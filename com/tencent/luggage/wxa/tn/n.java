package com.tencent.luggage.wxa.tn;

import java.io.FileInputStream;
import java.io.FilterInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f141660a;

    public n(FileInputStream fileInputStream) {
        super(fileInputStream);
        this.f141660a = 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i3) {
        try {
            this.f141660a = ((FileInputStream) ((FilterInputStream) this).in).getChannel().position();
        } catch (Exception e16) {
            w.a("MicroMsg.FileSeekingInputStream", e16, "Failed seeking FileChannel.", new Object[0]);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        ((FileInputStream) ((FilterInputStream) this).in).getChannel().position(this.f141660a);
    }
}
