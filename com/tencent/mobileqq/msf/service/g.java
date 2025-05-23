package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f250912a = "GuidConflictHandler";

    /* renamed from: b, reason: collision with root package name */
    private static final String f250913b = "guid_conflict_been_handled";

    /* renamed from: c, reason: collision with root package name */
    private static final String f250914c = "wtlogin_guid_conflict";

    /* renamed from: d, reason: collision with root package name */
    private static final String f250915d = "clearAccount";

    /* renamed from: e, reason: collision with root package name */
    private static final String f250916e = "0f607264fc6318a92b9e13c65db7cd3c";

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a() {
        try {
            QLog.d(f250912a, 1, "handlerGuidConflict");
            if (c()) {
                HashMap hashMap = new HashMap();
                if (d() && !b()) {
                    QLog.d(f250912a, 1, "handlerGuidConflict clear accounts");
                    hashMap.put(f250915d, "true");
                    e();
                    com.tencent.mobileqq.msf.core.auth.i.f247480n.clearAllSigAndUpdateGuid();
                    NetConnInfoCenter.GUID = com.tencent.mobileqq.msf.core.auth.i.f247480n.GetGuid();
                    FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_APP_CLONE);
                    fromServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
                    fromServiceMsg.setBusinessFail(3003);
                    MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                    MsfService.getCore().addRespToQuque(null, fromServiceMsg);
                } else {
                    hashMap.put(f250915d, "false");
                }
                BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(MsfService.getCore().getAccountCenter().e(), f250914c, true, hashMap, false);
            }
        } catch (Exception e16) {
            QLog.e(f250912a, 1, e16, new Object[0]);
        }
    }

    private static boolean b() {
        return com.tencent.mobileqq.msf.core.b0.a.b().a().decodeBool(f250913b, false);
    }

    private static boolean c() {
        if (f250916e.equalsIgnoreCase(util.buf_to_string(NetConnInfoCenter.GUID))) {
            return true;
        }
        return false;
    }

    private static boolean d() {
        return BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn("102552", false);
    }

    private static void e() {
        com.tencent.mobileqq.msf.core.b0.a.b().a().encodeBool(f250913b, true);
    }
}
