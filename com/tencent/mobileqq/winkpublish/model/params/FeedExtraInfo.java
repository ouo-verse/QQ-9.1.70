package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/FeedExtraInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", WadlProxyConsts.CHANNEL, "", "(I)V", "getChannel", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class FeedExtraInfo implements Parcelable {
    private final int channel;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<FeedExtraInfo> CREATOR = new Parcelable.Creator<FeedExtraInfo>() { // from class: com.tencent.mobileqq.winkpublish.model.params.FeedExtraInfo$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FeedExtraInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeedExtraInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FeedExtraInfo[] newArray(int size) {
            return new FeedExtraInfo[size];
        }
    };

    public FeedExtraInfo(int i3) {
        this.channel = i3;
    }

    public static /* synthetic */ FeedExtraInfo copy$default(FeedExtraInfo feedExtraInfo, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = feedExtraInfo.channel;
        }
        return feedExtraInfo.copy(i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getChannel() {
        return this.channel;
    }

    @NotNull
    public final FeedExtraInfo copy(int channel) {
        return new FeedExtraInfo(channel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof FeedExtraInfo) && this.channel == ((FeedExtraInfo) other).channel) {
            return true;
        }
        return false;
    }

    public final int getChannel() {
        return this.channel;
    }

    public int hashCode() {
        return this.channel;
    }

    @NotNull
    public String toString() {
        return "FeedExtraInfo(channel=" + this.channel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.channel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedExtraInfo(@NotNull Parcel parcel) {
        this(parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
