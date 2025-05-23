package com.tencent.mobileqq.vas.qqmc;

import com.tencent.mobileqq.vas.VasQQMcConstKt;
import com.tencent.mobileqq.vas.qqmc.bean.Test;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/TestVasJsonQQMC;", "Lcom/tencent/mobileqq/vas/qqmc/VasJsonQQMC;", "Lcom/tencent/mobileqq/vas/qqmc/bean/TestBean;", "()V", "defaultConfig", "getGroup", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class TestVasJsonQQMC extends VasJsonQQMC<Test> {
    @Override // com.tencent.mobileqq.vas.qqmc.VasQQMC
    @NotNull
    public String getGroup() {
        return VasQQMcConstKt.QQMC_KEY_VAS_TEST;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public Test defaultConfig() {
        return new Test(null, 1, null);
    }
}
