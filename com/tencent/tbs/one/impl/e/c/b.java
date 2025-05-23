package com.tencent.tbs.one.impl.e.c;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b extends com.tencent.tbs.one.impl.a.b<e<d>> {

    /* renamed from: b, reason: collision with root package name */
    Context f374987b;

    /* renamed from: c, reason: collision with root package name */
    String f374988c;

    /* renamed from: d, reason: collision with root package name */
    File f374989d;

    public b(Context context, String str, File file) {
        this.f374987b = context;
        this.f374988c = str;
        this.f374989d = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.e.c.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                Context context = bVar.f374987b;
                String str = bVar.f374988c;
                File file = bVar.f374989d;
                g.a("[%s] [BuiltinDEPSInstallationJob].install thread start on file=%s", str, file);
                File a16 = f.a(context);
                try {
                    com.tencent.tbs.one.impl.a.d.a(f.c(a16, str), file);
                    try {
                        bVar.a((b) e.a(e.a.BUILTIN, d.a(file)));
                    } catch (TBSOneException e16) {
                        bVar.a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                    }
                } catch (IOException e17) {
                    bVar.a(302, "Failed to copy builtin DEPS from " + a16.getAbsolutePath() + " to " + file.getAbsolutePath(), e17);
                }
            }
        });
    }
}
