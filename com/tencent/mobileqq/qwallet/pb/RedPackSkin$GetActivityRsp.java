package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$GetActivityRsp extends MessageMicro<RedPackSkin$GetActivityRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 64, 74}, new String[]{"id", "tag", "content", "reddot_pic", "action", "jump_url", "skins", "select_recommend_id", "tag2"}, new Object[]{0, "", "", "", 0, "", null, 0, ""}, RedPackSkin$GetActivityRsp.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f278702id = PBField.initInt32(0);
    public final PBStringField tag = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField reddot_pic = PBField.initString("");
    public final PBEnumField action = PBField.initEnum(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBRepeatMessageField<RedPackSkin$RecommendSkin> skins = PBField.initRepeatMessage(RedPackSkin$RecommendSkin.class);
    public final PBInt32Field select_recommend_id = PBField.initInt32(0);
    public final PBStringField tag2 = PBField.initString("");
}
