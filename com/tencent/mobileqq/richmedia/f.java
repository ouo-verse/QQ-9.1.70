package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements c {

    /* renamed from: d, reason: collision with root package name */
    public String f281573d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f281574e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f281575f = null;

    /* renamed from: h, reason: collision with root package name */
    protected String f281576h = null;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f281577i = true;

    public f() {
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this);
        b();
    }

    public static String a() {
        return "XGIdentifier";
    }

    @Override // com.tencent.mobileqq.richmedia.c
    public void V1(int i3) {
        if (QLog.isColorLevel()) {
            QLog.e("PttIpSaver", 2, "clear ip:" + i3);
        }
        if (i3 == -1) {
            this.f281573d = null;
            this.f281574e = null;
            this.f281575f = null;
        } else if (i3 == 0) {
            this.f281573d = null;
        } else if (i3 == 1) {
            this.f281574e = null;
        } else if (i3 == 2) {
            this.f281575f = null;
        }
    }

    @Override // com.tencent.mobileqq.richmedia.c
    public synchronized String Wd() {
        return this.f281576h;
    }

    public synchronized void b() {
        BaseApplication.getContext();
        this.f281576h = "";
        this.f281577i = true;
        if (QLog.isColorLevel()) {
            QLog.e("PttIpSaver", 2, "onNetMobile2Wifi  " + this.f281576h);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.c
    public void destroy() {
        try {
            AppNetConnInfo.unregisterNetInfoHandler(this);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.richmedia.c
    public synchronized boolean isWifi() {
        return this.f281577i;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetMobile2None() {
        V1(-1);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetMobile2Wifi(String str) {
        V1(-1);
        if (QLog.isColorLevel()) {
            QLog.e("PttIpSaver", 2, "onNetMobile2Wifi  " + this.f281576h);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetNone2Mobile(String str) {
        this.f281576h = a();
        this.f281577i = false;
        V1(-1);
        if (QLog.isColorLevel()) {
            QLog.e("PttIpSaver", 2, "onNetNone2Mobile  " + this.f281576h);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetNone2Wifi(String str) {
        this.f281577i = true;
        V1(-1);
        if (QLog.isColorLevel()) {
            QLog.e("PttIpSaver", 2, "onNetNone2Wifi  " + this.f281576h);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetWifi2Mobile(String str) {
        this.f281576h = a();
        this.f281577i = false;
        V1(-1);
        if (QLog.isColorLevel()) {
            QLog.e("PttIpSaver", 2, "onNetWifi2Mobile  " + this.f281576h);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetWifi2None() {
        V1(-1);
    }
}
