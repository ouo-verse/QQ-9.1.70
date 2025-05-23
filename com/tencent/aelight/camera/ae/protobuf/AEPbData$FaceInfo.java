package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes32.dex */
public final class AEPbData$FaceInfo extends MessageMicro<AEPbData$FaceInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public AEPbData$FacePose face_pose;
    public final PBRepeatField<Float> pos;
    public final PBRepeatField<Float> rc_face;
    public final PBRepeatField<Float> rc_leftEye;
    public final PBRepeatField<Float> rc_mouth;
    public final PBRepeatField<Float> rc_rightEye;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.aelight.camera.ae.protobuf.AEPbData$FacePose] */
    public AEPbData$FaceInfo() {
        PBFloatField pBFloatField = PBFloatField.__repeatHelper__;
        this.pos = PBField.initRepeat(pBFloatField);
        this.rc_face = PBField.initRepeat(pBFloatField);
        this.rc_leftEye = PBField.initRepeat(pBFloatField);
        this.rc_rightEye = PBField.initRepeat(pBFloatField);
        this.rc_mouth = PBField.initRepeat(pBFloatField);
        this.face_pose = new MessageMicro<AEPbData$FacePose>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$FacePose
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBFloatField pitch = PBField.initFloat(0.0f);
            public final PBFloatField yaw = PBField.initFloat(0.0f);
            public final PBFloatField roll = PBField.initFloat(0.0f);

            static {
                Float valueOf = Float.valueOf(0.0f);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 29}, new String[]{"pitch", "yaw", "roll"}, new Object[]{valueOf, valueOf, valueOf}, AEPbData$FacePose.class);
            }
        };
    }

    static {
        String[] strArr = {c.G, "rc_face", "rc_leftEye", "rc_rightEye", "rc_mouth", "face_pose"};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 29, 37, 45, 50}, strArr, new Object[]{valueOf, valueOf, valueOf, valueOf, valueOf, null}, AEPbData$FaceInfo.class);
    }
}
