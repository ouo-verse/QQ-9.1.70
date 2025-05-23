package com.tencent.mobileqq.register.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.fragment.RegisterNewBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.loginregister.callback.RegisterResult;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.bean.ZPlanOutboundAvatarInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.avatar.AvatarSelectComponent;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.mobileqq.register.fragment.RegisterNickAndPwdFragment;
import com.tencent.mobileqq.register.q;
import com.tencent.mobileqq.register.u;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.mobileqq.util.cy;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00af\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u00b0\u0001\u00b1\u0001B\t\u00a2\u0006\u0006\b\u00ad\u0001\u0010\u00ae\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J&\u0010+\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0015H\u0016J\b\u0010.\u001a\u00020\u0015H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001eH\u0016J\"\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u000103H\u0016J*\u0010;\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u0011H\u0016J*\u0010=\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0011H\u0016J\u0012\u0010?\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010>H\u0016J\b\u0010@\u001a\u00020\u0004H\u0016J\b\u0010A\u001a\u00020\u0004H\u0016J\b\u0010B\u001a\u00020\u0004H\u0016J\b\u0010C\u001a\u00020\u0004H\u0016J\u0010\u0010F\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010DJ\b\u0010G\u001a\u00020\u0015H\u0016J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020HH\u0016R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010]\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010a\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010SR\u0016\u0010c\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010SR\u0016\u0010e\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010SR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0016\u0010n\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u0016\u0010r\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010mR\u0016\u0010t\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010OR\u0016\u0010v\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010OR\u0016\u0010x\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010SR\u0016\u0010z\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\by\u0010SR\u0016\u0010|\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010WR\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020}8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u007fR\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0085\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u0085\u0001R\u0018\u0010\u008c\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010sR\u0018\u0010\u008e\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010sR\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0098\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010sR\"\u0010\u009d\u0001\u001a\r \u009a\u0001*\u0005\u0018\u00010\u0099\u00010\u0099\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001b\u0010\u00a4\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u001c\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u001c\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u00a9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001\u00a8\u0006\u00b2\u0001"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment;", "Lcom/tencent/mobileqq/fragment/RegisterNewBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/text/TextWatcher;", "", "initViews", "ci", "ei", "ni", "bi", "ii", "Xh", "pi", "di", "mi", "si", "ai", "", "resId", "icon", "qi", "", "Zh", "isHideInput", "oi", "Lcom/tencent/mobileqq/widget/PastablePwdEditText;", "editView", "hasFocus", "stringId", "ri", "Landroid/view/View;", "view", "", "offset", "ki", WidgetCacheLunarData.JI, "li", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "isWrapContent", "v", NodeProps.ON_CLICK, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", ReportConstant.COSTREPORT_PREFIX, "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "onFinish", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onAccountChanged", "", "uin", "Yh", "needStatusTrans", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "J", "Landroid/view/ViewGroup;", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "title", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "backBtn", "Landroid/widget/RelativeLayout;", "M", "Landroid/widget/RelativeLayout;", "nicknameLayout", "N", "passwordLayout", "P", "Lcom/tencent/mobileqq/widget/PastablePwdEditText;", "editNickname", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "editPassword", BdhLogUtil.LogTag.Tag_Req, "passwordEye", ExifInterface.LATITUDE_SOUTH, "nicknameClean", "T", "passwordClean", "Landroid/widget/Button;", "U", "Landroid/widget/Button;", "btnRegister", "V", "btnLogin", "W", "Landroid/view/View;", "rule1Root", "X", "rule2Root", "Y", "rule3Root", "Z", "rule1text", "a0", "rule2text", "b0", "rule1Img", "c0", "rule2Img", "d0", "avatarGroup", "Landroid/widget/LinearLayout;", "e0", "Landroid/widget/LinearLayout;", "nickAndPwdGroup", "f0", "buttonGroup", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "g0", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "ivAvatar", "h0", "ivAvatar1", "i0", "ivAvatar2", "j0", "isAvatar1LoadFinish", "k0", "isAvatar2LoadFinish", "Lcom/tencent/mobileqq/register/u;", "l0", "Lcom/tencent/mobileqq/register/u;", "registerWithNickAndPwd", "Landroid/net/Uri;", "m0", "Landroid/net/Uri;", "uploadPhotoUri", "n0", "mPassInvisible", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "o0", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "p0", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "mWechatInfo", "q0", "Ljava/lang/String;", "avatarLocalPath", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "r0", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "selectedAvatarInfo", "Lcom/tencent/mobileqq/register/avatar/AvatarSelectComponent;", "s0", "Lcom/tencent/mobileqq/register/avatar/AvatarSelectComponent;", "avatarSelectComponent", "<init>", "()V", "t0", "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RegisterNickAndPwdFragment extends RegisterNewBaseFragment implements View.OnClickListener, TextWatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: J, reason: from kotlin metadata */
    private ViewGroup container;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView title;

    /* renamed from: L, reason: from kotlin metadata */
    private ImageView backBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private RelativeLayout nicknameLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private RelativeLayout passwordLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private PastablePwdEditText editNickname;

    /* renamed from: Q, reason: from kotlin metadata */
    private PastablePwdEditText editPassword;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView passwordEye;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView nicknameClean;

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView passwordClean;

    /* renamed from: U, reason: from kotlin metadata */
    private Button btnRegister;

    /* renamed from: V, reason: from kotlin metadata */
    private Button btnLogin;

    /* renamed from: W, reason: from kotlin metadata */
    private View rule1Root;

    /* renamed from: X, reason: from kotlin metadata */
    private View rule2Root;

    /* renamed from: Y, reason: from kotlin metadata */
    private View rule3Root;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView rule1text;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private TextView rule2text;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView rule1Img;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ImageView rule2Img;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout avatarGroup;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout nickAndPwdGroup;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout buttonGroup;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProAvatarView ivAvatar;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProAvatarView ivAvatar1;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProAvatarView ivAvatar2;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean isAvatar1LoadFinish;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean isAvatar2LoadFinish;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private u registerWithNickAndPwd;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Uri uploadPhotoUri;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean mPassInvisible;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final AppRuntime app;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WechatInfo mWechatInfo;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String avatarLocalPath;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ZPlanAvatarInfo selectedAvatarInfo;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarSelectComponent avatarSelectComponent;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment$a;", "", "", "d", "", "c", "a", "I", "usableHeightPrevious", "<init>", "(Lcom/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int usableHeightPrevious;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterNickAndPwdFragment.this);
            } else {
                ((RegisterNewBaseFragment) RegisterNickAndPwdFragment.this).E.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.register.fragment.g
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        RegisterNickAndPwdFragment.a.b(RegisterNickAndPwdFragment.a.this);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.d();
        }

        private final int c() {
            Rect rect = new Rect();
            ((RegisterNewBaseFragment) RegisterNickAndPwdFragment.this).E.getWindowVisibleDisplayFrame(rect);
            return rect.bottom - rect.top;
        }

        private final void d() {
            int c16 = c();
            if (c16 != this.usableHeightPrevious) {
                int height = ((RegisterNewBaseFragment) RegisterNickAndPwdFragment.this).E.getHeight();
                View view = null;
                if (height - c16 > height / 4) {
                    RegisterNickAndPwdFragment registerNickAndPwdFragment = RegisterNickAndPwdFragment.this;
                    RelativeLayout relativeLayout = registerNickAndPwdFragment.avatarGroup;
                    if (relativeLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("avatarGroup");
                        relativeLayout = null;
                    }
                    registerNickAndPwdFragment.ki(relativeLayout, ViewUtils.dpToPx(-35.0f));
                    RegisterNickAndPwdFragment registerNickAndPwdFragment2 = RegisterNickAndPwdFragment.this;
                    LinearLayout linearLayout = registerNickAndPwdFragment2.nickAndPwdGroup;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("nickAndPwdGroup");
                        linearLayout = null;
                    }
                    registerNickAndPwdFragment2.ki(linearLayout, ViewUtils.dpToPx(-55.0f));
                    RegisterNickAndPwdFragment registerNickAndPwdFragment3 = RegisterNickAndPwdFragment.this;
                    LinearLayout linearLayout2 = registerNickAndPwdFragment3.buttonGroup;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("buttonGroup");
                    } else {
                        view = linearLayout2;
                    }
                    registerNickAndPwdFragment3.ki(view, ViewUtils.dpToPx(-65.0f));
                } else if (this.usableHeightPrevious != 0) {
                    RegisterNickAndPwdFragment registerNickAndPwdFragment4 = RegisterNickAndPwdFragment.this;
                    LinearLayout linearLayout3 = registerNickAndPwdFragment4.buttonGroup;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("buttonGroup");
                        linearLayout3 = null;
                    }
                    registerNickAndPwdFragment4.ji(linearLayout3, ViewUtils.dpToPx(-65.0f));
                    RegisterNickAndPwdFragment registerNickAndPwdFragment5 = RegisterNickAndPwdFragment.this;
                    LinearLayout linearLayout4 = registerNickAndPwdFragment5.nickAndPwdGroup;
                    if (linearLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("nickAndPwdGroup");
                        linearLayout4 = null;
                    }
                    registerNickAndPwdFragment5.ji(linearLayout4, ViewUtils.dpToPx(-55.0f));
                    RegisterNickAndPwdFragment registerNickAndPwdFragment6 = RegisterNickAndPwdFragment.this;
                    RelativeLayout relativeLayout2 = registerNickAndPwdFragment6.avatarGroup;
                    if (relativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("avatarGroup");
                    } else {
                        view = relativeLayout2;
                    }
                    registerNickAndPwdFragment6.ji(view, ViewUtils.dpToPx(-35.0f));
                }
                this.usableHeightPrevious = c16;
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u000eR\u0014\u0010!\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0012R\u0014\u0010\"\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010$\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0012R\u0014\u0010%\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0012R\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment$b;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "", "smsCode", "", "a", "", "registerContext", "b", "ANIMATE_AVATAR_BG_FIRST", "Ljava/lang/String;", "ANIMATE_AVATAR_BG_SECOND", "", "ANIMATE_AVATAR_CLIP_PERCENT_FIRST", "I", "ANIMATE_AVATAR_CLIP_PERCENT_SECOND", "ANIMATE_AVATAR_FIRST", "ANIMATE_AVATAR_SECOND", "", "AVATAR_ANIMATE_DELAY_TIME", "J", "", "AVATAR_MOVE_OFFSET", UserInfo.SEX_FEMALE, "AVATAR_SIZE", "BUTTON_MOVE_OFFSET", "INPUT_HINT_TEXT_SIZE_SP", "KEY_BUBBLE_TIP_SHOWN", "LOCAL_IMAGE_PATH", "MAX_CONSECUTIVE_SIZE", "MIN_PWD_LENGTH", "NICK_AND_PWD_MOVE_OFFSET", "NICK_LENGTH", "REQUEST_CODE_LOGIN_AVATAR", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.fragment.RegisterNickAndPwdFragment$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull QBaseActivity context, @Nullable WechatInfo wechatInfo, @Nullable String smsCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, wechatInfo, smsCode);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            cb.g("0X800C3B9");
            Intent intent = new Intent();
            intent.putExtra("key_wechat_binding_info", wechatInfo);
            intent.putExtra(AppConstants.Key.KEY_REGISTER_SMSCODE, smsCode);
            LoginPublicFragmentActivity.INSTANCE.a(context, intent, RegisterNickAndPwdFragment.class);
        }

        public final void b(@NotNull QBaseActivity context, @Nullable WechatInfo wechatInfo, @NotNull byte[] registerContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, context, wechatInfo, registerContext);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(registerContext, "registerContext");
            cb.g("0X800C3B9");
            Intent intent = new Intent();
            intent.putExtra("key_wechat_binding_info", wechatInfo);
            intent.putExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT, registerContext);
            LoginPublicFragmentActivity.INSTANCE.a(context, intent, RegisterNickAndPwdFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment$c", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView$b;", "", "onLoadFinish", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements QQProAvatarView.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterNickAndPwdFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.proavatar.QQProAvatarView.b
        public void onLoadFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RegisterNickAndPwdFragment.this.isAvatar1LoadFinish = true;
                if (RegisterNickAndPwdFragment.this.isAvatar2LoadFinish) {
                    RegisterNickAndPwdFragment.this.Xh();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment$d", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView$b;", "", "onLoadFinish", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements QQProAvatarView.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterNickAndPwdFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.proavatar.QQProAvatarView.b
        public void onLoadFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RegisterNickAndPwdFragment.this.isAvatar2LoadFinish = true;
                if (RegisterNickAndPwdFragment.this.isAvatar1LoadFinish) {
                    RegisterNickAndPwdFragment.this.Xh();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment$e", "Lcom/tencent/mobileqq/widget/ConfigClearableEditText$d;", "", NodeProps.VISIBLE, "", "Af", "", "w9", "pressed", "Mg", "v2", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements ConfigClearableEditText.d {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterNickAndPwdFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Af(boolean visible) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ImageView imageView = RegisterNickAndPwdFragment.this.nicknameClean;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nicknameClean");
                    imageView = null;
                }
                if (visible) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, visible);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Mg(boolean pressed) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, pressed);
                return;
            }
            ImageView imageView = null;
            if (pressed) {
                ImageView imageView2 = RegisterNickAndPwdFragment.this.nicknameClean;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nicknameClean");
                } else {
                    imageView = imageView2;
                }
                imageView.setAlpha(0.5f);
                return;
            }
            ImageView imageView3 = RegisterNickAndPwdFragment.this.nicknameClean;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nicknameClean");
            } else {
                imageView = imageView3;
            }
            imageView.setAlpha(1.0f);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void v2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                ImageView imageView = RegisterNickAndPwdFragment.this.nicknameClean;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nicknameClean");
                    imageView = null;
                }
                imageView.setAlpha(1.0f);
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public int w9() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/fragment/RegisterNickAndPwdFragment$f", "Lcom/tencent/mobileqq/widget/ConfigClearableEditText$d;", "", NodeProps.VISIBLE, "", "Af", "", "w9", "pressed", "Mg", "v2", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class f implements ConfigClearableEditText.d {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterNickAndPwdFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Af(boolean visible) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ImageView imageView = RegisterNickAndPwdFragment.this.passwordClean;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("passwordClean");
                    imageView = null;
                }
                if (visible) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, visible);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Mg(boolean pressed) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, pressed);
                return;
            }
            ImageView imageView = null;
            if (pressed) {
                ImageView imageView2 = RegisterNickAndPwdFragment.this.passwordClean;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("passwordClean");
                } else {
                    imageView = imageView2;
                }
                imageView.setAlpha(0.5f);
                return;
            }
            ImageView imageView3 = RegisterNickAndPwdFragment.this.passwordClean;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passwordClean");
            } else {
                imageView = imageView3;
            }
            imageView.setAlpha(1.0f);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void v2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                ImageView imageView = RegisterNickAndPwdFragment.this.passwordClean;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("passwordClean");
                    imageView = null;
                }
                imageView.setAlpha(1.0f);
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public int w9() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26682);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RegisterNickAndPwdFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mPassInvisible = true;
            this.app = MobileQQ.sMobileQQ.peekAppRuntime();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        com.tencent.mobileqq.register.util.b bVar = com.tencent.mobileqq.register.util.b.f280582a;
        bVar.c(this.ivAvatar, this.ivAvatar2, 1000L);
        bVar.c(this.ivAvatar2, this.ivAvatar1, 2000L);
        bVar.c(this.ivAvatar1, this.ivAvatar, 3000L);
    }

    private final boolean Zh() {
        boolean z16;
        int i3;
        boolean z17;
        PastablePwdEditText pastablePwdEditText = this.editPassword;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText = null;
        }
        String obj = pastablePwdEditText.getText().toString();
        PastablePwdEditText pastablePwdEditText3 = this.editNickname;
        if (pastablePwdEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
        } else {
            pastablePwdEditText2 = pastablePwdEditText3;
        }
        String obj2 = pastablePwdEditText2.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            qi(R.string.csu, 1);
            return false;
        }
        com.tencent.mobileqq.register.util.c cVar = com.tencent.mobileqq.register.util.c.f280585a;
        if (cVar.c(obj)) {
            qi(R.string.f172947g13, 1);
            return false;
        }
        if (!cVar.b(obj)) {
            qi(R.string.f172946g12, 1);
            return false;
        }
        if (!TextUtils.isEmpty(obj2)) {
            int length = obj2.length() - 1;
            int i16 = 0;
            boolean z18 = false;
            while (i16 <= length) {
                if (!z18) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) obj2.charAt(i3), 32) <= 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z18) {
                    if (!z17) {
                        z18 = true;
                    } else {
                        i16++;
                    }
                } else {
                    if (!z17) {
                        break;
                    }
                    length--;
                }
            }
            if (obj2.subSequence(i16, length + 1).toString().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    if (Utils.x(obj2) > 24) {
                        qi(R.string.fzp, 1);
                        return false;
                    }
                } catch (Exception unused) {
                    QLog.e("RegisterNickAndPwdFragment", 1, "checkNickAndPwd error: e");
                }
                return true;
            }
        }
        qi(R.string.fzo, 1);
        return false;
    }

    private final void ai() {
        PastablePwdEditText pastablePwdEditText = this.editNickname;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText = null;
        }
        pastablePwdEditText.clearFocus();
        PastablePwdEditText pastablePwdEditText3 = this.editPassword;
        if (pastablePwdEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
        } else {
            pastablePwdEditText2 = pastablePwdEditText3;
        }
        pastablePwdEditText2.clearFocus();
        Object systemService = this.C.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(this.E.getWindowToken(), 0);
    }

    private final void bi() {
        String str;
        RelativeLayout relativeLayout = this.avatarGroup;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarGroup");
            relativeLayout = null;
        }
        AccessibilityUtil.c(relativeLayout, getString(R.string.f20380517), Button.class.getName());
        this.ivAvatar = (QQProAvatarView) this.E.findViewById(R.id.f165909du3);
        QQProAvatarView qQProAvatarView = (QQProAvatarView) this.E.findViewById(R.id.y0i);
        this.ivAvatar1 = qQProAvatarView;
        if (qQProAvatarView != null) {
            qQProAvatarView.setDrawAreaMode(1);
        }
        QQProAvatarView qQProAvatarView2 = (QQProAvatarView) this.E.findViewById(R.id.y0j);
        this.ivAvatar2 = qQProAvatarView2;
        if (qQProAvatarView2 != null) {
            qQProAvatarView2.setDrawAreaMode(1);
        }
        WechatInfo wechatInfo = this.mWechatInfo;
        if (wechatInfo != null) {
            str = wechatInfo.b();
        } else {
            str = null;
        }
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.nf5, null);
        QQProAvatarView qQProAvatarView3 = this.ivAvatar;
        if (qQProAvatarView3 != null) {
            qQProAvatarView3.setImageDrawable(drawable);
        }
        ii();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        int dpToPx = ViewUtils.dpToPx(87.0f);
        cy cyVar = cy.f306749a;
        drawable2.setTag(cyVar.c(dpToPx, dpToPx));
        drawable2.setDecodeHandler(cyVar.d());
        QQProAvatarView qQProAvatarView4 = this.ivAvatar;
        if (qQProAvatarView4 != null) {
            qQProAvatarView4.setImageDrawable(drawable2);
        }
    }

    private final void ci() {
        View findViewById = this.E.findViewById(R.id.ajd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.btn_register_and_login)");
        this.btnRegister = (Button) findViewById;
        View findViewById2 = this.E.findViewById(R.id.login);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.login)");
        this.btnLogin = (Button) findViewById2;
    }

    private final void di() {
        View findViewById = this.E.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.title = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.f20381518));
        View findViewById2 = this.E.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.back_btn)");
        this.backBtn = (ImageView) findViewById2;
    }

    private final void ei() {
        String str;
        View findViewById = this.E.findViewById(R.id.zrd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.nickname_edit_layout)");
        this.nicknameLayout = (RelativeLayout) findViewById;
        View findViewById2 = this.E.findViewById(R.id.f226404_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.password_edit_layout)");
        this.passwordLayout = (RelativeLayout) findViewById2;
        View findViewById3 = this.E.findViewById(R.id.zrc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.nickname_clean)");
        this.nicknameClean = (ImageView) findViewById3;
        View findViewById4 = this.E.findViewById(R.id.fis);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.password_clean)");
        this.passwordClean = (ImageView) findViewById4;
        View findViewById5 = this.E.findViewById(R.id.fit);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.password_edit)");
        PastablePwdEditText pastablePwdEditText = (PastablePwdEditText) findViewById5;
        this.editPassword = pastablePwdEditText;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText = null;
        }
        pastablePwdEditText.addTextChangedListener(this);
        View findViewById6 = this.E.findViewById(R.id.f9x);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.nickname_edit)");
        PastablePwdEditText pastablePwdEditText3 = (PastablePwdEditText) findViewById6;
        this.editNickname = pastablePwdEditText3;
        if (pastablePwdEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText3 = null;
        }
        pastablePwdEditText3.addTextChangedListener(this);
        ni();
        View findViewById7 = this.E.findViewById(R.id.g65);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.pwd_rule1_root)");
        this.rule1Root = findViewById7;
        View findViewById8 = this.E.findViewById(R.id.g68);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.pwd_rule2_root)");
        this.rule2Root = findViewById8;
        View findViewById9 = this.E.findViewById(R.id.f29440ln);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.pwd_rule3_root)");
        this.rule3Root = findViewById9;
        View findViewById10 = this.E.findViewById(R.id.g66);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "root.findViewById(R.id.pwd_rule1_tx)");
        this.rule1text = (TextView) findViewById10;
        View findViewById11 = this.E.findViewById(R.id.g69);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "root.findViewById(R.id.pwd_rule2_tx)");
        this.rule2text = (TextView) findViewById11;
        View findViewById12 = this.E.findViewById(R.id.f166561g64);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "root.findViewById(R.id.pwd_rule1_check)");
        this.rule1Img = (ImageView) findViewById12;
        View findViewById13 = this.E.findViewById(R.id.g67);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "root.findViewById(R.id.pwd_rule2_check)");
        this.rule2Img = (ImageView) findViewById13;
        View findViewById14 = this.E.findViewById(R.id.fiu);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "root.findViewById(R.id.password_eye)");
        this.passwordEye = (ImageView) findViewById14;
        si();
        PastablePwdEditText pastablePwdEditText4 = this.editPassword;
        if (pastablePwdEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText4 = null;
        }
        ri(pastablePwdEditText4, false, R.string.f20376513);
        PastablePwdEditText pastablePwdEditText5 = this.editPassword;
        if (pastablePwdEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText5 = null;
        }
        pastablePwdEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.register.fragment.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                RegisterNickAndPwdFragment.fi(RegisterNickAndPwdFragment.this, view, z16);
            }
        });
        WechatInfo wechatInfo = this.mWechatInfo;
        if (wechatInfo != null) {
            str = wechatInfo.g();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            PastablePwdEditText pastablePwdEditText6 = this.editNickname;
            if (pastablePwdEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editNickname");
                pastablePwdEditText6 = null;
            }
            pastablePwdEditText6.setText(str);
            PastablePwdEditText pastablePwdEditText7 = this.editNickname;
            if (pastablePwdEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editNickname");
                pastablePwdEditText7 = null;
            }
            PastablePwdEditText pastablePwdEditText8 = this.editNickname;
            if (pastablePwdEditText8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editNickname");
                pastablePwdEditText8 = null;
            }
            pastablePwdEditText7.setSelection(pastablePwdEditText8.getText().length());
        }
        PastablePwdEditText pastablePwdEditText9 = this.editNickname;
        if (pastablePwdEditText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText9 = null;
        }
        ri(pastablePwdEditText9, false, R.string.f20375512);
        PastablePwdEditText pastablePwdEditText10 = this.editNickname;
        if (pastablePwdEditText10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText10 = null;
        }
        pastablePwdEditText10.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.register.fragment.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                RegisterNickAndPwdFragment.gi(RegisterNickAndPwdFragment.this, view, z16);
            }
        });
        IQSecChannel iQSecChannel = (IQSecChannel) QRoute.api(IQSecChannel.class);
        AppInterface appInterface = (AppInterface) this.app;
        String str2 = com.tencent.mobileqq.dt.api.c.f203661x;
        PastablePwdEditText pastablePwdEditText11 = this.editNickname;
        if (pastablePwdEditText11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText11 = null;
        }
        iQSecChannel.regTouchEvent(appInterface, str2, pastablePwdEditText11);
        IQSecChannel iQSecChannel2 = (IQSecChannel) QRoute.api(IQSecChannel.class);
        AppInterface appInterface2 = (AppInterface) this.app;
        String str3 = com.tencent.mobileqq.dt.api.c.f203662y;
        PastablePwdEditText pastablePwdEditText12 = this.editPassword;
        if (pastablePwdEditText12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
        } else {
            pastablePwdEditText2 = pastablePwdEditText12;
        }
        iQSecChannel2.regTouchEvent(appInterface2, str3, pastablePwdEditText2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(RegisterNickAndPwdFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PastablePwdEditText pastablePwdEditText = this$0.editPassword;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText = null;
        }
        if (view == pastablePwdEditText) {
            if (z16) {
                PastablePwdEditText pastablePwdEditText3 = this$0.editPassword;
                if (pastablePwdEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                    pastablePwdEditText3 = null;
                }
                PastablePwdEditText pastablePwdEditText4 = this$0.editPassword;
                if (pastablePwdEditText4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                    pastablePwdEditText4 = null;
                }
                pastablePwdEditText3.setSelection(pastablePwdEditText4.getText().length());
                ImageView imageView = this$0.passwordEye;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
                    imageView = null;
                }
                imageView.setVisibility(0);
                View view2 = this$0.rule1Root;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rule1Root");
                    view2 = null;
                }
                view2.setVisibility(0);
                View view3 = this$0.rule2Root;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rule2Root");
                    view3 = null;
                }
                view3.setVisibility(0);
            } else {
                ImageView imageView2 = this$0.passwordEye;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
            }
            PastablePwdEditText pastablePwdEditText5 = this$0.editPassword;
            if (pastablePwdEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            } else {
                pastablePwdEditText2 = pastablePwdEditText5;
            }
            this$0.ri(pastablePwdEditText2, z16, R.string.f20376513);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(RegisterNickAndPwdFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PastablePwdEditText pastablePwdEditText = this$0.editNickname;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText = null;
        }
        if (Intrinsics.areEqual(view, pastablePwdEditText)) {
            PastablePwdEditText pastablePwdEditText3 = this$0.editNickname;
            if (pastablePwdEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            } else {
                pastablePwdEditText2 = pastablePwdEditText3;
            }
            this$0.ri(pastablePwdEditText2, z16, R.string.f20375512);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(RegisterNickAndPwdFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new a();
    }

    private final void ii() {
        QQProAvatarView qQProAvatarView = this.ivAvatar1;
        if (qQProAvatarView != null) {
            qQProAvatarView.y(new ZPlanOutboundAvatarInfo("https://static-res.qq.com/static-res/zplan/aio/head/register_head/1006_302_female_Cropped1.png", "https://static-res.qq.com/static-res/zplan/aio/head/background/81.jpg", 60, 0, 0, 24, null));
        }
        QQProAvatarView qQProAvatarView2 = this.ivAvatar1;
        if (qQProAvatarView2 != null) {
            qQProAvatarView2.setEnableFrame(false);
        }
        QQProAvatarView qQProAvatarView3 = this.ivAvatar2;
        if (qQProAvatarView3 != null) {
            qQProAvatarView3.y(new ZPlanOutboundAvatarInfo("https://static-res.qq.com/static-res/zplan/aio/head/register_head/1001_398_male_Cropped.png", "https://static-res.qq.com/static-res/zplan/aio/head/background/38.png", 25, 0, 0, 24, null));
        }
        QQProAvatarView qQProAvatarView4 = this.ivAvatar2;
        if (qQProAvatarView4 != null) {
            qQProAvatarView4.setEnableFrame(false);
        }
        QQProAvatarView qQProAvatarView5 = this.ivAvatar;
        if (qQProAvatarView5 != null) {
            qQProAvatarView5.setVisibility(0);
        }
        QQProAvatarView qQProAvatarView6 = this.ivAvatar1;
        if (qQProAvatarView6 != null) {
            qQProAvatarView6.setVisibility(4);
        }
        QQProAvatarView qQProAvatarView7 = this.ivAvatar2;
        if (qQProAvatarView7 != null) {
            qQProAvatarView7.setVisibility(4);
        }
        QQProAvatarView qQProAvatarView8 = this.ivAvatar1;
        if (qQProAvatarView8 != null) {
            qQProAvatarView8.i(new c());
        }
        QQProAvatarView qQProAvatarView9 = this.ivAvatar2;
        if (qQProAvatarView9 != null) {
            qQProAvatarView9.i(new d());
        }
        pi();
    }

    private final void initViews() {
        List listOf;
        View findViewById = this.E.findViewById(R.id.f72493r0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.register_container)");
        this.container = (ViewGroup) findViewById;
        View findViewById2 = this.E.findViewById(R.id.f164550a34);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.avatar_group)");
        this.avatarGroup = (RelativeLayout) findViewById2;
        View findViewById3 = this.E.findViewById(R.id.zqx);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.nick_and_pwd_group)");
        this.nickAndPwdGroup = (LinearLayout) findViewById3;
        View findViewById4 = this.E.findViewById(R.id.tjh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.button_group)");
        this.buttonGroup = (LinearLayout) findViewById4;
        di();
        bi();
        ci();
        ei();
        ai();
        View[] viewArr = new View[8];
        ImageView imageView = this.backBtn;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            imageView = null;
        }
        viewArr[0] = imageView;
        ImageView imageView2 = this.passwordEye;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
            imageView2 = null;
        }
        viewArr[1] = imageView2;
        Button button = this.btnRegister;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRegister");
            button = null;
        }
        viewArr[2] = button;
        Button button2 = this.btnLogin;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLogin");
            button2 = null;
        }
        viewArr[3] = button2;
        ImageView imageView3 = this.nicknameClean;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nicknameClean");
            imageView3 = null;
        }
        viewArr[4] = imageView3;
        ImageView imageView4 = this.passwordClean;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordClean");
            imageView4 = null;
        }
        viewArr[5] = imageView4;
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        viewArr[6] = viewGroup;
        RelativeLayout relativeLayout2 = this.avatarGroup;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarGroup");
        } else {
            relativeLayout = relativeLayout2;
        }
        viewArr[7] = relativeLayout;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(this);
        }
        this.E.post(new Runnable() { // from class: com.tencent.mobileqq.register.fragment.d
            @Override // java.lang.Runnable
            public final void run() {
                RegisterNickAndPwdFragment.hi(RegisterNickAndPwdFragment.this);
            }
        });
        li();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(View view, float offset) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", offset, 0.0f);
        ofFloat.setDuration(160L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki(View view, float offset) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, offset);
        ofFloat.setDuration(160L);
        ofFloat.start();
    }

    private final void li() {
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        z.q(viewGroup, getQBaseActivity());
    }

    private final void mi() {
        String str;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            qi(R.string.b3j, 0);
            return;
        }
        if (!Zh()) {
            return;
        }
        PastablePwdEditText pastablePwdEditText = this.editNickname;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText = null;
        }
        String obj = pastablePwdEditText.getText().toString();
        WechatInfo wechatInfo = this.mWechatInfo;
        if (wechatInfo != null) {
            str = wechatInfo.g();
        } else {
            str = null;
        }
        if (!TextUtils.equals(obj, str)) {
            cb.d("0X800C32C");
        }
        Intent intent = this.C.getIntent();
        PastablePwdEditText pastablePwdEditText3 = this.editPassword;
        if (pastablePwdEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
        } else {
            pastablePwdEditText2 = pastablePwdEditText3;
        }
        intent.putExtra(AppConstants.Key.KEY_REGISTER_PASSWORD, pastablePwdEditText2.getText().toString());
        this.C.getIntent().putExtra(AppConstants.Key.KEY_REGISTER_NICK, obj);
        this.C.getIntent().putExtra("avatar_local_path", this.avatarLocalPath);
        this.C.getIntent().putExtra("key_register_avatar_info", this.selectedAvatarInfo);
        if (this.registerWithNickAndPwd == null) {
            Intent intent2 = this.C.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "mContext.intent");
            this.registerWithNickAndPwd = new u(this, intent2);
        }
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            u uVar = this.registerWithNickAndPwd;
            Intrinsics.checkNotNull(uVar);
            Intent intent3 = this.C.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "mContext.intent");
            uVar.l(intent3);
        } else {
            u uVar2 = this.registerWithNickAndPwd;
            Intrinsics.checkNotNull(uVar2);
            Intent intent4 = this.C.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent4, "mContext.intent");
            uVar2.k(intent4);
        }
        cb.f306645a.i("0X8006653");
    }

    private final void ni() {
        PastablePwdEditText pastablePwdEditText = this.editNickname;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText = null;
        }
        pastablePwdEditText.setCustomClearButtonCallback(new e());
        PastablePwdEditText pastablePwdEditText3 = this.editPassword;
        if (pastablePwdEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
        } else {
            pastablePwdEditText2 = pastablePwdEditText3;
        }
        pastablePwdEditText2.setCustomClearButtonCallback(new f());
    }

    private final void oi(boolean isHideInput) {
        WindowManager.LayoutParams attributes = this.C.getWindow().getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "mContext.window.attributes");
        if (isHideInput) {
            this.C.getWindow().setSoftInputMode((attributes.softInputMode & (-5)) | 2);
        } else {
            this.C.getWindow().setSoftInputMode((attributes.softInputMode & (-3)) | 4);
        }
        if (QLog.isColorLevel()) {
            QLog.i("RegisterNickAndPwdFragment", 2, "setSoftInputMode, isHideInput = " + isHideInput + ",mode = " + attributes.softInputMode);
        }
    }

    private final void pi() {
        if (!LoginUtil.i("key_bubble_tip_shown")) {
            QUIDefaultBubbleTip.r(getQBaseActivity()).S(this.E.findViewById(R.id.f73033sg)).o0(getString(R.string.f20379516)).k0(1).R(0).m0(4).i0(0.0f, 4.0f).s0();
            LoginUtil.s("key_bubble_tip_shown");
        }
    }

    private final void qi(int resId, int icon) {
        String string = getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(resId)");
        zh(string, icon);
        as.g(this.app, "0X800C1C9", "", ao.INSTANCE.c(), string);
    }

    private final void ri(PastablePwdEditText editView, boolean hasFocus, int stringId) {
        if (hasFocus) {
            editView.setSelection(editView.length());
            editView.setHint("");
        } else {
            editView.setHint(LoginUtil.d(ViewUtils.spToPx(17.0f), stringId));
        }
    }

    private final void si() {
        ImageView imageView = null;
        if (this.mPassInvisible) {
            PastablePwdEditText pastablePwdEditText = this.editPassword;
            if (pastablePwdEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                pastablePwdEditText = null;
            }
            pastablePwdEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ImageView imageView2 = this.passwordEye;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
                imageView2 = null;
            }
            imageView2.setImageResource(R.drawable.qui_eye_on_secondary_01_selector);
            ImageView imageView3 = this.passwordEye;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
            } else {
                imageView = imageView3;
            }
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f211245ka));
            return;
        }
        PastablePwdEditText pastablePwdEditText2 = this.editPassword;
        if (pastablePwdEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText2 = null;
        }
        pastablePwdEditText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        ImageView imageView4 = this.passwordEye;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
            imageView4 = null;
        }
        imageView4.setImageResource(R.drawable.qui_eye_off_secondary_01_selector);
        ImageView imageView5 = this.passwordEye;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
        } else {
            imageView = imageView5;
        }
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f211415kr));
    }

    public final void Yh(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) uin);
            return;
        }
        Button button = this.btnRegister;
        ImageView imageView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRegister");
            button = null;
        }
        button.setVisibility(8);
        Button button2 = this.btnLogin;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLogin");
            button2 = null;
        }
        button2.setVisibility(0);
        Button button3 = this.btnLogin;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLogin");
            button3 = null;
        }
        button3.setEnabled(true);
        PastablePwdEditText pastablePwdEditText = this.editNickname;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText = null;
        }
        pastablePwdEditText.setEnabled(false);
        PastablePwdEditText pastablePwdEditText2 = this.editPassword;
        if (pastablePwdEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText2 = null;
        }
        pastablePwdEditText2.setEnabled(false);
        ImageView imageView2 = this.passwordEye;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEye");
        } else {
            imageView = imageView2;
        }
        imageView.setEnabled(false);
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.app, com.tencent.mobileqq.dt.api.c.A, uin);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s16) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        PastablePwdEditText pastablePwdEditText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) s16);
            return;
        }
        if (s16 == null) {
            return;
        }
        PastablePwdEditText pastablePwdEditText2 = this.editNickname;
        if (pastablePwdEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText2 = null;
        }
        Editable text = pastablePwdEditText2.getText();
        PastablePwdEditText pastablePwdEditText3 = this.editPassword;
        if (pastablePwdEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText3 = null;
        }
        Editable text2 = pastablePwdEditText3.getText();
        if (s16 != text && s16 != text2) {
            return;
        }
        String obj = text.toString();
        String obj2 = text2.toString();
        if (!TextUtils.isEmpty(obj2) && obj2.length() >= 8) {
            ImageView imageView = this.rule1Img;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule1Img");
                imageView = null;
            }
            imageView.setBackgroundResource(R.drawable.ksc);
            TextView textView = this.rule1text;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule1text");
                textView = null;
            }
            textView.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_feedback_success));
            z16 = true;
        } else {
            ImageView imageView2 = this.rule1Img;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule1Img");
                imageView2 = null;
            }
            imageView2.setBackgroundResource(R.drawable.ksd);
            TextView textView2 = this.rule1text;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule1text");
                textView2 = null;
            }
            textView2.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_text_secondary));
            z16 = false;
        }
        if (!TextUtils.isEmpty(obj2) && com.tencent.mobileqq.register.util.c.f280585a.b(obj2)) {
            ImageView imageView3 = this.rule2Img;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule2Img");
                imageView3 = null;
            }
            imageView3.setBackgroundResource(R.drawable.ksc);
            TextView textView3 = this.rule2text;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule2text");
                textView3 = null;
            }
            textView3.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_feedback_success));
            z17 = true;
        } else {
            ImageView imageView4 = this.rule2Img;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule2Img");
                imageView4 = null;
            }
            imageView4.setBackgroundResource(R.drawable.ksd);
            TextView textView4 = this.rule2text;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule2text");
                textView4 = null;
            }
            textView4.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_text_secondary));
            z17 = false;
        }
        com.tencent.mobileqq.register.util.c cVar = com.tencent.mobileqq.register.util.c.f280585a;
        PastablePwdEditText pastablePwdEditText4 = this.editPassword;
        if (pastablePwdEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            pastablePwdEditText4 = null;
        }
        if (cVar.d(pastablePwdEditText4.getText().toString(), 6)) {
            View view = this.rule3Root;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule3Root");
                view = null;
            }
            view.setVisibility(0);
            z18 = false;
        } else {
            View view2 = this.rule3Root;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rule3Root");
                view2 = null;
            }
            view2.setVisibility(8);
            z18 = true;
        }
        Button button = this.btnRegister;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRegister");
            button = null;
        }
        if (!TextUtils.isEmpty(obj) && z16 && z17 && z18) {
            z19 = true;
        } else {
            z19 = false;
        }
        button.setEnabled(z19);
        if (s16 == text2) {
            if (TextUtils.isEmpty(obj2)) {
                PastablePwdEditText pastablePwdEditText5 = this.editPassword;
                if (pastablePwdEditText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                    pastablePwdEditText = null;
                } else {
                    pastablePwdEditText = pastablePwdEditText5;
                }
                pastablePwdEditText.setClearButtonVisible(false);
                return;
            }
            PastablePwdEditText pastablePwdEditText6 = this.editPassword;
            if (pastablePwdEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                pastablePwdEditText6 = null;
            }
            pastablePwdEditText6.setClearButtonVisible(true);
            String substring = obj2.substring(obj2.length() - 1, obj2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            try {
                int length = substring.length();
                Charset forName = Charset.forName("utf-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                byte[] bytes = substring.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                if (length < bytes.length) {
                    s16.delete(obj2.length() - 1, obj2.length());
                }
            } catch (UnsupportedEncodingException unused) {
                QLog.e("RegisterNickAndPwdFragment", 1, "afterTextChanged error: e");
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onAccountChanged();
        u uVar = this.registerWithNickAndPwd;
        if (uVar != null) {
            Intrinsics.checkNotNull(uVar);
            uVar.o();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (resultCode != -1) {
            return;
        }
        if (requestCode != 5) {
            if (requestCode == 10024 && data != null && data.getExtras() != null) {
                Bundle extras = data.getExtras();
                ImageView imageView = null;
                if (extras != null) {
                    str = extras.getString("PhotoConst.SINGLE_PHOTO_PATH");
                } else {
                    str = null;
                }
                this.avatarLocalPath = str;
                this.selectedAvatarInfo = null;
                QQProAvatarView qQProAvatarView = this.ivAvatar;
                if (qQProAvatarView != null) {
                    imageView = qQProAvatarView.s();
                }
                if (imageView == null) {
                    QLog.e("RegisterNickAndPwdFragment", 1, "ivAvatar is null");
                    return;
                } else {
                    ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).decodeAvatar(this.avatarLocalPath, imageView);
                    return;
                }
            }
            return;
        }
        ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).enterClipPage(getActivity(), this.uploadPhotoUri);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        cb.f("0X800C3BA", "0X800C3B9", 2, "");
        com.tencent.mobileqq.loginregister.callback.b d16 = q.c().d();
        if (d16 != null) {
            d16.a(RegisterResult.RegisterCancel);
        }
        finishActivity();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            if (id5 == R.id.ajd) {
                mi();
                ai();
            } else {
                PastablePwdEditText pastablePwdEditText = null;
                if (id5 == R.id.fiu) {
                    PastablePwdEditText pastablePwdEditText2 = this.editPassword;
                    if (pastablePwdEditText2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                        pastablePwdEditText2 = null;
                    }
                    String obj = pastablePwdEditText2.getText().toString();
                    this.mPassInvisible = !this.mPassInvisible;
                    si();
                    if (!TextUtils.isEmpty(obj)) {
                        PastablePwdEditText pastablePwdEditText3 = this.editPassword;
                        if (pastablePwdEditText3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                            pastablePwdEditText3 = null;
                        }
                        PastablePwdEditText pastablePwdEditText4 = this.editPassword;
                        if (pastablePwdEditText4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                        } else {
                            pastablePwdEditText = pastablePwdEditText4;
                        }
                        pastablePwdEditText3.setSelection(pastablePwdEditText.length());
                    }
                } else if (id5 == R.id.login) {
                    u uVar = this.registerWithNickAndPwd;
                    if (uVar != null) {
                        Intrinsics.checkNotNull(uVar);
                        uVar.s();
                    }
                    ai();
                } else if (id5 == R.id.f164550a34) {
                    if (this.avatarSelectComponent == null) {
                        QBaseActivity qBaseActivity = getQBaseActivity();
                        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
                        this.avatarSelectComponent = new AvatarSelectComponent(qBaseActivity);
                    }
                    AvatarSelectComponent avatarSelectComponent = this.avatarSelectComponent;
                    if (avatarSelectComponent != null) {
                        avatarSelectComponent.i(new Function2<ZPlanAvatarInfo, Uri, Unit>() { // from class: com.tencent.mobileqq.register.fragment.RegisterNickAndPwdFragment$onClick$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(2);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RegisterNickAndPwdFragment.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(ZPlanAvatarInfo zPlanAvatarInfo, Uri uri) {
                                invoke2(zPlanAvatarInfo, uri);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@Nullable ZPlanAvatarInfo zPlanAvatarInfo, @Nullable Uri uri) {
                                QQProAvatarView qQProAvatarView;
                                QQProAvatarView qQProAvatarView2;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) zPlanAvatarInfo, (Object) uri);
                                    return;
                                }
                                if (uri != null) {
                                    RegisterNickAndPwdFragment.this.uploadPhotoUri = uri;
                                    return;
                                }
                                if (zPlanAvatarInfo != null) {
                                    RegisterNickAndPwdFragment.this.avatarLocalPath = null;
                                    RegisterNickAndPwdFragment.this.selectedAvatarInfo = zPlanAvatarInfo;
                                    qQProAvatarView = RegisterNickAndPwdFragment.this.ivAvatar;
                                    if (qQProAvatarView != null) {
                                        qQProAvatarView.y(new ZPlanOutboundAvatarInfo(zPlanAvatarInfo.a(), zPlanAvatarInfo.c(), zPlanAvatarInfo.f(), 0, 0, 24, null));
                                    }
                                    qQProAvatarView2 = RegisterNickAndPwdFragment.this.ivAvatar;
                                    if (qQProAvatarView2 != null) {
                                        qQProAvatarView2.setEnableFrame(false);
                                    }
                                }
                            }
                        });
                    }
                    cb.f306645a.i("0X800C326");
                    ai();
                } else if (id5 == R.id.a47) {
                    onBackEvent();
                } else if (id5 == R.id.fis) {
                    PastablePwdEditText pastablePwdEditText5 = this.editPassword;
                    if (pastablePwdEditText5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editPassword");
                    } else {
                        pastablePwdEditText = pastablePwdEditText5;
                    }
                    pastablePwdEditText.h();
                } else if (id5 == R.id.zrc) {
                    PastablePwdEditText pastablePwdEditText6 = this.editNickname;
                    if (pastablePwdEditText6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editNickname");
                    } else {
                        pastablePwdEditText = pastablePwdEditText6;
                    }
                    pastablePwdEditText.h();
                } else if (id5 == R.id.f72493r0) {
                    ai();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        AvatarSelectComponent avatarSelectComponent = this.avatarSelectComponent;
        if (avatarSelectComponent != null) {
            avatarSelectComponent.g();
        }
        li();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WechatInfo wechatInfo;
        View view;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            this.E = inflater.inflate(R.layout.gyl, container, false);
            QBaseActivity qBaseActivity = getQBaseActivity();
            Button button = null;
            if (qBaseActivity != null && (intent = qBaseActivity.getIntent()) != null) {
                wechatInfo = (WechatInfo) intent.getParcelableExtra("key_wechat_binding_info");
            } else {
                wechatInfo = null;
            }
            this.mWechatInfo = wechatInfo;
            if (!wh()) {
                view = this.E;
            } else {
                initViews();
                if (needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
                    ImmersiveUtils.setStatusTextColor(!ThemeUtil.isNowThemeIsNight(null, false, null), requireActivity().getWindow());
                }
                cb.f306645a.i("0X800C325");
                IQSecChannel iQSecChannel = (IQSecChannel) QRoute.api(IQSecChannel.class);
                String str = com.tencent.mobileqq.dt.api.c.f203663z;
                Button button2 = this.btnRegister;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnRegister");
                } else {
                    button = button2;
                }
                iQSecChannel.setTouchEvent(str, button);
                ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.app, com.tencent.mobileqq.dt.api.c.f203659v, "");
                ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiStartSensor((AppInterface) this.app, com.tencent.mobileqq.dt.api.c.f203638a);
                view = this.E;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        rh();
        u uVar = this.registerWithNickAndPwd;
        if (uVar != null) {
            Intrinsics.checkNotNull(uVar);
            uVar.p();
        }
        this.avatarSelectComponent = null;
        ce.e(getQBaseActivity());
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.app, com.tencent.mobileqq.dt.api.c.f203641d, "");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onFinish();
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) this.app, com.tencent.mobileqq.dt.api.c.f203660w, "");
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiEndSensor((AppInterface) this.app, com.tencent.mobileqq.dt.api.c.f203638a);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onPause();
        u uVar = this.registerWithNickAndPwd;
        if (uVar != null) {
            Intrinsics.checkNotNull(uVar);
            uVar.q();
        }
        PastablePwdEditText pastablePwdEditText = this.editNickname;
        PastablePwdEditText pastablePwdEditText2 = null;
        if (pastablePwdEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editNickname");
            pastablePwdEditText = null;
        }
        if (!pastablePwdEditText.isFocused()) {
            PastablePwdEditText pastablePwdEditText3 = this.editPassword;
            if (pastablePwdEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editPassword");
            } else {
                pastablePwdEditText2 = pastablePwdEditText3;
            }
            if (!pastablePwdEditText2.isFocused()) {
                z16 = true;
                oi(z16);
            }
        }
        z16 = false;
        oi(z16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onResume();
        q.c().l(6);
        u uVar = this.registerWithNickAndPwd;
        if (uVar != null) {
            Intrinsics.checkNotNull(uVar);
            uVar.r();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }
}
