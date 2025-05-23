package com.tencent.mobileqq.qqlive.sail.model.audience;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.anchor.StyleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001#BE\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R\u0019\u0010)\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u001a\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "roomName", "e", "I", "()I", "roomType", "", "f", "J", "getRoomOwnerId", "()J", "roomOwnerId", h.F, "b", "cover", "i", "a", "anchorType", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;", "()Lcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;", "styleInfo", "<init>", "(Ljava/lang/String;IJLjava/lang/String;ILcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;)V", "CREATOR", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class SettingInfo implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String roomName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int roomType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long roomOwnerId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String cover;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int anchorType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final StyleInfo styleInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;", "Landroid/os/Parcel;", "source", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.audience.SettingInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<SettingInfo> {
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
        public SettingInfo createFromParcel(@NotNull Parcel source) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SettingInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
            }
            Intrinsics.checkNotNullParameter(source, "source");
            String readString = source.readString();
            if (readString == null) {
                str = "";
            } else {
                str = readString;
            }
            int readInt = source.readInt();
            long readLong = source.readLong();
            String readString2 = source.readString();
            if (readString2 == null) {
                str2 = "";
            } else {
                str2 = readString2;
            }
            return new SettingInfo(str, readInt, readLong, str2, source.readInt(), (StyleInfo) source.readTypedObject(StyleInfo.INSTANCE));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SettingInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SettingInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new SettingInfo[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30830);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SettingInfo() {
        this(null, 0, 0L, null, 0, null, 63, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.anchorType;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.cover;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.roomName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.roomType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingInfo)) {
            return false;
        }
        SettingInfo settingInfo = (SettingInfo) other;
        if (Intrinsics.areEqual(this.roomName, settingInfo.roomName) && this.roomType == settingInfo.roomType && this.roomOwnerId == settingInfo.roomOwnerId && Intrinsics.areEqual(this.cover, settingInfo.cover) && this.anchorType == settingInfo.anchorType && Intrinsics.areEqual(this.styleInfo, settingInfo.styleInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final StyleInfo f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (StyleInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.styleInfo;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        int hashCode2 = ((((((((this.roomName.hashCode() * 31) + this.roomType) * 31) + androidx.fragment.app.a.a(this.roomOwnerId)) * 31) + this.cover.hashCode()) * 31) + this.anchorType) * 31;
        StyleInfo styleInfo = this.styleInfo;
        if (styleInfo == null) {
            hashCode = 0;
        } else {
            hashCode = styleInfo.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "SettingInfo(roomName=" + this.roomName + ", roomType=" + this.roomType + ", roomOwnerId=" + this.roomOwnerId + ", cover=" + this.cover + ", anchorType=" + this.anchorType + ", styleInfo=" + this.styleInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) dest, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.roomName);
        dest.writeInt(this.roomType);
        dest.writeLong(this.roomOwnerId);
        dest.writeString(this.cover);
        dest.writeInt(this.anchorType);
        dest.writeTypedObject(this.styleInfo, flags);
    }

    public SettingInfo(@NotNull String roomName, int i3, long j3, @NotNull String cover, int i16, @Nullable StyleInfo styleInfo) {
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(cover, "cover");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, roomName, Integer.valueOf(i3), Long.valueOf(j3), cover, Integer.valueOf(i16), styleInfo);
            return;
        }
        this.roomName = roomName;
        this.roomType = i3;
        this.roomOwnerId = j3;
        this.cover = cover;
        this.anchorType = i16;
        this.styleInfo = styleInfo;
    }

    public /* synthetic */ SettingInfo(String str, int i3, long j3, String str2, int i16, StyleInfo styleInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0L : j3, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? 1 : i16, (i17 & 32) != 0 ? null : styleInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, Integer.valueOf(i16), styleInfo, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
