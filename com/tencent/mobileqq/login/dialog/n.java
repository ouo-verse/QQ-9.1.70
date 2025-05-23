package com.tencent.mobileqq.login.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.bw;
import com.tencent.mobileqq.login.fragment.BaseLoginFragment;
import com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView;
import com.tencent.mobileqq.login.y;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.widget.LoginFormItemRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001QB?\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010M\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bN\u0010OJ2\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J,\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010-\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010 R\u0016\u00105\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0016\u0010;\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00104R\u0016\u0010=\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00104R\u0016\u0010?\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00104R\"\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00130@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010 R\u0014\u0010J\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/login/dialog/n;", "Lcom/tencent/mobileqq/login/dialog/LoginHalfScreenDialog;", "Landroid/os/Bundle;", "args", "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "currentFragment", "", "logMsg", "", "uinInputHintType", "tReportValue", "", "k0", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "id", "resId", "Landroid/view/View$OnClickListener;", "listener", "Lcom/tencent/mobileqq/widget/LoginFormItemRelativeLayout;", "i0", "r0", "", VideoTemplateParser.ITEM_LIST, "j0", "g0", "action", "q0", "Landroid/view/View;", "W", "", "G", "Z", "isClicked", "H", "Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "J", "Lmqq/app/AppRuntime;", "app", "K", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "L", "hasWxLogin", "M", "Lcom/tencent/mobileqq/widget/LoginFormItemRelativeLayout;", "qqQidEmailLogin", "N", "qqLogin", "P", "qidEmailLogin", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "wxLogin", BdhLogUtil.LogTag.Tag_Req, "phoneLogin", ExifInterface.LATITUDE_SOUTH, "qrCodeLogin", "", "T", "Ljava/util/Map;", "loginGuideItemList", "Lcom/tencent/mobileqq/login/y;", "U", "Lcom/tencent/mobileqq/login/y;", "loginLoading", "V", "isSubAccountLogin", "loginEntrance", "Lcom/tencent/mobileqq/login/widget/LoginPageBottomMoreActionsView$a;", "delegate", "titleText", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ljava/util/List;Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;Lcom/tencent/mobileqq/login/widget/LoginPageBottomMoreActionsView$a;Ljava/lang/String;Landroid/os/Bundle;)V", "X", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class n extends LoginHalfScreenDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isClicked;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final LinearLayout container;

    /* renamed from: J, reason: from kotlin metadata */
    private final AppRuntime app;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: L, reason: from kotlin metadata */
    private final boolean hasWxLogin;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final LoginFormItemRelativeLayout qqQidEmailLogin;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private final LoginFormItemRelativeLayout qqLogin;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private final LoginFormItemRelativeLayout qidEmailLogin;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private final LoginFormItemRelativeLayout wxLogin;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private final LoginFormItemRelativeLayout phoneLogin;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private final LoginFormItemRelativeLayout qrCodeLogin;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, LoginFormItemRelativeLayout> loginGuideItemList;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final y loginLoading;

    /* renamed from: V, reason: from kotlin metadata */
    private final boolean isSubAccountLogin;

    /* renamed from: W, reason: from kotlin metadata */
    private final int loginEntrance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/login/dialog/n$a;", "", "", "LOGIN_GUIDE_PHONE", "I", "LOGIN_GUIDE_QID_EMAIL", "LOGIN_GUIDE_QQ", "LOGIN_GUIDE_QQ_QID_EMAIL", "LOGIN_GUIDE_QR_CODE", "LOGIN_GUIDE_WX", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.dialog.n$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull final QBaseActivity context, @NotNull List<Integer> itemList, @NotNull final BaseLoginFragment currentFragment, @NotNull final LoginPageBottomMoreActionsView.a delegate, @NotNull String titleText, @Nullable final Bundle bundle) {
        super(context);
        Map<Integer, LoginFormItemRelativeLayout> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(currentFragment, "currentFragment");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, itemList, currentFragment, delegate, titleText, bundle);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fge, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026in_guide_container, null)");
        this.root = inflate;
        this.container = (LinearLayout) inflate.findViewById(R.id.yuk);
        this.app = MobileQQ.sMobileQQ.peekAppRuntime();
        this.activity = context;
        this.hasWxLogin = itemList.contains(1);
        LoginFormItemRelativeLayout i06 = i0(context, R.drawable.oh_, R.string.f200654sp, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.o0(n.this, bundle, currentFragment, view);
            }
        });
        this.qqQidEmailLogin = i06;
        LoginFormItemRelativeLayout i07 = i0(context, R.drawable.oh_, R.string.f200644so, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.n0(n.this, bundle, currentFragment, view);
            }
        });
        this.qqLogin = i07;
        LoginFormItemRelativeLayout i08 = i0(context, R.drawable.qui_qid, R.string.f200634sn, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.m0(n.this, bundle, currentFragment, view);
            }
        });
        this.qidEmailLogin = i08;
        LoginFormItemRelativeLayout i09 = i0(context, R.drawable.qui_wechat, R.string.f200674sr, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.s0(n.this, delegate, context, view);
            }
        });
        this.wxLogin = i09;
        LoginFormItemRelativeLayout i010 = i0(context, R.drawable.qui_phone, R.string.f200624sm, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.l0(n.this, currentFragment, bundle, view);
            }
        });
        this.phoneLogin = i010;
        LoginFormItemRelativeLayout i011 = i0(context, R.drawable.qui_qrcode, R.string.f200664sq, new View.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.p0(n.this, context, view);
            }
        });
        this.qrCodeLogin = i011;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(0, i06), TuplesKt.to(3, i07), TuplesKt.to(2, i010), TuplesKt.to(4, i08), TuplesKt.to(1, i09), TuplesKt.to(5, i011));
        this.loginGuideItemList = mutableMapOf;
        this.loginLoading = currentFragment.wh();
        this.isSubAccountLogin = currentFragment.Gh();
        this.loginEntrance = currentFragment.uh();
        j0(itemList);
    }

    private final String g0() {
        if (this.hasWxLogin) {
            return "1";
        }
        return "2";
    }

    private final LoginFormItemRelativeLayout i0(QBaseActivity context, int id5, int resId, View.OnClickListener listener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gya, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.f164379vi)).setImageResource(id5);
        ((TextView) inflate.findViewById(R.id.f61772z1)).setText(resId);
        inflate.setOnClickListener(listener);
        if (!(inflate instanceof LoginFormItemRelativeLayout)) {
            return null;
        }
        return (LoginFormItemRelativeLayout) inflate;
    }

    private final void j0(List<Integer> itemList) {
        if (itemList.isEmpty()) {
            QLog.i("MoreLoginSelectionDialog", 1, "itemList is empty");
            dismiss();
            return;
        }
        LoginFormItemRelativeLayout loginFormItemRelativeLayout = null;
        if (itemList.size() == 1) {
            LoginFormItemRelativeLayout loginFormItemRelativeLayout2 = this.loginGuideItemList.get(itemList.get(0));
            if (loginFormItemRelativeLayout2 != null) {
                loginFormItemRelativeLayout2.setBGType(0);
                loginFormItemRelativeLayout = loginFormItemRelativeLayout2;
            }
            LinearLayout linearLayout = this.container;
            if (linearLayout != null) {
                linearLayout.addView(loginFormItemRelativeLayout);
            }
        } else {
            int size = itemList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 == 0) {
                    LoginFormItemRelativeLayout loginFormItemRelativeLayout3 = this.loginGuideItemList.get(itemList.get(0));
                    if (loginFormItemRelativeLayout3 != null) {
                        loginFormItemRelativeLayout3.setBGType(1);
                    } else {
                        loginFormItemRelativeLayout3 = null;
                    }
                    LinearLayout linearLayout2 = this.container;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(loginFormItemRelativeLayout3);
                    }
                } else if (i3 == itemList.size() - 1) {
                    LoginFormItemRelativeLayout loginFormItemRelativeLayout4 = this.loginGuideItemList.get(itemList.get(itemList.size() - 1));
                    if (loginFormItemRelativeLayout4 != null) {
                        loginFormItemRelativeLayout4.setBGType(3);
                    } else {
                        loginFormItemRelativeLayout4 = null;
                    }
                    LinearLayout linearLayout3 = this.container;
                    if (linearLayout3 != null) {
                        linearLayout3.addView(loginFormItemRelativeLayout4);
                    }
                } else {
                    LoginFormItemRelativeLayout loginFormItemRelativeLayout5 = this.loginGuideItemList.get(itemList.get(i3));
                    if (loginFormItemRelativeLayout5 != null) {
                        loginFormItemRelativeLayout5.setBGType(2);
                    } else {
                        loginFormItemRelativeLayout5 = null;
                    }
                    LinearLayout linearLayout4 = this.container;
                    if (linearLayout4 != null) {
                        linearLayout4.addView(loginFormItemRelativeLayout5);
                    }
                }
            }
        }
        ReportController.r(this.app, "dc00898", "", "", "0X800C2FF", "0X800C2FF", this.loginEntrance, 0, "", g0(), o.c(), "");
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginPageExposure(15, 6);
        if (itemList.contains(5)) {
            q0("0X800BA14");
        }
    }

    private final void k0(Bundle args, BaseLoginFragment currentFragment, String logMsg, int uinInputHintType, String tReportValue) {
        if (this.isClicked) {
            return;
        }
        this.isClicked = true;
        QLog.d("MoreLoginSelectionDialog", 2, logMsg);
        ReportController.r(this.app, "dc00898", "", "", tReportValue, tReportValue, this.loginEntrance, 0, "", g0(), o.c(), "");
        Bundle bundle = new Bundle();
        if (args != null) {
            bundle.putAll(args);
        }
        bundle.putInt("key_uin_input_hint_type", uinInputHintType);
        BaseLoginFragment.Ih(currentFragment, 5, bundle, false, 4, null);
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(n this$0, BaseLoginFragment currentFragment, Bundle bundle, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentFragment, "$currentFragment");
        if (!this$0.isClicked) {
            this$0.isClicked = true;
            QLog.d("MoreLoginSelectionDialog", 2, "phoneLogin clicked");
            ReportController.r(this$0.app, "dc00898", "", "", "0X800C40C", "0X800C40C", this$0.loginEntrance, 0, "", this$0.g0(), o.c(), "");
            aj.f306554f.s(currentFragment, bundle);
            this$0.R();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(n this$0, Bundle bundle, BaseLoginFragment currentFragment, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentFragment, "$currentFragment");
        this$0.k0(bundle, currentFragment, "qidEmailLogin clicked", 2, "0X800C44A");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(n this$0, Bundle bundle, BaseLoginFragment currentFragment, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentFragment, "$currentFragment");
        this$0.k0(bundle, currentFragment, "qq clicked", 1, "0X800C40B");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(n this$0, Bundle bundle, BaseLoginFragment currentFragment, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentFragment, "$currentFragment");
        this$0.k0(bundle, currentFragment, "qqQidEmailLogin clicked", 1, "0X800C40B");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(n this$0, QBaseActivity context, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!this$0.isClicked) {
            this$0.isClicked = true;
            this$0.R();
            Intent intent = context.getIntent();
            Bundle bundle = null;
            if (intent != null) {
                str = intent.getStringExtra("param_qr_code_url");
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e("MoreLoginSelectionDialog", 1, "qrCodeURl is null or empty");
            } else {
                Intent intent2 = context.getIntent();
                if (intent2 != null) {
                    bundle = intent2.getExtras();
                }
                QRoute.createNavigator(context, RouterConstants.UI_ROUTE_BROWSER).withString("url", z.h(com.tencent.open.agent.util.g.k(bundle, str))).withBoolean("hide_more_button", true).withBoolean("key_from_opensdk_qrcode", true).request();
                this$0.q0("0X800BA15");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q0(String action) {
        String str;
        String str2;
        String str3;
        Intent intent = this.activity.getIntent();
        String str4 = null;
        if (intent != null) {
            str = intent.getStringExtra("appid");
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        Intent intent2 = this.activity.getIntent();
        if (intent2 != null) {
            str4 = intent2.getStringExtra("oauth_app_name");
        }
        if (str4 == null) {
            str3 = "";
        } else {
            str3 = str4;
        }
        ReportController.o(this.app, "dc00898", "", "", action, action, 0, 0, str2, "", str3, "");
    }

    private final void r0(QBaseActivity context) {
        bw bwVar = new bw(15, this.isSubAccountLogin, false);
        com.tencent.mobileqq.login.k b16 = al.b(6);
        Intrinsics.checkNotNullExpressionValue(b16, "get<BaseLoginMainline<We\u2026arams>(LOGIN_TYPE_WECHAT)");
        b16.login(context, bwVar, this.loginLoading, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(final n this$0, LoginPageBottomMoreActionsView.a delegate, final QBaseActivity context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(delegate, "$delegate");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!this$0.isClicked) {
            this$0.isClicked = true;
            this$0.R();
            QLog.d("MoreLoginSelectionDialog", 2, "wxLogin clicked isCheckedPrivacyPolicy=" + delegate.a());
            final String c16 = o.c();
            ReportController.r(this$0.app, "dc00898", "", "", "0X800C2DD", "0X800C2DD", this$0.loginEntrance, 0, "", "1", c16, "");
            ReportController.r(this$0.app, "dc00898", "", "", "0X800C2DE", "0X800C2DE", 0, 0, "", "", c16, "");
            PrivacyPolicyHelper.showPrivacyPolicyDlgForWeChatLogin(delegate.a(), context, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    n.u0(n.this, c16, context, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.dialog.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    n.w0(dialogInterface, i3);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(n this$0, String str, QBaseActivity context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        ReportController.r(this$0.app, "dc00898", "", "", "0X800C31F", "0X800C31F", 0, 0, "", "", str, "");
        this$0.r0(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(DialogInterface dialogInterface, int i3) {
        QLog.d("MoreLoginSelectionDialog", 1, "on click cancel.");
    }

    @Override // com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog
    @NotNull
    public View W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.root;
    }
}
