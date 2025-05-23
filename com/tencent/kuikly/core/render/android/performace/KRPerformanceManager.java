package com.tencent.kuikly.core.render.android.performace;

import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.e;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k01.KRMemoryData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001\u0017B%\u0012\u0006\u00105\u001a\u00020\u0004\u0012\u0006\u00109\u001a\u000206\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:\u00a2\u0006\u0004\b=\u0010>J%\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010\"\u001a\u00020!J\b\u0010$\u001a\u0004\u0018\u00010#J\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010(\u001a\u0004\u0018\u00010'R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010*R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010,R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00101R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/KRPerformanceManager;", "Lcom/tencent/kuikly/core/render/android/e;", "Lcom/tencent/kuikly/core/render/android/performace/b;", "T", "", "name", "r", "(Ljava/lang/String;)Lcom/tencent/kuikly/core/render/android/performace/b;", "Lcom/tencent/kuikly/core/render/android/performace/a;", "dataCallback", "", "t", "onInit", "l", "j", "f", "k", "i", h.F, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "c", "a", "onResume", "e", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "b", "Lcom/tencent/kuikly/core/render/android/performace/c;", ReportConstant.COSTREPORT_PREFIX, "Lj01/a;", "p", "Lcom/tencent/kuikly/core/render/android/performace/frame/c;", "o", "Lk01/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Ljava/util/List;", "monitors", "Lcom/tencent/kuikly/core/render/android/performace/a;", "", "J", "initTimeStamps", "", "Z", "isColdLaunch", "isPageColdLaunch", "Ljava/lang/String;", "pageName", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "", "Lcom/tencent/kuikly/core/render/android/performace/KRMonitorType;", "monitorTypes", "<init>", "(Ljava/lang/String;Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;Ljava/util/List;)V", UserInfo.SEX_FEMALE, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRPerformanceManager implements e {

    /* renamed from: C, reason: from kotlin metadata */
    private final KuiklyRenderCoreExecuteMode executeMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<b<?>> monitors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a dataCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long initTimeStamps;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isColdLaunch;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPageColdLaunch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String pageName;
    private static boolean D = true;
    private static final List<String> E = new ArrayList();

    public KRPerformanceManager(@NotNull String pageName, @NotNull KuiklyRenderCoreExecuteMode executeMode, @NotNull List<? extends KRMonitorType> monitorTypes) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        Intrinsics.checkNotNullParameter(monitorTypes, "monitorTypes");
        this.pageName = pageName;
        this.executeMode = executeMode;
        this.monitors = new ArrayList();
        Iterator<T> it = monitorTypes.iterator();
        while (it.hasNext()) {
            int i3 = d.f118147a[((KRMonitorType) it.next()).ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.monitors.add(new k01.c());
                    }
                } else {
                    this.monitors.add(new com.tencent.kuikly.core.render.android.performace.frame.d());
                }
            } else {
                List<b<?>> list = this.monitors;
                j01.b bVar = new j01.b();
                bVar.q(new Function1<j01.a, Unit>() { // from class: com.tencent.kuikly.core.render.android.performace.KRPerformanceManager$$special$$inlined$forEach$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(j01.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull j01.a it5) {
                        a aVar;
                        Intrinsics.checkNotNullParameter(it5, "it");
                        aVar = KRPerformanceManager.this.dataCallback;
                        if (aVar != null) {
                            aVar.a(it5);
                        }
                    }
                });
                Unit unit = Unit.INSTANCE;
                list.add(bVar);
            }
        }
        List<String> list2 = E;
        if (!list2.contains(this.pageName)) {
            list2.add(this.pageName);
            this.isPageColdLaunch = true;
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void a() {
        w.f392617a.a("KRPerformanceManager", "--onRenderPageFinish--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void b(@NotNull Throwable throwable, @NotNull ErrorReason errorReason) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
        w.f392617a.a("KRPerformanceManager", "--onRenderException--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b(throwable, errorReason);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void c() {
        w.f392617a.a("KRPerformanceManager", "--onCreatePageStart--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).c();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void d() {
        w.f392617a.a("KRPerformanceManager", "--onRenderInitLayerReadCacheFinish--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).d();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void e() {
        w.f392617a.a("KRPerformanceManager", "--onFirstFramePaint--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).e();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void f() {
        w.f392617a.a("KRPerformanceManager", "--onRenderCoreInitFinish--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).f();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void g() {
        w.f392617a.a("KRPerformanceManager", "--onRenderInitLayerRenderCacheFinish--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).g();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void h() {
        w.f392617a.a("KRPerformanceManager", "--onRenderInitLayerReadCacheStart--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).h();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void i() {
        w.f392617a.a("KRPerformanceManager", "--onRenderContextInitFinish--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).i();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void j() {
        w.f392617a.a("KRPerformanceManager", "--onRenderCoreInitStart--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).j();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void k() {
        w.f392617a.a("KRPerformanceManager", "--onRenderContextInitStart--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).k();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void l() {
        w.f392617a.a("KRPerformanceManager", "--onPreloadDexClassFinish--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).l();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void m() {
        w.f392617a.a("KRPerformanceManager", "--onRenderInitLayerRenderCacheStart--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).m();
        }
    }

    @Nullable
    public final com.tencent.kuikly.core.render.android.performace.frame.c o() {
        com.tencent.kuikly.core.render.android.performace.frame.d dVar = (com.tencent.kuikly.core.render.android.performace.frame.d) r("KRFrameMonitor");
        if (dVar != null) {
            return dVar.getFrameData();
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onDestroy() {
        w.f392617a.a("KRPerformanceManager", "--onDestroy--");
        c s16 = s();
        a aVar = this.dataCallback;
        if (aVar != null) {
            aVar.b(s16);
        }
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onDestroy();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onInit() {
        w.f392617a.a("KRPerformanceManager", "--onInit--");
        this.initTimeStamps = System.currentTimeMillis();
        if (D) {
            this.isColdLaunch = true;
            D = false;
        }
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onInit();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onPause() {
        w.f392617a.a("KRPerformanceManager", "--onPause--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onPause();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onResume() {
        w.f392617a.a("KRPerformanceManager", "--onResume--");
        Iterator<T> it = this.monitors.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onResume();
        }
    }

    @Nullable
    public final j01.a p() {
        j01.b bVar = (j01.b) r("KRLaunchMonitor");
        if (bVar != null) {
            return bVar.s();
        }
        return null;
    }

    @Nullable
    public final KRMemoryData q() {
        k01.c cVar = (k01.c) r("KRMemoryMonitor");
        if (cVar != null) {
            return cVar.r();
        }
        return null;
    }

    @Nullable
    public final <T extends b<?>> T r(@NotNull String name) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = this.monitors.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (Intrinsics.areEqual(((b) obj2).p(), name)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        if (obj2 instanceof b) {
            obj = obj2;
        }
        return (T) obj;
    }

    @NotNull
    public final c s() {
        j01.a p16 = p();
        com.tencent.kuikly.core.render.android.performace.frame.c o16 = o();
        KRMemoryData q16 = q();
        return new c(this.pageName, System.currentTimeMillis() - this.initTimeStamps, this.isColdLaunch, this.isPageColdLaunch, this.executeMode.getMode(), p16, o16, q16);
    }

    public final void t(@NotNull a dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        this.dataCallback = dataCallback;
    }
}
