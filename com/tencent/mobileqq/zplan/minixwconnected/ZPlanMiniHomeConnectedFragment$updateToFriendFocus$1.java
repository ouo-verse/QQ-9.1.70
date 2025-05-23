package com.tencent.mobileqq.zplan.minixwconnected;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.zplan.manager.GiveLikeType;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.qphone.base.util.QLog;
import fi3.bi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanMiniHomeConnectedFragment$updateToFriendFocus$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $hostName;
    final /* synthetic */ String $hostUin;
    final /* synthetic */ View $part;
    final /* synthetic */ ZPlanMiniHomeConnectedFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMiniHomeConnectedFragment$updateToFriendFocus$1(ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment, View view, String str, String str2) {
        super(0);
        this.this$0 = zPlanMiniHomeConnectedFragment;
        this.$part = view;
        this.$hostUin = str;
        this.$hostName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZPlanMiniHomeConnectedFragment this$0, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        MiniHomeConnectedController miniHomeConnectedController2;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_interactive_btn", "dt_clck", null, false, true, 8, null);
        }
        miniHomeConnectedController2 = this$0.controller;
        if (miniHomeConnectedController2 != null) {
            miniHomeConnectedController2.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZPlanMiniHomeConnectedFragment this$0, String str, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click profileCardIcon, try jumpToProfileCard.");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_info_card", "dt_clck", null, false, true, 8, null);
        }
        this$0.ei(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZPlanMiniHomeConnectedFragment this$0, String str, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        MiniHomeConnectedController miniHomeConnectedController2;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_like", "dt_clck", null, false, true, 8, null);
        }
        miniHomeConnectedController2 = this$0.controller;
        if (miniHomeConnectedController2 != null) {
            miniHomeConnectedController2.Y(GiveLikeType.FRIEND, str != null ? StringsKt__StringNumberConversionsKt.toLongOrNull(str) : null);
        }
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click likeIcon, try give like.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZPlanMiniHomeConnectedFragment this$0, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click titleText, try jumpToProfileCard.");
        this$0.ei(str);
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
        String str;
        bi Xh4;
        bi Xh5;
        Xh = this.this$0.Xh();
        Xh.f399103f.setVisibility(8);
        view = this.this$0.friendFocusPart;
        if (view == null) {
            this.this$0.friendFocusPart = this.$part;
        }
        view2 = this.this$0.friendFocusPart;
        RelativeLayout relativeLayout = view2 instanceof RelativeLayout ? (RelativeLayout) view2 : null;
        if (relativeLayout != null) {
            final ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = this.this$0;
            final String str2 = this.$hostUin;
            ((RelativeLayout) relativeLayout.findViewWithTag("actionButtonIconLayout")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ZPlanMiniHomeConnectedFragment$updateToFriendFocus$1.e(ZPlanMiniHomeConnectedFragment.this, view5);
                }
            });
            ((RelativeLayout) relativeLayout.findViewWithTag("profileCardIcon")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ZPlanMiniHomeConnectedFragment$updateToFriendFocus$1.f(ZPlanMiniHomeConnectedFragment.this, str2, view5);
                }
            });
            ((RelativeLayout) relativeLayout.findViewWithTag("likeIcon")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ZPlanMiniHomeConnectedFragment$updateToFriendFocus$1.g(ZPlanMiniHomeConnectedFragment.this, str2, view5);
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
        this.this$0.ci();
        view4 = this.this$0.friendFocusPart;
        if (view4 != null) {
            ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment3 = this.this$0;
            ViewParent parent = view4.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view4);
            }
            Xh4 = zPlanMiniHomeConnectedFragment3.Xh();
            Xh4.f399099b.addView(view4);
        }
        Xh3 = this.this$0.Xh();
        TextView textView = Xh3.f399106i;
        String str3 = this.$hostName;
        final ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment4 = this.this$0;
        final String str4 = this.$hostUin;
        if (str3 == null || (str = w.b(str3, "\u7684\u7a9d", 0, 4, null)) == null) {
            str = "\u8da3\u90bb";
        }
        textView.setText(str);
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ZPlanMiniHomeConnectedFragment$updateToFriendFocus$1.h(ZPlanMiniHomeConnectedFragment.this, str4, view5);
            }
        });
    }
}
