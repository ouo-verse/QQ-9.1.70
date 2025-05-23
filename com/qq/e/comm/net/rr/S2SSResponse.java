package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.b;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes3.dex */
public class S2SSResponse extends AbstractResponse {

    /* renamed from: a, reason: collision with root package name */
    private boolean f38317a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38318b;

    public S2SSResponse(HttpURLConnection httpURLConnection) {
        super(httpURLConnection);
        this.f38317a = false;
        this.f38318b = false;
    }

    @Override // com.qq.e.comm.net.rr.AbstractResponse, com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        try {
            if (this.f38317a) {
                return b.b(super.getBytesContent());
            }
            if (this.f38318b) {
                return b.d(super.getBytesContent());
            }
            return super.getBytesContent();
        } catch (b.C0277b e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public S2SSResponse(HttpURLConnection httpURLConnection, boolean z16) {
        super(httpURLConnection);
        this.f38318b = false;
        this.f38317a = z16;
    }

    public S2SSResponse(HttpURLConnection httpURLConnection, boolean z16, boolean z17) {
        super(httpURLConnection);
        this.f38317a = z16;
        this.f38318b = z17;
    }
}
