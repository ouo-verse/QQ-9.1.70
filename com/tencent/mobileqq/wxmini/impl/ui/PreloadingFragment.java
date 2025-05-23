package com.tencent.mobileqq.wxmini.impl.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.data.LaunchWxaErrorCode;
import com.tencent.mobileqq.wxmini.api.data.LauncherWxaState;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaLauncher;
import com.tencent.mobileqq.wxmini.impl.util.i;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* loaded from: classes35.dex */
public class PreloadingFragment extends QPublicBaseFragment {
    private View C;
    private TextView D;
    private Runnable E;
    private a F;
    private ResultReceiver G = null;
    private WxaInfo H = null;
    private WxaLauncher I = null;
    private Boolean J;
    private Boolean K;

    /* loaded from: classes35.dex */
    private static class a implements WxaLauncher.e {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<PreloadingFragment> f327759a;

        public a(PreloadingFragment preloadingFragment) {
            this.f327759a = new WeakReference<>(preloadingFragment);
        }

        private void b(int i3, int i16) {
            if (this.f327759a.get() == null) {
                return;
            }
            this.f327759a.get().Gh(i3, i16);
        }

        @Override // com.tencent.mobileqq.wxmini.impl.launcher.WxaLauncher.e
        public void a(int i3, int i16, int i17) {
            QLog.i("[wxa-q]PreloadingFragment", 1, "onStateChange:" + i3 + ",errorCode:" + i17 + ", preloadFragmetn:" + this.f327759a.get());
            PreloadingFragment preloadingFragment = this.f327759a.get();
            if (preloadingFragment != null && preloadingFragment.Jh(preloadingFragment.getQBaseActivity())) {
                QLog.i("[wxa-q]PreloadingFragment", 1, "launch wxa state: " + i3 + ", firstOpenDownloadProgress:" + i16);
                preloadingFragment.J = Boolean.valueOf(i3 == LauncherWxaState.STATE_AUTHORIZING.getState());
                if (i3 == LauncherWxaState.STATE_DOWNLOAD_SO_SUCCESS.getState()) {
                    preloadingFragment.Oh(preloadingFragment.getString(R.string.x6i));
                    WxaLauncher wxaLauncher = preloadingFragment.I;
                    WxaInfo Hh = preloadingFragment.Hh();
                    if (wxaLauncher != null && Hh != null) {
                        preloadingFragment.I.W(Hh, hb3.f.h());
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("so download success but state invalid:");
                        sb5.append(wxaLauncher == null);
                        sb5.append(", ");
                        sb5.append(Hh == null);
                        QLog.e("[wxa-q]PreloadingFragment", 1, sb5.toString());
                    }
                } else if (i3 == LauncherWxaState.STATE_DOWNLOAD_SO_PROGRESS.getState()) {
                    preloadingFragment.Oh(String.format(preloadingFragment.getString(R.string.x6j), i16 + "%"));
                } else {
                    LauncherWxaState launcherWxaState = LauncherWxaState.STATE_DOWNLOAD_SO_FAIL;
                    if (i3 == launcherWxaState.getState()) {
                        QQToast.makeText(preloadingFragment.getContext(), 1, R.string.x6f, 0).show();
                        preloadingFragment.quit();
                        QLog.i("[wxa-q]PreloadingFragment", 1, "WxaLauncher.STATE_DOWNLOAD_SO_FAIL, quit!!");
                    } else if (i3 == LauncherWxaState.STATE_LAUNCH_SUCCEED.getState() || i3 == LauncherWxaState.STATE_LAUNCH_FAILED.getState() || i3 == launcherWxaState.getState()) {
                        preloadingFragment.quit();
                        QLog.i("[wxa-q]PreloadingFragment", 1, "state != WxaLauncher.STATE_LAUNCHINGL, quit with code:" + i17);
                    }
                }
                b(i3, i17);
                return;
            }
            QLog.i("[wxa-q]PreloadingFragment", 1, "onStateChange, activity is not active! state: " + i3 + ", firstOpenDownloadProgress:" + i16);
        }
    }

    public PreloadingFragment() {
        Boolean bool = Boolean.FALSE;
        this.J = bool;
        this.K = bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh(int i3, int i16) {
        if (this.G == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i16);
        bundle.putString("errMsg", i.c(i16));
        this.G.send(i3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WxaInfo Hh() {
        return this.H;
    }

    private void Ih() {
        if (!hb3.f.h().e()) {
            Oh(String.format(getString(R.string.x6j), "0%"));
        } else {
            Oh(getString(R.string.o7h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh() {
        if (Jh(getQBaseActivity())) {
            this.C.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(String str) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void Nh() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.1
            @Override // java.lang.Runnable
            public void run() {
                PreloadingFragment preloadingFragment = PreloadingFragment.this;
                preloadingFragment.F = new a(preloadingFragment);
                if (PreloadingFragment.this.getArguments() != null) {
                    PreloadingFragment preloadingFragment2 = PreloadingFragment.this;
                    preloadingFragment2.G = (ResultReceiver) preloadingFragment2.getArguments().getParcelable("mini_receiver");
                }
                PreloadingFragment.this.I = new WxaLauncher();
                PreloadingFragment.this.I.k0(Boolean.valueOf(PreloadingFragment.this.G == null));
                PreloadingFragment preloadingFragment3 = PreloadingFragment.this;
                preloadingFragment3.H = WxaLauncher.t(preloadingFragment3.getArguments());
                if (PreloadingFragment.this.H != null) {
                    PreloadingFragment.this.H.u(ib3.b.f407378a.g(PreloadingFragment.this.H));
                }
                PreloadingFragment.this.I.M(PreloadingFragment.this.H, PreloadingFragment.this.F);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.ui.c
            @Override // java.lang.Runnable
            public final void run() {
                PreloadingFragment.this.Mh(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quit() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (Jh(qBaseActivity)) {
            qBaseActivity.finishAndRemoveTask();
            qBaseActivity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        QLog.i("[wxa-q]PreloadingFragment", 1, "onFinish," + this);
        View view = this.C;
        if (view != null) {
            view.removeCallbacks(this.E);
        }
        WxaLauncher wxaLauncher = this.I;
        if (wxaLauncher != null) {
            wxaLauncher.a0();
        }
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.K = Boolean.TRUE;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.K.booleanValue()) {
            QLog.e("[wxa-q]PreloadingFragment", 1, "user cancel and back");
            Gh(LauncherWxaState.STATE_LAUNCHING_CLOSE.getState(), LaunchWxaErrorCode.Fail.getCode());
            quit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.i("[wxa-q]PreloadingFragment", 1, "onViewCreated," + this);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wxmini.impl.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QLog.i("[wxa-q]PreloadingFragment", 1, "prevent dispatch touch event!");
            }
        });
        Nh();
        this.C = view.findViewById(R.id.loading_layout);
        this.D = (TextView) view.findViewById(R.id.title);
        Ih();
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                PreloadingFragment.this.Lh();
            }
        };
        this.E = runnable;
        this.C.postDelayed(runnable, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jh(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.f168277s0, viewGroup, false);
    }
}
