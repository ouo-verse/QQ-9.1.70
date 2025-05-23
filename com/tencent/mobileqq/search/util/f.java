package com.tencent.mobileqq.search.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f285042a = new f();
    }

    f() {
    }

    @NonNull
    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = URLDecoder.decode(str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static f b() {
        return a.f285042a;
    }

    @NonNull
    public String c() {
        return a(e("search_url_prefix"));
    }

    @NonNull
    public String d() {
        return e("search_url_query_param_key");
    }

    @NonNull
    public String e(String str) {
        return "";
    }
}
