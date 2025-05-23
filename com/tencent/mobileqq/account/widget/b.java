package com.tencent.mobileqq.account.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.account.adapter.c;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00032\u00020\u0001:\u0002\u0013\u0018B-\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\"R\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/account/widget/b;", "", "Landroid/view/View;", "g", "Landroid/widget/LinearLayout;", "view", "", h.F, "Landroid/view/ViewGroup;", "e", "", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "target", "l", "f", "i", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Lcom/tencent/mobileqq/login/account/a;", "b", "Ljava/util/List;", "list", "", "c", "Z", "isV9", "d", "isV3", "Lcom/tencent/mobileqq/account/widget/g;", "Lcom/tencent/mobileqq/account/widget/g;", "popupWindowDialog", "Ljava/lang/String;", "getDrawerModeVideoReportValueV3", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "drawerModeVideoReportValueV3", "<init>", "(Landroid/app/Activity;Ljava/util/List;ZZ)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.login.account.a> list;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isV9;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isV3;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g popupWindowDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String drawerModeVideoReportValueV3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/account/widget/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.account.widget.b$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/account/widget/b$b;", "Le72/a;", "", "a", "b", "", "Ljava/lang/String;", "uin", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/account/widget/b;", "Lmqq/util/WeakReference;", "helperRef", "helper", "<init>", "(Lcom/tencent/mobileqq/account/widget/b;Ljava/lang/String;)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.account.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static final class C7091b implements e72.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<b> helperRef;

        public C7091b(@NotNull b helper, @NotNull String uin) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            Intrinsics.checkNotNullParameter(uin, "uin");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper, (Object) uin);
            } else {
                this.uin = uin;
                this.helperRef = new WeakReference<>(helper);
            }
        }

        @Override // e72.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = this.helperRef.get();
            if (bVar != null) {
                bVar.j();
            } else {
                QLog.e("AccountSelectHelper", 1, "onDirectLoginSuccess helper is null");
            }
        }

        @Override // e72.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            b bVar = this.helperRef.get();
            if (bVar != null) {
                bVar.m(this.uin);
            } else {
                QLog.e("AccountSelectHelper", 1, "onDirectLoginFailed helper is null");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/account/widget/b$c", "Lcom/tencent/mobileqq/account/adapter/c$a;", "", "uin", "", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class c implements c.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.account.adapter.c.a
        public void a(@NotNull String uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            QLog.i("AccountSelectHelper", 1, "onItemClick");
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).switchAccount(uin, new C7091b(b.this, uin));
            b.this.popupWindowDialog.m();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull Activity activity, @NotNull List<com.tencent.mobileqq.login.account.a> list, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "list");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.activity = activity;
        this.list = list;
        this.isV9 = z16;
        this.isV3 = z17;
        this.popupWindowDialog = new g(activity);
        this.drawerModeVideoReportValueV3 = "";
    }

    private final void e(ViewGroup view) {
        RecyclerView recyclerView = new RecyclerView(this.activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setVerticalScrollBarEnabled(false);
        recyclerView.setAdapter(new com.tencent.mobileqq.account.adapter.c(this.list, new c(), this.isV9));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ex.d(8);
        layoutParams.bottomMargin = ex.d(8);
        view.addView(recyclerView, layoutParams);
    }

    private final View g() {
        int i3;
        LinearLayout linearLayout = new LinearLayout(this.activity);
        if (this.list.size() > 4) {
            i3 = ex.d(278);
        } else {
            i3 = -2;
        }
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ex.d(240), i3));
        e(linearLayout);
        h(linearLayout);
        return linearLayout;
    }

    private final void h(LinearLayout view) {
        String str;
        if (this.isV3) {
            VideoReport.setPageId(view, "pg_bas_drawer");
        } else {
            VideoReport.setPageId(view, "pg_drawer");
        }
        if (QQTheme.isNowThemeIsNight()) {
            str = "1";
        } else {
            str = "0";
        }
        VideoReport.setPageParams(view, "zplan_page_model", str);
        VideoReport.setPageParams(view, "drawer_cover", this.drawerModeVideoReportValueV3);
        VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        QLog.i("AccountSelectHelper", 1, "onSwitchAccountSuccess");
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).closeDrawer();
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.ht7, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final String uin) {
        QLog.i("AccountSelectHelper", 1, "switchFail");
        QQCustomDialog message = DialogUtil.createCustomDialog(this.activity, 230).setTitle(this.activity.getString(R.string.f173179hs4)).setMessage(this.activity.getString(R.string.f173178hs3));
        Intrinsics.checkNotNullExpressionValue(message, "createCustomDialog(activ\u2026count_change_failed_tip))");
        message.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.account.widget.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                b.n(uin, this, dialogInterface, i3);
            }
        });
        message.setCancelable(true);
        message.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String uin, b this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AccountSelectHelper", 1, "switchFail, to LoginActivity");
        Intent intent = new Intent();
        intent.putExtra("is_change_account", true);
        intent.putExtra("switch_account_fail", true);
        intent.putExtra("uin", uin);
        intent.putExtra("befault_uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        RouteUtils.startActivity(this$0.activity, intent, RouterConstants.UI_ROUTER_LOGIN);
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.popupWindowDialog.m();
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.popupWindowDialog.n();
        }
    }

    public final void k(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.drawerModeVideoReportValueV3 = str;
        }
    }

    public final void l(@NotNull View target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) target);
        } else {
            Intrinsics.checkNotNullParameter(target, "target");
            this.popupWindowDialog.q(g()).r(12.0f, 2.5f).s(target);
        }
    }
}
