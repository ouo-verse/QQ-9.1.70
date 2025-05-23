package e41;

import com.tencent.luggage.wxa.tj.d;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ void a(d.c cVar, int i3, ArrayList arrayList, int i16, boolean z16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 4) != 0) {
                i16 = 0;
            }
            if ((i17 & 8) != 0) {
                z16 = false;
            }
            cVar.a(i3, arrayList, i16, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMsg");
    }
}
