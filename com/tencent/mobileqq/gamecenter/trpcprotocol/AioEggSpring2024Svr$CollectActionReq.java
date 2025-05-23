package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class AioEggSpring2024Svr$CollectActionReq extends MessageMicro<AioEggSpring2024Svr$CollectActionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 66, 72, 82}, new String[]{"scene", "act_id", "egg_id", QCircleSchemeAttr.Detail.KEY_WORD, "proactive", "friend_uin", "group_id", "channel_id", "platform", AppConstants.Preferences.QQ_VERSION}, new Object[]{0, "", 0L, "", Boolean.FALSE, 0L, 0L, "", 0, ""}, AioEggSpring2024Svr$CollectActionReq.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBStringField act_id = PBField.initString("");
    public final PBInt64Field egg_id = PBField.initInt64(0);
    public final PBStringField key_word = PBField.initString("");
    public final PBBoolField proactive = PBField.initBool(false);
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBStringField channel_id = PBField.initString("");
    public final PBEnumField platform = PBField.initEnum(0);
    public final PBStringField qq_version = PBField.initString("");
}
