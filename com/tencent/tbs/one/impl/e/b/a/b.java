package com.tencent.tbs.one.impl.e.b.a;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.e.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b extends com.tencent.tbs.one.impl.a.b<e<d>> {

    /* renamed from: p, reason: collision with root package name */
    Context f374971p;

    /* renamed from: q, reason: collision with root package name */
    String f374972q;

    /* renamed from: r, reason: collision with root package name */
    File f374973r;

    public b(Context context, String str, File file) {
        this.f374971p = context;
        this.f374972q = str;
        this.f374973r = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.e.b.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                Context context = bVar.f374971p;
                String str = bVar.f374972q;
                File file = bVar.f374973r;
                g.a("[%s] [AssetsDEPSInstallationJob].install start on file=%s", str, file);
                try {
                    InputStream open = context.getAssets().open("webkit/repo/" + str + "/DEPS");
                    if (open == null) {
                        bVar.a(324, "Failed to install deps from assets: webkit/repo/DEPS", new Throwable());
                        return;
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(open);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    com.tencent.tbs.one.impl.a.d.a(bufferedInputStream, bufferedOutputStream);
                    com.tencent.tbs.one.impl.a.d.a(bufferedOutputStream);
                    com.tencent.tbs.one.impl.a.d.a(bufferedInputStream);
                    try {
                        bVar.a((b) e.a(e.a.BUILTIN_ASSETS, d.a(file)));
                    } catch (TBSOneException e16) {
                        bVar.a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                    }
                } catch (Throwable th5) {
                    bVar.a(325, th5.getMessage(), th5.getCause());
                }
            }
        });
    }
}
