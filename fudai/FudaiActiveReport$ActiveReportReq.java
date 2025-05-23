package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FudaiActiveReport$ActiveReportReq extends MessageMicro<FudaiActiveReport$ActiveReportReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public final PBUInt64Field optime = PBField.initUInt64(0);
    public final PBUInt64Field touin = PBField.initUInt64(0);
    public final PBUInt64Field group_uin = PBField.initUInt64(0);
    public final PBStringField banner_id = PBField.initString("");
    public final PBStringField pendant_id = PBField.initString("");
    public final PBStringField vid = PBField.initString("");
    public final PBStringField game_id = PBField.initString("");
    public final PBStringField brand_id = PBField.initString("");
    public final PBStringField card_id = PBField.initString("");
    public final PBStringField fudai_id = PBField.initString("");
    public final PBEnumField award_type = PBField.initEnum(0);
    public final PBUInt32Field cash_value = PBField.initUInt32(0);
    public final PBBoolField entrance_remind = PBField.initBool(false);
    public final PBEnumField fd_status_type = PBField.initEnum(0);
    public final PBEnumField share_source = PBField.initEnum(1);
    public final PBEnumField share_type = PBField.initEnum(1);
    public final PBBoolField follow_brand = PBField.initBool(false);

    static {
        String[] strArr = {"act_id", "optime", "touin", "group_uin", "banner_id", "pendant_id", "vid", "game_id", "brand_id", "card_id", "fudai_id", "award_type", "cash_value", "entrance_remind", "fd_status_type", "share_source", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "follow_brand"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 128, 136, 144}, strArr, new Object[]{0, 0L, 0L, 0L, "", "", "", "", "", "", "", 0, 0, bool, 0, 1, 1, bool}, FudaiActiveReport$ActiveReportReq.class);
    }
}
