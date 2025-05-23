package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.b;
import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes3.dex */
public class S2SSRequest extends AbstractRequest {

    /* renamed from: a, reason: collision with root package name */
    private boolean f38315a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38316b;

    public S2SSRequest(String str, byte[] bArr) {
        super(str, 2, bArr);
        this.f38315a = false;
        this.f38316b = false;
    }

    @Override // com.qq.e.comm.net.rr.AbstractRequest, com.qq.e.comm.net.rr.Request
    public byte[] getPostData() throws Exception {
        byte[] postData = super.getPostData();
        if (this.f38315a) {
            return b.a(postData);
        }
        if (this.f38316b) {
            return b.c(postData);
        }
        return postData;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Response initResponse(HttpURLConnection httpURLConnection) {
        return new S2SSResponse(httpURLConnection, this.f38315a);
    }

    public S2SSRequest(String str, byte[] bArr, boolean z16) {
        super(str, 2, bArr);
        this.f38316b = false;
        this.f38315a = z16;
    }

    public S2SSRequest(String str, byte[] bArr, boolean z16, boolean z17) {
        super(str, 2, bArr);
        this.f38315a = z16;
        this.f38316b = z17;
        if (z17) {
            addHeader("Content-Encoding", "gzip");
        }
    }
}
