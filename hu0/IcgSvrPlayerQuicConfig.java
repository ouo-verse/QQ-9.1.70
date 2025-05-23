package hu0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lhu0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "isEnableDownloadProxy", "Z", "b", "()Z", "isSupportQuicFLv", "c", "enableQuicPlaintext", "a", "<init>", "(ZZZ)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hu0.b, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class IcgSvrPlayerQuicConfig {

    @SerializedName("enable_quic_plaintext")
    private final boolean enableQuicPlaintext;

    @SerializedName("is_enable_download_proxy")
    private final boolean isEnableDownloadProxy;

    @SerializedName("is_support_quic_flv")
    private final boolean isSupportQuicFLv;

    public IcgSvrPlayerQuicConfig() {
        this(false, false, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableQuicPlaintext() {
        return this.enableQuicPlaintext;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsEnableDownloadProxy() {
        return this.isEnableDownloadProxy;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSupportQuicFLv() {
        return this.isSupportQuicFLv;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IcgSvrPlayerQuicConfig)) {
            return false;
        }
        IcgSvrPlayerQuicConfig icgSvrPlayerQuicConfig = (IcgSvrPlayerQuicConfig) other;
        if (this.isEnableDownloadProxy == icgSvrPlayerQuicConfig.isEnableDownloadProxy && this.isSupportQuicFLv == icgSvrPlayerQuicConfig.isSupportQuicFLv && this.enableQuicPlaintext == icgSvrPlayerQuicConfig.enableQuicPlaintext) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isEnableDownloadProxy;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isSupportQuicFLv;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.enableQuicPlaintext;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "IcgSvrPlayerQuicConfig(isEnableDownloadProxy=" + this.isEnableDownloadProxy + ", isSupportQuicFLv=" + this.isSupportQuicFLv + ", enableQuicPlaintext=" + this.enableQuicPlaintext + ")";
    }

    public IcgSvrPlayerQuicConfig(boolean z16, boolean z17, boolean z18) {
        this.isEnableDownloadProxy = z16;
        this.isSupportQuicFLv = z17;
        this.enableQuicPlaintext = z18;
    }

    public /* synthetic */ IcgSvrPlayerQuicConfig(boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18);
    }
}
