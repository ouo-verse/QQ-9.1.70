package com.tencent.qcircle.tavcut;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qcircle.oscar.app.PAGSOLoadUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.report.TAVReportCenter;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import java.io.File;
import org.light.LightEngine;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TAVCut {
    private static final String PAG_SO_NAME = "liblibpag.so";
    private static final String TAG = "TAVCut";
    private static final String TAVKIT_SO_NAME = "libtav.so";
    private static String frameEmptyResPath = null;
    private static boolean isDebug = false;
    private static String lightBundleResPath;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface Callback {
        void onDone(int i3);
    }

    public static String getLightBundleResPath() {
        if (isDebug()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/light_assets/";
        }
        return lightBundleResPath;
    }

    public static String getPlaceHolderTemplatePath() {
        if (isDebug()) {
            return "/sdcard/tavcut/frame/none";
        }
        return frameEmptyResPath;
    }

    public static void initTAVCut(Context context, Callback callback) {
        initTAVCut(context, "", "", callback);
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setDebug(boolean z16) {
        isDebug = z16;
        TAVStickerHelper.setDebugMode(z16);
    }

    public static void initTAVCut(Context context, String str, String str2, Callback callback) {
        initTAVCut(context, str, str2, "", callback);
    }

    public static void initTAVCut(Context context, String str, String str2, String str3, Callback callback) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!ResourceLoadUtil.loadSoSync(str + TAVKIT_SO_NAME)) {
                    Logger.e(TAG, "tavkit so init failed");
                    if (callback != null) {
                        callback.onDone(-1);
                        return;
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!PAGSOLoadUtil.loadSoSync(str2 + PAG_SO_NAME)) {
                    Logger.e(TAG, "pag so init failed");
                    if (callback != null) {
                        callback.onDone(-2);
                        return;
                    }
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                AEStaticDetector.initDetector(str3);
                lightBundleResPath = new File(str3).getParent();
                frameEmptyResPath = lightBundleResPath + "/material/frame_empty";
                LightEngine.initAuth(context, "", "lightsdk_qq", QQWinkConstants.ENTRY_QQ_WORLD);
                if (TextUtils.isEmpty(lightBundleResPath) && callback != null) {
                    callback.onDone(-3);
                    return;
                }
            }
            if (!isDebug) {
                TAVReportCenter.init(context);
            }
            if (callback != null) {
                callback.onDone(0);
            }
        } catch (Exception e16) {
            Logger.e(e16);
            if (callback != null) {
                callback.onDone(-1);
            }
        }
    }
}
