package com.tencent.thumbplayer.core.datatransport.apiinner;

import android.content.Context;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.client.TPDataTransportTaskClientImpl;
import com.tencent.thumbplayer.core.datatransport.service.TPDataTransportRemoteMgrWrapper;
import com.tencent.thumbplayer.core.datatransport.service.TPDataTransportServiceConfig;

/* loaded from: classes26.dex */
public class TPDataTransportFactory {
    private ITPDataTransportTask mDataTransport;
    private ITPDataTransportMgrBridge mMgrWrapper;
    private ITPDataTransportTask mRemoteDataTransport;
    private ITPDataTransportMgrBridge mRemoteMgrWrapper;
    private boolean mUseService = false;
    private boolean mIsServiceConnected = false;
    private Context mContext = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class SingletonHolder {
        private static final TPDataTransportFactory INSTANCE = new TPDataTransportFactory();

        SingletonHolder() {
        }
    }

    public static TPDataTransportFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ITPDataTransportTask getDataTransport(boolean z16) {
        if (this.mUseService && z16) {
            if (!this.mIsServiceConnected && TPDataTransportServiceConfig.enableMainProcessTemporary()) {
                getDefaultDataTransportMgr();
                ITPDataTransportMgrBridge iTPDataTransportMgrBridge = this.mMgrWrapper;
                if (iTPDataTransportMgrBridge != null && !iTPDataTransportMgrBridge.isNativeInit()) {
                    this.mMgrWrapper.setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_LIMIT_MODE, "1");
                    this.mMgrWrapper.init(this.mContext);
                }
                return this.mDataTransport;
            }
            return getRemoteDataTransport();
        }
        if (this.mDataTransport == null) {
            synchronized (TPDataTransportFactory.class) {
                if (this.mDataTransport == null) {
                    this.mDataTransport = new TPDataTransportTaskImpl();
                }
            }
        }
        return this.mDataTransport;
    }

    public ITPDataTransportMgrBridge getDataTransportMgr() {
        if (this.mUseService) {
            if (this.mRemoteMgrWrapper == null) {
                synchronized (TPDataTransportFactory.class) {
                    if (this.mRemoteMgrWrapper == null) {
                        this.mRemoteMgrWrapper = new TPDataTransportRemoteMgrWrapper();
                    }
                }
            }
            return this.mRemoteMgrWrapper;
        }
        return getDefaultDataTransportMgr();
    }

    public ITPDataTransportMgrBridge getDefaultDataTransportMgr() {
        if (this.mMgrWrapper == null) {
            synchronized (TPDataTransportFactory.class) {
                if (this.mMgrWrapper == null) {
                    this.mMgrWrapper = new TPDataTransportMgrWrapper();
                }
            }
        }
        return this.mMgrWrapper;
    }

    public ITPDataTransportTask getRemoteDataTransport() {
        if (this.mRemoteDataTransport == null) {
            synchronized (TPDataTransportFactory.class) {
                if (this.mRemoteDataTransport == null) {
                    this.mRemoteDataTransport = new TPDataTransportTaskClientImpl();
                }
            }
        }
        return this.mRemoteDataTransport;
    }

    public synchronized void init(Context context) {
        this.mContext = context;
    }

    public void setServiceConnected(boolean z16) {
        this.mIsServiceConnected = z16;
    }

    public void setUseService(boolean z16) {
        this.mUseService = z16;
    }
}
