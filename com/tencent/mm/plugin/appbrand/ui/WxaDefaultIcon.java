package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WxaDefaultIcon {

    /* renamed from: a, reason: collision with root package name */
    public static volatile WeakReference f152300a;

    public static Drawable get() {
        Bitmap bitmap;
        if (f152300a == null || (bitmap = (Bitmap) f152300a.get()) == null || bitmap.isRecycled()) {
            f152300a = new WeakReference(BitmapFactory.decodeResource(z.j(), R.drawable.ojy));
        }
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(z.j(), (Bitmap) f152300a.get());
        create.setCircular(true);
        return create;
    }
}
