package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM;

import c45.i;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import d45.a;
import n35.v;

/* loaded from: classes31.dex */
public final class NBPFeedShareDataExtKt {
    public static final NearbyFeedPosterData fromJsonStr(String str) {
        byte[] a16;
        try {
            e eVar = new e(str);
            int k3 = eVar.k("appId", 2);
            String q16 = eVar.q("userId", "");
            String q17 = eVar.q("feedId", "");
            String p16 = eVar.p("feedImage");
            v vVar = ((p16.length() == 0) || (a16 = a.a(p16)) == null) ? null : (v) i.b(new v(null, null, 0, 0L, 0L, 0, 0, 127, null), a16);
            String q18 = eVar.q("feedFallbackImage", "");
            e m3 = eVar.m("feedAddress");
            return new NearbyFeedPosterData(k3, q16, q17, vVar, q18, m3 != null ? new NearbyFeedPosterData.AddressInfo(m3.q("city", ""), m3.q("district", ""), m3.q(CommonConstant.KEY_DISPLAY_NAME, "")) : null, eVar.q("feedTitle", ""), eVar.q("userAvatar", ""), eVar.q("userNickname", ""), eVar.q("themeId", ""));
        } catch (Exception unused) {
            return null;
        }
    }
}
