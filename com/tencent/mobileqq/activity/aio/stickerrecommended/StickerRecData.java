package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StickerRecData extends SimpleRemoteEmoticon {
    public static final int WEBURL_MAX_LENGTH = 100;
    private String algoInfo;
    private boolean clicked;
    private int epId;
    private boolean exposed;
    private String filePath;
    private String iconUrl;
    private long imgFileSize;
    private int imgHeight;
    private String imgMd5;
    private String imgUrl;
    private int imgWidth;
    private int index;
    private String keyWord;
    private int klType;
    private String packageName;
    private String recomTransfer;
    private String source;
    private long thumbFileSize;
    private int thumbHeight;
    private String thumbMd5;
    private String thumbUrl;
    private int thumbWidth;
    private String webUrl;
    private String zplanInfo;
    private int from = 0;
    int mRecType = 0;

    private int getZPlanPortraitId(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)) {
                return ((Integer) jSONObject.get(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)).intValue();
            }
            if (jSONObject.has("actionId")) {
                return ((Integer) jSONObject.get("actionId")).intValue();
            }
            if (!jSONObject.has("id")) {
                return -1;
            }
            return ((Integer) jSONObject.get("id")).intValue();
        } catch (JSONException e16) {
            QLog.e(SimpleRemoteEmoticon.TAG, 1, "getZPlanActionId has exception:", e16);
            return -1;
        } catch (Throwable th5) {
            QLog.e(SimpleRemoteEmoticon.TAG, 1, "getZPlanActionId has exception:", th5);
            return -1;
        }
    }

    public String getAlgoInfo() {
        return this.algoInfo;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getClickNum() {
        return 0;
    }

    public int getEpId() {
        return this.epId;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getExposeNum() {
        return 0;
    }

    public String getFilePath() {
        if (TextUtils.isEmpty(this.filePath)) {
            this.filePath = h.a(getURL());
        }
        return this.filePath;
    }

    public int getFromType() {
        return this.from;
    }

    public int getHeight() {
        if (TextUtils.isEmpty(this.thumbUrl)) {
            return this.imgHeight;
        }
        return this.thumbHeight;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getImgFileSize() {
        return this.imgFileSize;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgMd5() {
        if (isZPlanData()) {
            return "zplan-" + getZPlanPortraitId(this.zplanInfo);
        }
        return this.imgMd5;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public int getIndex() {
        return this.index;
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public int getKlType() {
        return this.klType;
    }

    public String getMd5() {
        if (TextUtils.isEmpty(this.thumbUrl)) {
            return this.imgMd5;
        }
        return this.thumbMd5;
    }

    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public int getRecType() {
        return this.mRecType;
    }

    public String getRecomTransfer() {
        return this.recomTransfer;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.SimpleRemoteEmoticon, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getReportEventPrefix() {
        if (isZPlanData()) {
            return "e-";
        }
        return super.getReportEventPrefix();
    }

    public String getSource() {
        return this.source;
    }

    public long getThumbFileSize() {
        return this.thumbFileSize;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public String getThumbMd5() {
        return this.thumbMd5;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public String getURL() {
        if (TextUtils.isEmpty(this.thumbUrl)) {
            return this.imgUrl;
        }
        return this.thumbUrl;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public int getWidth() {
        if (TextUtils.isEmpty(this.thumbUrl)) {
            return this.imgWidth;
        }
        return this.thumbWidth;
    }

    public String getZPlanInfo() {
        return this.zplanInfo;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isClicked() {
        return this.clicked;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isExposed() {
        return this.exposed;
    }

    public boolean isZPlanData() {
        if (this.from == 3) {
            return true;
        }
        return false;
    }

    public void setAlgoInfo(String str) {
        this.algoInfo = str;
    }

    public void setClicked(boolean z16) {
        this.clicked = z16;
    }

    public void setEpId(int i3) {
        this.epId = i3;
    }

    public void setExposed(boolean z16) {
        this.exposed = z16;
    }

    public void setFromType(int i3) {
        this.from = i3;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setImgFileSize(long j3) {
        this.imgFileSize = j3;
    }

    public void setImgHeight(int i3) {
        this.imgHeight = i3;
    }

    public void setImgMd5(String str) {
        this.imgMd5 = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setImgWidth(int i3) {
        this.imgWidth = i3;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setKeyWord(String str) {
        this.keyWord = str;
    }

    public void setKlType(int i3) {
        this.klType = i3;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRecType(int i3) {
        this.mRecType = i3;
    }

    public void setRecomTransfer(String str) {
        this.recomTransfer = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setThumbFileSize(long j3) {
        this.thumbFileSize = j3;
    }

    public void setThumbHeight(int i3) {
        this.thumbHeight = i3;
    }

    public void setThumbMd5(String str) {
        this.thumbMd5 = str;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setThumbWidth(int i3) {
        this.thumbWidth = i3;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public void setZPlanInfo(String str) {
        this.zplanInfo = str;
    }

    public String toString() {
        return "imgUrl=" + this.imgUrl + " thumbUrl=" + this.thumbUrl + " imgMd5=" + this.imgMd5 + " thumbMd5=" + this.thumbMd5 + " imgWidth=" + this.imgWidth + " imgHeight=" + this.imgHeight + " thumbWidth=" + this.thumbWidth + " thumbHeight=" + this.thumbHeight + " imgFileSize=" + this.imgFileSize + " thumbFileSize=" + this.thumbFileSize;
    }
}
