package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/GuideParamItem;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "guideId", "e", "c", "guideUrl", "f", "b", "guideText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class GuideParamItem implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GuideParamItem> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guideId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guideUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guideText;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a implements Parcelable.Creator<GuideParamItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GuideParamItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuideParamItem(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GuideParamItem[] newArray(int i3) {
            return new GuideParamItem[i3];
        }
    }

    public GuideParamItem(@NotNull String guideId, @NotNull String guideUrl, @NotNull String guideText) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Intrinsics.checkNotNullParameter(guideUrl, "guideUrl");
        Intrinsics.checkNotNullParameter(guideText, "guideText");
        this.guideId = guideId;
        this.guideUrl = guideUrl;
        this.guideText = guideText;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuideId() {
        return this.guideId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuideText() {
        return this.guideText;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuideUrl() {
        return this.guideUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuideParamItem)) {
            return false;
        }
        GuideParamItem guideParamItem = (GuideParamItem) other;
        if (Intrinsics.areEqual(this.guideId, guideParamItem.guideId) && Intrinsics.areEqual(this.guideUrl, guideParamItem.guideUrl) && Intrinsics.areEqual(this.guideText, guideParamItem.guideText)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.guideId.hashCode() * 31) + this.guideUrl.hashCode()) * 31) + this.guideText.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuideParamItem(guideId=" + this.guideId + ", guideUrl=" + this.guideUrl + ", guideText=" + this.guideText + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.guideId);
        parcel.writeString(this.guideUrl);
        parcel.writeString(this.guideText);
    }
}
