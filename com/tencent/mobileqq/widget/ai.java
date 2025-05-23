package com.tencent.mobileqq.widget;

import android.view.View;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ai implements URLDrawable.URLDrawableListener {

    /* renamed from: d, reason: collision with root package name */
    final WeakReference<View> f316615d;

    public ai(View view) {
        this.f316615d = new WeakReference<>(view);
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        View view = this.f316615d.get();
        if (view != null) {
            view.postInvalidate();
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
    }
}
