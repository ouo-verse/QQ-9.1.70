package com.tencent.mobileqq.onlinestatus.weather;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b-\u0018\u0000 D2\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\bA\u0010BB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bA\u0010CJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b$\u0010\u000fR\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR$\u00104\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u0010<\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000fR$\u0010@\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000f\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/weather/OnlineStatusWeatherModel;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;)V", "temper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "weatherType", "f", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "weatherTypeId", "", h.F, "J", "o", "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(J)V", "weatherUpdateTime", "i", "l", HippyTKDListViewAdapter.X, "weatherTip", "t", "weatherDesc", BdhLogUtil.LogTag.Tag_Conn, "I", "g", "()I", "u", "(I)V", "weatherFlag", "D", "c", "r", "city", "E", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, GdtGetUserInfoHandler.KEY_AREA, UserInfo.SEX_FEMALE, "a", "p", "adCode", "G", "j", "v", "weatherIconKey", "H", "k", "w", "weatherPrompt", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusWeatherModel implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int weatherFlag;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String city;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String area;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String adCode;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String weatherIconKey;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String weatherPrompt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String temper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String weatherType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String weatherTypeId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long weatherUpdateTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String weatherTip;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String weatherDesc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/weather/OnlineStatusWeatherModel$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/onlinestatus/weather/OnlineStatusWeatherModel;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/onlinestatus/weather/OnlineStatusWeatherModel;", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherModel$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion implements Parcelable.Creator<OnlineStatusWeatherModel> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OnlineStatusWeatherModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OnlineStatusWeatherModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OnlineStatusWeatherModel[] newArray(int size) {
            return new OnlineStatusWeatherModel[size];
        }

        Companion() {
        }
    }

    public OnlineStatusWeatherModel() {
        this.temper = "";
        this.weatherType = "";
        this.weatherTypeId = "";
        this.weatherTip = "";
        this.weatherDesc = "";
        this.city = "";
        this.area = "";
        this.adCode = "";
        this.weatherIconKey = "";
        this.weatherPrompt = "";
    }

    public final void A(long j3) {
        this.weatherUpdateTime = j3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAdCode() {
        return this.adCode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getArea() {
        return this.area;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getTemper() {
        return this.temper;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getWeatherDesc() {
        return this.weatherDesc;
    }

    /* renamed from: g, reason: from getter */
    public final int getWeatherFlag() {
        return this.weatherFlag;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getWeatherIconKey() {
        return this.weatherIconKey;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getWeatherPrompt() {
        return this.weatherPrompt;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getWeatherTip() {
        return this.weatherTip;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final String getWeatherType() {
        return this.weatherType;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getWeatherTypeId() {
        return this.weatherTypeId;
    }

    /* renamed from: o, reason: from getter */
    public final long getWeatherUpdateTime() {
        return this.weatherUpdateTime;
    }

    public final void p(@Nullable String str) {
        this.adCode = str;
    }

    public final void q(@Nullable String str) {
        this.area = str;
    }

    public final void r(@Nullable String str) {
        this.city = str;
    }

    public final void s(@Nullable String str) {
        this.temper = str;
    }

    public final void t(@Nullable String str) {
        this.weatherDesc = str;
    }

    public final void u(int i3) {
        this.weatherFlag = i3;
    }

    public final void v(@Nullable String str) {
        this.weatherIconKey = str;
    }

    public final void w(@Nullable String str) {
        this.weatherPrompt = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.temper);
        parcel.writeString(this.weatherType);
        parcel.writeString(this.weatherTypeId);
        parcel.writeLong(this.weatherUpdateTime);
        parcel.writeString(this.weatherTip);
        parcel.writeString(this.weatherDesc);
        parcel.writeInt(this.weatherFlag);
        parcel.writeString(this.city);
        parcel.writeString(this.area);
        parcel.writeString(this.adCode);
        parcel.writeString(this.weatherIconKey);
        parcel.writeString(this.weatherPrompt);
    }

    public final void x(@Nullable String str) {
        this.weatherTip = str;
    }

    public final void y(@Nullable String str) {
        this.weatherType = str;
    }

    public final void z(@Nullable String str) {
        this.weatherTypeId = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnlineStatusWeatherModel(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.temper = parcel.readString();
        this.weatherType = parcel.readString();
        this.weatherTypeId = parcel.readString();
        this.weatherUpdateTime = parcel.readLong();
        this.weatherTip = parcel.readString();
        this.weatherDesc = parcel.readString();
        this.weatherFlag = parcel.readInt();
        this.city = parcel.readString();
        this.area = parcel.readString();
        this.adCode = parcel.readString();
        this.weatherIconKey = parcel.readString();
        this.weatherPrompt = parcel.readString();
    }
}
