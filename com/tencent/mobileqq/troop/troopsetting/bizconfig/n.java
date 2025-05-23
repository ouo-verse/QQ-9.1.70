package com.tencent.mobileqq.troop.troopsetting.bizconfig;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/n;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "", "Z", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "r", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "viewModel", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class n extends x<x.b.d, x.c.g> {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopSettingViewModel viewModel;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n(@NotNull Activity activity, @NotNull TroopSettingViewModel viewModel) {
        super(r0, new x.c.g(r4, false, false, 6, null));
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        String string = activity.getResources().getString(R.string.f171432nq);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026tification_setting_troop)");
        x.b.d dVar = new x.b.d(string);
        String string2 = activity.getResources().getString(R.string.f173111vr2);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt\u2026et_msg_notification_tips)");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) viewModel);
            return;
        }
        this.activity = activity;
        this.viewModel = viewModel;
        x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.X(n.this, view);
            }
        });
        w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.m
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                n.Y(n.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(n this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.n(this$0.viewModel.T2());
    }

    private final void Z() {
        String str = this.viewModel.T2().troopUin;
        eu.g("Grp_set_new", "grpData_admin", "grpNotice_click", 0, 0, str);
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("uintype", 1);
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).messageNotificationSettingFragmentLaunch(this.activity, intent);
        HashMap hashMap = new HashMap();
        hashMap.put("to_uin", this.viewModel.S2().getTroopUin());
        hashMap.put("is_qq_fri", "2");
        Unit unit = Unit.INSTANCE;
        com.tencent.qqnt.notification.report.h.z(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, "em_bas_friend_message_notification_settings", null, hashMap, null, 16, null);
    }
}
