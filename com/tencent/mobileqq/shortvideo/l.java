package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l {
    public static p a(int i3, Object obj, v vVar) {
        xq2.b d16 = d(i3, null);
        if (d16 == null) {
            return null;
        }
        return d16.f(obj, vVar);
    }

    public static aa b(int i3, Object obj, v vVar) {
        xq2.b d16 = d(i3, null);
        if (d16 == null) {
            return null;
        }
        return d16.i(obj, vVar);
    }

    public static aa c(Object obj, v vVar) {
        xq2.b d16 = d(vVar.f288265e, null);
        if (d16 == null) {
            return null;
        }
        return d16.i(obj, vVar);
    }

    static xq2.b d(int i3, QQAppInterface qQAppInterface) {
        if (i3 != 0 && i3 != 2 && i3 != 3 && i3 != 5 && i3 != 6 && i3 != 7) {
            return null;
        }
        return ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(qQAppInterface);
    }

    public static void e(v vVar, QQAppInterface qQAppInterface) {
        if (vVar == null) {
            com.tencent.mobileqq.pic.f.d("ShortVideoBusiManager", "launch", "error,req == null");
            return;
        }
        if (vVar.f288264d == 2) {
            BaseSVReceiveOperator baseSVReceiveOperator = new BaseSVReceiveOperator(qQAppInterface);
            f(vVar, qQAppInterface, baseSVReceiveOperator);
            baseSVReceiveOperator.q(vVar.f288268i);
            return;
        }
        xq2.b d16 = d(vVar.f288265e, qQAppInterface);
        if (d16 == null) {
            com.tencent.mobileqq.pic.f.d("ShortVideoBusiManager", "launch", "error,operator == null,req.busiType:" + vVar.f288265e);
            return;
        }
        f(vVar, qQAppInterface, d16);
        int i3 = vVar.f288264d;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 3 && i3 != 4) {
                if (i3 == 5) {
                    d16.j(vVar.D);
                    return;
                }
                return;
            }
            d16.c(vVar.C);
            return;
        }
        d16.p(vVar.f288269m);
    }

    private static void f(v vVar, QQAppInterface qQAppInterface, xq2.b bVar) {
        bVar.k(qQAppInterface);
        bVar.n(vVar);
        bVar.o(vVar.f288266f);
        bVar.setLogTag(vVar.f288267h);
        bVar.d(vVar.E);
        if (vVar.f288265e == 1021 && (bVar instanceof BaseSVReceiveOperator)) {
            ((BaseSVReceiveOperator) bVar).w(vVar.E);
        }
        com.tencent.mobileqq.pic.f.b("ShortVideoBusiManager", "launch", "cmd:" + j.f(vVar.f288264d) + ", reqBusiType" + vVar.f288265e + ", uuid:" + vVar.f288266f);
    }
}
