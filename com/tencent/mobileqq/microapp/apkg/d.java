package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class d implements ApkgConfigManager.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f245847a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnUpdateListener f245848b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ApkgConfigManager f245849c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ApkgConfigManager apkgConfigManager, int i3, OnUpdateListener onUpdateListener) {
        this.f245849c = apkgConfigManager;
        this.f245847a = i3;
        this.f245848b = onUpdateListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, apkgConfigManager, Integer.valueOf(i3), onUpdateListener);
        }
    }

    @Override // com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.a
    public void onResult(int i3, MiniAppConfig miniAppConfig, String str, String str2) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), miniAppConfig, str, str2);
            return;
        }
        if (i3 == 0 && this.f245847a != miniAppConfig.config.mini_version) {
            OnUpdateListener onUpdateListener = this.f245848b;
            if (onUpdateListener != null) {
                onUpdateListener.onCheckForUpdate(true);
            }
            if (new File(g.a(miniAppConfig.config)).exists()) {
                OnUpdateListener onUpdateListener2 = this.f245848b;
                if (onUpdateListener2 != null) {
                    onUpdateListener2.onUpdateSucc(true);
                    return;
                }
                return;
            }
            String a16 = g.a(miniAppConfig.config);
            qQAppInterface = this.f245849c.mApp;
            PreloadManager preloadManager = ManagerProxy.getPreloadManager(qQAppInterface);
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.headers = new LinkedList();
            downloadParam.url = miniAppConfig.config.apkg_url + "?sign=" + URLEncoder.encode(miniAppConfig.config.cos_sign);
            preloadManager.getResPath(downloadParam, new e(this, a16));
            return;
        }
        OnUpdateListener onUpdateListener3 = this.f245848b;
        if (onUpdateListener3 != null) {
            onUpdateListener3.onCheckForUpdate(false);
        }
    }
}
