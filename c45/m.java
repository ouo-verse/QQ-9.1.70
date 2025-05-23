package c45;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final int f30322a;

    /* renamed from: b, reason: collision with root package name */
    public final List<a> f30323b;

    public m(int i3, List<a> list) {
        this.f30322a = i3;
        this.f30323b = list;
    }

    public final int hashCode() {
        return this.f30323b.hashCode() + (this.f30322a * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UnknownField(fieldNum=");
        m3.append(this.f30322a);
        m3.append(", values=");
        m3.append(this.f30323b);
        m3.append(')');
        return m3.toString();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f30324a;

        /* renamed from: b, reason: collision with root package name */
        public final c45.a f30325b;

        public a(int i3, c45.a aVar) {
            this.f30324a = i3;
            this.f30325b = aVar;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f30325b.f30291a) + (this.f30324a * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Value(wireType=");
            m3.append(this.f30324a);
            m3.append(", rawBytes=");
            m3.append(this.f30325b);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30324a == aVar.f30324a && Intrinsics.areEqual(this.f30325b, aVar.f30325b);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f30322a == mVar.f30322a && Intrinsics.areEqual(this.f30323b, mVar.f30323b);
    }
}
