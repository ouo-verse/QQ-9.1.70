package com.tencent.mobileqq.zplan.emoticon.panel.adapter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.zplan.aio.panel.page.ActionPage;
import com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapter;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.AioPanelLayout;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager;
import com.tencent.mobileqq.zplan.emoticon.tab.model.ZPlanEmoticonAvatarIconStatus;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.StateFlow;
import le3.ApiPanelEventHandler;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002FGBO\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010?\u001a\u00020\u0013\u0012\u0006\u0010@\u001a\u00020\u0013\u0012\u0006\u0010A\u001a\u00020\u0013\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010)\u001a\u00020#\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u0002H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J,\u0010%\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u001eH\u0016R\u0014\u0010)\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter2;", "Lcom/tencent/mobileqq/emoticonview/BaseEmotionAdapter;", "", "friendUin", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lle3/b;", "actionConfig", "Lkotlinx/coroutines/Deferred;", "r", "sceneConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/zplan/aio/panel/page/ActionPage;", "page", "", "t", "", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView;", "listView", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/AioPanelLayout;", "panelLayout", DomainData.DOMAIN_NAME, "currentView", "setCurrentListView", "getCount", "Lcom/tencent/mobileqq/emoticonview/BaseEmotionAdapter$ViewHolder;", "holder", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getEmotionView", "newHolder", "d", "Landroid/view/ViewGroup;", "aioRoot", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "e", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonPanelLifecycleObserver;", "f", "Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonPanelLifecycleObserver;", "observer", h.F, "Landroid/view/View;", "placeholderView", "Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService;", "i", "Lkotlin/Lazy;", "p", "()Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService;", "messageService", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "app", "Landroid/content/Context;", "context", "columnNum", "panelType", VasReportUtils.BUSINESS_TYPE_EMOTION, "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "callback", "<init>", "(Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;Landroid/content/Context;IIILcom/tencent/mobileqq/emoticonview/EmoticonCallback;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonPanelLifecycleObserver;)V", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonAdapter2 extends BaseEmotionAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup aioRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final SessionInfo sessionInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ZPlanEmoticonPanelLifecycleObserver observer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View placeholderView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy messageService;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter2$b;", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView$PullAndFastScrollListener;", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "p0", "", "followHand", "", "isPanelOpen", "onPullUp", "onPullDown", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/AioPanelLayout;", "d", "Ljava/lang/ref/WeakReference;", "aioPanel", "e", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView$PullAndFastScrollListener;", "originListener", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView$PullAndFastScrollListener;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements EmotionPanelListView.PullAndFastScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<AioPanelLayout> aioPanel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final EmotionPanelListView.PullAndFastScrollListener originListener;

        public b(WeakReference<AioPanelLayout> aioPanel, EmotionPanelListView.PullAndFastScrollListener originListener) {
            Intrinsics.checkNotNullParameter(aioPanel, "aioPanel");
            Intrinsics.checkNotNullParameter(originListener, "originListener");
            this.aioPanel = aioPanel;
            this.originListener = originListener;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
        public void followHand(MotionEvent p06) {
            this.originListener.followHand(p06);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
        public boolean isPanelOpen() {
            return this.originListener.isPanelOpen();
        }

        @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener, com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
        public void onPullDown() {
            QLog.i(BaseEmotionAdapter.TAG, 1, "onPullDown");
            AioPanelLayout aioPanelLayout = this.aioPanel.get();
            if (aioPanelLayout == null || aioPanelLayout.c()) {
                this.originListener.onPullDown();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
        public void onPullUp() {
            this.originListener.onPullUp();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonAdapter2(IEmoticonMainPanelApp app, Context context, int i3, int i16, int i17, EmoticonCallback callback, ViewGroup aioRoot, SessionInfo sessionInfo, ZPlanEmoticonPanelLifecycleObserver observer) {
        super(app, context, i3, i16, i17, callback);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(aioRoot, "aioRoot");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.aioRoot = aioRoot;
        this.sessionInfo = sessionInfo;
        this.observer = observer;
        this.placeholderView = new View(context);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanMsgService>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$messageService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanMsgService invoke() {
                return (IZPlanMsgService) QRoute.api(IZPlanMsgService.class);
            }
        });
        this.messageService = lazy;
    }

    private final List<Integer> m(String str) {
        List split$default;
        int collectionSizeOrDefault;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        return arrayList2;
    }

    private final void n(EmotionPanelListView listView, AioPanelLayout panelLayout) {
        if (listView.getOnScrollListener() instanceof EmoticonPanelOnScrollListener) {
            WeakReference weakReference = new WeakReference(panelLayout);
            EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener = listView.getPullAndFastScrollListener();
            Intrinsics.checkNotNullExpressionValue(pullAndFastScrollListener, "listView.pullAndFastScrollListener");
            b bVar = new b(weakReference, pullAndFastScrollListener);
            this.currentView.setPullAndFastScrollListener(bVar);
            EmotionPanelListView emotionPanelListView = this.currentView;
            emotionPanelListView.setOnScrollListener(new EmoticonPanelOnScrollListener(emotionPanelListView, bVar, null));
        }
    }

    private final List<Integer> o() {
        QLog.i(BaseEmotionAdapter.TAG, 1, "getHasIdListFromMMKV");
        return m(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_key_has_id_list_mmkv", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IZPlanMsgService p() {
        return (IZPlanMsgService) this.messageService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(String friendUin) {
        QRouteApi api = QRoute.api(IZPlanShowGuideApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanShowGuideApi::class.java)");
        IZPlanShowGuideApi iZPlanShowGuideApi = (IZPlanShowGuideApi) api;
        if (!iZPlanShowGuideApi.onNeedShowDialog(friendUin)) {
            return false;
        }
        iZPlanShowGuideApi.onShowDialog(3, friendUin);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(ActionPage page) {
        List<Integer> o16 = o();
        if (o16.isEmpty()) {
            QLog.i(BaseEmotionAdapter.TAG, 1, "updateItemHas hasList empty");
            return;
        }
        int i3 = 0;
        for (Object obj : page.c()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.zplan.aio.panel.item.b bVar = (com.tencent.mobileqq.zplan.aio.panel.item.b) obj;
            if (o16.contains(Integer.valueOf(bVar.getId()))) {
                bVar.q(true);
                Page.b selectFunction = page.getSelectFunction();
                if (selectFunction != null) {
                    selectFunction.T(i3);
                }
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        return 1;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder holder, int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.placeholderView;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        return new BaseEmotionAdapter.ViewHolder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Boolean> q(CoroutineScope scope, le3.b sceneConfig) {
        Deferred<Boolean> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(scope, null, null, new ZPlanEmoticonAdapter2$handleChangeScene$1(this, sceneConfig, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Boolean> r(CoroutineScope scope, le3.b actionConfig) {
        Deferred<Boolean> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(scope, null, null, new ZPlanEmoticonAdapter2$handleClickAction$1(this, actionConfig, null), 3, null);
        return async$default;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void setCurrentListView(EmotionPanelListView currentView) {
        Object d16;
        List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> listOfNotNull;
        super.setCurrentListView(currentView);
        ViewParent parent = currentView != null ? currentView.getParent() : null;
        AioPanelLayout aioPanelLayout = parent instanceof AioPanelLayout ? (AioPanelLayout) parent : null;
        if (aioPanelLayout == null) {
            return;
        }
        WeakReference weakReference = new WeakReference(aioPanelLayout);
        synchronized (aioPanelLayout) {
            d16 = ZPlanEmoticonAdapter2Kt.d(aioPanelLayout);
            if (Intrinsics.areEqual(d16, this.observer)) {
                return;
            }
            ZPlanEmoticonAdapter2Kt.h(aioPanelLayout, this.observer);
            Unit unit = Unit.INSTANCE;
            final LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.observer);
            final Context context = currentView.getContext();
            Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>> function2 = new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$handler$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Deferred<Boolean> invoke(CoroutineScope scope, le3.b config) {
                    Deferred<Boolean> r16;
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    Intrinsics.checkNotNullParameter(config, "config");
                    r16 = ZPlanEmoticonAdapter2.this.r(scope, config);
                    return r16;
                }
            };
            Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>> function22 = new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$handler$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Deferred<Boolean> invoke(CoroutineScope scope, le3.b config) {
                    Deferred<Boolean> q16;
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    Intrinsics.checkNotNullParameter(config, "config");
                    q16 = ZPlanEmoticonAdapter2.this.q(scope, config);
                    return q16;
                }
            };
            ZPlanEmoticonAdapter2$setCurrentListView$handler$3 zPlanEmoticonAdapter2$setCurrentListView$handler$3 = new ZPlanEmoticonAdapter2$setCurrentListView$handler$3(this, null);
            ZPlanEmoticonAdapter2$setCurrentListView$handler$4 zPlanEmoticonAdapter2$setCurrentListView$handler$4 = new ZPlanEmoticonAdapter2$setCurrentListView$handler$4(context);
            ZPlanEmoticonAdapter2$setCurrentListView$handler$5 zPlanEmoticonAdapter2$setCurrentListView$handler$5 = new Function1<View.OnClickListener, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$handler$5
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View.OnClickListener it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View.OnClickListener onClickListener) {
                    invoke2(onClickListener);
                    return Unit.INSTANCE;
                }
            };
            String str = this.sessionInfo.f179557e;
            Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
            final ApiPanelEventHandler apiPanelEventHandler = new ApiPanelEventHandler(function2, function22, zPlanEmoticonAdapter2$setCurrentListView$handler$3, zPlanEmoticonAdapter2$setCurrentListView$handler$4, zPlanEmoticonAdapter2$setCurrentListView$handler$5, str, new Function1<View.OnClickListener, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$handler$6
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View.OnClickListener it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View.OnClickListener onClickListener) {
                    invoke2(onClickListener);
                    return Unit.INSTANCE;
                }
            });
            boolean a16 = xh3.a.f448008a.a();
            com.tencent.mobileqq.zplan.aio.panel.panel.a[] aVarArr = new com.tencent.mobileqq.zplan.aio.panel.panel.a[3];
            Intrinsics.checkNotNullExpressionValue(context, "context");
            aVarArr[0] = new EmoticonPageBuilder(lifecycleScope, context, new Function0<ZPlanEmoticonAdapter>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$builders$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ZPlanEmoticonAdapter invoke() {
                    IEmoticonMainPanelApp iEmoticonMainPanelApp;
                    int i3;
                    int i16;
                    int i17;
                    EmoticonCallback emoticonCallback;
                    ViewGroup viewGroup;
                    SessionInfo sessionInfo;
                    iEmoticonMainPanelApp = ((BaseEmotionAdapter) ZPlanEmoticonAdapter2.this).app;
                    Context context2 = context;
                    i3 = ((BaseEmotionAdapter) ZPlanEmoticonAdapter2.this).columnNum;
                    i16 = ((BaseEmotionAdapter) ZPlanEmoticonAdapter2.this).panelType;
                    i17 = ((BaseEmotionAdapter) ZPlanEmoticonAdapter2.this).emotionType;
                    emoticonCallback = ((BaseEmotionAdapter) ZPlanEmoticonAdapter2.this).callback;
                    viewGroup = ZPlanEmoticonAdapter2.this.aioRoot;
                    sessionInfo = ZPlanEmoticonAdapter2.this.sessionInfo;
                    return new ZPlanEmoticonAdapter(iEmoticonMainPanelApp, context2, i3, i16, i17, emoticonCallback, viewGroup, sessionInfo, lifecycleScope);
                }
            });
            PageView.Theme.Companion companion = PageView.Theme.INSTANCE;
            aVarArr[1] = new ActionPageBuilder(lifecycleScope, context, companion.a(), apiPanelEventHandler.d(), new Function1<CoroutineScope, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$builders$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Deferred<Boolean> invoke(CoroutineScope it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ApiPanelEventHandler.this.c().invoke();
                    return CompletableDeferredKt.CompletableDeferred(Boolean.TRUE);
                }
            });
            aVarArr[2] = !a16 ? new ScenePageBuilder(lifecycleScope, context, companion.a(), apiPanelEventHandler.b(), apiPanelEventHandler.e(), apiPanelEventHandler.getFriendUin()) : null;
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) aVarArr);
            boolean z16 = ZPlanEmoticonTabAvatarManager.f333345a.D(false) != ZPlanEmoticonAvatarIconStatus.AvatarIconWithShaking;
            Panel.Companion companion2 = Panel.INSTANCE;
            Context context2 = currentView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "currentView.context");
            final StateFlow<Panel> g16 = companion2.g(lifecycleScope, context2, listOfNotNull, z16, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$source$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String emoticonNextOpenPage = ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).getEmoticonNextOpenPage();
                    return (emoticonNextOpenPage == null || emoticonNextOpenPage.length() == 0) ^ true ? "2" : "1";
                }
            });
            this.observer.getLifecycle().addObserver(new ZPlanEmoticonAdapter2$setCurrentListView$2(g16, this, aioPanelLayout, weakReference));
            PanelAdapter panelAdapter = new PanelAdapter(lifecycleScope, g16, listOfNotNull);
            aioPanelLayout.setDataSource(g16);
            aioPanelLayout.getViewPager().setAdapter(panelAdapter);
            new com.google.android.material.tabs.d(aioPanelLayout.getTabLayout(), aioPanelLayout.getViewPager(), aioPanelLayout.getTabConfigurationStrategy()).a();
            CorountineFunKt.e(lifecycleScope, "zplan_ZPlanEmotionAdapter2_\u76d1\u542c\u8868\u60c5\u66f4\u65b0", null, null, null, new ZPlanEmoticonAdapter2$setCurrentListView$3(g16, panelAdapter, null), 14, null);
            final WeakReference weakReference2 = new WeakReference(aioPanelLayout);
            this.observer.s(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str2) {
                    AioPanelLayout aioPanelLayout2 = weakReference2.get();
                    if (aioPanelLayout2 != null) {
                        ZPlanEmoticonAdapter2Kt.f(aioPanelLayout2, str2);
                    }
                    for (Page page : g16.getValue().b()) {
                        if (page instanceof ActionPage) {
                            this.t((ActionPage) page);
                        }
                    }
                }
            });
            ZPlanEmoticonAdapter2Kt.g(aioPanelLayout, null, 1, null);
            n(currentView, aioPanelLayout);
        }
    }
}
