package com.tencent.icgame.trpc.yes.common;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$ShareArkMsg extends MessageMicro<MessageOuterClass$ShareArkMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"game_id", "card_type", "ark_msg_info"}, new Object[]{0, 0, null}, MessageOuterClass$ShareArkMsg.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt32Field card_type = PBField.initInt32(0);
    public MessageOuterClass$ArkBaseInfo ark_msg_info = new MessageMicro<MessageOuterClass$ArkBaseInfo>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$ArkBaseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"appid", "view", "version", "prompt", PublicAccountMessageUtilImpl.META_NAME}, new Object[]{"", "", "", "", ""}, MessageOuterClass$ArkBaseInfo.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField view = PBField.initString("");
        public final PBStringField version = PBField.initString("");
        public final PBStringField prompt = PBField.initString("");
        public final PBStringField meta = PBField.initString("");
    };
}
