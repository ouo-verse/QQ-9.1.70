package com.tencent.mobileqq.msf.core.auth;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.NetContants;
import com.tencent.mobileqq.msf.core.wtlogin.MsfWtloginPrivacyListenerImpl;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.Cgi;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.listener.QimeiListener;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.listener.SwitchListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    static final String f247468b = "MSF.C.WTLoginCenter";

    /* renamed from: c, reason: collision with root package name */
    private static final String f247469c = "_wtlastchecklocaltokentime_";

    /* renamed from: d, reason: collision with root package name */
    private static final int f247470d = 43200000;

    /* renamed from: e, reason: collision with root package name */
    private static final String f247471e = "msf_guid";

    /* renamed from: f, reason: collision with root package name */
    public static final long f247472f = 16;

    /* renamed from: g, reason: collision with root package name */
    private static final long f247473g = 9;

    /* renamed from: h, reason: collision with root package name */
    private static final long f247474h = 8;

    /* renamed from: i, reason: collision with root package name */
    public static final HashSet<String> f247475i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f247476j = 1346;

    /* renamed from: k, reason: collision with root package name */
    public static final int f247477k = 57;

    /* renamed from: l, reason: collision with root package name */
    public static final int f247478l = 56;

    /* renamed from: m, reason: collision with root package name */
    public static MsfCore f247479m = null;

    /* renamed from: n, reason: collision with root package name */
    public static WtloginHelper f247480n = null;

    /* renamed from: o, reason: collision with root package name */
    private static final String f247481o = "wt_change_token_src";

    /* renamed from: p, reason: collision with root package name */
    private static final String f247482p = "src";

    /* renamed from: q, reason: collision with root package name */
    public static final byte f247483q = 1;

    /* renamed from: a, reason: collision with root package name */
    private final int f247484a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements QimeiListener {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        public static final String f247485a = "WtQimeiListener";

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // oicq.wlogin_sdk.listener.QimeiListener
        public String getQimei(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Qimei qimei = QimeiSDK.getInstance(BaseApplication.getContext().getMSFInterfaceAdapter().getBeaconAppKey()).getQimei();
            if (qimei == null) {
                return "";
            }
            return qimei.getQimei16();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b implements ReportListener {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // oicq.wlogin_sdk.listener.ReportListener
        public void onReport(String str, HashMap<String, String> hashMap, boolean z16, boolean z17) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, hashMap, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            MsfCore msfCore = MsfCore.sCore;
            if (msfCore != null && msfCore.getAccountCenter() != null) {
                str2 = MsfCore.sCore.getAccountCenter().e();
            } else {
                str2 = "";
            }
            String str3 = str2;
            hashMap.put("account_uin", str3);
            BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(str3, str, true, hashMap, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c implements SwitchListener {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // oicq.wlogin_sdk.listener.SwitchListener
        public boolean isSwitchOn(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16))).booleanValue();
            }
            if (BaseApplication.getContext() == null) {
                return false;
            }
            return BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(str, z16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f247475i = new HashSet<>();
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f247484a = 100;
        }
    }

    private void b() {
    }

    public static byte[] c() {
        return f247480n.GetGuid();
    }

    private void d() {
        HashSet<String> hashSet = f247475i;
        hashSet.add("game.qq.com");
        hashSet.add("mail.qq.com");
        hashSet.add("qzone.qq.com");
        hashSet.add(FlockBaseRequest.QUN_DOMAIN);
        hashSet.add("openmobile.qq.com");
        hashSet.add(Cgi.TENPAY_DOMAIN);
        hashSet.add("connect.qq.com");
        hashSet.add("tim.qq.com");
        hashSet.add("qqweb.qq.com");
        hashSet.add("office.qq.com");
        hashSet.add("ti.qq.com");
        hashSet.add("mma.qq.com");
        hashSet.add(ITeamWorkHandler.DOCS_DOMAIN);
        hashSet.add("vip.qq.com");
        hashSet.add("gamecenter.qq.com");
    }

    public void A(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.CloseDevLock(toServiceMsg.getUin(), 16L, ((Long) toServiceMsg.getAttribute("subAppid")).longValue(), b16), "wt_CloseDevLock");
    }

    public void B(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        long longValue = ((Long) toServiceMsg.getAttribute("dwSrcAppid")).longValue();
        long longValue2 = ((Long) toServiceMsg.getAttribute("dwSubSrcAppid")).longValue();
        long longValue3 = ((Long) toServiceMsg.getAttribute("dwDstAppid")).longValue();
        long longValue4 = ((Long) toServiceMsg.getAttribute("dwSubDstAppid")).longValue();
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "wt_GetA1WithA1 dwSrcppid = " + longValue + " dwSubSrcAppid = " + longValue2 + " dwDstAppid = " + longValue3 + " dwSubDstAppid = " + longValue4);
        }
        a(toServiceMsg, a16, f247480n.GetA1WithA1(toServiceMsg.getUin(), longValue, longValue2, (byte[]) toServiceMsg.getAttribute("dstAppName"), ((Long) toServiceMsg.getAttribute("dwDstSsoVer")).longValue(), longValue3, longValue4, (byte[]) toServiceMsg.getAttribute("dstAppVer"), (byte[]) toServiceMsg.getAttribute("dstAppSign"), b16, (WFastLoginInfo) toServiceMsg.getAttribute("fastLoginInfo")), "wt_GetA1WithA1");
    }

    public void C(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "wt_GetOpenKeyWithoutPasswd uin=" + toServiceMsg.getUin() + " dwSrcAppid=" + toServiceMsg.getAttribute("dwSrcAppid") + " dwDstAppid=" + toServiceMsg.getAttribute("dwDstAppid") + " sigInfo=" + b16);
        }
        b(toServiceMsg, "wt_GetOpenKeyWithoutPasswd");
        a(toServiceMsg, a16, f247480n.GetOpenKeyWithoutPasswd(toServiceMsg.getUin(), ((Long) toServiceMsg.getAttribute("dwSrcAppid")).longValue(), ((Long) toServiceMsg.getAttribute("dwDstAppid")).longValue(), 36864, b16), "wt_GetOpenKeyWithoutPasswd");
    }

    public void D(ToServiceMsg toServiceMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, b16);
        long longValue = ((Long) toServiceMsg.getAttribute("appid")).longValue();
        long longValue2 = ((Long) toServiceMsg.getAttribute("subAppid")).longValue();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("isFromIFrame")).booleanValue();
        try {
            str = new String((byte[]) toServiceMsg.getAttribute("pwd"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e16) {
            QLog.e(f247468b, 1, e16, new Object[0]);
            str = null;
        }
        long[] jArr = new long[0];
        if (com.tencent.mobileqq.msf.core.x.b.p1()) {
            jArr = new long[]{1600000226};
        }
        a(toServiceMsg, a16, f247480n.getSaltUinList(longValue, longValue2, str, b16, jArr, booleanValue, 0), "wt_GetSaltUinList");
    }

    public void E(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, b16);
        a(toServiceMsg, a16, f247480n.getStByPhoneAndPassword(((Long) toServiceMsg.getAttribute("appid")).longValue(), ((Long) toServiceMsg.getAttribute("subAppid")).longValue(), m.f247500f, b16, 0), "wt_GetStByPhoneAndPassword");
    }

    public void F(ToServiceMsg toServiceMsg) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        long appId = toServiceMsg.getAppId();
        String str = (String) toServiceMsg.getAttribute("from_where", null);
        if (str != null && str.equalsIgnoreCase(BaseConstants.SSO_ACCOUNT_ACTION)) {
            b16._login_bitmap = 2;
            j3 = BaseConstants.OPEN_SDK_BUFLAG_B1;
        } else {
            b16._login_bitmap = 0;
            j3 = 16;
        }
        a(toServiceMsg, b16);
        a(toServiceMsg, a16, f247480n.getStByGateWay(j3, appId, m.f247500f, b16, 0), "wt_GetStViaGatewayLogin");
    }

    public void G(ToServiceMsg toServiceMsg) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        long appId = toServiceMsg.getAppId();
        String str = (String) toServiceMsg.getAttribute("from_where", null);
        if (str != null && str.equalsIgnoreCase(BaseConstants.SSO_ACCOUNT_ACTION)) {
            b16._login_bitmap = 2;
            j3 = BaseConstants.OPEN_SDK_BUFLAG_B1;
        } else {
            b16._login_bitmap = 0;
            j3 = 16;
        }
        long j16 = j3;
        a(toServiceMsg, b16);
        String str2 = (String) toServiceMsg.getAttribute("countryCode");
        String str3 = (String) toServiceMsg.getAttribute("userAccount");
        if (!str2.startsWith("86")) {
            str3 = "00" + str2 + str3;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "wt_GetStViaSMSVerifyLogin appId = " + j16 + " localappid = " + appId);
        }
        a(toServiceMsg, a16, f247480n.GetStViaSMSVerifyLogin(str3, j16, appId, m.f247500f, b16), "wt_GetStViaSMSVerifyLogin");
    }

    public void H(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.GetStWithPasswd(toServiceMsg.getUin(), ((Long) toServiceMsg.getAttribute("appid")).longValue(), (String) toServiceMsg.getAttribute("passwd"), b16), "wt_GetStWithPasswd");
    }

    public void I(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, b16);
        long appId = toServiceMsg.getAppId();
        long longValue = ((Long) toServiceMsg.getAttribute("dwSrcAppid")).longValue();
        long longValue2 = ((Long) toServiceMsg.getAttribute("dwDstAppid")).longValue();
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "wt_GetStWithoutPasswd dwSrcppid = " + longValue + " dwDstAppid = " + longValue2 + " localappid = " + appId);
        }
        b(toServiceMsg, "wt_GetStWithoutPasswd");
        a(toServiceMsg, a16, f247480n.GetStWithoutPasswd(toServiceMsg.getUin(), longValue, longValue2, appId, m.f247500f, b16), "wt_GetStWithoutPasswd");
    }

    public void J(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        long appId = toServiceMsg.getAppId();
        long longValue = ((Long) toServiceMsg.getAttribute("dwSrcAppid")).longValue();
        long longValue2 = ((Long) toServiceMsg.getAttribute("dwDstAppid")).longValue();
        QLog.d(f247468b, 1, "wt_GetUIDWithoutPasswd dwSrcppid = " + longValue + " dwDstAppid = " + longValue2 + " localappid = " + appId);
        int GetStWithoutPasswd = f247480n.GetStWithoutPasswd(toServiceMsg.getUin(), longValue, longValue2, appId, m.f247500f, b16);
        b(toServiceMsg, "wt_GetUIDWithoutPasswd");
        a(toServiceMsg, a16, GetStWithoutPasswd, "wt_GetUIDWithoutPasswd");
    }

    public void K(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        Object attribute = toServiceMsg.getAttribute(BaseConstants.ATTR_KET_PHONE_TOKEN);
        if (attribute != null) {
            WtloginHelper.setExtraLoginTlvValue(b16, 1346, (byte[]) attribute);
        }
        a(toServiceMsg, a16, f247480n.quickLoginByGateway(16L, 34869344L, toServiceMsg.getAppId(), b16), "wt_QuickLoginByGateway");
    }

    public void L(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.RefreshPictureData(toServiceMsg.getUin(), b16), "wt_RefreshPictureData");
    }

    public void M(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        Object attribute = toServiceMsg.getAttribute(BaseConstants.ATTR_KET_BUSINESS_SQE);
        if (attribute != null && (attribute instanceof Integer)) {
            b16._seqence = ((Integer) attribute).intValue();
        }
        Object attribute2 = toServiceMsg.getAttribute("businessType");
        if (attribute2 != null && (attribute2 instanceof Integer)) {
            b16.businessType = ((Integer) attribute2).intValue();
        }
        a(toServiceMsg, b16);
        a(toServiceMsg, a16, f247480n.RefreshSMSData(toServiceMsg.getUin(), 9L, b16, (byte[]) toServiceMsg.getAttribute("smsExtraData")), "wt_RefreshSMSData");
    }

    public void N(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        String str = (String) toServiceMsg.getAttribute("countryCode");
        String str2 = (String) toServiceMsg.getAttribute("userAccount");
        if (!str.startsWith("86")) {
            str2 = "00" + str + str2;
        }
        a(toServiceMsg, a16, f247480n.RefreshSMSVerifyLoginCode(str2, b16), "wt_RefreshSMSVerifyLoginCode");
    }

    public void O(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_LH_UIN);
        String str2 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_UNBIND_LH_UIN);
        String str3 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION);
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f247468b, 2, "GetSMSVerifyLoginAccount|lhUin= " + str);
            }
            a(b16, 46, str);
        } else if (!TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(f247468b, 2, "GetSMSVerifyLoginAccount|unBindUin= " + str2);
            }
            a(b16, 47, str2);
        }
        a(toServiceMsg, a16, f247480n.RegGetSMSVerifyLoginAccount((byte[]) toServiceMsg.getAttribute("msgchk"), "qqpassport".getBytes(), (byte[]) toServiceMsg.getAttribute("nick"), str3.getBytes(), b16), "wt_RegGetSMSVerifyLoginAccount");
    }

    public void P(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) toServiceMsg);
        } else {
            f247480n.SetDevlockMobileType(((Integer) toServiceMsg.getAttribute("mobile_type")).intValue());
        }
    }

    public void Q(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.VerifyCode(toServiceMsg.getUin(), ((Long) toServiceMsg.getAttribute("appid")).longValue(), ((Boolean) toServiceMsg.getAttribute("close")).booleanValue(), (byte[]) toServiceMsg.getAttribute("code"), (int[]) toServiceMsg.getAttribute("tlv"), ((Integer) toServiceMsg.getAttribute("version")).intValue(), (byte[]) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, new byte[0]), b16), "wt_VerifyCode");
    }

    public void R(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        String str = (String) toServiceMsg.getAttribute("countryCode");
        String str2 = (String) toServiceMsg.getAttribute("userAccount");
        if (!str.startsWith("86")) {
            str2 = "00" + str + str2;
        }
        a(toServiceMsg, a16, f247480n.VerifySMSVerifyLoginCode(str2, (String) toServiceMsg.getAttribute("code"), b16), "wt_VerifySMSVerifyLoginCode");
    }

    public void S(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, b16);
        a(toServiceMsg, a16, f247480n.getStViaThirdPlatformLogin(((Long) toServiceMsg.getAttribute("appid")).longValue(), ((Long) toServiceMsg.getAttribute("subAppid")).longValue(), m.f247500f, b16, 0), "wt_getStViaWxLogin");
    }

    public void T(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, b16);
        WtloginHelper.QuickLoginParam quickLoginParam = new WtloginHelper.QuickLoginParam();
        quickLoginParam.sigMap = m.f247500f;
        quickLoginParam.userSigInfo = b16;
        quickLoginParam.appid = ((Long) toServiceMsg.getAttribute("appid")).longValue();
        a(toServiceMsg, a16, f247480n.quickLoginByThirdPlatform(quickLoginParam, 0), "wt_loginByWx");
    }

    public void U(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) toServiceMsg);
        } else {
            f247480n.SetRegDevLockFlag(((Integer) toServiceMsg.getAttribute("flag")).intValue());
        }
    }

    public void a(MsfCommand msfCommand, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 60)) {
            return;
        }
        iPatchRedirector.redirect((short) 60, (Object) this, (Object) msfCommand, (Object) toServiceMsg);
    }

    public int e(ToServiceMsg toServiceMsg) {
        int i3;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg)).intValue();
        }
        Byte b16 = (Byte) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_COUNTRY);
        Byte b17 = (Byte) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_LANGUAGE);
        Byte b18 = (Byte) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_PIGTYPE);
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION);
        String str2 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE);
        long longValue = ((Long) toServiceMsg.getAttributes().get("appid")).longValue();
        String str3 = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_CAPTCHA_SIG, null);
        WtloginHelper.setSecTransInfo((String) toServiceMsg.getAttributes().get("wifi_mac"), (String) toServiceMsg.getAttributes().get("os_language"), ((Integer) toServiceMsg.getAttributes().get("qq_language")).intValue(), (String) toServiceMsg.getAttributes().get("gps_location"));
        if (toServiceMsg.getAttributes().get("tim_register_flag") != null) {
            i3 = ((Integer) toServiceMsg.getAttributes().get("tim_register_flag")).intValue();
            QLog.d(f247468b, 1, "timRegisterFlag is " + i3);
        } else {
            i3 = 0;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b19 = m.b(toServiceMsg.getRequestSsoSeq());
        b19._seqence = a16.f247508f;
        WtloginHelper.setRegisterFlg(i3 | 68);
        String str4 = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_INVITATION_CODE, null);
        if (!TextUtils.isEmpty(str4)) {
            if (QLog.isColorLevel()) {
                QLog.d(f247468b, 2, "RegSubmitMobile|invitation= " + str4);
            }
            WtloginHelper.setExtraRegTlvValue(b19, 49, str4.getBytes());
        }
        byte[] bArr = (byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REG_PHONE_TOKEN, null);
        if (bArr != null && bArr.length > 0) {
            QLog.d(f247468b, 1, "add phone token , length = " + bArr.length);
            WtloginHelper.setExtraRegTlvValue(b19, 57, bArr);
        }
        byte[] bArr2 = (byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_WX_TOKEN, null);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("add wxRegisterToken , length = ");
        if (bArr2 == null) {
            valueOf = bArr2;
        } else {
            valueOf = Integer.valueOf(bArr2.length);
        }
        sb5.append(valueOf);
        QLog.d(f247468b, 1, sb5.toString());
        if (bArr2 != null && bArr2.length > 0) {
            WtloginHelper.setExtraRegTlvValue(b19, 56, bArr2);
        }
        HashMap<String, Object> hashMap = (HashMap) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_MAP_PARAM);
        a(b19, hashMap);
        int RegSubmitMobile = f247480n.RegSubmitMobile(str3, str2.getBytes(), str.getBytes(), b16.byteValue(), b17.byteValue(), b18.byteValue(), 16L, longValue, b19, hashMap);
        a(toServiceMsg, a16, RegSubmitMobile, "RegSubmitMobile");
        return RegSubmitMobile;
    }

    public int f(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_SMSCODE);
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        int RegSubmitMsgChk = f247480n.RegSubmitMsgChk(str.getBytes(), b16);
        a(toServiceMsg, a16, RegSubmitMsgChk, "RegSubmitMsgChk");
        return RegSubmitMsgChk;
    }

    public int g(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String uin = toServiceMsg.getUin();
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION);
        Byte b16 = (Byte) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_LANGUAGE);
        int appId = toServiceMsg.getAppId();
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b17 = m.b(toServiceMsg.getRequestSsoSeq());
        b17._seqence = a16.f247508f;
        if (QLog.isColorLevel()) {
            QLog.d("Login_Optimize_Center", 2, "WTLoiginCenter|checkQuickRegister : account= " + uin + ",subAppId = " + appId + ",appVer=" + str);
        }
        int quickRegisterCheckAccount = f247480n.quickRegisterCheckAccount(Long.valueOf(uin).longValue(), 16L, b16.byteValue(), appId, str.getBytes(), b17);
        a(toServiceMsg, a16, quickRegisterCheckAccount, "checkQuickRegister");
        return quickRegisterCheckAccount;
    }

    public void h(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) toServiceMsg);
            return;
        }
        try {
            if (BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
                return;
            }
            String uin = toServiceMsg.getUin();
            ArrayList<com.tencent.mobileqq.msf.core.auth.a> arrayList = new ArrayList<>();
            f247479m.getAccountCenter().b(arrayList);
            Iterator<com.tencent.mobileqq.msf.core.auth.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.msf.core.auth.a next = it.next();
                if (next.z().equals(uin) && next.b() != null && next.b().length > 0 && next.h() != null && next.h().length > 0 && next.k() != null && next.k().length > 0) {
                    return;
                }
            }
            BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(toServiceMsg.getUin(), "wt_sig_deleted_when_online", true, null, false);
            QLog.d(f247468b, 1, "checkSig\uff1a account " + toServiceMsg.getUin() + " miss sig");
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn("105777", false)) {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
                a16.setBusinessFail(2001, "");
                MsfSdkUtils.addFromMsgProcessName("*", a16);
                f247479m.addRespToQuque(toServiceMsg, a16);
            }
        } catch (Exception e16) {
            QLog.e(f247468b, 1, e16, new Object[0]);
        }
    }

    public int i(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String uin = toServiceMsg.getUin();
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_PASS);
        String str2 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_NICK);
        String str3 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION);
        Byte b16 = (Byte) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_LANGUAGE);
        int appId = toServiceMsg.getAppId();
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b17 = m.b(toServiceMsg.getRequestSsoSeq());
        b17._seqence = a16.f247508f;
        if (QLog.isColorLevel()) {
            QLog.d("Login_Optimize_Center", 2, "WTLoiginCenter|getQuickRegisterAccount : account= " + uin + ",nick= " + str2 + ",subAppId = " + appId + ",appVer=" + str3);
        }
        int quickRegisterGetAccount = f247480n.quickRegisterGetAccount(Long.valueOf(uin).longValue(), 16L, b16.byteValue(), appId, str3.getBytes(), str2.getBytes(), str, b17);
        a(toServiceMsg, a16, quickRegisterGetAccount, "getQuickRegisterAccount");
        return quickRegisterGetAccount;
    }

    public void j(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!f247479m.isUseNewService()) {
            FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
            a16.setBusinessFail(1001, "try inject ticket but msfcore not support");
            f247479m.addRespToQuque(toServiceMsg, a16);
            return;
        }
        NTAccountSigInfo nTAccountSigInfo = (NTAccountSigInfo) toServiceMsg.getAttribute(g.f247459a, new NTAccountSigInfo());
        FromServiceMsg a17 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
        QLog.d(f247468b, 1, "injectSigToMsf  accountSigInfo = " + nTAccountSigInfo);
        if (nTAccountSigInfo.getUin() != 0 && nTAccountSigInfo.getA2() != null && nTAccountSigInfo.getA2().length != 0 && nTAccountSigInfo.getD2() != null && nTAccountSigInfo.getD2().length != 0 && nTAccountSigInfo.getD2key() != null && nTAccountSigInfo.getD2key().length != 0) {
            if (nTAccountSigInfo.getUinType() == 0) {
                com.tencent.mobileqq.msf.core.auth.a aVar = new com.tencent.mobileqq.msf.core.auth.a(String.valueOf(nTAccountSigInfo.getUin()));
                aVar.b(nTAccountSigInfo.getA2());
                aVar.g(nTAccountSigInfo.getD2key());
                aVar.f(nTAccountSigInfo.getD2());
                f247479m.getAccountCenter().d(aVar);
                f247479m.getAccountCenter().g().a(String.valueOf(nTAccountSigInfo.getUin()), nTAccountSigInfo.getUid());
            } else if (nTAccountSigInfo.getUinType() == 6) {
                if (!TextUtils.isEmpty(nTAccountSigInfo.getUid())) {
                    f247479m.getAccountCenter().g().a(String.valueOf(nTAccountSigInfo.getUin()), nTAccountSigInfo.getUid());
                } else if (TextUtils.isEmpty(f247479m.getAccountCenter().g().d(String.valueOf(nTAccountSigInfo.getUin())))) {
                    QLog.e(f247468b, 1, "injectSigToMsf error : uid is empty");
                    a17.setMsgFail();
                    f247479m.addRespToQuque(toServiceMsg, a17);
                    return;
                }
                f247479m.setAccountKey(String.valueOf(nTAccountSigInfo.getUin()), 6, new byte[0], nTAccountSigInfo.getA2(), new byte[0], new byte[0], nTAccountSigInfo.getD2(), new byte[0], nTAccountSigInfo.getD2key(), new byte[0], null);
            }
            a17.setMsgSuccess();
            f247479m.addRespToQuque(toServiceMsg, a17);
            return;
        }
        a17.setMsgFail();
        f247479m.addRespToQuque(toServiceMsg, a17);
    }

    public int k(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) toServiceMsg)).intValue();
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        a(toServiceMsg, b16);
        b16._seqence = a16.f247508f;
        int RefreshPictureData = f247480n.RefreshPictureData(toServiceMsg.getUin(), b16);
        a(toServiceMsg, a16, RefreshPictureData, "refreVerifycode");
        return RefreshPictureData;
    }

    public void l(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = false;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "refreshDA2|GetStWithoutPasswd");
        }
        a(toServiceMsg, a16, f247480n.GetStWithoutPasswd(toServiceMsg.getUin(), 16L, 16L, -1L, 33554432, b16), "refreshDA2");
    }

    public int m(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_PUZZLE_VERIFY_CODE_TICKET);
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        Object attribute = toServiceMsg.getAttribute("businessType");
        if (attribute != null && (attribute instanceof Integer)) {
            b16.businessType = ((Integer) attribute).intValue();
        }
        a(toServiceMsg, b16);
        b16._seqence = a16.f247508f;
        int CheckWebsigAndGetSt = f247480n.CheckWebsigAndGetSt(toServiceMsg.getUin(), str, b16);
        a(toServiceMsg, a16, CheckWebsigAndGetSt, "submitPuzzleVerifyCodeTicket");
        return CheckWebsigAndGetSt;
    }

    public int n(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_VERIFY_CODE);
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        a(toServiceMsg, b16);
        b16._seqence = a16.f247508f;
        int CheckPictureAndGetSt = f247480n.CheckPictureAndGetSt(toServiceMsg.getUin(), str.getBytes(), b16);
        a(toServiceMsg, a16, CheckPictureAndGetSt, "submitVerifycode");
        return CheckPictureAndGetSt;
    }

    public int o(ToServiceMsg toServiceMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg)).intValue();
        }
        try {
            str = new String((byte[]) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_LOGIN_PWD), "ISO-8859-1");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            str = "";
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247503a = true;
        a16.f247510h = true;
        m.a(toServiceMsg);
        WUserSigInfo wUserSigInfo = new WUserSigInfo();
        wUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(toServiceMsg.getRequestSsoSeq());
        WtloginHelper wtloginHelper = f247480n;
        String uin = toServiceMsg.getUin();
        int GetStWithPasswd = wtloginHelper.GetStWithPasswd(uin, 16L, 0, 1600000749L, new long[0], true, str, wUserSigInfo, new byte[0]);
        a(toServiceMsg, a16, GetStWithPasswd, "verifyPasswd");
        return GetStWithPasswd;
    }

    public int p(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) toServiceMsg)).intValue();
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247510h = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.CheckPictureAndGetSt(toServiceMsg.getUin(), ((String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_VERIFY_PASSWD_IMAGE)).getBytes(), b16), "verifyPasswdImage");
        return -1;
    }

    public int q(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) toServiceMsg)).intValue();
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247510h = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.RefreshPictureData(toServiceMsg.getUin(), b16), "verifyPasswdRefreshImage");
        return -1;
    }

    public void r(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.AskDevLockSms(toServiceMsg.getUin(), 16L, 8L, b16), "wt_AskDevLockSms");
    }

    public void s(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.cancelCode(toServiceMsg.getUin(), ((Long) toServiceMsg.getAttribute("appid")).longValue(), (byte[]) toServiceMsg.getAttribute("code"), (byte[]) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_PB_DATA), b16), "wt_CancelCode");
    }

    public void t(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.CheckDevLockSms(toServiceMsg.getUin(), 16L, ((Long) toServiceMsg.getAttribute("subAppid")).longValue(), (String) toServiceMsg.getAttribute("smdCode"), (byte[]) toServiceMsg.getAttribute("sppKey"), b16), "wt_CheckDevLockSms");
    }

    public void u(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, b16);
        a(toServiceMsg, a16, f247480n.CheckDevLockStatus(toServiceMsg.getUin(), 16L, ((Long) toServiceMsg.getAttribute("subAppid")).longValue(), b16), "wt_CheckDevLockStatus");
    }

    public void v(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.CheckPictureAndGetSt(toServiceMsg.getUin(), (byte[]) toServiceMsg.getAttribute("userInput"), b16), "wt_CheckPictureAndGetSt");
    }

    public void w(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        a(toServiceMsg, b16);
        b16._seqence = a16.f247508f;
        Object attribute = toServiceMsg.getAttribute(BaseConstants.ATTR_KET_BUSINESS_SQE);
        if (attribute != null && (attribute instanceof Integer)) {
            b16._seqence = ((Integer) attribute).intValue();
        }
        Object attribute2 = toServiceMsg.getAttribute("businessType");
        if (attribute2 != null && (attribute2 instanceof Integer)) {
            b16.businessType = ((Integer) attribute2).intValue();
        }
        Object attribute3 = toServiceMsg.getAttribute(BaseConstants.ATTR_KET_PHONE_TOKEN);
        if (attribute3 != null) {
            WtloginHelper.setExtraLoginTlvValue(b16, 1346, (byte[]) attribute3);
        }
        a(toServiceMsg, a16, f247480n.CheckSMSAndGetSt(toServiceMsg.getUin(), (byte[]) toServiceMsg.getAttribute("userInput"), b16, null, (byte[]) toServiceMsg.getAttribute("smsExtraData")), "wt_CheckSMSAndGetSt");
    }

    public void x(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        a(toServiceMsg, a16, f247480n.CheckSMSAndGetSt(toServiceMsg.getUin(), (byte[]) toServiceMsg.getAttribute("userInput"), b16, null, (byte[]) toServiceMsg.getAttribute("smsExtraData")), "wt_CheckSMSAndGetSt");
    }

    public void y(ToServiceMsg toServiceMsg) {
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        String str2 = (String) toServiceMsg.getAttribute("countryCode");
        String str3 = (String) toServiceMsg.getAttribute("userAccount");
        if (!str2.startsWith("86")) {
            str = "00" + str2 + str3;
        } else {
            str = str3;
        }
        Object attribute = toServiceMsg.getAttribute("verifyToken");
        if (attribute != null) {
            WtloginHelper.setExtraLoginTlvValue(b16, 1346, (byte[]) attribute);
        }
        String str4 = (String) toServiceMsg.getAttribute("from_where", null);
        if (str4 != null && str4.equalsIgnoreCase(BaseConstants.SSO_ACCOUNT_ACTION)) {
            j3 = BaseConstants.OPEN_SDK_BUFLAG_B1;
        } else {
            j3 = 16;
        }
        a(toServiceMsg, a16, f247480n.CheckSMSVerifyLoginAccount(j3, toServiceMsg.getAppId(), str, b16), "wt_CheckSMSVerifyLoginAccount");
    }

    public void z(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) toServiceMsg);
            return;
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247509g = true;
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        ArrayList arrayList = (ArrayList) toServiceMsg.getAttribute("data");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(HexUtil.hexStr2Bytes((String) it.next()));
        }
        a(toServiceMsg, a16, f247480n.CloseCode(toServiceMsg.getUin(), ((Long) toServiceMsg.getAttribute("appid")).longValue(), (byte[]) toServiceMsg.getAttribute("code"), ((Integer) toServiceMsg.getAttribute("version")).intValue(), arrayList2, (byte[]) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, new byte[0]), b16), "wt_CloseCode");
    }

    private boolean b(String str) {
        if (com.tencent.mobileqq.msf.core.x.b.d1()) {
            long currentTimeMillis = System.currentTimeMillis();
            String config = MsfStore.getNativeConfigStore().getConfig(f247469c + str);
            if (config == null) {
                return false;
            }
            long parseLong = Long.parseLong(config);
            if (currentTimeMillis > parseLong && currentTimeMillis - parseLong <= 43200000) {
                return true;
            }
        }
        return false;
    }

    public void a(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msfCore);
            return;
        }
        f247479m = msfCore;
        util.LOGCAT_OUT = !BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion();
        d();
        b();
        WtloginHelper.setQimeiListener(new a());
        WtloginHelper.setReportListener(new b());
        WtloginHelper.setSwitchListener(new c());
        WtloginHelper wtloginHelper = new WtloginHelper((Context) BaseApplication.getContext(), (PrivacyListener) MsfWtloginPrivacyListenerImpl.getSingleton());
        f247480n = wtloginHelper;
        QLog.d("wtlogin_guid", 1, util.buf_to_string(wtloginHelper.GetGuid()));
        f247480n.SetTimeOut(40000);
        f247480n.SetMsfTransportFlag(1);
        f247480n.setBabyQFlg(true);
        f247480n.SetListener(new n(msfCore));
        byte[] GetGuid = f247480n.GetGuid();
        NetConnInfoCenter.GUID = GetGuid;
        String buf_to_string = util.buf_to_string(GetGuid);
        if (TextUtils.isEmpty(buf_to_string)) {
            return;
        }
        MsfService.getCore().getSharedPreferences(NetContants.SharePref.SP_MSF_COMMON, 4).edit().putString("msf_guid", buf_to_string).apply();
    }

    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                QLog.d(f247468b, 1, "check ps, uin is empty!");
                return false;
            }
            Ticket GetLocalTicket = f247480n.GetLocalTicket(str, 16L, 1048576);
            if (GetLocalTicket == null && GetLocalTicket._pskey_map == null) {
                QLog.d(f247468b, 1, "check ps, local store is empty!");
                return false;
            }
            HashSet<String> o06 = com.tencent.mobileqq.msf.core.x.b.o0();
            if (o06 == null) {
                QLog.d(f247468b, 1, "check ps, dons is empty!");
                return false;
            }
            Iterator<String> it = o06.iterator();
            while (it.hasNext()) {
                String next = it.next();
                byte[] bArr = GetLocalTicket._pskey_map.get(next);
                if (bArr == null || bArr.length == 0) {
                    QLog.d(f247468b, 1, "check ps, " + next + " is empty!");
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.d(f247468b, 1, "get ticket failed, PSKEY, exception: " + e16.toString());
            return false;
        }
    }

    public long b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3)).longValue();
        }
        Ticket GetLocalTicket = f247480n.GetLocalTicket(str, 16L, i3);
        if (GetLocalTicket == null) {
            return 0L;
        }
        return GetLocalTicket._expire_time * 1000;
    }

    private void b(ToServiceMsg toServiceMsg, String str) {
        try {
            if (a()) {
                HashMap hashMap = new HashMap();
                hashMap.put("src", str);
                BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(toServiceMsg != null ? toServiceMsg.getUin() : "", f247481o, true, hashMap, false);
            }
        } catch (Exception e16) {
            QLog.e(f247468b, 1, e16, new Object[0]);
        }
    }

    public int b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE);
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        if (QLog.isColorLevel()) {
            QLog.d("queryMobile", 2, "WTLoginCenter.RegQueryAccount");
        }
        int RegQueryAccount = f247480n.RegQueryAccount(1, str.getBytes(), 16L, b16);
        a(toServiceMsg, a16, RegQueryAccount, "RegQueryAccount");
        return RegQueryAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(String str) {
        QLog.d(f247468b, 2, "updateCheckTime " + str);
        long currentTimeMillis = System.currentTimeMillis();
        MsfStore.getNativeConfigStore().setConfig(f247469c + str, String.valueOf(currentTimeMillis));
    }

    public int c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) toServiceMsg)).intValue();
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        int RegQueryClientSentMsgStatus = f247480n.RegQueryClientSentMsgStatus(b16);
        a(toServiceMsg, a16, RegQueryClientSentMsgStatus, "RegQueryClientSentMsgStatus");
        return RegQueryClientSentMsgStatus;
    }

    public int d(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) toServiceMsg)).intValue();
        }
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        int RegRequestServerResendMsg = f247480n.RegRequestServerResendMsg(b16);
        a(toServiceMsg, a16, RegRequestServerResendMsg, "RegRequestServerResendMsg");
        return RegRequestServerResendMsg;
    }

    public int a(com.tencent.mobileqq.msf.core.auth.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? a(aVar, m.f247500f, z16) : ((Integer) iPatchRedirector.redirect((short) 4, this, aVar, Boolean.valueOf(z16))).intValue();
    }

    public int a(com.tencent.mobileqq.msf.core.auth.a aVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, aVar, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        if (!z16) {
            try {
                if (b(aVar.z())) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f247468b, 2, aVar.z() + " setKeyToWtlogin not reach time limit, return ...");
                    }
                    return 1;
                }
            } catch (Exception e16) {
                QLog.d(f247468b, 1, "call setWt error " + e16, e16);
                return -1;
            }
        }
        byte[] k3 = aVar.k();
        int nextSeq = MsfService.getCore().getNextSeq();
        ToServiceMsg toServiceMsg = new ToServiceMsg("", aVar.z(), BaseConstants.CMD_GET_SID);
        toServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
        toServiceMsg.setRequestSsoSeq(nextSeq);
        toServiceMsg.setAppId(100);
        toServiceMsg.setTimeout(30000L);
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247504b = false;
        m.a(toServiceMsg);
        a16.f247503a = true;
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "setKeyToWtlogin|GetStWithoutPasswd");
        }
        int GetStWithoutPasswd = f247480n.GetStWithoutPasswd(aVar.z(), 16L, 16L, toServiceMsg.getAppId(), i3, aVar.b(), aVar.h(), k3, m.b(nextSeq));
        a(toServiceMsg, a16, GetStWithoutPasswd, "setWt");
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "call setWt for " + aVar.z());
        }
        return GetStWithoutPasswd;
    }

    public long a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3)).longValue();
        }
        Ticket GetLocalTicket = f247480n.GetLocalTicket(str, 16L, i3);
        if (GetLocalTicket == null) {
            return 0L;
        }
        return GetLocalTicket._create_time * 1000;
    }

    private void a(ToServiceMsg toServiceMsg, o oVar, int i3, String str) {
        if (i3 != -1001) {
            if (QLog.isColorLevel()) {
                QLog.d(f247468b, 2, "call " + str + " ret  " + i3);
            }
            oVar.a(str, 0, m.b(toServiceMsg.getRequestSsoSeq()));
        }
    }

    private void a(ToServiceMsg toServiceMsg, String str) {
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
        QLog.d(f247468b, 1, Thread.currentThread().getName() + " createNeedLoginRespByWt setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(a16.getUin()));
        f247479m.getAccountCenter().n(a16.getUin());
        a16.setBusinessFail(2001, a16.getBusinessFailMsg());
        MsfSdkUtils.addFromMsgProcessName("*", a16);
        f247479m.addRespToQuque(toServiceMsg, a16);
        QLog.d(f247468b, 1, "found accountToken " + a16.getUin() + " is expired on call " + str);
    }

    public int a(ToServiceMsg toServiceMsg, boolean z16) {
        String str;
        int i3;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, toServiceMsg, Boolean.valueOf(z16))).intValue();
        }
        try {
            str = new String((byte[]) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_LOGIN_PWD), "ISO-8859-1");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            str = "";
        }
        String str2 = str;
        if (z16) {
            String str3 = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN);
            String uin = toServiceMsg.getUin();
            toServiceMsg.setUin(str3);
            toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN, uin);
        }
        o a16 = m.a(f247479m, toServiceMsg);
        a16.f247503a = true;
        m.a(toServiceMsg);
        WUserSigInfo c16 = m.c(toServiceMsg.getRequestSsoSeq());
        a(toServiceMsg, c16);
        String str4 = (String) toServiceMsg.getAttribute("from_where", null);
        if (toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG) != null) {
            c16._in_ksid = (byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG);
        }
        long appId = toServiceMsg.getAppId();
        if (str4 != null && str4.equalsIgnoreCase(BaseConstants.SSO_ACCOUNT_ACTION)) {
            c16._login_bitmap = 2;
        } else {
            c16._login_bitmap = 0;
        }
        Object attribute = toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT);
        if (attribute != null) {
            WtloginHelper.setExtraLoginTlvValue(c16, 1346, (byte[]) attribute);
        }
        Object attribute2 = toServiceMsg.getAttribute(BaseConstants.ATTR_KET_SIF_SESSION);
        if (attribute2 != null) {
            WtloginHelper.setExtraLoginTlvValue(c16, 260, (byte[]) attribute2);
        }
        Object attribute3 = toServiceMsg.getAttribute("businessType");
        if (attribute3 != null && (attribute3 instanceof Integer)) {
            c16.businessType = ((Integer) attribute3).intValue();
        }
        if (BaseConstants.SSO_ACCOUNT_ACTION.equals((String) toServiceMsg.getAttribute("from_where", null))) {
            i3 = ((Integer) toServiceMsg.getAttribute(AppConstants.Key.KEY_PUZZLE_VERIFY_CODE, 0)).intValue();
            j3 = BaseConstants.OPEN_SDK_BUFLAG_B1;
        } else {
            i3 = 130;
            j3 = 16;
        }
        long j16 = j3;
        QLog.d(f247468b, 1, "WTLoginCenter login --> CanWebVerify=" + i3);
        f247480n.SetCanWebVerify(i3);
        long[] jArr = new long[0];
        if (com.tencent.mobileqq.msf.core.x.b.p1()) {
            jArr = new long[]{1600000226};
        }
        long[] jArr2 = jArr;
        byte[][] bArr = new byte[0];
        f247480n.SetUinDeviceToken(true);
        if (QLog.isColorLevel()) {
            QLog.d(f247468b, 2, "login appId = " + j16 + " localappid = " + appId);
        }
        int GetStWithPasswd = f247480n.GetStWithPasswd(toServiceMsg.getUin(), j16, m.f247500f, appId, jArr2, true, str2, c16, bArr);
        a(toServiceMsg, a16, GetStWithPasswd, "login");
        return GetStWithPasswd;
    }

    private void a(ToServiceMsg toServiceMsg, WUserSigInfo wUserSigInfo) {
        Object attribute = toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_542);
        if (attribute instanceof byte[]) {
            if (wUserSigInfo.extraLoginTLVMap.containsKey(1346)) {
                QLog.d(f247468b, 1, "setExtra542TlvValue already have tlv542Data, MsfCommand= " + toServiceMsg.getMsfCommand());
            } else {
                WtloginHelper.setExtraLoginTlvValue(wUserSigInfo, 1346, (byte[]) attribute);
            }
        }
        if (BaseConstants.SSO_ACCOUNT_ACTION.equals((String) toServiceMsg.getAttribute("from_where", null))) {
            Object attribute2 = toServiceMsg.getAttribute(AppConstants.Key.KEY_CONNECT_DATA);
            if (attribute2 instanceof byte[]) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("WTLoginCenter login --> MsfCommand=");
                sb5.append(toServiceMsg.getMsfCommand());
                sb5.append(", connect_data=");
                byte[] bArr = (byte[]) attribute2;
                sb5.append(bArr.length);
                QLog.d(f247468b, 1, sb5.toString());
                WtloginHelper.setExtraLoginTlvValue(wUserSigInfo, 1346, bArr);
                return;
            }
            QLog.d(f247468b, 1, "WTLoginCenter login --> MsfCommand=" + toServiceMsg.getMsfCommand());
        }
    }

    private boolean a() {
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            return new Random().nextInt(100) == 1 && BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn("103024", false);
        }
        return true;
    }

    public int a(ToServiceMsg toServiceMsg, boolean z16, String str) {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, toServiceMsg, Boolean.valueOf(z16), str)).intValue();
        }
        try {
            m.a(f247479m, toServiceMsg);
            a16 = a(toServiceMsg, f247480n);
            QLog.d(f247468b, 1, "changeTokenAfterLogin checkIsNeedLoginWithPasswd " + a16 + " process:" + com.tencent.mobileqq.msf.service.n.b(toServiceMsg) + " cmd:" + toServiceMsg.getServiceCmd() + " src:" + str);
        } catch (Exception e16) {
            QLog.e(f247468b, 1, "changeTokenAfterLogin error " + e16.toString(), e16);
        }
        if (a16 == -1) {
            a(toServiceMsg, "changeTokenAfterLogin");
            return -1;
        }
        if (a16 == 0) {
            b(toServiceMsg, str);
            return a(toServiceMsg, true, f247479m.getAccountCenter().b(toServiceMsg.getUin()), z16);
        }
        if (a16 != 1) {
            return 0;
        }
        b(toServiceMsg, str);
        return a(toServiceMsg, false, (com.tencent.mobileqq.msf.core.auth.a) null, z16);
    }

    private int a(ToServiceMsg toServiceMsg, boolean z16, com.tencent.mobileqq.msf.core.auth.a aVar, boolean z17) {
        int i3;
        long j3;
        long j16;
        boolean z18;
        WUserSigInfo b16;
        int GetStWithoutPasswd;
        try {
            o a16 = m.a(f247479m, toServiceMsg);
            long[] jArr = new long[0];
            if (com.tencent.mobileqq.msf.core.x.b.p1()) {
                jArr = new long[]{1600000226};
            }
            long[] jArr2 = jArr;
            byte[][] bArr = new byte[0];
            long appId = toServiceMsg.getAppId();
            long j17 = 16;
            if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_CHANGETOKEN_A2D2)) {
                i3 = m.f247499e;
            } else if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_CHANGETOKEN_WEBVIEW_KEY)) {
                i3 = m.f247501g;
            } else {
                HashMap hashMap = (HashMap) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_LOGIN_TOKEN_MAP);
                if ((((RequestCustomSig) hashMap.get(e.f247453m)).ulCustumFlag & 8192) == 8192) {
                    appId = Long.parseLong((String) hashMap.get("OpenAppid"));
                    i3 = 16384;
                    j17 = 715019303;
                } else {
                    i3 = 0;
                    j3 = appId;
                    j16 = 16;
                    z18 = false;
                    int i16 = i3 | 33554432;
                    if (com.tencent.mobileqq.msf.core.x.b.d1() || !z18) {
                        return 1;
                    }
                    a16.f247503a = true;
                    f247480n.SetTimeOut((int) toServiceMsg.getTimeout());
                    m.a(toServiceMsg);
                    if ((i16 & 1048576) == 1048576) {
                        b16 = m.c(toServiceMsg.getRequestSsoSeq());
                    } else {
                        b16 = m.b(toServiceMsg.getRequestSsoSeq());
                    }
                    WUserSigInfo wUserSigInfo = b16;
                    if (QLog.isColorLevel()) {
                        QLog.d(f247468b, 2, "changeTokenAfterLoginReal|GetStWithoutPasswd:" + z16);
                    }
                    if (!z16) {
                        byte[][] bArr2 = {r7};
                        byte[] bArr3 = {1};
                        GetStWithoutPasswd = f247480n.GetStWithoutPasswd(toServiceMsg.getUin(), 16L, j16, -1L, i16, j3, jArr2, wUserSigInfo, bArr, bArr2);
                    } else {
                        if (aVar == null) {
                            QLog.e(f247468b, 1, "changeTokenAfterLogin error account is null.");
                            return -1;
                        }
                        if (BaseApplication.getContext() != null && BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
                            return -1;
                        }
                        GetStWithoutPasswd = f247480n.GetStWithoutPasswd(aVar.z(), 16L, 16L, toServiceMsg.getAppId(), i16, aVar.b(), aVar.h(), aVar.k(), wUserSigInfo);
                    }
                    try {
                        a(toServiceMsg, a16, GetStWithoutPasswd, "sendChangeTokenMsg");
                        return GetStWithoutPasswd;
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(f247468b, 1, "changeTokenAfterLogin error " + e.toString(), e);
                        return 0;
                    }
                }
            }
            j3 = appId;
            j16 = j17;
            z18 = true;
            int i162 = i3 | 33554432;
            if (com.tencent.mobileqq.msf.core.x.b.d1()) {
            }
            return 1;
        } catch (Exception e17) {
            e = e17;
        }
    }

    int a(ToServiceMsg toServiceMsg, WtloginHelper wtloginHelper) {
        if (!wtloginHelper.IsNeedLoginWithPasswd(toServiceMsg.getUin(), 16L).booleanValue()) {
            return 1;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = f247479m.getAccountCenter().b(toServiceMsg.getUin());
        if (b16 != null && b16.B()) {
            return 0;
        }
        QLog.d(f247468b, 1, "checkIsNeedLoginWithPasswd " + MD5.toMD5(toServiceMsg.getUin()) + " IsNeedLoginWithPasswd");
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
        a16.setBusinessFail(2001, toServiceMsg.getUin() + " not login");
        MsfSdkUtils.addFromMsgProcessName("*", a16);
        f247479m.addRespToQuque(toServiceMsg, a16);
        return -1;
    }

    public HashMap<String, String> a(String str) {
        String str2;
        String str3;
        Exception e16;
        String str4;
        String str5;
        Ticket GetLocalTicket;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (HashMap) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        try {
            Ticket GetLocalTicket2 = f247480n.GetLocalTicket(str, 16L, 64);
            str4 = (GetLocalTicket2 == null || (bArr3 = GetLocalTicket2._sig) == null) ? null : HexUtil.bytes2HexStr(bArr3);
            try {
                Ticket GetLocalTicket3 = f247480n.GetLocalTicket(str, 16L, 4096);
                str3 = (GetLocalTicket3 == null || (bArr2 = GetLocalTicket3._sig) == null) ? null : new String(bArr2);
                try {
                    GetLocalTicket = f247480n.GetLocalTicket(str, 16L, 32);
                } catch (Exception e17) {
                    e16 = e17;
                    e16.printStackTrace();
                    str5 = null;
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("uin", str);
                    hashMap.put(NowProxyConstants.AccountInfoKey.A2, str4);
                    hashMap.put("vkey", null);
                    hashMap.put("skey", str3);
                    hashMap.put("pskey", null);
                    hashMap.put("stweb", str5);
                    hashMap.put("superkey", null);
                    return hashMap;
                }
            } catch (Exception e18) {
                str2 = str4;
                e = e18;
                str3 = null;
                String str6 = str2;
                e16 = e;
                str4 = str6;
                e16.printStackTrace();
                str5 = null;
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("uin", str);
                hashMap2.put(NowProxyConstants.AccountInfoKey.A2, str4);
                hashMap2.put("vkey", null);
                hashMap2.put("skey", str3);
                hashMap2.put("pskey", null);
                hashMap2.put("stweb", str5);
                hashMap2.put("superkey", null);
                return hashMap2;
            }
        } catch (Exception e19) {
            e = e19;
            str2 = null;
        }
        if (GetLocalTicket != null && (bArr = GetLocalTicket._sig) != null) {
            str5 = HexUtil.bytes2HexStr(bArr);
            HashMap<String, String> hashMap22 = new HashMap<>();
            hashMap22.put("uin", str);
            hashMap22.put(NowProxyConstants.AccountInfoKey.A2, str4);
            hashMap22.put("vkey", null);
            hashMap22.put("skey", str3);
            hashMap22.put("pskey", null);
            hashMap22.put("stweb", str5);
            hashMap22.put("superkey", null);
            return hashMap22;
        }
        str5 = null;
        HashMap<String, String> hashMap222 = new HashMap<>();
        hashMap222.put("uin", str);
        hashMap222.put(NowProxyConstants.AccountInfoKey.A2, str4);
        hashMap222.put("vkey", null);
        hashMap222.put("skey", str3);
        hashMap222.put("pskey", null);
        hashMap222.put("stweb", str5);
        hashMap222.put("superkey", null);
        return hashMap222;
    }

    public void a(WUserSigInfo wUserSigInfo, HashMap<String, Object> hashMap) {
        byte[] bArr;
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) wUserSigInfo, (Object) hashMap);
            return;
        }
        StringBuilder sb5 = new StringBuilder("regAddFaceParam analysisExtraMap");
        if (hashMap != null) {
            bArr = (byte[]) hashMap.get(MsfConstants.ATTRIBUTE_MAP_FACE_REG_SIG);
            bArr2 = (byte[]) hashMap.get(MsfConstants.ATTRIBUTE_MAP_FACE_RESULT);
        } else {
            sb5.append(",extraMap = null");
            bArr = null;
            bArr2 = null;
        }
        sb5.append(",byteFaceRegSig = ");
        if (bArr != null) {
            sb5.append(bArr.length);
            WtloginHelper.setExtraRegTlvValue(wUserSigInfo, 54, bArr);
        } else {
            sb5.append("null");
        }
        sb5.append(",byteFaceResult = ");
        if (bArr2 != null) {
            sb5.append(bArr2.length);
            WtloginHelper.setExtraRegTlvValue(wUserSigInfo, 55, bArr2);
        } else {
            sb5.append("null");
        }
        QLog.i(f247468b, 1, sb5.toString());
    }

    public int a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String str = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_SMSCODE);
        String str2 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_PASS);
        String str3 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_NICK);
        int i3 = (!toServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_REGISTER_TYPE) || ((Boolean) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_TYPE)).booleanValue()) ? 1 : 5;
        o a16 = m.a(f247479m, toServiceMsg);
        m.a(toServiceMsg);
        WUserSigInfo b16 = m.b(toServiceMsg.getRequestSsoSeq());
        b16._seqence = a16.f247508f;
        String str4 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_LH_UIN);
        String str5 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_UNBIND_LH_UIN);
        String str6 = (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION);
        if (!TextUtils.isEmpty(str4)) {
            if (QLog.isColorLevel()) {
                QLog.d(f247468b, 2, "RegGetAccount|lhUin= " + str4);
            }
            a(b16, 46, str4);
        } else if (!TextUtils.isEmpty(str5)) {
            if (QLog.isColorLevel()) {
                QLog.d(f247468b, 2, "RegGetAccount|unBindUin= " + str4);
            }
            a(b16, 47, str5);
        }
        a(b16, (HashMap<String, Object>) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_REGISTER_MAP_PARAM));
        if (str == null) {
            str = "";
        }
        byte[] bArr = (byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_PROFILE_SIG, null);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("add wxRegisterToken , length = ");
        sb5.append(bArr != null ? Integer.valueOf(bArr.length) : null);
        QLog.d(f247468b, 1, sb5.toString());
        int RegGetAccount = f247480n.RegGetAccount(str.getBytes(), "qqpassport".getBytes(), str2.getBytes(), str3.getBytes(), str6.getBytes(), bArr, i3, b16);
        a(toServiceMsg, a16, RegGetAccount, "RegGetAccount");
        return RegGetAccount;
    }

    public static void a(WUserSigInfo wUserSigInfo, int i3, String str) {
        long j3;
        if (wUserSigInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            j3 = Long.valueOf(str).longValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (j3 > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(f247468b, 2, "setExtraRegTlvValue|type= " + i3 + "|" + j3);
            }
            byte[] bArr = new byte[8];
            util.int64_to_buf(bArr, 0, j3);
            WtloginHelper.setExtraRegTlvValue(wUserSigInfo, i3, bArr);
        }
    }
}
