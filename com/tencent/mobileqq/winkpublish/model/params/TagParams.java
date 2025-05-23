package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\fH\u00c6\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\b\u0010\u001c\u001a\u00020\fH\u0016J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\fH\u00d6\u0001J\t\u0010!\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\fH\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/TagParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "name", "rank", "hasSelected", "", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getHasSelected", "()Z", "getId", "()Ljava/lang/String;", "getName", "getRank", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class TagParams implements Parcelable {

    @NotNull
    private static final String TAG = "TagParams";
    private final boolean hasSelected;

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String rank;
    private final int type;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TagParams> CREATOR = new Parcelable.Creator<TagParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.TagParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TagParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TagParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TagParams[] newArray(int size) {
            return new TagParams[size];
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/TagParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/TagParams;", "TAG", "", "from", "", "labelInfos", "Lcooperation/qzone/model/LabelInfo;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final List<TagParams> from(@Nullable List<? extends LabelInfo> labelInfos) {
            boolean z16;
            int collectionSizeOrDefault;
            String str;
            String str2;
            String str3;
            List<? extends LabelInfo> list = labelInfos;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.i(TagParams.TAG, 1, "[fromLabelInfo] invalid params");
                return null;
            }
            List<? extends LabelInfo> list2 = labelInfos;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (LabelInfo labelInfo : list2) {
                String str4 = labelInfo.f390867id;
                if (str4 == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str4, "it.id ?: \"\"");
                    str = str4;
                }
                String str5 = labelInfo.name;
                if (str5 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str5, "it.name ?: \"\"");
                    str2 = str5;
                }
                String str6 = labelInfo.rank;
                if (str6 == null) {
                    str3 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str6, "it.rank ?: \"\"");
                    str3 = str6;
                }
                arrayList.add(new TagParams(str, str2, str3, labelInfo.hasSelected, labelInfo.type));
            }
            QLog.i(TagParams.TAG, 1, "[fromLabelInfos] " + arrayList);
            return arrayList;
        }

        Companion() {
        }
    }

    public TagParams(@NotNull String id5, @NotNull String name, @NotNull String rank, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rank, "rank");
        this.id = id5;
        this.name = name;
        this.rank = rank;
        this.hasSelected = z16;
        this.type = i3;
    }

    public static /* synthetic */ TagParams copy$default(TagParams tagParams, String str, String str2, String str3, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = tagParams.id;
        }
        if ((i16 & 2) != 0) {
            str2 = tagParams.name;
        }
        String str4 = str2;
        if ((i16 & 4) != 0) {
            str3 = tagParams.rank;
        }
        String str5 = str3;
        if ((i16 & 8) != 0) {
            z16 = tagParams.hasSelected;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            i3 = tagParams.type;
        }
        return tagParams.copy(str, str4, str5, z17, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRank() {
        return this.rank;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasSelected() {
        return this.hasSelected;
    }

    /* renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final TagParams copy(@NotNull String id5, @NotNull String name, @NotNull String rank, boolean hasSelected, int type) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rank, "rank");
        return new TagParams(id5, name, rank, hasSelected, type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagParams)) {
            return false;
        }
        TagParams tagParams = (TagParams) other;
        if (Intrinsics.areEqual(this.id, tagParams.id) && Intrinsics.areEqual(this.name, tagParams.name) && Intrinsics.areEqual(this.rank, tagParams.rank) && this.hasSelected == tagParams.hasSelected && this.type == tagParams.type) {
            return true;
        }
        return false;
    }

    public final boolean getHasSelected() {
        return this.hasSelected;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRank() {
        return this.rank;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.rank.hashCode()) * 31;
        boolean z16 = this.hasSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "TagParams(id=" + this.id + ", name=" + this.name + ", rank=" + this.rank + ", hasSelected=" + this.hasSelected + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.rank);
        parcel.writeByte(this.hasSelected ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TagParams(@NotNull Parcel parcel) {
        this(r3, r4, r0 == null ? "" : r0, parcel.readByte() != 0, parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
    }
}
