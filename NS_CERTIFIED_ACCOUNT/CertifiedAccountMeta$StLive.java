package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StLive extends MessageMicro<CertifiedAccountMeta$StLive> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 64, 74, 80, 90, 98, 106}, new String[]{"liveUin", "liveState", "anchorName", "anchorIcon", "roomId", "roomTitle", "roomIcon", "viewer", "marketStatus", "totalGoods", "goodsInfo", "rtmpURL", "typeIcon"}, new Object[]{0L, 0, "", "", 0L, "", null, 0L, "", 0, null, "", ""}, CertifiedAccountMeta$StLive.class);
    public final PBUInt64Field liveUin = PBField.initUInt64(0);
    public final PBInt32Field liveState = PBField.initInt32(0);
    public final PBStringField anchorName = PBField.initString("");
    public final PBStringField anchorIcon = PBField.initString("");
    public final PBUInt64Field roomId = PBField.initUInt64(0);
    public final PBStringField roomTitle = PBField.initString("");
    public final PBRepeatMessageField<RoomIcon> roomIcon = PBField.initRepeatMessage(RoomIcon.class);
    public final PBUInt64Field viewer = PBField.initUInt64(0);
    public final PBStringField marketStatus = PBField.initString("");
    public final PBInt32Field totalGoods = PBField.initInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StLiveGoods> goodsInfo = PBField.initRepeatMessage(CertifiedAccountMeta$StLiveGoods.class);
    public final PBStringField rtmpURL = PBField.initString("");
    public final PBStringField typeIcon = PBField.initString("");

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class RoomIcon extends MessageMicro<RoomIcon> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"size", "url"}, new Object[]{"", ""}, RoomIcon.class);
        public final PBStringField size = PBField.initString("");
        public final PBStringField url = PBField.initString("");
    }
}
