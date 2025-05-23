package com.tencent.commonsdk.soload;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.MyZipFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DexReleasor implements MyZipConstants {
    static IPatchRedirector $redirector_ = null;
    public static int APK_DEX_COUNT = 0;
    private static final String DEX_COUNT_KEY = "mobileqq.dex.count";
    private static final String DEX_NAME = "classes.dex";
    private static final int SIZE_80_K = 81920;
    private static final String TAG = "DexReleasor";
    private static DexReleasor dexOperator;
    public static String[] sExtraDexes;
    public static String[] sExtraJarDexes;
    byte[] buffer;
    byte[] commentOfEOCD;
    private String mDstPath;
    private final LinkedHashMap<String, MyZipEntry> mEntries;
    RandomAccessFile mRaf;
    private String mSrcFile;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47014);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            APK_DEX_COUNT = 11;
            dexOperator = null;
        }
    }

    public DexReleasor(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.mRaf = null;
        this.commentOfEOCD = null;
        this.mEntries = new LinkedHashMap<>();
        this.buffer = new byte[SIZE_80_K];
        this.mSrcFile = str;
        this.mDstPath = str2;
        try {
            read();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "constructing DexReleasor failed ", e16);
        }
    }

    private void checkSrcFile() throws IOException {
        File file = new File(this.mSrcFile);
        if (file.exists()) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            this.mRaf = randomAccessFile;
            long length = randomAccessFile.length() - 22;
            long j3 = 0;
            if (length >= 0) {
                long j16 = length - 65536;
                if (j16 >= 0) {
                    j3 = j16;
                }
                do {
                    this.mRaf.seek(length);
                    if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256) {
                        return;
                    } else {
                        length--;
                    }
                } while (length >= j3);
                throw new ZipException("EOCD not found; not a Zip archive?");
            }
            throw new ZipException("too short to be Zip");
        }
        throw new IOException("no exist " + this.mSrcFile);
    }

    private void close(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            outputStream.close();
        } catch (IOException e16) {
            QLog.e(TAG, 1, "closeOutputStream failed ", e16);
        }
    }

    private ByteArrayOutputStream getAndInitializeCenterDirectory(MyZipEntry myZipEntry, byte[] bArr, int i3) throws IOException {
        int i16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeLong(byteArrayOutputStream, MyZipConstants.CENSIG);
        writeShort(byteArrayOutputStream, myZipEntry.version);
        writeShort(byteArrayOutputStream, myZipEntry.versionMinimum);
        writeShort(byteArrayOutputStream, myZipEntry.flags);
        writeShort(byteArrayOutputStream, myZipEntry.compressionMethod);
        writeShort(byteArrayOutputStream, myZipEntry.time);
        writeShort(byteArrayOutputStream, myZipEntry.modDate);
        writeLong(byteArrayOutputStream, myZipEntry.crc);
        writeLong(byteArrayOutputStream, myZipEntry.compressedSize);
        writeLong(byteArrayOutputStream, myZipEntry.size);
        writeShort(byteArrayOutputStream, i3);
        writeShort(byteArrayOutputStream, myZipEntry.extraLength);
        writeShort(byteArrayOutputStream, myZipEntry.commentLength);
        writeShort(byteArrayOutputStream, myZipEntry.diskNumbers);
        writeShort(byteArrayOutputStream, myZipEntry.internalFileAttri);
        writeLong(byteArrayOutputStream, myZipEntry.externalFileAttri);
        writeLong(byteArrayOutputStream, 0L);
        byteArrayOutputStream.write(bArr);
        if (myZipEntry.extraLength > 0) {
            byteArrayOutputStream.write(myZipEntry.extra);
        }
        if (myZipEntry.commentLength > 0) {
            byteArrayOutputStream.write(myZipEntry.comment.getBytes());
        }
        if (myZipEntry.hasDD) {
            i16 = 16;
        } else {
            i16 = 0;
        }
        long j3 = i16 + 30 + i3 + myZipEntry.extraLength + myZipEntry.compressedSize;
        int size = byteArrayOutputStream.size();
        writeLong(byteArrayOutputStream, MyZipConstants.ENDSIG);
        writeShort(byteArrayOutputStream, 0);
        writeShort(byteArrayOutputStream, 0);
        writeShort(byteArrayOutputStream, 1);
        writeShort(byteArrayOutputStream, 1);
        writeLong(byteArrayOutputStream, size);
        writeLong(byteArrayOutputStream, j3);
        byte[] bArr2 = this.commentOfEOCD;
        if (bArr2 != null) {
            writeShort(byteArrayOutputStream, bArr2.length);
            byteArrayOutputStream.write(this.commentOfEOCD);
        } else {
            writeShort(byteArrayOutputStream, 0);
        }
        return byteArrayOutputStream;
    }

    private int getFoundDexCount(short s16, int i3) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new MyZipFile.RAFStream(this.mRaf, i3), 4096);
        byte[] bArr = new byte[46];
        int i16 = 0;
        for (int i17 = 0; i17 < s16 && i16 != APK_DEX_COUNT - 1; i17++) {
            MyZipEntry myZipEntry = new MyZipEntry(bArr, bufferedInputStream);
            String name = myZipEntry.getName();
            if (!TextUtils.isEmpty(name)) {
                for (String str : sExtraDexes) {
                    if (TextUtils.equals(name, str)) {
                        this.mEntries.put(name, myZipEntry);
                        i16++;
                    }
                }
            }
        }
        return i16;
    }

    public static synchronized DexReleasor getInstance(String str, String str2) {
        DexReleasor dexReleasor;
        synchronized (DexReleasor.class) {
            if (dexOperator == null) {
                dexOperator = new DexReleasor(str, str2);
            }
            dexReleasor = dexOperator;
        }
        return dexReleasor;
    }

    public static void initDexCount(Context context) {
        Bundle bundle;
        int i3;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (i3 = bundle.getInt(DEX_COUNT_KEY, -1)) > 0) {
                QLog.d(TAG, 1, "DexReleasor.read, meta-data dexCount = " + i3);
                APK_DEX_COUNT = i3;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "DexReleaser.read meta-data dexCount Error", th5);
        }
        int i16 = APK_DEX_COUNT;
        sExtraDexes = new String[i16 - 1];
        sExtraJarDexes = new String[i16 - 1];
        for (int i17 = 0; i17 < APK_DEX_COUNT - 1; i17++) {
            String[] strArr = sExtraDexes;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("classes");
            int i18 = i17 + 2;
            sb5.append(i18);
            sb5.append(QZonePatchService.PATCH_SUFFIX_DEX);
            strArr[i17] = sb5.toString();
            sExtraJarDexes[i17] = "classes" + i18 + QZonePatchService.PATCH_SUFFIX;
        }
    }

    private synchronized boolean read() throws IOException {
        checkSrcFile();
        byte[] bArr = new byte[18];
        this.mRaf.readFully(bArr);
        HeapBufferIterator it = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
        short readShort = it.readShort();
        short readShort2 = it.readShort();
        short readShort3 = it.readShort();
        short readShort4 = it.readShort();
        it.readInt();
        int readInt = it.readInt();
        updateComment(it.readShort());
        if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
            if (getFoundDexCount(readShort3, readInt) != APK_DEX_COUNT - 1) {
                return false;
            }
            return readLocalHeader(this.mRaf);
        }
        throw new ZipException("spanned archives not supported");
    }

    private synchronized boolean readLocalHeader(RandomAccessFile randomAccessFile) throws IOException {
        byte[] bArr = new byte[30];
        Iterator<String> it = this.mEntries.keySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                return true;
            }
            MyZipEntry myZipEntry = this.mEntries.get(it.next());
            int i3 = 0;
            Streams.readFully(new BufferedInputStream(new MyZipFile.RAFStream(randomAccessFile, myZipEntry.mLocalHeaderRelOffset), 4096), bArr, 0, 30);
            HeapBufferIterator it5 = HeapBufferIterator.iterator(bArr, 0, 30, ByteOrder.LITTLE_ENDIAN);
            if (it5.readInt() != MyZipConstants.LOCSIG) {
                return false;
            }
            it5.skip(2);
            if ((it5.readShort() & 8) == 0) {
                z16 = false;
            }
            it5.skip(18);
            short readShort = it5.readShort();
            short readShort2 = it5.readShort();
            myZipEntry.hasDD = z16;
            long j3 = readShort + 30 + readShort2 + myZipEntry.compressedSize;
            if (z16) {
                i3 = 16;
            }
            myZipEntry.mLocContentSize = j3 + i3;
        }
    }

    private void updateComment(int i3) throws IOException {
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            if (this.mRaf.read(bArr, 0, i3) != -1) {
                this.commentOfEOCD = bArr;
            }
        }
    }

    private boolean writeBaseInfoToJar(BufferedOutputStream bufferedOutputStream, MyZipEntry myZipEntry, byte[] bArr, int i3) throws IOException {
        int read;
        writeShort(bufferedOutputStream, i3);
        writeShort(bufferedOutputStream, myZipEntry.extraLength);
        bufferedOutputStream.write(bArr);
        this.mRaf.seek(myZipEntry.mLocalHeaderRelOffset + 30 + myZipEntry.nameLength);
        long j3 = (myZipEntry.mLocContentSize - 30) - myZipEntry.nameLength;
        long j16 = 0;
        while (81920 + j16 <= j3 && (read = this.mRaf.read(this.buffer)) != -1) {
            bufferedOutputStream.write(this.buffer);
            j16 += read;
        }
        int i16 = (int) (j3 - j16);
        int read2 = this.mRaf.read(this.buffer, 0, i16);
        if (read2 == -1 || read2 != i16) {
            return false;
        }
        bufferedOutputStream.write(this.buffer, 0, i16);
        return true;
    }

    private long writeLong(OutputStream outputStream, long j3) throws IOException {
        outputStream.write((int) (255 & j3));
        outputStream.write(((int) (j3 >> 8)) & 255);
        outputStream.write(((int) (j3 >> 16)) & 255);
        outputStream.write(((int) (j3 >> 24)) & 255);
        return j3;
    }

    private int writeShort(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(i3 & 255);
        outputStream.write((i3 >> 8) & 255);
        return i3;
    }

    private synchronized File writeToJar(String str, String str2) throws IOException {
        boolean z16;
        MyZipEntry myZipEntry = this.mEntries.get(str2);
        if (myZipEntry == null) {
            return null;
        }
        File file = new File(this.mDstPath + str);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        this.mRaf.seek(myZipEntry.mLocalHeaderRelOffset);
        try {
            int read = this.mRaf.read(this.buffer, 0, 26);
            if (read != -1 && read == 26) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return null;
            }
            try {
                try {
                    bufferedOutputStream.write(this.buffer, 0, 26);
                    byte[] bytes = "classes.dex".getBytes("UTF-8");
                    int length = bytes.length;
                    if (!writeBaseInfoToJar(bufferedOutputStream, myZipEntry, bytes, length)) {
                        return null;
                    }
                    getAndInitializeCenterDirectory(myZipEntry, bytes, length).writeTo(bufferedOutputStream);
                    return file;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "writeToJar failed", e16);
                    throw e16;
                }
            } finally {
                close(bufferedOutputStream);
                close(fileOutputStream);
            }
        } catch (Exception e17) {
            QLog.e(TAG, 1, "writeToJar failed", e17);
            throw e17;
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        RandomAccessFile randomAccessFile = this.mRaf;
        try {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "DexReleasor destroy failed", e16);
                }
            }
            this.buffer = null;
            dexOperator = null;
        } finally {
            this.mRaf = null;
        }
    }

    public long getEntryCrcCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).longValue();
        }
        MyZipEntry myZipEntry = this.mEntries.get(str);
        if (myZipEntry == null) {
            return -1L;
        }
        return myZipEntry.crc;
    }

    public synchronized File releaseDex(String str, String str2) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        try {
            try {
                file = writeToJar(str, str2);
                if (sExtraDexes[APK_DEX_COUNT - 2].equals(str2)) {
                    destroy();
                }
            } catch (IOException e16) {
                QLog.e(TAG, 1, "releaseDex failed ", e16);
                if (sExtraDexes[APK_DEX_COUNT - 2].equals(str2)) {
                    destroy();
                }
                file = null;
            }
            return file;
        } catch (Throwable th5) {
            if (sExtraDexes[APK_DEX_COUNT - 2].equals(str2)) {
                destroy();
            }
            throw th5;
        }
    }
}
