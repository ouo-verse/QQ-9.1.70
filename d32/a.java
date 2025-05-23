package d32;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\t\b\u0004\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u0082\u0001\u0001\u0006\u00a8\u0006\u0007"}, d2 = {"Ld32/a;", "", "Ld32/b;", "a", "<init>", "()V", "Ld32/c;", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Ld32/a$a;", "", "", "appId", "Ld32/a;", "a", "QQLIVE_APP_ID", "Ljava/lang/String;", "<init>", "()V", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: d32.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a(@NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            if (Intrinsics.areEqual(appId, "1078")) {
                return c.f392737b;
            }
            throw new RuntimeException("invalid appId: " + appId);
        }

        Companion() {
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract LiveConfig a();

    a() {
    }
}
