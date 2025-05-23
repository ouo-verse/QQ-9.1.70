package com.tencent.mobileqq.login.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.ai;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.be;
import com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.bk;
import com.tencent.mobileqq.util.bw;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$MaskPhoneData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u00105R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010@R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/GatewayLoginFragment;", "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "Landroid/view/View$OnClickListener;", "", "Vh", "Landroid/view/View;", "view", "initViews", "Th", "", "tValue", "r2", "r3", "r4", "r5", "Xh", "Wh", "ai", "msg", UIJsPlugin.EVENT_SHOW_TOAST, "Zh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "v", NodeProps.ON_CLICK, "", TangramHippyConstants.LOGIN_TYPE, "uin", "bundle", "Lh", "Lcom/tencent/mobileqq/login/aj;", "failedInfo", "Kh", "Ph", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "K", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "maskPhoneData", "Landroid/widget/LinearLayout;", "L", "Landroid/widget/LinearLayout;", "contentView", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "textCountryCode", "N", "textPhoneNum", "P", "textGatewayServerHint", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkBoxPrivacy", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "privacyPolicyLayout", ExifInterface.LATITUDE_SOUTH, "textPrivacyPolicy", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "T", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btnQuickLogin", "U", "btnOtherPhoneNumLogin", "Lcom/tencent/mobileqq/login/widget/LoginPageBottomMoreActionsView;", "V", "Lcom/tencent/mobileqq/login/widget/LoginPageBottomMoreActionsView;", "loginPageBottomMoreActionsView", "", "W", "Z", "mIsCheckedQuickLoginAgreement", "<init>", "()V", "X", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GatewayLoginFragment extends BaseLoginFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GetLocalPhone$MaskPhoneData maskPhoneData;

    /* renamed from: L, reason: from kotlin metadata */
    private LinearLayout contentView;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView textCountryCode;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView textPhoneNum;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView textGatewayServerHint;

    /* renamed from: Q, reason: from kotlin metadata */
    private QUICheckBox checkBoxPrivacy;

    /* renamed from: R, reason: from kotlin metadata */
    private View privacyPolicyLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView textPrivacyPolicy;

    /* renamed from: T, reason: from kotlin metadata */
    private QUIButton btnQuickLogin;

    /* renamed from: U, reason: from kotlin metadata */
    private View btnOtherPhoneNumLogin;

    /* renamed from: V, reason: from kotlin metadata */
    private LoginPageBottomMoreActionsView loginPageBottomMoreActionsView;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mIsCheckedQuickLoginAgreement;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/GatewayLoginFragment$a;", "", "", "COUNTRY_CODE_STR", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.fragment.GatewayLoginFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/fragment/GatewayLoginFragment$b", "Lcom/tencent/mobileqq/login/widget/LoginPageBottomMoreActionsView$a;", "", "a", "", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements LoginPageBottomMoreActionsView.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GatewayLoginFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QUICheckBox qUICheckBox = GatewayLoginFragment.this.checkBoxPrivacy;
                if (qUICheckBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrivacy");
                    qUICheckBox = null;
                }
                return qUICheckBox.isChecked();
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        @Override // com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20969);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GatewayLoginFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void Th() {
        View view = null;
        if (uh() == 16) {
            QUICheckBox qUICheckBox = this.checkBoxPrivacy;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrivacy");
                qUICheckBox = null;
            }
            qUICheckBox.setChecked(true);
            View view2 = this.privacyPolicyLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyPolicyLayout");
            } else {
                view = view2;
            }
            view.setVisibility(4);
            return;
        }
        QUICheckBox qUICheckBox2 = this.checkBoxPrivacy;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrivacy");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setChecked(false);
        View view3 = this.privacyPolicyLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyPolicyLayout");
            view3 = null;
        }
        view3.setVisibility(0);
        View view4 = this.privacyPolicyLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyPolicyLayout");
        } else {
            view = view4;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.k
            @Override // java.lang.Runnable
            public final void run() {
                GatewayLoginFragment.Uh(GatewayLoginFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(GatewayLoginFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUICheckBox qUICheckBox = this$0.checkBoxPrivacy;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrivacy");
            qUICheckBox = null;
        }
        LoginUtil.t(qUICheckBox, "key_gateway_login_tips_shown");
    }

    private final void Vh() {
        LinearLayout linearLayout = null;
        if (z.b(getContext())) {
            LinearLayout linearLayout2 = this.contentView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
            } else {
                linearLayout = linearLayout2;
            }
            z.y(linearLayout);
            return;
        }
        LinearLayout linearLayout3 = this.contentView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            linearLayout = linearLayout3;
        }
        z.A(linearLayout);
    }

    private final void Wh() {
        String str;
        PBStringField pBStringField;
        QLog.i("GatewayPhoneLoginFragment", 1, "start phone quick login");
        if (getQBaseActivity() == null) {
            return;
        }
        Zh();
        be.a l3 = new be.a(4, uh()).l(getQBaseActivity().getIntent().getStringExtra("uin"));
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = this.maskPhoneData;
        if (getLocalPhone$MaskPhoneData != null && (pBStringField = getLocalPhone$MaskPhoneData.str_mask_phone) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        be h16 = l3.i(str).j(Eh()).m(Gh()).k(Fh()).h();
        com.tencent.mobileqq.login.k b16 = al.b(4);
        Intrinsics.checkNotNullExpressionValue(b16, "get<BaseLoginMainline<Ba\u2026ONE_GATEWAY\n            )");
        b16.login(getQBaseActivity(), h16, wh(), th(4));
    }

    private final void Xh(String tValue, String r26, String r36, String r46, String r56) {
        ReportController.r(getAppRuntime(), "dc00898", "", "", tValue, tValue, uh(), 0, r26, r36, r46, r56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(GatewayLoginFragment this$0, String msg2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(this$0.getActivity(), msg2, 0).create(i3).show();
    }

    private final void Zh() {
        QUIButton qUIButton = this.btnQuickLogin;
        if (qUIButton == null) {
            return;
        }
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnQuickLogin");
            qUIButton = null;
        }
        if (!qUIButton.m()) {
            QUIButton qUIButton3 = this.btnQuickLogin;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnQuickLogin");
            } else {
                qUIButton2 = qUIButton3;
            }
            qUIButton2.r();
        }
    }

    private final void ai() {
        Intent intent;
        QLog.d("GatewayPhoneLoginFragment", 1, "toPhoneSmsLogin");
        Bundle bundle = new Bundle();
        QUICheckBox qUICheckBox = this.checkBoxPrivacy;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrivacy");
            qUICheckBox = null;
        }
        bundle.putBoolean("has_checked_agreement", qUICheckBox.isChecked());
        QBaseActivity qBaseActivity = getQBaseActivity();
        boolean z16 = false;
        if (qBaseActivity != null && (intent = qBaseActivity.getIntent()) != null) {
            z16 = intent.getBooleanExtra("key_from_wx_login", false);
        }
        bundle.putBoolean("key_from_wx_login", z16);
        BaseLoginFragment.Ih(this, 4, bundle, false, 4, null);
    }

    private final void initViews(View view) {
        String str;
        String str2;
        String str3;
        List listOf;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        View findViewById = view.findViewById(R.id.yu9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.login_\u2026teway_login_content_view)");
        this.contentView = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.f95225ee);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.text_country_code)");
        this.textCountryCode = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f95595fe);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.text_phone_num)");
        this.textPhoneNum = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f95375et);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.text_gateway_server_hint)");
        this.textGatewayServerHint = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f164679tg3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.btn_quick_login)");
        this.btnQuickLogin = (QUIButton) findViewById5;
        View findViewById6 = view.findViewById(R.id.tft);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.btn_other_phone_num)");
        this.btnOtherPhoneNumLogin = findViewById6;
        View findViewById7 = view.findViewById(R.id.yug);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.login_privacy_policy_layout)");
        this.privacyPolicyLayout = findViewById7;
        View findViewById8 = view.findViewById(R.id.yue);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.login_privacy_policy_check_box)");
        this.checkBoxPrivacy = (QUICheckBox) findViewById8;
        View findViewById9 = view.findViewById(R.id.yuh);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.login_privacy_policy_text)");
        this.textPrivacyPolicy = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.zea);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.more_actions_view_layout)");
        this.loginPageBottomMoreActionsView = (LoginPageBottomMoreActionsView) findViewById10;
        Th();
        TextView textView = this.textCountryCode;
        View view2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textCountryCode");
            textView = null;
        }
        textView.setText("+86");
        TextView textView2 = this.textPhoneNum;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textPhoneNum");
            textView2 = null;
        }
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = this.maskPhoneData;
        if (getLocalPhone$MaskPhoneData != null && (pBStringField3 = getLocalPhone$MaskPhoneData.str_mask_phone) != null) {
            str = pBStringField3.get();
        } else {
            str = null;
        }
        textView2.setText(str);
        if (FontSettingManager.getFontLevel() >= 18.0f) {
            if (FontSettingManager.getFontLevel() >= 20.0f) {
                TextView textView3 = this.textCountryCode;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textCountryCode");
                    textView3 = null;
                }
                textView3.setTextSize(34.0f);
                TextView textView4 = this.textPhoneNum;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textPhoneNum");
                    textView4 = null;
                }
                textView4.setTextSize(34.0f);
            } else {
                TextView textView5 = this.textCountryCode;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textCountryCode");
                    textView5 = null;
                }
                textView5.setTextSize(37.0f);
                TextView textView6 = this.textPhoneNum;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textPhoneNum");
                    textView6 = null;
                }
                textView6.setTextSize(37.0f);
            }
        }
        LoginUtil loginUtil = LoginUtil.f306390a;
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData2 = this.maskPhoneData;
        if (getLocalPhone$MaskPhoneData2 != null && (pBStringField2 = getLocalPhone$MaskPhoneData2.str_terms_wording) != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        TextView textView7 = this.textGatewayServerHint;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textGatewayServerHint");
            textView7 = null;
        }
        loginUtil.o(str2, textView7);
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData3 = this.maskPhoneData;
        if (getLocalPhone$MaskPhoneData3 != null && (pBStringField = getLocalPhone$MaskPhoneData3.str_terms_wording) != null) {
            str3 = pBStringField.get();
        } else {
            str3 = null;
        }
        TextView textView8 = this.textPrivacyPolicy;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textPrivacyPolicy");
            textView8 = null;
        }
        QUICheckBox qUICheckBox = this.checkBoxPrivacy;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrivacy");
            qUICheckBox = null;
        }
        loginUtil.m(str3, textView8, qUICheckBox);
        LoginPageBottomMoreActionsView.b bVar = new LoginPageBottomMoreActionsView.b();
        bVar.f242766f = new b();
        bVar.f242767g = new Bundle();
        boolean booleanExtra = getQBaseActivity().getIntent().getBooleanExtra("key_from_wx_login", false);
        bVar.f242767g.putBoolean("key_from_wx_login", booleanExtra);
        bVar.f242761a = booleanExtra;
        LoginPageBottomMoreActionsView loginPageBottomMoreActionsView = this.loginPageBottomMoreActionsView;
        if (loginPageBottomMoreActionsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginPageBottomMoreActionsView");
            loginPageBottomMoreActionsView = null;
        }
        loginPageBottomMoreActionsView.I(this, bVar);
        View[] viewArr = new View[2];
        QUIButton qUIButton = this.btnQuickLogin;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnQuickLogin");
            qUIButton = null;
        }
        viewArr[0] = qUIButton;
        View view3 = this.btnOtherPhoneNumLogin;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnOtherPhoneNumLogin");
        } else {
            view2 = view3;
        }
        viewArr[1] = view2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(this);
        }
    }

    private final void showToast(final String msg2) {
        final int dpToPx = ViewUtils.dpToPx(44.0f);
        QLog.i("GatewayPhoneLoginFragment", 2, "showToast offsetY = " + dpToPx);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.j
            @Override // java.lang.Runnable
            public final void run() {
                GatewayLoginFragment.Yh(GatewayLoginFragment.this, msg2, dpToPx);
            }
        });
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Kh(int loginType, @NotNull aj failedInfo) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, loginType, (Object) failedInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(failedInfo, "failedInfo");
        super.Kh(loginType, failedInfo);
        if (getQBaseActivity() != null && !getQBaseActivity().isFinishing()) {
            int i16 = failedInfo.f241864a;
            if (i16 != 160) {
                if (i16 != 219) {
                    bk.k("0X800B8D0");
                    i3 = 5;
                } else {
                    bk.k("0X800B8D6");
                    i3 = 1;
                }
            } else {
                bk.k("0X800B8D0");
                i3 = 3;
            }
            bw.c(failedInfo.f241864a, failedInfo.f241866c);
            bk.i(String.valueOf(i3));
            if (!ai.l(getQBaseActivity(), uh(), failedInfo, false)) {
                String string = getString(R.string.f2035950m);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_quick_login_need_sms)");
                showToast(string);
                ai();
            }
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Lh(int loginType, @NotNull String uin, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(loginType), uin, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        super.Lh(loginType, uin, bundle);
        if (getQBaseActivity() != null && !getQBaseActivity().isFinishing()) {
            bk.i("2");
            bw.c(0, "SUCCESS");
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QUIButton qUIButton = this.btnQuickLogin;
        if (qUIButton == null) {
            return;
        }
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnQuickLogin");
            qUIButton = null;
        }
        qUIButton.s();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNull(v3);
            int id5 = v3.getId();
            if (id5 == R.id.f164679tg3) {
                QUICheckBox qUICheckBox = this.checkBoxPrivacy;
                View view = null;
                if (qUICheckBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkBoxPrivacy");
                    qUICheckBox = null;
                }
                if (qUICheckBox.isChecked()) {
                    if (this.maskPhoneData == null) {
                        ai();
                    } else {
                        this.mIsCheckedQuickLoginAgreement = true;
                        Wh();
                    }
                    str = "1";
                } else {
                    Context context = getContext();
                    View view2 = this.privacyPolicyLayout;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("privacyPolicyLayout");
                    } else {
                        view = view2;
                    }
                    com.tencent.mobileqq.util.l.f(context, view);
                    str = "2";
                }
                Xh("0X800C40D", "", "", com.tencent.mobileqq.statistics.o.c(), "");
                Xh("0X800B8CD", str, "", com.tencent.mobileqq.statistics.o.c(), "");
            } else if (id5 == R.id.tft) {
                Xh("0X800C40E", "", "", com.tencent.mobileqq.statistics.o.c(), "");
                Xh("0X800B8CE", "1", "", com.tencent.mobileqq.statistics.o.c(), "");
                ai();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Vh();
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        GetLocalPhone$MaskPhoneData mMaskPhoneData = com.tencent.mobileqq.util.aj.f306554f.getMMaskPhoneData();
        this.maskPhoneData = mMaskPhoneData;
        if (savedInstanceState != null && mMaskPhoneData == null) {
            QLog.w("GatewayPhoneLoginFragment", 1, "maskPhoneData is null, finish activity");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            view = inflater.inflate(R.layout.gy9, container, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            initViews(view);
            Vh();
            bk.j(uh(), "");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
