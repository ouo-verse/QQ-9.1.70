package com.tenpay.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.api.TTSUtil;
import com.tenpay.api.TenpayInterface;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.util.ConfigUtil;
import com.tenpay.sdk.util.OnGetResult;
import com.tenpay.sdk.util.QQFaceFileUtil;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.ExpandClearableEditor;
import com.tenpay.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQTransferActivity extends NetBaseActivity {
    public static final int REQ_CHOOSE_RECEIVER_CODE = 102;
    public static final int REQ_PAY_CODE = 101;
    private ImageView mBackBtn;
    private Button mBtnFirstStep;
    private Button mBtnPay;
    private ImageView mCloseBtn;
    private ExpandClearableEditor mEditPayQQ;
    private ClearableEditText mEditPayQQAmount;
    private ClearableEditText mEditPayQQComments;
    private LinearLayout mFirstLayout;
    private MyKeyboardWindow mKeyboard;
    private String mPayQQNum;
    private ImageView mQQHeaderImg;
    private TextView mQQNameTxt;
    private RelativeLayout mRootBgLayout;
    private LinearLayout mRootLayout;
    private LinearLayout mSecondLayout;
    private int mTransMaxFee;
    private String mTransQuotaMsg;
    private String mPayQQName = "";
    private String mSendUin = "";
    private int mIsConfirm = 0;
    private boolean mIsFromForward = false;
    private long mlastInvalidatetime = 0;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.tenpay.sdk.activity.QQTransferActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!QQTransferActivity.this.isFinishing()) {
                QQTransferActivity.this.showPaySuccess(intent);
            }
        }
    };
    private TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.QQTransferActivity.2
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (QQTransferActivity.this.mFirstLayout.getVisibility() == 0) {
                    QQTransferActivity.this.mEditPayQQ.sendAccessibilityEvent(16);
                    if (QQTransferActivity.this.mEditPayQQ.getText().length() > 4) {
                        if (!QQTransferActivity.this.mBtnFirstStep.isEnabled()) {
                            QQTransferActivity.this.mBtnFirstStep.setEnabled(true);
                            QQTransferActivity.this.mBtnFirstStep.setClickable(true);
                            return;
                        }
                        return;
                    }
                    if (QQTransferActivity.this.mBtnFirstStep.isEnabled()) {
                        QQTransferActivity.this.mBtnFirstStep.setClickable(false);
                        QQTransferActivity.this.mBtnFirstStep.setEnabled(false);
                        return;
                    }
                    return;
                }
                if (QQTransferActivity.this.mSecondLayout.getVisibility() == 0) {
                    QQTransferActivity.this.mEditPayQQAmount.sendAccessibilityEvent(16);
                    String obj = QQTransferActivity.this.mEditPayQQAmount.getText().toString();
                    if (obj.length() > 0 && !obj.startsWith(".") && !obj.endsWith(".") && Utils.checkAmountValid(obj)) {
                        float parseFloat = Float.parseFloat(obj);
                        if (QQTransferActivity.this.mTransMaxFee > 0 && !TextUtils.isEmpty(QQTransferActivity.this.mTransQuotaMsg) && parseFloat * 100.0f >= QQTransferActivity.this.mTransMaxFee && !TextUtils.isEmpty(QQTransferActivity.this.mTransQuotaMsg)) {
                            QQToast.makeText(QQTransferActivity.this.getContext(), QQTransferActivity.this.mTransQuotaMsg, 0).show();
                        }
                        if (!QQTransferActivity.this.mBtnPay.isEnabled()) {
                            QQTransferActivity.this.mBtnPay.setEnabled(true);
                            QQTransferActivity.this.mBtnPay.setClickable(true);
                            return;
                        }
                        return;
                    }
                    if (QQTransferActivity.this.mBtnPay.isEnabled()) {
                        QQTransferActivity.this.mBtnPay.setClickable(false);
                        QQTransferActivity.this.mBtnPay.setEnabled(false);
                    }
                }
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) QQTransferActivity.this).TAG, 1, "", e16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    public View.OnFocusChangeListener keyOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.15
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                if (view instanceof ClearableEditText) {
                    ((ClearableEditText) view).manageClearButton();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) QQTransferActivity.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                if (QQTransferActivity.this.mKeyboard != null) {
                    if (view == QQTransferActivity.this.mEditPayQQ) {
                        QQTransferActivity.this.mKeyboard.setXMode(0);
                    } else if (view == QQTransferActivity.this.mEditPayQQAmount) {
                        QQTransferActivity.this.mKeyboard.setXMode(4);
                    }
                    QQTransferActivity.this.mKeyboard.setInputEditText((EditText) view);
                    QQTransferActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.QQTransferActivity.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQTransferActivity.this.mKeyboard.setVisibility(0);
                        }
                    }, 200L);
                    return;
                }
                return;
            }
            if (view instanceof ClearableEditText) {
                ((ClearableEditText) view).removeClearButton();
            }
            if (view instanceof ExpandClearableEditor) {
                ((ClearableEditText) view).removeClearButton();
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class ForwardResultReceiver extends ResultReceiver {
        public ForwardResultReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            ArrayList<String> stringArrayList;
            if (bundle != null && (stringArrayList = bundle.getStringArrayList("choose_friend_uins")) != null && stringArrayList.size() > 0 && QQTransferActivity.this.mEditPayQQ != null) {
                QQTransferActivity.this.mSendUin = stringArrayList.get(0);
                QQTransferActivity.this.mEditPayQQ.setText(QQTransferActivity.this.mSendUin);
                QQTransferActivity.this.mIsFromForward = true;
                QQTransferActivity.this.mBtnFirstStep.performClick();
            }
        }
    }

    private void initView(View view) {
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        ImageView imageView = (ImageView) view.findViewById(R.id.gte);
        this.mCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                QQTransferActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        ImageView imageView2 = (ImageView) view.findViewById(R.id.gtd);
        this.mBackBtn = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                QQTransferActivity.this.mBackBtn.setVisibility(8);
                QQTransferActivity.this.mSecondLayout.setVisibility(8);
                QQTransferActivity.this.mFirstLayout.setVisibility(0);
                QQTransferActivity.this.mEditPayQQ.setText("");
                QQTransferActivity.this.mPayQQNum = "";
                QQTransferActivity.this.mPayQQName = "";
                QQTransferActivity.this.mIsFromForward = false;
                QQTransferActivity.this.mEditPayQQ.manageClearButton();
                QQTransferActivity.this.mBtnFirstStep.setEnabled(false);
                QQTransferActivity.this.mEditPayQQ.requestFocus();
                QQTransferActivity qQTransferActivity = QQTransferActivity.this;
                Utils.touchEditText(qQTransferActivity.mHandler, qQTransferActivity.mEditPayQQ);
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mFirstLayout = (LinearLayout) view.findViewById(R.id.e3l);
        ExpandClearableEditor expandClearableEditor = (ExpandClearableEditor) view.findViewById(R.id.brf);
        this.mEditPayQQ = expandClearableEditor;
        QWalletUtils.hideSysKeyBorad(expandClearableEditor);
        this.mEditPayQQ.addTextChangedListener(this.mTextWatcher);
        this.mEditPayQQ.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mEditPayQQ.setEditorButtonClickListener(new ExpandClearableEditor.OnEditorButtonClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.6
            @Override // com.tenpay.sdk.view.ExpandClearableEditor.OnEditorButtonClickListener
            public void onDefaultRightButtonClicked() {
                QQTransferActivity qQTransferActivity = QQTransferActivity.this;
                QQTransferActivity qQTransferActivity2 = QQTransferActivity.this;
                qQTransferActivity.chooseFriends("\u9009\u62e9\u8054\u7cfb\u4eba", new ForwardResultReceiver(qQTransferActivity2.mHandler));
            }
        });
        this.mEditPayQQ.requestFocus();
        Utils.touchEditText(this.mHandler, this.mEditPayQQ);
        Button button = (Button) view.findViewById(R.id.cbe);
        this.mBtnFirstStep = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                QQTransferActivity.this.onQQConfirmBtnClicked();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mBtnFirstStep.setEnabled(false);
        this.mSecondLayout = (LinearLayout) view.findViewById(R.id.e5h);
        this.mQQHeaderImg = (ImageView) view.findViewById(R.id.gqy);
        this.mQQNameTxt = (TextView) view.findViewById(R.id.grv);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.brg);
        this.mEditPayQQAmount = clearableEditText;
        clearableEditText.addTextChangedListener(this.mTextWatcher);
        this.mEditPayQQAmount.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        QWalletUtils.hideSysKeyBorad(this.mEditPayQQAmount);
        ClearableEditText clearableEditText2 = (ClearableEditText) view.findViewById(R.id.brh);
        this.mEditPayQQComments = clearableEditText2;
        clearableEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                if (z16) {
                    if (QQTransferActivity.this.mKeyboard != null && QQTransferActivity.this.mKeyboard.getVisibility() == 0) {
                        QQTransferActivity.this.mKeyboard.setVisibility(8);
                    }
                    InputMethodManager inputMethodManager = (InputMethodManager) QQTransferActivity.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    if (inputMethodManager != null && !inputMethodManager.isActive()) {
                        inputMethodManager.showSoftInput(QQTransferActivity.this.mEditPayQQComments, 0);
                    }
                }
            }
        });
        this.mEditPayQQComments.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.9
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                if ((i3 == 6 || (keyEvent != null && keyEvent.getKeyCode() == 66)) && QQTransferActivity.this.mBtnPay.isEnabled()) {
                    QQTransferActivity.this.mBtnPay.performClick();
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return false;
            }
        });
        Button button2 = (Button) view.findViewById(R.id.fj9);
        this.mBtnPay = button2;
        button2.setEnabled(false);
        this.mBtnPay.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view2);
                long currentTimeMillis = System.currentTimeMillis();
                if (QQTransferActivity.this.mlastInvalidatetime + 1000 <= currentTimeMillis) {
                    QQTransferActivity.this.mlastInvalidatetime = currentTimeMillis;
                    if (QQTransferActivity.this.mIsFromForward) {
                        str = "0";
                    } else {
                        str = "3";
                    }
                    QQTransferActivity.this.requestTransfer(str);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.root);
        this.mRootBgLayout = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                QQTransferActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.root_layout);
        this.mRootLayout = linearLayout;
        linearLayout.setClickable(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.QQTransferActivity.12
            @Override // java.lang.Runnable
            public void run() {
                QQTransferActivity.this.mRootLayout.startAnimation(AnimationUtils.loadAnimation(QQTransferActivity.this.getContext(), R.anim.f154881ev));
                QQTransferActivity.this.mRootLayout.setVisibility(0);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onQQConfirmBtnClicked$0(String str) {
        if (this.mEditPayQQ != null && this.mQQNameTxt != null) {
            String str2 = "%1$s (" + this.mEditPayQQ.getText().toString() + ")";
            this.mPayQQName = str;
            this.mQQNameTxt.setText(Utils.cutTextByPix(this.mQQNameTxt.getContext(), String.format(str2, str), 250.0f, this.mQQNameTxt.getPaint()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQQConfirmBtnClicked() {
        try {
            String obj = this.mEditPayQQ.getText().toString();
            this.mPayQQNum = obj;
            if (obj.equals(this.mUin)) {
                QQToast.makeText(getContext(), 1, "\u4e0d\u80fd\u5411\u81ea\u5df1\u8f6c\u8d26", 0).show();
                return;
            }
            this.mFirstLayout.setVisibility(8);
            this.mBackBtn.setVisibility(0);
            this.mSecondLayout.setVisibility(0);
            this.mQQNameTxt.setText(this.mPayQQNum);
            this.mEditPayQQAmount.setText("");
            this.mEditPayQQAmount.setSelection(0);
            this.mEditPayQQAmount.manageClearButton();
            this.mEditPayQQComments.setText("");
            this.mEditPayQQComments.manageClearButton();
            this.mEditPayQQAmount.requestFocus();
            this.mEditPayQQAmount.setFocusable(true);
            Utils.touchEditText(this.mHandler, this.mEditPayQQAmount);
            this.mBtnPay.setEnabled(false);
            new QQFaceFileUtil(new OnGetResult() { // from class: com.tenpay.sdk.activity.QQTransferActivity.13
                @Override // com.tenpay.sdk.util.OnGetResult
                public void getResult(Object obj2) {
                    if (obj2 != null) {
                        String str = (String) obj2;
                        QwLog.i("onGetFaceFilePath path=" + str);
                        new QQFaceFileUtil.LoadQQIconTask(QQTransferActivity.this.getContext(), QQTransferActivity.this.mQQHeaderImg, 240).execute(str);
                    }
                }
            }).getQQFaceImage(this.mPayQQNum, getActivity());
            QWalletNickNameServer.b(null, this.mPayQQNum, new Function1() { // from class: com.tenpay.sdk.activity.cu
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit lambda$onQQConfirmBtnClicked$0;
                    lambda$onQQConfirmBtnClicked$0 = QQTransferActivity.this.lambda$onQQConfirmBtnClicked$0((String) obj2);
                    return lambda$onQQConfirmBtnClicked$0;
                }
            });
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void openSkin(View view) {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("skinColorData");
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    int parseColor = Color.parseColor(jSONObject.optString("qrcode_transfer_textcolor"));
                    int parseColor2 = Color.parseColor(jSONObject.optString("qrcode_transfertip_color"));
                    int parseColor3 = Color.parseColor(jSONObject.optString("qrcode_transfer_btn_presscolor"));
                    int parseColor4 = Color.parseColor(jSONObject.optString("qrcode_transfer_btn_normalcolor"));
                    int parseColor5 = Color.parseColor(jSONObject.optString("qrcode_transfer_bg"));
                    ((TextView) view.findViewById(R.id.jvf)).setTextColor(parseColor2);
                    this.mEditPayQQ.setHintTextColor(parseColor);
                    this.mEditPayQQ.setBackgroundDrawable(Utils.createCornerRectDrawable(10, -1, 0, 0));
                    ((LinearLayout) view.findViewById(R.id.f166653h05)).setBackgroundDrawable(Utils.createCornerRectDrawable(10, -1, 0, 0));
                    String stringExtra2 = intent.getStringExtra("507");
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        try {
                            Drawable createFromPath = Drawable.createFromPath(stringExtra2);
                            if (createFromPath != null) {
                                this.mEditPayQQ.setDefaultImgRight(createFromPath);
                            }
                        } catch (Exception e16) {
                            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                        }
                    }
                    ImageView imageView = (ImageView) view.findViewById(R.id.f166651h03);
                    Bitmap createBitmap = Bitmap.createBitmap(Utils.getScreenWidth(getContext()), Utils.dp2Px(getContext(), 94.0f), Bitmap.Config.ARGB_8888);
                    createBitmap.eraseColor(parseColor5);
                    imageView.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), Utils.getRoundedCornerBitmap(createBitmap, 18.0f, true)));
                    ((ImageView) view.findViewById(R.id.f166652h04)).setVisibility(8);
                    view.findViewById(R.id.f166650h02).setBackgroundDrawable(new ColorDrawable(parseColor5));
                    this.mBtnFirstStep.setBackgroundDrawable(Utils.getStateListDrawableWithCorner(parseColor4, parseColor3));
                    this.mBtnPay.setBackgroundDrawable(Utils.getStateListDrawableWithCorner(parseColor4, parseColor3));
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    private void requestPay() {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("come_from", this.mComeFrom + "");
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        httpRequest(Cgi.URI_PAY_GATE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestTransfer(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "3";
        }
        try {
            HashMap hashMap = new HashMap();
            QwLog.e("uin is " + this.mUin);
            hashMap.put("uin", this.mUin);
            hashMap.put("come_from", "2");
            hashMap.put("histrans_sign", "");
            hashMap.put("source", str);
            hashMap.put("payee_uin", this.mPayQQNum);
            hashMap.put("payee_nick", this.mPayQQName);
            hashMap.put("total_fee", Utils.yuan2Fen(this.mEditPayQQAmount.getText().toString()));
            hashMap.put("memo", this.mEditPayQQComments.getText().toString());
            hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
            httpRequest(Cgi.URI_QWallet_REQUEST_TRANSFER, hashMap);
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPaySuccess(Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("retData");
        if (bundleExtra != null && !this.mIsFromForward) {
            try {
                JSONObject jSONObject = new JSONObject(bundleExtra.getString("data"));
                QwLog.e("data received in QQ transfer is: " + jSONObject.toString());
                String optString = jSONObject.optString("callback_url");
                if (optString == null) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer(Uri.decode(optString));
                String optString2 = jSONObject.optString("sp_data");
                if (!TextUtils.isEmpty(optString2)) {
                    stringBuffer.append("&sp_data=");
                    stringBuffer.append(optString2);
                }
                String optString3 = jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID);
                if (!TextUtils.isEmpty(optString3)) {
                    stringBuffer.append("&transaction_id=");
                    stringBuffer.append(optString3);
                }
                String optString4 = jSONObject.optString("total_fee");
                if (!TextUtils.isEmpty(optString4)) {
                    stringBuffer.append("&total_fee=");
                    stringBuffer.append(optString4);
                }
                String optString5 = jSONObject.optString("pay_time");
                if (!TextUtils.isEmpty(optString5)) {
                    stringBuffer.append("&pay_time=");
                    stringBuffer.append(optString5);
                }
                gotoH5(stringBuffer.toString());
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
        if (this.mIsFromForward && !TextUtils.isEmpty(this.mSendUin)) {
            TenUtils.openAio(this.mSendUin, 0);
        }
        finish();
    }

    private boolean startPayeeConfirmDlg(final Intent intent) {
        if (this.mPayQQNum != null && !this.mIsFromForward) {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mPayQQName != null) {
                stringBuffer.append(getString(R.string.eew));
                stringBuffer.append(this.mPayQQName);
                stringBuffer.append("(");
                stringBuffer.append(this.mPayQQNum);
                stringBuffer.append(")");
            } else {
                stringBuffer.append(this.mPayQQNum);
            }
            QUIProxy.createCustomDialog(getContext(), 230, null, stringBuffer.toString(), getString(R.string.cancel), getString(R.string.eep), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.16
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    QQTransferActivity.this.launchFragmentForResult(intent, PayActivity.class, 101);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.17
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            });
            return true;
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 101 && i16 == -1) {
            showPaySuccess(intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ExpandClearableEditor expandClearableEditor;
        getWindow().setSoftInputMode(48);
        getWindow().clearFlags(8192);
        View inflate = layoutInflater.inflate(R.layout.afs, viewGroup, false);
        initView(inflate);
        openSkin(inflate);
        this.mExitEnable = false;
        registerReceiver(this.mBroadcastReceiver, new IntentFilter(Cgi.BROADCAST_INTENT_ACTION_PAYSUCC));
        String stringExtra = getIntent().getStringExtra("recevier_uin");
        this.mSendUin = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && (expandClearableEditor = this.mEditPayQQ) != null) {
            expandClearableEditor.setText(this.mSendUin);
            this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.QQTransferActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    QQTransferActivity.this.mBtnFirstStep.performClick();
                }
            }, 550L);
            this.mIsFromForward = true;
        }
        this.mTransMaxFee = ConfigUtil.getTransQuota();
        this.mTransQuotaMsg = ConfigUtil.getTransQuotaMsg();
        if (TenUtils.isNeedPreConnect(getContext(), this.mUin, "type_mqq_and_myun")) {
            NetUtil.preConnect(getContext(), Cgi.URL_MQQ_PRECONNECT);
            NetUtil.preConnect(getContext(), Cgi.URL_MYUN_PRECONNECT);
            TTSUtil.setViewContentDescription(this.mFirstLayout, "\u8f93\u5165\u5bf9\u65b9QQ\u53f7\u4ed8\u6b3e\u7f16\u8f91\u6846\uff0c\u94b1\u5c06\u5b9e\u65f6\u8f6c\u5165\u5bf9\u65b9QQ\u94b1\u5305\u4f59\u989d");
            TTSUtil.setViewContentDescription(this.mEditPayQQ, "\u8f93\u5165\u5bf9\u65b9QQ\u53f7\u4ed8\u6b3e\u7f16\u8f91\u6846");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BroadcastReceiver broadcastReceiver = this.mBroadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        boolean z16;
        super.onSuccess(str, jSONObject);
        this.mlastInvalidatetime = System.currentTimeMillis();
        if (str.equals(Cgi.URI_QWallet_REQUEST_TRANSFER)) {
            QwLog.e(jSONObject.toString());
            try {
                this.mPayTokenId = jSONObject.optString("token_id");
                this.mIsConfirm = jSONObject.optInt("is_confirm");
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            requestPay();
            return;
        }
        if (Cgi.URI_PAY_GATE.equals(str)) {
            QwLog.e(jSONObject.toString());
            this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
            this.mBargainorName = jSONObject.optString("bargainor_true_name");
            this.mGoodsName = jSONObject.optString("desc");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mTrueName = jSONObject.optString("purchaser_true_name");
            this.mUserAttr = jSONObject.optInt("user_attr");
            this.mCacheVer = jSONObject.optString("interf_cache_ver");
            this.mUserCertType = jSONObject.optInt("cert_user");
            this.mPromotionFee = jSONObject.optString("promotion_fee");
            String optString = jSONObject.optString("promotion_flag");
            this.mPromotionFlag = optString;
            if ("0".equals(optString)) {
                this.mTotalFee = jSONObject.optString("total_fee");
            } else {
                this.mTotalFee = jSONObject.optString("real_fee");
            }
            this.mPromotionName = jSONObject.optString("promotion_name");
            this.mPromotionType = jSONObject.optString("promotion_type");
            this.mPromotionId = jSONObject.optString("promotion_id");
            this.mSubscribeInfo = jSONObject.optString("service_info");
            this.mServiceId = jSONObject.optString("service_id");
            this.mBargainorId = jSONObject.optString("bargainor_id");
            if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1")) {
                if (!TextUtils.isEmpty(this.mPromotionFee) && Double.parseDouble(this.mPromotionFee) >= 0.0d) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    String string = getString(R.string.eaw);
                    Bundle bundle = new Bundle();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("err_msg", string);
                    } catch (Exception unused) {
                    }
                    bundle.putString("retmsg", jSONObject2.toString());
                    QUIProxy.createCustomDialog(getContext(), 230, null, string, getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.QQTransferActivity.14
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                        }
                    });
                } else {
                    try {
                        QwLog.e("when paying in QQ transfer, mComeFrom = " + this.mComeFrom);
                        this.mShowNativePaySuccess = false;
                        jSONObject.put("token_id", this.mPayTokenId);
                        this.mProcessViewTag = TenpayInterface.VIEWTAG_QQ_TRANSFER_PAGE;
                        Intent intent = new Intent();
                        intent.putExtra("pay_gate", jSONObject.toString());
                        intent.putExtra("token_id", this.mPayTokenId);
                        intent.putExtra("isInner", true);
                        intent.putExtra("from_qq_transfer", true);
                        intent.putExtra("is_callback", this.mIsConfirm);
                        if (!startPayeeConfirmDlg(intent)) {
                            launchFragmentForResult(intent, PayActivity.class, 101);
                        }
                    } catch (Exception e17) {
                        QLog.e(((NetBaseActivity) this).TAG, 1, "", e17);
                    }
                }
            } else {
                try {
                    this.mShowNativePaySuccess = false;
                    jSONObject.put("token_id", this.mPayTokenId);
                    QwLog.e("when paying in QQ transfer, mComeFrom = " + this.mComeFrom);
                    this.mProcessViewTag = TenpayInterface.VIEWTAG_QQ_TRANSFER_PAGE;
                    Intent intent2 = new Intent();
                    intent2.putExtra("pay_gate", jSONObject.toString());
                    intent2.putExtra("token_id", this.mPayTokenId);
                    QwLog.e("in QQ transfer, token id put is: " + this.mPayTokenId);
                    intent2.putExtra("isInner", true);
                    intent2.putExtra("from_qq_transfer", true);
                    intent2.putExtra("is_callback", this.mIsConfirm);
                    if (!startPayeeConfirmDlg(intent2)) {
                        launchFragmentForResult(intent2, PayActivity.class, 101);
                    }
                } catch (Exception e18) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e18);
                }
            }
            String optString2 = jSONObject.optString("domain_name");
            if (!TextUtils.isEmpty(optString2)) {
                setServerAddr(optString2);
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
