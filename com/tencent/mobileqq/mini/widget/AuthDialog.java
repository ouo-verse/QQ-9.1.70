package com.tencent.mobileqq.mini.widget;

import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AuthDialog extends Dialog implements View.OnClickListener {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_ONCE_SUB_RESULT_CB_1 = "key_once_sub_cb1";
    public static final String KEY_ONCE_SUB_RESULT_CB_2 = "key_once_sub_cb2";
    public static final String KEY_ONCE_SUB_RESULT_CB_3 = "key_once_sub_cb3";
    public static final String KEY_ONCE_SUB_RESULT_CB_MAINTAIN = "key_once_sub_cb_maintain";
    public static final String KEY_ONCE_SUB_RSP_DATA = "key_once_sub_rsp_data";
    public static final int REQUEST_CODE_ADD_PHONENUMBER = 1088;
    public static final int REQUEST_CODE_MANAGER_ADD_PHONENUMBER = 1090;
    public static final int REQUEST_CODE_PHONE_MANAGER = 1089;
    private static final String TAG = "AuthDialog";
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_ONCE_SUB_MSG = 3;
    public static final int TYPE_PHONENUMBER = 2;
    public static final int TYPE_SYS_SUB_MSG = 4;
    private String mAppId;
    private TextView mAuthDesc;
    private ImageView mAuthInfoBackIcon;
    private TextView mAuthInfoDetailText1;
    private TextView mAuthInfoDetailText2;
    private ImageView mAuthInfoImageView;
    private RelativeLayout mAuthInfoLayout;
    private TextView mAuthInfoTitle;
    private TextView mAuthTitle;
    private LinearLayout mConfirmLayout;
    private Activity mContext;
    private Bundle mData;
    private boolean mIsConfirm;
    private boolean mIsRefuse;
    private TextView mLeftBtn;
    private View mLineView1;
    private View mLineView2;
    private View mLineView3;
    private View mLineView4;
    private ImageView mMiniAppIcon;
    private LinearLayout mMiniAppInfoLayout;
    private TextView mMiniAppName;
    private TextView mOperateNumberBtn;
    private TextView mPhoneNumber1;
    private TextView mPhoneNumber2;
    private TextView mPhoneNumber3;
    private RelativeLayout mPhoneNumberLayout;
    private RelativeLayout mPhoneNumberLayout1;
    private RelativeLayout mPhoneNumberLayout2;
    private RelativeLayout mPhoneNumberLayout3;
    private ImageView mPhoneNumberSection1;
    private ImageView mPhoneNumberSection2;
    private ImageView mPhoneNumberSection3;
    private AuthDialogResBuilder mResBuilder;
    private TextView mRightBtn;
    private View mRootView;
    private int mSelectPhoneNumber;
    private int mType;
    private ImageView mUserIcon;
    private TextView mUserName;
    private CheckBox onceSubCheckBox1;
    private CheckBox onceSubCheckBox2;
    private CheckBox onceSubCheckBox3;
    private RelativeLayout onceSubLayout1;
    private RelativeLayout onceSubLayout2;
    private RelativeLayout onceSubLayout3;
    private CheckBox onceSubMaintainCheckBox;
    private final CompoundButton.OnCheckedChangeListener onceSubOnCheckedChangeListener;
    private TextView onceSubTextView1;
    private TextView onceSubTextView2;
    private TextView onceSubTextView3;
    private ImageView onceSubTips1;
    private ImageView onceSubTips2;
    private ImageView onceSubTips3;
    private String uin;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class AuthDialogResBuilder {
        private String mAuthDesc;
        private String mAuthTitle;
        private View.OnClickListener mLeftBtnClickListener;
        private String mLeftBtnText;
        private MiniAppConfig mMiniAppConfig;
        private String mMiniAppIconUrl;
        private String mMiniAppName;
        private JSONArray mPhoneNumberList;
        private String mReportSubAction;
        private View.OnClickListener mRightBtnClickListener;
        private String mRightBtnText;
        private String mUserIconUrl;
        private String mUserName;

        public String getAuthDesc() {
            return this.mAuthDesc;
        }

        public String getAuthTitle() {
            return this.mAuthTitle;
        }

        public View.OnClickListener getLeftBtnClickListener() {
            return this.mLeftBtnClickListener;
        }

        public String getLeftBtnText() {
            return this.mLeftBtnText;
        }

        public MiniAppConfig getMiniAppConfig() {
            return this.mMiniAppConfig;
        }

        public String getMiniAppIconUrl() {
            return this.mMiniAppIconUrl;
        }

        public String getMiniAppName() {
            return this.mMiniAppName;
        }

        public JSONArray getPhoneNumberList() {
            return this.mPhoneNumberList;
        }

        public String getReportSubAction() {
            return this.mReportSubAction;
        }

        public View.OnClickListener getRightBtnClickListener() {
            return this.mRightBtnClickListener;
        }

        public String getRightBtnText() {
            return this.mRightBtnText;
        }

        public String getUserIconUrl() {
            return this.mUserIconUrl;
        }

        public String getUserName() {
            return this.mUserName;
        }

        public AuthDialogResBuilder setAuthDesc(String str) {
            this.mAuthDesc = str;
            return this;
        }

        public AuthDialogResBuilder setAuthTitle(String str) {
            this.mAuthTitle = str;
            return this;
        }

        public AuthDialogResBuilder setLeftBtnClickListener(View.OnClickListener onClickListener) {
            this.mLeftBtnClickListener = onClickListener;
            return this;
        }

        public AuthDialogResBuilder setLeftBtnText(String str) {
            this.mLeftBtnText = str;
            return this;
        }

        public AuthDialogResBuilder setMiniAppConfig(MiniAppConfig miniAppConfig) {
            this.mMiniAppConfig = miniAppConfig;
            return this;
        }

        public AuthDialogResBuilder setMiniAppIconUrl(String str) {
            this.mMiniAppIconUrl = str;
            return this;
        }

        public AuthDialogResBuilder setMiniAppName(String str) {
            this.mMiniAppName = str;
            return this;
        }

        public AuthDialogResBuilder setPhoneNumberList(JSONArray jSONArray) {
            this.mPhoneNumberList = jSONArray;
            return this;
        }

        public AuthDialogResBuilder setReportSubAction(String str) {
            this.mReportSubAction = str;
            return this;
        }

        public AuthDialogResBuilder setRightBtnClickListener(View.OnClickListener onClickListener) {
            this.mRightBtnClickListener = onClickListener;
            return this;
        }

        public AuthDialogResBuilder setRightBtnText(String str) {
            this.mRightBtnText = str;
            return this;
        }

        public AuthDialogResBuilder setUserIconUrl(String str) {
            this.mUserIconUrl = str;
            return this;
        }

        public AuthDialogResBuilder setUserName(String str) {
            this.mUserName = str;
            return this;
        }
    }

    public AuthDialog(Activity activity) {
        super(activity, R.style.f173513f1);
        this.mType = 1;
        this.mAppId = null;
        this.uin = null;
        this.mSelectPhoneNumber = 1;
        this.onceSubOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                int i3 = (AuthDialog.this.onceSubLayout1.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox1.isChecked()) ? 1 : 0;
                if (AuthDialog.this.onceSubLayout2.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox2.isChecked()) {
                    i3++;
                }
                if (AuthDialog.this.onceSubLayout3.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox3.isChecked()) {
                    i3++;
                }
                if (i3 > 0) {
                    AuthDialog.this.mRightBtn.setEnabled(true);
                    AuthDialog.this.mRightBtn.setTextColor(-1);
                } else {
                    AuthDialog.this.mRightBtn.setEnabled(false);
                    AuthDialog.this.mRightBtn.setTextColor(Color.parseColor("#8e909d"));
                }
            }
        };
        this.mContext = activity;
        initView(activity);
    }

    private void initOnceSubMsgView(Context context, int i3) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fhn, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
        this.mMiniAppIcon = (ImageView) inflate.findViewById(R.id.ewf);
        this.mMiniAppName = (TextView) inflate.findViewById(R.id.ewh);
        this.mAuthTitle = (TextView) inflate.findViewById(R.id.a19);
        this.mLeftBtn = (TextView) inflate.findViewById(R.id.e7d);
        this.mRightBtn = (TextView) inflate.findViewById(R.id.i_w);
        this.onceSubLayout1 = (RelativeLayout) inflate.findViewById(R.id.f7582400);
        this.onceSubLayout2 = (RelativeLayout) inflate.findViewById(R.id.f7583401);
        this.onceSubLayout3 = (RelativeLayout) inflate.findViewById(R.id.f7584402);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.tpn);
        this.onceSubCheckBox1 = checkBox;
        checkBox.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.tpo);
        this.onceSubCheckBox2 = checkBox2;
        checkBox2.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.tpp);
        this.onceSubCheckBox3 = checkBox3;
        checkBox3.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
        this.onceSubMaintainCheckBox = (CheckBox) inflate.findViewById(R.id.tpj);
        this.onceSubTextView1 = (TextView) inflate.findViewById(R.id.f109726gl);
        this.onceSubTextView2 = (TextView) inflate.findViewById(R.id.f109736gm);
        this.onceSubTextView3 = (TextView) inflate.findViewById(R.id.f109746gn);
        this.onceSubTips1 = (ImageView) inflate.findViewById(R.id.y6h);
        this.onceSubTips2 = (ImageView) inflate.findViewById(R.id.y6i);
        this.onceSubTips3 = (ImageView) inflate.findViewById(R.id.y6j);
        if (i3 == 4) {
            inflate.findViewById(R.id.f75763zu).setVisibility(8);
        }
    }

    private void initPhoneNumberView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fhr, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
        this.mMiniAppInfoLayout = (LinearLayout) inflate.findViewById(R.id.z7y);
        this.mMiniAppIcon = (ImageView) inflate.findViewById(R.id.ewf);
        this.mMiniAppName = (TextView) inflate.findViewById(R.id.ewh);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.z7n);
        this.mAuthInfoImageView = imageView;
        imageView.setOnClickListener(this);
        this.mAuthTitle = (TextView) inflate.findViewById(R.id.a19);
        this.mPhoneNumberLayout = (RelativeLayout) inflate.findViewById(R.id.z7u);
        this.mPhoneNumberLayout1 = (RelativeLayout) inflate.findViewById(R.id.z86);
        this.mPhoneNumber1 = (TextView) inflate.findViewById(R.id.f166265z81);
        this.mPhoneNumberSection1 = (ImageView) inflate.findViewById(R.id.z8v);
        this.mPhoneNumberLayout1.setOnClickListener(this);
        this.mPhoneNumberLayout2 = (RelativeLayout) inflate.findViewById(R.id.z87);
        this.mPhoneNumber2 = (TextView) inflate.findViewById(R.id.f166266z82);
        this.mPhoneNumberSection2 = (ImageView) inflate.findViewById(R.id.z8w);
        this.mPhoneNumberLayout2.setOnClickListener(this);
        this.mPhoneNumberLayout3 = (RelativeLayout) inflate.findViewById(R.id.z88);
        this.mPhoneNumber3 = (TextView) inflate.findViewById(R.id.f166267z83);
        this.mPhoneNumberSection3 = (ImageView) inflate.findViewById(R.id.z8x);
        this.mPhoneNumberLayout3.setOnClickListener(this);
        this.mLineView1 = inflate.findViewById(R.id.z7p);
        this.mLineView2 = inflate.findViewById(R.id.z7q);
        this.mLineView3 = inflate.findViewById(R.id.z7r);
        this.mLineView4 = inflate.findViewById(R.id.z7s);
        TextView textView = (TextView) inflate.findViewById(R.id.z7t);
        this.mOperateNumberBtn = textView;
        textView.setOnClickListener(this);
        this.mConfirmLayout = (LinearLayout) inflate.findViewById(R.id.z7i);
        this.mLeftBtn = (TextView) inflate.findViewById(R.id.f166264z80);
        this.mRightBtn = (TextView) inflate.findViewById(R.id.f166270z91);
        this.mAuthInfoLayout = (RelativeLayout) inflate.findViewById(R.id.z7o);
        this.mAuthInfoBackIcon = (ImageView) inflate.findViewById(R.id.z7j);
        this.mAuthInfoTitle = (TextView) inflate.findViewById(R.id.z7m);
        this.mAuthInfoDetailText1 = (TextView) inflate.findViewById(R.id.z7k);
        this.mAuthInfoDetailText2 = (TextView) inflate.findViewById(R.id.z7l);
        this.mAuthInfoBackIcon.setOnClickListener(this);
        this.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168274ru, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
        this.mMiniAppIcon = (ImageView) inflate.findViewById(R.id.ewf);
        this.mMiniAppName = (TextView) inflate.findViewById(R.id.ewh);
        this.mAuthTitle = (TextView) inflate.findViewById(R.id.a19);
        this.mUserIcon = (ImageView) inflate.findViewById(R.id.klf);
        this.mUserName = (TextView) inflate.findViewById(R.id.km_);
        this.mAuthDesc = (TextView) inflate.findViewById(R.id.a0z);
        this.mLeftBtn = (TextView) inflate.findViewById(R.id.e7d);
        this.mRightBtn = (TextView) inflate.findViewById(R.id.i_w);
    }

    private void loadOnceSubMsgBottomBtn() {
        TextView textView = this.mLeftBtn;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.jyi));
            this.mLeftBtn.setVisibility(0);
            this.mLeftBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb1", AuthDialog.this.onceSubCheckBox1.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb2", AuthDialog.this.onceSubCheckBox2.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb3", AuthDialog.this.onceSubCheckBox3.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb_maintain", AuthDialog.this.onceSubMaintainCheckBox.isChecked());
                    AuthDialog.this.setRefuse(true);
                    AuthDialog.this.dismiss();
                }
            });
        }
        TextView textView2 = this.mRightBtn;
        if (textView2 != null) {
            textView2.setText(HardCodeUtil.qqStr(R.string.jyh));
            this.mRightBtn.setVisibility(0);
            this.mRightBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb1", AuthDialog.this.onceSubCheckBox1.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb2", AuthDialog.this.onceSubCheckBox2.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb3", AuthDialog.this.onceSubCheckBox3.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb_maintain", AuthDialog.this.onceSubMaintainCheckBox.isChecked());
                    AuthDialog.this.setConfirm(true);
                    AuthDialog.this.dismiss();
                }
            });
        }
    }

    private void loadOnceSubMsgView() {
        Bundle data = getData();
        if (data != null) {
            byte[] byteArray = data.getByteArray("key_once_sub_rsp_data");
            INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
            if (byteArray != null) {
                try {
                    iNTERFACE$StGetUserSettingRsp.mergeFrom(byteArray);
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "loadOnceSubMsgView - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", th5);
                }
            }
            INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = iNTERFACE$StGetUserSettingRsp.setting;
            if (iNTERFACE$StUserSettingInfo != null) {
                List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StUserSettingInfo.subItems.get();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
                    if (iNTERFACE$StSubscribeMessage.authState.get() == 0) {
                        arrayList.add(iNTERFACE$StSubscribeMessage);
                    }
                }
                int size = arrayList.size();
                if (size == 1) {
                    this.onceSubLayout1.setVisibility(0);
                    this.onceSubLayout2.setVisibility(8);
                    this.onceSubLayout3.setVisibility(8);
                    loadOnceSubItemView(arrayList, 0);
                    return;
                }
                if (size == 2) {
                    this.onceSubLayout1.setVisibility(0);
                    this.onceSubLayout2.setVisibility(0);
                    this.onceSubLayout3.setVisibility(8);
                    loadOnceSubItemView(arrayList, 0);
                    loadOnceSubItemView(arrayList, 1);
                    return;
                }
                if (size != 3) {
                    QLog.e(TAG, 1, "subMsgNoMaintainAuth size > 3 || size == 0!!");
                    return;
                }
                this.onceSubLayout1.setVisibility(0);
                this.onceSubLayout2.setVisibility(0);
                this.onceSubLayout3.setVisibility(0);
                loadOnceSubItemView(arrayList, 0);
                loadOnceSubItemView(arrayList, 1);
                loadOnceSubItemView(arrayList, 2);
            }
        }
    }

    private void realReportTo4239(String str) {
        String str2;
        String reportSubAction = this.mResBuilder.getReportSubAction();
        MiniAppConfig miniAppConfig = this.mResBuilder.getMiniAppConfig();
        if (miniAppConfig.isReportTypeMiniGame()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        MiniProgramLpReportDC04239.reportMiniAppEvent(miniAppConfig, str2, null, "scope", reportSubAction, str, null);
    }

    private void setActivityResultListener() {
        MiniAppController.getInstance().setActivityResultListener(new MiniAppController.ActivityResultListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.2
            @Override // com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                QLog.d(AuthDialog.TAG, 2, "doOnActivityResult : " + i3);
                if (i3 == 1089) {
                    if (i16 != -1) {
                        QLog.e(AuthDialog.TAG, 1, "REQUEST_CODE_PHONE_MANAGER " + i16);
                    } else if (intent != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(intent.getStringExtra("phoneNumberArray"));
                            if (AuthDialog.this.mResBuilder != null) {
                                AuthDialog.this.mResBuilder.setPhoneNumberList(jSONArray);
                                AuthDialog authDialog = AuthDialog.this;
                                authDialog.updatePhoneNumberView(authDialog.mResBuilder.getPhoneNumberList());
                            }
                        } catch (Throwable th5) {
                            QLog.e(AuthDialog.TAG, 1, "REQUEST_CODE_PHONE_MANAGER error, ", th5);
                        }
                    }
                    return true;
                }
                if (i3 != 1088) {
                    return false;
                }
                if (i16 != -1) {
                    QLog.e(AuthDialog.TAG, 1, "REQUEST_CODE_ADD_PHONENUMBER " + i16);
                } else if (intent != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("phoneType", 1);
                        jSONObject.put("purePhoneNumber", intent.getStringExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER));
                        jSONObject.put("countryCode", "+86");
                        jSONObject.put("iv", intent.getStringExtra("iv"));
                        jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, intent.getStringExtra(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
                        QLog.d(AuthDialog.TAG, 1, "REQUEST_CODE_ADD_PHONENUMBER stPhoneNumberObj : " + jSONObject);
                        if (AuthDialog.this.mResBuilder != null) {
                            AuthDialog.this.mResBuilder.getPhoneNumberList().mo162put(jSONObject);
                            AuthDialog authDialog2 = AuthDialog.this;
                            authDialog2.updatePhoneNumberView(authDialog2.mResBuilder.getPhoneNumberList());
                        }
                    } catch (Throwable th6) {
                        QLog.e(AuthDialog.TAG, 1, "REQUEST_CODE_ADD_PHONENUMBER error, ", th6);
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOnceSubItemDetailDialog(INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage) {
        int i3;
        int i16;
        QLog.e(TAG, 1, "showOnceSubItemDetailDialog detailItem: " + iNTERFACE$StSubscribeMessage.example.title.get());
        View view = this.mRootView;
        if (view != null) {
            i3 = view.getHeight();
            i16 = this.mRootView.getWidth();
        } else {
            i3 = -1;
            i16 = -1;
        }
        new AuthDetailDialog(this.mContext, iNTERFACE$StSubscribeMessage, i3, i16, 1).show();
    }

    public void bindData(Bundle bundle) {
        this.mData = bundle;
        if (bundle != null) {
            this.mAppId = bundle.getString("key_app_id");
        }
    }

    public Bundle getData() {
        return this.mData;
    }

    protected URLDrawable getUrlDrawable(String str, int i3) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        obtain.mRequestHeight = i3;
        obtain.mRequestWidth = i3;
        try {
            return URLDrawable.getDrawable(str, obtain);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getIcon url: " + str);
            }
            return null;
        }
    }

    public boolean isConfirm() {
        return this.mIsConfirm;
    }

    public boolean isRefuse() {
        return this.mIsRefuse;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.z7j /* 2131376453 */:
                this.mAuthInfoLayout.setVisibility(4);
                this.mAuthTitle.setVisibility(0);
                this.mMiniAppInfoLayout.setVisibility(0);
                this.mAuthInfoImageView.setVisibility(0);
                this.mAuthInfoImageView.setVisibility(0);
                this.mPhoneNumberLayout.setVisibility(0);
                this.mConfirmLayout.setVisibility(0);
                return;
            case R.id.z7n /* 2131376457 */:
                this.mAuthInfoLayout.setVisibility(0);
                this.mAuthTitle.setVisibility(4);
                this.mMiniAppInfoLayout.setVisibility(4);
                this.mAuthInfoImageView.setVisibility(4);
                this.mAuthInfoImageView.setVisibility(4);
                this.mPhoneNumberLayout.setVisibility(4);
                this.mConfirmLayout.setVisibility(4);
                return;
            case R.id.z7t /* 2131376463 */:
                Intent intent = new Intent();
                intent.putExtra("appId", this.mAppId);
                if (this.mOperateNumberBtn.getText().equals("\u7ba1\u7406\u624b\u673a\u53f7\u7801")) {
                    AuthDialogResBuilder authDialogResBuilder = this.mResBuilder;
                    if (authDialogResBuilder != null && authDialogResBuilder.getPhoneNumberList() != null && this.mResBuilder.getPhoneNumberList().length() > 0) {
                        intent.putExtra("phoneNumberList", this.mResBuilder.getPhoneNumberList().toString());
                    }
                    PublicFragmentActivity.b.d(this.mContext, intent, PublicFragmentActivityForMini.class, PhoneNumberManagementFragment.class, 1089);
                    return;
                }
                PublicFragmentActivity.b.d(this.mContext, intent, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, 1088);
                return;
            case R.id.z86 /* 2131376503 */:
                this.mPhoneNumberSection1.setVisibility(0);
                this.mPhoneNumberSection2.setVisibility(8);
                this.mPhoneNumberSection3.setVisibility(8);
                this.mSelectPhoneNumber = 1;
                return;
            case R.id.z87 /* 2131376504 */:
                this.mPhoneNumberSection1.setVisibility(8);
                this.mPhoneNumberSection2.setVisibility(0);
                this.mPhoneNumberSection3.setVisibility(8);
                this.mSelectPhoneNumber = 2;
                return;
            case R.id.z88 /* 2131376505 */:
                this.mPhoneNumberSection1.setVisibility(8);
                this.mPhoneNumberSection2.setVisibility(8);
                this.mPhoneNumberSection3.setVisibility(0);
                this.mSelectPhoneNumber = 3;
                return;
            default:
                return;
        }
    }

    public void reportAuthDialogCancelTo4239() {
        realReportTo4239("cancel");
    }

    public void reportAuthDialogClickTo4239() {
        realReportTo4239("click");
    }

    public void reportAuthDialogExpoTo4239() {
        realReportTo4239("expo");
    }

    public void setConfirm(boolean z16) {
        this.mIsConfirm = z16;
    }

    public void setRefuse(boolean z16) {
        this.mIsRefuse = z16;
    }

    public void show(AuthDialogResBuilder authDialogResBuilder) {
        URLDrawable urlDrawable;
        if (authDialogResBuilder == null) {
            QLog.e(TAG, 1, "authdialog show error, resBuilder is null, return.");
            return;
        }
        if (this.mType == 2 && (authDialogResBuilder.getPhoneNumberList() == null || authDialogResBuilder.getPhoneNumberList().length() <= 0)) {
            QLog.e(TAG, 1, "authdialog show error, getPhoneNumberList is null, return.");
            return;
        }
        this.mResBuilder = authDialogResBuilder;
        this.mIsConfirm = false;
        this.mIsRefuse = false;
        int dpToPx = ViewUtils.dpToPx(26.0f);
        if (this.mMiniAppIcon != null && !TextUtils.isEmpty(authDialogResBuilder.getMiniAppIconUrl()) && (urlDrawable = getUrlDrawable(authDialogResBuilder.getMiniAppIconUrl(), dpToPx)) != null) {
            urlDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(dpToPx, dpToPx, ViewUtils.dpToPx(5.0f)));
            urlDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            this.mMiniAppIcon.setImageDrawable(urlDrawable);
        }
        if (this.mMiniAppName != null && !TextUtils.isEmpty(authDialogResBuilder.getMiniAppName())) {
            this.mMiniAppName.setText(authDialogResBuilder.getMiniAppName());
        }
        if (this.mAuthTitle != null && !TextUtils.isEmpty(authDialogResBuilder.getAuthTitle())) {
            this.mAuthTitle.setText(authDialogResBuilder.getAuthTitle());
        }
        if (this.mUserIcon != null) {
            if (!TextUtils.isEmpty(authDialogResBuilder.getUserIconUrl())) {
                URLDrawable urlDrawable2 = getUrlDrawable(authDialogResBuilder.getUserIconUrl(), ViewUtils.dpToPx(40.0f));
                if (urlDrawable2 != null) {
                    urlDrawable2.setTag(com.tencent.mobileqq.urldrawable.a.d(dpToPx, dpToPx));
                    urlDrawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                    this.mUserIcon.setImageDrawable(urlDrawable2);
                }
                this.mUserIcon.setVisibility(0);
            } else {
                this.mUserIcon.setVisibility(8);
            }
        }
        if (this.mUserName != null) {
            if (!TextUtils.isEmpty(authDialogResBuilder.getUserName())) {
                this.mUserName.setText(authDialogResBuilder.getUserName());
                this.mUserName.setVisibility(0);
            } else {
                this.mUserName.setVisibility(8);
            }
        }
        int i3 = this.mType;
        if (i3 != 3 && i3 != 4) {
            if (this.mLeftBtn != null) {
                if (!TextUtils.isEmpty(authDialogResBuilder.getLeftBtnText())) {
                    this.mLeftBtn.setText(authDialogResBuilder.getLeftBtnText());
                    this.mLeftBtn.setVisibility(0);
                    if (authDialogResBuilder.getLeftBtnClickListener() != null) {
                        this.mLeftBtn.setOnClickListener(authDialogResBuilder.getLeftBtnClickListener());
                    }
                } else {
                    this.mLeftBtn.setVisibility(8);
                }
            }
            if (this.mRightBtn != null) {
                if (!TextUtils.isEmpty(authDialogResBuilder.getRightBtnText())) {
                    this.mRightBtn.setText(authDialogResBuilder.getRightBtnText());
                    this.mRightBtn.setVisibility(0);
                    if (authDialogResBuilder.getRightBtnClickListener() != null) {
                        this.mRightBtn.setOnClickListener(authDialogResBuilder.getRightBtnClickListener());
                    }
                } else {
                    this.mRightBtn.setVisibility(8);
                }
            }
        } else {
            loadOnceSubMsgBottomBtn();
        }
        if (this.mAuthDesc != null) {
            if (!TextUtils.isEmpty(authDialogResBuilder.getAuthDesc())) {
                this.mAuthDesc.setVisibility(0);
                this.mAuthDesc.setText(authDialogResBuilder.getAuthDesc());
            } else {
                this.mAuthDesc.setVisibility(8);
            }
        }
        if (this.mType == 2) {
            updatePhoneNumberView(authDialogResBuilder.getPhoneNumberList());
        }
        int i16 = this.mType;
        if (i16 == 3 || i16 == 4) {
            loadOnceSubMsgView();
        }
        show();
    }

    public JSONObject getSelectPhoneNumber() {
        try {
            AuthDialogResBuilder authDialogResBuilder = this.mResBuilder;
            if (authDialogResBuilder != null) {
                return authDialogResBuilder.getPhoneNumberList().optJSONObject(this.mSelectPhoneNumber - 1);
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getSelectPhoneNumber error,", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePhoneNumberView(JSONArray jSONArray) {
        if (jSONArray != null) {
            String string = StorageUtil.getPreference().getString(this.uin + "_PhoneNumber", "");
            QLog.d(TAG, 1, "updatePhoneNumberView phoneNumberArray length : " + jSONArray.length());
            int length = jSONArray.length();
            if (length == 1) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject != null) {
                    this.mPhoneNumberLayout.setVisibility(0);
                    this.mPhoneNumberLayout1.setVisibility(0);
                    this.mPhoneNumberLayout2.setVisibility(8);
                    this.mPhoneNumberLayout3.setVisibility(8);
                    this.mPhoneNumber1.setText(optJSONObject.optString("purePhoneNumber"));
                    this.mPhoneNumberSection1.setVisibility(0);
                    this.mPhoneNumberSection2.setVisibility(8);
                    this.mPhoneNumberSection3.setVisibility(8);
                    this.mSelectPhoneNumber = 1;
                    this.mLineView1.setVisibility(0);
                    this.mLineView2.setVisibility(0);
                    this.mLineView3.setVisibility(8);
                    this.mLineView4.setVisibility(8);
                    this.mOperateNumberBtn.setText("\u4f7f\u7528\u5176\u4ed6\u53f7\u7801");
                    this.mOperateNumberBtn.setVisibility(0);
                    return;
                }
                return;
            }
            if (length == 2) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
                JSONObject optJSONObject3 = jSONArray.optJSONObject(1);
                if (optJSONObject2 == null || optJSONObject3 == null) {
                    return;
                }
                this.mPhoneNumberLayout.setVisibility(0);
                this.mPhoneNumberLayout1.setVisibility(0);
                this.mPhoneNumberLayout2.setVisibility(0);
                this.mPhoneNumberLayout3.setVisibility(8);
                this.mPhoneNumber1.setText(optJSONObject2.optString("purePhoneNumber"));
                this.mPhoneNumber2.setText(optJSONObject3.optString("purePhoneNumber"));
                if (string.equals(optJSONObject2.optString("purePhoneNumber"))) {
                    this.mPhoneNumberSection1.setVisibility(0);
                    this.mSelectPhoneNumber = 1;
                } else {
                    this.mPhoneNumberSection1.setVisibility(8);
                }
                if (string.equals(optJSONObject3.optString("purePhoneNumber"))) {
                    this.mPhoneNumberSection2.setVisibility(0);
                    this.mSelectPhoneNumber = 2;
                } else {
                    this.mPhoneNumberSection2.setVisibility(8);
                }
                if (TextUtils.isEmpty(string)) {
                    this.mPhoneNumberSection1.setVisibility(0);
                }
                this.mPhoneNumberSection3.setVisibility(8);
                this.mLineView1.setVisibility(0);
                this.mLineView2.setVisibility(0);
                this.mLineView3.setVisibility(0);
                this.mLineView4.setVisibility(8);
                this.mOperateNumberBtn.setText("\u7ba1\u7406\u624b\u673a\u53f7\u7801");
                this.mOperateNumberBtn.setVisibility(0);
                return;
            }
            if (length != 3) {
                return;
            }
            JSONObject optJSONObject4 = jSONArray.optJSONObject(0);
            JSONObject optJSONObject5 = jSONArray.optJSONObject(1);
            JSONObject optJSONObject6 = jSONArray.optJSONObject(2);
            if (optJSONObject4 == null || optJSONObject5 == null || optJSONObject6 == null) {
                return;
            }
            this.mPhoneNumberLayout.setVisibility(0);
            this.mPhoneNumberLayout1.setVisibility(0);
            this.mPhoneNumberLayout2.setVisibility(0);
            this.mPhoneNumberLayout3.setVisibility(0);
            this.mPhoneNumber1.setText(optJSONObject4.optString("purePhoneNumber"));
            this.mPhoneNumber2.setText(optJSONObject5.optString("purePhoneNumber"));
            this.mPhoneNumber3.setText(optJSONObject6.optString("purePhoneNumber"));
            if (string.equals(optJSONObject4.optString("purePhoneNumber"))) {
                this.mPhoneNumberSection1.setVisibility(0);
                this.mSelectPhoneNumber = 1;
            } else {
                this.mPhoneNumberSection1.setVisibility(8);
            }
            if (string.equals(optJSONObject5.optString("purePhoneNumber"))) {
                this.mPhoneNumberSection2.setVisibility(0);
                this.mSelectPhoneNumber = 2;
            } else {
                this.mPhoneNumberSection2.setVisibility(8);
            }
            if (string.equals(optJSONObject6.optString("purePhoneNumber"))) {
                this.mPhoneNumberSection3.setVisibility(0);
                this.mSelectPhoneNumber = 3;
            } else {
                this.mPhoneNumberSection3.setVisibility(8);
            }
            this.mLineView1.setVisibility(0);
            this.mLineView2.setVisibility(0);
            this.mLineView3.setVisibility(0);
            this.mLineView4.setVisibility(0);
            this.mOperateNumberBtn.setText("\u7ba1\u7406\u624b\u673a\u53f7\u7801");
            this.mOperateNumberBtn.setVisibility(0);
        }
    }

    public AuthDialog(Activity activity, int i3) {
        super(activity, R.style.f173513f1);
        this.mType = 1;
        this.mAppId = null;
        this.uin = null;
        this.mSelectPhoneNumber = 1;
        this.onceSubOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                int i36 = (AuthDialog.this.onceSubLayout1.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox1.isChecked()) ? 1 : 0;
                if (AuthDialog.this.onceSubLayout2.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox2.isChecked()) {
                    i36++;
                }
                if (AuthDialog.this.onceSubLayout3.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox3.isChecked()) {
                    i36++;
                }
                if (i36 > 0) {
                    AuthDialog.this.mRightBtn.setEnabled(true);
                    AuthDialog.this.mRightBtn.setTextColor(-1);
                } else {
                    AuthDialog.this.mRightBtn.setEnabled(false);
                    AuthDialog.this.mRightBtn.setTextColor(Color.parseColor("#8e909d"));
                }
            }
        };
        this.mContext = activity;
        this.mType = i3;
        if (i3 == 1) {
            initView(activity);
        } else if (i3 == 2) {
            initPhoneNumberView(activity);
        } else if (i3 == 3 || i3 == 4) {
            initOnceSubMsgView(activity, i3);
        }
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        setActivityResultListener();
    }

    private void loadOnceSubItemView(final List<INTERFACE$StSubscribeMessage> list, int i3) {
        if (i3 == 0) {
            this.onceSubTextView1.setText(list.get(0).example.title.get());
            this.onceSubTips1.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AuthDialog.this.showOnceSubItemDetailDialog((INTERFACE$StSubscribeMessage) list.get(0));
                }
            });
        } else if (i3 == 1) {
            this.onceSubTextView2.setText(list.get(1).example.title.get());
            this.onceSubTips2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AuthDialog.this.showOnceSubItemDetailDialog((INTERFACE$StSubscribeMessage) list.get(1));
                }
            });
        } else {
            if (i3 != 2) {
                return;
            }
            this.onceSubTextView3.setText(list.get(2).example.title.get());
            this.onceSubTips3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.AuthDialog.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AuthDialog.this.showOnceSubItemDetailDialog((INTERFACE$StSubscribeMessage) list.get(2));
                }
            });
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        reportAuthDialogExpoTo4239();
    }
}
