package com.tencent.mobileqq.zplan.minixwconnected;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.manager.GiveLikeType;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import fi3.bi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ x45.h $currRecommendInfo;
    final /* synthetic */ View $strangerIcon;
    final /* synthetic */ ZPlanMiniHomeConnectedFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1(ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment, View view, x45.h hVar) {
        super(0);
        this.this$0 = zPlanMiniHomeConnectedFragment;
        this.$strangerIcon = view;
        this.$currRecommendInfo = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZPlanMiniHomeConnectedFragment this$0, x45.h hVar, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click titleText, try jumpToProfileCard.");
        this$0.ei(String.valueOf(hVar.f447212a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZPlanMiniHomeConnectedFragment this$0, x45.h hVar, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click profileCardIcon, try jumpToProfileCard.");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_info_card", "dt_clck", null, false, false, 40, null);
        }
        this$0.ei(String.valueOf(hVar.f447212a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZPlanMiniHomeConnectedFragment this$0, x45.h hVar, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        MiniHomeConnectedController miniHomeConnectedController2;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click likeIcon, try give like.");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_like", "dt_clck", null, false, false, 40, null);
        }
        miniHomeConnectedController2 = this$0.controller;
        if (miniHomeConnectedController2 != null) {
            miniHomeConnectedController2.Y(GiveLikeType.STRANGER, Long.valueOf(hVar.f447212a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ZPlanMiniHomeConnectedFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click changePeerButton, try change stranger.");
        this$0.wi();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        bi Xh;
        View view;
        View view2;
        bi Xh2;
        View view3;
        View view4;
        bi Xh3;
        bi Xh4;
        bi Xh5;
        Xh = this.this$0.Xh();
        Xh.f399103f.setVisibility(8);
        view = this.this$0.strangerPart;
        if (view == null) {
            this.this$0.strangerPart = this.$strangerIcon;
        }
        view2 = this.this$0.strangerPart;
        if (view2 != null) {
            final ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = this.this$0;
            final x45.h hVar = this.$currRecommendInfo;
            view2.setVisibility(0);
            ((RelativeLayout) view2.findViewWithTag("profileCardIcon")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1.g(ZPlanMiniHomeConnectedFragment.this, hVar, view5);
                }
            });
            ((RelativeLayout) view2.findViewWithTag("likeIcon")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1.h(ZPlanMiniHomeConnectedFragment.this, hVar, view5);
                }
            });
            ((TextView) view2.findViewWithTag("changePeerButton")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1.i(ZPlanMiniHomeConnectedFragment.this, view5);
                }
            });
            final TextView textView = (TextView) view2.findViewWithTag("addPeerButton");
            Intrinsics.checkNotNullExpressionValue(textView, "this");
            zPlanMiniHomeConnectedFragment.ki(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1.j(ZPlanMiniHomeConnectedFragment.this, textView, hVar, view5);
                }
            });
        }
        Xh2 = this.this$0.Xh();
        Xh2.f399099b.removeAllViews();
        view3 = this.this$0.coupleActionPanel;
        if (view3 != null) {
            ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment2 = this.this$0;
            Xh5 = zPlanMiniHomeConnectedFragment2.Xh();
            Xh5.getRoot().removeView(view3);
            zPlanMiniHomeConnectedFragment2.coupleActionPanel = null;
        }
        view4 = this.this$0.strangerPart;
        if (view4 != null) {
            Xh4 = this.this$0.Xh();
            RelativeLayout relativeLayout = Xh4.f399099b;
            relativeLayout.removeAllViews();
            relativeLayout.addView(view4);
        }
        Xh3 = this.this$0.Xh();
        TextView textView2 = Xh3.f399106i;
        final x45.h hVar2 = this.$currRecommendInfo;
        final ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment3 = this.this$0;
        String str = hVar2.f447214c;
        Intrinsics.checkNotNullExpressionValue(str, "currRecommendInfo.nickName");
        textView2.setText(w.b(str, "\u7684\u7a9d", 0, 4, null));
        textView2.setVisibility(0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1.f(ZPlanMiniHomeConnectedFragment.this, hVar2, view5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZPlanMiniHomeConnectedFragment this$0, TextView textView, x45.h hVar, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click addPeerButton, try add friend.");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, SquareReportConst.ElementId.ELEMENT_ID_ADD_FRIEND, "dt_clck", null, false, false, 40, null);
        }
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(textView.getContext(), ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(textView.getContext(), 1, String.valueOf(hVar.f447212a), (String) null, 3178, 1, hVar.f447214c, (String) null, (String) null, (String) null, (String) null, hVar.f447213b));
    }
}
