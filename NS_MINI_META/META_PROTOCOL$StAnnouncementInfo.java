package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StAnnouncementInfo extends MessageMicro<META_PROTOCOL$StAnnouncementInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"announceId", "announceTime", "announceTitle", FunctionConfigManagerImpl.CONFIG_CONTENT_URL}, new Object[]{"", 0, "", ""}, META_PROTOCOL$StAnnouncementInfo.class);
    public final PBStringField announceId = PBField.initString("");
    public final PBUInt32Field announceTime = PBField.initUInt32(0);
    public final PBStringField announceTitle = PBField.initString("");
    public final PBStringField contentUrl = PBField.initString("");
}
