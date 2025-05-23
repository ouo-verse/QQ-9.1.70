package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.minigame.publicaccount.utils.AuthDialogPAUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;

/* compiled from: P */
@ProxyService(proxy = SpecialProxy.class)
/* loaded from: classes34.dex */
public class br implements SpecialProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy
    public boolean sendEventToHost(int i3, Bundle bundle, SpecialProxy.EventCallback eventCallback) {
        QLog.i("SpecialProxyImpl", 1, "receive event from minisdk, event:" + i3);
        try {
            return c(i3, bundle, eventCallback);
        } catch (Throwable th5) {
            QLog.e("SpecialProxyImpl", 1, "exception when receive event from minisdk", th5);
            return false;
        }
    }

    private void a(Bundle bundle, SpecialProxy.EventCallback eventCallback) {
        if (bundle == null) {
            if (eventCallback != null) {
                eventCallback.onResult(false, null);
                return;
            }
            return;
        }
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        NetworkTimeoutInfo networkTimeoutInfo = (NetworkTimeoutInfo) bundle.getParcelable(SpecialProxy.KEY_NETWORK_TIMEOUT_INFO);
        if (networkTimeoutInfo == null) {
            if (eventCallback != null) {
                eventCallback.onResult(false, null);
            }
        } else {
            QLog.e("SpecialProxyImpl", 1, "Specialproxy onInitNetworkInfo :" + networkTimeoutInfo.toString());
            MiniOkHttpClientFactory.init((long) networkTimeoutInfo.request, (long) networkTimeoutInfo.uploadFile, (long) networkTimeoutInfo.downloadFile);
        }
    }

    private void b(Bundle bundle, SpecialProxy.EventCallback eventCallback) {
        if (bundle == null) {
            if (eventCallback != null) {
                eventCallback.onResult(false, null);
                return;
            }
            return;
        }
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        MiniAppConfig h16 = aq.h((MiniAppInfo) bundle.getParcelable(MiniAppConst.MINI_KEY_APPINFO));
        if (h16 == null) {
            if (eventCallback != null) {
                eventCallback.onResult(false, null);
            }
        } else {
            MiniAppUtils.notityPullDownEntryInMainProcess(h16);
            if (eventCallback != null) {
                eventCallback.onResult(true, null);
            }
        }
    }

    private boolean c(int i3, Bundle bundle, SpecialProxy.EventCallback eventCallback) {
        if (i3 == 1) {
            b(bundle, eventCallback);
            return true;
        }
        if (i3 == 2) {
            a(bundle, eventCallback);
            return true;
        }
        if (i3 == 3) {
            AuthDialogPAUtil.getMiniGamePASubMsg(eventCallback);
            return true;
        }
        if (i3 != 4) {
            return false;
        }
        AuthDialogPAUtil.followMiniGamePA(eventCallback);
        return true;
    }
}
