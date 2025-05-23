package com.tencent.mobileqq.login.dialog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.LoginFormItemRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B)\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b!\u0010\"J,\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/login/dialog/e;", "Lcom/tencent/mobileqq/login/dialog/LoginHalfScreenDialog;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "id", "resId", "Landroid/view/View$OnClickListener;", "listener", "Lcom/tencent/mobileqq/widget/LoginFormItemRelativeLayout;", "b0", "", "c0", "Landroid/view/View;", "W", "G", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getContext", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "H", "Landroid/view/View$OnClickListener;", "findPwdOnClickListener", "I", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "J", "Ljava/lang/String;", "inputUin", "Landroid/widget/LinearLayout;", "K", "Landroid/widget/LinearLayout;", "newContainer", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Landroid/view/View$OnClickListener;ILjava/lang/String;)V", "L", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e extends LoginHalfScreenDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final QBaseActivity context;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener findPwdOnClickListener;

    /* renamed from: I, reason: from kotlin metadata */
    private final int entrance;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final String inputUin;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private LinearLayout newContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/login/dialog/e$a;", "", "", "MORE_ACTIONS_FEEDBACK_URL", "Ljava/lang/String;", "MORE_ACTIONS_RETRIEVE_PASSWORD_URL", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.dialog.e$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull QBaseActivity context, @NotNull View.OnClickListener findPwdOnClickListener, int i3, @Nullable String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(findPwdOnClickListener, "findPwdOnClickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, findPwdOnClickListener, Integer.valueOf(i3), str);
            return;
        }
        this.context = context;
        this.findPwdOnClickListener = findPwdOnClickListener;
        this.entrance = i3;
        this.inputUin = str;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(0.0f), ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(30.0f));
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.newContainer = linearLayout;
        c0();
    }

    private final LoginFormItemRelativeLayout b0(QBaseActivity activity, int id5, int resId, View.OnClickListener listener) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.gya, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.f164379vi)).setImageResource(id5);
        ((TextView) inflate.findViewById(R.id.f61772z1)).setText(resId);
        inflate.setOnClickListener(listener);
        if (!(inflate instanceof LoginFormItemRelativeLayout)) {
            return null;
        }
        return (LoginFormItemRelativeLayout) inflate;
    }

    private final void c0() {
        LoginFormItemRelativeLayout b06 = b0(this.context, R.drawable.qui_search, R.string.f211215k8, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.d0(e.this, view);
            }
        });
        if (b06 != null) {
            b06.setBGType(1);
            this.newContainer.addView(b06);
        }
        LoginFormItemRelativeLayout b07 = b0(this.context, R.drawable.qui_safety, R.string.f211235k_, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.e0(e.this, view);
            }
        });
        if (b07 != null) {
            b07.setBGType(2);
            this.newContainer.addView(b07);
        }
        LoginFormItemRelativeLayout b08 = b0(this.context, R.drawable.qui_feedback, R.string.f211205k7, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.f0(e.this, view);
            }
        });
        if (b08 != null) {
            b08.setBGType(3);
            this.newContainer.addView(b08);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.findPwdOnClickListener.onClick(view);
        this$0.R();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", this$0.inputUin, "0X800C1F2", "0X800C1F2", this$0.entrance, 0, "", "", "", o.c());
        Intent intent = new Intent();
        intent.putExtra("url", z.h("https://accounts.qq.com/helpcenter/index?_wv=3&_wwv=128"));
        RouteUtils.startActivity(this$0.context, intent, RouterConstants.UI_ROUTE_BROWSER);
        this$0.R();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", this$0.inputUin, "0X800C1F1", "0X800C1F1", this$0.entrance, 0, "", "", "", o.c());
        Intent intent = new Intent();
        intent.putExtra("url", z.h("https://ti.qq.com/tucao/index.html?productId=429222"));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = false;
        if (peekAppRuntime != null && !peekAppRuntime.isLogin()) {
            z16 = true;
        }
        if (z16) {
            intent.putExtra("hide_more_button", true);
        }
        RouteUtils.startActivity(this$0.context, intent, RouterConstants.UI_ROUTE_BROWSER);
        this$0.R();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog
    @NotNull
    public View W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.newContainer;
    }
}
