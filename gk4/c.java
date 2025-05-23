package gk4;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lgk4/c;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/FrameLayout;", "a", "", "b", "c", "Lgk4/d;", "Lgk4/d;", "pendantManager", "", "Z", "isInited", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d pendantManager = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isInited;

    private final FrameLayout a(View rootView) {
        View findViewById = rootView.findViewById(R.id.f235806t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.pendantContainerRb)");
        return (FrameLayout) findViewById;
    }

    public final void b(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (this.isInited) {
            return;
        }
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long p16 = cVar.p();
        if (p16 == 0) {
            AegisLogger.INSTANCE.e("Pendant|TimiAnchorPendantComponent", "initPendant", "init pendant, room id is 0!");
            com.tencent.mobileqq.qqlive.framework.c.e(new IllegalAccessException("pendant init but room id is 0!"));
        } else {
            this.pendantManager.t(p16).r(com.tencent.mobileqq.qqlive.sail.c.l(cVar, p16, 0, 2, null)).u(1).s(a(rootView));
            this.pendantManager.E(rootView.findViewById(R.id.f236106w)).F(rootView.findViewById(R.id.f236006v)).h();
            this.isInited = true;
        }
    }

    public final void c() {
        this.isInited = false;
        this.pendantManager.w();
    }
}
