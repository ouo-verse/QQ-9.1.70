package com.tencent.tavcut.rendermodel.entity;

import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u00cf\u0001\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\u0003\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u00c6\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u00c6\u0003J\u001b\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\u00c6\u0003J\u001b\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\u00c6\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\u00c6\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u001b\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\u0003H\u00c6\u0003J\u00d3\u0001\u0010\"\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\u0003H\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0004H\u00d6\u0001J\t\u0010'\u001a\u00020\fH\u00d6\u0001R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R#\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R#\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/tencent/tavcut/rendermodel/entity/MutableEntity;", "", "entities", "", "", "Lcom/tencent/tavcut/rendermodel/entity/EntityId;", "components", "rawComponents", "Lcom/google/gson/JsonObject;", "entityMapToComponent", "", "byComponentType", "", "parentMapToEntity", "entityMapToParent", "noIdComponents", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getByComponentType", "()Ljava/util/Map;", "getComponents", "getEntities", "getEntityMapToComponent", "getEntityMapToParent", "getNoIdComponents", "getParentMapToEntity", "getRawComponents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class MutableEntity {
    public static final int ROOT_NONE = 0;

    @NotNull
    private final Map<String, List<Integer>> byComponentType;

    @NotNull
    private final Map<Integer, Object> components;

    @NotNull
    private final Map<Integer, EntityId> entities;

    @NotNull
    private final Map<Integer, List<Integer>> entityMapToComponent;

    @NotNull
    private final Map<Integer, Integer> entityMapToParent;

    @NotNull
    private final Map<Integer, List<Object>> noIdComponents;

    @NotNull
    private final Map<Integer, List<Integer>> parentMapToEntity;

    @NotNull
    private final Map<Integer, JsonObject> rawComponents;

    public MutableEntity() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ MutableEntity copy$default(MutableEntity mutableEntity, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, int i3, Object obj) {
        Map map9;
        Map map10;
        Map map11;
        Map map12;
        Map map13;
        Map map14;
        Map map15;
        Map map16;
        if ((i3 & 1) != 0) {
            map9 = mutableEntity.entities;
        } else {
            map9 = map;
        }
        if ((i3 & 2) != 0) {
            map10 = mutableEntity.components;
        } else {
            map10 = map2;
        }
        if ((i3 & 4) != 0) {
            map11 = mutableEntity.rawComponents;
        } else {
            map11 = map3;
        }
        if ((i3 & 8) != 0) {
            map12 = mutableEntity.entityMapToComponent;
        } else {
            map12 = map4;
        }
        if ((i3 & 16) != 0) {
            map13 = mutableEntity.byComponentType;
        } else {
            map13 = map5;
        }
        if ((i3 & 32) != 0) {
            map14 = mutableEntity.parentMapToEntity;
        } else {
            map14 = map6;
        }
        if ((i3 & 64) != 0) {
            map15 = mutableEntity.entityMapToParent;
        } else {
            map15 = map7;
        }
        if ((i3 & 128) != 0) {
            map16 = mutableEntity.noIdComponents;
        } else {
            map16 = map8;
        }
        return mutableEntity.copy(map9, map10, map11, map12, map13, map14, map15, map16);
    }

    @NotNull
    public final Map<Integer, EntityId> component1() {
        return this.entities;
    }

    @NotNull
    public final Map<Integer, Object> component2() {
        return this.components;
    }

    @NotNull
    public final Map<Integer, JsonObject> component3() {
        return this.rawComponents;
    }

    @NotNull
    public final Map<Integer, List<Integer>> component4() {
        return this.entityMapToComponent;
    }

    @NotNull
    public final Map<String, List<Integer>> component5() {
        return this.byComponentType;
    }

    @NotNull
    public final Map<Integer, List<Integer>> component6() {
        return this.parentMapToEntity;
    }

    @NotNull
    public final Map<Integer, Integer> component7() {
        return this.entityMapToParent;
    }

    @NotNull
    public final Map<Integer, List<Object>> component8() {
        return this.noIdComponents;
    }

    @NotNull
    public final MutableEntity copy(@NotNull Map<Integer, EntityId> entities, @NotNull Map<Integer, ? extends Object> components, @NotNull Map<Integer, JsonObject> rawComponents, @NotNull Map<Integer, ? extends List<Integer>> entityMapToComponent, @NotNull Map<String, ? extends List<Integer>> byComponentType, @NotNull Map<Integer, ? extends List<Integer>> parentMapToEntity, @NotNull Map<Integer, Integer> entityMapToParent, @NotNull Map<Integer, ? extends List<? extends Object>> noIdComponents) {
        Intrinsics.checkParameterIsNotNull(entities, "entities");
        Intrinsics.checkParameterIsNotNull(components, "components");
        Intrinsics.checkParameterIsNotNull(rawComponents, "rawComponents");
        Intrinsics.checkParameterIsNotNull(entityMapToComponent, "entityMapToComponent");
        Intrinsics.checkParameterIsNotNull(byComponentType, "byComponentType");
        Intrinsics.checkParameterIsNotNull(parentMapToEntity, "parentMapToEntity");
        Intrinsics.checkParameterIsNotNull(entityMapToParent, "entityMapToParent");
        Intrinsics.checkParameterIsNotNull(noIdComponents, "noIdComponents");
        return new MutableEntity(entities, components, rawComponents, entityMapToComponent, byComponentType, parentMapToEntity, entityMapToParent, noIdComponents);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MutableEntity) {
                MutableEntity mutableEntity = (MutableEntity) other;
                if (!Intrinsics.areEqual(this.entities, mutableEntity.entities) || !Intrinsics.areEqual(this.components, mutableEntity.components) || !Intrinsics.areEqual(this.rawComponents, mutableEntity.rawComponents) || !Intrinsics.areEqual(this.entityMapToComponent, mutableEntity.entityMapToComponent) || !Intrinsics.areEqual(this.byComponentType, mutableEntity.byComponentType) || !Intrinsics.areEqual(this.parentMapToEntity, mutableEntity.parentMapToEntity) || !Intrinsics.areEqual(this.entityMapToParent, mutableEntity.entityMapToParent) || !Intrinsics.areEqual(this.noIdComponents, mutableEntity.noIdComponents)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Map<String, List<Integer>> getByComponentType() {
        return this.byComponentType;
    }

    @NotNull
    public final Map<Integer, Object> getComponents() {
        return this.components;
    }

    @NotNull
    public final Map<Integer, EntityId> getEntities() {
        return this.entities;
    }

    @NotNull
    public final Map<Integer, List<Integer>> getEntityMapToComponent() {
        return this.entityMapToComponent;
    }

    @NotNull
    public final Map<Integer, Integer> getEntityMapToParent() {
        return this.entityMapToParent;
    }

    @NotNull
    public final Map<Integer, List<Object>> getNoIdComponents() {
        return this.noIdComponents;
    }

    @NotNull
    public final Map<Integer, List<Integer>> getParentMapToEntity() {
        return this.parentMapToEntity;
    }

    @NotNull
    public final Map<Integer, JsonObject> getRawComponents() {
        return this.rawComponents;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        Map<Integer, EntityId> map = this.entities;
        int i28 = 0;
        if (map != null) {
            i3 = map.hashCode();
        } else {
            i3 = 0;
        }
        int i29 = i3 * 31;
        Map<Integer, Object> map2 = this.components;
        if (map2 != null) {
            i16 = map2.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        Map<Integer, JsonObject> map3 = this.rawComponents;
        if (map3 != null) {
            i17 = map3.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (i36 + i17) * 31;
        Map<Integer, List<Integer>> map4 = this.entityMapToComponent;
        if (map4 != null) {
            i18 = map4.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        Map<String, List<Integer>> map5 = this.byComponentType;
        if (map5 != null) {
            i19 = map5.hashCode();
        } else {
            i19 = 0;
        }
        int i39 = (i38 + i19) * 31;
        Map<Integer, List<Integer>> map6 = this.parentMapToEntity;
        if (map6 != null) {
            i26 = map6.hashCode();
        } else {
            i26 = 0;
        }
        int i46 = (i39 + i26) * 31;
        Map<Integer, Integer> map7 = this.entityMapToParent;
        if (map7 != null) {
            i27 = map7.hashCode();
        } else {
            i27 = 0;
        }
        int i47 = (i46 + i27) * 31;
        Map<Integer, List<Object>> map8 = this.noIdComponents;
        if (map8 != null) {
            i28 = map8.hashCode();
        }
        return i47 + i28;
    }

    @NotNull
    public String toString() {
        return "MutableEntity(entities=" + this.entities + ", components=" + this.components + ", rawComponents=" + this.rawComponents + ", entityMapToComponent=" + this.entityMapToComponent + ", byComponentType=" + this.byComponentType + ", parentMapToEntity=" + this.parentMapToEntity + ", entityMapToParent=" + this.entityMapToParent + ", noIdComponents=" + this.noIdComponents + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutableEntity(@NotNull Map<Integer, EntityId> entities, @NotNull Map<Integer, ? extends Object> components, @NotNull Map<Integer, JsonObject> rawComponents, @NotNull Map<Integer, ? extends List<Integer>> entityMapToComponent, @NotNull Map<String, ? extends List<Integer>> byComponentType, @NotNull Map<Integer, ? extends List<Integer>> parentMapToEntity, @NotNull Map<Integer, Integer> entityMapToParent, @NotNull Map<Integer, ? extends List<? extends Object>> noIdComponents) {
        Intrinsics.checkParameterIsNotNull(entities, "entities");
        Intrinsics.checkParameterIsNotNull(components, "components");
        Intrinsics.checkParameterIsNotNull(rawComponents, "rawComponents");
        Intrinsics.checkParameterIsNotNull(entityMapToComponent, "entityMapToComponent");
        Intrinsics.checkParameterIsNotNull(byComponentType, "byComponentType");
        Intrinsics.checkParameterIsNotNull(parentMapToEntity, "parentMapToEntity");
        Intrinsics.checkParameterIsNotNull(entityMapToParent, "entityMapToParent");
        Intrinsics.checkParameterIsNotNull(noIdComponents, "noIdComponents");
        this.entities = entities;
        this.components = components;
        this.rawComponents = rawComponents;
        this.entityMapToComponent = entityMapToComponent;
        this.byComponentType = byComponentType;
        this.parentMapToEntity = parentMapToEntity;
        this.entityMapToParent = entityMapToParent;
        this.noIdComponents = noIdComponents;
    }

    public /* synthetic */ MutableEntity(Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LinkedHashMap() : map, (i3 & 2) != 0 ? new LinkedHashMap() : map2, (i3 & 4) != 0 ? new LinkedHashMap() : map3, (i3 & 8) != 0 ? new LinkedHashMap() : map4, (i3 & 16) != 0 ? new LinkedHashMap() : map5, (i3 & 32) != 0 ? new LinkedHashMap() : map6, (i3 & 64) != 0 ? new LinkedHashMap() : map7, (i3 & 128) != 0 ? new LinkedHashMap() : map8);
    }
}
