package com.tencent.mobileqq.apollo.handler;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.praise.praise_sso$TPraiseSsoReq;
import com.tencent.mobileqq.praise.praise_sso$TPraiseSsoRsp;
import com.tencent.mobileqq.praise.praise_sso$TSsoCmd0x1Req;
import com.tencent.mobileqq.praise.praise_sso$TSsoCmd0x1Rsp;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.updatesystem.data.VasUpdateData;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.pb.pendantMarket.PendantMarket$SetAddonRsp;
import com.tencent.pb.pendantMarket.PendantMarket$TipsInfo;
import com.tencent.pb.scupdate.SCUpdatePB$SCUpdateRsp;
import com.tencent.pb.scupdate.SCUpdatePB$UpdateInfo;
import com.tencent.pb.scupdate.SCUpdatePB$VCR;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import mqq.app.NewIntent;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$ClientInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$ReqBody;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$RichCardNameElem;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.oidb.qqshop.qqshop_code$SReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloExtensionHandler extends BusinessHandler implements b {
    public static final String E = "com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler";
    private static String F = "ApolloExtensionHandler";
    public static String G = "Addon.Set";
    public static final Map<String, d> H;
    private static long I;
    public Bundle C;
    private com.tencent.mobileqq.profile.like.a D;

    /* renamed from: d, reason: collision with root package name */
    public int f194377d;

    /* renamed from: e, reason: collision with root package name */
    public int f194378e;

    /* renamed from: f, reason: collision with root package name */
    public Vector<Long> f194379f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, BusinessObserver> f194380h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f194381i;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f194382m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class UpdateRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        BusinessObserver f194383d;

        /* renamed from: e, reason: collision with root package name */
        boolean f194384e;

        /* renamed from: f, reason: collision with root package name */
        Object f194385f;

        public UpdateRunnable(BusinessObserver businessObserver, boolean z16, Object obj) {
            this.f194383d = businessObserver;
            this.f194384e = z16;
            this.f194385f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusinessObserver businessObserver = this.f194383d;
            if (businessObserver != null) {
                businessObserver.onUpdate(0, this.f194384e, this.f194385f);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        H = hashMap;
        I = 0L;
        hashMap.put("qqvalue.GetQQValue", new m23.c());
        hashMap.put("OidbSvc.0x5eb_99", new j13.a());
    }

    public ApolloExtensionHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f194377d = 0;
        this.f194378e = 0;
        this.f194379f = new Vector<>();
        this.f194380h = new HashMap<>();
        this.f194381i = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).disableCMShowRequest();
        this.f194382m = qQAppInterface;
    }

    private NewIntent E2(String str, BaseApplication baseApplication, byte[] bArr) {
        NewIntent newIntent = new NewIntent(baseApplication, a.class);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        return newIntent;
    }

    private WebSSOAgent$UniSsoServerReq F2(String str) {
        WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
        webSSOAgent$UniSsoServerReqComm.platform.set(109L);
        webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
        webSSOAgent$UniSsoServerReqComm.mqqver.set(str);
        WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
        webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
        return webSSOAgent$UniSsoServerReq;
    }

    private void H2(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        if (!fromServiceMsg.isSuccess() || obj == null) {
            return;
        }
        Oidb_0x8fc$RspBody oidb_0x8fc$RspBody = new Oidb_0x8fc$RspBody();
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            oidb_0x8fc$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                notifyUI(27, true, null);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ColorNick", 2, "handleModifyColorNick sso fail result = " + oidb_sso_oidbssopkg.uint32_result.get());
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.has() ? oidb_sso_oidbssopkg.uint32_result.get() : -1);
            if (oidb_0x8fc$RspBody.strErrInfo.has()) {
                str = oidb_0x8fc$RspBody.strErrInfo.get();
            } else {
                str = "";
            }
            objArr[1] = str;
            notifyUI(27, false, objArr);
        } catch (Exception e16) {
            QLog.e("ColorNick", 1, "handleModifyColorNick error: ", e16);
            notifyUI(27, false, -1);
        }
    }

    private void I2(FromServiceMsg fromServiceMsg, BusinessObserver businessObserver, Object obj) {
        ThreadManager.getSubThreadHandler().post(new UpdateRunnable(businessObserver, fromServiceMsg.isSuccess(), obj));
    }

    private void K2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", intent.getIntExtra("id", -1));
        bundle.putString("name", intent.getStringExtra("name"));
        bundle.putString("minVersion", intent.getStringExtra("minVersion"));
        bundle.putInt(VipFunCallConstants.KEY_FEET_TYPE, intent.getIntExtra(VipFunCallConstants.KEY_FEET_TYPE, 0));
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, intent.getIntExtra(IProfileCardConst.KEY_FROM_TYPE, 0));
        if (bArr != null && fromServiceMsg.isSuccess()) {
            try {
                WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(bArr);
                long j3 = webSSOAgent$UniSsoServerRsp.ret.get();
                String str = webSSOAgent$UniSsoServerRsp.errmsg.get();
                if (j3 == 0) {
                    notifyUI(23, true, bundle);
                    return;
                }
                bundle.putLong("result", j3);
                bundle.putString("msg", str);
                QLog.e(F, 1, "handlePokeAuthResp failed " + str);
            } catch (Exception e16) {
                bundle.putInt("result", -254);
                bundle.putString("msg", HardCodeUtil.qqStr(R.string.f172873uy1));
                if (QLog.isColorLevel()) {
                    QLog.e(F, 2, "handlePokeAuthResp failed ", e16);
                }
            }
        } else {
            bundle.putInt("result", -255);
            bundle.putString("msg", HardCodeUtil.qqStr(R.string.f172874uy2));
            if (QLog.isColorLevel()) {
                QLog.e(F, 2, "handlePokeAuthResp fail ret: " + fromServiceMsg.getResultCode());
            }
        }
        notifyUI(23, false, bundle);
    }

    private boolean M2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        BusinessObserver businessObserver;
        String stringExtra = intent.getStringExtra("__cmd_seq__");
        if (TextUtils.isEmpty(stringExtra) || !this.f194380h.containsKey(stringExtra) || (businessObserver = this.f194380h.get(stringExtra)) == null) {
            return false;
        }
        this.f194380h.remove(stringExtra);
        Class cls = (Class) intent.getSerializableExtra("__rspClass__");
        if (cls == null) {
            I2(fromServiceMsg, businessObserver, bArr);
            return true;
        }
        try {
            MessageMicro messageMicro = (MessageMicro) cls.newInstance();
            messageMicro.mergeFrom(bArr);
            I2(fromServiceMsg, businessObserver, messageMicro);
            return true;
        } catch (Exception e16) {
            QLog.e(F, 1, "response is error", e16);
            return false;
        }
    }

    private boolean N2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr, String str) {
        if ("Praise.sso".equals(str)) {
            L2(intent, fromServiceMsg, bArr);
        } else if (!"gxzbpublic.filter".equals(str)) {
            if ("OidbSvc.0x8fc_3".equals(str)) {
                H2(intent, fromServiceMsg, bArr);
            } else if ("vaspoke.check".equals(str)) {
                K2(intent, fromServiceMsg, bArr);
            } else if (str.equals(G)) {
                J2(intent, bArr);
            } else {
                if (!"scupdate.handle".equals(str)) {
                    return false;
                }
                handleQuickUpdate(intent, fromServiceMsg, bArr);
            }
        }
        return true;
    }

    private void O2(WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq, JSONObject jSONObject, String str) {
        webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
        this.f194382m.startServlet(E2(str, this.f194382m.getApp(), webSSOAgent$UniSsoServerReq.toByteArray()));
    }

    public void D2(String[] strArr, int[] iArr, int i3) {
        j13.a.c(this.f194382m, strArr, iArr, i3);
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    /* renamed from: G2, reason: merged with bridge method [inline-methods] */
    public QQAppInterface getApp() {
        return this.f194382m;
    }

    public void J2(Intent intent, byte[] bArr) {
        String str;
        PendantMarket$SetAddonRsp pendantMarket$SetAddonRsp = new PendantMarket$SetAddonRsp();
        try {
            pendantMarket$SetAddonRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(F, 1, "handlePendantAuthRsp rsp.mergeFrom e=" + e16);
            pendantMarket$SetAddonRsp = null;
        }
        if (pendantMarket$SetAddonRsp == null) {
            return;
        }
        Bundle bundle = new Bundle();
        int i3 = pendantMarket$SetAddonRsp.int_result.get();
        bundle.putLong("pendantId", intent.getLongExtra("pendantId", -1L));
        bundle.getInt("seriesId", intent.getIntExtra("seriesId", -1));
        bundle.putString("uin", intent.getStringExtra("uin"));
        if (i3 != 0) {
            String str2 = "";
            if (pendantMarket$SetAddonRsp.tips_info.has()) {
                PendantMarket$TipsInfo pendantMarket$TipsInfo = new PendantMarket$TipsInfo();
                try {
                    pendantMarket$TipsInfo.mergeFrom(pendantMarket$SetAddonRsp.tips_info.toByteArray());
                    PendantTipsInfo pendantTipsInfo = new PendantTipsInfo();
                    boolean z16 = pendantMarket$TipsInfo.valid.get();
                    pendantTipsInfo.valid = z16;
                    if (z16) {
                        pendantTipsInfo.type = pendantMarket$TipsInfo.type.get();
                        String str3 = pendantMarket$TipsInfo.title_wording.get();
                        if (str3.equals("")) {
                            str3 = HardCodeUtil.qqStr(R.string.uxz);
                        }
                        pendantTipsInfo.titleWording = str3;
                        pendantTipsInfo.wording = pendantMarket$TipsInfo.wording.get();
                        String str4 = pendantMarket$TipsInfo.right_btn_wording.get();
                        if (str4.equals("")) {
                            str4 = HardCodeUtil.qqStr(R.string.f172872uy0);
                        }
                        pendantTipsInfo.rightBtnWording = str4;
                        String str5 = pendantMarket$TipsInfo.left_btn_wording.get();
                        if (str5.equals("")) {
                            str5 = HardCodeUtil.qqStr(R.string.j6l);
                        }
                        pendantTipsInfo.leftBtnWording = str5;
                        pendantTipsInfo.vipType = pendantMarket$TipsInfo.vip_type.get();
                        pendantTipsInfo.vipMonth = pendantMarket$TipsInfo.vip_month.get();
                        pendantTipsInfo.url = pendantMarket$TipsInfo.url.get();
                    }
                    bundle.putSerializable("tipsInfo", pendantTipsInfo);
                } catch (InvalidProtocolBufferMicroException e17) {
                    QLog.e(F, 1, "handlePendantAuthRsp tipsInfo.mergeFrom e=" + e17);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("VasExtensionHandler", 2, "response from server error: " + i3);
            }
            bundle.putInt("result", i3);
            if (i3 == 6001) {
                if (!pendantMarket$SetAddonRsp.str_msg.has()) {
                    str = "";
                } else {
                    str = pendantMarket$SetAddonRsp.str_msg.get();
                }
                if (pendantMarket$SetAddonRsp.str_url.has()) {
                    str2 = pendantMarket$SetAddonRsp.str_url.get();
                }
                bundle.putString("tips", str);
                bundle.putString("url", str2);
            }
            notifyUI(1, false, bundle);
            return;
        }
        QLog.e("VasExtensionHandler", 1, "\u529f\u80fd\u5e9f\u5f03");
        notifyUI(1, false, bundle);
    }

    public void L2(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        com.tencent.mobileqq.profile.like.a aVar;
        if (QLog.isColorLevel()) {
            QLog.d(F, 2, "handlePraiseAuthResponse");
        }
        try {
            if (!fromServiceMsg.isSuccess()) {
                QLog.e(F, 1, "handlePraiseAuthResponse, isSuccess false, error code=" + fromServiceMsg.getResultCode());
                return;
            }
            praise_sso$TPraiseSsoRsp praise_sso_tpraisessorsp = new praise_sso$TPraiseSsoRsp();
            praise_sso_tpraisessorsp.mergeFrom((byte[]) obj);
            int i3 = praise_sso_tpraisessorsp.i32_ret.get();
            praise_sso$TSsoCmd0x1Rsp praise_sso_tssocmd0x1rsp = praise_sso_tpraisessorsp.st_cmd0x1_rsp.get();
            int i16 = praise_sso_tssocmd0x1rsp.i32_itemId.get();
            String str = praise_sso_tssocmd0x1rsp.str_url.get();
            if (i3 == 0) {
                PraiseManager.i(this.f194382m, i16);
            } else {
                QLog.e(F, 1, "handlePraiseAuthResponse, ret=" + i3);
            }
            Bundle bundle = this.C;
            if (bundle == null || (aVar = this.D) == null) {
                return;
            }
            aVar.a(i3, i16, str, bundle);
            this.C = null;
            this.D = null;
        } catch (Exception e16) {
            QLog.e(F, 1, "handlePraiseAuthResponse exception", e16);
        }
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void W() {
        j2(new String[]{this.f194382m.getCurrentAccountUin()}, new int[]{45033});
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void X1(int i3, int i16, long j3) {
        QLog.d(F, 1, "getPadFaceAd");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("uin", Long.parseLong(this.f194382m.getCurrentAccountUin()));
            jSONObject3.put("id", i16);
            jSONObject3.put(RedTouchWebviewHandler.PLUGIN_NAMESPACE, i3);
            jSONObject3.put("last_time", j3);
            jSONObject3.put("qq_plat", 1);
            String str = AppSetting.f99554n;
            jSONObject3.put(AppConstants.Preferences.QQ_VERSION, str);
            jSONObject2.put("req", jSONObject3);
            jSONObject.put("12818", jSONObject2);
            O2(F2(str), jSONObject, "QQVacCommSvc.get_padface_add");
        } catch (Exception e16) {
            QLog.e(F, 1, "[getPadFaceAd] exception=", e16);
        }
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void c0(String str) {
        qqshop_code$SReq qqshop_code_sreq = new qqshop_code$SReq();
        qqshop_code_sreq.appid.set(100273020);
        qqshop_code_sreq.version.set(1);
        PBStringField pBStringField = qqshop_code_sreq.redirect_uri;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        pBStringField.set(str);
        NewIntent E2 = E2("SQQShopAuthCodeSvc.AuthCode", this.f194382m.getApp(), qqshop_code_sreq.toByteArray());
        E2.putExtra("timeout", 3000L);
        this.f194382m.startServlet(E2);
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void m(int i3) {
        QLog.d(F, 1, "reportPadFaceShown");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("uin", Long.parseLong(this.f194382m.getCurrentAccountUin()));
            jSONObject3.put("id", i3);
            jSONObject3.put("qq_plat", 1);
            String str = AppSetting.f99554n;
            jSONObject3.put(AppConstants.Preferences.QQ_VERSION, str);
            jSONObject2.put("req", jSONObject3);
            jSONObject.put("12827", jSONObject2);
            O2(F2(str), jSONObject, "QQVacCommSvc.report_padface_shown");
        } catch (Exception e16) {
            QLog.e(F, 1, "[reportPadFaceShown] exception=", e16);
        }
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public d m0(String str) {
        return H.get(str);
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void o0(int i3, Bundle bundle, com.tencent.mobileqq.profile.like.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(F, 2, "requestPraiseAuth, praiseId=" + i3);
        }
        praise_sso$TSsoCmd0x1Req praise_sso_tssocmd0x1req = new praise_sso$TSsoCmd0x1Req();
        praise_sso_tssocmd0x1req.i32_itemId.set(i3);
        praise_sso$TPraiseSsoReq praise_sso_tpraisessoreq = new praise_sso$TPraiseSsoReq();
        praise_sso_tpraisessoreq.i32_cmd.set(1);
        praise_sso_tpraisessoreq.i32_implat.set(109);
        praise_sso_tpraisessoreq.str_qq_ver.set(AppSetting.f99554n);
        praise_sso_tpraisessoreq.st_cmd0x1_req.set(praise_sso_tssocmd0x1req);
        NewIntent E2 = E2("Praise.sso", this.f194382m.getApp(), praise_sso_tpraisessoreq.toByteArray());
        this.C = bundle;
        this.D = aVar;
        this.f194382m.startServlet(E2);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void request(String str, MessageMicro messageMicro, Class cls, BusinessObserver businessObserver) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), a.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        long j3 = I + 1;
        I = j3;
        sb5.append(j3);
        String sb6 = sb5.toString();
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", messageMicro.toByteArray());
        newIntent.putExtra("timeout", 30000L);
        newIntent.putExtra("__cmd_seq__", sb6);
        newIntent.putExtra("__rspClass__", cls);
        this.f194380h.put(sb6, businessObserver);
        qQAppInterface.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void y0(int i3, String str, int i16, String str2, int i17) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i3);
            WebSSOAgent$UniSsoServerReq F2 = F2(AppSetting.f99551k);
            F2.reqdata.set(jSONObject.toString());
            NewIntent E2 = E2("vaspoke.check", this.f194382m.getApp(), F2.toByteArray());
            E2.putExtra("timeout", 20000);
            E2.putExtra("id", i3);
            E2.putExtra("name", str);
            E2.putExtra("minVersion", str2);
            E2.putExtra(VipFunCallConstants.KEY_FEET_TYPE, i16);
            E2.putExtra(IProfileCardConst.KEY_FROM_TYPE, i17);
            this.f194382m.startServlet(E2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(F, 2, "handlePokeAuth failed ", e16);
            }
        }
    }

    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        String stringExtra = intent.getStringExtra("cmd");
        if (TextUtils.isEmpty(stringExtra) || M2(intent, fromServiceMsg, bArr) || N2(intent, fromServiceMsg, bArr, stringExtra)) {
            return;
        }
        d dVar = H.get(stringExtra);
        if (dVar != null) {
            dVar.a(this, intent, fromServiceMsg, bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(F, 2, "unknow cmd :" + stringExtra);
        }
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void A0(String str, Object obj, int i3) {
        ArrayList arrayList;
        try {
            arrayList = (ArrayList) obj;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ColorNick", 1, "[modifyTroopMemberCardInfoWithColorNick] error! ", e16);
            }
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNick", 2, "modifyTroopMemberCardInfoWithColorNick troopUin = " + str);
            }
            Oidb_0x8fc$ReqBody oidb_0x8fc$ReqBody = new Oidb_0x8fc$ReqBody();
            oidb_0x8fc$ReqBody.uint64_group_code.set(Long.parseLong(str));
            ArrayList arrayList2 = new ArrayList();
            Oidb_0x8fc$MemberInfo oidb_0x8fc$MemberInfo = new Oidb_0x8fc$MemberInfo();
            oidb_0x8fc$MemberInfo.uint64_uin.set(Long.parseLong(this.f194382m.getCurrentAccountUin()));
            ArrayList arrayList3 = new ArrayList();
            StringBuilder sb5 = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ColorClearableEditText.a aVar = (ColorClearableEditText.a) it.next();
                Oidb_0x8fc$RichCardNameElem oidb_0x8fc$RichCardNameElem = new Oidb_0x8fc$RichCardNameElem();
                int i16 = aVar.f315542e;
                if (i16 == 1) {
                    oidb_0x8fc$RichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(aVar.f315540c.getBytes()));
                    sb5.append(aVar.f315540c);
                } else if (i16 == 2 || i16 == 3) {
                    String str2 = aVar.f315540c;
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.length() > 1 && str2.substring(0, 1).equals("<")) {
                            str2 = str2.substring(1);
                        }
                        if (str2.length() > 0 && str2.substring(str2.length() - 1).equals(">")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        oidb_0x8fc$RichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(str2.getBytes()));
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNick", 2, "modifyTroopMemberCardInfoWithColorNick type = " + aVar.f315542e + " text = " + aVar.f315540c);
                }
                arrayList3.add(oidb_0x8fc$RichCardNameElem);
            }
            Oidb_0x8fc$CommCardNameBuf oidb_0x8fc$CommCardNameBuf = new Oidb_0x8fc$CommCardNameBuf();
            oidb_0x8fc$CommCardNameBuf.rpt_rich_card_name.set(arrayList3);
            oidb_0x8fc$CommCardNameBuf.uint32_cool_id.set(i3);
            oidb_0x8fc$MemberInfo.bytes_comm_rich_card_name.set(ByteStringMicro.copyFrom(oidb_0x8fc$CommCardNameBuf.toByteArray()));
            oidb_0x8fc$MemberInfo.member_card_name.set(ByteStringMicro.copyFrom(sb5.toString().getBytes()));
            arrayList2.add(oidb_0x8fc$MemberInfo);
            oidb_0x8fc$ReqBody.rpt_mem_level_info.set(arrayList2);
            Oidb_0x8fc$ClientInfo oidb_0x8fc$ClientInfo = new Oidb_0x8fc$ClientInfo();
            oidb_0x8fc$ClientInfo.uint32_implat.set(109);
            oidb_0x8fc$ClientInfo.string_clientver.set(ah.P());
            oidb_0x8fc$ReqBody.msg_client_info.set(oidb_0x8fc$ClientInfo);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2300);
            oidb_sso_oidbssopkg.uint32_service_type.set(3);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8fc$ReqBody.toByteArray()));
            this.f194382m.startServlet(E2("OidbSvc.0x8fc_3", this.f194382m.getApp(), oidb_sso_oidbssopkg.toByteArray()));
            return;
        }
        QLog.e("ColorNick", 1, "modifyTroopMemberCardInfoWithColorNick paragraphs is empty");
    }

    public void handleQuickUpdate(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        if (bArr == null || !fromServiceMsg.isSuccess()) {
            return;
        }
        SCUpdatePB$SCUpdateRsp sCUpdatePB$SCUpdateRsp = new SCUpdatePB$SCUpdateRsp();
        try {
            sCUpdatePB$SCUpdateRsp.mergeFrom(bArr);
            if (QLog.isColorLevel()) {
                QLog.d(F, 2, "handleQuickUpdate ret: " + sCUpdatePB$SCUpdateRsp.ret.get());
            }
            long j3 = sCUpdatePB$SCUpdateRsp.comm.cookie.has() ? sCUpdatePB$SCUpdateRsp.comm.cookie.get() : 0L;
            if (sCUpdatePB$SCUpdateRsp.ret.get() == 0) {
                if (sCUpdatePB$SCUpdateRsp.cmd.get() == 1) {
                    VasUpdateData.SyncVCRRsp syncVCRRsp = new VasUpdateData.SyncVCRRsp();
                    syncVCRRsp.cookie = j3;
                    syncVCRRsp.seq = sCUpdatePB$SCUpdateRsp.rsp0x01.seq.get();
                    syncVCRRsp.continueFlag = sCUpdatePB$SCUpdateRsp.rsp0x01.continue_flag.get();
                    syncVCRRsp.polltime = sCUpdatePB$SCUpdateRsp.comm.polltime.get();
                    syncVCRRsp.syncSwitch = sCUpdatePB$SCUpdateRsp.rsp0x01.sync_switch.get();
                    syncVCRRsp.environment = sCUpdatePB$SCUpdateRsp.rsp0x01.environment.get();
                    for (int i3 = 0; i3 < sCUpdatePB$SCUpdateRsp.rsp0x01.vcr_list.size(); i3++) {
                        SCUpdatePB$VCR sCUpdatePB$VCR = sCUpdatePB$SCUpdateRsp.rsp0x01.vcr_list.get(i3);
                        VasUpdateData.VCR vcr = new VasUpdateData.VCR();
                        vcr.set(sCUpdatePB$VCR);
                        syncVCRRsp.vcrList.add(vcr);
                    }
                    syncVCRRsp.preload.ver = sCUpdatePB$SCUpdateRsp.rsp0x01.preload.plver.get();
                    syncVCRRsp.preload.setList(sCUpdatePB$SCUpdateRsp.rsp0x01.preload.item_list);
                    syncVCRRsp.report.ver = sCUpdatePB$SCUpdateRsp.rsp0x01.report.rpver.get();
                    syncVCRRsp.report.setList(sCUpdatePB$SCUpdateRsp.rsp0x01.report.item_list);
                    notifyUI(16, true, syncVCRRsp);
                    return;
                }
                if (sCUpdatePB$SCUpdateRsp.cmd.get() == 2) {
                    VasUpdateData.GetUrlRsp getUrlRsp = new VasUpdateData.GetUrlRsp();
                    getUrlRsp.cookie = j3;
                    for (int i16 = 0; i16 < sCUpdatePB$SCUpdateRsp.rsp0x02.update_list.size(); i16++) {
                        SCUpdatePB$UpdateInfo sCUpdatePB$UpdateInfo = sCUpdatePB$SCUpdateRsp.rsp0x02.update_list.get(i16);
                        VasUpdateData.UpdateInfo updateInfo = new VasUpdateData.UpdateInfo();
                        updateInfo.set(sCUpdatePB$UpdateInfo, i16);
                        getUrlRsp.updateList.add(updateInfo);
                    }
                    notifyUI(17, true, getUrlRsp);
                    return;
                }
                return;
            }
            QLog.e(F, 1, "handleQuickUpdate result = " + sCUpdatePB$SCUpdateRsp.ret.get() + "msg = " + sCUpdatePB$SCUpdateRsp.f342172msg.get());
            VasUpdateData.QuickUpdateRsp quickUpdateRsp = new VasUpdateData.QuickUpdateRsp();
            quickUpdateRsp.ret = sCUpdatePB$SCUpdateRsp.ret.get();
            quickUpdateRsp.cookie = j3;
            if (sCUpdatePB$SCUpdateRsp.cmd.get() == 1) {
                notifyUI(16, false, quickUpdateRsp);
            } else if (sCUpdatePB$SCUpdateRsp.cmd.get() == 2) {
                notifyUI(17, false, quickUpdateRsp);
            }
        } catch (Exception e16) {
            QLog.e(F, 1, "handleQuickUpdate error: ", e16);
            VasUpdateData.QuickUpdateRsp quickUpdateRsp2 = new VasUpdateData.QuickUpdateRsp();
            quickUpdateRsp2.ret = -1L;
            quickUpdateRsp2.cookie = 0L;
            if (sCUpdatePB$SCUpdateRsp.cmd.get() == 1) {
                notifyUI(16, false, quickUpdateRsp2);
            } else if (sCUpdatePB$SCUpdateRsp.cmd.get() == 2) {
                notifyUI(17, false, quickUpdateRsp2);
            }
        }
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void j2(String[] strArr, int[] iArr) {
        D2(strArr, iArr, 99);
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void request(String str, String str2, BusinessObserver businessObserver) {
        try {
            request(str, str2.getBytes("ISO8859_1"), businessObserver);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.apollo.handler.b
    public void request(String str, byte[] bArr, BusinessObserver businessObserver) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), a.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        long j3 = I + 1;
        I = j3;
        sb5.append(j3);
        String sb6 = sb5.toString();
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("timeout", 30000L);
        newIntent.putExtra("__cmd_seq__", sb6);
        this.f194380h.put(sb6, businessObserver);
        qQAppInterface.startServlet(newIntent);
    }
}
