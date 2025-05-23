package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenBase$StoreFace extends MessageMicro<YTOpenBase$StoreFace> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"face_id", "face_item", "tag"}, new Object[]{"", null, ""}, YTOpenBase$StoreFace.class);
    public final PBStringField face_id = PBField.initString("");
    public YTOpenBase$FaceItem face_item = new MessageMicro<YTOpenBase$FaceItem>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase$FaceItem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField face_id = PBField.initString("");

        /* renamed from: x, reason: collision with root package name */
        public final PBInt32Field f197725x = PBField.initInt32(0);

        /* renamed from: y, reason: collision with root package name */
        public final PBInt32Field f197726y = PBField.initInt32(0);
        public final PBFloatField height = PBField.initFloat(0.0f);
        public final PBFloatField width = PBField.initFloat(0.0f);
        public final PBInt32Field pitch = PBField.initInt32(0);
        public final PBInt32Field roll = PBField.initInt32(0);
        public final PBInt32Field yaw = PBField.initInt32(0);
        public final PBInt32Field age = PBField.initInt32(0);
        public final PBInt32Field gender = PBField.initInt32(0);
        public final PBBoolField glass = PBField.initBool(false);
        public final PBInt32Field expression = PBField.initInt32(0);
        public final PBInt32Field glasses = PBField.initInt32(0);
        public final PBInt32Field mask = PBField.initInt32(0);
        public final PBInt32Field hat = PBField.initInt32(0);
        public final PBInt32Field beauty = PBField.initInt32(0);
        public final PBFloatField rel_leftx = PBField.initFloat(0.0f);
        public final PBFloatField rel_width = PBField.initFloat(0.0f);
        public final PBFloatField rel_lefty = PBField.initFloat(0.0f);
        public final PBFloatField rel_height = PBField.initFloat(0.0f);
        public YTOpenBase$FaceShapeItem face_shape = new MessageMicro<YTOpenBase$FaceShapeItem>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase$FaceShapeItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 34, 42, 50, 58, 66, 74}, new String[]{"face_profile", "left_eye", "right_eye", "left_eyebrow", "right_eyebrow", "mouth", "nose"}, new Object[]{null, null, null, null, null, null, null}, YTOpenBase$FaceShapeItem.class);
            public final PBRepeatMessageField<YTOpenBase$point> face_profile = PBField.initRepeatMessage(YTOpenBase$point.class);
            public final PBRepeatMessageField<YTOpenBase$point> left_eye = PBField.initRepeatMessage(YTOpenBase$point.class);
            public final PBRepeatMessageField<YTOpenBase$point> right_eye = PBField.initRepeatMessage(YTOpenBase$point.class);
            public final PBRepeatMessageField<YTOpenBase$point> left_eyebrow = PBField.initRepeatMessage(YTOpenBase$point.class);
            public final PBRepeatMessageField<YTOpenBase$point> right_eyebrow = PBField.initRepeatMessage(YTOpenBase$point.class);
            public final PBRepeatMessageField<YTOpenBase$point> mouth = PBField.initRepeatMessage(YTOpenBase$point.class);
            public final PBRepeatMessageField<YTOpenBase$point> nose = PBField.initRepeatMessage(YTOpenBase$point.class);
        };

        static {
            int[] iArr = {10, 16, 24, 37, 45, 48, 56, 64, 72, 80, 88, 96, 104, 165, 173, 181, 189, 242, 320, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 336};
            String[] strArr = {"face_id", HippyTKDListViewAdapter.X, "y", "height", "width", "pitch", "roll", "yaw", "age", "gender", "glass", "expression", "beauty", "rel_leftx", "rel_width", "rel_lefty", "rel_height", "face_shape", "glasses", "mask", "hat"};
            Float valueOf = Float.valueOf(0.0f);
            __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", 0, 0, valueOf, valueOf, 0, 0, 0, 0, 0, Boolean.FALSE, 0, 0, valueOf, valueOf, valueOf, valueOf, null, 0, 0, 0}, YTOpenBase$FaceItem.class);
        }
    };
    public final PBStringField tag = PBField.initString("");
}
