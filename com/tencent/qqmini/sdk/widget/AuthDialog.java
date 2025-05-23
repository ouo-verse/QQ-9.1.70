package com.tencent.qqmini.sdk.widget;

import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PrivacyDetailInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AuthDialog extends ReportDialog implements View.OnClickListener {
    public static final String KEY_ONCE_SUB_RESULT_CB_1 = "key_once_sub_cb1";
    public static final String KEY_ONCE_SUB_RESULT_CB_2 = "key_once_sub_cb2";
    public static final String KEY_ONCE_SUB_RESULT_CB_3 = "key_once_sub_cb3";
    public static final String KEY_ONCE_SUB_RESULT_CB_MAINTAIN = "key_once_sub_cb_maintain";
    public static final int REQUEST_CODE_ADD_PHONENUMBER = 1088;
    public static final int REQUEST_CODE_MANAGER_ADD_PHONENUMBER = 1090;
    public static final int REQUEST_CODE_PHONE_MANAGER = 1089;
    private static final String SUB_MINIGAME_REPORT = "minigamesubs";
    private static final String TAG = "AuthDialog";
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_ONCE_SUB_MSG = 3;
    public static final int TYPE_PHONENUMBER = 2;
    public static final int TYPE_SYS_SUB_MSG = 4;
    public static final int TYPE_USER_INFO = 5;
    private static final String UNSUB_MINIGAME_REPORT = "no_mgs";
    private d mActResultListener;
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
    private String mEventName;
    private boolean mIsConfirm;
    private boolean mIsRefuse;
    private TextView mLeftBtn;
    private View mLineView1;
    private View mLineView2;
    private View mLineView3;
    private View mLineView4;
    private IMiniAppContext mMiniAppContext;
    private ImageView mMiniAppIcon;
    private LinearLayout mMiniAppInfoLayout;
    private TextView mMiniAppName;
    private INTERFACE$StSubscribeMessage mMiniGameSubMsg;
    private ImageView mMorePrivacyView;
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
    private PrivacyDetailInfo mPrivacyInfo;
    private AuthDialogResBuilder mResBuilder;
    private TextView mRightBtn;
    private View mRootView;
    private int mSelectPhoneNumber;
    private List<INTERFACE$StSubscribeMessage> mSubMsgNoMaintainAuth;
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
    private String reserves2;
    private String uin;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AuthDialogResBuilder {
        private String mAuthDesc;
        private String mAuthTitle;
        private String mEventName;
        private View.OnClickListener mLeftBtnClickListener;
        private String mLeftBtnText;
        private Drawable mMiniAppIconUrl;
        private MiniAppInfo mMiniAppInfo;
        private String mMiniAppName;
        private JSONArray mPhoneNumberList;
        private String mReportSubAction;
        private View.OnClickListener mRightBtnClickListener;
        private String mRightBtnText;
        private Drawable mUserIconUrl;
        private String mUserName;

        public String getAuthDesc() {
            return this.mAuthDesc;
        }

        public String getAuthTitle() {
            return this.mAuthTitle;
        }

        public String getEventName() {
            return this.mEventName;
        }

        public View.OnClickListener getLeftBtnClickListener() {
            return this.mLeftBtnClickListener;
        }

        public String getLeftBtnText() {
            return this.mLeftBtnText;
        }

        public Drawable getMiniAppIconUrl() {
            return this.mMiniAppIconUrl;
        }

        public MiniAppInfo getMiniAppInfo() {
            return this.mMiniAppInfo;
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

        public Drawable getUserIconUrl() {
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

        public AuthDialogResBuilder setEventName(String str) {
            this.mEventName = str;
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

        public AuthDialogResBuilder setMiniAppIconUrl(Drawable drawable) {
            this.mMiniAppIconUrl = drawable;
            return this;
        }

        public AuthDialogResBuilder setMiniAppInfo(MiniAppInfo miniAppInfo) {
            this.mMiniAppInfo = miniAppInfo;
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

        public AuthDialogResBuilder setUserIconUrl(Drawable drawable) {
            this.mUserIconUrl = drawable;
            return this;
        }

        public AuthDialogResBuilder setUserName(String str) {
            this.mUserName = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f348368d;

        a(List list) {
            this.f348368d = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AuthDialog.this.showOnceSubItemDetailDialog((INTERFACE$StSubscribeMessage) this.f348368d.get(2));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f348370d;

        b(List list) {
            this.f348370d = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AuthDialog.this.showOnceSubItemDetailDialog((INTERFACE$StSubscribeMessage) this.f348370d.get(0));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f348372d;

        c(List list) {
            this.f348372d = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AuthDialog.this.showOnceSubItemDetailDialog((INTERFACE$StSubscribeMessage) this.f348372d.get(1));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class d implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AuthDialog> f348374a;

        d(AuthDialog authDialog) {
            this.f348374a = new WeakReference<>(authDialog);
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            AuthDialog authDialog = this.f348374a.get();
            if (authDialog != null) {
                return authDialog.doOnActivityResult(i3, i16, intent);
            }
            return false;
        }
    }

    public AuthDialog(Activity activity) {
        super(activity, R.style.mini_sdk_MiniAppAuthDialog);
        this.reserves2 = null;
        this.mType = 1;
        this.mAppId = null;
        this.uin = null;
        this.mEventName = null;
        this.mSelectPhoneNumber = 1;
        this.onceSubOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                int i3;
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                if (AuthDialog.this.onceSubLayout1.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox1.isChecked()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
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
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        };
        this.mContext = activity;
        initView(activity);
    }

    private void dealMiniGamePABeforeDismiss() {
        INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage;
        CheckBox checkBox;
        QMLog.d(TAG, "[dealMiniGamePABeforeDismiss mType=" + this.mType + "; isRefuse=" + isRefuse() + "; isConfirm=" + isConfirm());
        List<INTERFACE$StSubscribeMessage> list = this.mSubMsgNoMaintainAuth;
        if (list != null && (iNTERFACE$StSubscribeMessage = this.mMiniGameSubMsg) != null && list.contains(iNTERFACE$StSubscribeMessage)) {
            this.mSubMsgNoMaintainAuth.remove(this.mMiniGameSubMsg);
            int i3 = this.mType;
            if (i3 == 5) {
                checkBox = this.onceSubCheckBox1;
            } else {
                if (i3 == 3 || i3 == 4) {
                    if (this.mSubMsgNoMaintainAuth.size() == 1) {
                        checkBox = this.onceSubCheckBox2;
                    } else if (this.mSubMsgNoMaintainAuth.size() == 2) {
                        checkBox = this.onceSubCheckBox3;
                    }
                }
                checkBox = null;
            }
            if (checkBox == null) {
                QMLog.e(TAG, "[dealMiniGamePABeforeDismiss] miniGameCheck == null type=" + this.mType);
                return;
            }
            if (checkBox.isChecked()) {
                this.reserves2 = "minigamesubs";
            } else {
                this.reserves2 = "no_mgs";
            }
            if (isConfirm() && checkBox.isChecked()) {
                followMiniGamePA();
                return;
            }
            return;
        }
        QMLog.d(TAG, "mMiniGameSubMsg is Empty!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doOnActivityResult(int i3, int i16, Intent intent) {
        QMLog.d(TAG, "doOnActivityResult : " + i3);
        if (i3 == 1089) {
            if (i16 == -1) {
                if (intent != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(intent.getStringExtra("phoneNumberArray"));
                        AuthDialogResBuilder authDialogResBuilder = this.mResBuilder;
                        if (authDialogResBuilder != null) {
                            authDialogResBuilder.setPhoneNumberList(jSONArray);
                            updatePhoneNumberView(this.mResBuilder.getPhoneNumberList());
                        }
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "REQUEST_CODE_PHONE_MANAGER error, ", th5);
                    }
                }
            } else {
                QMLog.e(TAG, "REQUEST_CODE_PHONE_MANAGER " + i16);
            }
            return true;
        }
        if (i3 == 1088) {
            if (i16 == -1) {
                if (intent != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("phoneType", 1);
                        jSONObject.put("purePhoneNumber", intent.getStringExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER));
                        jSONObject.put("countryCode", "+86");
                        jSONObject.put("iv", intent.getStringExtra("iv"));
                        jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, intent.getStringExtra(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
                        QMLog.d(TAG, "REQUEST_CODE_ADD_PHONENUMBER stPhoneNumberObj : " + jSONObject);
                        AuthDialogResBuilder authDialogResBuilder2 = this.mResBuilder;
                        if (authDialogResBuilder2 != null) {
                            authDialogResBuilder2.getPhoneNumberList().mo162put(jSONObject);
                            updatePhoneNumberView(this.mResBuilder.getPhoneNumberList());
                        }
                    } catch (Throwable th6) {
                        QMLog.e(TAG, "REQUEST_CODE_ADD_PHONENUMBER error, ", th6);
                    }
                }
            } else {
                QMLog.e(TAG, "REQUEST_CODE_ADD_PHONENUMBER " + i16);
            }
            return true;
        }
        return false;
    }

    private void doShowPrivacyDetailDialog(PrivacyDetailInfo privacyDetailInfo) {
        if (privacyDetailInfo == null) {
            QMLog.e(TAG, "doShowPrivacyDetailDialog, detailInfo is null");
        } else {
            new com.tencent.qqmini.sdk.widget.a(this.mContext, privacyDetailInfo).show();
        }
    }

    private void followMiniGamePA() {
        SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
        if (specialProxy != null) {
            specialProxy.sendEventToHost(4, null, null);
        }
    }

    private void initOnceSubMsgView(Context context, int i3) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_once_sub_auth_dialog, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
        this.mMiniAppIcon = (ImageView) inflate.findViewById(R.id.mini_app_icon);
        this.mMiniAppName = (TextView) inflate.findViewById(R.id.mini_app_name);
        this.mAuthTitle = (TextView) inflate.findViewById(R.id.auth_title);
        this.mLeftBtn = (TextView) inflate.findViewById(R.id.left_btn);
        this.mRightBtn = (TextView) inflate.findViewById(R.id.right_btn);
        this.onceSubLayout1 = (RelativeLayout) inflate.findViewById(R.id.rl_once_sub_1);
        this.onceSubLayout2 = (RelativeLayout) inflate.findViewById(R.id.rl_once_sub_2);
        this.onceSubLayout3 = (RelativeLayout) inflate.findViewById(R.id.rl_once_sub_3);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.cb_once_sub_1);
        this.onceSubCheckBox1 = checkBox;
        checkBox.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.cb_once_sub_2);
        this.onceSubCheckBox2 = checkBox2;
        checkBox2.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.cb_once_sub_3);
        this.onceSubCheckBox3 = checkBox3;
        checkBox3.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
        this.onceSubMaintainCheckBox = (CheckBox) inflate.findViewById(R.id.cb_maintain);
        this.onceSubTextView1 = (TextView) inflate.findViewById(R.id.tv_once_sub_1);
        this.onceSubTextView2 = (TextView) inflate.findViewById(R.id.tv_once_sub_2);
        this.onceSubTextView3 = (TextView) inflate.findViewById(R.id.tv_once_sub_3);
        this.onceSubTips1 = (ImageView) inflate.findViewById(R.id.iv_once_sub_1);
        this.onceSubTips2 = (ImageView) inflate.findViewById(R.id.iv_once_sub_2);
        this.onceSubTips3 = (ImageView) inflate.findViewById(R.id.iv_once_sub_3);
        if (i3 == 4) {
            inflate.findViewById(R.id.rl_maintain).setVisibility(8);
        }
    }

    private void initPhoneNumberView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_phone_number_auth_dialog, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
        this.mMiniAppInfoLayout = (LinearLayout) inflate.findViewById(R.id.mini_sdk_info_layout);
        this.mMiniAppIcon = (ImageView) inflate.findViewById(R.id.mini_sdk_icon);
        this.mMiniAppName = (TextView) inflate.findViewById(R.id.mini_sdk_name);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.mini_sdk_auth_info_icon);
        this.mAuthInfoImageView = imageView;
        imageView.setOnClickListener(this);
        this.mAuthTitle = (TextView) inflate.findViewById(R.id.auth_title);
        this.mPhoneNumberLayout = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_auth_phone_number_layout);
        this.mPhoneNumberLayout1 = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_phone_number_layout1);
        this.mPhoneNumber1 = (TextView) inflate.findViewById(R.id.mini_sdk_phone_number_1);
        this.mPhoneNumberSection1 = (ImageView) inflate.findViewById(R.id.mini_sdk_phone_number_section_1);
        this.mPhoneNumberLayout1.setOnClickListener(this);
        this.mPhoneNumberLayout2 = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_phone_number_layout2);
        this.mPhoneNumber2 = (TextView) inflate.findViewById(R.id.mini_sdk_phone_number_2);
        this.mPhoneNumberSection2 = (ImageView) inflate.findViewById(R.id.mini_sdk_phone_number_section_2);
        this.mPhoneNumberLayout2.setOnClickListener(this);
        this.mPhoneNumberLayout3 = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_phone_number_layout3);
        this.mPhoneNumber3 = (TextView) inflate.findViewById(R.id.mini_sdk_phone_number_3);
        this.mPhoneNumberSection3 = (ImageView) inflate.findViewById(R.id.mini_sdk_phone_number_section_3);
        this.mPhoneNumberLayout3.setOnClickListener(this);
        this.mLineView1 = inflate.findViewById(R.id.mini_sdk_auth_line1);
        this.mLineView2 = inflate.findViewById(R.id.mini_sdk_auth_line2);
        this.mLineView3 = inflate.findViewById(R.id.mini_sdk_auth_line3);
        this.mLineView4 = inflate.findViewById(R.id.mini_sdk_auth_line4);
        TextView textView = (TextView) inflate.findViewById(R.id.mini_sdk_auth_operate_number);
        this.mOperateNumberBtn = textView;
        textView.setOnClickListener(this);
        this.mConfirmLayout = (LinearLayout) inflate.findViewById(R.id.mini_sdk_auth_confirm_layout);
        this.mLeftBtn = (TextView) inflate.findViewById(R.id.mini_sdk_left_btn);
        this.mRightBtn = (TextView) inflate.findViewById(R.id.mini_sdk_right_btn);
        this.mAuthInfoLayout = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_auth_info_layout);
        this.mAuthInfoBackIcon = (ImageView) inflate.findViewById(R.id.mini_sdk_auth_info_detail_back_icon);
        this.mAuthInfoTitle = (TextView) inflate.findViewById(R.id.mini_sdk_auth_info_detail_title);
        this.mAuthInfoDetailText1 = (TextView) inflate.findViewById(R.id.mini_sdk_auth_info_detail_text1);
        this.mAuthInfoDetailText2 = (TextView) inflate.findViewById(R.id.mini_sdk_auth_info_detail_text2);
        this.mAuthInfoBackIcon.setOnClickListener(this);
        this.uin = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_auth_dialog, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
        this.mMiniAppIcon = (ImageView) inflate.findViewById(R.id.mini_app_icon);
        this.mMiniAppName = (TextView) inflate.findViewById(R.id.mini_app_name);
        this.mAuthTitle = (TextView) inflate.findViewById(R.id.auth_title);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_more_privacy);
        this.mMorePrivacyView = imageView;
        imageView.setOnClickListener(this);
        this.mUserIcon = (ImageView) inflate.findViewById(R.id.user_icon);
        this.mUserName = (TextView) inflate.findViewById(R.id.user_name);
        this.mAuthDesc = (TextView) inflate.findViewById(R.id.auth_desc);
        this.mLeftBtn = (TextView) inflate.findViewById(R.id.left_btn);
        this.mRightBtn = (TextView) inflate.findViewById(R.id.right_btn);
    }

    private void insertMiniGamePA2Dialog() {
        if (!isAddMiniGamePASub()) {
            show();
            return;
        }
        SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
        if (specialProxy == null) {
            show();
        } else {
            specialProxy.sendEventToHost(3, null, new SpecialProxy.EventCallback() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.11
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback
                public void onResult(boolean z16, Bundle bundle) {
                    final INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = null;
                    if (z16) {
                        try {
                            byte[] byteArray = bundle.getByteArray(SpecialProxy.KEY_DATA);
                            if (byteArray != null && byteArray.length > 0) {
                                INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage2 = new INTERFACE$StSubscribeMessage();
                                try {
                                    iNTERFACE$StSubscribeMessage2.mergeFrom(byteArray);
                                    iNTERFACE$StSubscribeMessage = iNTERFACE$StSubscribeMessage2;
                                } catch (Exception e16) {
                                    e = e16;
                                    iNTERFACE$StSubscribeMessage = iNTERFACE$StSubscribeMessage2;
                                    QMLog.e(AuthDialog.TAG, "[insertMiniGamePA2Dialog] error!", e);
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.11.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (iNTERFACE$StSubscribeMessage != null) {
                                                if (AuthDialog.this.mType != 3 && AuthDialog.this.mType != 4) {
                                                    if (AuthDialog.this.mType == 5) {
                                                        AuthDialog.this.mMiniGameSubMsg = iNTERFACE$StSubscribeMessage;
                                                        AuthDialog.this.insertMiniGamePA2UserInfoDialog();
                                                    }
                                                } else {
                                                    AuthDialog.this.mMiniGameSubMsg = iNTERFACE$StSubscribeMessage;
                                                    AuthDialog.this.insertMiniGamePA2SubDialog();
                                                }
                                            }
                                            AuthDialog.this.show();
                                        }
                                    });
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                        }
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iNTERFACE$StSubscribeMessage != null) {
                                if (AuthDialog.this.mType != 3 && AuthDialog.this.mType != 4) {
                                    if (AuthDialog.this.mType == 5) {
                                        AuthDialog.this.mMiniGameSubMsg = iNTERFACE$StSubscribeMessage;
                                        AuthDialog.this.insertMiniGamePA2UserInfoDialog();
                                    }
                                } else {
                                    AuthDialog.this.mMiniGameSubMsg = iNTERFACE$StSubscribeMessage;
                                    AuthDialog.this.insertMiniGamePA2SubDialog();
                                }
                            }
                            AuthDialog.this.show();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertMiniGamePA2SubDialog() {
        if (this.mSubMsgNoMaintainAuth.size() == 1) {
            this.mSubMsgNoMaintainAuth.add(this.mMiniGameSubMsg);
            this.onceSubLayout2.setVisibility(0);
            loadOnceSubItemView(this.mSubMsgNoMaintainAuth, 1);
        } else if (this.mSubMsgNoMaintainAuth.size() == 2) {
            this.mSubMsgNoMaintainAuth.add(this.mMiniGameSubMsg);
            this.onceSubLayout3.setVisibility(0);
            loadOnceSubItemView(this.mSubMsgNoMaintainAuth, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertMiniGamePA2UserInfoDialog() {
        this.onceSubLayout1 = (RelativeLayout) this.mRootView.findViewById(R.id.rl_once_sub_1);
        this.onceSubCheckBox1 = (CheckBox) this.mRootView.findViewById(R.id.cb_once_sub_1);
        this.onceSubTextView1 = (TextView) this.mRootView.findViewById(R.id.tv_once_sub_1);
        this.onceSubTips1 = (ImageView) this.mRootView.findViewById(R.id.iv_once_sub_1);
        this.onceSubLayout1.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        this.mSubMsgNoMaintainAuth = arrayList;
        arrayList.add(this.mMiniGameSubMsg);
        loadOnceSubItemView(this.mSubMsgNoMaintainAuth, 0);
    }

    private boolean isAddMiniGamePASub() {
        int size;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext == null || !iMiniAppContext.isMiniGame()) {
            return false;
        }
        List<INTERFACE$StSubscribeMessage> list = this.mSubMsgNoMaintainAuth;
        if (list == null) {
            size = -1;
        } else {
            size = list.size();
        }
        QMLog.d(TAG, "[isAddMiniGamePASub] mType=" + this.mType + " size=" + size);
        int i3 = this.mType;
        if (i3 == 5) {
            return true;
        }
        if ((i3 != 3 && i3 != 4) || size <= 0 || size >= 3) {
            return false;
        }
        return true;
    }

    private void loadOnceSubItemView(List<INTERFACE$StSubscribeMessage> list, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.onceSubTextView3.setText(list.get(2).example.title.get());
                    this.onceSubTips3.setOnClickListener(new a(list));
                    return;
                }
                return;
            }
            this.onceSubTextView2.setText(list.get(1).example.title.get());
            this.onceSubTips2.setOnClickListener(new c(list));
            return;
        }
        this.onceSubTextView1.setText(list.get(0).example.title.get());
        this.onceSubTips1.setOnClickListener(new b(list));
    }

    private void loadOnceSubMsgBottomBtn() {
        TextView textView = this.mLeftBtn;
        if (textView != null) {
            textView.setText("\u62d2\u7edd");
            this.mLeftBtn.setVisibility(0);
            this.mLeftBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb1", AuthDialog.this.onceSubCheckBox1.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb2", AuthDialog.this.onceSubCheckBox2.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb3", AuthDialog.this.onceSubCheckBox3.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb_maintain", AuthDialog.this.onceSubMaintainCheckBox.isChecked());
                    AuthDialog.this.setRefuse(true);
                    AuthDialog.this.dismiss();
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
        TextView textView2 = this.mRightBtn;
        if (textView2 != null) {
            textView2.setText("\u5141\u8bb8");
            this.mRightBtn.setVisibility(0);
            this.mRightBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb1", AuthDialog.this.onceSubCheckBox1.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb2", AuthDialog.this.onceSubCheckBox2.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb3", AuthDialog.this.onceSubCheckBox3.isChecked());
                    AuthDialog.this.getData().putBoolean("key_once_sub_cb_maintain", AuthDialog.this.onceSubMaintainCheckBox.isChecked());
                    AuthDialog.this.setConfirm(true);
                    AuthDialog.this.dismiss();
                    EventCollector.getInstance().onViewClicked(view);
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
                    QMLog.e(TAG, "loadOnceSubMsgView - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", th5);
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
                this.mSubMsgNoMaintainAuth = arrayList;
                int size = arrayList.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size != 3) {
                            QMLog.e(TAG, "subMsgNoMaintainAuth size > 3 || size == 0!!");
                            return;
                        }
                        this.onceSubLayout1.setVisibility(0);
                        this.onceSubLayout2.setVisibility(0);
                        this.onceSubLayout3.setVisibility(0);
                        loadOnceSubItemView(arrayList, 0);
                        loadOnceSubItemView(arrayList, 1);
                        loadOnceSubItemView(arrayList, 2);
                        return;
                    }
                    this.onceSubLayout1.setVisibility(0);
                    this.onceSubLayout2.setVisibility(0);
                    this.onceSubLayout3.setVisibility(8);
                    loadOnceSubItemView(arrayList, 0);
                    loadOnceSubItemView(arrayList, 1);
                    return;
                }
                this.onceSubLayout1.setVisibility(0);
                this.onceSubLayout2.setVisibility(8);
                this.onceSubLayout3.setVisibility(8);
                loadOnceSubItemView(arrayList, 0);
            }
        }
    }

    private void loadPrivacyInfo() {
        QMLog.d(TAG, "loadPrivacyInfo:" + this.mAppId);
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getMiniAppPrivacyInfo(this.mAppId, this.mEventName, new MiniAppProxy.GetPrivacyInfoListener() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetPrivacyInfoListener
            public void onResult(boolean z16, boolean z17, PrivacyDetailInfo privacyDetailInfo) {
                AuthDialog.this.mPrivacyInfo = privacyDetailInfo;
                QMLog.i(AuthDialog.TAG, "loadPrivacyInfo result\uff1a" + z16 + "," + z17 + "," + privacyDetailInfo);
                if (!z16 || !z17) {
                    AuthDialog.this.mPrivacyInfo = null;
                }
                AuthDialog.this.postPrivacyUIStatus();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPrivacyUIStatus() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.5
            @Override // java.lang.Runnable
            public void run() {
                boolean isShowing = AuthDialog.this.isShowing();
                if (AuthDialog.this.mMorePrivacyView != null) {
                    if (AuthDialog.this.mPrivacyInfo != null) {
                        AuthDialog.this.mMorePrivacyView.setVisibility(0);
                        return;
                    } else {
                        AuthDialog.this.mMorePrivacyView.setVisibility(8);
                        return;
                    }
                }
                QMLog.i(AuthDialog.TAG, "loadPrivacyInfo success but not show:" + isShowing);
            }
        });
    }

    private void realReportTo4239(String str) {
        String reportSubAction = this.mResBuilder.getReportSubAction();
        MiniAppInfo miniAppInfo = this.mResBuilder.getMiniAppInfo();
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "scope", reportSubAction, str, this.reserves2);
    }

    private void setAppIcon(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mMiniAppIcon != null && authDialogResBuilder.getMiniAppIconUrl() != null) {
            this.mMiniAppIcon.setImageDrawable(authDialogResBuilder.getMiniAppIconUrl());
        }
    }

    private void setAppName(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mMiniAppName != null && !TextUtils.isEmpty(authDialogResBuilder.getMiniAppName())) {
            this.mMiniAppName.setText(authDialogResBuilder.getMiniAppName());
        }
    }

    private void setAuthDesc(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mAuthDesc != null) {
            if (!TextUtils.isEmpty(authDialogResBuilder.getAuthDesc())) {
                this.mAuthDesc.setVisibility(0);
                this.mAuthDesc.setText(authDialogResBuilder.getAuthDesc());
            } else {
                this.mAuthDesc.setVisibility(8);
            }
        }
    }

    private void setAuthTitle(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mAuthTitle != null && !TextUtils.isEmpty(authDialogResBuilder.getAuthTitle())) {
            this.mAuthTitle.setText(authDialogResBuilder.getAuthTitle());
        }
    }

    private void setEventName(AuthDialogResBuilder authDialogResBuilder) {
        this.mEventName = authDialogResBuilder.getEventName();
    }

    private void setLeftBtn(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mLeftBtn != null) {
            if (!TextUtils.isEmpty(authDialogResBuilder.getLeftBtnText())) {
                this.mLeftBtn.setText(authDialogResBuilder.getLeftBtnText());
                this.mLeftBtn.setVisibility(0);
                if (authDialogResBuilder.getLeftBtnClickListener() != null) {
                    this.mLeftBtn.setOnClickListener(authDialogResBuilder.getLeftBtnClickListener());
                    return;
                } else {
                    this.mLeftBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            AuthDialog.this.setRefuse(true);
                            AuthDialog.this.dismiss();
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                    return;
                }
            }
            this.mLeftBtn.setVisibility(8);
        }
    }

    private void setRightBtn(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mRightBtn != null) {
            if (!TextUtils.isEmpty(authDialogResBuilder.getRightBtnText())) {
                this.mRightBtn.setText(authDialogResBuilder.getRightBtnText());
                this.mRightBtn.setVisibility(0);
                if (authDialogResBuilder.getRightBtnClickListener() != null) {
                    this.mRightBtn.setOnClickListener(authDialogResBuilder.getRightBtnClickListener());
                    return;
                } else {
                    this.mRightBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            AuthDialog.this.setConfirm(true);
                            AuthDialog.this.dismiss();
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                    return;
                }
            }
            this.mRightBtn.setVisibility(8);
        }
    }

    private void setUserIcon(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mUserIcon != null) {
            if (authDialogResBuilder.getUserIconUrl() != null) {
                this.mUserIcon.setImageDrawable(authDialogResBuilder.getUserIconUrl());
                this.mUserIcon.setVisibility(0);
            } else {
                this.mUserIcon.setVisibility(8);
            }
        }
    }

    private void setUserName(AuthDialogResBuilder authDialogResBuilder) {
        if (this.mUserName != null) {
            if (!TextUtils.isEmpty(authDialogResBuilder.getUserName())) {
                this.mUserName.setText(authDialogResBuilder.getUserName());
                this.mUserName.setVisibility(0);
            } else {
                this.mUserName.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOnceSubItemDetailDialog(INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage) {
        int i3;
        int i16;
        QMLog.e(TAG, "showOnceSubItemDetailDialog detailItem: " + iNTERFACE$StSubscribeMessage.example.title.get());
        View view = this.mRootView;
        if (view != null) {
            i3 = view.getHeight();
            i16 = this.mRootView.getWidth();
        } else {
            i3 = -1;
            i16 = -1;
        }
        AuthJsProxy.AuthDetailDialogResConfig authDetailDialogResConfig = new AuthJsProxy.AuthDetailDialogResConfig();
        authDetailDialogResConfig.dialogType = 1;
        authDetailDialogResConfig.curSubMsg = iNTERFACE$StSubscribeMessage;
        authDetailDialogResConfig.requestHeight = i3;
        authDetailDialogResConfig.requestWidth = i16;
        authDetailDialogResConfig.canceledOnTouchOutside = true;
        ((AuthJsProxy) ProxyManager.get(AuthJsProxy.class)).showAuthListViewHintDialog(this.mContext, authDetailDialogResConfig);
    }

    private void updatePhoneNumber1(JSONArray jSONArray) {
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
        }
    }

    private void updatePhoneNumber2(JSONArray jSONArray, String str) {
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        JSONObject optJSONObject2 = jSONArray.optJSONObject(1);
        if (optJSONObject != null && optJSONObject2 != null) {
            this.mPhoneNumberLayout.setVisibility(0);
            this.mPhoneNumberLayout1.setVisibility(0);
            this.mPhoneNumberLayout2.setVisibility(0);
            this.mPhoneNumberLayout3.setVisibility(8);
            this.mPhoneNumber1.setText(optJSONObject.optString("purePhoneNumber"));
            this.mPhoneNumber2.setText(optJSONObject2.optString("purePhoneNumber"));
            if (str.equals(optJSONObject.optString("purePhoneNumber"))) {
                this.mPhoneNumberSection1.setVisibility(0);
                this.mSelectPhoneNumber = 1;
            } else {
                this.mPhoneNumberSection1.setVisibility(8);
            }
            if (str.equals(optJSONObject2.optString("purePhoneNumber"))) {
                this.mPhoneNumberSection2.setVisibility(0);
                this.mSelectPhoneNumber = 2;
            } else {
                this.mPhoneNumberSection2.setVisibility(8);
            }
            if (TextUtils.isEmpty(str)) {
                this.mPhoneNumberSection1.setVisibility(0);
            }
            this.mPhoneNumberSection3.setVisibility(8);
            this.mLineView1.setVisibility(0);
            this.mLineView2.setVisibility(0);
            this.mLineView3.setVisibility(0);
            this.mLineView4.setVisibility(8);
            this.mOperateNumberBtn.setText("\u7ba1\u7406\u624b\u673a\u53f7\u7801");
            this.mOperateNumberBtn.setVisibility(0);
        }
    }

    private void updatePhoneNumber3(JSONArray jSONArray, String str) {
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        JSONObject optJSONObject2 = jSONArray.optJSONObject(1);
        JSONObject optJSONObject3 = jSONArray.optJSONObject(2);
        if (optJSONObject != null && optJSONObject2 != null && optJSONObject3 != null) {
            this.mPhoneNumberLayout.setVisibility(0);
            this.mPhoneNumberLayout1.setVisibility(0);
            this.mPhoneNumberLayout2.setVisibility(0);
            this.mPhoneNumberLayout3.setVisibility(0);
            this.mPhoneNumber1.setText(optJSONObject.optString("purePhoneNumber"));
            this.mPhoneNumber2.setText(optJSONObject2.optString("purePhoneNumber"));
            this.mPhoneNumber3.setText(optJSONObject3.optString("purePhoneNumber"));
            if (str.equals(optJSONObject.optString("purePhoneNumber"))) {
                this.mPhoneNumberSection1.setVisibility(0);
                this.mSelectPhoneNumber = 1;
            } else {
                this.mPhoneNumberSection1.setVisibility(8);
            }
            if (str.equals(optJSONObject2.optString("purePhoneNumber"))) {
                this.mPhoneNumberSection2.setVisibility(0);
                this.mSelectPhoneNumber = 2;
            } else {
                this.mPhoneNumberSection2.setVisibility(8);
            }
            if (str.equals(optJSONObject3.optString("purePhoneNumber"))) {
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

    private void updatePhoneNumberView(JSONArray jSONArray) {
        if (jSONArray != null) {
            String string = StorageUtil.getPreference().getString(this.uin + "_PhoneNumber", "");
            QMLog.d(TAG, "updatePhoneNumberView phoneNumberArray length : " + jSONArray.length());
            int length = jSONArray.length();
            if (length != 1) {
                if (length != 2) {
                    if (length == 3) {
                        updatePhoneNumber3(jSONArray, string);
                        return;
                    }
                    return;
                }
                updatePhoneNumber2(jSONArray, string);
                return;
            }
            updatePhoneNumber1(jSONArray);
        }
    }

    public void bindData(Bundle bundle) {
        this.mData = bundle;
        if (bundle != null) {
            this.mAppId = bundle.getString("key_appid");
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        dealMiniGamePABeforeDismiss();
        super.dismiss();
        ActivityResultManager.g().removeActivityResultListener(this.mActResultListener);
    }

    public int getAuthDialogType() {
        return this.mType;
    }

    public Bundle getData() {
        return this.mData;
    }

    public JSONObject getSelectPhoneNumber() {
        try {
            AuthDialogResBuilder authDialogResBuilder = this.mResBuilder;
            if (authDialogResBuilder != null) {
                return authDialogResBuilder.getPhoneNumberList().optJSONObject(this.mSelectPhoneNumber - 1);
            }
            return null;
        } catch (Throwable th5) {
            QMLog.e(TAG, "getSelectPhoneNumber error,", th5);
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
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.mini_sdk_phone_number_layout1) {
            this.mPhoneNumberSection1.setVisibility(0);
            this.mPhoneNumberSection2.setVisibility(8);
            this.mPhoneNumberSection3.setVisibility(8);
            this.mSelectPhoneNumber = 1;
        } else if (id5 == R.id.mini_sdk_phone_number_layout2) {
            this.mPhoneNumberSection1.setVisibility(8);
            this.mPhoneNumberSection2.setVisibility(0);
            this.mPhoneNumberSection3.setVisibility(8);
            this.mSelectPhoneNumber = 2;
        } else if (id5 == R.id.mini_sdk_phone_number_layout3) {
            this.mPhoneNumberSection1.setVisibility(8);
            this.mPhoneNumberSection2.setVisibility(8);
            this.mPhoneNumberSection3.setVisibility(0);
            this.mSelectPhoneNumber = 3;
        } else if (id5 == R.id.mini_sdk_auth_operate_number) {
            Intent intent = new Intent();
            intent.putExtra("appId", this.mAppId);
            intent.putExtra("public_fragment_window_feature", 1);
            if (this.mOperateNumberBtn.getText().equals("\u7ba1\u7406\u624b\u673a\u53f7\u7801")) {
                AuthDialogResBuilder authDialogResBuilder = this.mResBuilder;
                if (authDialogResBuilder != null && authDialogResBuilder.getPhoneNumberList() != null && this.mResBuilder.getPhoneNumberList().length() > 0) {
                    intent.putExtra("phoneNumberList", this.mResBuilder.getPhoneNumberList().toString());
                }
                ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                if (channelProxy != null) {
                    channelProxy.launchPhoneNumberManagementFragment(this.mContext, intent, 1089);
                }
            } else {
                ChannelProxy channelProxy2 = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                if (channelProxy2 != null) {
                    channelProxy2.launchAddPhoneNumberFragment(this.mContext, intent, 1088);
                }
            }
        } else if (id5 == R.id.mini_sdk_auth_info_icon) {
            this.mAuthInfoLayout.setVisibility(0);
            this.mAuthTitle.setVisibility(4);
            this.mMiniAppInfoLayout.setVisibility(4);
            this.mAuthInfoImageView.setVisibility(4);
            this.mAuthInfoImageView.setVisibility(4);
            this.mPhoneNumberLayout.setVisibility(4);
            this.mConfirmLayout.setVisibility(4);
        } else if (id5 == R.id.mini_sdk_auth_info_detail_back_icon) {
            this.mAuthInfoLayout.setVisibility(4);
            this.mAuthTitle.setVisibility(0);
            this.mMiniAppInfoLayout.setVisibility(0);
            this.mAuthInfoImageView.setVisibility(0);
            this.mAuthInfoImageView.setVisibility(0);
            this.mPhoneNumberLayout.setVisibility(0);
            this.mConfirmLayout.setVisibility(0);
        } else if (id5 == R.id.iv_more_privacy) {
            doShowPrivacyDetailDialog(this.mPrivacyInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
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
        if (authDialogResBuilder == null) {
            QMLog.e(TAG, "authdialog show error, resBuilder is null, return.");
            return;
        }
        if (this.mType == 2) {
            if (authDialogResBuilder.getPhoneNumberList() != null && authDialogResBuilder.getPhoneNumberList().length() > 0) {
                updatePhoneNumberView(authDialogResBuilder.getPhoneNumberList());
            } else {
                QMLog.e(TAG, "authdialog show error, getPhoneNumberList is null, return.");
                return;
            }
        }
        this.mResBuilder = authDialogResBuilder;
        this.mIsConfirm = false;
        this.mIsRefuse = false;
        setAppIcon(authDialogResBuilder);
        setAppName(authDialogResBuilder);
        setAuthTitle(authDialogResBuilder);
        setUserIcon(authDialogResBuilder);
        setUserName(authDialogResBuilder);
        setEventName(authDialogResBuilder);
        int i3 = this.mType;
        if (i3 == 4) {
            loadOnceSubMsgBottomBtn();
            loadOnceSubMsgView();
            authDialogResBuilder.setReportSubAction(MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_SYS_MSG_SUBSCRIBED);
        } else if (i3 == 3) {
            loadOnceSubMsgBottomBtn();
            loadOnceSubMsgView();
            authDialogResBuilder.setReportSubAction(MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_ONCE_MSG_SUBSCRIBED);
        } else {
            setLeftBtn(authDialogResBuilder);
            setRightBtn(authDialogResBuilder);
            loadPrivacyInfo();
        }
        setAuthDesc(authDialogResBuilder);
        insertMiniGamePA2Dialog();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AuthDialog(Activity activity, IMiniAppContext iMiniAppContext, int i3) {
        super(activity, R.style.mini_sdk_MiniAppAuthDialog);
        Window window;
        this.reserves2 = null;
        this.mType = 1;
        this.mAppId = null;
        this.uin = null;
        this.mEventName = null;
        this.mSelectPhoneNumber = 1;
        this.onceSubOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqmini.sdk.widget.AuthDialog.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                int i36;
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                if (AuthDialog.this.onceSubLayout1.getVisibility() == 0 && AuthDialog.this.onceSubCheckBox1.isChecked()) {
                    i36 = 1;
                } else {
                    i36 = 0;
                }
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
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        };
        this.mContext = activity;
        this.mMiniAppContext = iMiniAppContext;
        this.mType = i3;
        if (i3 != 1) {
            if (i3 == 2) {
                initPhoneNumberView(activity);
            } else if (i3 == 3 || i3 == 4) {
                initOnceSubMsgView(activity, i3);
            } else if (i3 != 5) {
                initView(activity);
            }
            setCanceledOnTouchOutside(true);
            window = getWindow();
            if (window != null) {
                window.setGravity(80);
            }
            this.mActResultListener = new d(this);
            ActivityResultManager.g().addActivityResultListener(this.mActResultListener);
        }
        initView(activity);
        setCanceledOnTouchOutside(true);
        window = getWindow();
        if (window != null) {
        }
        this.mActResultListener = new d(this);
        ActivityResultManager.g().addActivityResultListener(this.mActResultListener);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        Activity activity = this.mContext;
        if (activity == null) {
            QMLog.e(TAG, "show: activity is null.");
            return;
        }
        try {
            if (!activity.isFinishing() && !this.mContext.isDestroyed()) {
                super.show();
                reportAuthDialogExpoTo4239();
                return;
            }
            QMLog.e(TAG, "show: activity is invalid.");
        } catch (Exception e16) {
            QMLog.e(TAG, "show: authDialog show error.", e16);
        }
    }
}
