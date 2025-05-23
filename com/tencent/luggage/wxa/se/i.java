package com.tencent.luggage.wxa.se;

import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends v {
    public static final int CTRL_INDEX = 436;
    public static final String NAME = "measureText";

    /* JADX WARN: Can't wrap try/catch for region: R(9:(8:51|(1:(1:(1:25)(1:46))(1:47))(1:48)|26|27|(2:29|(1:41))(2:42|(1:44))|38|35|36)|21|(0)(0)|26|27|(0)(0)|38|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00dd, code lost:
    
        if (r5 == 1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e0, code lost:
    
        r4.setFakeBoldText(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e8, code lost:
    
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4 A[Catch: JSONException -> 0x00e8, TryCatch #0 {JSONException -> 0x00e8, blocks: (B:27:0x00b6, B:37:0x00e0, B:38:0x00e4, B:39:0x00c9, B:42:0x00d4), top: B:26:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac A[Catch: JSONException -> 0x00b0, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00b0, blocks: (B:15:0x0066, B:46:0x00a4, B:47:0x00a8, B:48:0x00ac, B:49:0x007e, B:52:0x0086, B:55:0x0091), top: B:14:0x0066 }] */
    @Override // com.tencent.luggage.wxa.xd.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        int hashCode;
        String string;
        int hashCode2;
        char c16;
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiMeasureText", "measureText, data is null");
            return makeReturnJson("fail:data is null");
        }
        String optString = jSONObject.optString("text");
        float optDouble = (float) jSONObject.optDouble("fontSize", 16.0d);
        w.d("MicroMsg.JsApiMeasureText", "measureText data:%s", jSONObject.toString());
        if (!TextUtils.isEmpty(optString) && optDouble > 0.0f) {
            com.tencent.luggage.wxa.ad.a aVar = new com.tencent.luggage.wxa.ad.a();
            aVar.setTextSize(com.tencent.luggage.wxa.tk.g.a(optDouble));
            try {
                aVar.a(jSONObject.getString("fontFamily"));
            } catch (JSONException unused) {
                w.d("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
            }
            char c17 = '\uffff';
            try {
                string = jSONObject.getString("fontStyle");
                hashCode2 = string.hashCode();
            } catch (JSONException unused2) {
                w.d("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
            }
            if (hashCode2 != -1657669071) {
                if (hashCode2 != -1178781136) {
                    if (hashCode2 == -1039745817 && string.equals("normal")) {
                        c16 = 2;
                        if (c16 == 0) {
                            if (c16 != 1) {
                                if (c16 == 2) {
                                    aVar.a(0);
                                }
                            } else {
                                aVar.a(2);
                            }
                        } else {
                            aVar.a(2);
                        }
                        String string2 = jSONObject.getString("fontWeight");
                        hashCode = string2.hashCode();
                        if (hashCode == -1039745817) {
                            if (hashCode == 3029637 && string2.equals("bold")) {
                                c17 = 0;
                            }
                        } else if (string2.equals("normal")) {
                            c17 = 1;
                        }
                        aVar.setFakeBoldText(true);
                        float measureText = aVar.measureText(optString);
                        Paint.FontMetrics fontMetrics = aVar.getFontMetrics();
                        float abs = Math.abs(fontMetrics.bottom - fontMetrics.top);
                        w.d("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top), Float.valueOf(measureText), Float.valueOf(abs));
                        float b16 = com.tencent.luggage.wxa.tk.g.b(measureText);
                        float b17 = com.tencent.luggage.wxa.tk.g.b(abs);
                        HashMap hashMap = new HashMap();
                        hashMap.put("width", Float.valueOf(b16));
                        hashMap.put("height", Float.valueOf(b17));
                        w.d("MicroMsg.JsApiMeasureText", "map:%s", hashMap.toString());
                        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                    String string22 = jSONObject.getString("fontWeight");
                    hashCode = string22.hashCode();
                    if (hashCode == -1039745817) {
                    }
                    aVar.setFakeBoldText(true);
                    float measureText2 = aVar.measureText(optString);
                    Paint.FontMetrics fontMetrics2 = aVar.getFontMetrics();
                    float abs2 = Math.abs(fontMetrics2.bottom - fontMetrics2.top);
                    w.d("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics2.bottom), Float.valueOf(fontMetrics2.top), Float.valueOf(measureText2), Float.valueOf(abs2));
                    float b162 = com.tencent.luggage.wxa.tk.g.b(measureText2);
                    float b172 = com.tencent.luggage.wxa.tk.g.b(abs2);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("width", Float.valueOf(b162));
                    hashMap2.put("height", Float.valueOf(b172));
                    w.d("MicroMsg.JsApiMeasureText", "map:%s", hashMap2.toString());
                    return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap2);
                }
                if (string.equals("italic")) {
                    c16 = 1;
                    if (c16 == 0) {
                    }
                    String string222 = jSONObject.getString("fontWeight");
                    hashCode = string222.hashCode();
                    if (hashCode == -1039745817) {
                    }
                    aVar.setFakeBoldText(true);
                    float measureText22 = aVar.measureText(optString);
                    Paint.FontMetrics fontMetrics22 = aVar.getFontMetrics();
                    float abs22 = Math.abs(fontMetrics22.bottom - fontMetrics22.top);
                    w.d("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics22.bottom), Float.valueOf(fontMetrics22.top), Float.valueOf(measureText22), Float.valueOf(abs22));
                    float b1622 = com.tencent.luggage.wxa.tk.g.b(measureText22);
                    float b1722 = com.tencent.luggage.wxa.tk.g.b(abs22);
                    HashMap hashMap22 = new HashMap();
                    hashMap22.put("width", Float.valueOf(b1622));
                    hashMap22.put("height", Float.valueOf(b1722));
                    w.d("MicroMsg.JsApiMeasureText", "map:%s", hashMap22.toString());
                    return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap22);
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
                String string2222 = jSONObject.getString("fontWeight");
                hashCode = string2222.hashCode();
                if (hashCode == -1039745817) {
                }
                aVar.setFakeBoldText(true);
                float measureText222 = aVar.measureText(optString);
                Paint.FontMetrics fontMetrics222 = aVar.getFontMetrics();
                float abs222 = Math.abs(fontMetrics222.bottom - fontMetrics222.top);
                w.d("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics222.bottom), Float.valueOf(fontMetrics222.top), Float.valueOf(measureText222), Float.valueOf(abs222));
                float b16222 = com.tencent.luggage.wxa.tk.g.b(measureText222);
                float b17222 = com.tencent.luggage.wxa.tk.g.b(abs222);
                HashMap hashMap222 = new HashMap();
                hashMap222.put("width", Float.valueOf(b16222));
                hashMap222.put("height", Float.valueOf(b17222));
                w.d("MicroMsg.JsApiMeasureText", "map:%s", hashMap222.toString());
                return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap222);
            }
            if (string.equals("oblique")) {
                c16 = 0;
                if (c16 == 0) {
                }
                String string22222 = jSONObject.getString("fontWeight");
                hashCode = string22222.hashCode();
                if (hashCode == -1039745817) {
                }
                aVar.setFakeBoldText(true);
                float measureText2222 = aVar.measureText(optString);
                Paint.FontMetrics fontMetrics2222 = aVar.getFontMetrics();
                float abs2222 = Math.abs(fontMetrics2222.bottom - fontMetrics2222.top);
                w.d("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics2222.bottom), Float.valueOf(fontMetrics2222.top), Float.valueOf(measureText2222), Float.valueOf(abs2222));
                float b162222 = com.tencent.luggage.wxa.tk.g.b(measureText2222);
                float b172222 = com.tencent.luggage.wxa.tk.g.b(abs2222);
                HashMap hashMap2222 = new HashMap();
                hashMap2222.put("width", Float.valueOf(b162222));
                hashMap2222.put("height", Float.valueOf(b172222));
                w.d("MicroMsg.JsApiMeasureText", "map:%s", hashMap2222.toString());
                return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap2222);
            }
            c16 = '\uffff';
            if (c16 == 0) {
            }
            String string222222 = jSONObject.getString("fontWeight");
            hashCode = string222222.hashCode();
            if (hashCode == -1039745817) {
            }
            aVar.setFakeBoldText(true);
            float measureText22222 = aVar.measureText(optString);
            Paint.FontMetrics fontMetrics22222 = aVar.getFontMetrics();
            float abs22222 = Math.abs(fontMetrics22222.bottom - fontMetrics22222.top);
            w.d("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics22222.bottom), Float.valueOf(fontMetrics22222.top), Float.valueOf(measureText22222), Float.valueOf(abs22222));
            float b1622222 = com.tencent.luggage.wxa.tk.g.b(measureText22222);
            float b1722222 = com.tencent.luggage.wxa.tk.g.b(abs22222);
            HashMap hashMap22222 = new HashMap();
            hashMap22222.put("width", Float.valueOf(b1622222));
            hashMap22222.put("height", Float.valueOf(b1722222));
            w.d("MicroMsg.JsApiMeasureText", "map:%s", hashMap22222.toString());
            return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap22222);
        }
        w.b("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
        return makeReturnJson("fail:param is illegal");
    }
}
