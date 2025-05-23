package com.tencent.mobileqq.troop.change.troopmemberinfo.level;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u000e\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/change/troopmemberinfo/level/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "titleId", "b", "newLevel", "e", "uniqueTitleExpire", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "uniqueTitle", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "role", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;)V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer titleId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer newLevel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer uniqueTitleExpire;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String uniqueTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MemberRole role;

    public a(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str, @Nullable MemberRole memberRole) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, num, num2, num3, str, memberRole);
            return;
        }
        this.titleId = num;
        this.newLevel = num2;
        this.uniqueTitleExpire = num3;
        this.uniqueTitle = str;
        this.role = memberRole;
    }

    @Nullable
    public final Integer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.newLevel;
    }

    @Nullable
    public final MemberRole b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MemberRole) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.role;
    }

    @Nullable
    public final Integer c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.titleId;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uniqueTitle;
    }

    @Nullable
    public final Integer e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.uniqueTitleExpire;
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
        if (Intrinsics.areEqual(this.titleId, aVar.titleId) && Intrinsics.areEqual(this.newLevel, aVar.newLevel) && Intrinsics.areEqual(this.uniqueTitleExpire, aVar.uniqueTitleExpire) && Intrinsics.areEqual(this.uniqueTitle, aVar.uniqueTitle) && this.role == aVar.role) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        Integer num = this.titleId;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num2 = this.newLevel;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Integer num3 = this.uniqueTitleExpire;
        if (num3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str = this.uniqueTitle;
        if (str == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        MemberRole memberRole = this.role;
        if (memberRole != null) {
            i3 = memberRole.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "TroopMemberInfoLevelItem(titleId=" + this.titleId + ", newLevel=" + this.newLevel + ", uniqueTitleExpire=" + this.uniqueTitleExpire + ", uniqueTitle=" + this.uniqueTitle + ", role=" + this.role + ')';
    }
}
