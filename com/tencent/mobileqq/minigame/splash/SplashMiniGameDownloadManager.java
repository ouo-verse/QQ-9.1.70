package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SplashMiniGameDownloadManager {
    public static final int RES_TYPE_PIC = 0;
    public static final int RES_TYPE_VIDEO = 1;
    public static final String TAG = "SplashMiniGameDownloadMgr";

    public static void downloadRes(QQAppInterface qQAppInterface, final String str, final String str2, final String str3, final int i3) {
        int i16;
        try {
            IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
            if (iPreDownloadController.isEnable()) {
                String str4 = "minigame_splash_png";
                if (i3 == 1) {
                    str4 = "minigame_splash_video";
                    i16 = 10087;
                } else {
                    i16 = 10086;
                }
                QLog.i(TAG, 1, "downloadPicAGifAVideoRes request appid" + str);
                iPreDownloadController.requestPreDownload(i16, PreDownloadConstants.DEPARTMENT_PRD, str2, 0, str2, str3, 2, 0, false, new AbsPreDownloadTask(qQAppInterface, str4) { // from class: com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.1
                    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
                    protected void realStart() {
                        QLog.i(SplashMiniGameDownloadManager.TAG, 1, "downloadPicAGifAVideoRes appid" + str);
                        HttpNetReq httpNetReq = new HttpNetReq();
                        httpNetReq.mCallback = new DownLoadNetEngine((QQAppInterface) this.app, str, i3, str3, str2);
                        httpNetReq.mReqUrl = str2;
                        httpNetReq.mHttpMethod = 0;
                        httpNetReq.mOutPath = str3;
                        ((IHttpEngineService) this.app.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    }

                    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
                    protected void realCancel() {
                        QLog.i(SplashMiniGameDownloadManager.TAG, 1, "ctrl realCancel");
                    }
                });
            } else {
                QLog.i(TAG, 1, "ctrl.isEnable() = false");
            }
        } catch (Exception unused) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class DownLoadNetEngine implements INetEngineListener {
        QQAppInterface app;
        String appid;
        String downloadurl;
        String resPath;
        int type;

        public DownLoadNetEngine(QQAppInterface qQAppInterface, String str, int i3, String str2, String str3) {
            this.app = qQAppInterface;
            this.appid = str;
            this.type = i3;
            this.downloadurl = str3;
            this.resPath = str2;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            try {
                int i3 = netResp.mResult;
                if (i3 != 0) {
                    if (i3 == 1) {
                        QLog.i(SplashMiniGameDownloadManager.TAG, 1, "ResFile dowload faield");
                        return;
                    }
                    return;
                }
                QLog.i(SplashMiniGameDownloadManager.TAG, 1, "ResFile has download!");
                if (TextUtils.isEmpty(this.resPath)) {
                    return;
                }
                File file = new File(this.resPath);
                if (file.exists()) {
                    long length = file.length();
                    IPreDownloadController iPreDownloadController = (IPreDownloadController) this.app.getRuntimeService(IPreDownloadController.class);
                    if (iPreDownloadController.isEnable()) {
                        QLog.i(SplashMiniGameDownloadManager.TAG, 1, "preDownloadSuccess");
                        iPreDownloadController.preDownloadSuccess(this.downloadurl, length);
                    }
                    if (this.type == 0) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(file.getParent());
                        String str = File.separator;
                        sb5.append(str);
                        ZipUtils.unZipFile(file, sb5.toString());
                        this.resPath = file.getParent() + str + "splash.png";
                    }
                    SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
                    return;
                }
                QLog.i(SplashMiniGameDownloadManager.TAG, 1, "ResFile check not exist");
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
