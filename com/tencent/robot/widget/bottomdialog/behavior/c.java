package com.tencent.robot.widget.bottomdialog.behavior;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002H&J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0005H&R\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "Lcom/tencent/robot/widget/bottomdialog/behavior/d;", "", "y", "type", "", "scrollTo", "dy", "scrollBy", "time", "c", "e", "d", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "getScrollY", "()I", "scrollY", "a", "b", "(I)V", "translationY", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface c extends d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static void a(@NotNull c cVar, int i3, int i16) {
            cVar.scrollTo(cVar.getScrollY() + i3, i16);
        }

        public static /* synthetic */ void b(c cVar, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i16 = 1;
                }
                cVar.scrollTo(i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollTo");
        }

        public static /* synthetic */ void c(c cVar, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i16 = 250;
                }
                cVar.c(i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smoothScrollTo");
        }

        public static /* synthetic */ void d(c cVar, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i16 = 125;
                }
                cVar.e(i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smoothTranslateTo");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/behavior/c$b;", "", "Landroid/view/View;", "who", "", "type", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "", "a", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        void a(@NotNull View who, int type, int scrollX, int scrollY, int oldScrollX, int oldScrollY);
    }

    int a();

    void b(int i3);

    void c(int y16, int time);

    void d();

    void e(int y16, int time);

    int getScrollY();

    @NotNull
    View getView();

    void scrollBy(int dy5, int type);

    void scrollTo(int y16, int type);
}
