package l64;

import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Ll64/a;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "b", "Ll64/a$a;", "Ll64/a$b;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ll64/a$a;", "Ll64/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "isShowing", "<init>", "(Z)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l64.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class DialogIsShowingResult extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShowing;

        public DialogIsShowingResult(boolean z16) {
            super(null);
            this.isShowing = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsShowing() {
            return this.isShowing;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof DialogIsShowingResult) && this.isShowing == ((DialogIsShowingResult) other).isShowing) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isShowing;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "DialogIsShowingResult(isShowing=" + this.isShowing + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ll64/a$b;", "Ll64/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "handled", "<init>", "(Z)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l64.a$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class OnTextChangedProcessResult extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean handled;

        public OnTextChangedProcessResult(boolean z16) {
            super(null);
            this.handled = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHandled() {
            return this.handled;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnTextChangedProcessResult) && this.handled == ((OnTextChangedProcessResult) other).handled) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.handled;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "OnTextChangedProcessResult(handled=" + this.handled + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
