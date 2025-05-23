package com.tencent.biz.qqcircle.immersive.redpacket.task;

import androidx.annotation.CallSuper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0017R\"\u0010\f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/e;", "DATA", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/p;", "", "cancel", "", "a", "Z", "getCancelled", "()Z", "setCancelled", "(Z)V", "cancelled", "", "c", "()Ljava/lang/String;", "tag", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class e<DATA> implements p<DATA> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean cancelled;

    @NotNull
    public abstract String c();

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    @CallSuper
    public void cancel() {
        QLog.d(c(), 1, "cancel ");
        this.cancelled = true;
    }
}
