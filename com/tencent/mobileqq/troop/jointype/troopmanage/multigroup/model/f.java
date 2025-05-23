package com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/f;", "", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageItemType;", "a", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageItemType;", "d", "()Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageItemType;", "type", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/b;", "b", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/b;", "()Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/b;", "troopDataInfo", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/c;", "c", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/c;", "()Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/c;", "troopInfo", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageDataFrom;", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageDataFrom;", "()Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageDataFrom;", "dataFrom", "<init>", "(Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageItemType;Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/b;Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/c;Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageDataFrom;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopMultiGroupManageItemType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b troopDataInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c troopInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopMultiGroupManageDataFrom dataFrom;

    public f(@NotNull TroopMultiGroupManageItemType type, @Nullable b bVar, @Nullable c cVar, @NotNull TroopMultiGroupManageDataFrom dataFrom) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(dataFrom, "dataFrom");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, type, bVar, cVar, dataFrom);
            return;
        }
        this.type = type;
        this.troopDataInfo = bVar;
        this.troopInfo = cVar;
        this.dataFrom = dataFrom;
    }

    @NotNull
    public final TroopMultiGroupManageDataFrom a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopMultiGroupManageDataFrom) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.dataFrom;
    }

    @Nullable
    public final b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopDataInfo;
    }

    @Nullable
    public final c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.troopInfo;
    }

    @NotNull
    public final TroopMultiGroupManageItemType d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopMultiGroupManageItemType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.type;
    }

    public /* synthetic */ f(TroopMultiGroupManageItemType troopMultiGroupManageItemType, b bVar, c cVar, TroopMultiGroupManageDataFrom troopMultiGroupManageDataFrom, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(troopMultiGroupManageItemType, (i3 & 2) != 0 ? null : bVar, (i3 & 4) == 0 ? cVar : null, (i3 & 8) != 0 ? TroopMultiGroupManageDataFrom.MULTI_GROUP_MANAGE_DATA_FROM_LOCAL : troopMultiGroupManageDataFrom);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, troopMultiGroupManageItemType, bVar, cVar, troopMultiGroupManageDataFrom, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
