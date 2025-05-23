package com.tencent.mobileqq.troop.troopblacklist.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/troop/troopblacklist/model/a;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "setSortedModelList", "(Ljava/util/List;)V", "sortedModelList", "", "setIndexList", "indexList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<a> sortedModelList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Character> indexList;

    public e() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this);
    }

    @NotNull
    public final List<Character> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.indexList;
    }

    @NotNull
    public final List<a> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sortedModelList;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.sortedModelList, eVar.sortedModelList) && Intrinsics.areEqual(this.indexList, eVar.indexList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return (this.sortedModelList.hashCode() * 31) + this.indexList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "TroopBlackListUIModel(sortedModelList=" + this.sortedModelList + ", indexList=" + this.indexList + ")";
    }

    public e(@NotNull List<a> sortedModelList, @NotNull List<Character> indexList) {
        Intrinsics.checkNotNullParameter(sortedModelList, "sortedModelList");
        Intrinsics.checkNotNullParameter(indexList, "indexList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sortedModelList, (Object) indexList);
        } else {
            this.sortedModelList = sortedModelList;
            this.indexList = indexList;
        }
    }

    public /* synthetic */ e(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new ArrayList() : list2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, list2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
