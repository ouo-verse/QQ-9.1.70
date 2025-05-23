package com.tencent.could.huiyansdk.turing;

import android.content.Context;
import android.view.View;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public c f100269a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract int a(View view, CameraHolder cameraHolder, String str);

    public abstract String a();

    public abstract String a(String str, String str2);

    public abstract void a(Context context);

    public abstract void a(String str);

    public abstract void a(byte[] bArr);

    public abstract JSONObject b();

    public abstract String c();

    public abstract void d();
}
