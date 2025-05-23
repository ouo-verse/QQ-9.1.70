package com.tencent.luggage.wxa.jh;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.jh.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mm.libmmwebrtc.MMWebRTCBinding;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.EglBase;
import org.webrtc.GlRectDrawer;
import org.webrtc.IRenderer;
import org.webrtc.PerformanceStatistics;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.TextureViewRenderer;
import org.webrtc.VideoSink;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.ee.b {
    public static final int CTRL_INDEX = 1117;

    @NotNull
    public static final String NAME = "insertWebRTCRendererView";

    /* renamed from: a, reason: collision with root package name */
    public static final a f131148a = new a(null);

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
    /* renamed from: com.tencent.luggage.wxa.jh.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C6341b extends FrameLayout implements com.tencent.luggage.wxa.jh.a {

        /* renamed from: a, reason: collision with root package name */
        public VideoSink f131149a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f131150b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6341b(b bVar, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f131150b = bVar;
        }

        @Override // com.tencent.luggage.wxa.jh.a
        public VideoSink a() {
            return this.f131149a;
        }

        @Nullable
        public final VideoSink getVideoSink() {
            return this.f131149a;
        }

        public final void setVideoSink(@Nullable VideoSink videoSink) {
            this.f131149a = videoSink;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends k0 {
        public static final int CTRL_INDEX = 1120;

        @NotNull
        public static final String NAME = "onWebRTCLoadedMetaData";

        /* renamed from: a, reason: collision with root package name */
        public static final a f131151a = new a(null);

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

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum d {
        Surface,
        Texture
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f131155a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.Surface.ordinal()] = 1;
            iArr[d.Texture.ordinal()] = 2;
            f131155a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f131156a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131157b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f131158c;

        public f(View view, JSONObject jSONObject, com.tencent.luggage.wxa.m4.b bVar) {
            this.f131156a = view;
            this.f131157b = jSONObject;
            this.f131158c = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.a aVar;
            KeyEvent.Callback callback = this.f131156a;
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.webrtc.IWebRTCVideoSinkProvider");
            VideoSink a16 = ((com.tencent.luggage.wxa.jh.a) callback).a();
            if (a16 != null) {
                aVar = com.tencent.luggage.wxa.jh.e.f131173a.a(this.f131157b, a16, this.f131158c, e.b.AddOrUpdate);
                w.d("MicroMsg.JsApiInsertWebRTCRendererView", "hy: webrtc update webrtc video sink with errcode " + aVar);
            } else {
                aVar = null;
            }
            w.d("MicroMsg.JsApiInsertWebRTCRendererView", "hy: webrtc add result is " + aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements RendererCommon.RendererEvents {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f131160b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f131161c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.m4.b f131162a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PerformanceStatistics f131163b;

            public a(com.tencent.luggage.wxa.m4.b bVar, PerformanceStatistics performanceStatistics) {
                this.f131162a = bVar;
                this.f131163b = performanceStatistics;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MMWebRTCBinding E = this.f131162a.y0().g0().E();
                if (E != null) {
                    E.onRenderStats(this.f131163b);
                }
            }
        }

        public g(com.tencent.luggage.wxa.m4.b bVar, int i3) {
            this.f131160b = bVar;
            this.f131161c = i3;
        }

        public void onFirstFrameRendered() {
            b.this.a(this.f131160b, this.f131161c);
        }

        public void onFrameResolutionChanged(int i3, int i16, int i17) {
            w.d("MicroMsg.JsApiInsertWebRTCRendererView", "hy: onFrameResolutionChanged " + i3 + " * " + i16);
        }

        public void onRenderStats(PerformanceStatistics performanceStatistics) {
            j jsRuntime;
            q qVar;
            Intrinsics.checkNotNullParameter(performanceStatistics, "performanceStatistics");
            w.d("MicroMsg.JsApiInsertWebRTCRendererView", "hy: current render stats: " + performanceStatistics);
            com.tencent.luggage.wxa.r4.d y06 = this.f131160b.y0();
            if (y06 != null && (jsRuntime = y06.getJsRuntime()) != null && (qVar = (q) jsRuntime.a(q.class)) != null) {
                qVar.a(new a(this.f131160b, performanceStatistics));
            }
        }
    }

    public void a(com.tencent.luggage.wxa.m4.b bVar, IRenderer renderView, int i3) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public void beforeOperateFromOriginThread(com.tencent.luggage.wxa.xd.d component, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(component, "component");
        ((com.tencent.luggage.wxa.m4.b) component).y0().g0().Y();
    }

    public d e() {
        return d.Texture;
    }

    public final boolean f() {
        try {
            new EglBase.EglBaseStatic();
            return true;
        } catch (ClassNotFoundException unused) {
            w.f("MicroMsg.JsApiInsertWebRTCRendererView", "no webrtc support");
            return false;
        } catch (NoClassDefFoundError unused2) {
            w.f("MicroMsg.JsApiInsertWebRTCRendererView", "no webrtc support");
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public Boolean getUnderView(JSONObject jSONObject) {
        Boolean valueOf;
        if (jSONObject != null) {
            try {
                valueOf = Boolean.valueOf(jSONObject.getBoolean("underGameView"));
            } catch (JSONException unused) {
            }
            w.d("MicroMsg.JsApiInsertWebRTCRendererView", "getUnderView " + valueOf);
            return valueOf;
        }
        valueOf = null;
        w.d("MicroMsg.JsApiInsertWebRTCRendererView", "getUnderView " + valueOf);
        return valueOf;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getInt("viewId");
    }

    @Override // com.tencent.luggage.wxa.ee.b, com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p jsRt) {
        Intrinsics.checkNotNullParameter(jsRt, "jsRt");
        if (f()) {
            super.invoke(dVar, jSONObject, i3, jsRt);
        } else if (dVar != null) {
            dVar.a(i3, "fail:not supported");
        }
    }

    @Override // com.tencent.luggage.wxa.ee.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public View inflateView(com.tencent.luggage.wxa.m4.b bVar, JSONObject jSONObject) {
        if (bVar == null) {
            return null;
        }
        Context context = bVar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "component.context");
        C6341b c6341b = new C6341b(this, context);
        c6341b.setBackgroundColor(-1);
        return c6341b;
    }

    public void a(com.tencent.luggage.wxa.m4.b component, int i3) {
        Intrinsics.checkNotNullParameter(component, "component");
        w.d("MicroMsg.JsApiInsertWebRTCRendererView", "hy: on first frame rendered " + i3);
        new c().setContext(component.y0()).setData("viewId", Integer.valueOf(i3)).dispatch();
    }

    @Override // com.tencent.luggage.wxa.ee.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onInsertView(com.tencent.luggage.wxa.m4.b bVar, int i3, View view, JSONObject jSONObject) {
        TextureViewRenderer surfaceViewRenderer;
        j jsRuntime;
        q qVar;
        w.d("MicroMsg.JsApiInsertWebRTCRendererView", "hy: try insert webrtc view " + i3);
        super.onInsertView(bVar, i3, view, jSONObject);
        if (bVar != null) {
            EglBase create = EglBase.EglBaseStatic.create((EglBase.Context) null, EglBase.CONFIG_PLAIN);
            int i16 = e.f131155a[e().ordinal()];
            if (i16 == 1) {
                surfaceViewRenderer = new SurfaceViewRenderer(bVar.getContext());
            } else {
                if (i16 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                surfaceViewRenderer = new TextureViewRenderer(bVar.getContext());
            }
            Intrinsics.checkNotNull(create);
            surfaceViewRenderer.init(create.getEglBaseContext(), new g(bVar, i3), EglBase.CONFIG_PLAIN, new GlRectDrawer());
            a(bVar, (IRenderer) surfaceViewRenderer, i3);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.webrtc.JsApiInsertWebRTCRendererView.HolderView");
            C6341b c6341b = (C6341b) view;
            c6341b.setVideoSink(surfaceViewRenderer);
            c6341b.addView((View) surfaceViewRenderer, new ViewGroup.LayoutParams(-1, -1));
            com.tencent.luggage.wxa.r4.d y06 = bVar.y0();
            if (y06 == null || (jsRuntime = y06.getJsRuntime()) == null || (qVar = (q) jsRuntime.a(q.class)) == null) {
                return;
            }
            qVar.a(new f(view, jSONObject, bVar));
        }
    }
}
