package com.tencent.tavcut.rendermodel.entity;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/tavcut/rendermodel/entity/Entity;", "", "id", "", "name", "", Node.CHILDREN_ATTR, "", "components", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "enable", "", "version", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;ZI)V", "getChildren", "()Ljava/util/List;", "getComponents", "getEnable", "()Z", "getId", "()I", "getName", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class Entity {

    @NotNull
    private final List<Entity> children;

    @NotNull
    private final List<IdentifyComponent> components;
    private final boolean enable;
    private final int id;

    @NotNull
    private final String name;
    private final int version;

    public Entity() {
        this(0, null, null, null, false, 0, 63, null);
    }

    public static /* synthetic */ Entity copy$default(Entity entity, int i3, String str, List list, List list2, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = entity.id;
        }
        if ((i17 & 2) != 0) {
            str = entity.name;
        }
        String str2 = str;
        if ((i17 & 4) != 0) {
            list = entity.children;
        }
        List list3 = list;
        if ((i17 & 8) != 0) {
            list2 = entity.components;
        }
        List list4 = list2;
        if ((i17 & 16) != 0) {
            z16 = entity.enable;
        }
        boolean z17 = z16;
        if ((i17 & 32) != 0) {
            i16 = entity.version;
        }
        return entity.copy(i3, str2, list3, list4, z17, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<Entity> component3() {
        return this.children;
    }

    @NotNull
    public final List<IdentifyComponent> component4() {
        return this.components;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component6, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public final Entity copy(int id5, @NotNull String name, @NotNull List<Entity> children, @NotNull List<IdentifyComponent> components, boolean enable, int version) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(children, "children");
        Intrinsics.checkParameterIsNotNull(components, "components");
        return new Entity(id5, name, children, components, enable, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Entity) {
                Entity entity = (Entity) other;
                if (this.id != entity.id || !Intrinsics.areEqual(this.name, entity.name) || !Intrinsics.areEqual(this.children, entity.children) || !Intrinsics.areEqual(this.components, entity.components) || this.enable != entity.enable || this.version != entity.version) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<Entity> getChildren() {
        return this.children;
    }

    @NotNull
    public final List<IdentifyComponent> getComponents() {
        return this.components;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getVersion() {
        return this.version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.id * 31;
        String str = this.name;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        List<Entity> list = this.children;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        List<IdentifyComponent> list2 = this.components;
        if (list2 != null) {
            i18 = list2.hashCode();
        }
        int i27 = (i26 + i18) * 31;
        boolean z16 = this.enable;
        int i28 = z16;
        if (z16 != 0) {
            i28 = 1;
        }
        return ((i27 + i28) * 31) + this.version;
    }

    @NotNull
    public String toString() {
        return "Entity(id=" + this.id + ", name=" + this.name + ", children=" + this.children + ", components=" + this.components + ", enable=" + this.enable + ", version=" + this.version + ")";
    }

    public Entity(int i3, @NotNull String name, @NotNull List<Entity> children, @NotNull List<IdentifyComponent> components, boolean z16, int i16) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(children, "children");
        Intrinsics.checkParameterIsNotNull(components, "components");
        this.id = i3;
        this.name = name;
        this.children = children;
        this.components = components;
        this.enable = z16;
        this.version = i16;
    }

    public /* synthetic */ Entity(int i3, String str, List list, List list2, boolean z16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i17 & 16) != 0 ? true : z16, (i17 & 32) != 0 ? 0 : i16);
    }
}
