package com.tencent.libra.extension;

import android.os.Handler;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.rlottie.AXrLottieDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import r01.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/libra/extension/LibraRLottieAnimateDrawable$frameChangedListener$1", "Lcom/tencent/rlottie/AXrLottieDrawable$c;", "Lcom/tencent/rlottie/AXrLottieDrawable;", "p0", "", "p1", "", "onFrameChanged", "loopNumber", "", "onRepeat", "endAnimation", DKHippyEvent.EVENT_STOP, "onStart", "onRecycle", "libra-extension-rlottie_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraRLottieAnimateDrawable$frameChangedListener$1 implements AXrLottieDrawable.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LibraRLottieAnimateDrawable f118707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LibraRLottieAnimateDrawable$frameChangedListener$1(LibraRLottieAnimateDrawable libraRLottieAnimateDrawable) {
        this.f118707a = libraRLottieAnimateDrawable;
    }

    @Override // com.tencent.rlottie.AXrLottieDrawable.c
    public void onRepeat(final int loopNumber, boolean p16) {
        Handler handler;
        handler = this.f118707a.mUIHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.libra.extension.LibraRLottieAnimateDrawable$frameChangedListener$1$onRepeat$1
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar;
                    dVar = LibraRLottieAnimateDrawable$frameChangedListener$1.this.f118707a.libraAnimationListener;
                    if (dVar != null) {
                        dVar.a(loopNumber);
                    }
                }
            });
        }
    }

    @Override // com.tencent.rlottie.AXrLottieDrawable.c
    public void onStart() {
        Handler handler;
        handler = this.f118707a.mUIHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.libra.extension.LibraRLottieAnimateDrawable$frameChangedListener$1$onStart$1
                @Override // java.lang.Runnable
                public final void run() {
                    Animatable2Compat.AnimationCallback animationCallback;
                    animationCallback = LibraRLottieAnimateDrawable$frameChangedListener$1.this.f118707a.animatableCallback;
                    if (animationCallback != null) {
                        animationCallback.onAnimationStart(LibraRLottieAnimateDrawable$frameChangedListener$1.this.f118707a.getDrawable());
                    }
                }
            });
        }
    }

    @Override // com.tencent.rlottie.AXrLottieDrawable.c
    public void onStop(boolean endAnimation) {
        Handler handler;
        handler = this.f118707a.mUIHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.libra.extension.LibraRLottieAnimateDrawable$frameChangedListener$1$onStop$1
                @Override // java.lang.Runnable
                public final void run() {
                    Animatable2Compat.AnimationCallback animationCallback;
                    animationCallback = LibraRLottieAnimateDrawable$frameChangedListener$1.this.f118707a.animatableCallback;
                    if (animationCallback != null) {
                        animationCallback.onAnimationEnd(LibraRLottieAnimateDrawable$frameChangedListener$1.this.f118707a.getDrawable());
                    }
                }
            });
        }
    }

    @Override // com.tencent.rlottie.AXrLottieDrawable.c
    public void onRecycle() {
    }

    @Override // com.tencent.rlottie.AXrLottieDrawable.c
    public void onFrameChanged(@Nullable AXrLottieDrawable p06, int p16) {
    }
}
