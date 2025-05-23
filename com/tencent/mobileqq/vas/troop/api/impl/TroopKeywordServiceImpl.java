package com.tencent.mobileqq.vas.troop.api.impl;

import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.troop.api.ITroopKeywordService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/api/impl/TroopKeywordServiceImpl;", "Lcom/tencent/mobileqq/vas/troop/api/ITroopKeywordService;", "()V", "containsKeyword", "", "troopUin", "", "msg", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class TroopKeywordServiceImpl implements ITroopKeywordService {
    @Override // com.tencent.mobileqq.vas.troop.api.ITroopKeywordService
    public boolean containsKeyword(@NotNull String troopUin, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return VasInjectApi.getInstance().containsKeyword(troopUin, msg2);
    }
}
