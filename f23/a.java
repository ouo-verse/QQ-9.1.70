package f23;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$GetChargeProductReq;
import com.tencent.mobileqq.vas.util.VasUtil;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f397715a = new a();

    a() {
    }

    public static a a() {
        return f397715a;
    }

    public void b(int i3, BusinessObserver businessObserver) {
        try {
            midasPayCoinb$GetChargeProductReq midaspaycoinb_getchargeproductreq = new midasPayCoinb$GetChargeProductReq();
            midaspaycoinb_getchargeproductreq.access_appid.set(i3);
            VasUtil.getService().getPbRequest().request("trpc.common_pay.midas_pay.MidasPayCoinb.SsoGetChargeProduct", new String(midaspaycoinb_getchargeproductreq.toByteArray(), "ISO8859_1"), businessObserver);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        } catch (NumberFormatException e17) {
            e17.printStackTrace();
        }
    }
}
