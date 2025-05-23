package k6;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final List<c<d>> f411721a;

    static {
        ArrayList arrayList = new ArrayList();
        f411721a = arrayList;
        arrayList.add(new l6.c());
        arrayList.add(new m6.b());
    }

    public static d a(i6.a aVar) {
        if (aVar == null) {
            QLog.e("CardDecoratorFactory", 1, "getBigCardDecoration  modelBannerData == null");
            return null;
        }
        for (c<d> cVar : f411721a) {
            if (cVar.b(aVar)) {
                return cVar.a();
            }
        }
        QLog.w("CardDecoratorFactory", 1, "getBigCardDecoration  not find decoration");
        return null;
    }
}
