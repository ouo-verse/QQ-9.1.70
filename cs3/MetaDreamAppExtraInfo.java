package cs3;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcs3/d;", "", "", "toString", "Lcs3/a;", "a", "Lcs3/a;", "()Lcs3/a;", "e", "(Lcs3/a;)V", "apkInfo", "Lcs3/e;", "b", "Lcs3/e;", "d", "()Lcs3/e;", h.F, "(Lcs3/e;)V", "pufferInfo", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", MosaicConstants$JsProperty.PROP_ENV, "f", "diffPatchInfo", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cs3.d, reason: from toString */
/* loaded from: classes22.dex */
public final class MetaDreamAppExtraInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private ApkInfo apkInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private PufferInfo pufferInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String env;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String diffPatchInfo;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final ApkInfo getApkInfo() {
        return this.apkInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final PufferInfo getPufferInfo() {
        return this.pufferInfo;
    }

    public final void e(@Nullable ApkInfo apkInfo) {
        this.apkInfo = apkInfo;
    }

    public final void f(@Nullable String str) {
        this.diffPatchInfo = str;
    }

    public final void g(@Nullable String str) {
        this.env = str;
    }

    public final void h(@Nullable PufferInfo pufferInfo) {
        this.pufferInfo = pufferInfo;
    }

    @NotNull
    public String toString() {
        return "MetaDreamAppExtraInfo(apkInfo=" + this.apkInfo + ", pufferInfo=" + this.pufferInfo + ", env=" + this.env + " diffPatchInfo=" + this.diffPatchInfo + ')';
    }
}
