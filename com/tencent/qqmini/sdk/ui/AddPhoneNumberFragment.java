package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.graphics.Color;
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
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.Switch;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class AddPhoneNumberFragment extends MiniBaseFragment {
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
    private int intervalTime = 60;
    private Handler mHandler = null;
    private boolean isSave = false;
    private String mPhoneNumber = null;
    private String mSmsCode = null;
    private String mAppId = null;
    private Runnable runnableCountdown = new Runnable() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.1
        @Override // java.lang.Runnable
        public void run() {
            int i3 = AddPhoneNumberFragment.mSecond;
            if (i3 <= 1) {
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#181819"));
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setEnabled(true);
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(true);
                return;
            }
            AddPhoneNumberFragment.mSecond = i3 - 1;
            AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(false);
            AddPhoneNumberFragment.this.mSendSmsCodeBtn.setText("\u6709\u6548\u671f(" + AddPhoneNumberFragment.mSecond + ")");
            AddPhoneNumberFragment.this.mHandler.postDelayed(this, 1000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment$10, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass10 implements AsyncResult {
        final /* synthetic */ ChannelProxy val$proxy;

        AnonymousClass10(ChannelProxy channelProxy) {
            this.val$proxy = channelProxy;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            QMLog.d("AddPhoneNumberFragment", "sendVerifySmsCodeRequest isSuccess=" + z16 + "; result=" + jSONObject);
            if (z16) {
                this.val$proxy.addPhoneNumber(AddPhoneNumberFragment.this.mAppId, AddPhoneNumberFragment.this.mPhoneNumber, "+86", AddPhoneNumberFragment.this.isSave ? 1 : 0, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.10.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z17, final JSONObject jSONObject2) {
                        QMLog.d("AddPhoneNumberFragment", "addPhoneNumber isSuccess=" + z17 + "; result=" + jSONObject2);
                        if (z17) {
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.10.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Intent intent = new Intent();
                                    JSONObject jSONObject3 = jSONObject2;
                                    if (jSONObject3 != null) {
                                        intent.putExtra(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, jSONObject3.optString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
                                        intent.putExtra("iv", jSONObject2.optString("iv"));
                                        intent.putExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, AddPhoneNumberFragment.this.mPhoneNumber);
                                        QMLog.d("AddPhoneNumberFragment", "phoneNumber : " + AddPhoneNumberFragment.this.mPhoneNumber);
                                    }
                                    AddPhoneNumberFragment.this.getActivity().setResult(-1, intent);
                                    AddPhoneNumberFragment.this.getActivity().finish();
                                }
                            });
                        } else {
                            final String optString = jSONObject2.optString("errMsg");
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.10.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    MiniToast.makeText(AddPhoneNumberFragment.this.getActivity(), optString, 0).show();
                                }
                            });
                        }
                    }
                });
                return;
            }
            final String optString = jSONObject.optString("message", "");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.10.2
                @Override // java.lang.Runnable
                public void run() {
                    MiniToast.makeText(AddPhoneNumberFragment.this.getActivity(), optString, 0).show();
                }
            });
        }
    }

    /* renamed from: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment$3, reason: invalid class name */
    /* loaded from: classes23.dex */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(AddPhoneNumberFragment.this.mPhoneNumber)) {
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).sendSmsCodeRequest(AddPhoneNumberFragment.this.mPhoneNumber, "+86", new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.3.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        QMLog.d("AddPhoneNumberFragment", "sendSmsCodeRequest isSuccess=" + z16 + "; result=" + jSONObject);
                        if (z16) {
                            AddPhoneNumberFragment.this.restartTimer(jSONObject.optInt("intervalTime", 60));
                        } else {
                            final String optString = jSONObject.optString("message", "");
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.3.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MiniToast.makeText(AddPhoneNumberFragment.this.getActivity(), optString, 0).show();
                                }
                            });
                        }
                    }
                });
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartTimer(int i3) {
        this.mSendSmsCodeBtn.setEnabled(false);
        this.mSendSmsCodeBtn.setClickable(false);
        this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#B0B3BF"));
        mSecond = i3;
        this.mSendSmsCodeBtn.setText("\u6709\u6548\u671f(" + mSecond + ")");
        this.mHandler.postDelayed(this.runnableCountdown, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVerifySmsCodeRequest() {
        if (!TextUtils.isEmpty(this.mSmsCode)) {
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            channelProxy.sendVerifySmsCodeRequest(this.mSmsCode, this.mPhoneNumber, "+86", new AnonymousClass10(channelProxy));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment
    public void onBackPressed() {
        QMLog.i("AddPhoneNumberFragment", "onBackPressed");
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().setResult(0);
            getActivity().finish();
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler(Looper.getMainLooper());
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mAppId = arguments.getString("appId", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_add_phone_number, (ViewGroup) null);
        getActivity().getWindow().clearFlags(67108864);
        getActivity().getWindow().addFlags(Integer.MIN_VALUE);
        getActivity().getWindow().setStatusBarColor(-1);
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
        if (DisplayUtil.isImmersiveSupported()) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLeftBtnView = (ImageView) view.findViewById(R.id.mini_app_phone_number_manager_title_back);
        Button button = (Button) view.findViewById(R.id.mini_app_add_phone_number_btn);
        this.mSendSmsCodeBtn = button;
        button.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
        this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#B0B3BF"));
        this.mSendSmsCodeBtn.setEnabled(false);
        this.mSendSmsCodeBtn.setClickable(false);
        this.mPhoneNumberLayout = (RelativeLayout) view.findViewById(R.id.mini_app_add_phone_number);
        this.mPhoneNumberEditText = (EditText) view.findViewById(R.id.mini_app_add_phone_number_edittext);
        this.mSmsCodeLayout = (RelativeLayout) view.findViewById(R.id.mini_app_add_phone_number_smscode);
        this.mSmsCodeEditText = (EditText) view.findViewById(R.id.mini_app_add_phone_number_smscode_edittext);
        Switch r36 = (Switch) view.findViewById(R.id.mini_app_add_phone_number_save_switch);
        this.mSaveSwitch = r36;
        r36.setChecked(false);
        Button button2 = (Button) view.findViewById(R.id.mini_app_add_phone_number_commit_btn);
        this.mCommitBtn = button2;
        button2.setEnabled(false);
        this.mCommitBtn.setClickable(false);
        this.mCommitBtn.setTextColor(Color.parseColor("#3303081A"));
        this.mLeftBtnView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (view2.getId() == R.id.mini_app_phone_number_manager_title_back && AddPhoneNumberFragment.this.getActivity() != null && !AddPhoneNumberFragment.this.getActivity().isFinishing()) {
                    AddPhoneNumberFragment.this.getActivity().setResult(0);
                    AddPhoneNumberFragment.this.getActivity().finish();
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mSendSmsCodeBtn.setOnClickListener(new AnonymousClass3());
        this.mPhoneNumberLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (AddPhoneNumberFragment.this.mPhoneNumberEditText != null) {
                    AddPhoneNumberFragment.this.mPhoneNumberEditText.performClick();
                    AddPhoneNumberFragment.this.mPhoneNumberEditText.requestFocus();
                    ((InputMethodManager) AddPhoneNumberFragment.this.mPhoneNumberEditText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(AddPhoneNumberFragment.this.mPhoneNumberEditText, 0);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mPhoneNumberEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddPhoneNumberFragment.this.mHandler.removeCallbacks(AddPhoneNumberFragment.this.runnableCountdown);
                AddPhoneNumberFragment.this.mSendSmsCodeBtn.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
                if (editable == null || editable.length() <= 0) {
                    AddPhoneNumberFragment.this.mPhoneNumber = null;
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setEnabled(false);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(false);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#B0B3BF"));
                } else {
                    AddPhoneNumberFragment.this.mPhoneNumber = editable.toString();
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setEnabled(true);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setClickable(true);
                    AddPhoneNumberFragment.this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#181819"));
                }
                QMLog.i("AddPhoneNumberFragment", "mPhoneNumber : " + AddPhoneNumberFragment.this.mPhoneNumber);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mSaveSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                AddPhoneNumberFragment.this.isSave = !r0.isSave;
                AddPhoneNumberFragment.this.mSaveSwitch.setChecked(AddPhoneNumberFragment.this.isSave);
                QMLog.d("AddPhoneNumberFragment", "isSave : " + AddPhoneNumberFragment.this.isSave);
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mSmsCodeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (AddPhoneNumberFragment.this.mSmsCodeEditText != null) {
                    AddPhoneNumberFragment.this.mSmsCodeEditText.performClick();
                    AddPhoneNumberFragment.this.mSmsCodeEditText.requestFocus();
                    ((InputMethodManager) AddPhoneNumberFragment.this.mSmsCodeEditText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(AddPhoneNumberFragment.this.mSmsCodeEditText, 0);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mSmsCodeEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    AddPhoneNumberFragment.this.mSmsCode = null;
                    AddPhoneNumberFragment.this.mCommitBtn.setEnabled(false);
                    AddPhoneNumberFragment.this.mCommitBtn.setClickable(false);
                    AddPhoneNumberFragment.this.mCommitBtn.setTextColor(Color.parseColor("#3303081A"));
                } else {
                    AddPhoneNumberFragment.this.mSmsCode = editable.toString();
                    AddPhoneNumberFragment.this.mCommitBtn.setEnabled(true);
                    AddPhoneNumberFragment.this.mCommitBtn.setClickable(true);
                    AddPhoneNumberFragment.this.mCommitBtn.setTextColor(-1);
                }
                QMLog.d("AddPhoneNumberFragment", "mSmsCode : " + AddPhoneNumberFragment.this.mSmsCode);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mCommitBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                AddPhoneNumberFragment.this.sendVerifySmsCodeRequest();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
    }
}
