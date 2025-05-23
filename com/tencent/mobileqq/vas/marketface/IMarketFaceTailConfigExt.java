package com.tencent.mobileqq.vas.marketface;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H&J:\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/marketface/IMarketFaceTailConfigExt;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getTailConfig", "Lkotlin/Pair;", "", "ePid", "openUrl", "", "context", "Landroid/content/Context;", "url", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "moduleId", "itemId", "itemType", "actionId", "", "busiInfo", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IMarketFaceTailConfigExt extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        public static /* synthetic */ void a(IMarketFaceTailConfigExt iMarketFaceTailConfigExt, String str, String str2, String str3, int i3, String str4, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    str4 = "";
                }
                iMarketFaceTailConfigExt.reportAction(str, str2, str3, i3, str4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportAction");
        }
    }

    @Nullable
    Pair<String, String> getTailConfig(@NotNull String ePid);

    void openUrl(@NotNull Context context, @NotNull String url);

    void reportAction(@Nullable String moduleId, @Nullable String itemId, @Nullable String itemType, int actionId, @Nullable String busiInfo);
}
