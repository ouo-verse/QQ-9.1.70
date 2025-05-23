package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.trpcprotocol.QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Ltencent/trpcprotocol/QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/l;", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class m {
    @NotNull
    public static final l a(@NotNull QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp) {
        Intrinsics.checkNotNullParameter(qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp, "<this>");
        boolean z16 = true;
        if (qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp.is_living.get() != 1) {
            z16 = false;
        }
        String str = qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp.living_detail_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "living_detail_url.get()");
        return new l(z16, str);
    }
}
