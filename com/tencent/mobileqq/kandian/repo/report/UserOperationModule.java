package com.tencent.mobileqq.kandian.repo.report;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.c;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.kandian.base.utils.b;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.SPEventReportSwitch;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886$RspBody;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0$RspBody;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UserOperationModule implements IUserOperationModule, com.tencent.mobileqq.kandian.base.msf.a {
    public static final int APP_PUSH_BITMAP_FLAG = 1;
    public static final int KANDIAN_DAILY_BITMAP_FLAG = 2;
    private static final String TAG = "UserOperationModule";
    private static volatile UserOperationModule instance;
    private final ReadInJoyMSFService mMSFService = ReadInJoyMSFService.f();
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    UserOperationModule() {
    }

    private void addPublicFeatureValue(oidb_cmd0x80a.KDEventReportReq kDEventReportReq) {
        ReadInJoyMMapKvStorage readInJoyMMapKvStorage = ReadInJoyMMapKvStorage.getInstance("80aEvent");
        List<oidb_cmd0x80a.AttributeList> list = kDEventReportReq.att_list.get();
        String valeForKey = readInJoyMMapKvStorage.getValeForKey("content");
        if (TextUtils.isEmpty(valeForKey)) {
            return;
        }
        if (readInJoyMMapKvStorage.getExpiredTime() != 0 && readInJoyMMapKvStorage.getExpiredTime() < System.currentTimeMillis() / 1000) {
            readInJoyMMapKvStorage.invalidate();
            return;
        }
        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
        attributeList.att_id.set(127);
        attributeList.att_name.set("FeatureFrameworkAttr");
        attributeList.att_value.set(valeForKey);
        list.add(attributeList);
    }

    private String get80aReportReq(oidb_cmd0x80a.KDEventReportReq kDEventReportReq) {
        if (kDEventReportReq == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_id", kDEventReportReq.event_id.get() + "");
            jSONObject.put("event_name", kDEventReportReq.event_name.get());
            jSONObject.put("version", kDEventReportReq.version.get() + "");
            List<oidb_cmd0x80a.AttributeList> list = kDEventReportReq.att_list.get();
            if (list != null) {
                JSONArray jSONArray = new JSONArray();
                for (oidb_cmd0x80a.AttributeList attributeList : list) {
                    if (attributeList != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("att_id", String.valueOf(attributeList.att_id.get()));
                        jSONObject2.put("att_name", attributeList.att_name.get());
                        jSONObject2.put("att_value", attributeList.att_value.get());
                        jSONArray.mo162put(jSONObject2);
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("att_list", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static UserOperationModule getInstance() {
        if (instance == null) {
            synchronized (UserOperationModule.class) {
                if (instance == null) {
                    instance = new UserOperationModule();
                }
            }
        }
        return instance;
    }

    private int getNetType() {
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork == 0) {
            return 0;
        }
        int i3 = 1;
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                i3 = 3;
                if (systemNetwork == 3) {
                    return 2;
                }
                if (systemNetwork != 4) {
                    if (systemNetwork != 5) {
                        return 0;
                    }
                }
            }
            return i3;
        }
        return 4;
    }

    private void handle0x80aPushEffectEvent(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        oidb_cmd0x80a.RspBody rspBody = new oidb_cmd0x80a.RspBody();
        int c16 = c.c(fromServiceMsg, obj, rspBody);
        if (c16 == 0) {
            processKDEventReportResp(rspBody);
            updatePulseReportParams(rspBody);
            if (rspBody.lastRecvMsgDuration.has() && rspBody.lastSendMsgDuration.has()) {
                ReadInJoyHelper.k0((int) rspBody.lastRecvMsgDuration.get(), (int) rspBody.lastSendMsgDuration.get());
            }
            if (rspBody.pulseTimerDuration.has() && rspBody.pulseTimerDuration.get() != 12345678) {
                ReadinjoySPEventReport.J().E0((int) rspBody.pulseTimerDuration.get());
            }
            if (rspBody.leftBtmRedCntMaxForExitAIO.has()) {
                ReadInJoyHelper.q0((int) rspBody.leftBtmRedCntMaxForExitAIO.get());
            }
            if (rspBody.uint64_scroll_interval_time.has()) {
                ReadinjoySPEventReport.f.f239826a = rspBody.uint64_scroll_interval_time.get();
            }
            if (rspBody.uint64_scroll_all_time.has()) {
                ReadinjoySPEventReport.f.f239827b = rspBody.uint64_scroll_all_time.get();
            }
            if (rspBody.uint64_chat_aio_time.has()) {
                ReadinjoySPEventReport.f239775u = rspBody.uint64_chat_aio_time.get();
            }
            processKDTabNumRedpntResp(rspBody);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handle0x80aPushEffectEvent, result=" + c16);
        }
    }

    private void handle0x886UserOperationReport(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int c16 = c.c(fromServiceMsg, obj, new MessageMicro<oidb_cmd0x886$RspBody>() { // from class: tencent.im.oidb.cmd0x886.oidb_cmd0x886$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"int32_ret", "uint64_uin", "bytes_msg"}, new Object[]{0, 0L, ByteStringMicro.EMPTY}, oidb_cmd0x886$RspBody.class);
            public final PBInt32Field int32_ret = PBField.initInt32(0);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        });
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handle0x886UserOperationReport, result=" + c16);
        }
    }

    private void handleUserActionReportResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        QLog.d(TAG, 1, "handleUserActionReport ret : " + c.c(fromServiceMsg, obj, new MessageMicro<oidb_cmd0xde0$RspBody>() { // from class: tencent.im.oidb.cmd0xde0.oidb_cmd0xde0$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isSuccess"}, new Object[]{Boolean.FALSE}, oidb_cmd0xde0$RspBody.class);
            public final PBBoolField isSuccess = PBField.initBool(false);
        }));
    }

    private void processKDEventReportResp(oidb_cmd0x80a.RspBody rspBody) {
        long j3 = rspBody.uint64_uin.has() ? rspBody.uint64_uin.get() : 0L;
        if (!rspBody.rsp_kd_event_report_resp.has() || rspBody.rsp_kd_event_report_resp.get() == null) {
            return;
        }
        if (rspBody.rsp_kd_event_report_resp.get().condParams.has()) {
            SPEventReportSwitch.f(rspBody.rsp_kd_event_report_resp.get().condParams.get());
        }
        if (rspBody.rsp_kd_event_report_resp.get().unit_reset.has()) {
            rspBody.rsp_kd_event_report_resp.get().unit_reset.get();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handle0x80aPushEffectEvent, uin:" + j3 + ";rspKDEventReportResp.result:" + rspBody.rsp_kd_event_report_resp.get().result.get() + ";rspKDEventReportResp.err_msg" + rspBody.rsp_kd_event_report_resp.get().err_msg.get());
        }
    }

    private void processKDTabNumRedpntResp(oidb_cmd0x80a.RspBody rspBody) {
        if (rspBody.uint64_should_hide_kdtab_num_redpnt.has()) {
            rspBody.uint64_should_hide_kdtab_num_redpnt.get();
        }
    }

    private void updatePulseReportParams(oidb_cmd0x80a.RspBody rspBody) {
        if (rspBody.AIOPulseMaxCnt.has() && rspBody.firstScnRedPntPulseMaxCnt.has() && rspBody.leftBtmRedPntPulseMaxCnt.has()) {
            ReadInJoyHelper.x0(b.c(), rspBody.leftBtmRedPntPulseMaxCnt.get(), rspBody.firstScnRedPntPulseMaxCnt.get(), rspBody.AIOPulseMaxCnt.get());
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.msf.a
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.getServiceCmd().equals("OidbSvc.0x80a")) {
            handle0x80aPushEffectEvent(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
            handle0x886UserOperationReport(toServiceMsg, fromServiceMsg, obj);
        } else if (fromServiceMsg.getServiceCmd().equals("OidbSvc.0xc22")) {
            handle0x80aPushEffectEvent(toServiceMsg, fromServiceMsg, obj);
        } else if (fromServiceMsg.getServiceCmd().equals("OidbSvc.0xde0")) {
            handleUserActionReportResp(toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule
    public void request0x80aPushEffectEvent(int i3, String str, List<oidb_cmd0x80a.AttributeList> list) {
        Pair<String, Integer> commandFrom = getCommandFrom(i3);
        request0x80aPushEffectEvent(i3, str, -1, list, (String) commandFrom.first, ((Integer) commandFrom.second).intValue());
    }

    private void sendPbReq(ToServiceMsg toServiceMsg) {
        if (toServiceMsg != null) {
            toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            toServiceMsg.extraData.putLong("time_stamp", System.currentTimeMillis());
            this.mMSFService.j(toServiceMsg, this);
        }
    }

    @Override // com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule
    public void request0x80aPushEffectEvent(int i3, String str, int i16, List<oidb_cmd0x80a.AttributeList> list, String str2, int i17) {
        oidb_cmd0x80a.ReqBody reqBody = new oidb_cmd0x80a.ReqBody();
        reqBody.uint64_uin.set(Long.valueOf(b.a()).longValue());
        reqBody.uint32_network_type.set(getNetType());
        reqBody.uint32_app_bitmap.set(3);
        reqBody.uint32_is_concise_mode.set(SimpleUIUtil.getSimpleUISwitch() ? 1 : 0);
        if (ReadInJoyHelper.V()) {
            reqBody.uint32_kandian_mode.set(3);
        } else {
            reqBody.uint32_kandian_mode.set(1);
        }
        oidb_cmd0x80a.KDEventReportReq kDEventReportReq = new oidb_cmd0x80a.KDEventReportReq();
        if (i3 != -1) {
            kDEventReportReq.event_id.set(i3);
        }
        if (!TextUtils.isEmpty(str)) {
            kDEventReportReq.event_name.set(str);
        }
        if (list != null && !list.isEmpty()) {
            kDEventReportReq.att_list.set(list);
        }
        if (i16 >= 0) {
            kDEventReportReq.version.set(i16);
        }
        reqBody.req_kd_event_report_req.set(kDEventReportReq);
        sendPbReq(c.b(str2, i17, 0, reqBody.toByteArray()));
    }

    private Pair<String, Integer> getCommandFrom(int i3) {
        if (i3 != 8) {
            if (i3 == 9) {
                return new Pair<>("OidbSvc.0xc43", 3139);
            }
            if (i3 == 12 || i3 == 61) {
                return new Pair<>("OidbSvc.0xc44", 3140);
            }
            if (i3 != 23 && i3 != 24) {
                return new Pair<>("OidbSvc.0x80a", 2058);
            }
        }
        return new Pair<>("OidbSvc.0xc42", 3138);
    }

    public void unInitialize() {
    }
}
