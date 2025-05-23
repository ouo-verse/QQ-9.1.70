package com.tencent.mobileqq.mini.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.mini.util.ResourceUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$RspBody;

/* loaded from: classes33.dex */
public class AddPhoneNumberFragment extends PublicBaseFragment {
    public static final int SECOND = 1000;
    public static final String TAG = "AddPhoneNumberFragment";
    public static int mSecond = 1;
    private Button mCommitBtn;
    private ImageView mLeftBtnView;
    private EditText mPhoneNumberEditText;
    private RelativeLayout mPhoneNumberLayout;
    private Switch mSaveSwitch;
    private Button mSendSmsCodeBtn;
    private EditText mSmsCodeEditText;
    private RelativeLayout mSmsCodeLayout;
    private Handler mHandler = null;
    private boolean isSave = false;
    private String mPhoneNumber = null;
    private String mSmsCode = null;
    private String mAppId = null;
    private Runnable runnableCountdown = new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.9
        @Override // java.lang.Runnable
        public void run() {
            QLog.d("AddPhoneNumberFragment", 1, "runnableCountdown mSecond:" + AddPhoneNumberFragment.mSecond);
            int i3 = AddPhoneNumberFragment.mSecond;
            if (i3 <= 1) {
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setTextColor(ResourceUtil.getColor(R.color.qui_button_text_secondary_default));
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setBackgroundColor(ResourceUtil.getColor(R.color.qui_button_bg_secondary_default));
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setBackground(ResourceUtil.getDrawable(R.drawable.jy9));
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setEnabled(true);
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(true);
                AddPhoneNumberFragment.this.stopTimerCountDown();
                return;
            }
            AddPhoneNumberFragment.mSecond = i3 - 1;
            AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(false);
            AddPhoneNumberFragment.this.mSendSmsCodeBtn.setText("\u91cd\u65b0\u53d1\u9001(" + AddPhoneNumberFragment.mSecond + ")");
            if (AddPhoneNumberFragment.this.mHandler != null) {
                AddPhoneNumberFragment.this.mHandler.postDelayed(this, 1000L);
            }
        }
    };

    /* renamed from: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment$2, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(AddPhoneNumberFragment.this.mPhoneNumber)) {
                return;
            }
            MiniAppSendSmsCodeServlet.sendSmsCodeRequest(AddPhoneNumberFragment.this.mPhoneNumber, "+86", new MiniAppSendSmsCodeObserver() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.2.1
                @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
                public void onFailedResponse(String str, int i3, final String str2) {
                    super.onFailedResponse(str, i3, str2);
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseActivity baseActivity = AddPhoneNumberFragment.this.getBaseActivity();
                            if (baseActivity == null || baseActivity.isFinishing()) {
                                return;
                            }
                            QQToast.makeText(baseActivity, str2, 0).show();
                        }
                    });
                    QLog.e("AddPhoneNumberFragment", 1, "send onFailedResponse cmd : " + str + ", code : " + i3 + "; message : " + str2);
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
                public void sendSmsCodeSuccess(oidb_0x87a$RspBody oidb_0x87a_rspbody) {
                    super.sendSmsCodeSuccess(oidb_0x87a_rspbody);
                    QLog.d("AddPhoneNumberFragment", 1, "send success");
                    if (oidb_0x87a_rspbody != null) {
                        AddPhoneNumberFragment.this.restartTimer(oidb_0x87a_rspbody.uint32_resend_interval.get() > 0 ? oidb_0x87a_rspbody.uint32_resend_interval.get() : 60);
                    }
                }

                @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
                public void verifySmsCodeSuccess(oidb_0x87c$RspBody oidb_0x87c_rspbody) {
                    super.verifySmsCodeSuccess(oidb_0x87c_rspbody);
                }
            });
        }
    }

    /* renamed from: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment$8, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass8 implements View.OnClickListener {

        /* renamed from: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment$8$1, reason: invalid class name */
        /* loaded from: classes33.dex */
        class AnonymousClass1 extends MiniAppSendSmsCodeObserver {
            AnonymousClass1() {
            }

            @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
            public void onFailedResponse(String str, int i3, final String str2) {
                super.onFailedResponse(str, i3, str2);
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseActivity baseActivity = AddPhoneNumberFragment.this.getBaseActivity();
                        if (baseActivity == null || baseActivity.isFinishing()) {
                            return;
                        }
                        QQToast.makeText(baseActivity, str2, 0).show();
                    }
                });
                QLog.e("AddPhoneNumberFragment", 1, "verify onFailedResponse cmd : " + str + ", code : " + i3 + "; message : " + str2);
            }

            @Override // com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
            public void verifySmsCodeSuccess(oidb_0x87c$RspBody oidb_0x87c_rspbody) {
                super.verifySmsCodeSuccess(oidb_0x87c_rspbody);
                QLog.d("AddPhoneNumberFragment", 1, "verify success");
                MiniAppCmdUtil miniAppCmdUtil = MiniAppCmdUtil.getInstance();
                String str = AddPhoneNumberFragment.this.mAppId;
                String str2 = AddPhoneNumberFragment.this.mPhoneNumber;
                boolean z16 = AddPhoneNumberFragment.this.isSave;
                miniAppCmdUtil.addPhoneNumber(str, str2, "+86", z16 ? 1 : 0, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.1
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z17, final JSONObject jSONObject) {
                        QLog.d("AddPhoneNumberFragment", 1, "addPhoneNumber isSuc : " + z17 + "; " + jSONObject);
                        if (!z17) {
                            final String optString = jSONObject.optString("errMsg");
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BaseActivity baseActivity = AddPhoneNumberFragment.this.getBaseActivity();
                                    if (baseActivity == null || baseActivity.isFinishing()) {
                                        return;
                                    }
                                    QQToast.makeText(baseActivity, optString, 0).show();
                                }
                            });
                        } else {
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    Intent intent = new Intent();
                                    JSONObject jSONObject2 = jSONObject;
                                    if (jSONObject2 != null) {
                                        intent.putExtra(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, jSONObject2.optString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
                                        intent.putExtra("iv", jSONObject.optString("iv"));
                                        AddPhoneNumberFragment addPhoneNumberFragment = AddPhoneNumberFragment.this;
                                        intent.putExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, addPhoneNumberFragment.resetPhoneNumberToHide(addPhoneNumberFragment.mPhoneNumber));
                                        intent.putExtra(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, jSONObject.optString(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID));
                                        QLog.d("AddPhoneNumberFragment", 1, "phoneNumber : " + AddPhoneNumberFragment.this.mPhoneNumber);
                                    }
                                    BaseActivity baseActivity = AddPhoneNumberFragment.this.getBaseActivity();
                                    if (baseActivity == null || baseActivity.isFinishing()) {
                                        return;
                                    }
                                    baseActivity.setResult(-1, intent);
                                    baseActivity.finish();
                                }
                            });
                        }
                    }
                });
            }
        }

        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(AddPhoneNumberFragment.this.mPhoneNumber) || TextUtils.isEmpty(AddPhoneNumberFragment.this.mSmsCode)) {
                return;
            }
            MiniAppSendSmsCodeServlet.sendVerifySmsCodeRequest(AddPhoneNumberFragment.this.mSmsCode, AddPhoneNumberFragment.this.mPhoneNumber, "+86", new AnonymousClass1());
        }
    }

    private Handler getTimerHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String resetPhoneNumberToHide(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.substring(0, 3) + "******" + str.substring(str.length() - 3, str.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartTimer(int i3) {
        this.mSendSmsCodeBtn.setEnabled(false);
        this.mSendSmsCodeBtn.setClickable(false);
        this.mSendSmsCodeBtn.setTextColor(ResourceUtil.getColor(R.color.qui_button_text_secondary_disable));
        this.mSendSmsCodeBtn.setBackgroundColor(ResourceUtil.getColor(R.color.qui_button_bg_secondary_disable));
        mSecond = i3;
        this.mSendSmsCodeBtn.setText("\u91cd\u65b0\u53d1\u9001(" + mSecond + ")");
        getTimerHandler().postDelayed(this.runnableCountdown, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommitBtnState() {
        if (!TextUtils.isEmpty(this.mPhoneNumberEditText.getText()) && !TextUtils.isEmpty(this.mSmsCodeEditText.getText())) {
            this.mCommitBtn.setEnabled(true);
            this.mCommitBtn.setClickable(true);
            this.mCommitBtn.setTextColor(ResourceUtil.getColor(R.color.qui_button_text_primary_default));
        } else {
            this.mCommitBtn.setEnabled(false);
            this.mCommitBtn.setClickable(false);
            this.mCommitBtn.setTextColor(ResourceUtil.getColor(R.color.qui_button_text_primary_disable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimerCountDown() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.runnableCountdown);
            this.mHandler = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && !baseActivity.isFinishing()) {
            baseActivity.setResult(0);
            baseActivity.finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mAppId = arguments.getString("appId", null);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.fhg, (ViewGroup) null);
        getBaseActivity().getWindow().clearFlags(67108864);
        getBaseActivity().getWindow().addFlags(Integer.MIN_VALUE);
        getBaseActivity().getWindow().setStatusBarColor(-1);
        ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stopTimerCountDown();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLeftBtnView = (ImageView) view.findViewById(R.id.z8t);
        Button button = (Button) view.findViewById(R.id.f166261z74);
        this.mSendSmsCodeBtn = button;
        button.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
        this.mSendSmsCodeBtn.setTextColor(ResourceUtil.getColor(R.color.qui_button_text_secondary_default));
        this.mSendSmsCodeBtn.setEnabled(false);
        this.mSendSmsCodeBtn.setClickable(false);
        this.mPhoneNumberLayout = (RelativeLayout) view.findViewById(R.id.f166260z73);
        this.mPhoneNumberEditText = (EditText) view.findViewById(R.id.z76);
        this.mSmsCodeLayout = (RelativeLayout) view.findViewById(R.id.z7d);
        this.mSmsCodeEditText = (EditText) view.findViewById(R.id.z7e);
        Switch r36 = (Switch) view.findViewById(R.id.z7b);
        this.mSaveSwitch = r36;
        r36.setChecked(false);
        Button button2 = (Button) view.findViewById(R.id.z75);
        this.mCommitBtn = button2;
        button2.setEnabled(false);
        this.mCommitBtn.setClickable(false);
        this.mLeftBtnView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseActivity baseActivity;
                if (view2.getId() != R.id.z8t || (baseActivity = AddPhoneNumberFragment.this.getBaseActivity()) == null || baseActivity.isFinishing()) {
                    return;
                }
                baseActivity.setResult(0);
                baseActivity.finish();
            }
        });
        this.mSendSmsCodeBtn.setOnClickListener(new AnonymousClass2());
        this.mPhoneNumberLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AddPhoneNumberFragment.this.mPhoneNumberEditText != null) {
                    AddPhoneNumberFragment.this.mPhoneNumberEditText.performClick();
                    AddPhoneNumberFragment.this.mPhoneNumberEditText.requestFocus();
                    ((InputMethodManager) AddPhoneNumberFragment.this.mPhoneNumberEditText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(AddPhoneNumberFragment.this.mPhoneNumberEditText, 0);
                }
            }
        });
        this.mPhoneNumberEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddPhoneNumberFragment.this.stopTimerCountDown();
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setBackground(ResourceUtil.getDrawable(R.drawable.jy9));
                if (editable == null || editable.length() <= 0) {
                    AddPhoneNumberFragment.this.mPhoneNumber = null;
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setEnabled(false);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(false);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setTextColor(ResourceUtil.getColor(R.color.qui_button_text_secondary_disable));
                } else {
                    AddPhoneNumberFragment.this.mPhoneNumber = editable.toString();
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setEnabled(true);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(true);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setTextColor(ResourceUtil.getColor(R.color.qui_button_text_secondary_default));
                }
                AddPhoneNumberFragment.this.setCommitBtnState();
                QLog.i("AddPhoneNumberFragment", 2, "mPhoneNumber : " + AddPhoneNumberFragment.this.mPhoneNumber);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mSaveSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AddPhoneNumberFragment.this.isSave = !r3.isSave;
                AddPhoneNumberFragment.this.mSaveSwitch.setChecked(AddPhoneNumberFragment.this.isSave);
                QLog.d("AddPhoneNumberFragment", 1, "isSave : " + AddPhoneNumberFragment.this.isSave);
            }
        });
        this.mSmsCodeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AddPhoneNumberFragment.this.mSmsCodeEditText != null) {
                    AddPhoneNumberFragment.this.mSmsCodeEditText.performClick();
                    AddPhoneNumberFragment.this.mSmsCodeEditText.requestFocus();
                    ((InputMethodManager) AddPhoneNumberFragment.this.mSmsCodeEditText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(AddPhoneNumberFragment.this.mSmsCodeEditText, 0);
                }
            }
        });
        this.mSmsCodeEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    AddPhoneNumberFragment.this.mSmsCode = null;
                } else {
                    AddPhoneNumberFragment.this.mSmsCode = editable.toString();
                }
                AddPhoneNumberFragment.this.setCommitBtnState();
                QLog.d("AddPhoneNumberFragment", 1, "mSmsCode : " + AddPhoneNumberFragment.this.mSmsCode);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mCommitBtn.setOnClickListener(new AnonymousClass8());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
