package com.tencent.mobileqq.selectmember.troop.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$CheckGroupsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a\u0012\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0016\u0010\u001dR#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/selectmember/troop/repo/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$CheckGroupsRsp;", "a", "Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$CheckGroupsRsp;", "b", "()Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$CheckGroupsRsp;", "checkSubGroupsRsp", "", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "nameWrongGroups", "e", "sourceGroups", "d", "getBindMasterGroups", "bindMasterGroups", "bindSubGroups", "", "f", "Ljava/util/List;", "()Ljava/util/List;", "searchFilterTroopUinList", "g", "unsafeGroups", "<init>", "(Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$CheckGroupsRsp;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;)V", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopJoinQunAutoSwitch$CheckGroupsRsp checkSubGroupsRsp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Boolean> nameWrongGroups;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Boolean> sourceGroups;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Boolean> bindMasterGroups;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> bindSubGroups;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> searchFilterTroopUinList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Boolean> unsafeGroups;

    public f() {
        this(null, null, null, null, null, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this);
    }

    @NotNull
    public final Map<String, String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.bindSubGroups;
    }

    @Nullable
    public final TroopJoinQunAutoSwitch$CheckGroupsRsp b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopJoinQunAutoSwitch$CheckGroupsRsp) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.checkSubGroupsRsp;
    }

    @NotNull
    public final Map<String, Boolean> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nameWrongGroups;
    }

    @NotNull
    public final List<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.searchFilterTroopUinList;
    }

    @NotNull
    public final Map<String, Boolean> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.sourceGroups;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (Intrinsics.areEqual(this.checkSubGroupsRsp, fVar.checkSubGroupsRsp) && Intrinsics.areEqual(this.nameWrongGroups, fVar.nameWrongGroups) && Intrinsics.areEqual(this.sourceGroups, fVar.sourceGroups) && Intrinsics.areEqual(this.bindMasterGroups, fVar.bindMasterGroups) && Intrinsics.areEqual(this.bindSubGroups, fVar.bindSubGroups) && Intrinsics.areEqual(this.searchFilterTroopUinList, fVar.searchFilterTroopUinList) && Intrinsics.areEqual(this.unsafeGroups, fVar.unsafeGroups)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, Boolean> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.unsafeGroups;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        TroopJoinQunAutoSwitch$CheckGroupsRsp troopJoinQunAutoSwitch$CheckGroupsRsp = this.checkSubGroupsRsp;
        if (troopJoinQunAutoSwitch$CheckGroupsRsp == null) {
            hashCode = 0;
        } else {
            hashCode = troopJoinQunAutoSwitch$CheckGroupsRsp.hashCode();
        }
        return (((((((((((hashCode * 31) + this.nameWrongGroups.hashCode()) * 31) + this.sourceGroups.hashCode()) * 31) + this.bindMasterGroups.hashCode()) * 31) + this.bindSubGroups.hashCode()) * 31) + this.searchFilterTroopUinList.hashCode()) * 31) + this.unsafeGroups.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "TroopListCheckResult(checkSubGroupsRsp=" + this.checkSubGroupsRsp + ", nameWrongGroups=" + this.nameWrongGroups + ", sourceGroups=" + this.sourceGroups + ", bindMasterGroups=" + this.bindMasterGroups + ", bindSubGroups=" + this.bindSubGroups + ", searchFilterTroopUinList=" + this.searchFilterTroopUinList + ", unsafeGroups=" + this.unsafeGroups + ")";
    }

    public f(@Nullable TroopJoinQunAutoSwitch$CheckGroupsRsp troopJoinQunAutoSwitch$CheckGroupsRsp, @NotNull Map<String, Boolean> nameWrongGroups, @NotNull Map<String, Boolean> sourceGroups, @NotNull Map<String, Boolean> bindMasterGroups, @NotNull Map<String, String> bindSubGroups, @NotNull List<String> searchFilterTroopUinList, @NotNull Map<String, Boolean> unsafeGroups) {
        Intrinsics.checkNotNullParameter(nameWrongGroups, "nameWrongGroups");
        Intrinsics.checkNotNullParameter(sourceGroups, "sourceGroups");
        Intrinsics.checkNotNullParameter(bindMasterGroups, "bindMasterGroups");
        Intrinsics.checkNotNullParameter(bindSubGroups, "bindSubGroups");
        Intrinsics.checkNotNullParameter(searchFilterTroopUinList, "searchFilterTroopUinList");
        Intrinsics.checkNotNullParameter(unsafeGroups, "unsafeGroups");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopJoinQunAutoSwitch$CheckGroupsRsp, nameWrongGroups, sourceGroups, bindMasterGroups, bindSubGroups, searchFilterTroopUinList, unsafeGroups);
            return;
        }
        this.checkSubGroupsRsp = troopJoinQunAutoSwitch$CheckGroupsRsp;
        this.nameWrongGroups = nameWrongGroups;
        this.sourceGroups = sourceGroups;
        this.bindMasterGroups = bindMasterGroups;
        this.bindSubGroups = bindSubGroups;
        this.searchFilterTroopUinList = searchFilterTroopUinList;
        this.unsafeGroups = unsafeGroups;
    }

    public /* synthetic */ f(TroopJoinQunAutoSwitch$CheckGroupsRsp troopJoinQunAutoSwitch$CheckGroupsRsp, Map map, Map map2, Map map3, Map map4, List list, Map map5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : troopJoinQunAutoSwitch$CheckGroupsRsp, (i3 & 2) != 0 ? new LinkedHashMap() : map, (i3 & 4) != 0 ? new LinkedHashMap() : map2, (i3 & 8) != 0 ? new LinkedHashMap() : map3, (i3 & 16) != 0 ? new LinkedHashMap() : map4, (i3 & 32) != 0 ? new ArrayList() : list, (i3 & 64) != 0 ? new LinkedHashMap() : map5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, troopJoinQunAutoSwitch$CheckGroupsRsp, map, map2, map3, map4, list, map5, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
