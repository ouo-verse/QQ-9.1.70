package com.tencent.luggage.wxa.p9;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.on.c {

    /* renamed from: d, reason: collision with root package name */
    public a f137441d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f137442a;

        /* renamed from: b, reason: collision with root package name */
        public long f137443b;

        /* renamed from: c, reason: collision with root package name */
        public String f137444c;

        /* renamed from: d, reason: collision with root package name */
        public String f137445d;

        /* renamed from: e, reason: collision with root package name */
        public String f137446e;

        /* renamed from: f, reason: collision with root package name */
        public int f137447f;

        /* renamed from: g, reason: collision with root package name */
        public String f137448g;

        /* renamed from: h, reason: collision with root package name */
        public String f137449h;
    }

    public c() {
        this(null);
    }

    public static String a(int i3) {
        if (i3 == 0 || i3 == 1) {
            return "play";
        }
        if (i3 == 2) {
            return "pause";
        }
        if (i3 == 3) {
            return "stop";
        }
        if (i3 == 4) {
            return "error";
        }
        if (i3 == 5) {
            return "ended";
        }
        if (i3 == 6) {
            return "seeked";
        }
        if (i3 == 7) {
            return "canplay";
        }
        if (i3 == 9) {
            return "waiting";
        }
        if (i3 == 10) {
            return "seeking";
        }
        if (i3 == 11) {
            return "real_play";
        }
        if (i3 == 12) {
            return "mix_play_ready";
        }
        if (i3 == 13) {
            return "preload_end";
        }
        return "";
    }

    public c(Runnable runnable) {
        this.f137441d = new a();
        this.f137056b = false;
        this.f137055a = runnable;
    }
}
