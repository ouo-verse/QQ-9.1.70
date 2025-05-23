package i32;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\u000b\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Li32/a;", UserInfo.SEX_FEMALE, "", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "()Ljava/lang/Class;", "featureClazz", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "featureImpl", "<init>", "(Ljava/lang/Class;Ljava/lang/Object;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a<F> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<F> featureClazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final F featureImpl;

    public a(@NotNull Class<F> featureClazz, F f16) {
        Intrinsics.checkNotNullParameter(featureClazz, "featureClazz");
        this.featureClazz = featureClazz;
        this.featureImpl = f16;
    }

    @NotNull
    public final Class<F> a() {
        return this.featureClazz;
    }

    public final F b() {
        return this.featureImpl;
    }
}
