package f45;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends e45.e {

    /* renamed from: b, reason: collision with root package name */
    public final b f397847b;

    /* renamed from: c, reason: collision with root package name */
    public final int f397848c;

    public c(b bVar, int i3) {
        super(new d(bVar));
        this.f397847b = bVar;
        this.f397848c = i3;
    }

    public final byte[] d() {
        IntRange until;
        byte[] sliceArray;
        b bVar = this.f397847b;
        byte[] bArr = bVar.f397845a;
        until = RangesKt___RangesKt.until(0, bVar.f397846b);
        sliceArray = ArraysKt___ArraysKt.sliceArray(bArr, until);
        if (sliceArray.length == this.f397848c) {
            return sliceArray;
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Expected ");
        m3.append(this.f397848c);
        m3.append(", got ");
        m3.append(sliceArray.length);
        throw new IllegalStateException(m3.toString().toString());
    }
}
