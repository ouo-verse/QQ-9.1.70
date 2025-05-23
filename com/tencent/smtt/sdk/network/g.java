package com.tencent.smtt.sdk.network;

import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private static g f369458a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f369459b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f369460c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private Object f369461d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<String> f369462e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<String> f369463f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private Object f369464g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<String> f369465h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private Object f369466i = new Object();

    g() {
        String[] interceptURL = InterceptConfig.getInterceptURL();
        if (interceptURL != null) {
            for (String str : interceptURL) {
                b(str);
            }
        }
        String[] excludeInterceptURLPostfix = InterceptConfig.getExcludeInterceptURLPostfix();
        if (excludeInterceptURLPostfix != null) {
            for (String str2 : excludeInterceptURLPostfix) {
                c(str2);
            }
        }
    }

    public static g a() {
        g gVar = f369458a;
        if (gVar != null) {
            return gVar;
        }
        synchronized (g.class) {
            if (f369458a == null) {
                f369458a = new g();
            }
        }
        return f369458a;
    }

    private boolean f(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith("loc?c=1&mars=0&obs=1")) {
            return false;
        }
        f.a("isLbsUrl " + str);
        return true;
    }

    private boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String path = new URL(str).getPath();
            if (TextUtils.isEmpty(path)) {
                return false;
            }
            String lowerCase = path.toLowerCase();
            synchronized (this.f369466i) {
                int size = this.f369465h.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (lowerCase.endsWith(this.f369465h.get(i3))) {
                        f.a("isExcludeInterceptUrlPostfix mExcludeInterceptUrlPostfixList contains " + str);
                        return true;
                    }
                }
                return false;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f369461d) {
            if (str.endsWith("*")) {
                String substring = str.substring(0, str.length() - 1);
                if (!this.f369460c.contains(substring)) {
                    f.a("addInterceptUrl: add prefix match url:" + substring);
                    this.f369460c.add(substring);
                }
            } else if (!this.f369459b.contains(str)) {
                f.a("addInterceptUrl: url=" + str);
                this.f369459b.add(str);
            }
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        synchronized (this.f369466i) {
            if (!this.f369465h.contains(lowerCase)) {
                f.a("addExcludeInterceptUrlPostfix: add urlPostfix :" + lowerCase);
                this.f369465h.add(lowerCase);
            }
        }
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str) || e(str)) {
            return false;
        }
        if (f(str)) {
            return true;
        }
        synchronized (this.f369461d) {
            if (this.f369459b.contains(str)) {
                f.a("shouldIntercept mInterceptUrlList contains " + str);
                return true;
            }
            int size = this.f369460c.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (str.startsWith(this.f369460c.get(i3))) {
                    f.a("shouldIntercept mInterceptUrlPrefixList contains " + str);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.f369464g) {
            if (this.f369462e.contains(str)) {
                f.a("isExcludeInterceptUrl mExcludeInterceptUrlList contains " + str);
                return true;
            }
            int size = this.f369463f.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (str.startsWith(this.f369463f.get(i3))) {
                    f.a("isExcludeInterceptUrl mExcludeInterceptUrlPrefixList contains " + str);
                    return true;
                }
            }
            return g(str);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f369464g) {
            if (str.endsWith("*")) {
                String substring = str.substring(0, str.length() - 1);
                if (!this.f369463f.contains(substring)) {
                    f.a("excludeInterceptUrl: exclude prefix match url:" + substring);
                    this.f369463f.add(substring);
                }
            } else if (!this.f369462e.contains(str)) {
                f.a("excludeInterceptUrl: url=" + str);
                this.f369462e.add(str);
            }
        }
    }
}
