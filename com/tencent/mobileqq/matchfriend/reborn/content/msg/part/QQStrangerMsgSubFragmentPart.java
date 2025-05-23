package com.tencent.mobileqq.matchfriend.reborn.content.msg.part;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerMsgAppBarExpendEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerMsgScrollToTopEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.QQStrangerMsgSubFragmentInfo;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.QQStrangerMsgSubFragmentType;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.QQStrangerPageTabBar;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"H\u0016R!\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/QQStrangerMsgSubFragmentPart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initView", "G9", "I9", "", "K9", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/api/IQQStrangerInteractiveMarkService;", "service", "C9", "L9", "N9", "", "position", "M9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerMsgSubFragmentType;", "type", "", "", "E9", "expend", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartResume", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/b;", "e", "Lkotlin/Lazy;", "F9", "()Ljava/util/List;", "subFragmentInfoList", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "f", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "reportHelper", "Landroidx/viewpager2/widget/ViewPager2;", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerPageTabBar;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerPageTabBar;", "pageTabBar", "Lcom/google/android/material/appbar/AppBarLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/a;", "adapter", "Ljava/util/concurrent/atomic/AtomicBoolean;", "D", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReportExp", "<init>", "()V", "E", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgSubFragmentPart extends a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.a adapter;

    /* renamed from: D, reason: from kotlin metadata */
    private final AtomicBoolean hasReportExp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy subFragmentInfoList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.matchfriend.utils.d reportHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewPager2;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQStrangerPageTabBar pageTabBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AppBarLayout appBarLayout;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244731a;

        static {
            int[] iArr = new int[QQStrangerMsgSubFragmentType.values().length];
            try {
                iArr[QQStrangerMsgSubFragmentType.OFTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QQStrangerMsgSubFragmentType.MSG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f244731a = iArr;
        }
    }

    public QQStrangerMsgSubFragmentPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<QQStrangerMsgSubFragmentInfo>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.part.QQStrangerMsgSubFragmentPart$subFragmentInfoList$2
            @Override // kotlin.jvm.functions.Function0
            public final List<QQStrangerMsgSubFragmentInfo> invoke() {
                List<QQStrangerMsgSubFragmentInfo> mutableListOf;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QQStrangerMsgSubFragmentInfo(QQStrangerMsgSubFragmentType.MSG, "\u5168\u90e8", null, 4, null));
                return mutableListOf;
            }
        });
        this.subFragmentInfoList = lazy;
        this.hasReportExp = new AtomicBoolean(false);
    }

    private final boolean C9(IQQStrangerInteractiveMarkService service) {
        if (!K9()) {
            QLog.i("QQStrangerMsgSubFragmentPart", 1, "[canShowOftenChatTab] is not ExpGroup.");
            return false;
        }
        if (com.tencent.mobileqq.matchfriend.reborn.utils.h.f245480a.g()) {
            QLog.i("QQStrangerMsgSubFragmentPart", 1, "[canShowOftenChatTab] hasOftenChatGuideShow.");
            return true;
        }
        List<RecentContactInfo> f16 = QQStrangerRecentContactHelper.f244865a.f();
        ArrayList arrayList = new ArrayList();
        for (Object obj : f16) {
            String str = ((RecentContactInfo) obj).peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "it.peerUid");
            if (service.canShownInOftenChatTab(104, str)) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        QLog.i("QQStrangerMsgSubFragmentPart", 1, "[canShowOftenChatTab] count=" + size);
        return size >= 3;
    }

    private final void D9(boolean expend) {
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(expend, true);
        }
    }

    private final Map<String, String> E9(QQStrangerMsgSubFragmentType type) {
        String str;
        Map<String, String> mapOf;
        int i3 = b.f244731a[type.ordinal()];
        if (i3 == 1) {
            str = "often";
        } else if (i3 == 2) {
            str = "all";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, str));
        return mapOf;
    }

    private final List<QQStrangerMsgSubFragmentInfo> F9() {
        return (List) this.subFragmentInfoList.getValue();
    }

    private final void G9() {
        int collectionSizeOrDefault;
        List<QQStrangerMsgSubFragmentInfo> mutableList;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IQQStrangerInteractiveMarkService iQQStrangerInteractiveMarkService = (IQQStrangerInteractiveMarkService) (appInterface != null ? appInterface.getRuntimeService(IQQStrangerInteractiveMarkService.class, "") : null);
        if (iQQStrangerInteractiveMarkService != null) {
            if (C9(iQQStrangerInteractiveMarkService)) {
                F9().add(new QQStrangerMsgSubFragmentInfo(QQStrangerMsgSubFragmentType.OFTEN, "\u5e38\u804a", null, 4, null));
            }
            com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.a aVar = this.adapter;
            if (aVar != null) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) F9());
                aVar.i0(mutableList);
            }
            int size = F9().size();
            QLog.i("QQStrangerMsgSubFragmentPart", 1, "[initSubFragments] subFragmentSize=" + size);
            if (size <= 1) {
                QQStrangerPageTabBar qQStrangerPageTabBar = this.pageTabBar;
                if (qQStrangerPageTabBar != null) {
                    qQStrangerPageTabBar.setVisibility(8);
                }
            } else {
                QQStrangerPageTabBar qQStrangerPageTabBar2 = this.pageTabBar;
                if (qQStrangerPageTabBar2 != null) {
                    qQStrangerPageTabBar2.setVisibility(0);
                }
                QQStrangerPageTabBar qQStrangerPageTabBar3 = this.pageTabBar;
                if (qQStrangerPageTabBar3 != null) {
                    List<QQStrangerMsgSubFragmentInfo> F9 = F9();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(F9, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = F9.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((QQStrangerMsgSubFragmentInfo) it.next()).getName());
                    }
                    Object[] array = arrayList.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    qQStrangerPageTabBar3.setTabData((String[]) array);
                }
                QQStrangerPageTabBar qQStrangerPageTabBar4 = this.pageTabBar;
                if (qQStrangerPageTabBar4 != null) {
                    qQStrangerPageTabBar4.bindViewPager2(this.viewPager2);
                }
                I9();
            }
            N9();
            QQStrangerPageTabBar qQStrangerPageTabBar5 = this.pageTabBar;
            if (qQStrangerPageTabBar5 != null) {
                qQStrangerPageTabBar5.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.part.c
                    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
                    public final void I0(int i3, boolean z16) {
                        QQStrangerMsgSubFragmentPart.H9(QQStrangerMsgSubFragmentPart.this, i3, z16);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(QQStrangerMsgSubFragmentPart this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9(i3);
    }

    private final void I9() {
        QQStrangerPageTabBar qQStrangerPageTabBar;
        if (com.tencent.mobileqq.matchfriend.reborn.utils.h.f245480a.g() || (qQStrangerPageTabBar = this.pageTabBar) == null) {
            return;
        }
        qQStrangerPageTabBar.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.part.d
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerMsgSubFragmentPart.J9(QQStrangerMsgSubFragmentPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QQStrangerMsgSubFragmentPart this$0) {
        View a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQStrangerPageTabBar qQStrangerPageTabBar = this$0.pageTabBar;
        if (qQStrangerPageTabBar == null || (a16 = qQStrangerPageTabBar.a(1)) == null) {
            return;
        }
        QUIDefaultBubbleTip.r(this$0.getActivity()).S(a16).R(0).k0(3).o0("\u5e38\u804a\u7684\u597d\u53cb\u90fd\u5728\u8fd9\u91cc").m0(3).s0();
        com.tencent.mobileqq.matchfriend.reborn.utils.h.f245480a.o();
    }

    private final boolean K9() {
        L9();
        return ABTestController.getInstance().getExpEntity("exp_jieban_changliao_tab_new").isExperiment("exp_jieban_changliao_tab_new_B");
    }

    private final void L9() {
        if (this.hasReportExp.getAndSet(true)) {
            return;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_jieban_changliao_tab_new");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(EXP_NAME)");
        expEntity.reportExpExposure();
    }

    private final void M9(int position) {
        Object orNull;
        com.tencent.mobileqq.matchfriend.utils.d dVar;
        orNull = CollectionsKt___CollectionsKt.getOrNull(F9(), position);
        QQStrangerMsgSubFragmentInfo qQStrangerMsgSubFragmentInfo = (QQStrangerMsgSubFragmentInfo) orNull;
        if (qQStrangerMsgSubFragmentInfo == null || (dVar = this.reportHelper) == null) {
            return;
        }
        dVar.e(qQStrangerMsgSubFragmentInfo.getType().toString(), E9(qQStrangerMsgSubFragmentInfo.getType()));
    }

    private final void N9() {
        for (QQStrangerMsgSubFragmentInfo qQStrangerMsgSubFragmentInfo : F9()) {
            String obj = qQStrangerMsgSubFragmentInfo.getType().toString();
            com.tencent.mobileqq.matchfriend.utils.d dVar = this.reportHelper;
            if (dVar != null) {
                dVar.a(obj, "em_kl_tab");
            }
            com.tencent.mobileqq.matchfriend.utils.d dVar2 = this.reportHelper;
            if (dVar2 != null) {
                dVar2.g(obj, E9(qQStrangerMsgSubFragmentInfo.getType()));
            }
        }
    }

    private final void initView() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        ViewPager2 viewPager2 = (ViewPager2) getPartRootView().findViewById(R.id.osg);
        this.viewPager2 = viewPager2;
        if (viewPager2 != null) {
            viewPager2.setUserInputEnabled(false);
        }
        this.appBarLayout = (AppBarLayout) getPartRootView().findViewById(R.id.f163140oi4);
        com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.a aVar = new com.tencent.mobileqq.matchfriend.reborn.content.msg.tab.a(hostFragment);
        this.adapter = aVar;
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 != null) {
            viewPager22.setAdapter(aVar);
        }
        this.pageTabBar = (QQStrangerPageTabBar) getPartRootView().findViewById(R.id.omw);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQStrangerMsgScrollToTopEvent.class);
        arrayList.add(QQStrangerMsgAppBarExpendEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Map<String, Object> mapOf;
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e("QQStrangerMsgSubFragmentPart", 1, "onInitView root is null.");
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        initView();
        com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(rootView.getContext());
        String selfOpenId = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId();
        if (selfOpenId == null) {
            selfOpenId = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(selfOpenId, "QRoute.api(IMatchFriendC\u2026ss.java).selfOpenId ?: \"\"");
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_new_from_openid", selfOpenId));
        dVar.c("pg_kl_new_chat_list", mapOf);
        this.reportHelper = dVar;
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.a, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        Object partHost = getPartHost();
        Fragment fragment = partHost instanceof Fragment ? (Fragment) partHost : null;
        if ((fragment != null ? fragment.isHidden() : false) || F9().size() >= 2) {
            return;
        }
        G9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerMsgScrollToTopEvent) {
            D9(true);
        } else if (event instanceof QQStrangerMsgAppBarExpendEvent) {
            D9(((QQStrangerMsgAppBarExpendEvent) event).getExpended());
        }
    }
}
