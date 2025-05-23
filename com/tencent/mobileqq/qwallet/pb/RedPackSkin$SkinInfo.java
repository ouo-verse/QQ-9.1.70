package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.TextNode;

/* loaded from: classes16.dex */
public final class RedPackSkin$SkinInfo extends MessageMicro<RedPackSkin$SkinInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field skin_id = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public RedPackSkin$Merchant merchant = new RedPackSkin$Merchant();
    public RedPackSkin$Activity activity = new RedPackSkin$Activity();
    public final PBStringField default_skin_url = PBField.initString("");
    public final PBStringField aio_res_url = PBField.initString("");
    public final PBStringField pop_res_url = PBField.initString("");
    public final PBRepeatMessageField<RedPackSkin$Story> stories = PBField.initRepeatMessage(RedPackSkin$Story.class);
    public RedPackSkin$Tail tail = new RedPackSkin$Tail();
    public final PBInt32Field price = PBField.initInt32(0);
    public final PBInt32Field iap_price = PBField.initInt32(0);
    public final PBStringField outer_skin_id = PBField.initString("");
    public final PBEnumField skin_from = PBField.initEnum(0);
    public final PBStringField pop_open_url = PBField.initString("");
    public final PBStringField pop_broken_url = PBField.initString("");
    public final PBStringField badge_url = PBField.initString("");
    public final PBStringField expire_date_prompt = PBField.initString("");
    public final PBRepeatField<String> labels = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt64Field expire_time = PBField.initInt64(0);
    public final PBBoolField allow_share = PBField.initBool(false);
    public final PBBoolField disabled = PBField.initBool(false);
    public final PBStringField disabled_tip = PBField.initString("");
    public final PBStringField make_res_url = PBField.initString("");

    static {
        String[] strArr = {"skin_id", "type", "title", "merchant", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "default_skin_url", "aio_res_url", "pop_res_url", "stories", TextNode.MODE_TAIL, "price", "iap_price", "outer_skin_id", "skin_from", "pop_open_url", "pop_broken_url", "badge_url", "expire_date_prompt", "labels", VasQQSettingMeImpl.EXPIRE_TIME, "allow_share", "disabled", "disabled_tip", "make_res_url"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 66, 74, 82, 90, 98, 104, 112, 122, 128, 138, 146, 154, 162, 170, 176, 184, 192, 202, 210}, strArr, new Object[]{0, 0, "", null, null, "", "", "", null, null, 0, 0, "", 0, "", "", "", "", "", 0L, bool, bool, "", ""}, RedPackSkin$SkinInfo.class);
    }
}
