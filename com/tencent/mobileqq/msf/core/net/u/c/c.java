package com.tencent.mobileqq.msf.core.net.u.c;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f249440f = "EndpointChannel";

    /* renamed from: g, reason: collision with root package name */
    private static int f249441g;

    /* renamed from: a, reason: collision with root package name */
    private final int f249442a;

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f249443b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f249444c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.d f249445d;

    /* renamed from: e, reason: collision with root package name */
    private i f249446e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(EmojiHomeUiPlugin.HOMEPAGE_RDM_EVENT_REDIRECT_LOOP);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public c(com.tencent.mobileqq.msf.core.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            return;
        }
        int i3 = f249441g;
        f249441g = i3 + 1;
        this.f249442a = i3;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("EndpointChannel_" + i3);
        this.f249443b = baseHandlerThread;
        baseHandlerThread.start();
        this.f249444c = new Handler(baseHandlerThread.getLooper());
        this.f249445d = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(d dVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar)).booleanValue();
        }
        if (this.f249446e == null) {
            try {
                i iVar = new i(this.f249445d);
                this.f249446e = iVar;
                iVar.connect(InetAddress.getByName(this.f249445d.b()), this.f249445d.d());
                this.f249446e.setSoTimeout(com.tencent.mobileqq.msf.core.x.d.X0() * 1000);
            } catch (SocketException e16) {
                QLog.e(f249440f, 1, "[post] create socket error. ", e16);
                z16 = false;
                if (z16) {
                }
                return !z16 ? false : false;
            } catch (UnknownHostException e17) {
                QLog.e(f249440f, 1, "[post] endpoint unknown. ", e17);
                z16 = false;
                if (z16) {
                }
                if (!z16) {
                }
            } catch (Exception e18) {
                QLog.e(f249440f, 1, "[post] unknown exception. ", e18);
                z16 = false;
                if (z16) {
                }
                if (!z16) {
                }
            }
        }
        z16 = true;
        if (z16) {
            dVar.a(this.f249446e);
        }
        if (!z16 && this.f249444c.post(dVar)) {
            return true;
        }
    }

    public boolean a(com.tencent.mobileqq.msf.core.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f249445d.equals(dVar) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar)).booleanValue();
    }
}
