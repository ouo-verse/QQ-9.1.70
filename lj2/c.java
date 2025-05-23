package lj2;

import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f414876a;

    /* renamed from: b, reason: collision with root package name */
    protected static final String f414877b;

    /* renamed from: c, reason: collision with root package name */
    protected static final String f414878c = com.tencent.mobileqq.qqvideoedit.a.c().getFilesDir().getParent();

    /* renamed from: d, reason: collision with root package name */
    protected static final String f414879d;

    /* renamed from: e, reason: collision with root package name */
    protected static final String f414880e;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f414881a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f414882b;

        /* renamed from: c, reason: collision with root package name */
        public static final String f414883c;

        static {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c.f414880e);
            String str = File.separator;
            sb5.append(str);
            sb5.append("video");
            f414881a = sb5.toString();
            f414882b = c.f414877b + str + "video";
            f414883c = c.f414876a + str + "video";
        }
    }

    static {
        boolean z16;
        if (com.tencent.mobileqq.qqvideoedit.a.c().getExternalFilesDir(null) != null && com.tencent.mobileqq.qqvideoedit.a.c().getExternalCacheDir() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f414877b = com.tencent.mobileqq.qqvideoedit.a.c().getExternalFilesDir(null).getPath();
            f414876a = com.tencent.mobileqq.qqvideoedit.a.c().getExternalCacheDir().getPath();
        } else {
            f414877b = com.tencent.mobileqq.qqvideoedit.a.c().getFilesDir().getPath();
            f414876a = com.tencent.mobileqq.qqvideoedit.a.c().getCacheDir().getPath();
        }
        f414880e = com.tencent.mobileqq.qqvideoedit.a.c().getFilesDir().getPath();
        f414879d = com.tencent.mobileqq.qqvideoedit.a.c().getCacheDir().getPath();
    }
}
