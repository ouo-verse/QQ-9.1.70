package mi1;

import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager;
import com.tencent.mobileqq.guild.report.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0016R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lmi1/a;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$b;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$a;", "", "", "a", "", "isDone", "", "dragType", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "from", "onChange", "", "distanceX", "distanceY", "mode", "Landroid/view/View;", "draggedView", "onDrag", "", "onGetVisibleDragView", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "draggedViewRef", "<init>", "()V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements DragFrameLayout.b, DragFrameLayout.a, QUIBadgeDragLayout.IDragViewProvider {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> draggedViewRef;

    private final void a() {
        Object obj = this.draggedViewRef;
        if (obj == null) {
            obj = "";
        }
        QLog.i("Guild.MF.GuildTabDragListenerImpl", 1, "onStartBornAll " + obj);
        e.c("drag");
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean isDone, int dragType, @NotNull QUIBadgeDragLayout from) {
        Intrinsics.checkNotNullParameter(from, "from");
        boolean j3 = GuildMainFrameRedDragManager.i().j();
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isInGuildTab()) {
            QLog.w("Guild.MF.GuildTabDragListenerImpl", 1, "onChange isInGuildTab=false " + isDone + " dragType=" + dragType + " from=" + from + " isDragging=" + j3);
            return;
        }
        QLog.d("Guild.MF.GuildTabDragListenerImpl", 1, "onChange ", Boolean.valueOf(isDone), " dragType=", Integer.valueOf(dragType), " from=", from, " isDragging=", Boolean.valueOf(j3));
        if (j3) {
            GuildMainFrameRedDragManager.i().g("Guild.MF.GuildTabDragListenerImpl onChange", isDone);
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragListener
    public void onDrag(float distanceX, float distanceY, int mode, @NotNull View draggedView) {
        Intrinsics.checkNotNullParameter(draggedView, "draggedView");
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isInGuildTab()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.GuildTabDragListenerImpl", 1, "onDrag mode=", Integer.valueOf(mode), " draggedView=", draggedView);
        }
        boolean j3 = GuildMainFrameRedDragManager.i().j();
        if (mode != 1 && mode != 2) {
            if (mode == -1 && j3) {
                GuildMainFrameRedDragManager.i().f("Guild.MF.GuildTabDragListenerImpl onDrag idle");
            }
        } else if (!j3) {
            GuildMainFrameRedDragManager.i().m("Guild.MF.GuildTabDragListenerImpl draggedView=" + draggedView);
        }
        if (mode == -1) {
            this.draggedViewRef = new WeakReference<>(draggedView);
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.IDragViewProvider
    @NotNull
    public List<View> onGetVisibleDragView() {
        a();
        return new ArrayList();
    }
}
