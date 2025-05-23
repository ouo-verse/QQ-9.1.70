package hk1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lhk1/a;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "Lhk1/a$a;", "Lhk1/a$b;", "Lhk1/a$c;", "Lhk1/a$d;", "Lhk1/a$e;", "Lhk1/a$f;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lhk1/a$a;", "Lhk1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "getDx", "()I", "dx", "b", "dy", "<init>", "(II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hk1.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentListOnScroll extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int dx;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int dy;

        public CommentListOnScroll(int i3, int i16) {
            super(null);
            this.dx = i3;
            this.dy = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getDy() {
            return this.dy;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentListOnScroll)) {
                return false;
            }
            CommentListOnScroll commentListOnScroll = (CommentListOnScroll) other;
            if (this.dx == commentListOnScroll.dx && this.dy == commentListOnScroll.dy) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.dx * 31) + this.dy;
        }

        @NotNull
        public String toString() {
            return "CommentListOnScroll(dx=" + this.dx + ", dy=" + this.dy + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lhk1/a$b;", "Lhk1/a;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f405206a = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lhk1/a$c;", "Lhk1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "I", "()I", "height", "<init>", "(Landroid/view/View;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hk1.a$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GetInputViewArgs extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final View rootView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        public GetInputViewArgs() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetInputViewArgs)) {
                return false;
            }
            GetInputViewArgs getInputViewArgs = (GetInputViewArgs) other;
            if (Intrinsics.areEqual(this.rootView, getInputViewArgs.rootView) && this.height == getInputViewArgs.height) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            View view = this.rootView;
            if (view == null) {
                hashCode = 0;
            } else {
                hashCode = view.hashCode();
            }
            return (hashCode * 31) + this.height;
        }

        @NotNull
        public String toString() {
            return "GetInputViewArgs(rootView=" + this.rootView + ", height=" + this.height + ")";
        }

        public /* synthetic */ GetInputViewArgs(View view, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? null : view, (i16 & 2) != 0 ? 0 : i3);
        }

        public GetInputViewArgs(@Nullable View view, int i3) {
            super(null);
            this.rootView = view;
            this.height = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lhk1/a$d;", "Lhk1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "a", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "b", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recyclerViewPool", "Lkk1/a;", "Lkk1/a;", "()Lkk1/a;", "delegatesManager", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Lkk1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hk1.a$d, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GetInputViewRecycledInfo extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RecyclerView.RecycledViewPool recyclerViewPool;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final kk1.a delegatesManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetInputViewRecycledInfo(@NotNull RecyclerView.RecycledViewPool recyclerViewPool, @NotNull kk1.a delegatesManager) {
            super(null);
            Intrinsics.checkNotNullParameter(recyclerViewPool, "recyclerViewPool");
            Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
            this.recyclerViewPool = recyclerViewPool;
            this.delegatesManager = delegatesManager;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final kk1.a getDelegatesManager() {
            return this.delegatesManager;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final RecyclerView.RecycledViewPool getRecyclerViewPool() {
            return this.recyclerViewPool;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetInputViewRecycledInfo)) {
                return false;
            }
            GetInputViewRecycledInfo getInputViewRecycledInfo = (GetInputViewRecycledInfo) other;
            if (Intrinsics.areEqual(this.recyclerViewPool, getInputViewRecycledInfo.recyclerViewPool) && Intrinsics.areEqual(this.delegatesManager, getInputViewRecycledInfo.delegatesManager)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.recyclerViewPool.hashCode() * 31) + this.delegatesManager.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetInputViewRecycledInfo(recyclerViewPool=" + this.recyclerViewPool + ", delegatesManager=" + this.delegatesManager + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lhk1/a$e;", "Lhk1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "()F", "panelHeight", "b", "getProcess", "process", "<init>", "(FF)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hk1.a$e, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class PanelHeightChangeEventDataArgs extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final float panelHeight;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float process;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public PanelHeightChangeEventDataArgs() {
            this(r2, r2, 3, null);
            float f16 = 0.0f;
        }

        /* renamed from: a, reason: from getter */
        public final float getPanelHeight() {
            return this.panelHeight;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PanelHeightChangeEventDataArgs)) {
                return false;
            }
            PanelHeightChangeEventDataArgs panelHeightChangeEventDataArgs = (PanelHeightChangeEventDataArgs) other;
            if (Float.compare(this.panelHeight, panelHeightChangeEventDataArgs.panelHeight) == 0 && Float.compare(this.process, panelHeightChangeEventDataArgs.process) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.panelHeight) * 31) + Float.floatToIntBits(this.process);
        }

        @NotNull
        public String toString() {
            return "PanelHeightChangeEventDataArgs(panelHeight=" + this.panelHeight + ", process=" + this.process + ")";
        }

        public /* synthetic */ PanelHeightChangeEventDataArgs(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17);
        }

        public PanelHeightChangeEventDataArgs(float f16, float f17) {
            super(null);
            this.panelHeight = f16;
            this.process = f17;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lhk1/a$f;", "Lhk1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "loadData", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hk1.a$f, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ShowCommentPanelArgs extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean loadData;

        public ShowCommentPanelArgs() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getLoadData() {
            return this.loadData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowCommentPanelArgs) && this.loadData == ((ShowCommentPanelArgs) other).loadData) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.loadData;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "ShowCommentPanelArgs(loadData=" + this.loadData + ")";
        }

        public ShowCommentPanelArgs(boolean z16) {
            super(null);
            this.loadData = z16;
        }

        public /* synthetic */ ShowCommentPanelArgs(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
