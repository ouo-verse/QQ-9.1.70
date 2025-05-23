package com.tencent.mobileqq.cardcontainer.framework;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H&J\"\u0010\b\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/i;", "", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "", "callback", "d", "a", "cardData", "", "position", "b", "c", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface i {
    void a(@NotNull Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> callback);

    void b(@NotNull com.tencent.mobileqq.cardcontainer.data.a cardData, int position);

    @NotNull
    List<com.tencent.mobileqq.cardcontainer.data.a> c();

    void d(@NotNull Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> callback);
}
