package com.tencent.trpcprotocol.qqva.ai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DrawCards$GetFeedsEntranceRsp extends MessageMicro<DrawCards$GetFeedsEntranceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{ILaunchTroopSysMsgUIUtilApi.KEY_HAS_RED, "entrance_text", "cards", "robot_uin", "reddot_attach"}, new Object[]{Boolean.FALSE, "", null, "", ""}, DrawCards$GetFeedsEntranceRsp.class);
    public final PBBoolField has_red = PBField.initBool(false);
    public final PBStringField entrance_text = PBField.initString("");
    public final PBRepeatMessageField<DrawCards$Card> cards = PBField.initRepeatMessage(DrawCards$Card.class);
    public final PBStringField robot_uin = PBField.initString("");
    public final PBStringField reddot_attach = PBField.initString("");
}
