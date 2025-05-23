package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.EmotionConstants;

/* loaded from: classes16.dex */
public final class RedPackSkin$GetRecommendSkinsRsp extends MessageMicro<RedPackSkin$GetRecommendSkinsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 58}, new String[]{"skins", EmotionConstants.DISPLAY_TYPE, "jump_type", "skins_page_reddot", "promotions", CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{null, 0, 0, null, null, 0, ""}, RedPackSkin$GetRecommendSkinsRsp.class);
    public final PBRepeatMessageField<RedPackSkin$RecommendSkin> skins = PBField.initRepeatMessage(RedPackSkin$RecommendSkin.class);
    public final PBInt32Field display_type = PBField.initInt32(0);
    public final PBEnumField jump_type = PBField.initEnum(0);
    public RedPackSkin$RedDot skins_page_reddot = new RedPackSkin$RedDot();
    public final PBRepeatMessageField<RedPackSkin$Promotion> promotions = PBField.initRepeatMessage(RedPackSkin$Promotion.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
