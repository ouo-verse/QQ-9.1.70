package com.tenpay.sdk.net.core.task.base;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.tmdownloader.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/net/core/task/base/TaskStatus;", "", "()V", "status", "Lcom/tenpay/sdk/net/core/task/base/TaskStatus$Status;", "statusChangeListener", "Lcom/tenpay/sdk/net/core/task/base/TaskStatus$TaskStatusChangeListener;", "changeStatus", "", "toStatus", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "isClosed", "setStatusChangeListener", "", "listener", "Status", "TaskStatusChangeListener", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TaskStatus {

    @NotNull
    private volatile Status status = Status.INIT;

    @Nullable
    private TaskStatusChangeListener statusChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/net/core/task/base/TaskStatus$Status;", "", "(Ljava/lang/String;I)V", a.CONNTECTSTATE_INIT, "PENDING", DebugCoroutineInfoImplKt.RUNNING, Tracker.PAUSE, "RESUME", "SUCCESS", Tracker.FAIL, "CANCEL", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum Status {
        INIT,
        PENDING,
        RUNNING,
        PAUSE,
        RESUME,
        SUCCESS,
        FAIL,
        CANCEL
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/net/core/task/base/TaskStatus$TaskStatusChangeListener;", "", "onStatusChange", "", "fromStatus", "Lcom/tenpay/sdk/net/core/task/base/TaskStatus$Status;", "toStatus", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface TaskStatusChangeListener {
        void onStatusChange(@NotNull Status fromStatus, @NotNull Status toStatus);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Status.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Status.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Status.FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Status.SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006f A[Catch: all -> 0x0080, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0013, B:5:0x0016, B:6:0x007c, B:7:0x007f, B:11:0x006f, B:13:0x0077, B:16:0x001c, B:19:0x0021, B:21:0x0025, B:23:0x0029, B:26:0x002e, B:28:0x0032, B:31:0x0037, B:33:0x003b, B:35:0x003f, B:37:0x0043, B:40:0x0048, B:42:0x004c, B:44:0x0050, B:47:0x0055), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean changeStatus(@NotNull Status toStatus) {
        boolean z16;
        List listOf;
        Intrinsics.checkNotNullParameter(toStatus, "toStatus");
        z16 = true;
        switch (WhenMappings.$EnumSwitchMapping$0[this.status.ordinal()]) {
            case 1:
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Status[]{Status.RUNNING, Status.PENDING, Status.CANCEL});
                z16 = listOf.contains(toStatus);
                if (z16) {
                    Status status = this.status;
                    this.status = toStatus;
                    TaskStatusChangeListener taskStatusChangeListener = this.statusChangeListener;
                    if (taskStatusChangeListener != null) {
                        taskStatusChangeListener.onStatusChange(status, toStatus);
                    }
                }
                break;
            case 2:
                if (toStatus != Status.RUNNING) {
                    if (toStatus != Status.PAUSE) {
                        if (toStatus == Status.CANCEL) {
                        }
                        z16 = false;
                    }
                }
                if (z16) {
                }
                break;
            case 3:
                if (toStatus != Status.PAUSE) {
                    if (toStatus != Status.SUCCESS) {
                        if (toStatus != Status.FAIL) {
                            if (toStatus == Status.CANCEL) {
                            }
                            z16 = false;
                        }
                    }
                }
                if (z16) {
                }
                break;
            case 4:
                if (toStatus != Status.RESUME) {
                    if (toStatus == Status.CANCEL) {
                    }
                    z16 = false;
                }
                if (z16) {
                }
                break;
            case 5:
                if (toStatus != Status.PAUSE) {
                    if (toStatus != Status.RUNNING) {
                        if (toStatus == Status.CANCEL) {
                        }
                        z16 = false;
                    }
                }
                if (z16) {
                }
                break;
            case 6:
                if (toStatus == Status.CANCEL) {
                    if (z16) {
                    }
                    break;
                }
                z16 = false;
                if (z16) {
                }
                break;
            case 7:
            case 8:
                z16 = false;
                if (z16) {
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return z16;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    public final boolean isClosed() {
        if (this.status != Status.SUCCESS && this.status != Status.FAIL && this.status != Status.CANCEL) {
            return false;
        }
        return true;
    }

    public final void setStatusChangeListener(@NotNull TaskStatusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.statusChangeListener = listener;
    }
}
