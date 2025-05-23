package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$showDebugInfo$1", f = "QNavigationBar.kt", i = {0}, l = {575}, m = "invokeSuspend", n = {"text"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class QNavigationBarViewAttr$showDebugInfo$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public String L$0;
    public int label;
    public final /* synthetic */ QNavigationBarViewAttr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QNavigationBarViewAttr$showDebugInfo$1(QNavigationBarViewAttr qNavigationBarViewAttr, Continuation<? super QNavigationBarViewAttr$showDebugInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = qNavigationBarViewAttr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QNavigationBarViewAttr$showDebugInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((QNavigationBarViewAttr$showDebugInfo$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        Continuation intercepted;
        String str2;
        String str3;
        Object coroutine_suspended2;
        String str4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resVersion=");
            c cVar = c.f117352a;
            sb5.append(PageDataExtKt.getResVersion(cVar.g().getPageData()));
            sb5.append("\nparams=");
            sb5.append(cVar.g().getPageData().n());
            String sb6 = sb5.toString();
            MqqUi ui5 = Mqq.INSTANCE.getUi();
            if (sb6.length() > 700) {
                StringBuilder sb7 = new StringBuilder();
                String substring = sb6.substring(0, 700);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                sb7.append(substring);
                sb7.append(" ...\n[\u4ec5\u5c55\u793a");
                sb7.append(700);
                sb7.append("\u5b57\u7b26]");
                str = sb7.toString();
            } else {
                str = sb6;
            }
            this.L$0 = sb6;
            this.label = 1;
            ui5.getClass();
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            BridgeModule bridgeModule = (BridgeModule) cVar.g().acquireModule("HRBridgeModule");
            Boolean boxBoolean = Boxing.boxBoolean(true);
            if (!boxBoolean.booleanValue()) {
                boxBoolean = null;
            }
            if (boxBoolean != null) {
                boxBoolean.booleanValue();
                str2 = "\u5173\u95ed";
            } else {
                str2 = null;
            }
            Boolean boxBoolean2 = Boxing.boxBoolean(true);
            if (!boxBoolean2.booleanValue()) {
                boxBoolean2 = null;
            }
            if (boxBoolean2 != null) {
                boxBoolean2.booleanValue();
                str3 = "\u590d\u5236\u5168\u90e8\u6587\u672c";
            } else {
                str3 = null;
            }
            bridgeModule.showAlert("\u8c03\u8bd5\u4fe1\u606f", str, str3, str2, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi$showDialog$2$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    Continuation<Integer> continuation = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(eVar2 != null ? Integer.valueOf(eVar2.j("index")) : null));
                    return Unit.INSTANCE;
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
            str4 = sb6;
            obj = orThrow;
        } else if (i3 == 1) {
            str4 = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Integer num = (Integer) obj;
        if (num != null && num.intValue() == 0) {
            Utils.INSTANCE.bridgeModule(this.this$0.getPagerId()).copyToPasteboard(str4);
            Mqq.INSTANCE.getUi().getClass();
            QQKuiklyPlatformApi.Companion.qqToast("\u5df2\u590d\u5236", QToastMode.Success);
        }
        return Unit.INSTANCE;
    }
}
