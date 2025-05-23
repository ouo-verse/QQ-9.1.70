package com.tencent.vas.update.business;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.vas.update.request.TaskBatchUrlRsp;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class BaseUpdateBusiness implements IBusinessCallback {
    private static final String TAG = "VasUpdate_BaseUpdateBusiness";
    private static WeakReference<IUpdateListener> weakListener;

    public void addUpdateListener(IUpdateListener iUpdateListener) {
        if (iUpdateListener != null) {
            weakListener = new WeakReference<>(iUpdateListener);
        }
    }

    public void cancelDownload(long j3, String str) {
        VasUpdateWrapper.getVasUpdateSystem().l(j3, str);
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public void deleteFile(@NonNull BusinessUpdateParams businessUpdateParams, BusinessItemInfo businessItemInfo) {
        if (businessItemInfo == null) {
            return;
        }
        FileUtil.safeDeleteFile(new File(businessItemInfo.mSavePath), "");
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public boolean isFileExist(@NonNull BusinessUpdateParams businessUpdateParams, BusinessItemInfo businessItemInfo) {
        if (businessItemInfo == null) {
            return false;
        }
        return new File(businessItemInfo.mSavePath).exists();
    }

    @Override // com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        IUpdateListener iUpdateListener;
        WeakReference<IUpdateListener> weakReference = weakListener;
        if (weakReference != null && (iUpdateListener = weakReference.get()) != null) {
            iUpdateListener.onLoadFail(updateListenerParams);
        }
    }

    @Override // com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
        IUpdateListener iUpdateListener;
        WeakReference<IUpdateListener> weakReference = weakListener;
        if (weakReference != null && (iUpdateListener = weakReference.get()) != null) {
            iUpdateListener.onLoadSuccess(updateListenerParams);
        }
    }

    @Override // com.tencent.vas.update.callback.listener.IUpdateListener
    public void onProgress(@NonNull UpdateListenerParams updateListenerParams) {
        IUpdateListener iUpdateListener;
        WeakReference<IUpdateListener> weakReference = weakListener;
        if (weakReference != null && (iUpdateListener = weakReference.get()) != null) {
            iUpdateListener.onProgress(updateListenerParams);
        }
    }

    public void removeUpdateListener() {
        WeakReference<IUpdateListener> weakReference = weakListener;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public void startDownload(BusinessUpdateParams businessUpdateParams) {
        VasUpdateWrapper.getVasUpdateSystem().j(businessUpdateParams);
    }

    public void cancelDownload(String str) {
        VasUpdateWrapper.getVasUpdateSystem().l(getBid(), str);
    }

    public void startDownload(List<BusinessUpdateParams> list) {
        VasUpdateWrapper.getVasUpdateSystem().g(list);
    }

    public void startDownload(String str) {
        startDownload(new BusinessUpdateParams(getBid(), str, getFrom()));
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public void preHandleGetUrlRsp(TaskBatchUrlRsp taskBatchUrlRsp) {
    }
}
