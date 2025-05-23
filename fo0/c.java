package fo0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lfo0/c;", "Lat/a;", "<init>", "()V", "a", "b", "Lfo0/c$a;", "Lfo0/c$b;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class c implements at.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lfo0/c$a;", "Lfo0/c;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends c {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final a f400132d = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lfo0/c$b;", "Lfo0/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "height", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fo0.c$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class InputBarHeightChangeIntent extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        public InputBarHeightChangeIntent(int i3) {
            super(null);
            this.height = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof InputBarHeightChangeIntent) && this.height == ((InputBarHeightChangeIntent) other).height) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.height;
        }

        @NotNull
        public String toString() {
            return "InputBarHeightChangeIntent(height=" + this.height + ")";
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
