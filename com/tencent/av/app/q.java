package com.tencent.av.app;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class q implements INetInfoHandler {

    /* renamed from: d, reason: collision with root package name */
    private a f73196d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void onApnChanged(int i3);
    }

    public q(a aVar) {
        this.f73196d = aVar;
    }

    public static int a() {
        int i3;
        int i16 = 1;
        if (AppNetConnInfo.isWifiConn()) {
            i3 = 1;
        } else if (AppNetConnInfo.isMobileConn()) {
            i3 = AppNetConnInfo.getMobileInfo();
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            i16 = 100;
                        } else {
                            i16 = 14;
                        }
                    } else {
                        i16 = 11;
                    }
                } else {
                    i16 = 9;
                }
            } else {
                i16 = 3;
            }
        } else {
            i16 = 0;
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSFNetInfoMonitor", 2, "getApn: " + i16 + " mobileType:" + i3);
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        if (QLog.isColorLevel()) {
            QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2None");
        }
        a aVar = this.f73196d;
        if (aVar != null) {
            aVar.onApnChanged(0);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2Wifi");
        }
        a aVar = this.f73196d;
        if (aVar != null) {
            aVar.onApnChanged(1);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Mobile");
        }
        a aVar = this.f73196d;
        if (aVar != null) {
            aVar.onApnChanged(2);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Wifi");
        }
        a aVar = this.f73196d;
        if (aVar != null) {
            aVar.onApnChanged(1);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2Mobile");
        }
        a aVar = this.f73196d;
        if (aVar != null) {
            aVar.onApnChanged(2);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        if (QLog.isColorLevel()) {
            QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2None");
        }
        a aVar = this.f73196d;
        if (aVar != null) {
            aVar.onApnChanged(0);
        }
    }
}
