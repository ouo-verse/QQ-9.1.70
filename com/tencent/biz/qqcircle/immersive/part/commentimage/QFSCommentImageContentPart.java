package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentHintTextEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSCommentOpenPicPanel;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageContentPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "I9", "initData", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "info", "F9", "Lcom/tencent/biz/qqcircle/events/QCircleCommentUpdateEvent;", "event", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "e7", "c8", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "d3", "onSave", "l7", "B6", "Lfeedcloud/FeedCloudMeta$StUser;", QCircleAlphaUserReporter.KEY_USER, "L5", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/e;", "e", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/e;", "contentAdapter", "", "f", "Ljava/util/Set;", "likeResultSet", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "currentInfo", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "i", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "viewModel", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentImageContentPart extends com.tencent.biz.qqcircle.immersive.part.u implements b, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e contentAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> likeResultSet = new LinkedHashSet();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSCommentImageInfo currentInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageContentPart$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            QFSCommentImageContentPart.this.G9().a2(position);
        }
    }

    public QFSCommentImageContentPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSCommentImageViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSCommentImageViewModel invoke() {
                return (QFSCommentImageViewModel) QFSCommentImageContentPart.this.getViewModel(QFSCommentImageViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(QFSCommentImageInfo info) {
        int i3;
        String str;
        PBStringField pBStringField;
        if (info.getStReply() != null) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        int i16 = i3;
        boolean u16 = info.u();
        String str2 = info.getStComment().f398447id.get();
        FeedCloudMeta$StReply stReply = info.getStReply();
        if (stReply != null && (pBStringField = stReply.f398460id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentPraiseUpdateEvent(i16, u16 ? 1 : 0, info.getFeedId(), str2, str, info.n(), hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QFSCommentImageViewModel G9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QFSCommentImageViewModel) value;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H9(QCircleCommentUpdateEvent event) {
        boolean z16;
        boolean isBlank;
        if (event.eventStatus == 3) {
            String str = event.fakeCommentId;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        QFSCommentImageViewModel G9 = G9();
                        String str2 = event.feedId;
                        Intrinsics.checkNotNullExpressionValue(str2, "event.feedId");
                        String str3 = event.fakeCommentId;
                        Intrinsics.checkNotNullExpressionValue(str3, "event.fakeCommentId");
                        G9.c2(str2, str3, event.comment);
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    private final void I9() {
        LiveData<QFSCommentImageInfo> Q1 = G9().Q1();
        QFSBaseFragment hostFragment = getHostFragment();
        final Function1<QFSCommentImageInfo, Unit> function1 = new Function1<QFSCommentImageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentPart$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSCommentImageInfo qFSCommentImageInfo) {
                invoke2(qFSCommentImageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSCommentImageInfo qFSCommentImageInfo) {
                QFSCommentImageContentPart.this.currentInfo = qFSCommentImageInfo;
            }
        };
        Q1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentImageContentPart.J9(Function1.this, obj);
            }
        });
        LiveData<Pair<String, Boolean>> X1 = G9().X1();
        QFSBaseFragment hostFragment2 = getHostFragment();
        final Function1<Pair<? extends String, ? extends Boolean>, Unit> function12 = new Function1<Pair<? extends String, ? extends Boolean>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentPart$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Boolean> pair) {
                invoke2((Pair<String, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
            
                r6 = r5.this$0.contentAdapter;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Pair<String, Boolean> pair) {
                Set set;
                e eVar;
                e eVar2;
                String tag = QFSCommentImageContentPart.this.getTAG();
                String first = pair.getFirst();
                QLog.d(tag, 1, "[initObserver] id=" + ((Object) first) + ", success=" + pair.getSecond());
                set = QFSCommentImageContentPart.this.likeResultSet;
                set.remove(pair.getFirst());
                eVar = QFSCommentImageContentPart.this.contentAdapter;
                QFSCommentImageInfo i06 = eVar != null ? eVar.i0(pair.getFirst()) : null;
                if (!pair.getSecond().booleanValue()) {
                    if (i06 != null && eVar2 != null) {
                        eVar2.k0(i06);
                    }
                    QCircleToast.v(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0);
                    return;
                }
                if (i06 != null) {
                    QFSCommentImageContentPart qFSCommentImageContentPart = QFSCommentImageContentPart.this;
                    i06.d();
                    qFSCommentImageContentPart.F9(i06);
                }
            }
        };
        X1.observe(hostFragment2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentImageContentPart.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        Serializable serializable;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleCommentPicLayerBean) {
            G9().Z1((QCircleCommentPicLayerBean) serializable);
            e eVar = new e(G9().W1(), TransitionAnimUtil.getCoverDrawable());
            this.contentAdapter = eVar;
            eVar.setData(G9().U1());
            e eVar2 = this.contentAdapter;
            if (eVar2 != null) {
                eVar2.p0(this);
            }
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                viewPager2.setAdapter(this.contentAdapter);
            }
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 != null) {
                viewPager22.setCurrentItem(G9().W1(), false);
                return;
            }
            return;
        }
        QLog.w(getTAG(), 1, "[initData] invalid initBean");
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void B6() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void L5(@NotNull FeedCloudMeta$StUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        QLog.d(getTAG(), 1, "[onUserClick] uin=" + user.f398463id);
        if (com.tencent.biz.qqcircle.comment.af.n(user)) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.poster.set(user);
            QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent = new QFSShowPersonalPanelEvent(feedCloudMeta$StFeed, true, getContext().hashCode());
            qFSShowPersonalPanelEvent.setPanelModel(2);
            qFSShowPersonalPanelEvent.setNeedMaskView(true);
            SimpleEventBus.getInstance().dispatchEvent(qFSShowPersonalPanelEvent);
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(user);
        com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void c8() {
        QLog.d(getTAG(), 1, "[onPostImage]");
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentOpenPicPanel(G9().R1()));
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void d3(int clickType) {
        QLog.d(getTAG(), 1, "[onInput]");
        if (!QCircleBindPhoneNumberHelper.a()) {
            QCircleBindPhoneNumberHelper.b(getActivity(), 2);
            QLog.e(getTAG(), 1, "[onInput] no bind phone number");
        } else {
            broadcastMessage("action_show_input_window", Integer.valueOf(clickType));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void e7(@NotNull QFSCommentImageInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.d(getTAG(), 1, "[onLike] id=" + info.l());
        if (this.likeResultSet.contains(info.l())) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.ksw), 0);
        } else {
            this.likeResultSet.add(info.l());
            G9().P1(info);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSCommentHintTextEvent.class, QCircleCommentUpdateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentImageContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewPager2 viewPager2;
        super.onInitView(rootView);
        if (rootView != null) {
            viewPager2 = (ViewPager2) rootView.findViewById(R.id.f3594138);
        } else {
            viewPager2 = null;
        }
        this.viewPager = viewPager2;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new a());
        }
        I9();
        initData();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        String str;
        e eVar;
        if (event instanceof QFSCommentHintTextEvent) {
            String feedId = ((QFSCommentHintTextEvent) event).getFeedId();
            QFSCommentImageInfo qFSCommentImageInfo = this.currentInfo;
            if (qFSCommentImageInfo != null) {
                str = qFSCommentImageInfo.getFeedId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(feedId, str)) {
                QFSCommentImageInfo qFSCommentImageInfo2 = this.currentInfo;
                if (qFSCommentImageInfo2 != null && (eVar = this.contentAdapter) != null) {
                    eVar.j0(qFSCommentImageInfo2);
                    return;
                }
                return;
            }
        }
        if (event instanceof QCircleCommentUpdateEvent) {
            H9((QCircleCommentUpdateEvent) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void l7() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.commentimage.b
    public void onSave() {
    }
}
