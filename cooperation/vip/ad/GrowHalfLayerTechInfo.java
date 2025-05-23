package cooperation.vip.ad;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0017\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcooperation/vip/ad/GrowHalfLayerTechInfo;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "a", "()I", "adId", "", "e", "J", "b", "()J", "lastStartDuration", "f", "requestNum", tl.h.F, "loadResourceStartTime", "i", "c", "loadResourceEndTime", "<init>", "(IJIJJ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class GrowHalfLayerTechInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GrowHalfLayerTechInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int adId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long lastStartDuration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int requestNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long loadResourceStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long loadResourceEndTime;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class a implements Parcelable.Creator<GrowHalfLayerTechInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GrowHalfLayerTechInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GrowHalfLayerTechInfo(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GrowHalfLayerTechInfo[] newArray(int i3) {
            return new GrowHalfLayerTechInfo[i3];
        }
    }

    public GrowHalfLayerTechInfo(int i3, long j3, int i16, long j16, long j17) {
        this.adId = i3;
        this.lastStartDuration = j3;
        this.requestNum = i16;
        this.loadResourceStartTime = j16;
        this.loadResourceEndTime = j17;
    }

    /* renamed from: a, reason: from getter */
    public final int getAdId() {
        return this.adId;
    }

    /* renamed from: b, reason: from getter */
    public final long getLastStartDuration() {
        return this.lastStartDuration;
    }

    /* renamed from: c, reason: from getter */
    public final long getLoadResourceEndTime() {
        return this.loadResourceEndTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final long getLoadResourceStartTime() {
        return this.loadResourceStartTime;
    }

    /* renamed from: f, reason: from getter */
    public final int getRequestNum() {
        return this.requestNum;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.adId);
        parcel.writeLong(this.lastStartDuration);
        parcel.writeInt(this.requestNum);
        parcel.writeLong(this.loadResourceStartTime);
        parcel.writeLong(this.loadResourceEndTime);
    }
}
