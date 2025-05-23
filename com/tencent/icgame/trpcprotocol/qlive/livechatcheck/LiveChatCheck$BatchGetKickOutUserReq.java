package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$BatchGetKickOutUserReq extends MessageMicro<LiveChatCheck$BatchGetKickOutUserReq> {
    public static final int MASTER_TINYID_FIELD_NUMBER = 2;
    public static final int PAGE_NUM_FIELD_NUMBER = 3;
    public static final int QUNATITY_FIELD_NUMBER = 4;
    public static final int ROOMID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"roomid", "master_tinyid", "page_num", "qunatity"}, new Object[]{0L, 0L, 0, 0}, LiveChatCheck$BatchGetKickOutUserReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field master_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field page_num = PBField.initUInt32(0);
    public final PBUInt32Field qunatity = PBField.initUInt32(0);
}
