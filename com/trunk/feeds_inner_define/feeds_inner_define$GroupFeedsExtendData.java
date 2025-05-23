package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds_inner_define$GroupFeedsExtendData extends MessageMicro<feeds_inner_define$GroupFeedsExtendData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bytes_reverse", "msg_concern_uin_record_set", "uint32_author_ignore_time"}, new Object[]{ByteStringMicro.EMPTY, null, 0}, feeds_inner_define$GroupFeedsExtendData.class);
    public final PBBytesField bytes_reverse = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_inner_define$ConcernUinRecordSet msg_concern_uin_record_set = new MessageMicro<feeds_inner_define$ConcernUinRecordSet>() { // from class: com.trunk.feeds_inner_define.feeds_inner_define$ConcernUinRecordSet
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_concern_uin_record"}, new Object[]{null}, feeds_inner_define$ConcernUinRecordSet.class);
        public final PBRepeatMessageField<feeds_inner_define$ConcernUinRecord> rpt_concern_uin_record = PBField.initRepeatMessage(feeds_inner_define$ConcernUinRecord.class);
    };
    public final PBUInt32Field uint32_author_ignore_time = PBField.initUInt32(0);
}
