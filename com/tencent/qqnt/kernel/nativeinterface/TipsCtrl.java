package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TipsCtrl {
    public TipsColor color;
    public boolean needSecCheck;
    public int secCheckConfirmTime;
    public String secCheckTips;
    public TipsColor secCheckTipsColor;
    public String tips;

    public TipsCtrl() {
        this.color = TipsColor.values()[0];
        this.tips = "";
        this.secCheckTips = "";
        this.secCheckTipsColor = TipsColor.values()[0];
    }

    public TipsColor getColor() {
        return this.color;
    }

    public boolean getNeedSecCheck() {
        return this.needSecCheck;
    }

    public int getSecCheckConfirmTime() {
        return this.secCheckConfirmTime;
    }

    public String getSecCheckTips() {
        return this.secCheckTips;
    }

    public TipsColor getSecCheckTipsColor() {
        return this.secCheckTipsColor;
    }

    public String getTips() {
        return this.tips;
    }

    public String toString() {
        return "TipsCtrl{color=" + this.color + ",tips=" + this.tips + ",needSecCheck=" + this.needSecCheck + ",secCheckTips=" + this.secCheckTips + ",secCheckTipsColor=" + this.secCheckTipsColor + ",secCheckConfirmTime=" + this.secCheckConfirmTime + ",}";
    }

    public TipsCtrl(TipsColor tipsColor, String str, boolean z16, String str2, TipsColor tipsColor2, int i3) {
        this.color = TipsColor.values()[0];
        this.tips = "";
        this.secCheckTips = "";
        TipsColor tipsColor3 = TipsColor.values()[0];
        this.color = tipsColor;
        this.tips = str;
        this.needSecCheck = z16;
        this.secCheckTips = str2;
        this.secCheckTipsColor = tipsColor2;
        this.secCheckConfirmTime = i3;
    }
}
