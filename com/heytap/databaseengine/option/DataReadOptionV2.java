package com.heytap.databaseengine.option;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0010H\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/heytap/databaseengine/option/DataReadOptionV2;", "Lcom/heytap/databaseengine/option/DataReadOption;", "Landroid/os/Parcelable;", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "deviceCategoryList", "", "", "getDeviceCategoryList", "()Ljava/util/List;", "setDeviceCategoryList", "(Ljava/util/List;)V", "readConfig", "", "", "getReadConfig", "()Ljava/util/Map;", "setReadConfig", "(Ljava/util/Map;)V", "readValidCountData", "", "getReadValidCountData", "()Z", "setReadValidCountData", "(Z)V", "describeContents", "toString", "writeToParcel", "", "dest", WadlProxyConsts.FLAGS, "CREATOR", "heytap_health_sdk_v2.1.5_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataReadOptionV2 extends DataReadOption {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private List<String> deviceCategoryList;

    @NotNull
    private Map<Integer, Integer> readConfig;
    private boolean readValidCountData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/heytap/databaseengine/option/DataReadOptionV2$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/heytap/databaseengine/option/DataReadOptionV2;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/heytap/databaseengine/option/DataReadOptionV2;", "heytap_health_sdk_v2.1.5_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.heytap.databaseengine.option.DataReadOptionV2$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion implements Parcelable.Creator<DataReadOptionV2> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DataReadOptionV2 createFromParcel(@NotNull Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new DataReadOptionV2(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DataReadOptionV2[] newArray(int size) {
            return new DataReadOptionV2[size];
        }
    }

    public DataReadOptionV2() {
        this.readConfig = new HashMap();
    }

    @Override // com.heytap.databaseengine.option.DataReadOption, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<String> getDeviceCategoryList() {
        return this.deviceCategoryList;
    }

    @NotNull
    public final Map<Integer, Integer> getReadConfig() {
        return this.readConfig;
    }

    public final boolean getReadValidCountData() {
        return this.readValidCountData;
    }

    public final void setDeviceCategoryList(@Nullable List<String> list) {
        this.deviceCategoryList = list;
    }

    public final void setReadConfig(@NotNull Map<Integer, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.readConfig = map;
    }

    public final void setReadValidCountData(boolean z16) {
        this.readValidCountData = z16;
    }

    @Override // com.heytap.databaseengine.option.DataReadOption
    @NotNull
    public String toString() {
        return "DataReadOptionV2(readConfig=" + this.readConfig + ", readValidCountData=" + this.readValidCountData + ", deviceCategoryList=" + this.deviceCategoryList + ')';
    }

    @Override // com.heytap.databaseengine.option.DataReadOption, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, flags);
        dest.writeInt(this.readConfig.size());
        for (Map.Entry<Integer, Integer> entry : this.readConfig.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            dest.writeValue(Integer.valueOf(intValue));
            dest.writeValue(Integer.valueOf(intValue2));
        }
        dest.writeByte(this.readValidCountData ? (byte) 1 : (byte) 0);
        dest.writeStringList(this.deviceCategoryList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataReadOptionV2(@NotNull Parcel in5) {
        super(in5);
        Intrinsics.checkNotNullParameter(in5, "in");
        this.readConfig = new HashMap();
        int readInt = in5.readInt();
        this.readConfig = new HashMap(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            Class cls = Integer.TYPE;
            Object readValue = in5.readValue(cls.getClassLoader());
            Intrinsics.checkNotNull(readValue, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) readValue).intValue();
            Object readValue2 = in5.readValue(cls.getClassLoader());
            Intrinsics.checkNotNull(readValue2, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) readValue2).intValue();
            Map<Integer, Integer> map = this.readConfig;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type java.util.HashMap<kotlin.Int, kotlin.Int>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Int, kotlin.Int> }");
            ((HashMap) map).put(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        this.readValidCountData = in5.readByte() != 0;
        this.deviceCategoryList = in5.createStringArrayList();
    }
}
