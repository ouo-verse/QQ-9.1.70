package com.qzone.module.vipcomponent.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.module.vipcomponent.common.VipUtils;
import com.qzone.module.vipcomponent.service.VipInfoManager;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.vip.vipcomponent.util.b;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DiamondYellowOpenActivity extends QzoneOpenBaseActivity {
    public static final int DEFAULT_OPEN_MONTH = 3;
    public static final boolean DEFUALT_AUTOPAY = true;
    public static final boolean DEFUALT_PAYDIRECTGO = false;
    public static final int OPEN_MONTH_ONE_YEAR = 12;
    public static final int PAYRESULT_SUCC = 0;
    public static final int REQUEST_OPEN_VIP_BY_H5 = 2;
    public static final int REQUEST_PAYSDK = 1;
    public static final String TAG = "DiamondYellowOpenActivity";
    public static boolean lock = false;

    /* renamed from: o0, reason: collision with root package name */
    private int f49060o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f49061p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f49062q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f49063r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f49064s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f49065t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f49066u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f49067v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f49068w0;

    /* renamed from: y0, reason: collision with root package name */
    private VipBusinessManager f49070y0;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f49046a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    protected String f49047b0 = "";

    /* renamed from: c0, reason: collision with root package name */
    protected String f49048c0 = "";

    /* renamed from: d0, reason: collision with root package name */
    protected String f49049d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    protected String f49050e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    protected String f49051f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    protected String f49052g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    protected String f49053h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    protected String f49054i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    protected String f49055j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    protected String f49056k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f49057l0 = true;

    /* renamed from: m0, reason: collision with root package name */
    protected String f49058m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    protected String f49059n0 = null;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f49069x0 = false;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f49071z0 = false;
    private Handler A0 = new Handler() { // from class: com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            super.handleMessage(message);
            Intent intent = new Intent();
            if (message.what != 153) {
                VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
                intent.putExtra("viplevel", vipComponentProxy.getServiceInterface().getVipLevel());
                intent.putExtra("viptype", vipComponentProxy.getServiceInterface().getVipType());
                intent.putExtra("cantreatuserasvip", vipComponentProxy.getServiceInterface().getVipType() > 0);
                if (DiamondYellowOpenActivity.this.f49071z0 && VasNormalToggle.QZONE_VIP_REFRESH_FIX.isEnable(true)) {
                    DiamondYellowOpenActivity.this.setResult(-1, intent);
                } else {
                    DiamondYellowOpenActivity.this.setResult(0, intent);
                }
                VipEnv.updateVipFakeStatus(intent);
                DiamondYellowOpenActivity.this.finish();
                return;
            }
            VipComponentProxy vipComponentProxy2 = VipComponentProxy.f50997g;
            intent.putExtra("viplevel", vipComponentProxy2.getServiceInterface().getVipLevel());
            intent.putExtra("viptype", vipComponentProxy2.getServiceInterface().getVipType());
            intent.putExtra("cantreatuserasvip", true);
            if (DiamondYellowOpenActivity.this.f49070y0 != null) {
                b.d(DiamondYellowOpenActivity.TAG, "vipManager.needDisPathResult = " + DiamondYellowOpenActivity.this.f49070y0.needDisPathResult);
            } else {
                b.d(DiamondYellowOpenActivity.TAG, "vipManager.needDisPathResult = null");
            }
            if (DiamondYellowOpenActivity.this.f49070y0 != null && DiamondYellowOpenActivity.this.f49070y0.needDisPathResult) {
                if (2 == DiamondYellowOpenActivity.this.f49064s0) {
                    str = "highVip";
                } else {
                    str = "normalVip";
                }
                intent.putExtra(QZoneHelper.QZONE_VIP_OPEN_SUCC_STR, VipUtils.generateOpenVipInfoResult(str));
            }
            DiamondYellowOpenActivity.this.setResult(-1, intent);
            VipEnv.updateVipFakeStatus(intent);
            if (!TextUtils.isEmpty(DiamondYellowOpenActivity.this.f49048c0)) {
                DiamondYellowOpenActivity diamondYellowOpenActivity = DiamondYellowOpenActivity.this;
                VipEnv.showToast(diamondYellowOpenActivity, 0, diamondYellowOpenActivity.f49048c0);
            }
            DiamondYellowOpenActivity.this.finish();
        }
    };

    private void V2() {
        if (this.f49046a0) {
            if (!VipEnv.isNetworkAvailable()) {
                VipEnv.showToast(this, 0, "\u7f51\u7edc\u65e0\u8fde\u63a5");
                Intent intent = new Intent();
                VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
                intent.putExtra("viplevel", vipComponentProxy.getServiceInterface().getVipLevel());
                intent.putExtra("viptype", vipComponentProxy.getServiceInterface().getVipType());
                intent.putExtra("cantreatuserasvip", vipComponentProxy.getServiceInterface().getVipType() > 0);
                setResult(0, intent);
                finish();
                lock = false;
                return;
            }
            this.f49070y0.directGo = true;
            if (!TextUtils.isEmpty(this.f49054i0)) {
                this.f49070y0.openVipWebPage(this.f49054i0);
                return;
            } else {
                this.f49070y0.openDialogBySetting(this.f49067v0, this.f49064s0, this.f49068w0, this.f49060o0);
                return;
            }
        }
        if (!isFinishing()) {
            this.f49070y0.showOpenVipDialog(this.f49050e0, this.f49053h0, this.f49052g0, this.f49051f0, this.f49067v0, this.f49064s0, this.f49068w0, this.f49060o0);
            return;
        }
        Intent intent2 = new Intent();
        VipComponentProxy vipComponentProxy2 = VipComponentProxy.f50997g;
        intent2.putExtra("viplevel", vipComponentProxy2.getServiceInterface().getVipLevel());
        intent2.putExtra("viptype", vipComponentProxy2.getServiceInterface().getVipType());
        intent2.putExtra("cantreatuserasvip", vipComponentProxy2.getServiceInterface().getVipType() > 0);
        setResult(0, intent2);
        finish();
        lock = false;
    }

    private void W2() {
        this.f49070y0 = new VipBusinessManager(this, this.A0);
        VipBusinessManager.havePaid = false;
    }

    @Override // com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity
    protected boolean Q2() {
        return false;
    }

    @Override // com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity
    protected void R2() {
        if (VipEnv.getQUA().contains("_GM_")) {
            finish();
            return;
        }
        Intent intent = getIntent();
        this.f49049d0 = intent.getStringExtra("aid");
        this.f49053h0 = intent.getStringExtra("dialog_title");
        this.f49048c0 = intent.getStringExtra("success_tips");
        this.f49050e0 = intent.getStringExtra("dialog_msg");
        this.f49052g0 = intent.getStringExtra("pos_btn");
        this.f49051f0 = intent.getStringExtra("neg_btn");
        this.f49054i0 = intent.getStringExtra("url");
        this.f49047b0 = intent.getStringExtra("entrance_refer_id");
        this.f49046a0 = intent.getBooleanExtra("direct_go", false);
        this.f49055j0 = intent.getStringExtra("remark");
        this.f49056k0 = intent.getStringExtra("open_month");
        this.f49057l0 = intent.getBooleanExtra("can_change", true);
        this.f49058m0 = intent.getStringExtra("entrance_offer_id");
        this.f49059n0 = intent.getStringExtra(AdParam.PF);
        long longExtra = intent.getLongExtra("provide_uin", 0L);
        this.f49060o0 = intent.getIntExtra("serviceType", 1);
        this.f49061p0 = intent.getStringExtra("source");
        this.f49062q0 = intent.getStringExtra(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        this.f49063r0 = intent.getBooleanExtra("pay_directgo", false);
        String stringExtra = intent.getStringExtra("viptype");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f49064s0 = VipEnv.strToInt(stringExtra, 0);
        } else {
            this.f49064s0 = intent.getIntExtra("viptype", 0);
        }
        this.f49065t0 = intent.getBooleanExtra("autopay", true);
        this.f49066u0 = intent.getBooleanExtra("need_loading_dialog", true);
        String stringExtra2 = intent.getStringExtra("month");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f49067v0 = VipEnv.strToInt(stringExtra2, 3);
        } else {
            this.f49067v0 = intent.getIntExtra("month", 3);
        }
        boolean booleanExtra = intent.getBooleanExtra("is_nianfei_type", false);
        if (booleanExtra) {
            this.f49067v0 = 12;
        }
        this.f49069x0 = intent.getBooleanExtra("need_report_by_aid", false);
        W2();
        this.f49070y0.setAid(VipEnv.formatAid(this.f49049d0));
        this.f49070y0.setProvideUIn(longExtra);
        this.f49070y0.setServiceType(this.f49060o0);
        this.f49070y0.setSource(this.f49061p0);
        this.f49070y0.setSwitch(this.f49062q0);
        this.f49070y0.setOfferid(this.f49058m0);
        this.f49070y0.setRemark(this.f49055j0);
        this.f49070y0.setPf(this.f49059n0);
        this.f49070y0.setOpenMonth(this.f49056k0, this.f49057l0);
        this.f49070y0.setAutopay(this.f49065t0);
        this.f49070y0.setViptype(this.f49064s0);
        this.f49070y0.setNewOpenmonth(this.f49067v0);
        this.f49070y0.setIsNianFei(booleanExtra);
        this.f49070y0.setNeedLoadingDialog(this.f49066u0);
        this.f49070y0.setNeedReportByAid(this.f49069x0);
        VipEnv.ReportQzoneVipEntrnce(this.f49049d0);
        this.f49071z0 = false;
        if (this.f49063r0) {
            this.f49070y0.payDirect(this.f49067v0, this.f49064s0, this.f49065t0);
        } else {
            this.f49068w0 = VipInfoManager.getInstance().getABTestType();
            V2();
        }
    }

    @Override // com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity
    public void checkLock() {
        if (lock) {
            Intent intent = new Intent();
            VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
            intent.putExtra("viplevel", vipComponentProxy.getServiceInterface().getVipLevel());
            intent.putExtra("viptype", vipComponentProxy.getServiceInterface().getVipType());
            intent.putExtra("cantreatuserasvip", vipComponentProxy.getServiceInterface().getVipType() > 0);
            setResult(0, intent);
            finish();
            return;
        }
        lock = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VipBusinessManager vipBusinessManager = this.f49070y0;
        if (vipBusinessManager != null) {
            vipBusinessManager.onDestroy();
        }
        lock = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        lock = false;
        String str = TAG;
        b.d(str, "resultcode = " + i16 + " requestcode = " + i3);
        if (intent != null && intent.hasExtra("result")) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra("result"));
                VipEnv.reportOpenQZoneVipResult(jSONObject.getInt(QzoneIPCModule.RESULT_CODE), jSONObject.getString("resultMsg"));
                VipEnv.payResultReport(this.f49049d0, jSONObject.getInt(QzoneIPCModule.RESULT_CODE), jSONObject.getString("resultMsg"), jSONObject.getInt("payState"), jSONObject.getInt("provideState"));
                b.d(str, "resultcode = " + jSONObject.getInt(QzoneIPCModule.RESULT_CODE) + " resultMsg = " + jSONObject.getString("resultMsg") + " payState = " + jSONObject.getInt("payState") + "\u3000provideState = " + jSONObject.getInt("provideState"));
                if (jSONObject.has(QzoneIPCModule.RESULT_CODE) && jSONObject.getInt(QzoneIPCModule.RESULT_CODE) == 0) {
                    VipBusinessManager vipBusinessManager = this.f49070y0;
                    if (vipBusinessManager != null) {
                        vipBusinessManager.onPaySuccess();
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                b.b(TAG, e16.getMessage());
            }
        }
        this.f49071z0 = i16 == 50;
        this.f49070y0.onPayEnd();
        this.f49070y0.sendEndMsg(137);
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity
    public void registerEvents() {
    }

    @Override // com.qzone.proxy.vipcomponent.ui.QzoneOpenBaseActivity
    public void unregisterEvents() {
    }
}
