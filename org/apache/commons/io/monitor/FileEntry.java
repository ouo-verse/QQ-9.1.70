package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileEntry implements Serializable {
    static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
    private static final long serialVersionUID = -2505664948818681153L;
    private FileEntry[] children;
    private boolean directory;
    private boolean exists;
    private final File file;
    private long lastModified;
    private long length;
    private String name;
    private final FileEntry parent;

    public FileEntry(File file) {
        this(null, file);
    }

    public FileEntry[] getChildren() {
        FileEntry[] fileEntryArr = this.children;
        if (fileEntryArr == null) {
            return EMPTY_ENTRIES;
        }
        return fileEntryArr;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry fileEntry = this.parent;
        if (fileEntry == null) {
            return 0;
        }
        return fileEntry.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File file) {
        return new FileEntry(this, file);
    }

    public boolean refresh(File file) {
        boolean z16;
        long j3;
        boolean z17 = this.exists;
        long j16 = this.lastModified;
        boolean z18 = this.directory;
        long j17 = this.length;
        this.name = file.getName();
        boolean exists = file.exists();
        this.exists = exists;
        if (exists && file.isDirectory()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.directory = z16;
        long j18 = 0;
        if (this.exists) {
            j3 = file.lastModified();
        } else {
            j3 = 0;
        }
        this.lastModified = j3;
        if (this.exists && !this.directory) {
            j18 = file.length();
        }
        this.length = j18;
        if (this.exists != z17 || this.lastModified != j16 || this.directory != z18 || j18 != j17) {
            return true;
        }
        return false;
    }

    public void setChildren(FileEntry[] fileEntryArr) {
        this.children = fileEntryArr;
    }

    public void setDirectory(boolean z16) {
        this.directory = z16;
    }

    public void setExists(boolean z16) {
        this.exists = z16;
    }

    public void setLastModified(long j3) {
        this.lastModified = j3;
    }

    public void setLength(long j3) {
        this.length = j3;
    }

    public void setName(String str) {
        this.name = str;
    }

    public FileEntry(FileEntry fileEntry, File file) {
        if (file != null) {
            this.file = file;
            this.parent = fileEntry;
            this.name = file.getName();
            return;
        }
        throw new IllegalArgumentException("File is missing");
    }
}
