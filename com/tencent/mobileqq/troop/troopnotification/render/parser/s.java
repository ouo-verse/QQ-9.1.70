package com.tencent.mobileqq.troop.troopnotification.render.parser;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ISafetyReportTempService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgStatus;
import com.tencent.widget.ActionSheet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0014H\u0016J6\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J6\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\u00182\u0006\u0010\u0012\u001a\u00020\u0014H\u0016R\u001a\u0010 \u001a\u00020\u00198\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/s;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "Lcom/tencent/qqnt/notification/f;", "msg", "", "j", "k", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "Landroid/app/Dialog;", "i", "Landroidx/fragment/app/FragmentActivity;", "", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "d", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "b", "", "wildcardValue", "", "", "data", "c", "a", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class s implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f300783a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f300783a = new s();
            key = "reportButton";
        }
    }

    s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Dialog i(Context context, View view) {
        ActionSheet dialog = ActionSheet.create(context, -1, null);
        dialog.setActionContentView(view, null);
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        return dialog;
    }

    private final boolean j(com.tencent.qqnt.notification.f msg2) {
        if (msg2.j().originMsgType == 1 || msg2.j().originMsgType == 22) {
            return true;
        }
        return false;
    }

    private final boolean k(com.tencent.qqnt.notification.f msg2) {
        if (msg2.j().originMsgType == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder, com.tencent.qqnt.notification.f msg2, View view) {
        FragmentActivity fragmentActivity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Context context = viewHolder.o().getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            f300783a.p(fragmentActivity, msg2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder, com.tencent.qqnt.notification.f msg2, View view) {
        FragmentActivity fragmentActivity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Context context = viewHolder.o().getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            f300783a.n(fragmentActivity, msg2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n(final FragmentActivity context, final com.tencent.qqnt.notification.f msg2) {
        Dialog i3 = i(context, null);
        Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) i3;
        actionSheet.addButton(context.getResources().getString(R.string.f170689yn), 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.r
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                s.o(FragmentActivity.this, msg2, actionSheet, view, i16);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[Catch: Exception -> 0x00cc, TryCatch #0 {Exception -> 0x00cc, blocks: (B:16:0x004b, B:22:0x0067, B:24:0x0078, B:27:0x0093, B:32:0x00a8), top: B:15:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[Catch: Exception -> 0x00cc, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cc, blocks: (B:16:0x004b, B:22:0x0067, B:24:0x0078, B:27:0x0093, B:32:0x00a8), top: B:15:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void o(FragmentActivity context, com.tencent.qqnt.notification.f msg2, ActionSheet sheet, View view, int i3) {
        String c16;
        int i16;
        String str;
        int i17;
        String str2;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        if (i3 == 0) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QQToast.makeText(context, R.string.f235087ap, 0).show();
                return;
            }
            AppInterface e16 = bg.e();
            if (e16 == null) {
                return;
            }
            String valueOf = String.valueOf(msg2.j().group.groupCode);
            com.tencent.qqnt.notification.b b16 = msg2.b();
            if (b16 != null && (c16 = b16.c()) != null) {
                try {
                    i16 = msg2.j().originMsgType;
                    str = "10035";
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                if (i16 != 1 && i16 == 2) {
                    str = "10042";
                    i17 = 20009;
                    if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("relation_tipoff_refactor_8973", false)) {
                        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
                        bVar.i(str);
                        bVar.n(c16);
                        bVar.o(2);
                        if (ProfileUtils.isFriend(e16, c16)) {
                            str2 = "1";
                        } else {
                            str2 = "0";
                        }
                        bVar.j(str2);
                        bVar.s(0);
                        bVar.r(valueOf);
                        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar);
                    } else {
                        String currentAccountUin = e16.getCurrentAccountUin();
                        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.getCurrentAccountUin()");
                        IRuntimeService runtimeService = e16.getRuntimeService(ISafetyReportTempService.class, "");
                        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IS\u2026va, ProcessConstant.MAIN)");
                        ((ISafetyReportTempService) runtimeService).safetyReport((QBaseActivity) context, c16, valueOf, currentAccountUin, i17, null);
                    }
                    com.tencent.mobileqq.troop.troopnotification.report.a.f300918a.h(msg2);
                }
                i17 = 20011;
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("relation_tipoff_refactor_8973", false)) {
                }
                com.tencent.mobileqq.troop.troopnotification.report.a.f300918a.h(msg2);
            } else {
                return;
            }
        }
        sheet.dismiss();
    }

    private final void p(final FragmentActivity context, final com.tencent.qqnt.notification.f msg2) {
        String str;
        if (j(msg2)) {
            str = context.getResources().getString(R.string.hgw);
        } else if (k(msg2)) {
            str = context.getResources().getString(R.string.i7g);
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (isApplyMsg(msg)) {\n \u2026e_info)\n        } else \"\"");
        Dialog i3 = i(context, null);
        Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) i3;
        actionSheet.setMainTitle(str);
        actionSheet.addButton(context.getResources().getString(R.string.f1788837v), 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.q
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                s.q(FragmentActivity.this, msg2, actionSheet, view, i16);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(FragmentActivity context, com.tencent.qqnt.notification.f msg2, ActionSheet sheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        if (i3 == 0) {
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                TroopNotificationDetailVM.INSTANCE.a(context).U1(msg2);
            } else {
                QQToast.makeText(context, R.string.f235087ap, 0).show();
            }
            com.tencent.mobileqq.troop.troopnotification.report.a.f300918a.k(msg2);
        }
        sheet.dismiss();
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull final com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (msg2.j().status == GroupNotifyMsgStatus.KUNHANDLE && (j(msg2) || k(msg2))) {
            viewHolder.n().setVisibility(0);
            viewHolder.f().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s.l(com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this, msg2, view);
                }
            });
            viewHolder.m().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s.m(com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this, msg2, view);
                }
            });
        } else {
            viewHolder.n().setVisibility(8);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean c(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    @NotNull
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return key;
    }
}
