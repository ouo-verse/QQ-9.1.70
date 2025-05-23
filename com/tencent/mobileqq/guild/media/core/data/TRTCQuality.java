package com.tencent.mobileqq.guild.media.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "userId", "I", "a", "()I", "c", "(I)V", CustomImageProps.QUALITY, "<init>", "()V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TRTCQuality implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String userId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int quality;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.data.TRTCQuality$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<TRTCQuality> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TRTCQuality createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TRTCQuality(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TRTCQuality[] newArray(int size) {
            return new TRTCQuality[size];
        }

        Companion() {
        }
    }

    public TRTCQuality() {
        this.userId = "";
    }

    /* renamed from: a, reason: from getter */
    public final int getQuality() {
        return this.quality;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final void c(int i3) {
        this.quality = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.userId);
        dest.writeInt(this.quality);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRTCQuality(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        if (readString != null) {
            this.userId = readString;
        }
        this.quality = parcel.readInt();
    }
}
