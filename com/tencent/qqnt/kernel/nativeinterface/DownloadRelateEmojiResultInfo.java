package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DownloadRelateEmojiResultInfo {
    public int clickNum;
    public String eId;
    public int eIdHeight;
    public int eIdIsAPNG;
    public String eIdName;
    public int eIdWeight;
    public int emojiId;
    public String encryptKey;
    public int epId;
    public int exposeNum;
    public boolean isMarkFace;
    public String md5;

    /* renamed from: msg, reason: collision with root package name */
    public String f359167msg;
    public String path;
    public RecommentEmojiType recommentEmojiType;
    public String resId;
    public int result;
    public String uin;
    public String url;
    public String word;

    public DownloadRelateEmojiResultInfo() {
        this.f359167msg = "";
        this.path = "";
        this.recommentEmojiType = RecommentEmojiType.values()[0];
        this.resId = "";
        this.uin = "";
        this.url = "";
        this.eId = "";
        this.eIdName = "";
        this.encryptKey = "";
        this.md5 = "";
        this.word = "";
    }

    public int getClickNum() {
        return this.clickNum;
    }

    public String getEId() {
        return this.eId;
    }

    public int getEIdHeight() {
        return this.eIdHeight;
    }

    public int getEIdIsAPNG() {
        return this.eIdIsAPNG;
    }

    public String getEIdName() {
        return this.eIdName;
    }

    public int getEIdWeight() {
        return this.eIdWeight;
    }

    public int getEmojiId() {
        return this.emojiId;
    }

    public String getEncryptKey() {
        return this.encryptKey;
    }

    public int getEpId() {
        return this.epId;
    }

    public int getExposeNum() {
        return this.exposeNum;
    }

    public boolean getIsMarkFace() {
        return this.isMarkFace;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMsg() {
        return this.f359167msg;
    }

    public String getPath() {
        return this.path;
    }

    public RecommentEmojiType getRecommentEmojiType() {
        return this.recommentEmojiType;
    }

    public String getResId() {
        return this.resId;
    }

    public int getResult() {
        return this.result;
    }

    public String getUin() {
        return this.uin;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "DownloadRelateEmojiResultInfo{result=" + this.result + ",msg=" + this.f359167msg + ",path=" + this.path + ",recommentEmojiType=" + this.recommentEmojiType + ",emojiId=" + this.emojiId + ",resId=" + this.resId + ",uin=" + this.uin + JefsClass.INDEX_URL + this.url + ",isMarkFace=" + this.isMarkFace + ",exposeNum=" + this.exposeNum + ",clickNum=" + this.clickNum + ",epId=" + this.epId + ",eId=" + this.eId + ",eIdName=" + this.eIdName + ",encryptKey=" + this.encryptKey + ",eIdWeight=" + this.eIdWeight + ",eIdHeight=" + this.eIdHeight + ",eIdIsAPNG=" + this.eIdIsAPNG + ",md5=" + this.md5 + ",word=" + this.word + ",}";
    }

    public DownloadRelateEmojiResultInfo(int i3, String str, String str2, RecommentEmojiType recommentEmojiType, int i16, String str3, String str4, String str5, boolean z16, int i17, int i18, int i19, String str6, String str7, String str8, int i26, int i27, int i28, String str9, String str10) {
        this.f359167msg = "";
        this.path = "";
        RecommentEmojiType recommentEmojiType2 = RecommentEmojiType.values()[0];
        this.result = i3;
        this.f359167msg = str;
        this.path = str2;
        this.recommentEmojiType = recommentEmojiType;
        this.emojiId = i16;
        this.resId = str3;
        this.uin = str4;
        this.url = str5;
        this.isMarkFace = z16;
        this.exposeNum = i17;
        this.clickNum = i18;
        this.epId = i19;
        this.eId = str6;
        this.eIdName = str7;
        this.encryptKey = str8;
        this.eIdWeight = i26;
        this.eIdHeight = i27;
        this.eIdIsAPNG = i28;
        this.md5 = str9;
        this.word = str10;
    }
}
