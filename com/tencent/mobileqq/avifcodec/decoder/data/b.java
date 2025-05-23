package com.tencent.mobileqq.avifcodec.decoder.data;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements d<Bitmap> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final a f200182a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f200183b;

    public b(@NonNull a aVar, @NonNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) bitmap);
        } else {
            this.f200182a = aVar;
            this.f200183b = bitmap;
        }
    }

    @Override // com.tencent.mobileqq.avifcodec.decoder.data.d
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f200183b;
    }
}
