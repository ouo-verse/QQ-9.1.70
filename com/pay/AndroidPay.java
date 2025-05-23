package com.pay;

import android.app.Activity;
import android.content.Context;
import com.pay.api.APPayResponseInfo;
import com.tencent.midas.api.APMidasPayAPI;

/* loaded from: classes2.dex */
public class AndroidPay {
    public static final int LANDSCAPE = 0;
    public static final int PORTRAINT = 1;
    private static volatile AndroidPay gInstance;
    public Activity fromActivity;
    public String offerId;
    public APPayResponseInfo payResponseInfo;
    public byte[] resdata;
    public Context applicationContext = null;
    public String unit = "";
    public boolean isShowNum = true;
    public boolean isShowListOtherNum = true;

    AndroidPay() {
        this.payResponseInfo = null;
        this.payResponseInfo = new APPayResponseInfo();
    }

    public static String getPaySDKVersion(Activity activity) {
        return APMidasPayAPI.getMidasSDKVersion(activity);
    }

    public static void setElseNumberVisible(boolean z16) {
        gInstance.isShowListOtherNum = z16;
    }

    public static void setEnv(String str) {
        APMidasPayAPI.setEnv(str);
    }

    public static void setIsShowSaveNum(boolean z16) {
        gInstance.isShowNum = z16;
    }

    public static void setLogEnable(boolean z16) {
        APMidasPayAPI.setLogEnable(z16);
    }

    public static void setNumberVisible(boolean z16) {
        setIsShowSaveNum(z16);
    }

    public static void setOfferId(String str) {
        gInstance.offerId = str;
    }

    public static void setPropUnit(String str) {
        gInstance.unit = str;
    }

    public static void setResData(byte[] bArr) {
        gInstance.resdata = bArr;
    }

    public static AndroidPay singleton() {
        if (gInstance == null) {
            synchronized (AndroidPay.class) {
                if (gInstance == null) {
                    gInstance = new AndroidPay();
                }
            }
        }
        return gInstance;
    }

    public Context getContext() {
        return this.applicationContext;
    }

    public static void Destory() {
    }

    public static void setCustomUrlParam(String str) {
    }

    public static void setScreenType(int i3) {
    }

    public static void setWechatAppId(String str) {
    }
}
