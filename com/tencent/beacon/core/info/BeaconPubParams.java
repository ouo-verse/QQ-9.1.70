package com.tencent.beacon.core.info;

import android.content.Context;
import android.os.Build;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.c.j;

/* loaded from: classes2.dex */
public class BeaconPubParams {
    private static BeaconPubParams sParamsHolder;
    private String androidId;
    private String appFirstInstallTime;
    private String appLastUpdatedTime;
    private String appVersion;
    private String beaconId;
    private String boundleId;
    private String brand;
    private String cid;
    private Context context;
    private String dpi;
    private String dtImei2;
    private String dtMeid;
    private String dtMf;
    private String fingerprint;
    private String gpu;
    private String hardwareOs;
    private String imei;
    private String imsi;
    private String isRooted;
    private String language;
    private String mac;
    private String model;
    private String modelApn;
    private String networkType;
    private String osVersion;
    private String platform;
    private String productId;
    private String qimei;
    private String resolution;
    private String sdkId;
    private String sdkVersion;
    private String wifiMac;
    private String wifiSsid;

    BeaconPubParams(Context context) {
        this.context = context;
        init(context);
    }

    public static synchronized BeaconPubParams getPubParams(Context context) {
        BeaconPubParams beaconPubParams;
        synchronized (BeaconPubParams.class) {
            if (sParamsHolder == null) {
                synchronized (BeaconPubParams.class) {
                    if (sParamsHolder == null) {
                        sParamsHolder = new BeaconPubParams(context);
                    }
                }
            }
            sParamsHolder.refresh();
            beaconPubParams = sParamsHolder;
        }
        return beaconPubParams;
    }

    private void init(Context context) {
        String str;
        if (context != context.getApplicationContext()) {
            context = context.getApplicationContext();
        }
        c c16 = c.c();
        c16.a(context);
        this.appVersion = b.a();
        this.boundleId = b.b();
        this.sdkId = c16.h();
        this.sdkVersion = c16.i();
        this.beaconId = j.f();
        this.appFirstInstallTime = b.a(context);
        e l3 = e.l();
        this.appLastUpdatedTime = l3.a(context);
        this.platform = String.valueOf((int) c16.g());
        this.dtMf = l3.o();
        this.osVersion = l3.t();
        this.hardwareOs = l3.f() + "_" + l3.e();
        this.brand = Build.BRAND;
        f e16 = f.e();
        this.model = e16.h();
        this.language = l3.n();
        this.resolution = l3.v();
        this.dpi = String.valueOf(l3.z());
        this.gpu = "";
        if (l3.m()) {
            str = "1";
        } else {
            str = "0";
        }
        this.isRooted = str;
        this.fingerprint = l3.w();
        this.qimei = j.b();
        this.mac = e16.f();
        this.wifiMac = e16.j();
        this.wifiSsid = e16.k();
        this.cid = l3.p();
    }

    private void refresh() {
        e l3 = e.l();
        f e16 = f.e();
        this.networkType = l3.q();
        this.modelApn = l3.r();
        this.imei = e16.b();
        this.dtImei2 = e16.c();
        this.dtMeid = e16.g();
        this.imsi = e16.d();
        this.androidId = e16.a();
        this.mac = e16.f();
        this.wifiMac = e16.j();
        this.wifiSsid = e16.k();
    }

    public String getAndroidId() {
        return this.androidId;
    }

    public String getAppFirstInstallTime() {
        return this.appFirstInstallTime;
    }

    public String getAppLastUpdatedTime() {
        return this.appLastUpdatedTime;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getBeaconId() {
        return this.beaconId;
    }

    public String getBoundleId() {
        return this.boundleId;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCid() {
        return this.cid;
    }

    public String getDpi() {
        return this.dpi;
    }

    public String getDtImei2() {
        return this.dtImei2;
    }

    public String getDtMeid() {
        return this.dtMeid;
    }

    public String getDtMf() {
        return this.dtMf;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public String getHardwareOs() {
        return this.hardwareOs;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getIsRooted() {
        return this.isRooted;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMac() {
        return this.mac;
    }

    public String getModel() {
        return this.model;
    }

    public String getModelApn() {
        return this.modelApn;
    }

    public String getNetworkType() {
        return this.networkType;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getQimei() {
        return this.qimei;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getSdkId() {
        return this.sdkId;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public String getWifiSsid() {
        return this.wifiSsid;
    }

    public String toString() {
        return super.toString();
    }
}
