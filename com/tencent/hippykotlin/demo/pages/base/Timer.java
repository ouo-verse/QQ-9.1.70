package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Timer {
    public long countDownTime;
    public boolean isRunning;
    public final Object obj;
    public final int step;
    public final Function1<Object, Unit> timeDownCallback;
    public final Function1<Object, Unit> timeStepCallback;
    public final long totalTime;

    public Timer(long j3, int i3, Object obj, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        this.totalTime = j3;
        this.step = i3;
        this.obj = obj;
        this.timeStepCallback = function1;
        this.timeDownCallback = function12;
        this.countDownTime = j3;
    }

    public final void countDownTime() {
        if (this.isRunning) {
            this.timeStepCallback.invoke(Long.valueOf(this.countDownTime));
            TimerKt.g(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.Timer$countDownTime$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Timer timer = Timer.this;
                    if (timer.isRunning) {
                        long j3 = timer.countDownTime - timer.step;
                        timer.countDownTime = j3;
                        if (j3 > 0) {
                            timer.countDownTime();
                        } else {
                            timer.timeDownCallback.invoke(timer.obj);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, this.step);
        }
    }

    public final void stopTimer() {
        if (this.isRunning) {
            this.isRunning = false;
        }
    }

    public /* synthetic */ Timer(long j3, int i3, Function1 function1, Function1 function12, int i16) {
        this(j3, (i16 & 2) != 0 ? 1000 : i3, (Object) null, (Function1<Object, Unit>) ((i16 & 8) != 0 ? new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.Timer.1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                return Unit.INSTANCE;
            }
        } : function1), (Function1<Object, Unit>) function12);
    }
}
