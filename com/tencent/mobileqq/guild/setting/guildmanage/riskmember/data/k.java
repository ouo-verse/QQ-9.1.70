package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010#\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\rH\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "", "", "tinyId", "", "b", "", "g", "i", "c", "isSelected", "a", "f", "", "toString", "", "hashCode", "other", "equals", "J", "getTotalCount", "()J", tl.h.F, "(J)V", "totalCount", "Z", "e", "()Z", "setChooseSelectAll", "(Z)V", "isChooseSelectAll", "", "Ljava/util/Set;", "d", "()Ljava/util/Set;", "setTinyIds", "(Ljava/util/Set;)V", "tinyIds", "<init>", "(JZLjava/util/Set;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long totalCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isChooseSelectAll;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<Long> tinyIds;

    public k() {
        this(0L, false, null, 7, null);
    }

    public final boolean a(long tinyId, boolean isSelected) {
        boolean z16 = this.isChooseSelectAll;
        if ((z16 && !isSelected) || (!z16 && isSelected)) {
            if (this.tinyIds.size() >= l.a()) {
                QQToast.makeText(BaseApplication.getContext(), 1, "\u6240\u9009\u7528\u6237\u8d85\u51fa\u6570\u91cf\u4e0a\u9650", 1).show();
                return false;
            }
            return this.tinyIds.add(Long.valueOf(tinyId));
        }
        return this.tinyIds.remove(Long.valueOf(tinyId));
    }

    public final boolean b(long tinyId) {
        if (this.isChooseSelectAll) {
            if (!this.tinyIds.contains(Long.valueOf(tinyId))) {
                return true;
            }
            return false;
        }
        return this.tinyIds.contains(Long.valueOf(tinyId));
    }

    public final long c() {
        if (this.isChooseSelectAll) {
            return this.totalCount - this.tinyIds.size();
        }
        return this.tinyIds.size();
    }

    @NotNull
    public final Set<Long> d() {
        return this.tinyIds;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsChooseSelectAll() {
        return this.isChooseSelectAll;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        if (this.totalCount == kVar.totalCount && this.isChooseSelectAll == kVar.isChooseSelectAll && Intrinsics.areEqual(this.tinyIds, kVar.tinyIds)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.isChooseSelectAll) {
            return this.tinyIds.isEmpty();
        }
        if (((int) this.totalCount) != 0 && this.tinyIds.size() == this.totalCount) {
            return true;
        }
        return false;
    }

    public final void g() {
        this.isChooseSelectAll = true;
        this.tinyIds.clear();
    }

    public final void h(long j3) {
        this.totalCount = j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = androidx.fragment.app.a.a(this.totalCount) * 31;
        boolean z16 = this.isChooseSelectAll;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((a16 + i3) * 31) + this.tinyIds.hashCode();
    }

    public final void i() {
        this.isChooseSelectAll = false;
        this.tinyIds.clear();
    }

    @NotNull
    public String toString() {
        String joinToString$default;
        boolean z16 = this.isChooseSelectAll;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.tinyIds, ",", null, null, 0, null, null, 62, null);
        return "SelectedMemberInfo{isChooseSelectAll = " + z16 + ", tinyIds = " + joinToString$default + "}";
    }

    public k(long j3, boolean z16, @NotNull Set<Long> tinyIds) {
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        this.totalCount = j3;
        this.isChooseSelectAll = z16;
        this.tinyIds = tinyIds;
    }

    public /* synthetic */ k(long j3, boolean z16, Set set, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? new LinkedHashSet() : set);
    }
}
