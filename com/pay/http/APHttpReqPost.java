package com.pay.http;

import com.tencent.mtt.hippy.adapter.http.HttpHeader;

/* loaded from: classes2.dex */
public abstract class APHttpReqPost extends APBaseHttpReq {
    public APHttpReqPost() {
        this.httpParam.setReqWithHttps();
        this.httpParam.setSendWithPost();
    }

    private void setPostMothod() {
        try {
            this.httpURLConnection.setRequestMethod("POST");
            this.httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
            this.httpURLConnection.setDoInput(true);
            this.httpURLConnection.setDoOutput(true);
            this.httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.httpParam.urlParams.getBytes().length));
            this.httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pay.http.APBaseHttpReq
    public void setBody() {
        super.setBody();
    }

    @Override // com.pay.http.APBaseHttpReq
    protected void setHeader() {
        setPostMothod();
    }
}
