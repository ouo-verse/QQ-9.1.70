package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.stPoints;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class Point implements SmartParcelable {

    /* renamed from: x, reason: collision with root package name */
    @NeedParcel
    public int f50265x;

    /* renamed from: y, reason: collision with root package name */
    @NeedParcel
    public int f50266y;

    public Point() {
    }

    public static Point create(stPoints stpoints) {
        Point point = new Point();
        point.f50265x = stpoints.f24997x;
        point.f50266y = stpoints.f24998y;
        return point;
    }

    public Point(int i3, int i16) {
        this.f50265x = i3;
        this.f50266y = i16;
    }
}
