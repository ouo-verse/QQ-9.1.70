package com.tencent.mobileqq.wink.utils;

import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGFont;

/* compiled from: P */
/* loaded from: classes21.dex */
public class w {

    /* renamed from: c, reason: collision with root package name */
    private static final String f326729c = "w";

    /* renamed from: d, reason: collision with root package name */
    private static volatile w f326730d;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, PAGFont> f326731a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f326732b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f326733a;

        /* renamed from: b, reason: collision with root package name */
        public String f326734b;

        /* renamed from: c, reason: collision with root package name */
        public String f326735c;

        /* renamed from: d, reason: collision with root package name */
        public String f326736d;

        public a(String str, String str2, String str3, String str4) {
            this.f326733a = str;
            this.f326734b = str2;
            this.f326735c = str3;
            this.f326736d = str4;
        }
    }

    w() {
        this.f326731a = null;
        this.f326731a = new LruCache<>(10);
    }

    private void a() {
        if (this.f326731a == null) {
            this.f326731a = new LruCache<>(10);
        }
    }

    public static w e() {
        if (f326730d == null) {
            synchronized (w.class) {
                if (f326730d == null) {
                    f326730d = new w();
                }
            }
        }
        return f326730d;
    }

    private boolean f(String str) {
        PAGFont RegisterFont;
        if (!com.tencent.mobileqq.wink.l.d()) {
            return false;
        }
        a();
        if (str == null) {
            return false;
        }
        if (this.f326731a.get(str) != null) {
            return true;
        }
        if (!new File(str).exists() || (RegisterFont = PAGFont.RegisterFont(str)) == null) {
            return false;
        }
        this.f326731a.put(str, RegisterFont);
        return true;
    }

    public PAGFont b(String str, String str2) {
        if (f(str)) {
            PAGFont pAGFont = this.f326731a.get(str);
            if (pAGFont != null) {
                this.f326732b.add(new a(str2, pAGFont.fontFamily, pAGFont.fontStyle, str));
            }
            return pAGFont;
        }
        return null;
    }

    public String c(String str) {
        for (a aVar : this.f326732b) {
            String str2 = aVar.f326734b;
            if (str2 != null && str2.equals(str)) {
                w53.b.a(f326729c, "getFontIdByFamily " + str + " :" + aVar.f326733a);
                return aVar.f326733a;
            }
        }
        w53.b.a(f326729c, "getFontIdByFamily " + str + " : null");
        return null;
    }

    public a d(String str) {
        for (a aVar : this.f326732b) {
            String str2 = aVar.f326734b;
            if (str2 != null && str2.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
