package com.tencent.mobileqq.minigame.va.util;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameVaConfigApi;
import com.tencent.mobileqq.minigame.va.MiniGameDiffPatchInfo;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.MiniGameVAImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import cs3.MetaDreamAppExtraInfo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes33.dex */
public class DiffPatchHandler {
    private static final String TAG = "MiniGameVADiffPatchHandler";

    public static void reportDownloadDiffError(String str, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper, int i3, String str2) {
        HashMap hashMap = new HashMap();
        if (miniGameDownloadDataWrapper.getData().getDiffPatchInfo() != null) {
            hashMap.put("ext7", miniGameDownloadDataWrapper.getData().getDiffPatchInfo().getBaseVersionName());
            hashMap.put("ext8", miniGameDownloadDataWrapper.getData().getDiffPatchInfo().getNewVersionName());
            hashMap.put("ext2", String.valueOf(i3));
            hashMap.put("ext6", str2);
        }
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989565", "18", str, hashMap);
    }

    public static void resDownloadVa(final MiniGameVAImpl miniGameVAImpl, String str) {
        miniGameVAImpl.queryVAInfo(str, new Function2<Boolean, MiniGameDownloadDataWrapper, Unit>() { // from class: com.tencent.mobileqq.minigame.va.util.DiffPatchHandler.3
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                if (bool.booleanValue() && miniGameDownloadDataWrapper != null) {
                    MiniGameVAImpl.this.getDownloadService().startDownload(miniGameDownloadDataWrapper);
                }
                QLog.i(DiffPatchHandler.TAG, 1, "resDownloadVa queryVAInfo dataWrapper:" + miniGameDownloadDataWrapper);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MiniGameDiffPatchInfo getPatchInfo(MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
        if (metaDreamAppExtraInfo == null || metaDreamAppExtraInfo.getDiffPatchInfo() == null) {
            return null;
        }
        return DiffPatchUtil.INSTANCE.json2DiffPatchInfo(metaDreamAppExtraInfo.getDiffPatchInfo());
    }

    public static void handleMiniBoxLowVersion(final MiniBoxAppInfo miniBoxAppInfo) {
        if (miniBoxAppInfo == null) {
            return;
        }
        if (!"com.tencent.letsgo".equals(miniBoxAppInfo.getPkgName())) {
            QLog.i(TAG, 1, "handleMiniBoxLowVersion only support meta dream app");
        } else {
            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).getExtraInfo(new cs3.c() { // from class: com.tencent.mobileqq.minigame.va.util.DiffPatchHandler.1
                @Override // cs3.c
                public void onExtraRsp(MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
                    MiniGameDiffPatchInfo patchInfo = DiffPatchHandler.getPatchInfo(metaDreamAppExtraInfo);
                    QLog.i(DiffPatchHandler.TAG, 1, "handleMiniBoxLowVersion onExtraRsp patchInfo:" + patchInfo);
                    if (patchInfo != null || MiniBoxAppInfo.this.getPkgName() == null) {
                        return;
                    }
                    ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).uninstallVirtualApp(MiniBoxAppInfo.this.getPkgName(), null);
                    QLog.i(DiffPatchHandler.TAG, 1, "handleMiniBoxLowVersion not patch, delete old version va app miniBoxAppInfo:" + MiniBoxAppInfo.this);
                }
            });
        }
    }

    public static void cancelPatchDownload(MiniGameVAImpl miniGameVAImpl, String str, ConcurrentHashMap<String, MiniGameDownloadDataWrapper> concurrentHashMap) {
        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper;
        if (miniGameVAImpl == null || concurrentHashMap == null || concurrentHashMap.isEmpty() || TextUtils.isEmpty(str) || (miniGameDownloadDataWrapper = concurrentHashMap.get(str)) == null || miniGameDownloadDataWrapper.getData().getDiffPatchInfo() == null) {
            return;
        }
        QLog.i(TAG, 1, "cancelPatchDownload downloadDataWrapper.data:" + miniGameDownloadDataWrapper.getData());
        miniGameVAImpl.cancelDownload(miniGameDownloadDataWrapper.getData().getGameId());
        reportDownloadDiffError(str, miniGameDownloadDataWrapper, -1, "download all apk");
    }

    public static void handleDiffPatchFailed(final MiniGameVAImpl miniGameVAImpl, final MiniGameDownloadData miniGameDownloadData, final String str) {
        if (miniGameVAImpl == null || miniGameDownloadData == null || TextUtils.isEmpty(miniGameDownloadData.getPkgName())) {
            return;
        }
        QLog.i(TAG, 1, "handleDiffPatchFailed pkgName:" + miniGameDownloadData.getPkgName() + " appId:" + str);
        ((IMiniGameVaConfigApi) QRoute.api(IMiniGameVaConfigApi.class)).setDiffPatchEnable(false);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.util.DiffPatchHandler.2
            @Override // java.lang.Runnable
            public void run() {
                DiffPatchHandler.resDownloadVa(MiniGameVAImpl.this, str);
                HashMap hashMap = new HashMap();
                if (miniGameDownloadData.getDiffPatchInfo() != null) {
                    hashMap.put("ext7", miniGameDownloadData.getDiffPatchInfo().getBaseVersionName());
                    hashMap.put("ext8", miniGameDownloadData.getDiffPatchInfo().getNewVersionName());
                }
                MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989564", "18", miniGameDownloadData.getGameId(), hashMap);
            }
        }, 16, null, false, 1000L);
    }
}
