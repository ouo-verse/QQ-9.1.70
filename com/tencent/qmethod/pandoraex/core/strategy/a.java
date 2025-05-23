package com.tencent.qmethod.pandoraex.core.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.qmethod.pandoraex.api.g;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.strategy.CacheStrategyFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements g {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f344157b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f344158c;

    /* renamed from: d, reason: collision with root package name */
    private static String f344159d;

    /* renamed from: a, reason: collision with root package name */
    private MMKV f344160a;

    public static a p(Context context) {
        if (f344158c == null) {
            synchronized (a.class) {
                if (f344158c == null) {
                    a aVar = new a();
                    if (aVar.t(context)) {
                        f344158c = aVar;
                        f344158c.v(context);
                    }
                }
            }
        }
        return f344158c;
    }

    private static void q(Context context) {
        if (f344158c == null) {
            o.a("MMKVStrategy", "not initialized MMKV yet");
            return;
        }
        SharedPreferences f16 = c.f(context);
        f344158c.f344160a.S(f16);
        f16.edit().clear().commit();
    }

    public static void r(Context context, boolean z16) {
        p(context);
        if (z16) {
            q(context);
        }
    }

    public static void s(Context context, boolean z16, String str) {
        f344159d = str;
        r(context, z16);
    }

    private boolean t(Context context) {
        MMKVLogLevel mMKVLogLevel;
        if (context == null) {
            o.a("MMKVStrategy", "initMMKV when context null");
            return false;
        }
        if (f344157b.compareAndSet(false, true)) {
            try {
                boolean z16 = q.f343925a;
                String str = f344159d;
                if (TextUtils.isEmpty(str)) {
                    str = context.getFilesDir().getAbsolutePath() + "/mmkv";
                }
                String V = MMKV.V(str);
                if (q.m()) {
                    mMKVLogLevel = MMKVLogLevel.LevelInfo;
                } else {
                    mMKVLogLevel = MMKVLogLevel.LevelError;
                }
                MMKV.g0(mMKVLogLevel);
                o.a("MMKVStrategy", "initMMKV at: " + V);
            } catch (Exception e16) {
                o.d("MMKVStrategy", "initMMKV error ", e16);
                f344157b.set(false);
            }
            if (f344157b.get()) {
                this.f344160a = MMKV.a0("Pandora", 2);
            }
        }
        return true;
    }

    private boolean u() {
        if (this.f344160a != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public String a(Context context, String str) {
        if (!u()) {
            return "";
        }
        return this.f344160a.q(str, "");
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Integer b(Context context, String str) {
        int i3;
        if (u()) {
            i3 = this.f344160a.j(str);
        } else {
            i3 = 0;
        }
        return Integer.valueOf(i3);
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean c(Context context, String str, Long l3) {
        if (u()) {
            this.f344160a.F(str, l3.longValue());
            return true;
        }
        o.a("MMKVStrategy", "mmkv not init");
        return false;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean d(Context context, String str, String str2) {
        if (u()) {
            this.f344160a.J(str, str2);
            return true;
        }
        o.a("MMKVStrategy", "mmkv not init");
        return false;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean e(Context context, String str, Integer num) {
        if (u()) {
            this.f344160a.D(str, num.intValue());
            return true;
        }
        o.a("MMKVStrategy", "mmkv not init");
        return false;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Long f(Context context, String str) {
        long j3;
        if (u()) {
            j3 = this.f344160a.l(str);
        } else {
            j3 = 0;
        }
        return Long.valueOf(j3);
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Boolean g(Context context, String str) {
        boolean z16;
        if (u()) {
            z16 = this.f344160a.d(str);
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public <T extends Parcelable> T h(Context context, String str, Class<T> cls) {
        if (u()) {
            try {
                return (T) this.f344160a.n(str, cls);
            } catch (Exception e16) {
                o.d("MMKVStrategy", "getParcelable:", e16);
            }
        }
        return null;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean i(Context context, String str, Parcelable parcelable) {
        if (u()) {
            this.f344160a.H(str, parcelable);
            return true;
        }
        o.a("MMKVStrategy", "mmkv not init");
        return false;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public void j(Context context, String str) {
        if (u()) {
            this.f344160a.remove(str);
        } else {
            o.a("MMKVStrategy", "mmkv not init");
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public void k(Context context) {
        if (u()) {
            this.f344160a.clear();
        } else {
            o.a("MMKVStrategy", "mmkv not init");
        }
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public <T> List<T> l(Context context, String str, Class<T> cls) {
        if (u()) {
            String p16 = this.f344160a.p(str);
            ArrayList arrayList = new ArrayList();
            if (p16 != null) {
                try {
                    Gson create = new GsonBuilder().registerTypeAdapter(CharSequence.class, new CacheStrategyFactory.CharSequenceAdapter()).create();
                    Iterator<JsonElement> it = new JsonParser().parse(p16).getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        arrayList.add(create.fromJson(it.next(), (Class) cls));
                    }
                } catch (Exception e16) {
                    o.d("MMKVStrategy", "gson fromJson error:", e16);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public Boolean m(Context context, String str) {
        boolean z16;
        if (u()) {
            z16 = this.f344160a.contains(str);
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public boolean n(Context context, String str, Boolean bool) {
        if (u()) {
            this.f344160a.N(str, bool.booleanValue());
            return true;
        }
        o.a("MMKVStrategy", "mmkv not init");
        return false;
    }

    @Override // com.tencent.qmethod.pandoraex.api.g
    public <T> boolean o(Context context, String str, List<T> list) {
        if (u()) {
            this.f344160a.J(str, new Gson().toJson(list));
            return true;
        }
        o.a("MMKVStrategy", "mmkv not init");
        return false;
    }

    public void v(Context context) {
        if (!this.f344160a.contains("version")) {
            this.f344160a.clear();
            this.f344160a.J("version", "2");
            o.a("MMKVStrategy", "OnUpdate: first no version");
            return;
        }
        String p16 = this.f344160a.p("version");
        if (!"2".equals(p16)) {
            this.f344160a.clear();
            this.f344160a.J("version", "2");
            o.a("MMKVStrategy", "OnUpdate: old version is " + p16 + " new version is 2");
        }
    }
}
