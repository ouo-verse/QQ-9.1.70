package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenBase$point extends MessageMicro<YTOpenBase$point> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{HippyTKDListViewAdapter.X, "y"}, new Object[]{0, 0}, YTOpenBase$point.class);

    /* renamed from: x, reason: collision with root package name */
    public final PBInt32Field f197727x = PBField.initInt32(0);

    /* renamed from: y, reason: collision with root package name */
    public final PBInt32Field f197728y = PBField.initInt32(0);
}
