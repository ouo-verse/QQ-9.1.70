package com.tencent.mobileqq.qcoroutine.framework.report;

import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u0012\b\b\u0002\u0010(\u001a\u00020\b\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/report/a;", "", "Lcom/tencent/mobileqq/qcoroutine/framework/b;", "task", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "getType", "()Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "", "b", "J", "getTaskWaitTime", "()J", "setTaskWaitTime", "(J)V", "taskWaitTime", "c", "getTaskDelayTime", "setTaskDelayTime", "taskDelayTime", "d", "getTaskBlockTime", "setTaskBlockTime", "taskBlockTime", "e", "I", "getTaskCount", "()I", "setTaskCount", "(I)V", "taskCount", "<init>", "(Lcom/tencent/mobileqq/qcoroutine/api/i;JJJI)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long taskWaitTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long taskDelayTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long taskBlockTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int taskCount;

    public a(@NotNull i type, long j3, long j16, long j17, int i3) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, type, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3));
            return;
        }
        this.type = type;
        this.taskWaitTime = j3;
        this.taskDelayTime = j16;
        this.taskBlockTime = j17;
        this.taskCount = i3;
    }

    public final void a(@Nullable b task) {
        Long i3;
        Long c16;
        Long b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) task);
            return;
        }
        if (task == null || (i3 = task.i()) == null || (c16 = task.c()) == null || (b16 = task.b()) == null) {
            return;
        }
        this.taskWaitTime += i3.longValue();
        this.taskDelayTime += c16.longValue();
        this.taskBlockTime += b16.longValue();
        this.taskCount++;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (!Intrinsics.areEqual(this.type, aVar.type) || this.taskWaitTime != aVar.taskWaitTime || this.taskDelayTime != aVar.taskDelayTime || this.taskBlockTime != aVar.taskBlockTime || this.taskCount != aVar.taskCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        i iVar = this.type;
        if (iVar != null) {
            i3 = iVar.hashCode();
        } else {
            i3 = 0;
        }
        return (((((((i3 * 31) + androidx.fragment.app.a.a(this.taskWaitTime)) * 31) + androidx.fragment.app.a.a(this.taskDelayTime)) * 31) + androidx.fragment.app.a.a(this.taskBlockTime)) * 31) + this.taskCount;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "TaskPoolStatisticalData(type=" + this.type + ", taskWaitTime=" + this.taskWaitTime + ", taskDelayTime=" + this.taskDelayTime + ", taskBlockTime=" + this.taskBlockTime + ", taskCount=" + this.taskCount + ")";
    }

    public /* synthetic */ a(i iVar, long j3, long j16, long j17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? 0L : j16, (i16 & 8) != 0 ? 0L : j17, (i16 & 16) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, this, iVar, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
