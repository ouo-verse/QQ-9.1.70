package o01;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends j {
    @Override // o01.j
    public final int a() {
        return this.f421689b.length();
    }

    @Override // o01.j
    public final void b(a aVar) {
        int i3;
        int length = this.f421689b.length();
        int i16 = 0;
        while (true) {
            i3 = i16 + 2;
            if (i3 >= length) {
                break;
            }
            int i17 = i16 + 3;
            String substring = this.f421689b.substring(i16, i17);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            aVar.a(Integer.parseInt(substring), 10);
            i16 = i17;
        }
        if (i16 < length) {
            int i18 = length - i16;
            if (i18 == 1) {
                String substring2 = this.f421689b.substring(i16, i16 + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                aVar.a(Integer.parseInt(substring2), 4);
            } else if (i18 == 2) {
                String substring3 = this.f421689b.substring(i16, i3);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                aVar.a(Integer.parseInt(substring3), 7);
            }
        }
    }

    public l(String str) {
        super(1, str);
    }
}
