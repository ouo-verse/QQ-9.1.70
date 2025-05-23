package com.tencent.mtt.hippy.a.a.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.a.a.b.d;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d extends c implements Handler.Callback, d.a {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mtt.hippy.a.a.b.d f336915b;

    /* renamed from: c, reason: collision with root package name */
    private a f336916c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f336917d;

    /* renamed from: e, reason: collision with root package name */
    private int f336918e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class a extends BaseHandlerThread {

        /* renamed from: a, reason: collision with root package name */
        final Handler f336919a;

        /* compiled from: P */
        /* renamed from: com.tencent.mtt.hippy.a.a.a.d$a$1, reason: invalid class name */
        /* loaded from: classes20.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.super.quit();
            }
        }

        public a(Handler.Callback callback) {
            super("ScreenCastHandlerThread");
            setPriority(5);
            start();
            this.f336919a = new Handler(getLooper(), callback);
        }

        public Handler a() {
            return this.f336919a;
        }

        @Override // android.os.HandlerThread
        public boolean quit() {
            return super.quitSafely();
        }
    }

    public d(com.tencent.mtt.hippy.a.a.a aVar) {
        super(aVar);
        this.f336918e = -1;
        this.f336915b = new com.tencent.mtt.hippy.a.a.b.d();
    }

    public String a() {
        return "Page";
    }

    @Override // com.tencent.mtt.hippy.a.a.b.d.a
    public void b() {
        a aVar;
        this.f336917d = true;
        WeakReference<com.tencent.mtt.hippy.a.a.a> weakReference = this.f336913a;
        HippyEngineContext b16 = (weakReference == null || weakReference.get() == null || this.f336913a.get().b() == null) ? null : this.f336913a.get().b();
        if (b16 == null || (aVar = this.f336916c) == null || this.f336918e == -1) {
            return;
        }
        Handler a16 = aVar.a();
        if (a16.hasMessages(2)) {
            return;
        }
        Message obtainMessage = a16.obtainMessage(2);
        obtainMessage.obj = b16;
        obtainMessage.arg1 = this.f336918e;
        a16.sendMessageDelayed(obtainMessage, 200L);
        this.f336917d = false;
    }

    @Override // com.tencent.mtt.hippy.a.a.a.c
    public void c() {
        super.c();
        a aVar = this.f336916c;
        if (aVar != null) {
            aVar.quit();
            this.f336916c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        JSONObject jSONObject;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                JSONObject a16 = this.f336915b.a((HippyEngineContext) message.obj, message.arg1);
                if (a16 != null) {
                    a(new com.tencent.mtt.hippy.a.a.b.c("Page.screencastFrame", a16));
                    return false;
                }
                return false;
            }
            return false;
        }
        HippyEngineContext hippyEngineContext = (HippyEngineContext) message.obj;
        Bundle data = message.getData();
        if (data != null) {
            try {
                jSONObject = new JSONObject(data.getString("params"));
            } catch (Exception e16) {
                LogUtils.e("PageDomain", "handleMessage, MSG_START_SCREEN_CAST paramObj parse exception=", e16);
            }
            a(new com.tencent.mtt.hippy.a.a.b.c("Page.screencastFrame", this.f336915b.a(hippyEngineContext, jSONObject)));
            if (!this.f336915b.a()) {
                this.f336915b.a(this);
                return false;
            }
            return false;
        }
        jSONObject = null;
        a(new com.tencent.mtt.hippy.a.a.b.c("Page.screencastFrame", this.f336915b.a(hippyEngineContext, jSONObject)));
        if (!this.f336915b.a()) {
        }
    }

    private void b(HippyEngineContext hippyEngineContext) {
        this.f336915b.a(hippyEngineContext);
        a aVar = this.f336916c;
        if (aVar != null) {
            Handler a16 = aVar.a();
            a16.removeMessages(1);
            a16.removeMessages(2);
        }
    }

    @Override // com.tencent.mtt.hippy.a.a.a.c
    public void a(HippyEngineContext hippyEngineContext) {
        b(hippyEngineContext);
        this.f336915b.b();
    }

    private void a(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        if (this.f336916c == null) {
            this.f336916c = new a(this);
        }
        Handler a16 = this.f336916c.a();
        Message obtainMessage = a16.obtainMessage(1);
        obtainMessage.obj = hippyEngineContext;
        if (jSONObject != null) {
            Bundle bundle = new Bundle();
            bundle.putString("params", jSONObject.toString());
            obtainMessage.setData(bundle);
        }
        a16.sendMessage(obtainMessage);
    }

    private void a(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        if (this.f336916c == null || jSONObject == null) {
            return;
        }
        if (!this.f336915b.a()) {
            Handler a16 = this.f336916c.a();
            Message obtainMessage = a16.obtainMessage(2);
            obtainMessage.obj = hippyEngineContext;
            obtainMessage.arg1 = jSONObject.optInt("sessionId");
            a16.removeMessages(2);
            a16.sendMessageDelayed(obtainMessage, 1000L);
            return;
        }
        int optInt = jSONObject.optInt("sessionId");
        if (!this.f336917d) {
            this.f336918e = optInt;
            return;
        }
        Handler a17 = this.f336916c.a();
        Message obtainMessage2 = a17.obtainMessage(2);
        obtainMessage2.obj = hippyEngineContext;
        obtainMessage2.arg1 = optInt;
        a17.removeMessages(2);
        a17.sendMessageDelayed(obtainMessage2, 200L);
        this.f336917d = false;
    }

    @Override // com.tencent.mtt.hippy.a.a.a.c
    public boolean a(HippyEngineContext hippyEngineContext, String str, int i3, JSONObject jSONObject) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -256576857:
                if (str.equals("screencastFrameAck")) {
                    c16 = 0;
                    break;
                }
                break;
            case 1483355053:
                if (str.equals("startScreencast")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1645047629:
                if (str.equals("stopScreencast")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                a(hippyEngineContext, jSONObject);
                return true;
            case 1:
                a(hippyEngineContext, i3, jSONObject);
                return true;
            case 2:
                b(hippyEngineContext);
                return true;
            default:
                return false;
        }
    }
}
