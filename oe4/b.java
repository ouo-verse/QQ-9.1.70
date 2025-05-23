package oe4;

import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private long f422586a;

    public b(long j3) {
        this.f422586a = j3;
    }

    @Override // oe4.a
    public boolean a(File file) {
        if (file == null || System.currentTimeMillis() - file.lastModified() <= this.f422586a) {
            return false;
        }
        return true;
    }
}
