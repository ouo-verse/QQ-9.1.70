package com.tencent.rdelivery.reshub.core;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.asset.PresetRes;
import com.tencent.rdelivery.reshub.local.LocalResConfigManager;
import com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u0017\u001a\u00020+\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J=\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\b2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ.\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010!\u001a\u00020\fJ,\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u0017\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/ResLoader;", "", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "", "resId", "", "t", "Lcom/tencent/rdelivery/reshub/api/h;", "callback", "g", "v", "", "l", "k", "userCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "loaded", "thenDo", "w", "Ljz3/e;", "localRes", "i", "j", "p", "Lkotlin/Function0;", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "Lkz3/a;", "batchContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "forceRequestRemoteConfig", "o", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Lcom/tencent/rdelivery/reshub/core/i;", "a", "Lcom/tencent/rdelivery/reshub/core/i;", "reshub", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "b", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "Lcom/tencent/rdelivery/reshub/asset/PresetRes;", "c", "Lcom/tencent/rdelivery/reshub/asset/PresetRes;", "presetRes", "<init>", "(Lcom/tencent/rdelivery/reshub/core/i;Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;Lcom/tencent/rdelivery/reshub/asset/PresetRes;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResLoader {

    /* renamed from: a, reason: from kotlin metadata */
    private final i reshub;

    /* renamed from: b, reason: from kotlin metadata */
    private final LocalResConfigManager localRes;

    /* renamed from: c, reason: from kotlin metadata */
    private final PresetRes presetRes;

    public ResLoader(@NotNull i reshub, @NotNull LocalResConfigManager localRes, @NotNull PresetRes presetRes) {
        Intrinsics.checkParameterIsNotNull(reshub, "reshub");
        Intrinsics.checkParameterIsNotNull(localRes, "localRes");
        Intrinsics.checkParameterIsNotNull(presetRes, "presetRes");
        this.reshub = reshub;
        this.localRes = localRes;
        this.presetRes = presetRes;
    }

    public final void g(String resId, final com.tencent.rdelivery.reshub.api.h callback) {
        i iVar = this.reshub;
        com.tencent.rdelivery.reshub.api.g t16 = iVar.t(resId);
        if (!(t16 instanceof jz3.e)) {
            t16 = null;
        }
        final k x16 = i.x(iVar, resId, 5, null, false, (jz3.e) t16, 12, null);
        h(resId, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$doPreloadLatest$1
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
                ResLoader.this.v(x16, callback);
            }
        });
    }

    private final void h(String str, Function0<Unit> function0) {
        this.presetRes.b(str, function0);
    }

    public final void i(k req, jz3.e localRes, com.tencent.rdelivery.reshub.api.h userCallback) {
        if (req.getMode() == 1) {
            s(req.x());
        }
        req.G(localRes);
        k.A(req, true, null, 0L, 6, null);
        if (userCallback != null) {
            ResLoadCallbackUtilKt.f(userCallback, true, localRes, null, 4, null);
        }
    }

    public final boolean j(k req, com.tencent.rdelivery.reshub.api.h userCallback) {
        if (req.getMode() != 5) {
            return false;
        }
        jz3.d.i("ResHubResLoader", "Remote Server Busy and No Local For Res(" + req.x() + "), Preload Fail.");
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(1010);
        k.A(req, false, aVar, 0L, 4, null);
        if (userCallback != null) {
            ResLoadCallbackUtilKt.e(userCallback, false, null, aVar);
            return true;
        }
        return true;
    }

    private final boolean k(k req) {
        jz3.e eVar;
        RDeliveryData z16;
        RDelivery rDelivery = req.getRDelivery();
        if (rDelivery != null && (z16 = RDelivery.z(rDelivery, req.x(), null, true, 2, null)) != null) {
            eVar = lz3.h.b(z16);
        } else {
            eVar = null;
        }
        if (eVar != null && eVar.f411284y == 1) {
            jz3.d.e("ResHubResLoader", "ignoreServerBusy for forceUpdate, config = " + eVar);
            return true;
        }
        return false;
    }

    private final boolean l(k req) {
        if (j.L.g()) {
            return false;
        }
        if (!lz3.a.f415844d.c(req) && !this.reshub.getLoadInterceptManager().c()) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void n(ResLoader resLoader, String str, com.tencent.rdelivery.reshub.api.h hVar, kz3.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        resLoader.m(str, hVar, aVar);
    }

    private final void p(final k req, final Function1<? super jz3.e, Unit> thenDo) {
        ThreadUtil.c(ThreadUtil.f364593c, "LocalResLoad", null, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$loadLocalResAsync$1
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
                thenDo.invoke(k.O(k.this, false, 1, null));
            }
        }, 2, null);
    }

    public static /* synthetic */ void r(ResLoader resLoader, String str, long j3, com.tencent.rdelivery.reshub.api.h hVar, kz3.a aVar, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            aVar = null;
        }
        resLoader.q(str, j3, hVar, aVar);
    }

    private final void s(String str) {
        this.localRes.t(str);
    }

    public final void t(k req, String resId) {
        if (l(req) && !k(req)) {
            jz3.d.i("ResHubResLoader", "Remote Server Busy, Ignore Check Update For Res(" + resId + ").");
            return;
        }
        req.h();
        ResLoadManager.f364407a.b(req, new l(resId));
    }

    public final void v(final k req, final com.tencent.rdelivery.reshub.api.h callback) {
        if (l(req) && !k(req)) {
            w(req, callback, new Function1<Boolean, Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$startLoadAndUseLocalWhenServerBusy$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    boolean j3;
                    if (!z16) {
                        j3 = ResLoader.this.j(req, callback);
                        if (j3) {
                            return;
                        }
                        jz3.d.i("ResHubResLoader", "Remote Server Busy, But No Local For Res(" + req.x() + "), Retry Load...");
                        ResLoadManager.f364407a.b(req, callback);
                        return;
                    }
                    jz3.d.i("ResHubResLoader", "Remote Server Busy, Use Local For Res(" + req.x() + ") Success.");
                }
            });
        } else {
            ResLoadManager.f364407a.b(req, callback);
        }
    }

    public final void w(final k req, final com.tencent.rdelivery.reshub.api.h userCallback, final Function1<? super Boolean, Unit> thenDo) {
        p(req, new Function1<jz3.e, Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$tryLoadByLocal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(jz3.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable jz3.e eVar) {
                boolean z16 = eVar != null;
                if (z16) {
                    ResLoader.this.i(req, eVar, userCallback);
                }
                thenDo.invoke(Boolean.valueOf(z16));
            }
        });
    }

    public final void m(@NotNull final String resId, @Nullable final com.tencent.rdelivery.reshub.api.h hVar, @Nullable kz3.a aVar) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        i iVar = this.reshub;
        com.tencent.rdelivery.reshub.api.g t16 = iVar.t(resId);
        if (!(t16 instanceof jz3.e)) {
            t16 = null;
        }
        final k x16 = i.x(iVar, resId, 1, aVar, false, (jz3.e) t16, 8, null);
        h(resId, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$load$1
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
                ResLoader.this.w(x16, hVar, new Function1<Boolean, Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$load$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        if (z16) {
                            ResLoader$load$1 resLoader$load$1 = ResLoader$load$1.this;
                            ResLoader.this.t(x16, resId);
                        } else {
                            ResLoadManager resLoadManager = ResLoadManager.f364407a;
                            ResLoader$load$1 resLoader$load$12 = ResLoader$load$1.this;
                            resLoadManager.b(x16, hVar);
                        }
                    }
                });
            }
        });
    }

    public final void o(@NotNull String resId, @Nullable final com.tencent.rdelivery.reshub.api.h callback, @Nullable kz3.a batchContext, boolean forceRequestRemoteConfig) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        i iVar = this.reshub;
        com.tencent.rdelivery.reshub.api.g t16 = iVar.t(resId);
        if (!(t16 instanceof jz3.e)) {
            t16 = null;
        }
        final k w3 = iVar.w(resId, 2, batchContext, forceRequestRemoteConfig, (jz3.e) t16);
        h(resId, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$loadLatest$1
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
                ResLoader.this.v(w3, callback);
            }
        });
    }

    public final void q(@NotNull String resId, long j3, @Nullable final com.tencent.rdelivery.reshub.api.h hVar, @Nullable kz3.a aVar) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        final k x16 = i.x(this.reshub, resId, 4, aVar, false, null, 24, null);
        x16.M(j3);
        h(resId, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$loadSpecific$1
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
                ResLoader.this.v(x16, hVar);
            }
        });
    }

    public final void u(@NotNull final String resId, @Nullable final com.tencent.rdelivery.reshub.api.h callback) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.reshub.getLoadInterceptManager().b(resId, callback, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoader$preloadLatest$1
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
                ResLoader.this.g(resId, callback);
            }
        });
    }
}
