package l12;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GetGiftListReq;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f413645a = new b();

    b() {
    }

    public static b a() {
        return f413645a;
    }

    public void b(String str, String str2, BusinessObserver businessObserver) {
        giftList$GetGiftListReq giftlist_getgiftlistreq = new giftList$GetGiftListReq();
        giftlist_getgiftlistreq.giftListId.set(str);
        giftlist_getgiftlistreq.attachInfo.set(str2);
        try {
            VasUtil.getService().getPbRequest().request("trpc.gift.channel_gift_list.GiftList.GetGiftList", new String(giftlist_getgiftlistreq.toByteArray(), "ISO8859_1"), businessObserver);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
