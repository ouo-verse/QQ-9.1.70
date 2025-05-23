package com.tencent.luggage.wxa.ff;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.rtmp.TXLivePlayer;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 367;
    public static final String NAME = "operateLivePlayer";

    /* renamed from: b, reason: collision with root package name */
    private static final String f126089b = "MicroMsg.JsApiOperateLivePlayer";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements TXLivePlayer.ITXSnapshotListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.luggage.wxa.ee.j f126090a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.luggage.wxa.xd.f f126091b;

        public a(com.tencent.luggage.wxa.ee.j jVar, com.tencent.luggage.wxa.xd.f fVar) {
            this.f126090a = jVar;
            this.f126091b = fVar;
        }

        public void a(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                String str = com.tencent.luggage.wxa.bo.b.a() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                try {
                    com.tencent.luggage.wxa.tn.d.a(bitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
                    com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                    if (this.f126091b.getFileSystem().createTempFileFrom(new v(str), "jpg", true, iVar) == l.OK) {
                        c.this.a(bitmap);
                        w.d(c.f126089b, "onSnapshot: actualPath:%s path:%s", str, iVar.f141499a);
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempImagePath", iVar.f141499a);
                        hashMap.put("width", Integer.valueOf(width));
                        hashMap.put("height", Integer.valueOf(height));
                        this.f126090a.a(c.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap));
                        return;
                    }
                    this.f126090a.a(c.this.makeReturnJson(com.tencent.luggage.wxa.af.g.f121343l));
                    return;
                } catch (IOException e16) {
                    w.b(c.f126089b, "onSnapshot: exception %s", e16.getMessage());
                    this.f126090a.a(c.this.makeReturnJson(com.tencent.luggage.wxa.af.g.f121342k));
                    return;
                }
            }
            w.b(c.f126089b, "onSnapshot: bitmap nil");
            this.f126090a.a(c.this.makeReturnJson(com.tencent.luggage.wxa.af.g.f121341j));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f126093a = "requestFullScreen";

        /* renamed from: b, reason: collision with root package name */
        public static final String f126094b = "exitFullScreen";

        /* renamed from: c, reason: collision with root package name */
        public static final String f126095c = "snapshot";
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("livePlayerId");
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean isAsyncCallback() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject, com.tencent.luggage.wxa.ee.j jVar) {
        int i16 = 0;
        w.d(f126089b, "onOperateView : livePlayerId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h(f126089b, "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        View view2 = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (!(view2 instanceof com.tencent.mm.plugin.appbrand.jsapi.live.a)) {
            w.b(f126089b, "targetView not AppBrandLivePlayerView");
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.live.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.live.a) view2;
        String optString = jSONObject.optString("type");
        w.d(f126089b, "onOperateView operateType=%s", optString);
        if (optString.equalsIgnoreCase("snapshot")) {
            a(aVar, fVar, jVar, jSONObject);
        } else if (optString.equalsIgnoreCase("requestFullScreen")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                i16 = optJSONArray.optInt(0, 0);
            } else {
                w.f(f126089b, "onOperateView directionArr nil");
            }
            jVar.a(makeReturnJson(aVar.a(i16) ? com.tencent.luggage.wxa.af.e.f121305a : com.tencent.luggage.wxa.af.e.f121309e));
        } else if (optString.equalsIgnoreCase("exitFullScreen")) {
            jVar.a(makeReturnJson(aVar.d() ? com.tencent.luggage.wxa.af.e.f121305a : com.tencent.luggage.wxa.af.e.f121309e));
        } else {
            jVar.a(makeReturnJson(aVar.a(optString, jSONObject) ? com.tencent.luggage.wxa.af.e.f121305a : com.tencent.luggage.wxa.af.e.f121309e));
        }
        return super.a(fVar, i3, view, jSONObject, jVar);
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.live.a aVar, com.tencent.luggage.wxa.xd.f fVar, com.tencent.luggage.wxa.ee.j jVar, JSONObject jSONObject) {
        aVar.a(new a(jVar, fVar));
        if (aVar.a("snapshot", jSONObject)) {
            return;
        }
        jVar.a(makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        w.d(f126089b, "bitmap recycle " + bitmap.toString());
        bitmap.recycle();
    }
}
