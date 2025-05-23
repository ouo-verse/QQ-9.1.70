package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005H\u00c6\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final /* data */ class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {

    /* renamed from: Key, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final long id;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: kotlinx.coroutines.CoroutineId$Key, reason: from kotlin metadata */
    /* loaded from: classes28.dex */
    public static final class Companion implements CoroutineContext.Key<CoroutineId> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public CoroutineId(long j3) {
        super(INSTANCE);
        this.id = j3;
    }

    public static /* synthetic */ CoroutineId copy$default(CoroutineId coroutineId, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = coroutineId.id;
        }
        return coroutineId.copy(j3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    public final CoroutineId copy(long id5) {
        return new CoroutineId(id5);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof CoroutineId) && this.id == ((CoroutineId) other).id) {
            return true;
        }
        return false;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return androidx.fragment.app.a.a(this.id);
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.id + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(@NotNull CoroutineContext context, @NotNull String oldState) {
        Thread.currentThread().setName(oldState);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    @NotNull
    public String updateThreadContext(@NotNull CoroutineContext context) {
        int lastIndexOf$default;
        String name;
        CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
        String str = "coroutine";
        if (coroutineName != null && (name = coroutineName.getName()) != null) {
            str = name;
        }
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) name2, " @", 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            lastIndexOf$default = name2.length();
        }
        StringBuilder sb5 = new StringBuilder(str.length() + lastIndexOf$default + 10);
        if (name2 != null) {
            String substring = name2.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            sb5.append(" @");
            sb5.append(str);
            sb5.append('#');
            sb5.append(getId());
            Unit unit = Unit.INSTANCE;
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(capacity).\u2026builderAction).toString()");
            currentThread.setName(sb6);
            return name2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
