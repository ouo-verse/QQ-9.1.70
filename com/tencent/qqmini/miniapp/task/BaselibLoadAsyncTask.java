package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import java.io.File;

/* compiled from: P */
@ClassTag(tag = BaselibLoadAsyncTask.TAG)
/* loaded from: classes23.dex */
public class BaselibLoadAsyncTask extends AsyncTask {
    public static final String TAG = "BaselibLoadAsyncTask";
    private BaselibLoader.BaselibContent mBaselibContent;

    public BaselibLoadAsyncTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        String str = "";
        MiniAppReportManager2.reportLaunchPiecewise(204, "", getRuntimeLoader().getMiniAppInfoForReport());
        if (getRuntimeLoader().getMiniAppInfoForReport() != null) {
            str = getRuntimeLoader().getMiniAppInfoForReport().appId;
        }
        QMLog.d(BaseRuntimeLoader.TAG, "startLoadBaseLib. appid:" + str);
        if (isBaseLibInit()) {
            onTaskSucceed();
            return;
        }
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 10, "0");
        loadBaselib();
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 11, "0");
        if (isBaseLibInit()) {
            MiniAppStartState.isBaseLibLoaded = true;
            onTaskSucceed();
        } else {
            onTaskFailed();
        }
    }

    public BaselibLoader.BaselibContent getBaselibContent() {
        return this.mBaselibContent;
    }

    public boolean isBaseLibInit() {
        BaselibLoader.BaselibContent baselibContent = this.mBaselibContent;
        if (baselibContent != null && baselibContent.isBaseLibInited()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0263 A[Catch: all -> 0x02d2, TRY_LEAVE, TryCatch #0 {all -> 0x02d2, blocks: (B:5:0x004b, B:7:0x0055, B:9:0x005b, B:10:0x018d, B:12:0x0196, B:14:0x019c, B:18:0x01cf, B:21:0x01d7, B:22:0x025d, B:24:0x0263, B:33:0x01aa), top: B:4:0x004b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02e2 A[Catch: all -> 0x02e6, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:26:0x02dc, B:28:0x02e2, B:35:0x02d3, B:5:0x004b, B:7:0x0055, B:9:0x005b, B:10:0x018d, B:12:0x0196, B:14:0x019c, B:18:0x01cf, B:21:0x01d7, B:22:0x025d, B:24:0x0263, B:33:0x01aa), top: B:2:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void loadBaselib() {
        boolean z16;
        BaselibLoader.BaselibContent baselibContent = new BaselibLoader.BaselibContent();
        String string = StorageUtil.getPreference().getString("downloadUrl", "");
        String string2 = StorageUtil.getPreference().getString("version", "1.74.3.00001");
        QMLog.i(TAG, "execute baseLibLoad task. url=" + string + " version=" + string2);
        String baseLibDir = BaseLibManager.g().getBaseLibDir(string, string2);
        try {
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            if (miniAppProxy != null && miniAppProxy.isDebugVersion()) {
                QMLog.d(TAG, "readJsFromFile from sdcard.");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                String str = File.separator;
                sb5.append(str);
                baselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(sb5.toString(), "QView.js"));
                baselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str, "QLogic.js"));
                baselibContent.waServicePath = Environment.getExternalStorageDirectory().getAbsolutePath() + str + "QLogic.js";
                StringBuilder sb6 = new StringBuilder();
                sb6.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                sb6.append(str);
                baselibContent.waConsoleJsStr = FileUtils.readFileToStr(new File(sb6.toString(), "QVConsole.js"));
                baselibContent.waRemoteDebugStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str, "QRemoteDebug.js"));
                baselibContent.miniappWebviewStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str, "QWebview.js"));
                baselibContent.waWorkerStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str, "QWorker.js"));
                baselibContent.pageFrameStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str, "QPageFrame.html"));
                baselibContent.version = "1.74.3.00001";
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "readJsFromFile failed.", th5);
        }
        if (!BaseLibInfo.needUpdateVersion("1.74.3.00001", string2) && (TextUtils.isEmpty(baseLibDir) || BaseLibManager.verifyBaselib(new File(baseLibDir)))) {
            z16 = true;
            if (!baselibContent.isBaseLibInited() && z16) {
                QMLog.d(TAG, "readJsFromFile from download.");
                baselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(baseLibDir, "QView.js"));
                baselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(baseLibDir, "QLogic.js"));
                baselibContent.waServicePath = baseLibDir + File.separator + "QLogic.js";
                baselibContent.waConsoleJsStr = FileUtils.readFileToStr(new File(baseLibDir, "QVConsole.js"));
                baselibContent.waRemoteDebugStr = FileUtils.readFileToStr(new File(baseLibDir, "QRemoteDebug.js"));
                baselibContent.miniappWebviewStr = FileUtils.readFileToStr(new File(baseLibDir, "QWebview.js"));
                baselibContent.waWorkerStr = FileUtils.readFileToStr(new File(baseLibDir, "QWorker.js"));
                baselibContent.pageFrameStr = FileUtils.readFileToStr(new File(baseLibDir, "QPageFrame.html"));
                baselibContent.version = string2;
            }
            if (!baselibContent.isBaseLibInited()) {
                QMLog.d(TAG, "readJsFromFile from Assets.");
                baselibContent.waWebviewJsStr = FileUtils.readFileFromAssets(getContext(), "mini/QView.js");
                baselibContent.waServiceJsStr = FileUtils.readFileFromAssets(getContext(), "mini/QLogic.js");
                baselibContent.waServicePath = "assets://mini/QLogic.js";
                baselibContent.waConsoleJsStr = FileUtils.readFileFromAssets(getContext(), "mini/QVConsole.js");
                baselibContent.waRemoteDebugStr = FileUtils.readFileFromAssets(getContext(), "mini/QRemoteDebug.js");
                baselibContent.miniappWebviewStr = FileUtils.readFileFromAssets(getContext(), "mini/QWebview.js");
                baselibContent.waWorkerStr = FileUtils.readFileFromAssets(getContext(), "mini/QWorker.js");
                baselibContent.pageFrameStr = FileUtils.readFileFromAssets(getContext(), "mini/QPageFrame.html");
                baselibContent.version = "1.74.3.00001";
            }
            if (baselibContent.isBaseLibInited()) {
                this.mBaselibContent = baselibContent;
            }
        }
        QMLog.e(TAG, "download baselib invalid! use assert baselib. download_version=" + string2 + " assert_version=1.74.3.00001");
        z16 = false;
        if (!baselibContent.isBaseLibInited()) {
            QMLog.d(TAG, "readJsFromFile from download.");
            baselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(baseLibDir, "QView.js"));
            baselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(baseLibDir, "QLogic.js"));
            baselibContent.waServicePath = baseLibDir + File.separator + "QLogic.js";
            baselibContent.waConsoleJsStr = FileUtils.readFileToStr(new File(baseLibDir, "QVConsole.js"));
            baselibContent.waRemoteDebugStr = FileUtils.readFileToStr(new File(baseLibDir, "QRemoteDebug.js"));
            baselibContent.miniappWebviewStr = FileUtils.readFileToStr(new File(baseLibDir, "QWebview.js"));
            baselibContent.waWorkerStr = FileUtils.readFileToStr(new File(baseLibDir, "QWorker.js"));
            baselibContent.pageFrameStr = FileUtils.readFileToStr(new File(baseLibDir, "QPageFrame.html"));
            baselibContent.version = string2;
        }
        if (!baselibContent.isBaseLibInited()) {
        }
        if (baselibContent.isBaseLibInited()) {
        }
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskSucceed() {
        super.onTaskSucceed();
        MiniAppReportManager2.reportLaunchPiecewise(205, "", getRuntimeLoader().getMiniAppInfoForReport());
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void reset() {
        super.reset();
        this.mBaselibContent = null;
    }
}
