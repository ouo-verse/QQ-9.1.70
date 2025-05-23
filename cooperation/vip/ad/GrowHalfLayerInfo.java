package cooperation.vip.ad;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rBi\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00107\u001a\u000203\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010/\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b.\u0010\u0013R\u0017\u00102\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b1\u0010\u000eR\u0017\u00107\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b\u0015\u00106\u00a8\u0006:"}, d2 = {"Lcooperation/vip/ad/GrowHalfLayerInfo;", "Landroid/os/Parcelable;", "", "toString", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "a", "()I", "adId", "e", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "hippyJsBundleName", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hippyJsBundleType", tl.h.F, "k", "hippyHeightStrategy", "i", "j", "hippyHeight", "", UserInfo.SEX_FEMALE, "g", "()F", "hippyAspectRatio", BdhLogUtil.LogTag.Tag_Conn, "o", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "D", "allAdJsonInfoStr", "", "E", "J", "c", "()J", "adTimestamp", DomainData.DOMAIN_NAME, "traceId", "G", "b", "adSpaceId", "", "H", "Z", "()Z", "clickOtherNoDismiss", "<init>", "(ILjava/lang/String;Ljava/lang/String;IIFLjava/lang/String;Ljava/lang/String;JLjava/lang/String;IZ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class GrowHalfLayerInfo implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private final String traceInfo;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private final String allAdJsonInfoStr;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private final long adTimestamp;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: G, reason: from kotlin metadata */
    private final int adSpaceId;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean clickOtherNoDismiss;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int adId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String hippyJsBundleName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String hippyJsBundleType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hippyHeightStrategy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hippyHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final float hippyAspectRatio;

    @NotNull
    public static final Parcelable.Creator<GrowHalfLayerInfo> CREATOR = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class b implements Parcelable.Creator<GrowHalfLayerInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GrowHalfLayerInfo createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            float readFloat = parcel.readFloat();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            long readLong = parcel.readLong();
            String readString5 = parcel.readString();
            int readInt4 = parcel.readInt();
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new GrowHalfLayerInfo(readInt, readString, readString2, readInt2, readInt3, readFloat, readString3, readString4, readLong, readString5, readInt4, z16);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GrowHalfLayerInfo[] newArray(int i3) {
            return new GrowHalfLayerInfo[i3];
        }
    }

    public GrowHalfLayerInfo(int i3, @NotNull String hippyJsBundleName, @NotNull String hippyJsBundleType, int i16, int i17, float f16, @NotNull String traceInfo, @NotNull String allAdJsonInfoStr, long j3, @NotNull String traceId, int i18, boolean z16) {
        Intrinsics.checkNotNullParameter(hippyJsBundleName, "hippyJsBundleName");
        Intrinsics.checkNotNullParameter(hippyJsBundleType, "hippyJsBundleType");
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        Intrinsics.checkNotNullParameter(allAdJsonInfoStr, "allAdJsonInfoStr");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.adId = i3;
        this.hippyJsBundleName = hippyJsBundleName;
        this.hippyJsBundleType = hippyJsBundleType;
        this.hippyHeightStrategy = i16;
        this.hippyHeight = i17;
        this.hippyAspectRatio = f16;
        this.traceInfo = traceInfo;
        this.allAdJsonInfoStr = allAdJsonInfoStr;
        this.adTimestamp = j3;
        this.traceId = traceId;
        this.adSpaceId = i18;
        this.clickOtherNoDismiss = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getAdId() {
        return this.adId;
    }

    /* renamed from: b, reason: from getter */
    public final int getAdSpaceId() {
        return this.adSpaceId;
    }

    /* renamed from: c, reason: from getter */
    public final long getAdTimestamp() {
        return this.adTimestamp;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAllAdJsonInfoStr() {
        return this.allAdJsonInfoStr;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getClickOtherNoDismiss() {
        return this.clickOtherNoDismiss;
    }

    /* renamed from: g, reason: from getter */
    public final float getHippyAspectRatio() {
        return this.hippyAspectRatio;
    }

    /* renamed from: j, reason: from getter */
    public final int getHippyHeight() {
        return this.hippyHeight;
    }

    /* renamed from: k, reason: from getter */
    public final int getHippyHeightStrategy() {
        return this.hippyHeightStrategy;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getHippyJsBundleName() {
        return this.hippyJsBundleName;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getHippyJsBundleType() {
        return this.hippyJsBundleType;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    @NotNull
    public String toString() {
        return "GrowHalfLayerInfo(adId=" + this.adId + ", hippyJsBundleName='" + this.hippyJsBundleName + "', hippyJsBundleType='" + this.hippyJsBundleType + "', hippyHeightStrategy=" + this.hippyHeightStrategy + ", hippyHeight=" + this.hippyHeight + ", hippyAspectRatio=" + this.hippyAspectRatio + ", traceInfo='" + this.traceInfo + "', allAdJsonInfoStr='" + this.allAdJsonInfoStr + "', adTimestamp=" + this.adTimestamp + ", traceId='" + this.traceId + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.adId);
        parcel.writeString(this.hippyJsBundleName);
        parcel.writeString(this.hippyJsBundleType);
        parcel.writeInt(this.hippyHeightStrategy);
        parcel.writeInt(this.hippyHeight);
        parcel.writeFloat(this.hippyAspectRatio);
        parcel.writeString(this.traceInfo);
        parcel.writeString(this.allAdJsonInfoStr);
        parcel.writeLong(this.adTimestamp);
        parcel.writeString(this.traceId);
        parcel.writeInt(this.adSpaceId);
        parcel.writeInt(this.clickOtherNoDismiss ? 1 : 0);
    }
}
