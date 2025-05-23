package m81;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lm81/a;", "", "<init>", "()V", "a", "b", "c", "Lm81/a$a;", "Lm81/a$b;", "Lm81/a$c;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lm81/a$a;", "Lm81/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "from", "e", "a", "entryMode", "<init>", "(II)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m81.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes11.dex */
    public static final /* data */ class FeedTabSelectEvent extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int from;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int entryMode;

        public FeedTabSelectEvent(int i3, int i16) {
            super(null);
            this.from = i3;
            this.entryMode = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getEntryMode() {
            return this.entryMode;
        }

        /* renamed from: b, reason: from getter */
        public final int getFrom() {
            return this.from;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedTabSelectEvent)) {
                return false;
            }
            FeedTabSelectEvent feedTabSelectEvent = (FeedTabSelectEvent) other;
            if (this.from == feedTabSelectEvent.from && this.entryMode == feedTabSelectEvent.entryMode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.from * 31) + this.entryMode;
        }

        @NotNull
        public String toString() {
            return "FeedTabSelectEvent(from=" + this.from + ", entryMode=" + this.entryMode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lm81/a$b;", "Lm81/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "b", "()Z", "withAnim", "e", "a", "reportClick", "<init>", "(ZZ)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m81.a$b, reason: from toString */
    /* loaded from: classes11.dex */
    public static final /* data */ class MsgTabSelectEvent extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean withAnim;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean reportClick;

        public MsgTabSelectEvent(boolean z16, boolean z17) {
            super(null);
            this.withAnim = z16;
            this.reportClick = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getReportClick() {
            return this.reportClick;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getWithAnim() {
            return this.withAnim;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgTabSelectEvent)) {
                return false;
            }
            MsgTabSelectEvent msgTabSelectEvent = (MsgTabSelectEvent) other;
            if (this.withAnim == msgTabSelectEvent.withAnim && this.reportClick == msgTabSelectEvent.reportClick) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.withAnim;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.reportClick;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "MsgTabSelectEvent(withAnim=" + this.withAnim + ", reportClick=" + this.reportClick + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lm81/a$c;", "Lm81/a;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final c f416420d = new c();

        c() {
            super(null);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
