package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lb94/d;", "dressController", "", "i", "", "toString", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "Lm94/i;", "callback", "", "waitingUeCallback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Lm94/i;Z)V", "g", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends b {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f370979h = new AtomicInteger(0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(DressTaskChannel dressTaskChannel, m94.i callback, boolean z16) {
        super(dressTaskChannel, "ResetAvatarToSavedTask-" + f370979h.getAndIncrement(), callback, false, z16);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        b.d(this, dressController, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.d().b(), false, null, 12, null);
    }

    public String toString() {
        return "ResetAvatarToSavedTask, " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
    }
}
