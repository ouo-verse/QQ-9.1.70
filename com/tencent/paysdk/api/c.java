package com.tencent.paysdk.api;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\n\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/paysdk/api/c;", "", "Lcom/tencent/paysdk/api/g;", "d", "Lcom/tencent/paysdk/api/i;", "c", "", "", "params", "", "b", "Landroid/content/Context;", "context", "Lcom/tencent/paysdk/api/f;", "a", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public interface c {
    @NotNull
    f a(@NotNull Context context);

    void b(@Nullable Map<String, ? extends Object> params);

    @NotNull
    i c();

    @NotNull
    g d();
}
