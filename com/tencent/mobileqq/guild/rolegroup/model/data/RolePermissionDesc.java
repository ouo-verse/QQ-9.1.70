package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.Desc;
import com.tencent.mobileqq.qqguildsdk.data.ek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB5\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/i;", "", "", "e", "", "toString", "", "hashCode", "other", "equals", "a", "I", "c", "()I", "permissionType", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "desc", "getCount", "count", "permType", "<init>", "(ILjava/lang/String;Ljava/lang/String;II)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.i, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RolePermissionDesc {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int permissionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int permType;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0002J2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\b\u0012\u0004\u0012\u00020\u0006`\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/i$a;", "", "", "title", "", "count", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/i;", "b", "permissionType", "desc", "permType", "a", "", "Lcom/tencent/mobileqq/qqguildsdk/data/bv;", "descList", "Lcom/tencent/mobileqq/qqguildsdk/data/ek;", "permissionCategories", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "TAG", "Ljava/lang/String;", "TYPE_GROUP", "I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.i$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final RolePermissionDesc a(int permissionType, String title, String desc, int permType) {
            return new RolePermissionDesc(permissionType, title, desc, 0, permType, 8, null);
        }

        private final RolePermissionDesc b(String title, int count) {
            return new RolePermissionDesc(-1, title, null, count, 0, 20, null);
        }

        @NotNull
        public final ArrayList<RolePermissionDesc> c(@NotNull List<Desc> descList, @NotNull List<? extends ek> permissionCategories) {
            Intrinsics.checkNotNullParameter(descList, "descList");
            Intrinsics.checkNotNullParameter(permissionCategories, "permissionCategories");
            ArrayList<RolePermissionDesc> arrayList = new ArrayList<>();
            int i3 = 0;
            for (ek ekVar : permissionCategories) {
                int a16 = ekVar.a() + i3;
                String name = ekVar.getName();
                Intrinsics.checkNotNullExpressionValue(name, "group.name");
                arrayList.add(b(name, ekVar.a()));
                while (true) {
                    if (i3 >= a16) {
                        break;
                    }
                    if (a16 > descList.size()) {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str = "ofList step:" + a16 + " descSize:" + descList.size();
                        if (str instanceof String) {
                            bVar.a().add(str);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("Guild.rg.RolePermissionDesc", 1, (String) it.next(), null);
                        }
                    } else {
                        arrayList.add(a(descList.get(i3).getId(), descList.get(i3).getTitle(), descList.get(i3).getDesc(), descList.get(i3).getPermType()));
                        i3++;
                    }
                }
                i3 = a16;
            }
            if (i3 != descList.size()) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str2 = "ofList step:" + i3 + " descSize:" + descList.size();
                if (str2 instanceof String) {
                    bVar2.a().add(str2);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.RolePermissionDesc", 1, (String) it5.next(), null);
                }
            }
            return arrayList;
        }

        Companion() {
        }
    }

    public RolePermissionDesc(int i3, @NotNull String title, @NotNull String desc, int i16, int i17) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.permissionType = i3;
        this.title = title;
        this.desc = desc;
        this.count = i16;
        this.permType = i17;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: b, reason: from getter */
    public final int getPermType() {
        return this.permType;
    }

    /* renamed from: c, reason: from getter */
    public final int getPermissionType() {
        return this.permissionType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final boolean e() {
        if (this.permissionType == -1) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RolePermissionDesc)) {
            return false;
        }
        RolePermissionDesc rolePermissionDesc = (RolePermissionDesc) other;
        if (this.permissionType == rolePermissionDesc.permissionType && Intrinsics.areEqual(this.title, rolePermissionDesc.title) && Intrinsics.areEqual(this.desc, rolePermissionDesc.desc) && this.count == rolePermissionDesc.count && this.permType == rolePermissionDesc.permType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.permissionType * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.count) * 31) + this.permType;
    }

    @NotNull
    public String toString() {
        return "RolePermissionDesc(permissionType=" + this.permissionType + ", title=" + this.title + ", desc=" + this.desc + ", count=" + this.count + ", permType=" + this.permType + ")";
    }

    public /* synthetic */ RolePermissionDesc(int i3, String str, String str2, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i18 & 4) != 0 ? "" : str2, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? 0 : i17);
    }
}
