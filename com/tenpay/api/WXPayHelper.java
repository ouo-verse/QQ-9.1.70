package com.tenpay.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes27.dex */
public class WXPayHelper {
    private static final byte[] lock = new byte[0];
    private static WXPayHelper sWXPayHelper;
    private final com.tencent.mobileqq.wxapi.WXPayHelper trueHelper = com.tencent.mobileqq.wxapi.WXPayHelper.getInstance();

    WXPayHelper() {
    }

    public static WXPayHelper getInstance() {
        if (sWXPayHelper == null) {
            synchronized (lock) {
                if (sWXPayHelper == null) {
                    sWXPayHelper = new WXPayHelper();
                }
            }
        }
        return sWXPayHelper;
    }

    public void addObserver(Handler handler) {
        this.trueHelper.addObserver(handler);
    }

    public int getWXAppSupportAPI() {
        return this.trueHelper.getWXAppSupportAPI();
    }

    public void handleIntent(Intent intent) {
        this.trueHelper.handleIntent(intent);
    }

    public boolean isWXinstalled() {
        return this.trueHelper.isWXinstalled();
    }

    public boolean isWXsupportApi() {
        return this.trueHelper.isWXsupportApi();
    }

    public boolean isWXsupportPayApi() {
        return this.trueHelper.isWXsupportPayApi();
    }

    public void registerApp(String str) {
        this.trueHelper.registerApp(str);
    }

    public void removeObserver(Handler handler) {
        this.trueHelper.removeObserver(handler);
    }

    public void sendReq(Bundle bundle) {
        this.trueHelper.sendReq(bundle);
    }

    public void unRegisterApp() {
        this.trueHelper.unRegisterApp();
    }

    public void registerApp() {
        this.trueHelper.registerApp();
    }
}
