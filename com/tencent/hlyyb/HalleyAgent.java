package com.tencent.hlyyb;

import android.content.Context;
import com.tencent.hlyyb.common.b.b;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HalleyAgent {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f114314a = false;

    /* renamed from: b, reason: collision with root package name */
    public static a f114315b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public HalleyAgent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (HalleyAgent.class) {
            if (f114314a) {
                return;
            }
            com.tencent.hlyyb.common.a.a(aVar.a(), aVar.c(), aVar.d(), aVar.b(), b.a(aVar.c()));
            f114314a = true;
        }
    }

    public static Downloader getDownloader() {
        if (f114314a) {
            return com.tencent.hlyyb.downloader.c.a.a();
        }
        throw new RuntimeException("halley not init");
    }

    public static void init(Context context, String str, String str2) {
        a aVar = new a(context, BaseConstants.CODE_SERVER_RETURN_ERROR, str2, str);
        f114315b = aVar;
        a(aVar);
    }

    public static void setFileLog(boolean z16, boolean z17) {
    }
}
