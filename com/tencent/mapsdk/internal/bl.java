package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.shell.events.ReportEvent;
import java.net.URLEncoder;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class bl {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bl f147889a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f147890b = false;

    bl() {
    }

    public static bl a() {
        if (f147889a == null) {
            synchronized (bl.class) {
                if (f147889a == null) {
                    f147889a = new bl();
                }
            }
        }
        return f147889a;
    }

    public final synchronized void a(bp bpVar) {
        if (this.f147890b) {
            return;
        }
        if (bpVar != null && !bpVar.u().a()) {
            kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.mapsdk.internal.bl.1
                private static Boolean a() throws Exception {
                    try {
                        dz dzVar = (dz) cr.a(dz.class);
                        if (TextUtils.isEmpty(ho.e())) {
                            ho.e();
                        }
                        NetResponse launchStat = ((dk) dzVar.i()).launchStat(ht.a(), URLEncoder.encode(ht.c(), "utf-8"), ho.d(), ho.e(), ho.j(), ho.k(), ho.n(), ho.c(), ho.g());
                        if (launchStat != null) {
                            LogUtil.b("LaunchStat data with response:" + new String(launchStat.data, launchStat.charset));
                        }
                    } catch (Exception e16) {
                        LogUtil.d("err:" + e16.getMessage());
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("cm_model", ht.c());
                    u.a();
                    new ReportEvent("cm_stat", hashMap);
                    return Boolean.TRUE;
                }

                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() throws Exception {
                    return a();
                }
            }).a((kp.b.a) Boolean.FALSE);
            this.f147890b = true;
        }
    }
}
