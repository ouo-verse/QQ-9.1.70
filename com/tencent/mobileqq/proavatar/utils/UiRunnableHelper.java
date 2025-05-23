package com.tencent.mobileqq.proavatar.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/UiRunnableHelper;", "", "", "d", "", "g", "()Z", "Lkotlin/Function0;", "block", "j", "(Lkotlin/jvm/functions/Function0;)V", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "", "c", "J", "lastTime", "", "Ljava/lang/ref/SoftReference;", "Ljava/util/List;", "blockList", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "delayRunnable", "f", "Lkotlin/Lazy;", "functionSwitchValue", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class UiRunnableHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final UiRunnableHelper f259710a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReentrantLock lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<SoftReference<Function0<Unit>>> blockList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Runnable delayRunnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy functionSwitchValue;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33976);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f259710a = new UiRunnableHelper();
        lock = new ReentrantLock();
        blockList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(UiRunnableHelper$functionSwitchValue$2.INSTANCE);
        functionSwitchValue = lazy;
    }

    UiRunnableHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (delayRunnable == null) {
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.proavatar.utils.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        UiRunnableHelper.e();
                    }
                };
                if (!ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 100L)) {
                    QLog.e("UiRunnableHelper", 1, "createAndPostDelayRunnableIfNeeded postDelay failed ");
                }
                delayRunnable = runnable;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<SoftReference<Function0<Unit>>> it = blockList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Function0<Unit> function0 = it.next().get();
                if (function0 != null) {
                    arrayList.add(function0);
                } else {
                    i3++;
                }
            }
            blockList.clear();
            delayRunnable = null;
            if (i3 > 0) {
                QLog.e("UiRunnableHelper", 1, "createAndPostDelayRunnableIfNeeded size: " + arrayList.size() + " nullSize:" + i3);
            } else {
                QLog.d("UiRunnableHelper", 4, "createAndPostDelayRunnableIfNeeded size: " + arrayList.size());
            }
            reentrantLock.unlock();
            if (QLog.isDevelopLevel()) {
                QLog.i("UiRunnableHelper", 4, "createAndPostDelayRunnableIfNeeded size: " + arrayList.size());
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ((Function0) it5.next()).invoke();
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("UiRunnableHelper", 4, "createAndPostDelayRunnableIfNeeded size: " + arrayList.size() + " end");
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    private final boolean f() {
        return ((Boolean) functionSwitchValue.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return f();
    }

    public final void j(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (lastTime <= 0) {
                lastTime = System.currentTimeMillis();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.utils.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        UiRunnableHelper.h(Function0.this);
                    }
                });
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - lastTime < 100) {
                    blockList.add(new SoftReference<>(block));
                    f259710a.d();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.utils.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            UiRunnableHelper.i(Function0.this);
                        }
                    });
                }
                lastTime = currentTimeMillis;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
