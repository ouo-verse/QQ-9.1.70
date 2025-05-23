package dz2;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015R0\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Ldz2/c;", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "a", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "c", "(Ljava/lang/ref/WeakReference;)V", "bizCallbackRef", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "exposureUrl", "referent", "<init>", "(Ljava/lang/Object;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c<R> extends WeakReference<R> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<VasResultCallback<Boolean>> bizCallbackRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String exposureUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull R referent) {
        super(referent);
        Intrinsics.checkNotNullParameter(referent, "referent");
    }

    @Nullable
    public final WeakReference<VasResultCallback<Boolean>> a() {
        return this.bizCallbackRef;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getExposureUrl() {
        return this.exposureUrl;
    }

    public final void c(@Nullable WeakReference<VasResultCallback<Boolean>> weakReference) {
        this.bizCallbackRef = weakReference;
    }

    public final void d(@Nullable String str) {
        this.exposureUrl = str;
    }
}
