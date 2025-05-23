package com.tencent.mobileqq.troop.troopnotification.render.parser;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H&J6\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J6\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0006H&R\u0014\u0010\u0013\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "", "d", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "b", "Lcom/tencent/qqnt/notification/f;", "msg", "wildcardValue", "", "", "data", "", "c", "a", "getKey", "()Ljava/lang/String;", "key", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder);

    void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder);

    boolean c(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder);

    void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder);

    @NotNull
    String getKey();
}
