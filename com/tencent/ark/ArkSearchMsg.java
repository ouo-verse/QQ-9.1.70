package com.tencent.ark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ArkSearchMsg {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_card_type;
        public final PBBytesField bytes_card_view;
        public final PBBytesField bytes_extra_info;
        public final PBBytesField bytes_msg_id;
        public final PBBytesField bytes_text;
        public final PBUInt32Field uint32_action;
        public final PBUInt32Field uint32_first_report;
        public final PBUInt32Field uint32_flag;
        public final PBUInt32Field uint32_scene;
        public final PBUInt32Field uint32_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 66, 72, 80}, new String[]{"bytes_extra_info", "bytes_msg_id", "uint32_type", "uint32_scene", "uint32_action", "bytes_card_type", "bytes_card_view", "bytes_text", "uint32_flag", "uint32_first_report"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, ReqBody.class);
        }

        public ReqBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_extra_info = PBField.initBytes(byteStringMicro);
            this.bytes_msg_id = PBField.initBytes(byteStringMicro);
            this.uint32_type = PBField.initUInt32(0);
            this.uint32_scene = PBField.initUInt32(0);
            this.uint32_action = PBField.initUInt32(0);
            this.bytes_card_type = PBField.initBytes(byteStringMicro);
            this.bytes_card_view = PBField.initBytes(byteStringMicro);
            this.bytes_text = PBField.initBytes(byteStringMicro);
            this.uint32_flag = PBField.initUInt32(0);
            this.uint32_first_report = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
    }

    ArkSearchMsg() {
    }
}
