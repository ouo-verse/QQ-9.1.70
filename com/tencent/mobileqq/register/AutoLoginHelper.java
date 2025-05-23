package com.tencent.mobileqq.register;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.taf.jce.HexUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.RegisterNewBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.c;
import com.tencent.mobileqq.login.y;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.loginregister.callback.RegisterResult;
import com.tencent.mobileqq.loginregister.v;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.mobileqq.register.fragment.RegisterPhoneNumFragment;
import com.tencent.mobileqq.servlet.RegisterZPlanAvatarHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarUploadService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager;
import com.tencent.util.LoadingUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u0001\u0018B\u001b\u0012\b\u0010E\u001a\u0004\u0018\u00010.\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0019R\u0018\u0010&\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u00102\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010!R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/register/AutoLoginHelper;", "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "j", UserInfo.SEX_FEMALE, "k", "", "headUrl", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "D", "p", "Landroid/content/Intent;", "o", "w", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "a", "Ljava/lang/String;", "phoneNum", "b", "countryCode", "c", "mUin", "", "d", "[B", "mSign", "e", "mPassword", "f", "mPassByte", "Landroid/app/Dialog;", "g", "Landroid/app/Dialog;", "mLoadingDialog", tl.h.F, "Landroid/content/Intent;", "mIntent", "Lcom/tencent/mobileqq/fragment/RegisterNewBaseFragment;", "i", "Lcom/tencent/mobileqq/fragment/RegisterNewBaseFragment;", "mFragment", "Z", "isLogining", "()Z", "B", "(Z)V", "isStartingMain", "setStartingMain", "l", "mSuperSig", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "mWechatInfo", "mAvatarLocalPath", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "selectedAvatarInfo", "Lcom/tencent/mobileqq/login/aa;", "Lcom/tencent/mobileqq/login/aa;", "mAccountLoginCallback", "fragment", "intent", "<init>", "(Lcom/tencent/mobileqq/fragment/RegisterNewBaseFragment;Landroid/content/Intent;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AutoLoginHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private static final File f280310r;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String phoneNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String countryCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mSign;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mPassword;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mPassByte;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mLoadingDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent mIntent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RegisterNewBaseFragment mFragment;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isLogining;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isStartingMain;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mSuperSig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WechatInfo mWechatInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mAvatarLocalPath;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ZPlanAvatarInfo selectedAvatarInfo;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private aa mAccountLoginCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/register/AutoLoginHelper$a;", "", "", "DELAY_TIME", "J", "Ljava/io/File;", "HEAD_FILE", "Ljava/io/File;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.AutoLoginHelper$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/register/AutoLoginHelper$b", "Lcom/tencent/mobileqq/login/aa;", "", "uin", "Landroid/os/Bundle;", "bundle", "", "c", "Lcom/tencent/mobileqq/login/aj;", "failedInfo", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements aa {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoLoginHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            AutoLoginHelper.this.B(false);
            AutoLoginHelper.this.p();
            if (QLog.isColorLevel()) {
                QLog.d("AutoLoginHelper", 2, "onLoginCancel");
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(@NotNull aj failedInfo) {
            FragmentActivity fragmentActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) failedInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(failedInfo, "failedInfo");
            if (QLog.isDevelopLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s", Arrays.copyOf(new Object[]{Integer.valueOf(failedInfo.f241864a), AutoLoginHelper.this.mUin, failedInfo.f241866c}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                QLog.d("AutoLoginHelper", 1, format);
            }
            RegisterNewBaseFragment registerNewBaseFragment = AutoLoginHelper.this.mFragment;
            QBaseActivity qBaseActivity = null;
            if (registerNewBaseFragment != null) {
                fragmentActivity = registerNewBaseFragment.getActivity();
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) fragmentActivity;
            }
            if (qBaseActivity == null) {
                return;
            }
            AutoLoginHelper.this.B(false);
            AutoLoginHelper.this.p();
            if (AutoLoginHelper.this.mFragment != null) {
                Intent intent = new Intent(qBaseActivity, (Class<?>) LoginActivity.class);
                intent.putExtra("uin", AutoLoginHelper.this.mUin);
                intent.putExtra("tab_index", 0);
                intent.addFlags(131072);
                intent.putExtra("loginFragmentType", 5);
                qBaseActivity.startActivity(intent);
                RegisterResult registerResult = RegisterResult.RegisterAndLoginFailed;
                cb.f("0X800C3BA", "0X800C3B9", registerResult.getResult(), "");
                com.tencent.mobileqq.loginregister.callback.b d16 = q.c().d();
                if (d16 != null) {
                    d16.a(registerResult);
                }
                qBaseActivity.finish();
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(@NotNull String uin, @NotNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) bundle);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            AutoLoginHelper.this.B(false);
            int c16 = ao.INSTANCE.c();
            ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", AutoLoginHelper.this.mUin, "0X800BC97", "0X800BC97", c16, 0, "", cb.f306645a.c(), com.tencent.mobileqq.statistics.o.c(), "");
            RegisterResult registerResult = RegisterResult.RegisterAndLoginSuccess;
            cb.f("0X800C3BA", "0X800C3B9", registerResult.getResult(), "");
            com.tencent.mobileqq.loginregister.callback.b d16 = q.c().d();
            if (d16 != null) {
                d16.a(registerResult);
            }
            QLog.d("AutoLoginHelper", 1, "AccountObserver ,onLoginSuccess ");
            AutoLoginHelper.this.p();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/register/AutoLoginHelper$c", "Lcom/tencent/mobileqq/login/y;", "", "msg", "", "a", "", "loginSuccess", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements y {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void a(@Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void b(boolean loginSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, loginSuccess);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
            f280310r = new File(BaseApplication.getContext().getCacheDir(), "head/wxHead.jpg");
        }
    }

    public AutoLoginHelper(@Nullable RegisterNewBaseFragment registerNewBaseFragment, @Nullable Intent intent) {
        WechatInfo wechatInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) registerNewBaseFragment, (Object) intent);
            return;
        }
        this.countryCode = "86";
        this.mFragment = registerNewBaseFragment;
        this.mIntent = intent;
        if (intent != null) {
            wechatInfo = (WechatInfo) intent.getParcelableExtra("key_wechat_binding_info");
        } else {
            wechatInfo = null;
        }
        this.mWechatInfo = wechatInfo;
        if (intent != null) {
            str = intent.getStringExtra("avatar_local_path");
        } else {
            str = null;
        }
        this.mAvatarLocalPath = str;
        this.selectedAvatarInfo = intent != null ? (ZPlanAvatarInfo) intent.getParcelableExtra("key_register_avatar_info") : null;
        this.mAccountLoginCallback = new b();
    }

    private final void A() {
        Uri uri;
        String str = null;
        if (!TextUtils.isEmpty(this.mAvatarLocalPath)) {
            uri = Uri.parse(this.mAvatarLocalPath);
        } else {
            uri = null;
        }
        WechatInfo wechatInfo = this.mWechatInfo;
        if (wechatInfo != null) {
            str = wechatInfo.b();
        }
        if (!TextUtils.isEmpty(str)) {
            uri = Uri.parse(str);
        }
        com.tencent.mobileqq.register.avatar.d.f280340a.d(this.selectedAvatarInfo, uri, this.mUin);
        QLog.i("AutoLoginHelper", 1, "setAvatarInfo selectedAvatarInfo:" + this.selectedAvatarInfo + ", uri:" + uri);
    }

    private final void C(String headUrl) {
        try {
            QRouteApi api = QRoute.api(IZPlanApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
            IZPlanApi iZPlanApi = (IZPlanApi) api;
            String n3 = n(headUrl);
            QLog.i("AutoLoginHelper", 1, "1. downloadWxHead with url: " + n3);
            if (m(n3)) {
                String absolutePath = f280310r.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "HEAD_FILE.absolutePath");
                iZPlanApi.setAvatarFromPeak(absolutePath, AutoLoginHelper$setWxHead$1.INSTANCE);
            }
            QLog.i("AutoLoginHelper", 1, "2. downloadWxHead with url: " + headUrl);
            if (m(headUrl)) {
                String absolutePath2 = f280310r.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath2, "HEAD_FILE.absolutePath");
                iZPlanApi.setAvatarFromPeak(absolutePath2, AutoLoginHelper$setWxHead$2.INSTANCE);
            }
        } catch (Exception e16) {
            QLog.d("AutoLoginHelper", 1, "setWxHead e = " + e16);
        }
    }

    private final void D() {
        FragmentActivity fragmentActivity;
        RegisterNewBaseFragment registerNewBaseFragment = this.mFragment;
        final QBaseActivity qBaseActivity = null;
        if (registerNewBaseFragment != null) {
            fragmentActivity = registerNewBaseFragment.getActivity();
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) fragmentActivity;
        }
        if (qBaseActivity == null) {
            return;
        }
        RegisterNewBaseFragment registerNewBaseFragment2 = this.mFragment;
        Intrinsics.checkNotNull(registerNewBaseFragment2);
        registerNewBaseFragment2.H.post(new Runnable() { // from class: com.tencent.mobileqq.register.e
            @Override // java.lang.Runnable
            public final void run() {
                AutoLoginHelper.E(AutoLoginHelper.this, qBaseActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AutoLoginHelper this$0, QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            if (this$0.mLoadingDialog == null && !activity.isFinishing()) {
                this$0.mLoadingDialog = LoadingUtil.showLoadingDialog(activity, HardCodeUtil.qqStr(R.string.f211365km), false);
            }
        } catch (Throwable th5) {
            QLog.e("AutoLoginHelper", 2, "error: " + th5);
        }
        Dialog dialog = this$0.mLoadingDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (!dialog.isShowing()) {
                Dialog dialog2 = this$0.mLoadingDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.show();
            }
        }
    }

    private final void F() {
        if (this.mFragment == null) {
            return;
        }
        this.isStartingMain = true;
        p();
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.register.f
            @Override // java.lang.Runnable
            public final void run() {
                AutoLoginHelper.G(AutoLoginHelper.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AutoLoginHelper this$0) {
        MqqHandler mqqHandler;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        QBaseActivity qBaseActivity = null;
        if (appInterface != null) {
            mqqHandler = appInterface.getHandler(v.class);
        } else {
            mqqHandler = null;
        }
        if (mqqHandler != null) {
            mqqHandler.sendEmptyMessage(2004);
        }
        com.tencent.mobileqq.login.fragment.l.c(com.tencent.mobileqq.login.fragment.l.f242160a, false, 1, null);
        RegisterNewBaseFragment registerNewBaseFragment = this$0.mFragment;
        if (registerNewBaseFragment != null) {
            qBaseActivity = registerNewBaseFragment.getQBaseActivity();
        }
        if (qBaseActivity == null) {
            return;
        }
        QRoute.createNavigator(qBaseActivity, RouterConstants.UI_ROUTER_SPLASH).withInt("tab_index", 0).withInt(SplashActivity.FRAGMENT_ID, 1).withBoolean("is_need_close_drawer", true).withFlags(67108864).requestWithReturn();
        qBaseActivity.finish();
    }

    private final void j() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e("AutoLoginHelper", 1, "closeAllActs, app is not appinterface");
            return;
        }
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        MqqHandler handler = appInterface.getHandler(RegisterSendUpSms.class);
        if (handler != null) {
            handler.sendEmptyMessage(107);
        }
        MqqHandler handler2 = appInterface.getHandler(RegisterPhoneNumFragment.class);
        if (handler2 != null) {
            handler2.sendEmptyMessage(2004);
        }
    }

    private final void k() {
        String str;
        String str2;
        Integer num;
        Integer num2;
        byte[] bArr;
        QLog.d("AutoLoginHelper", 1, "set zplan avatar");
        ZPlanAvatarInfo zPlanAvatarInfo = this.selectedAvatarInfo;
        if (zPlanAvatarInfo != null) {
            str = zPlanAvatarInfo.g();
        } else {
            str = null;
        }
        ZPlanAvatarInfo zPlanAvatarInfo2 = this.selectedAvatarInfo;
        if (zPlanAvatarInfo2 != null) {
            str2 = zPlanAvatarInfo2.a();
        } else {
            str2 = null;
        }
        ZPlanAvatarInfo zPlanAvatarInfo3 = this.selectedAvatarInfo;
        if (zPlanAvatarInfo3 != null) {
            num = Integer.valueOf(zPlanAvatarInfo3.b());
        } else {
            num = null;
        }
        ZPlanAvatarInfo zPlanAvatarInfo4 = this.selectedAvatarInfo;
        if (zPlanAvatarInfo4 != null) {
            num2 = Integer.valueOf(zPlanAvatarInfo4.f());
        } else {
            num2 = null;
        }
        ZPlanAvatarInfo zPlanAvatarInfo5 = this.selectedAvatarInfo;
        if (zPlanAvatarInfo5 != null) {
            bArr = zPlanAvatarInfo5.e();
        } else {
            bArr = null;
        }
        if (str != null && str2 != null && num != null && num2 != null) {
            final String str3 = str;
            final String str4 = str2;
            final Integer num3 = num;
            final Integer num4 = num2;
            final byte[] bArr2 = bArr;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.register.d
                @Override // java.lang.Runnable
                public final void run() {
                    AutoLoginHelper.l(AutoLoginHelper.this, str3, str4, num3, num4, bArr2);
                }
            }, 128, null, false, 2000L);
            return;
        }
        QLog.e("AutoLoginHelper", 1, "downloadAndUploadZPlanAvatar normalUrl:" + str + ", avatarUrl:" + str2 + ", bgId:" + num + ", " + num2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(final AutoLoginHelper this$0, String str, String str2, Integer num, Integer num2, final byte[] bArr) {
        Boolean bool;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.m(str)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AvatarResourceManager avatarResourceManager = AvatarResourceManager.f352954a;
            Context applicationContext = peekAppRuntime.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
            File h16 = avatarResourceManager.h(str2, applicationContext);
            Object obj = null;
            if (h16 != null && h16.exists() && h16.length() > 0) {
                String path = h16.getPath();
                if (path == null) {
                    QLog.e("AutoLoginHelper", 1, "downloadAndUploadZPlanAvatar outBoundPath is null");
                    return;
                }
                IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IZPlanAvatarUploadService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ant.ALL\n                )");
                IZPlanAvatarUploadService iZPlanAvatarUploadService = (IZPlanAvatarUploadService) runtimeService;
                String path2 = f280310r.getPath();
                int intValue = num.intValue();
                ZPlanAvatarInfo zPlanAvatarInfo = this$0.selectedAvatarInfo;
                if (zPlanAvatarInfo != null) {
                    str3 = zPlanAvatarInfo.c();
                } else {
                    str3 = null;
                }
                int intValue2 = num2.intValue();
                ZPlanAvatarInfo zPlanAvatarInfo2 = this$0.selectedAvatarInfo;
                if (zPlanAvatarInfo2 != null) {
                    obj = zPlanAvatarInfo2.j();
                }
                iZPlanAvatarUploadService.requestUploadAvatar(path2, path, intValue, str3, intValue2, obj, new Function1<Boolean, Unit>(bArr) { // from class: com.tencent.mobileqq.register.AutoLoginHelper$downloadAndUploadZPlanAvatar$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ byte[] $callbackInfo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$callbackInfo = bArr;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoLoginHelper.this, (Object) bArr);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                        invoke(bool2.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, z16);
                            return;
                        }
                        QLog.i("AutoLoginHelper", 2, "downloadAndUploadZPlanAvatar finish");
                        com.tencent.mobileqq.register.avatar.d.f280340a.d(null, null, AutoLoginHelper.this.mUin);
                        if (this.$callbackInfo == null) {
                            QLog.e("AutoLoginHelper", 1, "downloadAndUploadZPlanAvatar callbackInfo is null");
                            return;
                        }
                        if (!z16) {
                            QLog.e("AutoLoginHelper", 1, "downloadAndUploadZPlanAvatar failed");
                            AvatarInfoCheck.b(1, AutoLoginHelper.this.mUin);
                            return;
                        }
                        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime2).getBusinessHandler(RegisterZPlanAvatarHandler.class.getName());
                        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.RegisterZPlanAvatarHandler");
                        ((RegisterZPlanAvatarHandler) businessHandler).E2(this.$callbackInfo);
                    }
                });
                return;
            }
            if (h16 != null) {
                bool = Boolean.valueOf(h16.exists());
            } else {
                bool = null;
            }
            if (h16 != null) {
                obj = Long.valueOf(h16.length());
            }
            QLog.e("AutoLoginHelper", 1, "downloadAndUploadZPlanAvatar file error: " + bool + ", " + obj);
        }
    }

    private final boolean m(String headUrl) {
        QLog.i("AutoLoginHelper", 1, "start downloadHead path: " + f280310r.getAbsolutePath());
        if (TextUtils.isEmpty(headUrl)) {
            QLog.e("AutoLoginHelper", 1, "start downloadHead url is null");
            return false;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                File file = f280310r;
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e16) {
                QLog.d("AutoLoginHelper", 1, "downloadHead delete e = " + e16);
            }
            QLog.i("AutoLoginHelper", 1, "downloadHead url" + headUrl + " failTryCount: " + i3);
            Intrinsics.checkNotNull(headUrl);
            if (r(headUrl)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r9, "/", 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String n(String headUrl) {
        int lastIndexOf$default;
        try {
            if (TextUtils.isEmpty(headUrl) || lastIndexOf$default == -1) {
                return "";
            }
            String substring = headUrl.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (TextUtils.isEmpty(substring)) {
                return "";
            }
            return substring + "/0";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        RegisterNewBaseFragment registerNewBaseFragment = this.mFragment;
        Intrinsics.checkNotNull(registerNewBaseFragment);
        registerNewBaseFragment.H.post(new Runnable() { // from class: com.tencent.mobileqq.register.a
            @Override // java.lang.Runnable
            public final void run() {
                AutoLoginHelper.q(AutoLoginHelper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AutoLoginHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Dialog dialog = this$0.mLoadingDialog;
            if (dialog != null) {
                Intrinsics.checkNotNull(dialog);
                if (dialog.isShowing()) {
                    Dialog dialog2 = this$0.mLoadingDialog;
                    Intrinsics.checkNotNull(dialog2);
                    dialog2.dismiss();
                    Dialog dialog3 = this$0.mLoadingDialog;
                    Intrinsics.checkNotNull(dialog3);
                    dialog3.cancel();
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this$0.mLoadingDialog = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean r(String headUrl) {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            URL url = new URL(headUrl);
            url.openConnection().connect();
            bufferedInputStream = new BufferedInputStream(url.openStream(), 8192);
            try {
                File file = f280310r;
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (Exception e17) {
            e = e17;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                bufferedInputStream.close();
            } catch (Exception e18) {
                QLog.d("AutoLoginHelper", 1, "httpDownloadWxHead close input output e = " + e18);
            }
            try {
                fileOutputStream.close();
            } catch (Exception e19) {
                QLog.d("AutoLoginHelper", 1, "httpDownloadWxHead close input output e = " + e19);
            }
            return true;
        } catch (Exception e26) {
            e = e26;
            bufferedInputStream2 = bufferedInputStream;
            try {
                QLog.d("AutoLoginHelper", 1, "httpDownloadWxHead download head e = " + e);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e27) {
                        QLog.d("AutoLoginHelper", 1, "httpDownloadWxHead close input output e = " + e27);
                    }
                }
                if (fileOutputStream == null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Exception e28) {
                    QLog.d("AutoLoginHelper", 1, "httpDownloadWxHead close input output e = " + e28);
                    return false;
                }
            } catch (Throwable th7) {
                th = th7;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e29) {
                        QLog.d("AutoLoginHelper", 1, "httpDownloadWxHead close input output e = " + e29);
                    }
                }
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (Exception e36) {
                        QLog.d("AutoLoginHelper", 1, "httpDownloadWxHead close input output e = " + e36);
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
            }
            if (fileOutputStream == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AutoLoginHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AutoLoginHelper", 1, "set other avatar");
        QRouteApi api = QRoute.api(IZPlanApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
        String str = this$0.mAvatarLocalPath;
        Intrinsics.checkNotNull(str);
        ((IZPlanApi) api).setAvatarFromPeak(str, AutoLoginHelper$onAccountChanged$1$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AutoLoginHelper this$0, String avatarUrl) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(avatarUrl, "$avatarUrl");
        this$0.C(avatarUrl);
    }

    public final void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isLogining = z16;
        }
    }

    @Nullable
    public final Intent o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mIntent;
    }

    public final void s() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AutoLoginHelper", 2, "onAccountChanged success");
        }
        if (!TextUtils.isEmpty(this.mAvatarLocalPath)) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.register.b
                @Override // java.lang.Runnable
                public final void run() {
                    AutoLoginHelper.t(AutoLoginHelper.this);
                }
            }, 16, null, false, 2000L);
        } else {
            WechatInfo wechatInfo = this.mWechatInfo;
            final String str2 = null;
            if (wechatInfo != null) {
                str = wechatInfo.b();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.d("AutoLoginHelper", 1, "set wechat avatar");
                WechatInfo wechatInfo2 = this.mWechatInfo;
                if (wechatInfo2 != null) {
                    str2 = wechatInfo2.b();
                }
                Intrinsics.checkNotNull(str2);
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.register.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutoLoginHelper.u(AutoLoginHelper.this, str2);
                    }
                }, 128, null, false, 2000L);
            } else if (this.selectedAvatarInfo != null) {
                k();
            } else {
                QLog.i("AutoLoginHelper", 1, "mAvatarUrl is empty");
            }
        }
        QuestionnaireForLoginManager.b();
        F();
    }

    public final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        boolean z16 = false;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            RegisterNewBaseFragment registerNewBaseFragment = this.mFragment;
            if (registerNewBaseFragment != null) {
                registerNewBaseFragment.yh(R.string.b3j, 0);
                return;
            }
            return;
        }
        this.isLogining = true;
        this.isStartingMain = false;
        D();
        if (QLog.isColorLevel()) {
            if (this.mSign != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AutoLoginHelper", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.mSign));
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("AutoLoginHelper", 2, "swz mSign = null");
            }
        }
        com.tencent.mobileqq.phonelogin.a.a().e(true);
        c.a C = new c.a(1, 5, this.mUin, this.mPassword).B(this.mPassByte).C(this.mSuperSig);
        if (this.mWechatInfo != null) {
            z16 = true;
        }
        al.b(1).login(null, C.w(z16).r(), new c(), this.mAccountLoginCallback);
    }

    public final void w() {
        FragmentActivity fragmentActivity;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        RegisterNewBaseFragment registerNewBaseFragment = this.mFragment;
        String str4 = null;
        if (registerNewBaseFragment != null) {
            fragmentActivity = registerNewBaseFragment.getActivity();
        } else {
            fragmentActivity = null;
        }
        if (!(fragmentActivity instanceof QBaseActivity)) {
            return;
        }
        Intent o16 = o();
        if (o16 != null) {
            str = o16.getStringExtra(AppConstants.Key.PHONENUM);
        } else {
            str = null;
        }
        this.phoneNum = str;
        Intent o17 = o();
        if (o17 != null) {
            str2 = o17.getStringExtra("key");
        } else {
            str2 = null;
        }
        this.countryCode = str2;
        Intent o18 = o();
        if (o18 != null) {
            str3 = o18.getStringExtra("uin");
        } else {
            str3 = null;
        }
        this.mUin = str3;
        Intent o19 = o();
        if (o19 != null) {
            bArr = o19.getByteArrayExtra(AppConstants.Key.KEY_REGISTER_SIGN);
        } else {
            bArr = null;
        }
        this.mSign = bArr;
        Intent o26 = o();
        if (o26 != null) {
            bArr2 = o26.getByteArrayExtra(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG);
        } else {
            bArr2 = null;
        }
        this.mSuperSig = bArr2;
        Intent o27 = o();
        if (o27 != null) {
            str4 = o27.getStringExtra(AppConstants.Key.KEY_REGISTER_PASSWORD);
        }
        this.mPassword = str4;
        if (str4 != null) {
            this.mPassByte = MD5.toMD5Byte(str4);
        }
        this.isStartingMain = false;
        A();
        j();
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AutoLoginHelper", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        RegisterNewBaseFragment registerNewBaseFragment = this.mFragment;
        if (registerNewBaseFragment != null) {
            registerNewBaseFragment.rh();
        }
        p();
    }

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AutoLoginHelper", 2, "onResume\uff0c isStartingMain=" + this.isStartingMain);
        }
        if (!this.isStartingMain) {
            p();
        }
    }
}
