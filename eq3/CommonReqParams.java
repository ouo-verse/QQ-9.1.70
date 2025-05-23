package eq3;

import android.os.Bundle;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\t\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Leq3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", PushClientConstants.TAG_PKG_NAME, "b", "c", "hostAppId", "e", "proxyAppId", "f", "proxyToken", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "bundle", "Lcom/tencent/open/model/a;", "Lcom/tencent/open/model/a;", "()Lcom/tencent/open/model/a;", "account", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/tencent/open/model/a;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: eq3.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class CommonReqParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pkgName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String hostAppId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String proxyAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String proxyToken;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle bundle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final com.tencent.open.model.a account;

    public CommonReqParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final com.tencent.open.model.a getAccount() {
        return this.account;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getHostAppId() {
        return this.hostAppId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getPkgName() {
        return this.pkgName;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getProxyAppId() {
        return this.proxyAppId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonReqParams)) {
            return false;
        }
        CommonReqParams commonReqParams = (CommonReqParams) other;
        if (Intrinsics.areEqual(this.pkgName, commonReqParams.pkgName) && Intrinsics.areEqual(this.hostAppId, commonReqParams.hostAppId) && Intrinsics.areEqual(this.proxyAppId, commonReqParams.proxyAppId) && Intrinsics.areEqual(this.proxyToken, commonReqParams.proxyToken) && Intrinsics.areEqual(this.bundle, commonReqParams.bundle) && Intrinsics.areEqual(this.account, commonReqParams.account)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getProxyToken() {
        return this.proxyToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.pkgName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.hostAppId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.proxyAppId;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.proxyToken;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Bundle bundle = this.bundle;
        if (bundle == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = bundle.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        com.tencent.open.model.a aVar = this.account;
        if (aVar != null) {
            i3 = aVar.hashCode();
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "CommonReqParams(pkgName=" + this.pkgName + ", hostAppId=" + this.hostAppId + ", proxyAppId=" + this.proxyAppId + ", proxyToken=" + this.proxyToken + ", bundle=" + this.bundle + ", account=" + this.account + ")";
    }

    public CommonReqParams(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Bundle bundle, @Nullable com.tencent.open.model.a aVar) {
        this.pkgName = str;
        this.hostAppId = str2;
        this.proxyAppId = str3;
        this.proxyToken = str4;
        this.bundle = bundle;
        this.account = aVar;
    }

    public /* synthetic */ CommonReqParams(String str, String str2, String str3, String str4, Bundle bundle, com.tencent.open.model.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : bundle, (i3 & 32) != 0 ? null : aVar);
    }
}
