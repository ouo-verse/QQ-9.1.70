package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/g;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lb94/d;", "dressController", "", "i", "Lm94/a;", "newDressInfo", "", "addToHistory", "j", "", "toString", "", "g", "I", "getTargetHistoryIndex", "()I", "targetHistoryIndex", tl.h.F, "Lm94/a;", "getTargetHistoryData", "()Lm94/a;", "targetHistoryData", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Ljava/lang/String;Lm94/i;ILm94/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends b {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int targetHistoryIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final m94.a targetHistoryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(DressTaskChannel dressTaskChannel, String taskId, m94.i callback, int i3, m94.a targetHistoryData) {
        super(dressTaskChannel, taskId, callback, false, false, 16, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(targetHistoryData, "targetHistoryData");
        this.targetHistoryIndex = i3;
        this.targetHistoryData = targetHistoryData;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        b.d(this, dressController, this.targetHistoryData, false, null, 8, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    protected void j(b94.d dressController, m94.a newDressInfo, boolean addToHistory) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        Intrinsics.checkNotNullParameter(newDressInfo, "newDressInfo");
        dressController.n5(this.targetHistoryIndex);
        dressController.Nc(this.targetHistoryData, false);
    }

    public String toString() {
        return "HistoryDressTask, " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() + ", targetHistoryIndex:" + this.targetHistoryIndex + ", data:" + this.targetHistoryData;
    }
}
