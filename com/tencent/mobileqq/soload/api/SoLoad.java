package com.tencent.mobileqq.soload.api;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.EstablishSetting;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoad {
    static IPatchRedirector $redirector_ = null;
    public static final String BIZ_TRTC_GROUP_LIVE = "\u7fa4\u76f4\u64ad";
    public static final String BIZ_TRTC_ICGAME = "\u4e92\u52a8\u4e91\u73a9\u6cd5";
    public static final String BIZ_TRTC_PARTY_HOUSE = "\u7ed3\u4f34";
    public static final String BIZ_TRTC_QQCHANNEL = "QQ\u9891\u9053";
    public static final String BIZ_TRTC_QQLIVE = "QQ\u76f4\u64ad";
    public static final String BIZ_TRTC_QQMINI = "QQ\u5c0f\u7a0b\u5e8f";
    public static final String BIZ_TRTC_YOLO = "\u6709\u4e50";
    public static final String BIZ_TRTC_ZPLAN = "QQ\u5c0f\u7a9d";
    private static final boolean IS_64_BIT = true;
    private static final String TAG = "SoLoad";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface LoadCallback {
        void onLoad(boolean z16, String str, String str2);
    }

    public SoLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$load$0(String str, String str2, LoadCallback loadCallback, int i3, LoadExtResult loadExtResult) {
        String loadExtResult2;
        String str3;
        String arrays;
        if (loadExtResult == null) {
            loadExtResult2 = "";
        } else {
            loadExtResult2 = loadExtResult.toString();
        }
        if (i3 == 0 && loadExtResult != null) {
            QLog.i(TAG, 1, "[SoLoad.load(" + str + ", " + str2 + ")] onLoadResult:" + loadExtResult2);
            String relatedFilesFolder = loadExtResult.getRelatedFilesFolder(str2);
            if (EstablishSetting.isCpu64Bit()) {
                str3 = "arm64-v8a";
            } else {
                str3 = "armeabi-v7a";
            }
            String str4 = relatedFilesFolder + File.separator + str3;
            if (!new File(str4).exists()) {
                QLog.e(TAG, 1, "SoLoad, " + str4 + " path not exist.");
                if (relatedFilesFolder == null) {
                    arrays = "null";
                } else {
                    arrays = Arrays.toString(new File(relatedFilesFolder).list());
                }
                QLog.e(TAG, 1, "SoLoad, rootPath files: " + arrays);
                report(str, str2, false, "real jni path not exist.");
                loadCallback.onLoad(false, "\u8d44\u6e90\u6587\u4ef6\u4e0d\u5b58\u5728", null);
                return;
            }
            report(str, str2, true);
            loadCallback.onLoad(true, "", str4);
            return;
        }
        report(str, str2, false);
        loadCallback.onLoad(false, loadExtResult2, null);
    }

    public static void load(final String str, final String str2, final LoadCallback loadCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && loadCallback != null) {
            SoLoadManager.getInstance().load(str2, new OnLoadListener() { // from class: com.tencent.mobileqq.soload.api.a
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    SoLoad.lambda$load$0(str, str2, loadCallback, i3, loadExtResult);
                }
            });
        } else {
            QLog.e(TAG, 1, "[SoLoad.load] params error");
        }
    }

    public static String loadSync(String str, String str2) {
        String loadExtResult;
        String str3;
        String arrays;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(str2);
            if (loadSync == null) {
                loadExtResult = "";
            } else {
                loadExtResult = loadSync.toString();
            }
            if (loadSync != null && loadSync.isSucc()) {
                QLog.i(TAG, 1, "[SoLoad.loadSync(" + str + ", " + str2 + ")] onLoadResult:" + loadExtResult);
                String relatedFilesFolder = loadSync.getRelatedFilesFolder(str2);
                if (EstablishSetting.isCpu64Bit()) {
                    str3 = "arm64-v8a";
                } else {
                    str3 = "armeabi-v7a";
                }
                String str4 = relatedFilesFolder + File.separator + str3;
                if (!new File(str4).exists()) {
                    QLog.e(TAG, 1, "SoLoad, " + str4 + " path not exist.");
                    if (relatedFilesFolder == null) {
                        arrays = "null";
                    } else {
                        arrays = Arrays.toString(new File(relatedFilesFolder).list());
                    }
                    QLog.e(TAG, 1, "SoLoad, rootPath files: " + arrays);
                    report(str, str2, false, "real jni path not exist.");
                    return null;
                }
                report(str, str2, true);
                return str4;
            }
            report(str, str2, false);
            return null;
        }
        QLog.e(TAG, 1, "[SoLoad.loadSync] params error");
        return null;
    }

    private static void report(String str, String str2, boolean z16) {
        report(str, str2, z16, "");
    }

    private static void report(String str, String str2, boolean z16, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_BIZ_NAME, str);
        hashMap.put("so_res_name", str2);
        hashMap.put(VRReportDefine$ReportParam.IS_SUCCESS, String.valueOf(z16));
        hashMap.put("reason", str3);
        VideoReport.reportEvent("ev_trtc_qqso_download", hashMap);
    }
}
