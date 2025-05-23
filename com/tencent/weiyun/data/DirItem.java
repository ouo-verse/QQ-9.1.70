package com.tencent.weiyun.data;

import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DirItem extends CNativeObject {
    static IPatchRedirector $redirector_;
    public FileItem coverFile;
    public long createTime;
    private String dirKey;
    public String dirName;
    public String iconUrl;
    public boolean isBackupDir;
    public long modifyTime;
    public String ownerNickname;
    public long ownerUin;
    private String pDirKey;
    public String pDirName;

    DirItem() {
        super(0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.isBackupDir = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static DirItem createDir(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            DirItem dirItem = new DirItem();
            dirItem.dirKey = str;
            dirItem.dirName = str2;
            dirItem.pDirKey = str3;
            return dirItem;
        }
        throw new IllegalArgumentException("createDir: the params dirKey, dirName and pDirKey should be valid.");
    }

    public static DirItem newInstance(long j3) {
        if (j3 == 0) {
            return null;
        }
        DirItem dirItem = new DirItem(j3);
        dirItem.dirKey = CBundleReader.getHexString(j3, "dir_key");
        dirItem.dirName = CBundleReader.getString(j3, "dir_name");
        dirItem.pDirKey = CBundleReader.getHexString(j3, "p_dir_key");
        dirItem.pDirName = CBundleReader.getString(j3, JobDbManager.COL_UP_P_DIR_NAME);
        dirItem.createTime = CBundleReader.getLong(j3, AlbumCacheData.CREATE_TIME, 0L);
        dirItem.modifyTime = CBundleReader.getLong(j3, "modify_time", 0L);
        dirItem.iconUrl = CBundleReader.getString(j3, "icon_url");
        long j16 = CBundleReader.getLong(j3, "cover_file", 0L);
        if (j16 != 0) {
            dirItem.coverFile = FileItem.newInstance(j16);
        }
        dirItem.isBackupDir = CBundleReader.getBoolean(j3, "is_backup_dir", false);
        dirItem.ownerUin = CBundleReader.getLong(j3, PhotoCacheData.OWNER_UIN, 0L);
        dirItem.ownerNickname = CBundleReader.getString(j3, "owner_nickname");
        dirItem.releaseNative();
        return dirItem;
    }

    public String dirKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.dirKey;
    }

    public String pDirKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.pDirKey;
    }

    @Override // com.tencent.weiyun.data.CNativeObject
    public void releaseNative() {
        FileItem fileItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (isNative() && (fileItem = this.coverFile) != null) {
            fileItem.releaseNative();
        }
        super.releaseNative();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DirItem m288clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DirItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return (DirItem) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    DirItem(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.isBackupDir = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
    }
}
