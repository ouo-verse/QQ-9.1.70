package com.tencent.mobileqq.icgame.base.room;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.component.g;
import com.tencent.mobileqq.icgame.framework.component.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0007*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u001a2\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0007*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/component/h;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/icgame/framework/connector/b;", "Ljava/lang/Class;", "clazz", "c", "(Lcom/tencent/mobileqq/icgame/framework/connector/b;Ljava/lang/Class;)Lcom/tencent/mobileqq/icgame/framework/component/h;", "Lcom/tencent/mobileqq/icgame/framework/component/g;", "", "key", "e", "(Lcom/tencent/mobileqq/icgame/framework/connector/b;Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/icgame/framework/component/g;", "Lf32/b;", "d", "(Lf32/b;Ljava/lang/Class;)Lcom/tencent/mobileqq/icgame/framework/component/h;", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "a", "b", "ic-game-room-base_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    @Nullable
    public static final <C extends h> com.tencent.mobileqq.icgame.framework.component.d<C> a(@NotNull com.tencent.mobileqq.icgame.framework.connector.b bVar, @NotNull Class<C> clazz) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.mobileqq.icgame.framework.component.d<C> a16 = bVar.getConnectorContext().a(clazz);
        if (a16 == null) {
            j32.b.f409197a.w("ICGamePageSdk_TAG", "getConnectableComponent:" + clazz.getSimpleName() + " is null !!!");
            return null;
        }
        return a16;
    }

    @Nullable
    public static final <C extends g> com.tencent.mobileqq.icgame.framework.component.d<C> b(@NotNull com.tencent.mobileqq.icgame.framework.connector.b bVar, @NotNull Class<C> clazz, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        com.tencent.mobileqq.icgame.framework.component.d<C> b16 = bVar.getConnectorContext().b(clazz, key);
        if (b16 == null) {
            j32.b.f409197a.w("ICGamePageSdk_TAG", "focus from:" + clazz.getSimpleName() + " & key:" + key + " is null !!!");
            return null;
        }
        return b16;
    }

    @Nullable
    public static final <C extends h> C c(@NotNull com.tencent.mobileqq.icgame.framework.connector.b bVar, @NotNull Class<C> clazz) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.mobileqq.icgame.framework.component.d a16 = a(bVar, clazz);
        if (a16 != null) {
            return (C) a16.a();
        }
        return null;
    }

    @Nullable
    public static final <C extends h> C d(@NotNull f32.b bVar, @NotNull Class<C> clazz) {
        C c16;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.mobileqq.icgame.framework.component.d<C> a16 = bVar.a(clazz);
        if (a16 != null) {
            c16 = a16.a();
        } else {
            c16 = null;
        }
        if (c16 == null) {
            j32.b.f409197a.w("ICGamePageSdk_TAG", "getConnectableComponent:" + clazz.getSimpleName() + " is null !!!");
            return null;
        }
        return c16;
    }

    @Nullable
    public static final <C extends g> C e(@NotNull com.tencent.mobileqq.icgame.framework.connector.b bVar, @NotNull Class<C> clazz, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        com.tencent.mobileqq.icgame.framework.component.d b16 = b(bVar, clazz, key);
        if (b16 != null) {
            return (C) b16.a();
        }
        return null;
    }
}
