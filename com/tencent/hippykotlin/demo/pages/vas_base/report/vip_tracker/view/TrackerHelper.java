package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class TrackerHelper {
    public static final TrackerHelper INSTANCE = new TrackerHelper();
    public static final Map<ReportType, Integer> exposeActionMap;

    static {
        Map<ReportType, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ReportType.Page, 100), TuplesKt.to(ReportType.Module, 111), TuplesKt.to(ReportType.SubModule, 112), TuplesKt.to(ReportType.Item, 101));
        exposeActionMap = mapOf;
    }

    public final Tracker buildReportTracker(final BaseVipTrackerView<?, ?> baseVipTrackerView, final Tracker tracker, final Function2<? super Tracker, ? super BaseVipTrackerView<?, ?>, Unit> function2) {
        e eVar = baseVipTrackerView.getTracker().busiInfo;
        e eVar2 = tracker.busiInfo;
        e eVar3 = new e();
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            eVar3.v(next, eVar.e(next));
        }
        Iterator<String> c17 = eVar2.c();
        while (c17.hasNext()) {
            String next2 = c17.next();
            eVar3.v(next2, eVar2.e(next2));
        }
        tracker.busiInfo = eVar3;
        int ordinal = baseVipTrackerView.getReportType().ordinal();
        if (ordinal == 0) {
            tracker.appId = baseVipTrackerView.getTracker().appId;
            tracker.pageId = baseVipTrackerView.getTracker().pageId;
            if (function2 != null) {
                function2.invoke(tracker, baseVipTrackerView);
            }
            return tracker;
        }
        if (ordinal == 1) {
            findParentVt(baseVipTrackerView, new Function1<BaseVipTrackerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.TrackerHelper$buildReportTracker$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(BaseVipTrackerView<?, ?> baseVipTrackerView2) {
                    BaseVipTrackerView<?, ?> baseVipTrackerView3 = baseVipTrackerView2;
                    if (baseVipTrackerView3.isPage()) {
                        Tracker.this.moduleId = baseVipTrackerView.getTracker().moduleId;
                        TrackerHelper.INSTANCE.buildReportTracker(baseVipTrackerView3, Tracker.this, function2);
                    }
                    return Unit.INSTANCE;
                }
            });
            return tracker;
        }
        if (ordinal == 2) {
            findParentVt(baseVipTrackerView, new Function1<BaseVipTrackerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.TrackerHelper$buildReportTracker$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(BaseVipTrackerView<?, ?> baseVipTrackerView2) {
                    BaseVipTrackerView<?, ?> baseVipTrackerView3 = baseVipTrackerView2;
                    if (baseVipTrackerView3.isModule()) {
                        Tracker.this.subModuleId = baseVipTrackerView.getTracker().subModuleId;
                        TrackerHelper.INSTANCE.buildReportTracker(baseVipTrackerView3, Tracker.this, function2);
                    }
                    return Unit.INSTANCE;
                }
            });
            return tracker;
        }
        if (ordinal == 3) {
            findParentVt(baseVipTrackerView, new Function1<BaseVipTrackerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.TrackerHelper$buildReportTracker$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(BaseVipTrackerView<?, ?> baseVipTrackerView2) {
                    BaseVipTrackerView<?, ?> baseVipTrackerView3 = baseVipTrackerView2;
                    if (baseVipTrackerView3.isModule() || baseVipTrackerView3.isSubModule()) {
                        Tracker.this.itemId = baseVipTrackerView.getTracker().itemId;
                        Tracker.this.itemType = baseVipTrackerView.getTracker().itemType;
                        Tracker.this.positionId = baseVipTrackerView.getTracker().positionId;
                        Tracker.this.ruleInfo = baseVipTrackerView.getTracker().ruleInfo;
                        TrackerHelper.INSTANCE.buildReportTracker(baseVipTrackerView3, Tracker.this, function2);
                    }
                    return Unit.INSTANCE;
                }
            });
            return tracker;
        }
        if (ordinal == 4) {
            return tracker;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BaseVipTrackerView<?, ?> findParentVt(BaseVipTrackerView<?, ?> baseVipTrackerView, Function1<? super BaseVipTrackerView<?, ?>, Unit> function1) {
        if (baseVipTrackerView.getParentVt() != null) {
            BaseVipTrackerView<?, ?> parentVt = baseVipTrackerView.getParentVt();
            if (parentVt != null) {
                function1.invoke(parentVt);
            }
            return baseVipTrackerView.getParentVt();
        }
        ViewContainer<?, ?> parent = baseVipTrackerView.getParent();
        while (true) {
            if (parent == null) {
                break;
            }
            if (parent instanceof BaseVipTrackerView) {
                A viewAttr = parent.getViewAttr();
                Intrinsics.checkNotNull(viewAttr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerViewAttr");
                ((BaseVipTrackerViewAttr) viewAttr).getClass();
                if (baseVipTrackerView.isItem()) {
                    BaseVipTrackerView baseVipTrackerView2 = (BaseVipTrackerView) parent;
                    if (baseVipTrackerView2.isSubModule() || baseVipTrackerView2.isModule()) {
                        break;
                    }
                }
                if (baseVipTrackerView.isSubModule() && ((BaseVipTrackerView) parent).isModule()) {
                    function1.invoke(parent);
                    break;
                }
                if (baseVipTrackerView.isModule() && ((BaseVipTrackerView) parent).isPage()) {
                    function1.invoke(parent);
                    break;
                }
            }
            parent = parent.getParent();
        }
        function1.invoke(parent);
        BaseVipTrackerView<?, ?> baseVipTrackerView3 = parent instanceof BaseVipTrackerView ? (BaseVipTrackerView) parent : null;
        ((BaseVipTrackerViewAttr) baseVipTrackerView.getViewAttr()).getClass();
        return baseVipTrackerView3;
    }
}
