package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.troop.d;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopNotificationHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    public TroopNotificationHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, byte[] bArr) throws InvalidProtocolBufferMicroException {
        int i3 = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr).uint32_result.get();
        if (i3 != 0 && QLog.isColorLevel()) {
            QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive return Error result:" + i3 + "cmd\uff1a" + toServiceMsg.getServiceCmd());
        }
    }

    private void H2(List<Long> list) {
        if (!list.isEmpty() && list.size() <= 70) {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.set(list);
            oidb_0x5eb_reqbody.uint32_req_age.set(1);
            oidb_0x5eb_reqbody.uint32_req_gender.set(1);
            oidb_0x5eb_reqbody.uint32_req_city.set(1);
            oidb_0x5eb_reqbody.uint32_req_province.set(1);
            oidb_0x5eb_reqbody.uint32_req_country.set(1);
            oidb_0x5eb_reqbody.uint32_req_400_flag.set(1);
            oidb_0x5eb_reqbody.uint32_req_business_user.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_troopnotifycation", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("uins", list);
            sendPbReq(makeOIDBPkg);
            QLog.i("TroopNotificationHandler", 1, "[getNotifyCationApplicantInfoBy0x5eb]");
        }
    }

    private void I2(List<Long> list) {
        if (!list.isEmpty() && list.size() <= 70) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) == null) {
                    list.remove(i3);
                }
            }
            if (list.isEmpty()) {
                QLog.i("TroopNotificationHandler", 1, "[getNotifyCationApplicantQQLevelBy0x668] uins is empty");
                return;
            }
            short size = (short) list.size();
            ByteBuffer allocate = ByteBuffer.allocate((list.size() * 4) + 2);
            allocate.putShort(size);
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                allocate.putInt((int) it.next().longValue());
            }
            byte[] array = allocate.array();
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1640);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(array));
            M2("OidbSvc.0x668", oidb_sso_oidbssopkg.toByteArray(), null);
            QLog.i("TroopNotificationHandler", 1, "[getNotifyCationApplicantQQLevelBy0x668] ");
        }
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ITroopNotificationService iTroopNotificationService;
        List<oidb_0x5eb$UdcUinData> list;
        if (toServiceMsg == null || fromServiceMsg == null || obj == null || (iTroopNotificationService = (ITroopNotificationService) this.appRuntime.getRuntimeService(ITroopNotificationService.class, "")) == null) {
            return;
        }
        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
        if (OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x5eb_rspbody) == 0) {
            if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has()) {
                list = oidb_0x5eb_rspbody.rpt_msg_uin_data.get();
            } else {
                list = null;
            }
            iTroopNotificationService.saveApplicantInfoListToCacheFrom0x5eb(L2(list));
            notifyUI(d.f286419b, true, new Object[]{list});
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ITroopNotificationService iTroopNotificationService;
        if (toServiceMsg == null || fromServiceMsg == null || obj == null || !fromServiceMsg.isSuccess()) {
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException unused) {
        }
        if (oidb_sso_oidbssopkg == null || !oidb_sso_oidbssopkg.uint32_result.has() || !oidb_sso_oidbssopkg.bytes_bodybuffer.has() || oidb_sso_oidbssopkg.bytes_bodybuffer.get() == null || oidb_sso_oidbssopkg.uint32_result.get() != 0) {
            return;
        }
        byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
        short shortData = PkgTools.getShortData(byteArray, 0);
        if (byteArray.length != (shortData * 10) + 2 || (iTroopNotificationService = (ITroopNotificationService) this.appRuntime.getRuntimeService(ITroopNotificationService.class, "")) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i3 = 2;
        for (int i16 = 0; i16 < shortData; i16++) {
            long longData = PkgTools.getLongData(byteArray, i3);
            arrayList.add(Long.valueOf(longData));
            int i17 = i3 + 4;
            short shortData2 = PkgTools.getShortData(byteArray, i17);
            i3 = i17 + 2 + 4;
            hashMap.put(Long.valueOf(longData), Integer.valueOf(shortData2));
        }
        iTroopNotificationService.saveApplicantInfoToCacheFrom0x668(hashMap);
        notifyUI(d.f286419b, true, new Object[]{arrayList});
    }

    private List<com.tencent.mobileqq.data.troop.d> L2(List<oidb_0x5eb$UdcUinData> list) {
        String str;
        String str2;
        String str3;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        ITroopNotificationService iTroopNotificationService = (ITroopNotificationService) this.appRuntime.getRuntimeService(ITroopNotificationService.class, "");
        if (list != null && !list.isEmpty() && iTroopNotificationService != null) {
            for (oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata : list) {
                if (oidb_0x5eb_udcuindata != null) {
                    long j3 = oidb_0x5eb_udcuindata.uint64_uin.get();
                    int i3 = oidb_0x5eb_udcuindata.uint32_age.get();
                    if (!oidb_0x5eb_udcuindata.bytes_country.has()) {
                        str = "";
                    } else {
                        str = oidb_0x5eb_udcuindata.bytes_country.get().toStringUtf8();
                    }
                    if (!oidb_0x5eb_udcuindata.bytes_province.has()) {
                        str2 = "";
                    } else {
                        str2 = oidb_0x5eb_udcuindata.bytes_province.get().toStringUtf8();
                    }
                    if (!oidb_0x5eb_udcuindata.bytes_city.has()) {
                        str3 = "";
                    } else {
                        str3 = oidb_0x5eb_udcuindata.bytes_city.get().toStringUtf8();
                    }
                    int i16 = oidb_0x5eb_udcuindata.uint32_gender.get();
                    if (oidb_0x5eb_udcuindata.uint32_400_flag.get() != 1 && oidb_0x5eb_udcuindata.uint32_business_user.get() != 1) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    com.tencent.mobileqq.data.troop.d applicantInfo = iTroopNotificationService.getApplicantInfo(Long.valueOf(j3));
                    if (applicantInfo != null) {
                        applicantInfo.q(i16);
                        applicantInfo.m(str3);
                        applicantInfo.n(str);
                        applicantInfo.p(str2);
                        applicantInfo.l(i3);
                        applicantInfo.r(true);
                        applicantInfo.t(z16);
                        arrayList.add(applicantInfo);
                    } else {
                        arrayList.add(new com.tencent.mobileqq.data.troop.d(j3, i3, str, str2, str3, i16, z16, true));
                    }
                }
            }
        }
        return arrayList;
    }

    public void G2(List<Long> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && list != null) {
            if (str.equals("OidbSvc.0x5eb_troopnotifycation")) {
                H2(list);
            } else if (str.equals("OidbSvc.0x668")) {
                I2(list);
            }
        }
    }

    public void M2(String str, byte[] bArr, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, bArr, bundle);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), str);
        toServiceMsg.putWupBuffer(bArr);
        if (bundle != null) {
            toServiceMsg.extraData = bundle;
        }
        sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.troop.api.observer.d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive resultCode:" + fromServiceMsg.getResultCode() + "errMsg: " + fromServiceMsg.getBusinessFailMsg() + "serviceCmd: " + toServiceMsg.getServiceCmd());
            }
            String serviceCmd = toServiceMsg.getServiceCmd();
            try {
                F2(toServiceMsg, (byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive exception: " + e16.getMessage() + "cmd\uff1a" + toServiceMsg.getServiceCmd());
                }
            }
            if ("OidbSvc.0x5eb_troopnotifycation".equals(serviceCmd)) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0x668".equals(serviceCmd)) {
                    K2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive res == null || req == null");
    }
}
