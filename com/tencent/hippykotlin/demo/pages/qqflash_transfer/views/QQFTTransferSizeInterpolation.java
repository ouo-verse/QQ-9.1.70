package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.MutableState;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Timer;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zz0.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTTransferSizeInterpolation {
    public long beforeValue;
    public MutableState<Long> curValue;
    public Timer downloadSpeedTimer;
    public long expertCostTime = 1000;
    public final Function1<Long, Unit> finalListener;
    public long nextValue;
    public long startTimerTimestamp;
    public float step;

    /* JADX WARN: Multi-variable type inference failed */
    public QQFTTransferSizeInterpolation(MutableState<Long> mutableState, Function1<? super Long, Unit> function1) {
        this.curValue = mutableState;
        this.finalListener = function1;
    }

    public final int updateValue(long j3, boolean z16) {
        long j16 = this.nextValue;
        if (j16 >= j3) {
            return 0;
        }
        if (!z16) {
            this.beforeValue = j3;
            this.curValue.setValue(Long.valueOf(j3));
            this.nextValue = j3;
            return 0;
        }
        this.beforeValue = j16;
        this.curValue.setValue(Long.valueOf(j16));
        this.nextValue = j3;
        Timer timer = this.downloadSpeedTimer;
        if (timer != null) {
            timer.stopTimer();
        }
        if (j3 == 0) {
            KLog.INSTANCE.d("QQFTTransferSizeInterpolation", "updateValue 0");
            return 0;
        }
        if (this.startTimerTimestamp > 0) {
            this.expertCostTime = a.f453719a.a() - this.startTimerTimestamp;
        }
        this.startTimerTimestamp = a.f453719a.a();
        this.downloadSpeedTimer = null;
        long j17 = this.expertCostTime;
        int i3 = j17 >= 1000 ? 20 : j17 >= 500 ? 10 : 5;
        this.step = ((float) (this.nextValue - this.beforeValue)) / i3;
        int i16 = (int) (j17 / i3);
        int i17 = i3 * i16;
        long j18 = i17;
        Timer timer2 = new Timer(j18, i16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTransferSizeInterpolation$updateValue$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QQFTTransferSizeInterpolation qQFTTransferSizeInterpolation = QQFTTransferSizeInterpolation.this;
                qQFTTransferSizeInterpolation.getClass();
                long a16 = a.f453719a.a() - qQFTTransferSizeInterpolation.startTimerTimestamp;
                if (a16 >= qQFTTransferSizeInterpolation.expertCostTime) {
                    qQFTTransferSizeInterpolation.curValue.setValue(Long.valueOf(qQFTTransferSizeInterpolation.nextValue));
                    Function1<Long, Unit> function1 = qQFTTransferSizeInterpolation.finalListener;
                    if (function1 != null) {
                        function1.invoke(qQFTTransferSizeInterpolation.curValue.getValue());
                    }
                    qQFTTransferSizeInterpolation.expertCostTime = 500L;
                    qQFTTransferSizeInterpolation.startTimerTimestamp = 0L;
                } else {
                    MutableState<Long> mutableState = qQFTTransferSizeInterpolation.curValue;
                    mutableState.setValue(Long.valueOf(mutableState.getValue().longValue() + qQFTTransferSizeInterpolation.step));
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onTimerStep curValue=");
                m3.append(qQFTTransferSizeInterpolation.curValue.getValue().longValue());
                m3.append(" beforeValue=");
                m3.append(qQFTTransferSizeInterpolation.beforeValue);
                m3.append(" nextValue=");
                m3.append(qQFTTransferSizeInterpolation.nextValue);
                m3.append(" elapseTime=");
                m3.append(a16);
                m3.append(" expertCostTime=");
                m3.append(qQFTTransferSizeInterpolation.expertCostTime);
                kLog.d("QQFTTransferSizeInterpolation", m3.toString());
                return Unit.INSTANCE;
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTTransferSizeInterpolation$updateValue$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                KLog.INSTANCE.d("QQFTTransferSizeInterpolation", "timeDownCallback....");
                QQFTTransferSizeInterpolation qQFTTransferSizeInterpolation = QQFTTransferSizeInterpolation.this;
                qQFTTransferSizeInterpolation.curValue.setValue(Long.valueOf(qQFTTransferSizeInterpolation.nextValue));
                QQFTTransferSizeInterpolation qQFTTransferSizeInterpolation2 = QQFTTransferSizeInterpolation.this;
                Function1<Long, Unit> function1 = qQFTTransferSizeInterpolation2.finalListener;
                if (function1 != null) {
                    function1.invoke(qQFTTransferSizeInterpolation2.curValue.getValue());
                }
                QQFTTransferSizeInterpolation.this.expertCostTime = 500L;
                return Unit.INSTANCE;
            }
        }, 4);
        this.downloadSpeedTimer = timer2;
        if (!timer2.isRunning) {
            timer2.isRunning = true;
            timer2.countDownTime = j18;
            timer2.countDownTime();
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateValue oldValue=");
        m3.append(this.curValue.getValue().longValue());
        m3.append(" newValue=");
        m3.append(j3);
        m3.append(" expertCostTime=");
        m3.append(this.expertCostTime);
        m3.append(" startTimerTimestamp=");
        m3.append(this.startTimerTimestamp);
        m3.append(" totalCost=");
        m3.append(i17);
        m3.append(" stepCost=");
        m3.append(i16);
        kLog.d("QQFTTransferSizeInterpolation", m3.toString());
        return i17;
    }
}
