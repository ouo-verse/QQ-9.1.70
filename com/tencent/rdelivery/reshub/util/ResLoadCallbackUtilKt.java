package com.tencent.rdelivery.reshub.util;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rdelivery.reshub.api.n;
import com.tencent.rdelivery.reshub.api.p;
import com.tencent.rdelivery.reshub.report.ReportHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a&\u0010\r\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\u0014\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a(\u0010\u0012\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u001c\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u001a\u001c\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u001a\u001a\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/h;", "", "status", "", "progress", "", "g", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "e", "j", "k", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "i", "inMainThread", "Lkotlin/Function0;", "action", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "inWhat", DomainData.DOMAIN_NAME, "exceptionMsg", "l", tl.h.F, "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResLoadCallbackUtilKt {
    public static final void e(@NotNull final com.tencent.rdelivery.reshub.api.h doUserCompleteCallback, final boolean z16, @Nullable final com.tencent.rdelivery.reshub.api.g gVar, @NotNull final com.tencent.rdelivery.reshub.report.a errorInfo) {
        Intrinsics.checkParameterIsNotNull(doUserCompleteCallback, "$this$doUserCompleteCallback");
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        m(com.tencent.rdelivery.reshub.core.j.L.P(), new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt$doUserCompleteCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ResLoadCallbackUtilKt.i(com.tencent.rdelivery.reshub.api.h.this, z16, gVar, com.tencent.rdelivery.reshub.report.b.b(errorInfo));
            }
        });
    }

    public static /* synthetic */ void f(com.tencent.rdelivery.reshub.api.h hVar, boolean z16, com.tencent.rdelivery.reshub.api.g gVar, com.tencent.rdelivery.reshub.report.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = com.tencent.rdelivery.reshub.report.b.a();
        }
        e(hVar, z16, gVar, aVar);
    }

    public static final void g(@NotNull final com.tencent.rdelivery.reshub.api.h doUserProgressCallback, final int i3, final float f16) {
        Intrinsics.checkParameterIsNotNull(doUserProgressCallback, "$this$doUserProgressCallback");
        m(com.tencent.rdelivery.reshub.core.j.L.T(), new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt$doUserProgressCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean h16;
                h16 = ResLoadCallbackUtilKt.h(i3);
                if (!h16) {
                    ResLoadCallbackUtilKt.k(com.tencent.rdelivery.reshub.api.h.this, i3);
                }
                ResLoadCallbackUtilKt.j(com.tencent.rdelivery.reshub.api.h.this, f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(int i3) {
        if (i3 != 6 && i3 != 3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(@NotNull final com.tencent.rdelivery.reshub.api.h hVar, final boolean z16, final com.tencent.rdelivery.reshub.api.g gVar, final n nVar) {
        n("onComplete(" + z16 + ')', new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt$performComplete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.rdelivery.reshub.api.h.this.onComplete(z16, gVar, nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(@NotNull final com.tencent.rdelivery.reshub.api.h hVar, final float f16) {
        n("onProgress(" + f16 + ')', new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt$performProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.rdelivery.reshub.api.h.this.onProgress(f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(@NotNull final com.tencent.rdelivery.reshub.api.h hVar, final int i3) {
        n("onStatusUpdate(" + i3 + ')', new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt$performStatusUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.rdelivery.reshub.api.h hVar2 = com.tencent.rdelivery.reshub.api.h.this;
                if (!(hVar2 instanceof p)) {
                    hVar2 = null;
                }
                p pVar = (p) hVar2;
                if (pVar != null) {
                    pVar.a(i3);
                }
            }
        });
    }

    private static final void l(String str, String str2) {
        jz3.d.c("ResLoadCallback", "User Callback Exception in " + str + MsgSummary.STR_COLON + str2);
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(10003);
        aVar.g("in " + str + ", " + str2);
        new ReportHelper().b(aVar);
    }

    public static final void m(boolean z16, @NotNull final Function0<Unit> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        if (z16) {
            ThreadUtil.f364593c.e(new Runnable() { // from class: com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt$runUserCallback$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function0.this.invoke();
                }
            });
        } else {
            action.invoke();
        }
    }

    public static final void n(@NotNull String inWhat, @NotNull Function0<Unit> action) {
        Object m476constructorimpl;
        String str;
        Intrinsics.checkParameterIsNotNull(inWhat, "inWhat");
        Intrinsics.checkParameterIsNotNull(action, "action");
        try {
            Result.Companion companion = Result.INSTANCE;
            action.invoke();
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            str = m479exceptionOrNullimpl.getMessage();
        } else {
            str = null;
        }
        if (str != null) {
            l(inWhat, str);
        }
    }
}
