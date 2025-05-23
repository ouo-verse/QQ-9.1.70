package p01;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Reflection;
import o01.d;
import o01.j;
import o01.l;
import o01.m;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f424864a;

    /* renamed from: b, reason: collision with root package name */
    public final int f424865b;

    /* renamed from: c, reason: collision with root package name */
    public final int f424866c;

    /* renamed from: d, reason: collision with root package name */
    public final j f424867d;

    public c(String str, int i3, int i16) {
        j lVar;
        this.f424864a = str;
        this.f424865b = i3;
        this.f424866c = i16;
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(i16);
        if (ordinal == 0) {
            lVar = new l(str);
        } else if (ordinal == 1) {
            lVar = new d(str);
        } else {
            if (ordinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            lVar = new o01.c(str);
        }
        this.f424867d = lVar;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QRCode(data=");
        m3.append(this.f424864a);
        m3.append(", errorCorrectionLevel=");
        m3.append(a.c(this.f424865b));
        m3.append(", dataType=");
        m3.append(b.b(this.f424866c));
        m3.append(", qrCodeData=");
        m3.append(Reflection.getOrCreateKotlinClass(this.f424867d.getClass()).getSimpleName());
        m3.append(')');
        return m3.toString();
    }

    public /* synthetic */ c(String str) {
        this(str, 2, m.f421693a.a(str));
    }
}
