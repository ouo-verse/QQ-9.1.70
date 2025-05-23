package m72;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lm72/d;", "", "", "isSuccess", "", "errMsg", "", "a", "Lm72/c;", "Lm72/c;", "getLoaderParam", "()Lm72/c;", "loaderParam", "b", "Z", "success", "c", "Ljava/lang/String;", "<init>", "(Lm72/c;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c loaderParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean success;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String errMsg;

    public d(c loaderParam) {
        Intrinsics.checkNotNullParameter(loaderParam, "loaderParam");
        this.loaderParam = loaderParam;
        this.errMsg = "";
    }

    public final void a(boolean isSuccess, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.success = isSuccess;
        this.errMsg = errMsg;
    }
}
