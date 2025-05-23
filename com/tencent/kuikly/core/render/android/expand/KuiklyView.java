package com.tencent.kuikly.core.render.android.expand;

import android.widget.FrameLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.expand.a;
import com.tencent.kuikly.core.render.android.performace.KRMonitorType;
import com.tencent.kuikly.core.render.android.performace.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001bH\u0016J \u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000bH\u0016J\"\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u000bH\u0016R\u0016\u0010'\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/KuiklyView;", "Landroid/widget/FrameLayout;", "", "Lcom/tencent/kuikly/core/render/android/expand/a;", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "registerExternalRenderView", "registerExternalModule", "Ff", "registerViewExternalPropHandler", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "C2", "", "Lcom/tencent/kuikly/core/render/android/performace/KRMonitorType;", "ec", "p9", "Sa", "", "h4", "ng", "", "Re", "()Ljava/lang/Integer;", "Lj01/a;", "data", "pg", "Lcom/tencent/kuikly/core/render/android/performace/c;", "le", "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "executeMode", "Ia", "isSucceed", "onPageLoadComplete", "d", "Lcom/tencent/kuikly/core/render/android/expand/a;", "delegate", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class KuiklyView extends FrameLayout implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a delegate;

    @Override // com.tencent.kuikly.core.render.android.expand.a
    @NotNull
    public KuiklyRenderCoreExecuteMode C2() {
        KuiklyRenderCoreExecuteMode C2;
        a aVar = this.delegate;
        if (aVar == null || (C2 = aVar.C2()) == null) {
            return a.C5872a.a(this);
        }
        return C2;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean Cc() {
        return a.C5872a.b(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ff(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.q(this, kuiklyRenderExport);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.Ff(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ia(@NotNull Throwable throwable, @NotNull ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        a.C5872a.m(this, throwable, errorReason, executeMode);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.Ia(throwable, errorReason, executeMode);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    @Nullable
    /* renamed from: K0 */
    public Long getEmbedSceneSyncTimeout() {
        return a.C5872a.t(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    /* renamed from: M0 */
    public boolean getUseHostDisplayMetrics() {
        return a.C5872a.w(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    @Nullable
    public Map<String, Object> O1() {
        return a.C5872a.d(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    @Nullable
    public Integer Re() {
        Integer Re;
        a aVar = this.delegate;
        if (aVar == null || (Re = aVar.Re()) == null) {
            return a.C5872a.s(this);
        }
        return Re;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Sa() {
        a.C5872a.i(this);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.Sa();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    @Nullable
    public String V0() {
        return a.C5872a.v(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean c1() {
        return a.C5872a.f(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    @NotNull
    public List<KRMonitorType> ec() {
        List<KRMonitorType> ec5;
        a aVar = this.delegate;
        if (aVar == null || (ec5 = aVar.ec()) == null) {
            return a.C5872a.n(this);
        }
        return ec5;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean h4() {
        a aVar = this.delegate;
        if (aVar != null) {
            return aVar.h4();
        }
        return a.C5872a.u(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void le(@NotNull c data) {
        Intrinsics.checkNotNullParameter(data, "data");
        a.C5872a.h(this, data);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.le(data);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean ng() {
        a aVar = this.delegate;
        if (aVar != null) {
            return aVar.ng();
        }
        return a.C5872a.c(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        a.C5872a.k(this, isSucceed, errorReason, executeMode);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.onPageLoadComplete(isSucceed, errorReason, executeMode);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void p9() {
        a.C5872a.j(this);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.p9();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void pg(@NotNull j01.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        a.C5872a.g(this, data);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.pg(data);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalModule(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.o(this, kuiklyRenderExport);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.registerExternalModule(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalRenderView(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.p(this, kuiklyRenderExport);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.registerExternalRenderView(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerViewExternalPropHandler(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.r(this, kuiklyRenderExport);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.registerViewExternalPropHandler(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean u0() {
        return a.C5872a.e(this);
    }
}
