package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CustomEmotionData extends CustomEmotionBase<CustomEmotionData> {
    public int clickNum;
    public String eId;
    public int exposeNum;
    public int jumpId;
    public String modifyWord;
    public String ocrWord;
    public boolean isMarkFace = false;
    public boolean isLottieEmoji = false;

    public boolean checkMarketFace(String str) {
        if (!this.isMarkFace || (!TextUtils.isEmpty(this.eId) && !TextUtils.isEmpty(this.emoPath))) {
            return true;
        }
        QLog.e("CustomEmotionData", 1, "error MarketFace from " + str + ", " + toString());
        return false;
    }

    public CustomEmotionData cloneEmotionData(CustomEmotionData customEmotionData) {
        CustomEmotionData customEmotionData2 = new CustomEmotionData();
        customEmotionData2.uin = customEmotionData.uin;
        customEmotionData2.emoId = customEmotionData.emoId;
        customEmotionData2.emoPath = customEmotionData.emoPath;
        customEmotionData2.resid = customEmotionData.resid;
        customEmotionData2.url = customEmotionData.url;
        customEmotionData2.md5 = customEmotionData.md5;
        customEmotionData2.emoOriginalPath = customEmotionData.emoOriginalPath;
        customEmotionData2.thumbPath = customEmotionData.thumbPath;
        customEmotionData2.RomaingType = customEmotionData.RomaingType;
        customEmotionData2.isAPNG = customEmotionData.isAPNG;
        customEmotionData2.isMarkFace = customEmotionData.isMarkFace;
        customEmotionData2.isLottieEmoji = customEmotionData.isLottieEmoji;
        customEmotionData2.eId = customEmotionData.eId;
        customEmotionData2.ocrWord = customEmotionData.ocrWord;
        customEmotionData2.modifyWord = customEmotionData.modifyWord;
        customEmotionData2.exposeNum = customEmotionData.exposeNum;
        customEmotionData2.clickNum = customEmotionData.clickNum;
        customEmotionData2.jumpId = customEmotionData.jumpId;
        return customEmotionData2;
    }

    public void increaseClickNum() {
        int i3 = this.clickNum;
        if (i3 == Integer.MAX_VALUE) {
            return;
        }
        this.clickNum = i3 + 1;
    }

    public void increaseExposeNum() {
        int i3 = this.exposeNum;
        if (i3 == Integer.MAX_VALUE) {
            return;
        }
        this.exposeNum = i3 + 1;
    }

    public String toString() {
        return "CustomEmotionData [uin=" + this.uin + ", emoId=" + this.emoId + ", emoPath=" + this.emoPath + ", isMarkFace=" + this.isMarkFace + ", RomaingType=" + this.RomaingType + ", eId=" + this.eId + ", resid=" + this.resid + ", url=" + this.url + ", md5=" + this.md5 + "]";
    }

    @Override // com.tencent.mobileqq.data.CustomEmotionBase
    public void replace(CustomEmotionData customEmotionData) {
        if (customEmotionData != null) {
            super.replace(customEmotionData);
            this.isMarkFace = customEmotionData.isMarkFace;
            this.isLottieEmoji = customEmotionData.isLottieEmoji;
            this.eId = customEmotionData.eId;
            this.ocrWord = customEmotionData.ocrWord;
            this.modifyWord = customEmotionData.modifyWord;
            this.exposeNum = customEmotionData.exposeNum;
            this.clickNum = customEmotionData.clickNum;
            this.jumpId = customEmotionData.jumpId;
            checkMarketFace(SQLiteDatabase.OPERATE_TYPE_REPLACE);
        }
    }
}
