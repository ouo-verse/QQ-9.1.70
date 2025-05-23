package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TouchEventSender {
    private static final String TAG = "TouchEventSender";
    private static final int THRESHOLD_INTERPOLATE = 2;
    public static boolean isEnableTouchInterpolate;
    private final long halfRefreshPeriod;
    private List<MobileButtonEvent> lastTouchMoveEvents;
    private final ScheduledExecutorService periodTouchExecutorService;
    private float refreshRate;
    private ScheduledFuture<?> secondBatchSendFuture;
    private final Sender sender;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Sender {
        void send(int i3, List<MobileButtonEvent> list);
    }

    public TouchEventSender(Context context, @NonNull Sender sender) {
        this.refreshRate = 60.0f;
        float refreshRate = ((DisplayManager) context.getSystemService("display")).getDisplay(0).getMode().getRefreshRate();
        this.refreshRate = refreshRate;
        float f16 = 1000.0f / refreshRate;
        long j3 = f16 / 2.0f;
        this.halfRefreshPeriod = j3;
        this.sender = sender;
        this.periodTouchExecutorService = ProxyExecutors.newScheduledThreadPool(1);
        CGLog.i(CGStringUtil.format("refreshRate: %.2f, refreshPeriod: %.2f, HalfRefreshPeriod: %d", Float.valueOf(this.refreshRate), Float.valueOf(f16), Long.valueOf(j3)));
    }

    @Nullable
    private MobileButtonEvent findMoveEventAtLast(long j3) {
        List<MobileButtonEvent> list = this.lastTouchMoveEvents;
        if (list == null) {
            return null;
        }
        for (MobileButtonEvent mobileButtonEvent : list) {
            if (mobileButtonEvent.pId == j3) {
                return mobileButtonEvent;
            }
        }
        return null;
    }

    @Nullable
    private Pair<List<MobileButtonEvent>, List<MobileButtonEvent>> generateBatchMoveEvents(List<MobileButtonEvent> list) {
        if (list == null) {
            return null;
        }
        if (this.lastTouchMoveEvents == null) {
            this.lastTouchMoveEvents = list;
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MobileButtonEvent mobileButtonEvent : list) {
            MobileButtonEvent findMoveEventAtLast = findMoveEventAtLast(mobileButtonEvent.pId);
            if (findMoveEventAtLast == null) {
                arrayList2.add(mobileButtonEvent);
            } else if (Math.abs(mobileButtonEvent.pX - findMoveEventAtLast.pX) < 2 && Math.abs(mobileButtonEvent.pY - findMoveEventAtLast.pY) < 2) {
                arrayList.add(mobileButtonEvent);
            } else {
                MobileButtonEvent mobileButtonEvent2 = new MobileButtonEvent();
                mobileButtonEvent2.msgType = mobileButtonEvent.msgType;
                mobileButtonEvent2.buttonType = mobileButtonEvent.buttonType;
                mobileButtonEvent2.pX = (short) ((findMoveEventAtLast.pX + mobileButtonEvent.pX) / 2);
                mobileButtonEvent2.pY = (short) ((findMoveEventAtLast.pY + mobileButtonEvent.pY) / 2);
                mobileButtonEvent2.pId = mobileButtonEvent.pId;
                mobileButtonEvent2.pLast = false;
                arrayList.add(mobileButtonEvent2);
                arrayList2.add(mobileButtonEvent);
            }
        }
        List<MobileButtonEvent> lastForTouchEvents = setLastForTouchEvents(arrayList);
        List<MobileButtonEvent> lastForTouchEvents2 = setLastForTouchEvents(arrayList2);
        this.lastTouchMoveEvents = list;
        return new Pair<>(lastForTouchEvents, lastForTouchEvents2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$send$0(int i3, Pair pair) {
        this.sender.send(i3, (List) pair.second);
    }

    private void printSendTouchEvents(String str, List<MobileButtonEvent> list) {
        CGLog.i(str);
        for (MobileButtonEvent mobileButtonEvent : list) {
            CGLog.i(((int) mobileButtonEvent.pX) + ", " + ((int) mobileButtonEvent.pY) + ", " + mobileButtonEvent.pLast);
        }
    }

    @Nullable
    private List<MobileButtonEvent> setLastForTouchEvents(@Nullable List<MobileButtonEvent> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            MobileButtonEvent mobileButtonEvent = list.get(i3);
            if (i3 == size - 1) {
                if (!mobileButtonEvent.pLast) {
                    mobileButtonEvent.pLast = true;
                }
            } else if (mobileButtonEvent.pLast) {
                mobileButtonEvent.pLast = false;
            }
        }
        return list;
    }

    public void send(final int i3, List<MobileButtonEvent> list) {
        if (!isEnableTouchInterpolate) {
            CGLog.d("\u7981\u7528\u89e6\u6478\u63d2\u503c");
            this.sender.send(i3, list);
            return;
        }
        if (this.refreshRate > 100.0f) {
            this.sender.send(i3, list);
            return;
        }
        if (i3 != 82) {
            ScheduledFuture<?> scheduledFuture = this.secondBatchSendFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.secondBatchSendFuture = null;
            }
            this.lastTouchMoveEvents = null;
            this.sender.send(i3, list);
            return;
        }
        final Pair<List<MobileButtonEvent>, List<MobileButtonEvent>> generateBatchMoveEvents = generateBatchMoveEvents(list);
        if (generateBatchMoveEvents == null) {
            this.sender.send(i3, list);
            return;
        }
        if (!((List) generateBatchMoveEvents.first).isEmpty()) {
            this.sender.send(i3, (List) generateBatchMoveEvents.first);
        }
        if (!((List) generateBatchMoveEvents.second).isEmpty()) {
            this.secondBatchSendFuture = this.periodTouchExecutorService.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.d
                @Override // java.lang.Runnable
                public final void run() {
                    TouchEventSender.this.lambda$send$0(i3, generateBatchMoveEvents);
                }
            }, this.halfRefreshPeriod, TimeUnit.MILLISECONDS);
        }
    }

    public void stop() {
        this.periodTouchExecutorService.shutdownNow();
    }
}
