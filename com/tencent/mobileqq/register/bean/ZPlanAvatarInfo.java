package com.tencent.mobileqq.register.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0012\n\u0002\b\n\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001\u0016BU\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010)\u001a\u00020%\u00a2\u0006\u0004\b*\u0010+B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b\u0018\u0010\u001eR\u0019\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u0017\u0010)\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u0015\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "other", "", "equals", "hashCode", "", "toString", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "normalUrl", "e", "a", PhotoCategorySummaryInfo.AVATAR_URL, "f", "c", "bgUrl", h.F, "I", "b", "()I", "bgId", "i", "clipPercent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "suitId", "", BdhLogUtil.LogTag.Tag_Conn, "[B", "()[B", "callbackInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;[B)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class ZPlanAvatarInfo implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final byte[] callbackInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String normalUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String avatarUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String bgUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int bgId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int clipPercent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String suitId;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.bean.ZPlanAvatarInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<ZPlanAvatarInfo> {
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
        public ZPlanAvatarInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ZPlanAvatarInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ZPlanAvatarInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZPlanAvatarInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ZPlanAvatarInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new ZPlanAvatarInfo[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ZPlanAvatarInfo() {
        this(null, null, null, 0, 0, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            return;
        }
        iPatchRedirector.redirect((short) 24, (Object) this);
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.avatarUrl;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.bgId;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bgUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final byte[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.callbackInfo;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(ZPlanAvatarInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.register.bean.ZPlanAvatarInfo");
        ZPlanAvatarInfo zPlanAvatarInfo = (ZPlanAvatarInfo) other;
        if (Intrinsics.areEqual(this.normalUrl, zPlanAvatarInfo.normalUrl) && Intrinsics.areEqual(this.avatarUrl, zPlanAvatarInfo.avatarUrl) && Intrinsics.areEqual(this.bgUrl, zPlanAvatarInfo.bgUrl) && this.bgId == zPlanAvatarInfo.bgId && this.clipPercent == zPlanAvatarInfo.clipPercent && Intrinsics.areEqual(this.suitId, zPlanAvatarInfo.suitId) && Arrays.equals(this.callbackInfo, zPlanAvatarInfo.callbackInfo)) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.clipPercent;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.normalUrl;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        String str = this.normalUrl;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.avatarUrl;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.bgUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (((((i26 + i17) * 31) + this.bgId) * 31) + this.clipPercent) * 31;
        String str4 = this.suitId;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return ((i27 + i18) * 31) + Arrays.hashCode(this.callbackInfo);
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.suitId;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "normalUrl:" + this.normalUrl + ", avatarUrl:" + this.avatarUrl + ", bgUrl:" + this.bgUrl + ", clipPercent" + this.clipPercent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) dest, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.normalUrl);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.bgUrl);
        dest.writeInt(this.bgId);
        dest.writeInt(this.clipPercent);
        dest.writeString(this.suitId);
        dest.writeInt(this.callbackInfo.length);
        dest.writeByteArray(this.callbackInfo);
    }

    public ZPlanAvatarInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, int i16, @Nullable String str4, @NotNull byte[] callbackInfo) {
        Intrinsics.checkNotNullParameter(callbackInfo, "callbackInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), str4, callbackInfo);
            return;
        }
        this.normalUrl = str;
        this.avatarUrl = str2;
        this.bgUrl = str3;
        this.bgId = i3;
        this.clipPercent = i16;
        this.suitId = str4;
        this.callbackInfo = callbackInfo;
    }

    public /* synthetic */ ZPlanAvatarInfo(String str, String str2, String str3, int i3, int i16, String str4, byte[] bArr, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? 25 : i16, (i17 & 32) != 0 ? "" : str4, (i17 & 64) != 0 ? new byte[0] : bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), str4, bArr, Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ZPlanAvatarInfo(@NotNull Parcel parcel) {
        this(r2, r3, r4, r5, r6, r7, r8);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString4 = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        Unit unit = Unit.INSTANCE;
    }
}
