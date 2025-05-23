package com.tencent.mobileqq.troop.teamup.member.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpApplicationMaterial;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u001a\u0010\u0012\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u0019\u0010\u001cR\u0017\u0010!\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b \u0010\u0011R\u0017\u0010%\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b\u001e\u0010$R\u0017\u0010)\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b\u0013\u0010(R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/data/c;", "Lcom/tencent/mobileqq/troop/teamup/member/data/b;", "", h.F, "l", "g", "j", "k", "", "toString", "", "hashCode", "", "other", "equals", "a", "I", "()I", "type", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "memberName", "", "c", "J", "f", "()J", "memberUin", "d", "joinTime", "getJoinGroupStatus", "joinGroupStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpApplicationMaterial;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpApplicationMaterial;", "()Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpApplicationMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "()Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detailData", "Z", "i", "()Z", "setEndData", "(Z)V", "isEndData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "isSelect", DomainData.DOMAIN_NAME, "p", "isSelectCreatePage", "<init>", "(ILjava/lang/String;JJILcom/tencent/qqnt/kernel/nativeinterface/TeamUpApplicationMaterial;Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;ZZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String memberName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long memberUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long joinTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int joinGroupStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TeamUpApplicationMaterial material;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TeamUpTeamDetail detailData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isEndData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSelect;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectCreatePage;

    public c(int i3, @NotNull String memberName, long j3, long j16, int i16, @NotNull TeamUpApplicationMaterial material, @NotNull TeamUpTeamDetail detailData, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(memberName, "memberName");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(detailData, "detailData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), memberName, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), material, detailData, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.type = i3;
        this.memberName = memberName;
        this.memberUin = j3;
        this.joinTime = j16;
        this.joinGroupStatus = i16;
        this.material = material;
        this.detailData = detailData;
        this.isEndData = z16;
        this.isSelect = z17;
        this.isSelectCreatePage = z18;
    }

    private final boolean h() {
        if (this.detailData.newGroupId > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.teamup.member.data.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.type;
    }

    @NotNull
    public final TeamUpTeamDetail b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TeamUpTeamDetail) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.detailData;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.joinTime;
    }

    @NotNull
    public final TeamUpApplicationMaterial d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TeamUpApplicationMaterial) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.material;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.memberName;
    }

    @Override // com.tencent.mobileqq.troop.teamup.member.data.b
    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (a() == cVar.a() && Intrinsics.areEqual(this.memberName, cVar.memberName) && this.memberUin == cVar.memberUin && this.joinTime == cVar.joinTime && this.joinGroupStatus == cVar.joinGroupStatus && Intrinsics.areEqual(this.material, cVar.material) && Intrinsics.areEqual(this.detailData, cVar.detailData) && this.isEndData == cVar.isEndData && this.isSelect == cVar.isSelect && this.isSelectCreatePage == cVar.isSelectCreatePage) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.memberUin;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.detailData.joinType == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        int a16 = ((((((((((((a() * 31) + this.memberName.hashCode()) * 31) + androidx.fragment.app.a.a(this.memberUin)) * 31) + androidx.fragment.app.a.a(this.joinTime)) * 31) + this.joinGroupStatus) * 31) + this.material.hashCode()) * 31) + this.detailData.hashCode()) * 31;
        boolean z16 = this.isEndData;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (a16 + i16) * 31;
        boolean z17 = this.isSelect;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.isSelectCreatePage;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i19 + i3;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isEndData;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.joinGroupStatus == 1 || !h()) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (this.joinGroupStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (this.detailData.joinType == 2) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isSelect;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.isSelectCreatePage;
    }

    public final void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.isSelect = z16;
        }
    }

    public final void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isSelectCreatePage = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return "TroopTeamUpMemberItemData(type=" + a() + ", memberName=" + this.memberName + ", memberUin=" + this.memberUin + ", joinTime=" + this.joinTime + ", joinGroupStatus=" + this.joinGroupStatus + ", material=" + this.material + ", detailData=" + this.detailData + ", isEndData=" + this.isEndData + ", isSelect=" + this.isSelect + ", isSelectCreatePage=" + this.isSelectCreatePage + ")";
    }
}
