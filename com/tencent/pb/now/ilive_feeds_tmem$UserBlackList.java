package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$UserBlackList extends MessageMicro<ilive_feeds_tmem$UserBlackList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"act_uin", "black_feeds"}, new Object[]{0L, null}, ilive_feeds_tmem$UserBlackList.class);
    public final PBUInt64Field act_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<ilive_feeds_tmem$RankBlackFeeds> black_feeds = PBField.initRepeatMessage(ilive_feeds_tmem$RankBlackFeeds.class);
}
