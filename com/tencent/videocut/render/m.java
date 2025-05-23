package com.tencent.videocut.render;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H&J)\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000fH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/videocut/render/m;", "T", "V", "Lcom/tencent/videocut/render/i;", "data", "Lorg/light/lightAssetKit/Entity;", "b", "(Ljava/lang/Object;)Lorg/light/lightAssetKit/Entity;", "entity", "", "removeEntity", "oldData", "newData", "a", "(Lorg/light/lightAssetKit/Entity;Ljava/lang/Object;Ljava/lang/Object;)V", "", "", "entityMap", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public interface m<T, V> extends i {
    void a(@NotNull Entity entity, @Nullable T oldData, T newData);

    @Nullable
    Entity b(V data);

    void c(@NotNull Map<Integer, Entity> entityMap);

    void removeEntity(@NotNull Entity entity);
}
