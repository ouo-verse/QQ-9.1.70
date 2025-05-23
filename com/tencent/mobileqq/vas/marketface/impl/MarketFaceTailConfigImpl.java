package com.tencent.mobileqq.vas.marketface.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.api.INTVasHybirdApi;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig;
import com.tencent.mobileqq.vas.toggle.b;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J8\u0010\u000f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R,\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00070\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/vas/marketface/impl/MarketFaceTailConfigImpl;", "Lcom/tencent/mobileqq/vas/marketface/IMarketFaceTailConfig;", "", "innerInitConfig", "initConfig", "", "ePid", "Lkotlin/Pair;", "getTailConfig", "moduleId", "itemId", "itemType", "", "actionId", "busiInfo", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "Landroid/content/Context;", "context", "url", "openUrl", "Lorg/json/JSONObject;", "jsonFromQQMC", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/vas/toggle/b;", "proxy", "Lcom/tencent/mobileqq/vas/toggle/b;", "", "cacheResultMap", "Ljava/util/Map;", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class MarketFaceTailConfigImpl implements IMarketFaceTailConfig {

    @NotNull
    private static final String QQMC_CONFIG = "vas_market_face_tail_config";

    @NotNull
    private static final String TAG = "MarketFaceTailConfigImpl";

    @Nullable
    private JSONObject jsonFromQQMC;

    @NotNull
    private final b proxy = new b(QQMC_CONFIG, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.marketface.impl.MarketFaceTailConfigImpl$proxy$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z16) {
            if (z16) {
                MarketFaceTailConfigImpl.this.initConfig();
            }
        }
    });

    @NotNull
    private final Map<String, Pair<String, String>> cacheResultMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initConfig$lambda$0(MarketFaceTailConfigImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.innerInitConfig();
    }

    private final void innerInitConfig() {
        String readText$default;
        try {
            String a16 = this.proxy.a();
            if (TextUtils.isEmpty(a16)) {
                return;
            }
            File file = new File(a16);
            if (file.exists()) {
                readText$default = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
                this.jsonFromQQMC = new JSONObject(readText$default);
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    QLog.i(TAG, 1, "config:" + readText$default);
                }
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "parse error: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig
    @Nullable
    public Pair<String, String> getTailConfig(@NotNull String ePid) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Intrinsics.checkNotNullParameter(ePid, "ePid");
        if (this.jsonFromQQMC == null) {
            long currentTimeMillis = System.currentTimeMillis();
            innerInitConfig();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                QLog.i(TAG, 1, "cost time: " + (currentTimeMillis2 - currentTimeMillis));
            }
        }
        JSONObject jSONObject = this.jsonFromQQMC;
        if (jSONObject != null) {
            try {
                Pair<String, String> pair = this.cacheResultMap.get(ePid);
                if (pair != null) {
                    return pair;
                }
                if (jSONObject.optBoolean("enable", false) && (optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config)) != null && (optJSONObject2 = optJSONObject.optJSONObject(ePid)) != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(ePid)");
                    Pair<String, String> pair2 = new Pair<>(optJSONObject2.optString("ip_name"), optJSONObject2.optString("ip_url"));
                    this.cacheResultMap.put(ePid, pair2);
                    return pair2;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getTailConfig", e16);
                Unit unit = Unit.INSTANCE;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig
    public void initConfig() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.marketface.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                MarketFaceTailConfigImpl.initConfig$lambda$0(MarketFaceTailConfigImpl.this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig
    public void openUrl(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (!(context instanceof Activity) && !(context instanceof Application)) {
            context = MobileQQ.sMobileQQ;
        }
        ((INTVasHybirdApi) QRoute.api(INTVasHybirdApi.class)).openScheme(context, url);
    }

    @Override // com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig
    public void reportAction(@Nullable String moduleId, @Nullable String itemId, @Nullable String itemType, int actionId, @Nullable String busiInfo) {
        ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("DressVip", "pg_aio", moduleId, "", itemId, "", itemType, actionId, 0, 0, "", busiInfo, "");
    }
}
