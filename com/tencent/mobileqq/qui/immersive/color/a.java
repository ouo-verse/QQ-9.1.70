package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a implements IColorFetcher {
    static IPatchRedirector $redirector_ = null;
    public static final int MIN_AREA_HEIGHT = 5;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Pair<Integer, Integer> a(Drawable drawable) {
        int width = drawable.getBounds().width();
        int height = drawable.getBounds().height();
        if (width == 0 || height == 0) {
            width = drawable.getIntrinsicWidth();
            height = drawable.getIntrinsicHeight();
        }
        if (width <= 0 || height <= 0) {
            Drawable.Callback callback = drawable.getCallback();
            if (callback instanceof View) {
                View view = (View) callback;
                width = view.getWidth();
                height = view.getHeight();
            }
        }
        return new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public Pair<Boolean, Integer> getColor(View view, IColorFetcher.Area area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) area);
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap h16 = imageCacheHelper.h(view.getWidth(), 5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(h16);
        if (area == IColorFetcher.Area.BOTTOM) {
            canvas.translate(0.0f, (-view.getHeight()) + 5);
        }
        view.draw(canvas);
        int a16 = c.a(h16);
        imageCacheHelper.l(h16);
        return new Pair<>(Boolean.TRUE, Integer.valueOf(a16));
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public Pair<Boolean, Integer> getColor(Drawable drawable, IColorFetcher.Area area) {
        Bitmap h16;
        Canvas canvas;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) area);
        }
        if (drawable == null) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int width = drawable.getBounds().width();
        int height = drawable.getBounds().height();
        if (width != 0 && height != 0) {
            h16 = ImageCacheHelper.f98636a.h(width, Math.min(5, height), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(h16);
            if (area == IColorFetcher.Area.BOTTOM) {
                canvas.translate(0.0f, Math.min((-height) + 5, 0));
            }
        } else {
            Pair<Integer, Integer> a16 = a(drawable);
            if (((Integer) a16.first).intValue() > 0 && ((Integer) a16.second).intValue() > 0) {
                h16 = ImageCacheHelper.f98636a.h(((Integer) a16.first).intValue(), Math.min(5, ((Integer) a16.second).intValue()), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(h16);
                if (area == IColorFetcher.Area.BOTTOM) {
                    canvas2.translate(0.0f, Math.min((-((Integer) a16.first).intValue()) + 5, 0));
                }
                Rect rect = new Rect(drawable.getBounds());
                Rect rect2 = new Rect(0, 0, ((Integer) a16.first).intValue(), ((Integer) a16.second).intValue());
                Drawable.Callback callback = drawable.getCallback();
                drawable.setCallback(null);
                drawable.setBounds(rect2);
                drawable.draw(canvas2);
                drawable.setBounds(rect);
                drawable.setCallback(callback);
                canvas = canvas2;
            } else {
                return new Pair<>(Boolean.FALSE, -1);
            }
        }
        drawable.draw(canvas);
        int a17 = c.a(h16);
        ImageCacheHelper.f98636a.l(h16);
        return new Pair<>(Boolean.TRUE, Integer.valueOf(a17));
    }
}
