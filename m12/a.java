package m12;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GetGiftListRsp;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f415996a = new a();

    a() {
    }

    public static a b() {
        return f415996a;
    }

    public giftList$GetGiftListRsp a(String str) {
        String string = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences().getString("giftlist_" + str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            giftList$GetGiftListRsp giftlist_getgiftlistrsp = new giftList$GetGiftListRsp();
            giftlist_getgiftlistrsp.mergeFrom(string.getBytes("ISO8859_1"));
            return giftlist_getgiftlistrsp;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public boolean c(String str) {
        SharedPreferences preferences = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("giftlist_" + str);
        sb5.append("_saveTime");
        return System.currentTimeMillis() >= preferences.getLong(sb5.toString(), 0L);
    }

    public void d(String str, giftList$GetGiftListRsp giftlist_getgiftlistrsp) {
        String str2 = "giftlist_" + str;
        SharedPreferences preferences = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences();
        try {
            String str3 = new String(giftlist_getgiftlistrsp.toByteArray(), "ISO8859_1");
            preferences.edit().putLong(str2 + "_saveTime", System.currentTimeMillis() + (giftlist_getgiftlistrsp.duration.get() * 1000 * 20));
            preferences.edit().putString(str2, str3);
            preferences.edit().apply();
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
