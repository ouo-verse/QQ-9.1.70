package com.huawei.hms.hihealth.data;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthKitApiResult {
    private boolean isResultGzipped = false;
    private String response;

    public String getResponse() {
        return this.response;
    }

    public boolean isResultGzipped() {
        return this.isResultGzipped;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public void setResultGzipped(boolean z16) {
        this.isResultGzipped = z16;
    }
}
