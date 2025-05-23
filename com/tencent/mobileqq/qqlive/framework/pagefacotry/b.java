package com.tencent.mobileqq.qqlive.framework.pagefacotry;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0018\u00010\u0006H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/b;", "", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;", "root", "", "c", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "a", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/config/b;", "b", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {
    @Nullable
    List<Class<? extends com.tencent.mobileqq.qqlive.framework.connector.b>> a();

    @Nullable
    com.tencent.mobileqq.qqlive.framework.pagefacotry.config.b b();

    void c(@NotNull ComponentNode root);
}
