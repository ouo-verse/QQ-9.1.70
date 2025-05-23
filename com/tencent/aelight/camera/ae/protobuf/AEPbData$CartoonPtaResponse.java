package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes32.dex */
public final class AEPbData$CartoonPtaResponse extends MessageMicro<AEPbData$CartoonPtaResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"code", "msg", "deltaHSV", "skeleton", "dressList", "blendshape", "faceAttr", "debugInfo"}, new Object[]{0, "", null, null, null, null, null, null}, AEPbData$CartoonPtaResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f65663msg = PBField.initString("");
    public final PBRepeatMessageField<AEPbData$ColorItem> deltaHSV = PBField.initRepeatMessage(AEPbData$ColorItem.class);
    public final PBRepeatMessageField<AEPbData$SkeletonItem> skeleton = PBField.initRepeatMessage(AEPbData$SkeletonItem.class);
    public final PBRepeatMessageField<AEPbData$DressItem> dressList = PBField.initRepeatMessage(AEPbData$DressItem.class);
    public final PBRepeatMessageField<AEPbData$BlendItem> blendshape = PBField.initRepeatMessage(AEPbData$BlendItem.class);
    public AEPbData$FaceAttr faceAttr = new MessageMicro<AEPbData$FaceAttr>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$FaceAttr
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"gender", "mole_center", "roleID"}, new Object[]{0, null, 0}, AEPbData$FaceAttr.class);
        public final PBEnumField gender = PBField.initEnum(0);
        public AEPbData$Point2f mole_center = new MessageMicro<AEPbData$Point2f>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$Point2f
            static final MessageMicro.FieldMap __fieldMap__;

            /* renamed from: x, reason: collision with root package name */
            public final PBFloatField f65666x = PBField.initFloat(0.0f);

            /* renamed from: y, reason: collision with root package name */
            public final PBFloatField f65667y = PBField.initFloat(0.0f);

            static {
                String[] strArr = {HippyTKDListViewAdapter.X, "y"};
                Float valueOf = Float.valueOf(0.0f);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21}, strArr, new Object[]{valueOf, valueOf}, AEPbData$Point2f.class);
            }
        };
        public final PBInt32Field roleID = PBField.initInt32(0);
    };
    public AEPbData$DebugInfo debugInfo = new MessageMicro<AEPbData$DebugInfo>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"hair", "glasses", "brow", "ear", "eye", "mesh", "texture"}, new Object[]{null, null, null, null, null, null, null}, AEPbData$DebugInfo.class);
        public AEPbData$DebugHairItem hair = new MessageMicro<AEPbData$DebugHairItem>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugHairItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"hair_style", "hair_length", "hair_shape", "hair_affinestyle", "head_road"}, new Object[]{0, 0, 0, 0, 0}, AEPbData$DebugHairItem.class);
            public final PBInt32Field hair_style = PBField.initInt32(0);
            public final PBInt32Field hair_length = PBField.initInt32(0);
            public final PBInt32Field hair_shape = PBField.initInt32(0);
            public final PBInt32Field hair_affinestyle = PBField.initInt32(0);
            public final PBInt32Field head_road = PBField.initInt32(0);
        };
        public AEPbData$DebugGlassesItem glasses = new MessageMicro<AEPbData$DebugGlassesItem>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugGlassesItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"glasses_shape", "glasses_size", "glasses_colordiff", "glasses_slide", "glasses_type"}, new Object[]{0, 0, 0, 0, 0}, AEPbData$DebugGlassesItem.class);
            public final PBInt32Field glasses_shape = PBField.initInt32(0);
            public final PBInt32Field glasses_size = PBField.initInt32(0);
            public final PBInt32Field glasses_colordiff = PBField.initInt32(0);
            public final PBInt32Field glasses_slide = PBField.initInt32(0);
            public final PBInt32Field glasses_type = PBField.initInt32(0);
        };
        public AEPbData$DebugBrowItem brow = new MessageMicro<AEPbData$DebugBrowItem>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugBrowItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"brow_intensity", "brow_length", "brow_curvature", "brow_shape", "brow_arc_left", "brow_arcr_right"}, new Object[]{0, 0, 0, 0, 0, 0}, AEPbData$DebugBrowItem.class);
            public final PBInt32Field brow_intensity = PBField.initInt32(0);
            public final PBInt32Field brow_length = PBField.initInt32(0);
            public final PBInt32Field brow_curvature = PBField.initInt32(0);
            public final PBInt32Field brow_shape = PBField.initInt32(0);
            public final PBInt32Field brow_arc_left = PBField.initInt32(0);
            public final PBInt32Field brow_arcr_right = PBField.initInt32(0);
        };
        public AEPbData$DebugEarItem ear = new MessageMicro<AEPbData$DebugEarItem>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugEarItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ear_shape"}, new Object[]{0}, AEPbData$DebugEarItem.class);
            public final PBInt32Field ear_shape = PBField.initInt32(0);
        };
        public AEPbData$DebugEyeItem eye = new MessageMicro<AEPbData$DebugEyeItem>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugEyeItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"eyelids_left", "eyelids_right", "eyelids_weight", "eyelids_leftpos", "eyelids_rightpos"}, new Object[]{0, 0, 0, 0, 0}, AEPbData$DebugEyeItem.class);
            public final PBInt32Field eyelids_left = PBField.initInt32(0);
            public final PBInt32Field eyelids_right = PBField.initInt32(0);
            public final PBInt32Field eyelids_weight = PBField.initInt32(0);
            public final PBInt32Field eyelids_leftpos = PBField.initInt32(0);
            public final PBInt32Field eyelids_rightpos = PBField.initInt32(0);
        };
        public AEPbData$DebugMesh mesh = new MessageMicro<AEPbData$DebugMesh>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugMesh
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"mesh_points"}, new Object[]{null}, AEPbData$DebugMesh.class);
            public final PBRepeatMessageField<AEPbData$Point3f> mesh_points = PBField.initRepeatMessage(AEPbData$Point3f.class);
        };
        public AEPbData$DebugTextureData texture = new MessageMicro<AEPbData$DebugTextureData>() { // from class: com.tencent.aelight.camera.ae.protobuf.AEPbData$DebugTextureData
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField eyebrow_uv;
            public final PBBytesField face_landmark;
            public final PBBytesField face_normal;
            public final PBBytesField face_uv;

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.face_uv = PBField.initBytes(byteStringMicro);
                this.face_normal = PBField.initBytes(byteStringMicro);
                this.eyebrow_uv = PBField.initBytes(byteStringMicro);
                this.face_landmark = PBField.initBytes(byteStringMicro);
            }

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"face_uv", "face_normal", "eyebrow_uv", "face_landmark"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, AEPbData$DebugTextureData.class);
            }
        };
    };
}
