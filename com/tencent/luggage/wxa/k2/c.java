package com.tencent.luggage.wxa.k2;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.mm.plugin.appbrand.jsapi.audio.b {
    public static final int CTRL_INDEX = 1319;

    @NotNull
    public static final String NAME = "operateTingAudio";

    /* renamed from: b, reason: collision with root package name */
    public static final a f131418b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends k0 {
        private static final int CTRL_INDEX = 1325;

        @NotNull
        private static final String NAME = "onTingAudioNext";

        /* renamed from: a, reason: collision with root package name */
        public static final a f131419a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        public static final b f131420b = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final synchronized void a(com.tencent.luggage.wxa.xd.d dVar) {
                w.d("MicroMsg.Music.JsApiOperateTingAudio", b.NAME);
                b.f131420b.setContext(dVar).dispatch();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k2.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6354c extends k0 {
        private static final int CTRL_INDEX = 1324;

        @NotNull
        private static final String NAME = "onTingAudioPrev";

        /* renamed from: a, reason: collision with root package name */
        public static final a f131421a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        public static final C6354c f131422b = new C6354c();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.k2.c$c$a */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final synchronized void a(com.tencent.luggage.wxa.xd.d dVar) {
                w.d("MicroMsg.Music.JsApiOperateTingAudio", C6354c.NAME);
                C6354c.f131422b.setContext(dVar).dispatch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends k0 {
        private static final int CTRL_INDEX = 1323;

        @NotNull
        private static final String NAME = "onTingAudioStateChange";

        /* renamed from: a, reason: collision with root package name */
        public static final a f131423a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
