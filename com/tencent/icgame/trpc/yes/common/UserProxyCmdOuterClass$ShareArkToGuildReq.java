package com.tencent.icgame.trpc.yes.common;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$ShareArkToGuildReq extends MessageMicro<UserProxyCmdOuterClass$ShareArkToGuildReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"guild_id", "channel_id", "game_id", PublicAccountMessageUtilImpl.META_NAME}, new Object[]{0L, 0L, 0, ""}, UserProxyCmdOuterClass$ShareArkToGuildReq.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField meta = PBField.initString("");
}
