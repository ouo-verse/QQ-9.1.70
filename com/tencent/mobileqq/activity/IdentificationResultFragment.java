package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IdentificationResultFragment extends QPublicBaseFragment implements Handler.Callback, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static final Map<Integer, String> M;
    private QUIButton C;
    private QUIButton D;
    private QBaseActivity E;
    private FaceConf F;
    private Bundle G;
    public MqqHandler H;
    private Dialog I;
    private final AtomicBoolean J;
    private boolean K;
    private final Runnable L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationResultFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                IdentificationResultFragment.this.onBackEvent();
                if (IdentificationResultFragment.this.E != null) {
                    IdentificationResultFragment.this.E.finish();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationResultFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QLog.d("IdentificationResultFragment", 1, "retryButton onClick");
                Intent intent = IdentificationResultFragment.this.E.getIntent();
                if (intent != null) {
                    IdentificationResultFragment.this.F = (FaceConf) intent.getSerializableExtra("faceConf");
                }
                if (IdentificationResultFragment.this.F == null) {
                    QLog.e("IdentificationResultFragment", 1, "mFaceConf==null");
                    IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159591sq));
                } else if (!NetworkUtil.isNetSupport(IdentificationResultFragment.this.E)) {
                    IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159571so));
                    QLog.e("IdentificationResultFragment", 1, "retryButton onClick network not support");
                } else if (com.tencent.mobileqq.util.bm.b(IdentificationResultFragment.this.E)) {
                    IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159561sn));
                    QLog.e("IdentificationResultFragment", 1, "current mode is in multi window");
                } else if (com.tencent.mobileqq.util.bm.c()) {
                    IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159631su));
                    QLog.e("IdentificationResultFragment", 1, "current mode is video chatting");
                } else {
                    IdentificationResultFragment.this.F.setAppConf(null);
                    IdentificationResultFragment.this.Ah();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements IdentificationHuiyanSDKInitHelper.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationResultFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.f
        public void a(AppConf appConf) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appConf);
                return;
            }
            QLog.d("IdentificationResultFragment", 1, "getAppConfAndHuiyanSdkToken onSuccess");
            IdentificationResultFragment.this.J.set(false);
            if (IdentificationResultFragment.this.getContext() == null) {
                QLog.e("IdentificationResultFragment", 1, "callServer getContext == null");
                return;
            }
            IdentificationResultFragment.this.F.setAppConf(appConf);
            if (appConf != null && !TextUtils.isEmpty(appConf.huiyanSdkToken)) {
                String uin = IdentificationResultFragment.this.F.getUin();
                com.tencent.mobileqq.util.ap apVar = com.tencent.mobileqq.util.ap.f306581a;
                if (apVar.k(uin)) {
                    IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159501sh));
                    return;
                } else {
                    apVar.i(IdentificationResultFragment.this.F.getUin());
                    IdentificationResultFragment.this.Eh();
                    return;
                }
            }
            QLog.e("IdentificationResultFragment", 1, "getAppConfAndHuiyanSdkToken success appConf is null or huiyanSdkToken is null");
            IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159591sq));
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.f
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e("IdentificationResultFragment", 1, "getAppConfAndHuiyanSdkToken onFail");
            ReportController.o(null, "dc00898", "", "", "0X800C428", "0X800C428", 1, 1, String.valueOf(i3), "", "", "");
            IdentificationResultFragment.this.J.set(false);
            IdentificationResultFragment.this.H.removeMessages(1);
            IdentificationResultFragment.this.H.sendEmptyMessage(2);
            IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159591sq));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements IdentificationHuiyanSDKInitHelper.h {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationResultFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.h
        public void onFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.e("IdentificationResultFragment", 1, "prepare huiyan sdk fail");
                IdentificationResultFragment.this.Hh(HardCodeUtil.qqStr(R.string.f159601sr));
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.h
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("IdentificationResultFragment", 1, "prepare huiyan sdk success");
                IdentificationResultFragment.this.Gh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements IdentificationHuiyanSDKInitHelper.g {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationResultFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.g
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d("IdentificationResultFragment", 1, "startHuiyanSdk onFailed huiyanSdkErrorCode=" + i3 + " msg=" + str);
            IdentificationResultFragment identificationResultFragment = IdentificationResultFragment.this;
            identificationResultFragment.Fh(identificationResultFragment.F, i3);
            IdentificationResultFragment.this.E.finish();
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.g
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("IdentificationResultFragment", 1, "startHuiyanSdk onSuccess");
            IdentificationResultFragment identificationResultFragment = IdentificationResultFragment.this;
            identificationResultFragment.Fh(identificationResultFragment.F, 0);
            IdentificationResultFragment.this.E.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f implements WebViewBridge.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Runnable> f176272a;

        f(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            } else {
                this.f176272a = new WeakReference<>(runnable);
            }
        }

        private void c() {
            Runnable runnable = this.f176272a.get();
            if (runnable != null) {
                runnable.run();
            } else {
                QLog.e("IdentificationResultFragment", 1, "executeRunnable runnable is null");
            }
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            QLog.i("IdentificationResultFragment", 1, "WebViewBridge onReceiveEvent event: " + str);
            if (!"com.tencent.mobileqq.InvitationWebViewPlugin.unbindAccount".equals(str)) {
                return;
            }
            WebViewBridge.f().n(i3);
            c();
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void b(int i3, int i16, int i17, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
                return;
            }
            QLog.i("IdentificationResultFragment", 1, "WebViewBridge onActivityResult resultCode: " + i17);
            if (i17 == 0) {
                WebViewBridge.f().n(i3);
                c();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        HashMap hashMap = new HashMap();
        M = hashMap;
        hashMap.put(210, HardCodeUtil.qqStr(R.string.f159571so));
        hashMap.put(211, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(212, HardCodeUtil.qqStr(R.string.f159481sf));
        hashMap.put(213, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(214, HardCodeUtil.qqStr(R.string.f159481sf));
        hashMap.put(215, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(216, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(217, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(218, HardCodeUtil.qqStr(R.string.f159471se));
        hashMap.put(219, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(220, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(221, HardCodeUtil.qqStr(R.string.f159511si));
        hashMap.put(222, HardCodeUtil.qqStr(R.string.f159611ss));
        hashMap.put(223, HardCodeUtil.qqStr(R.string.f159611ss));
        hashMap.put(224, HardCodeUtil.qqStr(R.string.f159471se));
        hashMap.put(18, HardCodeUtil.qqStr(R.string.f159531sk));
        hashMap.put(228, HardCodeUtil.qqStr(R.string.f159511si));
    }

    public IdentificationResultFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = new MqqHandler(Looper.getMainLooper(), this);
        this.J = new AtomicBoolean(false);
        this.K = false;
        this.L = new Runnable() { // from class: com.tencent.mobileqq.activity.IdentificationResultFragment.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private final AtomicBoolean f176266d;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IdentificationResultFragment.this);
                } else {
                    this.f176266d = new AtomicBoolean(false);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("IdentificationResultFragment", 1, "cancelRunnable");
                if (this.f176266d.compareAndSet(false, true)) {
                    IdentificationResultFragment identificationResultFragment = IdentificationResultFragment.this;
                    identificationResultFragment.Fh(identificationResultFragment.F, 212);
                    IdentificationResultFragment.this.E.finish();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        ReportController.o(null, "dc00898", "", "", "0X800C427", "0X800C427", 1, 0, "", "", "", "");
        this.K = true;
        IdentificationHuiyanSDKInitHelper.m(this.F, new c());
    }

    private void Bh(View view) {
        View findViewById = view.findViewById(R.id.idz);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        TextView textView = (TextView) findViewById.findViewById(R.id.ivTitleBtnLeft);
        textView.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        textView.setCompoundDrawables(null, null, null, null);
        textView.setBackground(new ColorDrawable(0));
        textView.setText(HardCodeUtil.qqStr(R.string.cancel));
        textView.setVisibility(0);
        textView.setOnClickListener(new a());
        ((ImageView) findViewById.findViewById(R.id.f165972dz1)).setVisibility(8);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.ivTitleName);
        textView2.setText(getString(R.string.azj));
        textView2.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        int color = this.E.getResources().getColor(R.color.qui_common_bg_bottom_standard);
        SystemBarCompact systemBarCompact = new SystemBarCompact((Activity) this.E, true, color);
        systemBarCompact.setStatusBarColor(color);
        if (!isNowThemeIsNight) {
            SystemBarActivityModule.setSystemBarComp(this.E, systemBarCompact);
            ImmersiveUtils.setStatusTextColor(true, this.E.getWindow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(String str) {
        QQToast.makeText(getActivity(), str, 1).show();
    }

    private void Dh(QBaseActivity qBaseActivity, String str) {
        WebViewBridge.f().k(qBaseActivity, new f(this.L)).a(qBaseActivity, str, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        IdentificationHuiyanSDKInitHelper.B(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(FaceConf faceConf, int i3) {
        Intent intent = new Intent();
        intent.putExtra("key_has_identified", this.K);
        intent.putExtra("faceConf", faceConf);
        intent.putExtra("key_huiyan_sdk_error_code", i3);
        this.E.setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        String str;
        FaceConf faceConf = this.F;
        if (faceConf != null && faceConf.getAppConf() != null) {
            str = this.F.getAppConf().huiyanSdkToken;
        } else {
            str = null;
        }
        QLog.i("IdentificationResultFragment", 1, "startHuiyanSdk huiyanSdkToken=" + str);
        if (TextUtils.isEmpty(str)) {
            QLog.e("IdentificationResultFragment", 1, "huiyanSdkToken is null");
        } else {
            IdentificationHuiyanSDKInitHelper.D(this.F, new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.dn
            @Override // java.lang.Runnable
            public final void run() {
                IdentificationResultFragment.this.Ch(str);
            }
        });
    }

    @Nullable
    private String getErrMsg() {
        String string = this.G.getString("errMsg", HardCodeUtil.qqStr(R.string.f159511si));
        int intExtra = this.E.getIntent().getIntExtra("key_huiyan_sdk_error_code", 0);
        QLog.d("IdentificationResultFragment", 1, "getErrMsg huiyanSdkErrorCode=" + intExtra + " backend text=" + string);
        Map<Integer, String> map = M;
        if (map.containsKey(Integer.valueOf(intExtra))) {
            string = map.get(Integer.valueOf(intExtra));
        }
        if (TextUtils.isEmpty(string)) {
            return HardCodeUtil.qqStr(R.string.f159511si);
        }
        return string;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            showLoadingView();
        } else if (i3 == 2) {
            zh();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QLog.e("IdentificationResultFragment", 1, "onBackEvent");
        Fh(this.F, 212);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.xh9) {
                String string = this.G.getString("redirect_url", "");
                QBaseActivity qBaseActivity = this.E;
                if (qBaseActivity != null) {
                    Dh(qBaseActivity, string);
                } else {
                    QLog.e("IdentificationResultFragment", 1, "onClick mActivity is null");
                }
            } else if (id5 == R.id.xh_) {
                Fh(this.F, 212);
                QBaseActivity qBaseActivity2 = this.E;
                if (qBaseActivity2 != null) {
                    qBaseActivity2.finish();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            QLog.e("IdentificationResultFragment", 1, "onCreateView");
            inflate = layoutInflater.inflate(R.layout.fci, viewGroup, false);
            QBaseActivity qBaseActivity = (QBaseActivity) getActivity();
            this.E = qBaseActivity;
            FaceConf faceConf = (FaceConf) qBaseActivity.getIntent().getSerializableExtra("faceConf");
            this.F = faceConf;
            if (faceConf == null) {
                QLog.e("IdentificationResultFragment", 1, "onCreateView mFaceConf is null");
                this.E.finish();
            } else {
                Bundle bundleExtra = this.E.getIntent().getBundleExtra("data");
                this.G = bundleExtra;
                if (bundleExtra == null) {
                    this.G = new Bundle();
                    QLog.d("IdentificationResultFragment", 1, "onCreateView mData is null");
                }
                Bh(inflate);
                Button button = (Button) inflate.findViewById(R.id.xha);
                button.setOnClickListener(new b());
                ((TextView) inflate.findViewById(R.id.f167042k73)).setText(getErrMsg());
                this.C = (QUIButton) inflate.findViewById(R.id.xh9);
                this.D = (QUIButton) inflate.findViewById(R.id.xh_);
                int i3 = this.G.getInt("ret", -1);
                String string = this.G.getString("redirect_url", "");
                if (i3 == 700 && string != null && string.startsWith("http")) {
                    this.C.setVisibility(0);
                    this.D.setVisibility(0);
                    this.C.setOnClickListener(this);
                    this.D.setOnClickListener(this);
                    button.setVisibility(8);
                } else {
                    this.C.setVisibility(8);
                    this.D.setVisibility(8);
                    button.setVisibility(0);
                }
                Fh(this.F, 212);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroyView();
        QLog.e("IdentificationResultFragment", 1, "onDestroyView");
        this.E.finish();
    }

    public void showLoadingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            if (this.I == null) {
                this.I = DialogUtil.createWaitingDialog(getActivity(), R.string.f159541sl);
            }
            this.I.show();
        } catch (Exception e16) {
            QLog.e("IdentificationResultFragment", 1, e16, new Object[0]);
        }
    }

    public void zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Dialog dialog = this.I;
        if (dialog != null) {
            try {
                dialog.cancel();
            } catch (Exception e16) {
                QLog.e("IdentificationResultFragment", 1, e16, new Object[0]);
            }
            this.I = null;
        }
    }
}
