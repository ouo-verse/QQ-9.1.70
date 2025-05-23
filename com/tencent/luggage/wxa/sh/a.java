package com.tencent.luggage.wxa.sh;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.se.d;
import com.tencent.luggage.wxa.tk.c;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends d {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Bitmap bitmap;
        w.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "invokeXWebCanvasJsApi data:%s", jSONObject);
        int optInt = jSONObject.optInt("width", 300);
        int optInt2 = jSONObject.optInt("height", 150);
        float a16 = w0.a(jSONObject.optString("destWidth"), optInt);
        float a17 = w0.a(jSONObject.optString("destHeight"), optInt2);
        try {
            Object obj = jSONObject.get("data");
            if (!(obj instanceof ByteBuffer)) {
                w.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, value is not a ByteBuffer");
                dVar.a(i3, makeReturnJson("fail:illegal data"));
                return;
            }
            try {
                bitmap = Bitmap.createBitmap(a((ByteBuffer) obj), optInt, optInt2, Bitmap.Config.ARGB_8888);
            } catch (Exception e16) {
                w.f("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", e16);
                bitmap = null;
                if (bitmap == null) {
                }
            } catch (Throwable th5) {
                w.f("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", th5);
                bitmap = null;
                if (bitmap == null) {
                }
            }
            if (bitmap == null) {
                w.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
                dVar.a(i3, makeReturnJson("fail:illegal bitmap"));
                return;
            }
            if (bitmap.getWidth() != a16 || bitmap.getHeight() != a17) {
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) a16, (int) a17, false);
                    w.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "bitmap recycle %s %s ", bitmap, createScaledBitmap);
                    bitmap = createScaledBitmap;
                } catch (Exception e17) {
                    w.f("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", e17);
                } catch (Throwable th6) {
                    w.f("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", th6);
                }
            }
            if (bitmap == null) {
                w.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
                dVar.a(i3, makeReturnJson("fail:illegal bitmap"));
                return;
            }
            Bitmap.CompressFormat a18 = d.a(jSONObject);
            String str = a18 == Bitmap.CompressFormat.JPEG ? "jpg" : "png";
            v allocTempFile = dVar.getFileSystem().allocTempFile("canvas_" + System.currentTimeMillis() + "." + str);
            if (allocTempFile == null) {
                w.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, alloc file failed");
                dVar.a(i3, makeReturnJson("fail alloc file failed"));
                return;
            }
            String g16 = allocTempFile.g();
            w.a("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, savePath = %s", g16);
            try {
                com.tencent.luggage.wxa.tn.d.a(bitmap, d.b(jSONObject), a18, g16, true);
                i iVar = new i();
                dVar.getFileSystem().createTempFileFrom(new v(g16), str, true, iVar);
                String str2 = (String) iVar.f141499a;
                w.a("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, returnPath = %s", str2);
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", str2);
                dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            } catch (IOException e18) {
                w.h("MicroMsg.JsApiXWebCanvasToTempFilePath", "save bitmap to file failed. exception : %s", e18);
                dVar.a(i3, makeReturnJson("fail:write file failed"));
            }
        } catch (JSONException e19) {
            w.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, %s", Log.getStackTraceString(e19));
            dVar.a(i3, makeReturnJson("fail:missing data"));
        }
    }

    public final boolean c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("data")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.se.d, com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (c(jSONObject)) {
            a(dVar, jSONObject, i3);
        } else {
            super.invoke(dVar, jSONObject, i3);
        }
    }

    public final int[] a(ByteBuffer byteBuffer) {
        byte[] a16 = c.a(byteBuffer);
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
}
