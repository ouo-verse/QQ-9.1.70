package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiAvatarDisplayInfo {
    public String text = "";
    public String detailDescription = "";
    public String popupText = "";
    public String retentionPopupText = "";

    public String getDetailDescription() {
        return this.detailDescription;
    }

    public String getPopupText() {
        return this.popupText;
    }

    public String getRetentionPopupText() {
        return this.retentionPopupText;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "AiAvatarDisplayInfo{text=" + this.text + ",detailDescription=" + this.detailDescription + ",popupText=" + this.popupText + ",retentionPopupText=" + this.retentionPopupText + ",}";
    }
}
