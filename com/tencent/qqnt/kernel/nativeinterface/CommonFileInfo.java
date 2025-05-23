package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CommonFileInfo {
    public Integer bizType;
    public int chatType;
    public long elemId;
    public String favId;
    public long fileModelId;
    public String fileName;
    public long fileSize;
    public String md5;
    public String md510m;
    public long msgId;
    public long msgTime;
    public String parent;
    public String peerUid;
    public HashMap<Integer, String> picThumbPath;
    public String sha;
    public String sha3;
    public String subId;
    public String uuid;

    public CommonFileInfo() {
        this.uuid = "";
        this.subId = "";
        this.fileName = "";
        this.peerUid = "";
        this.md5 = "";
        this.md510m = "";
        this.sha = "";
        this.sha3 = "";
    }

    public Integer getBizType() {
        return this.bizType;
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getElemId() {
        return this.elemId;
    }

    public String getFavId() {
        return this.favId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMd510m() {
        return this.md510m;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String getParent() {
        return this.parent;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public HashMap<Integer, String> getPicThumbPath() {
        return this.picThumbPath;
    }

    public String getSha() {
        return this.sha;
    }

    public String getSha3() {
        return this.sha3;
    }

    public String getSubId() {
        return this.subId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public CommonFileInfo(long j3, long j16, long j17, String str, String str2, String str3, long j18, long j19, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, Integer num, HashMap<Integer, String> hashMap) {
        this.fileModelId = j3;
        this.msgId = j16;
        this.elemId = j17;
        this.uuid = str;
        this.subId = str2;
        this.fileName = str3;
        this.fileSize = j18;
        this.msgTime = j19;
        this.peerUid = str4;
        this.chatType = i3;
        this.md5 = str5;
        this.md510m = str6;
        this.sha = str7;
        this.sha3 = str8;
        this.parent = str9;
        this.favId = str10;
        this.bizType = num;
        this.picThumbPath = hashMap;
    }
}
