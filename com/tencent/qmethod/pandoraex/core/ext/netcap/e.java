package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends a {

    /* renamed from: f, reason: collision with root package name */
    private boolean f344089f;

    public e(HttpEntity httpEntity, d dVar) {
        super(httpEntity, dVar);
        this.f344089f = false;
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.j
    public void a(long j3) {
        this.f344075e.a();
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.j
    public void b(long j3, byte[] bArr) {
        d dVar = this.f344075e;
        dVar.f344085c = bArr;
        dVar.a();
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.j
    public void c(long j3) {
        this.f344075e.a();
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.j
    public void d(long j3) {
        this.f344075e.a();
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (!this.f344089f) {
            String str = "";
            long j3 = 0;
            try {
                Header contentType = getContentType();
                if (contentType != null) {
                    str = contentType.toString();
                }
                j3 = getContentLength();
                d dVar = this.f344075e;
                dVar.f344087e = str;
                dVar.f344088f = j3;
            } catch (Exception unused) {
            }
            try {
                d dVar2 = this.f344075e;
                if (k.a(dVar2.f344084b, dVar2.f344083a, str, j3)) {
                    c cVar = new c(outputStream);
                    cVar.f(this);
                    this.f344074d.writeTo(cVar);
                    this.f344075e.f344085c = cVar.a().toByteArray();
                    this.f344089f = true;
                    this.f344075e.a();
                } else {
                    this.f344089f = true;
                    this.f344075e.a();
                    this.f344074d.writeTo(outputStream);
                }
                return;
            } catch (IOException e16) {
                this.f344089f = true;
                throw e16;
            }
        }
        this.f344074d.writeTo(outputStream);
    }
}
