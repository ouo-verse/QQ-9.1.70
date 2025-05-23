package com.tencent.mobileqq.avifcodec.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements com.tencent.mobileqq.avifcodec.decoder.data.e<InputStream, Bitmap> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final com.tencent.mobileqq.avifcodec.decoder.data.a f200181a;

    public d() {
        this(new com.tencent.mobileqq.avifcodec.decoder.data.c());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
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
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.avifcodec.decoder.data.d<Bitmap> decode(@NonNull InputStream inputStream) {
        AvifDecoder c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.avifcodec.decoder.data.d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) inputStream);
        }
        byte[] c17 = c(inputStream);
        if (c17 == null || (c16 = AvifDecoder.c(c17)) == null) {
            return null;
        }
        if (c16.n() != 0) {
            c16.b();
            return null;
        }
        Bitmap d16 = c16.g().d(false);
        c16.b();
        return new com.tencent.mobileqq.avifcodec.decoder.data.b(this.f200181a, d16);
    }

    @Override // com.tencent.mobileqq.avifcodec.decoder.data.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b a(@NonNull InputStream inputStream) {
        AvifDecoder c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) inputStream);
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

    public d(@NonNull com.tencent.mobileqq.avifcodec.decoder.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f200181a = aVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }
}
