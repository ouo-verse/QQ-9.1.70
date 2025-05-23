package circlesearch;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$OneBoxFeedItem extends MessageMicro<CircleSearchExhibition$OneBoxFeedItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"feed_id", "poster_id", AlbumCacheData.CREATE_TIME}, new Object[]{"", "", 0L}, CircleSearchExhibition$OneBoxFeedItem.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField poster_id = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
}
