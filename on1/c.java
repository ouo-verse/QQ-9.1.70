package on1;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.util.Pair;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c {
    public static Pair<Integer, Integer> a(int i3) {
        kotlin.Pair<Integer, Integer> f16;
        if (i3 == 2) {
            f16 = GuildFeedMediaSizeUtils.f219296d.f(16, 9);
        } else {
            f16 = GuildFeedMediaSizeUtils.f219296d.f(5, 7);
        }
        return new Pair<>(f16.getFirst(), f16.getSecond());
    }

    public static b b(byte[] bArr) {
        String str;
        int i3;
        b bVar = new b();
        if (bArr == null) {
            return bVar;
        }
        try {
            str = new String(bArr, StandardCharsets.UTF_8);
        } catch (Exception e16) {
            com.tencent.xaction.log.b.b("GuildGameFeedsUtil", 1, "parseGuildGameFeedsData busiJsonStr exception", e16);
            str = null;
        }
        com.tencent.xaction.log.b.a("GuildGameFeedsUtil", 1, "parseGuildGameFeedsData busiJsonStr=" + str);
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f423214b = jSONObject.optString("avatar_nick");
            bVar.f423215c = jSONObject.optString("avatar_icon");
            bVar.f423216d = jSONObject.optString("text");
            bVar.f423221i = jSONObject.optString("actURL");
            String optString = jSONObject.optString("pic");
            String optString2 = jSONObject.optString("pic_type");
            String optString3 = jSONObject.optString("material_type");
            if (!TextUtils.isEmpty(optString3)) {
                i3 = Integer.parseInt(optString3);
                com.tencent.xaction.log.b.a("GuildGameFeedsUtil", 1, "adTypeStr is null");
            } else if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            if (i3 == 1) {
                bVar.f423213a = i3;
                if (!TextUtils.isEmpty(optString2)) {
                    bVar.f423217e = Integer.parseInt(optString2);
                }
                bVar.f423218f = optString;
            } else if (i3 == 2) {
                bVar.f423213a = i3;
                bVar.f423220h = jSONObject.optString("video_cover_img");
                bVar.f423217e = Integer.parseInt(jSONObject.optString("video_type"));
                bVar.f423218f = jSONObject.optString("video_link");
                bVar.f423219g = jSONObject.optString("vid");
            }
        } catch (Exception e17) {
            com.tencent.xaction.log.b.c("GuildGameFeedsUtil", 1, "parseGuildGameFeedsData json exception", e17);
        }
        return bVar;
    }
}
