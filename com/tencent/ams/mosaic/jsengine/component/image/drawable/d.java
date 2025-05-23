package com.tencent.ams.mosaic.jsengine.component.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@RequiresApi(21)
/* loaded from: classes3.dex */
class d extends e {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources, (Object) bitmap);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.drawable.e
    void c(int i3, int i16, int i17, Rect rect, Rect rect2) {
        Gravity.apply(i3, i16, i17, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) outline);
        } else {
            g();
            outline.setRoundRect(this.f71185h, b());
        }
    }
}
