package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EmojiNotifyInfo {
    public EmojiDownloadType downloadType;
    public String dynamicFacePath;
    public String emojiId;
    public String emojiPackageId;
    public int emojiType;
    public String errMsg;
    public HashMap<String, String> extraData;
    public String md5;
    public String path;
    public String resId;
    public int result;

    public EmojiNotifyInfo() {
        this.errMsg = "";
        this.md5 = "";
        this.resId = "";
        this.path = "";
        this.extraData = new HashMap<>();
        this.emojiId = "";
        this.emojiPackageId = "";
        this.downloadType = EmojiDownloadType.values()[0];
    }

    public EmojiDownloadType getDownloadType() {
        return this.downloadType;
    }

    public String getDynamicFacePath() {
        return this.dynamicFacePath;
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public String getEmojiPackageId() {
        return this.emojiPackageId;
    }

    public int getEmojiType() {
        return this.emojiType;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public HashMap<String, String> getExtraData() {
        return this.extraData;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPath() {
        return this.path;
    }

    public String getResId() {
        return this.resId;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "EmojiNotifyInfo{result=" + this.result + ",errMsg=" + this.errMsg + ",emojiType=" + this.emojiType + ",md5=" + this.md5 + ",resId=" + this.resId + ",path=" + this.path + ",extraData=" + this.extraData + ",emojiId=" + this.emojiId + ",emojiPackageId=" + this.emojiPackageId + ",downloadType=" + this.downloadType + ",dynamicFacePath=" + this.dynamicFacePath + ",}";
    }

    public EmojiNotifyInfo(int i3, String str, int i16, String str2, String str3, String str4, HashMap<String, String> hashMap, String str5, String str6, EmojiDownloadType emojiDownloadType, String str7) {
        this.errMsg = "";
        this.md5 = "";
        this.resId = "";
        this.path = "";
        this.extraData = new HashMap<>();
        this.emojiId = "";
        this.emojiPackageId = "";
        EmojiDownloadType emojiDownloadType2 = EmojiDownloadType.values()[0];
        this.result = i3;
        this.errMsg = str;
        this.emojiType = i16;
        this.md5 = str2;
        this.resId = str3;
        this.path = str4;
        this.extraData = hashMap;
        this.emojiId = str5;
        this.emojiPackageId = str6;
        this.downloadType = emojiDownloadType;
        this.dynamicFacePath = str7;
    }
}
