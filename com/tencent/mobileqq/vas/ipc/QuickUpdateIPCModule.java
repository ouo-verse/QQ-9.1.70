package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.aidl.IDownloadListener;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class QuickUpdateIPCModule extends QIPCModule {
    private static String ACTION_DOWNLOAD = "download";
    private static String ACTION_QUERY_VERSION = "query_version";
    private static final String BID = "bid";
    private static final String BINDER = "binder";
    public static final String NAME = "QuickUpdateIPCModule";
    private static final String PARAMS = "params";
    private static final String SCID = "scid";
    private static final String TAG = "QuickUpdateIPCModule";
    private static QuickUpdateIPCModule sInstance;

    /* loaded from: classes20.dex */
    private static class Params implements Serializable {
        public boolean boolVal;
        public int intVal;
        public String strVal1;
        public String strVal2;

        Params() {
        }
    }

    /* loaded from: classes20.dex */
    private static class RemoteListener implements QuickUpdateListener, IBinder.DeathRecipient {
        private long bid;
        private IDownloadListener listener;
        private String scid;

        RemoteListener(long j3, String str, IDownloadListener iDownloadListener) {
            this.bid = j3;
            this.scid = str;
            this.listener = iDownloadListener;
            try {
                iDownloadListener.asBinder().linkToDeath(this, 0);
            } catch (RemoteException e16) {
                QLog.e("QuickUpdateIPCModule", 1, "linkToDeath fail: " + this, e16);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            QLog.e("QuickUpdateIPCModule", 1, "binderDied: " + this);
            UpdateCallbackSelector.getCallback(this.bid).removeListener(this.bid, this.scid, this);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener
        public void onCompleted(long j3, String str, String str2, String str3, int i3, int i16) {
            QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + i3 + ", " + this);
            try {
                this.listener.onComplete(str, i3);
            } catch (RemoteException e16) {
                QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + this, e16);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener
        public void onProgress(long j3, String str, String str2, long j16, long j17) {
            try {
                this.listener.onProgress(str, j16, j17);
            } catch (RemoteException e16) {
                QLog.e("QuickUpdateIPCModule", 1, "onProgress: " + this, e16);
            }
        }

        public String toString() {
            return this.bid + "_" + this.scid + "," + super.toString();
        }
    }

    public QuickUpdateIPCModule(String str) {
        super(str);
    }

    public static void download(long j3, String str, IDownloadListener iDownloadListener) {
        Bundle bundle = new Bundle();
        if (iDownloadListener != null) {
            bundle.putParcelable(BINDER, new BinderWarpper(iDownloadListener.asBinder()));
        }
        bundle.putLong(BID, j3);
        bundle.putString(SCID, str);
        QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", ACTION_DOWNLOAD, bundle, null);
    }

    public static synchronized QuickUpdateIPCModule getInstance() {
        QuickUpdateIPCModule quickUpdateIPCModule;
        synchronized (QuickUpdateIPCModule.class) {
            if (sInstance == null) {
                sInstance = new QuickUpdateIPCModule("QuickUpdateIPCModule");
            }
            quickUpdateIPCModule = sInstance;
        }
        return quickUpdateIPCModule;
    }

    @Nullable
    private QQVasUpdateBusiness getNewBusiness(long j3) {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(j3).booleanValue()) {
            try {
                return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(j3));
            } catch (Exception e16) {
                QLog.w("QuickUpdateIPCModule", 1, "isUseNewBusiness bid:" + j3, e16);
                return null;
            }
        }
        return null;
    }

    public static void queryItemVersion(int i3, String str, boolean z16, final QueryItemCallback queryItemCallback) {
        Params params = new Params();
        params.intVal = i3;
        params.boolVal = z16;
        params.strVal1 = str;
        Bundle bundle = new Bundle();
        bundle.putSerializable("params", params);
        QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", ACTION_QUERY_VERSION, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule.3
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                if (eIPCResult.code != 0) {
                    QueryItemCallback.this.onQueryItemVer(2, "", "");
                } else {
                    Params params2 = (Params) eIPCResult.data.getSerializable("params");
                    QueryItemCallback.this.onQueryItemVer(params2.intVal, params2.strVal1, params2.strVal2);
                }
            }
        });
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, final int i3) {
        final RemoteListener remoteListener;
        bundle.setClassLoader(BinderWarpper.class.getClassLoader());
        if (ACTION_DOWNLOAD.equals(str)) {
            long j3 = bundle.getLong(BID);
            final String string = bundle.getString(SCID);
            if (bundle.containsKey(BINDER)) {
                remoteListener = new RemoteListener(j3, string, IDownloadListener.Stub.asInterface(((BinderWarpper) bundle.getParcelable(BINDER)).binder));
            } else {
                remoteListener = null;
            }
            QLog.e("QuickUpdateIPCModule", 1, "download listener: " + remoteListener);
            QQVasUpdateBusiness newBusiness = getNewBusiness(j3);
            if (newBusiness != null) {
                if (newBusiness.isFileExist(string)) {
                    if (remoteListener != null) {
                        remoteListener.onCompleted(j3, string, "", "QuickUpdateIpcModule", 0, 0);
                    }
                } else {
                    newBusiness.addDownLoadListener(string, new IDownLoadListener() { // from class: com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule.1
                        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
                            if (remoteListener != null) {
                                BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
                                if (TextUtils.equals(businessUpdateParams.mScid, string)) {
                                    remoteListener.onCompleted(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode);
                                }
                            }
                        }

                        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
                            if (remoteListener != null) {
                                BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
                                if (TextUtils.equals(businessUpdateParams.mScid, string)) {
                                    remoteListener.onCompleted(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode);
                                }
                            }
                        }
                    });
                    newBusiness.startDownload(string);
                }
            } else {
                UpdateCallbackSelector.getCallback(j3).download(j3, string, remoteListener, false);
            }
        } else if (ACTION_QUERY_VERSION.equals(str)) {
            Params params = (Params) bundle.getSerializable("params");
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                QLog.e("QuickUpdateIPCModule", 1, "onCall fail null application");
                callbackResult(i3, EIPCResult.createResult(-102, bundle));
            } else {
                ((IVasQuickUpdateService) waitAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(params.intVal, params.strVal1, params.boolVal, false, 10000L, new QueryItemCallback() { // from class: com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule.2
                    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback
                    public void onQueryItemVer(int i16, String str2, String str3) {
                        Params params2 = new Params();
                        params2.intVal = i16;
                        params2.strVal1 = str2;
                        params2.strVal2 = str3;
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable("params", params2);
                        QuickUpdateIPCModule.this.callbackResult(i3, EIPCResult.createResult(0, bundle2));
                    }
                });
            }
        }
        return null;
    }
}
