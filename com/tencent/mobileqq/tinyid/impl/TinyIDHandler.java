package com.tencent.mobileqq.tinyid.impl;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xfe3.oidb_cmd0xfe3$ReqBody;
import tencent.im.oidb.cmd0xfe3.oidb_cmd0xfe3$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TinyIDHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static final String f293222m;

    /* renamed from: d, reason: collision with root package name */
    private final String f293223d;

    /* renamed from: e, reason: collision with root package name */
    private final String f293224e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f293225f;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f293226h;

    /* renamed from: i, reason: collision with root package name */
    private AppInterface f293227i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43804);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f293222m = TinyIDHandler.class.getName();
        }
    }

    public TinyIDHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f293223d = "0xfe3";
        this.f293224e = "0";
        this.f293225f = new AtomicInteger(1000);
        this.f293226h = new ConcurrentHashMap<>();
        this.f293227i = appInterface;
    }

    private static String D2(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 4) {
            return "*" + str.substring(str.length() - 4);
        }
        return str;
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        if (obj != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = (String) toServiceMsg.getAttribute("RequestID");
        a aVar = this.f293226h.get(str2);
        try {
            if (z16) {
                try {
                    QLog.d("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID] 0xfe3, resultCode = [" + fromServiceMsg.getResultCode() + "], req = [" + toServiceMsg + "], res = [" + fromServiceMsg + "]");
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    try {
                        oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.d("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID] 0xfe3, pkg.mergeFrom error e =", e16);
                    }
                    if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                        if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                            oidb_cmd0xfe3$RspBody oidb_cmd0xfe3_rspbody = new oidb_cmd0xfe3$RspBody();
                            try {
                                oidb_cmd0xfe3_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                            } catch (InvalidProtocolBufferMicroException e17) {
                                QLog.e("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID] 0xfe3, rspBody.mergeFrom error: ", e17);
                            }
                            String str3 = oidb_cmd0xfe3_rspbody.tiny_id.get();
                            J2(toServiceMsg.getUin(), str3);
                            if (aVar != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TinyID.TinyIDHandlerImpl", 2, "[getTinyIDAsync] return tinyID by network, tinyID: " + str3);
                                } else {
                                    QLog.d("TinyID.TinyIDHandlerImpl", 1, "[getTinyIDAsync] return tinyID by network, tinyID: " + D2(str3));
                                }
                                aVar.a(str3);
                            }
                        } else {
                            QLog.d("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID]: pkg.bytes_bodybuffer is null");
                        }
                    } else {
                        if (oidb_sso_oidbssopkg.uint32_result.has()) {
                            str = " pkg.uint32_result error code: " + oidb_sso_oidbssopkg.uint32_result.get();
                        } else {
                            str = " pkg.uint32_result do not have";
                        }
                        QLog.d("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID], " + str);
                    }
                } catch (Exception e18) {
                    QLog.e("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID], parse 0xfe3 error, ", e18);
                }
            }
        } finally {
            H2(str2, aVar);
        }
    }

    private void J2(String str, String str2) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString("TinyID_Cache" + str, str2).commitAsync();
    }

    private String K2(String str, long j3) {
        try {
            return HexUtil.bytes2HexStr(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(("#" + str + ContainerUtils.FIELD_DELIMITER + "0xfe3&0&" + j3 + "#").getBytes("UTF-8")));
        } catch (Exception e16) {
            QLog.e("TinyID.TinyIDHandlerImpl", 1, e16, new Object[0]);
            return "";
        }
    }

    public void E2(String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("TinyID_Cache" + str, "");
        if (!TextUtils.isEmpty(decodeString)) {
            if (QLog.isColorLevel()) {
                QLog.d("TinyID.TinyIDHandlerImpl", 2, "[getTinyIDAsync] return tinyID by cache, tinyID: " + decodeString);
            } else {
                QLog.d("TinyID.TinyIDHandlerImpl", 1, "[getTinyIDAsync] return tinyID by cache, tinyID: " + D2(decodeString));
            }
            aVar.a(decodeString);
            return;
        }
        I2(aVar);
    }

    public String F2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("TinyID_Cache" + str, "");
        if (QLog.isColorLevel()) {
            QLog.d("TinyID.TinyIDHandlerImpl", 2, "[getTinyIDSync] return tinyID by cache, tinyID: " + decodeString);
        } else {
            QLog.d("TinyID.TinyIDHandlerImpl", 1, "[getTinyIDSync] return tinyID by cache, tinyID: " + D2(decodeString));
        }
        return decodeString;
    }

    public void H2(String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        ConcurrentHashMap<String, a> concurrentHashMap = this.f293226h;
        if (concurrentHashMap != null && aVar != null) {
            concurrentHashMap.remove(str);
        }
    }

    public void I2(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        oidb_cmd0xfe3$ReqBody oidb_cmd0xfe3_reqbody = new oidb_cmd0xfe3$ReqBody();
        String num = Integer.toString(this.f293225f.getAndIncrement());
        this.f293226h.put(num, aVar);
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            String K2 = K2(currentAccountUin, currentTimeMillis);
            if (TextUtils.isEmpty(K2)) {
                QLog.d("TinyID.TinyIDHandlerImpl", 1, "SHA256 hash sign failed");
                return;
            }
            oidb_cmd0xfe3_reqbody.sign.set(K2);
            oidb_cmd0xfe3_reqbody.post_time.set(currentTimeMillis);
            QLog.d("TinyID.TinyIDHandlerImpl", 1, "[reqGetTinyID] 0xfe3, SHA256 hash sign:" + K2.substring(0, 3));
            QLog.d("TinyID.TinyIDHandlerImpl", 1, "[reqGetTinyID] 0xfe3, sign combined success, and send pb request");
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xfe3", 4067, 0, oidb_cmd0xfe3_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("RequestID", num);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("TinyID.TinyIDHandlerImpl", 1, "[reqGetTinyID] 0xfe3, combined sign Error: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xfe3");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                QLog.d("TinyID.TinyIDHandlerImpl", 1, "onReceive, msgCmdFilter is true,cmd  = " + serviceCmd);
                return;
            }
            if (fromServiceMsg.getServiceCmd().equals("OidbSvc.0xfe3")) {
                QLog.d("TinyID.TinyIDHandlerImpl", 1, "[onReceive] 0xfe3, get TinyID message");
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        QLog.d("TinyID.TinyIDHandlerImpl", 1, "[onReceive] req or res is null");
    }
}
