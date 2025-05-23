package com.tencent.luggage.wxa.se;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 372;
    public static final String NAME = "canvasGetImageData";

    public static Map a(int[] iArr, int i3, int i16) {
        ByteBuffer a16 = a(iArr);
        HashMap hashMap = new HashMap();
        hashMap.put("data", a16);
        hashMap.put("width", Integer.valueOf(i3));
        hashMap.put("height", Integer.valueOf(i16));
        return hashMap;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        int i16;
        int i17;
        View view;
        int i18;
        int i19;
        try {
            int i26 = jSONObject.getInt("canvasId");
            com.tencent.luggage.wxa.xd.f a16 = ((com.tencent.luggage.wxa.ee.g) dVar.b(com.tencent.luggage.wxa.ee.g.class)).a(dVar, jSONObject);
            if (a16 == null) {
                w.f("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
                dVar.a(i3, makeReturnJson("fail:page is null"));
                return;
            }
            View c16 = a16.a(jSONObject.optBoolean("independent", false)).c(i26);
            if (c16 == null) {
                w.h("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", Integer.valueOf(i26));
                dVar.a(i3, makeReturnJson("fail:view is null"));
                return;
            }
            if (!(c16 instanceof com.tencent.luggage.wxa.ye.b)) {
                w.h("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i26));
                dVar.a(i3, makeReturnJson("fail:illegal view type"));
                return;
            }
            View view2 = (View) ((com.tencent.luggage.wxa.ye.b) c16).a(View.class);
            if (!(view2 instanceof com.tencent.luggage.wxa.dd.b)) {
                w.d("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i26));
                dVar.a(i3, makeReturnJson("fail:illegal view type"));
                return;
            }
            float a17 = com.tencent.luggage.wxa.tk.g.a();
            int optInt = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt2 = jSONObject.optInt("y");
            int optInt3 = jSONObject.optInt("width");
            int optInt4 = jSONObject.optInt("height");
            if (optInt3 != 0 && optInt4 != 0) {
                if (optInt3 < 0) {
                    optInt += optInt3;
                    optInt3 = -optInt3;
                }
                if (optInt4 < 0) {
                    optInt2 += optInt4;
                    optInt4 = -optInt4;
                }
                int round = Math.round(optInt * a17);
                int round2 = Math.round(optInt2 * a17);
                int round3 = Math.round(optInt3 * a17);
                int round4 = Math.round(optInt4 * a17);
                int measuredWidth = view2.getMeasuredWidth();
                int measuredHeight = view2.getMeasuredHeight();
                if (round < 0) {
                    i16 = optInt;
                    i17 = 0;
                } else if (round >= measuredWidth) {
                    dVar.a(i3, makeReturnJsonWithNativeBuffer(dVar, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, a(new int[optInt3 * optInt4], optInt3, optInt4)));
                    return;
                } else {
                    i16 = optInt;
                    i17 = round;
                }
                if (round2 < 0) {
                    view = view2;
                    i18 = optInt2;
                    i19 = 0;
                } else if (round2 >= measuredHeight) {
                    dVar.a(i3, makeReturnJsonWithNativeBuffer(dVar, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, a(new int[optInt3 * optInt4], optInt3, optInt4)));
                    return;
                } else {
                    view = view2;
                    i18 = optInt2;
                    i19 = round2;
                }
                int i27 = round + round3;
                if (i27 > measuredWidth) {
                    round3 = measuredWidth - i17;
                } else if (i27 <= 0) {
                    dVar.a(i3, makeReturnJsonWithNativeBuffer(dVar, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, a(new int[optInt3 * optInt4], optInt3, optInt4)));
                    return;
                } else if (round < 0) {
                    round3 = i27;
                }
                int i28 = round2 + round4;
                if (i28 > measuredHeight) {
                    round4 = measuredHeight - i19;
                } else if (i28 <= 0) {
                    dVar.a(i3, makeReturnJsonWithNativeBuffer(dVar, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, a(new int[optInt3 * optInt4], optInt3, optInt4)));
                    return;
                } else if (round2 < 0) {
                    round4 = i28;
                }
                int round5 = Math.round(i17 / a17);
                int round6 = Math.round(i19 / a17);
                int round7 = Math.round(round3 / a17);
                int round8 = Math.round(round4 / a17);
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                    com.tencent.luggage.wxa.vc.f fVar = new com.tencent.luggage.wxa.vc.f(createBitmap);
                    fVar.save();
                    fVar.translate(-i17, -i19);
                    ((com.tencent.luggage.wxa.dd.b) view).a(fVar);
                    fVar.restore();
                    int[] iArr = new int[optInt3 * optInt4];
                    try {
                        Bitmap.createScaledBitmap(createBitmap, round7, round8, false).getPixels(iArr, ((round6 - i18) * optInt3) + (round5 - i16), optInt3, 0, 0, round7, round8);
                        dVar.a(i3, makeReturnJsonWithNativeBuffer(dVar, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, a(iArr, optInt3, optInt4)));
                        return;
                    } catch (Exception e16) {
                        w.h("MicroMsg.JsApiCanvasGetImageData", "getPixels failed, viewId(%s). Exception: %s", Integer.valueOf(i26), e16);
                        w.h("MicroMsg.JsApiCanvasGetImageData", "getPixels failed. finalXDp:%d finalYDp:%d finalWidthDp:%d finalHeightDp:%d wDp:%d data:%s", Integer.valueOf(round5), Integer.valueOf(round6), Integer.valueOf(round7), Integer.valueOf(round8), Integer.valueOf(optInt3), jSONObject);
                        dVar.a(i3, makeReturnJson("fail: getPixels failed"));
                        return;
                    }
                } catch (Exception e17) {
                    w.h("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i26), e17);
                    dVar.a(i3, makeReturnJson("fail:create bitmap failed"));
                    return;
                }
            }
            w.d("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i26));
            dVar.a(i3, makeReturnJson("fail:width or height is 0"));
        } catch (JSONException e18) {
            w.d("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", Log.getStackTraceString(e18));
            dVar.a(i3, makeReturnJson("fail:illegal canvasId"));
        }
    }

    public static ByteBuffer a(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        int i3 = 0;
        for (int i16 : iArr) {
            int i17 = i3 + 1;
            bArr[i3] = (byte) ((i16 >> 16) & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) ((i16 >> 8) & 255);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i16 & 255);
            i3 = i19 + 1;
            bArr[i19] = (byte) ((i16 >> 24) & 255);
        }
        return ByteBuffer.wrap(bArr);
    }
}
