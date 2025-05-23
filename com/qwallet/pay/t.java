package com.qwallet.pay;

import com.qwallet.activity.QWalletAppInterface;
import com.qwallet.data.PayPucAccManager;
import com.qwallet.protocol.Wallet.OpenPay.ReqGetPuinInfo;
import com.qwallet.protocol.Wallet.OpenPay.RespGetPuinInfo;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class t implements com.qwallet.activity.sso.f {

    /* renamed from: d, reason: collision with root package name */
    private static volatile t f41682d;

    t() {
        QWalletAppInterface.getInstance().registUIObserver(this);
    }

    public static t a() {
        if (f41682d == null) {
            synchronized (t.class) {
                if (f41682d == null) {
                    f41682d = new t();
                }
            }
        }
        return f41682d;
    }

    @Override // com.qwallet.activity.sso.f
    public int H9() {
        return 1;
    }

    public void b() {
        QWalletAppInterface.getInstance().unRegistUIObserver(this);
    }

    public void c(int i3, String str, boolean z16) {
        com.qwallet.activity.sso.a aVar = (com.qwallet.activity.sso.a) QWalletAppInterface.getInstance().getQWalletProtocolById(4);
        ReqGetPuinInfo reqGetPuinInfo = new ReqGetPuinInfo();
        reqGetPuinInfo.bargainorId = "";
        reqGetPuinInfo.subbargainorId = "";
        reqGetPuinInfo.bussId = "";
        reqGetPuinInfo.f41684st = PayPucAccManager.j(MobileQQ.sMobileQQ.getApplicationContext());
        aVar.w(H9(), true, "", reqGetPuinInfo);
    }

    @Override // com.qwallet.activity.sso.f
    public void g3(int i3, boolean z16, boolean z17, Object obj) {
        if (i3 == 4 && z16 && (obj instanceof RespGetPuinInfo)) {
            PayPucAccManager.r(MobileQQ.sMobileQQ.getApplicationContext(), (RespGetPuinInfo) obj);
        }
    }
}
