package com.tencent.biz.pubaccount.weishi.report;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f81487a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f81488a = new c();
    }

    c() {
    }

    public static c b() {
        return a.f81488a;
    }

    public void a() {
        this.f81487a.clear();
    }

    public String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f81487a.get(str);
        }
        return "";
    }

    public void d(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return;
        }
        this.f81487a.put(str, new Gson().toJson(map));
    }
}
