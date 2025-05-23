package com.tencent.pb.now;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_source$CollectFeedsDataReq extends MessageMicro<ilive_feeds_source$CollectFeedsDataReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_source = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> feeds_topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBEnumField client_type = PBField.initEnum(1);

    static {
        String[] strArr = {"feeds_id", "feeds_source", "feeds_topic", AudienceReportConst.CLIENT_TYPE};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, strArr, new Object[]{byteStringMicro, 1, byteStringMicro, 1}, ilive_feeds_source$CollectFeedsDataReq.class);
    }
}
