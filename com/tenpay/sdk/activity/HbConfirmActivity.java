package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.state.data.SquareJSConst;
import com.tenpay.QwLog;
import com.tenpay.impl.ApiInterfaceImpl;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.api.IRealNameSourceReportApi;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.SDKCallbackManager;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.util.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HbConfirmActivity extends NetBaseActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    public static final int AVATAR_C2C = 1;
    public static final int AVATAR_DISCUSS = 101;
    public static final int AVATAR_TROOP = 4;
    public static final int AVATAR_UPDATE = 101;
    public static final int BASE_MSG_UPDATE = 100;
    protected static final String BROADCAST_QQHEAD_GET_HEAD_REQ = "com.tencent.qqhead.getheadreq";
    public static final int HB_ICON_SIZE = 240;
    public static final int NICKNAME_UPDATE = 102;
    protected static final String PERMISSION_QQHEAD_GET_HEAD_REQ = "com.tencent.qqhead.permission.getheadresp";
    public static final int RET_CANCEL = -11001;
    private static final String TAG = "HbConfirmActivity";
    private TextView mAmountText;
    private ImageView mAvatarImg;
    private View mBackView;
    private TextView mCancelView;
    private int mChannel;
    private int mFaceType;
    private TextView mHbBriefText;
    private ResultReceiver mLocalReceiver;
    private TextView mMsgText;
    private String mNickname;
    private ResultReceiver mOutRecevier;
    private String mPushData;
    private String mRecType;
    private String mRecUin;
    private Button mSendHbBtn;
    private TextView mTitleText;
    private String mTotalAmount;
    private String mUnitYuan;
    private String mWish;
    private TextView mWishTip;
    private int mRetCode = -1;
    private String mRetMsg = "";
    private MainHandler mMainHandler = new MainHandler(this);
    private long mlastInvalidatetime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class DiscussAvatarResultReceiver extends ResultReceiver {
        public DiscussAvatarResultReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            if (bundle != null) {
                String string = bundle.getString("avatar_path");
                Bitmap bitmap = (Bitmap) bundle.getParcelable("avatar_bitmap");
                Message obtainMessage = HbConfirmActivity.this.mMainHandler.obtainMessage();
                if (bitmap != null) {
                    obtainMessage.obj = bitmap;
                } else {
                    obtainMessage.obj = string;
                }
                obtainMessage.what = 101;
                HbConfirmActivity.this.mMainHandler.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class MainHandler extends Handler {
        WeakReference<HbConfirmActivity> mRootView;

        MainHandler(HbConfirmActivity hbConfirmActivity) {
            this.mRootView = new WeakReference<>(hbConfirmActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            HbConfirmActivity hbConfirmActivity = this.mRootView.get();
            if (hbConfirmActivity != null && !hbConfirmActivity.isFinishing()) {
                switch (message.what) {
                    case 100:
                        hbConfirmActivity.refreshUI();
                        return;
                    case 101:
                        Object obj = message.obj;
                        if (obj instanceof Bitmap) {
                            hbConfirmActivity.mAvatarImg.setImageBitmap((Bitmap) obj);
                            return;
                        }
                        return;
                    case 102:
                        try {
                            Object obj2 = message.obj;
                            if (obj2 == null || !(obj2 instanceof String)) {
                                str = "";
                            } else {
                                str = (String) obj2;
                            }
                            if (str.length() <= 10 || hbConfirmActivity.mRecType.equals("2")) {
                                hbConfirmActivity.mNickname = str;
                            } else {
                                hbConfirmActivity.mNickname = str.substring(0, 9) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                            }
                            if (hbConfirmActivity.mRecType.equals("2")) {
                                hbConfirmActivity.mHbBriefText.setEllipsize(TextUtils.TruncateAt.END);
                                hbConfirmActivity.mHbBriefText.setSingleLine();
                            }
                            StringBuffer stringBuffer = new StringBuffer("\u53d1\u7ea2\u5305\u7ed9");
                            stringBuffer.append(hbConfirmActivity.mNickname);
                            if (!hbConfirmActivity.mRecType.equals("2")) {
                                stringBuffer.append("(");
                                stringBuffer.append(hbConfirmActivity.mRecUin);
                                stringBuffer.append(")");
                            }
                            hbConfirmActivity.mHbBriefText.setText(stringBuffer.toString());
                            if (hbConfirmActivity.mChannel == 32) {
                                hbConfirmActivity.mWishTip.setText("\u7ea2\u5305\u53e3\u4ee4");
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(HbConfirmActivity.TAG, 1, "", e16);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class NicknameResultReceiver extends ResultReceiver {
        private final int mType;

        public NicknameResultReceiver(Handler handler, int i3) {
            super(handler);
            this.mType = i3;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            String string;
            if (bundle != null) {
                int i16 = this.mType;
                if (i16 != 0 && i16 != 1) {
                    string = bundle.getString("_qwallet_ipc_CorpReq_userNick");
                } else {
                    string = bundle.getString("_qwallet_ipc_CorpReq_memNick");
                }
                if (!TextUtils.isEmpty(string)) {
                    Message obtainMessage = HbConfirmActivity.this.mMainHandler.obtainMessage();
                    obtainMessage.obj = string;
                    obtainMessage.what = 102;
                    HbConfirmActivity.this.mMainHandler.sendMessage(obtainMessage);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum PACK_RECV_TYPE {
        PACK_RECV_TYPE_UIN,
        PACK_RECV_TYPE_DISCUSS,
        PACK_RECV_TYPE_GROUP,
        PACK_RECV_TYPE_TGROUP,
        PACK_RECV_TYPE_TDISC,
        PACK_RECV_TYPE_TOP,
        PACK_RECV_TYPE_NEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class PayReceiver extends ResultReceiver {
        public PayReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            int i16;
            String str;
            if (i3 > 0) {
                if (HbConfirmActivity.this.mOutRecevier != null) {
                    HbConfirmActivity.this.mOutRecevier.send(i3, bundle);
                    return;
                }
                return;
            }
            if (i3 == 0) {
                try {
                    i16 = Integer.parseInt(HbConfirmActivity.this.mRecType) - 1;
                } catch (Exception e16) {
                    QLog.e(HbConfirmActivity.TAG, 1, "", e16);
                    i16 = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uin", HbConfirmActivity.this.mRecUin);
                    jSONObject.put("type", i16);
                    HbConfirmActivity.this.doCallback(0, jSONObject.toString());
                } catch (JSONException e17) {
                    QLog.e(HbConfirmActivity.TAG, 1, "", e17);
                }
                HbConfirmActivity.this.mRetCode = 0;
                HbConfirmActivity.this.mRetMsg = "";
                HbConfirmActivity.this.finish();
                return;
            }
            if (bundle != null) {
                str = bundle.getString("retmsg");
            } else {
                str = "error";
            }
            if (i3 != -1) {
                QQToast.makeText(HbConfirmActivity.this.getContext(), 1, str, 0).show();
            }
        }
    }

    private void getHbTokenId(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", str);
            hashMap.put("push_data", this.mPushData);
            hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
            httpRequest(Cgi.URI_HB_PACK_CONFIRM, hashMap);
            return;
        }
        QQToast.makeText(getContext(), R.string.f171300dw2, 0).show();
    }

    private void getNickname(String str) {
        ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(null, str, new Function1() { // from class: com.tenpay.sdk.activity.be
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$getNickname$0;
                lambda$getNickname$0 = HbConfirmActivity.this.lambda$getNickname$0((String) obj);
                return lambda$getNickname$0;
            }
        });
    }

    private boolean go2Pay() {
        if (!TextUtils.isEmpty(this.mPayTokenId) && !TextUtils.isEmpty(this.mUin)) {
            Bundle bundle = new Bundle();
            bundle.putString("token_id", this.mPayTokenId);
            bundle.putString("uin", this.mUin);
            this.mIsH5Success = true;
            bundle.putInt("come_from", 2);
            bundle.putString(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
            bundle.putString("subscribe_info", this.mSubscribeInfo);
            new ApiInterfaceImpl().gotoPay(getContext(), bundle, this.mLocalReceiver);
            this.mProssesID = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    private void init(View view) {
        initParam();
        initView(view);
        initListener();
        getHbTokenId(this.mUin, this.mPushData);
    }

    private void initListener() {
        this.mSendHbBtn.setOnClickListener(this);
        this.mCancelView.setOnClickListener(this);
    }

    private void initParam() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mPushData = intent.getStringExtra("push_data");
            this.mOutRecevier = (ResultReceiver) intent.getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER);
            PayReceiver payReceiver = new PayReceiver(this.mMainHandler);
            this.mLocalReceiver = payReceiver;
            intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, payReceiver);
        }
        this.mUnitYuan = getString(R.string.ehr);
        this.mProssesID = System.currentTimeMillis();
    }

    private void initView(View view) {
        this.mAmountText = (TextView) view.findViewById(R.id.gg8);
        this.mHbBriefText = (TextView) view.findViewById(R.id.gg9);
        this.mMsgText = (TextView) view.findViewById(R.id.gg_);
        Button button = (Button) view.findViewById(R.id.ggb);
        this.mSendHbBtn = button;
        button.setEnabled(false);
        this.mAvatarImg = (ImageView) view.findViewById(R.id.gft);
        this.mBackView = view.findViewById(R.id.ivTitleBtnLeft);
        this.mCancelView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mTitleText = (TextView) view.findViewById(R.id.ivTitleName);
        this.mWishTip = (TextView) view.findViewById(R.id.gga);
        this.mTitleText.setText(getString(R.string.e8l));
        this.mCancelView.setText(getString(R.string.e5h));
        this.mCancelView.setGravity(5);
        this.mBackView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$getNickname$0(String str) {
        if (this.mMainHandler != null && !TextUtils.isEmpty(str)) {
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.obj = str;
            obtainMessage.what = 102;
            this.mMainHandler.sendMessage(obtainMessage);
        }
        return null;
    }

    private boolean parseBackData(JSONObject jSONObject, HashMap<String, String> hashMap) {
        if (jSONObject != null && hashMap != null) {
            if ("0".equals(jSONObject.optString("retcode"))) {
                this.mPayTokenId = jSONObject.optString("token_id");
                this.mChannel = jSONObject.optInt(WadlProxyConsts.CHANNEL);
                this.mRecType = jSONObject.optString("recv_type");
                this.mRecUin = jSONObject.optString("recv_uin");
                this.mWish = jSONObject.optString("wishing");
                this.mTotalAmount = jSONObject.optString("total_amount");
                return true;
            }
            hashMap.put("code", jSONObject.optString("retcode"));
            hashMap.put("msg", jSONObject.optString("retmsg"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        if (!TextUtils.isEmpty(this.mRecUin) && !TextUtils.isEmpty(this.mWish) && !TextUtils.isEmpty(this.mTotalAmount)) {
            this.mMsgText.setText(this.mWish);
            String str = Utils.fen2Yuan(this.mTotalAmount) + this.mUnitYuan;
            this.mAmountText.setText(str);
            String string = getString(R.string.e7s);
            this.mSendHbBtn.setText(string + str);
            this.mSendHbBtn.setEnabled(true);
        }
    }

    public void doCallback(int i3, String str) {
        QwLog.i("do callback=" + str);
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        try {
            if (i3 != 0) {
                jSONObject.put("err_msg", str);
                bundle.putString("retmsg", jSONObject.toString());
            } else {
                jSONObject.put("user_msg", str);
                bundle.putString("retmsg", jSONObject.toString());
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
        ResultReceiver resultReceiver = this.mOutRecevier;
        if (resultReceiver != null) {
            resultReceiver.send(i3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mRetCode = -11001;
            this.mRetMsg = "cancel";
            finish();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    public void getNickNameAndAvatar(String str) {
        try {
            int parseInt = Integer.parseInt(str) - 1;
            this.mFaceType = 1;
            if (parseInt == PACK_RECV_TYPE.PACK_RECV_TYPE_UIN.ordinal()) {
                getNickname(this.mRecUin);
            } else if (parseInt == PACK_RECV_TYPE.PACK_RECV_TYPE_DISCUSS.ordinal()) {
                this.mFaceType = 101;
                TenUtils.getGroupNickname(this.mRecUin, 1, new NicknameResultReceiver(new Handler(), 1));
            } else if (parseInt == PACK_RECV_TYPE.PACK_RECV_TYPE_GROUP.ordinal()) {
                this.mFaceType = 4;
                TenUtils.getGroupNickname(this.mRecUin, 0, new NicknameResultReceiver(new Handler(), 0));
            } else if (parseInt == PACK_RECV_TYPE.PACK_RECV_TYPE_TGROUP.ordinal()) {
                getNickname(this.mRecUin);
            } else if (parseInt == PACK_RECV_TYPE.PACK_RECV_TYPE_TDISC.ordinal()) {
                getNickname(this.mRecUin);
            }
            TenUtils.getAvatar(this.mRecUin, this.mFaceType, new DiscussAvatarResultReceiver(new Handler()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected int getStatusBarColor() {
        return Color.parseColor("#FF2152");
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        if (this.mMainHandler != null && !isFinishing()) {
            QUIProxy.createCustomDialog(getContext(), 230, null, jSONObject.optString("retmsg"), getString(R.string.e5j), null, null, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ggb) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mlastInvalidatetime + 1000 > currentTimeMillis) {
                this.mlastInvalidatetime = currentTimeMillis;
            } else {
                this.mlastInvalidatetime = currentTimeMillis;
                go2Pay();
            }
        } else if (id5 == R.id.ivTitleBtnRightText) {
            this.mRetCode = -11001;
            this.mRetMsg = "cancel";
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getIntent();
        ((IRealNameSourceReportApi) QRoute.api(IRealNameSourceReportApi.class)).setCurrentNameSource(new RealNameSource("18"));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ae_, viewGroup, false);
        init(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        int i3 = this.mRetCode;
        if (i3 != 0) {
            doCallback(i3, this.mRetMsg);
        }
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (this.mMainHandler == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (parseBackData(jSONObject, hashMap)) {
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 100;
            this.mMainHandler.sendMessage(obtainMessage);
            getNickNameAndAvatar(this.mRecType);
            new ArrayList().add(this.mRecUin);
            return;
        }
        QQToast.makeText(getContext(), 1, "\u89e3\u6790\u53c2\u6570\u9519\u8bef:" + hashMap.get("code"), 0).show();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void sendQQHeadRequest(int i3, ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Intent intent = new Intent("com.tencent.qqhead.getheadreq");
            intent.setPackage(getContext().getPackageName());
            intent.putExtra("faceType", i3);
            intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            getContext().sendBroadcast(intent, "com.tencent.qqhead.permission.getheadresp");
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.mRetCode = -1;
        this.mRetMsg = QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR;
        finish();
    }
}
