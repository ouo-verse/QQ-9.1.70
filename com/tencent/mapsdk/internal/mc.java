package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public class mc extends lu {

    /* renamed from: a, reason: collision with root package name */
    private NetResponse f149299a;

    private static InputStream a(InputStream inputStream) {
        return inputStream;
    }

    @Override // com.tencent.mapsdk.internal.lu
    public final void b() {
        super.b();
        NetResponse netResponse = this.f149299a;
        if (netResponse != null) {
            ku.a((Closeable) netResponse.getInputStream());
        }
    }

    @Override // com.tencent.mapsdk.internal.lu
    public InputStream e(String str) {
        NetRequest.NetRequestBuilder url = NetManager.getInstance().builder().url(str);
        a(url);
        NetResponse doStream = url.doStream();
        this.f149299a = doStream;
        if (doStream != null) {
            InputStream inputStream = doStream.getInputStream();
            a(this.f149299a);
            return inputStream;
        }
        a(new NetResponse(url.getNetRequest()));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(NetRequest.NetRequestBuilder netRequestBuilder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(NetResponse netResponse) {
    }
}
