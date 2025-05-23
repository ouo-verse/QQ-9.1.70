package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareDTReportClickEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareDTReportExposureEvent;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginEndEvent;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginPart;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 F2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$0#j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$`%H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R+\u00109\u001a\u0012\u0012\u0004\u0012\u00020\n03j\b\u0012\u0004\u0012\u00020\n`48BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R+\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\n03j\b\u0012\u0004\u0012\u00020\n`48BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/QQStrangerSquareReportPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "G9", "F9", "L9", "M9", "", "", "", "E9", "elementId", "", "params", "", "enableRepeat", "J9", "I9", "H9", "Lkotlin/Function0;", "block", "N9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "onPartPause", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", "", "d", "I", "from", "e", "schemeFrom", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "f", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "reportHelper", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", tl.h.F, "Lkotlin/Lazy;", "D9", "()Ljava/util/HashSet;", "hasInitElementSet", "i", "C9", "hasExposureSet", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isPendingPgInReport", "", BdhLogUtil.LogTag.Tag_Conn, "J", "pgInTime", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSquareReportPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private long pgInTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int schemeFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.matchfriend.utils.d reportHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy hasInitElementSet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy hasExposureSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPendingPgInReport;

    public QQStrangerSquareReportPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<String>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareReportPart$hasInitElementSet$2
            @Override // kotlin.jvm.functions.Function0
            public final HashSet<String> invoke() {
                return new HashSet<>();
            }
        });
        this.hasInitElementSet = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<String>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareReportPart$hasExposureSet$2
            @Override // kotlin.jvm.functions.Function0
            public final HashSet<String> invoke() {
                return new HashSet<>();
            }
        });
        this.hasExposureSet = lazy2;
        this.pgInTime = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<String> C9() {
        return (HashSet) this.hasExposureSet.getValue();
    }

    private final HashSet<String> D9() {
        return (HashSet) this.hasInitElementSet.getValue();
    }

    private final void F9() {
        if (this.isPendingPgInReport) {
            this.isPendingPgInReport = false;
            L9();
        }
    }

    private final void G9() {
        Map<String, Object> E9 = E9();
        View partRootView = getPartRootView();
        if (partRootView != null) {
            VideoReport.setPageId(partRootView, "pg_kl_new_home_page");
            VideoReport.setPageReportPolicy(partRootView, PageReportPolicy.REPORT_NONE);
            VideoReport.setPageParams(partRootView, new PageParams((Map<String, ?>) E9));
        }
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.reportHelper;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportHelper");
            dVar = null;
        }
        dVar.c("pg_kl_new_home_page", E9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(String elementId) {
        if (D9().contains(elementId)) {
            return;
        }
        D9().add(elementId);
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.reportHelper;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportHelper");
            dVar = null;
        }
        dVar.a(elementId, elementId);
    }

    private final void I9(final String elementId, final Map<String, String> params) {
        N9(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareReportPart$reportClickEvent$1
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
                com.tencent.mobileqq.matchfriend.utils.d dVar;
                QQStrangerSquareReportPart.this.H9(elementId);
                dVar = QQStrangerSquareReportPart.this.reportHelper;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reportHelper");
                    dVar = null;
                }
                dVar.e(elementId, params);
            }
        });
    }

    private final void J9(final String elementId, final Map<String, String> params, final boolean enableRepeat) {
        N9(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareReportPart$reportExposureEvent$1
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
                String str;
                com.tencent.mobileqq.matchfriend.utils.d dVar;
                HashSet C9;
                HashSet C92;
                Map<String, String> map = params;
                com.tencent.mobileqq.matchfriend.utils.d dVar2 = null;
                if (map != null) {
                    str = elementId + "-" + map;
                } else {
                    str = null;
                }
                Map<String, String> map2 = params;
                if (!(map2 == null || map2.isEmpty()) && str != null) {
                    if (!enableRepeat) {
                        C92 = this.C9();
                        if (C92.contains(str)) {
                            return;
                        }
                    }
                    C9 = this.C9();
                    C9.add(str);
                }
                this.H9(elementId);
                dVar = this.reportHelper;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reportHelper");
                } else {
                    dVar2 = dVar;
                }
                dVar2.g(elementId, params);
            }
        });
    }

    private final void L9() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            this.pgInTime = SystemClock.elapsedRealtime();
            VideoReport.setPageId(partRootView, "pg_kl_new_home_page");
            Map<String, Object> E9 = E9();
            VideoReport.setPageParams(partRootView, new PageParams((Map<String, ?>) E9));
            VideoReport.reportEvent("dt_pgin", partRootView, E9);
            QLog.d("QQStrangerSquareReportPart", 1, "reportPgIn " + E9);
        }
    }

    private final void M9() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.pgInTime;
            VideoReport.setPageId(partRootView, "pg_kl_new_home_page");
            Map<String, Object> E9 = E9();
            E9.put(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(elapsedRealtime));
            VideoReport.setPageParams(partRootView, new PageParams((Map<String, ?>) E9));
            VideoReport.reportEvent("dt_pgout", partRootView, E9);
            QLog.d("QQStrangerSquareReportPart", 1, "reportPgOut stayTime=" + elapsedRealtime + " " + E9);
        }
    }

    private final void N9(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.t
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerSquareReportPart.O9(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        Intent intent2;
        super.onPartCreate(activity, savedInstanceState);
        int i3 = 0;
        this.from = (activity == null || (intent2 = activity.getIntent()) == null) ? 0 : intent2.getIntExtra("from_intent_key", 0);
        if (activity != null && (intent = activity.getIntent()) != null) {
            i3 = intent.getIntExtra("scheme_from_intent_key", 0);
        }
        this.schemeFrom = i3;
        this.reportHelper = new com.tencent.mobileqq.matchfriend.utils.d(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (QQStrangerLoginPart.INSTANCE.a().get()) {
            L9();
        } else {
            this.isPendingPgInReport = true;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerSquareDTReportExposureEvent) {
            QQStrangerSquareDTReportExposureEvent qQStrangerSquareDTReportExposureEvent = (QQStrangerSquareDTReportExposureEvent) event;
            K9(this, qQStrangerSquareDTReportExposureEvent.getElementId(), qQStrangerSquareDTReportExposureEvent.getParams(), false, 4, null);
        } else if (event instanceof QQStrangerSquareDTReportClickEvent) {
            QQStrangerSquareDTReportClickEvent qQStrangerSquareDTReportClickEvent = (QQStrangerSquareDTReportClickEvent) event;
            I9(qQStrangerSquareDTReportClickEvent.getElementId(), qQStrangerSquareDTReportClickEvent.getParams());
        } else if (event instanceof QQStrangerLoginEndEvent) {
            F9();
        }
    }

    private final Map<String, Object> E9() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("kl_new_from_openid", com.tencent.mobileqq.matchfriend.utils.b.d().j()), TuplesKt.to("kl_new_home_page_from", Integer.valueOf(this.from)), TuplesKt.to("kl_new_home_page_scheme_from_id", Integer.valueOf(this.schemeFrom)));
        return mutableMapOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerSquareDTReportExposureEvent.class, QQStrangerSquareDTReportClickEvent.class, QQStrangerLoginEndEvent.class);
        return arrayListOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void K9(QQStrangerSquareReportPart qQStrangerSquareReportPart, String str, Map map, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        qQStrangerSquareReportPart.J9(str, map, z16);
    }
}
