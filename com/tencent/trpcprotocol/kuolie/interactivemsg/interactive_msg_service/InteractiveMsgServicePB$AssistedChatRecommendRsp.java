package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$AssistedChatRecommendRsp extends MessageMicro<InteractiveMsgServicePB$AssistedChatRecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 56}, new String[]{"rsp_head", "recommends", "android_small_yellow_face_ids", "ios_small_yellow_face_ids", "recom_trans_info", "guide", "is_end"}, new Object[]{null, null, 0, 0, ByteStringMicro.EMPTY, "", Boolean.FALSE}, InteractiveMsgServicePB$AssistedChatRecommendRsp.class);
    public final PBRepeatField<Integer> android_small_yellow_face_ids;
    public final PBStringField guide;
    public final PBRepeatField<Integer> ios_small_yellow_face_ids;
    public final PBBoolField is_end;
    public final PBBytesField recom_trans_info;
    public InteractiveMsgServicePB$RspHead rsp_head = new InteractiveMsgServicePB$RspHead();
    public final PBRepeatMessageField<InteractiveMsgServicePB$AssistedChatRecommend> recommends = PBField.initRepeatMessage(InteractiveMsgServicePB$AssistedChatRecommend.class);

    public InteractiveMsgServicePB$AssistedChatRecommendRsp() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.android_small_yellow_face_ids = PBField.initRepeat(pBUInt32Field);
        this.ios_small_yellow_face_ids = PBField.initRepeat(pBUInt32Field);
        this.recom_trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
        this.guide = PBField.initString("");
        this.is_end = PBField.initBool(false);
    }
}
