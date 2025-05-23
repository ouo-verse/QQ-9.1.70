package com.tencent.zplan.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u001a\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/zplan/model/ZPlanRecordFrameData;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "parcel", "readFromParcel", "", "frameData", "[B", "getFrameData", "()[B", "setFrameData", "([B)V", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "index", "getIndex", "setIndex", "frameTime", "getFrameTime", "setFrameTime", "<init>", "()V", "CREATOR", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanRecordFrameData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private byte[] frameData;
    private int frameTime;
    private int height;
    private int index;
    private int width;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/model/ZPlanRecordFrameData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/zplan/model/ZPlanRecordFrameData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/zplan/model/ZPlanRecordFrameData;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.model.ZPlanRecordFrameData$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion implements Parcelable.Creator<ZPlanRecordFrameData> {
        Companion() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ZPlanRecordFrameData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ZPlanRecordFrameData zPlanRecordFrameData = new ZPlanRecordFrameData();
            zPlanRecordFrameData.readFromParcel(parcel);
            return zPlanRecordFrameData;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZPlanRecordFrameData[] newArray(int size) {
            return new ZPlanRecordFrameData[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final byte[] getFrameData() {
        return this.frameData;
    }

    public final int getFrameTime() {
        return this.frameTime;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void readFromParcel(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.frameData = parcel.createByteArray();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.index = parcel.readInt();
        this.frameTime = parcel.readInt();
    }

    public final void setFrameData(@Nullable byte[] bArr) {
        this.frameData = bArr;
    }

    public final void setFrameTime(int i3) {
        this.frameTime = i3;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setIndex(int i3) {
        this.index = i3;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel dest, int flags) {
        if (dest != null) {
            dest.writeByteArray(this.frameData);
        }
        if (dest != null) {
            dest.writeInt(this.width);
        }
        if (dest != null) {
            dest.writeInt(this.height);
        }
        if (dest != null) {
            dest.writeInt(this.index);
        }
        if (dest != null) {
            dest.writeInt(this.frameTime);
        }
    }
}
