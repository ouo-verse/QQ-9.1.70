package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import gt0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class NBPLatLng {
    public static final Companion Companion = new Companion();
    public double latitude;
    public double longitude;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final NBPLatLng from(e eVar) {
            double h16 = eVar.h("lat02");
            double h17 = eVar.h("lon02");
            if (h16 == 0.0d) {
                if (h17 == 0.0d) {
                    h16 = eVar.h("lat84");
                    h17 = eVar.h("lon84");
                }
            }
            return new NBPLatLng(h16, h17);
        }
    }

    public NBPLatLng() {
        this(0.0d, 0.0d, 3, null);
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int hashCode() {
        return a.a(this.longitude) + (a.a(this.latitude) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPLatLng(latitude=");
        m3.append(this.latitude);
        m3.append(", longitude=");
        m3.append(this.longitude);
        m3.append(')');
        return m3.toString();
    }

    public NBPLatLng(double d16, double d17) {
        this.latitude = d16;
        this.longitude = d17;
    }

    public /* synthetic */ NBPLatLng(double d16, double d17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(-1.0d, -1.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPLatLng)) {
            return false;
        }
        NBPLatLng nBPLatLng = (NBPLatLng) obj;
        return Double.compare(this.latitude, nBPLatLng.latitude) == 0 && Double.compare(this.longitude, nBPLatLng.longitude) == 0;
    }
}
