package com.qwallet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qwallet.pay.r;
import com.qwallet.pay.v;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QvipPaySVipActivity extends QWalletBaseFragment {
    private MyKeyboardWindow B0;
    int C;
    String D;
    String E;
    private boolean E0;
    boolean F;
    String G;
    String H;
    String I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String P;
    String Q;
    String R;
    int S;
    String T;
    boolean U;
    boolean V;
    String W;
    String X;
    int Y;
    String Z;

    /* renamed from: a0, reason: collision with root package name */
    String f41273a0;

    /* renamed from: b0, reason: collision with root package name */
    String f41274b0;

    /* renamed from: c0, reason: collision with root package name */
    String f41275c0;

    /* renamed from: d0, reason: collision with root package name */
    String f41276d0;

    /* renamed from: e0, reason: collision with root package name */
    String f41277e0;

    /* renamed from: f0, reason: collision with root package name */
    int f41278f0;

    /* renamed from: g0, reason: collision with root package name */
    String f41279g0;

    /* renamed from: h0, reason: collision with root package name */
    String f41280h0;

    /* renamed from: i0, reason: collision with root package name */
    String f41281i0;

    /* renamed from: j0, reason: collision with root package name */
    String f41282j0;

    /* renamed from: k0, reason: collision with root package name */
    String f41283k0;

    /* renamed from: m0, reason: collision with root package name */
    private TextView f41285m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f41286n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f41287o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f41288p0;

    /* renamed from: q0, reason: collision with root package name */
    private TextView f41289q0;

    /* renamed from: r0, reason: collision with root package name */
    private TextView f41290r0;

    /* renamed from: s0, reason: collision with root package name */
    private TextView f41291s0;

    /* renamed from: t0, reason: collision with root package name */
    private EditText f41292t0;

    /* renamed from: u0, reason: collision with root package name */
    private LinearLayout f41293u0;

    /* renamed from: v0, reason: collision with root package name */
    private CheckBox f41294v0;

    /* renamed from: w0, reason: collision with root package name */
    private ImageButton f41295w0;

    /* renamed from: x0, reason: collision with root package name */
    private ImageButton f41296x0;

    /* renamed from: y0, reason: collision with root package name */
    private ImageButton f41297y0;

    /* renamed from: z0, reason: collision with root package name */
    private Button f41298z0;

    /* renamed from: l0, reason: collision with root package name */
    String f41284l0 = "";
    private int A0 = 1;
    private int C0 = 4;
    private boolean D0 = true;
    private TextWatcher F0 = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements IAPMidasPayCallBack {
        b() {
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            if (aPMidasResponse != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    String str = aPMidasResponse.resultMsg;
                    if (str != null && str.length() > 0) {
                        str = str.replace("\\", "\\\\");
                    }
                    jSONObject.put(QzoneIPCModule.RESULT_CODE, aPMidasResponse.resultCode);
                    jSONObject.put("realSaveNum", aPMidasResponse.realSaveNum);
                    jSONObject.put("payChannel", aPMidasResponse.payChannel);
                    jSONObject.put("payState", aPMidasResponse.payState);
                    jSONObject.put("provideState", aPMidasResponse.provideState);
                    jSONObject.put("resultMsg", str);
                    jSONObject.put("extendInfo", aPMidasResponse.extendInfo);
                    jSONObject.put("payReserve1", aPMidasResponse.payReserve1);
                    jSONObject.put("payReserve2", aPMidasResponse.payReserve2);
                    jSONObject.put("payReserve3", aPMidasResponse.payReserve3);
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.qwallet.pay.QvipPaySVipActivity", 2, "openSVipService result:" + jSONObject.toString());
                    }
                    QvipPaySVipActivity qvipPaySVipActivity = QvipPaySVipActivity.this;
                    qvipPaySVipActivity.Oh(qvipPaySVipActivity.C, qvipPaySVipActivity.D, jSONObject.toString(), aPMidasResponse.resultCode);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.qwallet.pay.QvipPaySVipActivity", 2, "openSVipService result json exception");
                    }
                    QvipPaySVipActivity qvipPaySVipActivity2 = QvipPaySVipActivity.this;
                    qvipPaySVipActivity2.Oh(qvipPaySVipActivity2.C, qvipPaySVipActivity2.D, "{'resultCode':-1,'resultMsg':'openSVipService result json exception'}", -97);
                    QLog.e("QvipPaySVipActivity", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.qwallet.pay.QvipPaySVipActivity", 2, "openSVipService payResponseInfo is null");
            }
            QvipPaySVipActivity qvipPaySVipActivity3 = QvipPaySVipActivity.this;
            qvipPaySVipActivity3.Oh(qvipPaySVipActivity3.C, qvipPaySVipActivity3.D, "{'resultCode':-1,'resultMsg':'openSVipService payResponseInfo is null'}", -97);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qwallet.pay.QvipPaySVipActivity", 2, "openSVipService auth login is error");
            }
            QvipPaySVipActivity qvipPaySVipActivity = QvipPaySVipActivity.this;
            qvipPaySVipActivity.Oh(qvipPaySVipActivity.C, qvipPaySVipActivity.D, "{'resultCode':-1,'resultMsg':'openSVipService auth login is error NeedLogin'}", 9000001);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QvipPaySVipActivity.this.B0 != null && QvipPaySVipActivity.this.B0.getVisibility() != 0) {
                QvipPaySVipActivity.this.B0.setVisibility(0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements TextView.OnEditorActionListener {
        d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (keyEvent != null && keyEvent.getKeyCode() == 66 && QvipPaySVipActivity.this.B0 != null && QvipPaySVipActivity.this.B0.getVisibility() == 0 && QvipPaySVipActivity.this.Hh()) {
                QvipPaySVipActivity.this.Jh();
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QvipPaySVipActivity.this.B0 != null && QvipPaySVipActivity.this.B0.getVisibility() == 0) {
                QvipPaySVipActivity.this.B0.setVisibility(8);
            }
            QvipPaySVipActivity.this.Kh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {
        f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QvipPaySVipActivity.this.D0 = z16;
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QvipPaySVipActivity.this.Hh()) {
                QvipPaySVipActivity.this.Jh();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QvipPaySVipActivity.this.E0 = !r0.E0;
            QvipPaySVipActivity qvipPaySVipActivity = QvipPaySVipActivity.this;
            qvipPaySVipActivity.Rh(qvipPaySVipActivity.E0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QvipPaySVipActivity.this.f41292t0.setText("");
            QvipPaySVipActivity.this.f41297y0.setEnabled(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String trim = QvipPaySVipActivity.this.f41292t0.getText().toString().trim();
            if (trim != null && trim.length() > 0) {
                QvipPaySVipActivity.this.f41297y0.setEnabled(true);
                int Qh = QvipPaySVipActivity.this.Qh(trim);
                if (Qh > 1) {
                    QvipPaySVipActivity.this.f41296x0.setEnabled(true);
                    QvipPaySVipActivity.this.f41292t0.setText(String.valueOf(Qh - 1));
                    QvipPaySVipActivity.this.f41292t0.setSelection(QvipPaySVipActivity.this.f41292t0.getText().toString().length());
                } else {
                    QvipPaySVipActivity.this.f41296x0.setEnabled(false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            String trim = QvipPaySVipActivity.this.f41292t0.getText().toString().trim();
            if (trim != null && trim.length() > 0) {
                i3 = QvipPaySVipActivity.this.Qh(trim);
            } else {
                i3 = 0;
            }
            QvipPaySVipActivity.this.f41296x0.setEnabled(true);
            int i16 = i3 + 1;
            if (QvipPaySVipActivity.this.Nh(i16)) {
                QvipPaySVipActivity.this.f41292t0.setText(String.valueOf(i16));
            } else {
                QvipPaySVipActivity.this.f41297y0.setEnabled(false);
            }
            QvipPaySVipActivity.this.f41292t0.setSelection(QvipPaySVipActivity.this.f41292t0.getText().toString().length());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hh() {
        String trim = this.f41292t0.getText().toString().trim();
        if (trim != null && trim.length() > 0) {
            if (Qh(trim) == 0) {
                return false;
            }
            return true;
        }
        QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.rhx), 1).show();
        return false;
    }

    private void Ih() {
        Intent intent = new Intent();
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, this.C);
        intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 2);
        intent.putExtra("result", "");
        intent.putExtra("payRetCode", -97);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        int i3;
        String str;
        b bVar = new b();
        boolean z16 = true;
        if (this.E0) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        EditText editText = this.f41292t0;
        if (editText != null) {
            str = editText.getText().toString().trim();
        } else {
            str = this.T;
        }
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        aPMidasMonthRequest.setOfferId(this.G);
        aPMidasMonthRequest.setUnit(this.H);
        aPMidasMonthRequest.setPayChannel(this.I);
        aPMidasMonthRequest.setOpenId(this.J);
        aPMidasMonthRequest.setOpenKey(this.K);
        aPMidasMonthRequest.setSessionId(this.L);
        aPMidasMonthRequest.setSessionType(this.M);
        aPMidasMonthRequest.setPf(this.N);
        aPMidasMonthRequest.setPfKey(this.P);
        aPMidasMonthRequest.setSaveValue(str);
        aPMidasMonthRequest.setIsCanChange(false);
        aPMidasMonthRequest.setServiceCode(this.Q);
        aPMidasMonthRequest.setServiceName(this.R);
        aPMidasMonthRequest.setServiceType(i3);
        aPMidasMonthRequest.setResId(this.S);
        aPMidasMonthRequest.setAutoPay(this.D0);
        aPMidasMonthRequest.setDiscoutId(this.f41281i0);
        aPMidasMonthRequest.setRemark(this.W);
        aPMidasMonthRequest.setReserv(this.f41282j0);
        aPMidasMonthRequest.setDrmInfo(this.f41284l0);
        APMidasPayAPI.setEnv(this.E);
        if (!this.F || !r.o()) {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(getActivity(), aPMidasMonthRequest);
        APMidasPayAPI.launchPay(getActivity(), aPMidasMonthRequest, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 2);
            jSONObject.put("payState", -1);
            jSONObject.put("provideState", -1);
            jSONObject.put("resultMsg", "");
            Intent intent = new Intent();
            intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, this.C);
            intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
            intent.putExtra("callbackSn", this.D);
            intent.putExtra("result", jSONObject.toString());
            intent.putExtra("payRetCode", -1);
            setResult(-1, intent);
            finish();
        } catch (Exception unused) {
            Ih();
        }
    }

    private void Lh() {
        int i3 = this.Y;
        if (i3 == 1) {
            this.f41285m0.setText(this.X);
            this.f41298z0.setText(this.f41275c0);
            this.f41298z0.setEnabled(true);
        } else if (i3 != 2 && i3 != 3) {
            if (i3 == 4 || i3 == 5) {
                this.f41285m0.setText(this.f41280h0);
            }
        } else {
            this.f41285m0.setText(this.f41279g0);
        }
        int i16 = this.Y;
        if (i16 == 1) {
            this.f41289q0.setVisibility(8);
            this.f41293u0.setVisibility(0);
        } else if (i16 != 2 && i16 != 4) {
            this.f41289q0.setVisibility(0);
            this.f41293u0.setVisibility(8);
        } else {
            this.f41289q0.setVisibility(8);
            this.f41293u0.setVisibility(8);
        }
        if (this.Y == 1) {
            this.f41286n0.setVisibility(0);
            this.f41294v0.setVisibility(8);
        }
        this.f41288p0.setVisibility(0);
        this.f41295w0.setVisibility(8);
    }

    private void Mh() {
        Bundle bundle;
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle == null) {
            Ih();
            return;
        }
        this.C = bundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        this.D = bundle.getString("callbackSn");
        this.E = bundle.getString("setEnv");
        this.F = bundle.getBoolean("setLogEnable", false);
        this.G = bundle.getString("offerId");
        this.H = bundle.getString("unit");
        this.I = bundle.getString("payChannel");
        this.J = bundle.getString("userId");
        this.K = bundle.getString("userKey");
        this.L = bundle.getString("sessionId");
        this.M = bundle.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        this.N = bundle.getString(AdParam.PF);
        this.P = bundle.getString("pfKey");
        this.Q = bundle.getString("serviceCode");
        this.R = bundle.getString("serviceName");
        this.S = bundle.getInt("resId", 0);
        this.T = bundle.getString("openMonth");
        this.U = bundle.getBoolean("isCanChange", true);
        this.V = bundle.getBoolean("isAutoPay", true);
        this.W = bundle.getString("remark");
        this.X = bundle.getString("actTitle");
        this.Y = bundle.getInt("openType");
        this.Z = bundle.getString("actHint");
        this.f41273a0 = bundle.getString("actPayTotal");
        this.f41274b0 = bundle.getString("actPayDiscount");
        this.f41275c0 = bundle.getString("actBtnTitle");
        this.f41276d0 = bundle.getString("openServicePrice");
        this.f41277e0 = bundle.getString("upgradeServicePrice");
        this.f41278f0 = bundle.getInt("maxUpgradeMonth");
        this.f41279g0 = bundle.getString("openTitle");
        this.f41280h0 = bundle.getString("upgradeTitle");
        this.f41281i0 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        this.f41282j0 = bundle.getString("other");
        this.f41283k0 = bundle.getString("couponId");
        this.f41284l0 = bundle.getString("drmInfo");
        this.D0 = this.V;
        int i3 = this.Y;
        if (i3 != 4 && i3 != 5) {
            this.E0 = false;
            this.A0 = 960;
        } else {
            this.E0 = true;
            this.A0 = this.f41278f0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nh(int i3) {
        if (i3 == 0 || i3 <= this.A0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(int i3, String str, String str2, int i16) {
        Intent intent = new Intent();
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, i3);
        intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        intent.putExtra("callbackSn", str);
        intent.putExtra("result", str2);
        intent.putExtra("payRetCode", i16);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        String format;
        String str = null;
        if (!TextUtils.isEmpty(this.f41292t0.getText().toString().trim())) {
            try {
                if (this.Y == 1) {
                    format = this.f41274b0;
                } else if (this.E0 && !TextUtils.isEmpty(this.f41277e0)) {
                    format = String.format("%.2f", Float.valueOf(Integer.valueOf(r0).intValue() * Float.valueOf(this.f41277e0).floatValue()));
                } else if (!this.E0 && !TextUtils.isEmpty(this.f41276d0)) {
                    format = String.format("%.2f", Float.valueOf(Integer.valueOf(r0).intValue() * Float.valueOf(this.f41276d0).floatValue()));
                }
                str = format;
            } catch (Exception e16) {
                QLog.e("QvipPaySVipActivity", 1, "", e16);
            }
        }
        if (str == null || str.equals("")) {
            str = "0.00";
        }
        this.f41287o0.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(boolean z16) {
        if (this.Y == 1) {
            return;
        }
        String str = "";
        if (z16) {
            this.A0 = this.f41278f0;
            this.f41289q0.setText(getString(R.string.g6w));
            this.f41285m0.setText(this.f41280h0);
            this.f41286n0.setVisibility(0);
            this.f41294v0.setVisibility(8);
            this.f41286n0.setText(getString(R.string.g6y) + this.f41278f0 + getString(R.string.g6z));
            this.f41298z0.setText(HardCodeUtil.qqStr(R.string.rhz));
            String trim = this.f41292t0.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                int intValue = Integer.valueOf(trim).intValue();
                if (intValue > this.A0) {
                    int i3 = this.Y;
                    if (i3 == 4 || i3 == 5) {
                        intValue = Integer.valueOf(this.T).intValue();
                    }
                    int i16 = this.A0;
                    if (intValue > i16) {
                        intValue = i16;
                    }
                    trim = "" + intValue;
                }
                str = trim;
            }
            this.f41292t0.setText(str);
            int length = this.f41292t0.getText().toString().length();
            if (length >= 0) {
                this.f41292t0.setSelection(length);
                return;
            }
            return;
        }
        this.A0 = 960;
        this.f41289q0.setText(getString(R.string.g6x));
        this.f41285m0.setText(this.f41279g0);
        this.f41286n0.setVisibility(8);
        this.f41294v0.setVisibility(0);
        this.f41298z0.setText(HardCodeUtil.qqStr(R.string.rhw));
        String trim2 = this.f41292t0.getText().toString().trim();
        if (!TextUtils.isEmpty(trim2)) {
            int intValue2 = Integer.valueOf(trim2).intValue();
            if (intValue2 > this.A0) {
                int i17 = this.Y;
                if (i17 == 2 || i17 == 3) {
                    intValue2 = Integer.valueOf(this.T).intValue();
                }
                int i18 = this.A0;
                if (intValue2 > i18) {
                    intValue2 = i18;
                }
                trim2 = "" + intValue2;
            }
            str = trim2;
        }
        this.f41292t0.setText(str);
        int length2 = this.f41292t0.getText().toString().length();
        if (length2 >= 0) {
            this.f41292t0.setSelection(length2);
        }
    }

    private void initUI(View view) {
        View findViewById = view.findViewById(R.id.qvip_pay_input_root);
        this.f41285m0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_buyinfo);
        this.f41296x0 = (ImageButton) findViewById.findViewById(R.id.qvip_pay_id_buyinput_dec);
        this.f41297y0 = (ImageButton) findViewById.findViewById(R.id.qvip_pay_id_buyinput_add);
        this.f41286n0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_mpinfo);
        Button button = (Button) findViewById.findViewById(R.id.qvip_pay_id_buyinput_paybtn);
        this.f41298z0 = button;
        button.setEnabled(false);
        this.f41287o0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_amount);
        this.f41286n0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_mpinfo);
        this.f41292t0 = (EditText) findViewById.findViewById(R.id.qvip_pay_id_buyinput_num);
        this.f41295w0 = (ImageButton) findViewById.findViewById(R.id.qvip_pay_id_buyinput_delete);
        this.f41288p0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_unitInfo);
        this.f41289q0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_switch);
        this.f41290r0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_pay_total);
        this.f41291s0 = (TextView) findViewById.findViewById(R.id.qvip_pay_id_buyinput_pay_discount);
        this.f41293u0 = (LinearLayout) findViewById.findViewById(R.id.qvip_pay_id_buyinput_layout_discount);
        CheckBox checkBox = (CheckBox) findViewById.findViewById(R.id.qvip_pay_id_buyinput_autopay);
        this.f41294v0 = checkBox;
        checkBox.setChecked(this.D0);
        this.B0 = (MyKeyboardWindow) findViewById.findViewById(R.id.qvip_pay_keyboard);
        QWalletUtils.hideSysKeyBorad(this.f41292t0);
        MyKeyboardWindow myKeyboardWindow = this.B0;
        if (myKeyboardWindow != null) {
            myKeyboardWindow.setInputEditText(this.f41292t0);
            this.B0.setVisibility(0);
            this.B0.setXMode(3);
        }
        this.f41292t0.setImeOptions(6);
        this.f41292t0.setOnClickListener(new c());
        this.f41292t0.setOnEditorActionListener(new d());
        this.f41292t0.setHintTextColor(DownloadCardView.COLOR_APP_VERSION);
        if (this.Y != 1) {
            this.f41292t0.addTextChangedListener(this.F0);
        }
        this.f41292t0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});
        this.f41292t0.setHint(HardCodeUtil.qqStr(R.string.rht));
        Lh();
        this.f41292t0.setText(this.T);
        int length = this.f41292t0.getText().toString().length();
        if (length >= 0) {
            this.f41292t0.setSelection(length);
        }
        ((ImageButton) findViewById.findViewById(R.id.qvip_pay_id_buyinput_close)).setOnClickListener(new e());
        this.f41294v0.setChecked(this.D0);
        this.f41294v0.setOnCheckedChangeListener(new f());
        this.f41298z0.setOnClickListener(new g());
        this.f41289q0.setOnClickListener(new h());
        if (this.f41292t0.getText().toString().length() == 0) {
            this.f41295w0.setVisibility(8);
        }
        this.f41295w0.setOnClickListener(new i());
        this.f41296x0.setOnClickListener(new j());
        this.f41297y0.setOnClickListener(new k());
        if (!TextUtils.isEmpty(this.H)) {
            this.f41288p0.setText(this.H);
        }
        if (this.Y == 1) {
            this.f41292t0.setEnabled(false);
            this.f41296x0.setEnabled(false);
            this.f41297y0.setEnabled(false);
            MyKeyboardWindow myKeyboardWindow2 = this.B0;
            if (myKeyboardWindow2 != null) {
                myKeyboardWindow2.setVisibility(8);
            }
            this.f41290r0.setText(this.f41273a0 + HardCodeUtil.qqStr(R.string.rhy));
            this.f41290r0.getPaint().setFlags(16);
            String format = String.format("%.2f", Float.valueOf(Float.valueOf(this.f41273a0).floatValue() - Float.valueOf(this.f41274b0).floatValue()));
            this.f41291s0.setText(HardCodeUtil.qqStr(R.string.f172509ri0) + format + HardCodeUtil.qqStr(R.string.rhv));
            this.f41286n0.setText(this.Z);
            Ph();
        } else {
            Rh(this.E0);
        }
        if (!this.U) {
            this.f41292t0.setEnabled(false);
            this.f41296x0.setEnabled(false);
            this.f41297y0.setEnabled(false);
            MyKeyboardWindow myKeyboardWindow3 = this.B0;
            if (myKeyboardWindow3 != null) {
                myKeyboardWindow3.setVisibility(8);
            }
        }
    }

    public int Qh(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            MyKeyboardWindow myKeyboardWindow = this.B0;
            if (myKeyboardWindow != null && myKeyboardWindow.getVisibility() == 0) {
                this.B0.setVisibility(8);
                return true;
            }
            Kh();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Mh();
        if (!this.U) {
            Jh();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        if (this.U) {
            view = layoutInflater.inflate(R.layout.bcz, viewGroup, false);
            initUI(view);
        } else {
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            QvipPaySVipActivity.this.Ph();
            if (editable.toString().length() > 0) {
                if (QvipPaySVipActivity.this.C0 != 4) {
                    QvipPaySVipActivity.this.f41295w0.setVisibility(0);
                }
                if (!TextUtils.isEmpty(editable.toString())) {
                    QvipPaySVipActivity.this.f41298z0.setEnabled(true);
                }
            } else {
                QvipPaySVipActivity.this.f41295w0.setVisibility(8);
                QvipPaySVipActivity.this.f41298z0.setEnabled(false);
            }
            if (editable.toString().equals("")) {
                QvipPaySVipActivity.this.f41296x0.setEnabled(false);
                return;
            }
            int Qh = QvipPaySVipActivity.this.Qh(editable.toString().trim());
            if (Qh == 0) {
                QvipPaySVipActivity.this.f41292t0.setText("");
                QvipPaySVipActivity.this.f41296x0.setEnabled(false);
            } else if (Qh > QvipPaySVipActivity.this.A0) {
                QvipPaySVipActivity.this.f41297y0.setEnabled(false);
                QvipPaySVipActivity.this.f41292t0.setText(String.valueOf(QvipPaySVipActivity.this.A0));
                int length = QvipPaySVipActivity.this.f41292t0.getText().toString().length();
                if (length > 0) {
                    QvipPaySVipActivity.this.f41292t0.setSelection(length);
                }
                QQToast.makeText(QvipPaySVipActivity.this.getContext(), HardCodeUtil.qqStr(R.string.rhu) + QvipPaySVipActivity.this.A0, 1).show();
            } else if (Qh == QvipPaySVipActivity.this.A0) {
                QvipPaySVipActivity.this.f41297y0.setEnabled(false);
                QvipPaySVipActivity.this.f41292t0.setSelection(QvipPaySVipActivity.this.f41292t0.getText().toString().length());
            } else {
                QvipPaySVipActivity.this.f41297y0.setEnabled(true);
            }
            if (Qh <= 1) {
                QvipPaySVipActivity.this.f41296x0.setEnabled(false);
            } else {
                QvipPaySVipActivity.this.f41296x0.setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (i3 == 0 && i16 == 1 && i17 == 0) {
                QvipPaySVipActivity.this.Ph();
            }
            String trim = QvipPaySVipActivity.this.f41292t0.getText().toString().trim();
            int length = trim.length();
            if (length != 0 && length != 1 && trim.substring(0, 1).equals("0")) {
                QvipPaySVipActivity.this.f41292t0.setText(trim.substring(1));
                String trim2 = QvipPaySVipActivity.this.f41292t0.getText().toString().trim();
                if (trim2.length() > 0) {
                    QvipPaySVipActivity.this.f41292t0.setSelection(trim2.length());
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
