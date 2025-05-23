package com.tencent.mobileqq.app.message.messageclean;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bR\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R.\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00178\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/k;", "", "", "d", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "key", "Lcom/tencent/mobileqq/app/message/messageclean/z;", "loadingListener", "", "e", "i", "g", "", "timeout", "c", "b", "f", "Z", "isComplete", "isTimeout", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "animator", "", "Ljava/util/Map;", "getListenerMap$AQQLiteModule_release", "()Ljava/util/Map;", "setListenerMap$AQQLiteModule_release", "(Ljava/util/Map;)V", "listenerMap", "", "I", "halfDuration", "D", "completeBottomNum", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f196233a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isComplete;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isTimeout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ValueAnimator animator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<ad, z> listenerMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int halfDuration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static double completeBottomNum;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f196233a = new k();
        listenerMap = new LinkedHashMap();
        halfDuration = 3;
        completeBottomNum = 15.0d;
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final double d() {
        return Math.pow(0.5d, 1 / halfDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Ref.DoubleRef startPow, double d16, long j3, Ref.DoubleRef curProgress, Ref.LongRef startEndTime, Ref.DoubleRef startX, Ref.DoubleRef startY, Ref.DoubleRef startProgress, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(startPow, "$startPow");
        Intrinsics.checkNotNullParameter(curProgress, "$curProgress");
        Intrinsics.checkNotNullParameter(startEndTime, "$startEndTime");
        Intrinsics.checkNotNullParameter(startX, "$startX");
        Intrinsics.checkNotNullParameter(startY, "$startY");
        Intrinsics.checkNotNullParameter(startProgress, "$startProgress");
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!isComplete) {
            double pow = Math.pow(d16, (uptimeMillis - j3) / 1000);
            startPow.element = pow;
            curProgress.element = Math.min(1 - pow, 0.9999d);
            startEndTime.element = uptimeMillis;
        } else {
            if (startX.element < 0.0d) {
                double log = Math.log(((-startPow.element) * Math.log(d16)) / Math.log(completeBottomNum)) / Math.log(completeBottomNum);
                startX.element = log;
                double d17 = 1;
                startY.element = Math.pow(completeBottomNum, log) - d17;
                startProgress.element = d17 - startPow.element;
            }
            curProgress.element = ((Math.pow(completeBottomNum, ((uptimeMillis - startEndTime.element) / 1000) + startX.element) - 1) - startY.element) + startProgress.element;
        }
        float min = Math.min((float) (curProgress.element * 100), 99.99f);
        Iterator<T> it = listenerMap.values().iterator();
        while (it.hasNext()) {
            ((z) it.next()).onProgressUpdate(min);
        }
        if (curProgress.element >= 1.0d) {
            f196233a.b();
            Iterator<T> it5 = listenerMap.values().iterator();
            while (it5.hasNext()) {
                ((z) it5.next()).a(isTimeout);
            }
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        animator = null;
    }

    public final void c(boolean timeout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, timeout);
        } else {
            isComplete = true;
            isTimeout = timeout;
        }
    }

    public final void e(@NotNull ad key, @NotNull z loadingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) key, (Object) loadingListener);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(loadingListener, "loadingListener");
        listenerMap.put(key, loadingListener);
        QLog.d("FakeLoadingHelper", 1, "registerLoadingListener key: " + key + ", value: " + loadingListener + ", size: " + listenerMap.size());
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        b();
        isComplete = false;
        isTimeout = false;
        listenerMap.clear();
    }

    public final void g() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        QLog.d("FakeLoadingHelper", 1, "startLoading");
        Iterator<T> it = listenerMap.values().iterator();
        while (it.hasNext()) {
            ((z) it.next()).onLoadStart();
        }
        isComplete = false;
        isTimeout = false;
        final long uptimeMillis = SystemClock.uptimeMillis();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = uptimeMillis;
        final double d16 = d();
        final Ref.DoubleRef doubleRef = new Ref.DoubleRef();
        ValueAnimator valueAnimator2 = animator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setRepeatCount(-1);
        animator = ofFloat;
        final Ref.DoubleRef doubleRef2 = new Ref.DoubleRef();
        doubleRef2.element = -1.0d;
        final Ref.DoubleRef doubleRef3 = new Ref.DoubleRef();
        final Ref.DoubleRef doubleRef4 = new Ref.DoubleRef();
        final Ref.DoubleRef doubleRef5 = new Ref.DoubleRef();
        ValueAnimator valueAnimator3 = animator;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.app.message.messageclean.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                k.h(Ref.DoubleRef.this, d16, uptimeMillis, doubleRef5, longRef, doubleRef2, doubleRef3, doubleRef4, valueAnimator4);
            }
        });
        ValueAnimator valueAnimator4 = animator;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.start();
    }

    public final void i(@NotNull ad key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) key);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.d("FakeLoadingHelper", 1, "unregisterLoadingListener key: " + key + ", value: " + listenerMap.get(key) + ", size: " + listenerMap.size());
        listenerMap.remove(key);
        int size = listenerMap.size();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unregisterLoadingListener, size: ");
        sb5.append(size);
        QLog.d("FakeLoadingHelper", 1, sb5.toString());
    }
}
