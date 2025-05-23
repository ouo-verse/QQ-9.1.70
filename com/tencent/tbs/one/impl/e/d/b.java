package com.tencent.tbs.one.impl.e.d;

import android.content.Context;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b extends com.tencent.tbs.one.impl.a.b<e<d>> implements a.InterfaceC9892a {

    /* renamed from: b, reason: collision with root package name */
    com.tencent.tbs.one.impl.d.a f375010b;

    /* renamed from: c, reason: collision with root package name */
    int f375011c;

    /* renamed from: d, reason: collision with root package name */
    private Context f375012d;

    /* renamed from: e, reason: collision with root package name */
    private String f375013e;

    /* renamed from: f, reason: collision with root package name */
    private String f375014f;

    /* renamed from: g, reason: collision with root package name */
    private File f375015g;

    public b(Context context, String str, String str2, File file) {
        this.f375012d = context;
        this.f375013e = str;
        this.f375014f = str2;
        this.f375015g = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        com.tencent.tbs.one.impl.d.a aVar = new com.tencent.tbs.one.impl.d.a(this.f375012d, this.f375014f);
        this.f375010b = aVar;
        aVar.f374889f = this;
        aVar.a((m) new m<Integer>() { // from class: com.tencent.tbs.one.impl.e.d.b.1
            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, int i16) {
                b.this.a(i16);
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, String str, Throwable th5) {
                b bVar = b.this;
                bVar.f375010b = null;
                bVar.a(i3, str, th5);
            }
        });
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        TBSOneRuntimeExtension a16;
        super.b();
        com.tencent.tbs.one.impl.d.a aVar = this.f375010b;
        if (aVar != null) {
            aVar.b();
        }
        if (this.f375011c != 0 && (a16 = com.tencent.tbs.one.impl.common.a.a(this.f375012d, this.f375013e)) != null) {
            a16.cancel(this.f375011c);
        }
    }

    @Override // com.tencent.tbs.one.impl.d.a.InterfaceC9892a
    public final void a(int i3, Map<String, List<String>> map, InputStream inputStream) {
        int shouldInterceptDEPSResponse;
        Context context = this.f375012d;
        String str = this.f375014f;
        final String str2 = this.f375013e;
        final File file = this.f375015g;
        g.a("[%s] Receiving DEPS response: [%d] %s", str2, Integer.valueOf(i3), map);
        if (i3 == 200 && inputStream != null) {
            TBSOneRuntimeExtension a16 = com.tencent.tbs.one.impl.common.a.a(context, str2);
            if (a16 != null && (shouldInterceptDEPSResponse = a16.shouldInterceptDEPSResponse(str2, null, inputStream, file, new TBSOneCallback<Void>() { // from class: com.tencent.tbs.one.impl.e.d.b.2
                @Override // com.tencent.tbs.one.TBSOneCallback
                public final /* synthetic */ void onCompleted(Void r46) {
                    g.a("[%s] Finished intercepting DEPS download stream by runtime extension", str2);
                    b.this.f375011c = 0;
                    try {
                        b.this.a((b) e.a(e.a.EXTENSION, d.a(file)));
                    } catch (TBSOneException e16) {
                        b.this.a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                    }
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onError(int i16, String str3) {
                    b bVar = b.this;
                    bVar.f375011c = 0;
                    bVar.a(i16, str3, (Throwable) null);
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onProgressChanged(int i16, int i17) {
                    b.this.a(i17);
                }
            })) != 0) {
                g.a("[%s] Intercepted DEPS download stream by runtime extension", str2);
                this.f375011c = shouldInterceptDEPSResponse;
                return;
            }
            try {
                a((b) e.a(e.a.ONLINE, d.a(com.tencent.tbs.one.impl.a.d.a(inputStream, "utf-8", file))));
                return;
            } catch (TBSOneException e16) {
                a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                return;
            } catch (IOException e17) {
                a(305, "Failed to download online DEPS from " + str + " to " + file.getAbsolutePath(), e17);
                return;
            }
        }
        a(210, "Invalid DEPS response stream, url: " + str + ", statusCode: " + i3, (Throwable) null);
    }
}
