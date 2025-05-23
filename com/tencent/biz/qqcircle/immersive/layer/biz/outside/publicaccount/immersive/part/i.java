package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.events.QFSLayerFloatShowEvent;
import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleForQZoneVideoState;
import com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountLauncher;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p40.o;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/part/i;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "L9", "N9", "E9", "", "isVisible", "O9", "G9", "J9", "", "getLogTag", "onInitView", "action", "", "args", "handleBroadcastMessage", "d", "Ljava/lang/String;", "TAG", "e", "Landroid/view/View;", "closeBtn", "Lfeedcloud/FeedCloudMeta$StFeed;", "f", "Lfeedcloud/FeedCloudMeta$StFeed;", "mCurrentFeed", tl.h.F, "mSmallWindow", "<init>", "()V", "i", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i extends u {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static int f86728m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "QFSLayerPublicAccountPa";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View closeBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mCurrentFeed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mSmallWindow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/part/i$a;", "", "", "titlePartHeight", "I", "a", "()I", "setTitlePartHeight", "(I)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.i$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return i.f86728m;
        }

        Companion() {
        }
    }

    private final void E9(View rootView) {
        View findViewById = rootView.findViewById(R.id.va6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026sh_show_layer_page_close)");
        this.closeBtn = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.F9(i.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (o.d(QCirclePluginUtil.getQCircleInitBean(this$0.getContext())) && uq3.o.g()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_TOP_CLOSE_TRIGGER));
        } else {
            this$0.getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G9(View rootView) {
        final View inflate = ((ViewStub) rootView.findViewById(R.id.va7)).inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView.findViewById<Vi\u2026ayer_page_more).inflate()");
        inflate.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.d
            @Override // java.lang.Runnable
            public final void run() {
                i.H9(i.this, inflate);
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.I9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(i this$0, View moreBtn) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(moreBtn, "$moreBtn");
        int[] iArr = new int[2];
        View view = this$0.closeBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            view = null;
        }
        view.getLocationOnScreen(iArr);
        f86728m = iArr[1] + moreBtn.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCirclePublicAccountLauncher qCirclePublicAccountLauncher = QCirclePublicAccountLauncher.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        qCirclePublicAccountLauncher.launchQCirclePublicAccountDetailPage(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J9(View rootView) {
        final View inflate = ((ViewStub) rootView.findViewById(R.id.va9)).inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView.findViewById<Vi\u2026er_page_search).inflate()");
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.K9(inflate, this, view);
            }
        });
        VideoReport.setElementId(inflate, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_BUTTON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(View searchBtn, i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(searchBtn, "$searchBtn");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String L0 = QFSVideoView.L0();
        if (L0 == null) {
            L0 = "";
        }
        VideoReport.setElementParam(searchBtn, "xsj_feed_id", L0);
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setUserSource(5);
        com.tencent.biz.qqcircle.launcher.c.y0(this$0.getContext(), qFSSearchBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void L9(View rootView) {
        boolean z16;
        View view;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        View findViewById = rootView.findViewById(R.id.va_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026_layer_page_small_window)");
        this.mSmallWindow = findViewById;
        View view2 = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmallWindow");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                i.M9(i.this, view3);
            }
        });
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        View view3 = this.mSmallWindow;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmallWindow");
            view3 = null;
        }
        o.a(view3, new e30.b(this.mCurrentFeed), qCircleInitBean);
        int i3 = 0;
        if (o.f(QCirclePluginUtil.getQCircleInitBean(getContext())) && !QCircleForQZoneVideoState.isMixMode()) {
            if (qCircleInitBean != null) {
                feedCloudMeta$StFeed = qCircleInitBean.getFeed();
            } else {
                feedCloudMeta$StFeed = null;
            }
            if (o.e(feedCloudMeta$StFeed)) {
                z16 = true;
                view = this.mSmallWindow;
                if (view != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSmallWindow");
                } else {
                    view2 = view;
                }
                if (!z16) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
        z16 = false;
        view = this.mSmallWindow;
        if (view != null) {
        }
        if (!z16) {
        }
        view2.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.mSmallWindow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmallWindow");
            view2 = null;
        }
        o.a(view2, new e30.b(this$0.mCurrentFeed), QCirclePluginUtil.getQCircleInitBean(this$0.getContext()));
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9() {
        String str;
        if (this.mCurrentFeed == null) {
            QLog.e("QFSLayerPublicAccountPageTitlePart", 1, "[clickOpenSmallWindow] current should not be null.");
            return;
        }
        if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(getActivity())) {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(getActivity());
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mCurrentFeed;
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            Intrinsics.checkNotNull(feedCloudMeta$StFeed);
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        QLog.d("QFSLayerPublicAccountPageTitlePart", 1, "[onClick] feed id: " + str);
        SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_LAYER_TOP_FLOAT_TRIGGER));
    }

    private final void O9(boolean isVisible) {
        View view = null;
        if (isVisible) {
            View view2 = this.mSmallWindow;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSmallWindow");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.closeBtn;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
                view3 = null;
            }
            View view4 = this.closeBtn;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
                view4 = null;
            }
            int paddingLeft = view4.getPaddingLeft();
            View view5 = this.closeBtn;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
                view5 = null;
            }
            int paddingTop = view5.getPaddingTop();
            int a16 = cx.a(6.0f);
            View view6 = this.closeBtn;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            } else {
                view = view6;
            }
            view3.setPadding(paddingLeft, paddingTop, a16, view.getPaddingBottom());
            return;
        }
        View view7 = this.mSmallWindow;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmallWindow");
            view7 = null;
        }
        view7.setVisibility(0);
        View view8 = this.closeBtn;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            view8 = null;
        }
        View view9 = this.closeBtn;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            view9 = null;
        }
        int paddingLeft2 = view9.getPaddingLeft();
        View view10 = this.closeBtn;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            view10 = null;
        }
        int paddingTop2 = view10.getPaddingTop();
        int a17 = cx.a(14.0f);
        View view11 = this.closeBtn;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        } else {
            view = view11;
        }
        view8.setPadding(paddingLeft2, paddingTop2, a17, view.getPaddingBottom());
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@NotNull String action, @Nullable Object args) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        boolean z16;
        Intrinsics.checkNotNullParameter(action, "action");
        super.handleBroadcastMessage(action, args);
        if (!Intrinsics.areEqual("layer_notify_part_update_feed", action) || !(args instanceof e30.b)) {
            return;
        }
        FeedCloudMeta$StFeed g16 = ((e30.b) args).g();
        if (g16 != null) {
            feedCloudMeta$StFeed = g16.get();
        } else {
            feedCloudMeta$StFeed = null;
        }
        this.mCurrentFeed = feedCloudMeta$StFeed;
        if (!n.i(feedCloudMeta$StFeed) && o.e(this.mCurrentFeed) && o.f(QCirclePluginUtil.getQCircleInitBean(getContext()))) {
            z16 = true;
        } else {
            z16 = false;
        }
        O9(z16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        E9(rootView);
        G9(rootView);
        J9(rootView);
        L9(rootView);
    }
}
