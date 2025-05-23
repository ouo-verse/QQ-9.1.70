package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$TimeLineItem extends MessageMicro<ilive_feeds_tmem$TimeLineItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{AlbumCacheData.CREATE_TIME, "id", QCircleFolderFunnelCollect.EXTRA_FEED_TYPE}, new Object[]{0L, "", 1}, ilive_feeds_tmem$TimeLineItem.class);
    public final PBUInt64Field create_time = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342147id = PBField.initString("");
    public final PBEnumField feed_type = PBField.initEnum(1);
}
