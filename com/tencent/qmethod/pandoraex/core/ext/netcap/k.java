package com.tencent.qmethod.pandoraex.core.ext.netcap;

import android.content.ClipData;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.qmethod.pandoraex.api.q;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static a f344096a;

    /* renamed from: b, reason: collision with root package name */
    public static LinkedHashSet<String> f344097b = new LinkedHashSet<>();

    /* renamed from: c, reason: collision with root package name */
    public static LinkedHashSet<String> f344098c = new LinkedHashSet<>();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f344099d = false;

    /* renamed from: e, reason: collision with root package name */
    public static HashSet<String> f344100e = new HashSet<>();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        boolean a();

        boolean b(String str, int i3);

        void c(String str, String str2, Map<String, List<String>> map, byte[] bArr, long j3, String str3, String str4, long j16);
    }

    public static boolean a(String str, String str2, String str3, long j3) {
        boolean z16;
        if (!"POST".equals(str) && !HttpPut.METHOD_NAME.equals(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return false;
        }
        if (d(j3)) {
            com.tencent.qmethod.pandoraex.core.o.a("NetworkCaptureHelper", "canParseBody > 1MB " + str2 + " " + j3);
            return false;
        }
        if (str3 == null || !c(str3)) {
            return true;
        }
        com.tencent.qmethod.pandoraex.core.o.a("NetworkCaptureHelper", "canParseBody isFile " + str2);
        return false;
    }

    public static boolean b() {
        a aVar = f344096a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    private static boolean c(String str) {
        String upperCase = str.toUpperCase();
        if (!upperCase.startsWith("multipart") && !upperCase.startsWith("image") && !upperCase.startsWith("video") && !upperCase.startsWith("audio") && !upperCase.startsWith("application/octet-stream") && !upperCase.startsWith("application/zip") && !upperCase.startsWith(MediaType.APPLICATION_PDF_VALUE)) {
            return false;
        }
        return true;
    }

    public static boolean d(long j3) {
        if (j3 > 1048576) {
            return true;
        }
        return false;
    }

    public static void e(String str, String str2, Map<String, List<String>> map, byte[] bArr, long j3, String str3, String str4, long j16) {
        a aVar = f344096a;
        if (aVar != null) {
            aVar.c(str, str2, map, bArr, j3, str3, str4, j16);
        }
    }

    public static void f(Intent intent) {
        if (b()) {
            try {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart)) {
                    LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(f344097b);
                    linkedHashSet.add(schemeSpecificPart);
                    if (linkedHashSet.size() > 8) {
                        linkedHashSet.remove(linkedHashSet.iterator().next());
                    }
                    if (q.m()) {
                        com.tencent.qmethod.pandoraex.core.o.a("NetworkCaptureHelper", "recordBroadcastPkgInfo " + schemeSpecificPart);
                    }
                    f344097b = linkedHashSet;
                }
            } catch (Throwable th5) {
                com.tencent.qmethod.pandoraex.core.o.b("NetworkCaptureHelper", "recordBroadcastPkgInfo", th5);
            }
        }
    }

    public static void g(ClipData clipData) {
        if (clipData != null && b() && f344099d) {
            try {
                int itemCount = clipData.getItemCount();
                for (int i3 = 0; i3 < itemCount; i3++) {
                    i(clipData.getItemAt(i3).getText().toString());
                }
            } catch (Throwable th5) {
                com.tencent.qmethod.pandoraex.core.o.d("NetworkCaptureHelper", "recordClipBoard", th5);
            }
        }
    }

    public static void h(CharSequence charSequence) {
        if (charSequence != null && b()) {
            try {
                i(charSequence.toString());
            } catch (Throwable th5) {
                com.tencent.qmethod.pandoraex.core.o.d("NetworkCaptureHelper", "recordClipBoard", th5);
            }
        }
    }

    private static void i(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(f344100e);
        linkedHashSet.add(str);
        if (linkedHashSet.size() > 8) {
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        f344100e = linkedHashSet;
    }

    public static void j(String str) {
        if (b()) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(f344098c);
                    linkedHashSet.add(str);
                    if (linkedHashSet.size() > 8) {
                        linkedHashSet.remove(linkedHashSet.iterator().next());
                    }
                    if (q.m()) {
                        com.tencent.qmethod.pandoraex.core.o.a("NetworkCaptureHelper", "recordPackageName " + str);
                    }
                    f344098c = linkedHashSet;
                }
            } catch (Throwable th5) {
                com.tencent.qmethod.pandoraex.core.o.b("NetworkCaptureHelper", "recordPackageName", th5);
            }
        }
    }

    public static boolean k(String str, int i3) {
        a aVar = f344096a;
        if (aVar != null) {
            return aVar.b(str, i3);
        }
        return false;
    }

    public static void l(a aVar) {
        f344096a = aVar;
    }
}
