package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.minigamecenter.dialog.HippyDialogFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes34.dex */
public class HippyPageProxyImpl implements HippyPageProxy {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<HippyDialogFragment> f347367a;

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void downloadJSBundle(String str, int i3) {
        String str2 = HippyDialogFragment.getHippyInfoMap(str).get("bundleName");
        if (TextUtils.isEmpty(str2)) {
            QLog.e("HippyPageProxyImpl", 1, "no bundle name in url:", str);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("HippyPageProxyImpl", 4, "downloadJSBundle bundleName=", str2);
        }
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(str2, String.valueOf(i3), null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void openHippyPage(final IMiniAppContext iMiniAppContext, final String str, String str2, int i3, HashMap<String, String> hashMap) {
        QLog.i("HippyPageProxyImpl", 1, "[openHippyPage],from:" + i3 + ", url:" + str + ",extData:" + hashMap);
        if (iMiniAppContext == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.HippyPageProxyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Activity attachActivity = iMiniAppContext.getAttachActivity();
                if (iMiniAppContext.getMiniAppInfo() == null) {
                    return;
                }
                if (!(attachActivity instanceof MiniBaseActivity)) {
                    QLog.w("HippyPageProxyImpl", 1, "[openHippyPage], it fails to open hippy page.");
                    return;
                }
                HippyDialogFragment newInstance = HippyDialogFragment.newInstance(str, !iMiniAppContext.isOrientationLandscape() ? 1 : 0);
                newInstance.show(((MiniBaseActivity) attachActivity).getSupportFragmentManager(), HippyDialogFragment.class.getSimpleName());
                HippyPageProxyImpl.this.f347367a = new WeakReference(newInstance);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void closeHippyPage() {
        QLog.i("HippyPageProxyImpl", 1, "[closeHippyPage]");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.HippyPageProxyImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (HippyPageProxyImpl.this.f347367a == null) {
                    QLog.w("HippyPageProxyImpl", 1, "hippy page is null.");
                    return;
                }
                HippyDialogFragment hippyDialogFragment = (HippyDialogFragment) HippyPageProxyImpl.this.f347367a.get();
                if (hippyDialogFragment == null) {
                    return;
                }
                hippyDialogFragment.dismiss();
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void setRoundDrawable(ImageView imageView, String str) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setImageDrawable(MiniAppUtils.getIcon(imageView.getContext(), str, true));
    }
}
