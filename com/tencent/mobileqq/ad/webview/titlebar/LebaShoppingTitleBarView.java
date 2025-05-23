package com.tencent.mobileqq.ad.webview.titlebar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001]B\u000f\u0012\u0006\u0010Y\u001a\u00020X\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001f\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010/\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010&R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010<\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010>\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010@\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00105R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00105R\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00105R\u0016\u0010F\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00105R\u0016\u0010H\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00105R\u001b\u0010M\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u00105R\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0014\u0010W\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bU\u0010V\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/ad/webview/titlebar/LebaShoppingTitleBarView;", "Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "l0", "", "show", "o0", "Landroid/app/Dialog;", "j0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Intent;", "i", "", "url", DomainData.DOMAIN_NAME, "", "index", "Landroid/graphics/drawable/Drawable;", "drawable", "pad", "Y", "title", "O", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "onTouch", "Landroid/widget/LinearLayout;", "s0", "Landroid/widget/LinearLayout;", "mDisclaimerProtosContainer", "Landroid/widget/TextView;", "t0", "Landroid/widget/TextView;", "mDisclaimerTitleTv", "u0", "mDisclaimerContentTv", "v0", "mPrivacyProtoTv", "w0", "mUserProtoTv", "x0", "mServerProtoTv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "y0", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mConfirmBtn", "z0", "Ljava/lang/String;", "mWebTitle", "A0", "mDisclaimerTitle", "B0", "mDisclaimerContent", "C0", "mPrivacyPolicyText", "D0", "mUserAgreementText", "E0", "mCustomerServiceText", "F0", "mConfirmText", "G0", "mPrivacyPolicyUrl", "H0", "mUserAgreementUrl", "I0", "mCustomerServiceUrl", "J0", "Lkotlin/Lazy;", "k0", "()Landroid/app/Dialog;", "mDisclaimerDialog", "K0", "Z", "mIsFirstLoad", "L0", "mHomeUrl", "M0", "mIsHomePage", "n0", "()Z", "isNight", "Lcom/tencent/mobileqq/webview/swift/component/v;", "uiStyleHandler", "<init>", "(Lcom/tencent/mobileqq/webview/swift/component/v;)V", "N0", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class LebaShoppingTitleBarView extends SwiftIphoneTitleBarUI implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: N0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: A0, reason: from kotlin metadata */
    @NotNull
    private String mDisclaimerTitle;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private String mDisclaimerContent;

    /* renamed from: C0, reason: from kotlin metadata */
    @NotNull
    private String mPrivacyPolicyText;

    /* renamed from: D0, reason: from kotlin metadata */
    @NotNull
    private String mUserAgreementText;

    /* renamed from: E0, reason: from kotlin metadata */
    @NotNull
    private String mCustomerServiceText;

    /* renamed from: F0, reason: from kotlin metadata */
    @NotNull
    private String mConfirmText;

    /* renamed from: G0, reason: from kotlin metadata */
    @NotNull
    private String mPrivacyPolicyUrl;

    /* renamed from: H0, reason: from kotlin metadata */
    @NotNull
    private String mUserAgreementUrl;

    /* renamed from: I0, reason: from kotlin metadata */
    @NotNull
    private String mCustomerServiceUrl;

    /* renamed from: J0, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDisclaimerDialog;

    /* renamed from: K0, reason: from kotlin metadata */
    private boolean mIsFirstLoad;

    /* renamed from: L0, reason: from kotlin metadata */
    private String mHomeUrl;

    /* renamed from: M0, reason: from kotlin metadata */
    private boolean mIsHomePage;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mDisclaimerProtosContainer;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private TextView mDisclaimerTitleTv;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private TextView mDisclaimerContentTv;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private TextView mPrivacyProtoTv;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private TextView mUserProtoTv;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private TextView mServerProtoTv;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private QUIButton mConfirmBtn;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mWebTitle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/ad/webview/titlebar/LebaShoppingTitleBarView$a;", "", "", "CONFIG_JSON_STR", "Ljava/lang/String;", "CONFIRM_TEXT", "CUSTOMER_SERVICE_TEXT", "CUSTOMER_SERVICE_URL", "DEFAULT_CONFIRM_TEXT", "DEFAULT_CUSTOMER_SERVICE_TEXT", "DEFAULT_CUSTOMER_SERVICE_URL", "DEFAULT_DISCLAIMER_CONTENT", "DEFAULT_DISCLAIMER_TITLE", "DEFAULT_PRIVACY_POLICY_TEXT", "DEFAULT_PRIVACY_POLICY_URL", "DEFAULT_USER_AGREEMENT_TEXT", "DEFAULT_USER_AGREEMENT_URL", "DEFAULT_WEB_TITLE", "DISCLAIMER_CONTENT", "DISCLAIMER_TITLE", "PRIVACY_POLICY_TEXT", "PRIVACY_POLICY_URL", "TAG", "USER_AGREEMENT_TEXT", "USER_AGREEMENT_URL", "WEB_TITLE", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.webview.titlebar.LebaShoppingTitleBarView$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FILED_KID_MODE_URL_FILTER_SWITCH);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LebaShoppingTitleBarView(@NotNull v uiStyleHandler) {
        super(uiStyleHandler);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(uiStyleHandler, "uiStyleHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uiStyleHandler);
            return;
        }
        this.mWebTitle = "\u4eac\u4e1c\u63d0\u4f9b\u670d\u52a1";
        this.mDisclaimerTitle = "\u6e29\u99a8\u63d0\u793a";
        this.mDisclaimerContent = "\u672c\u754c\u9762\u5185\u5bb9\u548c\u670d\u52a1\u7531\u4eac\u4e1c\uff08\u5317\u4eac\u4eac\u4e1c\u4e16\u7eaa\u8d38\u6613\u6709\u9650\u516c\u53f8\uff09\u63d0\u4f9b\u3002\u76f8\u5173\u670d\u52a1\u548c\u8d23\u4efb\u5747\u7531\u4eac\u4e1c\u627f\u62c5\u3002";
        this.mPrivacyPolicyText = "\u4eac\u4e1c\u9690\u79c1\u653f\u7b56";
        this.mUserAgreementText = "\u4eac\u4e1c\u7528\u6237\u670d\u52a1\u534f\u8bae";
        this.mCustomerServiceText = "\u5ba2\u6237\u670d\u52a1";
        this.mConfirmText = "\u6211\u77e5\u9053\u4e86";
        this.mPrivacyPolicyUrl = "https://in.m.jd.com/help/app/private_policy.html";
        this.mUserAgreementUrl = "https://in.m.jd.com/help/app/register_info.html";
        this.mCustomerServiceUrl = "https://ihelp.jd.com/";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.ad.webview.titlebar.LebaShoppingTitleBarView$mDisclaimerDialog$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaShoppingTitleBarView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Dialog invoke() {
                Dialog j06;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Dialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                j06 = LebaShoppingTitleBarView.this.j0();
                return j06;
            }
        });
        this.mDisclaimerDialog = lazy;
        this.mIsFirstLoad = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog j0() {
        int i3;
        WindowManager.LayoutParams attributes;
        int i16;
        Activity activity = this.f314045d.E;
        ReportDialog reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
        TextView textView = null;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.f168232fe3, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.uim);
        Intrinsics.checkNotNullExpressionValue(findViewById, "content.findViewById(R.i\u2026claimer_protos_container)");
        this.mDisclaimerProtosContainer = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.uio);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "content.findViewById(R.id.disclaimer_title_tv)");
        this.mDisclaimerTitleTv = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.uil);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "content.findViewById(R.i\u2026isclaimer_description_tv)");
        this.mDisclaimerContentTv = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f27650gt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "content.findViewById(R.id.privacy_proto_tv)");
        this.mPrivacyProtoTv = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f115746wv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "content.findViewById(R.id.user_proto_tv)");
        this.mUserProtoTv = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f83354jb);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "content.findViewById(R.id.server_proto_tv)");
        this.mServerProtoTv = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.uik);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "content.findViewById(R.id.disclaimer_confirm_btn)");
        this.mConfirmBtn = (QUIButton) findViewById7;
        TextView textView2 = this.mDisclaimerTitleTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDisclaimerTitleTv");
            textView2 = null;
        }
        textView2.setText(this.mDisclaimerTitle);
        TextView textView3 = this.mDisclaimerContentTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDisclaimerContentTv");
            textView3 = null;
        }
        textView3.setText(this.mDisclaimerContent);
        TextView textView4 = this.mPrivacyProtoTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyProtoTv");
            textView4 = null;
        }
        textView4.setText(this.mPrivacyPolicyText);
        TextView textView5 = this.mUserProtoTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserProtoTv");
            textView5 = null;
        }
        textView5.setText(this.mUserAgreementText);
        TextView textView6 = this.mServerProtoTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mServerProtoTv");
            textView6 = null;
        }
        textView6.setText(this.mCustomerServiceText);
        QUIButton qUIButton = this.mConfirmBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
            qUIButton = null;
        }
        qUIButton.setText(this.mConfirmText);
        TextView[] textViewArr = new TextView[4];
        TextView textView7 = this.mPrivacyProtoTv;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyProtoTv");
            textView7 = null;
        }
        textViewArr[0] = textView7;
        TextView textView8 = this.mUserProtoTv;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserProtoTv");
            textView8 = null;
        }
        textViewArr[1] = textView8;
        TextView textView9 = this.mServerProtoTv;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mServerProtoTv");
            textView9 = null;
        }
        textViewArr[2] = textView9;
        QUIButton qUIButton2 = this.mConfirmBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
            qUIButton2 = null;
        }
        textViewArr[3] = qUIButton2;
        for (int i17 = 0; i17 < 4; i17++) {
            textViewArr[i17].setOnClickListener(this);
        }
        GdtUIUtils.setViewTopRadius(inflate, ViewUtils.dpToPx(5.0f));
        QUIButton qUIButton3 = this.mConfirmBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
            qUIButton3 = null;
        }
        GdtUIUtils.setViewRadius(qUIButton3, ViewUtils.dpToPx(1.0f));
        if (n0()) {
            i3 = Color.parseColor("#242628");
        } else {
            i3 = -1;
        }
        inflate.setBackgroundColor(i3);
        TextView[] textViewArr2 = new TextView[2];
        TextView textView10 = this.mDisclaimerTitleTv;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDisclaimerTitleTv");
            textView10 = null;
        }
        textViewArr2[0] = textView10;
        TextView textView11 = this.mDisclaimerContentTv;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDisclaimerContentTv");
        } else {
            textView = textView11;
        }
        textViewArr2[1] = textView;
        for (int i18 = 0; i18 < 2; i18++) {
            TextView textView12 = textViewArr2[i18];
            if (n0()) {
                i16 = -1;
            } else {
                i16 = -16777216;
            }
            textView12.setTextColor(i16);
        }
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        reportDialog.setContentView(inflate);
        Window window = reportDialog.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            Intrinsics.checkNotNullExpressionValue(attributes, "attributes");
            attributes.gravity = 8388691;
            attributes.width = -1;
            attributes.height = -2;
            attributes.flags = attributes.flags | 512 | 1024;
            attributes.y = -x.e(activity);
        }
        return reportDialog;
    }

    private final Dialog k0() {
        return (Dialog) this.mDisclaimerDialog.getValue();
    }

    private final void l0() {
        Intent intent;
        WebViewProvider webViewProvider = this.f314045d.P;
        if (webViewProvider != null && (intent = webViewProvider.getIntent()) != null) {
            String stringExtra = intent.getStringExtra("config_json_str");
            if (stringExtra != null) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    String optString = jSONObject.optString("webTitle", "\u4eac\u4e1c\u63d0\u4f9b\u670d\u52a1");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(WEB_TITLE, DEFAULT_WEB_TITLE)");
                    this.mWebTitle = optString;
                    String optString2 = jSONObject.optString("disclaimer_title", "\u6e29\u99a8\u63d0\u793a");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(DISCLAIMER_TIT\u2026DEFAULT_DISCLAIMER_TITLE)");
                    this.mDisclaimerTitle = optString2;
                    String optString3 = jSONObject.optString("disclaimer_content", "\u672c\u754c\u9762\u5185\u5bb9\u548c\u670d\u52a1\u7531\u4eac\u4e1c\uff08\u5317\u4eac\u4eac\u4e1c\u4e16\u7eaa\u8d38\u6613\u6709\u9650\u516c\u53f8\uff09\u63d0\u4f9b\u3002\u76f8\u5173\u670d\u52a1\u548c\u8d23\u4efb\u5747\u7531\u4eac\u4e1c\u627f\u62c5\u3002");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(DISCLAIMER_CON\u2026FAULT_DISCLAIMER_CONTENT)");
                    this.mDisclaimerContent = optString3;
                    String optString4 = jSONObject.optString("privacy_policy_text", "\u4eac\u4e1c\u9690\u79c1\u653f\u7b56");
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(PRIVACY_POLICY\u2026AULT_PRIVACY_POLICY_TEXT)");
                    this.mPrivacyPolicyText = optString4;
                    String optString5 = jSONObject.optString("user_agreement_text", "\u4eac\u4e1c\u7528\u6237\u670d\u52a1\u534f\u8bae");
                    Intrinsics.checkNotNullExpressionValue(optString5, "optString(USER_AGREEMENT\u2026AULT_USER_AGREEMENT_TEXT)");
                    this.mUserAgreementText = optString5;
                    String optString6 = jSONObject.optString("customer_service_text", "\u5ba2\u6237\u670d\u52a1");
                    Intrinsics.checkNotNullExpressionValue(optString6, "optString(CUSTOMER_SERVI\u2026LT_CUSTOMER_SERVICE_TEXT)");
                    this.mCustomerServiceText = optString6;
                    String optString7 = jSONObject.optString(AECameraConstants.KEY_CONFIRM_TEXT, "\u6211\u77e5\u9053\u4e86");
                    Intrinsics.checkNotNullExpressionValue(optString7, "optString(CONFIRM_TEXT, DEFAULT_CONFIRM_TEXT)");
                    this.mConfirmText = optString7;
                    String optString8 = jSONObject.optString("privacy_policy_url", "https://in.m.jd.com/help/app/private_policy.html");
                    Intrinsics.checkNotNullExpressionValue(optString8, "optString(PRIVACY_POLICY\u2026FAULT_PRIVACY_POLICY_URL)");
                    this.mPrivacyPolicyUrl = optString8;
                    String optString9 = jSONObject.optString("user_agreement_url", "https://in.m.jd.com/help/app/register_info.html");
                    Intrinsics.checkNotNullExpressionValue(optString9, "optString(USER_AGREEMENT\u2026FAULT_USER_AGREEMENT_URL)");
                    this.mUserAgreementUrl = optString9;
                    String optString10 = jSONObject.optString("customer_service_url", "https://ihelp.jd.com/");
                    Intrinsics.checkNotNullExpressionValue(optString10, "optString(CUSTOMER_SERVI\u2026ULT_CUSTOMER_SERVICE_URL)");
                    this.mCustomerServiceUrl = optString10;
                } catch (Exception e16) {
                    QLog.e("LebaShoppingTitleBarView", 1, "init data error...", e16);
                }
            }
            String stringExtra2 = intent.getStringExtra("url");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra2, "it.getStringExtra(\"url\") ?: \"\"");
            }
            this.mHomeUrl = stringExtra2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m0(LebaShoppingTitleBarView this$0, int i3, Bundle bundle) {
        String str;
        boolean z16;
        boolean contains$default;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str3 = null;
        if (i3 != 7) {
            if (i3 == 8 && this$0.mIsFirstLoad) {
                this$0.mIsFirstLoad = false;
                if (bundle != null) {
                    String str4 = this$0.mHomeUrl;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHomeUrl");
                        str4 = null;
                    }
                    str2 = bundle.getString("url", str4);
                } else {
                    str2 = null;
                }
                if (str2 == null && (str2 = this$0.mHomeUrl) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeUrl");
                } else {
                    str3 = str2;
                }
                this$0.mHomeUrl = str3;
                return;
            }
            return;
        }
        if (bundle != null) {
            str = bundle.getString("url", "");
        } else {
            str = null;
        }
        if (str != null) {
            String str5 = this$0.mHomeUrl;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeUrl");
                str5 = null;
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str5, false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
                if (!z16) {
                    this$0.M.setVisibility(0);
                    this$0.O(this$0.mWebTitle);
                    this$0.o0(true);
                    this$0.mIsHomePage = true;
                    return;
                }
                this$0.mIsHomePage = false;
                this$0.o0(false);
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final boolean n0() {
        return ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void o0(boolean show) {
        Drawable drawable;
        if (show) {
            drawable = BaseApplication.context.getResources().getDrawable(R.drawable.qui_caution_circle);
        } else {
            drawable = null;
        }
        Y(2, drawable, 0);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void O(@Nullable String title) {
        String url;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) title);
            return;
        }
        if (this.mIsHomePage) {
            return;
        }
        TouchWebView u16 = this.f314045d.u();
        boolean z16 = false;
        if (u16 != null && (url = u16.getUrl()) != null) {
            String str = this.mHomeUrl;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeUrl");
                str = null;
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) str, false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
            }
        }
        if (z16) {
            o0(true);
            this.mIsHomePage = true;
            super.O(this.mWebTitle);
            return;
        }
        super.O(title);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void Y(int index, @Nullable Drawable drawable, int pad) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(index), drawable, Integer.valueOf(pad));
        } else {
            if (this.mIsHomePage) {
                return;
            }
            super.Y(index, drawable, pad);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        l0();
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        this.f314059m.setOnClickListener(this);
        this.f314059m.setOnTouchListener(this);
        this.f314047e.f314620c &= -5;
        this.f314045d.b0(new v.d() { // from class: com.tencent.mobileqq.ad.webview.titlebar.a
            @Override // com.tencent.mobileqq.webview.swift.component.v.d
            public final void a(int i3, Bundle bundle) {
                LebaShoppingTitleBarView.m0(LebaShoppingTitleBarView.this, i3, bundle);
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void n(@Nullable Intent i3, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) i3, (Object) url);
        } else {
            super.n(i3, url);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.ivTitleName) {
                if (this.mIsHomePage) {
                    k0().show();
                }
            } else if (num != null && num.intValue() == R.id.f27650gt) {
                TouchWebView u16 = this.f314045d.u();
                if (u16 != null) {
                    u16.loadUrl(this.mPrivacyPolicyUrl);
                }
            } else if (num != null && num.intValue() == R.id.f115746wv) {
                TouchWebView u17 = this.f314045d.u();
                if (u17 != null) {
                    u17.loadUrl(this.mUserAgreementUrl);
                }
            } else if (num != null && num.intValue() == R.id.f83354jb) {
                TouchWebView u18 = this.f314045d.u();
                if (u18 != null) {
                    u18.loadUrl(this.mCustomerServiceUrl);
                }
            } else if (num != null && num.intValue() == R.id.uik) {
                k0().dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            this.f314045d.b0(null);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num == null || num.intValue() != R.id.ivTitleName) {
            return false;
        }
        Drawable drawable = this.f314059m.getCompoundDrawables()[2];
        if (event == null || drawable == null || !this.mIsHomePage || event.getX() >= (this.f314059m.getRight() - drawable.getBounds().width()) - this.f314059m.getPaddingRight()) {
            return false;
        }
        return true;
    }
}
