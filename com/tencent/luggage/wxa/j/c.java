package com.tencent.luggage.wxa.j;

import java.io.FileInputStream;
import java.io.FilterInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f130758a;

    public c(FileInputStream fileInputStream) {
        super(fileInputStream);
        this.f130758a = 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i3) {
        try {
            this.f130758a = ((FileInputStream) ((FilterInputStream) this).in).getChannel().position();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.h.b.a("MicroMsg.FileSeekingInputStream", e16, "Failed seeking FileChannel.", new Object[0]);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        ((FileInputStream) ((FilterInputStream) this).in).getChannel().position(this.f130758a);
    }
}
