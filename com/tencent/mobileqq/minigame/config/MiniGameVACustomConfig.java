package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VACustomTextConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameVACustomConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "customTextConfig", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/VACustomTextConfig;", "getCustomTextConfig", "()Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/VACustomTextConfig;", "setCustomTextConfig", "(Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/VACustomTextConfig;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVACustomConfig implements IConfigData {
    public static final String CONFIG_ID = "102580";
    private VACustomTextConfig customTextConfig = new VACustomTextConfig(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 131071, null);

    public final VACustomTextConfig getCustomTextConfig() {
        return this.customTextConfig;
    }

    public final void setCustomTextConfig(VACustomTextConfig vACustomTextConfig) {
        Intrinsics.checkNotNullParameter(vACustomTextConfig, "<set-?>");
        this.customTextConfig = vACustomTextConfig;
    }
}
