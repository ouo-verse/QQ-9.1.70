package com.tencent.mobileqq.troop.appscenter.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.RankList;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\f\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/data/e;", "Lcom/tencent/mobileqq/troop/appscenter/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RankList;", "b", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setRankList", "(Ljava/util/ArrayList;)V", "rankList", "Z", "d", "()Z", "setOwnerOrAdmin", "(Z)V", "isOwnerOrAdmin", "a", "isEditManage", "<init>", "(Ljava/util/ArrayList;ZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RankList> rankList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isOwnerOrAdmin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isEditManage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull ArrayList<RankList> rankList, boolean z16, boolean z17) {
        super(z17, null);
        Intrinsics.checkNotNullParameter(rankList, "rankList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rankList, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.rankList = rankList;
        this.isOwnerOrAdmin = z16;
        this.isEditManage = z17;
    }

    @Override // com.tencent.mobileqq.troop.appscenter.data.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isEditManage;
    }

    @Override // com.tencent.mobileqq.troop.appscenter.data.a
    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isEditManage = z16;
        }
    }

    @NotNull
    public final ArrayList<RankList> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.rankList;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isOwnerOrAdmin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.rankList, eVar.rankList) && this.isOwnerOrAdmin == eVar.isOwnerOrAdmin && a() == eVar.a()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int hashCode = this.rankList.hashCode() * 31;
        ?? r16 = this.isOwnerOrAdmin;
        ?? r26 = 1;
        int i3 = r16;
        if (r16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean a16 = a();
        if (!a16) {
            r26 = a16;
        }
        return i16 + r26;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "TroopRankAppsData(rankList=" + this.rankList + ", isOwnerOrAdmin=" + this.isOwnerOrAdmin + ", isEditManage=" + a() + ")";
    }
}
