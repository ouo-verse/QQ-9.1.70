package com.tenpay.sdk.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.webbundle.sdk.WebBundleConstants;
import com.tenpay.QwLog;
import com.tenpay.sdk.util.ConfigUtil;
import com.tenpay.sdk.util.OnGetResult;
import com.tenpay.sdk.util.QQFaceFileUtil;
import com.tenpay.sdk.util.QRCodeUtils;
import com.tenpay.util.Utils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class QrcodeOverPayActivity extends NetBaseActivity implements View.OnClickListener {
    private static final String FTIP_FMT = "\u5411\u4e2a\u4eba\u7528\u6237%s(%s)\u4ed8\u6b3e";
    private static final String YAN_FMT = "\u8f6c\u8d26\u8bf4\u660e\uff1a%s";
    private View confirm_pay_btn;
    private String dynamic_qrcode_info;
    private TextView overpay_tip;
    private TextView pay_amount;
    private Map<String, String> pmap;
    private ImageView qrcode_img;
    private TextView topay_info;
    private TextView topay_persion_info;

    /* loaded from: classes27.dex */
    private class LoadQQIconTask extends AsyncTask<String, Void, Bitmap> {
        LoadQQIconTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            Bitmap imageByPath = !Utils.isStringNull(str) ? QQFaceFileUtil.getImageByPath(str, 240) : null;
            return imageByPath == null ? QQFaceFileUtil.loadDefaultQQIcon(QrcodeOverPayActivity.this.getContext(), 240, R.drawable.dwv) : imageByPath;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            QwLog.i("set qrcode_headimg......");
            QrcodeOverPayActivity qrcodeOverPayActivity = QrcodeOverPayActivity.this;
            qrcodeOverPayActivity.initQrcode(qrcodeOverPayActivity.pmap, bitmap);
        }
    }

    private Map<String, String> initData() {
        this.dynamic_qrcode_info = getIntent().getStringExtra("dynamic_qrcode_info");
        Bundle bundleExtra = getIntent().getBundleExtra(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA);
        if (!TextUtils.isEmpty(this.dynamic_qrcode_info) && bundleExtra != null) {
            return (HashMap) bundleExtra.getSerializable("transMap");
        }
        QwLog.i("dynamic_qrcode_info is null, " + bundleExtra);
        return null;
    }

    private void initGetFace(String str) {
        new QQFaceFileUtil(new OnGetResult() { // from class: com.tenpay.sdk.activity.QrcodeOverPayActivity.1
            @Override // com.tenpay.sdk.util.OnGetResult
            public void getResult(Object obj) {
                if (obj != null) {
                    String str2 = (String) obj;
                    QwLog.i("path = " + str2);
                    new LoadQQIconTask().execute(str2);
                }
            }
        }).getQQFaceImage(str, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initQrcode(Map<String, String> map, Bitmap bitmap) {
        String str = map.get("payee_uin");
        String str2 = map.get("payee_nick");
        try {
            JSONObject jSONObject = new JSONObject(this.dynamic_qrcode_info);
            this.overpay_tip.setText(jSONObject.optString("desc"));
            this.pay_amount.setText(Utils.transformToMoney(jSONObject.optString("total_fee"), 0));
            this.topay_persion_info.setText(String.format(FTIP_FMT, str2, Utils.hideUin(str, 1)));
            if (!TextUtils.isEmpty(map.get("memo"))) {
                this.topay_info.setVisibility(0);
                this.topay_info.setText(String.format(YAN_FMT, map.get("memo")));
            }
            String optString = jSONObject.optString("uin");
            this.mPayTokenId = jSONObject.optString("token_id");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("a", "1");
                hashMap.put("u", str);
                hashMap.put(DomainData.DOMAIN_NAME, URLEncoder.encode(str2));
                hashMap.put(com.tencent.mobileqq.search.model.ac.f283467k0, URLEncoder.encode(String.format("*%s", this.mPayTokenId)));
                hashMap.put("dy", "1");
                hashMap.put("su", optString);
                this.qrcode_img.setBackgroundDrawable(new BitmapDrawable(QRCodeUtils.getQRCode(ConfigUtil.getQrcodeUrl(hashMap), bitmap, Utils.dp2Px(getContext(), 165.0f), -16777216, -1)));
            } catch (Exception unused) {
                QwLog.i("exception happend...");
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void initView(View view) {
        view.findViewById(R.id.rlCommenTitle).setBackgroundColor(getResources().getColor(17170445));
        ((TextView) view.findViewById(R.id.ivTitleName)).setText("\u4ed8\u6b3e");
        this.overpay_tip = (TextView) view.findViewById(R.id.fgg);
        this.topay_persion_info = (TextView) view.findViewById(R.id.f167003ju0);
        this.pay_amount = (TextView) view.findViewById(R.id.fj7);
        this.qrcode_img = (ImageView) view.findViewById(R.id.h1g);
        this.topay_info = (TextView) view.findViewById(R.id.jtz);
        this.confirm_pay_btn = view.findViewById(R.id.b7s);
        view.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
        this.confirm_pay_btn.setOnClickListener(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        QwLog.i("requestCode = " + i16 + " resultCode = " + i3);
        if (i16 == -1) {
            setRetCodeAndGetBundle(0);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.b7s) {
            Intent intent = new Intent();
            intent.putExtra("token_id", this.mPayTokenId);
            launchFragmentForResult(intent, PayActivity.class, -1);
            com.tencent.mobileqq.qwallet.c.c("tapTransferLimitPayButton", Integer.valueOf(getProcessType()));
        } else if (view.getId() == R.id.ivTitleBtnLeft) {
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Map<String, String> initData = initData();
        this.pmap = initData;
        if (initData == null) {
            setRetCodeAndGetBundle(-101);
            finish();
        } else {
            initGetFace(initData.get("payee_uin"));
            com.tencent.mobileqq.qwallet.c.c("showTransferLimmitview", Integer.valueOf(getProcessType()));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168588ag0, viewGroup, false);
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
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
