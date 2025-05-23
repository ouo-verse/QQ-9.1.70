package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u00c6\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u00c6\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/MaterialParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "ids", "", "(Ljava/lang/String;Ljava/util/List;)V", "getIds", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class MaterialParams implements Parcelable {

    @NotNull
    private static final String TAG = "MaterialParams";

    @NotNull
    private final List<String> ids;

    @NotNull
    private final String type;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<MaterialParams> CREATOR = new Parcelable.Creator<MaterialParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.MaterialParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MaterialParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MaterialParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MaterialParams[] newArray(int size) {
            return new MaterialParams[size];
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/MaterialParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/MaterialParams;", "TAG", "", "from", "", "records", "Lcom/tencent/mobileqq/winkreport/datong/WinkPublishMediaRecord;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final List<MaterialParams> from(@Nullable List<? extends WinkPublishMediaRecord> records) {
            boolean z16;
            int collectionSizeOrDefault;
            List<? extends WinkPublishMediaRecord> list = records;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.i(MaterialParams.TAG, 1, "[from] invalid params");
                return null;
            }
            List<? extends WinkPublishMediaRecord> list2 = records;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (WinkPublishMediaRecord winkPublishMediaRecord : list2) {
                String str = winkPublishMediaRecord.mediaType;
                Intrinsics.checkNotNullExpressionValue(str, "it.mediaType");
                List<String> list3 = winkPublishMediaRecord.mediaId;
                Intrinsics.checkNotNullExpressionValue(list3, "it.mediaId");
                arrayList.add(new MaterialParams(str, list3));
            }
            QLog.i(MaterialParams.TAG, 1, "[from] " + arrayList);
            return arrayList;
        }

        Companion() {
        }
    }

    public MaterialParams(@NotNull String type, @NotNull List<String> ids) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.type = type;
        this.ids = ids;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaterialParams copy$default(MaterialParams materialParams, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = materialParams.type;
        }
        if ((i3 & 2) != 0) {
            list = materialParams.ids;
        }
        return materialParams.copy(str, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final List<String> component2() {
        return this.ids;
    }

    @NotNull
    public final MaterialParams copy(@NotNull String type, @NotNull List<String> ids) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(ids, "ids");
        return new MaterialParams(type, ids);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaterialParams)) {
            return false;
        }
        MaterialParams materialParams = (MaterialParams) other;
        if (Intrinsics.areEqual(this.type, materialParams.type) && Intrinsics.areEqual(this.ids, materialParams.ids)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> getIds() {
        return this.ids;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.ids.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaterialParams(type=" + this.type + ", ids=" + this.ids + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeStringList(this.ids);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialParams(@NotNull Parcel parcel) {
        this(r0, r2 == null ? CollectionsKt__CollectionsKt.emptyList() : r2);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        List createStringArrayList = parcel.createStringArrayList();
    }
}
