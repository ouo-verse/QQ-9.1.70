package l64;

import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Ll64/b;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "Ll64/b$a;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ll64/b$a;", "Ll64/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "isShowing", "<init>", "(Z)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l64.b$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class GetSlashDialogIsShowingResult extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShowing;

        public GetSlashDialogIsShowingResult(boolean z16) {
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
            if ((other instanceof GetSlashDialogIsShowingResult) && this.isShowing == ((GetSlashDialogIsShowingResult) other).isShowing) {
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
            return "GetSlashDialogIsShowingResult(isShowing=" + this.isShowing + ")";
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
