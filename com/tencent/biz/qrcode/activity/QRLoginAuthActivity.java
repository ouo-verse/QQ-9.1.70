package com.tencent.biz.qrcode.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.ims.devlock_verify_scheme$SchemePkg;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.br;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.open.agent.util.q;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.AutoLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.AutoLoginSwitchState;
import com.tencent.qqnt.kernel.nativeinterface.LoginPlat;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.SecCheckResult;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import com.tencent.qqnt.kernel.nativeinterface.TipsColor;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.json.JSONObject;
import qqlogin.qrlogin.extinfo.QrLoginExtInfo$QrExtInfo;
import wtlogin.qrlogin.scanresult.QrLogin$AutoRenewTicketInfo;
import wtlogin.qrlogin.scanresult.QrLogin$RiskInfo;
import wtlogin.qrlogin.scanresult.QrLogin$ScanResultInfo;
import wtlogin.qrlogin.scanresult.QrLogin$TipsCtrl;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QRLoginAuthActivity extends QBaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String Y0 = HardCodeUtil.qqStr(R.string.f172501re4);
    public static final String Z0 = HardCodeUtil.qqStr(R.string.re5);
    protected String A0;
    protected QQProgressDialog G0;
    protected String H0;
    protected String I0;
    protected int J0;
    protected String L0;
    protected long M0;
    private String N0;
    private long O0;
    private LoginPlat U0;

    /* renamed from: a0, reason: collision with root package name */
    private WtloginManager f94718a0;

    /* renamed from: b0, reason: collision with root package name */
    protected String f94719b0;

    /* renamed from: c0, reason: collision with root package name */
    private QQAppInterface f94720c0;

    /* renamed from: d0, reason: collision with root package name */
    protected BounceScrollView f94721d0;

    /* renamed from: e0, reason: collision with root package name */
    protected TextView f94722e0;

    /* renamed from: f0, reason: collision with root package name */
    protected TextView f94723f0;

    /* renamed from: g0, reason: collision with root package name */
    protected LinearLayout f94724g0;

    /* renamed from: h0, reason: collision with root package name */
    protected LinearLayout f94725h0;

    /* renamed from: i0, reason: collision with root package name */
    protected LinearLayout f94726i0;

    /* renamed from: j0, reason: collision with root package name */
    protected LinearLayout f94727j0;

    /* renamed from: k0, reason: collision with root package name */
    protected LinearLayout f94728k0;

    /* renamed from: l0, reason: collision with root package name */
    protected TextView f94729l0;

    /* renamed from: m0, reason: collision with root package name */
    protected TextView f94730m0;

    /* renamed from: n0, reason: collision with root package name */
    protected TextView f94731n0;

    /* renamed from: o0, reason: collision with root package name */
    protected ImageView f94732o0;

    /* renamed from: p0, reason: collision with root package name */
    protected ImageView f94733p0;

    /* renamed from: q0, reason: collision with root package name */
    protected Button f94734q0;

    /* renamed from: r0, reason: collision with root package name */
    protected Button f94735r0;

    /* renamed from: s0, reason: collision with root package name */
    protected QUIButton f94736s0;

    /* renamed from: t0, reason: collision with root package name */
    protected Button f94737t0;

    /* renamed from: u0, reason: collision with root package name */
    protected Button f94738u0;

    /* renamed from: v0, reason: collision with root package name */
    private View f94739v0;

    /* renamed from: w0, reason: collision with root package name */
    private QUICheckBox f94740w0;

    /* renamed from: z0, reason: collision with root package name */
    protected byte[] f94743z0;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f94741x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    protected int f94742y0 = 0;
    protected boolean B0 = false;
    private boolean C0 = false;
    protected String D0 = null;
    protected String E0 = null;
    protected String F0 = null;
    protected int K0 = -1;
    private final long P0 = 1000;
    private final long Q0 = 1000;
    private int R0 = 0;
    private QrLogin$AutoRenewTicketInfo S0 = null;
    private AutoLoginInfo T0 = null;
    private final f72.a V0 = new c();
    private final com.tencent.mobileqq.loginregister.servlet.h W0 = new d();
    Handler X0 = new j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f94744a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j3, long j16, String str) {
            super(j3, j16);
            this.f94744a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            QUIButton qUIButton = QRLoginAuthActivity.this.f94736s0;
            if (qUIButton != null && qUIButton.getVisibility() == 0) {
                QRLoginAuthActivity.this.f94736s0.setType(0);
                QRLoginAuthActivity.this.f94736s0.setEnabled(true);
                QRLoginAuthActivity.this.f94736s0.setText(this.f94744a);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            QUIButton qUIButton = QRLoginAuthActivity.this.f94736s0;
            if (qUIButton != null && qUIButton.getVisibility() == 0) {
                QRLoginAuthActivity qRLoginAuthActivity = QRLoginAuthActivity.this;
                qRLoginAuthActivity.f94736s0.setText(qRLoginAuthActivity.getString(R.string.f216855zf, String.valueOf((j3 / 1000) + 1)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f94746a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f94747b;

        static {
            int[] iArr = new int[LoginPlat.values().length];
            f94747b = iArr;
            try {
                iArr[LoginPlat.KLOGINPLATMAC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f94747b[LoginPlat.KLOGINPLATIPAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f94747b[LoginPlat.KLOGINPLATIWATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SecCheckResult.values().length];
            f94746a = iArr2;
            try {
                iArr2[SecCheckResult.KRISK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f94746a[SecCheckResult.KSAFE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f94746a[SecCheckResult.KREJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QRLoginAuthActivity.this.doOnBackPressed();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QRLoginAuthActivity.this.f94740w0.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class h implements DialogInterface.OnCancelListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            QRLoginAuthActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class j extends Handler {
        j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        QQProgressDialog qQProgressDialog = QRLoginAuthActivity.this.G0;
                        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                            QRLoginAuthActivity.this.G0.dismiss();
                        }
                        QRLoginAuthActivity.this.e3(null);
                        return;
                    }
                    return;
                }
                int i16 = data.getInt("ret", 1);
                byte[] byteArray = data.getByteArray("errMsg");
                byte[] byteArray2 = data.getByteArray("devInfo");
                if (byteArray2 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(byteArray2, "UTF-8"));
                        QRLoginAuthActivity.this.K0 = jSONObject.optInt("app_type");
                        QRLoginAuthActivity.this.L0 = jSONObject.optString("login_tips");
                        QRLoginAuthActivity.this.M0 = jSONObject.optLong("sub_appid");
                        if (QLog.isColorLevel()) {
                            QLog.d("QRLoginAuthActivity", 2, "ON CLOSE appType:" + QRLoginAuthActivity.this.K0 + ",bannerTips:" + QRLoginAuthActivity.this.L0 + ",subappid:" + QRLoginAuthActivity.this.M0);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } else if (QLog.isDevelopLevel()) {
                    QLog.d("QRLoginAuthActivity", 4, "ON CLOSE devInfo == null");
                }
                QQProgressDialog qQProgressDialog2 = QRLoginAuthActivity.this.G0;
                if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                    QRLoginAuthActivity.this.G0.dismiss();
                }
                if (i16 == 0) {
                    QRLoginAuthActivity.this.f3();
                    return;
                } else {
                    QRLoginAuthActivity.this.e3(new String(byteArray));
                    return;
                }
            }
            QRLoginAuthActivity.this.V2(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public QrLogin$ScanResultInfo f94756a;

        /* renamed from: b, reason: collision with root package name */
        public String f94757b;

        public k(QrLogin$ScanResultInfo qrLogin$ScanResultInfo, String str) {
            this.f94756a = qrLogin$ScanResultInfo;
            this.f94757b = str;
        }
    }

    private void H2() {
        new br().a(this, this.f94720c0, getString(R.string.f1791638m), getString(R.string.f1791538l), "qr_login", null);
    }

    private int J2(int i3) {
        return Math.round(getResources().getDisplayMetrics().density * i3);
    }

    private String K2() {
        if (!d3()) {
            return "4";
        }
        int i3 = this.K0;
        if (i3 == 65793) {
            return "1";
        }
        if (i3 == 5) {
            return "2";
        }
        if (rd0.h.e(i3)) {
            return "3";
        }
        if (this.K0 == 77313) {
            return "5";
        }
        return "";
    }

    private int L2(QrLogin$TipsCtrl qrLogin$TipsCtrl, StringBuilder sb5) {
        if (qrLogin$TipsCtrl == null || !qrLogin$TipsCtrl.has()) {
            return 0;
        }
        int i3 = qrLogin$TipsCtrl.normal_tips_color.get();
        sb5.append(", normalTipsColor=");
        sb5.append(i3);
        return i3;
    }

    private void M2() {
        if (!TextUtils.isEmpty(this.I0)) {
            this.f94722e0.setText(getString(R.string.vod, this.I0));
        } else if (d3()) {
            this.f94722e0.setText(getString(R.string.vod, "QQ"));
        } else {
            this.f94722e0.setText(getString(R.string.f216795z_));
        }
        this.f94722e0.setVisibility(0);
        this.f94722e0.setTextSize(20.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        new br().g(this, this.f94720c0, getString(R.string.f1791638m), getString(R.string.f1791538l), "qr_login", null);
    }

    private void P2() {
        this.f94719b0 = this.f94720c0.getAccount();
        com.tencent.mobileqq.loginregister.servlet.a aVar = QrAgentLoginManager.t().f339978i;
        if (aVar.d() != 0) {
            e3(aVar.c());
        } else if (!p3(QrAgentLoginManager.t().f339978i.e())) {
            s3(0);
            i3("0X800BD92", 0);
        }
    }

    private void S2(byte[] bArr, int i3, int i16, StringBuilder sb5) {
        sb5.append(", handleTlv209");
        QrLoginExtInfo$QrExtInfo qrLoginExtInfo$QrExtInfo = new QrLoginExtInfo$QrExtInfo();
        try {
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i3, bArr2, 0, i16);
            qrLoginExtInfo$QrExtInfo.mergeFrom(bArr2);
            if (!qrLoginExtInfo$QrExtInfo.has()) {
                sb5.append(", qrExtInfo=null");
                return;
            }
            if (qrLoginExtInfo$QrExtInfo.dev_info.has() && qrLoginExtInfo$QrExtInfo.dev_info.dev_type.has() && qrLoginExtInfo$QrExtInfo.dev_info.dev_name.has()) {
                this.D0 = qrLoginExtInfo$QrExtInfo.dev_info.dev_type.get().toStringUtf8();
                sb5.append(", dev_type=");
                sb5.append(this.D0);
                this.F0 = qrLoginExtInfo$QrExtInfo.dev_info.dev_name.get().toStringUtf8();
                sb5.append(", TLV_209 device name:");
                sb5.append(this.F0);
            } else {
                sb5.append(", dev_info=null");
            }
            if (qrLoginExtInfo$QrExtInfo.gen_info.has()) {
                this.J0 = qrLoginExtInfo$QrExtInfo.gen_info.client_appid.get();
                sb5.append(", mClientAppId=");
                sb5.append(this.J0);
                return;
            }
            sb5.append(", gen_info=null");
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QRLoginAuthActivity", 1, e16, new Object[0]);
        }
    }

    private void U2(byte[] bArr, int i3, int i16, StringBuilder sb5) {
        sb5.append(",handleTlv54");
        try {
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i3, bArr2, 0, i16);
            String str = new String(bArr2);
            sb5.append(", appidJson = ");
            sb5.append(str);
            JSONObject jSONObject = new JSONObject(str);
            this.O0 = jSONObject.optLong("open_appid");
            String optString = jSONObject.optString("comefrom");
            if ("app".equals(optString)) {
                optString = "android";
            }
            this.N0 = optString;
        } catch (Throwable th5) {
            QLog.e("QRLoginAuthActivity", 1, th5, new Object[0]);
        }
    }

    private void Y2(boolean z16, int i3) {
        char c16;
        int[] iArr = {R.drawable.qui_equipment_windows, R.drawable.qui_equipment_windows_error, R.drawable.qui_equipment_windows_warning};
        int[] iArr2 = {R.drawable.qui_equipment_ipad, R.drawable.qui_equipment_ipad_error, R.drawable.qui_equipment_ipad_warning};
        int[] iArr3 = {R.drawable.qui_equipment_watch, R.drawable.qui_equipment_watch_error, R.drawable.qui_equipment_watch_warning};
        int[] iArr4 = {R.drawable.qui_equipment_mac, R.drawable.qui_equipment_mac_error, R.drawable.qui_equipment_mac_warning};
        if (!z16) {
            if (i3 == 1) {
                c16 = 1;
            } else {
                c16 = 2;
            }
        } else {
            c16 = 0;
        }
        if (QrAgentLoginManager.t().f339978i != null) {
            int i16 = b.f94747b[this.U0.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        j3(iArr[c16]);
                        return;
                    } else {
                        j3(iArr3[c16]);
                        return;
                    }
                }
                j3(iArr2[c16]);
                return;
            }
            j3(iArr4[c16]);
            return;
        }
        int i17 = this.K0;
        if (i17 != 65793 && i17 != 77313 && i17 != 23) {
            if (i17 == 5) {
                j3(iArr4[c16]);
                return;
            }
            if (i17 == 3) {
                j3(iArr2[c16]);
                return;
            } else if (rd0.h.e(i17)) {
                j3(iArr3[c16]);
                return;
            } else {
                j3(iArr[c16]);
                return;
            }
        }
        j3(iArr[c16]);
    }

    private void Z2(boolean z16, int i3) {
        if (z16) {
            this.f94729l0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            this.f94730m0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            this.f94731n0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        } else {
            this.f94729l0.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
            this.f94730m0.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
            this.f94731n0.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    private void c3(boolean z16, int i3) {
        if (z16) {
            this.f94723f0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        } else if (i3 == 1) {
            this.f94723f0.setTextColor(getResources().getColor(R.color.qui_common_feedback_error));
        } else {
            this.f94723f0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        }
    }

    private boolean d3() {
        int i3 = this.J0;
        if (i3 == 16 || i3 == 1) {
            return true;
        }
        return false;
    }

    private void g3() {
        boolean z16;
        boolean z17;
        int i3 = 0;
        if (QrAgentLoginManager.t().f339978i != null) {
            AutoLoginInfo autoLoginInfo = this.T0;
            if (autoLoginInfo == null) {
                this.f94740w0.setOnCheckedChangeListener(null);
                this.f94739v0.setVisibility(4);
                return;
            } else {
                z16 = autoLoginInfo.getIsShowAutoLoginSwitch();
                if (this.T0.getAutoLoginSwitchState() == AutoLoginSwitchState.KAUTOLOGINSWITCHOPEN) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
        } else {
            QrLogin$AutoRenewTicketInfo qrLogin$AutoRenewTicketInfo = this.S0;
            if (qrLogin$AutoRenewTicketInfo == null) {
                this.f94740w0.setOnCheckedChangeListener(null);
                this.f94739v0.setVisibility(4);
                return;
            } else {
                z16 = qrLogin$AutoRenewTicketInfo.is_show_switch.get();
                z17 = this.S0.is_open_switch.get();
            }
        }
        QLog.i("QRLoginAuthActivity", 1, "showUiByScanResultInfo showAutoLogin: " + z16 + ", openAutoLogin: " + z17);
        View view = this.f94739v0;
        if (!z16) {
            i3 = 4;
        }
        view.setVisibility(i3);
        this.f94740w0.setOnCheckedChangeListener(null);
        this.f94740w0.setChecked(z17);
        this.f94740w0.setOnCheckedChangeListener(this);
    }

    private void h3() {
        if (QrAgentLoginManager.t().f339978i != null) {
            QrAgentLoginManager.t().f339978i.h();
            QrAgentLoginManager.t().f339978i = null;
            finish();
            return;
        }
        doOnBackPressed();
    }

    private void i3(String str, int i3) {
        String str2;
        if (QrAgentLoginManager.t().f339978i != null) {
            return;
        }
        String K2 = K2();
        if ("4".equals(K2())) {
            str2 = this.I0;
        } else {
            str2 = "";
        }
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, K2, "", str2, "");
    }

    private void j3(@DrawableRes int i3) {
        ImageView imageView = this.f94733p0;
        if (imageView != null) {
            imageView.setImageDrawable(getResources().getDrawable(i3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:7:0x0011, B:9:0x0019, B:11:0x001d, B:12:0x003d, B:14:0x0043, B:15:0x004e, B:17:0x0055, B:18:0x0070, B:22:0x0028, B:24:0x002c), top: B:6:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:7:0x0011, B:9:0x0019, B:11:0x001d, B:12:0x003d, B:14:0x0043, B:15:0x004e, B:17:0x0055, B:18:0x0070, B:22:0x0028, B:24:0x002c), top: B:6:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l3() {
        String str;
        String str2;
        if (isFinishing()) {
            QLog.i("QRLoginAuthActivity", 1, "showAutoLoginTipDialog, activity is finishing.");
            return;
        }
        try {
            if (QrAgentLoginManager.t().f339978i != null) {
                AutoLoginInfo autoLoginInfo = this.T0;
                if (autoLoginInfo != null) {
                    str = autoLoginInfo.getTipsTitle();
                    str2 = this.T0.getTipsContent();
                    if (TextUtils.isEmpty(str)) {
                        str = getResources().getString(R.string.f172652r1);
                    }
                    String str3 = str;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getResources().getString(R.string.f172622qy, getResources().getString(R.string.f172632qz));
                    }
                    DialogUtil.createCustomDialog(this, 230, str3, str2, R.string.cancel, R.string.f172612qx, new f(), new g()).show();
                }
                str = null;
                str2 = null;
                if (TextUtils.isEmpty(str)) {
                }
                String str32 = str;
                if (TextUtils.isEmpty(str2)) {
                }
                DialogUtil.createCustomDialog(this, 230, str32, str2, R.string.cancel, R.string.f172612qx, new f(), new g()).show();
            }
            QrLogin$AutoRenewTicketInfo qrLogin$AutoRenewTicketInfo = this.S0;
            if (qrLogin$AutoRenewTicketInfo != null) {
                str = qrLogin$AutoRenewTicketInfo.tips_title.get();
                str2 = this.S0.tips_template.get();
                if (TextUtils.isEmpty(str)) {
                }
                String str322 = str;
                if (TextUtils.isEmpty(str2)) {
                }
                DialogUtil.createCustomDialog(this, 230, str322, str2, R.string.cancel, R.string.f172612qx, new f(), new g()).show();
            }
            str = null;
            str2 = null;
            if (TextUtils.isEmpty(str)) {
            }
            String str3222 = str;
            if (TextUtils.isEmpty(str2)) {
            }
            DialogUtil.createCustomDialog(this, 230, str3222, str2, R.string.cancel, R.string.f172612qx, new f(), new g()).show();
        } catch (Exception e16) {
            QLog.e("QRLoginAuthActivity", 1, "showAutoLoginTipDialog, " + e16);
        }
    }

    private void n3() {
        if (this.G0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
            this.G0 = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.g2y);
            this.G0.setOnCancelListener(new h());
        }
        if (!this.G0.isShowing()) {
            this.G0.show();
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void t3(String str, StringBuilder sb5) {
        this.f94733p0.setVisibility(0);
        this.f94733p0.setImageDrawable(getResources().getDrawable(R.drawable.clj));
        this.f94724g0.setVisibility(8);
        this.f94727j0.setVisibility(8);
        this.f94728k0.setVisibility(8);
        g3();
        this.f94738u0.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.f216775z8);
        }
        sb5.append("\uff0crejectTip=");
        sb5.append(str);
        this.f94722e0.setText(getString(R.string.f216865zg));
        this.f94722e0.setVisibility(0);
        this.f94723f0.setText(str);
        this.f94723f0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        this.f94723f0.setVisibility(0);
        this.f94728k0.setVisibility(8);
        i3("0X800BD92", 3);
    }

    private void u3(String str, int i3) {
        String string;
        if (TextUtils.isEmpty(this.D0)) {
            b3();
        }
        Y2(false, i3);
        Z2(false, i3);
        c3(false, i3);
        M2();
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.f216785z9);
        }
        this.f94723f0.setText(str);
        this.f94723f0.setVisibility(0);
        this.f94727j0.setVisibility(8);
        x3(true);
        this.f94724g0.setVisibility(0);
        this.f94729l0.setVisibility(0);
        if (TextUtils.isEmpty(this.E0)) {
            this.E0 = getString(R.string.iaa);
        }
        this.f94729l0.setText(this.E0);
        if (!TextUtils.isEmpty(this.F0)) {
            this.f94726i0.setVisibility(0);
            this.f94731n0.setText(this.F0);
        }
        this.f94728k0.setVisibility(0);
        if (this.C0) {
            string = getString(R.string.f216895zj);
        } else {
            string = getString(R.string.voe);
        }
        w3(string);
        i3("0X800BD92", 2);
        g3();
    }

    private void w3(String str) {
        this.f94736s0.setType(1);
        this.f94736s0.setEnabled(false);
        new a(5000L, 1000L, str).start();
    }

    private void x3(boolean z16) {
        int i3;
        View view = this.f94739v0;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (z16) {
            i3 = 150;
        } else {
            i3 = 170;
        }
        layoutParams.height = J2(i3);
        this.f94739v0.setLayoutParams(layoutParams);
    }

    private void y3() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.R0 = intent.getIntExtra("KEY_QR_VERIFY_SCAN_SCENE", 0);
        QLog.i("QRLoginAuthActivity", 1, "updateScanScene: " + this.R0);
    }

    protected void I2(boolean z16) {
        boolean z17;
        QUICheckBox qUICheckBox;
        QUICheckBox qUICheckBox2;
        ((ActivateFriendsManager) this.f94720c0.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).l();
        n3();
        if (QrAgentLoginManager.t().f339978i != null) {
            SwitchOperation switchOperation = SwitchOperation.KOPDEFAULT;
            AutoLoginInfo autoLoginInfo = this.T0;
            if (autoLoginInfo != null && autoLoginInfo.getIsShowAutoLoginSwitch() && (qUICheckBox2 = this.f94740w0) != null) {
                switchOperation = qUICheckBox2.isChecked() ? SwitchOperation.KOPDEFAULTOPEN : SwitchOperation.KOPDEFAULTCLOSE;
            }
            QrAgentLoginManager.t().f339978i.f(switchOperation, this.V0);
            return;
        }
        byte[] M = com.tencent.biz.qrcode.util.h.M(this.f94720c0.getOnlineStauts());
        ByteBuffer allocate = ByteBuffer.allocate(M.length + 4);
        allocate.putShort((short) 2);
        allocate.putShort((short) M.length);
        allocate.put(M);
        byte[] array = allocate.array();
        String uinDisplayNameBeforeLogin = this.f94720c0.getUinDisplayNameBeforeLogin(this.f94719b0);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(uinDisplayNameBeforeLogin) && !uinDisplayNameBeforeLogin.equals(this.f94719b0)) {
            byte[] bytes = uinDisplayNameBeforeLogin.getBytes();
            ByteBuffer allocate2 = ByteBuffer.allocate(bytes.length + 4);
            allocate2.putShort((short) 1);
            allocate2.putShort((short) bytes.length);
            allocate2.put(bytes);
            byte[] array2 = allocate2.array();
            ByteBuffer allocate3 = ByteBuffer.allocate(array2.length + 4);
            allocate3.putShort((short) 4);
            allocate3.putShort((short) array2.length);
            allocate3.put(array2);
            byte[] array3 = allocate3.array();
            arrayList.add(HexUtil.bytes2HexStr(array));
            arrayList.add(HexUtil.bytes2HexStr(array3));
        } else {
            arrayList.add(HexUtil.bytes2HexStr(array));
        }
        ByteBuffer allocate4 = ByteBuffer.allocate(8);
        allocate4.putShort((short) 21);
        allocate4.putShort((short) 4);
        allocate4.putInt(z16 ? 1 : 0);
        arrayList.add(HexUtil.bytes2HexStr(allocate4.array()));
        Bundle bundle = new Bundle();
        QrLogin$AutoRenewTicketInfo qrLogin$AutoRenewTicketInfo = this.S0;
        if (qrLogin$AutoRenewTicketInfo != null && qrLogin$AutoRenewTicketInfo.is_show_switch.get() && (qUICheckBox = this.f94740w0) != null) {
            z17 = qUICheckBox.isChecked();
        } else {
            z17 = false;
        }
        QLog.i("QRLoginAuthActivity", 1, "confirmQRLogin allowAutoLogin: " + z17);
        bundle.putByteArray(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, q.b(this.f94720c0, this.R0, z17).toByteArray());
        ((ILoginServletService) this.f94720c0.getRuntimeService(ILoginServletService.class, "all")).closeCode(this.f94719b0, 16L, this.f94743z0, 1, arrayList, this.W0, bundle);
    }

    protected void Q2() {
        if (super.isFinishing()) {
            return;
        }
        Intent intent = super.getIntent();
        this.A0 = intent.getStringExtra("QR_CODE_STRING");
        String stringExtra = intent.getStringExtra("KEY_ERROR_MSG");
        if (intent.getBooleanExtra("KEY_QR_IS_FORBID_LOCAL_PIC", false)) {
            ReportController.o(this.f94720c0, "dc00898", "", "", "0X800C28E", "0X800C28E", intent.getIntExtra("KEY_QR_FORBID_LOCAL_PIC_FROM", 3), 0, "", "", "", "");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            QLog.e("QRLoginAuthActivity", 1, "requestQRLogin, errorMsg is ", stringExtra);
            e3(stringExtra);
            return;
        }
        byte[] bArr = null;
        try {
            int indexOf = this.A0.indexOf("?k=") + 3;
            String substring = this.A0.substring(indexOf, indexOf + 32);
            this.f94743z0 = q.a(substring.getBytes(), substring.length());
            String str = this.A0;
            this.H0 = str.substring(str.indexOf("&f=") + 3);
            if (QrAgentLoginManager.t().f339978i != null) {
                P2();
                return;
            }
            Bundle bundleExtra = intent.getBundleExtra("KEY_QR_VERIFY_CODE_DATA");
            if (bundleExtra == null) {
                QLog.e("QRLoginAuthActivity", 1, "handleQRLoginData, but qrVerifyCodeData is null!");
                e3(null);
                return;
            }
            this.f94719b0 = bundleExtra.getString("KEY_QR_VERIFY_ACCOUNT");
            this.C0 = bundleExtra.getBoolean("KEY_QR_VERIFY_IS_OPEN");
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("KEY_QR_VERIFY_TLV");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    try {
                        byteArrayOutputStream.write(HexUtil.hexStr2Bytes(stringArrayList.get(i3)));
                    } catch (Throwable th5) {
                        QLog.e("QRLoginAuthActivity", 1, "String array to Byte array error :" + th5);
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
            }
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt("ret", bundleExtra.getInt("KEY_QR_VERIFY_RET"));
            bundle.putByteArray("tlv", bArr);
            bundle.putByteArray("appName", bundleExtra.getByteArray("KEY_QR_VERIFY_APPNAME"));
            bundle.putByteArray("errMsg", bundleExtra.getByteArray("KEY_QR_VERIFY_ERROR_MSG"));
            message.setData(bundle);
            message.what = 1;
            this.X0.sendMessage(message);
        } catch (Exception e16) {
            QLog.e("QRLoginAuthActivity", 1, "qrCodeString illegal, qrCode: ", this.A0, " exception: ", e16.getMessage());
            e3(null);
        }
    }

    public QrLogin$ScanResultInfo R2(byte[] bArr, int i3, int i16, StringBuilder sb5) {
        sb5.append(",handleTlv208");
        QrLogin$ScanResultInfo qrLogin$ScanResultInfo = new QrLogin$ScanResultInfo();
        try {
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i3, bArr2, 0, i16);
            qrLogin$ScanResultInfo.mergeFrom(bArr2);
        } catch (Throwable th5) {
            QLog.e("QRLoginAuthActivity", 1, th5, new Object[0]);
        }
        if (qrLogin$ScanResultInfo.scan_result.has()) {
            sb5.append(",scan=");
            sb5.append(qrLogin$ScanResultInfo.scan_result.get());
            return qrLogin$ScanResultInfo;
        }
        sb5.append(",scan=null");
        return null;
    }

    public void T2(byte[] bArr, int i3, int i16) {
        boolean z16;
        boolean z17;
        try {
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i3, bArr2, 0, i16);
            devlock_verify_scheme$SchemePkg devlock_verify_scheme_schemepkg = new devlock_verify_scheme$SchemePkg();
            devlock_verify_scheme_schemepkg.mergeFrom(bArr2);
            if (devlock_verify_scheme_schemepkg.u32_button2_type.has() && devlock_verify_scheme_schemepkg.u32_button2_type.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (devlock_verify_scheme_schemepkg.str_button2_caption.has() && !TextUtils.isEmpty(devlock_verify_scheme_schemepkg.str_button2_caption.get())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (devlock_verify_scheme_schemepkg.u32_button2_auth.has()) {
                this.f94742y0 = devlock_verify_scheme_schemepkg.u32_button2_auth.get();
            }
            if (z16 && z17 && this.f94742y0 == 2) {
                this.f94741x0 = true;
            } else {
                this.f94741x0 = false;
            }
        } catch (Throwable th5) {
            QLog.e("QRLoginAuthActivity", 1, th5, new Object[0]);
        }
    }

    public void V2(Bundle bundle) {
        k kVar;
        int i3 = bundle.getInt("ret", 1);
        byte[] byteArray = bundle.getByteArray("appName");
        byte[] byteArray2 = bundle.getByteArray("tlv");
        byte[] byteArray3 = bundle.getByteArray("errMsg");
        if (byteArray3 == null) {
            byteArray3 = new byte[0];
        }
        StringBuilder sb5 = new StringBuilder("handleUiSHow");
        if (i3 == 0) {
            QrLogin$ScanResultInfo qrLogin$ScanResultInfo = null;
            try {
                kVar = W2(byteArray2, sb5);
            } catch (Exception e16) {
                QLog.e("QRLoginAuthActivity", 1, e16, new Object[0]);
                kVar = null;
            }
            if (kVar != null) {
                qrLogin$ScanResultInfo = kVar.f94756a;
            }
            boolean r36 = r3(byteArray, qrLogin$ScanResultInfo, sb5);
            sb5.append("\uff0cisShowUiByScanResultInfo=");
            sb5.append(r36);
            if (!r36) {
                s3(0);
                i3("0X800BD92", 0);
            }
            BounceScrollView bounceScrollView = this.f94721d0;
            if (bounceScrollView != null) {
                bounceScrollView.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginAuthActivity.9
                    @Override // java.lang.Runnable
                    public void run() {
                        BounceScrollView bounceScrollView2 = QRLoginAuthActivity.this.f94721d0;
                        if (bounceScrollView2 != null) {
                            bounceScrollView2.fullScroll(130);
                        }
                    }
                });
            }
        } else {
            sb5.append("ret != 0,errMsg = ");
            sb5.append(new String(byteArray3));
            e3(new String(byteArray3));
        }
        QLog.d("QRLoginAuthActivity", 1, sb5.toString());
    }

    public k W2(byte[] bArr, StringBuilder sb5) {
        QrLogin$ScanResultInfo qrLogin$ScanResultInfo = null;
        if (bArr == null) {
            sb5.append("\uff0ctlv == null");
            return new k(null, null);
        }
        String str = null;
        int i3 = 0;
        while (i3 < bArr.length) {
            int i16 = (bArr[i3] << 8) & 65280;
            int i17 = i3 + 1;
            int i18 = i16 | (bArr[i17] & 255);
            int i19 = i17 + 1;
            int i26 = 65280 & (bArr[i19] << 8);
            int i27 = i19 + 1;
            int i28 = i26 | (bArr[i27] & 255);
            sb5.append(",t=");
            sb5.append(i18);
            sb5.append(" l=");
            sb5.append(i28);
            int i29 = i27 + 1;
            if (i18 == 3) {
                str = new String(bArr, i29, i28);
            } else if (i18 == 5) {
                this.E0 = new String(bArr, i29, i28);
                sb5.append("\uff0cTLV_5:");
                sb5.append(this.E0);
            } else if (i18 == 32) {
                T2(bArr, i29, i28);
            } else if (i18 == 53) {
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i29, bArr2, 0, i28);
                this.K0 = ((bArr2[0] & 255) << 24) | ((bArr2[1] & 255) << 16) | (bArr2[3] & 255) | ((bArr2[2] & 255) << 8);
                sb5.append("\uff0cTLV_53 wtlogin apptype:");
                sb5.append(this.K0);
            } else if (i18 == 54) {
                U2(bArr, i29, i28, sb5);
            } else if (i18 == 208) {
                qrLogin$ScanResultInfo = R2(bArr, i29, i28, sb5);
            } else if (i18 == 209) {
                S2(bArr, i29, i28, sb5);
            }
            i3 = i29 + i28;
        }
        return new k(qrLogin$ScanResultInfo, str);
    }

    protected void b3() {
        int i3 = this.K0;
        if (i3 != 65793 && i3 != 77313 && i3 != 23) {
            if (i3 == 5) {
                this.D0 = "Mac";
                return;
            } else if (i3 == 3) {
                this.D0 = "iPad";
                return;
            } else {
                if (rd0.h.e(i3)) {
                    this.D0 = Y0;
                    return;
                }
                return;
            }
        }
        this.D0 = "Windows";
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        super.doOnBackPressed();
        if (QrAgentLoginManager.t().f339978i != null) {
            QrAgentLoginManager.t().f339978i.g();
        } else {
            ((ILoginServletService) getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).cancelCode(this.f94720c0.getCurrentAccountUin(), 16L, this.f94743z0, q.c(this.f94720c0, this.R0, false).toByteArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        ImmersiveUtils.setStatusTextColor(!ThemeUtil.isNowThemeIsNight(this.f94720c0, false, null), getWindow());
        initUI();
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        this.f94720c0 = qQAppInterface;
        this.f94719b0 = qQAppInterface.getCurrentAccountUin();
        this.f94718a0 = (WtloginManager) this.f94720c0.getManager(1);
        if (QLog.isColorLevel()) {
            QLog.d("QRLoginAuthActivity", 2, "wtloginManager:" + this.f94718a0 + " isLogin:" + this.f94720c0.isLogin());
        }
        y3();
        if (!MobileQQ.sMobileQQ.isLoginByNT()) {
            H2();
        }
        if (this.f94720c0.isLogin()) {
            Q2();
        } else {
            e3(null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        QQProgressDialog qQProgressDialog = this.G0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.G0.dismiss();
        }
        super.doOnDestroy();
        com.tencent.mobileqq.qrscan.utils.b.c(this);
    }

    protected void e3(String str) {
        if (isFinishing()) {
            return;
        }
        if (!HttpUtil.isConnect(this)) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            createCustomDialog.setMessage(R.string.h67);
            createCustomDialog.setPositiveButton(R.string.f171151ok, new i());
            createCustomDialog.show();
        }
        if (str == null || str.length() == 0) {
            str = getString(R.string.h65);
        }
        this.f94733p0.setVisibility(0);
        this.f94733p0.setImageDrawable(getResources().getDrawable(R.drawable.clj));
        this.f94722e0.setText(getString(R.string.f216865zg));
        this.f94722e0.setVisibility(0);
        this.f94723f0.setText(str);
        this.f94723f0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        this.f94723f0.setVisibility(0);
        this.B0 = true;
        this.f94727j0.setVisibility(0);
        this.f94728k0.setVisibility(8);
        this.f94738u0.setVisibility(8);
        this.f94724g0.setVisibility(8);
        this.f94734q0.setText(R.string.f173086h64);
        this.f94734q0.setVisibility(0);
        this.f94735r0.setVisibility(8);
        g3();
    }

    protected void f3() {
        if (!isFinishing()) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.setFlags(67108864);
            super.startActivity(aliasIntent);
        }
        QQToast.makeText(getApplicationContext(), R.string.h66, 0).show();
        if (!TextUtils.isEmpty(this.H0) && "1600000104".equals(this.H0.trim())) {
            Intent intent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
            intent.putExtra("loginInfo", this.E0);
            intent.putExtra(TangramHippyConstants.LOGIN_APP_ID, this.H0);
            intent.putExtra("status", "login");
            super.sendBroadcast(intent);
            return;
        }
        Intent intent2 = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
        intent2.putExtra("loginInfo", this.E0);
        intent2.putExtra("status", "login");
        intent2.putExtra("bannerTips", this.L0);
        intent2.putExtra("subappid", this.M0);
        intent2.putExtra("appType", this.K0);
        super.sendBroadcast(intent2);
    }

    protected void initUI() {
        super.setContentView(R.layout.c_s);
        ImageView imageView = (ImageView) super.findViewById(R.id.f74523wh);
        this.f94732o0 = imageView;
        imageView.setOnClickListener(new e());
        this.f94721d0 = (BounceScrollView) super.findViewById(R.id.f80454bi);
        this.f94724g0 = (LinearLayout) super.findViewById(R.id.yu_);
        this.f94725h0 = (LinearLayout) super.findViewById(R.id.yu8);
        this.f94726i0 = (LinearLayout) super.findViewById(R.id.yu6);
        this.f94727j0 = (LinearLayout) super.findViewById(R.id.ufn);
        this.f94728k0 = (LinearLayout) super.findViewById(R.id.f74923xk);
        this.f94729l0 = (TextView) super.findViewById(R.id.yua);
        this.f94730m0 = (TextView) super.findViewById(R.id.yu7);
        this.f94731n0 = (TextView) super.findViewById(R.id.yu5);
        this.f94733p0 = (ImageView) super.findViewById(R.id.uh5);
        this.f94734q0 = (Button) super.findViewById(R.id.u4f);
        this.f94735r0 = (Button) super.findViewById(R.id.f99045oq);
        this.f94736s0 = (QUIButton) super.findViewById(R.id.u4h);
        this.f94737t0 = (Button) super.findViewById(R.id.f74933xl);
        this.f94738u0 = (Button) super.findViewById(R.id.f72573r8);
        this.f94722e0 = (TextView) super.findViewById(R.id.yuc);
        this.f94723f0 = (TextView) super.findViewById(R.id.yum);
        this.f94739v0 = super.findViewById(R.id.f164531t03);
        QUICheckBox qUICheckBox = (QUICheckBox) super.findViewById(R.id.f164530t02);
        this.f94740w0 = qUICheckBox;
        qUICheckBox.a();
        this.f94734q0.setOnClickListener(this);
        this.f94735r0.setOnClickListener(this);
        this.f94736s0.setOnClickListener(this);
        this.f94737t0.setOnClickListener(this);
        this.f94738u0.setOnClickListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton != null && compoundButton.getId() == R.id.f164530t02 && z16) {
            l3();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.u4f) {
            if (this.B0) {
                Intent intent = new Intent();
                intent.setFlags(67108864);
                RouteUtils.startActivity(this, intent, "/qrscan/scanner");
                finish();
            } else {
                I2(false);
                i3("0X800BD93", 1);
            }
        } else if (id5 == R.id.u4h) {
            if (this.C0) {
                v3();
            } else {
                I2(false);
            }
            i3("0X800BD93", 2);
        } else if (id5 == R.id.f99045oq) {
            I2(true);
            ReportController.o(null, "dc00898", "", "", "0X800C1CB", "0X800C1CB", 0, 0, "", "", "", "");
        } else if (id5 == R.id.f74523wh) {
            finish();
            if (QrAgentLoginManager.t().f339978i != null) {
                QrAgentLoginManager.t().f339978i.g();
            } else {
                ((ILoginServletService) getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).cancelCode(this.f94720c0.getCurrentAccountUin(), 16L, this.f94743z0, q.c(this.f94720c0, this.R0, false).toByteArray());
            }
        } else if (id5 == R.id.f74933xl) {
            i3("0X800BD94", 0);
            h3();
        } else if (id5 == R.id.f72573r8) {
            h3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public boolean p3(ScanQrRspInfo scanQrRspInfo) {
        boolean z16;
        int i3;
        if (scanQrRspInfo == null) {
            return false;
        }
        long openAppid = scanQrRspInfo.getDstOpenAppInfo().getOpenAppid();
        this.O0 = openAppid;
        if (openAppid > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.C0 = z16;
        this.I0 = scanQrRspInfo.getDstAppName();
        this.T0 = scanQrRspInfo.getAutoLogin();
        this.E0 = scanQrRspInfo.getLoginCity();
        this.N0 = scanQrRspInfo.getDstOpenAppInfo().getComeFrom();
        this.F0 = scanQrRspInfo.getLoginDevName();
        this.U0 = scanQrRspInfo.getLoginPlat();
        if ("app".equals(this.N0)) {
            this.N0 = "android";
        }
        if (scanQrRspInfo.getTips().getColor() == TipsColor.KDEFAULT) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        String tips = scanQrRspInfo.getTips().getTips();
        if (!TextUtils.isEmpty(this.D0)) {
            this.f94725h0.setVisibility(0);
            this.f94730m0.setText(this.D0);
        }
        int i16 = b.f94746a[scanQrRspInfo.getSecCheckResult().ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    return false;
                }
                t3(tips, new StringBuilder("handleNewQrLogin"));
                return true;
            }
            s3(i3);
            i3("0X800BD92", 1);
            return true;
        }
        u3(tips, i3);
        return true;
    }

    public boolean r3(byte[] bArr, QrLogin$ScanResultInfo qrLogin$ScanResultInfo, StringBuilder sb5) {
        if (bArr != null && bArr.length > 0) {
            this.I0 = new String(bArr);
        }
        if (qrLogin$ScanResultInfo == null || !qrLogin$ScanResultInfo.scan_result.has()) {
            return false;
        }
        int L2 = L2(qrLogin$ScanResultInfo.tips_ctrl.get(), sb5);
        this.S0 = qrLogin$ScanResultInfo.auto_renew_ticket_info.get();
        int i3 = qrLogin$ScanResultInfo.scan_result.get();
        if (i3 == 0) {
            s3(L2);
            i3("0X800BD92", 1);
            return true;
        }
        String str = null;
        if (i3 == 1) {
            QrLogin$RiskInfo qrLogin$RiskInfo = qrLogin$ScanResultInfo.risk_info.get();
            if (qrLogin$RiskInfo != null && qrLogin$RiskInfo.str_new_tips_template.has()) {
                str = qrLogin$RiskInfo.str_new_tips_template.get();
            }
            u3(str, L2);
            return true;
        }
        if (i3 != 2) {
            return false;
        }
        if (qrLogin$ScanResultInfo.reject_info.get() != null) {
            str = qrLogin$ScanResultInfo.reject_info.get().str_tips.get();
        }
        t3(str, sb5);
        return true;
    }

    public void s3(int i3) {
        Y2(true, i3);
        Z2(true, i3);
        c3(true, i3);
        M2();
        if (TextUtils.isEmpty(this.E0)) {
            this.E0 = getString(R.string.iaa);
        }
        this.f94724g0.setVisibility(0);
        this.f94729l0.setText(this.E0);
        if (this.f94741x0) {
            this.f94735r0.setVisibility(0);
        } else {
            this.f94735r0.setVisibility(8);
        }
        this.f94734q0.setVisibility(0);
        this.f94734q0.setText(R.string.voe);
        g3();
    }

    public void v3() {
        n3();
        Intent intent = new Intent(this, (Class<?>) AgentActivity.class);
        intent.putExtra("key_action", "action_login");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_login_by_qr_scan", true);
        bundle.putString(CommonConstant.ReqAccessTokenParam.CLIENT_ID, String.valueOf(this.O0));
        bundle.putString("sdkp", this.N0);
        bundle.putString("QR_CODE_STRING", this.A0);
        bundle.putLong("KEY_ONLINE_STATUS", this.f94720c0.getOnlineStauts());
        bundle.putByteArray("key_qr_code", this.f94743z0);
        intent.putExtra("key_params", bundle);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements f72.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3, String str) {
            QQProgressDialog qQProgressDialog = QRLoginAuthActivity.this.G0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                QRLoginAuthActivity.this.G0.dismiss();
            }
            if (i3 == 0) {
                QRLoginAuthActivity.this.f3();
            } else if (MobileQQ.sMobileQQ.isLoginByNT() && i3 == 3) {
                QRLoginAuthActivity.this.N2();
            } else {
                QRLoginAuthActivity.this.e3(str);
            }
        }

        @Override // f72.a
        public void b(final int i3, @Nullable final String str, @Nullable String str2) {
            QLog.i("QRLoginAuthActivity", 1, "mQrLoginCallback onCloseCode result=" + i3 + " errMsg=" + str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.c
                @Override // java.lang.Runnable
                public final void run() {
                    QRLoginAuthActivity.c.this.d(i3, str);
                }
            });
        }

        @Override // f72.a
        public void a(int i3, @Nullable String str, @Nullable ScanQrRspInfo scanQrRspInfo) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d extends com.tencent.mobileqq.loginregister.servlet.h {
        d() {
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void h(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) {
            byte[] bArr3;
            QLog.d("QRLoginAuthActivity", 1, "OnCloseCode userAccount=" + str + " ret=" + i3);
            if (i3 == 0 && wUserSigInfo != null) {
                bArr3 = WtloginHelper.getLoginTlvValue(wUserSigInfo, 54);
            } else {
                bArr3 = null;
            }
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt("ret", i3);
            bundle.putByteArray("errMsg", bArr2);
            if (bArr3 != null) {
                bundle.putByteArray("devInfo", bArr3);
            }
            message.setData(bundle);
            message.what = 2;
            QRLoginAuthActivity.this.X0.sendMessage(message);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void j(String str, int i3) {
            QLog.d("QRLoginAuthActivity", 1, "OnException e=" + str);
            Message message = new Message();
            message.what = 3;
            QRLoginAuthActivity.this.X0.sendMessage(message);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void E(String str, byte[] bArr, long j3, ArrayList<String> arrayList, byte[] bArr2, int i3, ErrMsg errMsg) {
        }
    }
}
