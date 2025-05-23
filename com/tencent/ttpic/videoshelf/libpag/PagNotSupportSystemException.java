package com.tencent.ttpic.videoshelf.libpag;

/* loaded from: classes27.dex */
public class PagNotSupportSystemException extends Exception {
    private String mClassName;

    public PagNotSupportSystemException(String str) {
        this.mClassName = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + "," + this.mClassName + "\uff0c\u5f53\u524dandroid \u7cfb\u7edf\u592a\u4f4e\uff0c\u4e0d\u652f\u6301pag\uff0c\u9700\u8981\u4fdd\u8bc1\u7cfb\u7edf\u5728android 4.3\u4ee5\u53ca\u4ee5\u4e0a\u3002";
    }
}
