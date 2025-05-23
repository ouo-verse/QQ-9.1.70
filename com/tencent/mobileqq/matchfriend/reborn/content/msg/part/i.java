package com.tencent.mobileqq.matchfriend.reborn.content.msg.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerEnableUpdateTabUnreadNumEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerMsgScrollToTopEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.matchfriend.reborn.titlebar.QQStrangerOnPageBackEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/i;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/a;", "", "N9", "", "O9", "T9", "J9", "K9", "P9", "I9", "Landroid/view/View;", "Q9", "S9", "", "btnType", "R9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "e", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragHost", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "f", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "<init>", "(Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;)V", tl.h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class i extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QUIBadgeDragLayout dragHost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar quiSecNavBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/part/i$c", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "I", "getDrawable", "()I", "drawable", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends com.tencent.biz.qui.quisecnavbar.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int drawable = R.drawable.qui_setting_selector;

        c() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(View view) {
            i.this.K9();
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return this.drawable;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/part/i$d", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e16) {
            return i.this.N9();
        }
    }

    public i(QUIBadgeDragLayout dragHost) {
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        this.dragHost = dragHost;
    }

    private final void I9() {
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar = null;
        }
        VideoReport.setPageId(qUISecNavBar, "pg_kl_new_chat_list");
        QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar3 = null;
        }
        VideoReport.setPageParams(qUISecNavBar3, "kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        QUISecNavBar qUISecNavBar4 = this.quiSecNavBar;
        if (qUISecNavBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar4 = null;
        }
        VideoReport.setPageReportPolicy(qUISecNavBar4, PageReportPolicy.REPORT_NONE);
        QUISecNavBar qUISecNavBar5 = this.quiSecNavBar;
        if (qUISecNavBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar5 = null;
        }
        VideoReport.setElementExposePolicy(qUISecNavBar5, ExposurePolicy.REPORT_NONE);
        QUISecNavBar qUISecNavBar6 = this.quiSecNavBar;
        if (qUISecNavBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar6 = null;
        }
        VideoReport.setElementEndExposePolicy(qUISecNavBar6, EndExposurePolicy.REPORT_NONE);
        QUISecNavBar qUISecNavBar7 = this.quiSecNavBar;
        if (qUISecNavBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
        } else {
            qUISecNavBar2 = qUISecNavBar7;
        }
        VideoReport.setElementClickPolicy(qUISecNavBar2, ClickPolicy.REPORT_NONE);
    }

    private final void J9() {
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerOnPageBackEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        Activity activity;
        if (u.a().b() || (activity = getActivity()) == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        P9();
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterChatSetting(activity, appInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M9(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(gestureDetector, "$gestureDetector");
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N9() {
        SimpleEventBus.getInstance().dispatchEvent(QQStrangerMsgScrollToTopEvent.INSTANCE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f169694x30);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null) != null) {
            if (QQStrangerRecentContactHelper.f244865a.h() <= 0) {
                QLog.i("QQStrangerMsgTitlePart", 1, "onUnreadMsgCountCleanClick unreadMsgCount <= 0, so return ");
            } else {
                T9();
            }
        }
    }

    private final void P9() {
        com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        dVar.c("pg_kl_new_chat_list", hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_kl_config");
        dVar.b(arrayList);
        dVar.d("em_kl_config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(View view) {
        Map emptyMap;
        VideoReport.setElementId(view, "em_kl_clear_btn");
        emptyMap = MapsKt__MapsKt.emptyMap();
        VideoReport.reportEvent("clck", view, emptyMap);
    }

    private final void R9(int btnType) {
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar = null;
        }
        VideoReport.setElementId(qUISecNavBar, "em_kl_clear_confirm_pop");
        QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
        } else {
            qUISecNavBar2 = qUISecNavBar3;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_pgid", "pg_kl_new_chat_list");
        hashMap.put("qq_eid", "em_kl_clear_confirm_pop");
        hashMap.put("btn_type", Integer.valueOf(btnType));
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("qq_clck", qUISecNavBar2, hashMap);
    }

    private final void S9() {
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar = null;
        }
        VideoReport.setElementId(qUISecNavBar, "em_kl_clear_confirm_pop");
        QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
        } else {
            qUISecNavBar2 = qUISecNavBar3;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_pgid", "pg_kl_new_chat_list");
        hashMap.put("qq_eid", "em_kl_clear_confirm_pop");
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("qq_imp", qUISecNavBar2, hashMap);
    }

    private final void T9() {
        Activity activity = getActivity();
        boolean z16 = false;
        if (!(activity != null && activity.isFinishing())) {
            Activity activity2 = getActivity();
            if (activity2 != null && activity2.isDestroyed()) {
                z16 = true;
            }
            if (!z16) {
                S9();
                DialogUtil.createCustomDialog(getContext(), 230, (String) null, getContext().getString(R.string.x2z), getContext().getString(R.string.wyl), getContext().getString(R.string.wym), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.part.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        i.U9(i.this, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.part.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        i.V9(i.this, dialogInterface, i3);
                    }
                }).show();
                return;
            }
        }
        QLog.i("QQStrangerMsgTitlePart", 1, "showConfirmCleanUpDialog activity is finishing or destroyed, so return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(i this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("QQStrangerMsgTitlePart", 2, "handleMsgWasCleanUp createCustomDialog forceAllToBorn");
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerEnableUpdateTabUnreadNumEvent(false));
        this$0.dragHost.forceAllToBorn("stranger_msg", 2);
        this$0.R9(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(i this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.op6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qqstranger_msg_nav_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.quiSecNavBar = qUISecNavBar;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setAutoAdaptTransparent(false);
        qUISecNavBar.setTitleAlpha(0.0f);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        qUISecNavBar.R(activity);
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.L9(i.this, view);
            }
        });
        qUISecNavBar.d(new b());
        qUISecNavBar.d(new c());
        final GestureDetector gestureDetector = new GestureDetector(qUISecNavBar.getContext(), new d());
        qUISecNavBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.part.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean M9;
                M9 = i.M9(gestureDetector, view, motionEvent);
                return M9;
            }
        });
        I9();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/part/i$b", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "I", "getDrawable", "()I", "drawable", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends com.tencent.biz.qui.quisecnavbar.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int drawable = R.drawable.qui_clear_selector;

        b() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return this.drawable;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(View view) {
            if (view != null) {
                i.this.Q9(view);
            }
            if (hf0.a.a("QQStrangerMsgTitlePart")) {
                return;
            }
            i.this.O9();
        }
    }
}
