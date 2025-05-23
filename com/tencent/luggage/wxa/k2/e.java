package com.tencent.luggage.wxa.k2;

import android.os.Parcel;
import com.tencent.luggage.wxa.k2.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends d {
    public static final int CTRL_INDEX = 1317;

    @NotNull
    public static final String NAME = "setTingAudioState";

    /* renamed from: b, reason: collision with root package name */
    public static final a f131424b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final String f131425c = "MicroMsg.Music.JsApiSetTingAudioState";

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
    public static final class b extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask {
        public b(@Nullable Parcel parcel) {
            super(parcel);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        
            if (r0 != 4) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask, com.tencent.luggage.wxa.wd.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g() {
            int i3;
            boolean z16;
            if (this.f152032e == null) {
                w.b(e.f131425c, "service is null, don't callback");
                return;
            }
            a(this.f152039l);
            int i16 = this.f152039l;
            if (i16 != 7) {
                if (i16 != 13) {
                    if (i16 != 14) {
                        if (i16 != 0 && i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                }
                            }
                        } else {
                            com.tencent.luggage.wxa.ic.e.a(this.f152037j, this.f152030c);
                            com.tencent.luggage.wxa.pi.a.f137604c.b(this.f152037j);
                        }
                        i3 = this.f152039l;
                        if (1 != i3) {
                            com.tencent.luggage.wxa.pi.a.f137604c.a(i3);
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        w.d(e.f131425c, "runInClientProcess callback action:%d, retJson:%s", Integer.valueOf(this.f152039l), this.f152038k);
                        new c.d().setContext(this.f152032e).setData(this.f152038k).dispatch();
                        if (z16) {
                            com.tencent.luggage.wxa.pi.a.f137604c.a(this.f152039l);
                            return;
                        }
                        return;
                    }
                    c.b.f131419a.a(this.f152032e);
                    return;
                }
                c.C6354c.f131421a.a(this.f152032e);
                return;
            }
            com.tencent.luggage.wxa.ic.e.b(this.f152037j, this.f152030c);
            i3 = this.f152039l;
            if (1 != i3) {
            }
            w.d(e.f131425c, "runInClientProcess callback action:%d, retJson:%s", Integer.valueOf(this.f152039l), this.f152038k);
            new c.d().setContext(this.f152032e).setData(this.f152038k).dispatch();
            if (z16) {
            }
        }

        public b(@Nullable com.tencent.luggage.wxa.xd.a aVar, @Nullable com.tencent.luggage.wxa.xd.d dVar, int i3) {
            super(aVar, dVar, i3);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
    public JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        return new b(aVar, dVar, i3);
    }
}
