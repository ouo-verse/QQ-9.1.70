package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$RecommendRsp extends MessageMicro<AssistedChatPB$RecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<Integer> android_small_yellow_face_ids;
    public final PBBytesField binary_data;
    public final PBBytesField ext_data;
    public final PBStringField guide;
    public final PBRepeatField<Integer> ios_small_yellow_face_ids;
    public final PBBoolField is_end;
    public final PBBoolField is_festival_end;
    public final PBBytesField recom_trans_info;
    public AssistedChatPB$RspHead rsp_head = new AssistedChatPB$RspHead();
    public final PBRepeatMessageField<AssistedChatPB$Recommend> recommends = PBField.initRepeatMessage(AssistedChatPB$Recommend.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 56, 64, 74, 82}, new String[]{"rsp_head", "recommends", "android_small_yellow_face_ids", "ios_small_yellow_face_ids", "recom_trans_info", "guide", "is_end", "is_festival_end", "binary_data", "ext_data"}, new Object[]{null, null, 0, 0, byteStringMicro, "", bool, bool, byteStringMicro, byteStringMicro}, AssistedChatPB$RecommendRsp.class);
    }

    public AssistedChatPB$RecommendRsp() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.android_small_yellow_face_ids = PBField.initRepeat(pBUInt32Field);
        this.ios_small_yellow_face_ids = PBField.initRepeat(pBUInt32Field);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.recom_trans_info = PBField.initBytes(byteStringMicro);
        this.guide = PBField.initString("");
        this.is_end = PBField.initBool(false);
        this.is_festival_end = PBField.initBool(false);
        this.binary_data = PBField.initBytes(byteStringMicro);
        this.ext_data = PBField.initBytes(byteStringMicro);
    }
}
