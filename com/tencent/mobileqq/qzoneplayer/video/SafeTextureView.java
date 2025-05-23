package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class SafeTextureView extends TextureView {
    public SafeTextureView(Context context) {
        super(context);
    }

    protected void destroyHardwareResources() {
        try {
            super.destroyHardwareResources();
        } catch (Throwable th5) {
            PlayerUtils.log(6, "SafeTextureView destroyHardwareResources", PlayerUtils.getPrintableStackTrace(th5));
            th5.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Exception e16) {
            PlayerUtils.log(6, "SafeTextureView onDetachedFromWindow", PlayerUtils.getPrintableStackTrace(e16));
            e16.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean post(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return super.post(runnable);
        }
        PlayerUtils.runOnUiThread(runnable);
        return true;
    }

    @Override // android.view.View
    public boolean postDelayed(Runnable runnable, long j3) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return super.postDelayed(runnable, j3);
        }
        PlayerUtils.runOnUiThreadDelay(runnable, j3);
        return true;
    }

    public SafeTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
