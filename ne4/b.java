package ne4;

import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private long f420072a;

    public b(long j3) {
        this.f420072a = j3;
    }

    @Override // ne4.a
    public boolean a(File file) {
        if (file == null || file.length() <= this.f420072a) {
            return false;
        }
        return true;
    }
}
