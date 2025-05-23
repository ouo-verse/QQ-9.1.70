package com.tencent.treasurecard.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.treasurecard.FtConstants;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;
import com.tencent.treasurecard.httpNet.HttpRequest;
import so4.a;
import so4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements so4.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC11243a f381204a;

        a(a.InterfaceC11243a interfaceC11243a) {
            this.f381204a = interfaceC11243a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) interfaceC11243a);
            }
        }

        @Override // so4.b.a
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            com.tencent.treasurecard.util.d.c().j(i16);
            Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "request-callBack resultCode" + i3 + " cardState " + i16);
            this.f381204a.onChange(i16);
        }
    }

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            com.tencent.treasurecard.report.a.a().c(str, str2);
        }
    }

    @Override // so4.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return com.tencent.treasurecard.util.d.c().b();
    }

    @Override // so4.a
    public com.tencent.treasurecard.bean.d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.treasurecard.bean.d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String string = com.tencent.treasurecard.util.d.c().e().getString(FtConstants.TC_ACTIVE_URL + com.tencent.treasurecard.util.a.f381233a, "");
        String string2 = com.tencent.treasurecard.util.d.c().e().getString(FtConstants.TC_ACTIVE_TIPS + com.tencent.treasurecard.util.a.f381233a, "");
        if (!TextUtils.isEmpty(com.tencent.treasurecard.report.a.a().f381231f) && !TextUtils.isEmpty(string)) {
            string = string + "&from=$from";
        }
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "obtainCardInfo $from $orderUrl $message");
        return new com.tencent.treasurecard.bean.d(string, "", string2);
    }

    @Override // so4.a
    public void c(Context context, int i3, long j3, a.InterfaceC11243a interfaceC11243a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Long.valueOf(j3), interfaceC11243a);
            return;
        }
        so4.b i16 = d.i();
        i16.init(context);
        i16.e(new HttpRequest(context, i3));
        i16.a(j3);
        i16.d(new a(interfaceC11243a));
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "init");
    }
}
