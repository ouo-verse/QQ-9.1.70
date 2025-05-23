package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameRetainConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGameRetainConfig;", "()V", "defaultConfig", "parse", "content", "", "parseConfig", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameRetainConfigParser extends BaseConfigParser<MiniGameRetainConfig> {
    private static final String CONFIG_ID = "105440";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameRetainConfigParser$Companion;", "", "()V", "CONFIG_ID", "", "loadConfig", "Lcom/tencent/mobileqq/minigame/config/MiniGameRetainConfig;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MiniGameRetainConfig loadConfig() {
            MiniGameRetainConfig miniGameRetainConfig = (MiniGameRetainConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameRetainConfigParser.CONFIG_ID);
            return miniGameRetainConfig == null ? new MiniGameRetainConfig(null, 1, null) : miniGameRetainConfig;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final MiniGameRetainConfig loadConfig() {
        return INSTANCE.loadConfig();
    }

    private final MiniGameRetainConfig parseConfig(String content) {
        try {
            return new MiniGameRetainConfig(new JSONObject(content).optString("jumpLink"));
        } catch (JSONException unused) {
            return defaultConfig();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGameRetainConfig defaultConfig() {
        return new MiniGameRetainConfig(null, 1, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGameRetainConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return parseConfig(new String(content, UTF_8));
        }
        return defaultConfig();
    }
}
