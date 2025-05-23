package com.tencent.trpcprotocol.qqva.post.post;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GestureGiftCoordinateBean$Coordinate extends MessageMicro<GestureGiftCoordinateBean$Coordinate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "giftID"}, new Object[]{0, 0, 0, 0}, GestureGiftCoordinateBean$Coordinate.class);

    /* renamed from: x, reason: collision with root package name */
    public final PBUInt32Field f381638x = PBField.initUInt32(0);

    /* renamed from: y, reason: collision with root package name */
    public final PBUInt32Field f381639y = PBField.initUInt32(0);

    /* renamed from: z, reason: collision with root package name */
    public final PBUInt32Field f381640z = PBField.initUInt32(0);
    public final PBUInt32Field giftID = PBField.initUInt32(0);
}
