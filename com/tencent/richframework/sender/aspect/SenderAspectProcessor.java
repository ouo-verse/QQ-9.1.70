package com.tencent.richframework.sender.aspect;

import android.os.SystemClock;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.sender.util.EventControlUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
/* loaded from: classes25.dex */
public class SenderAspectProcessor {
    private static final String TAG = "SenderAspectProcessor";
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static /* synthetic */ SenderAspectProcessor ajc$perSingletonInstance;

    static {
        try {
            ajc$postClinit();
        } catch (Throwable th5) {
            ajc$initFailureCause = th5;
        }
    }

    private static /* synthetic */ void ajc$postClinit() {
        ajc$perSingletonInstance = new SenderAspectProcessor();
    }

    public static SenderAspectProcessor aspectOf() {
        SenderAspectProcessor senderAspectProcessor = ajc$perSingletonInstance;
        if (senderAspectProcessor != null) {
            return senderAspectProcessor;
        }
        throw new NoAspectBoundException("com.tencent.richframework.sender.aspect.SenderAspectProcessor", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        if (ajc$perSingletonInstance != null) {
            return true;
        }
        return false;
    }

    @Around("execution(@com.tencent.richframework.sender.aspect.ThrottlingDelay * *(..)) && @annotation(throttlingDelayParam)")
    public void doAroundThrottlingDelay(final ProceedingJoinPoint proceedingJoinPoint, ThrottlingDelay throttlingDelay) throws Throwable {
        if (throttlingDelay == null) {
            RFWLog.d(TAG, RFWLog.DEV, "throttlingDelayParam is null");
            return;
        }
        final String tag = throttlingDelay.tag();
        long timeInterval = throttlingDelay.timeInterval();
        Long lastTime = EventControlUtils.getLastTime(tag);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (lastTime == null || elapsedRealtime - lastTime.longValue() >= timeInterval) {
            EventControlUtils.setLastTime(tag, elapsedRealtime);
            Timer timer = EventControlUtils.getTimer(tag);
            if (timer != null) {
                timer.cancel();
            }
            BaseTimer baseTimer = new BaseTimer();
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.richframework.sender.aspect.SenderAspectProcessor.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        EventControlUtils.removeTimer(tag);
                        proceedingJoinPoint.proceed();
                        RFWLog.d(SenderAspectProcessor.TAG, RFWLog.DEV, "proceedingJoinPoint proceed()");
                    } catch (Throwable th5) {
                        RFWLog.e(SenderAspectProcessor.TAG, RFWLog.DEV, th5.getMessage());
                        th5.printStackTrace();
                    }
                }
            }, timeInterval);
            EventControlUtils.setTimer(tag, baseTimer);
        }
    }

    @Pointcut("@annotation(com.tencent.biz.qqcircle.aspectj.ThrottlingDelay)")
    public void pointCutThrottlingDelay() {
    }
}
