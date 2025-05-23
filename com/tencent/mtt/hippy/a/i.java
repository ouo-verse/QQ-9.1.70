package com.tencent.mtt.hippy.a;

import android.content.SharedPreferences;
import com.tencent.mtt.hippy.utils.ContextHolder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    boolean f336969a = false;

    /* renamed from: b, reason: collision with root package name */
    final SharedPreferences f336970b = ContextHolder.getAppContext().getSharedPreferences("hippydebugpref", 0);

    /* renamed from: c, reason: collision with root package name */
    private final String f336971c;

    /* renamed from: d, reason: collision with root package name */
    private final String f336972d;

    public i(String str, String str2) {
        this.f336971c = str;
        this.f336972d = str2;
    }

    public String a() {
        return this.f336971c;
    }

    public String b() {
        return this.f336972d;
    }

    public boolean c() {
        return this.f336970b.getBoolean("js_remote_debug", false);
    }

    public boolean d() {
        return this.f336969a;
    }
}
