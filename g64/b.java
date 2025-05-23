package g64;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lg64/b;", "Lcom/tencent/robot/widget/list/vb/a;", "<init>", "()V", "a", "Lg64/b$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b extends com.tencent.robot.widget.list.vb.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lg64/b$a;", "Lg64/b;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "a", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "c", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "layoutManager", "", "e", "I", "b", "()I", "(I)V", HippyTKDListViewAdapter.SCROLL_STATE, "<init>", "(Landroidx/recyclerview/widget/LinearLayoutManager;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private LinearLayoutManager layoutManager;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int scrollState;

        public a(@Nullable LinearLayoutManager linearLayoutManager, int i3) {
            super(null);
            this.layoutManager = linearLayoutManager;
            this.scrollState = i3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final LinearLayoutManager getLayoutManager() {
            return this.layoutManager;
        }

        /* renamed from: b, reason: from getter */
        public final int getScrollState() {
            return this.scrollState;
        }

        public final void c(@Nullable LinearLayoutManager linearLayoutManager) {
            this.layoutManager = linearLayoutManager;
        }

        public final void d(int i3) {
            this.scrollState = i3;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
