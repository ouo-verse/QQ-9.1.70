package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisOperationHotSearchItem {
    public boolean isManualOperation;
    public String word = "";
    public UfsDisHotSearchIcon icons = new UfsDisHotSearchIcon();
    public String serialNumUrl = "";
    public UfsDisJumpLink jumpLink = new UfsDisJumpLink();
    public byte[] reportData = new byte[0];
    public String hotSearchTextId = "";

    public String getHotSearchTextId() {
        return this.hotSearchTextId;
    }

    public UfsDisHotSearchIcon getIcons() {
        return this.icons;
    }

    public boolean getIsManualOperation() {
        return this.isManualOperation;
    }

    public UfsDisJumpLink getJumpLink() {
        return this.jumpLink;
    }

    public byte[] getReportData() {
        return this.reportData;
    }

    public String getSerialNumUrl() {
        return this.serialNumUrl;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "UfsDisOperationHotSearchItem{word=" + this.word + ",icons=" + this.icons + ",serialNumUrl=" + this.serialNumUrl + ",jumpLink=" + this.jumpLink + ",reportData=" + this.reportData + ",isManualOperation=" + this.isManualOperation + ",hotSearchTextId=" + this.hotSearchTextId + ",}";
    }
}
