package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$FeedsList extends MessageMicro<ilive_feeds_tmem$FeedsList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feedlist"}, new Object[]{null}, ilive_feeds_tmem$FeedsList.class);
    public final PBRepeatMessageField<ilive_feeds_tmem$FeedsListItem> feedlist = PBField.initRepeatMessage(ilive_feeds_tmem$FeedsListItem.class);
}
