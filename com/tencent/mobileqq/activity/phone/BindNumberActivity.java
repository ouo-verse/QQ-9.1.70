package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BindNumberActivity extends DialogBaseActivity implements View.OnClickListener, TextWatcher, CompoundButton.OnCheckedChangeListener, Handler.Callback, View.OnKeyListener, OnSizeChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected EditText f183725a0;

    /* renamed from: b0, reason: collision with root package name */
    protected CheckBox f183726b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Button f183727c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f183728d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String f183729e0;

    /* renamed from: f0, reason: collision with root package name */
    protected com.tencent.mobileqq.phonecontact.observer.b f183730f0;

    /* renamed from: g0, reason: collision with root package name */
    protected com.tencent.mobileqq.phonecontact.observer.b f183731g0;

    /* renamed from: h0, reason: collision with root package name */
    protected ar f183732h0;

    /* renamed from: i0, reason: collision with root package name */
    protected String f183733i0;

    /* renamed from: j0, reason: collision with root package name */
    protected TextView f183734j0;

    /* renamed from: k0, reason: collision with root package name */
    protected ViewGroup f183735k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f183736l0;

    /* renamed from: m0, reason: collision with root package name */
    protected boolean f183737m0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f183738n0;

    /* renamed from: o0, reason: collision with root package name */
    protected boolean f183739o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f183740p0;

    /* renamed from: q0, reason: collision with root package name */
    private final Handler f183741q0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f183742r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f183743s0;

    /* renamed from: t0, reason: collision with root package name */
    public QQCustomDialog f183744t0;

    /* renamed from: u0, reason: collision with root package name */
    public QQCustomDialog f183745u0;

    /* renamed from: v0, reason: collision with root package name */
    public QQCustomDialog f183746v0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                BindNumberActivity.this.Q2();
                dialogInterface.dismiss();
                Intent intent = BindNumberActivity.this.getIntent();
                if (intent.getBooleanExtra("kFPhoneChange", false)) {
                    BindNumberActivity.this.S2("CliOper", "0X8005DE9", 1);
                }
                if (intent.getBooleanExtra("kUnityOther", false)) {
                    BindNumberActivity.this.S2("CliOper", "0X8005DE9", 2);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                BindNumberActivity.this.U2();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.phonecontact.observer.b
        public void onCancelBind(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            super.onCancelBind(z16);
            if (z16) {
                BindNumberActivity.this.f183741q0.sendEmptyMessage(3);
            } else {
                BindNumberActivity.this.dismissProgressDialog();
                BindNumberActivity.this.showToast(R.string.h1y);
            }
            BindNumberActivity bindNumberActivity = BindNumberActivity.this;
            bindNumberActivity.app.unRegistObserver(bindNumberActivity.f183731g0);
            BindNumberActivity.this.f183731g0 = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onBindMobile(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            BindNumberActivity bindNumberActivity = BindNumberActivity.this;
            bindNumberActivity.f183742r0 = false;
            bindNumberActivity.V2();
            BindNumberActivity.this.dismissProgressDialog();
            if (z16) {
                String X = ac.X();
                if (!TextUtils.isEmpty(X)) {
                    ReportController.o(BindNumberActivity.this.app, "dc00898", "", "", X, X, 0, 0, "", "", "", "");
                }
                int i3 = bundle.getInt(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT);
                if (bundle.getBoolean(com.tencent.mobileqq.phonecontact.observer.b.KEY_AUTO_BIND, false)) {
                    BindNumberActivity.this.K2();
                } else if (i3 != 104 && i3 != 0) {
                    if (i3 == 107) {
                        BindNumberActivity.this.R2(bundle);
                        return;
                    }
                    if (i3 == 106) {
                        BindNumberActivity.this.P2(null, 2);
                    } else if (i3 == 227) {
                        BindNumberActivity.this.onMobileBindUinNotSetPasswordError();
                    } else if (i3 == 226) {
                        BindNumberActivity.this.onUinNotSetPasswordError();
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("BindNumberActivity", 2, "bind error " + i3);
                        }
                        BindNumberActivity.this.showToast(getBindErrorMessage(i3));
                    }
                } else {
                    BindNumberActivity.this.gotoBindVerify();
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("BindNumberActivity", 2, "onBindMobile failed");
                }
                BindNumberActivity.this.showToast(R.string.h1y);
            }
            ac.d();
            BindNumberActivity bindNumberActivity2 = BindNumberActivity.this;
            bindNumberActivity2.app.unRegistObserver(bindNumberActivity2.f183730f0);
            BindNumberActivity.this.f183730f0 = null;
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onRebindMobile(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            BindNumberActivity.this.dismissProgressDialog();
            if (z16) {
                BindNumberActivity.this.gotoBindVerify();
            } else {
                BindNumberActivity.this.showToast(R.string.h1y);
            }
            BindNumberActivity bindNumberActivity = BindNumberActivity.this;
            bindNumberActivity.app.unRegistObserver(bindNumberActivity.f183730f0);
            BindNumberActivity.this.f183730f0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BindNumberActivity", 2, "new user guild confirm unbind");
            }
            BindNumberActivity.this.S2("dc00898", "0X8009F16", 0);
            BindNumberActivity bindNumberActivity = BindNumberActivity.this;
            bindNumberActivity.mPhoneContactService.sendRebindMobile(bindNumberActivity.f183728d0, bindNumberActivity.f183733i0, 0, bindNumberActivity.f183736l0, bindNumberActivity.f183737m0);
            BindNumberActivity.this.showProgressDialog(R.string.hex, 1000L, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            BindNumberActivity.this.S2("dc00898", "0X8009F15", 0);
            dialogInterface.dismiss();
            BindNumberActivity.this.U2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            EditText editText = BindNumberActivity.this.f183725a0;
            if (editText != null) {
                editText.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            EditText editText = BindNumberActivity.this.f183725a0;
            if (editText != null) {
                editText.setText("");
            }
        }
    }

    public BindNumberActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183728d0 = "+86";
        this.f183729e0 = HardCodeUtil.qqStr(R.string.k1m);
        this.f183736l0 = false;
        this.f183737m0 = false;
        this.f183738n0 = false;
        this.f183740p0 = false;
        this.f183741q0 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f183742r0 = false;
        this.f183743s0 = -1;
    }

    private void L2() {
        if (this.f183737m0) {
            S2("dc00898", "0X8009EC3", 0);
        }
        S2("dc00898", "0X8009F12", 0);
        if (this.f183739o0) {
            if (this.f183744t0 == null) {
                this.f183744t0 = DialogUtil.createCustomDialog(this, 230, (String) null, HardCodeUtil.qqStr(R.string.k1v), getString(R.string.cancel), getString(R.string.f171151ok), new a(), new b());
            }
            QQCustomDialog qQCustomDialog = this.f183744t0;
            if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !isFinishing()) {
                this.f183744t0.show();
                return;
            }
            return;
        }
        Q2();
    }

    private void M2(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, String.format("finish2 [%s]", Integer.valueOf(i3)));
        }
        super.finish();
        if (N2()) {
            overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2() {
        String trim = this.f183725a0.getText().toString().trim();
        this.f183733i0 = trim;
        if (TextUtils.isEmpty(trim)) {
            showToast(HardCodeUtil.qqStr(R.string.k1w));
            return;
        }
        if (this.f183728d0.equalsIgnoreCase("+86") && this.f183733i0.length() != 11) {
            showToast(R.string.f171164ct1);
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
        } else if (this.f183739o0) {
            this.f183741q0.sendEmptyMessage(0);
        } else {
            this.f183741q0.sendEmptyMessage(2);
        }
    }

    private void T2(String str, String str2) {
        String str3 = str + " " + str2;
        Rect rect = new Rect();
        this.f183734j0.getPaint().getTextBounds(str3, 0, str3.length(), rect);
        if (rect.right > getResources().getDimensionPixelSize(R.dimen.f159251yk) - (getResources().getDimensionPixelSize(R.dimen.f159250yj) * 2)) {
            this.f183734j0.setText(str2);
        } else {
            this.f183734j0.setText(str3);
        }
        if (AppSetting.f99565y) {
            this.f183734j0.setContentDescription(((Object) this.f183734j0.getText()) + HardCodeUtil.qqStr(R.string.k1o));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2() {
        this.f183725a0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.BindNumberActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!BindNumberActivity.this.isFinishing()) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                    BindNumberActivity.this.f183725a0.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, 0.0f, 0.0f, 0);
                    BindNumberActivity.this.f183725a0.dispatchTouchEvent(obtain2);
                    obtain2.recycle();
                    EditText editText = BindNumberActivity.this.f183725a0;
                    editText.setSelection(editText.getText().toString().length());
                }
            }
        }, 300L);
    }

    protected void J2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        int i3 = this.f183743s0;
        int i16 = 0;
        if (i3 != 10 && i3 != 11 && i3 != 15 && i3 != 17 && i3 != 1 && i3 != 12 && i3 != 14) {
            z16 = false;
        } else {
            z16 = true;
        }
        List<String> list = null;
        if (!z16) {
            W2(0, null);
            return;
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null) {
            Object[] friendHasBindPhone = iPhoneContactService.getFriendHasBindPhone();
            i16 = ((Integer) friendHasBindPhone[0]).intValue();
            list = (List) friendHasBindPhone[1];
        }
        W2(i16, list);
        if (this.f183732h0 == null) {
            ar arVar = new ar() { // from class: com.tencent.mobileqq.activity.phone.BindNumberActivity.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BindNumberActivity.this);
                    }
                }

                @Override // com.tencent.mobileqq.app.ar
                public void onGetFriendsHasBindPhone(boolean z17, int i17, List<String> list2) {
                    Object valueOf;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z17), Integer.valueOf(i17), list2);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(z17);
                        objArr[1] = Integer.valueOf(i17);
                        if (list2 == null) {
                            valueOf = "null";
                        } else {
                            valueOf = Integer.valueOf(list2.size());
                        }
                        objArr[2] = valueOf;
                        QLog.i("BindNumberActivity", 2, String.format("onGetFriendsHasBindPhone [%s, %s, %s]", objArr));
                    }
                    if (z17) {
                        BindNumberActivity.this.runOnUiThread(new Runnable(i17, list2) { // from class: com.tencent.mobileqq.activity.phone.BindNumberActivity.10.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f183748d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ List f183749e;

                            {
                                this.f183748d = i17;
                                this.f183749e = list2;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass10.this, Integer.valueOf(i17), list2);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    BindNumberActivity.this.W2(this.f183748d, this.f183749e);
                                }
                            }
                        });
                    }
                    BindNumberActivity bindNumberActivity = BindNumberActivity.this;
                    bindNumberActivity.app.removeObserver(bindNumberActivity.f183732h0);
                    BindNumberActivity.this.f183732h0 = null;
                }
            };
            this.f183732h0 = arVar;
            this.app.addObserver(arVar);
        }
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler != null) {
            friendListHandler.getFriendsHasBindPhone(3);
        }
    }

    protected void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (this.f183743s0 == 10) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 1);
            aliasIntent.setFlags(603979776);
            startActivity(aliasIntent);
        } else {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
            RespondQueryQQBindingStat selfBindInfo = iPhoneContactService.getSelfBindInfo();
            if (!iPhoneContactService.isAutoUploadContacts() && selfBindInfo != null && !selfBindInfo.isStopFindMatch) {
                Intent intent = new Intent(this, (Class<?>) PhoneMatchActivity.class);
                intent.putExtra("key_from_contact_first", true);
                startActivity(intent);
            }
        }
        setResult(-1);
        M2(3);
    }

    protected boolean N2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (!this.f183740p0 && (i3 = this.f183743s0) != 9 && i3 != 11 && i3 != 10) {
            return false;
        }
        return true;
    }

    protected void P2(Intent intent, int i3) {
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) intent, i3);
            return;
        }
        Intent intent2 = new Intent();
        if (intent == null) {
            stringExtra = null;
        } else {
            stringExtra = intent.getStringExtra("check_permission_result");
        }
        if (QLog.isColorLevel()) {
            QLog.i("BindMsgConstant", 2, "onBindSuc src: " + this.f183743s0 + ", per: " + stringExtra);
        }
        int i16 = this.f183743s0;
        if (i16 == 10) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 1);
            aliasIntent.setFlags(603979776);
            startActivity(aliasIntent);
        } else if (i16 != 21) {
            if (i16 == 22) {
                QQToast.makeText(this, R.string.f174032ur, 1).show();
            } else if (this.f183738n0) {
                Intent intent3 = new Intent(this, (Class<?>) PhoneUnityBindInfoActivity.class);
                intent3.putExtra("kSrouce", this.f183743s0);
                intent3.putExtra("kBindNew", true);
                startActivity(intent3);
            } else if (!"permission_denied".equals(stringExtra) && !"permission_denied_by_user".equals(stringExtra)) {
                if ("permission_granted".equals(stringExtra)) {
                    ContactBindedActivity.U2(this.app, this.f183743s0, 1, intent2);
                    intent2.putExtra("check_permission_result", stringExtra);
                }
            } else {
                intent2.putExtra("check_permission_result", stringExtra);
                Intent intent4 = new Intent(this, (Class<?>) GuideBindPhoneActivity.class);
                intent4.putExtra("kSrouce", this.f183743s0);
                intent4.putExtra("fromKeyForContactBind", 1);
                startActivity(intent4);
            }
        }
        setResult(-1, intent2);
        M2(i3);
        if (this.f183737m0) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009EC4", "0X8009EC4", 0, 0, "", "", "", "");
        }
    }

    protected void R2(Bundle bundle) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) bundle);
            return;
        }
        S2("dc00898", "0X8009F14", 0);
        String string = bundle.getString(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN);
        if (TextUtils.isEmpty(this.f183728d0)) {
            str = this.f183733i0;
        } else {
            str = this.f183728d0 + " " + this.f183733i0;
        }
        String string2 = getResources().getString(R.string.f171166ct4, str, string, this.app.getCurrentAccountUin());
        int indexOf = string2.indexOf(str);
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), indexOf, str.length() + indexOf, 17);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, (String) null, spannableString, getString(R.string.cancel), getString(R.string.f171151ok), new e(), new f());
        if (createCustomDialog != null && !createCustomDialog.isShowing() && !isFinishing()) {
            createCustomDialog.show();
        }
    }

    public void S2(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, str, str2, Integer.valueOf(i3));
        } else {
            ReportController.o(this.app, str, "", "", str2, str2, i3, 0, "", "", "", "");
        }
    }

    protected void V2() {
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Button button = this.f183727c0;
        if (button != null && (editText = this.f183725a0) != null) {
            boolean z16 = false;
            if (this.f183742r0) {
                button.setEnabled(false);
                return;
            }
            if (editText.getText().toString().trim().length() > 0 && this.f183726b0.isChecked()) {
                z16 = true;
            }
            this.f183727c0.setEnabled(z16);
        }
    }

    protected void W2(int i3, List<String> list) {
        String str;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i3);
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            objArr[1] = valueOf;
            QLog.i("BindNumberActivity", 2, String.format("updateFrdInPhoneContact [%s, %s]", objArr));
        }
        View findViewById = this.f183735k0.findViewById(R.id.cle);
        if (i3 >= 10 && list != null && list.size() >= 3) {
            findViewById.setVisibility(0);
            ((TextView) findViewById.findViewById(R.id.f166398f81)).setText(String.format(getString(R.string.csn), Integer.valueOf(i3)));
            int[] iArr = {R.id.d2q, R.id.d2r, R.id.d2s};
            for (int i16 = 0; i16 < 3; i16++) {
                ImageView imageView = (ImageView) findViewById.findViewById(iArr[i16]);
                if (imageView != null) {
                    if (i16 < list.size()) {
                        str = list.get(i16);
                    } else {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        imageView.setVisibility(8);
                    } else {
                        imageView.setVisibility(0);
                        imageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, str));
                        if (imageView instanceof ThemeImageView) {
                            ((ThemeImageView) imageView).setSupportMaskView(true);
                        }
                    }
                }
            }
            return;
        }
        findViewById.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) editable);
        } else {
            V2();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1) {
            if (i16 == -1) {
                this.f183729e0 = intent.getStringExtra("k_name");
                String str = Marker.ANY_NON_NULL_MARKER + intent.getStringExtra("k_code");
                this.f183728d0 = str;
                T2(this.f183729e0, str);
                return;
            }
            return;
        }
        if (i3 == 2 && i16 != 0) {
            setResult(i16, intent);
            if (i16 == -1) {
                P2(intent, 3);
                int i17 = this.f183743s0;
                if (i17 == 7) {
                    ReportController.o(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
                } else if (i17 == 12) {
                    ReportController.o(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
                }
                if (this.f183743s0 == 11) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            M2(3);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        int i3 = this.f183743s0;
        boolean z16 = false;
        if (i3 != 10 && i3 != 11) {
            if (getIntent().getBooleanExtra("k_is_block", false)) {
                ReportController.o(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
            }
            super.doOnBackPressed();
        } else {
            if (i3 == 10) {
                z16 = true;
            }
            showConfirmSkipDialog(z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        BounceScrollView bounceScrollView;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f183743s0 = getIntent().getIntExtra("kSrouce", -1);
        this.f183739o0 = getIntent().getBooleanExtra("kNeedUnbind", false);
        this.f183740p0 = getIntent().getBooleanExtra("key_is_modal_pop", false);
        this.f183736l0 = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
        this.f183737m0 = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
        this.f183738n0 = getIntent().getBooleanExtra("kUnityWebBind", false);
        if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, String.format("onCreate [%s, %s, %s]", Boolean.valueOf(this.f183736l0), Boolean.valueOf(this.f183737m0), Integer.valueOf(this.f183743s0)));
        }
        getWindow().setSoftInputMode(18);
        setContentView(R.layout.f168360tu);
        if ((!Build.MANUFACTURER.equalsIgnoreCase("Letv") || !DeviceInfoMonitor.getModel().equalsIgnoreCase("X900+")) && (bounceScrollView = (BounceScrollView) findViewById(R.id.adt)) != null) {
            bounceScrollView.setOnSizeChangeListener(this);
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f7z);
        this.f183735k0 = viewGroup;
        viewGroup.getRootView().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_texture));
        Resources resources = getResources();
        if (this.f183737m0) {
            string = resources.getString(R.string.csq);
        } else {
            int i16 = this.f183743s0;
            if (i16 != 12 && i16 != 14) {
                string = resources.getString(R.string.csp);
            } else {
                string = resources.getString(R.string.cso);
            }
        }
        setTitle("", "");
        if (N2()) {
            setLeftButton(R.string.close, (View.OnClickListener) null);
            TextView textView = this.leftViewNotBack;
            if (textView != null) {
                textView.setVisibility(8);
            }
            setRightButton(R.string.close, this);
        } else {
            setLeftViewName(R.string.f170549u3);
        }
        ((TextView) findViewById(R.id.f166399f82)).setText(string);
        String string2 = resources.getString(R.string.csl);
        if (this.f183737m0) {
            string2 = resources.getString(R.string.csm);
        }
        ((TextView) findViewById(R.id.f166397f80)).setText(string2);
        J2();
        String b16 = PhoneCodeUtils.b(this);
        if (!"86".equals(b16)) {
            this.f183729e0 = "";
            this.f183728d0 = '+' + b16;
        }
        TextView textView2 = (TextView) findViewById(R.id.baq);
        this.f183734j0 = textView2;
        textView2.setOnClickListener(this);
        T2(this.f183729e0, this.f183728d0);
        CheckBox checkBox = (CheckBox) findViewById(R.id.juo);
        this.f183726b0 = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        this.f183726b0.setContentDescription(HardCodeUtil.qqStr(R.string.k1x));
        EditText editText = (EditText) findViewById(R.id.fcb);
        this.f183725a0 = editText;
        editText.addTextChangedListener(this);
        this.f183725a0.setSingleLine();
        this.f183725a0.setText(this.f183733i0);
        if (!TextUtils.isEmpty(this.f183733i0)) {
            this.f183725a0.setSelection(this.f183733i0.length());
        }
        this.f183725a0.requestFocus();
        this.f183725a0.setOnKeyListener(this);
        Button button = (Button) findViewById(R.id.b5c);
        this.f183727c0 = button;
        button.setOnClickListener(this);
        V2();
        findViewById(R.id.jup).setOnClickListener(this);
        findViewById(R.id.jur).setOnClickListener(this);
        int i17 = this.f183743s0;
        if (i17 != -1) {
            if (i17 != 1) {
                if (i17 != 9) {
                    if (i17 != 17) {
                        if (i17 != 11) {
                            if (i17 != 12) {
                                if (i17 != 14) {
                                    if (i17 != 15) {
                                        i3 = 0;
                                    }
                                }
                            } else {
                                i3 = 3;
                            }
                        }
                    }
                    i3 = 4;
                }
                i3 = 5;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 6;
        }
        S2("dc00898", "0X8009F11", i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.f183730f0;
        if (bVar != null) {
            this.app.unRegistObserver(bVar);
            this.f183730f0 = null;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar2 = this.f183731g0;
        if (bVar2 != null) {
            this.app.unRegistObserver(bVar2);
            this.f183731g0 = null;
        }
        ar arVar = this.f183732h0;
        if (arVar != null) {
            this.app.removeObserver(arVar);
            this.f183732h0 = null;
        }
        QQCustomDialog qQCustomDialog = this.f183744t0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f183744t0 = null;
        }
        QQCustomDialog qQCustomDialog2 = this.f183745u0;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.dismiss();
            this.f183745u0 = null;
        }
        QQCustomDialog qQCustomDialog3 = this.f183746v0;
        if (qQCustomDialog3 != null) {
            qQCustomDialog3.dismiss();
            this.f183746v0 = null;
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        if (TextUtils.isEmpty(this.f183733i0)) {
            U2();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            M2(0);
        }
    }

    protected void gotoBindVerify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) BindVerifyActivity.class);
        intent.putExtra("kSrouce", this.f183743s0);
        intent.putExtra("kBindType", 0);
        intent.putExtra("keyReqBindMode", 0);
        intent.putExtra("k_number", this.f183733i0);
        intent.putExtra("k_country_code", this.f183728d0);
        intent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
        intent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
        intent.putExtra("cmd_param_is_from_uni", this.f183736l0);
        intent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
        intent.putExtra("cmd_param_is_from_change_bind", this.f183737m0);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        if (!isFinishing()) {
            startActivityForResult(intent, 2);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4) {
                    this.f183741q0.removeMessages(4);
                    BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.adt);
                    if (bounceScrollView != null) {
                        bounceScrollView.fullScroll(130);
                    }
                } else {
                    throw new RuntimeException("Unknown message: " + message.what);
                }
            } else {
                if (this.f183730f0 == null) {
                    d dVar = new d();
                    this.f183730f0 = dVar;
                    this.app.registObserver(dVar);
                }
                this.f183742r0 = true;
                V2();
                this.mPhoneContactService.sendBindMobile(this.f183728d0, this.f183733i0, 0, this.f183736l0, this.f183737m0);
                if (3 != message.what) {
                    showProgressDialog(R.string.hex, 1000L, true);
                }
            }
        } else {
            if (this.f183731g0 == null) {
                c cVar = new c();
                this.f183731g0 = cVar;
                this.app.registObserver(cVar);
            }
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
            showProgressDialog(R.string.hex, 1000L, true);
            iPhoneContactService.unbindMobile(this.f183736l0, this.f183737m0);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    protected boolean onBackEvent() {
        InputMethodManager inputMethodManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        int i3 = this.f183743s0;
        boolean z16 = false;
        if (i3 != 10 && i3 != 11) {
            S2("dc00898", "0X8009F13", 0);
            Intent intent = new Intent();
            intent.putExtra("key_user_cancel", 1);
            setResult(0, intent);
            if (this.f183725a0 != null && (inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f183725a0.getWindowToken(), 0);
            }
            finish();
            return true;
        }
        if (i3 == 10) {
            z16 = true;
        }
        showConfirmSkipDialog(z16);
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, compoundButton, Boolean.valueOf(z16));
        } else {
            if (this.f183726b0.isChecked()) {
                this.f183726b0.setContentDescription(HardCodeUtil.qqStr(R.string.k1y));
            } else {
                this.f183726b0.setContentDescription(HardCodeUtil.qqStr(R.string.k1u));
            }
            V2();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            boolean z16 = true;
            if (id5 == R.id.baq) {
                startActivityForResult(new Intent(this, (Class<?>) CountryActivity.class), 1);
            } else if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.ivTitleBtnLeftButton && id5 != R.id.ivTitleBtnRightText) {
                if (id5 == R.id.b5c) {
                    L2();
                } else if (id5 == R.id.jur) {
                    Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", "https://qq-web.cdn-go.cn/agreement/latest/mqq/bindphone.html");
                    startActivity(intent);
                } else if (id5 == R.id.jup) {
                    this.f183726b0.setChecked(!r0.isChecked());
                } else {
                    this.app.logout(true);
                    RouteUtils.startActivity(this, new Intent(), RouterConstants.UI_ROUTER_LOGIN);
                    M2(1);
                    S2("CliOper", "0X80053D3", 0);
                }
            } else {
                int i3 = this.f183743s0;
                if (i3 != 10 && i3 != 11) {
                    setResult(0);
                    finish();
                } else {
                    if (i3 != 10) {
                        z16 = false;
                    }
                    showConfirmSkipDialog(z16);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
        }
        if (view != this.f183725a0 || 66 != i3 || keyEvent.getAction() != 0) {
            return false;
        }
        Q2();
        return true;
    }

    protected void onMobileBindUinNotSetPasswordError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
        if (this.f183745u0 == null) {
            this.f183745u0 = DialogUtil.createCustomDialog(this, 230, (String) null, "\u8be5\u624b\u673a\u53f7\u7801\u5df2\u7ed1\u5b9a\u4e00\u4e2a\u65e0\u5bc6\u7801\u7684QQ\u53f7\uff0c\u9700\u7ed9\u539fQQ\u53f7\u8bbe\u7f6e\u5bc6\u7801\u540e\u624d\u80fd\u89e3\u7ed1\u5e76\u7ed1\u5b9a\u65b0QQ\u53f7\u3002", (String) null, HardCodeUtil.qqStr(R.string.k1n), new g(), (DialogInterface.OnClickListener) null);
        }
        QQCustomDialog qQCustomDialog = this.f183745u0;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !isFinishing()) {
            this.f183745u0.show();
        }
    }

    @Override // com.tencent.widget.OnSizeChangeListener
    public void onSizeChanged(int i3, int i16, int i17, int i18, boolean z16, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19));
        } else if (i16 > 0 && i18 > 0 && i16 < i18 && i3 == i17) {
            this.f183741q0.sendEmptyMessageDelayed(4, 100L);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    protected void onUinNotSetPasswordError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8005B77", "0X8005B77", 0, 0, "", "", "", "");
        if (this.f183746v0 == null) {
            this.f183746v0 = DialogUtil.createCustomDialog(this, 230, (String) null, HardCodeUtil.qqStr(R.string.k1t), (String) null, HardCodeUtil.qqStr(R.string.k1r), new h(), (DialogInterface.OnClickListener) null);
        }
        QQCustomDialog qQCustomDialog = this.f183746v0;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !isFinishing()) {
            this.f183746v0.show();
        }
    }
}
