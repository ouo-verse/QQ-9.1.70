package l12;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$SendGiftReq;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final c f413646a = new c();

    c() {
    }

    public static c a() {
        return f413646a;
    }

    public String b(long j3, long j16, int i3, int i16, long j17, long j18, String str) {
        giftList$SendGiftReq giftlist_sendgiftreq = new giftList$SendGiftReq();
        giftlist_sendgiftreq.senderTinyid.set(j3);
        giftlist_sendgiftreq.recverTinyid.set(j16);
        giftlist_sendgiftreq.giftId.set(i3);
        giftlist_sendgiftreq.sendType.set(i16);
        giftlist_sendgiftreq.channelId.set(j17);
        giftlist_sendgiftreq.groupId.set(j18);
        if (!TextUtils.isEmpty(str)) {
            giftlist_sendgiftreq.authKey.set(str);
        }
        return PluginBaseInfoHelper.Base64Helper.encodeToString(giftlist_sendgiftreq.toByteArray(), 0);
    }

    public void c(long j3, long j16, int i3, int i16, long j17, long j18, String str, BusinessObserver businessObserver) {
        giftList$SendGiftReq giftlist_sendgiftreq = new giftList$SendGiftReq();
        giftlist_sendgiftreq.senderTinyid.set(j3);
        giftlist_sendgiftreq.recverTinyid.set(j16);
        giftlist_sendgiftreq.giftId.set(i3);
        giftlist_sendgiftreq.sendType.set(i16);
        giftlist_sendgiftreq.channelId.set(j17);
        giftlist_sendgiftreq.groupId.set(j18);
        giftlist_sendgiftreq.authKey.set(str);
        try {
            VasUtil.getService().getPbRequest().request("trpc.gift.channel_gift_send.GiftSend.SendChannelGift", new String(giftlist_sendgiftreq.toByteArray(), "ISO8859_1"), businessObserver);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
