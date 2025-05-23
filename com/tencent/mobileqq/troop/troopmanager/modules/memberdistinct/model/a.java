package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.protofile.TroopMemberDetectSvr$DuplicateMember;
import com.tencent.protofile.TroopMemberDetectSvr$GroupInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0003\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;", "", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/TroopMemberDistinctResultListItemType;", "a", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/TroopMemberDistinctResultListItemType;", "c", "()Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/TroopMemberDistinctResultListItemType;", "type", "Lcom/tencent/protofile/TroopMemberDetectSvr$DuplicateMember;", "b", "Lcom/tencent/protofile/TroopMemberDetectSvr$DuplicateMember;", "()Lcom/tencent/protofile/TroopMemberDetectSvr$DuplicateMember;", "memberInfo", "Lcom/tencent/protofile/TroopMemberDetectSvr$GroupInfo;", "Lcom/tencent/protofile/TroopMemberDetectSvr$GroupInfo;", "()Lcom/tencent/protofile/TroopMemberDetectSvr$GroupInfo;", "groupInfo", "", "d", "Z", "()Z", "e", "(Z)V", "isGroupCheckedToDelete", "<init>", "(Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/TroopMemberDistinctResultListItemType;Lcom/tencent/protofile/TroopMemberDetectSvr$DuplicateMember;Lcom/tencent/protofile/TroopMemberDetectSvr$GroupInfo;Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopMemberDistinctResultListItemType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopMemberDetectSvr$DuplicateMember memberInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopMemberDetectSvr$GroupInfo groupInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isGroupCheckedToDelete;

    public a(@NotNull TroopMemberDistinctResultListItemType type, @Nullable TroopMemberDetectSvr$DuplicateMember troopMemberDetectSvr$DuplicateMember, @Nullable TroopMemberDetectSvr$GroupInfo troopMemberDetectSvr$GroupInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, type, troopMemberDetectSvr$DuplicateMember, troopMemberDetectSvr$GroupInfo, Boolean.valueOf(z16));
            return;
        }
        this.type = type;
        this.memberInfo = troopMemberDetectSvr$DuplicateMember;
        this.groupInfo = troopMemberDetectSvr$GroupInfo;
        this.isGroupCheckedToDelete = z16;
    }

    @Nullable
    public final TroopMemberDetectSvr$GroupInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMemberDetectSvr$GroupInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.groupInfo;
    }

    @Nullable
    public final TroopMemberDetectSvr$DuplicateMember b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopMemberDetectSvr$DuplicateMember) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.memberInfo;
    }

    @NotNull
    public final TroopMemberDistinctResultListItemType c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopMemberDistinctResultListItemType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.type;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isGroupCheckedToDelete;
    }

    public final void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isGroupCheckedToDelete = z16;
        }
    }

    public /* synthetic */ a(TroopMemberDistinctResultListItemType troopMemberDistinctResultListItemType, TroopMemberDetectSvr$DuplicateMember troopMemberDetectSvr$DuplicateMember, TroopMemberDetectSvr$GroupInfo troopMemberDetectSvr$GroupInfo, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(troopMemberDistinctResultListItemType, (i3 & 2) != 0 ? null : troopMemberDetectSvr$DuplicateMember, (i3 & 4) == 0 ? troopMemberDetectSvr$GroupInfo : null, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, troopMemberDistinctResultListItemType, troopMemberDetectSvr$DuplicateMember, troopMemberDetectSvr$GroupInfo, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
