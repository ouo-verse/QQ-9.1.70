package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LoginRspInfo {
    public BindUinInfo bindUinInfo;
    public int errCode;
    public byte[] loginContext;
    public byte[] longCookie;
    public String errMsg = "";
    public String jumpUrl = "";
    public String jumpWord = "";
    public String tipsTitle = "";
    public String tipsContent = "";
    public ErrorDetail msgDetail = new ErrorDetail();
    public ArrayList<Button> msgButton = new ArrayList<>();

    public BindUinInfo getBindUinInfo() {
        return this.bindUinInfo;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getJumpWord() {
        return this.jumpWord;
    }

    public byte[] getLoginContext() {
        return this.loginContext;
    }

    public byte[] getLongCookie() {
        return this.longCookie;
    }

    public ArrayList<Button> getMsgButton() {
        return this.msgButton;
    }

    public ErrorDetail getMsgDetail() {
        return this.msgDetail;
    }

    public String getTipsContent() {
        return this.tipsContent;
    }

    public String getTipsTitle() {
        return this.tipsTitle;
    }

    public String toString() {
        return "LoginRspInfo{errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",jumpUrl=" + this.jumpUrl + ",jumpWord=" + this.jumpWord + ",tipsTitle=" + this.tipsTitle + ",tipsContent=" + this.tipsContent + ",loginContext=" + this.loginContext + ",longCookie=" + this.longCookie + ",bindUinInfo=" + this.bindUinInfo + ",msgDetail=" + this.msgDetail + ",msgButton=" + this.msgButton + ",}";
    }
}
