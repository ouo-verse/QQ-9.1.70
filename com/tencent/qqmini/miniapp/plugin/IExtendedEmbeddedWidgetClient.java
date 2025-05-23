package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IExtendedEmbeddedWidgetClient extends IEmbeddedWidgetClient {
    IMiniAppContext getMiniAppContext();

    int getViewId();

    void nativeDestroy();

    void nativePause();

    void nativeResume();

    void webViewDestroy();

    void webViewPause();

    void webViewResume();
}
