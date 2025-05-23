package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B+\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/i;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lb94/d;", "dressController", "", "i", "", "toString", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "Lm94/i;", "callback", "", "waitingUeCallback", "addToHistory", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Lm94/i;ZZ)V", "g", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i extends b {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f370977h = new AtomicInteger();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(DressTaskChannel dressTaskChannel, m94.i callback, boolean z16, boolean z17) {
        super(dressTaskChannel, "RefreshCurrentDressTask-" + f370977h.getAndIncrement(), callback, z17, z16);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        b.d(this, dressController, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b(), false, null, 12, null);
    }

    public String toString() {
        return "RefreshCurrentDressTask, " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
    }
}
