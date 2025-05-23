package com.tencent.could.huiyansdk.operate;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @SerializedName("OsVersion")
    public String f100234a;

    /* renamed from: b, reason: collision with root package name */
    @SerializedName(QCircleVideoDeviceInfoUtils.STRATEGY_DEVICE_MODEL)
    public String f100235b;

    /* renamed from: c, reason: collision with root package name */
    @SerializedName("DeviceBrand")
    public String f100236c;

    /* renamed from: d, reason: collision with root package name */
    @SerializedName("SdkVersion")
    public String f100237d;

    /* renamed from: e, reason: collision with root package name */
    @SerializedName("YouTuVersion")
    public String f100238e;

    /* renamed from: f, reason: collision with root package name */
    @SerializedName("TuringVersion")
    public String f100239f;

    /* renamed from: g, reason: collision with root package name */
    @SerializedName("PackageName")
    public String f100240g;

    /* renamed from: h, reason: collision with root package name */
    @SerializedName("PackageVersion")
    public String f100241h;

    /* renamed from: i, reason: collision with root package name */
    @SerializedName("NetWorkType")
    public String f100242i;

    /* renamed from: j, reason: collision with root package name */
    @SerializedName("ChargingStatus")
    public int f100243j;

    /* renamed from: k, reason: collision with root package name */
    @SerializedName("BatteryPower")
    public int f100244k;

    /* renamed from: l, reason: collision with root package name */
    @SerializedName("BootTime")
    public long f100245l;

    /* renamed from: m, reason: collision with root package name */
    @SerializedName("DeviceToken")
    public String f100246m;

    /* renamed from: n, reason: collision with root package name */
    @SerializedName("SupportSim")
    public boolean f100247n;

    /* renamed from: o, reason: collision with root package name */
    @SerializedName("OpenAssistant")
    public boolean f100248o;

    /* renamed from: p, reason: collision with root package name */
    @SerializedName("IsConnectUsb")
    public boolean f100249p;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "CurrentDeviceInfo{osVersion='" + this.f100234a + "', deviceModel='" + this.f100235b + "', deviceBrand='" + this.f100236c + "', platform='Android', sdkVersion='" + this.f100237d + "', youTuVersion='" + this.f100238e + "', turingVersion='" + this.f100239f + "', packageName='" + this.f100240g + "', packageVersion='" + this.f100241h + "', netWorkType='" + this.f100242i + "', chargingStatus=" + this.f100243j + ", batteryPower=" + this.f100244k + ", bootTime=" + this.f100245l + ", deviceToken='" + this.f100246m + "', supportSim=" + this.f100247n + ", openAssistant=" + this.f100248o + ", isConnectUsb=" + this.f100249p + '}';
    }
}
