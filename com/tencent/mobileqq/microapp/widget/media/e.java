package com.tencent.mobileqq.microapp.widget.media;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
final class e implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f246222a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f246223b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, byte[] bArr) {
        this.f246223b = dVar;
        this.f246222a = bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) bArr);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        float f16;
        String b16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            long j3 = Runtime.getRuntime().totalMemory() / 1024;
            long maxMemory = Runtime.getRuntime().maxMemory() / 1024;
            long freeMemory = Runtime.getRuntime().freeMemory() / 1024;
            long j16 = maxMemory - (j3 - freeMemory);
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppCamera", 2, "remain= " + j16 + ",totalMemory=" + j3 + ",maxMemory=" + maxMemory + ",freeMemory" + freeMemory);
            }
            if (j16 < 51200) {
                URLDrawable.clearMemoryCache();
                System.gc();
            }
            if (j16 < 81920) {
                z16 = true;
            } else {
                z16 = false;
            }
            byte[] bArr = this.f246222a;
            Bitmap b17 = com.tencent.mobileqq.util.j.b(bArr, 0, bArr.length);
            Matrix matrix = new Matrix();
            if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
                f16 = 270.0f;
            } else {
                f16 = 90.0f;
            }
            matrix.postRotate(f16);
            Bitmap createBitmap = Bitmap.createBitmap(b17, 0, 0, b17.getWidth(), b17.getHeight(), matrix, false);
            CameraSurfaceView.f246169a.stopPreview();
            if (z16) {
                System.gc();
            }
            File file = new File(com.tencent.mobileqq.microapp.appbrand.b.b.a().a("jpg"));
            file.getParentFile().mkdirs();
            b16 = MiniAppCamera.b(createBitmap, file, this.f246223b.f246218a);
            if (StringUtil.isEmpty(b16)) {
                JSONObject b18 = com.tencent.mobileqq.microapp.a.c.b(this.f246223b.f246219b, (JSONObject) null);
                if (b18 != null) {
                    str = b18.toString();
                } else {
                    str = "";
                }
                d dVar = this.f246223b;
                dVar.f246220c.appBrandRuntime.f245904i.evaluateCallbackJs(dVar.f246221d, str);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tempImagePath", com.tencent.mobileqq.microapp.appbrand.b.b.a().b(b16));
                d dVar2 = this.f246223b;
                dVar2.f246220c.appBrandRuntime.f245904i.evaluateCallbackJs(dVar2.f246221d, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
