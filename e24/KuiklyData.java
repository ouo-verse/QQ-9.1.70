package e24;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Entity(tableName = "kuikly_data")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Le24/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", QAdRewardDefine$SecurityData.DATA_KEY, "c", "dataValue", "", "[B", "()[B", "byteArray", "<init>", "(Ljava/lang/String;Ljava/lang/String;[B)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e24.c, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class KuiklyData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @PrimaryKey
    @NotNull
    private final String dataKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @ColumnInfo(name = "dataValue")
    @NotNull
    private final String dataValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @ColumnInfo(name = "byteArray")
    @NotNull
    private final byte[] byteArray;

    public KuiklyData(@NotNull String dataKey, @NotNull String dataValue, @NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        Intrinsics.checkNotNullParameter(dataValue, "dataValue");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        this.dataKey = dataKey;
        this.dataValue = dataValue;
        this.byteArray = byteArray;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final byte[] getByteArray() {
        return this.byteArray;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDataKey() {
        return this.dataKey;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDataValue() {
        return this.dataValue;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(KuiklyData.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.robot.adelie.kuikly.database.KuiklyData");
        KuiklyData kuiklyData = (KuiklyData) other;
        if (!Intrinsics.areEqual(this.dataKey, kuiklyData.dataKey) || !Intrinsics.areEqual(this.dataValue, kuiklyData.dataValue)) {
            return false;
        }
        return Arrays.equals(this.byteArray, kuiklyData.byteArray);
    }

    public int hashCode() {
        return (((this.dataKey.hashCode() * 31) + this.dataValue.hashCode()) * 31) + Arrays.hashCode(this.byteArray);
    }

    @NotNull
    public String toString() {
        return "KuiklyData(dataKey=" + this.dataKey + ", dataValue=" + this.dataValue + ", byteArray=" + Arrays.toString(this.byteArray) + ")";
    }
}
