package com.tencent.qqnt.inner.compator.troopinfo.level;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/level/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getOwnerUin", "()Ljava/lang/String;", "ownerUin", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "b", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "getRole", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "role", "", "c", "Ljava/lang/Byte;", "getRankUserFlag", "()Ljava/lang/Byte;", "rankUserFlag", "d", "getNewRankUserFlag", "newRankUserFlag", "", "e", "J", "getLevelSeq", "()J", "levelSeq", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;Ljava/lang/Byte;Ljava/lang/Byte;J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String ownerUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MemberRole role;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Byte rankUserFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Byte newRankUserFlag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long levelSeq;

    public a(@Nullable String str, @Nullable MemberRole memberRole, @Nullable Byte b16, @Nullable Byte b17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, memberRole, b16, b17, Long.valueOf(j3));
            return;
        }
        this.ownerUin = str;
        this.role = memberRole;
        this.rankUserFlag = b16;
        this.newRankUserFlag = b17;
        this.levelSeq = j3;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.ownerUin, aVar.ownerUin) && this.role == aVar.role && Intrinsics.areEqual(this.rankUserFlag, aVar.rankUserFlag) && Intrinsics.areEqual(this.newRankUserFlag, aVar.newRankUserFlag) && this.levelSeq == aVar.levelSeq) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        String str = this.ownerUin;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        MemberRole memberRole = this.role;
        if (memberRole == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = memberRole.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Byte b16 = this.rankUserFlag;
        if (b16 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = b16.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Byte b17 = this.newRankUserFlag;
        if (b17 != null) {
            i3 = b17.hashCode();
        }
        return ((i18 + i3) * 31) + androidx.fragment.app.a.a(this.levelSeq);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "TroopInfoChangedLevelItem(ownerUin=" + this.ownerUin + ", role=" + this.role + ", rankUserFlag=" + this.rankUserFlag + ", newRankUserFlag=" + this.newRankUserFlag + ", levelSeq=" + this.levelSeq + ")";
    }
}
