package com.tencent.mobileqq.wink.picker;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.picker.WinkMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB'\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/WinkMediaInfos;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/wink/picker/WinkMediaInfo;", "d", "Ljava/util/List;", "getOriginalMediaList", "()Ljava/util/List;", "originalMediaList", "e", "getProcessedMediaList", "processedMediaList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkMediaInfos implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<WinkMediaInfo> originalMediaList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<WinkMediaInfo> processedMediaList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/WinkMediaInfos$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/picker/WinkMediaInfos;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/picker/WinkMediaInfos;", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.WinkMediaInfos$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkMediaInfos> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkMediaInfos createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkMediaInfos(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkMediaInfos[] newArray(int size) {
            return new WinkMediaInfos[size];
        }

        Companion() {
        }
    }

    public WinkMediaInfos(@Nullable List<WinkMediaInfo> list, @Nullable List<WinkMediaInfo> list2) {
        this.originalMediaList = list;
        this.processedMediaList = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkMediaInfos)) {
            return false;
        }
        WinkMediaInfos winkMediaInfos = (WinkMediaInfos) other;
        if (Intrinsics.areEqual(this.originalMediaList, winkMediaInfos.originalMediaList) && Intrinsics.areEqual(this.processedMediaList, winkMediaInfos.processedMediaList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        List<WinkMediaInfo> list = this.originalMediaList;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i16 = hashCode * 31;
        List<WinkMediaInfo> list2 = this.processedMediaList;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "WinkMediaInfos(originalMediaList=" + this.originalMediaList + ", processedMediaList=" + this.processedMediaList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.originalMediaList);
        parcel.writeTypedList(this.processedMediaList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkMediaInfos(@NotNull Parcel parcel) {
        this(parcel.createTypedArrayList(r0), parcel.createTypedArrayList(r0));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        WinkMediaInfo.Companion companion = WinkMediaInfo.INSTANCE;
    }
}
