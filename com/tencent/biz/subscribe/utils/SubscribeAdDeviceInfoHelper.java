package com.tencent.biz.subscribe.utils;

import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeAdDeviceInfoHelper {

    /* renamed from: b, reason: collision with root package name */
    private static SubscribeAdDeviceInfoHelper f96208b;

    /* renamed from: a, reason: collision with root package name */
    private qq_ad_get.QQAdGet.DeviceInfo f96209a;

    public static SubscribeAdDeviceInfoHelper e() {
        if (f96208b == null) {
            synchronized (SubscribeAdDeviceInfoHelper.class) {
                if (f96208b == null) {
                    f96208b = new SubscribeAdDeviceInfoHelper();
                }
            }
        }
        return f96208b;
    }

    public qq_ad_get.QQAdGet.DeviceInfo c() {
        f(3);
        return this.f96209a;
    }

    public String d() {
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = this.f96209a;
        if (deviceInfo == null) {
            f(3);
            return "";
        }
        Object pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo);
        if (pbToJson == null) {
            return "";
        }
        return pbToJson.toString();
    }

    public void f(int i3) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
            @Override // java.lang.Runnable
            public void run() {
                qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
                try {
                    GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
                    SubscribeAdDeviceInfoHelper subscribeAdDeviceInfoHelper = SubscribeAdDeviceInfoHelper.this;
                    if (create != null) {
                        deviceInfo = create.deviceInfo;
                    } else {
                        deviceInfo = null;
                    }
                    subscribeAdDeviceInfoHelper.f96209a = deviceInfo;
                    if (SubscribeAdDeviceInfoHelper.this.f96209a != null) {
                        pz2.b.f428093a.f(SubscribeAdDeviceInfoHelper.this.f96209a);
                    }
                } catch (Throwable th5) {
                    QLog.e("SubscribeAdDeviceInfoHelper", 1, "initAdDeviceInfo error! ", th5);
                }
            }
        });
    }
}
