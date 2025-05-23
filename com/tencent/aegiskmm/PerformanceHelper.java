package com.tencent.aegiskmm;

import com.tencent.kuikly.core.module.LaunchData;
import com.tencent.kuikly.core.module.PerformanceModule;
import com.tencent.kuikly.core.module.m;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\t\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aegiskmm/PerformanceHelper;", "", "Lkotlin/Function1;", "Lcom/tencent/aegiskmm/e;", "Lkotlin/ParameterName;", "name", QCircleWeakNetReporter.KEY_COST, "", "resultAction", "a", "<init>", "()V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class PerformanceHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final PerformanceHelper f61709a = new PerformanceHelper();

    PerformanceHelper() {
    }

    public final void a(final Function1<? super e, Unit> resultAction) {
        Intrinsics.checkNotNullParameter(resultAction, "resultAction");
        ((PerformanceModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRPerformanceModule")).a(new Function1<m, Unit>() { // from class: com.tencent.aegiskmm.PerformanceHelper$getLaunchCost$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                invoke2(mVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m mVar) {
                LaunchData pageLoadTime;
                a aVar = a.f61726d;
                com.tencent.aegiskmm.utils.a b16 = aVar.b();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getLaunchCost, PerformanceData: ");
                e eVar = null;
                sb5.append(mVar != null ? mVar.getPageLoadTime() : null);
                b16.d("KA", sb5.toString());
                if (mVar != null && (pageLoadTime = mVar.getPageLoadTime()) != null) {
                    eVar = new e(0L, pageLoadTime.getInitRenderContextCost(), pageLoadTime.getPageBuildCost(), pageLoadTime.getPageLayoutCost(), pageLoadTime.getFirstPaintCost(), pageLoadTime.getFirstPaintCost());
                }
                aVar.b().d("KA", "getLaunchCost, launchCost: " + eVar);
                Function1.this.invoke(eVar);
            }
        });
    }
}
