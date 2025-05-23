package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload;
import com.tencent.mobileqq.teamwork.api.IUniDownloadListenerProxy;
import mqq.app.AppRuntime;

/* loaded from: classes18.dex */
public class UniDownloadListenerProxyImpl implements IUniDownloadListenerProxy {
    private UniformDownload.a mListener;

    @Override // com.tencent.mobileqq.teamwork.api.IUniDownloadListenerProxy
    public void onCreate(AppRuntime appRuntime, Activity activity, TouchWebView touchWebView, boolean z16) {
        UniformDownload.a aVar = new UniformDownload.a(appRuntime, activity, touchWebView);
        this.mListener = aVar;
        aVar.d(z16);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IUniDownloadListenerProxy
    public void onDestroy() {
        this.mListener = null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IUniDownloadListenerProxy
    public void setDownloadListener(TouchWebView touchWebView) {
        UniformDownload.a aVar = this.mListener;
        if (aVar != null && touchWebView != null) {
            touchWebView.setDownloadListener(aVar);
        }
    }
}
