package com.tencent.mobileqq.register.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.fragment.RegisterNewBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.ntregister.NTRegisterMainline;
import com.tencent.mobileqq.register.prettyaccount.PrettyAccountABTestExp;
import com.tencent.mobileqq.register.prettyaccount.PrettyAccountRegisterUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.q;
import com.tencent.mobileqq.util.s;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0087\u0001B\t\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0003J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J&\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\"\u0010,\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0005H\u0016J*\u00104\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0016J*\u00106\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u0014H\u0016J\u0012\u00108\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u000107H\u0016J\b\u00109\u001a\u00020\u0019H\u0016J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0019H\u0016J\b\u0010?\u001a\u00020\u0014H\u0016J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0019H\u0016J\b\u0010B\u001a\u00020\u0007H\u0016R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001e\u0010K\u001a\n H*\u0004\u0018\u00010G0G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010P\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010T\u001a\n H*\u0004\u0018\u00010Q0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010OR\u0016\u0010X\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010OR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010[R\u0016\u0010h\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010[R\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010cR\u0016\u0010u\u001a\u00020s8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010[R\u0016\u0010}\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010oR\u0016\u0010\u007f\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010[R\u0018\u0010\u0081\u0001\u001a\u00020v8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010xR\u0018\u0010\u0083\u0001\u001a\u00020v8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010x\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/RegisterPhoneNumFragment;", "Lcom/tencent/mobileqq/fragment/RegisterNewBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/text/TextWatcher;", "Lcom/tencent/mobileqq/widget/ConfigClearableEditText$d;", "Landroid/view/View;", "view", "", "initViews", "Rh", "Yh", "Sh", "Xh", "Mh", "Nh", "ei", "Oh", "Ph", "Qh", "gi", "", "resId", "icon", "di", "fi", "", "hasFocus", "hi", "ci", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onResume", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "v", NodeProps.ON_CLICK, "", ReportConstant.COSTREPORT_PREFIX, "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "needStatusTrans", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", NodeProps.VISIBLE, "Af", "w9", "pressed", "Mg", "v2", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "J", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "mWechatInfo", "", "kotlin.jvm.PlatformType", "K", "Ljava/lang/String;", "mStrCountryName", "L", "mCountryEnglishName", "M", "Z", "mIsValidPhoneNum", "Lmqq/app/AppRuntime;", "N", "Lmqq/app/AppRuntime;", "mApp", "P", "mIsFromOldAddAccount", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mIsFromGatewayRegister", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "mPrivacyPolicyLayout", "Landroid/widget/CheckBox;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/CheckBox;", "mPrivacyPolicyCheckBox", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "mTvCountryCode", "U", "mPhoneNumRegisterLayout", "V", "mChangeCountryCodeLayout", "Lcom/tencent/mobileqq/widget/ConfigClearableEditText;", "W", "Lcom/tencent/mobileqq/widget/ConfigClearableEditText;", "mEditText", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "X", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mBtnNext", "Y", "mTvPrivacyPolicy", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "mPhoneNumInputLayout", "Landroid/widget/ImageView;", "a0", "Landroid/widget/ImageView;", "mBackBtn", "b0", "mPhoneNumRegisterContainer", "c0", "mBtnPrettyAccountRegister", "d0", "mBottomPrettyAccountRegister", "e0", "mBottomPrettyAccountIcon", "f0", "mPhoneNumClean", "<init>", "()V", "g0", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RegisterPhoneNumFragment extends RegisterNewBaseFragment implements View.OnClickListener, TextWatcher, ConfigClearableEditText.d {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private WechatInfo mWechatInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private String mStrCountryName;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String mCountryEnglishName;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsValidPhoneNum;

    /* renamed from: N, reason: from kotlin metadata */
    private final AppRuntime mApp;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mIsFromOldAddAccount;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean mIsFromGatewayRegister;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout mPrivacyPolicyLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private CheckBox mPrivacyPolicyCheckBox;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView mTvCountryCode;

    /* renamed from: U, reason: from kotlin metadata */
    private LinearLayout mPhoneNumRegisterLayout;

    /* renamed from: V, reason: from kotlin metadata */
    private LinearLayout mChangeCountryCodeLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private ConfigClearableEditText mEditText;

    /* renamed from: X, reason: from kotlin metadata */
    private QUIButton mBtnNext;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView mTvPrivacyPolicy;

    /* renamed from: Z, reason: from kotlin metadata */
    private RelativeLayout mPhoneNumInputLayout;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ImageView mBackBtn;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mPhoneNumRegisterContainer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private QUIButton mBtnPrettyAccountRegister;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mBottomPrettyAccountRegister;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ImageView mBottomPrettyAccountIcon;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ImageView mPhoneNumClean;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/RegisterPhoneNumFragment$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "", "hideCheckLayout", "isFromOldAddAccount", "isFromGatewayRegister", "", "a", "", "INPUT_HINT_TEXT_SIZE_SP", "I", "", "INPUT_LAYOUT_WIDTH", UserInfo.SEX_FEMALE, "REQUEST_LOCATION", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.fragment.RegisterPhoneNumFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable QBaseActivity activity, @Nullable WechatInfo wechatInfo, boolean hideCheckLayout, boolean isFromOldAddAccount, boolean isFromGatewayRegister) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, wechatInfo, Boolean.valueOf(hideCheckLayout), Boolean.valueOf(isFromOldAddAccount), Boolean.valueOf(isFromGatewayRegister));
                return;
            }
            if (activity == null) {
                QLog.e("RegisterPhoneNumFragment", 1, "start failed");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_wechat_binding_info", wechatInfo);
            intent.putExtra("key_hide_check_layout", hideCheckLayout);
            intent.putExtra("key_is_from_old_add_account", isFromOldAddAccount);
            intent.putExtra("key_is_from_gateway_register", isFromGatewayRegister);
            LoginPublicFragmentActivity.INSTANCE.a(activity, intent, RegisterPhoneNumFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/register/fragment/RegisterPhoneNumFragment$b", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", "menu", "", "onCreateActionMode", "onPrepareActionMode", "", "onDestroyActionMode", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onActionItemClicked", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements ActionMode.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(@NotNull ActionMode mode, @NotNull MenuItem item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) mode, (Object) item)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(item, "item");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mode, (Object) menu)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            menu.clear();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(@NotNull ActionMode mode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) mode);
            } else {
                Intrinsics.checkNotNullParameter(mode, "mode");
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mode, (Object) menu)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/register/fragment/RegisterPhoneNumFragment$c", "Lcom/tencent/mobileqq/util/q;", "", "countryCode", "countryShort", "", "onResult", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements q {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterPhoneNumFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.util.q
        public void onResult(@NotNull String countryCode, @NotNull String countryShort) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) countryCode, (Object) countryShort);
                return;
            }
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            Intrinsics.checkNotNullParameter(countryShort, "countryShort");
            RegisterPhoneNumFragment registerPhoneNumFragment = RegisterPhoneNumFragment.this;
            registerPhoneNumFragment.G = countryCode;
            registerPhoneNumFragment.mCountryEnglishName = countryShort;
            RegisterPhoneNumFragment.this.ei();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RegisterPhoneNumFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mStrCountryName = HardCodeUtil.qqStr(R.string.fyo);
        this.mCountryEnglishName = LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
        this.mApp = MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final void Mh() {
        ConfigClearableEditText configClearableEditText = this.mEditText;
        ConfigClearableEditText configClearableEditText2 = null;
        if (configClearableEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText = null;
        }
        configClearableEditText.clearFocus();
        ConfigClearableEditText configClearableEditText3 = this.mEditText;
        if (configClearableEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            configClearableEditText2 = configClearableEditText3;
        }
        configClearableEditText2.setClearButtonVisible(false);
        Object systemService = this.C.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(this.E.getWindowToken(), 0);
    }

    private final void Nh() {
        ConfigClearableEditText configClearableEditText = this.mEditText;
        if (configClearableEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText = null;
        }
        configClearableEditText.setCustomSelectionActionModeCallback(new b());
    }

    private final void Oh() {
        int i3;
        AppRuntime appRuntime = this.mApp;
        if (!TextUtils.isEmpty(this.mStrCountryName) && Intrinsics.areEqual(this.mStrCountryName, getString(R.string.fyn))) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.r(appRuntime, "dc00898", "", "", "0X8007CC7", "0X8007CC7", i3, 0, "", "", "", "");
        cb.d("0X800C324");
        if (!this.mIsValidPhoneNum) {
            di(R.string.f174022uq, 1);
            return;
        }
        CheckBox checkBox = this.mPrivacyPolicyCheckBox;
        LinearLayout linearLayout = null;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyCheckBox");
            checkBox = null;
        }
        if (!checkBox.isChecked()) {
            if (AppSetting.f99565y) {
                di(R.string.brf, 0);
                return;
            }
            QBaseActivity qBaseActivity = getQBaseActivity();
            LinearLayout linearLayout2 = this.mPrivacyPolicyLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
            } else {
                linearLayout = linearLayout2;
            }
            com.tencent.mobileqq.util.l.f(qBaseActivity, linearLayout);
            return;
        }
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.mApp, com.tencent.mobileqq.dt.api.c.f203652o, this.F);
        Ph();
    }

    private final void Ph() {
        String mCountryCode = this.G;
        Intrinsics.checkNotNullExpressionValue(mCountryCode, "mCountryCode");
        String str = this.mCountryEnglishName;
        Intrinsics.checkNotNull(str);
        String mPhoneNum = this.F;
        Intrinsics.checkNotNullExpressionValue(mPhoneNum, "mPhoneNum");
        com.tencent.mobileqq.register.bean.a aVar = new com.tencent.mobileqq.register.bean.a(mCountryCode, str, mPhoneNum);
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            NTRegisterMainline nTRegisterMainline = new NTRegisterMainline();
            QBaseActivity qBaseActivity = getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            nTRegisterMainline.G(qBaseActivity, aVar, this.mWechatInfo, null);
            return;
        }
        com.tencent.mobileqq.register.m mVar = com.tencent.mobileqq.register.m.f280462f;
        QBaseActivity qBaseActivity2 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
        mVar.s(qBaseActivity2, aVar, this.mWechatInfo, null);
    }

    private final void Qh() {
        Intent intent = new Intent(getQBaseActivity(), (Class<?>) NewStyleCountryActivity.class);
        intent.putExtra("k_code", this.G);
        intent.putExtra("k_name", this.mStrCountryName);
        intent.putExtra("k_register", true);
        getQBaseActivity().startActivityForResult(intent, 1);
        getQBaseActivity().overridePendingTransition(R.anim.f154454a3, R.anim.f154550b4);
    }

    private final void Rh() {
        s.f306795a.c(2, new c());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void Sh() {
        hi(false);
        ConfigClearableEditText configClearableEditText = this.mEditText;
        ImageView imageView = null;
        if (configClearableEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText = null;
        }
        configClearableEditText.addTextChangedListener(this);
        ConfigClearableEditText configClearableEditText2 = this.mEditText;
        if (configClearableEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText2 = null;
        }
        configClearableEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.register.fragment.j
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                RegisterPhoneNumFragment.Th(RegisterPhoneNumFragment.this, view, z16);
            }
        });
        ConfigClearableEditText configClearableEditText3 = this.mEditText;
        if (configClearableEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText3 = null;
        }
        configClearableEditText3.setCustomClearButtonCallback(this);
        ConfigClearableEditText configClearableEditText4 = this.mEditText;
        if (configClearableEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText4 = null;
        }
        configClearableEditText4.setNeedContextMenu(true);
        Nh();
        LinearLayout linearLayout = this.mChangeCountryCodeLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeCountryCodeLayout");
            linearLayout = null;
        }
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.register.fragment.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Uh;
                Uh = RegisterPhoneNumFragment.Uh(view, motionEvent);
                return Uh;
            }
        });
        LinearLayout linearLayout2 = this.mPhoneNumRegisterLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumRegisterLayout");
            linearLayout2 = null;
        }
        linearLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.register.fragment.l
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Vh;
                Vh = RegisterPhoneNumFragment.Vh(RegisterPhoneNumFragment.this, view, motionEvent);
                return Vh;
            }
        });
        LinearLayout linearLayout3 = this.mPhoneNumRegisterLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumRegisterLayout");
            linearLayout3 = null;
        }
        linearLayout3.post(new Runnable() { // from class: com.tencent.mobileqq.register.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                RegisterPhoneNumFragment.Wh(RegisterPhoneNumFragment.this);
            }
        });
        ImageView imageView2 = this.mPhoneNumClean;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumClean");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(RegisterPhoneNumFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hi(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Uh(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Vh(RegisterPhoneNumFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mh();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(RegisterPhoneNumFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.mPhoneNumRegisterLayout;
        ConfigClearableEditText configClearableEditText = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumRegisterLayout");
            linearLayout = null;
        }
        if (linearLayout.getWidth() <= ViewUtils.dpToPx(320.0f)) {
            ConfigClearableEditText configClearableEditText2 = this$0.mEditText;
            if (configClearableEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                configClearableEditText2 = null;
            }
            int paddingRight = configClearableEditText2.getPaddingRight();
            LinearLayout linearLayout2 = this$0.mChangeCountryCodeLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChangeCountryCodeLayout");
                linearLayout2 = null;
            }
            int width = linearLayout2.getWidth();
            ConfigClearableEditText configClearableEditText3 = this$0.mEditText;
            if (configClearableEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                configClearableEditText3 = null;
            }
            int max = Math.max(width, configClearableEditText3.getPaddingLeft());
            ConfigClearableEditText configClearableEditText4 = this$0.mEditText;
            if (configClearableEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                configClearableEditText = configClearableEditText4;
            }
            configClearableEditText.setPadding(max, 0, paddingRight, 0);
        }
    }

    private final void Xh() {
        Intent intent;
        int i3;
        PrettyAccountRegisterUtils prettyAccountRegisterUtils = PrettyAccountRegisterUtils.f280539a;
        FragmentActivity activity = getActivity();
        ImageView imageView = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        PrettyAccountABTestExp d16 = prettyAccountRegisterUtils.d(intent);
        int i16 = 0;
        if (d16 == PrettyAccountABTestExp.EXP_1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (d16 != PrettyAccountABTestExp.EXP_2) {
            i16 = 4;
        }
        QUIButton qUIButton = this.mBtnPrettyAccountRegister;
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
        com.tencent.mobileqq.register.prettyaccount.c.f280545a.d(d16);
    }

    private final void Yh() {
        boolean z16;
        if (this.mWechatInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean booleanExtra = getQBaseActivity().getIntent().getBooleanExtra("key_hide_check_layout", false);
        CheckBox checkBox = null;
        if (!z16 && !booleanExtra) {
            LinearLayout linearLayout = this.mPrivacyPolicyLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.mPrivacyPolicyLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
                linearLayout2 = null;
            }
            linearLayout2.post(new Runnable() { // from class: com.tencent.mobileqq.register.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    RegisterPhoneNumFragment.Zh(RegisterPhoneNumFragment.this);
                }
            });
            TextView textView = this.mTvPrivacyPolicy;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPrivacyPolicy");
                textView = null;
            }
            String c16 = com.tencent.mobileqq.util.l.c();
            CheckBox checkBox2 = this.mPrivacyPolicyCheckBox;
            if (checkBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyCheckBox");
            } else {
                checkBox = checkBox2;
            }
            PrivacyPolicyHelper.initPrivacyPolicyTextView(textView, c16, com.tencent.mobileqq.util.l.b(checkBox));
            return;
        }
        LinearLayout linearLayout3 = this.mPrivacyPolicyLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyLayout");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(8);
        CheckBox checkBox3 = this.mPrivacyPolicyCheckBox;
        if (checkBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyCheckBox");
        } else {
            checkBox = checkBox3;
        }
        checkBox.setChecked(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(RegisterPhoneNumFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CheckBox checkBox = this$0.mPrivacyPolicyCheckBox;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyCheckBox");
            checkBox = null;
        }
        LoginUtil.t(checkBox, "key_phone_num_register_tips_shown");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ai(RegisterPhoneNumFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this$0.mApp, com.tencent.mobileqq.dt.api.c.f203650m, motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bi(RegisterPhoneNumFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this$0.mApp, com.tencent.mobileqq.dt.api.c.f203651n, motionEvent);
        return false;
    }

    private final void ci() {
        LinearLayout linearLayout = this.mPhoneNumRegisterContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumRegisterContainer");
            linearLayout = null;
        }
        z.q(linearLayout, getQBaseActivity());
    }

    private final void di(int resId, int icon) {
        String string = getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(resId)");
        zh(string, icon);
        as.g(this.mApp, "0X800C1C3", "", ao.INSTANCE.c(), string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei() {
        String str = Marker.ANY_NON_NULL_MARKER + this.G;
        LinearLayout linearLayout = this.mChangeCountryCodeLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeCountryCodeLayout");
            linearLayout = null;
        }
        AccessibilityUtil.c(linearLayout, str, Button.class.getName());
        TextView textView2 = this.mTvCountryCode;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvCountryCode");
        } else {
            textView = textView2;
        }
        textView.setText(str);
        gi();
    }

    private final void fi() {
        if (FontSettingManager.getFontLevel() >= 17.0f) {
            ConfigClearableEditText configClearableEditText = null;
            if (FontSettingManager.getFontLevel() >= 20.0f) {
                ConfigClearableEditText configClearableEditText2 = this.mEditText;
                if (configClearableEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    configClearableEditText2 = null;
                }
                configClearableEditText2.setPadding(ViewUtils.dpToPx(68.0f), 0, ViewUtils.dpToPx(16.0f), 0);
                TextView textView = this.mTvCountryCode;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvCountryCode");
                    textView = null;
                }
                textView.setTextSize(17.0f);
                ConfigClearableEditText configClearableEditText3 = this.mEditText;
                if (configClearableEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                } else {
                    configClearableEditText = configClearableEditText3;
                }
                configClearableEditText.setTextSize(17.0f);
                return;
            }
            ConfigClearableEditText configClearableEditText4 = this.mEditText;
            if (configClearableEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                configClearableEditText4 = null;
            }
            configClearableEditText4.setPadding(ViewUtils.dpToPx(48.0f), 0, ViewUtils.dpToPx(16.0f), 0);
            TextView textView2 = this.mTvCountryCode;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvCountryCode");
                textView2 = null;
            }
            textView2.setTextSize(18.0f);
            ConfigClearableEditText configClearableEditText5 = this.mEditText;
            if (configClearableEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                configClearableEditText = configClearableEditText5;
            }
            configClearableEditText.setTextSize(18.0f);
        }
    }

    private final void gi() {
        ConfigClearableEditText configClearableEditText = this.mEditText;
        QUIButton qUIButton = null;
        if (configClearableEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText = null;
        }
        boolean qh5 = qh(configClearableEditText.getText());
        this.mIsValidPhoneNum = qh5;
        if (qh5) {
            QUIButton qUIButton2 = this.mBtnNext;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
                qUIButton2 = null;
            }
            qUIButton2.o();
            QUIButton qUIButton3 = this.mBtnNext;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
            } else {
                qUIButton = qUIButton3;
            }
            qUIButton.setEnabled(true);
            return;
        }
        QUIButton qUIButton4 = this.mBtnNext;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
        } else {
            qUIButton = qUIButton4;
        }
        qUIButton.setBackgroundDisabled();
    }

    private final void hi(boolean hasFocus) {
        ConfigClearableEditText configClearableEditText = null;
        if (hasFocus) {
            ConfigClearableEditText configClearableEditText2 = this.mEditText;
            if (configClearableEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                configClearableEditText2 = null;
            }
            ConfigClearableEditText configClearableEditText3 = this.mEditText;
            if (configClearableEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                configClearableEditText3 = null;
            }
            configClearableEditText2.setSelection(configClearableEditText3.length());
            ConfigClearableEditText configClearableEditText4 = this.mEditText;
            if (configClearableEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                configClearableEditText = configClearableEditText4;
            }
            configClearableEditText.setHint("");
            return;
        }
        ConfigClearableEditText configClearableEditText5 = this.mEditText;
        if (configClearableEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            configClearableEditText = configClearableEditText5;
        }
        configClearableEditText.setHint(LoginUtil.d(ViewUtils.spToPx(17.0f), R.string.f211285ke));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initViews(View view) {
        List listOf;
        View findViewById = view.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.back_btn)");
        this.mBackBtn = (ImageView) findViewById;
        ((TextView) view.findViewById(R.id.title)).setVisibility(4);
        View findViewById2 = view.findViewById(R.id.f2443094);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.phone_num_register_layout)");
        this.mPhoneNumRegisterLayout = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.f27610gp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.privacy_policy_layout)");
        this.mPrivacyPolicyLayout = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.f27600go);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.privacy_policy_check_box)");
        this.mPrivacyPolicyCheckBox = (CheckBox) findViewById4;
        View findViewById5 = view.findViewById(R.id.u_8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.country_code_text_view)");
        this.mTvCountryCode = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tra);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.change_country_code_layout)");
        this.mChangeCountryCodeLayout = (LinearLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.f243808z);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.phone_num_edit_text)");
        this.mEditText = (ConfigClearableEditText) findViewById7;
        View findViewById8 = view.findViewById(R.id.f8w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.next_btn)");
        this.mBtnNext = (QUIButton) findViewById8;
        View findViewById9 = view.findViewById(R.id.f27630gr);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.privacy_policy_text)");
        this.mTvPrivacyPolicy = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.f2439090);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.phone_num_input_layout)");
        this.mPhoneNumInputLayout = (RelativeLayout) findViewById10;
        View findViewById11 = view.findViewById(R.id.f2442093);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.phone_num_register_container)");
        this.mPhoneNumRegisterContainer = (LinearLayout) findViewById11;
        View findViewById12 = view.findViewById(R.id.tfx);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.btn_pretty_account)");
        this.mBtnPrettyAccountRegister = (QUIButton) findViewById12;
        View findViewById13 = view.findViewById(R.id.zeb);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.more_a\u2026ions_view_pretty_account)");
        this.mBottomPrettyAccountRegister = (LinearLayout) findViewById13;
        View findViewById14 = view.findViewById(R.id.zdx);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.more_a\u2026ions_icon_pretty_account)");
        this.mBottomPrettyAccountIcon = (ImageView) findViewById14;
        View findViewById15 = view.findViewById(R.id.f243708y);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.phone_num_clean)");
        ImageView imageView = (ImageView) findViewById15;
        this.mPhoneNumClean = imageView;
        CheckBox checkBox = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumClean");
            imageView = null;
        }
        AccessibilityUtil.c(imageView, getString(R.string.f200144rb), Button.class.getName());
        Yh();
        Sh();
        Xh();
        View[] viewArr = new View[6];
        ImageView imageView2 = this.mBackBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackBtn");
            imageView2 = null;
        }
        viewArr[0] = imageView2;
        LinearLayout linearLayout = this.mChangeCountryCodeLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeCountryCodeLayout");
            linearLayout = null;
        }
        viewArr[1] = linearLayout;
        QUIButton qUIButton = this.mBtnNext;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
            qUIButton = null;
        }
        viewArr[2] = qUIButton;
        QUIButton qUIButton2 = this.mBtnPrettyAccountRegister;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPrettyAccountRegister");
            qUIButton2 = null;
        }
        viewArr[3] = qUIButton2;
        LinearLayout linearLayout2 = this.mBottomPrettyAccountRegister;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPrettyAccountRegister");
            linearLayout2 = null;
        }
        viewArr[4] = linearLayout2;
        ImageView imageView3 = this.mBottomPrettyAccountIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPrettyAccountIcon");
            imageView3 = null;
        }
        viewArr[5] = imageView3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(this);
        }
        QUIButton qUIButton3 = this.mBtnNext;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
            qUIButton3 = null;
        }
        qUIButton3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.register.fragment.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean ai5;
                ai5 = RegisterPhoneNumFragment.ai(RegisterPhoneNumFragment.this, view2, motionEvent);
                return ai5;
            }
        });
        CheckBox checkBox2 = this.mPrivacyPolicyCheckBox;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivacyPolicyCheckBox");
        } else {
            checkBox = checkBox2;
        }
        checkBox.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.register.fragment.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean bi5;
                bi5 = RegisterPhoneNumFragment.bi(RegisterPhoneNumFragment.this, view2, motionEvent);
                return bi5;
            }
        });
        ci();
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public void Af(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, visible);
            return;
        }
        ImageView imageView = this.mPhoneNumClean;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumClean");
            imageView = null;
        }
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public void Mg(boolean pressed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, pressed);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) s16);
            return;
        }
        ConfigClearableEditText configClearableEditText = this.mEditText;
        if (configClearableEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            configClearableEditText = null;
        }
        this.F = configClearableEditText.getText().toString();
        gi();
        com.tencent.mobileqq.register.q.c().l(1);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (data == null) {
            QLog.i("RegisterPhoneNumFragment", 1, "data is null");
            return;
        }
        if (requestCode == 1 && resultCode == -1) {
            this.mStrCountryName = data.getStringExtra("k_name");
            this.G = data.getStringExtra("k_code");
            this.mCountryEnglishName = data.getStringExtra("k_english_name");
            ei();
            s.f306795a.b();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        cb.d("0X800BC95");
        getQBaseActivity().finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            if (id5 == R.id.tra) {
                Qh();
                Mh();
            } else if (id5 == R.id.f8w) {
                Oh();
                Mh();
            } else if (id5 == R.id.a47) {
                onBackEvent();
            } else if (id5 == R.id.f243708y) {
                ConfigClearableEditText configClearableEditText = this.mEditText;
                if (configClearableEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    configClearableEditText = null;
                }
                configClearableEditText.h();
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
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ci();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            cb.f306645a.i("0X8007360");
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.mApp, com.tencent.mobileqq.dt.api.c.f203640c, "");
            getQBaseActivity().getWindow().setSoftInputMode(2);
            PrettyAccountRegisterUtils.f280539a.g();
            QBaseActivity qBaseActivity = getQBaseActivity();
            ConfigClearableEditText configClearableEditText = null;
            if (qBaseActivity != null) {
                intent = qBaseActivity.getIntent();
            } else {
                intent = null;
            }
            if (intent != null) {
                this.mWechatInfo = (WechatInfo) intent.getParcelableExtra("key_wechat_binding_info");
                this.mIsFromOldAddAccount = intent.getBooleanExtra("key_is_from_old_add_account", false);
                this.mIsFromGatewayRegister = intent.getBooleanExtra("key_is_from_gateway_register", false);
            }
            this.E = inflater.inflate(R.layout.gym, container, false);
            if (!wh()) {
                view = this.E;
            } else {
                View root = this.E;
                Intrinsics.checkNotNullExpressionValue(root, "root");
                initViews(root);
                Rh();
                fi();
                if (needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
                    ImmersiveUtils.setStatusTextColor(!ThemeUtil.isNowThemeIsNight(null, false, null), requireActivity().getWindow());
                }
                com.tencent.mobileqq.register.q.c().e();
                IQSecChannel iQSecChannel = (IQSecChannel) QRoute.api(IQSecChannel.class);
                AppInterface appInterface = (AppInterface) this.mApp;
                String str = com.tencent.mobileqq.dt.api.c.f203649l;
                ConfigClearableEditText configClearableEditText2 = this.mEditText;
                if (configClearableEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                } else {
                    configClearableEditText = configClearableEditText2;
                }
                iQSecChannel.regTouchEvent(appInterface, str, configClearableEditText);
                ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.mApp, com.tencent.mobileqq.dt.api.c.f203647j, "");
                ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiStartSensor((AppInterface) this.mApp, com.tencent.mobileqq.dt.api.c.f203638a);
                view = this.E;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        z.s(this.mApp, RegisterPhoneNumFragment.class);
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiEndSensor((AppInterface) this.mApp, com.tencent.mobileqq.dt.api.c.f203638a);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onResume();
        gi();
        com.tencent.mobileqq.register.q.c().l(2);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onStop();
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.mApp, com.tencent.mobileqq.dt.api.c.f203648k, "");
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public void v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public int w9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 0;
    }
}
