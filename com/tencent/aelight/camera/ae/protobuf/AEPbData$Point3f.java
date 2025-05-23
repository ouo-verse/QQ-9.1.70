package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes32.dex */
public final class AEPbData$Point3f extends MessageMicro<AEPbData$Point3f> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: x, reason: collision with root package name */
    public final PBFloatField f65668x = PBField.initFloat(0.0f);

    /* renamed from: y, reason: collision with root package name */
    public final PBFloatField f65669y = PBField.initFloat(0.0f);

    /* renamed from: z, reason: collision with root package name */
    public final PBFloatField f65670z = PBField.initFloat(0.0f);

    static {
        String[] strArr = {HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 29}, strArr, new Object[]{valueOf, valueOf, valueOf}, AEPbData$Point3f.class);
    }
}
