package com.tencent.mobileqq.microapp.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f246102a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebviewContainer f246103b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f246104c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f246105d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ CanvasView f246106e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CanvasView canvasView, JSONObject jSONObject, WebviewContainer webviewContainer, String str, int i3) {
        this.f246106e = canvasView;
        this.f246102a = jSONObject;
        this.f246103b = webviewContainer;
        this.f246104c = str;
        this.f246105d = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, canvasView, jSONObject, webviewContainer, str, Integer.valueOf(i3));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        float f16;
        float f17;
        float f18;
        float f19;
        Bitmap a16;
        float f26;
        float f27;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            try {
                f16 = this.f246106e.f246056k;
                int optDouble = (int) (f16 * this.f246102a.optDouble("destWidth"));
                f17 = this.f246106e.f246056k;
                int optDouble2 = (int) (f17 * this.f246102a.optDouble("destHeight"));
                if (QLog.isColorLevel()) {
                    str2 = CanvasView.f246046c;
                    QLog.d(str2, 2, "----saveBitmap---destWidth: " + optDouble + "---destHeight: " + optDouble2);
                }
                f18 = this.f246106e.f246056k;
                int optDouble3 = (int) ((f18 * (this.f246102a.optDouble("width") + this.f246102a.optDouble(HippyTKDListViewAdapter.X))) + 0.5d);
                f19 = this.f246106e.f246056k;
                int optDouble4 = (int) ((f19 * (this.f246102a.optDouble("height") + this.f246102a.optDouble("y"))) + 0.5d);
                Bitmap createBitmap = Bitmap.createBitmap(optDouble, optDouble2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                CanvasView canvasView = this.f246106e;
                a16 = canvasView.a((View) canvasView);
                if (a16 == null) {
                    this.f246103b.callbackJsEventFail(this.f246104c, null, this.f246105d);
                    return;
                }
                Rect rect = new Rect(0, 0, optDouble, optDouble2);
                f26 = this.f246106e.f246056k;
                int optDouble5 = (int) ((f26 * this.f246102a.optDouble(HippyTKDListViewAdapter.X)) + 0.5d);
                f27 = this.f246106e.f246056k;
                canvas.drawBitmap(a16, new Rect(optDouble5, (int) ((f27 * this.f246102a.optDouble("y")) + 0.5d), optDouble3, optDouble4), rect, (Paint) null);
                String optString = this.f246102a.optString(TagName.FILE_TYPE);
                String a17 = com.tencent.mobileqq.microapp.appbrand.b.b.a().a(optString);
                try {
                    fileOutputStream2 = new FileOutputStream(FileUtils.createFile(a17));
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
                try {
                    if ("png".equals(optString)) {
                        createBitmap.compress(Bitmap.CompressFormat.PNG, (int) (this.f246102a.optDouble(CustomImageProps.QUALITY) * 100.0d), fileOutputStream2);
                    } else if ("jpg".equals(optString)) {
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, (int) (this.f246102a.optDouble("jpgQuality") * 100.0d), fileOutputStream2);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tempFilePath", com.tencent.mobileqq.microapp.appbrand.b.b.a().b(a17));
                        this.f246103b.appBrandRuntime.f245904i.evaluateCallbackJs(this.f246105d, jSONObject.toString());
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        this.f246103b.callbackJsEventFail(this.f246104c, null, this.f246105d);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    if (!a16.isRecycled()) {
                        a16.recycle();
                        return;
                    }
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                    if (!a16.isRecycled()) {
                        a16.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                if (QLog.isColorLevel()) {
                    str = CanvasView.f246046c;
                    QLog.d(str, 2, "canvasToTempFilePath faile: " + th7.getLocalizedMessage());
                }
                this.f246103b.callbackJsEventFail(this.f246104c, null, this.f246105d);
                return;
            }
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
