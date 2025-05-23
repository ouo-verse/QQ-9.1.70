package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckUrlResult {
    public int jumpResult;
    public String jumpUrl;
    public int result;
    public String url;

    public CheckUrlResult() {
        this.url = "";
        this.jumpUrl = "";
    }

    public int getJumpResult() {
        return this.jumpResult;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getResult() {
        return this.result;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "CheckUrlResult{url=" + this.url + ",result=" + this.result + ",jumpResult=" + this.jumpResult + ",jumpUrl=" + this.jumpUrl + ",}";
    }

    public CheckUrlResult(String str, int i3, int i16, String str2) {
        this.url = str;
        this.result = i3;
        this.jumpResult = i16;
        this.jumpUrl = str2;
    }
}
