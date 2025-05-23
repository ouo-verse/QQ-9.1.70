package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes28.dex */
public final class msg_svc$PbC2CReadedReportReq extends MessageMicro<msg_svc$PbC2CReadedReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sync_cookie", "pair_info"}, new Object[]{ByteStringMicro.EMPTY, null}, msg_svc$PbC2CReadedReportReq.class);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<UinPairReadInfo> pair_info = PBField.initRepeatMessage(UinPairReadInfo.class);

    /* loaded from: classes28.dex */
    public static final class UinPairReadInfo extends MessageMicro<UinPairReadInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 72}, new String[]{ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "last_read_time", "crm_sig", "peer_type", "chat_type", "cpid", "aio_type", "uint64_to_tiny_id"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 1, 0, 0L, 0, 0L}, UinPairReadInfo.class);
        public final PBUInt64Field peer_uin = PBField.initUInt64(0);
        public final PBUInt32Field last_read_time = PBField.initUInt32(0);
        public final PBBytesField crm_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField peer_type = PBField.initEnum(1);
        public final PBUInt32Field chat_type = PBField.initUInt32(0);
        public final PBUInt64Field cpid = PBField.initUInt64(0);
        public final PBUInt32Field aio_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_to_tiny_id = PBField.initUInt64(0);
    }
}
