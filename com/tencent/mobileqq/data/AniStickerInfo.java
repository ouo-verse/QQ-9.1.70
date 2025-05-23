package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AniStickerInfo {
    public String aniStickerHeight;
    public String aniStickerId;
    public String aniStickerPackId;
    public int aniStickerType;
    public String aniStickerWidth;
    public int localId;
    public String randomKey;
    public String resultId;
    public int sevrId;
    public String surpriseId;
    public String text;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Builder {
        AniStickerInfo info = new AniStickerInfo();

        public AniStickerInfo build() {
            return this.info;
        }

        public Builder fromEmoItem(QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem) {
            this.info.convert(qQEmoConfigItem);
            return this;
        }

        public Builder setBasicInfo(int i3, int i16, int i17, String str, String str2, String str3) {
            AniStickerInfo aniStickerInfo = this.info;
            aniStickerInfo.aniStickerType = i3;
            aniStickerInfo.text = str;
            aniStickerInfo.localId = i16;
            aniStickerInfo.sevrId = i17;
            aniStickerInfo.aniStickerPackId = str2;
            aniStickerInfo.aniStickerId = str3;
            return this;
        }

        public Builder setResultId(String str) {
            this.info.resultId = str;
            return this;
        }

        public Builder setSurpriseId(String str) {
            this.info.surpriseId = str;
            return this;
        }
    }

    public void convert(QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem) {
        this.aniStickerType = qQEmoConfigItem.AniStickerType;
        this.aniStickerPackId = qQEmoConfigItem.AniStickerPackId;
        this.aniStickerId = qQEmoConfigItem.AniStickerId;
        this.aniStickerWidth = qQEmoConfigItem.AniStickerWidth;
        this.aniStickerHeight = qQEmoConfigItem.AniStickerHeight;
        String str = qQEmoConfigItem.QSid;
        if (str != null) {
            int parseInt = Integer.parseInt(str);
            this.sevrId = parseInt;
            this.localId = QQSysFaceUtil.convertToLocal(parseInt);
        }
        this.text = qQEmoConfigItem.QDes;
    }

    public String getCacheKey() {
        return this.localId + "_" + this.sevrId + "_" + this.resultId;
    }

    public String getFinishStateResFilePath() {
        if (!TextUtils.isEmpty(this.resultId)) {
            if (this.aniStickerType == 3 && "0".equals(this.resultId)) {
                return QQSysAndEmojiResMgr.getInstance().getAniStickerResPath(this.sevrId, this.aniStickerPackId, this.aniStickerId);
            }
            return QQSysAndEmojiResMgr.getInstance().getAniStickerRandomResultFullResPath(this.sevrId, this.aniStickerPackId, this.aniStickerId, this.resultId);
        }
        if (!TextUtils.isEmpty(this.surpriseId)) {
            return QQSysAndEmojiResMgr.getInstance().getAniStickerRandomResultFullResPath(this.sevrId, this.aniStickerPackId, this.aniStickerId, this.surpriseId);
        }
        return QQSysAndEmojiResMgr.getInstance().getAniStickerResPath(this.sevrId, this.aniStickerPackId, this.aniStickerId);
    }

    public String getResultId() {
        return this.resultId;
    }

    public String getSurpriseId() {
        return this.surpriseId;
    }

    public void setResultId(String str) {
        this.resultId = str;
    }

    public void setSurpriseId(String str) {
        this.surpriseId = str;
    }
}
