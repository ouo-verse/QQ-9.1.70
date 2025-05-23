package com.tencent.videocut.render;

import com.tencent.mobileqq.wink.utils.n;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.LAKCutSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.PAGAsset;
import org.light.lightAssetKit.components.ReplaceItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a$\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\u0000*\u00020\n\u001a\u0012\u0010\u000f\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r\u001a\u0012\u0010\u0010\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0011"}, d2 = {"Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "", "d", "entity", "entityMap", "", "f", "e", "Lcom/tencent/tavcut/core/session/LAKCutSession;", "c", "Lcom/tencent/tavcut/core/session/ICutSession;", "", "entityName", "a", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class d {
    public static final int a(@NotNull ICutSession iCutSession, @NotNull String entityName) {
        Entity c16;
        List<Entity> children;
        Intrinsics.checkNotNullParameter(iCutSession, "<this>");
        Intrinsics.checkNotNullParameter(entityName, "entityName");
        if ((iCutSession instanceof LAKCutSession) && (c16 = c((LAKCutSession) iCutSession)) != null && (children = c16.getChildren()) != null) {
            int i3 = 0;
            for (Object obj : children) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Collection<Component> components = ((Entity) obj).getComponents();
                Intrinsics.checkNotNullExpressionValue(components, "entity.components");
                boolean z16 = false;
                for (Component component : components) {
                    if ((component instanceof EntityIdentifier) && Intrinsics.areEqual(entityName, ((EntityIdentifier) component).getName())) {
                        z16 = true;
                    }
                }
                if (z16) {
                    return i3;
                }
                i3 = i16;
            }
            return -1;
        }
        return -1;
    }

    public static final int b(@NotNull ICutSession iCutSession, @NotNull String entityName) {
        Entity c16;
        List<Entity> children;
        Intrinsics.checkNotNullParameter(iCutSession, "<this>");
        Intrinsics.checkNotNullParameter(entityName, "entityName");
        int i3 = -1;
        if ((iCutSession instanceof LAKCutSession) && (c16 = c((LAKCutSession) iCutSession)) != null && (children = c16.getChildren()) != null) {
            int i16 = 0;
            for (Object obj : children) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Collection<Component> components = ((Entity) obj).getComponents();
                Intrinsics.checkNotNullExpressionValue(components, "entity.components");
                boolean z16 = false;
                for (Component component : components) {
                    if ((component instanceof EntityIdentifier) && Intrinsics.areEqual(entityName, ((EntityIdentifier) component).getName())) {
                        z16 = true;
                    }
                }
                if (z16) {
                    i3 = i16;
                }
                i16 = i17;
            }
        }
        return i3;
    }

    @Nullable
    public static final Entity c(@NotNull LAKCutSession lAKCutSession) {
        Intrinsics.checkNotNullParameter(lAKCutSession, "<this>");
        return e(lAKCutSession.getRootEntity());
    }

    @NotNull
    public static final Map<Integer, Entity> d(@Nullable Entity entity) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f(entity, linkedHashMap);
        return linkedHashMap;
    }

    @Nullable
    public static final Entity e(@Nullable Entity entity) {
        List<Entity> list;
        Entity entity2;
        Object firstOrNull;
        List<Entity> list2 = null;
        if (entity != null) {
            list = com.tencent.videocut.render.extension.d.b(entity, n.a.INSTANCE.c());
        } else {
            list = null;
        }
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            entity2 = (Entity) firstOrNull;
        } else {
            entity2 = null;
        }
        if (entity2 == null) {
            if (entity != null) {
                list2 = com.tencent.videocut.render.extension.d.b(entity, n.a.INSTANCE.d());
            }
            if (list2 != null) {
                for (Entity entity3 : list2) {
                    Collection<Component> components = entity3.getComponents();
                    Intrinsics.checkNotNullExpressionValue(components, "pagAssetEntity.components");
                    for (Component component : components) {
                        if (component instanceof PAGAsset) {
                            ArrayList<ReplaceItem> replacement = ((PAGAsset) component).getReplacement();
                            Intrinsics.checkNotNullExpressionValue(replacement, "component.replacement");
                            Iterator<T> it = replacement.iterator();
                            while (it.hasNext()) {
                                if (Intrinsics.areEqual("videoSource", ((ReplaceItem) it.next()).src)) {
                                    return entity3;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (entity2 != null) {
            return entity2;
        }
        return entity;
    }

    public static final void f(@Nullable Entity entity, @NotNull Map<Integer, Entity> entityMap) {
        Intrinsics.checkNotNullParameter(entityMap, "entityMap");
        if (entity != null) {
            entityMap.put(Integer.valueOf(entity.getId()), entity);
            List<Entity> children = entity.getChildren();
            if (children != null) {
                Intrinsics.checkNotNullExpressionValue(children, "children");
                Iterator<T> it = children.iterator();
                while (it.hasNext()) {
                    f((Entity) it.next(), entityMap);
                }
            }
        }
    }
}
