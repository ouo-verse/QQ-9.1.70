package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class NativeDoFlowerOp$ScreenCoord extends MessageMicro<NativeDoFlowerOp$ScreenCoord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{HippyTKDListViewAdapter.X, "y"}, new Object[]{0, 0}, NativeDoFlowerOp$ScreenCoord.class);

    /* renamed from: x, reason: collision with root package name */
    public final PBUInt32Field f106427x = PBField.initUInt32(0);

    /* renamed from: y, reason: collision with root package name */
    public final PBUInt32Field f106428y = PBField.initUInt32(0);
}
