package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.filemanager.util.k;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTroopFile extends ChatMessage {
    public static final String TAG = "MessageForTroopFile";
    public String FromUin;
    public int bisID;
    public String dspFileName;
    public String dspFileSize;
    public int duration;
    public long entitySessionId;
    public String fileName;
    public long fileSize;
    public int height;
    public long lastTime;
    public String md5;
    public String sha1;
    public String url;
    public String uuid;
    public int width;
    public String yybApkIconUrl;
    public String yybApkName;
    public String yybApkPackageName;
    public boolean isPause = false;
    public boolean bReported = false;

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        TroopFileData troopFileData;
        try {
            troopFileData = (TroopFileData) MessagePkgUtils.getObjectFromBytes(this.msgData);
        } catch (Exception e16) {
            e16.printStackTrace();
            troopFileData = null;
        }
        if (troopFileData != null) {
            this.url = troopFileData.fileUrl;
            this.sha1 = troopFileData.sha1;
            this.md5 = troopFileData.md5;
            this.dspFileSize = troopFileData.dspFileSize;
            this.dspFileName = troopFileData.dspFileName;
            this.bisID = troopFileData.bisID;
            this.uuid = troopFileData.uuid;
            this.fileSize = troopFileData.lfileSize;
            this.fileName = troopFileData.fileName;
            this.FromUin = troopFileData.FromUin;
            this.lastTime = troopFileData.lastTime;
            this.entitySessionId = troopFileData.entitySessionId;
            this.width = troopFileData.width;
            this.height = troopFileData.height;
            this.duration = troopFileData.duration;
            this.yybApkPackageName = troopFileData.yybApkPackageName;
            this.yybApkName = troopFileData.yybApkName;
            this.yybApkIconUrl = troopFileData.yybApkIconUrl;
            int i3 = troopFileData.fromScene;
            if (i3 != 0) {
                k.c(this, i3);
            }
        }
        this.f203106msg = HardCodeUtil.qqStr(R.string.f172168o12);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return HardCodeUtil.qqStr(R.string.o2d) + this.fileName;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
    }

    public void serial() {
        TroopFileData troopFileData = new TroopFileData();
        troopFileData.fileUrl = this.url;
        troopFileData.sha1 = this.sha1;
        troopFileData.md5 = this.md5;
        troopFileData.fileName = this.fileName;
        troopFileData.dspFileName = this.dspFileName;
        troopFileData.dspFileSize = this.dspFileSize;
        troopFileData.bisID = this.bisID;
        troopFileData.uuid = this.uuid;
        troopFileData.lfileSize = this.fileSize;
        troopFileData.FromUin = this.FromUin;
        troopFileData.lastTime = this.lastTime;
        troopFileData.entitySessionId = this.entitySessionId;
        troopFileData.width = this.width;
        troopFileData.height = this.height;
        troopFileData.duration = this.duration;
        troopFileData.yybApkPackageName = this.yybApkPackageName;
        troopFileData.yybApkName = this.yybApkName;
        troopFileData.yybApkIconUrl = this.yybApkIconUrl;
        troopFileData.fromScene = k.f(this);
        try {
            this.msgData = MessagePkgUtils.getBytesFromObject(troopFileData);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
