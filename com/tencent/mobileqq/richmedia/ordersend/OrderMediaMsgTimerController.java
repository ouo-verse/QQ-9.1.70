package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OrderMediaMsgTimerController implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private a f281609d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f281610e = new Handler(Looper.getMainLooper(), null);

    /* renamed from: f, reason: collision with root package name */
    private Handler f281611f = new Handler(ThreadManagerV2.getSubThreadLooper(), this);

    /* renamed from: h, reason: collision with root package name */
    private Runnable f281612h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f281613i;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<Long, Runnable> f281614m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(long j3);

        void b(Object obj);

        void c(long j3);

        void d(long j3, int i3, int i16);
    }

    public OrderMediaMsgTimerController(a aVar) {
        this.f281609d = aVar;
    }

    public void b(final long j3, final int i3, final int i16) {
        if (this.f281614m == null) {
            this.f281614m = new HashMap<>();
        }
        if (this.f281614m.containsKey(Long.valueOf(j3))) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.4
            @Override // java.lang.Runnable
            public void run() {
                if (OrderMediaMsgTimerController.this.f281611f != null) {
                    Message obtainMessage = OrderMediaMsgTimerController.this.f281611f.obtainMessage(102);
                    obtainMessage.obj = Long.valueOf(j3);
                    obtainMessage.arg1 = i3;
                    obtainMessage.arg2 = i16;
                    OrderMediaMsgTimerController.this.f281611f.sendMessage(obtainMessage);
                }
            }
        };
        this.f281610e.postDelayed(runnable, 30000L);
        this.f281614m.put(Long.valueOf(j3), runnable);
    }

    public Runnable c(final long j3) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.1
            @Override // java.lang.Runnable
            public void run() {
                if (OrderMediaMsgTimerController.this.f281611f != null) {
                    Message obtainMessage = OrderMediaMsgTimerController.this.f281611f.obtainMessage(100);
                    obtainMessage.obj = Long.valueOf(j3);
                    OrderMediaMsgTimerController.this.f281611f.sendMessage(obtainMessage);
                }
            }
        };
        this.f281610e.postDelayed(runnable, 8000L);
        return runnable;
    }

    public Runnable d(final String str) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.2
            @Override // java.lang.Runnable
            public void run() {
                if (OrderMediaMsgTimerController.this.f281611f != null) {
                    Message obtainMessage = OrderMediaMsgTimerController.this.f281611f.obtainMessage(100);
                    obtainMessage.obj = str;
                    OrderMediaMsgTimerController.this.f281611f.sendMessage(obtainMessage);
                }
            }
        };
        this.f281610e.postDelayed(runnable, 8000L);
        return runnable;
    }

    public boolean e(final long j3) {
        if (this.f281613i != null) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.5
            @Override // java.lang.Runnable
            public void run() {
                if (OrderMediaMsgTimerController.this.f281611f != null) {
                    Message obtainMessage = OrderMediaMsgTimerController.this.f281611f.obtainMessage(103);
                    obtainMessage.obj = Long.valueOf(j3);
                    OrderMediaMsgTimerController.this.f281611f.sendMessage(obtainMessage);
                }
            }
        };
        this.f281613i = runnable;
        this.f281610e.postDelayed(runnable, 30000L);
        return true;
    }

    public boolean f(final long j3) {
        if (this.f281612h != null) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.3
            @Override // java.lang.Runnable
            public void run() {
                if (OrderMediaMsgTimerController.this.f281611f != null) {
                    Message obtainMessage = OrderMediaMsgTimerController.this.f281611f.obtainMessage(101);
                    obtainMessage.obj = Long.valueOf(j3);
                    OrderMediaMsgTimerController.this.f281611f.sendMessage(obtainMessage);
                }
            }
        };
        this.f281612h = runnable;
        this.f281610e.postDelayed(runnable, 30000L);
        return true;
    }

    public void g() {
        HashMap<Long, Runnable> hashMap = this.f281614m;
        if (hashMap != null) {
            for (Runnable runnable : hashMap.values()) {
                Handler handler = this.f281610e;
                if (handler != null) {
                    handler.removeCallbacks(runnable);
                }
            }
            this.f281614m.clear();
            this.f281614m = null;
        }
        Handler handler2 = this.f281610e;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.f281610e = null;
        }
        Handler handler3 = this.f281611f;
        if (handler3 != null) {
            handler3.removeCallbacksAndMessages(null);
            this.f281611f = null;
        }
    }

    public void h(long j3) {
        HashMap<Long, Runnable> hashMap = this.f281614m;
        if (hashMap != null && hashMap.containsKey(Long.valueOf(j3))) {
            Handler handler = this.f281610e;
            if (handler != null) {
                handler.removeCallbacks(this.f281614m.get(Long.valueOf(j3)));
            }
            this.f281614m.remove(Long.valueOf(j3));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        long j3 = 0;
        switch (message.what) {
            case 100:
                Object obj = message.obj;
                if (obj != null && (aVar = this.f281609d) != null) {
                    aVar.b(obj);
                    return false;
                }
                return false;
            case 101:
                Object obj2 = message.obj;
                if (obj2 != null) {
                    j3 = ((Long) obj2).longValue();
                }
                a aVar2 = this.f281609d;
                if (aVar2 != null) {
                    aVar2.a(j3);
                    return false;
                }
                return false;
            case 102:
                Object obj3 = message.obj;
                if (obj3 != null) {
                    j3 = ((Long) obj3).longValue();
                }
                a aVar3 = this.f281609d;
                if (aVar3 != null) {
                    aVar3.d(j3, message.arg1, message.arg2);
                    return false;
                }
                return false;
            case 103:
                Object obj4 = message.obj;
                if (obj4 != null) {
                    j3 = ((Long) obj4).longValue();
                }
                a aVar4 = this.f281609d;
                if (aVar4 != null) {
                    aVar4.c(j3);
                    return false;
                }
                return false;
            default:
                return false;
        }
    }

    public void i(Runnable runnable) {
        Handler handler = this.f281610e;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void j() {
        Handler handler = this.f281610e;
        if (handler != null) {
            handler.removeCallbacks(this.f281613i);
            this.f281613i = null;
        }
    }

    public void k() {
        Handler handler = this.f281610e;
        if (handler != null) {
            handler.removeCallbacks(this.f281612h);
            this.f281612h = null;
        }
    }
}
