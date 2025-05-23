package com.tencent.mobileqq.nearbypro.utils.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.dt.api.b;
import com.tencent.mobileqq.nearbypro.utils.api.INearbyProJubaoApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J8\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J@\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/api/impl/NearbyProJubaoApiImpl;", "Lcom/tencent/mobileqq/nearbypro/utils/api/INearbyProJubaoApi;", "Landroid/content/Context;", "context", "", "tinyId", "feedId", "", "reportFeed", "reportUser", "contentId", "reportFeedComment", "", "appId", "evilUin", "chatType", "", "sigToken", "doJumpReport", "evilUinType", "buddyFlag", "", "isAnonymous", "<init>", "()V", "Companion", "a", "qq_nearby_pro_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NearbyProJubaoApiImpl implements INearbyProJubaoApi {
    private static final String JubaoServlet_KEY_NEARBY_PRO_SIG = "jubao_nearbypro_sig";
    public static final int KEY_NEARBY_PRO_FEED = 100522;
    public static final int KEY_NEARBY_PRO_FEED_COMMENT = 100614;
    public static final int KEY_NEARBY_PRO_PROFILE_USER = 100521;

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProJubaoApi
    public void doJumpReport(Context context, int appId, String evilUin, String contentId, String chatType, byte[] sigToken) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(evilUin, "evilUin");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(chatType, "chatType");
        Intrinsics.checkNotNullParameter(sigToken, "sigToken");
        b bVar = new b();
        bVar.i(String.valueOf(appId));
        bVar.n(evilUin);
        bVar.o(2);
        bVar.j("0");
        bVar.s(0);
        bVar.m(contentId);
        if (chatType.length() > 0) {
            bVar.k(chatType);
        }
        if (!(sigToken.length == 0)) {
            Bundle bundle = new Bundle();
            bundle.putString(JubaoServlet_KEY_NEARBY_PRO_SIG, Base64.encodeToString(sigToken, 0));
            bVar.p(bundle);
        }
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar);
    }

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProJubaoApi
    public void reportFeed(Context context, String tinyId, String feedId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        INearbyProJubaoApi.a.a(this, context, 100522, tinyId, feedId, null, null, 48, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProJubaoApi
    public void reportFeedComment(Context context, String tinyId, String contentId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        INearbyProJubaoApi.a.a(this, context, KEY_NEARBY_PRO_FEED_COMMENT, tinyId, contentId, null, null, 48, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProJubaoApi
    public void reportUser(Context context, String tinyId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        INearbyProJubaoApi.a.a(this, context, 100521, tinyId, "", null, null, 48, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.utils.api.INearbyProJubaoApi
    public void doJumpReport(Context context, String appId, String evilUin, int evilUinType, String buddyFlag, boolean isAnonymous, String contentId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(evilUin, "evilUin");
        Intrinsics.checkNotNullParameter(buddyFlag, "buddyFlag");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        b bVar = new b();
        bVar.i(appId);
        bVar.n(evilUin);
        bVar.o(evilUinType);
        bVar.j(buddyFlag);
        bVar.s(isAnonymous ? 1 : 0);
        bVar.m(contentId);
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar);
    }
}
