package NS_MINI_APP_MISC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MISC$StTrans4RoomidReq extends MessageMicro<MISC$StTrans4RoomidReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID}, new Object[]{"", ""}, MISC$StTrans4RoomidReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField groupid = PBField.initString("");
}
