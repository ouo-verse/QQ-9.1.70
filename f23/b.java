package f23;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$BuyGoodsReq;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$ProductItem;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$TokenInfo;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$UserInfo;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f397716a = new b();

    b() {
    }

    public static b a() {
        return f397716a;
    }

    public void b(AppInterface appInterface, int i3, String str, int i16, String str2, BusinessObserver businessObserver) {
        if (appInterface == null) {
            return;
        }
        try {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            String pSkey = VasSkey.getPSkey(appInterface, "qzone.qq.com");
            midasPayCoinb$TokenInfo midaspaycoinb_tokeninfo = new midasPayCoinb$TokenInfo();
            midaspaycoinb_tokeninfo.type.set(4);
            midaspaycoinb_tokeninfo.open_id.set(currentAccountUin);
            midaspaycoinb_tokeninfo.open_key.set(pSkey);
            midaspaycoinb_tokeninfo.domainID.set(5);
            midasPayCoinb$UserInfo midaspaycoinb_userinfo = new midasPayCoinb$UserInfo();
            midaspaycoinb_userinfo.token.set(midaspaycoinb_tokeninfo);
            midaspaycoinb_userinfo.platform.set(1);
            midaspaycoinb_userinfo.account_type.set(0);
            midasPayCoinb$ProductItem midaspaycoinb_productitem = new midasPayCoinb$ProductItem();
            midaspaycoinb_productitem.ProductID.set(str);
            midaspaycoinb_productitem.Quantity.set(i16);
            midasPayCoinb$BuyGoodsReq midaspaycoinb_buygoodsreq = new midasPayCoinb$BuyGoodsReq();
            midaspaycoinb_buygoodsreq.src_user.set(midaspaycoinb_userinfo);
            ArrayList arrayList = new ArrayList();
            arrayList.add(midaspaycoinb_productitem);
            midaspaycoinb_buygoodsreq.product.set(arrayList);
            midaspaycoinb_buygoodsreq.access_appid.set(i3);
            midaspaycoinb_buygoodsreq.recharge_pf_ext.set(str2);
            QLog.i("SsoBuyGoodsRequestHandler", 1, "psKey:" + pSkey + " uin:" + currentAccountUin + " productId:" + str + " quantity: appId:" + i3 + " pf:" + str2);
            VasUtil.getService().getPbRequest().request("trpc.common_pay.midas_pay.MidasPayCoinb.SsoBuyGoods", new String(midaspaycoinb_buygoodsreq.toByteArray(), "ISO8859_1"), businessObserver);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        } catch (NumberFormatException e17) {
            e17.printStackTrace();
        } catch (Exception e18) {
            QLog.e("SsoBuyGoodsRequestHandler", 1, "request Exception", e18);
        }
    }
}
