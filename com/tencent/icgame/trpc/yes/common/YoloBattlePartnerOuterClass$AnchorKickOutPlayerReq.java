package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattlePartnerOuterClass$AnchorKickOutPlayerReq extends MessageMicro<YoloBattlePartnerOuterClass$AnchorKickOutPlayerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"kickout_uid"}, new Object[]{0L}, YoloBattlePartnerOuterClass$AnchorKickOutPlayerReq.class);
    public final PBUInt64Field kickout_uid = PBField.initUInt64(0);
}
