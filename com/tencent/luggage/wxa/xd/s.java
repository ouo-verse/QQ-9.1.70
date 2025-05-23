package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.uk.h0;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class s extends p {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f144882a;

        static {
            int[] iArr = new int[h0.a.values().length];
            iArr[h0.a.LANDSCAPE.ordinal()] = 1;
            iArr[h0.a.REVERSE_LANDSCAPE.ordinal()] = 2;
            iArr[h0.a.PORTRAIT.ordinal()] = 3;
            f144882a = iArr;
        }
    }

    public final void a(com.tencent.luggage.wxa.kj.v pageView, int i3, h0.a orientation) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + pageView + ", viewId: " + i3 + ", orientation: " + orientation);
        String a16 = a(orientation);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, null == orientationStr");
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("viewId", Integer.valueOf(i3));
        hashMap.put("orientation", a16);
        String obj = com.tencent.luggage.wxa.xa.g.a(hashMap).toString();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + getName() + ", data: " + obj);
        setData(obj).setContext(pageView, pageView.getComponentId()).dispatch();
        com.tencent.luggage.wxa.ic.l y06 = pageView.y0();
        if (y06 != null) {
            setData(obj).setContext(y06, pageView.getComponentId()).dispatch();
        }
    }

    public final String a(h0.a aVar) {
        int i3 = a.f144882a[aVar.ordinal()];
        if (i3 == 1) {
            return "landscapeLeft";
        }
        if (i3 == 2) {
            return "landscape";
        }
        if (i3 != 3) {
            return null;
        }
        return "portrait";
    }
}
