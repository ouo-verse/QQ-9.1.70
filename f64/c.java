package f64;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.MainThread;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import com.tencent.robot.widget.list.vb.d;
import com.tencent.robot.widget.list.vb.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\n\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lf64/c;", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/d;", "Lcom/tencent/robot/widget/list/vb/f;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", "binding", "", h.F, "state", "g", "", "f", "d", "Lcom/tencent/robot/widget/list/vb/d;", "e", "()Lcom/tencent/robot/widget/list/vb/d;", "i", "(Lcom/tencent/robot/widget/list/vb/d;)V", "mHost", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.input.base.mvicompat.c<com.tencent.robot.widget.list.vb.a, CommonListUIState, d, f> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mHost;

    public c(@NotNull d mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull CommonListUIState commonListUIState) {
        c.a.a(this, commonListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        c.a.e(this, bVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: e, reason: from getter and merged with bridge method [inline-methods] */
    public d M() {
        return this.mHost;
    }

    @Nullable
    public Void f() {
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CommonListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    public /* bridge */ /* synthetic */ List<Class<? extends CommonListUIState>> getObserverStates() {
        return (List) f();
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull f binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        binding.getRoot().setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
        View root = binding.getRoot();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        root.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mHost = dVar;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }
}
