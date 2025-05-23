package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mapsdk.internal.kq;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class kx implements kz {

    /* renamed from: a, reason: collision with root package name */
    static Set<String> f149088a;

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f149089g;

    /* renamed from: b, reason: collision with root package name */
    boolean f149090b;

    /* renamed from: c, reason: collision with root package name */
    private long f149091c;

    /* renamed from: d, reason: collision with root package name */
    private int f149092d;

    /* renamed from: e, reason: collision with root package name */
    private File f149093e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, int[]> f149094f = new HashMap();

    static {
        HashSet hashSet = new HashSet();
        f149088a = hashSet;
        hashSet.add(ky.f149103i);
        f149088a.add("NetManager");
        f149088a.add("asset");
        f149089g = new int[]{2, 3, 4, 5, 6};
    }

    public kx(Context context, TencentMapOptions tencentMapOptions) {
        String[] debugTags;
        this.f149093e = kt.a(new File(mz.a(context, tencentMapOptions).c().getAbsolutePath()), "logs");
        if (tencentMapOptions != null && (debugTags = tencentMapOptions.getDebugTags()) != null) {
            a(debugTags);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void a(String str) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void b(String str) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void c(String str) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void d() {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void e(String str) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void a(String str, Throwable th5) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void b(String str, Throwable th5) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void c(String str, Throwable th5) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void d(String str) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void e(String str, Throwable th5) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void a(boolean z16) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public final boolean b() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void c(String str, String str2) {
        if (a(4, str)) {
            a(4, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void d(String str, Throwable th5) {
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void e(String str, String str2) {
        if (a(6, str)) {
            a(6, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public final boolean a() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void b(String str, String str2) {
        if (a(3, str)) {
            a(3, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void d(String str, String str2) {
        if (a(5, str)) {
            a(5, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public boolean a(int i3, String str) {
        return this.f149094f.containsKey(str) || this.f149090b || (tf.f150437d && !f149088a.contains(str));
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void c(String str, String str2, Throwable th5) {
        if (a(4, str)) {
            a(4, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void e(String str, String str2, Throwable th5) {
        if (a(6, str)) {
            a(6, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void b(String str, String str2, Throwable th5) {
        if (a(3, str)) {
            a(3, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void d(String str, String str2, Throwable th5) {
        if (a(5, str)) {
            a(5, str, str2, th5);
        }
    }

    private static void a(int i3, String str, String str2) {
        a(i3, str, str2, null);
    }

    @Override // com.tencent.mapsdk.internal.kz
    public String c() {
        return this.f149093e.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i3, String str, String str2, Throwable th5) {
        if (th5 != null) {
            switch (i3) {
                case 2:
                    Log.v(str, str2, th5);
                    return;
                case 3:
                    Log.d(str, str2, th5);
                    return;
                case 4:
                    Log.i(str, str2, th5);
                    return;
                case 5:
                    Log.w(str, str2, th5);
                    return;
                case 6:
                    Log.e(str, str2, th5);
                    return;
                case 7:
                    Log.wtf(str, str2, th5);
                    return;
                default:
                    return;
            }
        }
        Log.println(i3, str, str2);
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void a(String str, String str2) {
        if (a(2, str)) {
            a(2, str, str2, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void a(String str, String str2, Throwable th5) {
        if (a(2, str)) {
            a(2, str, str2, th5);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public void a(Context context, kq.a aVar) {
        if (context != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.f149091c;
            if (j3 != 0 && uptimeMillis - j3 >= 400) {
                this.f149092d = 0;
                this.f149091c = 0L;
                this.f149090b = false;
                return;
            }
            this.f149091c = uptimeMillis;
            this.f149092d++;
            String str = "\u89e6\u53d1\u8c03\u8bd5\u6a21\u5f0f" + this.f149092d + "\u6b21";
            int i3 = this.f149092d;
            if (i3 >= 5 && i3 < 10) {
                str = "\u5f00\u53d1\u8005\u8c03\u8bd5\u5728" + (10 - this.f149092d) + "\u6b21\u540e\u5f00\u542f";
                if (aVar != null) {
                    aVar.a(str, 1).b();
                }
            } else if (i3 == 10) {
                this.f149090b = true;
                str = "\u5f00\u53d1\u8005\u8c03\u8bd5\u5df2\u5f00\u542f";
                if (aVar != null) {
                    aVar.a("\u5f00\u53d1\u8005\u8c03\u8bd5\u5df2\u5f00\u542f", 1).b();
                }
            }
            a(5, ky.f149098d, str, null);
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public final void a(String... strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                this.f149094f.remove(str);
                this.f149094f.put(str, f149089g);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.kz
    public final void a(boolean z16, int i3, String... strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                this.f149094f.remove(str);
                if (z16) {
                    this.f149094f.put(str, new int[]{i3});
                }
            }
        }
    }
}
