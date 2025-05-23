package com.tencent.videocut.render.extension;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.LightAssetFragment;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a$\u0010\u0005\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u001a+\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u001a\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n\u001a\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r\u001a\n\u0010\u0011\u001a\u00020\u0010*\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lorg/light/lightAssetKit/components/Component;", "T", "Lorg/light/lightAssetKit/Entity;", "Lkotlin/reflect/KClass;", "componentTypeClass", "e", "d", "(Lorg/light/lightAssetKit/Entity;Lkotlin/reflect/KClass;)Lorg/light/lightAssetKit/components/Component;", "", "a", "", "componentTypeName", "b", "", "targetOriginEntityId", "c", "", "f", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class d {
    @NotNull
    public static final <T extends Component> List<Entity> a(@NotNull Entity entity, @NotNull KClass<T> componentTypeClass) {
        Object orNull;
        List<Entity> emptyList;
        Intrinsics.checkNotNullParameter(entity, "<this>");
        Intrinsics.checkNotNullParameter(componentTypeClass, "componentTypeClass");
        ArrayList arrayList = new ArrayList();
        if (entity.hasComponent(componentTypeClass.getSimpleName())) {
            arrayList.add(entity);
        }
        List<Entity> childrenList = entity.getChildren();
        int size = childrenList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Intrinsics.checkNotNullExpressionValue(childrenList, "childrenList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(childrenList, i3);
            Entity entity2 = (Entity) orNull;
            if (entity2 == null || (emptyList = a(entity2, componentTypeClass)) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            arrayList.addAll(emptyList);
        }
        return arrayList;
    }

    @NotNull
    public static final List<Entity> b(@NotNull Entity entity, @NotNull String componentTypeName) {
        Object orNull;
        List<Entity> emptyList;
        Intrinsics.checkNotNullParameter(entity, "<this>");
        Intrinsics.checkNotNullParameter(componentTypeName, "componentTypeName");
        ArrayList arrayList = new ArrayList();
        if (entity.hasComponent(componentTypeName)) {
            arrayList.add(entity);
        }
        List<Entity> childrenList = entity.getChildren();
        int size = childrenList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Intrinsics.checkNotNullExpressionValue(childrenList, "childrenList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(childrenList, i3);
            Entity entity2 = (Entity) orNull;
            if (entity2 == null || (emptyList = b(entity2, componentTypeName)) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            arrayList.addAll(emptyList);
        }
        return arrayList;
    }

    @Nullable
    public static final Entity c(@NotNull Entity entity, int i3) {
        Object orNull;
        Intrinsics.checkNotNullParameter(entity, "<this>");
        EntityIdentifier entityIdentifier = (EntityIdentifier) entity.getComponent(EntityIdentifier.class);
        if (entityIdentifier != null && entityIdentifier.getOriginID() == i3) {
            return entity;
        }
        List<Entity> childrenList = entity.getChildren();
        int size = childrenList.size();
        int i16 = 0;
        while (true) {
            Entity entity2 = null;
            if (i16 >= size) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(childrenList, "childrenList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(childrenList, i16);
            Entity entity3 = (Entity) orNull;
            if (entity3 != null) {
                entity2 = c(entity3, i3);
            }
            if (entity2 != null) {
                return entity2;
            }
            i16++;
        }
    }

    @Nullable
    public static final <T extends Component> T d(@NotNull Entity entity, @NotNull KClass<T> componentTypeClass) {
        Object orNull;
        Intrinsics.checkNotNullParameter(entity, "<this>");
        Intrinsics.checkNotNullParameter(componentTypeClass, "componentTypeClass");
        if (entity.hasComponent(componentTypeClass.getSimpleName())) {
            T t16 = (T) entity.getComponent(componentTypeClass.getSimpleName());
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.tencent.videocut.render.extension.LAKEntityExtKt.findFirstComponentByComponentType");
            return t16;
        }
        List<Entity> childrenList = entity.getChildren();
        int size = childrenList.size();
        int i3 = 0;
        while (true) {
            T t17 = null;
            if (i3 >= size) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(childrenList, "childrenList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(childrenList, i3);
            Entity entity2 = (Entity) orNull;
            if (entity2 != null) {
                t17 = (T) d(entity2, componentTypeClass);
            }
            if (t17 != null) {
                return t17;
            }
            i3++;
        }
    }

    @Nullable
    public static final <T extends Component> Entity e(@NotNull Entity entity, @NotNull KClass<T> componentTypeClass) {
        Object orNull;
        Intrinsics.checkNotNullParameter(entity, "<this>");
        Intrinsics.checkNotNullParameter(componentTypeClass, "componentTypeClass");
        if (entity.hasComponent(componentTypeClass.getSimpleName())) {
            return entity;
        }
        List<Entity> childrenList = entity.getChildren();
        int size = childrenList.size();
        int i3 = 0;
        while (true) {
            Entity entity2 = null;
            if (i3 >= size) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(childrenList, "childrenList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(childrenList, i3);
            Entity entity3 = (Entity) orNull;
            if (entity3 != null) {
                entity2 = e(entity3, componentTypeClass);
            }
            if (entity2 != null) {
                return entity2;
            }
            i3++;
        }
    }

    public static final boolean f(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "<this>");
        if (e(entity, Reflection.getOrCreateKotlinClass(LightAssetFragment.class)) != null) {
            return true;
        }
        return false;
    }
}
