package com.tencent.mobileqq.vas.updatesystem.api.impl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBridge;
import com.tencent.mobileqq.vas.updatesystem.business.NativeUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IRemoteVasUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasUpdateBridgeImpl implements IVasUpdateBridge {
    private final String TAG = "VasUpdateBridgeImpl";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends EIPCCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IRemoteVasUpdateListener f311158d;

        a(IRemoteVasUpdateListener iRemoteVasUpdateListener) {
            this.f311158d = iRemoteVasUpdateListener;
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) {
            Bundle bundle;
            if (eIPCResult != null && (bundle = eIPCResult.data) != null && bundle.getParcelable("data") != null) {
                VasUpdateBridgeImpl.this.notifyRemoteListener((VasUpdateParcelableParams) eIPCResult.data.getParcelable("data"), this.f311158d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends EIPCCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IRemoteVasUpdateListener f311160d;

        b(IRemoteVasUpdateListener iRemoteVasUpdateListener) {
            this.f311160d = iRemoteVasUpdateListener;
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) {
            Bundle bundle;
            if (eIPCResult != null && (bundle = eIPCResult.data) != null && bundle.getParcelable("data") != null) {
                VasUpdateBridgeImpl.this.notifyRemoteListener((VasUpdateParcelableParams) eIPCResult.data.getParcelable("data"), this.f311160d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRemoteListener(VasUpdateParcelableParams vasUpdateParcelableParams, IRemoteVasUpdateListener iRemoteVasUpdateListener) {
        if (vasUpdateParcelableParams != null && iRemoteVasUpdateListener != null) {
            if (vasUpdateParcelableParams.mIsLoading) {
                iRemoteVasUpdateListener.onProgress(vasUpdateParcelableParams);
            } else if (vasUpdateParcelableParams.mIsSuccess) {
                iRemoteVasUpdateListener.onLoadSuccess(vasUpdateParcelableParams);
            } else {
                iRemoteVasUpdateListener.onLoadFail(vasUpdateParcelableParams);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBridge
    @Nullable
    public BaseUpdateBusiness getNativeUpdateBusiness() {
        return new NativeUpdateBusiness();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBridge
    public <T extends QQVasUpdateBusiness<?>> void startRemoteDownload(@NonNull Class<T> cls, @NonNull String str, @NonNull String str2, @NonNull IRemoteVasUpdateListener iRemoteVasUpdateListener) {
        if (QLog.isColorLevel()) {
            QLog.i("VasUpdateBridgeImpl", 1, "startRemoteDownload scid = " + str + " cls = " + cls.getSimpleName());
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null || mobileQQ.peekAppRuntime() == null) {
            return;
        }
        ((IVasService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasService.class, "all")).getVasUpdateManager().startRemoteDownload(cls, str, str2, new a(iRemoteVasUpdateListener));
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBridge
    public <T extends QQVasUpdateBusiness<?>> void startRemoteDownload(@NonNull Class<T> cls, @NonNull List<? extends BusinessUpdateParams> list, @NonNull String str, @NonNull IRemoteVasUpdateListener iRemoteVasUpdateListener) {
        if (QLog.isColorLevel() && list != null && !list.isEmpty()) {
            Iterator<? extends BusinessUpdateParams> it = list.iterator();
            while (it.hasNext()) {
                QLog.i("VasUpdateBridgeImpl", 1, "startRemoteDownload scid = " + it.next().mScid + " cls = " + cls.getSimpleName());
            }
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null || mobileQQ.peekAppRuntime() == null) {
            return;
        }
        ((IVasService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasService.class, "all")).getVasUpdateManager().startRemoteDownload((Class) cls, (List<BusinessUpdateParams>) list, str, (EIPCCallback) new b(iRemoteVasUpdateListener));
    }
}
