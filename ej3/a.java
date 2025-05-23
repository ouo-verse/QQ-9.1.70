package ej3;

import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.c;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lej3/a;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "", "onFirstFrame", "", "d", "Z", "isFirstFrame", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstFrame = true;

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean z16) {
        c.a.a(this, z16);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.isFirstFrame) {
            this.isFirstFrame = false;
            com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.a.f371751a.h(ZPlanQQMC.INSTANCE.getZPlanShareConfig());
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean z16) {
        c.a.c(this, z16);
    }
}
