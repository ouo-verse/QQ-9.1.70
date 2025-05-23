package jf3;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.scene.component.base.FromLifeCycle;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0014\u00a8\u0006\u0010"}, d2 = {"Ljf3/f;", "Ljf3/e;", "", "A0", "Landroid/graphics/Bitmap;", "lastFrame", "", "from", "v0", "", "O", "o0", "<init>", "()V", "Z", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends e {
    private final void A0() {
        dy4.a zplanRender;
        int activeSceneCounter = ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).getActiveSceneCounter();
        QLog.i("SubSceneAvatarComponent_", 1, "tryPauseEngine activeSceneCounter:" + activeSceneCounter);
        if (activeSceneCounter < 1 && (zplanRender = getZplanRender()) != null) {
            zplanRender.pause();
        }
    }

    @Override // md3.a
    protected boolean O() {
        return true;
    }

    @Override // jf3.e
    protected String o0() {
        return "SubSceneAvatarComponent_";
    }

    @Override // jf3.e
    protected void v0(Bitmap lastFrame, @FromLifeCycle String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        A0();
    }
}
