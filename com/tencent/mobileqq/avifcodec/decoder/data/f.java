package com.tencent.mobileqq.avifcodec.decoder.data;

import android.graphics.YuvImage;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f implements d<YuvImage> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final YuvImage f200184a;

    public f(@NonNull YuvImage yuvImage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) yuvImage);
        } else {
            this.f200184a = yuvImage;
        }
    }

    @Override // com.tencent.mobileqq.avifcodec.decoder.data.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public YuvImage get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (YuvImage) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f200184a;
    }
}
