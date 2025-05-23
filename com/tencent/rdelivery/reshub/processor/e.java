package com.tencent.rdelivery.reshub.processor;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/e;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Ljz3/e;", "newConfig", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lkotlin/Pair;", "", "k", "currentConfig", "", "o", "l", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "errorCode", "", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getPriority", "i", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e extends a {
    private final Pair<Boolean, jz3.e> k(jz3.e newConfig, com.tencent.rdelivery.reshub.core.k req) {
        Object firstOrNull;
        jz3.e eVar;
        jz3.e n3 = req.getConfigMap().n(req.x());
        jz3.e m3 = req.getConfigMap().m(req.x());
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) req.getConfigMap().j(req.x(), newConfig.f411261b));
        Pair pair = (Pair) firstOrNull;
        if (pair != null) {
            eVar = (jz3.e) pair.getSecond();
        } else {
            eVar = null;
        }
        if (l(n3, newConfig, req)) {
            return new Pair<>(Boolean.TRUE, n3);
        }
        if (l(m3, newConfig, req)) {
            return new Pair<>(Boolean.TRUE, m3);
        }
        if (l(eVar, newConfig, req)) {
            return new Pair<>(Boolean.TRUE, eVar);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    private final boolean l(jz3.e currentConfig, jz3.e newConfig, com.tencent.rdelivery.reshub.core.k req) {
        boolean z16;
        if (currentConfig != null && Intrinsics.areEqual(currentConfig.f411260a, newConfig.f411260a) && currentConfig.f411261b == newConfig.f411261b && currentConfig.f411263d == newConfig.f411263d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        boolean b16 = com.tencent.rdelivery.reshub.util.k.b(newConfig, currentConfig, req);
        boolean a16 = com.tencent.rdelivery.reshub.util.k.a(newConfig, currentConfig, req);
        if (z16 && (b16 || a16)) {
            return true;
        }
        return false;
    }

    private final void m(com.tencent.rdelivery.reshub.core.k req, l chain, int errorCode, String errorReason) {
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(errorCode);
        aVar.g(errorReason);
        a.h(this, 1, req, aVar, 0L, 0L, 24, null);
        e(false, 201, req, chain, aVar);
    }

    static /* synthetic */ void n(e eVar, com.tencent.rdelivery.reshub.core.k kVar, l lVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str = null;
        }
        eVar.m(kVar, lVar, i3, str);
    }

    private final void o(jz3.e currentConfig, jz3.e newConfig) {
        if (newConfig != null && currentConfig != null) {
            if (TextUtils.isEmpty(newConfig.G)) {
                newConfig.G = currentConfig.G;
            }
            if (TextUtils.isEmpty(newConfig.H)) {
                newConfig.H = currentConfig.H;
            }
            if (TextUtils.isEmpty(newConfig.J)) {
                newConfig.J = currentConfig.J;
            }
            if (TextUtils.isEmpty(newConfig.I)) {
                newConfig.I = currentConfig.I;
            }
            if (TextUtils.isEmpty(newConfig.K)) {
                newConfig.K = currentConfig.K;
            }
        }
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 300;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            n(this, req, chain, 1004, null, 8, null);
            return;
        }
        Pair<Boolean, String> b16 = com.tencent.rdelivery.reshub.util.j.b(resConfig, req);
        boolean booleanValue = b16.component1().booleanValue();
        String component2 = b16.component2();
        jz3.e resConfig2 = req.getResConfig();
        if (resConfig2 == null) {
            jz3.d.e("ConfigAnalyze", "proceed. resConfig is null");
            n(this, req, chain, 1004, null, 8, null);
            return;
        }
        if (!booleanValue) {
            m(req, chain, 1005, component2);
            return;
        }
        a.h(this, 1, req, null, 0L, 0L, 24, null);
        com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        Pair<Boolean, jz3.e> k3 = k(resConfig2, req);
        if (k3.getFirst().booleanValue()) {
            o(k3.getSecond(), resConfig2);
            jz3.d.a("ConfigAnalyze", "Local Downloaded Res: " + resConfig2.f411260a + " Ver: " + resConfig2.f411261b + ", Ignore Downloading.");
            req.P(resConfig2);
            a.f(this, true, 101, req, chain, null, 16, null);
            cVar.c();
            return;
        }
        cVar.c();
        chain.c(req);
    }
}
