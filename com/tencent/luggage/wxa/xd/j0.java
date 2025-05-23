package com.tencent.luggage.wxa.xd;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 250;
    public static final String NAME = "captureScreen";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends com.tencent.luggage.wxa.tn.s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f144853h;

        public a(com.tencent.luggage.wxa.kj.v vVar) {
            this.f144853h = vVar;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Bitmap a() {
            return this.f144853h.w0();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "captureScreen, appId:%s", lVar.getAppId());
        com.tencent.luggage.wxa.kj.p Y = lVar.getRuntime().Y();
        if (Y != null && Y.getPageView() != null) {
            if (Y.getPageView() == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
                lVar.a(i3, makeReturnJson("fail:container or page is null"));
                return;
            }
            Bitmap a16 = a(lVar);
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiCaptureScreen", "bitmap is null, err return");
                lVar.a(i3, makeReturnJson("fail:can't captureScreen"));
                return;
            }
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            com.tencent.luggage.wxa.rc.l tempDirectory = lVar.getFileSystem().getTempDirectory(iVar);
            com.tencent.luggage.wxa.rc.l lVar2 = com.tencent.luggage.wxa.rc.l.OK;
            if (tempDirectory != lVar2) {
                lVar.a(i3, makeReturnJson("fail:gen temp file failed"));
                return;
            }
            String g16 = new com.tencent.luggage.wxa.cp.v((String) iVar.f141499a, "appbrand_capture_" + System.currentTimeMillis()).g();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "capture bitmap path:%s", g16);
            try {
                try {
                    com.tencent.luggage.wxa.tn.d.a(a16, 100, Bitmap.CompressFormat.PNG, g16, true);
                    com.tencent.luggage.wxa.tk.i iVar2 = new com.tencent.luggage.wxa.tk.i();
                    if (lVar.getFileSystem().createTempFileFrom(new com.tencent.luggage.wxa.cp.v(g16), "png", true, iVar2) != lVar2) {
                        com.tencent.luggage.wxa.tn.w.h("MicroMsg.JsApiCaptureScreen", "create temp file failed, path:%s", g16);
                        lVar.a(i3, makeReturnJson("fail:gen temp file failed"));
                        if (a16.isRecycled()) {
                            return;
                        }
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", a16);
                        a16.recycle();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempFilePath", (String) iVar2.f141499a);
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "capture bitmap tempFilePath:%s", iVar2.f141499a);
                    lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                    if (a16.isRecycled()) {
                        return;
                    }
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", a16);
                    a16.recycle();
                    return;
                } catch (IOException e16) {
                    com.tencent.luggage.wxa.tn.w.h("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e16);
                    lVar.a(i3, makeReturnJson("fail:IOException"));
                    if (a16.isRecycled()) {
                        return;
                    }
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", a16);
                    a16.recycle();
                    return;
                } catch (Exception e17) {
                    com.tencent.luggage.wxa.tn.w.h("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e17);
                    lVar.a(i3, makeReturnJson("fail:Exception"));
                    if (a16.isRecycled()) {
                        return;
                    }
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", a16);
                    a16.recycle();
                    return;
                }
            } catch (Throwable th5) {
                if (!a16.isRecycled()) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", a16);
                    a16.recycle();
                }
                throw th5;
            }
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
        lVar.a(i3, makeReturnJson("fail:container or page is null"));
    }

    public Bitmap a(com.tencent.luggage.wxa.ic.l lVar) {
        com.tencent.luggage.wxa.kj.v J = lVar.J();
        if (J == null) {
            return null;
        }
        return (Bitmap) new a(J).a(new com.tencent.luggage.wxa.tn.b0(Looper.getMainLooper()));
    }
}
