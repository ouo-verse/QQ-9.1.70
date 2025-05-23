package com.tencent.mobileqq.troop.troopsetting.bizconfig;

import android.app.Activity;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/c;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "", "Z", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "r", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "viewModel", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends x<x.b.d, x.c.g> {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QUIListItemAdapter adapter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopSettingViewModel viewModel;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(@NotNull Activity activity, @Nullable QUIListItemAdapter qUIListItemAdapter, @NotNull TroopSettingViewModel viewModel) {
        super(r0, new x.c.g(r8, false, false, 6, null));
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        String string = activity.getString(R.string.dqi);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026ng.qb_group_chat_history)");
        x.b.d dVar = new x.b.d(string);
        String string2 = activity.getString(R.string.kgv);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t\u2026.qqstr_chatsett_6c87d27d)");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, qUIListItemAdapter, viewModel);
            return;
        }
        this.activity = activity;
        this.adapter = qUIListItemAdapter;
        this.viewModel = viewModel;
        x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.X(c.this, view);
            }
        });
        w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.b
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                c.Y(c.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(c this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.l(this$0.viewModel.T2());
    }

    private final void Z() {
        AppInterface appInterface;
        TroopInfoData T2 = this.viewModel.T2();
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startActivityForTroop(this.activity, T2.troopUin, 1001);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.u(appInterface, T2);
    }
}
