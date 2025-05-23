package com.tencent.luggage.wxa.se;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.dd.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 373;
    public static final String NAME = "canvasPutImageData";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f140291a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f140292b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f140291a = dVar;
            this.f140292b = i3;
        }

        @Override // com.tencent.luggage.wxa.dd.b.a
        public void a(com.tencent.luggage.wxa.dd.c cVar) {
            this.f140291a.a(this.f140292b, c.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    public final int[] a(ByteBuffer byteBuffer) {
        byte[] a16 = com.tencent.luggage.wxa.tk.c.a(byteBuffer);
        int length = a16.length / 4;
        int[] iArr = new int[length];
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i16 + 1;
            int i18 = i17 + 1;
            int i19 = ((a16[i16] & 255) << 16) | ((a16[i17] & 255) << 8);
            int i26 = i18 + 1;
            iArr[i3] = i19 | (a16[i18] & 255) | ((a16[i26] & 255) << 24);
            i3++;
            i16 = i26 + 1;
        }
        return iArr;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        try {
            int i16 = jSONObject.getInt("canvasId");
            com.tencent.luggage.wxa.xd.f a16 = ((com.tencent.luggage.wxa.ee.g) dVar.b(com.tencent.luggage.wxa.ee.g.class)).a(dVar, jSONObject);
            if (a16 == null) {
                w.f("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasPutImageData failed, component view is null.");
                dVar.a(i3, makeReturnJson("fail:page is null"));
                return;
            }
            View c16 = a16.a(jSONObject.optBoolean("independent", false)).c(i16);
            if (c16 == null) {
                w.h("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", Integer.valueOf(i16));
                dVar.a(i3, makeReturnJson("fail:view is null"));
                return;
            }
            if (!(c16 instanceof com.tencent.luggage.wxa.ye.b)) {
                w.h("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i16));
                dVar.a(i3, makeReturnJson("fail:illegal view type"));
                return;
            }
            KeyEvent.Callback callback = (View) ((com.tencent.luggage.wxa.ye.b) c16).a(View.class);
            if (!(callback instanceof com.tencent.luggage.wxa.dd.b)) {
                w.d("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i16));
                dVar.a(i3, makeReturnJson("fail:illegal view type"));
                return;
            }
            float a17 = com.tencent.luggage.wxa.tk.g.a();
            int optInt = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt2 = jSONObject.optInt("y");
            int optInt3 = jSONObject.optInt("width");
            int optInt4 = jSONObject.optInt("height");
            Math.round(optInt * a17);
            Math.round(optInt2 * a17);
            Math.round(optInt3 * a17);
            Math.round(optInt4 * a17);
            if (optInt3 != 0 && optInt4 != 0) {
                if (optInt3 < 0) {
                    optInt += optInt3;
                    optInt3 = -optInt3;
                }
                if (optInt4 < 0) {
                    optInt2 += optInt4;
                    optInt4 = -optInt4;
                }
                try {
                    Object obj = jSONObject.get("data");
                    if (!(obj instanceof ByteBuffer)) {
                        w.d("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
                        dVar.a(i3, makeReturnJson("fail:illegal data"));
                        return;
                    }
                    ByteBuffer byteBuffer = (ByteBuffer) obj;
                    JSONArray jSONArray = new JSONArray();
                    int[] a18 = a(byteBuffer);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(optInt);
                        jSONArray2.put(optInt2);
                        jSONArray2.put(optInt3);
                        jSONArray2.put(optInt4);
                        jSONArray2.mo162put(Bitmap.createBitmap(a18, optInt3, optInt4, Bitmap.Config.ARGB_8888));
                        jSONObject2.put("method", "__setPixels");
                        jSONObject2.put("data", jSONArray2);
                        jSONArray.mo162put(jSONObject2);
                        com.tencent.luggage.wxa.dd.b bVar = (com.tencent.luggage.wxa.dd.b) callback;
                        bVar.a(jSONArray, new a(dVar, i3));
                        bVar.a();
                        return;
                    } catch (JSONException e16) {
                        w.h("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", e16);
                        dVar.a(i3, makeReturnJson("fail:build action JSON error"));
                        return;
                    }
                } catch (JSONException e17) {
                    w.d("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", Log.getStackTraceString(e17));
                    dVar.a(i3, makeReturnJson("fail:missing data"));
                    return;
                }
            }
            w.d("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i16));
            dVar.a(i3, makeReturnJson("fail:width or height is 0"));
        } catch (JSONException e18) {
            w.d("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", Log.getStackTraceString(e18));
            dVar.a(i3, makeReturnJson("fail:illegal canvasId"));
        }
    }
}
