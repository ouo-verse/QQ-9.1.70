package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPURLContent implements Serializable {
    public String displayText;
    public int iconType;
    long serialVersionUID;
    public GProMVPTencentDocsContent tencentDocsContent;
    public GProMVPThirdPlatform thirdPlatform;
    public GProMVPCommThirdShareInfo thirdShareInfo;
    public GProMVPThirdVideoInfo thirdVideoInfo;
    public int type;
    public String url;
    public GProMVPWeixinOfficialAccountsContent weixinOffcialAccountsContent;

    public GProMVPURLContent() {
        this.serialVersionUID = 1L;
        this.url = "";
        this.displayText = "";
        this.thirdPlatform = new GProMVPThirdPlatform();
        this.thirdVideoInfo = new GProMVPThirdVideoInfo();
        this.weixinOffcialAccountsContent = new GProMVPWeixinOfficialAccountsContent();
        this.tencentDocsContent = new GProMVPTencentDocsContent();
        this.thirdShareInfo = new GProMVPCommThirdShareInfo();
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public int getIconType() {
        return this.iconType;
    }

    public GProMVPTencentDocsContent getTencentDocsContent() {
        return this.tencentDocsContent;
    }

    public GProMVPThirdPlatform getThirdPlatform() {
        return this.thirdPlatform;
    }

    public GProMVPCommThirdShareInfo getThirdShareInfo() {
        return this.thirdShareInfo;
    }

    public GProMVPThirdVideoInfo getThirdVideoInfo() {
        return this.thirdVideoInfo;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public GProMVPWeixinOfficialAccountsContent getWeixinOffcialAccountsContent() {
        return this.weixinOffcialAccountsContent;
    }

    public String toString() {
        return "GProMVPURLContent{url=" + this.url + ",displayText=" + this.displayText + ",type=" + this.type + ",thirdPlatform=" + this.thirdPlatform + ",thirdVideoInfo=" + this.thirdVideoInfo + ",weixinOffcialAccountsContent=" + this.weixinOffcialAccountsContent + ",tencentDocsContent=" + this.tencentDocsContent + ",thirdShareInfo=" + this.thirdShareInfo + ",iconType=" + this.iconType + ",}";
    }

    public GProMVPURLContent(String str, String str2, int i3, GProMVPThirdPlatform gProMVPThirdPlatform, GProMVPThirdVideoInfo gProMVPThirdVideoInfo, GProMVPWeixinOfficialAccountsContent gProMVPWeixinOfficialAccountsContent, GProMVPTencentDocsContent gProMVPTencentDocsContent) {
        this.serialVersionUID = 1L;
        this.url = "";
        this.displayText = "";
        this.thirdPlatform = new GProMVPThirdPlatform();
        this.thirdVideoInfo = new GProMVPThirdVideoInfo();
        this.weixinOffcialAccountsContent = new GProMVPWeixinOfficialAccountsContent();
        this.tencentDocsContent = new GProMVPTencentDocsContent();
        this.thirdShareInfo = new GProMVPCommThirdShareInfo();
        this.url = str;
        this.displayText = str2;
        this.type = i3;
        this.thirdPlatform = gProMVPThirdPlatform;
        this.thirdVideoInfo = gProMVPThirdVideoInfo;
        this.weixinOffcialAccountsContent = gProMVPWeixinOfficialAccountsContent;
        this.tencentDocsContent = gProMVPTencentDocsContent;
    }
}
