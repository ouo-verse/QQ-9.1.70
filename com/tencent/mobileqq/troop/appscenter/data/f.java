package com.tencent.mobileqq.troop.appscenter.data;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b\f\u0010\u0018R$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\"\u001a\u0004\b\u001e\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/data/f;", "Lcom/tencent/mobileqq/troop/appscenter/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "b", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "setRecommendApps", "(Ljava/util/ArrayList;)V", "recommendApps", "c", "Z", "isOwnerOrAdmin", "()Z", "setOwnerOrAdmin", "(Z)V", "I", "()I", "f", "(I)V", "columnsSize", "e", "a", "isEditManage", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "setTroopInfo", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "troopInfo", "<init>", "(Ljava/util/ArrayList;ZIZLcom/tencent/mobileqq/data/troop/TroopInfo;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class f extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<AppDetail> recommendApps;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isOwnerOrAdmin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int columnsSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isEditManage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopInfo troopInfo;

    public /* synthetic */ f(ArrayList arrayList, boolean z16, int i3, boolean z17, TroopInfo troopInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, z16, i3, z17, (i16 & 16) != 0 ? null : troopInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, arrayList, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), troopInfo, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // com.tencent.mobileqq.troop.appscenter.data.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isEditManage;
    }

    @Override // com.tencent.mobileqq.troop.appscenter.data.a
    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.isEditManage = z16;
        }
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.columnsSize;
    }

    @NotNull
    public final ArrayList<AppDetail> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.recommendApps;
    }

    @Nullable
    public final TroopInfo e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.troopInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (Intrinsics.areEqual(this.recommendApps, fVar.recommendApps) && this.isOwnerOrAdmin == fVar.isOwnerOrAdmin && this.columnsSize == fVar.columnsSize && a() == fVar.a() && Intrinsics.areEqual(this.troopInfo, fVar.troopInfo)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.columnsSize = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int hashCode2 = this.recommendApps.hashCode() * 31;
        ?? r16 = this.isOwnerOrAdmin;
        ?? r26 = 1;
        int i3 = r16;
        if (r16 != 0) {
            i3 = 1;
        }
        int i16 = (((hashCode2 + i3) * 31) + this.columnsSize) * 31;
        boolean a16 = a();
        if (!a16) {
            r26 = a16;
        }
        int i17 = (i16 + r26) * 31;
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null) {
            hashCode = 0;
        } else {
            hashCode = troopInfo.hashCode();
        }
        return i17 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "TroopRecommendAppsData(recommendApps=" + this.recommendApps + ", isOwnerOrAdmin=" + this.isOwnerOrAdmin + ", columnsSize=" + this.columnsSize + ", isEditManage=" + a() + ", troopInfo=" + this.troopInfo + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull ArrayList<AppDetail> recommendApps, boolean z16, int i3, boolean z17, @Nullable TroopInfo troopInfo) {
        super(z17, null);
        Intrinsics.checkNotNullParameter(recommendApps, "recommendApps");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, recommendApps, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), troopInfo);
            return;
        }
        this.recommendApps = recommendApps;
        this.isOwnerOrAdmin = z16;
        this.columnsSize = i3;
        this.isEditManage = z17;
        this.troopInfo = troopInfo;
    }
}
