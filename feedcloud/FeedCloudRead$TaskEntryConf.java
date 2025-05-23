package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$TaskEntryConf extends MessageMicro<FeedCloudRead$TaskEntryConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"task_name", "task_icon", "jump_url", "red_dot_flag"}, new Object[]{"", "", "", 0}, FeedCloudRead$TaskEntryConf.class);
    public final PBStringField task_name = PBField.initString("");
    public final PBStringField task_icon = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBInt32Field red_dot_flag = PBField.initInt32(0);
}
