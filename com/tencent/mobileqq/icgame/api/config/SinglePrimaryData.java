package com.tencent.mobileqq.icgame.api.config;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J>\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u000b\u001a\u0002H\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u0002H\u00140\u0016H\u0002\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/config/SinglePrimaryData;", "", "configKey", "", QAdRewardDefine$SecurityData.DATA_KEY, "configJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aegisLogger", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "getBoolean", "", AdMetricTag.FALLBACK, "getDouble", "", "getInt", "", "getLong", "", "getString", "parseSafely", "T", "parser", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "jsonObject", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class SinglePrimaryData {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String TAG = "SinglePrimaryData";

    @NotNull
    private final IAegisLogApi aegisLogger;

    @Nullable
    private final String configJson;

    @NotNull
    private final String configKey;

    @NotNull
    private final String dataKey;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/config/SinglePrimaryData$Companion;", "", "()V", "TAG", "", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public SinglePrimaryData(@NotNull String configKey, @NotNull String dataKey, @Nullable String str) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        this.configKey = configKey;
        this.dataKey = dataKey;
        this.configJson = str;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    private final <T> T parseSafely(T fallback, Function1<? super JSONObject, ? extends T> parser) {
        if (TextUtils.isEmpty(this.configJson)) {
            this.aegisLogger.e(TAG, "config is empty for config key:" + this.configKey + ",data key:" + this.dataKey);
            return fallback;
        }
        try {
            return parser.invoke(new JSONObject(this.configJson));
        } catch (NumberFormatException e16) {
            this.aegisLogger.a(TAG, "parse config failed for key:" + this.configKey + ",data key:" + this.dataKey + ",config:" + this.configJson + ",e:" + e16);
            return fallback;
        } catch (JSONException e17) {
            this.aegisLogger.a(TAG, "parse config failed for key:" + this.configKey + ",data key:" + this.dataKey + ",config:" + this.configJson + ",e:" + e17);
            return fallback;
        }
    }

    public final boolean getBoolean(final boolean fallback) {
        return ((Boolean) parseSafely(Boolean.valueOf(fallback), new Function1<JSONObject, Boolean>() { // from class: com.tencent.mobileqq.icgame.api.config.SinglePrimaryData$getBoolean$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull JSONObject it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                str = SinglePrimaryData.this.dataKey;
                return Boolean.valueOf(it.optBoolean(str, fallback));
            }
        })).booleanValue();
    }

    public final double getDouble(final double fallback) {
        return ((Number) parseSafely(Double.valueOf(fallback), new Function1<JSONObject, Double>() { // from class: com.tencent.mobileqq.icgame.api.config.SinglePrimaryData$getDouble$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Double invoke(@NotNull JSONObject it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                str = SinglePrimaryData.this.dataKey;
                return Double.valueOf(it.optDouble(str, fallback));
            }
        })).doubleValue();
    }

    public final int getInt(final int fallback) {
        return ((Number) parseSafely(Integer.valueOf(fallback), new Function1<JSONObject, Integer>() { // from class: com.tencent.mobileqq.icgame.api.config.SinglePrimaryData$getInt$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull JSONObject it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                str = SinglePrimaryData.this.dataKey;
                return Integer.valueOf(it.optInt(str, fallback));
            }
        })).intValue();
    }

    public final long getLong(final long fallback) {
        return ((Number) parseSafely(Long.valueOf(fallback), new Function1<JSONObject, Long>() { // from class: com.tencent.mobileqq.icgame.api.config.SinglePrimaryData$getLong$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Long invoke(@NotNull JSONObject it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                str = SinglePrimaryData.this.dataKey;
                return Long.valueOf(it.optLong(str, fallback));
            }
        })).longValue();
    }

    @NotNull
    public final String getString(@NotNull final String fallback) {
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        return (String) parseSafely(fallback, new Function1<JSONObject, String>() { // from class: com.tencent.mobileqq.icgame.api.config.SinglePrimaryData$getString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull JSONObject it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                str = SinglePrimaryData.this.dataKey;
                String optString = it.optString(str, fallback);
                Intrinsics.checkNotNullExpressionValue(optString, "it.optString(dataKey, fallback)");
                return optString;
            }
        });
    }
}
