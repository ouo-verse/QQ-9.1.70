package com.tencent.msf.service.protocol.pb;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msf.service.protocol.pb.SSOReserveField;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SSOLoginMerge {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class BusiBuffData extends MessageMicro<BusiBuffData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"BusiBuffVec", "MaxRespSizeHint"}, new Object[]{null, 0}, BusiBuffData.class);
        public final PBRepeatMessageField<BusiBuffItem> BusiBuffVec = PBField.initRepeatMessage(BusiBuffItem.class);
        public final PBUInt32Field MaxRespSizeHint = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class BusiBuffItem extends MessageMicro<BusiBuffItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 58, 64}, new String[]{"SeqNo", "ServiceCmd", "BusiBuffLen", "BusiBuff", "NeedResp", "trpc_rsp", "trans_info", RemoteMessageConst.MSGTYPE}, new Object[]{0, "", 0, ByteStringMicro.EMPTY, Boolean.FALSE, null, null, 0}, BusiBuffItem.class);
        public final PBUInt32Field SeqNo = PBField.initUInt32(0);
        public final PBStringField ServiceCmd = PBField.initString("");
        public final PBUInt32Field BusiBuffLen = PBField.initUInt32(0);
        public final PBBytesField BusiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField NeedResp = PBField.initBool(false);
        public SSOReserveField.SsoTrpcResponse trpc_rsp = new SSOReserveField.SsoTrpcResponse();
        public final PBRepeatMessageField<SSOReserveField.SsoMapEntry> trans_info = PBField.initRepeatMessage(SSOReserveField.SsoMapEntry.class);
        public final PBUInt32Field message_type = PBField.initUInt32(0);
    }

    SSOLoginMerge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
