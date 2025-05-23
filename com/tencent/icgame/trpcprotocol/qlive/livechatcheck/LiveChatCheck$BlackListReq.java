package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$BlackListReq extends MessageMicro<LiveChatCheck$BlackListReq> {
    public static final int QUERY_TYPE_FIELD_NUMBER = 2;
    public static final int ROOMID_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "query_type", "roomid"}, new Object[]{0L, 1, 0}, LiveChatCheck$BlackListReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField query_type = PBField.initEnum(1);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
}
