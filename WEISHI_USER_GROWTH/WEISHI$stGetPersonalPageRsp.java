package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class WEISHI$stGetPersonalPageRsp extends MessageMicro<WEISHI$stGetPersonalPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 66, 82, 90}, new String[]{"feed_num", "feeds", "attach_info", "personid"}, new Object[]{0, null, "", ""}, WEISHI$stGetPersonalPageRsp.class);
    public final PBInt32Field feed_num = PBField.initInt32(0);
    public final PBRepeatMessageField<WEISHI$stMetaFeed> feeds = PBField.initRepeatMessage(WEISHI$stMetaFeed.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField personid = PBField.initString("");
}
