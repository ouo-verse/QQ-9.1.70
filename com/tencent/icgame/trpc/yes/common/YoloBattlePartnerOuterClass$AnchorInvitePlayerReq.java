package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattlePartnerOuterClass$AnchorInvitePlayerReq extends MessageMicro<YoloBattlePartnerOuterClass$AnchorInvitePlayerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ready_uid"}, new Object[]{0L}, YoloBattlePartnerOuterClass$AnchorInvitePlayerReq.class);
    public final PBUInt64Field ready_uid = PBField.initUInt64(0);
}
