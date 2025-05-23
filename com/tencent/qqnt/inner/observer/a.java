package com.tencent.qqnt.inner.observer;

import com.tencent.qqnt.notification.f;
import com.tencent.qqnt.troop.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/inner/observer/a;", "Lcom/tencent/qqnt/troop/g;", "Lcom/tencent/qqnt/notification/f;", "newMsg", "", "a", "c", "msg", "d", "e", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a extends g {
    void a(@NotNull f newMsg);

    void c();

    void d(@NotNull f msg2);

    void e();
}
