package cooperation.qzone.networkedmodule;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ModuleDownloadListener {
    void onDownloadCanceled(String str);

    void onDownloadFailed(String str);

    void onDownloadProgress(String str, float f16);

    void onDownloadSucceed(String str);
}
