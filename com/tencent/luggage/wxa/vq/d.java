package com.tencent.luggage.wxa.vq;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.remotedebug.XWebRemoteDebugService;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static void a() {
        if (p0.a()) {
            x0.d("XWebRemoteDebugHandler", "reset remote debug started to false");
            WebDebugCfg.getInst().setRemoteDebugStarted(false);
        }
    }

    public static void b() {
        if (p0.a()) {
            WebDebugCfg.getInst().setRemoteDebugToken(null);
            WebDebugCfg.getInst().setRemoteDebugStarted(false);
            XWalkEnvironment.getApplicationContext().stopService(new Intent(XWalkEnvironment.getApplicationContext(), (Class<?>) XWebRemoteDebugService.class));
            c.b();
        }
    }

    public static void c() {
        x0.d("XWebRemoteDebugHandler", "stopRemoteDebug, process:" + XWalkEnvironment.getProcessName());
        if (p0.a()) {
            x0.d("XWebRemoteDebugHandler", "stopRemoteDebug, main process ignored");
        } else {
            g.a(ConstValue.INVOKE_RUNTIME_ID_STOP_REMOTE_DEBUG, new Object[0]);
        }
    }

    public static void a(String str) {
        if (p0.a()) {
            WebDebugCfg.getInst().setRemoteDebugToken(str);
            WebDebugCfg.getInst().setRemoteDebugStarted(true);
            XWalkEnvironment.getApplicationContext().startService(new Intent(XWalkEnvironment.getApplicationContext(), (Class<?>) XWebRemoteDebugService.class));
            c.b(str);
        }
    }

    public static void b(String str) {
        x0.d("XWebRemoteDebugHandler", "startRemoteDebug, process:" + XWalkEnvironment.getProcessName() + ", token:" + str);
        if (TextUtils.isEmpty(str)) {
            x0.f("XWebRemoteDebugHandler", "startRemoteDebug, invalid token");
        } else if (p0.a()) {
            x0.d("XWebRemoteDebugHandler", "startRemoteDebug, main process ignored");
        } else {
            g.a(ConstValue.INVOKE_RUNTIME_ID_START_REMOTE_DEBUG, new Object[]{str});
        }
    }
}
