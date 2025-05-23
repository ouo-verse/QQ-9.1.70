package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes32.dex */
public final class AEPbData$ImageInfo extends MessageMicro<AEPbData$ImageInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<AEPbData$FaceInfo> faceInfos;
    public final PBInt32Field faceNum;
    public final PBBoolField hasFace;
    public final PBBytesField imageMask;
    public final PBBytesField imageRawData;
    public final PBInt32Field imgHeight;
    public final PBInt32Field imgWidth;

    public AEPbData$ImageInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.imageRawData = PBField.initBytes(byteStringMicro);
        this.hasFace = PBField.initBool(false);
        this.faceNum = PBField.initInt32(0);
        this.faceInfos = PBField.initRepeatMessage(AEPbData$FaceInfo.class);
        this.imgWidth = PBField.initInt32(0);
        this.imgHeight = PBField.initInt32(0);
        this.imageMask = PBField.initBytes(byteStringMicro);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 58}, new String[]{"imageRawData", "hasFace", "faceNum", "faceInfos", "imgWidth", "imgHeight", "imageMask"}, new Object[]{byteStringMicro, Boolean.FALSE, 0, null, 0, 0, byteStringMicro}, AEPbData$ImageInfo.class);
    }
}
