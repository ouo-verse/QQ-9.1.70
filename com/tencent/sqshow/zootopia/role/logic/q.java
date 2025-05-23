package com.tencent.sqshow.zootopia.role.logic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleHelper;
import com.tencent.sqshow.zootopia.role.ui.RoleLoadingButton;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.state.report.SquareReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.ar;
import pv4.u;
import qv4.ab;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/q;", "", "", "f", tl.h.F, "l", "e", "", "url", "k", "jumpFromSource", "j", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln74/ar;", "b", "Ln74/ar;", "getMBinding", "()Ln74/ar;", "mBinding", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "c", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "getMController", "()Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", "<init>", "(Landroid/app/Activity;Ln74/ar;Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;)V", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ar mBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CreateRoleController mController;

    public q(Activity activity, ar mBinding, CreateRoleController mController) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        Intrinsics.checkNotNullParameter(mController, "mController");
        this.activity = activity;
        this.mBinding = mBinding;
        this.mController = mController;
    }

    private final void e() {
        ZplanViewReportHelper reportHelper = this.mController.getReportHelper();
        ZPlanMediaView zPlanMediaView = this.mBinding.f418696g;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.bannerImg");
        reportHelper.g(zPlanMediaView, "em_zplan_activity_banner", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper reportHelper2 = this.mController.getReportHelper();
        RoleLoadingButton roleLoadingButton = this.mBinding.f418704o;
        Intrinsics.checkNotNullExpressionValue(roleLoadingButton, "mBinding.headBtn");
        reportHelper2.g(roleLoadingButton, "em_zplan_create_head_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper reportHelper3 = this.mController.getReportHelper();
        RoleLoadingButton roleLoadingButton2 = this.mBinding.f418708s;
        Intrinsics.checkNotNullExpressionValue(roleLoadingButton2, "mBinding.roleBtn");
        reportHelper3.g(roleLoadingButton2, "em_zplan_start_xiaowo", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper reportHelper4 = this.mController.getReportHelper();
        ImageView imageView = this.mBinding.f418694e;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIconFinish");
        reportHelper4.g(imageView, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void f() {
        u uVar;
        pu4.g gVar;
        u uVar2;
        pu4.g gVar2;
        ab r16 = this.mController.r();
        String str = (r16 == null || (uVar2 = r16.f429895j) == null || (gVar2 = uVar2.f427705d) == null) ? null : gVar2.f427434a;
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            this.mBinding.f418696g.setVisibility(0);
            ab r17 = this.mController.r();
            if (r17 != null && (uVar = r17.f429895j) != null && (gVar = uVar.f427705d) != null) {
                this.mBinding.f418696g.e(gVar);
            }
            ZPlanMediaView zPlanMediaView = this.mBinding.f418696g;
            Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.bannerImg");
            aa.d(zPlanMediaView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.g(q.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(q this$0, View view) {
        u uVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ab r16 = this$0.mController.r();
        this$0.k((r16 == null || (uVar = r16.f429895j) == null) ? null : uVar.f427703b);
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        ZPlanMediaView zPlanMediaView = this$0.mBinding.f418696g;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.bannerImg");
        ZplanViewReportHelper.f(reportHelper, zPlanMediaView, "em_zplan_activity_banner", null, 4, null);
    }

    private final void h() {
        u uVar;
        pu4.g gVar;
        u uVar2;
        ab r16 = this.mController.r();
        String str = (r16 == null || (uVar2 = r16.f429897l) == null) ? null : uVar2.f427702a;
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            this.mBinding.f418704o.setVisibility(0);
            this.mBinding.f418704o.setText(str);
            this.mBinding.f418704o.setTextColor(-16777216);
            ab r17 = this.mController.r();
            if (r17 != null && (uVar = r17.f429897l) != null && (gVar = uVar.f427705d) != null) {
                this.mBinding.f418704o.setIcon(gVar);
            }
            this.mBinding.f418704o.setOnClickListenerWithLoading(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.i(q.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(q this$0, View view) {
        u uVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ab r16 = this$0.mController.r();
        this$0.k((r16 == null || (uVar = r16.f429897l) == null) ? null : uVar.f427703b);
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        ZPlanMediaView zPlanMediaView = this$0.mBinding.f418696g;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.bannerImg");
        ZplanViewReportHelper.f(reportHelper, zPlanMediaView, "em_zplan_create_head_btn", null, 4, null);
    }

    private final void j(String jumpFromSource) {
        boolean z16 = true;
        QLog.i("CreateRoleSelectDressStep", 1, "handleJumpToEmoticon");
        Bundle extras = this.activity.getIntent().getExtras();
        String string = extras != null ? extras.getString("friendUin", "") : null;
        if (string != null && string.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ((IZPlanEmoticonApi) QRoute.api(IZPlanEmoticonApi.class)).jumpToEmoticon(this.activity, string, jumpFromSource);
    }

    private final void l() {
        u uVar;
        pu4.g gVar;
        u uVar2;
        ab r16 = this.mController.r();
        String str = (r16 == null || (uVar2 = r16.f429894i) == null) ? null : uVar2.f427702a;
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            this.mBinding.f418708s.setVisibility(0);
            this.mBinding.f418708s.setText(str);
            ab r17 = this.mController.r();
            if (r17 != null && (uVar = r17.f429894i) != null && (gVar = uVar.f427705d) != null) {
                this.mBinding.f418708s.setIcon(gVar);
            }
            this.mBinding.f418708s.setOnClickListenerWithLoading(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.m(q.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(q this$0, View view) {
        u uVar;
        u uVar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ab r16 = this$0.mController.r();
        String str = null;
        String str2 = (r16 == null || (uVar2 = r16.f429894i) == null) ? null : uVar2.f427703b;
        if (str2 == null) {
            str2 = "";
        }
        if (Intrinsics.areEqual(str2, ZootopiaSource.SUB_SOURCE_EMOTICON_DETAIL)) {
            this$0.j("create_detail");
            return;
        }
        if (Intrinsics.areEqual(str2, ZootopiaSource.SUB_SOURCE_EMOTICON_GRAY_TIP)) {
            this$0.j(ZootopiaSource.SUB_SOURCE_EMOTICON_GRAY_TIP);
            return;
        }
        ab r17 = this$0.mController.r();
        if (r17 != null && (uVar = r17.f429894i) != null) {
            str = uVar.f427703b;
        }
        this$0.k(str);
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        ZPlanMediaView zPlanMediaView = this$0.mBinding.f418696g;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.bannerImg");
        ZplanViewReportHelper.f(reportHelper, zPlanMediaView, "em_zplan_start_xiaowo", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(q this$0, View view) {
        u uVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ab r16 = this$0.mController.r();
        this$0.k((r16 == null || (uVar = r16.f429893h) == null) ? null : uVar.f427703b);
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        ZPlanMediaView zPlanMediaView = this$0.mBinding.f418696g;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "mBinding.bannerImg");
        ZplanViewReportHelper.f(reportHelper, zPlanMediaView, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, null, 4, null);
    }

    public void n() {
        this.mBinding.f418697h.setVisibility(4);
        this.mBinding.f418693d.setVisibility(8);
        this.mBinding.f418699j.setVisibility(4);
        this.mBinding.f418715z.setVisibility(8);
        this.mBinding.f418713x.setVisibility(8);
        this.mBinding.f418694e.setVisibility(0);
        this.mBinding.f418694e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.o(q.this, view);
            }
        });
        ab r16 = this.mController.r();
        this.mBinding.A.setText(r16 != null ? r16.f429896k : null);
        f();
        h();
        l();
        e();
    }

    private final void k(String url) {
        if (url == null) {
            url = "";
        }
        this.activity.finish();
        PortalStoreCreateRoleBubbleHelper portalStoreCreateRoleBubbleHelper = PortalStoreCreateRoleBubbleHelper.f371421a;
        if (portalStoreCreateRoleBubbleHelper.e()) {
            portalStoreCreateRoleBubbleHelper.h();
            return;
        }
        if (url.length() > 0) {
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(this.activity, url);
        }
    }
}
