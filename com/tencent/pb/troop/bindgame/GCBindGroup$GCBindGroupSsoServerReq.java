package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GCBindGroup$GCBindGroupSsoServerReq extends MessageMicro<GCBindGroup$GCBindGroupSsoServerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"cmd", "bind_req", "dynamic_req", "member_req"}, new Object[]{"", null, null, null}, GCBindGroup$GCBindGroupSsoServerReq.class);
    public final PBStringField cmd = PBField.initString("");
    public GCBindGroup$QQGroupBind bind_req = new GCBindGroup$QQGroupBind();
    public GCBindGroup$QQGroupCardDynamic dynamic_req = new MessageMicro<GCBindGroup$QQGroupCardDynamic>() { // from class: com.tencent.pb.troop.bindgame.GCBindGroup$QQGroupCardDynamic
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "last_time"}, new Object[]{0L, 0L}, GCBindGroup$QQGroupCardDynamic.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt64Field last_time = PBField.initUInt64(0);
    };
    public GCBindGroup$QQGroupCardMember member_req = new MessageMicro<GCBindGroup$QQGroupCardMember>() { // from class: com.tencent.pb.troop.bindgame.GCBindGroup$QQGroupCardMember
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "uin"}, new Object[]{0L, 0L}, GCBindGroup$QQGroupCardMember.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    };
}
