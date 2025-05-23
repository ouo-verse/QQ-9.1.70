package com.tencent.timi.game.utils;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    private static volatile m f380306b;

    /* renamed from: a, reason: collision with root package name */
    private List<INetInfoHandler> f380307a = new CopyOnWriteArrayList();

    m() {
    }

    public static m a() {
        if (f380306b == null) {
            synchronized (m.class) {
                if (f380306b == null) {
                    f380306b = new m();
                }
            }
        }
        return f380306b;
    }

    public boolean b() {
        if (!AppNetConnInfo.isMobileConn() && !AppNetConnInfo.isWifiConn()) {
            return false;
        }
        return true;
    }

    public void c(INetInfoHandler iNetInfoHandler) {
        if (!this.f380307a.contains(iNetInfoHandler)) {
            this.f380307a.add(iNetInfoHandler);
            AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), iNetInfoHandler);
        }
    }

    public void d(INetInfoHandler iNetInfoHandler) {
        this.f380307a.remove(iNetInfoHandler);
        AppNetConnInfo.unregisterNetInfoHandler(iNetInfoHandler);
    }
}
