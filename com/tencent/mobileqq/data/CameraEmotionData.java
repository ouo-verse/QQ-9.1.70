package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CameraEmotionData extends CustomEmotionBase<CameraEmotionData> {
    public int clickNum;
    public int exposeNum;
    public String strContext;
    public String templateId;

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
        return "CameraEmotionData [uin=" + this.uin + ", emoId=" + this.emoId + ", emoPath=" + this.emoPath + ", strContext=" + this.strContext + ", RomaingType=" + this.RomaingType + ", resid=" + this.resid + ", url=" + this.url + ", md5=" + this.md5 + ", templateId:" + this.templateId + "]";
    }

    @Override // com.tencent.mobileqq.data.CustomEmotionBase
    public void replace(CameraEmotionData cameraEmotionData) {
        if (cameraEmotionData != null) {
            super.replace(cameraEmotionData);
            this.strContext = cameraEmotionData.strContext;
            this.templateId = cameraEmotionData.templateId;
        }
    }
}
