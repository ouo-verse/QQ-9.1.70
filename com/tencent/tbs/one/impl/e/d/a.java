package com.tencent.tbs.one.impl.e.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.f;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends com.tencent.tbs.one.impl.a.b<e<File>> implements a.InterfaceC9892a {

    /* renamed from: b, reason: collision with root package name */
    int f374995b;

    /* renamed from: c, reason: collision with root package name */
    private Context f374996c;

    /* renamed from: d, reason: collision with root package name */
    private String f374997d;

    /* renamed from: e, reason: collision with root package name */
    private d.a f374998e;

    /* renamed from: f, reason: collision with root package name */
    private File f374999f;

    /* renamed from: g, reason: collision with root package name */
    private File f375000g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.tbs.one.impl.d.a f375001h;

    /* renamed from: i, reason: collision with root package name */
    private long f375002i = -1;

    /* renamed from: j, reason: collision with root package name */
    private Bundle f375003j;

    public a(Context context, String str, d.a aVar, File file, Bundle bundle) {
        File file2;
        this.f374996c = context;
        this.f374997d = str;
        this.f374998e = aVar;
        this.f374999f = file;
        this.f375003j = bundle;
        String str2 = aVar.f374826a;
        int i3 = aVar.f374828c;
        File externalFilesDir = context.getExternalFilesDir("tbs");
        if (externalFilesDir != null) {
            file2 = new File(new File(externalFilesDir, str), str2);
        } else {
            file2 = null;
        }
        this.f375000g = file2 != null ? new File(file2, String.valueOf(i3)) : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        com.tencent.tbs.one.impl.d.a aVar = new com.tencent.tbs.one.impl.d.a(this.f374996c, this.f374998e.f374829d);
        this.f375001h = aVar;
        aVar.f374889f = this;
        aVar.a((m) new m<Integer>() { // from class: com.tencent.tbs.one.impl.e.d.a.1
            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, int i16) {
                a.this.a(i16);
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i3, String str, Throwable th5) {
                a.this.a(i3, str, th5);
            }
        });
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        TBSOneRuntimeExtension a16;
        super.b();
        com.tencent.tbs.one.impl.d.a aVar = this.f375001h;
        if (aVar != null) {
            aVar.b();
        }
        if (this.f374995b != 0 && (a16 = com.tencent.tbs.one.impl.common.a.a(this.f374996c, this.f374997d)) != null) {
            a16.cancel(this.f374995b);
        }
    }

    @Override // com.tencent.tbs.one.impl.d.a.InterfaceC9892a
    public final void a(int i3, Map<String, List<String>> map, InputStream inputStream) {
        File file;
        int shouldInterceptComponentResponse;
        final String str = this.f374997d;
        d.a aVar = this.f374998e;
        final String str2 = aVar.f374826a;
        int i16 = aVar.f374828c;
        String str3 = aVar.f374829d;
        final File file2 = this.f374999f;
        File file3 = this.f375000g;
        if (file3 != null && !file3.exists()) {
            this.f375000g.mkdirs();
        }
        if (this.f375000g == null) {
            file = null;
        } else {
            file = new File(this.f375000g, this.f374998e.f374826a + ".tbs");
        }
        g.a("[%s] {%s} Receiving component response: [%d] %s", str, str2, Integer.valueOf(i3), map);
        if (i3 == 200 && inputStream != null) {
            List<String> list = map.get("Content-Length");
            if (list != null && list.size() > 0) {
                try {
                    this.f375002i = Long.parseLong(list.get(0));
                } catch (Exception e16) {
                    g.c("Failed to parse Content-Length header %s, url: %s", list, str3, e16);
                }
            } else {
                g.a("No Content-Length header exists, url: %s", str3);
            }
            TBSOneRuntimeExtension a16 = com.tencent.tbs.one.impl.common.a.a(this.f374996c, str);
            if (a16 != null && (shouldInterceptComponentResponse = a16.shouldInterceptComponentResponse(str, str2, i16, null, inputStream, file2, new TBSOneCallback<Void>() { // from class: com.tencent.tbs.one.impl.e.d.a.2
                @Override // com.tencent.tbs.one.TBSOneCallback
                public final /* synthetic */ void onCompleted(Void r46) {
                    g.a("[%s] {%s} Finished intercepting component download stream by runtime extension", str, str2);
                    a aVar2 = a.this;
                    aVar2.f374995b = 0;
                    aVar2.a((a) e.a(e.a.EXTENSION, file2));
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onError(int i17, String str4) {
                    a aVar2 = a.this;
                    aVar2.f374995b = 0;
                    aVar2.a(i17, str4, (Throwable) null);
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onProgressChanged(int i17, int i18) {
                    a.this.a(i18);
                }
            })) != 0) {
                g.a("[%s] {%s} Intercepted component download stream by runtime extension", str, str2);
                this.f374995b = shouldInterceptComponentResponse;
                return;
            }
            try {
                f.a(inputStream, this.f374998e.f374830e, this.f375002i, file2, file, new l.a() { // from class: com.tencent.tbs.one.impl.e.d.a.3
                    @Override // com.tencent.tbs.one.impl.a.l.a
                    public final boolean a() {
                        return !a.this.f374550a;
                    }

                    @Override // com.tencent.tbs.one.impl.a.l.a
                    public final void a(int i17) {
                        a.this.a(i17);
                    }
                });
                f.a(file2, file2);
                f.a(file2, i16);
                f.a(this.f374996c.getDir("tbs", 0));
                f.b(file2);
                a((a) e.a(e.a.ONLINE, file2));
                return;
            } catch (TBSOneException e17) {
                a(e17.getErrorCode(), e17.getMessage(), e17.getCause());
                return;
            }
        }
        a(215, "Invalid component response stream, url: " + str3 + ", statusCode: " + i3, (Throwable) null);
    }
}
