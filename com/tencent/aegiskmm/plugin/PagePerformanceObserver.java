package com.tencent.aegiskmm.plugin;

import com.tencent.aegiskmm.PerformanceHelper;
import com.tencent.aegiskmm.bean.AegisLogLevel;
import com.tencent.aegiskmm.bean.AegisLogType;
import com.tencent.aegiskmm.bean.NormalLog;
import com.tencent.aegiskmm.bean.g;
import com.tencent.aegiskmm.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.c;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/aegiskmm/plugin/PagePerformanceObserver;", "Lcom/tencent/kuikly/core/pager/c;", "Lcom/tencent/aegiskmm/e;", QCircleWeakNetReporter.KEY_COST, "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "c", "", "pagerEvent", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "eventData", "", "onPagerEvent", "", "a", "I", "maxTime", "Lcom/tencent/aegiskmm/bean/g;", "b", "Lcom/tencent/aegiskmm/bean/g;", "plugin", "", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "resLoadCost", "<init>", "(Lcom/tencent/aegiskmm/bean/g;Ljava/lang/Long;)V", "ElapsedType", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class PagePerformanceObserver implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final g plugin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Long resLoadCost;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aegiskmm/plugin/PagePerformanceObserver$ElapsedType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NATIVE_INIT", "JS_ENGINE_INIT", "RUN_APPLICATION", "FIRST_FRAME", "FP", "FCP", "DOM_CREATE", "CUSTOM_DURATION", "BUNDLE_INDEX_LOAD", "BUNDLE_INDEX_EXECUTE", "BUNDLE_VENDOR_LOAD", "BUNDLE_VENDOR_EXECUTE", "FETCH_CONTEXT", "PAGE_BUILD", "PAGE_LAYOUT", "FIRST_FRAME_ALL", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes37.dex */
    public enum ElapsedType {
        NATIVE_INIT(0),
        JS_ENGINE_INIT(1),
        RUN_APPLICATION(2),
        FIRST_FRAME(3),
        FP(4),
        FCP(5),
        DOM_CREATE(6),
        CUSTOM_DURATION(7),
        BUNDLE_INDEX_LOAD(8),
        BUNDLE_INDEX_EXECUTE(9),
        BUNDLE_VENDOR_LOAD(10),
        BUNDLE_VENDOR_EXECUTE(11),
        FETCH_CONTEXT(12),
        PAGE_BUILD(13),
        PAGE_LAYOUT(14),
        FIRST_FRAME_ALL(15);

        private final int value;

        ElapsedType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public PagePerformanceObserver(g plugin, Long l3) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.plugin = plugin;
        this.resLoadCost = l3;
        this.maxTime = 30000;
    }

    public final com.tencent.kuikly.core.nvi.serialization.json.b c(e cost) {
        Intrinsics.checkNotNullParameter(cost, "cost");
        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.t("elapsedType", ElapsedType.FETCH_CONTEXT.getValue());
        Long l3 = this.resLoadCost;
        long longValue = l3 != null ? l3.longValue() : 0L;
        eVar.u("duration", longValue);
        bVar.t(eVar);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar2.t("elapsedType", ElapsedType.NATIVE_INIT.getValue());
        eVar2.u("duration", cost.getInitRenderContextCost());
        bVar.t(eVar2);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar3.t("elapsedType", ElapsedType.PAGE_BUILD.getValue());
        eVar3.u("duration", cost.getPageBuildCost());
        bVar.t(eVar3);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar4 = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar4.t("elapsedType", ElapsedType.PAGE_LAYOUT.getValue());
        eVar4.u("duration", cost.getPageLayoutCost());
        bVar.t(eVar4);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar5 = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar5.t("elapsedType", ElapsedType.FIRST_FRAME.getValue());
        eVar5.u("duration", cost.getFirstFramePaintCost());
        bVar.t(eVar5);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar6 = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar6.t("elapsedType", ElapsedType.FIRST_FRAME_ALL.getValue());
        eVar6.u("duration", longValue + cost.getFirstFramePaintCost());
        bVar.t(eVar6);
        return bVar;
    }

    /* renamed from: d, reason: from getter */
    public final Long getResLoadCost() {
        return this.resLoadCost;
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onPagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        if (pagerEvent != Pager.PAGER_EVENT_FIRST_FRAME_PAINT) {
            return;
        }
        PerformanceHelper.f61709a.a(new Function1<e, Unit>() { // from class: com.tencent.aegiskmm.plugin.PagePerformanceObserver$onPagerEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e eVar) {
                int i3;
                int i16;
                g gVar;
                int i17;
                if (eVar != null) {
                    long fetchContextCost = eVar.getFetchContextCost();
                    long firstFramePaintCost = eVar.getFirstFramePaintCost();
                    i3 = PagePerformanceObserver.this.maxTime;
                    if (fetchContextCost <= i3) {
                        i16 = PagePerformanceObserver.this.maxTime;
                        if (firstFramePaintCost > i16) {
                            return;
                        }
                        if (PagePerformanceObserver.this.getResLoadCost() != null) {
                            long longValue = PagePerformanceObserver.this.getResLoadCost().longValue();
                            i17 = PagePerformanceObserver.this.maxTime;
                            if (longValue > i17) {
                                KLog.INSTANCE.d("PagePerformance", "onPagerEvent return for err data," + PagePerformanceObserver.this.getResLoadCost());
                                return;
                            }
                        }
                        if (firstFramePaintCost < 0) {
                            return;
                        }
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                        eVar2.v("elapsedTime", PagePerformanceObserver.this.c(eVar));
                        gVar = PagePerformanceObserver.this.plugin;
                        gVar.c().a(new NormalLog("page_performance", AegisLogLevel.REPORT, AegisLogType.PAGE_PERFORMANCE, eVar2));
                    }
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }
}
