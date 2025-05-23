package com.tencent.mobileqq.mini.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfigProcessor;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig;", "()V", "defaultConfig", "parse", "content", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class AppDetainFreqConfigProcessor extends BaseConfigParser<AppDetainFreqConfig> {
    private static final String CONFIG_ID = "100852";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AppDetainFreqConfigProcessor";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "getConfig", "Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppDetainFreqConfig getConfig() {
            return (AppDetainFreqConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(AppDetainFreqConfigProcessor.CONFIG_ID);
        }

        Companion() {
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public AppDetainFreqConfig defaultConfig() {
        return new AppDetainFreqConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public AppDetainFreqConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        AppDetainFreqConfig appDetainFreqConfig = new AppDetainFreqConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(content, UTF_8);
            QLog.i(TAG, 1, "parse: config=" + str);
            appDetainFreqConfig.parse(str);
        } else {
            QLog.i(TAG, 1, "parse empty content");
        }
        return appDetainFreqConfig;
    }
}
