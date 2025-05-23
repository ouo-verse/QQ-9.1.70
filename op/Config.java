package op;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\n\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lop/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lop/f;", "a", "Lop/f;", "b", "()Lop/f;", "f", "(Lop/f;)V", "logger", "Lop/e;", "Lop/e;", "c", "()Lop/e;", "g", "(Lop/e;)V", "stateChangeListener", "Z", "d", "()Z", "isDebug", "Lop/c;", "exceptionListener", "Lop/c;", "()Lop/c;", "e", "(Lop/c;)V", "<init>", "(Z)V", "fg_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: op.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class Config {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f logger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e stateChangeListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDebug;

    public Config() {
        this(false, 1, null);
    }

    @Nullable
    public final c a() {
        return null;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final f getLogger() {
        return this.logger;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final e getStateChangeListener() {
        return this.stateChangeListener;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsDebug() {
        return this.isDebug;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof Config) || this.isDebug != ((Config) other).isDebug) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final void f(@Nullable f fVar) {
        this.logger = fVar;
    }

    public final void g(@Nullable e eVar) {
        this.stateChangeListener = eVar;
    }

    public int hashCode() {
        boolean z16 = this.isDebug;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "Config(isDebug=" + this.isDebug + ")";
    }

    public Config(boolean z16) {
        this.isDebug = z16;
    }

    public /* synthetic */ Config(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public final void e(@Nullable c cVar) {
    }
}
