package com.tencent.mobileqq.nearbypro.api.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.a;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import da2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp4.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0086\b\u0018\u0000 J2\u00020\u0001:\u0001(B\u008d\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010<\u001a\u00020\t\u0012\b\b\u0002\u0010>\u001a\u00020\t\u0012\b\b\u0002\u0010@\u001a\u00020\t\u0012\b\b\u0002\u0010B\u001a\u00020\t\u0012\b\b\u0002\u0010D\u001a\u00020\t\u0012\b\b\u0002\u0010F\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u00a2\u0006\u0004\bG\u0010HB\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\bG\u0010IJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015J\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\tJ\u0006\u0010%\u001a\u00020\tJ\u0006\u0010&\u001a\u00020\tJ\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\tJ\u0018\u0010,\u001a\u00020\u00172\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016J\t\u0010.\u001a\u00020\tH\u00d6\u0001J\t\u0010/\u001a\u00020\u0010H\u00d6\u0001J\u0013\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u00d6\u0003R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00105R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00106R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010:R\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00105R\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00105R\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00105R\u0016\u0010F\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00105R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00105\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "Landroid/os/Parcelable;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "latLng", "", "u", "", "tid", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", PhotoCategorySummaryInfo.AVATAR_URL, "r", "address", "v", "name", "w", "", "gender", "t", "nickName", HippyTKDListViewAdapter.X, "Lrp4/g;", "statusInfo", "", "y", "avatarDressBorderUrl", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "b", DomainData.DOMAIN_NAME, "o", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "k", "g", "l", "f", "j", "a", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "toString", "hashCode", "", "other", "equals", "d", "J", "Ljava/lang/String;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", h.F, "I", "i", "Lrp4/g;", BdhLogUtil.LogTag.Tag_Conn, "locationAddress", "D", "locationName", "E", "locationCountry", UserInfo.SEX_FEMALE, "locationProvince", "G", "locationCity", "H", "locationDistrict", "<init>", "(JLjava/lang/String;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;ILjava/lang/String;Lrp4/g;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class SelfUserInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String locationAddress;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private String locationName;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private String locationCountry;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private String locationProvince;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private String locationCity;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private String locationDistrict;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private String avatarDressBorderUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long tid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String avatarUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private LatLng latLng;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int gender;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String nickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private g statusInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "<init>", "()V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion implements Parcelable.Creator<SelfUserInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SelfUserInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SelfUserInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SelfUserInfo[] newArray(int size) {
            return new SelfUserInfo[size];
        }

        Companion() {
        }
    }

    public SelfUserInfo() {
        this(0L, null, null, 0, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarDressBorderUrl() {
        return this.avatarDressBorderUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: c, reason: from getter */
    public final int getGender() {
        return this.gender;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getLocationAddress() {
        return this.locationAddress;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelfUserInfo)) {
            return false;
        }
        SelfUserInfo selfUserInfo = (SelfUserInfo) other;
        if (this.tid == selfUserInfo.tid && Intrinsics.areEqual(this.avatarUrl, selfUserInfo.avatarUrl) && Intrinsics.areEqual(this.latLng, selfUserInfo.latLng) && this.gender == selfUserInfo.gender && Intrinsics.areEqual(this.nickName, selfUserInfo.nickName) && Intrinsics.areEqual(this.statusInfo, selfUserInfo.statusInfo) && Intrinsics.areEqual(this.locationAddress, selfUserInfo.locationAddress) && Intrinsics.areEqual(this.locationName, selfUserInfo.locationName) && Intrinsics.areEqual(this.locationCountry, selfUserInfo.locationCountry) && Intrinsics.areEqual(this.locationProvince, selfUserInfo.locationProvince) && Intrinsics.areEqual(this.locationCity, selfUserInfo.locationCity) && Intrinsics.areEqual(this.locationDistrict, selfUserInfo.locationDistrict) && Intrinsics.areEqual(this.avatarDressBorderUrl, selfUserInfo.avatarDressBorderUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getLocationCity() {
        return this.locationCity;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getLocationCountry() {
        return this.locationCountry;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((a.a(this.tid) * 31) + this.avatarUrl.hashCode()) * 31;
        LatLng latLng = this.latLng;
        int i3 = 0;
        if (latLng == null) {
            hashCode = 0;
        } else {
            hashCode = latLng.hashCode();
        }
        int hashCode2 = (((((a16 + hashCode) * 31) + this.gender) * 31) + this.nickName.hashCode()) * 31;
        g gVar = this.statusInfo;
        if (gVar != null) {
            i3 = gVar.hashCode();
        }
        return ((((((((((((((hashCode2 + i3) * 31) + this.locationAddress.hashCode()) * 31) + this.locationName.hashCode()) * 31) + this.locationCountry.hashCode()) * 31) + this.locationProvince.hashCode()) * 31) + this.locationCity.hashCode()) * 31) + this.locationDistrict.hashCode()) * 31) + this.avatarDressBorderUrl.hashCode();
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getLocationDistrict() {
        return this.locationDistrict;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getLocationName() {
        return this.locationName;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getLocationProvince() {
        return this.locationProvince;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final LatLng getLatLng() {
        return this.latLng;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final g getStatusInfo() {
        return this.statusInfo;
    }

    @NotNull
    public final String p() {
        return String.valueOf(this.tid);
    }

    /* renamed from: q, reason: from getter */
    public final long getTid() {
        return this.tid;
    }

    public final boolean r(@NotNull String avatarUrl) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        if (!Intrinsics.areEqual(this.avatarUrl, avatarUrl) && !TextUtils.isEmpty(avatarUrl)) {
            this.avatarUrl = avatarUrl;
            return true;
        }
        return false;
    }

    public final boolean s(@NotNull String avatarDressBorderUrl) {
        Intrinsics.checkNotNullParameter(avatarDressBorderUrl, "avatarDressBorderUrl");
        if (!Intrinsics.areEqual(this.avatarDressBorderUrl, avatarDressBorderUrl)) {
            this.avatarDressBorderUrl = avatarDressBorderUrl;
            return true;
        }
        return false;
    }

    public final boolean t(int gender) {
        if (this.gender != gender) {
            this.gender = gender;
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "SelfUserInfo(tid=" + this.tid + ", avatarUrl=" + this.avatarUrl + ", latLng=" + this.latLng + ", gender=" + this.gender + ", nickName=" + this.nickName + ", statusInfo=" + this.statusInfo + ", locationAddress=" + this.locationAddress + ", locationName=" + this.locationName + ", locationCountry=" + this.locationCountry + ", locationProvince=" + this.locationProvince + ", locationCity=" + this.locationCity + ", locationDistrict=" + this.locationDistrict + ", avatarDressBorderUrl=" + this.avatarDressBorderUrl + ")";
    }

    public final boolean u(@NotNull LatLng latLng) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        LatLng latLng2 = this.latLng;
        if (latLng2 == null) {
            this.latLng = latLng;
            return true;
        }
        Intrinsics.checkNotNull(latLng2);
        double d16 = latLng2.latitude;
        double d17 = latLng.latitude;
        if (d16 == d17) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (latLng2.longitude == latLng.longitude) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return false;
            }
        }
        latLng2.latitude = d17;
        latLng2.longitude = latLng.longitude;
        return true;
    }

    public final boolean v(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (!Intrinsics.areEqual(this.locationAddress, address) && !TextUtils.isEmpty(address)) {
            this.locationAddress = address;
            return true;
        }
        return false;
    }

    public final boolean w(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!Intrinsics.areEqual(this.locationName, name) && !TextUtils.isEmpty(name)) {
            this.locationName = name;
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.tid);
        parcel.writeString(this.avatarUrl);
        parcel.writeParcelable(this.latLng, flags);
        parcel.writeInt(this.gender);
        parcel.writeString(this.nickName);
        parcel.writeString(this.locationAddress);
        parcel.writeString(this.locationName);
        parcel.writeString(this.locationCountry);
        parcel.writeString(this.locationProvince);
        parcel.writeString(this.locationCity);
        parcel.writeString(this.locationDistrict);
        parcel.writeString(this.avatarDressBorderUrl);
    }

    public final boolean x(@NotNull String nickName) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        if (!Intrinsics.areEqual(this.nickName, nickName)) {
            this.nickName = nickName;
            return true;
        }
        return false;
    }

    public final void y(@NotNull g statusInfo) {
        Intrinsics.checkNotNullParameter(statusInfo, "statusInfo");
        this.statusInfo = statusInfo;
    }

    public final boolean z(long tid) {
        if (this.tid != tid && tid != 0) {
            this.tid = tid;
            return true;
        }
        return false;
    }

    public SelfUserInfo(long j3, @NotNull String avatarUrl, @Nullable LatLng latLng, int i3, @NotNull String nickName, @Nullable g gVar, @NotNull String locationAddress, @NotNull String locationName, @NotNull String locationCountry, @NotNull String locationProvince, @NotNull String locationCity, @NotNull String locationDistrict, @NotNull String avatarDressBorderUrl) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(locationAddress, "locationAddress");
        Intrinsics.checkNotNullParameter(locationName, "locationName");
        Intrinsics.checkNotNullParameter(locationCountry, "locationCountry");
        Intrinsics.checkNotNullParameter(locationProvince, "locationProvince");
        Intrinsics.checkNotNullParameter(locationCity, "locationCity");
        Intrinsics.checkNotNullParameter(locationDistrict, "locationDistrict");
        Intrinsics.checkNotNullParameter(avatarDressBorderUrl, "avatarDressBorderUrl");
        this.tid = j3;
        this.avatarUrl = avatarUrl;
        this.latLng = latLng;
        this.gender = i3;
        this.nickName = nickName;
        this.statusInfo = gVar;
        this.locationAddress = locationAddress;
        this.locationName = locationName;
        this.locationCountry = locationCountry;
        this.locationProvince = locationProvince;
        this.locationCity = locationCity;
        this.locationDistrict = locationDistrict;
        this.avatarDressBorderUrl = avatarDressBorderUrl;
    }

    public /* synthetic */ SelfUserInfo(long j3, String str, LatLng latLng, int i3, String str2, g gVar, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? c.a() : latLng, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? "" : str2, (i16 & 32) != 0 ? null : gVar, (i16 & 64) != 0 ? "" : str3, (i16 & 128) != 0 ? "" : str4, (i16 & 256) != 0 ? "" : str5, (i16 & 512) != 0 ? "" : str6, (i16 & 1024) != 0 ? "" : str7, (i16 & 2048) != 0 ? "" : str8, (i16 & 4096) == 0 ? str9 : "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SelfUserInfo(@NotNull Parcel parcel) {
        this(r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r0 == null ? "" : r0, 32, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        long readLong = parcel.readLong();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        LatLng latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        LatLng a16 = latLng == null ? c.a() : latLng;
        int readInt = parcel.readInt();
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        g gVar = null;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        String str7 = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        String str8 = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
    }
}
