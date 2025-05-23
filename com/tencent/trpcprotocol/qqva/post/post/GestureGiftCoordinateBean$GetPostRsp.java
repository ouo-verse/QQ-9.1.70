package com.tencent.trpcprotocol.qqva.post.post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class GestureGiftCoordinateBean$GetPostRsp extends MessageMicro<GestureGiftCoordinateBean$GetPostRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "msg", "points"}, new Object[]{0, "", null}, GestureGiftCoordinateBean$GetPostRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381641msg = PBField.initString("");
    public final PBRepeatMessageField<GestureGiftCoordinateBean$Coordinate> points = PBField.initRepeatMessage(GestureGiftCoordinateBean$Coordinate.class);
}
