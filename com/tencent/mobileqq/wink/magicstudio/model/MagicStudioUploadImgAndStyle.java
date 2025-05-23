package com.tencent.mobileqq.wink.magicstudio.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R6\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR6\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "currentImg", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "getCurrentImg", "()Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "setCurrentImg", "(Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;)V", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "Lkotlin/collections/ArrayList;", "recommendTopicList", "Ljava/util/ArrayList;", "getRecommendTopicList", "()Ljava/util/ArrayList;", "setRecommendTopicList", "(Ljava/util/ArrayList;)V", "recommendStyleList", "getRecommendStyleList", "setRecommendStyleList", "safeId", "Ljava/lang/String;", "getSafeId", "()Ljava/lang/String;", "setSafeId", "(Ljava/lang/String;)V", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioUploadImgAndStyle implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private MagicStudioUploadImgInfo currentImg;

    /* renamed from: recommendStyleList, reason: from kotlin metadata and from toString */
    @Nullable
    private ArrayList<String> recommendStyleMap;

    @Nullable
    private ArrayList<MagicStudioPrompt> recommendTopicList;

    @NotNull
    private String safeId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<MagicStudioUploadImgAndStyle> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MagicStudioUploadImgAndStyle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MagicStudioUploadImgAndStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MagicStudioUploadImgAndStyle[] newArray(int size) {
            return new MagicStudioUploadImgAndStyle[size];
        }

        Companion() {
        }
    }

    public MagicStudioUploadImgAndStyle() {
        this.safeId = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final MagicStudioUploadImgInfo getCurrentImg() {
        return this.currentImg;
    }

    @Nullable
    public final ArrayList<String> getRecommendStyleList() {
        return this.recommendStyleMap;
    }

    @Nullable
    public final ArrayList<MagicStudioPrompt> getRecommendTopicList() {
        return this.recommendTopicList;
    }

    @NotNull
    public final String getSafeId() {
        return this.safeId;
    }

    public final void setCurrentImg(@Nullable MagicStudioUploadImgInfo magicStudioUploadImgInfo) {
        this.currentImg = magicStudioUploadImgInfo;
    }

    public final void setRecommendStyleList(@Nullable ArrayList<String> arrayList) {
        this.recommendStyleMap = arrayList;
    }

    public final void setRecommendTopicList(@Nullable ArrayList<MagicStudioPrompt> arrayList) {
        this.recommendTopicList = arrayList;
    }

    public final void setSafeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.safeId = str;
    }

    @NotNull
    public String toString() {
        return "MagicStudioUploadImgAndStyle(currentImg=" + this.currentImg + ", recommendTopicList=" + this.recommendTopicList + ", recommendStyleMap=" + this.recommendStyleMap + ", safeId='" + this.safeId + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.currentImg, flags);
        ArrayList<MagicStudioPrompt> arrayList = this.recommendTopicList;
        if (arrayList != null) {
            parcel.writeParcelableArray((Parcelable[]) arrayList.toArray(new MagicStudioPrompt[arrayList.size()]), flags);
        }
        parcel.writeStringList(this.recommendStyleMap);
        parcel.writeString(this.safeId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MagicStudioUploadImgAndStyle(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.currentImg = (MagicStudioUploadImgInfo) parcel.readParcelable(MagicStudioUploadImgInfo.class.getClassLoader());
        Parcelable[] readParcelableArray = parcel.readParcelableArray(MagicStudioPrompt.class.getClassLoader());
        this.recommendTopicList = new ArrayList<>();
        if (readParcelableArray != null) {
            Iterator it = ArrayIteratorKt.iterator(readParcelableArray);
            while (it.hasNext()) {
                Parcelable parcelable = (Parcelable) it.next();
                ArrayList<MagicStudioPrompt> arrayList = this.recommendTopicList;
                if (arrayList != null) {
                    Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt");
                    arrayList.add((MagicStudioPrompt) parcelable);
                }
            }
        }
        this.recommendStyleMap = parcel.createStringArrayList();
        String readString = parcel.readString();
        this.safeId = readString == null ? "" : readString;
    }
}
