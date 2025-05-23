package com.tencent.luggage.wxa.lm;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.net.URL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.l9.b {

    /* renamed from: c, reason: collision with root package name */
    private static final String f133615c = "MicroMsg.Audio.AudioHttpDownloadSource";

    /* renamed from: a, reason: collision with root package name */
    private IMediaHTTPConnection f133616a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.luggage.wxa.qb.b f133617b;

    public d(IMediaHTTPConnection iMediaHTTPConnection, com.tencent.luggage.wxa.qb.b bVar) {
        this.f133616a = iMediaHTTPConnection;
        this.f133617b = bVar;
    }

    @Override // com.tencent.luggage.wxa.l9.c
    public void a() {
        URL url;
        if (this.f133616a != null) {
            try {
                url = new URL(this.f133617b.f138565b);
            } catch (Exception e16) {
                w.a(f133615c, e16, UploadQualityReportBuilder.STATE_CONNECT, new Object[0]);
                url = null;
            }
            this.f133616a.connect(url, new HashMap());
        }
    }

    @Override // com.tencent.luggage.wxa.l9.b, com.tencent.luggage.wxa.l9.c
    public String b() {
        IMediaHTTPConnection iMediaHTTPConnection = this.f133616a;
        if (iMediaHTTPConnection != null) {
            return iMediaHTTPConnection.getMIMEType();
        }
        return super.b();
    }

    @Override // com.tencent.luggage.wxa.l9.c
    public com.tencent.luggage.wxa.qb.b c() {
        return this.f133617b;
    }

    @Override // com.tencent.luggage.wxa.l9.c
    public void disconnect() {
        IMediaHTTPConnection iMediaHTTPConnection = this.f133616a;
        if (iMediaHTTPConnection != null) {
            iMediaHTTPConnection.disconnect();
        }
    }

    @Override // com.tencent.luggage.wxa.l9.b, com.tencent.luggage.wxa.l9.c
    public long getSize() {
        IMediaHTTPConnection iMediaHTTPConnection = this.f133616a;
        if (iMediaHTTPConnection != null) {
            return iMediaHTTPConnection.getSize();
        }
        return super.getSize();
    }

    @Override // com.tencent.luggage.wxa.l9.b, com.tencent.luggage.wxa.l9.c
    public int readAt(long j3, byte[] bArr, int i3, int i16) {
        IMediaHTTPConnection iMediaHTTPConnection = this.f133616a;
        if (iMediaHTTPConnection != null) {
            return iMediaHTTPConnection.readAt(j3, bArr, i3, i16);
        }
        return super.readAt(j3, bArr, i3, i16);
    }
}
