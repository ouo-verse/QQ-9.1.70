package com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u0015B7\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\u000f\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0017R\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0017R\"\u0010#\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\"\u0010\u0017\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/TroopGameInfoData;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "troopUin", "", "e", "Z", "()Z", "isHomeworkTroop", "f", "a", "k", "(Z)V", "showTeammatePlayTogetherStatus", h.F, "c", "setGangUpTroop", "isGangUpTroop", "i", "g", "setTroopGameCardEnabled", "isTroopGameCardEnabled", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "isMyGameCardEnabled", "<init>", "(Ljava/lang/String;ZZZZZ)V", BdhLogUtil.LogTag.Tag_Conn, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopGameInfoData implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final Parcelable.Creator<TroopGameInfoData> CREATOR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isHomeworkTroop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showTeammatePlayTogetherStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isGangUpTroop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isTroopGameCardEnabled;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isMyGameCardEnabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/TroopGameInfoData$a;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "info", "Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/TroopGameInfoData;", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model.TroopGameInfoData$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final TroopGameInfoData a(@NotNull TroopInfo info) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopGameInfoData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            String str = info.troopuin;
            Intrinsics.checkNotNullExpressionValue(str, "info.troopuin");
            boolean isHomeworkTroop = info.isHomeworkTroop();
            boolean shouldShowPlayTogetherStatus = info.shouldShowPlayTogetherStatus();
            if (info.groupExt.gangUpId > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new TroopGameInfoData(str, isHomeworkTroop, shouldShowPlayTogetherStatus, z16, info.isTroopGameCardEnabledV2(), info.isShowMyGameCardEnabledV2());
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b implements Parcelable.Creator<TroopGameInfoData> {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TroopGameInfoData createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopGameInfoData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
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
            if (parcel.readInt() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (parcel.readInt() != 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            return new TroopGameInfoData(readString, z16, z17, z18, z19, z26);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TroopGameInfoData[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopGameInfoData[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new TroopGameInfoData[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
            CREATOR = new b();
        }
    }

    public TroopGameInfoData(@NotNull String troopUin, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26));
            return;
        }
        this.troopUin = troopUin;
        this.isHomeworkTroop = z16;
        this.showTeammatePlayTogetherStatus = z17;
        this.isGangUpTroop = z18;
        this.isTroopGameCardEnabled = z19;
        this.isMyGameCardEnabled = z26;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.showTeammatePlayTogetherStatus;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isGangUpTroop;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isHomeworkTroop;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isMyGameCardEnabled;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isTroopGameCardEnabled;
    }

    public final void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isMyGameCardEnabled = z16;
        }
    }

    public final void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.showTeammatePlayTogetherStatus = z16;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.troopUin);
        parcel.writeInt(this.isHomeworkTroop ? 1 : 0);
        parcel.writeInt(this.showTeammatePlayTogetherStatus ? 1 : 0);
        parcel.writeInt(this.isGangUpTroop ? 1 : 0);
        parcel.writeInt(this.isTroopGameCardEnabled ? 1 : 0);
        parcel.writeInt(this.isMyGameCardEnabled ? 1 : 0);
    }
}
