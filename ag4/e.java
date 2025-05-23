package ag4;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f26060a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f26061b;

    /* renamed from: c, reason: collision with root package name */
    public long f26062c;

    /* renamed from: d, reason: collision with root package name */
    public int f26063d;

    /* renamed from: e, reason: collision with root package name */
    public List<Integer> f26064e = new ArrayList();

    public e(int i3, boolean z16, long j3, int i16, List<Integer> list) {
        this.f26060a = i3;
        this.f26061b = z16;
        this.f26062c = j3;
        this.f26063d = i16;
        if (list != null && list.size() > 0) {
            this.f26064e.addAll(list);
        }
    }

    public static e a(int i3) {
        return new e(i3, true, 0L, 0, null);
    }

    public static e b(int i3, long j3, int i16, List<Integer> list) {
        return new e(i3, false, j3, i16, list);
    }
}
