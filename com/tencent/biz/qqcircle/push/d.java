package com.tencent.biz.qqcircle.push;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QFSBottomMuteViewEvent;
import com.tencent.biz.qqcircle.l;
import com.tencent.biz.qqcircle.push.QFSOverPushView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001?B\u0017\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ\b\u0010\"\u001a\u0004\u0018\u00010\u001cJ\u001a\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001c2\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007J\b\u0010&\u001a\u00020\u0006H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010,\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030*`+H\u0016R \u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010/R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/biz/qqcircle/push/d;", "Landroid/widget/PopupWindow;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "isShowCancelBtn", "", "i", "j", "", "f", "Lcom/tencent/mobileqq/auto/engine/event/ASEngineTabStatusEvent;", "event", tl.h.F, "Lcom/tencent/biz/qqcircle/events/QFSBottomMuteViewEvent;", "g", "", "currentRocketCount", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "hasPushedCnt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "showCancelBtn", "p", "isOnlyShowCancelBtn", DomainData.DOMAIN_NAME, "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "c", "Landroid/view/View;", "parentView", "o", "Lcom/tencent/biz/qqcircle/push/QFSOverPushView$b;", "fastPushPanelClickListener", "l", "e", "targetView", "simpleMode", ReportConstant.COSTREPORT_PREFIX, "dismiss", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "mTargetView", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/biz/qqcircle/push/QFSOverPushView;", "Lcom/tencent/biz/qqcircle/push/QFSOverPushView;", "mFastPushPanel", "[I", "mTargetViewLocation", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tipsView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Z)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class d extends PopupWindow implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> mTargetView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Activity> mActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSOverPushView mFastPushPanel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] mTargetViewLocation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tipsView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/push/d$b", "Lcom/tencent/biz/qqcircle/push/QFSOverPushView$b;", "", "isNeedShowRocketEditPanel", "", "pushCnt", "pushType", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements QFSOverPushView.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.push.QFSOverPushView.b
        public void a(boolean isNeedShowRocketEditPanel, int pushCnt, int pushType) {
            d.this.dismiss();
        }
    }

    public d(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivity = new WeakReference<>((Activity) context);
        i(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.dismiss();
    }

    private final int[] f() {
        View view;
        WeakReference<View> weakReference = this.mTargetView;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null && this.mFastPushPanel != null) {
            int height = view.getHeight();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            boolean z16 = false;
            int[] iArr2 = {iArr[0], (iArr[1] + (height / 2)) - (cx.a(224.0f) / 2)};
            TextView textView = this.tipsView;
            if (textView != null && textView.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                iArr2[1] = iArr2[1] - cx.a(49.0f);
                QLog.d("QFSOverPushPopupWindow", 1, "[getShowXY] show tips");
            }
            this.mTargetViewLocation = iArr;
            return iArr2;
        }
        return new int[2];
    }

    private final void g(QFSBottomMuteViewEvent event) {
        String str;
        FeedCloudMeta$StFeed feed;
        PBStringField pBStringField;
        if (!event.getIsVisible()) {
            String feedId = event.getFeedId();
            QFSOverPushView qFSOverPushView = this.mFastPushPanel;
            if (qFSOverPushView != null && (feed = qFSOverPushView.getFeed()) != null && (pBStringField = feed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(feedId, str)) {
                dismiss();
            }
        }
    }

    private final void h(ASEngineTabStatusEvent event) {
        if (Intrinsics.areEqual(event.getBusinessKey(), ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && !event.isSelected()) {
            dismiss();
            QLog.d("QFSOverPushPopupWindow", 1, "tab unselect, dismiss");
        }
    }

    private final void i(boolean isShowCancelBtn) {
        Activity activity;
        int a16;
        ViewGroup.LayoutParams layoutParams;
        WeakReference<Activity> weakReference = this.mActivity;
        ViewGroup.LayoutParams layoutParams2 = null;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.gk6, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mActivity?.get())\n \u2026_push_panel, null, false)");
        this.mFastPushPanel = (QFSOverPushView) inflate.findViewById(R.id.f48081z1);
        this.tipsView = (TextView) inflate.findViewById(R.id.f48091z2);
        if (l.b() && !isShowCancelBtn && !k.a().c("qfs_key_has_show_push_v5_guide_anim", false)) {
            TextView textView = this.tipsView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            a16 = cx.a(323.0f);
        } else {
            TextView textView2 = this.tipsView;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            a16 = cx.a(224.0f);
        }
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null) {
            layoutParams = qFSOverPushView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.width = cx.a(151.0f);
        }
        QFSOverPushView qFSOverPushView2 = this.mFastPushPanel;
        if (qFSOverPushView2 != null) {
            layoutParams2 = qFSOverPushView2.getLayoutParams();
        }
        if (layoutParams2 != null) {
            layoutParams2.height = cx.a(224.0f);
        }
        setContentView(inflate);
        setWidth(cx.a(151.0f));
        setHeight(a16);
        setOutsideTouchable(false);
        setFocusable(true);
        setTouchable(true);
    }

    private final void j() {
        if (l.b()) {
            QFSOverPushView qFSOverPushView = this.mFastPushPanel;
            boolean z16 = false;
            if (qFSOverPushView != null && !qFSOverPushView.getOnlyShowCancelBtn()) {
                z16 = true;
            }
            if (z16) {
                setTouchInterceptor(new View.OnTouchListener() { // from class: com.tencent.biz.qqcircle.push.b
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean k3;
                        k3 = d.k(view, motionEvent);
                        return k3;
                    }
                });
            }
        }
        l(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(View view, MotionEvent motionEvent) {
        return true;
    }

    public static /* synthetic */ void t(d dVar, View view, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        dVar.s(view, z16);
    }

    public final void c(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null) {
            qFSOverPushView.setFeed(feed);
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        View view;
        Context context;
        Context context2;
        View view2;
        View view3;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        setOutsideTouchable(true);
        Context context3 = null;
        if (this.mTargetView != null && this.mFastPushPanel != null && isShowing()) {
            WeakReference<View> weakReference = this.mTargetView;
            if (weakReference != null && (view3 = weakReference.get()) != null) {
                context = view3.getContext();
            } else {
                context = null;
            }
            if (context instanceof Activity) {
                WeakReference<View> weakReference2 = this.mTargetView;
                if (weakReference2 != null && (view2 = weakReference2.get()) != null) {
                    context2 = view2.getContext();
                } else {
                    context2 = null;
                }
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                if (!((Activity) context2).isFinishing()) {
                    setTouchInterceptor(null);
                    QFSOverPushView qFSOverPushView = this.mFastPushPanel;
                    if (qFSOverPushView != null) {
                        qFSOverPushView.g(true);
                    }
                    QFSOverPushView qFSOverPushView2 = this.mFastPushPanel;
                    if (qFSOverPushView2 != null) {
                        qFSOverPushView2.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.push.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.d(d.this);
                            }
                        }, 300L);
                    }
                    QLog.d("QFSOverPushPopupWindow", 1, "dismiss");
                    return;
                }
            }
        }
        WeakReference<View> weakReference3 = this.mTargetView;
        if (weakReference3 != null && (view = weakReference3.get()) != null) {
            context3 = view.getContext();
        }
        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type android.app.Activity");
        QLog.d("QFSOverPushPopupWindow", 1, "[dismiss] activity is finish: " + ((Activity) context3).isFinishing());
    }

    @Nullable
    public final View e() {
        return this.mFastPushPanel;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ASEngineTabStatusEvent.class, QFSBottomMuteViewEvent.class, QCircleConfigChangeEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    public final void l(@NotNull QFSOverPushView.b fastPushPanelClickListener) {
        List<QFSOverPushView.b> o16;
        Intrinsics.checkNotNullParameter(fastPushPanelClickListener, "fastPushPanelClickListener");
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null && (o16 = qFSOverPushView.o()) != null) {
            o16.add(fastPushPanelClickListener);
        }
    }

    public final void m(int hasPushedCnt) {
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null) {
            qFSOverPushView.setHasPushedCnt(hasPushedCnt);
        }
    }

    public final void n(boolean isOnlyShowCancelBtn) {
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null) {
            qFSOverPushView.setOnlyShowCancelBtn(isOnlyShowCancelBtn);
        }
    }

    public final void o(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null) {
            qFSOverPushView.setParentView(parentView);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            h((ASEngineTabStatusEvent) simpleBaseEvent);
            QLog.d("QFSOverPushPopupWindow", 1, "receive tab select event");
        } else if (simpleBaseEvent instanceof QFSBottomMuteViewEvent) {
            g((QFSBottomMuteViewEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            dismiss();
        }
    }

    public final void p(boolean showCancelBtn) {
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null) {
            qFSOverPushView.setShowCancelBtn(showCancelBtn);
        }
    }

    public final void q(int currentRocketCount) {
        QFSOverPushView qFSOverPushView = this.mFastPushPanel;
        if (qFSOverPushView != null) {
            qFSOverPushView.setUserCurrentRocketCount(currentRocketCount);
        }
    }

    @JvmOverloads
    public final void r(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        t(this, targetView, false, 2, null);
    }

    @JvmOverloads
    public final void s(@NotNull View targetView, boolean simpleMode) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.mTargetView = new WeakReference<>(targetView);
        if (this.mFastPushPanel != null && (targetView.getContext() instanceof Activity)) {
            Context context = targetView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (!((Activity) context).isFinishing()) {
                SimpleEventBus.getInstance().registerReceiver(this);
                setTouchable(true);
                setOutsideTouchable(true);
                j();
                QFSOverPushView qFSOverPushView = this.mFastPushPanel;
                if (qFSOverPushView != null) {
                    qFSOverPushView.setSimpleMode(simpleMode);
                }
                int[] f16 = f();
                showAtLocation(targetView, 0, f16[0], f16[1]);
                QFSOverPushView qFSOverPushView2 = this.mFastPushPanel;
                if (qFSOverPushView2 != null) {
                    qFSOverPushView2.x();
                }
            }
        }
    }
}
