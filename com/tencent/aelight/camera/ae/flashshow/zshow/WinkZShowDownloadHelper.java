package com.tencent.aelight.camera.ae.flashshow.zshow;

import android.util.Log;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WinkZShowDownloadHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f65190a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f65191b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f65192c;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Downloader.DownloadListener f65197a;

        a(Downloader.DownloadListener downloadListener) {
            this.f65197a = downloadListener;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            Log.i("WinkZShowDownloadHelper", "downloadOldLoadingRes onDownloadFailed url https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag");
            WinkZShowDownloadHelper.f65191b = false;
            Downloader.DownloadListener downloadListener = this.f65197a;
            if (downloadListener != null) {
                downloadListener.onDownloadCanceled("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            Log.i("WinkZShowDownloadHelper", "downloadOldLoadingRes onDownloadFailed url https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag");
            WinkZShowDownloadHelper.f65191b = false;
            Downloader.DownloadListener downloadListener = this.f65197a;
            if (downloadListener != null) {
                downloadListener.onDownloadFailed("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag", downloadResult);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            Downloader.DownloadListener downloadListener = this.f65197a;
            if (downloadListener != null) {
                downloadListener.onDownloadProgress("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag", j3, f16);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            Log.i("WinkZShowDownloadHelper", "downloadOldLoadingRes onDownloadSucceed url https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag path " + downloadResult.getPath());
            WinkZShowDownloadHelper.f65191b = true;
            if (this.f65197a == null || !WinkZShowDownloadHelper.f65192c) {
                return;
            }
            DownloadResult downloadResult2 = new DownloadResult("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag");
            downloadResult2.setPath(downloadResult.getPath());
            this.f65197a.onDownloadSucceed("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag", downloadResult2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Downloader.DownloadListener f65198a;

        b(Downloader.DownloadListener downloadListener) {
            this.f65198a = downloadListener;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            Log.i("WinkZShowDownloadHelper", "downloadNewLoadingRes onDownloadFailed url https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag");
            WinkZShowDownloadHelper.f65192c = false;
            Downloader.DownloadListener downloadListener = this.f65198a;
            if (downloadListener != null) {
                downloadListener.onDownloadCanceled("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            Log.i("WinkZShowDownloadHelper", "downloadNewLoadingRes onDownloadFailed url https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag");
            WinkZShowDownloadHelper.f65192c = false;
            Downloader.DownloadListener downloadListener = this.f65198a;
            if (downloadListener != null) {
                downloadListener.onDownloadFailed("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag", downloadResult);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            Downloader.DownloadListener downloadListener = this.f65198a;
            if (downloadListener != null) {
                downloadListener.onDownloadProgress("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag", j3, f16);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            Log.i("WinkZShowDownloadHelper", "downloadNewLoadingRes onDownloadSucceed url https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag path " + downloadResult.getPath());
            WinkZShowDownloadHelper.f65192c = true;
            if (this.f65198a == null || !WinkZShowDownloadHelper.f65191b) {
                return;
            }
            DownloadResult downloadResult2 = new DownloadResult("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag");
            downloadResult2.setPath(downloadResult.getPath());
            this.f65198a.onDownloadSucceed("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag", downloadResult2);
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplication.getContext().getFilesDir().getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(WinkPublishMediaRecord.WINK_REPORT_TYPE_ZSHOW);
        sb5.append(str);
        f65190a = sb5.toString();
        f65191b = false;
        f65192c = false;
    }

    public static void e(String str, String str2, Downloader.DownloadListener downloadListener) {
        Log.i("WinkZShowDownloadHelper", "downloadFile url " + str + " destPath " + str2);
        try {
            DownloaderFactory.getInstance(BaseApplication.getContext()).getCommonDownloader().download(str, str2, downloadListener);
        } catch (Exception e16) {
            if (downloadListener != null) {
                downloadListener.onDownloadFailed(str, new DownloadResult(str));
            }
            e16.printStackTrace();
        }
    }

    public static void f(final String str, String str2, final Downloader.DownloadListener downloadListener) {
        Log.i("WinkZShowDownloadHelper", "downloadLoadingRes ");
        StringBuilder sb5 = new StringBuilder();
        String str3 = f65190a;
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(".pag");
        final String sb6 = sb5.toString();
        if (new File(sb6).exists()) {
            DownloadResult downloadResult = new DownloadResult(str);
            downloadResult.setPath(sb6);
            downloadListener.onDownloadSucceed(str, downloadResult);
        } else {
            try {
                if (!new File(str3).exists()) {
                    new File(str3).mkdirs();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            ThreadUtil.postOnSubThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.WinkZShowDownloadHelper.3

                /* compiled from: P */
                /* renamed from: com.tencent.aelight.camera.ae.flashshow.zshow.WinkZShowDownloadHelper$3$a */
                /* loaded from: classes32.dex */
                class a implements Downloader.DownloadListener {
                    a() {
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadCanceled(String str) {
                        Log.i("WinkZShowDownloadHelper", "downloadLoadingRes onDownloadFailed url " + str);
                        Downloader.DownloadListener downloadListener = downloadListener;
                        if (downloadListener != null) {
                            downloadListener.onDownloadCanceled(str);
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadFailed(String str, DownloadResult downloadResult) {
                        Log.i("WinkZShowDownloadHelper", "downloadLoadingRes onDownloadFailed url " + str);
                        Downloader.DownloadListener downloadListener = downloadListener;
                        if (downloadListener != null) {
                            downloadListener.onDownloadFailed(str, downloadResult);
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadProgress(String str, long j3, float f16) {
                        Downloader.DownloadListener downloadListener = downloadListener;
                        if (downloadListener != null) {
                            downloadListener.onDownloadProgress(str, j3, f16);
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                        Log.i("WinkZShowDownloadHelper", "downloadLoadingRes onDownloadSucceed url " + str + " path " + sb6);
                        if (downloadListener != null) {
                            DownloadResult downloadResult2 = new DownloadResult(str);
                            downloadResult2.setPath(sb6);
                            downloadListener.onDownloadSucceed(str, downloadResult2);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    WinkZShowDownloadHelper.e(str, sb6, new a());
                }
            });
        }
    }

    public static void g(Downloader.DownloadListener downloadListener) {
        f("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation.pag", "zpai_loading_animation", new a(downloadListener));
        f("https://downv6.qq.com/shadow_qqcamera/zshow/zpai_loading_animation_v2.pag", "zpai_loading_animation_v2", new b(downloadListener));
    }
}
