package com.tencent.luggage.wxa.jh;

import android.view.KeyEvent;
import android.view.View;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.jh.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.webrtc.VideoSink;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.ee.c {
    public static final int CTRL_INDEX = 1118;

    @NotNull
    public static final String NAME = "removeWebRTCRendererView";

    /* renamed from: b, reason: collision with root package name */
    public static final a f131164b = new a(null);

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
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f131165a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131166b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f131167c;

        public b(View view, JSONObject jSONObject, com.tencent.luggage.wxa.m4.b bVar) {
            this.f131165a = view;
            this.f131166b = jSONObject;
            this.f131167c = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.a aVar;
            KeyEvent.Callback callback = this.f131165a;
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.webrtc.IWebRTCVideoSinkProvider");
            VideoSink a16 = ((com.tencent.luggage.wxa.jh.a) callback).a();
            if (a16 != null) {
                aVar = e.f131173a.a(this.f131166b, a16, this.f131167c, e.b.Remove);
                w.d("MicroMsg.JsApiRemoveWebRTCRendererView", "hy: webrtc update webrtc video sink with errcode " + aVar);
            } else {
                aVar = null;
            }
            w.d("MicroMsg.JsApiRemoveWebRTCRendererView", "hy: webrtc remove result is " + aVar);
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.m4.b bVar, int i3, View view, JSONObject jSONObject) {
        com.tencent.luggage.wxa.r4.d y06;
        j jsRuntime;
        q qVar;
        w.d("MicroMsg.JsApiRemoveWebRTCRendererView", "hy: try remove webrtc view " + i3);
        if (bVar != null && (y06 = bVar.y0()) != null && (jsRuntime = y06.getJsRuntime()) != null && (qVar = (q) jsRuntime.a(q.class)) != null) {
            qVar.a(new b(view, jSONObject, bVar));
        }
        return super.a((f) bVar, i3, view, jSONObject);
    }
}
