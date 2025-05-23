package com.tencent.thumbplayer.core.datatransport.apiinner;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;

/* loaded from: classes26.dex */
public class TPDataTransportPreloadTaskMgrImpl implements ITPDataTransportPreloadTaskMgr {
    private final ITPDataTransportLog mLogger;
    private boolean mUseService;

    public TPDataTransportPreloadTaskMgrImpl(boolean z16) {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportPreloadTaskMgrImpl");
        this.mLogger = logger;
        logger.i("construct start, use service:" + z16);
        this.mUseService = z16;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr
    public int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportPreloadTaskMgr.PreloadTaskListener preloadTaskListener) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.createPreloadTask(tPDataTransportTaskParam, preloadTaskListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr
    public void setPreloadTaskOptionalConfigParam(int i3, String str, String str2) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.setTaskOptionalConfigParam(i3, str, str2);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr
    public void stopPreloadTask(int i3) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.stopTask(i3);
        }
    }
}
