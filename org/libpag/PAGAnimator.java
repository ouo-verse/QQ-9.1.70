package org.libpag;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class PAGAnimator {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f423715a;

    /* renamed from: b, reason: collision with root package name */
    private float f423716b;
    private long nativeContext = 0;

    /* loaded from: classes29.dex */
    public interface Listener {
        void onAnimationCancel(PAGAnimator pAGAnimator);

        void onAnimationEnd(PAGAnimator pAGAnimator);

        void onAnimationRepeat(PAGAnimator pAGAnimator);

        void onAnimationStart(PAGAnimator pAGAnimator);

        void onAnimationUpdate(PAGAnimator pAGAnimator);
    }

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGAnimator(Context context, Listener listener) {
        this.f423715a = null;
        this.f423716b = 1.0f;
        this.f423715a = new WeakReference(listener);
        if (context != null) {
            this.f423716b = Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        nativeSetup();
    }

    public static PAGAnimator a(Context context, Listener listener) {
        if (listener == null) {
            return null;
        }
        return new PAGAnimator(context, listener);
    }

    private native void doStart();

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup();

    private void onAnimationCancel() {
        Listener listener = (Listener) this.f423715a.get();
        if (listener != null) {
            listener.onAnimationCancel(this);
        }
    }

    private void onAnimationEnd() {
        Listener listener = (Listener) this.f423715a.get();
        if (listener != null) {
            listener.onAnimationEnd(this);
        }
    }

    private void onAnimationRepeat() {
        Listener listener = (Listener) this.f423715a.get();
        if (listener != null) {
            listener.onAnimationRepeat(this);
        }
    }

    private void onAnimationStart() {
        Listener listener = (Listener) this.f423715a.get();
        if (listener != null) {
            listener.onAnimationStart(this);
        }
    }

    private void onAnimationUpdate() {
        Listener listener = (Listener) this.f423715a.get();
        if (listener != null) {
            listener.onAnimationUpdate(this);
        }
    }

    public native void cancel();

    public native long duration();

    protected void finalize() {
        nativeFinalize();
    }

    public native boolean isRunning();

    public native boolean isSync();

    public native double progress();

    public native int repeatCount();

    public native void setDuration(long j3);

    public native void setProgress(double d16);

    public native void setRepeatCount(int i3);

    public native void setSync(boolean z16);

    public native void update();

    public void a() {
        if (this.f423716b == 0.0f) {
            Log.e("libpag", "PAGAnimator.play() The scale of animator duration is turned off!");
            Listener listener = (Listener) this.f423715a.get();
            if (listener != null) {
                listener.onAnimationUpdate(this);
                listener.onAnimationEnd(this);
                return;
            }
            return;
        }
        doStart();
    }
}
