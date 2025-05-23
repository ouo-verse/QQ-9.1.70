package com.tencent.mobileqq.microapp.widget.media;

import android.graphics.Bitmap;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class h implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246228a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebviewContainer f246229b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f246230c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MiniAppCamera f246231d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MiniAppCamera miniAppCamera, String str, WebviewContainer webviewContainer, int i3) {
        this.f246231d = miniAppCamera;
        this.f246228a = str;
        this.f246229b = webviewContainer;
        this.f246230c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, miniAppCamera, str, webviewContainer, Integer.valueOf(i3));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        String str;
        Bitmap c16;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            z16 = MiniAppCamera.f246184n;
            if (z16) {
                try {
                    String a16 = com.tencent.mobileqq.microapp.appbrand.b.b.a().a("jpg");
                    File file = new File(a16);
                    file.getParentFile().mkdirs();
                    str = MiniAppCamera.f246185o;
                    c16 = MiniAppCamera.c(str);
                    if (c16 != null) {
                        MiniAppCamera.b(c16, file, "");
                        str2 = MiniAppCamera.f246185o;
                        if (StringUtil.isEmpty(str2)) {
                            this.f246231d.a(this.f246228a, this.f246229b, this.f246230c);
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tempThumbPath", com.tencent.mobileqq.microapp.appbrand.b.b.a().b(a16));
                        com.tencent.mobileqq.microapp.appbrand.b.b a17 = com.tencent.mobileqq.microapp.appbrand.b.b.a();
                        str3 = MiniAppCamera.f246185o;
                        jSONObject.put("tempVideoPath", a17.b(str3));
                        this.f246229b.appBrandRuntime.f245904i.evaluateCallbackJs(this.f246230c, jSONObject.toString());
                        boolean unused = MiniAppCamera.f246184n = false;
                        return;
                    }
                    this.f246231d.a(this.f246228a, this.f246229b, this.f246230c);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    this.f246231d.a(this.f246228a, this.f246229b, this.f246230c);
                    return;
                }
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
