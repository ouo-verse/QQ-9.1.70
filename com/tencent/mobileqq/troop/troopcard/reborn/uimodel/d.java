package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b!\u0010\"JG\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u001c\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/d;", "", "", "troopUin", "", "hasSetNewTroopHead", "isMember", "isOwnerOrAdmin", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/l;", "liveStatusUIModel", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "picInfo", "a", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "b", "Z", "c", "()Z", "g", "d", tl.h.F, "e", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/l;", "()Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/l;", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "()Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "<init>", "(Ljava/lang/String;ZZZLcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/l;Lcom/tencent/mobileqq/data/troop/TroopClipPic;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean hasSetNewTroopHead;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isMember;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isOwnerOrAdmin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l liveStatusUIModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopClipPic picInfo;

    public d(@NotNull String troopUin, boolean z16, boolean z17, boolean z18, @NotNull l liveStatusUIModel, @Nullable TroopClipPic troopClipPic) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(liveStatusUIModel, "liveStatusUIModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), liveStatusUIModel, troopClipPic);
            return;
        }
        this.troopUin = troopUin;
        this.hasSetNewTroopHead = z16;
        this.isMember = z17;
        this.isOwnerOrAdmin = z18;
        this.liveStatusUIModel = liveStatusUIModel;
        this.picInfo = troopClipPic;
    }

    public static /* synthetic */ d b(d dVar, String str, boolean z16, boolean z17, boolean z18, l lVar, TroopClipPic troopClipPic, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dVar.troopUin;
        }
        if ((i3 & 2) != 0) {
            z16 = dVar.hasSetNewTroopHead;
        }
        boolean z19 = z16;
        if ((i3 & 4) != 0) {
            z17 = dVar.isMember;
        }
        boolean z26 = z17;
        if ((i3 & 8) != 0) {
            z18 = dVar.isOwnerOrAdmin;
        }
        boolean z27 = z18;
        if ((i3 & 16) != 0) {
            lVar = dVar.liveStatusUIModel;
        }
        l lVar2 = lVar;
        if ((i3 & 32) != 0) {
            troopClipPic = dVar.picInfo;
        }
        return dVar.a(str, z19, z26, z27, lVar2, troopClipPic);
    }

    @NotNull
    public final d a(@NotNull String troopUin, boolean hasSetNewTroopHead, boolean isMember, boolean isOwnerOrAdmin, @NotNull l liveStatusUIModel, @Nullable TroopClipPic picInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (d) iPatchRedirector.redirect((short) 15, this, troopUin, Boolean.valueOf(hasSetNewTroopHead), Boolean.valueOf(isMember), Boolean.valueOf(isOwnerOrAdmin), liveStatusUIModel, picInfo);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(liveStatusUIModel, "liveStatusUIModel");
        return new d(troopUin, hasSetNewTroopHead, isMember, isOwnerOrAdmin, liveStatusUIModel, picInfo);
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.hasSetNewTroopHead;
    }

    @NotNull
    public final l d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (l) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.liveStatusUIModel;
    }

    @Nullable
    public final TroopClipPic e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TroopClipPic) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.picInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.troopUin, dVar.troopUin) && this.hasSetNewTroopHead == dVar.hasSetNewTroopHead && this.isMember == dVar.isMember && this.isOwnerOrAdmin == dVar.isOwnerOrAdmin && Intrinsics.areEqual(this.liveStatusUIModel, dVar.liveStatusUIModel) && Intrinsics.areEqual(this.picInfo, dVar.picInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isMember;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isOwnerOrAdmin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        int hashCode2 = this.troopUin.hashCode() * 31;
        boolean z16 = this.hasSetNewTroopHead;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isMember;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.isOwnerOrAdmin;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int hashCode3 = (((i19 + i3) * 31) + this.liveStatusUIModel.hashCode()) * 31;
        TroopClipPic troopClipPic = this.picInfo;
        if (troopClipPic == null) {
            hashCode = 0;
        } else {
            hashCode = troopClipPic.hashCode();
        }
        return hashCode3 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "TroopAvatarUIModel(troopUin=" + this.troopUin + ", hasSetNewTroopHead=" + this.hasSetNewTroopHead + ", isMember=" + this.isMember + ", isOwnerOrAdmin=" + this.isOwnerOrAdmin + ", liveStatusUIModel=" + this.liveStatusUIModel + ", picInfo=" + this.picInfo + ")";
    }

    public /* synthetic */ d(String str, boolean z16, boolean z17, boolean z18, l lVar, TroopClipPic troopClipPic, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, z17, z18, (i3 & 16) != 0 ? new l(false, "") : lVar, (i3 & 32) != 0 ? null : troopClipPic);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), lVar, troopClipPic, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
