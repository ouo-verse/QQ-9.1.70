package com.tencent.qqmini.sdk.core.manager.impl;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InternalBaselibLoader extends BaselibLoader {
    public static final String TAG = "InternalBaselibLoader";

    @Override // com.tencent.qqmini.sdk.launcher.shell.BaselibLoader
    public synchronized void loadBaselib(Context context, BaselibLoader.OnLoadBaselibListener onLoadBaselibListener) {
        if (isBaseLibInit()) {
            if (onLoadBaselibListener != null) {
                onLoadBaselibListener.onResult(0, "", this.mBaselibContent.m247clone());
            }
            return;
        }
        BaselibLoader.BaselibContent baselibContent = new BaselibLoader.BaselibContent();
        baselibContent.waWebviewJsStr = FileUtils.readFileFromAssets(context, "mini/QView.js");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QLogic.js");
        if (file.exists() && file.isFile()) {
            Log.i(TAG, "load ServiceJs from " + file.getAbsolutePath());
            baselibContent.waServiceJsStr = FileUtils.readFileToStr(file);
            baselibContent.waServicePath = file.getAbsolutePath();
        } else {
            Log.i(TAG, "load ServiceJs from assets");
            baselibContent.waServiceJsStr = FileUtils.readFileFromAssets(context, "mini/QLogic.js");
            baselibContent.waServicePath = "assets://mini/QLogic.js";
        }
        baselibContent.waConsoleJsStr = FileUtils.readFileFromAssets(context, "mini/QVConsole.js");
        baselibContent.waRemoteDebugStr = FileUtils.readFileFromAssets(context, "mini/QRemoteDebug.js");
        baselibContent.miniappWebviewStr = FileUtils.readFileFromAssets(context, "mini/QWebview.js");
        baselibContent.waWorkerStr = FileUtils.readFileFromAssets(context, "mini/QWorker.js");
        setBaselib(baselibContent);
        if (onLoadBaselibListener != null) {
            if (isBaseLibInit()) {
                onLoadBaselibListener.onResult(0, "", this.mBaselibContent.m247clone());
            } else {
                onLoadBaselibListener.onResult(-1, "\u57fa\u7840\u5e93\u52a0\u8f7d\u5931\u8d25", null);
            }
        }
    }
}
