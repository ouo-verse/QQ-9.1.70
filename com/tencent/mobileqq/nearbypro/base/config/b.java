package com.tencent.mobileqq.nearbypro.base.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/config/b;", "Lcom/tencent/mobileqq/nearbypro/base/b;", "", "getCurrentAccountUin", "Lmqq/app/MobileQQ;", "a", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements com.tencent.mobileqq.nearbypro.base.b {
    @NotNull
    public MobileQQ a() {
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        return sMobileQQ;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.b
    @NotNull
    public String getCurrentAccountUin() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "0";
        }
        return str;
    }
}
