package com.tencent.mobileqq.wink.aigc.newtest;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\u0016B3\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u001dR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u0015\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "modelName", "e", "a", "coverUrl", "f", "b", "desc", tl.h.F, "I", "()I", "wantWidth", "i", "wantHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class ModelItem implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int wantWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int wantHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aigc.newtest.ModelItem$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<ModelItem> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModelItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ModelItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ModelItem[] newArray(int size) {
            return new ModelItem[size];
        }

        Companion() {
        }
    }

    public ModelItem(@NotNull String modelName, @NotNull String coverUrl, @NotNull String desc, int i3, int i16) {
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.modelName = modelName;
        this.coverUrl = coverUrl;
        this.desc = desc;
        this.wantWidth = i3;
        this.wantHeight = i16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getWantHeight() {
        return this.wantHeight;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelItem)) {
            return false;
        }
        ModelItem modelItem = (ModelItem) other;
        if (Intrinsics.areEqual(this.modelName, modelItem.modelName) && Intrinsics.areEqual(this.coverUrl, modelItem.coverUrl) && Intrinsics.areEqual(this.desc, modelItem.desc) && this.wantWidth == modelItem.wantWidth && this.wantHeight == modelItem.wantHeight) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getWantWidth() {
        return this.wantWidth;
    }

    public int hashCode() {
        return (((((((this.modelName.hashCode() * 31) + this.coverUrl.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.wantWidth) * 31) + this.wantHeight;
    }

    @NotNull
    public String toString() {
        return "ModelItem(modelName=" + this.modelName + ", coverUrl=" + this.coverUrl + ", desc=" + this.desc + ", wantWidth=" + this.wantWidth + ", wantHeight=" + this.wantHeight + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.modelName);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.desc);
        parcel.writeInt(this.wantWidth);
        parcel.writeInt(this.wantHeight);
    }

    public /* synthetic */ ModelItem(String str, String str2, String str3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? 0 : i16);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ModelItem(@NotNull Parcel parcel) {
        this(r3, r4, r0 == null ? "" : r0, parcel.readInt(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
    }
}
