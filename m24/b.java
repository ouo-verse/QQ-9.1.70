package m24;

import android.view.View;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lm24/b;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "Lm24/b$a;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lm24/b$a;", "Lm24/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "anchorView", "<init>", "(Landroid/view/View;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m24.b$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class GeAnchorViewMsgResult extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final View anchorView;

        public GeAnchorViewMsgResult(@Nullable View view) {
            super(null);
            this.anchorView = view;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final View getAnchorView() {
            return this.anchorView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GeAnchorViewMsgResult) && Intrinsics.areEqual(this.anchorView, ((GeAnchorViewMsgResult) other).anchorView)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            View view = this.anchorView;
            if (view == null) {
                return 0;
            }
            return view.hashCode();
        }

        @NotNull
        public String toString() {
            return "GeAnchorViewMsgResult(anchorView=" + this.anchorView + ")";
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
