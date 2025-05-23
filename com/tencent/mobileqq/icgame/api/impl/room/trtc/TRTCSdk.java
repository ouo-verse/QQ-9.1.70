package com.tencent.mobileqq.icgame.api.impl.room.trtc;

import android.content.Context;
import android.os.Looper;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudListener;
import java.io.File;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TRTCSdk {
    private static final int DELAY_CHECK_INIT = 1000;
    private static final String TAG = "TRTCSdk";
    public static final int TRTC_APP_ID = 1400799628;
    private static final IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private static volatile TRTCSdk instance = null;
    private boolean isLoading = false;
    private InitCallback initCallback = null;
    private TRTCCloud trtcCloud = null;
    private final Runnable checkInitRunnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.t
        @Override // java.lang.Runnable
        public final void run() {
            TRTCSdk.this.lambda$new$0();
        }
    };
    private final TRTCCloudListener.TRTCLogListener logListener = new TRTCCloudListener.TRTCLogListener() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.TRTCSdk.1
        @Override // com.tencent.trtc.TRTCCloudListener.TRTCLogListener
        public void onLog(String str, int i3, String str2) {
            if (TRTCSdk.iAegisLogApi == null) {
                return;
            }
            if (i3 == 0 || i3 == 1) {
                TRTCSdk.iAegisLogApi.d(TRTCSdk.TAG, "[" + str2 + "] " + str);
                return;
            }
            if (i3 == 2) {
                TRTCSdk.iAegisLogApi.i(TRTCSdk.TAG, "[" + str2 + "] " + str);
                return;
            }
            if (i3 == 3) {
                TRTCSdk.iAegisLogApi.w(TRTCSdk.TAG, "[" + str2 + "] " + str);
                return;
            }
            if (i3 == 4 || i3 == 5) {
                TRTCSdk.iAegisLogApi.e(TRTCSdk.TAG, "[" + str2 + "] " + str);
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface InitCallback {
        void onFailure();

        void onSuccess();
    }

    public static TRTCSdk getInstance() {
        if (instance == null) {
            synchronized (TRTCSdk.class) {
                if (instance == null) {
                    instance = new TRTCSdk();
                }
            }
        }
        return instance;
    }

    private void initTRTC(Context context) {
        this.trtcCloud = TRTCCloud.sharedInstance(context);
        TRTCCloud.setLogLevel(2);
        TRTCCloud.setLogListener(this.logListener);
        this.trtcCloud.setDefaultStreamRecvMode(true, true);
        iAegisLogApi.i(TAG, "initTRTC finish!");
    }

    private boolean isInit() {
        if (this.trtcCloud != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLibrary$1(boolean z16, String str, Context context) {
        QLog.i(TAG, 1, "initEngine onLoadResult isSuccess:" + z16);
        if (z16) {
            iAegisLogApi.i(TAG, "setLibraryPath: " + str + " file list:" + Arrays.toString(new File(str).list()));
            TXLiveBase.setLibraryPath(str);
            initTRTC(context);
            this.isLoading = false;
            notifyInitResult(true);
            return;
        }
        iAegisLogApi.e(TAG, "SoLoadManager.onLoadResult TRTC failed! ");
        this.isLoading = false;
        notifyInitResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLibrary$2(final Context context, final boolean z16, String str, final String str2) {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.r
            @Override // java.lang.Runnable
            public final void run() {
                TRTCSdk.this.lambda$loadLibrary$1(z16, str2, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (this.isLoading) {
            iAegisLogApi.e(TAG, "check and init trtc timeout!");
            notifyInitResult(false);
        }
    }

    private void loadLibrary(final Context context) {
        SoLoad.load("\u4e92\u52a8\u4e91\u73a9\u6cd5", SoLoadConstants.SONAME_TRTC, new SoLoad.LoadCallback() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.s
            @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
            public final void onLoad(boolean z16, String str, String str2) {
                TRTCSdk.this.lambda$loadLibrary$2(context, z16, str, str2);
            }
        });
    }

    private void notifyInitResult(boolean z16) {
        iAegisLogApi.i(TAG, "notifyInitResult isSuccess:" + z16 + " initCallback:" + this.initCallback);
        InitCallback initCallback = this.initCallback;
        if (initCallback != null) {
            if (z16) {
                initCallback.onSuccess();
            } else {
                initCallback.onFailure();
            }
            this.initCallback = null;
        }
    }

    private void runOnUIThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public void checkAndInit(Context context, @NotNull InitCallback initCallback) {
        this.initCallback = initCallback;
        IAegisLogApi iAegisLogApi2 = iAegisLogApi;
        iAegisLogApi2.i(TAG, "checkAndInit context:" + context + " callback:" + initCallback);
        if (context == null) {
            iAegisLogApi2.e(TAG, "checkAndInit fail! context is null!");
            notifyInitResult(false);
            return;
        }
        if (isInit()) {
            iAegisLogApi2.i(TAG, "checkAndInit had init! success");
            notifyInitResult(true);
            return;
        }
        ThreadManager.getUIHandler().removeCallbacks(this.checkInitRunnable);
        ThreadManager.getUIHandler().postDelayed(this.checkInitRunnable, 1000L);
        if (this.isLoading) {
            iAegisLogApi2.i(TAG, "init isLoading!");
        } else {
            this.isLoading = true;
            loadLibrary(context);
        }
    }

    public TRTCCloud getTRTCCloud() {
        return this.trtcCloud;
    }
}
