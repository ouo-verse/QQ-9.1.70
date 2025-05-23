package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopFileTansferItemEntity extends Entity {
    public int BusId;
    public int ErrorCode;
    public String FileName;
    public String FilePath;
    public int ForwardBusId;
    public String ForwardPath;
    public boolean HasThumbnailFile_Large;
    public boolean HasThumbnailFile_Middle;
    public boolean HasThumbnailFile_Small;
    public UUID Id;
    public String LocalFile;
    public byte[] Md5;
    public String NameForSave;
    public String NickName;
    public String PreviewUrl;
    public long ProgressTotal;
    public long ProgressValue;
    public byte[] Sha;
    public String Sha3;
    public int Status;
    public long ThumbnailFileTimeMS_Large;
    public long ThumbnailFileTimeMS_Middle;
    public long ThumbnailFileTimeMS_Small;
    public int UploadTime;
    public String _sId;
    public String _sStatus;
    public String apkSafeDetailUrl;
    public String apkSafeMsg;
    public int duration;
    public long entrySessionID;
    public int fromScene;
    public int height;
    public boolean isFromAIO;
    public boolean isZipInnerFile;
    public String largeThumbnailFile;
    public String mParentId;
    public String middleThumbnailFile;
    public long origLastModifyTime;
    public String smallThumbFile;
    public String strQRUrl;
    public int width;
    public String yybApkIconUrl;
    public String yybApkName;
    public String yybApkPackageName;
    public int zipBusId;
    public String zipFilePath;
    public String zipInnerPath;
    public int zipType;
    public long troopuin = 0;
    public int RandomNum = 0;
    public int SafeCheckRes = 0;
    public long ForwardTroopuin = 0;

    @notColumn
    public boolean isCheckPrivateDir = false;
    public int apkSafeLevel = 0;
    public long ntMsgId = 0;
    public long ntElementId = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public Class<? extends Entity> getClassForTable() {
        return TroopFileTansferItemEntity.class;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return "TroopFileTansferItemEntity" + this.troopuin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        this.Status = com.tencent.mobileqq.troop.data.a.d(this._sStatus);
        this._sStatus = null;
        this.Id = UUID.fromString(this._sId);
        this._sId = null;
    }

    public void preupdate() {
        prewrite();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        this._sStatus = com.tencent.mobileqq.troop.data.a.c(this.Status);
        this._sId = this.Id.toString();
    }
}
