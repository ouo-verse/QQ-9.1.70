package cooperation.vip.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;

/* loaded from: classes28.dex */
public class AnimationDrawableProxyView extends View {

    /* renamed from: d, reason: collision with root package name */
    private View f391017d;

    public AnimationDrawableProxyView(Context context, View view, Drawable drawable) {
        super(context);
        this.f391017d = view;
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        this.f391017d.invalidate();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        this.f391017d.postDelayed(runnable, j3 - SystemClock.uptimeMillis());
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f391017d.removeCallbacks(runnable);
    }
}
