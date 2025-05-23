package com.tencent.luggage.wxa.v1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.bf.f;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f142947a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142948b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f142949c;

        public a(l lVar, int i3, JSONObject jSONObject) {
            this.f142947a = lVar;
            this.f142948b = i3;
            this.f142949c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f142947a.isRunning()) {
                w.f("MicroMsg.WAGameJsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
                this.f142947a.a(this.f142948b, d.this.makeReturnJson("fail"));
                return;
            }
            v J = this.f142947a.J();
            if (((com.tencent.luggage.wxa.z1.d) J.f(com.tencent.luggage.wxa.z1.d.class)) == null) {
                this.f142947a.a(this.f142948b, d.this.makeReturnJson("fail"));
            } else {
                f a16 = d.a(J, this.f142949c, false);
                this.f142947a.a(this.f142948b, d.this.makeReturnJson(a16.f144873b, a16.f144872a));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tk.l.a().d(new a(lVar, i3, jSONObject));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ab A[Catch: RuntimeException -> 0x03ef, OutOfMemoryError -> 0x041d, TRY_ENTER, TRY_LEAVE, TryCatch #6 {RuntimeException -> 0x03ef, blocks: (B:27:0x00c8, B:30:0x00d9, B:31:0x00db, B:33:0x00fa, B:34:0x00fc, B:36:0x0103, B:37:0x0105, B:39:0x0125, B:40:0x0127, B:42:0x0162, B:44:0x0165, B:46:0x0168, B:48:0x016b, B:50:0x0173, B:52:0x017a, B:54:0x017d, B:65:0x01ab, B:67:0x01b4, B:68:0x01b6, B:70:0x01ba, B:72:0x01c0, B:79:0x0204, B:81:0x020c, B:82:0x0225, B:84:0x023f, B:85:0x0247, B:88:0x0256, B:90:0x025d, B:92:0x0267, B:93:0x0273, B:95:0x0277, B:97:0x028d, B:98:0x028f, B:100:0x029d, B:101:0x029f, B:106:0x02a8, B:108:0x02b3, B:109:0x02c2, B:113:0x01d3, B:114:0x01d7, B:118:0x01dc, B:120:0x01ef, B:123:0x01f3, B:128:0x031f, B:130:0x032f, B:131:0x0331, B:133:0x034f, B:134:0x0351, B:137:0x0367, B:138:0x0369, B:150:0x02c7, B:152:0x02d7, B:153:0x02d9, B:155:0x02f7, B:156:0x02f9, B:158:0x0312, B:159:0x0314, B:172:0x0376, B:174:0x037f, B:175:0x0381, B:177:0x018f, B:179:0x0385, B:182:0x0394, B:183:0x0396, B:185:0x03b8, B:186:0x03ba, B:210:0x03d3, B:212:0x03dc, B:213:0x03e8), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ba A[Catch: RuntimeException -> 0x03ef, OutOfMemoryError -> 0x041d, TryCatch #6 {RuntimeException -> 0x03ef, blocks: (B:27:0x00c8, B:30:0x00d9, B:31:0x00db, B:33:0x00fa, B:34:0x00fc, B:36:0x0103, B:37:0x0105, B:39:0x0125, B:40:0x0127, B:42:0x0162, B:44:0x0165, B:46:0x0168, B:48:0x016b, B:50:0x0173, B:52:0x017a, B:54:0x017d, B:65:0x01ab, B:67:0x01b4, B:68:0x01b6, B:70:0x01ba, B:72:0x01c0, B:79:0x0204, B:81:0x020c, B:82:0x0225, B:84:0x023f, B:85:0x0247, B:88:0x0256, B:90:0x025d, B:92:0x0267, B:93:0x0273, B:95:0x0277, B:97:0x028d, B:98:0x028f, B:100:0x029d, B:101:0x029f, B:106:0x02a8, B:108:0x02b3, B:109:0x02c2, B:113:0x01d3, B:114:0x01d7, B:118:0x01dc, B:120:0x01ef, B:123:0x01f3, B:128:0x031f, B:130:0x032f, B:131:0x0331, B:133:0x034f, B:134:0x0351, B:137:0x0367, B:138:0x0369, B:150:0x02c7, B:152:0x02d7, B:153:0x02d9, B:155:0x02f7, B:156:0x02f9, B:158:0x0312, B:159:0x0314, B:172:0x0376, B:174:0x037f, B:175:0x0381, B:177:0x018f, B:179:0x0385, B:182:0x0394, B:183:0x0396, B:185:0x03b8, B:186:0x03ba, B:210:0x03d3, B:212:0x03dc, B:213:0x03e8), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(v vVar, JSONObject jSONObject, boolean z16) {
        Class cls;
        int i3;
        Bitmap bitmap;
        float f16;
        Object[] objArr;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        float f17;
        int height;
        String str;
        float f18 = 0.0f;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                int i28 = jSONObject.getInt("canvasId");
                                if (vVar == null) {
                                    return new f("fail: no page", new Object[0]);
                                }
                                com.tencent.luggage.wxa.z1.d dVar = (com.tencent.luggage.wxa.z1.d) vVar.f(com.tencent.luggage.wxa.z1.d.class);
                                boolean optBoolean = jSONObject.optBoolean("isScreenCanvas", false);
                                if (dVar == null || dVar.c() == null) {
                                    bitmap = null;
                                } else if (!optBoolean) {
                                    bitmap = dVar.a(i28, z16);
                                } else {
                                    bitmap = dVar.c().getMagicBrush().s().a(dVar.c().getVirtualElementId(), -1, true);
                                }
                                if (bitmap == null) {
                                    w.f("MicroMsg.WAGameJsApiCanvasToTempFilePath", "get screenBitmap return null.");
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(807L, optBoolean ? 14L : 15L, 1L);
                                    return new f("fail:get bitmap failed", new Object[0]);
                                }
                                float width = bitmap.getWidth();
                                float height2 = bitmap.getHeight();
                                w.d("MicroMsg.WAGameJsApiCanvasToTempFilePath", "canvasWidth:%f,canvasHeight:%f", Float.valueOf(width), Float.valueOf(height2));
                                try {
                                    float optDouble = (float) jSONObject.optDouble(HippyTKDListViewAdapter.X, 0.0d);
                                    f18 = (float) jSONObject.optDouble("y", 0.0d);
                                    float optDouble2 = (float) jSONObject.optDouble("width", width);
                                    cls = com.tencent.luggage.wxa.zj.b.class;
                                    float optDouble3 = (float) jSONObject.optDouble("height", height2);
                                    Object[] objArr2 = new Object[4];
                                    boolean z17 = false;
                                    try {
                                        objArr2[0] = Float.valueOf(optDouble);
                                        objArr2[1] = Float.valueOf(f18);
                                        objArr2[2] = Float.valueOf(optDouble2);
                                        objArr2[3] = Float.valueOf(optDouble3);
                                        w.d("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,width:%f,height:%f", objArr2);
                                        if (optDouble + optDouble2 > width) {
                                            optDouble2 = width - optDouble;
                                        }
                                        f16 = optDouble2;
                                        if (f18 + optDouble3 > height2) {
                                            optDouble3 = height2 - f18;
                                        }
                                        float optDouble4 = (float) jSONObject.optDouble("destWidth", f16);
                                        float optDouble5 = (float) jSONObject.optDouble("destHeight", optDouble3);
                                        Object[] objArr3 = new Object[8];
                                        z17 = false;
                                        objArr3[0] = Float.valueOf(optDouble);
                                        objArr3[1] = Float.valueOf(f18);
                                        objArr3[2] = Float.valueOf(width);
                                        objArr3[3] = Float.valueOf(height2);
                                        objArr3[4] = Float.valueOf(f16);
                                        objArr3[5] = Float.valueOf(optDouble3);
                                        objArr3[6] = Float.valueOf(optDouble4);
                                        objArr3[7] = Float.valueOf(optDouble5);
                                        w.d("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,screenWidth:%f,screenHeight:%f,width:%f,height:%f,imgWidth:%f,imgHeight:%f", objArr3);
                                        int i29 = (int) optDouble;
                                        if (i29 >= 0 && (i16 = (int) f18) >= 0 && (i17 = (int) f16) > 0 && (i18 = (int) optDouble3) > 0 && ((int) (optDouble + f16)) <= ((int) width) && ((int) (f18 + optDouble3)) <= ((int) height2) && (i19 = (int) optDouble4) > 0 && (i26 = (int) optDouble5) > 0) {
                                            if (f16 == width && optDouble3 == height2) {
                                                i27 = i26;
                                                f17 = optDouble5;
                                                if (bitmap != null) {
                                                    w.b("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content null!");
                                                    return new f("fail:gen bitmap failed!", new Object[0]);
                                                }
                                                if (bitmap.getWidth() > 0 && (height = bitmap.getHeight()) > 0) {
                                                    try {
                                                        try {
                                                            try {
                                                                if (f16 != optDouble4 || optDouble3 != f17) {
                                                                    try {
                                                                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i19, i27, false);
                                                                        bitmap.recycle();
                                                                        if (createScaledBitmap == null) {
                                                                            try {
                                                                                try {
                                                                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(807L, 9L, 1L);
                                                                                    str = "fail:gen bitmap failed because of null pointer!";
                                                                                    try {
                                                                                        return new f(str, new Object[0]);
                                                                                    } catch (NullPointerException e16) {
                                                                                        e = e16;
                                                                                        bitmap = createScaledBitmap;
                                                                                        Object[] objArr4 = new Object[4];
                                                                                        objArr4[0] = Integer.valueOf(bitmap.getWidth());
                                                                                        objArr4[1] = Integer.valueOf(bitmap.getHeight());
                                                                                        objArr4[2] = Float.valueOf(optDouble4);
                                                                                        objArr4[3] = Float.valueOf(f17);
                                                                                        w.h("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", objArr4);
                                                                                        w.a("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: weired exception occured!!", new Object[0]);
                                                                                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(807L, 9L, 1L);
                                                                                        try {
                                                                                            return new f(str, new Object[0]);
                                                                                        } catch (OutOfMemoryError e17) {
                                                                                            e = e17;
                                                                                            i3 = 0;
                                                                                            w.a("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: out of memory!!", new Object[i3]);
                                                                                            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(807L, 12L, 1L);
                                                                                            return new f("fail:out of memory!", new Object[0]);
                                                                                        }
                                                                                    }
                                                                                } catch (IllegalArgumentException e18) {
                                                                                    e = e18;
                                                                                    bitmap = createScaledBitmap;
                                                                                    Object[] objArr5 = new Object[4];
                                                                                    objArr5[0] = Integer.valueOf(bitmap.getWidth());
                                                                                    objArr5[1] = Integer.valueOf(bitmap.getHeight());
                                                                                    objArr5[2] = Float.valueOf(optDouble4);
                                                                                    objArr5[3] = Float.valueOf(f17);
                                                                                    w.h("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", objArr5);
                                                                                    w.a("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: illegalArgument exception occured!!", new Object[0]);
                                                                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(807L, 10L, 1L);
                                                                                    return new f("fail:gen bitmap failed because of illegal argument!", new Object[0]);
                                                                                }
                                                                            } catch (NullPointerException e19) {
                                                                                e = e19;
                                                                                str = "fail:gen bitmap failed because of null pointer!";
                                                                            }
                                                                        } else {
                                                                            bitmap = createScaledBitmap;
                                                                        }
                                                                    } catch (IllegalArgumentException e26) {
                                                                        e = e26;
                                                                    } catch (NullPointerException e27) {
                                                                        e = e27;
                                                                        str = "fail:gen bitmap failed because of null pointer!";
                                                                    }
                                                                }
                                                                Bitmap.CompressFormat a16 = com.tencent.luggage.wxa.se.d.a(jSONObject);
                                                                if (a16 == Bitmap.CompressFormat.PNG) {
                                                                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
                                                                    new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                                                                    bitmap = createBitmap;
                                                                }
                                                                String genMediaFilePath = AppBrandLocalMediaObjectManager.genMediaFilePath(vVar.getAppId(), "canvas_" + i28);
                                                                try {
                                                                    com.tencent.luggage.wxa.tn.d.a(bitmap, com.tencent.luggage.wxa.se.d.b(jSONObject), a16, genMediaFilePath, true);
                                                                    com.tencent.luggage.wxa.rc.c a17 = AppBrandLocalMediaObjectManager.a(vVar.getAppId(), genMediaFilePath, a16 == Bitmap.CompressFormat.JPEG ? "jpg" : "png", true);
                                                                    if (a17 == null) {
                                                                        Object[] objArr6 = new Object[1];
                                                                        objArr6[0] = Integer.valueOf(i28);
                                                                        w.h("MicroMsg.WAGameJsApiCanvasToTempFilePath", "gen temp file failed, canvasId : %s.", objArr6);
                                                                        return new f("fail:gen temp file failed", new Object[0]);
                                                                    }
                                                                    HashMap hashMap = new HashMap();
                                                                    hashMap.put("tempFilePath", a17.f139471a);
                                                                    Object[] objArr7 = new Object[2];
                                                                    objArr7[0] = a17.f139471a;
                                                                    objArr7[1] = a17.f139472b;
                                                                    w.g("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save file(id : %s) to path : %s", objArr7);
                                                                    return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]).a(hashMap);
                                                                } catch (IOException e28) {
                                                                    Object[] objArr8 = new Object[2];
                                                                    objArr8[0] = Integer.valueOf(i28);
                                                                    objArr8[1] = e28;
                                                                    w.h("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", objArr8);
                                                                    return new f("fail:write file failed", new Object[0]);
                                                                }
                                                            } catch (OutOfMemoryError e29) {
                                                                e = e29;
                                                                i3 = height;
                                                            }
                                                        } catch (OutOfMemoryError e36) {
                                                            e = e36;
                                                            i3 = f18;
                                                            w.a("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: out of memory!!", new Object[i3]);
                                                            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(807L, 12L, 1L);
                                                            return new f("fail:out of memory!", new Object[0]);
                                                        }
                                                    } catch (OutOfMemoryError e37) {
                                                        e = e37;
                                                        i3 = f16;
                                                    }
                                                } else {
                                                    w.b("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content width or height <=0!");
                                                    return new f("fail:gen bitmap failed!", new Object[0]);
                                                }
                                            }
                                            f18 = 0.0f;
                                            i27 = i26;
                                            f17 = optDouble5;
                                            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, i29, i16, i17, i18, (Matrix) null, false);
                                            bitmap.recycle();
                                            bitmap = createBitmap2;
                                            if (bitmap != null) {
                                            }
                                        }
                                        objArr = new Object[5];
                                    } catch (OutOfMemoryError e38) {
                                        e = e38;
                                        i3 = z17;
                                    }
                                    try {
                                        objArr[0] = Float.valueOf(optDouble);
                                        objArr[1] = Float.valueOf(f18);
                                        objArr[2] = Float.valueOf(f16);
                                        objArr[3] = Float.valueOf(optDouble3);
                                        objArr[4] = Integer.valueOf(i28);
                                        w.b("MicroMsg.WAGameJsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, canvasId(%s).", objArr);
                                        return new f("fail:illegal arguments", new Object[0]);
                                    } catch (OutOfMemoryError e39) {
                                        e = e39;
                                        i3 = 0;
                                        w.a("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: out of memory!!", new Object[i3]);
                                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(807L, 12L, 1L);
                                        return new f("fail:out of memory!", new Object[0]);
                                    }
                                } catch (OutOfMemoryError e46) {
                                    e = e46;
                                    cls = com.tencent.luggage.wxa.zj.b.class;
                                    i3 = 0;
                                    w.a("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: out of memory!!", new Object[i3]);
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(807L, 12L, 1L);
                                    return new f("fail:out of memory!", new Object[0]);
                                }
                            } catch (OutOfMemoryError e47) {
                                e = e47;
                            }
                        } catch (JSONException e48) {
                            Object[] objArr9 = new Object[1];
                            objArr9[0] = e48;
                            w.h("MicroMsg.WAGameJsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", objArr9);
                            return new f("fail:canvasId do not exist", new Object[0]);
                        }
                    } catch (RuntimeException e49) {
                        e = e49;
                        w.a("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: runtime exception!", new Object[0]);
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(807L, 13L, 1L, false);
                        return new f("fail:runtime exception! %s", e.toString());
                    }
                } catch (OutOfMemoryError e56) {
                    e = e56;
                    cls = com.tencent.luggage.wxa.zj.b.class;
                }
            } catch (OutOfMemoryError e57) {
                e = e57;
                i3 = "fail:gen bitmap failed because of null pointer!";
            }
        } catch (RuntimeException e58) {
            e = e58;
        }
    }
}
