package com.tencent.ecommerce.richtext.ui.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import jk0.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<a> f105424d;

    public VFrameLayout(@NonNull Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f105424d = new WeakReference<>(aVar);
    }

    @Nullable
    public a b() {
        WeakReference<a> weakReference = this.f105424d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (b() != null) {
            if (!b().w() && !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
