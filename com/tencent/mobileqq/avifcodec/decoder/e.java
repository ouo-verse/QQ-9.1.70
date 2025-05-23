package com.tencent.mobileqq.avifcodec.decoder;

import android.graphics.YuvImage;
import androidx.annotation.NonNull;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.mobileqq.avifcodec.decoder.data.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements com.tencent.mobileqq.avifcodec.decoder.data.e<InputStream, YuvImage> {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private byte[] c(InputStream inputStream) {
        int i3;
        try {
            i3 = inputStream.available();
        } catch (IOException unused) {
            i3 = 16384;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.avifcodec.decoder.data.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.avifcodec.decoder.data.d<YuvImage> decode(@NonNull InputStream inputStream) {
        AvifDecoder c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.avifcodec.decoder.data.d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) inputStream);
        }
        byte[] c17 = c(inputStream);
        if (c17 == null || (c16 = AvifDecoder.c(c17)) == null) {
            return null;
        }
        if (c16.n() != 0) {
            c16.b();
            return null;
        }
        AvifImage g16 = c16.g();
        if (g16.i() != 3) {
            c16.b();
            return null;
        }
        int h16 = g16.h();
        int g17 = g16.g();
        byte[] a16 = g16.a();
        c16.b();
        return new f(new YuvImage(a16, 17, h16, g17, null));
    }

    @Override // com.tencent.mobileqq.avifcodec.decoder.data.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b a(@NonNull InputStream inputStream) {
        AvifDecoder c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) inputStream);
        }
        byte[] c17 = c(inputStream);
        if (c17 == null || (c16 = AvifDecoder.c(c17)) == null) {
            return null;
        }
        AvifImage g16 = c16.g();
        b bVar = new b(g16.h(), g16.g(), g16.e());
        c16.b();
        return bVar;
    }
}
