package com.tencent.mobileqq.ocr.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OCRTextSearchActivity extends QBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    d f254778a0;

    /* renamed from: b0, reason: collision with root package name */
    RelativeLayout f254779b0;

    /* renamed from: c0, reason: collision with root package name */
    EditText f254780c0;

    /* renamed from: d0, reason: collision with root package name */
    ImageButton f254781d0;

    /* renamed from: e0, reason: collision with root package name */
    ImageView f254782e0;

    /* renamed from: f0, reason: collision with root package name */
    View f254783f0;

    /* renamed from: g0, reason: collision with root package name */
    LinearLayout f254784g0;

    /* renamed from: h0, reason: collision with root package name */
    RelativeLayout f254785h0;

    /* renamed from: i0, reason: collision with root package name */
    View f254786i0;

    /* renamed from: j0, reason: collision with root package name */
    FragmentManager f254787j0;

    /* renamed from: k0, reason: collision with root package name */
    SearchResultFragment f254788k0;

    /* renamed from: l0, reason: collision with root package name */
    String f254789l0;

    /* renamed from: m0, reason: collision with root package name */
    String f254790m0;

    /* renamed from: n0, reason: collision with root package name */
    String f254791n0;

    /* renamed from: o0, reason: collision with root package name */
    com.tencent.mobileqq.ocr.c f254792o0;

    /* renamed from: p0, reason: collision with root package name */
    InputMethodManager f254793p0;

    /* renamed from: q0, reason: collision with root package name */
    private e f254794q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f254795r0;

    /* renamed from: s0, reason: collision with root package name */
    public BaseOCRTextSearchFragment.b f254796s0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.ocr.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRTextSearchActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.ocr.c
        public void b(int i3, String str, OCRTextSearchInfo.c cVar) {
            String str2;
            List<OCRTextSearchInfo.a> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, cVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.OCRTextSearchActivity", 2, "onGetTextSearchResult, errorCode=" + i3 + ", sessionID=" + str + ", mSessionId=" + OCRTextSearchActivity.this.f254791n0);
            }
            if (str != null && (str2 = OCRTextSearchActivity.this.f254791n0) != null && str2.equals(str)) {
                OCRTextSearchActivity.this.P2(false);
                OCRTextSearchActivity oCRTextSearchActivity = OCRTextSearchActivity.this;
                if (oCRTextSearchActivity.f254788k0 == null) {
                    oCRTextSearchActivity.G2(1);
                }
                OCRTextSearchActivity oCRTextSearchActivity2 = OCRTextSearchActivity.this;
                SearchResultFragment searchResultFragment = oCRTextSearchActivity2.f254788k0;
                if (searchResultFragment != null) {
                    searchResultFragment.ph(oCRTextSearchActivity2.f254780c0.getText().toString(), i3, cVar);
                }
                OCRTextSearchActivity.this.M2(1);
                if (i3 == 0 && (list = cVar.f254553a) != null && list.size() > 0) {
                    ReportController.o(null, "dc00898", "", "", "0X80082E8", "0X80082E8", 0, 0, "", "", "", "");
                    return;
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X80082E7", "0X80082E7", 0, 0, "", "", "", "");
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.OCRTextSearchActivity", 2, "onGetTextSearchResult, session error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRTextSearchActivity.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else if (i3 == 3 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
                OCRTextSearchActivity.this.I2();
                EditText editText = OCRTextSearchActivity.this.f254780c0;
                editText.setSelection(editText.getText().length());
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements BaseOCRTextSearchFragment.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRTextSearchActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                OCRTextSearchActivity.this.f254778a0.a(z16);
            }
        }

        @Override // com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment.b
        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
                return;
            }
            if (view == null) {
                OCRTextSearchActivity oCRTextSearchActivity = OCRTextSearchActivity.this;
                oCRTextSearchActivity.f254793p0.hideSoftInputFromWindow(oCRTextSearchActivity.f254780c0.getWindowToken(), 0);
            } else {
                OCRTextSearchActivity.this.f254793p0.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            OCRTextSearchActivity.this.f254780c0.clearFocus();
            OCRTextSearchActivity.this.f254780c0.setCursorVisible(false);
            c(OCRTextSearchActivity.this.f254780c0.getText().toString().trim());
            EditText editText = OCRTextSearchActivity.this.f254780c0;
            editText.setSelection(editText.getText().length());
        }

        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                OCRTextSearchActivity.this.L2(str);
            }
        }

        @Override // com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment.b
        public Activity getActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return OCRTextSearchActivity.this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class d extends FlingGestureHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f254800d;

        public d(Activity activity) {
            super(activity);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            } else {
                this.f254800d = true;
            }
        }

        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
                return;
            }
            this.f254800d = z16;
            if (!isWrapped()) {
                wrap();
            }
            this.mTopLayout.setInterceptTouchFlag(z16);
        }

        @Override // com.tencent.mobileqq.activity.fling.FlingGestureHandler, com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
        public void flingLToR() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (this.f254800d) {
                super.flingLToR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements TextWatcher {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRTextSearchActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) editable);
            } else {
                OCRTextSearchActivity.this.J2(OCRTextSearchActivity.this.f254780c0.getText().toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    public OCRTextSearchActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f254788k0 = null;
        this.f254792o0 = new a();
        this.f254793p0 = null;
        this.f254794q0 = new e();
        this.f254795r0 = 0;
        this.f254796s0 = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2() {
        String str;
        if (this.f254780c0.getText() != null) {
            str = this.f254780c0.getText().toString();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f254780c0.getHint().toString();
        }
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return;
        }
        this.f254789l0 = null;
        K2(trim);
        P2(true);
        ReportController.o(null, "dc00898", "", "", "0X80082EE", "0X80082EE", 0, 0, "", "", "", "");
    }

    public static void Q2(QBaseActivity qBaseActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(qBaseActivity, (Class<?>) OCRTextSearchActivity.class);
        intent.putExtra("keyWord", str);
        qBaseActivity.startActivity(intent);
        qBaseActivity.overridePendingTransition(0, 0);
        com.tencent.qqperf.opt.threadpriority.b.k(false);
    }

    void G2(int i3) {
        if (i3 == 1 && this.f254788k0 == null) {
            this.f254788k0 = new SearchResultFragment();
            FragmentTransaction beginTransaction = this.f254787j0.beginTransaction();
            beginTransaction.add(R.id.result_layout, this.f254788k0, "search_result");
            beginTransaction.commitAllowingStateLoss();
        }
    }

    void H2(int i3) {
        if (i3 == 1) {
            this.f254783f0.setVisibility(8);
            if (this.f254787j0.findFragmentByTag("search_result") == null) {
                G2(i3);
            }
            FragmentTransaction beginTransaction = this.f254787j0.beginTransaction();
            beginTransaction.hide(this.f254788k0);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    protected void J2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else if (str.equals("")) {
            this.f254781d0.setVisibility(8);
        } else {
            this.f254781d0.setVisibility(0);
        }
    }

    public void K2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        IOCRService iOCRService = (IOCRService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOCRService.class, "");
        String generateTextSearchSessionID = iOCRService.generateTextSearchSessionID();
        this.f254791n0 = generateTextSearchSessionID;
        iOCRService.doSougouSearch(generateTextSearchSessionID, str, SystemClock.elapsedRealtime());
        this.f254790m0 = str;
    }

    protected void L2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f254781d0.setVisibility(0);
        this.f254780c0.removeTextChangedListener(this.f254794q0);
        this.f254780c0.setText(str);
        EditText editText = this.f254780c0;
        editText.setSelection(editText.getText().length());
        this.f254780c0.addTextChangedListener(this.f254794q0);
    }

    protected void M2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (isFinishing()) {
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                N2(1);
                this.f254795r0 = 1;
                return;
            }
            return;
        }
        H2(1);
        this.f254795r0 = 0;
        SearchResultFragment searchResultFragment = this.f254788k0;
        if (searchResultFragment != null) {
            searchResultFragment.reset();
        }
    }

    void N2(int i3) {
        if (i3 == 1) {
            this.f254783f0.setVisibility(0);
            if (this.f254787j0.findFragmentByTag("search_result") == null) {
                G2(i3);
            }
            FragmentTransaction beginTransaction = this.f254787j0.beginTransaction();
            beginTransaction.show(this.f254788k0);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    protected void P2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f254780c0.clearFocus();
            this.f254780c0.setCursorVisible(false);
            M2(0);
            this.f254784g0.setVisibility(0);
            this.f254781d0.setEnabled(false);
            this.f254780c0.setEnabled(false);
            return;
        }
        this.f254784g0.setVisibility(8);
        this.f254781d0.setEnabled(true);
        this.f254780c0.setEnabled(true);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
            return;
        }
        super.doOnConfigurationChanged(configuration);
        d dVar = this.f254778a0;
        if (dVar != null) {
            dVar.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f254787j0 = getSupportFragmentManager();
        setContentView(R.layout.ayq);
        findViews();
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return true;
        }
        initObserver();
        M2(this.f254795r0);
        String stringExtra = intent.getStringExtra("keyWord");
        if (!TextUtils.isEmpty(stringExtra)) {
            L2(stringExtra);
            K2(stringExtra);
            P2(true);
            this.f254795r0 = 1;
        }
        d dVar = new d(this);
        this.f254778a0 = dVar;
        dVar.a(false);
        if (bundle != null) {
            this.f254788k0 = (SearchResultFragment) this.f254787j0.findFragmentByTag("search_result");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof AppInterface) {
            ((AppInterface) waitAppRuntime).removeObserver(this.f254792o0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        String stringExtra = intent.getStringExtra("keyWord");
        if (!TextUtils.isEmpty(stringExtra)) {
            L2(stringExtra);
            K2(stringExtra);
            P2(true);
            this.f254795r0 = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(9)
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.f254795r0 == 0) {
            super.getWindow().setSoftInputMode(36);
            this.f254780c0.setCursorVisible(true);
        } else {
            super.getWindow().setSoftInputMode(34);
            this.f254780c0.setCursorVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f254778a0.onStart();
        }
    }

    @TargetApi(14)
    protected void findViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) super.findViewById(R.id.if5);
        this.f254785h0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        if (this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
            this.f254785h0.setFitsSystemWindows(true);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) super.findViewById(R.id.search_box);
        this.f254779b0 = relativeLayout2;
        EditText editText = (EditText) relativeLayout2.findViewById(R.id.et_search_keyword);
        this.f254780c0 = editText;
        editText.setHintTextColor(-1431918938);
        this.f254780c0.setEllipsize(TextUtils.TruncateAt.END);
        this.f254781d0 = (ImageButton) this.f254779b0.findViewById(R.id.ib_clear_text);
        AccessibilityUtil.u(this.f254780c0, getString(R.string.f170792ab3));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f254781d0.getLayoutParams();
        layoutParams.width = (int) al.a(this, 22.0f);
        layoutParams.height = (int) al.a(this, 22.0f);
        this.f254781d0.setLayoutParams(layoutParams);
        ((Button) this.f254779b0.findViewById(R.id.btn_cancel_search)).setVisibility(8);
        ImageView imageView = (ImageView) this.f254779b0.findViewById(R.id.du6);
        this.f254782e0 = imageView;
        imageView.setVisibility(0);
        this.f254784g0 = (LinearLayout) super.findViewById(R.id.ikc);
        this.f254783f0 = super.findViewById(R.id.result_layout);
        if (this.f254793p0 == null) {
            this.f254793p0 = (InputMethodManager) super.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        }
        this.f254781d0.setOnClickListener(this);
        this.f254782e0.setOnClickListener(this);
        this.f254780c0.setImeOptions(3);
        this.f254780c0.setSingleLine(true);
        this.f254780c0.setOnEditorActionListener(new b());
        this.f254780c0.setOnClickListener(this);
        this.f254786i0 = findViewById(R.id.enc);
        if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
            this.f254786i0.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        EditText editText = this.f254780c0;
        if (editText != null) {
            this.f254793p0.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        setResult(-1);
        super.finish();
        overridePendingTransition(0, R.anim.activity_finish);
    }

    protected void initObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f254780c0.addTextChangedListener(this.f254794q0);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof AppInterface) {
            ((AppInterface) waitAppRuntime).addObserver(this.f254792o0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ib_clear_text) {
                this.f254780c0.setText("");
                this.f254780c0.setCursorVisible(true);
                this.f254793p0.showSoftInput(this.f254780c0, 0);
            } else if (id5 == R.id.if5) {
                this.f254793p0.hideSoftInputFromWindow(view.getWindowToken(), 0);
                this.f254780c0.clearFocus();
                this.f254780c0.setCursorVisible(false);
            } else if (id5 == R.id.et_search_keyword) {
                this.f254780c0.setCursorVisible(true);
            } else if (id5 == R.id.du6) {
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }
}
