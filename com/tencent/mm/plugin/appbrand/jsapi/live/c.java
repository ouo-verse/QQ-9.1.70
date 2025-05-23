package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.ee.j;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.g;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.rtmp.TXLivePusher;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 363;
    public static final String NAME = "operateLivePusher";

    /* renamed from: b, reason: collision with root package name */
    private static final String f152125b = "MicroMsg.JsApiOperateLivePusher";

    /* renamed from: c, reason: collision with root package name */
    private static final String f152126c = "snapshot";

    /* renamed from: d, reason: collision with root package name */
    private static final String f152127d = "playBGM";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements g.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f152128a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.live.b f152129b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f152130c;

        public a(JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, String str) {
            this.f152128a = jSONObject;
            this.f152129b = bVar;
            this.f152130c = str;
        }

        @Override // com.tencent.luggage.wxa.uk.g.d
        public void onLoad(String str) {
            if (!w0.c(str)) {
                String b16 = x.b(str, false);
                w.d(c.f152125b, "operatePlayBgm, local file path:%s, realLocalPath: %s", str, b16);
                JSONObject jSONObject = this.f152128a;
                try {
                    jSONObject.put("BGMFilePath", b16);
                } catch (JSONException e16) {
                    w.b(c.f152125b, "operatePlayBgm, set param fail", e16);
                }
                if (!this.f152129b.a("playBGM", jSONObject)) {
                    w.b(c.f152125b, "operatePlayBgm, play bgm fail, url:%s", this.f152130c);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("url", this.f152130c);
                    this.f152129b.a(com.tencent.luggage.wxa.af.g.f121349r, 10003, "download file fail", hashMap);
                    return;
                }
                return;
            }
            w.b(c.f152125b, "operatePlayBgm, download file fail, url:%s", this.f152130c);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("url", this.f152130c);
            this.f152129b.a(com.tencent.luggage.wxa.af.g.f121349r, 10003, "download file fail", hashMap2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements TXLivePusher.ITXSnapshotListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f152132a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f152133b;

        public b(j jVar, f fVar) {
            this.f152132a = jVar;
            this.f152133b = fVar;
        }

        public void a(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                String str = com.tencent.luggage.wxa.bo.b.a() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                try {
                    com.tencent.luggage.wxa.tn.d.a(bitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
                    i iVar = new i();
                    if (this.f152133b.getFileSystem().createTempFileFrom(new v(str), "jpg", true, iVar) == l.OK) {
                        c.this.a(bitmap);
                        w.d(c.f152125b, "onSnapshot: actualPath:%s path:%s", str, iVar.f141499a);
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempImagePath", iVar.f141499a);
                        hashMap.put("width", Integer.valueOf(width));
                        hashMap.put("height", Integer.valueOf(height));
                        this.f152132a.a(c.this.makeReturnJson(e.f121305a, hashMap));
                        return;
                    }
                    this.f152132a.a(c.this.makeReturnJson(com.tencent.luggage.wxa.af.g.f121343l));
                    return;
                } catch (IOException e16) {
                    w.b(c.f152125b, "onSnapshot: exception %s", e16.getMessage());
                    this.f152132a.a(c.this.makeReturnJson(com.tencent.luggage.wxa.af.g.f121342k));
                    return;
                }
            }
            w.b(c.f152125b, "onSnapshot: bitmap nil");
            this.f152132a.a(c.this.makeReturnJson(com.tencent.luggage.wxa.af.g.f121341j));
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("livePusherId");
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean isAsyncCallback() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(f fVar, int i3, View view, JSONObject jSONObject, j jVar) {
        w.d(f152125b, "onOperateView : livePusherId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h(f152125b, "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        View view2 = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (!(view2 instanceof com.tencent.mm.plugin.appbrand.jsapi.live.b)) {
            w.b(f152125b, "targetView not AppBrandLivePusherView");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.live.b bVar = (com.tencent.mm.plugin.appbrand.jsapi.live.b) view2;
        String optString = jSONObject.optString("type");
        w.d(f152125b, "onOperateView operateType=%s", optString);
        if (optString.equalsIgnoreCase("snapshot")) {
            a(bVar, fVar, jVar, jSONObject);
        } else if (optString.equalsIgnoreCase("playBGM")) {
            a(fVar, bVar, jSONObject, jVar);
        } else if (bVar.a(optString, jSONObject)) {
            jVar.a(makeReturnJson(e.f121305a));
        } else {
            jVar.a(makeReturnJson(e.f121309e));
        }
        return super.a(fVar, i3, view, jSONObject, jVar);
    }

    private void a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, JSONObject jSONObject, j jVar) {
        String optString = jSONObject.optString("url");
        if (w0.c(optString)) {
            w.f(f152125b, "operatePlayBgm, url is nil");
            jVar.a(makeReturnJson("fail:url is nil", e.f121315k));
        } else {
            g.c(dVar, optString, null, new a(jSONObject, bVar, optString));
            jVar.a(makeReturnJson(e.f121305a));
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.live.b bVar, f fVar, j jVar, JSONObject jSONObject) {
        bVar.a(new b(jVar, fVar));
        if (bVar.a("snapshot", jSONObject)) {
            return;
        }
        jVar.a(makeReturnJson(e.f121309e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        w.d(f152125b, "bitmap recycle " + bitmap.toString());
        bitmap.recycle();
    }
}
