package com.tencent.qqmini.sdk.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONArray;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class PhoneNumberManagementFragment extends MiniBaseFragment implements View.OnClickListener {
    public static final String TAG = "PhoneNumberManagementFragment";
    private String mAppId;
    private TextView mDelPhoneNmber2;
    private TextView mDelPhoneNmber3;
    private ImageView mLeftBtnView;
    private RelativeLayout mOperatePhoneNumberLayout;
    private JSONArray mPhoneNumberArray = new JSONArray();
    private RelativeLayout mPhoneNumberLayout1;
    private RelativeLayout mPhoneNumberLayout2;
    private RelativeLayout mPhoneNumberLayout3;
    private TextView mPhoneNumberMaxInfo;
    private TextView mPhoneNumberText1;
    private TextView mPhoneNumberText2;
    private TextView mPhoneNumberText3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment$3, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ int val$position;

        AnonymousClass3(int i3) {
            this.val$position = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            JSONObject optJSONObject;
            QMLog.d("PhoneNumberManagementFragment", " click positiveButton");
            if (PhoneNumberManagementFragment.this.mPhoneNumberArray != null && (optJSONObject = PhoneNumberManagementFragment.this.mPhoneNumberArray.optJSONObject(this.val$position)) != null) {
                final String optString = optJSONObject.optString("purePhoneNumber");
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).delPhoneNumber(PhoneNumberManagementFragment.this.mAppId, optString, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.3.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        QMLog.d("PhoneNumberManagementFragment", "isSuccess : " + z16 + "; result : " + jSONObject + "; purePhoneNumber : " + optString);
                        if (z16) {
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.3.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    PhoneNumberManagementFragment.this.mPhoneNumberArray.remove(AnonymousClass3.this.val$position);
                                    PhoneNumberManagementFragment.this.updateView();
                                }
                            });
                        } else {
                            final String optString2 = jSONObject.optString("errMsg");
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.3.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    MiniToast.makeText(PhoneNumberManagementFragment.this.getActivity(), optString2, 0).show();
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    private void sendDelRequest(int i3) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            MiniCustomDialog miniCustomDialog = new MiniCustomDialog(getActivity(), R.style.mini_sdk_MiniAppInputDialog);
            miniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_for_delphonenumber);
            miniCustomDialog.setTitle("\u786e\u8ba4\u5220\u9664\u6b64\u53f7\u7801\uff1f").setMessage("").setPositiveButton("\u786e\u5b9a", new AnonymousClass3(i3)).setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    QMLog.d("PhoneNumberManagementFragment", " click negativeButton");
                }
            });
            miniCustomDialog.show();
        }
    }

    private void setActivityResultListener() {
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.1
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                QMLog.d("PhoneNumberManagementFragment", "doOnActivityResult : " + i3);
                if (i3 == 1090) {
                    if (i16 == -1) {
                        if (intent != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("phoneType", 1);
                                jSONObject.put("purePhoneNumber", intent.getStringExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER));
                                jSONObject.put("countryCode", "+86");
                                jSONObject.put("iv", intent.getStringExtra("iv"));
                                jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, intent.getStringExtra(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
                                if (PhoneNumberManagementFragment.this.mPhoneNumberArray != null) {
                                    QMLog.d("PhoneNumberManagementFragment", "mPhoneNumberArray put : " + jSONObject.toString());
                                    PhoneNumberManagementFragment.this.mPhoneNumberArray.mo162put(jSONObject);
                                    PhoneNumberManagementFragment.this.updateView();
                                }
                            } catch (Throwable th5) {
                                QMLog.e("PhoneNumberManagementFragment", "REQUEST_CODE_ADD_PHONENUMBER error, ", th5);
                            }
                        }
                    } else {
                        QMLog.e("PhoneNumberManagementFragment", "REQUEST_CODE_ADD_PHONENUMBER " + i16);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        JSONArray jSONArray = this.mPhoneNumberArray;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = this.mPhoneNumberArray.length();
            if (length != 1) {
                if (length != 2) {
                    if (length == 3) {
                        JSONObject optJSONObject = this.mPhoneNumberArray.optJSONObject(0);
                        JSONObject optJSONObject2 = this.mPhoneNumberArray.optJSONObject(1);
                        JSONObject optJSONObject3 = this.mPhoneNumberArray.optJSONObject(2);
                        this.mPhoneNumberLayout1.setVisibility(0);
                        this.mPhoneNumberLayout2.setVisibility(0);
                        this.mPhoneNumberLayout3.setVisibility(0);
                        this.mPhoneNumberText1.setText(optJSONObject.optString("purePhoneNumber"));
                        this.mPhoneNumberText2.setText(optJSONObject2.optString("purePhoneNumber"));
                        this.mPhoneNumberText3.setText(optJSONObject3.optString("purePhoneNumber"));
                        this.mOperatePhoneNumberLayout.setVisibility(8);
                        this.mPhoneNumberMaxInfo.setVisibility(0);
                        return;
                    }
                    return;
                }
                JSONObject optJSONObject4 = this.mPhoneNumberArray.optJSONObject(0);
                JSONObject optJSONObject5 = this.mPhoneNumberArray.optJSONObject(1);
                this.mPhoneNumberLayout1.setVisibility(0);
                this.mPhoneNumberLayout2.setVisibility(0);
                this.mPhoneNumberLayout3.setVisibility(8);
                this.mPhoneNumberText1.setText(optJSONObject4.optString("purePhoneNumber"));
                this.mPhoneNumberText2.setText(optJSONObject5.optString("purePhoneNumber"));
                this.mOperatePhoneNumberLayout.setVisibility(0);
                this.mPhoneNumberMaxInfo.setVisibility(8);
                return;
            }
            JSONObject optJSONObject6 = this.mPhoneNumberArray.optJSONObject(0);
            this.mPhoneNumberLayout1.setVisibility(0);
            this.mPhoneNumberLayout2.setVisibility(8);
            this.mPhoneNumberLayout3.setVisibility(8);
            this.mPhoneNumberText1.setText(optJSONObject6.optString("purePhoneNumber"));
            this.mOperatePhoneNumberLayout.setVisibility(0);
            this.mPhoneNumberMaxInfo.setVisibility(8);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment
    public void onBackPressed() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            Intent intent = new Intent();
            JSONArray jSONArray = this.mPhoneNumberArray;
            if (jSONArray != null) {
                intent.putExtra("phoneNumberArray", jSONArray.toString());
            }
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.mini_app_phone_number_manager_title_back) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                Intent intent = new Intent();
                JSONArray jSONArray = this.mPhoneNumberArray;
                if (jSONArray != null) {
                    intent.putExtra("phoneNumberArray", jSONArray.toString());
                }
                getActivity().setResult(-1, intent);
                getActivity().finish();
            }
        } else if (id5 == R.id.mini_app_phone_number_manager_number_del2) {
            sendDelRequest(1);
        } else if (id5 == R.id.mini_app_phone_number_manager_number_del3) {
            sendDelRequest(2);
        } else if (id5 == R.id.mini_app_phone_number_manager_operate) {
            Intent intent2 = new Intent();
            intent2.putExtra("appId", this.mAppId);
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            if (channelProxy != null) {
                channelProxy.launchAddPhoneNumberFragment(getActivity(), intent2, 1090);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.mAppId = arguments.getString("appId", null);
                this.mPhoneNumberArray = new JSONArray(arguments.getString("phoneNumberList"));
            }
        } catch (Throwable th5) {
            QMLog.e("PhoneNumberManagementFragment", "parse getArguments error,", th5);
        }
        setActivityResultListener();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_phone_number_manager, (ViewGroup) null);
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
        ImageView imageView = (ImageView) view.findViewById(R.id.mini_app_phone_number_manager_title_back);
        this.mLeftBtnView = imageView;
        imageView.setOnClickListener(this);
        this.mPhoneNumberLayout1 = (RelativeLayout) view.findViewById(R.id.mini_app_phone_number_manager_number_1);
        this.mPhoneNumberText1 = (TextView) view.findViewById(R.id.mini_app_phone_number_manager_number_text1);
        this.mPhoneNumberLayout2 = (RelativeLayout) view.findViewById(R.id.mini_app_phone_number_manager_number_2);
        this.mPhoneNumberText2 = (TextView) view.findViewById(R.id.mini_app_phone_number_manager_number_text2);
        TextView textView = (TextView) view.findViewById(R.id.mini_app_phone_number_manager_number_del2);
        this.mDelPhoneNmber2 = textView;
        textView.setOnClickListener(this);
        this.mPhoneNumberLayout3 = (RelativeLayout) view.findViewById(R.id.mini_app_phone_number_manager_number_3);
        this.mPhoneNumberText3 = (TextView) view.findViewById(R.id.mini_app_phone_number_manager_number_text3);
        TextView textView2 = (TextView) view.findViewById(R.id.mini_app_phone_number_manager_number_del3);
        this.mDelPhoneNmber3 = textView2;
        textView2.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mini_app_phone_number_manager_operate);
        this.mOperatePhoneNumberLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.mPhoneNumberMaxInfo = (TextView) view.findViewById(R.id.mini_app_phone_number_manager_max_info);
        updateView();
    }
}
