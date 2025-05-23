package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 M2\u00020\u0001:\u0001MB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0099\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u001aJ\t\u00100\u001a\u00020\u0006H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\t\u00102\u001a\u00020\fH\u00c6\u0003J\t\u00103\u001a\u00020\fH\u00c6\u0003J\t\u00104\u001a\u00020\fH\u00c6\u0003J\t\u00105\u001a\u00020\fH\u00c6\u0003J\t\u00106\u001a\u00020\fH\u00c6\u0003J\t\u00107\u001a\u00020\fH\u00c6\u0003J\t\u00108\u001a\u00020\fH\u00c6\u0003J\t\u00109\u001a\u00020\u0006H\u00c6\u0003J\t\u0010:\u001a\u00020\u0006H\u00c6\u0003J\t\u0010;\u001a\u00020\u0006H\u00c6\u0003J\t\u0010<\u001a\u00020\u0006H\u00c6\u0003J\t\u0010=\u001a\u00020\u0006H\u00c6\u0003J\t\u0010>\u001a\u00020\fH\u00c6\u0003J\t\u0010?\u001a\u00020\fH\u00c6\u0003J\t\u0010@\u001a\u00020\fH\u00c6\u0003J\t\u0010A\u001a\u00020\fH\u00c6\u0003J\u00bf\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u00c6\u0001J\b\u0010C\u001a\u00020\u0006H\u0016J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u00d6\u0003J\t\u0010H\u001a\u00020\u0006H\u00d6\u0001J\t\u0010I\u001a\u00020\fH\u00d6\u0001J\u0018\u0010J\u001a\u00020K2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u0006H\u0016R\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0018\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0017\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u0012\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001c\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "districtCode", "", Element.ELEMENT_NAME_DISTANCE, "hotValue", "poiNum", "poiOrderType", "poiId", "", "poiName", "poiTypeName", "address", "gpsParams", "Lcom/tencent/mobileqq/winkpublish/model/params/GpsParams;", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "country", "province", "city", "poiDefaultName", "district", "dianPingId", "poiType", "(IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/model/params/GpsParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAddress", "()Ljava/lang/String;", "getCity", "getCountry", "getDianPingId", "getDistance", "()I", "getDistrict", "getDistrictCode", "getGpsParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/GpsParams;", "getHotValue", "getPhoneNumber", "getPoiDefaultName", "getPoiId", "getPoiName", "getPoiNum", "getPoiOrderType", "getPoiType", "getPoiTypeName", "getProvince", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class PoiParams implements Parcelable {

    @NotNull
    private static final String TAG = "PoiParams";

    @NotNull
    private final String address;

    @NotNull
    private final String city;

    @NotNull
    private final String country;

    @NotNull
    private final String dianPingId;
    private final int distance;

    @NotNull
    private final String district;
    private final int districtCode;

    @Nullable
    private final GpsParams gpsParams;
    private final int hotValue;

    @NotNull
    private final String phoneNumber;

    @NotNull
    private final String poiDefaultName;

    @NotNull
    private final String poiId;

    @NotNull
    private final String poiName;
    private final int poiNum;
    private final int poiOrderType;
    private final int poiType;

    @NotNull
    private final String poiTypeName;

    @NotNull
    private final String province;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PoiParams> CREATOR = new Parcelable.Creator<PoiParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.PoiParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PoiParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PoiParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PoiParams[] newArray(int size) {
            return new PoiParams[size];
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams;", "TAG", "", "fromPoiInfo", "poiInfo", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final PoiParams fromPoiInfo(@Nullable LbsDataV2.PoiInfo poiInfo) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            if (poiInfo == null) {
                QLog.i(PoiParams.TAG, 1, "[fromPoiInfo] invalid params");
                return null;
            }
            int i3 = poiInfo.districtCode;
            int i16 = poiInfo.distance;
            int i17 = poiInfo.poiNum;
            int i18 = poiInfo.poiOrderType;
            String str12 = poiInfo.poiId;
            if (str12 == null) {
                str = "";
            } else {
                str = str12;
            }
            String str13 = poiInfo.poiName;
            if (str13 == null) {
                str2 = "";
            } else {
                str2 = str13;
            }
            String str14 = poiInfo.poiTypeName;
            if (str14 == null) {
                str3 = "";
            } else {
                str3 = str14;
            }
            String str15 = poiInfo.address;
            if (str15 == null) {
                str4 = "";
            } else {
                str4 = str15;
            }
            GpsParams from = GpsParams.INSTANCE.from(poiInfo.gpsInfo);
            String str16 = poiInfo.phoneNumber;
            if (str16 == null) {
                str5 = "";
            } else {
                str5 = str16;
            }
            String str17 = poiInfo.country;
            if (str17 == null) {
                str6 = "";
            } else {
                str6 = str17;
            }
            String str18 = poiInfo.province;
            if (str18 == null) {
                str7 = "";
            } else {
                str7 = str18;
            }
            String str19 = poiInfo.city;
            if (str19 == null) {
                str8 = "";
            } else {
                str8 = str19;
            }
            String str20 = poiInfo.poiDefaultName;
            if (str20 == null) {
                str9 = "";
            } else {
                str9 = str20;
            }
            String str21 = poiInfo.district;
            if (str21 == null) {
                str10 = "";
            } else {
                str10 = str21;
            }
            String str22 = poiInfo.dianPingId;
            if (str22 == null) {
                str11 = "";
            } else {
                str11 = str22;
            }
            PoiParams poiParams = new PoiParams(i3, i16, i16, i17, i18, str, str2, str3, str4, from, str5, str6, str7, str8, str9, str10, str11, poiInfo.poiType);
            QLog.i(PoiParams.TAG, 1, "[fromPoiInfo] " + poiParams);
            return poiParams;
        }

        Companion() {
        }
    }

    public PoiParams(int i3, int i16, int i17, int i18, int i19, @NotNull String poiId, @NotNull String poiName, @NotNull String poiTypeName, @NotNull String address, @Nullable GpsParams gpsParams, @NotNull String phoneNumber, @NotNull String country, @NotNull String province, @NotNull String city, @NotNull String poiDefaultName, @NotNull String district, @NotNull String dianPingId, int i26) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiName, "poiName");
        Intrinsics.checkNotNullParameter(poiTypeName, "poiTypeName");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(poiDefaultName, "poiDefaultName");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(dianPingId, "dianPingId");
        this.districtCode = i3;
        this.distance = i16;
        this.hotValue = i17;
        this.poiNum = i18;
        this.poiOrderType = i19;
        this.poiId = poiId;
        this.poiName = poiName;
        this.poiTypeName = poiTypeName;
        this.address = address;
        this.gpsParams = gpsParams;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.province = province;
        this.city = city;
        this.poiDefaultName = poiDefaultName;
        this.district = district;
        this.dianPingId = dianPingId;
        this.poiType = i26;
    }

    @JvmStatic
    @Nullable
    public static final PoiParams fromPoiInfo(@Nullable LbsDataV2.PoiInfo poiInfo) {
        return INSTANCE.fromPoiInfo(poiInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDistrictCode() {
        return this.districtCode;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final GpsParams getGpsParams() {
        return this.gpsParams;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getPoiDefaultName() {
        return this.poiDefaultName;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getDianPingId() {
        return this.dianPingId;
    }

    /* renamed from: component18, reason: from getter */
    public final int getPoiType() {
        return this.poiType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDistance() {
        return this.distance;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHotValue() {
        return this.hotValue;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPoiNum() {
        return this.poiNum;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPoiOrderType() {
        return this.poiOrderType;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getPoiName() {
        return this.poiName;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getPoiTypeName() {
        return this.poiTypeName;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final PoiParams copy(int districtCode, int distance, int hotValue, int poiNum, int poiOrderType, @NotNull String poiId, @NotNull String poiName, @NotNull String poiTypeName, @NotNull String address, @Nullable GpsParams gpsParams, @NotNull String phoneNumber, @NotNull String country, @NotNull String province, @NotNull String city, @NotNull String poiDefaultName, @NotNull String district, @NotNull String dianPingId, int poiType) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiName, "poiName");
        Intrinsics.checkNotNullParameter(poiTypeName, "poiTypeName");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(poiDefaultName, "poiDefaultName");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(dianPingId, "dianPingId");
        return new PoiParams(districtCode, distance, hotValue, poiNum, poiOrderType, poiId, poiName, poiTypeName, address, gpsParams, phoneNumber, country, province, city, poiDefaultName, district, dianPingId, poiType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoiParams)) {
            return false;
        }
        PoiParams poiParams = (PoiParams) other;
        if (this.districtCode == poiParams.districtCode && this.distance == poiParams.distance && this.hotValue == poiParams.hotValue && this.poiNum == poiParams.poiNum && this.poiOrderType == poiParams.poiOrderType && Intrinsics.areEqual(this.poiId, poiParams.poiId) && Intrinsics.areEqual(this.poiName, poiParams.poiName) && Intrinsics.areEqual(this.poiTypeName, poiParams.poiTypeName) && Intrinsics.areEqual(this.address, poiParams.address) && Intrinsics.areEqual(this.gpsParams, poiParams.gpsParams) && Intrinsics.areEqual(this.phoneNumber, poiParams.phoneNumber) && Intrinsics.areEqual(this.country, poiParams.country) && Intrinsics.areEqual(this.province, poiParams.province) && Intrinsics.areEqual(this.city, poiParams.city) && Intrinsics.areEqual(this.poiDefaultName, poiParams.poiDefaultName) && Intrinsics.areEqual(this.district, poiParams.district) && Intrinsics.areEqual(this.dianPingId, poiParams.dianPingId) && this.poiType == poiParams.poiType) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final String getCity() {
        return this.city;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getDianPingId() {
        return this.dianPingId;
    }

    public final int getDistance() {
        return this.distance;
    }

    @NotNull
    public final String getDistrict() {
        return this.district;
    }

    public final int getDistrictCode() {
        return this.districtCode;
    }

    @Nullable
    public final GpsParams getGpsParams() {
        return this.gpsParams;
    }

    public final int getHotValue() {
        return this.hotValue;
    }

    @NotNull
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @NotNull
    public final String getPoiDefaultName() {
        return this.poiDefaultName;
    }

    @NotNull
    public final String getPoiId() {
        return this.poiId;
    }

    @NotNull
    public final String getPoiName() {
        return this.poiName;
    }

    public final int getPoiNum() {
        return this.poiNum;
    }

    public final int getPoiOrderType() {
        return this.poiOrderType;
    }

    public final int getPoiType() {
        return this.poiType;
    }

    @NotNull
    public final String getPoiTypeName() {
        return this.poiTypeName;
    }

    @NotNull
    public final String getProvince() {
        return this.province;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((this.districtCode * 31) + this.distance) * 31) + this.hotValue) * 31) + this.poiNum) * 31) + this.poiOrderType) * 31) + this.poiId.hashCode()) * 31) + this.poiName.hashCode()) * 31) + this.poiTypeName.hashCode()) * 31) + this.address.hashCode()) * 31;
        GpsParams gpsParams = this.gpsParams;
        if (gpsParams == null) {
            hashCode = 0;
        } else {
            hashCode = gpsParams.hashCode();
        }
        return ((((((((((((((((hashCode2 + hashCode) * 31) + this.phoneNumber.hashCode()) * 31) + this.country.hashCode()) * 31) + this.province.hashCode()) * 31) + this.city.hashCode()) * 31) + this.poiDefaultName.hashCode()) * 31) + this.district.hashCode()) * 31) + this.dianPingId.hashCode()) * 31) + this.poiType;
    }

    @NotNull
    public String toString() {
        return "PoiParams(districtCode=" + this.districtCode + ", distance=" + this.distance + ", hotValue=" + this.hotValue + ", poiNum=" + this.poiNum + ", poiOrderType=" + this.poiOrderType + ", poiId=" + this.poiId + ", poiName=" + this.poiName + ", poiTypeName=" + this.poiTypeName + ", address=" + this.address + ", gpsParams=" + this.gpsParams + ", phoneNumber=" + this.phoneNumber + ", country=" + this.country + ", province=" + this.province + ", city=" + this.city + ", poiDefaultName=" + this.poiDefaultName + ", district=" + this.district + ", dianPingId=" + this.dianPingId + ", poiType=" + this.poiType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.districtCode);
        parcel.writeInt(this.distance);
        parcel.writeInt(this.hotValue);
        parcel.writeInt(this.poiNum);
        parcel.writeInt(this.poiOrderType);
        parcel.writeString(this.poiId);
        parcel.writeString(this.poiName);
        parcel.writeString(this.poiTypeName);
        parcel.writeString(this.address);
        parcel.writeParcelable(this.gpsParams, flags);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.poiDefaultName);
        parcel.writeString(this.district);
        parcel.writeString(this.dianPingId);
        parcel.writeInt(this.poiType);
    }

    public /* synthetic */ PoiParams(int i3, int i16, int i17, int i18, int i19, String str, String str2, String str3, String str4, GpsParams gpsParams, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, i19, str, str2, str3, str4, (i27 & 512) != 0 ? null : gpsParams, str5, str6, str7, str8, str9, str10, str11, i26);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PoiParams(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r1 == null ? "" : r1, parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        GpsParams gpsParams = (GpsParams) parcel.readParcelable(GpsParams.class.getClassLoader());
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        String str7 = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        String str8 = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        String str9 = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        String str10 = readString10 == null ? "" : readString10;
        String readString11 = parcel.readString();
    }
}
