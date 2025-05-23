package com.tencent.biz.qqstory.network.pb;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$GpsMsg extends MessageMicro<qqstory_struct$GpsMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lng"}, new Object[]{0, 0}, qqstory_struct$GpsMsg.class);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
}
