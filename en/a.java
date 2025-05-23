package en;

import com.tencent.richframework.data.base.BaseDataCenter;
import fn.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends BaseDataCenter {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f396831a;

    a() {
        addDataConverter(new fn.a());
        addDataConverter(new b());
    }

    public static a a() {
        if (f396831a == null) {
            synchronized (a.class) {
                if (f396831a == null) {
                    f396831a = new a();
                }
            }
        }
        return f396831a;
    }
}
