package com.tencent.luggage.wxa.p004if;

import android.content.Context;
import android.media.AudioManager;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioFocusRequestCompat;
import androidx.media.AudioManagerCompat;
import com.tencent.luggage.wxa.tn.w;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c0 extends d0 {

    /* renamed from: h, reason: collision with root package name */
    public static final a f130180h = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final String f130181d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f130182e;

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f130183f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f130184g;

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
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f130185a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c0 f130186b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, c0 c0Var) {
            super(0);
            this.f130185a = context;
            this.f130186b = c0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AudioManager invoke() {
            AudioManager audioManager;
            Object systemService = this.f130185a.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                audioManager = (AudioManager) systemService;
            } else {
                audioManager = null;
            }
            c0 c0Var = this.f130186b;
            if (audioManager == null) {
                w.b(c0Var.c(), "audioManager is null");
            }
            return audioManager;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AudioFocusRequestCompat invoke() {
            return new AudioFocusRequestCompat.Builder(2).setAudioAttributes(new AudioAttributesCompat.Builder().setUsage(1).setLegacyStreamType(3).build()).setOnAudioFocusChangeListener(c0.this.l()).build();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function0 {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements AudioManager.OnAudioFocusChangeListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0 f130189a;

            public a(c0 c0Var) {
                this.f130189a = c0Var;
            }

            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i3) {
                w.d(this.f130189a.c(), "onAudioFocusChange, focusChange: " + i3);
                if (i3 != -3 && i3 != -2) {
                    if (i3 != -1) {
                        if (i3 == 1) {
                            this.f130189a.f();
                            return;
                        }
                        return;
                    }
                    this.f130189a.h();
                    return;
                }
                this.f130189a.d();
            }
        }

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AudioManager.OnAudioFocusChangeListener invoke() {
            return new a(c0.this);
        }
    }

    public c0(Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f130181d = "MicroMsg.WxaAudioFocusService#" + hashCode();
        lazy = LazyKt__LazyJVMKt.lazy(new b(context, this));
        this.f130182e = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new d());
        this.f130183f = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new c());
        this.f130184g = lazy3;
    }

    @Override // com.tencent.luggage.wxa.p004if.d0
    public String c() {
        return this.f130181d;
    }

    @Override // com.tencent.luggage.wxa.p004if.d0
    public boolean i() {
        if (j() == null) {
            return false;
        }
        AudioManager j3 = j();
        Intrinsics.checkNotNull(j3);
        if (1 != AudioManagerCompat.requestAudioFocus(j3, k())) {
            return false;
        }
        return true;
    }

    public final AudioManager j() {
        return (AudioManager) this.f130182e.getValue();
    }

    public final AudioFocusRequestCompat k() {
        return (AudioFocusRequestCompat) this.f130184g.getValue();
    }

    public final AudioManager.OnAudioFocusChangeListener l() {
        return (AudioManager.OnAudioFocusChangeListener) this.f130183f.getValue();
    }

    @Override // com.tencent.luggage.wxa.p004if.d0
    public boolean a() {
        if (j() == null) {
            return false;
        }
        AudioManager j3 = j();
        Intrinsics.checkNotNull(j3);
        return 1 == AudioManagerCompat.abandonAudioFocusRequest(j3, k());
    }
}
