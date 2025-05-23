package com.tencent.mobileqq.pskey;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/pskey/f;", "", "", "", "Lcom/tencent/mobileqq/pskey/a;", "domainToPskeyMap", "", "onSuccess", "errMsg", "onFail", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface f {
    void onFail(@NotNull String errMsg);

    void onSuccess(@NotNull Map<String, a> domainToPskeyMap);
}
