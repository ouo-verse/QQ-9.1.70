package com.tencent.mobileqq.colornote.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.handler.b;
import ea1.c;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private short f201397d;

    public ColorNoteHandler(AppInterface appInterface) {
        super(appInterface);
        this.f201397d = (short) -23193;
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        int i3 = 0;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            b.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, false);
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            if (mergeFrom != null && mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                try {
                    oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    b.c().onReceive(toServiceMsg, fromServiceMsg, obj, oidb_0x5eb_rspbody, true);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    b.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, true);
                    return;
                }
            }
            if (mergeFrom != null) {
                i3 = mergeFrom.uint32_result.get();
            }
            if (mergeFrom != null) {
                str = mergeFrom.str_error_msg.get();
            } else {
                str = null;
            }
            QLog.d("ColorNoteHandler", 1, "handleReq0x5ebForColdStart result=" + i3 + " errMsg=" + str);
            b.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, true);
        } catch (InvalidProtocolBufferMicroException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteHandler", 2, String.format("handleReq0x5eb  e=%s", e17.toString()));
            }
            b.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, true);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            } catch (Exception e16) {
                e = e16;
                z17 = z16;
            }
            if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                long j3 = i3;
                if (i3 < 0) {
                    j3 += 4294967296L;
                }
                if (this.appRuntime.getCurrentAccountUin().equals(String.valueOf(j3))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteHandler", 2, "handleReqSetColorNoteRecentSwitch: set switch success");
                    }
                } else {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("ColorNoteHandler", 2, "handleReqSetColorNoteRecentSwitch: set switch failed");
                        }
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("ColorNoteHandler", 1, "handleReqSetColorNoteRecentSwitch: oidb_sso errors", e);
                        z16 = z17;
                        notifyUI(2, z16, null);
                    }
                    z16 = z17;
                }
            }
            z17 = z16;
            z16 = z17;
        }
        notifyUI(2, z16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("ColorNoteHandler", 1, "pkg.mergeFrom error: ", e16);
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    try {
                        oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    } catch (InvalidProtocolBufferMicroException e17) {
                        QLog.e("ColorNoteHandler", 1, "response.mergeFrom error: ", e17);
                    }
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_flag_color_note_recent_switch.get() == 1) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        z17 = z26;
                        z16 = true;
                        QLog.i("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch isSuccess? " + z16 + ", turnOn? " + z17);
                        if (z16) {
                            c loadConfig = ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).loadConfig();
                            if (loadConfig != null && loadConfig.a()) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
                            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                            if (z18 && !z17) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            iColorNoteController.setRecentlyViewedSwitch(runtime, z19);
                        }
                        notifyUI(1, z16, new Object[]{Boolean.valueOf(z17)});
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch: response.rpt_msg_uin_data.size() < 0");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch: pkg.bytes_bodybuffer is null");
                }
            } else if (QLog.isColorLevel()) {
                if (oidb_sso_oidbssopkg.uint32_result.has()) {
                    QLog.d("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch: pkg.uint32_result error code: " + oidb_sso_oidbssopkg.uint32_result.get());
                } else {
                    QLog.d("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch: pkg.uint32_result do not have");
                }
            }
            z16 = false;
        }
        z17 = true;
        QLog.i("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch isSuccess? " + z16 + ", turnOn? " + z17);
        if (z16) {
        }
        notifyUI(1, z16, new Object[]{Boolean.valueOf(z17)});
    }

    public void G2() {
        long parseLong;
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        try {
            parseLong = Long.parseLong(currentAccountUin);
            oidb_0x5eb_reqbody = b.c().get0x5ebReqBody(new Bundle(), oidb_0x5eb_reqbody);
        } catch (Exception e16) {
            QLog.e("ColorNoteHandler", 1, "reqGetColorNoteRecentSwitch: parseLongError: ", e16);
        }
        if (oidb_0x5eb_reqbody == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteHandler", 1, "null == reqBody");
            }
        } else {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(parseLong));
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_for_cold_start", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("uin", currentAccountUin);
            makeOIDBPkg.extraData.putAll(b.c().getRequestExtraData());
            sendPbReq(makeOIDBPkg);
        }
    }

    public void H2() {
        QLog.i("ColorNoteHandler", 2, "reqGetColorNoteRecentSwitch isMergeReq = false");
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(currentAccountUin)));
        } catch (Exception e16) {
            QLog.e("ColorNoteHandler", 1, "reqGetColorNoteRecentSwitch: parseLongError: ", e16);
        }
        oidb_0x5eb_reqbody.uint32_flag_color_note_recent_switch.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_cn_switch", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("uin", currentAccountUin);
        makeOIDBPkg.extraData.putBoolean("uint32_flag_color_note_recent_switch", true);
        sendPbReq(makeOIDBPkg);
    }

    public void I2(boolean z16) {
        short s16;
        boolean z17 = !z16;
        try {
            long parseLong = Long.parseLong(this.appRuntime.getCurrentAccountUin());
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            if (z17) {
                s16 = 1;
            } else {
                s16 = 0;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(this.f201397d).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x4ff_cn_switch");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            sendPbReq(createToServiceMsg);
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteHandler", 2, "reqSetColorNoteRecentSwitch: request sent, switch: " + z17);
            }
        } catch (Exception e16) {
            QLog.e("ColorNoteHandler", 1, "reqSetColorNoteRecentSwitch error: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ea1.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (TextUtils.equals("OidbSvc.0x5eb_cn_switch", fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteHandler", 2, "onReceive: receive CMD_REQ_GET_SWITCH message");
            }
            E2(toServiceMsg, fromServiceMsg, obj);
        } else if (TextUtils.equals("OidbSvc.0x4ff_cn_switch", fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteHandler", 2, "onReceive: receive CMD_REQ_SET_SWITCH message");
            }
            F2(toServiceMsg, fromServiceMsg, obj);
        } else if (TextUtils.equals("OidbSvc.0x5eb_for_cold_start", fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteHandler", 2, "onReceive: receive CMD_REQ_SET_SWITCH message");
            }
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
