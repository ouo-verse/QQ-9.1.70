package l12;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$UniBalanceFromAdminReq;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f413644a = new a();

    a() {
    }

    public static a a() {
        return f413644a;
    }

    public void b(String str, BusinessObserver businessObserver) {
        giftList$UniBalanceFromAdminReq giftlist_unibalancefromadminreq = new giftList$UniBalanceFromAdminReq();
        giftlist_unibalancefromadminreq.appid.set("1003");
        giftlist_unibalancefromadminreq.authkey.set(str);
        giftlist_unibalancefromadminreq.domainID.set(5);
        try {
            VasUtil.getService().getPbRequest().request("trpc.gift.channel_gift_currency.GiftCurrency.UniGetBalanceFromAdmin", new String(giftlist_unibalancefromadminreq.toByteArray(), "ISO8859_1"), businessObserver);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
