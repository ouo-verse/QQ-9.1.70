package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class d extends com.tencent.tbs.one.impl.a.c<e<com.tencent.tbs.one.impl.common.d>> {

    /* renamed from: e, reason: collision with root package name */
    private boolean f374991e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> f374992f;

    /* renamed from: g, reason: collision with root package name */
    private File f374993g;

    public d(boolean z16, com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> bVar, File file) {
        super(com.tencent.tbs.one.impl.common.f.e(file, ".lock"), 10000L);
        this.f374991e = z16;
        this.f374992f = bVar;
        this.f374993g = file;
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        super.b();
        this.f374992f.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.c
    public final void c() {
        File file = this.f374993g;
        com.tencent.tbs.one.impl.a.g.a("[ExclusiveDEPSInstallationJob].onLockGranted start on file=%s", file);
        if (f.g(file)) {
            if (file.exists()) {
                com.tencent.tbs.one.impl.a.g.a("[ExclusiveDEPSInstallationJob].onLockGranted DEPS File Existed", new Object[0]);
                if (!this.f374991e) {
                    com.tencent.tbs.one.impl.a.g.a("[ExclusiveDEPSInstallationJob].onLockGranted Load Existing DEPS File (mIgnoreExisting=false)", new Object[0]);
                    try {
                        a(e.a(e.a.EXISTING, com.tencent.tbs.one.impl.common.d.a(file)));
                        com.tencent.tbs.one.impl.a.g.a("[ExclusiveDEPSInstallationJob].onLockGranted Successfully loaded Existing DEPS File", new Object[0]);
                        return;
                    } catch (TBSOneException unused) {
                        com.tencent.tbs.one.impl.a.g.c("[ExclusiveDEPSInstallationJob].onLockGranted Fail to Load Existing DEPS File", new Object[0]);
                    }
                }
                com.tencent.tbs.one.impl.a.g.a("[ExclusiveDEPSInstallationJob].onLockGranted Delete Existing DEPS File (mIgnoreExisting=true)", new Object[0]);
                com.tencent.tbs.one.impl.a.d.c(file);
            } else {
                com.tencent.tbs.one.impl.a.g.a("[ExclusiveDEPSInstallationJob].onLockGranted DEPS File Not Existed", new Object[0]);
            }
            f.e(file);
        } else if (file.exists()) {
            com.tencent.tbs.one.impl.a.d.c(file);
        }
        this.f374992f.a(new m<e<com.tencent.tbs.one.impl.common.d>>() { // from class: com.tencent.tbs.one.impl.e.d.1
            @Override // com.tencent.tbs.one.impl.a.m
            public final /* bridge */ /* synthetic */ void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
                d.this.a(eVar);
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, int i16) {
                d.this.a(i16);
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, String str, Throwable th5) {
                d.this.a(i3, str, th5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.c
    public final void a(Exception exc) {
        a(301, "Failed to wait for DEPS installation lock " + this.f374993g, exc);
    }

    @Override // com.tencent.tbs.one.impl.a.c, com.tencent.tbs.one.impl.a.b
    public final void a(int i3, String str, Throwable th5) {
        File file = this.f374993g;
        com.tencent.tbs.one.impl.a.g.a("[ExclusiveComponentInstallationJob].fail Delete file: " + file, new Object[0]);
        com.tencent.tbs.one.impl.a.d.c(file);
        f.f(file);
        super.a(i3, str, th5);
    }

    @Override // com.tencent.tbs.one.impl.a.c, com.tencent.tbs.one.impl.a.b
    public final void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
        com.tencent.tbs.one.impl.a.g.a("[ExclusiveComponentInstallationJob].finish", new Object[0]);
        f.f(this.f374993g);
        super.a((d) eVar);
    }
}
