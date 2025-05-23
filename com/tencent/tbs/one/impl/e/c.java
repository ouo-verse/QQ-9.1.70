package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class c extends com.tencent.tbs.one.impl.a.c<e<File>> {

    /* renamed from: e, reason: collision with root package name */
    private d.a f374975e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.tbs.one.impl.a.b<e<File>> f374976f;

    /* renamed from: g, reason: collision with root package name */
    private File f374977g;

    /* renamed from: h, reason: collision with root package name */
    private Context f374978h;

    public c(Context context, d.a aVar, com.tencent.tbs.one.impl.a.b<e<File>> bVar, File file, int i3) {
        super(com.tencent.tbs.one.impl.common.f.e(file, ".lock"), i3);
        this.f374975e = aVar;
        this.f374976f = bVar;
        this.f374977g = file;
        this.f374978h = context;
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        super.b();
        this.f374976f.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.c
    public final void c() {
        File file = this.f374977g;
        com.tencent.tbs.one.impl.a.g.a("[ExclusiveComponentInstallationJob].onLockGranted start on path=%s", file);
        if (f.g(file)) {
            if (file.exists()) {
                com.tencent.tbs.one.impl.a.g.a("[ExclusiveComponentInstallationJob].onLockGranted Component has been installed completely in outputDirectory. Finish Installation.", new Object[0]);
                a(e.a(e.a.EXISTING, file));
                return;
            }
            f.e(file);
        } else if (file.exists()) {
            com.tencent.tbs.one.impl.a.g.a("[ExclusiveComponentInstallationJob].onLockGranted Cleaning incomplete files in outputDirectory.", new Object[0]);
            com.tencent.tbs.one.impl.a.d.c(file);
        }
        this.f374976f.a(new m<e<File>>() { // from class: com.tencent.tbs.one.impl.e.c.1
            @Override // com.tencent.tbs.one.impl.a.m
            public final /* bridge */ /* synthetic */ void a(e<File> eVar) {
                c.this.a(eVar);
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, int i16) {
                c.this.a(i16);
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, String str, Throwable th5) {
                c.this.a(i3, str, th5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.c
    public final void a(Exception exc) {
        a(311, "Failed to wait for component installation lock " + this.f374977g, exc);
    }

    @Override // com.tencent.tbs.one.impl.a.c, com.tencent.tbs.one.impl.a.b
    public final void a(int i3, String str, Throwable th5) {
        File file = this.f374977g;
        com.tencent.tbs.one.impl.a.g.a("[ExclusiveComponentInstallationJob].fail Delete files in path: " + file, new Object[0]);
        com.tencent.tbs.one.impl.a.d.c(file);
        f.f(file);
        super.a(i3, str, th5);
    }

    @Override // com.tencent.tbs.one.impl.a.c, com.tencent.tbs.one.impl.a.b
    public final void a(e<File> eVar) {
        com.tencent.tbs.one.impl.a.g.a("[ExclusiveComponentInstallationJob].finish try to doDex2oat", new Object[0]);
        File file = eVar.f375021b;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                String str = this.f374975e.f374826a;
                String[] strArr = com.tencent.tbs.one.impl.common.e.a(new File(file, "MANIFEST")).f374834c;
                if (strArr != null && strArr.length > 0 && !TextUtils.isEmpty(strArr[0])) {
                    File[] fileArr = {new File(file, strArr[0])};
                    com.tencent.tbs.one.impl.a.g.a("do dexopt for component %s,entryClass=%s,installDir=%s", str, fileArr[0], file);
                    com.tencent.tbs.one.impl.c.a.d.a(this.f374978h, fileArr, file.getAbsolutePath(), file.getAbsolutePath(), null, false, null, false, false);
                }
            } catch (Throwable th5) {
                com.tencent.tbs.one.impl.a.g.c("exception occured in dex2oat,exception=%s", Log.getStackTraceString(th5));
            }
        }
        f.f(this.f374977g);
        super.a((c) eVar);
    }
}
