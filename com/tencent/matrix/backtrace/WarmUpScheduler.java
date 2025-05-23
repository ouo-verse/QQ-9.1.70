package com.tencent.matrix.backtrace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.matrix.backtrace.WeChatBacktrace;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WarmUpScheduler implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private b f151395d;

    /* renamed from: e, reason: collision with root package name */
    private WarmUpDelegate f151396e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f151397f;

    /* renamed from: h, reason: collision with root package name */
    private Context f151398h;

    /* renamed from: i, reason: collision with root package name */
    private WeChatBacktrace.WarmUpTiming f151399i;

    /* renamed from: m, reason: collision with root package name */
    private long f151400m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum TaskType {
        WarmUp,
        CleanUp,
        RequestConsuming,
        DiskUsage
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f151402a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f151403b;

        static {
            int[] iArr = new int[TaskType.values().length];
            f151403b = iArr;
            try {
                iArr[TaskType.WarmUp.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f151403b[TaskType.CleanUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f151403b[TaskType.RequestConsuming.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f151403b[TaskType.DiskUsage.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[WeChatBacktrace.WarmUpTiming.values().length];
            f151402a = iArr2;
            try {
                iArr2[WeChatBacktrace.WarmUpTiming.PostStartup.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f151402a[WeChatBacktrace.WarmUpTiming.WhileCharging.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f151402a[WeChatBacktrace.WarmUpTiming.WhileScreenOff.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private CancellationSignal f151404a;

        /* renamed from: b, reason: collision with root package name */
        Handler f151405b;

        /* renamed from: c, reason: collision with root package name */
        Context f151406c;

        /* renamed from: d, reason: collision with root package name */
        private final WeChatBacktrace.WarmUpTiming f151407d;

        /* renamed from: e, reason: collision with root package name */
        private final long f151408e;

        /* renamed from: f, reason: collision with root package name */
        private final Set<TaskType> f151409f = new HashSet();

        b(Context context, Handler handler, WeChatBacktrace.WarmUpTiming warmUpTiming, long j3) {
            this.f151406c = context;
            this.f151405b = handler;
            this.f151407d = warmUpTiming;
            this.f151408e = j3;
        }

        private synchronized void d(boolean z16, boolean z17) {
            boolean z18;
            g51.b.c("Matrix.WarmUpScheduler", "Idle status changed: interactive = %s, charging = %s", Boolean.valueOf(z16), Boolean.valueOf(z17));
            if (!z16 && (this.f151407d == WeChatBacktrace.WarmUpTiming.WhileScreenOff || !z17)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 && this.f151404a == null) {
                this.f151404a = new CancellationSignal();
                Iterator<TaskType> it = this.f151409f.iterator();
                while (it.hasNext()) {
                    int i3 = a.f151403b[it.next().ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    if (c.m(this.f151406c)) {
                                        Handler handler = this.f151405b;
                                        handler.sendMessageDelayed(Message.obtain(handler, 4, this.f151404a), 3000L);
                                    } else {
                                        it.remove();
                                    }
                                    g51.b.c("Matrix.WarmUpScheduler", "System idle, trigger disk usage in %s seconds.", 3L);
                                }
                            } else {
                                Handler handler2 = this.f151405b;
                                handler2.sendMessageDelayed(Message.obtain(handler2, 2, this.f151404a), this.f151408e);
                                g51.b.c("Matrix.WarmUpScheduler", "System idle, trigger consume requested qut in %s seconds.", Long.valueOf(this.f151408e / 1000));
                            }
                        } else {
                            if (c.i(this.f151406c)) {
                                Handler handler3 = this.f151405b;
                                handler3.sendMessageDelayed(Message.obtain(handler3, 3, this.f151404a), 3000L);
                            } else {
                                it.remove();
                            }
                            g51.b.c("Matrix.WarmUpScheduler", "System idle, trigger clean up in %s seconds.", 3L);
                        }
                    } else if (!c.e(this.f151406c)) {
                        Handler handler4 = this.f151405b;
                        handler4.sendMessageDelayed(Message.obtain(handler4, 1, this.f151404a), this.f151408e);
                        g51.b.c("Matrix.WarmUpScheduler", "System idle, trigger warm up in %s seconds.", Long.valueOf(this.f151408e / 1000));
                    } else {
                        it.remove();
                    }
                }
            } else if (!z18 && this.f151404a != null) {
                this.f151405b.removeMessages(1);
                this.f151405b.removeMessages(2);
                this.f151405b.removeMessages(3);
                this.f151405b.removeMessages(4);
                this.f151404a.cancel();
                this.f151404a = null;
                g51.b.c("Matrix.WarmUpScheduler", "Exit idle state, task cancelled.", new Object[0]);
            }
        }

        synchronized void a(TaskType taskType) {
            if (this.f151409f.contains(taskType)) {
                return;
            }
            this.f151409f.add(taskType);
        }

        synchronized int b(TaskType taskType) {
            this.f151409f.remove(taskType);
            return this.f151409f.size();
        }

        synchronized void c(Context context) {
            int intExtra;
            boolean isInteractive = ((PowerManager) context.getSystemService("power")).isInteractive();
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z16 = false;
            if (registerReceiver != null && ((intExtra = registerReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5)) {
                z16 = true;
            }
            d(isInteractive, z16);
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
                d(z16, z17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WarmUpScheduler(WarmUpDelegate warmUpDelegate, Context context, WeChatBacktrace.WarmUpTiming warmUpTiming, long j3) {
        this.f151400m = 0L;
        this.f151396e = warmUpDelegate;
        if (this.f151397f == null) {
            this.f151397f = new Handler(Looper.getMainLooper(), this);
        }
        this.f151398h = context;
        this.f151399i = warmUpTiming;
        this.f151400m = Math.max(j3, 3000L);
    }

    private void a(TaskType taskType) {
        int i3 = a.f151403b[taskType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    g51.b.c("Matrix.WarmUpScheduler", "Schedule request consuming in %ss", Long.valueOf(this.f151400m / 1000));
                    Handler handler = this.f151397f;
                    handler.sendMessageDelayed(Message.obtain(handler, 2, new CancellationSignal()), this.f151400m);
                    return;
                }
                return;
            }
            g51.b.c("Matrix.WarmUpScheduler", "Schedule clean-up in %ss", Long.valueOf(this.f151400m / 1000));
            Handler handler2 = this.f151397f;
            handler2.sendMessageDelayed(Message.obtain(handler2, 3, new CancellationSignal()), this.f151400m);
            return;
        }
        g51.b.c("Matrix.WarmUpScheduler", "Schedule warm-up in %ss", Long.valueOf(this.f151400m / 1000));
        Handler handler3 = this.f151397f;
        handler3.sendMessageDelayed(Message.obtain(handler3, 1, new CancellationSignal()), this.f151400m);
    }

    private synchronized void b(Context context, TaskType taskType) {
        b bVar = this.f151395d;
        if (bVar == null) {
            b bVar2 = new b(context, this.f151397f, this.f151399i, this.f151400m);
            this.f151395d = bVar2;
            bVar2.a(taskType);
            g51.b.c("Matrix.WarmUpScheduler", "Register idle receiver.", new Object[0]);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            context.registerReceiver(this.f151395d, intentFilter);
            this.f151395d.c(context);
            return;
        }
        bVar.a(taskType);
    }

    private synchronized void c(Context context, TaskType taskType) {
        b bVar = this.f151395d;
        if (bVar != null && bVar.b(taskType) == 0) {
            g51.b.c("Matrix.WarmUpScheduler", "Unregister idle receiver.", new Object[0]);
            context.unregisterReceiver(this.f151395d);
            this.f151395d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(final TaskType taskType) {
        this.f151397f.post(new Runnable() { // from class: com.tencent.matrix.backtrace.WarmUpScheduler.1
            @Override // java.lang.Runnable
            public void run() {
                WarmUpScheduler.this.e(taskType);
            }
        });
    }

    void e(TaskType taskType) {
        int i3 = a.f151402a[this.f151399i.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                b(this.f151398h, taskType);
                return;
            }
            return;
        }
        a(taskType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(TaskType taskType) {
        int i3 = a.f151402a[this.f151399i.ordinal()];
        if (i3 == 2 || i3 == 3) {
            c(this.f151398h, taskType);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.f151396e.l((CancellationSignal) message.obj);
                        return false;
                    }
                    return false;
                }
                this.f151396e.k((CancellationSignal) message.obj);
                return false;
            }
            this.f151396e.m((CancellationSignal) message.obj);
            return false;
        }
        this.f151396e.w((CancellationSignal) message.obj);
        return false;
    }
}
