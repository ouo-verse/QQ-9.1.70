package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.api.IVasUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class at implements IVasUpdateManager {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EIPCCallback f308588a;

        a(EIPCCallback eIPCCallback) {
            this.f308588a = eIPCCallback;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(UpdateListenerParams updateListenerParams) {
            at.this.b(updateListenerParams, this.f308588a, false, false);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
            at.this.b(updateListenerParams, this.f308588a, true, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EIPCCallback f308590a;

        b(EIPCCallback eIPCCallback) {
            this.f308590a = eIPCCallback;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(UpdateListenerParams updateListenerParams) {
            at.this.b(updateListenerParams, this.f308590a, false, false);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
            at.this.b(updateListenerParams, this.f308590a, true, false);
        }
    }

    private VasUpdateParcelableParams a(UpdateListenerParams updateListenerParams) {
        if (updateListenerParams != null && updateListenerParams.mBusinessUpdateParams != null) {
            VasUpdateParcelableParams vasUpdateParcelableParams = new VasUpdateParcelableParams();
            BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
            vasUpdateParcelableParams.mFrom = businessUpdateParams.mFrom;
            vasUpdateParcelableParams.mBid = businessUpdateParams.mBid;
            vasUpdateParcelableParams.mScid = businessUpdateParams.mScid;
            vasUpdateParcelableParams.mErrorCode = updateListenerParams.mErrorCode;
            vasUpdateParcelableParams.mHttpCode = updateListenerParams.mHttpCode;
            vasUpdateParcelableParams.mProgress = updateListenerParams.mProgress;
            vasUpdateParcelableParams.mProgressMax = updateListenerParams.mProgressMax;
            vasUpdateParcelableParams.mProgressRate = updateListenerParams.mProgressRate;
            vasUpdateParcelableParams.mErrorMessage = updateListenerParams.mErrorMessage;
            return vasUpdateParcelableParams;
        }
        return new VasUpdateParcelableParams();
    }

    public void b(UpdateListenerParams updateListenerParams, EIPCCallback eIPCCallback, boolean z16, boolean z17) {
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = new Bundle();
        VasUpdateParcelableParams a16 = a(updateListenerParams);
        if (a16 != null) {
            a16.mIsSuccess = z16;
            a16.mIsLoading = z17;
            eIPCResult.data.putParcelable("data", a16);
        }
        try {
            eIPCCallback.callback(eIPCResult);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return getClass().getName();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUpdateManager
    public <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> cls, String str, EIPCCallback eIPCCallback) {
        startRemoteDownload(cls, str, (String) null, eIPCCallback);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUpdateManager
    public <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> cls, String str, String str2, EIPCCallback eIPCCallback) {
        QQVasUpdateBusiness businessInstance = QQVasUpdateBusinessUtil.getBusinessInstance(cls);
        businessInstance.addDownLoadListener(str, new a(eIPCCallback));
        BusinessUpdateParams businessUpdateParams = new BusinessUpdateParams(businessInstance.getBid(), str, businessInstance.getFrom());
        if (!TextUtils.isEmpty(str2)) {
            businessUpdateParams.mFrom = str2;
        }
        try {
            Iterator<IVasUpdateManager.a> it = IVasUpdateManager.INTERCEPTOR_LIST.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
        } catch (Exception e16) {
            QLog.w("VasUpdateManagerImpl", 1, "startRemoteDownload exception - 1", e16);
        }
        businessInstance.startDownload(businessUpdateParams);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUpdateManager
    public <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> cls, List<BusinessUpdateParams> list, String str, EIPCCallback eIPCCallback) {
        QQVasUpdateBusiness businessInstance = QQVasUpdateBusinessUtil.getBusinessInstance(cls);
        Iterator<BusinessUpdateParams> it = list.iterator();
        while (it.hasNext()) {
            businessInstance.addDownLoadListener(it.next().mScid, new b(eIPCCallback));
        }
        for (BusinessUpdateParams businessUpdateParams : list) {
            try {
                Iterator<IVasUpdateManager.a> it5 = IVasUpdateManager.INTERCEPTOR_LIST.iterator();
                while (it5.hasNext()) {
                    it5.next().a(businessUpdateParams.mScid);
                }
            } catch (Exception e16) {
                QLog.w("VasUpdateManagerImpl", 1, "startRemoteDownload exception - 2", e16);
            }
        }
        businessInstance.startDownload(list);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUpdateManager
    public void startRemoteDownload(long j3, String str, String str2) {
        try {
            Iterator<IVasUpdateManager.a> it = IVasUpdateManager.INTERCEPTOR_LIST.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
        } catch (Exception e16) {
            QLog.w("VasUpdateManagerImpl", 1, "startRemoteDownload exception - 3", e16);
        }
        ((IVasQuickUpdateService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(j3, str, str2);
    }
}
