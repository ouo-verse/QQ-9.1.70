package com.tencent.component.media.gif;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class InvalidationHandler extends Handler {
    private final WeakReference<Drawable> mDrawableRef;

    public InvalidationHandler(Drawable drawable) {
        super(Looper.getMainLooper());
        this.mDrawableRef = new WeakReference<>(drawable);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Drawable drawable = this.mDrawableRef.get();
        if (drawable != null) {
            drawable.invalidateSelf();
        }
    }
}
