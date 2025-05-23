package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$RoomInfoData extends MessageMicro<FeedCloudMeta$RoomInfoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 64, 74, 80}, new String[]{"roomId", "roomTitle", "rtmpUrl", "topic", "roomState", "roomType", "coverUrl", "source", "flvUrl", "isUseFlvUrl"}, new Object[]{0L, "", "", "", 0, 0, "", 0L, "", Boolean.FALSE}, FeedCloudMeta$RoomInfoData.class);
    public final PBUInt64Field roomId = PBField.initUInt64(0);
    public final PBStringField roomTitle = PBField.initString("");
    public final PBStringField rtmpUrl = PBField.initString("");
    public final PBStringField topic = PBField.initString("");
    public final PBUInt32Field roomState = PBField.initUInt32(0);
    public final PBUInt32Field roomType = PBField.initUInt32(0);
    public final PBStringField coverUrl = PBField.initString("");
    public final PBUInt64Field source = PBField.initUInt64(0);
    public final PBStringField flvUrl = PBField.initString("");
    public final PBBoolField isUseFlvUrl = PBField.initBool(false);
}
