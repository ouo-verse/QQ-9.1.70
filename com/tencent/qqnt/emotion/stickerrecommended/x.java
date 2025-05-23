package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public abstract class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f356663a;

    /* renamed from: b, reason: collision with root package name */
    public String f356664b;

    /* renamed from: c, reason: collision with root package name */
    public String f356665c;

    /* renamed from: d, reason: collision with root package name */
    public String f356666d;

    /* renamed from: e, reason: collision with root package name */
    public String f356667e;

    /* renamed from: f, reason: collision with root package name */
    public String f356668f;

    /* renamed from: g, reason: collision with root package name */
    public String f356669g;

    /* renamed from: h, reason: collision with root package name */
    public String f356670h;

    /* renamed from: i, reason: collision with root package name */
    public String f356671i;

    public x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract JSONObject a();
}
