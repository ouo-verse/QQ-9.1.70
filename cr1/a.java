package cr1;

import android.view.View;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcr1/a;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$a;", "listener", "", "b", "c", "", "distanceX", "distanceY", "", "dragType", "Landroid/view/View;", "draggedView", "onDrag", "", "d", "Ljava/util/List;", "listeners", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements DragFrameLayout.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<DragFrameLayout.a> listeners = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcr1/a$a;", "", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", AIInput.KEY_FRAME, "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$a;", "listener", "", "a", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cr1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull DragFrameLayout frame, @NotNull DragFrameLayout.a listener) {
            DragFrameLayout.a aVar;
            Intrinsics.checkNotNullParameter(frame, "frame");
            Intrinsics.checkNotNullParameter(listener, "listener");
            QUIBadgeDragLayout.OnDragListener onDragListener = frame.getOnDragListener();
            if (onDragListener instanceof DragFrameLayout.a) {
                aVar = (DragFrameLayout.a) onDragListener;
            } else {
                aVar = null;
            }
            if (aVar instanceof a) {
                ((a) aVar).b(listener);
                return;
            }
            a aVar2 = new a();
            aVar2.b(listener);
            if (aVar != null) {
                aVar2.b(aVar);
            }
            frame.setOnDragListener(aVar2);
        }

        public final void b(@NotNull DragFrameLayout frame, @NotNull DragFrameLayout.a listener) {
            Intrinsics.checkNotNullParameter(frame, "frame");
            Intrinsics.checkNotNullParameter(listener, "listener");
            QUIBadgeDragLayout.OnDragListener onDragListener = frame.getOnDragListener();
            if (onDragListener instanceof a) {
                a aVar = (a) onDragListener;
                aVar.c(listener);
                if (aVar.listeners.size() == 1) {
                    frame.setOnDragListener((QUIBadgeDragLayout.OnDragListener) aVar.listeners.get(0));
                }
            }
            if (onDragListener == listener) {
                frame.setOnDragListener((QUIBadgeDragLayout.OnDragListener) null);
            }
        }

        Companion() {
        }
    }

    public final void b(@NotNull DragFrameLayout.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void c(@NotNull DragFrameLayout.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragListener
    public void onDrag(float distanceX, float distanceY, int dragType, @NotNull View draggedView) {
        Intrinsics.checkNotNullParameter(draggedView, "draggedView");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DragFrameLayout.a) it.next()).onDrag(distanceX, distanceY, dragType, draggedView);
        }
    }
}
