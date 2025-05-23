package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes9.dex */
public class GesturePWDCreateActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    TextView f176112a0;

    /* renamed from: b0, reason: collision with root package name */
    LockPatternView f176113b0;

    /* renamed from: c0, reason: collision with root package name */
    Handler f176114c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f176115d0;

    /* renamed from: e0, reason: collision with root package name */
    int[] f176116e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f176117f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f176118g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f176119h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f176120i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f176121j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f176122k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f176123l0;

    /* renamed from: m0, reason: collision with root package name */
    private View f176124m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f176125n0;

    /* renamed from: o0, reason: collision with root package name */
    private ArrayList<View> f176126o0;

    /* renamed from: p0, reason: collision with root package name */
    int f176127p0;

    /* renamed from: q0, reason: collision with root package name */
    String f176128q0;

    public GesturePWDCreateActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176114c0 = new Handler();
        this.f176115d0 = false;
        this.f176116e0 = new int[9];
        this.f176126o0 = new ArrayList<>(9);
        this.f176127p0 = 0;
        this.f176128q0 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        finish();
    }

    private void K2() {
        ArrayList<View> arrayList;
        int color;
        int[] iArr = this.f176116e0;
        if (iArr != null && iArr.length == 9 && (arrayList = this.f176126o0) != null && arrayList.size() == 9) {
            for (int i3 = 0; i3 < this.f176116e0.length; i3++) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.f176126o0.get(i3).getBackground();
                if (this.f176116e0[i3] == 1) {
                    color = getResources().getColor(R.color.qui_common_feedback_normal);
                } else {
                    color = getResources().getColor(R.color.qui_common_fill_standard_secondary);
                }
                gradientDrawable.setColor(color);
            }
        }
    }

    private void L2() {
        if (this.f176116e0 == null) {
            this.f176116e0 = new int[9];
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f176116e0;
            if (i3 < iArr.length) {
                iArr[i3] = 0;
                i3++;
            } else {
                return;
            }
        }
    }

    private void initData() {
        this.f176127p0 = 0;
        this.f176115d0 = getIntent().getBooleanExtra(GesturePWDSettingActivity.KEY_GESTURE_RESET, false);
        L2();
    }

    private void initUI() {
        setTitle(R.string.f170992bi4);
        this.f176112a0 = (TextView) findViewById(R.id.ctd);
        LockPatternView lockPatternView = (LockPatternView) findViewById(R.id.ctc);
        this.f176113b0 = lockPatternView;
        lockPatternView.setFillInGapCell(false);
        this.f176113b0.setTactileFeedbackEnabled(true);
        this.f176113b0.setOnPatternListener(new LockPatternView.b() { // from class: com.tencent.mobileqq.activity.GesturePWDCreateActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GesturePWDCreateActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
            public void onPatternCellAdded(List<LockPatternView.a> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
                } else if (QLog.isColorLevel()) {
                    QLog.d("Q.gesturelock.creat", 2, "celladd.");
                }
            }

            @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
            public void onPatternCleared() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
            public void onPatternDetected(List<LockPatternView.a> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
                    return;
                }
                if (list != null) {
                    int i3 = GesturePWDCreateActivity.this.f176127p0;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            String encodeGesture = BaseGesturePWDUtil.encodeGesture(GesturePWDUtils.patternToString(list), GesturePWDCreateActivity.this.app.getCurrentAccountUin());
                            String str = GesturePWDCreateActivity.this.f176128q0;
                            if (str != null && encodeGesture != null && str.equals(encodeGesture)) {
                                GesturePWDCreateActivity gesturePWDCreateActivity = GesturePWDCreateActivity.this;
                                BaseGesturePWDUtil.setGesturePWD(gesturePWDCreateActivity, gesturePWDCreateActivity.app.getCurrentAccountUin(), GesturePWDCreateActivity.this.f176128q0);
                                GesturePWDCreateActivity gesturePWDCreateActivity2 = GesturePWDCreateActivity.this;
                                GesturePWDUtils.setGesturePWDState(gesturePWDCreateActivity2, gesturePWDCreateActivity2.app.getCurrentAccountUin(), 2);
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime != null) {
                                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C551", "0X800C551", 0, 0, "0", "", "", "");
                                }
                                GesturePWDCreateActivity gesturePWDCreateActivity3 = GesturePWDCreateActivity.this;
                                QQToast.makeText(gesturePWDCreateActivity3, 2, gesturePWDCreateActivity3.getString(R.string.bhx), 0).show(GesturePWDCreateActivity.this.getTitleBarHeight());
                                GesturePWDCreateActivity.this.f176114c0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.GesturePWDCreateActivity.1.3
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            GesturePWDCreateActivity.this.setResult(-1);
                                            GesturePWDCreateActivity.this.finish();
                                        }
                                    }
                                }, 300L);
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.gesturelock.creat", 2, "gesture lock create success...");
                                    return;
                                }
                                return;
                            }
                            GesturePWDCreateActivity.this.f176113b0.setDisplayMode(2);
                            GesturePWDCreateActivity.this.f176114c0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.GesturePWDCreateActivity.1.4
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        GesturePWDCreateActivity.this.f176113b0.c();
                                    }
                                }
                            }, 500L);
                            GesturePWDCreateActivity.this.f176112a0.setText(R.string.bhw);
                            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                            if (peekAppRuntime2 != null) {
                                ReportController.o(peekAppRuntime2, "dc00898", "", "", "0X800C551", "0X800C551", 0, 0, "1", "", "", "");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (list.size() >= 3) {
                        GesturePWDCreateActivity.this.M2(list);
                        GesturePWDCreateActivity.this.f176128q0 = BaseGesturePWDUtil.encodeGesture(GesturePWDUtils.patternToString(list), GesturePWDCreateActivity.this.app.getCurrentAccountUin());
                        GesturePWDCreateActivity.this.f176112a0.setText(R.string.bhv);
                        GesturePWDCreateActivity.this.f176114c0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.GesturePWDCreateActivity.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    GesturePWDCreateActivity.this.f176113b0.c();
                                }
                            }
                        }, 500L);
                        GesturePWDCreateActivity.this.f176127p0 = 1;
                        return;
                    }
                    GesturePWDCreateActivity.this.f176113b0.setDisplayMode(2);
                    GesturePWDCreateActivity gesturePWDCreateActivity4 = GesturePWDCreateActivity.this;
                    QQToast.makeText(gesturePWDCreateActivity4, 0, gesturePWDCreateActivity4.getString(R.string.bie), 0).show(GesturePWDCreateActivity.this.getTitleBarHeight());
                    GesturePWDCreateActivity.this.f176114c0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.GesturePWDCreateActivity.1.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                GesturePWDCreateActivity.this.f176113b0.c();
                            }
                        }
                    }, 500L);
                }
            }

            @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
            public void onPatternStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        if (this.mDensity <= 1.0d) {
            ViewGroup.LayoutParams layoutParams = this.f176113b0.getLayoutParams();
            float f16 = this.mDensity;
            layoutParams.height = (int) (f16 * 240.0f);
            layoutParams.width = (int) (f16 * 240.0f);
            this.f176113b0.setLayoutParams(layoutParams);
        }
        this.f176117f0 = findViewById(R.id.ctq);
        this.f176118g0 = findViewById(R.id.ctr);
        this.f176119h0 = findViewById(R.id.cts);
        this.f176120i0 = findViewById(R.id.ctt);
        this.f176121j0 = findViewById(R.id.ctu);
        this.f176122k0 = findViewById(R.id.ctv);
        this.f176123l0 = findViewById(R.id.ctw);
        this.f176124m0 = findViewById(R.id.ctx);
        this.f176125n0 = findViewById(R.id.cty);
        this.f176126o0.add(this.f176117f0);
        this.f176126o0.add(this.f176118g0);
        this.f176126o0.add(this.f176119h0);
        this.f176126o0.add(this.f176120i0);
        this.f176126o0.add(this.f176121j0);
        this.f176126o0.add(this.f176122k0);
        this.f176126o0.add(this.f176123l0);
        this.f176126o0.add(this.f176124m0);
        this.f176126o0.add(this.f176125n0);
    }

    void M2(List<LockPatternView.a> list) {
        int c16;
        L2();
        if (list != null) {
            for (LockPatternView.a aVar : list) {
                if (aVar != null && (c16 = (aVar.c() * 3) + aVar.b()) >= 0) {
                    int[] iArr = this.f176116e0;
                    if (c16 < iArr.length) {
                        iArr[c16] = 1;
                    }
                }
            }
        }
        K2();
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
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.f168007os);
        initData();
        initUI();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.f154442w, R.anim.f154458a7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f176115d0) {
            DialogUtil.createCustomDialog(this, 230, getString(R.string.f1380308g), getString(R.string.f1380208f), R.string.g3l, R.string.f1380108e, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.cw
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.cx
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GesturePWDCreateActivity.this.J2(dialogInterface, i3);
                }
            }).show();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
