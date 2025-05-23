package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/cb;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/Group;", "y", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "g", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class cb extends bv {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/cb$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.component.cb$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62909);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(cb this$0, View view) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean contains$default;
        boolean contains$default2;
        String replace$default;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bv.l(this$0, "em_group_promote_numbers", null, 2, null);
        String url = BigTroopExpiredNtTipsBar.D();
        try {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "groupId=%s", false, 2, (Object) null);
            if (contains$default) {
                Intrinsics.checkNotNullExpressionValue(url, "url");
                replace$default = StringsKt__StringsJVMKt.replace$default(url, "groupId=%s", "groupId=" + this$0.g().j(), false, 4, (Object) null);
                url = replace$default;
            }
            Intrinsics.checkNotNullExpressionValue(url, "url");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "from=%s", false, 2, (Object) null);
            if (contains$default2) {
                Intrinsics.checkNotNullExpressionValue(url, "url");
                url = StringsKt__StringsJVMKt.replace$default(url, "from=%s", "from=outside_76", false, 4, (Object) null);
            }
        } catch (Exception e16) {
            QLog.e("UpgradeTroopConfigList", 1, "format exception", e16);
        }
        IVipTraceDetailReport iVipTraceDetailReport = (IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        String buildTraceDetailUrl = iVipTraceDetailReport.buildTraceDetailUrl(url, IVipTraceDetailReport.FROM.TROOP_MANAGER_INCREASE_GROUP_NUMBER);
        if (QLog.isColorLevel()) {
            QLog.i("UpgradeTroopConfigList", 2, "DATA_TAG_UPGRADE_TROOP traceUrl:" + buildTraceDetailUrl);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, com.tencent.mobileqq.msf.core.x.q.f250389u, false, 2, null);
        if (!startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
            if (!startsWith$default2) {
                QRouteApi api = QRoute.api(IVasHybridRoute.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IVasHybridRoute::class.java)");
                QBaseActivity b16 = this$0.b();
                Intrinsics.checkNotNullExpressionValue(url, "url");
                IVasHybridRoute.b.a((IVasHybridRoute) api, b16, url, null, 4, null);
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        Intent intent = new Intent(this$0.b(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, this$0.b().getResources().getString(R.string.i7o));
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", buildTraceDetailUrl);
        this$0.b().startActivity(intent);
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public Group y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.i7t, "", null, null, 12, null);
        bv.n(this, "em_group_promote_numbers", null, 2, null);
        v3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.ca
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cb.z(cb.this, view);
            }
        });
        Unit unit = Unit.INSTANCE;
        return new Group(v3);
    }
}
