package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.mobileqq.qcoroutine.api.g;
import com.tencent.mobileqq.qcoroutine.api.h;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/g;", "", "b", "(Lcom/tencent/mobileqq/qcoroutine/api/g;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "QCoroutine_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class QTaskPoolKt {
    public static final void a(@NotNull g cancel) {
        Intrinsics.checkNotNullParameter(cancel, "$this$cancel");
        QTaskPool e16 = d.f261833c.e(cancel.e());
        if (e16 != null) {
            e16.a(cancel);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0138 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:13:0x002f, B:14:0x0132, B:16:0x0138, B:17:0x013b, B:19:0x0147, B:21:0x014d, B:33:0x0046, B:34:0x00b1, B:36:0x00bd, B:38:0x00c3, B:39:0x00ce, B:41:0x00d4, B:42:0x00d7, B:44:0x00db, B:46:0x00e1, B:48:0x00ea, B:50:0x00f2, B:53:0x00fd, B:55:0x0106, B:58:0x0111, B:60:0x0117, B:62:0x011d, B:64:0x0125, B:65:0x0129, B:67:0x012f, B:73:0x0098, B:75:0x00a2), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0147 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:13:0x002f, B:14:0x0132, B:16:0x0138, B:17:0x013b, B:19:0x0147, B:21:0x014d, B:33:0x0046, B:34:0x00b1, B:36:0x00bd, B:38:0x00c3, B:39:0x00ce, B:41:0x00d4, B:42:0x00d7, B:44:0x00db, B:46:0x00e1, B:48:0x00ea, B:50:0x00f2, B:53:0x00fd, B:55:0x0106, B:58:0x0111, B:60:0x0117, B:62:0x011d, B:64:0x0125, B:65:0x0129, B:67:0x012f, B:73:0x0098, B:75:0x00a2), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0164 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:13:0x002f, B:14:0x0132, B:16:0x0138, B:17:0x013b, B:19:0x0147, B:21:0x014d, B:33:0x0046, B:34:0x00b1, B:36:0x00bd, B:38:0x00c3, B:39:0x00ce, B:41:0x00d4, B:42:0x00d7, B:44:0x00db, B:46:0x00e1, B:48:0x00ea, B:50:0x00f2, B:53:0x00fd, B:55:0x0106, B:58:0x0111, B:60:0x0117, B:62:0x011d, B:64:0x0125, B:65:0x0129, B:67:0x012f, B:73:0x0098, B:75:0x00a2), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:13:0x002f, B:14:0x0132, B:16:0x0138, B:17:0x013b, B:19:0x0147, B:21:0x014d, B:33:0x0046, B:34:0x00b1, B:36:0x00bd, B:38:0x00c3, B:39:0x00ce, B:41:0x00d4, B:42:0x00d7, B:44:0x00db, B:46:0x00e1, B:48:0x00ea, B:50:0x00f2, B:53:0x00fd, B:55:0x0106, B:58:0x0111, B:60:0x0117, B:62:0x011d, B:64:0x0125, B:65:0x0129, B:67:0x012f, B:73:0x0098, B:75:0x00a2), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0111 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:13:0x002f, B:14:0x0132, B:16:0x0138, B:17:0x013b, B:19:0x0147, B:21:0x014d, B:33:0x0046, B:34:0x00b1, B:36:0x00bd, B:38:0x00c3, B:39:0x00ce, B:41:0x00d4, B:42:0x00d7, B:44:0x00db, B:46:0x00e1, B:48:0x00ea, B:50:0x00f2, B:53:0x00fd, B:55:0x0106, B:58:0x0111, B:60:0x0117, B:62:0x011d, B:64:0x0125, B:65:0x0129, B:67:0x012f, B:73:0x0098, B:75:0x00a2), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object b(@NotNull g gVar, @NotNull Continuation<? super Unit> continuation) {
        QTaskPoolKt$run$1 qTaskPoolKt$run$1;
        Object coroutine_suspended;
        int i3;
        b g16;
        QTaskPool e16;
        com.tencent.mobileqq.qcoroutine.api.a a16;
        Runnable runnable;
        Function1<Continuation<? super Unit>, Object> function1;
        b g17;
        com.tencent.mobileqq.qcoroutine.api.a a17;
        QTaskPool e17;
        b g18;
        try {
            if (continuation instanceof QTaskPoolKt$run$1) {
                qTaskPoolKt$run$1 = (QTaskPoolKt$run$1) continuation;
                int i16 = qTaskPoolKt$run$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    qTaskPoolKt$run$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = qTaskPoolKt$run$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = qTaskPoolKt$run$1.label;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    gVar = (g) qTaskPoolKt$run$1.L$0;
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                gVar = (g) qTaskPoolKt$run$1.L$0;
                            }
                            ResultKt.throwOnFailure(obj);
                            a17 = gVar.a();
                            if (a17 != null) {
                                a17.b();
                            }
                            e17 = d.f261833c.e(gVar.e());
                            if (e17 != null && (g18 = e17.g(gVar)) != null) {
                                g18.k(Boxing.boxLong(System.currentTimeMillis()));
                            }
                            return Unit.INSTANCE;
                        }
                        gVar = (g) qTaskPoolKt$run$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        e.e("QRunnable.run(),type: " + gVar.e().c() + " ,name: " + gVar.d(), null, 2, null);
                        QTaskPool e18 = d.f261833c.e(gVar.e());
                        if (e18 != null && (g16 = e18.g(gVar)) != null) {
                            g16.m(Boxing.boxLong(System.currentTimeMillis()));
                        }
                        if (!gVar.f().get()) {
                            long c16 = gVar.c();
                            qTaskPoolKt$run$1.L$0 = gVar;
                            qTaskPoolKt$run$1.label = 1;
                            if (DelayKt.delay(c16, qTaskPoolKt$run$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    e16 = d.f261833c.e(gVar.e());
                    if (e16 != null && (g17 = e16.g(gVar)) != null) {
                        g17.n(Boxing.boxLong(System.currentTimeMillis()));
                    }
                    a16 = gVar.a();
                    if (a16 != null) {
                        a16.onTaskStart();
                    }
                    if (!(gVar instanceof h)) {
                        if (gVar.b()) {
                            WeakReference<Function1<Continuation<? super Unit>, Object>> o16 = ((h) gVar).o();
                            if (o16 != null && (function1 = o16.get()) != null) {
                                qTaskPoolKt$run$1.L$0 = gVar;
                                qTaskPoolKt$run$1.label = 2;
                                if (function1.invoke(qTaskPoolKt$run$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            Function1<Continuation<? super Unit>, Object> n3 = ((h) gVar).n();
                            if (n3 != null) {
                                qTaskPoolKt$run$1.L$0 = gVar;
                                qTaskPoolKt$run$1.label = 3;
                                if (n3.invoke(qTaskPoolKt$run$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    } else if (gVar.b()) {
                        WeakReference<Runnable> l3 = gVar.l();
                        if (l3 != null && (runnable = l3.get()) != null) {
                            runnable.run();
                        }
                    } else {
                        Runnable k3 = gVar.k();
                        if (k3 != null) {
                            k3.run();
                        }
                    }
                    a17 = gVar.a();
                    if (a17 != null) {
                    }
                    e17 = d.f261833c.e(gVar.e());
                    if (e17 != null) {
                        g18.k(Boxing.boxLong(System.currentTimeMillis()));
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i3 == 0) {
            }
            e16 = d.f261833c.e(gVar.e());
            if (e16 != null) {
                g17.n(Boxing.boxLong(System.currentTimeMillis()));
            }
            a16 = gVar.a();
            if (a16 != null) {
            }
            if (!(gVar instanceof h)) {
            }
            a17 = gVar.a();
            if (a17 != null) {
            }
            e17 = d.f261833c.e(gVar.e());
            if (e17 != null) {
            }
            return Unit.INSTANCE;
        } finally {
            QTaskPool e19 = d.f261833c.e(gVar.e());
            if (e19 != null) {
                e19.d(gVar);
            }
        }
        qTaskPoolKt$run$1 = new QTaskPoolKt$run$1(continuation);
        Object obj2 = qTaskPoolKt$run$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qTaskPoolKt$run$1.label;
    }
}
