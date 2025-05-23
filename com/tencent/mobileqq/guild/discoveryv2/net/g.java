package com.tencent.mobileqq.guild.discoveryv2.net;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTabContentCommonRsp;", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {
    @NotNull
    public static final String a(@NotNull IGProTabContentCommonRsp iGProTabContentCommonRsp) {
        Integer num;
        Intrinsics.checkNotNullParameter(iGProTabContentCommonRsp, "<this>");
        int size = iGProTabContentCommonRsp.getRecommendList().size();
        int size2 = iGProTabContentCommonRsp.getTabList().size();
        byte[] cookies = iGProTabContentCommonRsp.getCookies();
        Integer num2 = null;
        if (cookies != null) {
            num = Integer.valueOf(cookies.length);
        } else {
            num = null;
        }
        byte[] backendCookies = iGProTabContentCommonRsp.getBackendCookies();
        if (backendCookies != null) {
            num2 = Integer.valueOf(backendCookies.length);
        }
        return "GProTabContentCommonRsp(data:" + size + " tab:" + size2 + " cookies:" + num + " backendCookies:" + num2 + " sessionId:" + iGProTabContentCommonRsp.getSessionId() + ")";
    }
}
