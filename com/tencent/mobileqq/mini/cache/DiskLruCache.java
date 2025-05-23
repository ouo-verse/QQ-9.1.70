package com.tencent.mobileqq.mini.cache;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final File directory;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    static final String STRING_KEY_PATTERN = "[A-Za-z0-9_-]{1,120}";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile(STRING_KEY_PATTERN);
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.tencent.mobileqq.mini.cache.DiskLruCache.2
        @Override // java.io.OutputStream
        public void write(int i3) throws IOException {
        }
    };
    private long size = 0;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    final ThreadPoolExecutor executorService = new BaseThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> cleanupCallable = new Callable<Void>() { // from class: com.tencent.mobileqq.mini.cache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter == null) {
                    return null;
                }
                DiskLruCache.this.trimToSize();
                if (DiskLruCache.this.journalRebuildRequired()) {
                    DiskLruCache.this.rebuildJournal();
                    DiskLruCache.this.redundantOpCount = 0;
                }
                return null;
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        private final boolean[] written;

        Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if (this.committed) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.completeEdit(this, true);
            }
            this.committed = true;
        }

        public String getString(int i3) throws IOException {
            InputStream newInputStream = newInputStream(i3);
            if (newInputStream != null) {
                return DiskLruCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        public InputStream newInputStream(int i3) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor == this) {
                    if (!this.entry.readable) {
                        return null;
                    }
                    try {
                        return new FileInputStream(this.entry.getCleanFile(i3));
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
                throw new IllegalStateException();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public class FaultHidingOutputStream extends FilterOutputStream {
            FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i3) {
                try {
                    ((FilterOutputStream) this).out.write(i3);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i3, int i16) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i3, i16);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }
        }

        public void set(int i3, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(newOutputStream(i3), Util.UTF_8);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                outputStreamWriter.write(str);
                Util.closeQuietly(outputStreamWriter);
            } catch (Throwable th6) {
                th = th6;
                outputStreamWriter2 = outputStreamWriter;
                Util.closeQuietly(outputStreamWriter2);
                throw th;
            }
        }

        public OutputStream newOutputStream(int i3) throws IOException {
            FileOutputStream fileOutputStream;
            FaultHidingOutputStream faultHidingOutputStream;
            if (i3 >= 0 && i3 < DiskLruCache.this.valueCount) {
                synchronized (DiskLruCache.this) {
                    if (this.entry.currentEditor == this) {
                        if (!this.entry.readable) {
                            this.written[i3] = true;
                        }
                        File dirtyFile = this.entry.getDirtyFile(i3);
                        try {
                            fileOutputStream = new FileOutputStream(dirtyFile);
                        } catch (FileNotFoundException unused) {
                            DiskLruCache.this.directory.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(dirtyFile);
                            } catch (FileNotFoundException unused2) {
                                return DiskLruCache.NULL_OUTPUT_STREAM;
                            }
                        }
                        faultHidingOutputStream = new FaultHidingOutputStream(fileOutputStream);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return faultHidingOutputStream;
            }
            throw new IllegalArgumentException("Expected index " + i3 + " to be greater than 0 and less than the maximum value count of " + DiskLruCache.this.valueCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public final class Entry {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.valueCount) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    try {
                        this.lengths[i3] = Long.parseLong(strArr[i3]);
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
                return;
            }
            throw invalidLengths(strArr);
        }

        public File getCleanFile(int i3) {
            return new File(DiskLruCache.this.directory, this.key + "." + i3);
        }

        public File getDirtyFile(int i3) {
            return new File(DiskLruCache.this.directory, this.key + "." + i3 + ".tmp");
        }

        public String getLengths() throws IOException {
            StringBuilder sb5 = new StringBuilder();
            for (long j3 : this.lengths) {
                sb5.append(TokenParser.SP);
                sb5.append(j3);
            }
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public final class Snapshot implements Closeable {
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        Snapshot(String str, long j3, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j3;
            this.ins = inputStreamArr;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.ins) {
                Util.closeQuietly(inputStream);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public InputStream getInputStream(int i3) {
            return this.ins[i3];
        }

        public long getLength(int i3) {
            return this.lengths[i3];
        }

        public String getString(int i3) throws IOException {
            return DiskLruCache.inputStreamToString(getInputStream(i3));
        }
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(Editor editor, boolean z16) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor == editor) {
            if (z16 && !entry.readable) {
                for (int i3 = 0; i3 < this.valueCount; i3++) {
                    if (editor.written[i3]) {
                        if (!entry.getDirtyFile(i3).exists()) {
                            editor.abort();
                            return;
                        }
                    } else {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                    }
                }
            }
            for (int i16 = 0; i16 < this.valueCount; i16++) {
                File dirtyFile = entry.getDirtyFile(i16);
                if (z16) {
                    if (dirtyFile.exists()) {
                        File cleanFile = entry.getCleanFile(i16);
                        dirtyFile.renameTo(cleanFile);
                        long j3 = entry.lengths[i16];
                        long length = cleanFile.length();
                        entry.lengths[i16] = length;
                        this.size = (this.size - j3) + length;
                    }
                } else {
                    deleteIfExists(dirtyFile);
                }
            }
            this.redundantOpCount++;
            entry.currentEditor = null;
            if (entry.readable | z16) {
                entry.readable = true;
                this.journalWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                if (z16) {
                    long j16 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j16;
                    entry.sequenceNumber = j16;
                }
            } else {
                this.lruEntries.remove(entry.key);
                this.journalWriter.write("REMOVE " + entry.key + '\n');
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        int i3 = this.redundantOpCount;
        return i3 >= 2000 && i3 >= this.lruEntries.size();
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i3 = 0;
            if (next.currentEditor != null) {
                next.currentEditor = null;
                while (i3 < this.valueCount) {
                    deleteIfExists(next.getCleanFile(i3));
                    deleteIfExists(next.getDirtyFile(i3));
                    i3++;
                }
                it.remove();
            } else {
                while (i3 < this.valueCount) {
                    this.size += next.lengths[i3];
                    i3++;
                }
            }
        }
    }

    private void readJournal() throws IOException {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            String readLine = strictLineReader.readLine();
            String readLine2 = strictLineReader.readLine();
            String readLine3 = strictLineReader.readLine();
            String readLine4 = strictLineReader.readLine();
            String readLine5 = strictLineReader.readLine();
            if (!MAGIC.equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.appVersion).equals(readLine3) || !Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i3 = 0;
            while (true) {
                try {
                    readJournalLine(strictLineReader.readLine());
                    i3++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i3 - this.lruEntries.size();
                    if (strictLineReader.hasUnterminatedLine()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
                    }
                    Util.closeQuietly(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th5) {
            Util.closeQuietly(strictLineReader);
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        Writer writer = this.journalWriter;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + entry.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } catch (Throwable th5) {
            bufferedWriter.close();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() throws IOException {
        long j3 = this.size;
        long j16 = this.maxSize;
        if (j3 > j16) {
            long j17 = j16 / 2;
            while (this.size > j17) {
                remove(this.lruEntries.entrySet().iterator().next().getKey());
            }
        }
    }

    private void validateKey(String str) {
        LEGAL_KEY_PATTERN.matcher(str).matches();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.journalWriter == null) {
            return;
        }
        Iterator it = new ArrayList(this.lruEntries.values()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.currentEditor != null) {
                entry.currentEditor.abort();
            }
        }
        trimToSize();
        this.journalWriter.close();
        this.journalWriter = null;
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
        this.size = 0L;
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    public synchronized Snapshot get(String str) throws IOException {
        InputStream inputStream;
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.valueCount];
        for (int i3 = 0; i3 < this.valueCount; i3++) {
            try {
                inputStreamArr[i3] = new FileInputStream(entry.getCleanFile(i3));
            } catch (FileNotFoundException unused) {
                for (int i16 = 0; i16 < this.valueCount && (inputStream = inputStreamArr[i16]) != null; i16++) {
                    Util.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append((CharSequence) ("READ " + str + '\n'));
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Snapshot(str, entry.sequenceNumber, inputStreamArr, entry.lengths);
    }

    public File getDirectory() {
        return this.directory;
    }

    public Set<String> getKeys() {
        LinkedHashMap<String, Entry> linkedHashMap = this.lruEntries;
        if (linkedHashMap == null) {
            return null;
        }
        return linkedHashMap.keySet();
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    public synchronized boolean remove(String str) throws IOException {
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.currentEditor == null) {
            for (int i3 = 0; i3 < this.valueCount; i3++) {
                File cleanFile = entry.getCleanFile(i3);
                if (cleanFile.exists() && !cleanFile.delete()) {
                    throw new IOException("failed to delete " + cleanFile);
                }
                this.size -= entry.lengths[i3];
                entry.lengths[i3] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.append((CharSequence) ("REMOVE " + str + '\n'));
            this.lruEntries.remove(str);
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            return true;
        }
        return false;
    }

    public synchronized void setMaxSize(long j3) {
        this.maxSize = j3;
        this.executorService.submit(this.cleanupCallable);
    }

    public synchronized long size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Editor edit(String str, long j3) throws IOException {
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j3 != -1 && (entry == null || entry.sequenceNumber != j3)) {
            return null;
        }
        if (entry != null) {
            if (entry.currentEditor != null) {
                return null;
            }
        } else {
            entry = new Entry(str);
            this.lruEntries.put(str, entry);
        }
        Editor editor = new Editor(entry);
        entry.currentEditor = editor;
        this.journalWriter.write("DIRTY " + str + '\n');
        this.journalWriter.flush();
        return editor;
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i3 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i3);
            if (indexOf2 == -1) {
                substring = str.substring(i3);
                if (indexOf == 6 && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i3, indexOf2);
            }
            Entry entry = this.lruEntries.get(substring);
            if (entry == null) {
                entry = new Entry(substring);
                this.lruEntries.put(substring, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                entry.currentEditor = new Editor(entry);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith(READ)) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private static void renameTo(File file, File file2, boolean z16) throws IOException {
        if (z16) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    DiskLruCache(File file, int i3, int i16, long j3) {
        this.directory = file;
        this.appVersion = i3;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i16;
        this.maxSize = j3;
    }

    public static DiskLruCache open(File file, int i3, int i16, long j3) throws IOException {
        if (j3 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i16 > 0) {
            File file2 = new File(file, JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i3, i16, j3);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    return diskLruCache;
                } catch (IOException e16) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e16.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i3, i16, j3);
            diskLruCache2.rebuildJournal();
            return diskLruCache2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }
}
