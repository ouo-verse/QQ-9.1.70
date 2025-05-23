package com.tencent.robot.widget.bottomdialog.behavior;

import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.robot.widget.bottomdialog.behavior.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/widget/bottomdialog/behavior/DialogBehaviorUIOperator$mViewFlinger$1", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "f", "Landroid/widget/Scroller;", "d", "Landroid/widget/Scroller;", "e", "()Landroid/widget/Scroller;", "mScroller", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class DialogBehaviorUIOperator$mViewFlinger$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scroller mScroller;
    final /* synthetic */ DialogBehaviorUIOperator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogBehaviorUIOperator$mViewFlinger$1(DialogBehaviorUIOperator dialogBehaviorUIOperator) {
        this.this$0 = dialogBehaviorUIOperator;
        this.mScroller = new Scroller(dialogBehaviorUIOperator.getView().getContext());
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final Scroller getMScroller() {
        return this.mScroller;
    }

    public final void f() {
        this.this$0.getView().removeCallbacks(this);
        ViewCompat.postOnAnimation(this.this$0.getView(), this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mScroller.computeScrollOffset()) {
            c.a.b(this.this$0, this.mScroller.getCurrY(), 0, 2, null);
            f();
        }
    }
}
