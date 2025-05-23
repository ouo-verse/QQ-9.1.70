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
public class d extends com.tencent.luggage.wxa.ee.d {
    public static final int CTRL_INDEX = 1119;

    @NotNull
    public static final String NAME = "updateWebRTCRendererView";

    /* renamed from: b, reason: collision with root package name */
    public static final a f131168b = new a(null);

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
        public final /* synthetic */ View f131169a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131170b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f131171c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f131172d;

        public b(View view, JSONObject jSONObject, com.tencent.luggage.wxa.m4.b bVar, d dVar) {
            this.f131169a = view;
            this.f131170b = jSONObject;
            this.f131171c = bVar;
            this.f131172d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.a aVar;
            KeyEvent.Callback callback = this.f131169a;
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.webrtc.IWebRTCVideoSinkProvider");
            VideoSink a16 = ((com.tencent.luggage.wxa.jh.a) callback).a();
            if (a16 != null) {
                JSONObject jSONObject = this.f131170b;
                com.tencent.luggage.wxa.m4.b bVar = this.f131171c;
                d dVar = this.f131172d;
                aVar = e.f131173a.a(jSONObject, a16, bVar, e.b.AddOrUpdate);
                w.d("MicroMsg.JsApiUpdateWebRTCRendererView", "hy: webrtc update webrtc video sink with errcode " + aVar);
                dVar.a(bVar, a16, aVar, jSONObject);
            } else {
                aVar = null;
            }
            w.d("MicroMsg.JsApiUpdateWebRTCRendererView", "hy: webrtc remove result is " + aVar);
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d appBrandComponent, VideoSink videoSink, e.a videoSinkErrCode, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(appBrandComponent, "appBrandComponent");
        Intrinsics.checkNotNullParameter(videoSink, "videoSink");
        Intrinsics.checkNotNullParameter(videoSinkErrCode, "videoSinkErrCode");
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.m4.b bVar, int i3, View view, JSONObject jSONObject) {
        com.tencent.luggage.wxa.r4.d y06;
        j jsRuntime;
        q qVar;
        w.d("MicroMsg.JsApiUpdateWebRTCRendererView", "hy: try update webrtc view " + i3);
        if (bVar != null && (y06 = bVar.y0()) != null && (jsRuntime = y06.getJsRuntime()) != null && (qVar = (q) jsRuntime.a(q.class)) != null) {
            qVar.a(new b(view, jSONObject, bVar, this));
        }
        return super.a((f) bVar, i3, view, jSONObject);
    }
}
