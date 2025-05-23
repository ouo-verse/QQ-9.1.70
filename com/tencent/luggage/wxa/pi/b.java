package com.tencent.luggage.wxa.pi;

import android.text.TextUtils;
import com.tencent.luggage.wxa.rb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f137610a;

    /* renamed from: b, reason: collision with root package name */
    public String f137611b;

    /* renamed from: c, reason: collision with root package name */
    public d f137612c;

    /* renamed from: d, reason: collision with root package name */
    public Object f137613d;

    /* renamed from: e, reason: collision with root package name */
    public int f137614e;

    /* renamed from: f, reason: collision with root package name */
    public String f137615f;

    /* renamed from: g, reason: collision with root package name */
    public String f137616g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f137617h;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pi.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6605b {

        /* renamed from: a, reason: collision with root package name */
        public static b f137618a = new b();
    }

    public static b b() {
        return C6605b.f137618a;
    }

    public boolean a(String str, String str2) {
        d b16;
        if (!str2.equalsIgnoreCase("play")) {
            return str.equalsIgnoreCase(this.f137610a) && (b16 = com.tencent.luggage.wxa.rb.a.b()) != null && b16.f139441c.equals(this.f137611b);
        }
        w.d("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", str, this.f137610a);
        return true;
    }

    public String c() {
        return this.f137610a;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        if (!d()) {
            return com.tencent.luggage.wxa.rb.b.c();
        }
        throw null;
    }

    public b() {
        this.f137617h = new HashMap();
    }

    public void b(String str) {
        IListener iListener = (IListener) this.f137617h.remove(str);
        if (iListener == null) {
            w.d("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", str);
        } else {
            iListener.dead();
        }
    }

    public void c(String str) {
        this.f137610a = str;
    }

    public void d(String str) {
        this.f137611b = str;
    }

    public void a(d dVar) {
        this.f137612c = dVar;
        this.f137613d = null;
    }

    public d a() {
        return this.f137612c;
    }

    public void a(String str, int i3, String str2, String str3) {
        this.f137610a = str;
        this.f137614e = i3;
        this.f137615f = str2;
        this.f137616g = str3;
    }

    public void a(IListener iListener, String str) {
        if (this.f137617h.get(str) != null) {
            w.d("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", str);
        } else {
            iListener.alive();
            this.f137617h.put(str, iListener);
        }
    }

    public void a(String str, int i3) {
        IListener iListener = (IListener) this.f137617h.get(str);
        if (iListener == null || i3 != iListener.hashCode()) {
            return;
        }
        w.d("MicroMsg.AppBrandMusicPlayerManager", "remove listener for appid: %s, hash: %d", str, Integer.valueOf(i3));
        this.f137617h.remove(str);
        iListener.dead();
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            w.b("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            return false;
        }
        if (!str.equalsIgnoreCase(c())) {
            w.b("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            return false;
        }
        if (TextUtils.isEmpty(this.f137611b)) {
            w.b("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            return false;
        }
        if (!d()) {
            d b16 = com.tencent.luggage.wxa.rb.a.b();
            if (b16 == null) {
                w.b("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                return false;
            }
            if (!this.f137611b.equalsIgnoreCase(b16.f139441c)) {
                w.b("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                return false;
            }
            if (com.tencent.luggage.wxa.rb.a.c()) {
                return true;
            }
            w.d("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
            return false;
        }
        throw null;
    }
}
