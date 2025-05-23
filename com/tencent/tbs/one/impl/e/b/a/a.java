package com.tencent.tbs.one.impl.e.b.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends com.tencent.tbs.one.impl.a.b<e<File>> {

    /* renamed from: p, reason: collision with root package name */
    Context f374964p;

    /* renamed from: q, reason: collision with root package name */
    String f374965q;

    /* renamed from: r, reason: collision with root package name */
    d.a f374966r;

    /* renamed from: s, reason: collision with root package name */
    File f374967s;

    /* renamed from: t, reason: collision with root package name */
    private Bundle f374968t;

    /* renamed from: u, reason: collision with root package name */
    private String f374969u;

    public a(Context context, String str, d.a aVar, File file, Bundle bundle, String str2) {
        this.f374964p = context;
        this.f374965q = str;
        this.f374966r = aVar;
        this.f374967s = file;
        this.f374968t = bundle;
        this.f374969u = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.e.b.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                Context context = aVar.f374964p;
                String str = aVar.f374965q;
                d.a aVar2 = aVar.f374966r;
                File file = aVar.f374967s;
                g.a("[%s] [AssetsComponentInstallationJob].install start on path=%s", str, file);
                File a16 = f.a(context);
                com.tencent.tbs.one.impl.a.d.d(file);
                File file2 = new File(file, "MANIFEST");
                String str2 = "webkit/repo/" + str + "/components/" + aVar2.f374826a + "/" + aVar2.f374828c;
                try {
                    InputStream open = aVar.f374964p.getAssets().open(str2 + "/MANIFEST");
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    com.tencent.tbs.one.impl.a.d.a(open, fileOutputStream);
                    com.tencent.tbs.one.impl.a.d.a(fileOutputStream);
                    com.tencent.tbs.one.impl.common.e a17 = com.tencent.tbs.one.impl.common.e.a(file2);
                    int i3 = aVar.f374966r.f374828c;
                    int i16 = a17.f374832a;
                    MessageDigest messageDigest = null;
                    if (i3 != i16) {
                        aVar.a(417, "Failed to verify version code, expected " + i3 + " but was " + i16, null);
                        return;
                    }
                    for (e.a aVar3 : a17.f374836e) {
                        String str3 = aVar3.f374841a;
                        File file3 = new File(file, str3);
                        String str4 = str2 + "/" + str3;
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                            com.tencent.tbs.one.impl.a.d.a(aVar.f374964p.getAssets().open(str4), fileOutputStream2);
                            com.tencent.tbs.one.impl.a.d.a(fileOutputStream2);
                            String str5 = aVar3.f374842b;
                            if (!TextUtils.isEmpty(str5)) {
                                if (messageDigest == null) {
                                    try {
                                        messageDigest = com.tencent.tbs.one.impl.e.f.a();
                                    } catch (TBSOneException e16) {
                                        aVar.a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                                        return;
                                    }
                                }
                                com.tencent.tbs.one.impl.e.f.a(messageDigest, file3, str5);
                            }
                        } catch (IOException e17) {
                            aVar.a(326, "Failed to copy builtin component file from " + a16.getAbsolutePath() + " to " + file3.getAbsolutePath(), e17);
                            return;
                        }
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    String str6 = File.separator;
                    sb5.append(str6);
                    sb5.append("libs");
                    String sb6 = sb5.toString();
                    String str7 = file.getAbsolutePath() + str6 + "libs";
                    try {
                        com.tencent.tbs.one.impl.a.d.a(context, sb6, str7, true);
                        String str8 = str2 + str6 + "extensions";
                        String absolutePath = file.getAbsolutePath();
                        try {
                            com.tencent.tbs.one.impl.a.d.a(context, str8, absolutePath, true);
                            aVar.a((a) com.tencent.tbs.one.impl.e.e.a(e.a.BUILTIN_ASSETS, file));
                        } catch (Throwable th5) {
                            aVar.a(326, "Failed to copy builtin component extensions from " + str8 + " to " + absolutePath, th5);
                        }
                    } catch (Throwable th6) {
                        aVar.a(326, "Failed to copy builtin component libs from " + sb6 + " to " + str7, th6);
                    }
                } catch (Throwable th7) {
                    aVar.a(327, th7.getMessage(), th7.getCause());
                }
            }
        });
    }
}
