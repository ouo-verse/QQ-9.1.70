package com.tencent.hippykotlin.demo.pages.foundation.lib.mqq;

import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.p;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MqqUi {
    public static void openUrl$default(MqqUi mqqUi, String str) {
        mqqUi.getClass();
        QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), str, false, 4);
    }

    public final void openKuikly(String str, e eVar) {
        p.c((p) c.f117352a.g().acquireModule("KRRouterModule"), str, eVar, null, 4, null);
    }

    public final void popBack() {
        QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        qQKuiklyPlatformApi.closePage(false);
    }

    public final Object screenShot(int i3, Continuation<? super screenShotResult> continuation) {
        Continuation intercepted;
        Object valueOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        c cVar = c.f117352a;
        QQUIModule qQUIModule = (QQUIModule) cVar.g().acquireModule("QQUIModule");
        e eVar = new e();
        if (k.a(cVar)) {
            valueOf = Boxing.boxInt(i3);
        } else {
            valueOf = String.valueOf(i3);
        }
        eVar.v("rootViewId", valueOf);
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi$screenShot$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                int j3 = eVar3 != null ? eVar3.j("retCode") : -1;
                String p16 = eVar3 != null ? eVar3.p("imgPath") : null;
                Continuation<screenShotResult> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(new screenShotResult(j3, p16)));
                return Unit.INSTANCE;
            }
        };
        qQUIModule.getClass();
        qQUIModule.toNative(false, "screenShot", eVar.toString(), function1, false);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void showErrorTips(String str) {
        QQKuiklyPlatformApi.Companion.qqToast(str, QToastMode.Warning);
    }

    public final void showInfoTips(String str) {
        QQKuiklyPlatformApi.Companion.qqToast(str, QToastMode.Info);
    }

    public final void showTips$enumunboxing$(String str, int i3) {
        QToastMode qToastMode;
        if (i3 != 0) {
            int i16 = i3 - 1;
            if (i16 == 0) {
                qToastMode = QToastMode.Info;
            } else if (i16 == 1) {
                qToastMode = QToastMode.Success;
            } else if (i16 == 2) {
                qToastMode = QToastMode.Warning;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            QQKuiklyPlatformApi.Companion.qqToast(str, qToastMode);
            return;
        }
        throw null;
    }
}
