package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QQGameResFlowControl$URLResourceState extends MessageMicro<QQGameResFlowControl$URLResourceState> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"res_url", "res_state"}, new Object[]{"", 0}, QQGameResFlowControl$URLResourceState.class);
    public final PBStringField res_url = PBField.initString("");
    public final PBEnumField res_state = PBField.initEnum(0);
}
