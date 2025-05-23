package i01;

import i01.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R(\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Li01/f;", "Li01/b;", "Lcom/tencent/kuikly/core/render/android/a;", "a", "Lcom/tencent/kuikly/core/render/android/a;", "_kuiklyRenderContext", "value", "()Lcom/tencent/kuikly/core/render/android/a;", "setKuiklyRenderContext", "(Lcom/tencent/kuikly/core/render/android/a;)V", "kuiklyRenderContext", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class f implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.a _kuiklyRenderContext;

    @Nullable
    /* renamed from: a, reason: from getter */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return this._kuiklyRenderContext;
    }

    @Override // i01.b
    @Nullable
    public Object d(@NotNull String methodName, @NotNull String params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        return b.a.a(this, methodName, params);
    }

    @Override // i01.b
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        this._kuiklyRenderContext = aVar;
    }
}
