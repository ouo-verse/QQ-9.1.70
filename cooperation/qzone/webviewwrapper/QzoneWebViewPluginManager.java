package cooperation.qzone.webviewwrapper;

import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.api.ProcessConstant;

/* loaded from: classes38.dex */
public class QzoneWebViewPluginManager {
    private static QzoneWebViewPluginManager mInstance;
    private static Object obj = new Object();
    private QzoneWebViewRuntime mApp;

    public static QzoneWebViewPluginManager getInstance() {
        if (mInstance == null) {
            synchronized (obj) {
                if (mInstance == null) {
                    mInstance = new QzoneWebViewPluginManager();
                }
            }
        }
        return mInstance;
    }

    public QzoneWebViewRuntime getRuntime() {
        if (this.mApp == null) {
            synchronized (obj) {
                if (this.mApp == null) {
                    QzoneWebViewRuntime qzoneWebViewRuntime = new QzoneWebViewRuntime(BaseApplicationImpl.getApplication(), ProcessConstant.QZONELIVE);
                    qzoneWebViewRuntime.onCreate(null);
                    this.mApp = qzoneWebViewRuntime;
                }
            }
        }
        return this.mApp;
    }

    public void initApp(QzoneWebViewRuntime qzoneWebViewRuntime) {
        this.mApp = qzoneWebViewRuntime;
    }
}
