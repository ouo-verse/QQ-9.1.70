package e40;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\nB;\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Le40/n;", "", "", "g", "", "toString", "", "hashCode", "other", "equals", "a", "Z", "f", "()Z", "isSuccess", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "coverUrl", "c", "e", "isByUser", "Landroid/os/Bundle;", "d", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "transParams", "errorCode", "errorMsg", "<init>", "(ZLjava/lang/String;ZLandroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e40.n, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSTopPopBannerData {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final List<String> f395657h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isByUser;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle transParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMsg;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"1410015", "1410009"});
        f395657h = listOf;
    }

    public QFSTopPopBannerData(boolean z16, @NotNull String coverUrl, boolean z17, @Nullable Bundle bundle, @NotNull String errorCode, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.isSuccess = z16;
        this.coverUrl = coverUrl;
        this.isByUser = z17;
        this.transParams = bundle;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Bundle getTransParams() {
        return this.transParams;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsByUser() {
        return this.isByUser;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSTopPopBannerData)) {
            return false;
        }
        QFSTopPopBannerData qFSTopPopBannerData = (QFSTopPopBannerData) other;
        if (this.isSuccess == qFSTopPopBannerData.isSuccess && Intrinsics.areEqual(this.coverUrl, qFSTopPopBannerData.coverUrl) && this.isByUser == qFSTopPopBannerData.isByUser && Intrinsics.areEqual(this.transParams, qFSTopPopBannerData.transParams) && Intrinsics.areEqual(this.errorCode, qFSTopPopBannerData.errorCode) && Intrinsics.areEqual(this.errorMsg, qFSTopPopBannerData.errorMsg)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final boolean g() {
        return f395657h.contains(this.errorCode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isSuccess;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode2 = ((r06 * 31) + this.coverUrl.hashCode()) * 31;
        boolean z17 = this.isByUser;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i16 = (hashCode2 + i3) * 31;
        Bundle bundle = this.transParams;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        return ((((i16 + hashCode) * 31) + this.errorCode.hashCode()) * 31) + this.errorMsg.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSTopPopBannerData(isSuccess=" + this.isSuccess + ", coverUrl=" + this.coverUrl + ", isByUser=" + this.isByUser + ", transParams=" + this.transParams + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
    }
}
