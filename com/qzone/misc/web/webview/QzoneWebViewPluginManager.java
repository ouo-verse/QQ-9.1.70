package com.qzone.misc.web.webview;

import com.tencent.common.app.BaseApplicationImpl;

/* loaded from: classes39.dex */
public class QzoneWebViewPluginManager {

    /* renamed from: b, reason: collision with root package name */
    private static QzoneWebViewPluginManager f48624b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f48625c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private QzoneWebViewRuntime f48626a;

    public static QzoneWebViewPluginManager getInstance() {
        if (f48624b == null) {
            synchronized (f48625c) {
                if (f48624b == null) {
                    f48624b = new QzoneWebViewPluginManager();
                }
            }
        }
        return f48624b;
    }

    public QzoneWebViewRuntime getRuntime() {
        if (this.f48626a == null) {
            synchronized (f48625c) {
                if (this.f48626a == null) {
                    QzoneWebViewRuntime qzoneWebViewRuntime = new QzoneWebViewRuntime(BaseApplicationImpl.getApplication(), "qzone");
                    qzoneWebViewRuntime.onCreate(null);
                    this.f48626a = qzoneWebViewRuntime;
                }
            }
        }
        return this.f48626a;
    }

    public void initApp(QzoneWebViewRuntime qzoneWebViewRuntime) {
        this.f48626a = qzoneWebViewRuntime;
    }
}
