package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQBridgeApi;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.frequency_control.DebounceKt;
import com.tencent.hippykotlin.demo.pages.vas_base.frequency_control.DebounceKt$debounce$2;
import com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.IntersectionObserver;
import com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.IntersectionObserverEntry;
import com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.Margin;
import com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.ObservableView;
import com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.Options;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.LogKt;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.MemoryTraceStore;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAction;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.StorageTraceStore$setTrace$1;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceInfo;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter.Reporter;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerViewAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerViewEvent;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.event.d;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ScrollerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.apache.httpcore.message.TokenParser;
import zz0.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class BaseVipTrackerView<A extends BaseVipTrackerViewAttr, E extends BaseVipTrackerViewEvent> extends ObservableView<A, E> {
    public static final Companion Companion = new Companion();
    public static final IntersectionObserver observer;
    public final long createdTime = QQBridgeApi.INSTANCE.getBridgeModule().currentTimeStamp();
    public boolean exposed;
    public final List<String> ioPages;
    public final List<String> newExposeMap;
    public final Function1<Float, Unit> onExpose;
    public Reporter reporter;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final void log(String str) {
            VLog.debug$default(LogKt.log, str, false, 2, null);
        }
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(0.5f));
        observer = new IntersectionObserver(new Options(null, Margin.f160default, listOf), new Function2<List<? extends IntersectionObserverEntry>, IntersectionObserver, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$Companion$observer$1
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(List<? extends IntersectionObserverEntry> list, IntersectionObserver intersectionObserver) {
                for (IntersectionObserverEntry intersectionObserverEntry : list) {
                    ObservableView<?, ?> observableView = intersectionObserverEntry.target;
                    if (observableView instanceof BaseVipTrackerView) {
                        ((BaseVipTrackerView) observableView).onExpose.invoke(Float.valueOf(intersectionObserverEntry.intersectionRatio));
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public BaseVipTrackerView() {
        List<String> listOf;
        List<String> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"vas_gxh_shop", "vas_qqvip_root_page", "vas_qq_card_home", "vas_qq_card_subset", "vas_qq_card_ip_collection", "vas_spring_2025_home"});
        this.newExposeMap = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf("vas_new_el_homeland");
        this.ioPages = listOf2;
        this.onExpose = (DebounceKt$debounce$2) DebounceKt.debounce(new Function1<Float, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$onExpose$1
            public final /* synthetic */ BaseVipTrackerView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f16) {
                if (f16.floatValue() >= 0.5f) {
                    BaseVipTrackerView<A, E> baseVipTrackerView = this.this$0;
                    if (!baseVipTrackerView.exposed) {
                        baseVipTrackerView.expose();
                        this.this$0.exposed = true;
                        return Unit.INSTANCE;
                    }
                }
                this.this$0.exposed = false;
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BaseVipTrackerViewAttr access$getAttr(BaseVipTrackerView baseVipTrackerView) {
        return (BaseVipTrackerViewAttr) baseVipTrackerView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void reportAction$default(BaseVipTrackerView baseVipTrackerView, ReportAction reportAction, String str, String str2, String str3, String str4, e eVar, e eVar2, String str5, int i3, Object obj) {
        baseVipTrackerView.reportAction(reportAction, ((BaseVipTrackerViewAttr) baseVipTrackerView.getAttr()).tracker.moduleId, ((BaseVipTrackerViewAttr) baseVipTrackerView.getAttr()).tracker.subModuleId, ((BaseVipTrackerViewAttr) baseVipTrackerView.getAttr()).tracker.itemId, ((BaseVipTrackerViewAttr) baseVipTrackerView.getAttr()).tracker.itemType, ((BaseVipTrackerViewAttr) baseVipTrackerView.getAttr()).tracker.busiInfo, ((BaseVipTrackerViewAttr) baseVipTrackerView.getAttr()).tracker.ruleInfo, ((BaseVipTrackerViewAttr) baseVipTrackerView.getAttr()).tracker.positionId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.tencent.kuikly.core.base.event.Event] */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView<?, ?>>, java.util.ArrayList] */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        String trimIndent;
        super.created();
        if (getReportType() == ReportType.Invalid) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\n                \u4e0a\u62a5\u7c7b\u578b\u975e\u6cd5\uff0c\u5c06\u4e0d\u4f1a\u81ea\u52a8\u66dd\u5149\u548c\u70b9\u51fb\n                \u6307\u5f15\uff1ahttps://iwiki.woa.com/p/4009975714#%E4%B8%8A%E6%8A%A5%E5%A4%B1%E8%B4%A5%E8%87%AA%E6%9F%A5\n                tracker: ");
            m3.append(((BaseVipTrackerViewAttr) getAttr()).tracker);
            m3.append("\n                ");
            trimIndent = StringsKt__IndentKt.trimIndent(m3.toString());
            VLog.debug$default(LogKt.log, trimIndent, false, 2, null);
            Function0<Unit> function0 = new Function0<Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$created$1
                public final /* synthetic */ BaseVipTrackerView<A, E> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    MqqUi ui5 = Mqq.INSTANCE.getUi();
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4e0a\u62a5\u8282\u70b9");
                    m16.append(this.this$0.getNativeRef());
                    m16.append("\u975e\u6cd5\uff01");
                    ui5.showErrorTips(m16.toString());
                    this.this$0.attr(new Function1<BaseVipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$created$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(BaseVipTrackerViewAttr baseVipTrackerViewAttr) {
                            h hVar;
                            BaseVipTrackerViewAttr baseVipTrackerViewAttr2 = baseVipTrackerViewAttr;
                            if (!VasUIToken.INSTANCE.isDarkMode()) {
                                hVar = new h(4294396976L);
                            } else {
                                hVar = new h(4294396976L);
                            }
                            baseVipTrackerViewAttr2.mo113backgroundColor(hVar);
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            };
            if (c.f117352a.g().getPageData().u()) {
                function0.invoke();
                return;
            }
            return;
        }
        if (isPage()) {
            this.reporter = new Reporter(((BaseVipTrackerViewAttr) getAttr()).tracker.appId, ((BaseVipTrackerViewAttr) getAttr()).tracker.pageId, ((BaseVipTrackerViewAttr) getAttr()).tracker.traceInfo);
        }
        if (isItem()) {
            ((BaseVipTrackerViewEvent) getEvent()).reportClickHandler = new Function1<ClickParams, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$created$2
                public final /* synthetic */ BaseVipTrackerView<A, E> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    BaseVipTrackerView.Companion companion = BaseVipTrackerView.Companion;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Item ");
                    m16.append(BaseVipTrackerView.access$getAttr(this.this$0).tracker.itemId);
                    m16.append(" Clicked");
                    companion.log(m16.toString());
                    TrackerHelper trackerHelper = TrackerHelper.INSTANCE;
                    final BaseVipTrackerView<A, E> baseVipTrackerView = this.this$0;
                    Function2<? super Tracker, ? super BaseVipTrackerView<?, ?>, Unit> function2 = new Function2<Tracker, BaseVipTrackerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$created$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Tracker tracker, BaseVipTrackerView<?, ?> baseVipTrackerView2) {
                            final Tracker tracker2 = tracker;
                            BaseVipTrackerView<?, ?> baseVipTrackerView3 = baseVipTrackerView2;
                            Reporter reporter = baseVipTrackerView3.reporter;
                            if (reporter != null) {
                                reporter.reportAction(new ReportAction(BaseVipTrackerView.access$getAttr(baseVipTrackerView).tracker.clickActionId, 0L, 0), tracker2.moduleId, tracker2.subModuleId, tracker2.itemId, tracker2.itemType, tracker2.busiInfo, tracker2.ruleInfo, tracker2.positionId);
                            }
                            Reporter reporter2 = baseVipTrackerView3.reporter;
                            if (reporter2 != null) {
                                tracker2.getClass();
                                e eVar = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.Tracker$buildTraceDetail$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(e eVar2) {
                                        e eVar3 = eVar2;
                                        eVar3.z("appid", Tracker.this.appId);
                                        eVar3.z("page_id", Tracker.this.pageId);
                                        eVar3.z("module_id", Tracker.this.moduleId);
                                        eVar3.z("sub_module_id", Tracker.this.subModuleId);
                                        eVar3.z("item_id", Tracker.this.itemId);
                                        eVar3.z("item_type", Tracker.this.itemType);
                                        eVar3.z("rule_id", Tracker.this.ruleInfo.p("rule_id"));
                                        eVar3.z("str_ruleid", Tracker.this.ruleInfo.p("str_ruleid"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                TraceInfo traceInfo = reporter2.traceInfo;
                                TraceInfo traceInfo2 = new TraceInfo(traceInfo.f114312id, eVar, traceInfo.index, traceInfo.num);
                                if (QQUtils.INSTANCE.compare("9.0.65") >= 0) {
                                    BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new StorageTraceStore$setTrace$1(traceInfo2, null), 3, null);
                                }
                                MemoryTraceStore memoryTraceStore = MemoryTraceStore.INSTANCE;
                                TraceInfo traceInfo3 = reporter2.traceInfo;
                                String str = traceInfo3.f114312id;
                                String str2 = traceInfo3.index;
                                int i3 = traceInfo3.num;
                                memoryTraceStore.getClass();
                                memoryTraceStore.getLocalStorageTrace().f114312id = str;
                                memoryTraceStore.getLocalStorageTrace().detail = eVar;
                                memoryTraceStore.getLocalStorageTrace().index = str2;
                                memoryTraceStore.getLocalStorageTrace().num = i3;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    Tracker tracker = baseVipTrackerView.getTracker();
                    trackerHelper.buildReportTracker(baseVipTrackerView, new Tracker(tracker.appId, tracker.pageId, tracker.moduleId, tracker.subModuleId, tracker.itemId, tracker.itemType, tracker.expose, tracker.busiInfo, tracker.traceInfo, tracker.ruleInfo, tracker.positionId, 0, 2048, null), function2);
                    return Unit.INSTANCE;
                }
            };
        }
        if (!((BaseVipTrackerViewAttr) getAttr()).tracker.expose && !isItem()) {
            if (isPage()) {
                this.onExpose.invoke(Float.valueOf(1.0f));
            }
        } else {
            List<String> list = this.newExposeMap;
            c cVar = c.f117352a;
            if (list.contains(cVar.g().getPageName())) {
                exposeByEvent();
            } else if (this.ioPages.contains(cVar.g().getPageName())) {
                exposeByIO();
            } else {
                int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(((BaseVipTrackerViewAttr) getAttr()).exposeStrategy);
                if (ordinal == 1) {
                    exposeByEvent();
                } else if (ordinal != 2) {
                    VisibilityEventKt.a(getEvent(), new Function1<Float, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$exposeByDefault$1
                        public final /* synthetic */ BaseVipTrackerView<BaseVipTrackerViewAttr, BaseVipTrackerViewEvent> this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Float f16) {
                            this.this$0.onExpose.invoke(Float.valueOf(f16.floatValue()));
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    exposeByIO();
                }
            }
        }
        VisualStructure visualStructure = VisualStructure.INSTANCE;
        if (c.f117352a.g().getPageData().u()) {
            VisualStructure.vtList.add(this);
            ((BaseVipTrackerViewEvent) getViewEvent()).registerEvent("vip-tracker-generate-structure", new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VisualStructure$register$1
                public final /* synthetic */ BaseVipTrackerView<?, ?> $vt;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$vt = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    if (this.$vt.getReportType() != ReportType.Page) {
                        TrackerHelper trackerHelper = TrackerHelper.INSTANCE;
                        final BaseVipTrackerView<?, ?> baseVipTrackerView = this.$vt;
                        trackerHelper.findParentVt(baseVipTrackerView, new Function1<BaseVipTrackerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VisualStructure$register$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView<?, ?>, java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView<?, ?>>>, java.util.Map] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BaseVipTrackerView<?, ?> baseVipTrackerView2) {
                                List mutableListOf;
                                BaseVipTrackerView<?, ?> baseVipTrackerView3 = baseVipTrackerView2;
                                ?? r06 = VisualStructure.localTree;
                                if (!r06.containsKey(baseVipTrackerView3)) {
                                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(baseVipTrackerView);
                                    r06.put(baseVipTrackerView3, mutableListOf);
                                } else {
                                    List list2 = (List) r06.get(baseVipTrackerView3);
                                    if (list2 != null) {
                                        list2.add(baseVipTrackerView);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void expose() {
        String str;
        Integer num = TrackerHelper.exposeActionMap.get(getReportType());
        if (num == null) {
            Companion companion = Companion;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u975e\u6cd5\u4e0a\u62a5\u7c7b\u578b: ");
            m3.append(getReportType());
            m3.append("\uff0c\u4e0d\u8fdb\u884c\u66dd\u5149\u4e0a\u62a5");
            companion.log(m3.toString());
            return;
        }
        ReportAction reportAction = new ReportAction(num.intValue(), a.f453719a.a() - this.createdTime, 0);
        Companion companion2 = Companion;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getReportType().name());
        sb5.append(TokenParser.SP);
        Tracker tracker = ((BaseVipTrackerViewAttr) getAttr()).tracker;
        int ordinal = getReportType().ordinal();
        if (ordinal == 0) {
            str = tracker.pageId;
        } else if (ordinal == 1) {
            str = tracker.moduleId;
        } else if (ordinal == 2) {
            str = tracker.subModuleId;
        } else if (ordinal != 3) {
            str = "";
        } else {
            str = tracker.itemId;
        }
        sb5.append(str);
        sb5.append(" Exposed");
        companion2.log(sb5.toString());
        reportAction$default(this, reportAction, null, null, null, null, null, null, null, 254, null);
        if (isPage()) {
            BuildersKt.e(VasBasePage.Companion.getCtx().getPageScope(), null, null, new BaseVipTrackerView$startMarkStayTimeIfNeed$1(this, null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void exposeByEvent() {
        BaseVipTrackerViewEvent baseVipTrackerViewEvent = (BaseVipTrackerViewEvent) getEvent();
        Function1<Object, Unit> function1 = new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$exposeByEvent$1
            public final /* synthetic */ BaseVipTrackerView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                BaseVipTrackerView<A, E> baseVipTrackerView = this.this$0;
                baseVipTrackerView.exposed = false;
                baseVipTrackerView.onExpose.invoke(Float.valueOf(0.5f));
                return Unit.INSTANCE;
            }
        };
        d pluginEvent = baseVipTrackerViewEvent.getPluginEvent("ExposeEvent");
        if (pluginEvent == null) {
            ExposeEvent exposeEvent = new ExposeEvent(-1, 0.5f, 600, 600L, true, false);
            exposeEvent.init(baseVipTrackerViewEvent.getPagerId(), baseVipTrackerViewEvent.getViewId());
            baseVipTrackerViewEvent.putPluginEvent("ExposeEvent", exposeEvent);
            pluginEvent = exposeEvent;
        }
        pluginEvent.register("expose", function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void exposeByIO() {
        if (((BaseVipTrackerViewAttr) getAttr()).getExposeActive()) {
            observer.observe(this);
        } else {
            bindValueChange(new Function0<Object>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$exposeByIO$1
                public final /* synthetic */ BaseVipTrackerView<A, E> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(BaseVipTrackerView.access$getAttr(this.this$0).getExposeActive());
                }
            }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$exposeByIO$2
                public final /* synthetic */ BaseVipTrackerView<A, E> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    if (BaseVipTrackerView.access$getAttr(this.this$0).getExposeActive()) {
                        BaseVipTrackerView.observer.observe(this.this$0);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BaseVipTrackerView<?, ?> getParentVt() {
        return ((BaseVipTrackerViewAttr) getAttr()).parentVt;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ReportType getReportType() {
        Tracker tracker = ((BaseVipTrackerViewAttr) getAttr()).tracker;
        if (!Intrinsics.areEqual(tracker.appId, "") && !Intrinsics.areEqual(tracker.pageId, "")) {
            return ReportType.Page;
        }
        if (!Intrinsics.areEqual(tracker.moduleId, "")) {
            return ReportType.Module;
        }
        if (!Intrinsics.areEqual(tracker.subModuleId, "")) {
            return ReportType.SubModule;
        }
        if (!Intrinsics.areEqual(tracker.itemId, "")) {
            return ReportType.Item;
        }
        return ReportType.Invalid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Tracker getTracker() {
        return ((BaseVipTrackerViewAttr) getAttr()).tracker;
    }

    public final boolean isItem() {
        return getReportType() == ReportType.Item;
    }

    public final boolean isModule() {
        return getReportType() == ReportType.Module;
    }

    public final boolean isPage() {
        return getReportType() == ReportType.Page;
    }

    public final boolean isSubModule() {
        return getReportType() == ReportType.SubModule;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reportAction(final ReportAction reportAction, String str, String str2, String str3, String str4, e eVar, e eVar2, String str5) {
        ((BaseVipTrackerViewAttr) getAttr()).getClass();
        TrackerHelper.INSTANCE.buildReportTracker(this, new Tracker(null, null, str, str2, str3, str4, false, eVar, null, eVar2, str5, 0, 2371, null), new Function2<Tracker, BaseVipTrackerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView$reportAction$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Tracker tracker, BaseVipTrackerView<?, ?> baseVipTrackerView) {
                Tracker tracker2 = tracker;
                Reporter reporter = baseVipTrackerView.reporter;
                if (reporter != null) {
                    reporter.reportAction(ReportAction.this, tracker2.moduleId, tracker2.subModuleId, tracker2.itemId, tracker2.itemType, tracker2.busiInfo, tracker2.ruleInfo, tracker2.positionId);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        if (isPage()) {
            ReportAction reportAction = new ReportAction(133, ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp() - this.createdTime, ((Number) ((BaseVipTrackerViewAttr) getAttr()).tracker.stayAttr$delegate.getValue()).intValue());
            String str = getTracker().moduleId;
            String str2 = getTracker().subModuleId;
            String str3 = getTracker().itemId;
            String str4 = getTracker().itemType;
            e eVar = getTracker().busiInfo;
            eVar.v("page_exit", "1");
            Unit unit = Unit.INSTANCE;
            reportAction(reportAction, str, str2, str3, str4, eVar, getTracker().ruleInfo, getTracker().positionId);
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerView<?, ?>>, java.util.ArrayList] */
    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void willRemoveFromParentView() {
        super.willRemoveFromParentView();
        VisualStructure visualStructure = VisualStructure.INSTANCE;
        if (c.f117352a.g().getPageData().u()) {
            VisualStructure.vtList.remove(this);
        }
        IntersectionObserver intersectionObserver = observer;
        intersectionObserver.getClass();
        Iterator<T> it = this.scrollers.iterator();
        while (it.hasNext()) {
            ((ScrollerView) it.next()).removeScrollerViewEventObserver(this);
        }
        this.scrollers.clear();
        intersectionObserver.observeItemMap.remove(this);
    }
}
