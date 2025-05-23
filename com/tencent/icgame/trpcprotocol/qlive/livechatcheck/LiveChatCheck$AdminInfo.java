package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$AdminInfo extends MessageMicro<LiveChatCheck$AdminInfo> {
    public static final int ADMIN_UID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"admin_uid"}, new Object[]{0L}, LiveChatCheck$AdminInfo.class);
    public final PBUInt64Field admin_uid = PBField.initUInt64(0);
}
