package com.qq.e.comm.plugin.base.media.video;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private long f39272a;

    /* renamed from: b, reason: collision with root package name */
    private a f39273b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void i();
    }

    public e(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f39273b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f39273b != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f39272a > 1000) {
                this.f39272a = elapsedRealtime;
                this.f39273b.i();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
