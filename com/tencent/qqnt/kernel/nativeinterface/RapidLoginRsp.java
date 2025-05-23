package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RapidLoginRsp {
    public int retCode;
    public String errorMsg = "";
    public String url = "";

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "RapidLoginRsp{retCode=" + this.retCode + ",errorMsg=" + this.errorMsg + JefsClass.INDEX_URL + this.url + ",}";
    }
}
