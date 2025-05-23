package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$RankBlackFeeds extends MessageMicro<ilive_feeds_tmem$RankBlackFeeds> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"insert_time", "feeds_id"}, new Object[]{0, ByteStringMicro.EMPTY}, ilive_feeds_tmem$RankBlackFeeds.class);
    public final PBUInt32Field insert_time = PBField.initUInt32(0);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
