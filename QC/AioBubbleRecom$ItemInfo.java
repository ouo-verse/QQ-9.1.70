package QC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AioBubbleRecom$ItemInfo extends MessageMicro<AioBubbleRecom$ItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 56, 64, 72}, new String[]{"appID", "itemID", "name", VipFunCallConstants.KEY_FEET_TYPE, "itemBgColor", "image", "price", "fontEngine", "isQualified"}, new Object[]{0, 0, "", 0, "", "", 0, 0, Boolean.FALSE}, AioBubbleRecom$ItemInfo.class);
    public final PBUInt32Field appID = PBField.initUInt32(0);
    public final PBUInt32Field itemID = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field feeType = PBField.initUInt32(0);
    public final PBStringField itemBgColor = PBField.initString("");
    public final PBStringField image = PBField.initString("");
    public final PBUInt32Field price = PBField.initUInt32(0);
    public final PBUInt32Field fontEngine = PBField.initUInt32(0);
    public final PBBoolField isQualified = PBField.initBool(false);
}
