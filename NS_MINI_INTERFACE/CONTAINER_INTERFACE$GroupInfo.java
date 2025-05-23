package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$GroupInfo extends MessageMicro<CONTAINER_INTERFACE$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{VipFunCallConstants.KEY_GROUP, "version", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS}, new Object[]{"", "", 0}, CONTAINER_INTERFACE$GroupInfo.class);
    public final PBStringField group = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBInt32Field compress = PBField.initInt32(0);
}
