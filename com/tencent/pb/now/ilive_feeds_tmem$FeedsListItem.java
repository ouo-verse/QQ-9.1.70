package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$FeedsListItem extends MessageMicro<ilive_feeds_tmem$FeedsListItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"feed_id", AlbumCacheData.CREATE_TIME, "feed_status"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, ilive_feeds_tmem$FeedsListItem.class);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBUInt32Field feed_status = PBField.initUInt32(0);
}
