package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx;

import android.app.Application;
import android.util.Log;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public enum OpenSdkManager {
    INSTANCE;

    private static final String TAG = "WXApiProvider";
    private static final int WX_APP_SUPPORT_MINI_GAME_VERSION = 620889088;
    private static final int WX_APP_SUPPORT_VERSION = 620823552;
    private int WX_SUPPORT_API_VERSION = 0;
    private IWXAPI mIWXApi;

    OpenSdkManager() {
        updateWXSupportApiVersion();
    }

    private void updateWXSupportApiVersion() {
        if (!ev2.e.e()) {
            n.e(TAG, "updateWXSupportApiVersion: no user agreed private protocol");
            return;
        }
        int i3 = 0;
        if (!isWXInstalled()) {
            n.e(TAG, "updateWXSupportApiVersion: wx not installed");
            this.WX_SUPPORT_API_VERSION = 0;
            return;
        }
        if (getWxApi() != null) {
            i3 = getWxApi().getWXAppSupportAPI();
        }
        n.e(TAG, "updateWXSupportApiVersion: OpenMiniProgramProxy.getWxApi()=" + getWxApi());
        n.e(TAG, "updateWXSupportApiVersion: wxAppSupportAPI=" + i3);
        if (i3 == 0) {
            this.WX_SUPPORT_API_VERSION = 1;
        } else {
            this.WX_SUPPORT_API_VERSION = i3;
        }
    }

    public int getInternalOpenSdkVersion() {
        if (!ev2.e.e()) {
            return 0;
        }
        return 637928960;
    }

    public String getWXAppId() {
        if (!ev2.e.e()) {
            return "";
        }
        return qv2.b.d();
    }

    public int getWXOpenSdkVersion() {
        IWXAPI wxApi;
        if (!ev2.e.e() || (wxApi = getWxApi()) == null) {
            return 0;
        }
        return wxApi.getWXAppSupportAPI();
    }

    public int getWXSupportAPIVersion() {
        if (this.WX_SUPPORT_API_VERSION <= 1) {
            n.e(TAG, "getWXSupportAPIVersion: update");
            updateWXSupportApiVersion();
        }
        n.e(TAG, "getWXSupportAPIVersion: WX_SUPPORT_API_VERSION=" + this.WX_SUPPORT_API_VERSION);
        return this.WX_SUPPORT_API_VERSION;
    }

    public IWXAPI getWxApi() {
        if (!ev2.e.e()) {
            return null;
        }
        Application a16 = qv2.b.a();
        if (this.mIWXApi == null && a16 != null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(a16, qv2.b.d());
            this.mIWXApi = createWXAPI;
            createWXAPI.registerApp(qv2.b.d());
        }
        Log.i(TAG, "getWxApi: " + this.mIWXApi + ", mContext: " + a16);
        return this.mIWXApi;
    }

    public boolean isSupportMiniGame() {
        boolean z16 = false;
        if (!ev2.e.e()) {
            return false;
        }
        IWXAPI wxApi = getWxApi();
        if (wxApi != null) {
            try {
                if (wxApi.getWXAppSupportAPI() >= 620889088) {
                    z16 = true;
                }
            } catch (Throwable th5) {
                Log.e(TAG, th5.getMessage());
            }
        }
        Log.i(TAG, "isWXAppSupportMiniGame: " + z16);
        return z16;
    }

    public boolean isWXAppSupportAPI() {
        boolean z16 = false;
        if (!ev2.e.e()) {
            return false;
        }
        IWXAPI wxApi = getWxApi();
        if (wxApi != null) {
            try {
                if (wxApi.getWXAppSupportAPI() >= 620823552) {
                    z16 = true;
                }
            } catch (Throwable th5) {
                Log.e(TAG, th5.getMessage());
            }
        }
        Log.i(TAG, "isWXAppSupportAPI: " + z16);
        return z16;
    }

    public boolean isWXInstalled() {
        boolean z16 = false;
        if (!ev2.e.e()) {
            n.e(TAG, "isWXInstalled: no user agreed private protocol again");
            return false;
        }
        IWXAPI wxApi = getWxApi();
        if (wxApi != null) {
            try {
                z16 = wxApi.isWXAppInstalled();
            } catch (Throwable th5) {
                Log.e(TAG, th5.getMessage());
            }
        }
        Log.i(TAG, "isWeixinInstalled: " + z16);
        return z16;
    }

    public void launchMiniProgram(d dVar, c cVar) {
        n.e(TAG, "launchMiniProgram, params=" + dVar);
        try {
            new g().d(dVar, cVar);
        } catch (Throwable th5) {
            n.c(TAG, th5);
        }
    }
}
