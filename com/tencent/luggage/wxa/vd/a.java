package com.tencent.luggage.wxa.vd;

import android.os.Build;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vd.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6840a extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public long f143352a;

        public C6840a(FileInputStream fileInputStream) {
            super(fileInputStream);
            this.f143352a = 0L;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i3) {
            try {
                this.f143352a = ((FileInputStream) ((FilterInputStream) this).in).getChannel().position();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.a("Luggage.ViewAttributeHelper", e16, "fail to mark position.");
                this.f143352a = -1L;
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (this.f143352a >= 0) {
                ((FileInputStream) ((FilterInputStream) this).in).getChannel().position(this.f143352a);
            } else {
                throw new IOException("Illegal marked position: " + this.f143352a);
            }
        }
    }

    public static int a() {
        "HUAWEI".equals(Build.MANUFACTURER);
        return 8388608;
    }

    public static InputStream a(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return inputStream;
        }
        if (inputStream instanceof FileInputStream) {
            return new C6840a((FileInputStream) inputStream);
        }
        return new BufferedInputStream(inputStream);
    }
}
