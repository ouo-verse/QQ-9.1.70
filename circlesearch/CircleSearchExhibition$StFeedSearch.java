package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StFeedSearch extends MessageMicro<CircleSearchExhibition$StFeedSearch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"feed_id", "uid", "title", "content", "content_id", "type"}, new Object[]{"", "", "", "", "", 0}, CircleSearchExhibition$StFeedSearch.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField content_id = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
}
