package com.tencent.mobileqq.qmmkv;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MMKVConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/qmmkv/MMKVConfig;", "b", "", "content", "d", "", "getGroup", "c", "", AdMetricTag.FALLBACK, "isSwitchOn", "<init>", "()V", "a", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MMKVConfigParser extends BaseConfigParser<MMKVConfig> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MMKVConfig defaultConfig() {
        return new MMKVConfig();
    }

    @NotNull
    public final MMKVConfig c() {
        MMKVConfig mMKVConfig = (MMKVConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(getGroup());
        if (mMKVConfig == null) {
            return defaultConfig();
        }
        return mMKVConfig;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public MMKVConfig parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(content, UTF_8));
            MMKVConfig mMKVConfig = new MMKVConfig();
            mMKVConfig.j(jSONObject);
            if (QLog.isColorLevel()) {
                QLog.d("MMKVReport_cfgParser", 1, "parse result:" + mMKVConfig);
            }
            return mMKVConfig;
        } catch (Exception e16) {
            QLog.d("MMKVReport_cfgParser", 1, "parse exception. ", e16);
            return defaultConfig();
        }
    }

    @NotNull
    public final String getGroup() {
        return "mmkv_report_config";
    }

    public final boolean isSwitchOn(boolean fallback) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(getGroup(), fallback);
    }
}
