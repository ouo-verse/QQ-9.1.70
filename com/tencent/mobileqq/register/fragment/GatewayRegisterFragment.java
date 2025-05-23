package com.tencent.mobileqq.register.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.callback.RegisterResult;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.ntregister.NTRegisterMainline;
import com.tencent.mobileqq.register.prettyaccount.PrettyAccountABTestExp;
import com.tencent.mobileqq.register.prettyaccount.PrettyAccountRegisterUtils;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$MaskPhoneData;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0002XYB\u0007\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00100R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010H\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010,R\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/GatewayRegisterFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "initViews", "sh", "qh", "rh", "uh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "v", NodeProps.ON_CLICK, "", "needImmersive", "needStatusTrans", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DKHippyEvent.EVENT_STOP, "onAccountChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", BdhLogUtil.LogTag.Tag_Conn, "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "maskPhoneData", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "D", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "mWechatInfo", "E", "Z", "mIsWechatRegister", UserInfo.SEX_FEMALE, "mIsFromOldAccount", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mBtnBack", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mGatewayRegisterTitle", "I", "mTextCountryCode", "J", "mTextPhoneNum", "K", "mTextGatewayServerHint", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "L", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mCheckBoxPrivacy", "M", "Landroid/view/View;", "mPrivacyPolicyLayout", "N", "mTextPrivacyPolicy", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "P", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mBtnQuickRegister", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mBtnOtherPhoneNumRegister", BdhLogUtil.LogTag.Tag_Req, "mBtnPrettyAccountRegister", "Landroid/widget/LinearLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/LinearLayout;", "mGatewayRegisterContainer", "T", "mBottomPrettyAccountRegister", "U", "mBottomPrettyAccountIcon", "Lmqq/os/MqqHandler;", "V", "Lmqq/os/MqqHandler;", "handler", "<init>", "()V", "W", "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GatewayRegisterFragment extends QPublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final GetLocalPhone$MaskPhoneData maskPhoneData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WechatInfo mWechatInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsWechatRegister;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsFromOldAccount;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mBtnBack;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mGatewayRegisterTitle;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mTextCountryCode;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mTextPhoneNum;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mTextGatewayServerHint;

    /* renamed from: L, reason: from kotlin metadata */
    private QUICheckBox mCheckBoxPrivacy;

    /* renamed from: M, reason: from kotlin metadata */
    private View mPrivacyPolicyLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView mTextPrivacyPolicy;

    /* renamed from: P, reason: from kotlin metadata */
    private QUIButton mBtnQuickRegister;

    /* renamed from: Q, reason: from kotlin metadata */
    private QUIButton mBtnOtherPhoneNumRegister;

    /* renamed from: R, reason: from kotlin metadata */
    private QUIButton mBtnPrettyAccountRegister;

    /* renamed from: S, reason: from kotlin metadata */
    private LinearLayout mGatewayRegisterContainer;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout mBottomPrettyAccountRegister;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView mBottomPrettyAccountIcon;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MqqHandler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/GatewayRegisterFragment$a;", "", "", "COUNTRY_CODE_STR", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.fragment.GatewayRegisterFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/GatewayRegisterFragment$b;", "Lcom/tencent/mobileqq/loginregister/callback/b;", "Lcom/tencent/mobileqq/loginregister/callback/RegisterResult;", "result", "", "a", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "getWechatInfo", "()Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "", "b", "Z", "isFromOldAccount", "()Z", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "c", "Lmqq/util/WeakReference;", "getMActivityRef", "()Lmqq/util/WeakReference;", "mActivityRef", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/register/bean/WechatInfo;Z)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class b implements com.tencent.mobileqq.loginregister.callback.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WechatInfo wechatInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isFromOldAccount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QBaseActivity> mActivityRef;

        public b(@Nullable QBaseActivity qBaseActivity, @Nullable WechatInfo wechatInfo, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qBaseActivity, wechatInfo, Boolean.valueOf(z16));
                return;
            }
            this.wechatInfo = wechatInfo;
            this.isFromOldAccount = z16;
            this.mActivityRef = new WeakReference<>(qBaseActivity);
        }

        @Override // com.tencent.mobileqq.loginregister.callback.b
        public void a(@NotNull RegisterResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            if (result == RegisterResult.RegisterGatewayFailed) {
                com.tencent.mobileqq.register.n.f280469a.m(this.mActivityRef.get(), 4, this.wechatInfo, false, true, this.isFromOldAccount, true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/register/fragment/GatewayRegisterFragment$c", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends MqqHandler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GatewayRegisterFragment.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@NotNull Message msg2) {
            FragmentActivity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("GatewayRegisterFragment", 1, "registerHandler handleMessage: " + msg2.what);
            if (msg2.what == 2004 && (activity = GatewayRegisterFragment.this.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26602);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GatewayRegisterFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.maskPhoneData = aj.f306554f.getMMaskPhoneData();
            this.handler = new c();
        }
    }

    private final void initViews(View view) {
        String str;
        String str2;
        List listOf;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        View findViewById = view.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.back_btn)");
        this.mBtnBack = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.vld);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.gateway_register_title)");
        this.mGatewayRegisterTitle = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f95225ee);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.text_country_code)");
        this.mTextCountryCode = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f95595fe);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.text_phone_num)");
        this.mTextPhoneNum = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f95375et);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.text_gateway_server_hint)");
        this.mTextGatewayServerHint = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f164680tg4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.btn_quick_register)");
        this.mBtnQuickRegister = (QUIButton) findViewById6;
        View findViewById7 = view.findViewById(R.id.tft);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.btn_other_phone_num)");
        this.mBtnOtherPhoneNumRegister = (QUIButton) findViewById7;
        View findViewById8 = view.findViewById(R.id.tfx);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.btn_pretty_account)");
        this.mBtnPrettyAccountRegister = (QUIButton) findViewById8;
        View findViewById9 = view.findViewById(R.id.f72523r3);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.register_privacy_policy_layout)");
        this.mPrivacyPolicyLayout = findViewById9;
        View findViewById10 = view.findViewById(R.id.f72513r2);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.regist\u2026privacy_policy_check_box)");
        this.mCheckBoxPrivacy = (QUICheckBox) findViewById10;
        View findViewById11 = view.findViewById(R.id.f72533r4);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.register_privacy_policy_text)");
        this.mTextPrivacyPolicy = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.vlc);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.gateway_register_container)");
        this.mGatewayRegisterContainer = (LinearLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.zeb);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.more_a\u2026ions_view_pretty_account)");
        this.mBottomPrettyAccountRegister = (LinearLayout) findViewById13;
        View findViewById14 = view.findViewById(R.id.zdx);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.more_a\u2026ions_icon_pretty_account)");
        this.mBottomPrettyAccountIcon = (ImageView) findViewById14;
        ((TextView) view.findViewById(R.id.title)).setVisibility(4);
        qh();
        TextView textView = this.mTextCountryCode;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextCountryCode");
            textView = null;
        }
        textView.setText("+86");
        TextView textView2 = this.mTextPhoneNum;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPhoneNum");
            textView2 = null;
        }
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = this.maskPhoneData;
        if (getLocalPhone$MaskPhoneData != null && (pBStringField2 = getLocalPhone$MaskPhoneData.str_mask_phone) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        textView2.setText(str);
        LoginUtil loginUtil = LoginUtil.f306390a;
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData2 = this.maskPhoneData;
        if (getLocalPhone$MaskPhoneData2 != null && (pBStringField = getLocalPhone$MaskPhoneData2.str_terms_wording) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        TextView textView3 = this.mTextGatewayServerHint;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextGatewayServerHint");
            textView3 = null;
        }
        loginUtil.o(str2, textView3);
        sh();
        rh();
        View[] viewArr = new View[6];
        ImageView imageView2 = this.mBtnBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnBack");
            imageView2 = null;
        }
        viewArr[0] = imageView2;
        QUIButton qUIButton = this.mBtnQuickRegister;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnQuickRegister");
            qUIButton = null;
        }
        viewArr[1] = qUIButton;
        QUIButton qUIButton2 = this.mBtnOtherPhoneNumRegister;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnOtherPhoneNumRegister");
            qUIButton2 = null;
        }
        viewArr[2] = qUIButton2;
        QUIButton qUIButton3 = this.mBtnPrettyAccountRegister;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPrettyAccountRegister");
            qUIButton3 = null;
        }
        viewArr[3] = qUIButton3;
        LinearLayout linearLayout = this.mBottomPrettyAccountRegister;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPrettyAccountRegister");
            linearLayout = null;
        }
        viewArr[4] = linearLayout;
        ImageView imageView3 = this.mBottomPrettyAccountIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPrettyAccountIcon");
        } else {
            imageView = imageView3;
        }
        viewArr[5] = imageView;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(this);
        }
        uh();
    }

    private final void qh() {
        QUIButton qUIButton = null;
        if (this.mIsWechatRegister) {
            TextView textView = this.mGatewayRegisterTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGatewayRegisterTitle");
                textView = null;
            }
            textView.setText(HardCodeUtil.qqStr(R.string.f2036950w));
            QUIButton qUIButton2 = this.mBtnQuickRegister;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnQuickRegister");
                qUIButton2 = null;
            }
            qUIButton2.setText(HardCodeUtil.qqStr(R.string.f2037050x));
            QUIButton qUIButton3 = this.mBtnOtherPhoneNumRegister;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnOtherPhoneNumRegister");
            } else {
                qUIButton = qUIButton3;
            }
            qUIButton.setText(HardCodeUtil.qqStr(R.string.f2037150y));
            return;
        }
        TextView textView2 = this.mGatewayRegisterTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGatewayRegisterTitle");
            textView2 = null;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.f2037250z));
        QUIButton qUIButton4 = this.mBtnQuickRegister;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnQuickRegister");
            qUIButton4 = null;
        }
        qUIButton4.setText(HardCodeUtil.qqStr(R.string.f2036450r));
        QUIButton qUIButton5 = this.mBtnOtherPhoneNumRegister;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnOtherPhoneNumRegister");
        } else {
            qUIButton = qUIButton5;
        }
        qUIButton.setText(HardCodeUtil.qqStr(R.string.f2036250p));
    }

    private final void rh() {
        int i3;
        PrettyAccountRegisterUtils prettyAccountRegisterUtils = PrettyAccountRegisterUtils.f280539a;
        PrettyAccountABTestExp c16 = prettyAccountRegisterUtils.c();
        int i16 = 0;
        if (c16 == PrettyAccountABTestExp.EXP_1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (c16 != PrettyAccountABTestExp.EXP_2) {
            i16 = 4;
        }
        QUIButton qUIButton = this.mBtnPrettyAccountRegister;
        ImageView imageView = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPrettyAccountRegister");
            qUIButton = null;
        }
        qUIButton.setVisibility(i3);
        LinearLayout linearLayout = this.mBottomPrettyAccountRegister;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPrettyAccountRegister");
            linearLayout = null;
        }
        linearLayout.setVisibility(i16);
        ImageView imageView2 = this.mBottomPrettyAccountIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPrettyAccountIcon");
            imageView2 = null;
        }
        ImageView imageView3 = this.mBottomPrettyAccountIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPrettyAccountIcon");
        } else {
            imageView = imageView3;
        }
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBottomPrettyAccountIcon.context");
        imageView2.setBackground(prettyAccountRegisterUtils.b(context));
        com.tencent.mobileqq.register.prettyaccount.c.f280545a.d(c16);
    }

    private final void sh() {
        boolean z16;
        String str;
        PBStringField pBStringField;
        if (this.mWechatInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QUICheckBox qUICheckBox = null;
        if (z16) {
            View view = this.mPrivacyPolicyLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
                view = null;
            }
            view.setVisibility(4);
            QUICheckBox qUICheckBox2 = this.mCheckBoxPrivacy;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxPrivacy");
            } else {
                qUICheckBox = qUICheckBox2;
            }
            qUICheckBox.setChecked(true);
            return;
        }
        View view2 = this.mPrivacyPolicyLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
            view2 = null;
        }
        view2.setVisibility(0);
        QUICheckBox qUICheckBox3 = this.mCheckBoxPrivacy;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxPrivacy");
            qUICheckBox3 = null;
        }
        qUICheckBox3.setChecked(false);
        View view3 = this.mPrivacyPolicyLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
            view3 = null;
        }
        view3.post(new Runnable() { // from class: com.tencent.mobileqq.register.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                GatewayRegisterFragment.th(GatewayRegisterFragment.this);
            }
        });
        LoginUtil loginUtil = LoginUtil.f306390a;
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = this.maskPhoneData;
        if (getLocalPhone$MaskPhoneData != null && (pBStringField = getLocalPhone$MaskPhoneData.str_terms_wording) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        TextView textView = this.mTextPrivacyPolicy;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextPrivacyPolicy");
            textView = null;
        }
        QUICheckBox qUICheckBox4 = this.mCheckBoxPrivacy;
        if (qUICheckBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxPrivacy");
        } else {
            qUICheckBox = qUICheckBox4;
        }
        loginUtil.m(str, textView, qUICheckBox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(GatewayRegisterFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUICheckBox qUICheckBox = this$0.mCheckBoxPrivacy;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxPrivacy");
            qUICheckBox = null;
        }
        LoginUtil.t(qUICheckBox, "key_gateway_register_tips_shown");
    }

    private final void uh() {
        LinearLayout linearLayout = this.mGatewayRegisterContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGatewayRegisterContainer");
            linearLayout = null;
        }
        z.q(linearLayout, getQBaseActivity());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onAccountChanged();
            getQBaseActivity().finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNull(v3);
            int id5 = v3.getId();
            if (id5 == R.id.a47) {
                QBaseActivity qBaseActivity = getQBaseActivity();
                if (qBaseActivity != null) {
                    qBaseActivity.finish();
                }
            } else {
                View view = null;
                if (id5 == R.id.f164680tg4) {
                    cb.d("0X800C321");
                    QUICheckBox qUICheckBox = this.mCheckBoxPrivacy;
                    if (qUICheckBox == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxPrivacy");
                        qUICheckBox = null;
                    }
                    if (qUICheckBox.isChecked()) {
                        if (MobileQQ.sMobileQQ.isLoginByNT()) {
                            NTRegisterMainline nTRegisterMainline = new NTRegisterMainline();
                            QBaseActivity qBaseActivity2 = getQBaseActivity();
                            Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
                            nTRegisterMainline.r(qBaseActivity2, this.mWechatInfo, new b(getQBaseActivity(), this.mWechatInfo, this.mIsFromOldAccount));
                        } else {
                            com.tencent.mobileqq.register.j jVar = com.tencent.mobileqq.register.j.f280455f;
                            QBaseActivity qBaseActivity3 = getQBaseActivity();
                            Intrinsics.checkNotNullExpressionValue(qBaseActivity3, "qBaseActivity");
                            jVar.t(qBaseActivity3, this.mWechatInfo, new b(getQBaseActivity(), this.mWechatInfo, this.mIsFromOldAccount));
                        }
                    } else {
                        Context context = getContext();
                        View view2 = this.mPrivacyPolicyLayout;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
                        } else {
                            view = view2;
                        }
                        com.tencent.mobileqq.util.l.f(context, view);
                    }
                } else if (id5 == R.id.tft) {
                    cb.d("0X800C322");
                    QUICheckBox qUICheckBox2 = this.mCheckBoxPrivacy;
                    if (qUICheckBox2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxPrivacy");
                        qUICheckBox2 = null;
                    }
                    if (qUICheckBox2.isChecked()) {
                        com.tencent.mobileqq.register.n.f280469a.m(getQBaseActivity(), 4, this.mWechatInfo, false, true, this.mIsFromOldAccount, true);
                    } else {
                        Context context2 = getContext();
                        View view3 = this.mPrivacyPolicyLayout;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
                        } else {
                            view = view3;
                        }
                        com.tencent.mobileqq.util.l.f(context2, view);
                    }
                } else {
                    boolean z17 = false;
                    if (id5 == R.id.tfx || id5 == R.id.zeb) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 || id5 == R.id.zdx) {
                        z17 = true;
                    }
                    if (z17) {
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            PrettyAccountRegisterUtils.f280539a.i(activity);
                        }
                        com.tencent.mobileqq.register.prettyaccount.c.f280545a.c(PrettyAccountRegisterUtils.f280539a.c());
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        uh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        boolean z16;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            this.mWechatInfo = (WechatInfo) getQBaseActivity().getIntent().getParcelableExtra("key_wechat_binding_info");
            this.mIsFromOldAccount = getQBaseActivity().getIntent().getBooleanExtra("key_is_from_old_add_account", false);
            if (this.mWechatInfo != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsWechatRegister = z16;
            QLog.i("GatewayRegisterFragment", 1, "mIsWechatRegister : " + z16);
            PrettyAccountRegisterUtils.f280539a.g();
            view = inflater.inflate(R.layout.gy_, container, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            initViews(view);
            if (needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
                ImmersiveUtils.setStatusTextColor(!ThemeUtil.isNowThemeIsNight(null, false, null), requireActivity().getWindow());
            }
            cb.f306645a.i("0X800C320");
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiStartSensor(null, com.tencent.mobileqq.dt.api.c.f203638a);
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport(null, com.tencent.mobileqq.dt.api.c.f203640c, "");
            IQSecChannel iQSecChannel = (IQSecChannel) QRoute.api(IQSecChannel.class);
            String str = com.tencent.mobileqq.dt.api.c.f203644g;
            QUIButton qUIButton = this.mBtnQuickRegister;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnQuickRegister");
                qUIButton = null;
            }
            iQSecChannel.setTouchEvent(str, qUIButton);
            IQSecChannel iQSecChannel2 = (IQSecChannel) QRoute.api(IQSecChannel.class);
            String str2 = com.tencent.mobileqq.dt.api.c.f203645h;
            QUIButton qUIButton2 = this.mBtnOtherPhoneNumRegister;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnOtherPhoneNumRegister");
                qUIButton2 = null;
            }
            iQSecChannel2.setTouchEvent(str2, qUIButton2);
            IQSecChannel iQSecChannel3 = (IQSecChannel) QRoute.api(IQSecChannel.class);
            String str3 = com.tencent.mobileqq.dt.api.c.f203646i;
            QUICheckBox qUICheckBox = this.mCheckBoxPrivacy;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxPrivacy");
                qUICheckBox = null;
            }
            iQSecChannel3.setTouchEvent(str3, qUICheckBox);
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport(null, com.tencent.mobileqq.dt.api.c.f203642e, "");
            z.v(MobileQQ.sMobileQQ.peekAppRuntime(), GatewayRegisterFragment.class, this.handler);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        z.s(MobileQQ.sMobileQQ.peekAppRuntime(), GatewayRegisterFragment.class);
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiEndSensor(null, com.tencent.mobileqq.dt.api.c.f203638a);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport(null, com.tencent.mobileqq.dt.api.c.f203643f, "");
            super.onStop();
        }
    }
}
