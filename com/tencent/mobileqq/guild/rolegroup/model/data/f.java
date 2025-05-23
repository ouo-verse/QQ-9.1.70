package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/f;", "", "", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "f", "", "tinyIds", "", "g", QCircleAlphaUserReporter.KEY_USER, "a", "b", "c", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "e", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", tl.h.F, "(Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;)V", "role", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "list", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RoleGroupModel role;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProUserInfo> list;

    public f(@NotNull RoleGroupModel role, @NotNull List<IGProUserInfo> list) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(list, "list");
        this.role = role;
        this.list = list;
    }

    public final boolean a(@NotNull IGProUserInfo user) {
        Object obj;
        Intrinsics.checkNotNullParameter(user, "user");
        Iterator<T> it = this.list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), user.getTinyId())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((IGProUserInfo) obj) == null) {
            this.list.add(user);
            return true;
        }
        return false;
    }

    public final boolean b(@NotNull String tinyId) {
        Object obj;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Iterator<T> it = this.list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), tinyId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final IGProUserInfo c(@NotNull String tinyId) {
        Object obj;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Iterator<T> it = this.list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), tinyId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (IGProUserInfo) obj;
    }

    @NotNull
    public final List<IGProUserInfo> d() {
        return this.list;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final RoleGroupModel getRole() {
        return this.role;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (Intrinsics.areEqual(this.role, fVar.role) && Intrinsics.areEqual(this.list, fVar.list)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final IGProUserInfo f(@NotNull String tinyId) {
        Object obj;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Iterator<T> it = this.list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), tinyId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
        if (iGProUserInfo == null) {
            return null;
        }
        this.list.remove(iGProUserInfo);
        return iGProUserInfo;
    }

    public final boolean g(@NotNull Set<String> tinyIds) {
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        List<IGProUserInfo> list = this.list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (tinyIds.contains(((IGProUserInfo) obj).getTinyId())) {
                arrayList.add(obj);
            }
        }
        return this.list.removeAll(arrayList);
    }

    public final void h(@NotNull RoleGroupModel roleGroupModel) {
        Intrinsics.checkNotNullParameter(roleGroupModel, "<set-?>");
        this.role = roleGroupModel;
    }

    public int hashCode() {
        return (this.role.hashCode() * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        RoleGroupModel roleGroupModel = this.role;
        List<IGProUserInfo> list = this.list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(InnerMember.INSTANCE.a((IGProUserInfo) it.next()));
        }
        return "MemberListModel(role=" + roleGroupModel + ", list=" + arrayList + ")";
    }
}
