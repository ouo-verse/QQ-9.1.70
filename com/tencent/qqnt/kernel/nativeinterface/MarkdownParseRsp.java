package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class MarkdownParseRsp {
    public String errMsg = "";
    public String parseResult = "";
    public int result;

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getParseResult() {
        return this.parseResult;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "MarkdownParseRsp{result=" + this.result + ",errMsg=" + this.errMsg + ",parseResult=" + this.parseResult + ",}";
    }
}
