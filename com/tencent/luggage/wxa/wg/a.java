package com.tencent.luggage.wxa.wg;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.kj.f1;
import com.tencent.luggage.wxa.mg.a;
import com.tencent.luggage.wxa.mg.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.ee.b {
    public static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6884a implements f1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.mg.a f144232a;

        public C6884a(com.tencent.luggage.wxa.mg.a aVar) {
            this.f144232a = aVar;
        }

        @Override // com.tencent.luggage.wxa.kj.f1
        public void onExitFullscreen() {
            this.f144232a.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f144234a = null;

        public b() {
        }

        public void a(Runnable runnable) {
            this.f144234a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f144234a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements a.p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f144236a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f144237b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f144238c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f1 f144239d;

        public c(com.tencent.luggage.wxa.xd.f fVar, boolean z16, int i3, f1 f1Var) {
            this.f144236a = fVar;
            this.f144237b = z16;
            this.f144238c = i3;
            this.f144239d = f1Var;
        }

        @Override // com.tencent.luggage.wxa.mg.a.p
        public void enterFullScreen(int i3) {
            this.f144236a.a(this.f144237b).a(this.f144238c, this.f144239d, i3);
        }

        @Override // com.tencent.luggage.wxa.mg.a.p
        public boolean isFullScreen() {
            return this.f144236a.a(this.f144237b).a(this.f144238c);
        }

        @Override // com.tencent.luggage.wxa.mg.a.p
        public void quitFullScreen() {
            this.f144236a.a(this.f144237b).e(this.f144238c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f144241a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g.d f144242b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g.c f144243c;

        public d(g.b bVar, g.d dVar, g.c cVar) {
            this.f144241a = bVar;
            this.f144242b = dVar;
            this.f144243c = cVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            super.onDestroy();
            this.f144243c.onDestroy();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            super.onPause(dVar);
            this.f144241a.onBackground();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            super.onResume();
            this.f144242b.onForeground();
        }
    }

    public static int b(String str) {
        int i3;
        if (!TextUtils.isEmpty(str)) {
            i3 = 0;
            for (String str2 : str.split(",")) {
                if ("supportSoftDecode".equals(str2.trim())) {
                    i3 |= 1;
                } else if ("mp4Only".equals(str2.trim())) {
                    i3 |= 2;
                }
            }
        } else {
            i3 = 0;
        }
        w.d("MicroMsg.JsApiInsertVideoPlayer", "convertPlayerHint, playerHintStr: %s, playerHint: %d", str, Integer.valueOf(i3));
        return i3;
    }

    public final void a(int i3, boolean z16, final com.tencent.luggage.wxa.xd.f fVar, final com.tencent.luggage.wxa.mg.a aVar) {
        final k kVar = new k(i3);
        final b bVar = new b();
        Objects.requireNonNull(aVar);
        final g.d dVar = new g.d() { // from class: n41.a
            @Override // com.tencent.luggage.wxa.xd.g.d
            public final void onForeground() {
                com.tencent.luggage.wxa.mg.a.this.o();
            }
        };
        final g.b bVar2 = new g.b() { // from class: n41.b
            @Override // com.tencent.luggage.wxa.xd.g.b
            public final void onBackground() {
                com.tencent.luggage.wxa.wg.a.a(f.this, kVar, aVar);
            }
        };
        final g.c cVar = new g.c() { // from class: n41.c
            @Override // com.tencent.luggage.wxa.xd.g.c
            public final void onDestroy() {
                com.tencent.luggage.wxa.wg.a.a(com.tencent.luggage.wxa.mg.a.this, bVar);
            }
        };
        if (z16) {
            final String appId = fVar.getAppId();
            final d dVar2 = new d(bVar2, dVar, cVar);
            bVar.a(new Runnable() { // from class: n41.d
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.ic.e.b(appId, dVar2);
                }
            });
            com.tencent.luggage.wxa.ic.e.a(appId, dVar2);
            return;
        }
        bVar.a(new Runnable() { // from class: n41.e
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.wg.a.a(f.this, dVar, bVar2, cVar);
            }
        });
        fVar.b(dVar);
        fVar.a(bVar2);
        fVar.a(cVar);
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("videoPlayerId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        Context context = fVar.getContext();
        com.tencent.luggage.wxa.ch.c cVar = new com.tencent.luggage.wxa.ch.c(context);
        com.tencent.luggage.wxa.mg.b bVar = new com.tencent.luggage.wxa.mg.b(context);
        bVar.setVideoFooterView(cVar);
        bVar.setPlayerHint(b(jSONObject.optString("playerHint")));
        com.tencent.luggage.wxa.mg.a aVar = new com.tencent.luggage.wxa.mg.a(context, bVar);
        aVar.a(cVar);
        return new com.tencent.luggage.wxa.ye.b(context, aVar);
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        int i16;
        k kVar = new k(i3);
        w.d("MicroMsg.JsApiInsertVideoPlayer", "%s onInsertView, data: %s", kVar, jSONObject);
        com.tencent.luggage.wxa.mg.a aVar = (com.tencent.luggage.wxa.mg.a) ((com.tencent.luggage.wxa.ye.b) view).a(com.tencent.luggage.wxa.mg.a.class);
        if (aVar == null) {
            w.b("MicroMsg.JsApiInsertVideoPlayer", "%s onInsertView appBrandVideoView null", kVar);
            return;
        }
        aVar.setVideoContext(kVar);
        boolean independent = getIndependent(jSONObject);
        a(i3, independent, fVar, aVar);
        aVar.setFullScreenDelegate(new c(fVar, independent, i3, new C6884a(aVar)));
        aVar.setContentDescription(view.getContext().getString(R.string.ywj));
        aVar.setMute(jSONObject.optBoolean("muted", false));
        boolean optBoolean = jSONObject.optBoolean("needEvent", false);
        boolean optBoolean2 = jSONObject.optBoolean("autoplay", false);
        w.d("MicroMsg.JsApiInsertVideoPlayer", "%s onInsertView autoPlay=%b needEvent=%b", kVar, Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean));
        boolean optBoolean3 = jSONObject.optBoolean("showDanmuBtn", false);
        boolean optBoolean4 = jSONObject.optBoolean("enableDanmu", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("danmuList");
        String optString = jSONObject.optString("objectFit");
        String optString2 = jSONObject.optString(QAdVrReport.ElementID.AD_POSTER);
        boolean optBoolean5 = jSONObject.optBoolean("showBasicControls", true);
        String optString3 = jSONObject.optString("data");
        int optInt = jSONObject.optInt("direction", -1);
        boolean optBoolean6 = jSONObject.optBoolean("loop", false);
        boolean optBoolean7 = jSONObject.optBoolean("pageGesture", false);
        boolean optBoolean8 = jSONObject.optBoolean("pageGestureInFullscreen", true);
        double optDouble = jSONObject.optDouble("initialTime", 0.0d);
        boolean optBoolean9 = jSONObject.optBoolean("showProgress", true);
        boolean optBoolean10 = jSONObject.optBoolean("showProgressInControlMode", true);
        boolean optBoolean11 = jSONObject.optBoolean("showFullScreenBtn", true);
        boolean optBoolean12 = jSONObject.optBoolean("showPlayBtn", true);
        boolean optBoolean13 = jSONObject.optBoolean("showCenterPlayBtn", true);
        boolean optBoolean14 = jSONObject.optBoolean("showPoster", false);
        boolean optBoolean15 = jSONObject.optBoolean("enableProgressGesture", true);
        String optString4 = jSONObject.optString("scene", "default");
        boolean optBoolean16 = jSONObject.optBoolean("showMuteBtn", false);
        String optString5 = jSONObject.optString("title", "");
        boolean optBoolean17 = jSONObject.optBoolean("showControlProgress", true);
        String optString6 = jSONObject.optString("playBtnPosition", "bottom");
        boolean optBoolean18 = jSONObject.optBoolean("enablePlayGesture", false);
        boolean optBoolean19 = jSONObject.optBoolean("autoPauseIfNavigate", true);
        boolean optBoolean20 = jSONObject.optBoolean("autoPauseIfOpenNative", true);
        long optLong = jSONObject.optLong("bufferDuration", 10L) * 1000;
        if (optLong <= 0) {
            optLong = 10000;
        }
        String optString7 = jSONObject.optString("backgroundColor");
        aVar.setComponent(fVar);
        aVar.setCookieData(optString3);
        aVar.setIsShowBasicControls(optBoolean5);
        aVar.b(optString2, optString);
        aVar.setFullScreenDirection(optInt);
        aVar.setObjectFit(optString);
        aVar.setLoop(optBoolean6);
        aVar.setPageGesture(optBoolean7);
        aVar.setPageGestureInFullscreen(optBoolean8);
        try {
            aVar.setVideoPlayerId(getViewId(jSONObject));
        } catch (JSONException e16) {
            w.b("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", e16);
        }
        aVar.setAutoPlay(optBoolean2);
        aVar.setShowDanmakuBtn(optBoolean3);
        aVar.setDanmakuEnable(optBoolean4);
        aVar.setDanmakuItemList(optJSONArray);
        aVar.setInitialTime(optDouble);
        aVar.setShowControlProgress(optBoolean17);
        aVar.setShowProgress(optBoolean9);
        aVar.setShowProgressBarInControlMode(optBoolean10);
        aVar.setShowFullScreenBtn(optBoolean11);
        aVar.setShowPlayBtn(optBoolean12);
        aVar.setShowCenterPlayBtn(optBoolean13);
        aVar.setShowPoster(optBoolean14);
        aVar.b(optBoolean15);
        if (optString4.equalsIgnoreCase("default")) {
            aVar.setVideoSource(0);
        } else {
            aVar.setVideoSource(1);
        }
        aVar.setShowMuteBtn(optBoolean16);
        aVar.setTitle(optString5);
        aVar.setPlayBtnPosition(optString6);
        aVar.setEnablePlayGesture(optBoolean18);
        aVar.setAutoPauseIfNavigate(optBoolean19);
        aVar.setAutoPauseIfOpenNative(optBoolean20);
        aVar.setMinBufferDuration(optLong);
        if (!TextUtils.isEmpty(optString7)) {
            if ("transparent".equals(optString7)) {
                i16 = 0;
            } else {
                try {
                    i16 = Color.parseColor(optString7);
                } catch (IllegalArgumentException unused) {
                    i16 = -16777216;
                }
            }
            aVar.setBackgroundColor(i16);
        }
        if (optBoolean) {
            aVar.setCallback(new com.tencent.luggage.wxa.vg.b(aVar, fVar));
        }
        int optInt2 = jSONObject.optInt("duration", -1);
        String optString8 = jSONObject.optString("filePath");
        boolean optBoolean21 = jSONObject.optBoolean("live", false);
        w.d("MicroMsg.JsApiInsertVideoPlayer", "%s onInsertView filePath=%s live=%b", kVar, optString8, Boolean.valueOf(optBoolean21));
        aVar.a(optString8, optBoolean21, optInt2);
    }

    public static /* synthetic */ void a(com.tencent.luggage.wxa.xd.f fVar, k kVar, com.tencent.luggage.wxa.mg.a aVar) {
        e.d d16 = com.tencent.luggage.wxa.ic.e.d(fVar.getAppId());
        w.d("MicroMsg.JsApiInsertVideoPlayer", "%s VideoPlayer enter background, pause type:%s", kVar, d16.name());
        aVar.a(d16);
    }

    public static /* synthetic */ void a(com.tencent.luggage.wxa.mg.a aVar, b bVar) {
        aVar.m();
        bVar.run();
    }

    public static /* synthetic */ void a(com.tencent.luggage.wxa.xd.f fVar, g.d dVar, g.b bVar, g.c cVar) {
        fVar.a(dVar);
        fVar.b(bVar);
        fVar.b(cVar);
    }
}
