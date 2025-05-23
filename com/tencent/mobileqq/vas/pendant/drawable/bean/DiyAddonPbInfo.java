package com.tencent.mobileqq.vas.pendant.drawable.bean;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyAddonUser;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes20.dex */
public final class DiyAddonPbInfo {

    /* loaded from: classes20.dex */
    public static final class AddonGetDiyInfoReq extends MessageMicro<AddonGetDiyInfoReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, AddonGetDiyInfoReq.class);
        public final PBRepeatField<Long> uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }

    /* loaded from: classes20.dex */
    public static final class AddonGetDiyInfoRsp extends MessageMicro<AddonGetDiyInfoRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"userdiyinfo"}, new Object[]{null}, AddonGetDiyInfoRsp.class);
        public final PBRepeatMessageField<DiyAddonUser.UserDiyInfo> userdiyinfo = PBField.initRepeatMessage(DiyAddonUser.UserDiyInfo.class);
    }

    /* loaded from: classes20.dex */
    public static final class AddonReqComm extends MessageMicro<AddonReqComm> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, AddonReqComm.class);
        public final PBInt64Field platform = PBField.initInt64(0);
        public final PBStringField osver = PBField.initString("");
        public final PBStringField mqqver = PBField.initString("");
    }

    /* loaded from: classes20.dex */
    public static final class AddonRspComm extends MessageMicro<AddonRspComm> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AddonRspComm.class);
    }

    /* loaded from: classes20.dex */
    public static final class ReadAddonReq extends MessageMicro<ReadAddonReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"cmd", "packetseq", "comm", "reqcmd0x01"}, new Object[]{0, 0L, null, null}, ReadAddonReq.class);
        public final PBUInt32Field cmd = PBField.initUInt32(0);
        public final PBUInt64Field packetseq = PBField.initUInt64(0);
        public AddonReqComm comm = new AddonReqComm();
        public AddonGetDiyInfoReq reqcmd0x01 = new AddonGetDiyInfoReq();
    }

    /* loaded from: classes20.dex */
    public static final class ReadAddonRsp extends MessageMicro<ReadAddonRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "cmd", "packetseq", "comm", "rspcmd0x01"}, new Object[]{0L, "", 0, 0L, null, null}, ReadAddonRsp.class);
        public final PBInt64Field ret = PBField.initInt64(0);
        public final PBStringField errmsg = PBField.initString("");
        public final PBUInt32Field cmd = PBField.initUInt32(0);
        public final PBUInt64Field packetseq = PBField.initUInt64(0);
        public AddonRspComm comm = new AddonRspComm();
        public AddonGetDiyInfoRsp rspcmd0x01 = new AddonGetDiyInfoRsp();
    }

    DiyAddonPbInfo() {
    }
}
