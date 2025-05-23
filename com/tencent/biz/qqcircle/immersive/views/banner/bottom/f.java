package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.an;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001IB\u000f\u0012\u0006\u0010E\u001a\u00020D\u00a2\u0006\u0004\bF\u0010GJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0007H\u0014J\b\u0010!\u001a\u00020\u0007H\u0014J\u0012\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&`'H\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00100R\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010*R\u0018\u00103\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010*R\u0018\u00104\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010*R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00106R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\u0016R\u0016\u0010C\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\u000b\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/f;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/qqcircle/events/QFSRecPicStateEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", BdhLogUtil.LogTag.Tag_Conn, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "E", HippyTKDListViewAdapter.X, "Lcom/tencent/biz/qqcircle/immersive/feed/event/an;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, UserInfo.SEX_FEMALE, "G", "H", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "y", "J", "B", "g", "isElementCanActivate", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "f", "onElementActivated", "onElementInactivated", "", "getPriority", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "v", NodeProps.ON_CLICK, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "D", "Landroid/view/View;", "containerLayout", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tipTv", "redPoint", "infoView", "topInfoView", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "showGuideRunnable", "K", "Z", "canShowGuide", "", "L", "Ljava/lang/String;", "mLastFeedId", "", "M", "permissionFeedGuideVideoProcess", "N", "permissionFeedGuideFeedPosLimit", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "P", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f extends c implements View.OnClickListener, SimpleEventReceiver<QFSRecPicStateEvent> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View containerLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView iconIv;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView tipTv;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View redPoint;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View infoView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View topInfoView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Runnable showGuideRunnable;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean canShowGuide;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String mLastFeedId;

    /* renamed from: M, reason: from kotlin metadata */
    private long permissionFeedGuideVideoProcess;

    /* renamed from: N, reason: from kotlin metadata */
    private int permissionFeedGuideFeedPosLimit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/f$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            View view = f.this.infoView;
            if (view != null) {
                view.setTranslationY(0.0f);
            }
            View view2 = f.this.topInfoView;
            if (view2 != null) {
                view2.setTranslationY(0.0f);
            }
            View view3 = f.this.containerLayout;
            if (view3 != null) {
                view3.setTranslationY(0.0f);
            }
            View view4 = f.this.containerLayout;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.mLastFeedId = "";
        com.tencent.biz.qqcircle.comment.recpic.z zVar = com.tencent.biz.qqcircle.comment.recpic.z.f83900a;
        this.permissionFeedGuideVideoProcess = zVar.u();
        this.permissionFeedGuideFeedPosLimit = zVar.t();
    }

    private final boolean A() {
        View view = this.containerLayout;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final boolean B() {
        if (com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(getContextHashCode(), "feed_type_bottom_non_resident_banner_group") != null) {
            return true;
        }
        return false;
    }

    private final void C(View rootView) {
        View view;
        TextView textView;
        if (this.containerLayout == null && rootView != null) {
            ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.f34630zo);
            View view2 = null;
            if (viewStub != null) {
                view = viewStub.inflate();
            } else {
                view = null;
            }
            if (view == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(view, "viewStub?.inflate() ?: return");
            this.containerLayout = view;
            this.iconIv = (ImageView) view.findViewById(R.id.d_k);
            View view3 = this.containerLayout;
            if (view3 != null) {
                textView = (TextView) view3.findViewById(R.id.jml);
            } else {
                textView = null;
            }
            this.tipTv = textView;
            View view4 = this.containerLayout;
            if (view4 != null) {
                view2 = view4.findViewById(R.id.vg_);
            }
            this.redPoint = view2;
            this.infoView = this.f90604h.findViewById(R.id.f34510zc);
            this.topInfoView = this.f90604h.findViewById(R.id.f39941d1);
            View view5 = this.containerLayout;
            if (view5 != null) {
                view5.setOnClickListener(this);
            }
            this.showGuideRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.D(f.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I();
    }

    private final void E() {
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        String feedId = l();
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        if (qFSCommentRecPicClusterHelper.F(feedId)) {
            return;
        }
        com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.K();
    }

    private final void F() {
        this.canShowGuide = true;
        C(this.f90604h);
        G();
        H();
        J();
        com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
    }

    private final void G() {
        if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.g()) {
            View view = this.redPoint;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.redPoint;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void H() {
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        String feedId = l();
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        if (qFSCommentRecPicClusterHelper.F(feedId)) {
            TextView textView = this.tipTv;
            if (textView != null) {
                textView.setText(com.tencent.biz.qqcircle.comment.recpic.z.f83900a.w().getVideoFrameGuideTip());
                return;
            }
            return;
        }
        TextView textView2 = this.tipTv;
        if (textView2 != null) {
            textView2.setText(com.tencent.biz.qqcircle.comment.recpic.z.f83900a.w().getPermissionFeedGuideTip());
        }
    }

    private final void I() {
        String str;
        View view = this.containerLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.infoView;
        if (view2 != null && this.topInfoView != null && this.containerLayout != null) {
            Intrinsics.checkNotNull(view2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationY", DisplayUtil.dip2px(j(), 42.0f), 0.0f);
            View view3 = this.topInfoView;
            Intrinsics.checkNotNull(view3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "translationY", DisplayUtil.dip2px(j(), 42.0f), 0.0f);
            View view4 = this.containerLayout;
            Intrinsics.checkNotNull(view4);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view4, "translationY", DisplayUtil.dip2px(j(), 42.0f), 0.0f);
            AnimatorSet duration = new AnimatorSet().setDuration(250L);
            duration.playTogether(ofFloat, ofFloat2, ofFloat3);
            duration.start();
            E();
            ak akVar = ak.f83788a;
            View view5 = this.containerLayout;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            QCircleReportBean p16 = p();
            if (p16 == null || (str = p16.getDtPageId()) == null) {
                str = "";
            }
            akVar.c(view5, feedCloudMeta$StFeed, str, true);
            com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.Q(l());
        }
    }

    private final void J() {
        ImageView imageView = this.iconIv;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.nqu);
        }
    }

    private final void x() {
        if (this.infoView == null || this.topInfoView == null || this.containerLayout == null || !A()) {
            return;
        }
        QLog.d("QFSBottomRecPicPermissionGuideView", 1, "[dismissGuide] ");
        this.canShowGuide = false;
        View view = this.infoView;
        Intrinsics.checkNotNull(view);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, DisplayUtil.dip2px(j(), 42.0f));
        View view2 = this.topInfoView;
        Intrinsics.checkNotNull(view2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationY", 0.0f, DisplayUtil.dip2px(j(), 42.0f));
        View view3 = this.containerLayout;
        Intrinsics.checkNotNull(view3);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, "translationY", 0.0f, DisplayUtil.dip2px(j(), 42.0f));
        AnimatorSet duration = new AnimatorSet().setDuration(250L);
        duration.playTogether(ofFloat, ofFloat2, ofFloat3);
        duration.addListener(new b());
        duration.start();
        com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.Q(null);
    }

    private final void y(SimpleBaseEvent event) {
        if (event instanceof QFSRecPicStateEvent) {
            QFSRecPicStateEvent qFSRecPicStateEvent = (QFSRecPicStateEvent) event;
            if (qFSRecPicStateEvent.getState() == 1 && TextUtils.equals(l(), qFSRecPicStateEvent.getFeedId())) {
                x();
            }
        }
    }

    private final void z(an event) {
        if (event.e() >= this.permissionFeedGuideVideoProcess && this.f90603f >= this.permissionFeedGuideFeedPosLimit) {
            com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
            Context j3 = j();
            Intrinsics.checkNotNull(j3, "null cannot be cast to non-null type android.app.Activity");
            if (!aaVar.f((Activity) j3)) {
                return;
            }
            F();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        super.f(event);
        if (!this.canShowGuide && !B() && (event instanceof an)) {
            z((an) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void g() {
        super.g();
        this.mLastFeedId = "";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QFSRecPicStateEvent>> getEventClass() {
        ArrayList<Class<QFSRecPicStateEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSRecPicStateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 127;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.canShowGuide) {
            com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
            if (aaVar.z(this.f90602e) && !aaVar.t()) {
                Context j3 = j();
                Intrinsics.checkNotNull(j3, "null cannot be cast to non-null type android.app.Activity");
                if (!aaVar.E((Activity) j3) && aaVar.F() && !aaVar.m()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        String str;
        String dtPageId;
        EventCollector.getInstance().onViewClickedBefore(v3);
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        String feedId = l();
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        boolean F = qFSCommentRecPicClusterHelper.F(feedId);
        String str2 = "";
        if (F) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String feedId2 = l();
            Intrinsics.checkNotNullExpressionValue(feedId2, "feedId");
            simpleEventBus.dispatchEvent(new QFSRecPicStateEvent(6, feedId2));
        } else {
            com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
            aaVar.L();
            Context context = j();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String feedId3 = l();
            Intrinsics.checkNotNullExpressionValue(feedId3, "feedId");
            QCircleReportBean p16 = p();
            if (p16 == null || (str = p16.getDtPageId()) == null) {
                str = "";
            }
            aaVar.R(context, feedId3, "feed_bar", str);
        }
        ak akVar = ak.f83788a;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        QCircleReportBean p17 = p();
        if (p17 != null && (dtPageId = p17.getDtPageId()) != null) {
            str2 = dtPageId;
        }
        akVar.c(v3, feedCloudMeta$StFeed, str2, false);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        C(this.f90604h);
        Runnable runnable = this.showGuideRunnable;
        if (runnable != null) {
            n().post(runnable);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        View view = this.containerLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        this.canShowGuide = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        y(event);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
}
