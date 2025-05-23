package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$DelFeedStuct extends MessageMicro<ilive_feeds_write$DelFeedStuct> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id;
    public final PBEnumField feed_type;
    public final PBBytesField file_id;
    public final PBUInt64Field timestamp;

    static {
        String[] strArr = {"file_id", "feed_id", QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "timestamp"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, strArr, new Object[]{byteStringMicro, byteStringMicro, 1, 0L}, ilive_feeds_write$DelFeedStuct.class);
    }

    public ilive_feeds_write$DelFeedStuct() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.file_id = PBField.initBytes(byteStringMicro);
        this.feed_id = PBField.initBytes(byteStringMicro);
        this.feed_type = PBField.initEnum(1);
        this.timestamp = PBField.initUInt64(0L);
    }
}
