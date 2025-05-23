package com.tencent.mobileqq.qqaudio.audioprocessor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface c {
    a a(byte[] bArr, int i3, int i16) throws IOException;

    void b(int i3, int i16, int i17) throws IOException;

    void release() throws IOException;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f262208a;

        /* renamed from: b, reason: collision with root package name */
        public int f262209b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f262210c;

        public a(byte[] bArr, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr, i3);
                return;
            }
            this.f262208a = i3;
            this.f262210c = bArr;
            this.f262209b = 0;
        }

        public a(byte[] bArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f262208a = i16;
            this.f262210c = bArr;
            this.f262209b = i3;
        }
    }
}
