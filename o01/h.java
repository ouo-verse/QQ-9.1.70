package o01;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f421686a;

    /* renamed from: b, reason: collision with root package name */
    public final int f421687b;

    public h(int i3, int i16) {
        this.f421686a = i3;
        this.f421687b = i16;
    }

    public final int hashCode() {
        return BoxType$EnumUnboxingSharedUtility.ordinal(this.f421687b) + (BoxType$EnumUnboxingSharedUtility.ordinal(this.f421686a) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QRCodeSquareInfo(type=");
        m3.append(i.a(this.f421686a));
        m3.append(", region=");
        m3.append(e.a(this.f421687b));
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f421686a == hVar.f421686a && this.f421687b == hVar.f421687b;
    }
}
