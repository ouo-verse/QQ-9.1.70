package msf.msgsvc;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* loaded from: classes28.dex */
public final class msg_svc$PbDeleteMsgReq extends MessageMicro<msg_svc$PbDeleteMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msgItems"}, new Object[]{null}, msg_svc$PbDeleteMsgReq.class);
    public final PBRepeatMessageField<MsgItem> msgItems = PBField.initRepeatMessage(MsgItem.class);

    /* loaded from: classes28.dex */
    public static final class MsgItem extends MessageMicro<MsgItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 58}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_seq", "msg_uid", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{0L, 0L, 0, 0, 0L, ByteStringMicro.EMPTY}, MsgItem.class);
        public final PBUInt64Field from_uin = PBField.initUInt64(0);
        public final PBUInt64Field to_uin = PBField.initUInt64(0);
        public final PBUInt32Field msg_type = PBField.initUInt32(0);
        public final PBUInt32Field msg_seq = PBField.initUInt32(0);
        public final PBUInt64Field msg_uid = PBField.initUInt64(0);
        public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
