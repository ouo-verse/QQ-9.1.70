package com.tencent.luggage.wxa.se;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
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
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f140294a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f140295b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f140296c;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3, JSONObject jSONObject) {
            this.f140294a = dVar;
            this.f140295b = i3;
            this.f140296c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f140294a.isRunning()) {
                w.f("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
                this.f140294a.a(this.f140295b, d.this.makeReturnJson("fail"));
                return;
            }
            com.tencent.luggage.wxa.xd.f a16 = ((com.tencent.luggage.wxa.ee.g) this.f140294a.b(com.tencent.luggage.wxa.ee.g.class)).a(this.f140294a, this.f140296c);
            if (a16 != null) {
                d.this.a(a16, this.f140296c, new com.tencent.luggage.wxa.ee.j(this.f140294a, this.f140295b));
            } else {
                w.f("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
                this.f140294a.a(this.f140295b, d.this.makeReturnJson("fail:page is null"));
            }
        }
    }

    public static int b(JSONObject jSONObject) {
        float optDouble = (float) jSONObject.optDouble(CustomImageProps.QUALITY, 1.0d);
        float f16 = 0.0f;
        if (optDouble >= 0.0f) {
            if (optDouble > 1.0f) {
                f16 = 100.0f;
            } else {
                f16 = optDouble * 100.0f;
            }
        }
        return (int) f16;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tk.l.a().d(new a(dVar, i3, jSONObject));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject, com.tencent.luggage.wxa.ee.j jVar) {
        String str;
        String str2;
        int i3;
        com.tencent.luggage.wxa.ee.j jVar2;
        int i16;
        d dVar;
        String str3;
        int i17;
        com.tencent.luggage.wxa.ee.j jVar3;
        d dVar2;
        String str4;
        int i18;
        int i19;
        d dVar3;
        com.tencent.luggage.wxa.ee.j jVar4;
        String str5;
        String str6;
        int i26;
        String str7;
        d dVar4;
        com.tencent.luggage.wxa.ee.j jVar5;
        String str8;
        String str9;
        int i27;
        d dVar5;
        com.tencent.luggage.wxa.ee.j jVar6;
        char c16;
        String str10;
        int i28;
        int i29;
        char c17;
        Bitmap createScaledBitmap;
        Object[] objArr;
        try {
            int i36 = jSONObject.getInt("canvasId");
            View c18 = fVar.a(jSONObject.optBoolean("independent", false)).c(i36);
            if (c18 == null) {
                w.h("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", Integer.valueOf(i36));
                jVar.a(makeReturnJson("fail:get canvas by canvasId failed"));
                return;
            }
            if (!(c18 instanceof com.tencent.luggage.wxa.ye.b)) {
                w.h("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", Integer.valueOf(i36));
                jVar.a(makeReturnJson("fail:the view is not a instance of CoverViewContainer"));
                return;
            }
            View view = (View) ((com.tencent.luggage.wxa.ye.b) c18).a(View.class);
            if (view == 0) {
                w.h("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", Integer.valueOf(i36));
                jVar.a(makeReturnJson("fail:target view is null."));
                return;
            }
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            try {
                try {
                    try {
                        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                        float a16 = com.tencent.luggage.wxa.tk.g.a(jSONObject, HippyTKDListViewAdapter.X);
                        float a17 = com.tencent.luggage.wxa.tk.g.a(jSONObject, "y");
                        float f16 = measuredWidth;
                        float a18 = com.tencent.luggage.wxa.tk.g.a(jSONObject, "width", f16);
                        float f17 = measuredHeight;
                        float a19 = com.tencent.luggage.wxa.tk.g.a(jSONObject, "height", f17);
                        if (a16 + a18 > f16) {
                            a18 = f16 - a16;
                        }
                        if (a17 + a19 > f17) {
                            a19 = f17 - a17;
                        }
                        float a26 = w0.a(jSONObject.optString("destWidth"), a18);
                        float a27 = w0.a(jSONObject.optString("destHeight"), a19);
                        int i37 = (int) a16;
                        if (i37 >= 0) {
                            int i38 = (int) a17;
                            if (i38 >= 0) {
                                int i39 = (int) a18;
                                if (i39 > 0) {
                                    int i46 = (int) a19;
                                    if (i46 > 0 && ((int) (a16 + a18)) <= measuredWidth && ((int) (a17 + a19)) <= measuredHeight && (i18 = (int) a26) > 0 && (i19 = (int) a27) > 0) {
                                        if (view instanceof com.tencent.luggage.wxa.dd.b) {
                                            ((com.tencent.luggage.wxa.dd.b) view).a(new com.tencent.luggage.wxa.vc.f(createBitmap));
                                        } else {
                                            view.draw(new com.tencent.luggage.wxa.vc.f(createBitmap));
                                        }
                                        if (a18 == f16 && a19 == f17) {
                                            str7 = "MicroMsg.JsApiCanvasToTempFilePath";
                                        } else {
                                            try {
                                                Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, i37, i38, i39, i46, (Matrix) null, false);
                                                str7 = "MicroMsg.JsApiCanvasToTempFilePath";
                                                try {
                                                    w.d(str7, "bitmap recycle %s", createBitmap);
                                                    createBitmap.recycle();
                                                    createBitmap = createBitmap2;
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    dVar4 = this;
                                                    jVar5 = jVar;
                                                    str8 = "create bitmap failed, viewId(%s). Exception : %s";
                                                    str9 = "fail:create bitmap failed";
                                                    i27 = i36;
                                                    w.h(str7, str8, Integer.valueOf(i27), e);
                                                    jVar5.a(dVar4.makeReturnJson(str9));
                                                    return;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    dVar3 = this;
                                                    jVar4 = jVar;
                                                    str5 = "fail:create bitmap failed";
                                                    str6 = "create bitmap failed, viewId(%s). Throwable : %s";
                                                    i26 = i36;
                                                    w.h(str7, str6, Integer.valueOf(i26), th);
                                                    jVar4.a(dVar3.makeReturnJson(str5));
                                                    return;
                                                }
                                            } catch (Exception e17) {
                                                e = e17;
                                                dVar4 = this;
                                                jVar5 = jVar;
                                                str8 = "create bitmap failed, viewId(%s). Exception : %s";
                                                str9 = "fail:create bitmap failed";
                                                i27 = i36;
                                                str7 = "MicroMsg.JsApiCanvasToTempFilePath";
                                            } catch (Throwable th6) {
                                                th = th6;
                                                dVar3 = this;
                                                jVar4 = jVar;
                                                str5 = "fail:create bitmap failed";
                                                str6 = "create bitmap failed, viewId(%s). Throwable : %s";
                                                i26 = i36;
                                                str7 = "MicroMsg.JsApiCanvasToTempFilePath";
                                            }
                                        }
                                        if (a18 != a26 || a19 != a27) {
                                            try {
                                                try {
                                                    createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i18, i19, false);
                                                    c17 = 1;
                                                    try {
                                                        objArr = new Object[1];
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        dVar5 = this;
                                                        jVar6 = jVar;
                                                        i28 = i36;
                                                        c16 = 0;
                                                        str10 = "fail:create bitmap failed";
                                                        i29 = 2;
                                                    }
                                                } catch (Exception e19) {
                                                    e = e19;
                                                    dVar5 = this;
                                                    jVar6 = jVar;
                                                    c16 = 0;
                                                    str10 = "fail:create bitmap failed";
                                                    i28 = i36;
                                                }
                                                try {
                                                    objArr[0] = createBitmap;
                                                    try {
                                                        w.d(str7, "bitmap recycle %s", objArr);
                                                        createBitmap.recycle();
                                                        createBitmap = createScaledBitmap;
                                                    } catch (Exception e26) {
                                                        e = e26;
                                                        dVar5 = this;
                                                        jVar6 = jVar;
                                                        i28 = i36;
                                                        str10 = "fail:create bitmap failed";
                                                        i29 = 2;
                                                        c17 = 1;
                                                        c16 = 0;
                                                        Object[] objArr2 = new Object[i29];
                                                        objArr2[c16] = Integer.valueOf(i28);
                                                        objArr2[c17] = e;
                                                        w.h(str7, "create bitmap failed, viewId(%s). Exception : %s", objArr2);
                                                        jVar6.a(dVar5.makeReturnJson(str10));
                                                        return;
                                                    }
                                                } catch (Exception e27) {
                                                    e = e27;
                                                    dVar5 = this;
                                                    jVar6 = jVar;
                                                    i28 = i36;
                                                    c16 = 0;
                                                    str10 = "fail:create bitmap failed";
                                                    i29 = 2;
                                                    c17 = 1;
                                                    Object[] objArr22 = new Object[i29];
                                                    objArr22[c16] = Integer.valueOf(i28);
                                                    objArr22[c17] = e;
                                                    w.h(str7, "create bitmap failed, viewId(%s). Exception : %s", objArr22);
                                                    jVar6.a(dVar5.makeReturnJson(str10));
                                                    return;
                                                }
                                            } catch (Throwable th7) {
                                                w.h(str7, "create bitmap failed, viewId(%s). Throwable : %s", Integer.valueOf(i36), th7);
                                                jVar.a(makeReturnJson("fail:create bitmap failed"));
                                                return;
                                            }
                                        }
                                        Bitmap.CompressFormat a28 = a(jSONObject);
                                        String str11 = a28 == Bitmap.CompressFormat.JPEG ? "jpg" : "png";
                                        v allocTempFile = fVar.getFileSystem().allocTempFile("canvas_" + i36 + "." + str11);
                                        if (allocTempFile == null) {
                                            w.b(str7, "toTempFilePath, alloc file failed");
                                            jVar.a(makeReturnJson("fail alloc file failed"));
                                            return;
                                        }
                                        String g16 = allocTempFile.g();
                                        w.a(str7, "toTempFilePath, savePath = %s", g16);
                                        try {
                                            com.tencent.luggage.wxa.tn.d.a(createBitmap, b(jSONObject), a28, g16, true);
                                            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                                            fVar.getFileSystem().createTempFileFrom(new v(g16), str11, true, iVar);
                                            String str12 = (String) iVar.f141499a;
                                            w.a(str7, "toTempFilePath, returnPath = %s", str12);
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("tempFilePath", str12);
                                            jVar.a(makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                                            return;
                                        } catch (IOException e28) {
                                            w.h(str7, "save bitmap to file failed, viewId(%s). exception : %s", Integer.valueOf(i36), e28);
                                            jVar.a(makeReturnJson("fail:write file failed"));
                                            return;
                                        } catch (Throwable th8) {
                                            w.h(str7, "save bitmap to file failed, viewId(%s). throwable : %s", Integer.valueOf(i36), th8);
                                            jVar.a(makeReturnJson("fail:write file failed"));
                                            return;
                                        }
                                    }
                                    dVar2 = this;
                                    jVar3 = jVar;
                                    i17 = i36;
                                    str4 = "MicroMsg.JsApiCanvasToTempFilePath";
                                } else {
                                    jVar3 = jVar;
                                    str4 = "MicroMsg.JsApiCanvasToTempFilePath";
                                    i17 = i36;
                                    dVar2 = this;
                                }
                            } else {
                                str4 = "MicroMsg.JsApiCanvasToTempFilePath";
                                i17 = i36;
                                dVar2 = this;
                                jVar3 = jVar;
                            }
                        } else {
                            i17 = i36;
                            jVar3 = jVar;
                            dVar2 = this;
                            str4 = "MicroMsg.JsApiCanvasToTempFilePath";
                        }
                        w.b(str4, "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", Float.valueOf(a16), Float.valueOf(a17), Float.valueOf(a18), Float.valueOf(a19), Integer.valueOf(i17));
                        jVar3.a(dVar2.makeReturnJson("fail:illegal arguments"));
                    } catch (Exception e29) {
                        e = e29;
                        str = "create bitmap failed, viewId(%s). Exception : %s";
                        str2 = "fail:create bitmap failed";
                        i3 = i36;
                        jVar2 = jVar;
                        dVar = this;
                        str3 = "MicroMsg.JsApiCanvasToTempFilePath";
                        i16 = 2;
                        Object[] objArr3 = new Object[i16];
                        objArr3[0] = Integer.valueOf(i3);
                        objArr3[1] = e;
                        w.h(str3, str, objArr3);
                        jVar2.a(dVar.makeReturnJson(str2));
                    }
                } catch (Throwable th9) {
                    w.h("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", Integer.valueOf(i36), th9);
                    jVar.a(makeReturnJson("fail:create bitmap failed"));
                }
            } catch (Exception e36) {
                e = e36;
                str = "create bitmap failed, viewId(%s). Exception : %s";
                str2 = "fail:create bitmap failed";
                i3 = i36;
                jVar2 = jVar;
                i16 = 2;
                dVar = this;
                str3 = "MicroMsg.JsApiCanvasToTempFilePath";
            }
        } catch (JSONException e37) {
            w.h("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", e37);
            jVar.a(makeReturnJson("fail:canvasId do not exist"));
        }
    }

    public static Bitmap.CompressFormat a(JSONObject jSONObject) {
        return "jpg".equalsIgnoreCase(jSONObject.optString(TagName.FILE_TYPE)) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }
}
