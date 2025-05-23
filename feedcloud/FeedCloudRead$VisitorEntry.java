package feedcloud;

import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$VisitorEntry extends MessageMicro<FeedCloudRead$VisitorEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 37}, new String[]{"name", MiniAppPlugin.ATTR_PAGE_TYPE, "value", "percent"}, new Object[]{"", 0, 0L, Float.valueOf(0.0f)}, FeedCloudRead$VisitorEntry.class);
    public final PBStringField name = PBField.initString("");
    public final PBEnumField page_type = PBField.initEnum(0);
    public final PBUInt64Field value = PBField.initUInt64(0);
    public final PBFloatField percent = PBField.initFloat(0.0f);
}
