package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$stTagItem extends MessageMicro<CircleSearchExhibition$stTagItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"tag_name", "feeds", "feeds_num"}, new Object[]{"", null, 0}, CircleSearchExhibition$stTagItem.class);
    public final PBStringField tag_name = PBField.initString("");
    public final PBRepeatMessageField<CircleSearchExhibition$stFeedItem> feeds = PBField.initRepeatMessage(CircleSearchExhibition$stFeedItem.class);
    public final PBInt32Field feeds_num = PBField.initInt32(0);
}
