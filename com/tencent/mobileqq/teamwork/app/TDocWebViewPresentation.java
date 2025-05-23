package com.tencent.mobileqq.teamwork.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.teamwork.ProcessOpenDocsPerformanceData;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
/* loaded from: classes18.dex */
public class TDocWebViewPresentation extends com.tencent.mobileqq.remoteweb.view.g {
    private Bundle J;
    private ProcessOpenDocsPerformanceData K;

    public TDocWebViewPresentation(@NonNull Context context, @NonNull Display display, @NonNull Bundle bundle) {
        super(context, display, bundle);
        this.K = new ProcessOpenDocsPerformanceData();
        ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initWebEngine();
        QLog.d("TDocWebViewPresentation", 1, "tDoc_step tDoc_local_edit TDocWebViewPresentation create ");
        this.J = bundle;
        this.K.f291499d = System.currentTimeMillis();
    }

    private boolean D(int i3) {
        try {
            LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(ITDocFileBrowserFacade.NATIVE_ENGINE_SO_NAME);
            QLog.i("TDocWebViewPresentation", 1, "[loadLibrary] ooXmlResult:" + loadSync.isSucc() + "docsType:" + i3);
            String relatedFilesFolder = loadSync.getRelatedFilesFolder();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(relatedFilesFolder);
            String str = File.separator;
            sb5.append(str);
            sb5.append("binding");
            sb5.append(str);
            sb5.append("libbinding.so");
            System.load(sb5.toString());
            return true;
        } catch (Exception | UnsatisfiedLinkError e16) {
            QLog.e("TDocWebViewPresentation", 1, "[loadLibrary] webResult false:" + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g
    public void A(@NonNull TouchWebView touchWebView) {
        QLog.d("TDocWebViewPresentation", 1, "tDoc_step tDoc_local_edit initWebView " + touchWebView);
        super.A(touchWebView);
        e.q(touchWebView, this.J.getString("key_web_page_id", ""));
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void d() {
        QLog.d("TDocWebViewPresentation", 1, "tDoc_local_edit TDocWebViewPresentation destroy ");
        super.d();
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void n(@NonNull String str, @NonNull Bundle bundle) {
        QLog.d("TDocWebViewPresentation", 1, "tDoc_step tDoc_local_edit loadUrl " + str);
        super.n(str, bundle);
        this.K.f291500e = System.currentTimeMillis();
        r.b().d(this.J.getString("key_web_page_id", ""), this.K);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public boolean r(@NotNull View view) {
        r.b().register();
        return super.r(view);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g
    @NonNull
    public TouchWebView u(@NonNull Activity activity) {
        QLog.d("TDocWebViewPresentation", 1, "tDoc_step tDoc_local_edit createWebView");
        int i3 = this.J.getInt("docs_type", -1);
        QLog.i("TDocWebViewPresentation", 1, "tDoc_step web start load");
        D(i3);
        QLog.i("TDocWebViewPresentation", 1, "tDoc_step web  load end");
        r.b().register();
        return super.u(activity);
    }
}
