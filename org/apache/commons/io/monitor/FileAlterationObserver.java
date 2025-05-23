package org.apache.commons.io.monitor;

import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.NameFileComparator;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileAlterationObserver implements Serializable {
    private static final long serialVersionUID = 1185122225658782848L;
    private final Comparator<File> comparator;
    private final FileFilter fileFilter;
    private final List<FileAlterationListener> listeners;
    private final FileEntry rootEntry;

    public FileAlterationObserver(String str) {
        this(new File(str));
    }

    private FileEntry createFileEntry(FileEntry fileEntry, File file) {
        FileEntry newChildInstance = fileEntry.newChildInstance(file);
        newChildInstance.refresh(file);
        newChildInstance.setChildren(doListFiles(file, newChildInstance));
        return newChildInstance;
    }

    private void doCreate(FileEntry fileEntry) {
        for (FileAlterationListener fileAlterationListener : this.listeners) {
            if (fileEntry.isDirectory()) {
                fileAlterationListener.onDirectoryCreate(fileEntry.getFile());
            } else {
                fileAlterationListener.onFileCreate(fileEntry.getFile());
            }
        }
        for (FileEntry fileEntry2 : fileEntry.getChildren()) {
            doCreate(fileEntry2);
        }
    }

    private void doDelete(FileEntry fileEntry) {
        for (FileAlterationListener fileAlterationListener : this.listeners) {
            if (fileEntry.isDirectory()) {
                fileAlterationListener.onDirectoryDelete(fileEntry.getFile());
            } else {
                fileAlterationListener.onFileDelete(fileEntry.getFile());
            }
        }
    }

    private FileEntry[] doListFiles(File file, FileEntry fileEntry) {
        FileEntry[] fileEntryArr;
        File[] listFiles = listFiles(file);
        if (listFiles.length > 0) {
            fileEntryArr = new FileEntry[listFiles.length];
        } else {
            fileEntryArr = FileEntry.EMPTY_ENTRIES;
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            fileEntryArr[i3] = createFileEntry(fileEntry, listFiles[i3]);
        }
        return fileEntryArr;
    }

    private void doMatch(FileEntry fileEntry, File file) {
        if (fileEntry.refresh(file)) {
            for (FileAlterationListener fileAlterationListener : this.listeners) {
                if (fileEntry.isDirectory()) {
                    fileAlterationListener.onDirectoryChange(file);
                } else {
                    fileAlterationListener.onFileChange(file);
                }
            }
        }
    }

    private File[] listFiles(File file) {
        File[] fileArr;
        if (file.isDirectory()) {
            FileFilter fileFilter = this.fileFilter;
            if (fileFilter == null) {
                fileArr = file.listFiles();
            } else {
                fileArr = file.listFiles(fileFilter);
            }
        } else {
            fileArr = null;
        }
        if (fileArr == null) {
            fileArr = FileUtils.EMPTY_FILE_ARRAY;
        }
        Comparator<File> comparator = this.comparator;
        if (comparator != null && fileArr.length > 1) {
            Arrays.sort(fileArr, comparator);
        }
        return fileArr;
    }

    public void addListener(FileAlterationListener fileAlterationListener) {
        if (fileAlterationListener != null) {
            this.listeners.add(fileAlterationListener);
        }
    }

    public void checkAndNotify() {
        Iterator<FileAlterationListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onStart(this);
        }
        File file = this.rootEntry.getFile();
        if (file.exists()) {
            FileEntry fileEntry = this.rootEntry;
            checkAndNotify(fileEntry, fileEntry.getChildren(), listFiles(file));
        } else if (this.rootEntry.isExists()) {
            FileEntry fileEntry2 = this.rootEntry;
            checkAndNotify(fileEntry2, fileEntry2.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
        }
        Iterator<FileAlterationListener> it5 = this.listeners.iterator();
        while (it5.hasNext()) {
            it5.next().onStop(this);
        }
    }

    public File getDirectory() {
        return this.rootEntry.getFile();
    }

    public FileFilter getFileFilter() {
        return this.fileFilter;
    }

    public Iterable<FileAlterationListener> getListeners() {
        return this.listeners;
    }

    public void initialize() throws Exception {
        FileEntry fileEntry = this.rootEntry;
        fileEntry.refresh(fileEntry.getFile());
        this.rootEntry.setChildren(doListFiles(this.rootEntry.getFile(), this.rootEntry));
    }

    public void removeListener(FileAlterationListener fileAlterationListener) {
        if (fileAlterationListener == null) {
            return;
        }
        do {
        } while (this.listeners.remove(fileAlterationListener));
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getSimpleName());
        sb5.append("[file='");
        sb5.append(getDirectory().getPath());
        sb5.append('\'');
        if (this.fileFilter != null) {
            sb5.append(", ");
            sb5.append(this.fileFilter.toString());
        }
        sb5.append(", listeners=");
        sb5.append(this.listeners.size());
        sb5.append("]");
        return sb5.toString();
    }

    public FileAlterationObserver(String str, FileFilter fileFilter) {
        this(new File(str), fileFilter);
    }

    public FileAlterationObserver(String str, FileFilter fileFilter, IOCase iOCase) {
        this(new File(str), fileFilter, iOCase);
    }

    public FileAlterationObserver(File file) {
        this(file, (FileFilter) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter) {
        this(file, fileFilter, (IOCase) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter, IOCase iOCase) {
        this(new FileEntry(file), fileFilter, iOCase);
    }

    protected FileAlterationObserver(FileEntry fileEntry, FileFilter fileFilter, IOCase iOCase) {
        this.listeners = new CopyOnWriteArrayList();
        if (fileEntry != null) {
            if (fileEntry.getFile() != null) {
                this.rootEntry = fileEntry;
                this.fileFilter = fileFilter;
                if (iOCase != null && !iOCase.equals(IOCase.SYSTEM)) {
                    if (iOCase.equals(IOCase.INSENSITIVE)) {
                        this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
                        return;
                    } else {
                        this.comparator = NameFileComparator.NAME_COMPARATOR;
                        return;
                    }
                }
                this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
                return;
            }
            throw new IllegalArgumentException("Root directory is missing");
        }
        throw new IllegalArgumentException("Root entry is missing");
    }

    private void checkAndNotify(FileEntry fileEntry, FileEntry[] fileEntryArr, File[] fileArr) {
        FileEntry[] fileEntryArr2 = fileArr.length > 0 ? new FileEntry[fileArr.length] : FileEntry.EMPTY_ENTRIES;
        int i3 = 0;
        for (FileEntry fileEntry2 : fileEntryArr) {
            while (i3 < fileArr.length && this.comparator.compare(fileEntry2.getFile(), fileArr[i3]) > 0) {
                FileEntry createFileEntry = createFileEntry(fileEntry, fileArr[i3]);
                fileEntryArr2[i3] = createFileEntry;
                doCreate(createFileEntry);
                i3++;
            }
            if (i3 < fileArr.length && this.comparator.compare(fileEntry2.getFile(), fileArr[i3]) == 0) {
                doMatch(fileEntry2, fileArr[i3]);
                checkAndNotify(fileEntry2, fileEntry2.getChildren(), listFiles(fileArr[i3]));
                fileEntryArr2[i3] = fileEntry2;
                i3++;
            } else {
                checkAndNotify(fileEntry2, fileEntry2.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
                doDelete(fileEntry2);
            }
        }
        while (i3 < fileArr.length) {
            FileEntry createFileEntry2 = createFileEntry(fileEntry, fileArr[i3]);
            fileEntryArr2[i3] = createFileEntry2;
            doCreate(createFileEntry2);
            i3++;
        }
        fileEntry.setChildren(fileEntryArr2);
    }

    public void destroy() throws Exception {
    }
}
