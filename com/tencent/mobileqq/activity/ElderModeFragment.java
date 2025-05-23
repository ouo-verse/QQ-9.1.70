package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ElderModeFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private ViewGroup C;
    private QQProgressDialog D;
    private Dialog E;
    private final com.tencent.mobileqq.simpleui.f F;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.simpleui.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElderModeFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void e(boolean z16, boolean z17, boolean z18, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ElderModeFragment.this.wh(z16, z17);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElderModeFragment.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ElderModeFragment.this.vh();
                ElderModeFragment.this.C.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElderModeFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ElderModeFragment.this.Eh();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f175700d;

        d(Activity activity) {
            this.f175700d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElderModeFragment.this, (Object) activity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("ElderModeFragment", 1, "showConfirmDialog ok click");
            ElderModeFragment.this.xh(this.f175700d);
            ElderModeFragment.this.E.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElderModeFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                QLog.d("ElderModeFragment", 1, "showConfirmDialog cancel click");
                ElderModeFragment.this.E.dismiss();
            }
        }
    }

    public ElderModeFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.F = new a();
        }
    }

    private boolean Ah() {
        return ThemeUtil.isNowThemeIsNight(getQBaseActivity().getAppRuntime(), true, null);
    }

    private void Bh(Activity activity) {
        Dialog dialog = this.E;
        if (dialog != null && dialog.isShowing()) {
            QLog.d("ElderModeFragment", 1, "showConfirmDialog is showing");
            return;
        }
        QLog.d("ElderModeFragment", 1, "showConfirmDialog");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, getString(R.string.bbh), getString(R.string.bbf), getString(R.string.bbe), getString(R.string.bbg), new d(activity), new e());
        this.E = createCustomDialog;
        createCustomDialog.show();
    }

    private void Ch(Activity activity) {
        QLog.d("ElderModeFragment", 1, UIJsPlugin.EVENT_SHOW_LOADING);
        if (this.D == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, 0, R.layout.b17, 17);
            this.D = qQProgressDialog;
            qQProgressDialog.setHeightParams(-1);
        }
        if (this.D.isShowing()) {
            return;
        }
        try {
            this.D.show();
        } catch (Exception e16) {
            QLog.e("ElderModeFragment", 1, UIJsPlugin.EVENT_SHOW_LOADING, e16);
        }
    }

    public static void Dh(Activity activity, int i3) {
        if (activity == null) {
            QLog.d("ElderModeFragment", 1, "startFragmentForResult fail null == activity");
        } else {
            QLog.d("ElderModeFragment", 1, "startFragmentForResult");
            QPublicFragmentActivity.b.e(activity, new Intent(), QPublicFragmentActivity.class, ElderModeFragment.class, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        QLog.d("ElderModeFragment", 1, "toggleElderMode click");
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.d("ElderModeFragment", 1, "-->exitImBlock--getActivity() == null");
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(qBaseActivity, 1, R.string.cjm, 0).show();
        } else if (ElderModeManager.k()) {
            Bh(qBaseActivity);
        } else {
            xh(qBaseActivity);
        }
    }

    private void Fh(int i3, float f16) {
        View findViewById = this.C.findViewById(i3);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = (int) f16;
        findViewById.setLayoutParams(layoutParams);
    }

    private void hideLoading() {
        QLog.d("ElderModeFragment", 1, UIJsPlugin.EVENT_HIDE_LOADING);
        QQProgressDialog qQProgressDialog = this.D;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.D.hide();
            } catch (Exception e16) {
                QLog.e("ElderModeFragment", 1, UIJsPlugin.EVENT_HIDE_LOADING, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        ViewGroup viewGroup = this.C;
        int i3 = viewGroup.getResources().getDisplayMetrics().heightPixels;
        int childCount = viewGroup.getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            i16 += viewGroup.getChildAt(i17).getMeasuredHeight();
        }
        float f16 = i3 - i16;
        QLog.d("ElderModeFragment", 1, "screenHeight=", Integer.valueOf(i3), ", totalViewHeight=", Integer.valueOf(i16), ", space=", Float.valueOf(f16));
        Fh(R.id.f163884b6, 0.17894737f * f16);
        Fh(R.id.zct, 0.060150377f * f16);
        Fh(R.id.zcs, 0.036090225f * f16);
        Fh(R.id.urt, f16 * 0.4330827f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(boolean z16, boolean z17) {
        float d16;
        QLog.d("ElderModeFragment", 1, "afterSwitchMode isSuc=", z16 + ", bChangeTheme=" + z17);
        if (!z16) {
            hideLoading();
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.d("ElderModeFragment", 1, "-->exitImBlock--getActivity() == null");
            return;
        }
        if (!(getQBaseActivity().getAppRuntime() instanceof AppInterface)) {
            return;
        }
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.F);
        hideLoading();
        qBaseActivity.setResult(-1);
        qBaseActivity.finish();
        if (ElderModeManager.l()) {
            if (ElderModeManager.j()) {
                d16 = ElderModeManager.c();
            } else {
                d16 = ElderModeManager.d();
            }
            ElderModeManager.o(FontSettingManager.getFontLevel());
            FontSettingManager.setCustomDensity(qBaseActivity, d16, true);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.ElderModeFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElderModeFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QLog.d("ElderModeFragment", 1, "afterSwitchMode killProcess");
                        FontSettingManager.killProcess();
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(Activity activity) {
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        if (!(appRuntime instanceof AppInterface)) {
            return;
        }
        if (StudyModeManager.t()) {
            boolean f16 = JumpKidModeMgr.b().f(3, 2, (QQAppInterface) appRuntime, activity, 4);
            QLog.d("ElderModeFragment", 1, "changeMode study mode change isSuccess=" + f16);
            if (!f16) {
                QQToast.makeText(getQBaseActivity(), R.string.hhx, 0).show();
                return;
            }
            return;
        }
        yh(activity, appRuntime);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0074, code lost:
    
        if (r0 < r6) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void yh(Activity activity, AppRuntime appRuntime) {
        String str;
        int i3;
        QLog.d("ElderModeFragment", 1, "doChangeMode");
        if (ElderModeManager.j()) {
            str = "0X800BE7D";
        } else {
            str = "0X800BE7C";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        ((AppInterface) appRuntime).addObserver(this.F);
        com.tencent.mobileqq.studymode.l lVar = (com.tencent.mobileqq.studymode.l) appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        int i16 = 0;
        if (ElderModeManager.j()) {
            QLog.d("ElderModeFragment", 1, "doChangeMode to close");
            String f16 = ElderModeManager.f(appRuntime);
            i3 = ElderModeManager.e(f16);
            int max = Math.max(SimpleUIUtil.getPrefByThemeId(f16), 0);
            if (i3 == 1) {
                i16 = SimpleUIUtil.getPrefByThemeId("2920");
                if (QQTheme.isNowThemeSimpleNight()) {
                }
            }
            i16 = max;
        } else {
            QLog.d("ElderModeFragment", 1, "doChangeMode to open");
            ElderModeManager.p(appRuntime);
            i3 = 3;
        }
        if (lVar.i(activity, i3, i16, true).c()) {
            Ch(activity);
        } else {
            QLog.d("ElderModeFragment", 1, "doChangeMode fail isSwitching");
        }
    }

    private void zh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.d("ElderModeFragment", 1, "-->exitImBlock--getActivity() == null");
        } else {
            qBaseActivity.setResult(0);
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        QLog.d("ElderModeFragment", 1, "-->onCreateView--");
        ReportController.o(null, "dc00898", "", "", "0X800BE7B", "0X800BE7B", 0, 0, "", "", "", "");
        ViewGroup viewGroup2 = (ViewGroup) ((QIphoneTitleBarFragment) this).mContentView;
        this.C = viewGroup2;
        TextView textView = (TextView) viewGroup2.findViewById(R.id.urt);
        TextView textView2 = (TextView) this.C.findViewById(R.id.zcs);
        if (ElderModeManager.j()) {
            i3 = R.string.f167922e9;
        } else {
            i3 = R.string.f167962ec;
        }
        textView2.setText(i3);
        if (ElderModeManager.j()) {
            i16 = R.string.f167912e8;
        } else {
            i16 = R.string.f167942ea;
        }
        textView.setText(i16);
        textView.setContentDescription(getString(i16));
        this.C.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.C.findViewById(R.id.urt).setOnClickListener(new c());
        boolean Ah = Ah();
        int i19 = -16777216;
        if (Ah) {
            i17 = -7894119;
        } else {
            i17 = -16777216;
        }
        textView2.setTextColor(i17);
        TextView textView3 = (TextView) this.C.findViewById(R.id.zct);
        if (Ah) {
            i18 = -1;
        } else {
            i18 = -16777216;
        }
        textView3.setTextColor(i18);
        ViewGroup viewGroup3 = this.C;
        if (!Ah) {
            i19 = -1;
        }
        viewGroup3.setBackgroundColor(i19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.h3o;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 2) {
            return;
        }
        QLog.d("ElderModeFragment", 1, "-->onActivityResult, resultCode=" + i16);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.d("ElderModeFragment", 1, "-->onActivityResult--getActivity() == null");
            return;
        }
        if (JumpKidModeMgr.b().d() != -1 && JumpKidModeMgr.b().c() != -1) {
            if (i16 != -1) {
                QQToast.makeText(getQBaseActivity(), R.string.hhx, 0).show();
                return;
            }
            AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
            if (!(appRuntime instanceof AppInterface)) {
                return;
            }
            yh(qBaseActivity, appRuntime);
            return;
        }
        QQToast.makeText(getQBaseActivity(), R.string.hhx, 0).show();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        QLog.d("ElderModeFragment", 1, "onBackEvent");
        zh();
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.F);
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
