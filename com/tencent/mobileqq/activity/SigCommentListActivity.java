package com.tencent.mobileqq.activity;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SigCommentListActivity extends IphoneTitleBarActivity implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.mobileqq.adapter.ah f177069a0;

    /* renamed from: b0, reason: collision with root package name */
    XListView f177070b0;

    /* renamed from: c0, reason: collision with root package name */
    View f177071c0;

    /* renamed from: d0, reason: collision with root package name */
    ImageView f177072d0;

    /* renamed from: e0, reason: collision with root package name */
    TextView f177073e0;

    /* renamed from: f0, reason: collision with root package name */
    Drawable f177074f0;

    /* renamed from: g0, reason: collision with root package name */
    private MqqWeakReferenceHandler f177075g0;

    /* renamed from: h0, reason: collision with root package name */
    com.tencent.mobileqq.app.da f177076h0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.app.da {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SigCommentListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.da
        protected void f(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (SigCommentListActivity.this.isResume()) {
                SigCommentListActivity.this.stopTitleProgress();
                if (z16) {
                    if (obj instanceof Bundle) {
                        SignatureManager.SigComments sigComments = (SignatureManager.SigComments) ((Bundle) obj).getSerializable("data");
                        boolean z17 = sigComments.isOver;
                        List<SignatureManager.SigCommentInfo> list = sigComments.mlist;
                        List<SignatureManager.SigCommentInfo> a16 = SigCommentListActivity.this.f177069a0.a();
                        if (list.size() > 0) {
                            if (a16 != null) {
                                a16.addAll(a16.size(), list);
                                SigCommentListActivity.this.f177069a0.d(a16, z17);
                            } else {
                                SigCommentListActivity.this.f177069a0.d(list, z17);
                            }
                            SigCommentListActivity.this.f177069a0.notifyDataSetChanged();
                            return;
                        }
                        if (a16 == null || a16.size() <= 0) {
                            SigCommentListActivity.this.I2(3);
                        } else {
                            SigCommentListActivity.this.f177069a0.d(a16, z17);
                        }
                        SigCommentListActivity.this.f177069a0.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                List<SignatureManager.SigCommentInfo> a17 = SigCommentListActivity.this.f177069a0.a();
                if (a17 == null || a17.size() <= 0) {
                    SigCommentListActivity.this.I2(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SigCommentListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SigCommentListActivity.this.J2(true, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SigCommentListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SigCommentListActivity.this.J2(true, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SigCommentListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f177076h0 = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(int i3) {
        if (i3 == 1) {
            try {
                this.f177073e0.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(R.color.skin_gray3)));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SigCommentListActivity", 2, e16.toString());
                }
            }
            this.f177073e0.setText(HardCodeUtil.qqStr(R.string.til));
            this.f177072d0.setImageDrawable(this.f177074f0);
            this.f177074f0.setVisible(true, true);
            return;
        }
        try {
            this.f177073e0.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(R.color.skin_gray3)));
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("SigCommentListActivity", 2, e17.toString());
            }
        }
        this.f177074f0.setVisible(false, false);
        this.f177072d0.setImageResource(R.drawable.h2c);
        if (i3 == 3) {
            this.f177073e0.setText(HardCodeUtil.qqStr(R.string.tim));
            return;
        }
        this.f177073e0.setText(HardCodeUtil.qqStr(R.string.tii));
        try {
            this.f177073e0.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(R.color.a3u)));
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.d("SigCommentListActivity", 2, e18.toString());
            }
        }
        this.f177073e0.setOnClickListener(new b());
        this.f177072d0.setOnClickListener(new c());
    }

    void H2() {
        if (getTitleBarView() != null) {
            getTitleBarView().setBackgroundResource(0);
            getTitleBarView().setBackgroundColor(-1);
        }
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (ThemeUtil.isInNightMode(getAppRuntime())) {
                if (!com.tencent.mobileqq.util.cu.g() && !com.tencent.mobileqq.util.cu.f()) {
                    systemBarComp.setStatusBarColor(-7829368);
                    return;
                } else {
                    systemBarComp.setStatusBarColor(-7829368);
                    systemBarComp.setStatusBarDarkMode(true);
                    return;
                }
            }
            if (!com.tencent.mobileqq.util.cu.g() && !com.tencent.mobileqq.util.cu.f()) {
                getWindow().getDecorView().setSystemUiVisibility(9216);
                systemBarComp.setStatusBarColor(-1);
            } else if (!com.tencent.mobileqq.util.cu.f()) {
                systemBarComp.setStatusBarColor(-2368549);
            } else {
                systemBarComp.setStatusBarColor(-1);
                systemBarComp.setStatusBarDarkMode(true);
            }
        }
    }

    public void J2(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        I2(1);
        if (NetworkUtil.isNetSupport(this)) {
            SignatureHandler signatureHandler = (SignatureHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
            if (signatureHandler != null) {
                signatureHandler.L2(z17);
            }
        } else {
            this.f177075g0.sendMessageDelayed(this.f177075g0.obtainMessage(1, 1, 0), 1000L);
            this.f177069a0.e(R.string.hmp);
        }
        if (z16) {
            startTitleProgress();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.bfb);
        super.setTitle(HardCodeUtil.qqStr(R.string.tij));
        this.leftView.setTextColor(getResources().getColor(R.color.black));
        this.leftView.setBackgroundDrawable(getResources().getDrawable(R.drawable.f160834no));
        this.centerView.setTextColor(getResources().getColor(R.color.black));
        H2();
        View inflate = LayoutInflater.from(this).inflate(R.layout.bz6, (ViewGroup) this.f177070b0, false);
        this.f177071c0 = inflate;
        this.f177072d0 = (ImageView) inflate.findViewById(R.id.bwg);
        this.f177073e0 = (TextView) this.f177071c0.findViewById(R.id.bwo);
        this.f177074f0 = getResources().getDrawable(R.drawable.common_loading6);
        XListView xListView = (XListView) findViewById(R.id.ivb);
        this.f177070b0 = xListView;
        xListView.setScrollbarFadingEnabled(true);
        this.f177070b0.setDivider(null);
        com.tencent.mobileqq.adapter.ah ahVar = new com.tencent.mobileqq.adapter.ah(this, this.app, this.f177070b0, this.f177071c0);
        this.f177069a0 = ahVar;
        this.f177070b0.setAdapter((ListAdapter) ahVar);
        MqqWeakReferenceHandler mqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
        this.f177075g0 = mqqWeakReferenceHandler;
        this.app.setHandler(SigCommentListActivity.class, mqqWeakReferenceHandler);
        com.tencent.mobileqq.app.da daVar = this.f177076h0;
        if (daVar != null) {
            this.app.addObserver(daVar);
        }
        this.f177075g0.sendMessageDelayed(this.f177075g0.obtainMessage(0, 1, 1), 500L);
        I2(1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.app.da daVar = this.f177076h0;
        if (daVar != null) {
            this.app.removeObserver(daVar);
            this.f177076h0 = null;
        }
        this.app.removeHandler(SigCommentListActivity.class);
        super.doOnDestroy();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        boolean z17 = false;
        if (i3 != 0) {
            if (i3 == 1) {
                stopTitleProgress();
                if (1 == message.arg1) {
                    if (isResume()) {
                        QQToast.makeText(this, 0, getResources().getString(R.string.hmq), 0).show(getTitleBarHeight());
                    }
                    I2(2);
                }
            }
        } else {
            if (message.arg1 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (message.arg2 == 1) {
                z17 = true;
            }
            J2(z16, z17);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
