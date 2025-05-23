package cooperation.qzone.webviewplugin.sound;

import android.os.Environment;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneSoundPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    public static final String QZONE_TINY_PROGRAM_CACHE = "tencent/Qzone/tinyprogram/";
    private static final String TAG = "QzoneSoundPlugin";
    private String mFinalCacheRoot = "";
    private String mDownloadMusicFinalCachePath = "";
    private QzoneSoundPlayerHelper mLocalBackSoundHelper = new QzoneSoundPlayerHelper();
    private QzoneSoundPlayerHelper mLocalSoundHelper = new QzoneSoundPlayerHelper();

    private String checkEnv() {
        if (TextUtils.isEmpty(this.mFinalCacheRoot)) {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "no sdcard");
                }
                return "";
            }
            this.mFinalCacheRoot = QZoneFilePath.ROOT_PATH + QZONE_TINY_PROGRAM_CACHE;
            File file = new File(this.mFinalCacheRoot);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "make dir fail");
                    }
                    return "";
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "make dir suc");
                }
            } else if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "dir is exists");
            }
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "cache root found use : " + this.mFinalCacheRoot);
        }
        return this.mFinalCacheRoot;
    }

    private void playLocalBackSound(String... strArr) {
        try {
            String str = checkEnv() + MD5Utils.toMD5(new JSONObject(strArr[0]).optString("url")) + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION;
            QLog.d(TAG, 2, "playLocalBackSound : " + str);
            if (new File(str).exists()) {
                this.mLocalBackSoundHelper.setDataSource(str);
                this.mLocalBackSoundHelper.start();
            }
        } catch (Exception unused) {
        }
    }

    private void playLocalSound(String... strArr) {
        try {
            String str = checkEnv() + MD5Utils.toMD5(new JSONObject(strArr[0]).optString("url")) + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION;
            QLog.d(TAG, 2, "playLocalSound : " + str);
            if (new File(str).exists()) {
                this.mLocalSoundHelper.setDataSource(str);
                this.mLocalSoundHelper.start();
            }
        } catch (Exception unused) {
        }
    }

    private void preloadSound(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            final String optString = jSONObject.optString("callback");
            String optString2 = jSONObject.optString("url");
            String md5 = MD5Utils.toMD5(jSONObject.optString("url"));
            QLog.d(TAG, 2, "downloadMusicUrl : " + optString2);
            QLog.d(TAG, 2, "downloadMusicMD5 : " + md5);
            this.mDownloadMusicFinalCachePath = checkEnv() + md5 + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mDownloadMusicFinalCachePath : ");
            sb5.append(this.mDownloadMusicFinalCachePath);
            QLog.d(TAG, 2, sb5.toString());
            if (!new File(this.mDownloadMusicFinalCachePath).exists()) {
                DownloaderFactory.getInstance(this.parentPlugin.mRuntime.a()).getCommonDownloader().download(optString2, this.mDownloadMusicFinalCachePath, new Downloader.DownloadListener() { // from class: cooperation.qzone.webviewplugin.sound.QzoneSoundPlugin.1
                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadCanceled(String str) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QzoneSoundPlugin.TAG, 2, "onDownloadCanceled:" + str);
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", -1);
                            jSONObject2.put("message", str);
                            ((QzoneInternalWebViewPlugin) QzoneSoundPlugin.this).parentPlugin.callJs(optString, jSONObject2.toString());
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i(QzoneSoundPlugin.TAG, 2, "DownloaderFactory onDownloadCanceled : " + e16.getMessage());
                            }
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadFailed(String str, DownloadResult downloadResult) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QzoneSoundPlugin.TAG, 2, "onDownloadFailed:" + str);
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (downloadResult != null) {
                                DownloadResult.Status status = downloadResult.getStatus();
                                if (status != null) {
                                    jSONObject2.put("code", status.failReason);
                                } else {
                                    jSONObject2.put("code", -1);
                                }
                                jSONObject2.put("message", downloadResult.getDetailDownloadInfo());
                            } else {
                                jSONObject2.put("code", -1);
                                jSONObject2.put("message", "DownloadFailed");
                            }
                            ((QzoneInternalWebViewPlugin) QzoneSoundPlugin.this).parentPlugin.callJs(optString, jSONObject2.toString());
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i(QzoneSoundPlugin.TAG, 2, "DownloaderFactory onDownloadFailed : " + e16.getMessage());
                            }
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadProgress(String str, long j3, float f16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QzoneSoundPlugin.TAG, 2, "onDownloadProgress: ", str + ProgressTracer.SEPARATOR + j3 + ProgressTracer.SEPARATOR + f16);
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QzoneSoundPlugin.TAG, 2, "onDownloadSucceed");
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", 0);
                            jSONObject2.put("message", "success");
                            ((QzoneInternalWebViewPlugin) QzoneSoundPlugin.this).parentPlugin.callJs(optString, jSONObject2.toString());
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i(QzoneSoundPlugin.TAG, 2, "DownloaderFactory onDownloadSucceed : " + e16.getMessage());
                            }
                        }
                    }
                });
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "The Music File is Exist");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put("message", "success");
                this.parentPlugin.callJs(optString, jSONObject2.toString());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "DownloaderFactory onDownloadSucceed : " + e16.getMessage());
                }
            }
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "METHOD_DOWNLOAD_SUPER_LIKE_MUSIC: ", e17);
            }
        }
    }

    private void stopLocalBackSound(String... strArr) {
        QzoneSoundPlayerHelper qzoneSoundPlayerHelper = this.mLocalBackSoundHelper;
        if (qzoneSoundPlayerHelper != null) {
            qzoneSoundPlayerHelper.stop();
        }
    }

    private void stopLocalSound(String... strArr) {
        QzoneSoundPlayerHelper qzoneSoundPlayerHelper = this.mLocalSoundHelper;
        if (qzoneSoundPlayerHelper != null) {
            qzoneSoundPlayerHelper.stop();
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_PLAY_LOCAL_SOUND)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, QZoneJsConstants.METHOD_PLAY_LOCAL_SOUND);
                }
                playLocalSound(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_PLAY_LOCAL_BACK_SOUND)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, QZoneJsConstants.METHOD_PLAY_LOCAL_BACK_SOUND);
                }
                playLocalBackSound(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_PRELOAD_SOUND)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, QZoneJsConstants.METHOD_PRELOAD_SOUND);
                }
                preloadSound(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_STOP_LOCAL_SOUND)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, QZoneJsConstants.METHOD_STOP_LOCAL_SOUND);
                }
                stopLocalSound(new String[0]);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_STOP_LOCAL_BACK_SOUND)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, QZoneJsConstants.METHOD_STOP_LOCAL_BACK_SOUND);
                }
                stopLocalBackSound(new String[0]);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        QzoneSoundPlayerHelper qzoneSoundPlayerHelper = this.mLocalBackSoundHelper;
        if (qzoneSoundPlayerHelper != null) {
            qzoneSoundPlayerHelper.release();
            this.mLocalBackSoundHelper = null;
        }
        QzoneSoundPlayerHelper qzoneSoundPlayerHelper2 = this.mLocalSoundHelper;
        if (qzoneSoundPlayerHelper2 != null) {
            qzoneSoundPlayerHelper2.release();
            this.mLocalSoundHelper = null;
        }
    }
}
