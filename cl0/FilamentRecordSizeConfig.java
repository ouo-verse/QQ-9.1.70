package cl0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcl0/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "width", "I", "b", "()I", "height", "a", "<init>", "(II)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: cl0.e, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FilamentRecordSizeConfig {

    @SerializedName("height")
    private final int height;

    @SerializedName("width")
    private final int width;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FilamentRecordSizeConfig() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FilamentRecordSizeConfig) {
                FilamentRecordSizeConfig filamentRecordSizeConfig = (FilamentRecordSizeConfig) other;
                if (this.width != filamentRecordSizeConfig.width || this.height != filamentRecordSizeConfig.height) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    @NotNull
    public String toString() {
        return "FilamentRecordSizeConfig(width=" + this.width + ", height=" + this.height + ")";
    }

    public FilamentRecordSizeConfig(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public /* synthetic */ FilamentRecordSizeConfig(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 900 : i3, (i17 & 2) != 0 ? 1400 : i16);
    }
}
