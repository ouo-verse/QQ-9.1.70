package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStRichTextURLContent implements Serializable {
    public int iconType;
    public boolean isFirstMediaContent;
    public int type;
    long serialVersionUID = 1;
    public String url = "";
    public String displayText = "";
    public String playUrl = "";
    public GProThirdPlatform thirdPlatform = new GProThirdPlatform();
    public GProCommThirdVideoInfo thirdVideoInfo = new GProCommThirdVideoInfo();
    public GProStRichTextWeixinOfficialAccountsContent weixinOffcialAccountsContent = new GProStRichTextWeixinOfficialAccountsContent();
    public GProStRichTextTencentDocsContent tencentDocsContent = new GProStRichTextTencentDocsContent();
    public GProStRichTextCardContent cardContent = new GProStRichTextCardContent();
    public GProCommThirdShareInfo thirdShareInfo = new GProCommThirdShareInfo();

    public GProStRichTextCardContent getCardContent() {
        return this.cardContent;
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public int getIconType() {
        return this.iconType;
    }

    public boolean getIsFirstMediaContent() {
        return this.isFirstMediaContent;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public GProStRichTextTencentDocsContent getTencentDocsContent() {
        return this.tencentDocsContent;
    }

    public GProThirdPlatform getThirdPlatform() {
        return this.thirdPlatform;
    }

    public GProCommThirdShareInfo getThirdShareInfo() {
        return this.thirdShareInfo;
    }

    public GProCommThirdVideoInfo getThirdVideoInfo() {
        return this.thirdVideoInfo;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public GProStRichTextWeixinOfficialAccountsContent getWeixinOffcialAccountsContent() {
        return this.weixinOffcialAccountsContent;
    }

    public String toString() {
        return "GProStRichTextURLContent{url=" + this.url + ",displayText=" + this.displayText + ",type=" + this.type + ",playUrl=" + this.playUrl + ",thirdPlatform=" + this.thirdPlatform + ",thirdVideoInfo=" + this.thirdVideoInfo + ",weixinOffcialAccountsContent=" + this.weixinOffcialAccountsContent + ",tencentDocsContent=" + this.tencentDocsContent + ",cardContent=" + this.cardContent + ",isFirstMediaContent=" + this.isFirstMediaContent + ",thirdShareInfo=" + this.thirdShareInfo + ",iconType=" + this.iconType + ",}";
    }
}
