package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StExhUser extends MessageMicro<CircleSearchExhibition$StExhUser> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f30976id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBBoolField isVip = PBField.initBool(false);
    public final PBInt64Field fans_num = PBField.initInt64(0);
    public final PBInt64Field feeds_num = PBField.initInt64(0);
    public final PBBoolField isFollow = PBField.initBool(false);
    public final PBBoolField isBigV = PBField.initBool(false);
    public final PBBoolField isQQFriend = PBField.initBool(false);
    public final PBBoolField isBlueVip = PBField.initBool(false);
    public final PBUInt32Field relationType = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField remark_name = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 114}, new String[]{"id", "name", "desc", "isVip", "fans_num", "feeds_num", "isFollow", "isBigV", "isQQFriend", "isBlueVip", "relationType", "icon", "feeds", "remark_name"}, new Object[]{"", "", "", bool, 0L, 0L, bool, bool, bool, bool, 0, "", null, ""}, CircleSearchExhibition$StExhUser.class);
    }
}
