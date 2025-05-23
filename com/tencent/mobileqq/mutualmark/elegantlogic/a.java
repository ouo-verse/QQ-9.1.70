package com.tencent.mobileqq.mutualmark.elegantlogic;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.x;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.info.d;
import com.tencent.mobileqq.mutualmark.info.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.config.toggle.c;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar) {
        try {
            if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion() && c.f364710w.g(false)) {
                b(aVar, xVar);
            }
        } catch (Throwable th5) {
            QLog.e("ElegantIntimatePushHelper", 1, th5, new Object[0]);
        }
    }

    private static void b(com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar) {
        if (xVar != null && aVar != null) {
            QLog.e("ElegantIntimatePushHelper", 1, "handleMutualMarkDataAfterPushInner, changeType=" + xVar.f180249c);
            f fVar = new f(aVar);
            int i3 = xVar.f180249c;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        switch (i3) {
                            default:
                                switch (i3) {
                                }
                            case 10001:
                            case 10002:
                            case 10003:
                            case 10004:
                            case 10005:
                                d(xVar, fVar);
                                break;
                        }
                        fVar.a(aVar);
                        return;
                    }
                }
                c(xVar, fVar);
                fVar.a(aVar);
                return;
            }
            d(xVar, fVar);
            fVar.a(aVar);
            return;
        }
        QLog.e("ElegantIntimatePushHelper", 1, "handleMutualMarkDataAfterPushInner fail, changeInfo=" + xVar + ",extensionInfo=" + aVar);
    }

    private static void c(x xVar, f fVar) {
        ConcurrentHashMap<Long, d> concurrentHashMap;
        x.c cVar;
        if (fVar != null && (concurrentHashMap = fVar.f252151a) != null && xVar != null && (cVar = xVar.f180251e) != null) {
            if (concurrentHashMap.containsKey(Long.valueOf(cVar.f180260a))) {
                fVar.f252151a.remove(Long.valueOf(xVar.f180251e.f180260a));
            }
            QLog.i("ElegantIntimatePushHelper", 1, "handleMutualMarkNegativePush, intimate_type=" + xVar.f180251e.f180260a);
            return;
        }
        QLog.e("ElegantIntimatePushHelper", 1, "handleMutualMarkDelPush fail, null found");
    }

    private static void d(x xVar, f fVar) {
        x.c cVar;
        if (fVar != null && xVar != null && (cVar = xVar.f180252f) != null && cVar.f180261b != null) {
            if (fVar.f252151a == null) {
                fVar.f252151a = new ConcurrentHashMap<>();
            }
            d dVar = fVar.f252151a.get(Long.valueOf(xVar.f180252f.f180260a));
            if (dVar == null) {
                dVar = new d();
            }
            x.c cVar2 = xVar.f180252f;
            dVar.f252109a = cVar2.f180260a;
            dVar.f252110b = cVar2.a();
            dVar.f252117i = xVar.f180252f.b();
            x.c.b bVar = xVar.f180252f.f180261b;
            if (bVar != null && !TextUtils.isEmpty(bVar.f180277m)) {
                dVar.f252124p = xVar.f180252f.f180261b.f180277m;
                QLog.i("ElegantIntimatePushHelper", 1, "handleMutualMarkPositivePush,iconUrl=" + dVar.f252124p);
            }
            x.c.b bVar2 = xVar.f180252f.f180261b;
            if (bVar2 != null) {
                long j3 = bVar2.f180267c;
                if (j3 > 0) {
                    dVar.f252113e = j3;
                }
            }
            fVar.f252151a.put(Long.valueOf(r7.f180260a), dVar);
            QLog.i("ElegantIntimatePushHelper", 1, "handleMutualMarkPositivePush, intimate_type=" + dVar.f252109a + ", intimate_level=" + dVar.f252110b);
            return;
        }
        QLog.e("ElegantIntimatePushHelper", 1, "handleMutualMarkPositivePush fail, null found");
    }
}
