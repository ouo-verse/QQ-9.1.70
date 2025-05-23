package com.tencent.mobileqq.troop.troopnotification.push.msg_content;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;

/* loaded from: classes35.dex */
public final class MsgContentPB$MsgContent extends MessageMicro<MsgContentPB$MsgContent> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField jump_schema;
    public final PBBytesField summary;
    public final PBBytesField title;

    public MsgContentPB$MsgContent() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.title = PBField.initBytes(byteStringMicro);
        this.summary = PBField.initBytes(byteStringMicro);
        this.jump_schema = PBField.initBytes(byteStringMicro);
    }

    static {
        String[] strArr = {"title", "summary", ChatsRevealApiImpl.KEY_JUMP_SCHEME};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, MsgContentPB$MsgContent.class);
    }
}
