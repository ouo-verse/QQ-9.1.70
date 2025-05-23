package com.tencent.state.utils;

import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.state.square.SquareBaseKt;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/utils/TimeoutTaskManager;", "", "()V", "timeoutTask", "Ljava/util/TimerTask;", SemanticAttributes.FaasTriggerValues.TIMER, "Ljava/util/Timer;", "clearTimeout", "", "destroy", "setTimeout", "timeout", "", "callback", "Lkotlin/Function0;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TimeoutTaskManager {
    private static final String TAG = "TimeoutTaskManager";
    private TimerTask timeoutTask;
    private Timer timer = new Timer();

    public final synchronized void clearTimeout() {
        TimerTask timerTask = this.timeoutTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    public final synchronized void destroy() {
        TimerTask timerTask = this.timeoutTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.timeoutTask = null;
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
    }

    public final synchronized void setTimeout(long timeout, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TimerTask timerTask = this.timeoutTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        TimerTask timerTask2 = new TimerTask() { // from class: com.tencent.state.utils.TimeoutTaskManager$setTimeout$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SquareBaseKt.getSquareLog().d("TimeoutTaskManager", "timeoutTask run");
                Function0.this.invoke();
            }
        };
        this.timeoutTask = timerTask2;
        Timer timer = this.timer;
        if (timer != null) {
            timer.schedule(timerTask2, timeout);
        }
    }
}
