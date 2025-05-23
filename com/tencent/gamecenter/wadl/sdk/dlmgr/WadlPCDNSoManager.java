package com.tencent.gamecenter.wadl.sdk.dlmgr;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* loaded from: classes6.dex */
public class WadlPCDNSoManager {
    private static final String PCDN_TEGTRANS_SDK_SO_NAME = "PcdnTegTransSdk";
    private static final String TAG = "WadlPCDNSoManager";
    private static volatile WadlPCDNSoManager instance;
    private volatile boolean isPCDNSOReady = false;
    private static final byte[] LOCK = new byte[0];
    private static final String[] SO_LIST = {"apollo_pcdn"};

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private String checkSoReady() {
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(PCDN_TEGTRANS_SDK_SO_NAME, new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setCloseRetry(true).build());
        QLog.i(TAG, 1, "checkSoReady loadResult isSuccess:" + loadSync.isSucc() + ",failInfo:" + loadSync.failInfo + ",path:" + loadSync.getRelatedFilesFolder());
        if (!loadSync.isSucc()) {
            return null;
        }
        String relatedFilesFolder = loadSync.getRelatedFilesFolder();
        boolean z16 = true;
        for (String str : SO_LIST) {
            File file = new File(getSoFilePath(relatedFilesFolder, str));
            if (!file.exists()) {
                QLog.e(TAG, 1, "checkSoReady soFile:" + file + ",not exists");
                z16 = false;
            }
        }
        if (!z16) {
            return null;
        }
        return relatedFilesFolder;
    }

    public static WadlPCDNSoManager getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new WadlPCDNSoManager();
                }
            }
        }
        return instance;
    }

    private String getSoFilePath(String str, String str2) {
        return str + File.separator + RFixConstants.SO_PATH + str2 + ".so";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndLoadSoAsync$0(long j3, int i3, LoadExtResult loadExtResult) {
        try {
            String checkSoReady = checkSoReady();
            if (!TextUtils.isEmpty(checkSoReady)) {
                for (String str : SO_LIST) {
                    System.load(getSoFilePath(checkSoReady, str));
                }
                this.isPCDNSOReady = true;
            }
            QLog.i(TAG, 1, "checkAndLoadSoAsync,cost:" + (System.currentTimeMillis() - j3) + ",soFolderPath:" + checkSoReady);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndLoadSoAsync$1(final long j3) {
        try {
            SoLoadManager.getInstance().load(PCDN_TEGTRANS_SDK_SO_NAME, new OnLoadListener() { // from class: com.tencent.gamecenter.wadl.sdk.dlmgr.b
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    WadlPCDNSoManager.this.lambda$checkAndLoadSoAsync$0(j3, i3, loadExtResult);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void checkAndLoadSoAsync() {
        final long currentTimeMillis = System.currentTimeMillis();
        this.isPCDNSOReady = false;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.sdk.dlmgr.a
            @Override // java.lang.Runnable
            public final void run() {
                WadlPCDNSoManager.this.lambda$checkAndLoadSoAsync$1(currentTimeMillis);
            }
        }, 64, null, false);
    }

    public boolean checkAndLoadSoSync() {
        long currentTimeMillis = System.currentTimeMillis();
        this.isPCDNSOReady = false;
        try {
            String checkSoReady = checkSoReady();
            if (!TextUtils.isEmpty(checkSoReady)) {
                for (String str : SO_LIST) {
                    System.load(getSoFilePath(checkSoReady, str));
                }
                this.isPCDNSOReady = true;
            }
            QLog.i(TAG, 1, "checkAndLoadSoSync,cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",soFolderPath:" + checkSoReady);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return this.isPCDNSOReady;
    }

    public boolean isPCDNSOReady() {
        return this.isPCDNSOReady;
    }
}
