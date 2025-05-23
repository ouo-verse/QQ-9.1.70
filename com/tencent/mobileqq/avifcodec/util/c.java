package com.tencent.mobileqq.avifcodec.util;

import com.tencent.mobileqq.avifcodec.util.Reader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements Reader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f200187a;

    public c(ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) byteBuffer);
        } else {
            this.f200187a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }
    }

    public int a() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (this.f200187a.remaining() >= 1) {
            return this.f200187a.get();
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
    public int read(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr, i3)).intValue();
        }
        int min = Math.min(i3, this.f200187a.remaining());
        if (min == 0) {
            return -1;
        }
        this.f200187a.get(bArr, 0, min);
        return min;
    }
}
