package com.tencent.tdf.embed;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final /* synthetic */ class a {
    public static Bitmap a(EmbeddedView embeddedView) {
        IPatchRedirector iPatchRedirector = EmbeddedView.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) embeddedView);
        }
        View view = embeddedView.getView();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width != 0 && height != 0) {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return null;
    }

    public static void b(EmbeddedView embeddedView) {
        IPatchRedirector iPatchRedirector = EmbeddedView.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) embeddedView);
        }
    }

    public static void c(EmbeddedView embeddedView) {
        IPatchRedirector iPatchRedirector = EmbeddedView.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) embeddedView);
        }
    }

    public static void d(EmbeddedView embeddedView, Map map) {
        IPatchRedirector iPatchRedirector = EmbeddedView.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) embeddedView, (Object) map);
        }
    }
}
