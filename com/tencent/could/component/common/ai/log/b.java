package com.tencent.could.component.common.ai.log;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.tencent.could.component.common.ai.log.e;
import com.tencent.could.component.common.ai.utils.ThreadPoolUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public AiLogConfig f99952a;

    /* renamed from: b, reason: collision with root package name */
    public int f99953b;

    /* renamed from: c, reason: collision with root package name */
    public String f99954c;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Context> f99955d;

    /* renamed from: e, reason: collision with root package name */
    public c f99956e;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f99957f;

    public b(Context context, AiLogConfig aiLogConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aiLogConfig);
            return;
        }
        this.f99952a = aiLogConfig;
        this.f99953b = Process.myPid();
        this.f99954c = context.getPackageName();
        this.f99955d = new WeakReference<>(context);
        a(context);
    }

    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FileLogThread");
        this.f99957f = baseHandlerThread;
        baseHandlerThread.start();
        this.f99956e = new c(this.f99957f.getLooper(), this.f99952a, context);
        ThreadPoolUtil.getInstance().addWork(new a(this, this.f99952a.getDirLog()));
    }

    public void a(int i3, String str, String str2) {
        d acquire;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (this.f99952a.isOpen() && i3 >= this.f99952a.getMinLevel()) {
            if (this.f99952a.isLogCat()) {
                switch (i3) {
                    case 2:
                        Log.v(str, str2);
                        break;
                    case 3:
                        Log.d(str, str2);
                        break;
                    case 4:
                        Log.i(str, str2);
                        break;
                    case 5:
                        Log.w(str, str2);
                        break;
                    case 6:
                        Log.e(str, str2);
                        break;
                    case 7:
                        Log.wtf(str, str2);
                        break;
                    default:
                        Log.e(str, "do not know logLevel \uff01 msg: " + str2);
                        break;
                }
            }
            e eVar = e.a.f99970a;
            eVar.getClass();
            synchronized (e.class) {
                acquire = eVar.f99969a.acquire();
            }
            if (acquire == null) {
                acquire = new d(i3, str, str2);
            } else {
                acquire.f99964b = System.currentTimeMillis();
                acquire.f99963a = i3;
                acquire.f99965c = str;
                acquire.f99966d = str2;
            }
            long id5 = Thread.currentThread().getId();
            acquire.f99967e = this.f99953b + "-" + id5;
            acquire.f99968f = this.f99954c;
            c cVar = this.f99956e;
            if (cVar != null) {
                Message obtainMessage = cVar.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = acquire;
                cVar.sendMessage(obtainMessage);
            }
        }
    }
}
