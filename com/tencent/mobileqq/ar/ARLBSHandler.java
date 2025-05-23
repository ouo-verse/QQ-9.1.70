package com.tencent.mobileqq.ar;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49$ARClassifyLBSCheckReq;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49$ARClassifyLBSCheckRsp;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49$LBSPoint;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49$ReqBody;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49$RspBody;
import com.tencent.mobileqq.ar.arengine.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARLBSHandler extends BusinessHandler {
    public ARLBSHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private static b.a D2(oidb_cmd0xb49$LBSPoint oidb_cmd0xb49_lbspoint) {
        int i3;
        int i16;
        String str;
        b.a aVar = new b.a();
        int i17 = 0;
        if (oidb_cmd0xb49_lbspoint.int32_lat.has()) {
            i3 = oidb_cmd0xb49_lbspoint.int32_lat.get();
        } else {
            i3 = 0;
        }
        aVar.f198150a = i3;
        if (oidb_cmd0xb49_lbspoint.int32_lon.has()) {
            i16 = oidb_cmd0xb49_lbspoint.int32_lon.get();
        } else {
            i16 = 0;
        }
        aVar.f198151b = i16;
        String str2 = "";
        if (!oidb_cmd0xb49_lbspoint.str_name.has()) {
            str = "";
        } else {
            str = oidb_cmd0xb49_lbspoint.str_name.get();
        }
        aVar.f198152c = str;
        if (oidb_cmd0xb49_lbspoint.str_addr.has()) {
            str2 = oidb_cmd0xb49_lbspoint.str_addr.get();
        }
        aVar.f198153d = str2;
        if (oidb_cmd0xb49_lbspoint.uint32_dist.has()) {
            i17 = oidb_cmd0xb49_lbspoint.uint32_dist.get();
        }
        aVar.f198154e = i17;
        return aVar;
    }

    public boolean E2(String str, int i3, int i16) {
        QLog.i("ARLBSHandler", 1, "requestToCheckLBSLocation. imageId = " + str + ", latitude = " + i3 + ", longitude = " + i16);
        oidb_cmd0xb49$ReqBody oidb_cmd0xb49_reqbody = new oidb_cmd0xb49$ReqBody();
        oidb_cmd0xb49_reqbody.int32_lat.set(i3);
        oidb_cmd0xb49_reqbody.int32_lon.set(i16);
        oidb_cmd0xb49$ARClassifyLBSCheckReq oidb_cmd0xb49_arclassifylbscheckreq = new oidb_cmd0xb49$ARClassifyLBSCheckReq();
        oidb_cmd0xb49_arclassifylbscheckreq.str_id.set(str);
        oidb_cmd0xb49_reqbody.msg_ar_classify_req.set(oidb_cmd0xb49_arclassifylbscheckreq);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xb49", 2889, 10, oidb_cmd0xb49_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("imageId", str);
        sendPbReq(makeOIDBPkg);
        return true;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        b.a aVar;
        if (toServiceMsg != null && fromServiceMsg != null && "OidbSvc.0xb49".equals(fromServiceMsg.getServiceCmd())) {
            com.tencent.mobileqq.ar.arengine.b bVar = new com.tencent.mobileqq.ar.arengine.b();
            String str = "";
            String str2 = (String) toServiceMsg.getAttribute("imageId", "");
            QLog.i("ARLBSHandler", 1, "req.getAttribute id imageIdSend:" + str2);
            if (fromServiceMsg.isSuccess()) {
                oidb_cmd0xb49$RspBody oidb_cmd0xb49_rspbody = new oidb_cmd0xb49$RspBody();
                OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_cmd0xb49_rspbody);
                fromServiceMsg.extraData.getString("str_error_msg");
                if (oidb_cmd0xb49_rspbody.msg_ar_classify_rsp.has()) {
                    oidb_cmd0xb49$ARClassifyLBSCheckRsp oidb_cmd0xb49_arclassifylbscheckrsp = oidb_cmd0xb49_rspbody.msg_ar_classify_rsp.get();
                    if (oidb_cmd0xb49_arclassifylbscheckrsp.str_id.has()) {
                        str = oidb_cmd0xb49_arclassifylbscheckrsp.str_id.get();
                    }
                    if (!str.equalsIgnoreCase(str2)) {
                        QLog.i("ARLBSHandler", 1, "onReceiveLBSLocation. resp is success. err: image id is not equals. req image id = " + str2 + ", rsp image id = " + str);
                        return;
                    }
                    if (oidb_cmd0xb49_arclassifylbscheckrsp.uint32_lbs_result.has()) {
                        i3 = oidb_cmd0xb49_arclassifylbscheckrsp.uint32_lbs_result.get();
                    } else {
                        i3 = -1;
                    }
                    bVar.f198147a = i3;
                    bVar.f198148b = str;
                    if (oidb_cmd0xb49_arclassifylbscheckrsp.msg_nearest_point.has()) {
                        aVar = D2(oidb_cmd0xb49_arclassifylbscheckrsp.msg_nearest_point);
                    } else {
                        aVar = null;
                    }
                    bVar.f198149c = aVar;
                }
                QLog.i("ARLBSHandler", 1, "onReceiveLBSLocation. resp is success. retCode = " + bVar.f198147a);
            } else {
                QLog.i("ARLBSHandler", 1, "onReceiveLBSLocation. resp is failed. ");
            }
            notifyUI(1, true, bVar);
        }
    }
}
