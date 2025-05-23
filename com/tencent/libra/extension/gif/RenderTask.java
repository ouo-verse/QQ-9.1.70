package com.tencent.libra.extension.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class RenderTask extends SafeRunnable {

    /* renamed from: e, reason: collision with root package name */
    private long f118743e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderTask(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.tencent.libra.extension.gif.SafeRunnable
    public void e() {
        if (this.f118743e == 0) {
            GifDrawable gifDrawable = this.f118744d;
            this.f118743e = gifDrawable.C.x(gifDrawable.f118727m);
        }
        if (this.f118743e >= 0) {
            this.f118744d.f118724f = SystemClock.uptimeMillis() + this.f118743e;
            if (this.f118744d.isVisible() && this.f118744d.f118723e) {
                GifDrawable gifDrawable2 = this.f118744d;
                if (!gifDrawable2.H) {
                    gifDrawable2.f().remove(this);
                    GifDrawable gifDrawable3 = this.f118744d;
                    gifDrawable3.M = gifDrawable3.f().schedule(this, this.f118743e, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f118744d.D.isEmpty() && this.f118744d.d() == this.f118744d.C.m() - 1) {
                GifDrawable gifDrawable4 = this.f118744d;
                gifDrawable4.I.sendEmptyMessageAtTime(gifDrawable4.e(), this.f118744d.f118724f);
            }
        } else {
            GifDrawable gifDrawable5 = this.f118744d;
            gifDrawable5.f118724f = Long.MIN_VALUE;
            gifDrawable5.f118723e = false;
        }
        if (this.f118744d.isVisible() && !this.f118744d.I.hasMessages(-1)) {
            this.f118744d.I.sendEmptyMessageAtTime(-1, 0L);
        }
        this.f118743e = 0L;
    }

    public void f() {
        GifDrawable gifDrawable = this.f118744d;
        this.f118743e = gifDrawable.C.x(gifDrawable.f118727m);
    }
}
