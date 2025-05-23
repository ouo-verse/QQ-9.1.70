package com.tencent.tbs.one.impl.e.c;

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

    /* renamed from: b, reason: collision with root package name */
    Context f374980b;

    /* renamed from: c, reason: collision with root package name */
    String f374981c;

    /* renamed from: d, reason: collision with root package name */
    d.a f374982d;

    /* renamed from: e, reason: collision with root package name */
    File f374983e;

    /* renamed from: f, reason: collision with root package name */
    String f374984f;

    /* renamed from: g, reason: collision with root package name */
    private Bundle f374985g;

    public a(Context context, String str, d.a aVar, File file, Bundle bundle, String str2) {
        this.f374980b = context;
        this.f374981c = str;
        this.f374982d = aVar;
        this.f374983e = file;
        this.f374985g = bundle;
        this.f374984f = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.e.c.a.1
            /* JADX WARN: Removed duplicated region for block: B:32:0x0111  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0131 A[SYNTHETIC] */
            /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                Context context;
                boolean z16;
                String str;
                MessageDigest a16;
                FileOutputStream fileOutputStream;
                InputStream inputStream;
                InputStream inputStream2;
                a aVar = a.this;
                Context context2 = aVar.f374980b;
                String str2 = aVar.f374981c;
                d.a aVar2 = aVar.f374982d;
                File file = aVar.f374983e;
                int i3 = 2;
                g.a("[%s] [BuiltinComponentInstallationJob].install start on path=%s", str2, file);
                File a17 = f.a(context2);
                String str3 = aVar2.f374826a;
                File a18 = f.a(a17, str3, "MANIFEST");
                try {
                    com.tencent.tbs.one.impl.common.e a19 = com.tencent.tbs.one.impl.common.e.a(a18);
                    int i16 = aVar.f374982d.f374828c;
                    int i17 = a19.f374832a;
                    if (i16 != i17) {
                        aVar.a(417, "Failed to verify version code, expected " + i16 + " but was " + i17, null);
                        return;
                    }
                    com.tencent.tbs.one.impl.a.d.d(file);
                    try {
                        com.tencent.tbs.one.impl.a.d.a(a18, new File(file, "MANIFEST"));
                        e.a[] aVarArr = a19.f374836e;
                        int length = aVarArr.length;
                        int i18 = 0;
                        MessageDigest messageDigest = null;
                        while (i18 < length) {
                            e.a aVar3 = aVarArr[i18];
                            String str4 = aVar3.f374841a;
                            File file2 = new File(file, str4);
                            if (!TextUtils.isEmpty(aVar3.f374845e)) {
                                Object[] objArr = new Object[i3];
                                objArr[0] = str4;
                                objArr[1] = aVar3.f374845e;
                                g.a("unzip %s from url %s", objArr);
                                try {
                                    inputStream2 = com.tencent.tbs.one.impl.a.d.a(context2, aVar.f374984f, aVar3.f374845e);
                                    try {
                                        try {
                                            Object[] objArr2 = new Object[1];
                                            z16 = false;
                                            try {
                                                objArr2[0] = inputStream2;
                                                g.a("opening inputstream %s", objArr2);
                                                fileOutputStream = new FileOutputStream(file2);
                                                try {
                                                    try {
                                                        com.tencent.tbs.one.impl.a.d.a(inputStream2, fileOutputStream);
                                                        com.tencent.tbs.one.impl.a.d.a(inputStream2);
                                                        com.tencent.tbs.one.impl.a.d.a(fileOutputStream);
                                                        context = context2;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        inputStream = inputStream2;
                                                        com.tencent.tbs.one.impl.a.d.a(inputStream);
                                                        com.tencent.tbs.one.impl.a.d.a(fileOutputStream);
                                                        throw th;
                                                    }
                                                } catch (IOException e16) {
                                                    e = e16;
                                                    StringBuilder sb5 = new StringBuilder("Failed to copy builtin component file from ");
                                                    context = context2;
                                                    sb5.append(aVar3.f374845e);
                                                    sb5.append(" to ");
                                                    sb5.append(file2.getAbsolutePath());
                                                    aVar.a(318, sb5.toString(), e);
                                                    com.tencent.tbs.one.impl.a.d.a(inputStream2);
                                                    com.tencent.tbs.one.impl.a.d.a(fileOutputStream);
                                                    str = aVar3.f374842b;
                                                    if (!TextUtils.isEmpty(str)) {
                                                    }
                                                    i18++;
                                                    context2 = context;
                                                    i3 = 2;
                                                }
                                            } catch (IOException e17) {
                                                e = e17;
                                                fileOutputStream = null;
                                                StringBuilder sb52 = new StringBuilder("Failed to copy builtin component file from ");
                                                context = context2;
                                                sb52.append(aVar3.f374845e);
                                                sb52.append(" to ");
                                                sb52.append(file2.getAbsolutePath());
                                                aVar.a(318, sb52.toString(), e);
                                                com.tencent.tbs.one.impl.a.d.a(inputStream2);
                                                com.tencent.tbs.one.impl.a.d.a(fileOutputStream);
                                                str = aVar3.f374842b;
                                                if (!TextUtils.isEmpty(str)) {
                                                }
                                                i18++;
                                                context2 = context;
                                                i3 = 2;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            inputStream = inputStream2;
                                            fileOutputStream = null;
                                        }
                                    } catch (IOException e18) {
                                        e = e18;
                                        z16 = false;
                                    }
                                } catch (IOException e19) {
                                    e = e19;
                                    z16 = false;
                                    fileOutputStream = null;
                                    inputStream2 = null;
                                } catch (Throwable th7) {
                                    th = th7;
                                    fileOutputStream = null;
                                    inputStream = null;
                                }
                            } else {
                                context = context2;
                                z16 = false;
                                try {
                                    com.tencent.tbs.one.impl.a.d.a(f.a(a17, str3, str4), file2);
                                } catch (IOException e26) {
                                    aVar.a(312, "Failed to copy builtin component file from " + a17.getAbsolutePath() + " to " + file2.getAbsolutePath(), e26);
                                    return;
                                }
                            }
                            str = aVar3.f374842b;
                            if (!TextUtils.isEmpty(str)) {
                                if (messageDigest == null) {
                                    try {
                                        a16 = com.tencent.tbs.one.impl.e.f.a();
                                    } catch (TBSOneException e27) {
                                        aVar.a(e27.getErrorCode(), e27.getMessage(), e27.getCause());
                                        return;
                                    }
                                } else {
                                    a16 = messageDigest;
                                }
                                com.tencent.tbs.one.impl.e.f.a(a16, file2, str);
                                messageDigest = a16;
                            }
                            i18++;
                            context2 = context;
                            i3 = 2;
                        }
                        aVar.a((a) com.tencent.tbs.one.impl.e.e.a(e.a.BUILTIN, file));
                    } catch (IOException e28) {
                        aVar.a(312, "Failed to copy builtin component file from " + a17.getAbsolutePath() + " to " + a18.getAbsolutePath(), e28);
                    }
                } catch (TBSOneException e29) {
                    aVar.a(e29.getErrorCode(), e29.getMessage(), e29.getCause());
                }
            }
        });
    }
}
