package com.tencent.qqnt.beacon;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.inject.b;
import com.tencent.mobileqq.injector.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NTBeaconReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f353056a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Service/beacon/Inject_AppSetting.yml", version = 1)
    static b f353057b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f353058c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41972);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f353058c = arrayList;
        arrayList.add(d.class);
        f353056a = new AtomicBoolean(false);
    }

    static void b() {
        if (f353057b == null) {
            c();
        }
    }

    @QAutoInitMethod
    static void c() {
        f353057b = (b) com.tencent.mobileqq.qroute.utils.b.a(f353058c);
    }

    protected static void d(EventResult eventResult) {
        if (eventResult.isSuccess()) {
            return;
        }
        b();
        if ((f353057b.isDebugVersion() || eventResult.errorCode != 101) && QLog.isColorLevel()) {
            QLog.d("NTBeaconReport", 2, "EventResult{ eventID:" + eventResult.eventID + ", errorCode: " + eventResult.errorCode + ", errorMsg: " + eventResult.errMsg + "}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17, boolean z18) {
        if (!TextUtils.isEmpty(str3)) {
            BeaconEvent.Builder builder = BeaconEvent.builder();
            if (!TextUtils.isEmpty(str)) {
                builder.withAppKey(str);
            }
            if (map == null) {
                map = new HashMap<>();
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put("user_uin", str2);
            }
            builder.withCode(str3);
            builder.withIsSucceed(z16);
            if (z17) {
                builder.withType(EventType.REALTIME);
            }
            builder.withParams(map);
            d(BeaconReport.getInstance().report(builder.build()));
            return;
        }
        throw new RuntimeException("report a event with a empty key!");
    }

    public static void f(String str) {
        g("", str);
    }

    public static void g(String str, String str2) {
        h(str, str2, new HashMap());
    }

    public static void h(String str, String str2, Map<String, String> map) {
        i(str, str2, map, false);
    }

    public static void i(String str, String str2, Map<String, String> map, boolean z16) {
        j(str, str2, true, map, z16);
    }

    public static void j(String str, String str2, boolean z16, Map<String, String> map, boolean z17) {
        k("", str, str2, z16, map, z17, false);
    }

    private static void k(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17, boolean z18) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            ThreadManagerV2.excute(new Runnable(str, str2, str3, z16, map, z17, z18) { // from class: com.tencent.qqnt.beacon.NTBeaconReport.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f353059d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f353060e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f353061f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f353062h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ Map f353063i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ boolean f353064m;

                {
                    this.f353059d = str;
                    this.f353060e = str2;
                    this.f353061f = str3;
                    this.f353062h = z16;
                    this.f353063i = map;
                    this.f353064m = z17;
                    this.C = z18;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, str2, str3, Boolean.valueOf(z16), map, Boolean.valueOf(z17), Boolean.valueOf(z18));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        NTBeaconReport.e(this.f353059d, this.f353060e, this.f353061f, this.f353062h, this.f353063i, this.f353064m, this.C);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, false);
        } else {
            e(str, str2, str3, z16, map, z17, z18);
        }
    }

    public static void l(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17) {
        k(str, str2, str3, z16, map, z17, false);
    }
}
