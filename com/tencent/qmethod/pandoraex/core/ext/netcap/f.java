package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f extends a {
    public f(HttpEntity httpEntity, d dVar) {
        super(httpEntity, dVar);
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.j
    public void a(long j3) {
        this.f344075e.a();
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.j
    public void b(long j3, byte[] bArr) {
        this.f344075e.a();
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
        try {
            c cVar = new c(outputStream);
            cVar.f(this);
            this.f344074d.writeTo(cVar);
        } catch (IOException e16) {
            throw e16;
        }
    }
}
