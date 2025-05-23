package com.tencent.mobileqq.vas.marketface.impl;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J8\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/marketface/impl/MarketFaceTailConfigExtImpl;", "Lcom/tencent/mobileqq/vas/marketface/IMarketFaceTailConfigExt;", "()V", "getTailConfig", "Lkotlin/Pair;", "", "ePid", "openUrl", "", "context", "Landroid/content/Context;", "url", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "moduleId", "itemId", "itemType", "actionId", "", "busiInfo", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class MarketFaceTailConfigExtImpl implements IMarketFaceTailConfigExt {
    @Override // com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt
    @Nullable
    public Pair<String, String> getTailConfig(@NotNull String ePid) {
        Intrinsics.checkNotNullParameter(ePid, "ePid");
        return ((IMarketFaceTailConfig) QRoute.api(IMarketFaceTailConfig.class)).getTailConfig(ePid);
    }

    @Override // com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt
    public void openUrl(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        ((IMarketFaceTailConfig) QRoute.api(IMarketFaceTailConfig.class)).openUrl(context, url);
    }

    @Override // com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt
    public void reportAction(@Nullable String moduleId, @Nullable String itemId, @Nullable String itemType, int actionId, @Nullable String busiInfo) {
        ((IMarketFaceTailConfig) QRoute.api(IMarketFaceTailConfig.class)).reportAction(moduleId, itemId, itemType, actionId, busiInfo);
    }
}
