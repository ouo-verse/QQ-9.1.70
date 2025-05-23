package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$IsReachReportLimitReq extends MessageMicro<LiveChatCheck$IsReachReportLimitReq> {
    public static final int USER_UID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"user_uid"}, new Object[]{0L}, LiveChatCheck$IsReachReportLimitReq.class);
    public final PBUInt64Field user_uid = PBField.initUInt64(0);
}
