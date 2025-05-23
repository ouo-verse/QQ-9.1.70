package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$GetPortalRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$GetSubscriptionRsp extends MessageMicro<CertifiedAccountRead$GetSubscriptionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"room_lst", "bottom", "page_info"}, new Object[]{null, null, ""}, CertifiedAccountRead$GetSubscriptionRsp.class);
    public final PBRepeatMessageField<CertifiedAccountRead$GetPortalRsp.RoomLstItem> room_lst = PBField.initRepeatMessage(CertifiedAccountRead$GetPortalRsp.RoomLstItem.class);
    public Bottom bottom = new Bottom();
    public final PBStringField page_info = PBField.initString("");

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Bottom extends MessageMicro<Bottom> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"desc", "jump_url"}, new Object[]{"", ""}, Bottom.class);
        public final PBStringField desc = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    }
}
