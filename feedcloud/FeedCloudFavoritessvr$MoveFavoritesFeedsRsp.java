package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$MoveFavoritesFeedsRsp extends MessageMicro<FeedCloudFavoritessvr$MoveFavoritesFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"src_delta_num", "dst_delta_num", "dst_id"}, new Object[]{0, 0, 0L}, FeedCloudFavoritessvr$MoveFavoritesFeedsRsp.class);
    public final PBInt32Field src_delta_num = PBField.initInt32(0);
    public final PBInt32Field dst_delta_num = PBField.initInt32(0);
    public final PBUInt64Field dst_id = PBField.initUInt64(0);
}
