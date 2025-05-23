package com.tencent.mobileqq.loginregister.sms.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0001mB\u0007\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0010H\u0014J \u0010\u0015\u001a\u00020\u00022\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\fJ\b\u0010\u0016\u001a\u00020\u0002H\u0014J\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0004R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\"\u00103\u001a\u00020,8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00107\u001a\u00020,8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\"\u0004\b6\u00102R$\u0010?\u001a\u0004\u0018\u0001088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010G\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010N\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010R\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\"\u0010Y\u001a\u00020S8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010A\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010]\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010I\u001a\u0004\b[\u0010K\"\u0004\b\\\u0010MR\"\u0010d\u001a\u00020^8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010H\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010j\u001a\u00020e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "rh", "Ljava/lang/Class;", "clazz", "ph", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "needImmersive", "Fh", "", "Ah", OcrConfig.CHINESE, "fragmentClass", "addToBackStack", "Hh", "finishActivity", "qh", "Gh", "Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment$a;", "Dh", "()Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment$a;", "Rh", "(Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment$a;)V", "smsVerifyViewModel", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "Qh", "(Landroid/view/View;)V", "root", "E", "sh", "Jh", "backBtn", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "Eh", "()Landroid/widget/TextView;", "Sh", "(Landroid/widget/TextView;)V", "titleHint", "G", "Bh", "Oh", "otherVerificationBtn", "Lcom/tencent/mobileqq/app/QBaseActivity;", "H", "Lcom/tencent/mobileqq/app/QBaseActivity;", "xh", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "setMContext", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "mContext", "Lmqq/app/AppRuntime;", "I", "Lmqq/app/AppRuntime;", "wh", "()Lmqq/app/AppRuntime;", "setMAppRuntime", "(Lmqq/app/AppRuntime;)V", "mAppRuntime", "J", "Ljava/lang/String;", "Ch", "()Ljava/lang/String;", "Ph", "(Ljava/lang/String;)V", "phoneNum", "K", "uh", "Lh", "countryCode", "", "L", "yh", "()I", "Nh", "(I)V", "mSmsFunctionCode", "M", "getMEntrance", "Mh", "mEntrance", "", "N", "th", "()J", "Kh", "(J)V", "clickOtherVerifyBtnLastTime", "Lmqq/os/MqqHandler;", "P", "Lmqq/os/MqqHandler;", "vh", "()Lmqq/os/MqqHandler;", "handler", "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class SmsVerifyBaseFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a smsVerifyViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    protected View root;

    /* renamed from: E, reason: from kotlin metadata */
    protected View backBtn;

    /* renamed from: F, reason: from kotlin metadata */
    protected TextView titleHint;

    /* renamed from: G, reason: from kotlin metadata */
    protected TextView otherVerificationBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QBaseActivity mContext;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private AppRuntime mAppRuntime;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String phoneNum;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private String countryCode;

    /* renamed from: L, reason: from kotlin metadata */
    private int mSmsFunctionCode;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private String mEntrance;

    /* renamed from: N, reason: from kotlin metadata */
    private long clickOtherVerifyBtnLastTime;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MqqHandler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment$a;", "Landroidx/lifecycle/ViewModel;", "", "i", "Z", "L1", "()Z", "N1", "(Z)V", "hasClickSendBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "O1", "hasShowBackDialog", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends ViewModel {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean hasClickSendBtn;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean hasShowBackDialog;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean L1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.hasClickSendBtn;
        }

        public final boolean M1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.hasShowBackDialog;
        }

        public final void N1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.hasClickSendBtn = z16;
            }
        }

        public final void O1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.hasShowBackDialog = z16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment$b", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends MqqHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SmsVerifyBaseFragment.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@Nullable Message msg2) {
            QBaseActivity xh5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            if (msg2 != null) {
                SmsVerifyBaseFragment smsVerifyBaseFragment = SmsVerifyBaseFragment.this;
                if (msg2.what == 2004 && (xh5 = smsVerifyBaseFragment.xh()) != null) {
                    xh5.finish();
                }
            }
        }
    }

    public SmsVerifyBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.phoneNum = "";
        this.countryCode = "86";
        this.handler = new b();
    }

    public static /* synthetic */ void Ih(SmsVerifyBaseFragment smsVerifyBaseFragment, Class cls, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            smsVerifyBaseFragment.Hh(cls, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceFragmentWithAnim");
    }

    private final QPublicBaseFragment ph(Class<? extends QPublicBaseFragment> clazz) {
        Bundle bundle;
        Intent intent;
        QLog.d(QPublicBaseFragment.TAG, 2, "creating fragment ", clazz);
        try {
            QPublicBaseFragment newInstance = clazz.newInstance();
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            newInstance.setArguments(bundle);
            return newInstance;
        } catch (Exception e16) {
            QLog.e(QPublicBaseFragment.TAG, 1, "create fragment error", e16);
            return null;
        }
    }

    private final void rh() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (getRoot() != null) {
                ImmersiveUtils.setFitsSystemWindows(getRoot(), true);
            }
            Window window = null;
            if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
                QBaseActivity qBaseActivity = this.mContext;
                if (qBaseActivity != null) {
                    window = qBaseActivity.getWindow();
                }
                ImmersiveUtils.setStatusTextColor(true, window);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public String Ah() {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        String zh5 = zh();
        String str = this.countryCode;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) Marker.ANY_NON_NULL_MARKER, false, 2, (Object) null);
            if (contains$default) {
                return " " + this.countryCode + " " + zh5 + " ";
            }
        }
        return " +" + this.countryCode + " " + zh5 + " ";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView Bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TextView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        TextView textView = this.otherVerificationBtn;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("otherVerificationBtn");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String Ch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.phoneNum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final a Dh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.smsVerifyViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        TextView textView = this.titleHint;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleHint");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.mContext = qBaseActivity;
        if (qBaseActivity == null) {
            return false;
        }
        Intrinsics.checkNotNull(qBaseActivity);
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        this.mAppRuntime = appRuntime;
        if (appRuntime == null) {
            QBaseActivity qBaseActivity2 = this.mContext;
            Intrinsics.checkNotNull(qBaseActivity2);
            qBaseActivity2.finish();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Gh() {
        ISmsVerifyCodeService iSmsVerifyCodeService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iSmsVerifyCodeService = (ISmsVerifyCodeService) peekAppRuntime.getRuntimeService(ISmsVerifyCodeService.class, "all");
        } else {
            iSmsVerifyCodeService = null;
        }
        if (iSmsVerifyCodeService != null) {
            iSmsVerifyCodeService.handleSmsVerifyCodeCancel(getQBaseActivity(), new Bundle());
        }
    }

    public final void Hh(@NotNull Class<? extends QPublicBaseFragment> fragmentClass, boolean addToBackStack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, fragmentClass, Boolean.valueOf(addToBackStack));
            return;
        }
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            QPublicBaseFragment ph5 = ph(fragmentClass);
            if (ph5 == null) {
                QLog.e(QPublicBaseFragment.TAG, 1, "replaceFragmentWithAnim create fragment return null");
                return;
            }
            FragmentTransaction replace = activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.f154936u1, R.anim.f154935u0, R.anim.f154934tz, R.anim.f154937u2).replace(R.id.ckj, ph5);
            Intrinsics.checkNotNullExpressionValue(replace, "it.supportFragmentManage\u2026ag_container, fragment!!)");
            if (addToBackStack) {
                replace.addToBackStack(null);
            }
            replace.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jh(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.backBtn = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Kh(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, j3);
        } else {
            this.clickOtherVerifyBtnLastTime = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Lh(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.countryCode = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Mh(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.mEntrance = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Nh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.mSmsFunctionCode = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Oh(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.otherVerificationBtn = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ph(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.phoneNum = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Qh(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.root = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Rh(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.smsVerifyViewModel = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Sh(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.titleHint = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finishActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.mContext;
        if (qBaseActivity != null) {
            Object systemService = qBaseActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(qBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
            }
            qBaseActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        View view = this.root;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        Object firstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        QBaseActivity qBaseActivity = this.mContext;
        if (qBaseActivity != null && (supportFragmentManager = qBaseActivity.getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) fragments);
            fragment = (Fragment) firstOrNull;
        } else {
            fragment = null;
        }
        if (fragment instanceof SmsVerifyBaseFragment) {
            return ((SmsVerifyBaseFragment) fragment).qh();
        }
        if (fragment instanceof QPublicBaseFragment) {
            return ((QPublicBaseFragment) fragment).onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        rh();
    }

    protected boolean qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        View view = this.backBtn;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return this.clickOtherVerifyBtnLastTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.countryCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MqqHandler vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final AppRuntime wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final QBaseActivity xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int yh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mSmsFunctionCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        String str = this.phoneNum;
        if (str != null) {
            if (str.length() > 5) {
                String substring = str.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring2 = str.substring(str.length() - 2);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                return substring + "******" + substring2;
            }
            return str;
        }
        return "";
    }
}
