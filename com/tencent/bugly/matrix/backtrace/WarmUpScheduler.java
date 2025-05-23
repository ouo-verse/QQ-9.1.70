package com.tencent.bugly.matrix.backtrace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;
import com.tencent.bugly.matrix.util.MatrixLog;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WarmUpScheduler implements Handler.Callback {
    static final long DELAY_CLEAN_UP = 3000;
    static final long DELAY_CONSUME_REQ_QUT = 3000;
    static final long DELAY_SHORTLY = 3000;
    static final long DELAY_WARM_UP = 3000;
    private static final int MSG_CLEAN_UP = 3;
    private static final int MSG_COMPUTE_DISK_USAGE = 4;
    private static final int MSG_CONSUME_REQ_QUT = 2;
    private static final int MSG_WARM_UP = 1;
    private static final String TAG = "Matrix.WarmUpScheduler";
    private Context mContext;
    private WarmUpDelegate mDelegate;
    private Handler mHandler;
    private IdleReceiver mIdleReceiver;
    private WeChatBacktrace.WarmUpTiming mTiming;
    private long mWarmUpDelay;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.bugly.matrix.backtrace.WarmUpScheduler$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$bugly$matrix$backtrace$WarmUpScheduler$TaskType;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$WarmUpTiming;

        static {
            int[] iArr = new int[TaskType.values().length];
            $SwitchMap$com$tencent$bugly$matrix$backtrace$WarmUpScheduler$TaskType = iArr;
            try {
                iArr[TaskType.WarmUp.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WarmUpScheduler$TaskType[TaskType.CleanUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WarmUpScheduler$TaskType[TaskType.RequestConsuming.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WarmUpScheduler$TaskType[TaskType.DiskUsage.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[WeChatBacktrace.WarmUpTiming.values().length];
            $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$WarmUpTiming = iArr2;
            try {
                iArr2[WeChatBacktrace.WarmUpTiming.PostStartup.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$WarmUpTiming[WeChatBacktrace.WarmUpTiming.WhileCharging.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$WarmUpTiming[WeChatBacktrace.WarmUpTiming.WhileScreenOff.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class IdleReceiver extends BroadcastReceiver {
        private CancellationSignal mCancellationSignal;
        Context mContext;
        Handler mIdleHandler;
        private final Set<TaskType> mTasks = new HashSet();
        private final WeChatBacktrace.WarmUpTiming mTiming;
        private final long mWarmUpDelay;

        IdleReceiver(Context context, Handler handler, WeChatBacktrace.WarmUpTiming warmUpTiming, long j3) {
            this.mContext = context;
            this.mIdleHandler = handler;
            this.mTiming = warmUpTiming;
            this.mWarmUpDelay = j3;
        }

        private synchronized void triggerIdle(boolean z16, boolean z17) {
            boolean z18;
            MatrixLog.i(WarmUpScheduler.TAG, "Idle status changed: interactive = %s, charging = %s", Boolean.valueOf(z16), Boolean.valueOf(z17));
            if (!z16 && (this.mTiming == WeChatBacktrace.WarmUpTiming.WhileScreenOff || !z17)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 && this.mCancellationSignal == null) {
                this.mCancellationSignal = new CancellationSignal();
                Iterator<TaskType> it = this.mTasks.iterator();
                while (it.hasNext()) {
                    int i3 = AnonymousClass2.$SwitchMap$com$tencent$bugly$matrix$backtrace$WarmUpScheduler$TaskType[it.next().ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    if (WarmUpUtility.shouldComputeDiskUsage(this.mContext)) {
                                        Handler handler = this.mIdleHandler;
                                        handler.sendMessageDelayed(Message.obtain(handler, 4, this.mCancellationSignal), 3000L);
                                    } else {
                                        it.remove();
                                    }
                                    MatrixLog.i(WarmUpScheduler.TAG, "System idle, trigger disk usage in %s seconds.", 3L);
                                }
                            } else {
                                Handler handler2 = this.mIdleHandler;
                                handler2.sendMessageDelayed(Message.obtain(handler2, 2, this.mCancellationSignal), this.mWarmUpDelay);
                                MatrixLog.i(WarmUpScheduler.TAG, "System idle, trigger consume requested qut in %s seconds.", Long.valueOf(this.mWarmUpDelay / 1000));
                            }
                        } else {
                            if (WarmUpUtility.needCleanUp(this.mContext)) {
                                Handler handler3 = this.mIdleHandler;
                                handler3.sendMessageDelayed(Message.obtain(handler3, 3, this.mCancellationSignal), 3000L);
                            } else {
                                it.remove();
                            }
                            MatrixLog.i(WarmUpScheduler.TAG, "System idle, trigger clean up in %s seconds.", 3L);
                        }
                    } else if (!WarmUpUtility.hasWarmedUp(this.mContext)) {
                        Handler handler4 = this.mIdleHandler;
                        handler4.sendMessageDelayed(Message.obtain(handler4, 1, this.mCancellationSignal), this.mWarmUpDelay);
                        MatrixLog.i(WarmUpScheduler.TAG, "System idle, trigger warm up in %s seconds.", Long.valueOf(this.mWarmUpDelay / 1000));
                    } else {
                        it.remove();
                    }
                }
            } else if (!z18 && this.mCancellationSignal != null) {
                this.mIdleHandler.removeMessages(1);
                this.mIdleHandler.removeMessages(2);
                this.mIdleHandler.removeMessages(3);
                this.mIdleHandler.removeMessages(4);
                this.mCancellationSignal.cancel();
                this.mCancellationSignal = null;
                MatrixLog.i(WarmUpScheduler.TAG, "Exit idle state, task cancelled.", new Object[0]);
            }
        }

        synchronized void arrange(TaskType taskType) {
            if (this.mTasks.contains(taskType)) {
                return;
            }
            this.mTasks.add(taskType);
        }

        synchronized int finish(TaskType taskType) {
            this.mTasks.remove(taskType);
            return this.mTasks.size();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            char c16;
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            synchronized (this) {
                boolean z16 = true;
                boolean z17 = false;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                            c16 = 1;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            c16 = 3;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case -1454123155:
                        if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                            c16 = 0;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            c16 = 2;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    default:
                        c16 = '\uffff';
                        break;
                }
                if (c16 != 0) {
                    if (c16 == 1 || c16 != 2) {
                        z16 = false;
                    } else {
                        z17 = true;
                        z16 = false;
                    }
                }
                triggerIdle(z16, z17);
            }
        }

        synchronized void refreshIdleStatus(Context context) {
            int intExtra;
            boolean isInteractive = ((PowerManager) context.getSystemService("power")).isInteractive();
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z16 = false;
            if (registerReceiver != null && ((intExtra = registerReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5)) {
                z16 = true;
            }
            triggerIdle(isInteractive, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum TaskType {
        WarmUp,
        CleanUp,
        RequestConsuming,
        DiskUsage
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WarmUpScheduler(WarmUpDelegate warmUpDelegate, Context context, WeChatBacktrace.WarmUpTiming warmUpTiming, long j3) {
        this.mWarmUpDelay = 0L;
        this.mDelegate = warmUpDelegate;
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
        this.mContext = context;
        this.mTiming = warmUpTiming;
        this.mWarmUpDelay = Math.max(j3, 3000L);
    }

    private void arrangeTaskDirectly(TaskType taskType) {
        int i3 = AnonymousClass2.$SwitchMap$com$tencent$bugly$matrix$backtrace$WarmUpScheduler$TaskType[taskType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    MatrixLog.i(TAG, "Schedule request consuming in %ss", Long.valueOf(this.mWarmUpDelay / 1000));
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(Message.obtain(handler, 2, new CancellationSignal()), this.mWarmUpDelay);
                    return;
                }
                return;
            }
            MatrixLog.i(TAG, "Schedule clean-up in %ss", Long.valueOf(this.mWarmUpDelay / 1000));
            Handler handler2 = this.mHandler;
            handler2.sendMessageDelayed(Message.obtain(handler2, 3, new CancellationSignal()), this.mWarmUpDelay);
            return;
        }
        MatrixLog.i(TAG, "Schedule warm-up in %ss", Long.valueOf(this.mWarmUpDelay / 1000));
        Handler handler3 = this.mHandler;
        handler3.sendMessageDelayed(Message.obtain(handler3, 1, new CancellationSignal()), this.mWarmUpDelay);
    }

    private synchronized void arrangeTaskToIdleReceiver(Context context, TaskType taskType) {
        IdleReceiver idleReceiver = this.mIdleReceiver;
        if (idleReceiver == null) {
            IdleReceiver idleReceiver2 = new IdleReceiver(context, this.mHandler, this.mTiming, this.mWarmUpDelay);
            this.mIdleReceiver = idleReceiver2;
            idleReceiver2.arrange(taskType);
            MatrixLog.i(TAG, "Register idle receiver.", new Object[0]);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            context.registerReceiver(this.mIdleReceiver, intentFilter);
            this.mIdleReceiver.refreshIdleStatus(context);
            return;
        }
        idleReceiver.arrange(taskType);
    }

    private synchronized void finishTaskToIdleReceiver(Context context, TaskType taskType) {
        IdleReceiver idleReceiver = this.mIdleReceiver;
        if (idleReceiver != null && idleReceiver.finish(taskType) == 0) {
            MatrixLog.i(TAG, "Unregister idle receiver.", new Object[0]);
            context.unregisterReceiver(this.mIdleReceiver);
            this.mIdleReceiver = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.mDelegate.computeDiskUsage((CancellationSignal) message.obj);
                        return false;
                    }
                    return false;
                }
                this.mDelegate.cleaningUp((CancellationSignal) message.obj);
                return false;
            }
            this.mDelegate.consumingRequestedQut((CancellationSignal) message.obj);
            return false;
        }
        this.mDelegate.warmingUp((CancellationSignal) message.obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleTask(final TaskType taskType) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpScheduler.1
            @Override // java.lang.Runnable
            public void run() {
                WarmUpScheduler.this.scheduleTaskImpl(taskType);
            }
        });
    }

    void scheduleTaskImpl(TaskType taskType) {
        int i3 = AnonymousClass2.$SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$WarmUpTiming[this.mTiming.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                arrangeTaskToIdleReceiver(this.mContext, taskType);
                return;
            }
            return;
        }
        arrangeTaskDirectly(taskType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void taskFinished(TaskType taskType) {
        int i3 = AnonymousClass2.$SwitchMap$com$tencent$bugly$matrix$backtrace$WeChatBacktrace$WarmUpTiming[this.mTiming.ordinal()];
        if (i3 == 2 || i3 == 3) {
            finishTaskToIdleReceiver(this.mContext, taskType);
        }
    }
}
