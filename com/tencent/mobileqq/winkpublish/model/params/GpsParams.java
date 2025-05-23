package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0019H\u0016R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/GpsParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", QCircleSchemeAttr.Polymerize.LAT, "", "lon", QCircleSchemeAttr.Polymerize.ALT, "gpsType", "accuracy", "(JJJJJ)V", "getAccuracy", "()J", "getAlt", "getGpsType", "getLat", "getLon", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class GpsParams implements Parcelable {

    @NotNull
    private static final String TAG = "GpsParams";
    private final long accuracy;
    private final long alt;
    private final long gpsType;
    private final long lat;
    private final long lon;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<GpsParams> CREATOR = new Parcelable.Creator<GpsParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.GpsParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public GpsParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GpsParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public GpsParams[] newArray(int size) {
            return new GpsParams[size];
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/GpsParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/GpsParams;", "TAG", "", "from", "gpsInfo", "Lcooperation/qzone/LbsDataV2$GpsInfo;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final GpsParams from(@Nullable LbsDataV2.GpsInfo gpsInfo) {
            if (gpsInfo == null) {
                QLog.i(GpsParams.TAG, 1, "[fromGpsInfo] invalid params");
                return null;
            }
            GpsParams gpsParams = new GpsParams(gpsInfo.lat, gpsInfo.lon, gpsInfo.alt, gpsInfo.gpsType, gpsInfo.accuracy);
            QLog.i(GpsParams.TAG, 1, "[fromGpsInfo] " + gpsParams);
            return gpsParams;
        }

        Companion() {
        }
    }

    public GpsParams(long j3, long j16, long j17, long j18, long j19) {
        this.lat = j3;
        this.lon = j16;
        this.alt = j17;
        this.gpsType = j18;
        this.accuracy = j19;
    }

    public static /* synthetic */ GpsParams copy$default(GpsParams gpsParams, long j3, long j16, long j17, long j18, long j19, int i3, Object obj) {
        long j26;
        long j27;
        long j28;
        long j29;
        long j36;
        if ((i3 & 1) != 0) {
            j26 = gpsParams.lat;
        } else {
            j26 = j3;
        }
        if ((i3 & 2) != 0) {
            j27 = gpsParams.lon;
        } else {
            j27 = j16;
        }
        if ((i3 & 4) != 0) {
            j28 = gpsParams.alt;
        } else {
            j28 = j17;
        }
        if ((i3 & 8) != 0) {
            j29 = gpsParams.gpsType;
        } else {
            j29 = j18;
        }
        if ((i3 & 16) != 0) {
            j36 = gpsParams.accuracy;
        } else {
            j36 = j19;
        }
        return gpsParams.copy(j26, j27, j28, j29, j36);
    }

    /* renamed from: component1, reason: from getter */
    public final long getLat() {
        return this.lat;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLon() {
        return this.lon;
    }

    /* renamed from: component3, reason: from getter */
    public final long getAlt() {
        return this.alt;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGpsType() {
        return this.gpsType;
    }

    /* renamed from: component5, reason: from getter */
    public final long getAccuracy() {
        return this.accuracy;
    }

    @NotNull
    public final GpsParams copy(long lat, long lon, long alt, long gpsType, long accuracy) {
        return new GpsParams(lat, lon, alt, gpsType, accuracy);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GpsParams)) {
            return false;
        }
        GpsParams gpsParams = (GpsParams) other;
        if (this.lat == gpsParams.lat && this.lon == gpsParams.lon && this.alt == gpsParams.alt && this.gpsType == gpsParams.gpsType && this.accuracy == gpsParams.accuracy) {
            return true;
        }
        return false;
    }

    public final long getAccuracy() {
        return this.accuracy;
    }

    public final long getAlt() {
        return this.alt;
    }

    public final long getGpsType() {
        return this.gpsType;
    }

    public final long getLat() {
        return this.lat;
    }

    public final long getLon() {
        return this.lon;
    }

    public int hashCode() {
        return (((((((a.a(this.lat) * 31) + a.a(this.lon)) * 31) + a.a(this.alt)) * 31) + a.a(this.gpsType)) * 31) + a.a(this.accuracy);
    }

    @NotNull
    public String toString() {
        return "GpsParams(lat=" + this.lat + ", lon=" + this.lon + ", alt=" + this.alt + ", gpsType=" + this.gpsType + ", accuracy=" + this.accuracy + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.lat);
        parcel.writeLong(this.lon);
        parcel.writeLong(this.alt);
        parcel.writeLong(this.gpsType);
        parcel.writeLong(this.accuracy);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GpsParams(@NotNull Parcel parcel) {
        this(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
