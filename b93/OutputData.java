package b93;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001\nB]\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\u0019\u0010&\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\n\u0010%\u00a8\u0006*"}, d2 = {"Lb93/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "f", "()J", "outputPoint", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "missionId", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Ljava/util/List;", "e", "()Ljava/util/List;", "outputMedias", "d", "originalMedias", "businessReturnSchema", "getBusinessUserData", "businessUserData", "g", "getBusinessTaskId", "businessTaskId", "Landroid/os/Bundle;", h.F, "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "bundle", "<init>", "(JLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "i", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: b93.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class OutputData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long outputPoint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String missionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<LocalMediaInfo> outputMedias;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<LocalMediaInfo> originalMedias;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String businessReturnSchema;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String businessUserData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String businessTaskId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle bundle;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ$\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lb93/b$a;", "", "", "outputPoint", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "outputMedias", "originalMedias", "Landroid/os/Bundle;", "bundle", "Lb93/b;", "b", "Landroid/content/Intent;", "intent", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: b93.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OutputData a(long outputPoint, @NotNull List<? extends LocalMediaInfo> outputMedias, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(outputMedias, "outputMedias");
            Intrinsics.checkNotNullParameter(intent, "intent");
            return ((IWinkAPI) QRoute.api(IWinkAPI.class)).retrieveOutputData(outputPoint, outputMedias, intent);
        }

        @NotNull
        public final OutputData b(long outputPoint, @NotNull List<? extends LocalMediaInfo> outputMedias, @Nullable List<? extends LocalMediaInfo> originalMedias, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(outputMedias, "outputMedias");
            return ((IWinkAPI) QRoute.api(IWinkAPI.class)).retrieveOutputData(outputPoint, outputMedias, originalMedias, bundle);
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OutputData(long j3, @NotNull String missionId, @NotNull List<? extends LocalMediaInfo> outputMedias, @Nullable List<? extends LocalMediaInfo> list, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(outputMedias, "outputMedias");
        this.outputPoint = j3;
        this.missionId = missionId;
        this.outputMedias = outputMedias;
        this.originalMedias = list;
        this.businessReturnSchema = str;
        this.businessUserData = str2;
        this.businessTaskId = str3;
        this.bundle = bundle;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getBusinessReturnSchema() {
        return this.businessReturnSchema;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    public final List<LocalMediaInfo> d() {
        return this.originalMedias;
    }

    @NotNull
    public final List<LocalMediaInfo> e() {
        return this.outputMedias;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutputData)) {
            return false;
        }
        OutputData outputData = (OutputData) other;
        if (this.outputPoint == outputData.outputPoint && Intrinsics.areEqual(this.missionId, outputData.missionId) && Intrinsics.areEqual(this.outputMedias, outputData.outputMedias) && Intrinsics.areEqual(this.originalMedias, outputData.originalMedias) && Intrinsics.areEqual(this.businessReturnSchema, outputData.businessReturnSchema) && Intrinsics.areEqual(this.businessUserData, outputData.businessUserData) && Intrinsics.areEqual(this.businessTaskId, outputData.businessTaskId) && Intrinsics.areEqual(this.bundle, outputData.bundle)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getOutputPoint() {
        return this.outputPoint;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int a16 = ((((androidx.fragment.app.a.a(this.outputPoint) * 31) + this.missionId.hashCode()) * 31) + this.outputMedias.hashCode()) * 31;
        List<LocalMediaInfo> list = this.originalMedias;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        String str = this.businessReturnSchema;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.businessUserData;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.businessTaskId;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Bundle bundle = this.bundle;
        if (bundle != null) {
            i3 = bundle.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "OutputData(outputPoint=" + this.outputPoint + ", missionId=" + this.missionId + ", outputMedias=" + this.outputMedias + ", originalMedias=" + this.originalMedias + ", businessReturnSchema=" + this.businessReturnSchema + ", businessUserData=" + this.businessUserData + ", businessTaskId=" + this.businessTaskId + ", bundle=" + this.bundle + ")";
    }
}
