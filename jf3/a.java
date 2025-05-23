package jf3;

import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Ljf3/a;", "Lcom/tencent/zplan/world/view/b;", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "a", "Z", "getDisableUeEvent", "()Z", "(Z)V", "disableUeEvent", "<init>", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements com.tencent.zplan.world.view.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean disableUeEvent;

    public a(boolean z16) {
        this.disableUeEvent = z16;
    }

    public final void a(boolean z16) {
        this.disableUeEvent = z16;
    }

    @Override // com.tencent.zplan.world.view.b
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.disableUeEvent) {
            QLog.i("AvatarTextureViewTouchListener_", 1, "onTouchEvent disableUeEvent!");
            return false;
        }
        ZPlanServiceHelper.I.w0(event);
        return true;
    }
}
