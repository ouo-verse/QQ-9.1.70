package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$SingleProfileCardInfo extends MessageMicro<FeedCloudRead$SingleProfileCardInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField card_cover_type = PBField.initEnum(0);
    public final PBBoolField setting_status = PBField.initBool(false);
    public final PBBoolField allow_modify = PBField.initBool(false);
    public final PBStringField tips_word = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"card_cover_type", "setting_status", "allow_modify", "tips_word"}, new Object[]{0, bool, bool, ""}, FeedCloudRead$SingleProfileCardInfo.class);
    }
}
