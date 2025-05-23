package com.tencent.mtt.hippy.modules.nativemodules.timer;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyEngineLifecycleEventListener;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
@HippyNativeModule(name = "TimerModule")
/* loaded from: classes20.dex */
public class TimerModule extends HippyNativeModuleBase implements Handler.Callback, HippyEngineLifecycleEventListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean f337538a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, a> f337539b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f337540c;

    /* renamed from: d, reason: collision with root package name */
    private long f337541d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final String f337544a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f337545b;

        /* renamed from: c, reason: collision with root package name */
        final int f337546c;

        /* renamed from: d, reason: collision with root package name */
        long f337547d;

        /* renamed from: e, reason: collision with root package name */
        final Promise f337548e;

        a(String str, long j3, int i3, boolean z16, Promise promise) {
            this.f337544a = str;
            this.f337547d = j3;
            this.f337546c = i3;
            this.f337545b = z16;
            this.f337548e = promise;
        }
    }

    public TimerModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337538a = false;
        this.f337539b = new HashMap<>();
        this.f337541d = 0L;
        hippyEngineContext.addEngineLifecycleEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f337541d = 0L;
        this.f337540c.removeMessages(100);
    }

    @HippyMethod(name = "clearInterval")
    public void clearInterval(String str) {
        this.f337539b.remove(str);
        a((a) null);
    }

    @HippyMethod(name = "clearTimeout")
    public void clearTimeout(String str) {
        this.f337539b.remove(str);
        a((a) null);
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        this.f337539b.clear();
        a();
        this.mContext.removeEngineLifecycleEventListener(this);
        super.destroy();
    }

    public void doFrame() {
        a value;
        this.f337541d = 0L;
        this.f337540c.removeMessages(100);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f337539b.entrySet().iterator();
        a aVar = null;
        while (it.hasNext()) {
            Map.Entry<String, a> next = it.next();
            if (next != null && (value = next.getValue()) != null) {
                long j3 = value.f337547d;
                int i3 = value.f337546c;
                if (i3 + j3 <= elapsedRealtime) {
                    Promise promise = value.f337548e;
                    if (promise != null) {
                        promise.resolve(null);
                    }
                    if (!value.f337545b) {
                        it.remove();
                    } else {
                        value.f337547d = elapsedRealtime;
                        if (aVar != null && value.f337546c + elapsedRealtime >= aVar.f337547d + aVar.f337546c) {
                        }
                        aVar = value;
                    }
                } else {
                    if (aVar != null && j3 + i3 >= aVar.f337547d + aVar.f337546c) {
                    }
                    aVar = value;
                }
            }
        }
        a(aVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 100) {
            doFrame();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void initialize() {
        this.f337540c = new Handler(this.mContext.getThreadExecutor().getJsBridgeThread().getLooper(), this);
    }

    @Override // com.tencent.mtt.hippy.HippyEngineLifecycleEventListener
    public void onEnginePause() {
        Handler handler = this.f337540c;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.mtt.hippy.modules.nativemodules.timer.TimerModule.2
                @Override // java.lang.Runnable
                public void run() {
                    TimerModule.this.f337538a = true;
                    TimerModule.this.a();
                }
            });
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngineLifecycleEventListener
    public void onEngineResume() {
        Handler handler = this.f337540c;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.mtt.hippy.modules.nativemodules.timer.TimerModule.1
                @Override // java.lang.Runnable
                public void run() {
                    TimerModule.this.f337538a = false;
                    TimerModule.this.doFrame();
                }
            });
        }
    }

    @HippyMethod(name = "setInterval")
    public void setInterval(int i3, String str, Promise promise) {
        a aVar = new a(str, SystemClock.elapsedRealtime(), i3, true, promise);
        this.f337539b.put(str, aVar);
        a(aVar);
    }

    @HippyMethod(name = "setTimeout")
    public void setTimeout(int i3, String str, Promise promise) {
        a aVar = new a(str, SystemClock.elapsedRealtime(), i3, false, promise);
        this.f337539b.put(str, aVar);
        a(aVar);
    }

    private void a(a aVar) {
        long elapsedRealtime;
        if (this.f337538a || this.f337539b.isEmpty()) {
            a();
            return;
        }
        if (aVar != null) {
            long j3 = this.f337541d;
            if (j3 == 0 || aVar.f337547d + aVar.f337546c < j3) {
                long j16 = aVar.f337547d + aVar.f337546c;
                this.f337541d = j16;
                if (j16 < 0) {
                    this.f337541d = SystemClock.elapsedRealtime();
                    elapsedRealtime = 0;
                } else {
                    elapsedRealtime = j16 - SystemClock.elapsedRealtime();
                }
                this.f337540c.removeMessages(100);
                this.f337540c.sendEmptyMessageDelayed(100, elapsedRealtime > 0 ? elapsedRealtime : 0L);
            }
        }
    }
}
