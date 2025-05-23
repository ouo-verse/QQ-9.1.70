package com.tencent.mobileqq.vas.qqmc;

import com.tencent.mobileqq.vas.qqmc.bean.NoConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/VasQQMCSwitch;", "Lcom/tencent/mobileqq/vas/qqmc/VasJsonQQMC;", "Lcom/tencent/mobileqq/vas/qqmc/bean/NoConfig;", "()V", "defaultConfig", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class VasQQMCSwitch extends VasJsonQQMC<NoConfig> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public NoConfig defaultConfig() {
        return NoConfig.INSTANCE;
    }
}
