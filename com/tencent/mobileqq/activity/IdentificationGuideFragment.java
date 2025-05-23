package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper;
import com.tencent.mobileqq.identification.ae;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IdentificationGuideFragment extends ReportAndroidXFragment implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private FragmentActivity C;
    private QQPermission D;
    public MqqHandler E;
    AtomicBoolean F;
    private int G;
    private FaceConf H;
    private String I;
    private boolean J;
    private ViewGroup K;
    private TextView L;
    private View M;
    private Dialog N;
    public QUIButton P;
    public CheckBox Q;
    private final StringBuilder R;
    private boolean S;
    private final BroadcastReceiver T;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.IdentificationGuideFragment$8 */
    /* loaded from: classes9.dex */
    public class AnonymousClass8 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ int f176251d;

        AnonymousClass8(int i3) {
            this.f176251d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this, i3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (IdentificationGuideFragment.this.getActivity() != null && !IdentificationGuideFragment.this.getActivity().isFinishing()) {
                IdentificationGuideFragment.this.Ph();
                com.tencent.mobileqq.identification.z.g(IdentificationGuideFragment.this.C, "failed", new Bundle());
                IdentificationGuideFragment.this.Sh(new Bundle(), this.f176251d);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.IdentificationGuideFragment$9 */
    /* loaded from: classes9.dex */
    public class AnonymousClass9 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ int f176252d;

        /* renamed from: e */
        final /* synthetic */ Bundle f176253e;

        /* renamed from: f */
        final /* synthetic */ boolean f176254f;

        /* renamed from: h */
        final /* synthetic */ int f176255h;

        /* renamed from: i */
        final /* synthetic */ int f176256i;

        AnonymousClass9(int i3, Bundle bundle, boolean z16, int i16, int i17) {
            this.f176252d = i3;
            this.f176253e = bundle;
            this.f176254f = z16;
            this.f176255h = i16;
            this.f176256i = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, IdentificationGuideFragment.this, Integer.valueOf(i3), bundle, Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (IdentificationGuideFragment.this.C != null && !IdentificationGuideFragment.this.C.isFinishing()) {
                IdentificationGuideFragment.this.Ph();
                boolean z16 = false;
                if (this.f176252d != 1) {
                    IdentificationGuideFragment.this.S = false;
                    Intent intent = new Intent();
                    intent.putExtra("data", this.f176253e);
                    IdentificationGuideFragment.this.setResult(-1, IdentificationGuideFragment.this.ii(intent));
                } else {
                    IdentificationGuideFragment identificationGuideFragment = IdentificationGuideFragment.this;
                    if (this.f176253e.getInt("ret") == 0) {
                        z16 = true;
                    }
                    identificationGuideFragment.S = z16;
                    Intent intent2 = new Intent();
                    intent2.putExtra("data", this.f176253e);
                    Intent ii5 = IdentificationGuideFragment.this.ii(intent2);
                    if (IdentificationGuideFragment.this.S) {
                        ii5.putExtra("key_face_scan_result", true);
                    }
                    IdentificationGuideFragment.this.setResult(-1, ii5);
                }
                if (IdentificationGuideFragment.this.S) {
                    com.tencent.mobileqq.identification.z.g(IdentificationGuideFragment.this.C, "success", this.f176253e);
                    ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", this.f176254f ? 1 : 0, 0, "", "", "", "");
                    if ("loginVerify".equals(IdentificationGuideFragment.this.I)) {
                        QLog.d("IdentificationGuideFragment", 1, "sendBroadcast autoLogin");
                        Intent intent3 = new Intent();
                        intent3.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.autoLogin");
                        intent3.putExtra("key_login_verify_by_face", true);
                        intent3.setPackage(BaseApplication.getContext().getPackageName());
                        IdentificationGuideFragment.this.C.sendBroadcast(intent3);
                    }
                    IdentificationGuideFragment.this.C.finish();
                    return;
                }
                com.tencent.mobileqq.identification.z.g(IdentificationGuideFragment.this.C, "failed", this.f176253e);
                ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", this.f176254f ? 1 : 0, 2, String.valueOf(this.f176255h), "", "", "");
                IdentificationGuideFragment.this.Sh(this.f176253e, this.f176256i);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IdentificationGuideFragment.this.Rh(true);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements IdentificationHuiyanSDKInitHelper.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ boolean f176258a;

        b(boolean z16) {
            this.f176258a = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, IdentificationGuideFragment.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.f
        public void a(AppConf appConf) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appConf);
                return;
            }
            QLog.d("IdentificationGuideFragment", 1, "getAppConfAndHuiyanSdkToken onSuccess");
            IdentificationGuideFragment.this.F.set(false);
            if (IdentificationGuideFragment.this.getContext() == null) {
                QLog.e("IdentificationGuideFragment", 1, "callServer getContext == null");
                return;
            }
            IdentificationGuideFragment.this.E.removeMessages(1);
            IdentificationGuideFragment.this.E.sendEmptyMessage(2);
            IdentificationGuideFragment.this.H.setAppConf(appConf);
            IdentificationGuideFragment.this.Zh(appConf);
            if (this.f176258a) {
                if (appConf != null && !TextUtils.isEmpty(appConf.huiyanSdkToken)) {
                    IdentificationGuideFragment.this.fi();
                } else {
                    QLog.e("IdentificationGuideFragment", 1, "getAppConfAndHuiyanSdkToken success appConf is null or huiyanSdkToken is null");
                    IdentificationGuideFragment.this.mi(HardCodeUtil.qqStr(R.string.f159591sq));
                }
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.f
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d("IdentificationGuideFragment", 1, "getAppConfAndHuiyanSdkToken onFailed");
            ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", 0, 1, String.valueOf(i3), "", "", "");
            IdentificationGuideFragment.this.F.set(false);
            IdentificationGuideFragment.this.E.removeMessages(1);
            IdentificationGuideFragment.this.E.sendEmptyMessage(2);
            if (this.f176258a) {
                IdentificationGuideFragment.this.mi(HardCodeUtil.qqStr(R.string.f159591sq));
            }
            if (IdentificationGuideFragment.this.J) {
                com.tencent.mobileqq.identification.z.g(IdentificationGuideFragment.this.C, "failed", new Bundle());
                IdentificationGuideFragment.this.setResult(-1, new Intent());
                IdentificationGuideFragment.this.C.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements IdentificationHuiyanSDKInitHelper.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.h
        public void onFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.e("IdentificationGuideFragment", 1, "prepare huiyan sdk fail");
                IdentificationGuideFragment.this.mi(HardCodeUtil.qqStr(R.string.f159601sr));
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.h
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("IdentificationGuideFragment", 1, "prepare huiyan sdk success");
                IdentificationGuideFragment.this.li();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements IdentificationHuiyanSDKInitHelper.g {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.g
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e("IdentificationGuideFragment", 1, "startHuiyanSdk onFailed huiyanSdkErrorCode=" + i3 + " msg=" + str);
            IdentificationGuideFragment.this.pi(i3, false);
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.g
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("IdentificationGuideFragment", 1, "startHuiyanSdk onSuccess");
                IdentificationGuideFragment.this.pi(0, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IdentificationGuideFragment.this.ni();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (NewIntent.ACTION_ACCOUNT_KICKED.equals(intent.getAction())) {
                QLog.d("IdentificationGuideFragment", 1, "received account kicked broadcast");
                IdentificationGuideFragment.this.C.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ String f176264d;

        g(String str) {
            this.f176264d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent intent = new Intent();
                intent.putExtra("title", IdentificationGuideFragment.this.getString(R.string.f159701t1));
                intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, IdentificationGuideFragment.this.getString(R.string.button_back));
                intent.putExtra("url", this.f176264d);
                IdentificationGuideFragment.this.startActivity(intent);
                RouteUtils.startActivity(IdentificationGuideFragment.this.getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
                ReportController.o(null, "dc00898", "", "", "0X800BDB2", "0X800BDB2", com.tencent.mobileqq.util.bm.a(IdentificationGuideFragment.this.I), 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public IdentificationGuideFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = new MqqHandler(Looper.getMainLooper(), this);
        this.F = new AtomicBoolean(false);
        this.R = new StringBuilder();
        this.T = new f();
    }

    private boolean Nh() {
        Uh();
        QQPermission qQPermission = this.D;
        if (qQPermission == null) {
            QLog.e("IdentificationGuideFragment", 1, "checkHasPermission mQQPermission == null");
            return false;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            return false;
        }
        return true;
    }

    private void Oh(int i3, String str) {
        String account;
        QLog.d("IdentificationGuideFragment", 1, "collectErrorCode error code=", Integer.valueOf(i3));
        HashMap<String, String> hashMap = new HashMap<>(4);
        hashMap.put("errorCode", String.valueOf(i3));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("errorMsg", str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            account = "";
        } else {
            account = peekAppRuntime.getAccount();
        }
        String str2 = account;
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("uin", str2);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, "tagIdentificationErrorCode", this.S, 0L, 0L, hashMap, "");
    }

    public void Ph() {
        Dialog dialog = this.N;
        if (dialog != null) {
            try {
                dialog.cancel();
            } catch (Exception e16) {
                QLog.e("IdentificationGuideFragment", 1, e16, new Object[0]);
            }
            this.N = null;
        }
    }

    private void Qh() {
        try {
            Vibrator vibrator = (Vibrator) getActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(50L);
            }
        } catch (Exception e16) {
            QLog.e("IdentificationGuideFragment", 1, "exception when doVibrate.", e16);
        }
    }

    public void Rh(boolean z16) {
        QLog.d("IdentificationGuideFragment", 1, "start getAppConfAndHuiyanSdkToken autoStartIdentification=" + z16);
        if (z16) {
            this.E.sendEmptyMessageDelayed(1, 500L);
        }
        if (this.F.getAndSet(true)) {
            QLog.d("IdentificationGuideFragment", 1, "start getAppConfAndHuiyanSdkToken has already sent");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800C427", "0X800C427", 0, 0, "", "", "", "");
            IdentificationHuiyanSDKInitHelper.m(this.H, new b(z16));
        }
    }

    public void Sh(Bundle bundle, int i3) {
        QLog.d("IdentificationGuideFragment", 2, "gotoResultFragment");
        Intent intent = new Intent(this.C, (Class<?>) IdentificationFragmentActivity.class);
        intent.putExtra("faceConf", this.H);
        intent.putExtra("data", bundle);
        intent.putExtra("key_huiyan_sdk_error_code", i3);
        intent.putExtra("key_page_code", 103);
        startActivityForResult(intent, 103);
    }

    private void Th(View view) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.jo9);
        qUISecNavBar.S(this);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.mobileqq.activity.dl
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit Vh;
                Vh = IdentificationGuideFragment.this.Vh((View) obj, (BaseAction) obj2);
                return Vh;
            }
        });
    }

    private void Uh() {
        if (this.D == null) {
            this.D = QQPermissionFactory.getQQPermission(this.C, new BusinessConfig(QQPermissionConstants.Business.ID.FACE_IDENTIFICATION, QQPermissionConstants.Business.SCENE.FACE_IDENTIFICATION_GUIDE));
        }
    }

    public /* synthetic */ Unit Vh(View view, BaseAction baseAction) {
        if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
            di();
            FragmentActivity fragmentActivity = this.C;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
                return null;
            }
            return null;
        }
        return null;
    }

    public /* synthetic */ void Wh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            this.P.o();
            gi("0X800A858", "0X800A859");
        } else {
            this.P.setBackgroundDisabled();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public static /* synthetic */ void Xh() {
        QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", new Bundle());
    }

    public /* synthetic */ void Yh(String str) {
        QQToast.makeText(this.C, str, 1).show();
    }

    public /* synthetic */ void ai(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        CheckBox checkBox = this.Q;
        if (checkBox != null) {
            checkBox.setChecked(!checkBox.isChecked());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public /* synthetic */ void bi(boolean z16, int i3, int i16, Bundle bundle) {
        int i17 = bundle.getInt("ret", -1);
        String string = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.f159511si));
        String string2 = bundle.getString("idKey", "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("verifyResultThroughBDH onRequestFinish code=");
        sb5.append(i16);
        sb5.append(" ret=");
        sb5.append(i17);
        sb5.append(" errMsg=");
        sb5.append(string);
        sb5.append(" idKey=");
        sb5.append(!TextUtils.isEmpty(string2));
        QLog.e("IdentificationGuideFragment", 1, sb5.toString());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(i16, bundle, z16, i17, i3) { // from class: com.tencent.mobileqq.activity.IdentificationGuideFragment.9
            static IPatchRedirector $redirector_;

            /* renamed from: d */
            final /* synthetic */ int f176252d;

            /* renamed from: e */
            final /* synthetic */ Bundle f176253e;

            /* renamed from: f */
            final /* synthetic */ boolean f176254f;

            /* renamed from: h */
            final /* synthetic */ int f176255h;

            /* renamed from: i */
            final /* synthetic */ int f176256i;

            AnonymousClass9(int i162, Bundle bundle2, boolean z162, int i172, int i36) {
                this.f176252d = i162;
                this.f176253e = bundle2;
                this.f176254f = z162;
                this.f176255h = i172;
                this.f176256i = i36;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, IdentificationGuideFragment.this, Integer.valueOf(i162), bundle2, Boolean.valueOf(z162), Integer.valueOf(i172), Integer.valueOf(i36));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (IdentificationGuideFragment.this.C != null && !IdentificationGuideFragment.this.C.isFinishing()) {
                    IdentificationGuideFragment.this.Ph();
                    boolean z162 = false;
                    if (this.f176252d != 1) {
                        IdentificationGuideFragment.this.S = false;
                        Intent intent = new Intent();
                        intent.putExtra("data", this.f176253e);
                        IdentificationGuideFragment.this.setResult(-1, IdentificationGuideFragment.this.ii(intent));
                    } else {
                        IdentificationGuideFragment identificationGuideFragment = IdentificationGuideFragment.this;
                        if (this.f176253e.getInt("ret") == 0) {
                            z162 = true;
                        }
                        identificationGuideFragment.S = z162;
                        Intent intent2 = new Intent();
                        intent2.putExtra("data", this.f176253e);
                        Intent ii5 = IdentificationGuideFragment.this.ii(intent2);
                        if (IdentificationGuideFragment.this.S) {
                            ii5.putExtra("key_face_scan_result", true);
                        }
                        IdentificationGuideFragment.this.setResult(-1, ii5);
                    }
                    if (IdentificationGuideFragment.this.S) {
                        com.tencent.mobileqq.identification.z.g(IdentificationGuideFragment.this.C, "success", this.f176253e);
                        ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", this.f176254f ? 1 : 0, 0, "", "", "", "");
                        if ("loginVerify".equals(IdentificationGuideFragment.this.I)) {
                            QLog.d("IdentificationGuideFragment", 1, "sendBroadcast autoLogin");
                            Intent intent3 = new Intent();
                            intent3.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.autoLogin");
                            intent3.putExtra("key_login_verify_by_face", true);
                            intent3.setPackage(BaseApplication.getContext().getPackageName());
                            IdentificationGuideFragment.this.C.sendBroadcast(intent3);
                        }
                        IdentificationGuideFragment.this.C.finish();
                        return;
                    }
                    com.tencent.mobileqq.identification.z.g(IdentificationGuideFragment.this.C, "failed", this.f176253e);
                    ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", this.f176254f ? 1 : 0, 2, String.valueOf(this.f176255h), "", "", "");
                    IdentificationGuideFragment.this.Sh(this.f176253e, this.f176256i);
                }
            }
        }, 200L);
    }

    private void ci() {
        if (Nh()) {
            Rh(true);
            return;
        }
        QQPermission qQPermission = this.D;
        if (qQPermission == null) {
            QLog.e("IdentificationGuideFragment", 1, "requestPermission mQQPermission == null");
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
        }
    }

    private void ei() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.dh
            @Override // java.lang.Runnable
            public final void run() {
                IdentificationGuideFragment.Xh();
            }
        }, 16, null, true);
    }

    public void fi() {
        IdentificationHuiyanSDKInitHelper.B(new c());
    }

    private void gi(String str, String str2) {
        if ("setFaceData".equals(this.I)) {
            ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        } else if ("loginVerify".equals(this.I)) {
            ReportController.r(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    private void hi() {
        Uh();
        QQPermission qQPermission = this.D;
        if (qQPermission == null) {
            QLog.e("IdentificationGuideFragment", 1, "requestPermission mQQPermission == null");
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new e());
        }
    }

    public Intent ii(Intent intent) {
        String sb5 = this.R.toString();
        if (intent != null && intent.hasExtra("data")) {
            Bundle bundleExtra = intent.getBundleExtra("data");
            Oh(bundleExtra.getInt("ret", 299), bundleExtra.getString("errMsg"));
        }
        if (TextUtils.isEmpty(sb5)) {
            return intent;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("allResults", sb5);
        return intent;
    }

    public void ji() {
        ViewGroup viewGroup;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(new dg(this));
            return;
        }
        FragmentActivity fragmentActivity = this.C;
        if (fragmentActivity != null && !fragmentActivity.isFinishing() && (viewGroup = this.K) != null) {
            QLog.d("IdentificationGuideFragment", 1, "setGuidePageTransparent");
            viewGroup.setVisibility(8);
        }
    }

    private void ki(int i3) {
        try {
            if (this.N == null) {
                this.N = DialogUtil.createWaitingDialog(getActivity(), i3);
            }
            this.N.show();
        } catch (Exception e16) {
            QLog.e("IdentificationGuideFragment", 1, e16, new Object[0]);
        }
    }

    public void li() {
        if (!NetworkUtil.isNetSupport(this.C)) {
            mi(HardCodeUtil.qqStr(R.string.f159571so));
            QLog.e("IdentificationGuideFragment", 1, "startHuiYanSdk network not support");
            return;
        }
        if (com.tencent.mobileqq.util.bm.b(this.C)) {
            mi(HardCodeUtil.qqStr(R.string.f159561sn));
            QLog.e("IdentificationGuideFragment", 1, "current mode is in multi window");
            return;
        }
        if (com.tencent.mobileqq.util.bm.c()) {
            mi(HardCodeUtil.qqStr(R.string.f159631su));
            QLog.e("IdentificationGuideFragment", 1, "current mode is video chatting");
            return;
        }
        String uin = this.H.getUin();
        com.tencent.mobileqq.util.ap apVar = com.tencent.mobileqq.util.ap.f306581a;
        if (apVar.k(uin)) {
            mi(HardCodeUtil.qqStr(R.string.f159501sh));
            return;
        }
        apVar.h(uin);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new dg(this), 1000L);
        IdentificationHuiyanSDKInitHelper.D(this.H, new d());
    }

    public void mi(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.dm
            @Override // java.lang.Runnable
            public final void run() {
                IdentificationGuideFragment.this.Yh(str);
            }
        });
    }

    public void ni() {
        QLog.d("IdentificationGuideFragment", 1, "tryToStartHuiYanSdk, mMethod=", this.I);
        AppConf appConf = this.H.getAppConf();
        if (appConf != null && !TextUtils.isEmpty(appConf.huiyanSdkToken)) {
            fi();
        } else if (!NetworkUtil.isNetSupport(getActivity())) {
            QLog.e("IdentificationGuideFragment", 1, "tryToStartHuiYanSdk isNetSupport=false");
            mi(HardCodeUtil.qqStr(R.string.f159571so));
        } else {
            Rh(true);
        }
    }

    /* renamed from: oi */
    public void Zh(final AppConf appConf) {
        String str;
        String str2;
        String sb5;
        if (getContext() == null) {
            QLog.e("IdentificationGuideFragment", 1, "getContext() == null");
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.di
                @Override // java.lang.Runnable
                public final void run() {
                    IdentificationGuideFragment.this.Zh(appConf);
                }
            });
            return;
        }
        String string = getString(R.string.f159691t0);
        String string2 = getString(R.string.f159671sy);
        String string3 = getString(R.string.f159681sz);
        if (appConf != null && !appConf.serviceProtocols.isEmpty()) {
            AppConf.ServiceProtocolSerializable serviceProtocolSerializable = appConf.serviceProtocols.get(0);
            if (!TextUtils.isEmpty(serviceProtocolSerializable.wording)) {
                string = serviceProtocolSerializable.wording;
            }
            if (!TextUtils.isEmpty(serviceProtocolSerializable.name)) {
                string2 = serviceProtocolSerializable.name;
            }
            if (!TextUtils.isEmpty(serviceProtocolSerializable.url)) {
                string3 = serviceProtocolSerializable.url;
            }
            if (QCircleQualityReporter.KEY_ID.equals(this.I) && !TextUtils.isEmpty(string3) && string3.contains("?appname=")) {
                QLog.d("IdentificationGuideFragment", 2, "url have no change");
            } else {
                if ("setFaceData".equals(this.I)) {
                    sb5 = string3 + "?appname=qq_safety";
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(string3);
                    if (TextUtils.isEmpty(appConf.appName)) {
                        str2 = "";
                    } else {
                        str2 = "?appname=" + appConf.appName;
                    }
                    sb6.append(str2);
                    sb5 = sb6.toString();
                }
                string3 = sb5;
            }
        } else {
            QLog.e("IdentificationGuideFragment", 1, "updateProtocolText null == mAppConf || mAppConf.serviceProtocols.isEmpty()");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("IdentificationGuideFragment", 4, "updateProtocolText wording=" + string + " name=" + string2 + " url=" + string3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData(string2, (View.OnClickListener) new g(string3), true));
        if (!TextUtils.isEmpty(string)) {
            if (string.length() >= 4) {
                str = string.substring(0, 4);
            } else {
                str = string;
            }
            arrayList.add(new RichTextHelper.RichTextData(str, new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.dj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdentificationGuideFragment.this.ai(view);
                }
            }, false));
        }
        PrivacyPolicyHelper.expandCheckBoxTouchDelegate(this.Q);
        this.L.setText(RichTextHelper.buildSpannable(string + string2, getContext(), false, arrayList));
    }

    public void pi(final int i3, final boolean z16) {
        if (i3 != 210 && NetworkUtil.isNetSupport(this.C) && i3 != 212 && i3 != 214) {
            FaceConf faceConf = this.H;
            if (faceConf != null && faceConf.getAppConf() != null && !TextUtils.isEmpty(this.H.getAppConf().huiyanSdkToken)) {
                QLog.d("IdentificationGuideFragment", 1, "verifyResultThroughBDH huiyanSdkToken=" + this.H.getAppConf().huiyanSdkToken + " huiyanSdkErrorCode=" + i3);
                new com.tencent.mobileqq.identification.ae(this.H, new ae.b() { // from class: com.tencent.mobileqq.activity.dk
                    @Override // com.tencent.mobileqq.identification.ae.b
                    public final void a(int i16, Bundle bundle) {
                        IdentificationGuideFragment.this.bi(z16, i3, i16, bundle);
                    }
                }).f();
                ki(R.string.f159621st);
                return;
            }
            mi(HardCodeUtil.qqStr(R.string.f159591sq));
            QLog.e("IdentificationGuideFragment", 1, "verifyResultThroughBDH sdkToken is empty");
            return;
        }
        QLog.e("IdentificationGuideFragment", 1, "verifyResultThroughBDH network not support");
        ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", z16 ? 1 : 0, 2, String.valueOf(210), "", "", "");
        ki(R.string.f159621st);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.IdentificationGuideFragment.8
            static IPatchRedirector $redirector_;

            /* renamed from: d */
            final /* synthetic */ int f176251d;

            AnonymousClass8(final int i36) {
                this.f176251d = i36;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationGuideFragment.this, i36);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (IdentificationGuideFragment.this.getActivity() != null && !IdentificationGuideFragment.this.getActivity().isFinishing()) {
                    IdentificationGuideFragment.this.Ph();
                    com.tencent.mobileqq.identification.z.g(IdentificationGuideFragment.this.C, "failed", new Bundle());
                    IdentificationGuideFragment.this.Sh(new Bundle(), this.f176251d);
                }
            }
        }, 200L);
    }

    private void showLoadingView() {
        ki(R.string.f159541sl);
    }

    public void di() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", 0, 3, "", "", "", "");
        ReportController.o(null, "dc00898", "", "", "0X800BDB3", "0X800BDB3", com.tencent.mobileqq.util.bm.a(this.I), 0, "", "", "", "");
        com.tencent.mobileqq.identification.z.g(this.C, "canceled", null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            showLoadingView();
        } else if (i3 == 2) {
            Ph();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        QLog.d("IdentificationGuideFragment", 1, "onActivityResult requestCode=" + i3 + ", resultCode=" + i16);
        if (i3 == 103 && i16 == -1 && this.C != null) {
            FaceConf faceConf = (FaceConf) intent.getSerializableExtra("faceConf");
            if (faceConf != null) {
                this.H = faceConf;
            } else {
                QLog.e("IdentificationGuideFragment", 1, "onActivityResult faceConf=null");
            }
            boolean booleanExtra = intent.getBooleanExtra("key_has_identified", false);
            if (booleanExtra) {
                pi(intent.getIntExtra("key_huiyan_sdk_error_code", 0), true);
            } else {
                this.C.finish();
            }
            QLog.d("IdentificationGuideFragment", 1, "onActivityResult hasIdentified=" + booleanExtra);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onAttach(activity);
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        this.C = fragmentActivity;
        this.H = (FaceConf) fragmentActivity.getIntent().getSerializableExtra("faceConf");
        this.J = this.C.getIntent().getBooleanExtra("skipIdentificationGuidePage", false);
        if (this.H == null) {
            QLog.e("IdentificationGuideFragment", 1, "mFaceConf is null");
            this.C.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f165745xh0) {
            if (!this.Q.isChecked()) {
                this.M.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.f155059vh));
                Qh();
            } else if (this.H == null) {
                QLog.e("IdentificationGuideFragment", 1, "mFaceConf==null");
                mi(HardCodeUtil.qqStr(R.string.f159591sq));
            } else if (!NetworkUtil.isNetSupport(this.C)) {
                mi(HardCodeUtil.qqStr(R.string.f159571so));
                QLog.e("IdentificationGuideFragment", 1, "verifyResultThroughBDH network not support");
            } else if (com.tencent.mobileqq.util.bm.b(this.C)) {
                mi(HardCodeUtil.qqStr(R.string.f159561sn));
                QLog.e("IdentificationGuideFragment", 1, "current mode is in multi window");
            } else if (com.tencent.mobileqq.util.bm.c()) {
                mi(HardCodeUtil.qqStr(R.string.f159631su));
                QLog.e("IdentificationGuideFragment", 1, "current mode is video chatting");
            } else {
                if (Nh()) {
                    ni();
                } else {
                    hi();
                }
                com.tencent.mobileqq.identification.z.g(this.C, "guidePageNextBtnClick", null);
                if ("loginVerify".equals(this.I)) {
                    ReportController.o(null, "dc00898", "", "", "0X800A319", "0X800A319", 0, 0, "", "", "", "");
                } else if ("setFaceData".equals(this.I)) {
                    ReportController.o(null, "dc00898", "", "", "0X800A31E", "0X800A31E", 0, 0, "", "", "", "");
                }
                ReportController.o(null, "dc00898", "", "", "0X800BD78", "0X800BD78", com.tencent.mobileqq.util.bm.a(this.I), 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        String format;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.fcg, viewGroup, false);
            if (this.H == null) {
                QLog.e("IdentificationGuideFragment", 1, "onCreateView mFaceConf is null");
                if (!this.C.isFinishing()) {
                    this.C.finish();
                }
            } else {
                Th(inflate);
                String name = this.H.getName();
                String method = this.H.getMethod();
                this.I = method;
                if (TextUtils.isEmpty(method) && bundle != null) {
                    String string = bundle.getString("method");
                    this.I = string;
                    this.H.setMethod(string);
                    QLog.d("IdentificationGuideFragment", 1, "saveInstanceState is not null, method is ", this.I);
                }
                if ("setFaceData".equalsIgnoreCase(this.I)) {
                    format = getString(R.string.f159781t9);
                } else {
                    String string2 = getString(R.string.f159651sw);
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(name)) {
                        name = getString(R.string.f159711t2);
                    }
                    objArr[0] = name;
                    format = String.format(string2, objArr);
                }
                this.K = (ViewGroup) inflate.findViewById(R.id.f165746xh1);
                ((TextView) inflate.findViewById(R.id.f165747xh2)).setText(format);
                this.Q = (CheckBox) inflate.findViewById(R.id.f165748xh3);
                TextView textView = (TextView) inflate.findViewById(R.id.xh5);
                this.L = textView;
                textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
                Zh(this.H.getAppConf());
                this.Q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.df
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                        IdentificationGuideFragment.this.Wh(compoundButton, z16);
                    }
                });
                QUIButton qUIButton = (QUIButton) inflate.findViewById(R.id.f165745xh0);
                this.P = qUIButton;
                qUIButton.setOnClickListener(this);
                this.P.setBackgroundDisabled();
                View findViewById = inflate.findViewById(R.id.f165749xh4);
                this.M = findViewById;
                findViewById.setOnClickListener(this);
                if (QQTheme.isNowThemeIsNight()) {
                    ((ImageView) inflate.findViewById(R.id.xgy)).setColorFilter(-1);
                }
                ReportController.o(null, "dc00898", "", "", "0X80097E9", "0X80097E9", com.tencent.mobileqq.util.bm.a(this.I), 0, String.valueOf(this.H.getServiceType()), "", String.valueOf(this.H.getAppId()), "");
                if (this.G == 0) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
                    this.C.registerReceiver(this.T, intentFilter);
                    this.G = 1;
                }
                if ("loginVerify".equals(this.I)) {
                    ReportController.o(null, "dc00898", "", "", "0X800A318", "0X800A318", 0, 0, "", "", "", "");
                } else if ("setFaceData".equals(this.I)) {
                    ReportController.o(null, "dc00898", "", "", "0X800A31D", "0X800A31D", 0, 0, "", "", "", "");
                }
                com.tencent.mobileqq.util.ap.f306581a.m();
                com.tencent.mobileqq.identification.z.g(this.C, "guidePageCreate", null);
                if (QLog.isDevelopLevel()) {
                    QLog.d("IdentificationGuideFragment", 4, "mNeedSkipGuide=" + this.J);
                }
                if (this.J) {
                    ji();
                    ci();
                } else {
                    Rh(false);
                    ei();
                }
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.G == 1) {
            this.C.unregisterReceiver(this.T);
            this.G = 0;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.onSaveInstanceState(bundle);
        QLog.d("IdentificationGuideFragment", 1, "onSaveInstanceState");
        bundle.putString("method", this.I);
    }

    void setResult(int i3, Intent intent) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(i3, intent);
        }
    }
}
