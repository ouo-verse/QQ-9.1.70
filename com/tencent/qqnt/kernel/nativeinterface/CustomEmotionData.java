package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CustomEmotionData {
    public String RomaingType;
    public int clickNum;
    public String desc;
    public String eId;
    public int emoId;
    public String emoOriginalPath;
    public String emoPath;
    public String epId;
    public int exposeNum;
    public boolean isAPNG;
    public boolean isExist;
    public boolean isMarkFace;
    public String md5;
    public String modifyWord;
    public String ocrWord;
    public String resId;
    public String thumbPath;
    public String uin;
    public String url;

    public CustomEmotionData() {
        this.uin = "";
        this.emoPath = "";
        this.resId = "";
        this.url = "";
        this.md5 = "";
        this.emoOriginalPath = "";
        this.thumbPath = "";
        this.RomaingType = "";
        this.eId = "";
        this.epId = "";
        this.ocrWord = "";
        this.modifyWord = "";
        this.desc = "";
    }

    public int getClickNum() {
        return this.clickNum;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getEId() {
        return this.eId;
    }

    public int getEmoId() {
        return this.emoId;
    }

    public String getEmoOriginalPath() {
        return this.emoOriginalPath;
    }

    public String getEmoPath() {
        return this.emoPath;
    }

    public String getEpId() {
        return this.epId;
    }

    public int getExposeNum() {
        return this.exposeNum;
    }

    public boolean getIsAPNG() {
        return this.isAPNG;
    }

    public boolean getIsExist() {
        return this.isExist;
    }

    public boolean getIsMarkFace() {
        return this.isMarkFace;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getModifyWord() {
        return this.modifyWord;
    }

    public String getOcrWord() {
        return this.ocrWord;
    }

    public String getResId() {
        return this.resId;
    }

    public String getRomaingType() {
        return this.RomaingType;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public String getUin() {
        return this.uin;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "CustomEmotionData{uin=" + this.uin + ",emoId=" + this.emoId + ",emoPath=" + this.emoPath + ",isExist=" + this.isExist + ",resId=" + this.resId + JefsClass.INDEX_URL + this.url + ",md5=" + this.md5 + ",emoOriginalPath=" + this.emoOriginalPath + ",thumbPath=" + this.thumbPath + ",RomaingType=" + this.RomaingType + ",isAPNG=" + this.isAPNG + ",isMarkFace=" + this.isMarkFace + ",eId=" + this.eId + ",epId=" + this.epId + ",ocrWord=" + this.ocrWord + ",modifyWord=" + this.modifyWord + ",exposeNum=" + this.exposeNum + ",clickNum=" + this.clickNum + ",desc=" + this.desc + ",}";
    }

    public CustomEmotionData(String str, int i3, String str2, boolean z16, String str3, String str4, String str5, String str6, String str7, String str8, boolean z17, boolean z18, String str9, String str10, String str11, String str12, int i16, int i17, String str13) {
        this.uin = str;
        this.emoId = i3;
        this.emoPath = str2;
        this.isExist = z16;
        this.resId = str3;
        this.url = str4;
        this.md5 = str5;
        this.emoOriginalPath = str6;
        this.thumbPath = str7;
        this.RomaingType = str8;
        this.isAPNG = z17;
        this.isMarkFace = z18;
        this.eId = str9;
        this.epId = str10;
        this.ocrWord = str11;
        this.modifyWord = str12;
        this.exposeNum = i16;
        this.clickNum = i17;
        this.desc = str13;
    }
}
