package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f extends BaseThread {

    /* renamed from: a, reason: collision with root package name */
    public Context f422888a;

    public f(Context context) {
        this.f422888a = context;
        setName("Wtlogin_CleanThread");
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        util.deleteExpireLog(this.f422888a);
    }
}
