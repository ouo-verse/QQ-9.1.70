package com.tencent.biz.pubaccount.weishi.player;

import android.os.Looper;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

/* loaded from: classes32.dex */
public class WSPlayerForNetInfoHandler implements INetInfoHandler {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<WSPlayerManager> f81030d;

    public WSPlayerForNetInfoHandler(WSPlayerManager wSPlayerManager) {
        this.f81030d = new WeakReference<>(wSPlayerManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        x.j("WSPlayerForNetInfoHandler", "[handleConnectNetWorkChange] thread:" + Thread.currentThread());
        WSPlayerManager wSPlayerManager = this.f81030d.get();
        if (wSPlayerManager == null || wSPlayerManager.n0() == null) {
            return;
        }
        e n06 = wSPlayerManager.n0();
        if (!wSPlayerManager.H0() && !wSPlayerManager.z0()) {
            if (wSPlayerManager.G0()) {
                wSPlayerManager.X0();
                return;
            }
            return;
        }
        wSPlayerManager.L0(n06, false);
    }

    private void c() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerForNetInfoHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    WSPlayerForNetInfoHandler.this.b();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        x.b("WSPlayerForNetInfoHandler", "[onNetMobile2None] thread:" + Thread.currentThread());
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        x.b("WSPlayerForNetInfoHandler", "[onNetMobile2Wifi] s:" + str + ", thread:" + Thread.currentThread());
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        x.b("WSPlayerForNetInfoHandler", "[onNetNone2Mobile] s:" + str + ", thread:" + Thread.currentThread());
        c();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        x.b("WSPlayerForNetInfoHandler", "[onNetNone2Wifi] s:" + str + ", thread:" + Thread.currentThread());
        c();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        x.b("WSPlayerForNetInfoHandler", "[onNetWifi2Mobile] s:" + str + ", thread:" + Thread.currentThread());
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        x.b("WSPlayerForNetInfoHandler", "[onNetWifi2None] thread:" + Thread.currentThread());
    }
}
