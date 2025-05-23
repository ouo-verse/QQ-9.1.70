package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$PushBrokeToast extends MessageMicro<FeedCloudMeta$PushBrokeToast> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"should_toast", "title", "content", "give_rocket_num", "give_no", "give_tot"}, new Object[]{Boolean.FALSE, "", "", 0, 0, 0}, FeedCloudMeta$PushBrokeToast.class);
    public final PBBoolField should_toast = PBField.initBool(false);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field give_rocket_num = PBField.initUInt32(0);
    public final PBUInt32Field give_no = PBField.initUInt32(0);
    public final PBUInt32Field give_tot = PBField.initUInt32(0);
}
