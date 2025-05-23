package ea2;

import com.tencent.mobileqq.nearbypro.api.router.NearbyFeedPosterData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/router/b;", "", "b", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(NearbyFeedPosterData nearbyFeedPosterData) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", nearbyFeedPosterData.getAppId());
        jSONObject.put("userId", nearbyFeedPosterData.getUserId());
        jSONObject.put("feedId", nearbyFeedPosterData.getFeedId());
        jSONObject.put("feedFallbackImage", nearbyFeedPosterData.getFeedFallbackImage());
        nearbyFeedPosterData.b();
        jSONObject.put("feedAddress", (Object) null);
        jSONObject.put("feedTitle", nearbyFeedPosterData.getFeedTitle());
        jSONObject.put("userAvatar", nearbyFeedPosterData.getUserAvatar());
        jSONObject.put("userNickname", nearbyFeedPosterData.getUserNickname());
        jSONObject.put("themeId", nearbyFeedPosterData.getThemeId());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026themeId)\n    }.toString()");
        return jSONObject2;
    }
}
