package com.tencent.mm.plugin.appbrand.appstorage;

/* compiled from: P */
/* loaded from: classes9.dex */
public class FileStructStat {
    public long st_atime;
    public long st_ctime;
    public int st_mode;
    public long st_mtime;
    public long st_size;

    public void fillAnother(FileStructStat fileStructStat) {
        if (fileStructStat == null) {
            return;
        }
        fileStructStat.st_mode = this.st_mode;
        fileStructStat.st_size = this.st_size;
        fileStructStat.st_atime = this.st_atime;
        fileStructStat.st_mtime = this.st_mtime;
        fileStructStat.st_ctime = this.st_ctime;
    }

    public boolean isDirectory() {
        if ((this.st_mode & 16384) == 16384) {
            return true;
        }
        return false;
    }

    public boolean isSymLink() {
        if ((this.st_mode & 61440) == 40960) {
            return true;
        }
        return false;
    }

    public void makeItIsDir() {
        this.st_mode |= 16384;
    }
}
