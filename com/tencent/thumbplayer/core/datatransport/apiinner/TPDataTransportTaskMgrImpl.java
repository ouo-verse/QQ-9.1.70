package com.tencent.thumbplayer.core.datatransport.apiinner;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.resourceloader.TPDownloadProxyResourceLoaderAdapter;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public class TPDataTransportTaskMgrImpl implements ITPDataTransportTaskMgr {
    private final ITPDataTransportLog mLogger;
    private final TPDownloadProxyResourceLoaderAdapter mResourceLoaderAdapter;
    private boolean mUseService;

    public TPDataTransportTaskMgrImpl(boolean z16) {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportTaskMgrImpl");
        this.mLogger = logger;
        this.mResourceLoaderAdapter = new TPDownloadProxyResourceLoaderAdapter();
        logger.i("construct start, use service:" + z16);
        this.mUseService = z16;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public int createMultiTask(List<TPDataTransportTaskParam> list, ITPDataTransportTaskMgr.TaskListener taskListener) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.createMultiTask(list, taskListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPDataTransportTaskMgr.TaskListener taskListener) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.createTask(tPDataTransportTaskParam, taskListener);
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public ArrayList<String> getMultiProxyUrlList(int i3, int i16) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.getMultiProxyUrlList(i3, i16);
        }
        return new ArrayList<>();
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public String getProxyUrl(int i3, int i16) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.getProxyUrl(i3, i16);
        }
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public String getTaskAccessibleNativeInfo(int i3, int i16) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.getTaskAccessibleNativeInfo(i3, i16);
        }
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public String getTaskErrorCode(int i3) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            return dataTransport.getTaskErrorCode(i3);
        }
        return "";
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public void pauseTask(int i3) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.pauseTask(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public void resumeTask(int i3) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.resumeTask(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public void setTaskOptionalConfigParam(int i3, String str, String str2) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.setTaskOptionalConfigParam(i3, str, str2);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public void setTaskResourceLoaderListener(int i3, ITPDataTransportResourceLoaderListener iTPDataTransportResourceLoaderListener) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        this.mResourceLoaderAdapter.addResourceLoaderListener(i3, iTPDataTransportResourceLoaderListener);
        dataTransport.setTaskResourceLoaderListener(i3, this.mResourceLoaderAdapter);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public void stopTask(int i3) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.stopTask(i3);
            this.mResourceLoaderAdapter.removeResourceLoaderListener(i3);
        }
    }

    @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr
    public void updateRunningTaskParam(int i3, ArrayList<TPDataTransportTaskParam> arrayList) {
        ITPDataTransportTask dataTransport = TPDataTransportFactory.getInstance().getDataTransport(this.mUseService);
        if (dataTransport != null) {
            dataTransport.updateRunningTaskParam(i3, arrayList);
        }
    }
}
