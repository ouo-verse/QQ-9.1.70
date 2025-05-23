package com.tencent.luggage.wxa.se;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.se.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.magicbrush.ui.g;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.ee.b {
    public static final int CTRL_INDEX = 594;

    @NotNull
    public static final String NAME = "insertWebGLCanvas";

    /* renamed from: c, reason: collision with root package name */
    public static final a f140306c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f140307a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public boolean f140308b;

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
    public static final class c implements g.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f140313a;

        public c(b bVar) {
            this.f140313a = bVar;
        }

        @Override // com.tencent.magicbrush.ui.g.f
        public void a() {
            this.f140313a.a(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements g.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f140314a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f140315b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.magicbrush.b f140316c;

        public d(com.tencent.luggage.wxa.m4.b bVar, int i3, com.tencent.magicbrush.b bVar2) {
            this.f140314a = bVar;
            this.f140315b = i3;
            this.f140316c = bVar2;
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public final void onForeground() {
            w.d("JsApiInsertHTMLCanvasElement", com.tencent.mobileqq.msf.core.net.r.a.f248963o);
            a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
            String appId = this.f140314a.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
            com.tencent.luggage.wxa.se.a a16 = bVar.a(appId);
            a16.c(this.f140315b);
            if (a16.b() == 1) {
                this.f140316c.m();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements g.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f140317a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f140318b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.magicbrush.b f140319c;

        public e(com.tencent.luggage.wxa.m4.b bVar, int i3, com.tencent.magicbrush.b bVar2) {
            this.f140317a = bVar;
            this.f140318b = i3;
            this.f140319c = bVar2;
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public final void onBackground() {
            w.d("JsApiInsertHTMLCanvasElement", "background");
            if (this.f140317a.getRuntime().t0()) {
                return;
            }
            a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
            String appId = this.f140317a.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
            com.tencent.luggage.wxa.se.a a16 = bVar.a(appId);
            a16.a(this.f140318b);
            if (a16.b() == 0) {
                this.f140319c.l();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public boolean enableGesture() {
        return this.f140308b;
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public boolean enableLongClick() {
        return this.f140308b;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getInt("canvasId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public boolean isAsyncCallback() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public View inflateView(com.tencent.luggage.wxa.m4.b component, JSONObject data, int i3) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(data, "data");
        w.d("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + i3 + "] [" + data + ']');
        com.tencent.luggage.wxa.r4.d y06 = component.y0();
        com.tencent.luggage.wxa.w1.c cVar = y06 != null ? (com.tencent.luggage.wxa.w1.c) y06.h(com.tencent.luggage.wxa.w1.c.class) : null;
        if (cVar == null) {
            w.f("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
            return null;
        }
        com.tencent.magicbrush.b n3 = cVar.n();
        if (n3 == null) {
            return null;
        }
        this.f140308b = data.optBoolean("scrollSupportedTouchEvent", false);
        b bVar = new b(i3);
        this.f140307a.put(Integer.valueOf(i3), bVar);
        Context context = component.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "component.context");
        com.tencent.magicbrush.ui.g gVar = new com.tencent.magicbrush.ui.g(context, g.h.f147524b);
        gVar.setMagicBrush(n3);
        gVar.getPreparedListeners().a(new c(bVar));
        if (data.optBoolean("transparentBackground", false)) {
            gVar.setOpaque(false);
        }
        a.b bVar2 = com.tencent.luggage.wxa.se.a.f140284c;
        String appId = component.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
        bVar2.a(appId).a(i3, gVar);
        if (this.f140308b) {
            gVar.setEnableTouchEvent(false);
        }
        component.b(new d(component, i3, n3));
        if (component.M0()) {
            String appId2 = component.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId2, "component.appId");
            com.tencent.luggage.wxa.se.a a16 = bVar2.a(appId2);
            a16.c(i3);
            if (a16.b() == 1) {
                n3.m();
            }
        }
        component.a(new e(component, i3, n3));
        return new com.tencent.luggage.wxa.ye.b(component.getContext(), gVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f140309a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f140310b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.ee.j f140311c;

        public b(int i3) {
            this.f140309a = i3;
        }

        public final void a(boolean z16) {
            if (z16) {
                this.f140310b = z16;
                if (this.f140311c != null) {
                    a();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void a(com.tencent.luggage.wxa.ee.j jVar) {
            if (jVar != null) {
                this.f140311c = jVar;
                if (this.f140310b) {
                    a();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void a() {
            if (this.f140310b) {
                com.tencent.luggage.wxa.ee.j jVar = this.f140311c;
                Intrinsics.checkNotNull(jVar);
                jVar.a(h.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                h.this.f140307a.remove(Integer.valueOf(this.f140309a));
                w.d("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.f140309a + ']');
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // com.tencent.luggage.wxa.ee.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onInsertViewWithAsyncCallback(com.tencent.luggage.wxa.m4.b component, int i3, View view, JSONObject data, com.tencent.luggage.wxa.ee.j callback) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object obj = this.f140307a.get(Integer.valueOf(i3));
        Intrinsics.checkNotNull(obj);
        ((b) obj).a(callback);
    }
}
