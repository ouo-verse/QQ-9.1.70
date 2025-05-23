package com.tencent.mobileqq.troop.troopselector;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001)BU\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010 \u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u001f\u0010'\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "toString", "hashCode", "", "other", "", "equals", "d", "Z", "e", "()Z", "isMultiMode", "I", "b", "()I", "maxNum", "f", "isShowCreateTroops", tl.h.F, "j", "isShowManageTroops", "i", "g", "isShowJoinedTroops", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "originSelectedList", BdhLogUtil.LogTag.Tag_Conn, "a", "actionType", "<init>", "(ZIZZZLjava/util/ArrayList;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopSelectorConfig implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int actionType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isMultiMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int maxNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowCreateTroops;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowManageTroops;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowJoinedTroops;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<ResultRecord> originSelectedList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion implements Parcelable.Creator<TroopSelectorConfig> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopSelectorConfig createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopSelectorConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopSelectorConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopSelectorConfig[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopSelectorConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new TroopSelectorConfig[size];
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectorConfig() {
        this(false, 0, false, false, false, null, 0, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            return;
        }
        iPatchRedirector.redirect((short) 24, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.actionType;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.maxNum;
    }

    @Nullable
    public final ArrayList<ResultRecord> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.originSelectedList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isMultiMode;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopSelectorConfig)) {
            return false;
        }
        TroopSelectorConfig troopSelectorConfig = (TroopSelectorConfig) other;
        if (this.isMultiMode == troopSelectorConfig.isMultiMode && this.maxNum == troopSelectorConfig.maxNum && this.isShowCreateTroops == troopSelectorConfig.isShowCreateTroops && this.isShowManageTroops == troopSelectorConfig.isShowManageTroops && this.isShowJoinedTroops == troopSelectorConfig.isShowJoinedTroops && Intrinsics.areEqual(this.originSelectedList, troopSelectorConfig.originSelectedList) && this.actionType == troopSelectorConfig.actionType) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isShowCreateTroops;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isShowJoinedTroops;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        boolean z16 = this.isMultiMode;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = ((r06 * 31) + this.maxNum) * 31;
        ?? r26 = this.isShowCreateTroops;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.isShowManageTroops;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z17 = this.isShowJoinedTroops;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i27 = (i26 + i3) * 31;
        ArrayList<ResultRecord> arrayList = this.originSelectedList;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        return ((i27 + hashCode) * 31) + this.actionType;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isShowManageTroops;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "TroopSelectorConfig(isMultiMode=" + this.isMultiMode + ", maxNum=" + this.maxNum + "isShowCreateTroops=" + this.isShowCreateTroops + ", isShowManageTroops=" + this.isShowManageTroops + ", isShowJoinedTroops=" + this.isShowJoinedTroops + ", originSelectedList=" + this.originSelectedList + ", actionType=" + this.actionType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isMultiMode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.maxNum);
        parcel.writeByte(this.isShowCreateTroops ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isShowManageTroops ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isShowJoinedTroops ? (byte) 1 : (byte) 0);
        parcel.writeList(this.originSelectedList);
        parcel.writeInt(this.actionType);
    }

    public TroopSelectorConfig(boolean z16, int i3, boolean z17, boolean z18, boolean z19, @Nullable ArrayList<ResultRecord> arrayList, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), arrayList, Integer.valueOf(i16));
            return;
        }
        this.isMultiMode = z16;
        this.maxNum = i3;
        this.isShowCreateTroops = z17;
        this.isShowManageTroops = z18;
        this.isShowJoinedTroops = z19;
        this.originSelectedList = arrayList;
        this.actionType = i16;
    }

    public /* synthetic */ TroopSelectorConfig(boolean z16, int i3, boolean z17, boolean z18, boolean z19, ArrayList arrayList, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? true : z17, (i17 & 8) != 0 ? false : z18, (i17 & 16) != 0 ? false : z19, (i17 & 32) != 0 ? new ArrayList() : arrayList, (i17 & 64) != 0 ? -1 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), arrayList, Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TroopSelectorConfig(@NotNull Parcel parcel) {
        this(parcel.readByte() != 0, parcel.readInt(), parcel.readByte() != 0, parcel.readByte() != 0, parcel.readByte() != 0, parcel.readArrayList(ResultRecord.class.getClassLoader()), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcel);
    }
}
