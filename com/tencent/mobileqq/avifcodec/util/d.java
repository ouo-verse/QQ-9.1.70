package com.tencent.mobileqq.avifcodec.util;

import com.tencent.mobileqq.avifcodec.util.Reader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements Reader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f200188a;

    public d(InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream);
        } else {
            this.f200188a = inputStream;
        }
    }

    public int a() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        int read = this.f200188a.read();
        if (read != -1) {
            return read;
        }
        throw new Reader.EndOfFileException();
    }

    @Override // com.tencent.mobileqq.avifcodec.util.Reader
    public int getInt32BE() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return (a() << 24) | (a() << 16) | (a() << 8) | a();
    }

    @Override // com.tencent.mobileqq.avifcodec.util.Reader
    public int read(byte[] bArr, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr, i3)).intValue();
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < i3 && (i17 = this.f200188a.read(bArr, i16, i3 - i16)) != -1) {
            i16 += i17;
        }
        if (i16 == 0 && i17 == -1) {
            throw new Reader.EndOfFileException();
        }
        return i16;
    }
}
