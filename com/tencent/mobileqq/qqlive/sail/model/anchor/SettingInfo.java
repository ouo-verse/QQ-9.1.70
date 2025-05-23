package com.tencent.mobileqq.qqlive.sail.model.anchor;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.common.LocationInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b$\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001\u0019Bw\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016Jy\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u001a\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b#\u00100R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b1\u0010 \u001a\u0004\b1\u0010\"R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b6\u0010/\u001a\u0004\b\u0015\u00100R\u0017\u0010\u0016\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b7\u0010$\u001a\u0004\b8\u0010&R\u0017\u0010\u0017\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u00100R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b;\u0010 \u001a\u0004\b<\u0010\"\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "roomType", "", "roomName", "Lcom/tencent/mobileqq/qqlive/sail/model/common/LocationInfo;", "locationInfo", "Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;", "coverInfo", "", "enableGif", "streamRecordType", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;", "styleInfo", "isPrivateLive", "source", "isECGoodsLive", "openTabLevel", "a", "toString", "hashCode", "", "other", "equals", "d", "I", "k", "()I", "e", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "f", "Lcom/tencent/mobileqq/qqlive/sail/model/common/LocationInfo;", "()Lcom/tencent/mobileqq/qqlive/sail/model/common/LocationInfo;", h.F, "Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;", "c", "()Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;", "i", "Z", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;", "D", "E", "l", UserInfo.SEX_FEMALE, "o", "G", "g", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqlive/sail/model/common/LocationInfo;Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;ZILcom/tencent/mobileqq/qqlive/sail/model/anchor/StyleInfo;ZLjava/lang/String;ZI)V", "CREATOR", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class SettingInfo implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C */
    @NotNull
    private final StyleInfo styleInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isPrivateLive;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String source;

    /* renamed from: F */
    private final boolean isECGoodsLive;

    /* renamed from: G, reason: from kotlin metadata */
    private final int openTabLevel;

    /* renamed from: d, reason: from kotlin metadata */
    private final int roomType;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final String roomName;

    /* renamed from: f, reason: from kotlin metadata */
    @Nullable
    private final LocationInfo locationInfo;

    /* renamed from: h */
    @NotNull
    private final RoomCoverInfo coverInfo;

    /* renamed from: i, reason: from kotlin metadata */
    private final boolean enableGif;

    /* renamed from: m */
    private final int streamRecordType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "c", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<SettingInfo> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a */
        public SettingInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SettingInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b */
        public SettingInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SettingInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new SettingInfo[size];
        }

        @NotNull
        public final SettingInfo c(@NotNull Parcel parcel) {
            String str;
            RoomCoverInfo roomCoverInfo;
            boolean z16;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (SettingInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            if (readString == null) {
                str = "";
            } else {
                str = readString;
            }
            LocationInfo locationInfo = (LocationInfo) parcel.readTypedObject(LocationInfo.INSTANCE);
            RoomCoverInfo roomCoverInfo2 = (RoomCoverInfo) parcel.readTypedObject(RoomCoverInfo.INSTANCE);
            if (roomCoverInfo2 == null) {
                roomCoverInfo = new RoomCoverInfo(0, null, 0L, null, 0L, null, 0L, 127, null);
            } else {
                roomCoverInfo = roomCoverInfo2;
            }
            if (parcel.readInt() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int readInt2 = parcel.readInt();
            StyleInfo styleInfo = (StyleInfo) parcel.readTypedObject(StyleInfo.INSTANCE);
            if (styleInfo == null) {
                styleInfo = new StyleInfo(0, null, null, 0, 15, null);
            }
            if (parcel.readInt() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            String readString2 = parcel.readString();
            if (readString2 == null) {
                readString2 = "";
            }
            if (parcel.readInt() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            return new SettingInfo(readInt, str, locationInfo, roomCoverInfo, z16, readInt2, styleInfo, z17, readString2, z18, parcel.readInt());
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SettingInfo() {
        this(0, null, null, null, false, 0, null, false, null, false, 0, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            return;
        }
        iPatchRedirector.redirect((short) 31, (Object) this);
    }

    public static /* synthetic */ SettingInfo b(SettingInfo settingInfo, int i3, String str, LocationInfo locationInfo, RoomCoverInfo roomCoverInfo, boolean z16, int i16, StyleInfo styleInfo, boolean z17, String str2, boolean z18, int i17, int i18, Object obj) {
        return settingInfo.a((i18 & 1) != 0 ? settingInfo.roomType : i3, (i18 & 2) != 0 ? settingInfo.roomName : str, (i18 & 4) != 0 ? settingInfo.locationInfo : locationInfo, (i18 & 8) != 0 ? settingInfo.coverInfo : roomCoverInfo, (i18 & 16) != 0 ? settingInfo.enableGif : z16, (i18 & 32) != 0 ? settingInfo.streamRecordType : i16, (i18 & 64) != 0 ? settingInfo.styleInfo : styleInfo, (i18 & 128) != 0 ? settingInfo.isPrivateLive : z17, (i18 & 256) != 0 ? settingInfo.source : str2, (i18 & 512) != 0 ? settingInfo.isECGoodsLive : z18, (i18 & 1024) != 0 ? settingInfo.openTabLevel : i17);
    }

    @NotNull
    public final SettingInfo a(int roomType, @NotNull String roomName, @Nullable LocationInfo locationInfo, @NotNull RoomCoverInfo coverInfo, boolean enableGif, int streamRecordType, @NotNull StyleInfo styleInfo, boolean isPrivateLive, @NotNull String source, boolean isECGoodsLive, int openTabLevel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (SettingInfo) iPatchRedirector.redirect((short) 27, this, Integer.valueOf(roomType), roomName, locationInfo, coverInfo, Boolean.valueOf(enableGif), Integer.valueOf(streamRecordType), styleInfo, Boolean.valueOf(isPrivateLive), source, Boolean.valueOf(isECGoodsLive), Integer.valueOf(openTabLevel));
        }
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(coverInfo, "coverInfo");
        Intrinsics.checkNotNullParameter(styleInfo, "styleInfo");
        Intrinsics.checkNotNullParameter(source, "source");
        return new SettingInfo(roomType, roomName, locationInfo, coverInfo, enableGif, streamRecordType, styleInfo, isPrivateLive, source, isECGoodsLive, openTabLevel);
    }

    @NotNull
    public final RoomCoverInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RoomCoverInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.coverInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.enableGif;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingInfo)) {
            return false;
        }
        SettingInfo settingInfo = (SettingInfo) other;
        if (this.roomType == settingInfo.roomType && Intrinsics.areEqual(this.roomName, settingInfo.roomName) && Intrinsics.areEqual(this.locationInfo, settingInfo.locationInfo) && Intrinsics.areEqual(this.coverInfo, settingInfo.coverInfo) && this.enableGif == settingInfo.enableGif && this.streamRecordType == settingInfo.streamRecordType && Intrinsics.areEqual(this.styleInfo, settingInfo.styleInfo) && this.isPrivateLive == settingInfo.isPrivateLive && Intrinsics.areEqual(this.source, settingInfo.source) && this.isECGoodsLive == settingInfo.isECGoodsLive && this.openTabLevel == settingInfo.openTabLevel) {
            return true;
        }
        return false;
    }

    @Nullable
    public final LocationInfo f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LocationInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.locationInfo;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.openTabLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        int hashCode2 = ((this.roomType * 31) + this.roomName.hashCode()) * 31;
        LocationInfo locationInfo = this.locationInfo;
        if (locationInfo == null) {
            hashCode = 0;
        } else {
            hashCode = locationInfo.hashCode();
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.coverInfo.hashCode()) * 31;
        boolean z16 = this.enableGif;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode4 = (((((hashCode3 + i16) * 31) + this.streamRecordType) * 31) + this.styleInfo.hashCode()) * 31;
        boolean z17 = this.isPrivateLive;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int hashCode5 = (((hashCode4 + i17) * 31) + this.source.hashCode()) * 31;
        boolean z18 = this.isECGoodsLive;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return ((hashCode5 + i3) * 31) + this.openTabLevel;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.roomName;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.roomType;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.source;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.streamRecordType;
    }

    @NotNull
    public final StyleInfo n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (StyleInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.styleInfo;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isECGoodsLive;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "SettingInfo(roomType=" + this.roomType + ", roomName=" + this.roomName + ", locationInfo=" + this.locationInfo + ", coverInfo=" + this.coverInfo + ", enableGif=" + this.enableGif + ", streamRecordType=" + this.streamRecordType + ", styleInfo=" + this.styleInfo + ", isPrivateLive=" + this.isPrivateLive + ", source=" + this.source + ", isECGoodsLive=" + this.isECGoodsLive + ", openTabLevel=" + this.openTabLevel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel, r56);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.roomType);
        parcel.writeString(this.roomName);
        parcel.writeTypedObject(this.locationInfo, r56);
        parcel.writeTypedObject(this.coverInfo, r56);
        parcel.writeInt(this.enableGif ? 1 : 0);
        parcel.writeInt(this.streamRecordType);
        parcel.writeTypedObject(this.styleInfo, r56);
        parcel.writeInt(this.isPrivateLive ? 1 : 0);
        parcel.writeString(this.source);
        parcel.writeInt(this.isECGoodsLive ? 1 : 0);
        parcel.writeInt(this.openTabLevel);
    }

    public SettingInfo(int i3, @NotNull String roomName, @Nullable LocationInfo locationInfo, @NotNull RoomCoverInfo coverInfo, boolean z16, int i16, @NotNull StyleInfo styleInfo, boolean z17, @NotNull String source, boolean z18, int i17) {
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(coverInfo, "coverInfo");
        Intrinsics.checkNotNullParameter(styleInfo, "styleInfo");
        Intrinsics.checkNotNullParameter(source, "source");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), roomName, locationInfo, coverInfo, Boolean.valueOf(z16), Integer.valueOf(i16), styleInfo, Boolean.valueOf(z17), source, Boolean.valueOf(z18), Integer.valueOf(i17));
            return;
        }
        this.roomType = i3;
        this.roomName = roomName;
        this.locationInfo = locationInfo;
        this.coverInfo = coverInfo;
        this.enableGif = z16;
        this.streamRecordType = i16;
        this.styleInfo = styleInfo;
        this.isPrivateLive = z17;
        this.source = source;
        this.isECGoodsLive = z18;
        this.openTabLevel = i17;
    }

    public /* synthetic */ SettingInfo(int i3, String str, LocationInfo locationInfo, RoomCoverInfo roomCoverInfo, boolean z16, int i16, StyleInfo styleInfo, boolean z17, String str2, boolean z18, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? null : locationInfo, (i18 & 8) != 0 ? new RoomCoverInfo(0, null, 0L, null, 0L, null, 0L, 127, null) : roomCoverInfo, (i18 & 16) != 0 ? false : z16, (i18 & 32) != 0 ? 0 : i16, (i18 & 64) != 0 ? new StyleInfo(0, null, null, 0, 15, null) : styleInfo, (i18 & 128) != 0 ? false : z17, (i18 & 256) != 0 ? "" : str2, (i18 & 512) != 0 ? false : z18, (i18 & 1024) != 0 ? 0 : i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, locationInfo, roomCoverInfo, Boolean.valueOf(z16), Integer.valueOf(i16), styleInfo, Boolean.valueOf(z17), str2, Boolean.valueOf(z18), Integer.valueOf(i17), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
