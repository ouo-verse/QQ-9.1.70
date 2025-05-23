package com.tencent.qimei.au;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.as.a;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.shell.sdkinfo.UserInfoType;
import com.tencent.qimei.u.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, a> f343147d;

    /* renamed from: a, reason: collision with root package name */
    public final String f343148a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, String> f343149b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f343150c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20646);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343147d = new ConcurrentHashMap();
        }
    }

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343149b = new ConcurrentHashMap();
        this.f343150c = new AtomicBoolean(false);
        this.f343148a = str;
    }

    public static synchronized a a(String str) {
        a aVar;
        synchronized (a.class) {
            Map<String, a> map = f343147d;
            aVar = map.get(str);
            if (aVar == null) {
                aVar = new a(str);
                map.put(str, aVar);
            }
        }
        return aVar;
    }

    public String[] a() {
        c cVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Qimei a16 = com.tencent.qimei.an.a.a(this.f343148a);
        if (a16 != null && !a16.isEmpty()) {
            if (!a16.getQimei16().isEmpty()) {
                this.f343149b.put(UserInfoType.TYPE_Q16.toString(), a16.getQimei16());
            }
            if (!a16.getQimei36().isEmpty()) {
                this.f343149b.put(UserInfoType.TYPE_Q36.toString(), a16.getQimei36());
            }
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(this.f343148a).f343094b;
        aVar.getClass();
        this.f343149b.put(UserInfoType.TYPE_PRE_AUDIT_STATE.toString(), com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343116n, aVar.f343146r).booleanValue() ? "1" : "0");
        com.tencent.qimei.ae.a a17 = com.tencent.qimei.ae.a.a(this.f343148a);
        this.f343149b.put(UserInfoType.TYPE_OZ.toString(), a17.e());
        a17.e();
        if (!this.f343150c.get()) {
            synchronized (c.class) {
                cVar = c.f343390p;
            }
            String str2 = this.f343148a;
            com.tencent.qimei.ap.a aVar2 = new com.tencent.qimei.ap.a(str2);
            com.tencent.qimei.ae.a a18 = com.tencent.qimei.ae.a.a(str2);
            this.f343149b.put(UserInfoType.TYPE_SDK_VERSION.toString(), "2.1.2.132");
            this.f343149b.put(UserInfoType.TYPE_APP_KEY.toString(), this.f343148a);
            this.f343149b.put(UserInfoType.TYPE_NET_WORK_TYPE.toString(), cVar.e());
            Map<String, String> map = this.f343149b;
            String userInfoType = UserInfoType.TYPE_APP_VERSION.toString();
            if (com.tencent.qimei.u.a.f343384c == null) {
                com.tencent.qimei.u.a.f343384c = com.tencent.qimei.u.a.e();
            }
            map.put(userInfoType, com.tencent.qimei.u.a.f343384c);
            this.f343149b.put(UserInfoType.TYPE_CHANNEL_ID.toString(), aVar2.a());
            this.f343149b.put(UserInfoType.TYPE_USER_ID_PARAM.toString(), aVar2.h());
            Map<String, String> map2 = this.f343149b;
            String userInfoType2 = UserInfoType.TYPE_OS_VERSION.toString();
            synchronized (cVar) {
                str = cVar.f343395e;
                if (str == null) {
                    str = "Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK;
                    cVar.f343395e = str;
                }
            }
            map2.put(userInfoType2, str);
            this.f343149b.put(UserInfoType.TYPE_MODEL.toString(), a18.b());
            this.f343150c.set(true);
        }
        int a19 = UserInfoType.MAX_TYPE_SIZE.a();
        String[] strArr = new String[a19];
        for (Map.Entry<String, String> entry : this.f343149b.entrySet()) {
            int parseInt = Integer.parseInt(entry.getKey());
            if (parseInt < a19) {
                strArr[parseInt] = entry.getValue();
            }
        }
        return strArr;
    }
}
