package com.tencent.videocut.picker;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u00a2\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013R\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013R\u0017\u0010/\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010\u0013R\u0017\u00102\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u0017\u00107\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/videocut/picker/PickersConfig;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "getSelectType", "()I", "selectType", "", "e", "J", "getMaxDuration", "()J", "maxDuration", "f", "getMinDuration", "minDuration", h.F, "getMaxVideoNum", "maxVideoNum", "i", "getMaxImageNum", "maxImageNum", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMinVideoNum", "minVideoNum", BdhLogUtil.LogTag.Tag_Conn, "getMinImageNum", "minImageNum", "D", "getMinTotalNum", "minTotalNum", "E", "getMaxTotalNum", "maxTotalNum", UserInfo.SEX_FEMALE, "getSelectNumLimit", "selectNumLimit", "G", "Ljava/lang/String;", "getShootingTips", "()Ljava/lang/String;", "shootingTips", "<init>", "(IJJIIIIIIILjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final /* data */ class PickersConfig implements Parcelable {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final Parcelable.Creator<PickersConfig> CREATOR;

    /* renamed from: C, reason: from kotlin metadata */
    private final int minImageNum;

    /* renamed from: D, reason: from kotlin metadata */
    private final int minTotalNum;

    /* renamed from: E, reason: from kotlin metadata */
    private final int maxTotalNum;

    /* renamed from: F, reason: from kotlin metadata */
    private final int selectNumLimit;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String shootingTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int selectType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long maxDuration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long minDuration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int maxVideoNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int maxImageNum;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int minVideoNum;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class a implements Parcelable.Creator<PickersConfig> {
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
        public final PickersConfig createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PickersConfig) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PickersConfig(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PickersConfig[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PickersConfig[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new PickersConfig[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            CREATOR = new a();
        }
    }

    public PickersConfig() {
        this(0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, null, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            return;
        }
        iPatchRedirector.redirect((short) 31, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickersConfig)) {
            return false;
        }
        PickersConfig pickersConfig = (PickersConfig) other;
        if (this.selectType == pickersConfig.selectType && this.maxDuration == pickersConfig.maxDuration && this.minDuration == pickersConfig.minDuration && this.maxVideoNum == pickersConfig.maxVideoNum && this.maxImageNum == pickersConfig.maxImageNum && this.minVideoNum == pickersConfig.minVideoNum && this.minImageNum == pickersConfig.minImageNum && this.minTotalNum == pickersConfig.minTotalNum && this.maxTotalNum == pickersConfig.maxTotalNum && this.selectNumLimit == pickersConfig.selectNumLimit && Intrinsics.areEqual(this.shootingTips, pickersConfig.shootingTips)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return (((((((((((((((((((this.selectType * 31) + androidx.fragment.app.a.a(this.maxDuration)) * 31) + androidx.fragment.app.a.a(this.minDuration)) * 31) + this.maxVideoNum) * 31) + this.maxImageNum) * 31) + this.minVideoNum) * 31) + this.minImageNum) * 31) + this.minTotalNum) * 31) + this.maxTotalNum) * 31) + this.selectNumLimit) * 31) + this.shootingTips.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return "PickersConfig(selectType=" + this.selectType + ", maxDuration=" + this.maxDuration + ", minDuration=" + this.minDuration + ", maxVideoNum=" + this.maxVideoNum + ", maxImageNum=" + this.maxImageNum + ", minVideoNum=" + this.minVideoNum + ", minImageNum=" + this.minImageNum + ", minTotalNum=" + this.minTotalNum + ", maxTotalNum=" + this.maxTotalNum + ", selectNumLimit=" + this.selectNumLimit + ", shootingTips=" + this.shootingTips + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.selectType);
        parcel.writeLong(this.maxDuration);
        parcel.writeLong(this.minDuration);
        parcel.writeInt(this.maxVideoNum);
        parcel.writeInt(this.maxImageNum);
        parcel.writeInt(this.minVideoNum);
        parcel.writeInt(this.minImageNum);
        parcel.writeInt(this.minTotalNum);
        parcel.writeInt(this.maxTotalNum);
        parcel.writeInt(this.selectNumLimit);
        parcel.writeString(this.shootingTips);
    }

    public PickersConfig(int i3, long j3, long j16, int i16, int i17, int i18, int i19, int i26, int i27, int i28, @NotNull String shootingTips) {
        Intrinsics.checkNotNullParameter(shootingTips, "shootingTips");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), shootingTips);
            return;
        }
        this.selectType = i3;
        this.maxDuration = j3;
        this.minDuration = j16;
        this.maxVideoNum = i16;
        this.maxImageNum = i17;
        this.minVideoNum = i18;
        this.minImageNum = i19;
        this.minTotalNum = i26;
        this.maxTotalNum = i27;
        this.selectNumLimit = i28;
        this.shootingTips = shootingTips;
    }

    public /* synthetic */ PickersConfig(int i3, long j3, long j16, int i16, int i17, int i18, int i19, int i26, int i27, int i28, String str, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this((i29 & 1) != 0 ? 3 : i3, (i29 & 2) != 0 ? Long.MAX_VALUE : j3, (i29 & 4) != 0 ? 0L : j16, (i29 & 8) != 0 ? 30 : i16, (i29 & 16) != 0 ? 30 : i17, (i29 & 32) != 0 ? 1 : i18, (i29 & 64) != 0 ? 1 : i19, (i29 & 128) != 0 ? 1 : i26, (i29 & 256) != 0 ? 60 : i27, (i29 & 512) != 0 ? 1 : i28, (i29 & 1024) != 0 ? "" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), str, Integer.valueOf(i29), defaultConstructorMarker);
    }
}
