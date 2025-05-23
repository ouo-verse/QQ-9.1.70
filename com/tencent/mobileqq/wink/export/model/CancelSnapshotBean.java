package com.tencent.mobileqq.wink.export.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.vfs.QuotaFileSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u001d2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0013\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/export/model/CancelSnapshotBean;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "toString", "d", "I", "a", "()I", "c", "(I)V", QuotaFileSystem.STAT_FILE_COUNT, "", "e", "J", "b", "()J", "(J)V", "videoTotalDurationMs", "<init>", "()V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class CancelSnapshotBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int fileCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long videoTotalDurationMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/export/model/CancelSnapshotBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/export/model/CancelSnapshotBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/export/model/CancelSnapshotBean;", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.export.model.CancelSnapshotBean$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<CancelSnapshotBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CancelSnapshotBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CancelSnapshotBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CancelSnapshotBean[] newArray(int size) {
            return new CancelSnapshotBean[size];
        }

        Companion() {
        }
    }

    public CancelSnapshotBean() {
    }

    /* renamed from: a, reason: from getter */
    public final int getFileCount() {
        return this.fileCount;
    }

    /* renamed from: b, reason: from getter */
    public final long getVideoTotalDurationMs() {
        return this.videoTotalDurationMs;
    }

    public final void c(int i3) {
        this.fileCount = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(long j3) {
        this.videoTotalDurationMs = j3;
    }

    @NotNull
    public String toString() {
        return "CancelSnapshotBean(fileCount=" + this.fileCount + ", videoTotalDurationMs=" + this.videoTotalDurationMs + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel dest, int flags) {
        if (dest != null) {
            dest.writeInt(this.fileCount);
        }
        if (dest != null) {
            dest.writeLong(this.videoTotalDurationMs);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CancelSnapshotBean(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.fileCount = parcel.readInt();
        this.videoTotalDurationMs = parcel.readLong();
    }
}
