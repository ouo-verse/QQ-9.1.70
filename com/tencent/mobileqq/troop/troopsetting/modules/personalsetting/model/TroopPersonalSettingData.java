package com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\f\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010 \u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010$R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u0010.\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/personalsetting/model/TroopPersonalSettingData;", "Landroid/os/Parcelable;", "", "nickName", "", "nickId", "", "k", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "troopUin", "Z", "f", "()Z", "isHomeworkTroop", "j", "isQiDianPrivateTroop", h.F, "g", "isLuckyCharacterSwitchOn", "i", "b", "setMemberNickName", "(Ljava/lang/String;)V", "memberNickName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "c", "()I", "setNickId", "(I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "identityReportId", "<init>", "(Ljava/lang/String;ZZZLjava/lang/String;ILjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopPersonalSettingData implements Parcelable {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final Parcelable.Creator<TroopPersonalSettingData> CREATOR;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String identityReportId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isHomeworkTroop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isQiDianPrivateTroop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isLuckyCharacterSwitchOn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String memberNickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int nickId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a implements Parcelable.Creator<TroopPersonalSettingData> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TroopPersonalSettingData createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopPersonalSettingData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (parcel.readInt() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (parcel.readInt() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            return new TroopPersonalSettingData(readString, z16, z17, z18, parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TroopPersonalSettingData[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopPersonalSettingData[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new TroopPersonalSettingData[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            CREATOR = new a();
        }
    }

    public TroopPersonalSettingData(@NotNull String troopUin, boolean z16, boolean z17, boolean z18, @Nullable String str, int i3, @NotNull String identityReportId) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(identityReportId, "identityReportId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Integer.valueOf(i3), identityReportId);
            return;
        }
        this.troopUin = troopUin;
        this.isHomeworkTroop = z16;
        this.isQiDianPrivateTroop = z17;
        this.isLuckyCharacterSwitchOn = z18;
        this.memberNickName = str;
        this.nickId = i3;
        this.identityReportId = identityReportId;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.identityReportId;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.memberNickName;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.nickId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopPersonalSettingData)) {
            return false;
        }
        TroopPersonalSettingData troopPersonalSettingData = (TroopPersonalSettingData) other;
        if (Intrinsics.areEqual(this.troopUin, troopPersonalSettingData.troopUin) && this.isHomeworkTroop == troopPersonalSettingData.isHomeworkTroop && this.isQiDianPrivateTroop == troopPersonalSettingData.isQiDianPrivateTroop && this.isLuckyCharacterSwitchOn == troopPersonalSettingData.isLuckyCharacterSwitchOn && Intrinsics.areEqual(this.memberNickName, troopPersonalSettingData.memberNickName) && this.nickId == troopPersonalSettingData.nickId && Intrinsics.areEqual(this.identityReportId, troopPersonalSettingData.identityReportId)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isHomeworkTroop;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isLuckyCharacterSwitchOn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int hashCode2 = this.troopUin.hashCode() * 31;
        boolean z16 = this.isHomeworkTroop;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isQiDianPrivateTroop;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.isLuckyCharacterSwitchOn;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int i26 = (i19 + i3) * 31;
        String str = this.memberNickName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((i26 + hashCode) * 31) + this.nickId) * 31) + this.identityReportId.hashCode();
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isQiDianPrivateTroop;
    }

    public final void k(@Nullable String nickName, int nickId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) nickName, nickId);
        } else {
            this.memberNickName = nickName;
            this.nickId = nickId;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "TroopPersonalSettingData(troopUin=" + this.troopUin + ", isHomeworkTroop=" + this.isHomeworkTroop + ", isQiDianPrivateTroop=" + this.isQiDianPrivateTroop + ", isLuckyCharacterSwitchOn=" + this.isLuckyCharacterSwitchOn + ", memberNickName=" + this.memberNickName + ", nickId=" + this.nickId + ", identityReportId=" + this.identityReportId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.troopUin);
        parcel.writeInt(this.isHomeworkTroop ? 1 : 0);
        parcel.writeInt(this.isQiDianPrivateTroop ? 1 : 0);
        parcel.writeInt(this.isLuckyCharacterSwitchOn ? 1 : 0);
        parcel.writeString(this.memberNickName);
        parcel.writeInt(this.nickId);
        parcel.writeString(this.identityReportId);
    }
}
