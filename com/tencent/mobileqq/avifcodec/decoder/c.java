package com.tencent.mobileqq.avifcodec.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements com.tencent.mobileqq.avifcodec.decoder.data.e<ByteBuffer, Bitmap> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.avifcodec.decoder.data.a f200180a;

    public c() {
        this(new com.tencent.mobileqq.avifcodec.decoder.data.c());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.mobileqq.avifcodec.decoder.data.e
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.avifcodec.decoder.data.d<Bitmap> decode(@NonNull ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.avifcodec.decoder.data.d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) byteBuffer);
        }
        AvifDecoder e16 = AvifDecoder.e(byteBuffer);
        if (e16 == null) {
            return null;
        }
        if (e16.n() != 0) {
            e16.b();
            return null;
        }
        Bitmap d16 = e16.g().d(false);
        e16.b();
        return new com.tencent.mobileqq.avifcodec.decoder.data.b(this.f200180a, d16);
    }

    @Override // com.tencent.mobileqq.avifcodec.decoder.data.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(@NonNull ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) byteBuffer);
        }
        AvifDecoder e16 = AvifDecoder.e(byteBuffer);
        if (e16 == null) {
            return null;
        }
        AvifImage g16 = e16.g();
        b bVar = new b(g16.h(), g16.g(), g16.e());
        e16.b();
        return bVar;
    }

    public c(@NonNull com.tencent.mobileqq.avifcodec.decoder.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f200180a = aVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }
}
