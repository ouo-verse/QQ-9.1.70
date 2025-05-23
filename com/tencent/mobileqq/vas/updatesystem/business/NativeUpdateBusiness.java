package com.tencent.mobileqq.vas.updatesystem.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NativeUpdateBusiness extends BaseUpdateBusiness {
    private static final String TAG = "VasUpdate_NativeUpdateBusiness";

    private void onCompleted(@NonNull UpdateListenerParams updateListenerParams) {
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        if (businessUpdateParams == null) {
            return;
        }
        long j3 = businessUpdateParams.mBid;
        String str = businessUpdateParams.mScid;
        String str2 = businessUpdateParams.mFrom;
        int i3 = updateListenerParams.mErrorCode;
        int i16 = updateListenerParams.mHttpCode;
        QLog.d(TAG, 1, "onCompleted bid = " + j3 + " scid = " + str + " from = " + str2 + " message = " + updateListenerParams.mErrorMessage + " errorCode = " + i3 + " httpCode = " + i16);
        BaseUpdateCallback callback = UpdateCallbackSelector.getCallback(j3);
        if (callback != null) {
            callback.onCompleted(j3, str, "", str2, i3, i16);
        }
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    public void deleteFile(@NonNull BusinessUpdateParams businessUpdateParams, BusinessItemInfo businessItemInfo) {
        long j3 = businessUpdateParams.mBid;
        String str = businessUpdateParams.mScid;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteFiles bid = " + j3 + " scid = " + str);
        }
        BaseUpdateCallback callback = UpdateCallbackSelector.getCallback(j3);
        if (callback != null) {
            callback.deleteFiles(j3, str);
        }
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 0L;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public BusinessItemInfo getBusinessItemInfo(long j3, String str) {
        BaseUpdateCallback callback = UpdateCallbackSelector.getCallback(j3);
        if (callback == null) {
            return null;
        }
        BusinessItemInfo businessItemInfo = new BusinessItemInfo();
        businessItemInfo.mIsCanUpdate = callback.canUpdate(j3, str, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "canUpdate bid = " + j3 + " scid = " + str + " mIsCanUpdate = " + businessItemInfo.mIsCanUpdate);
        }
        TagItemInfo itemInfo = callback.getItemInfo(j3, str);
        if (itemInfo == null) {
            return null;
        }
        String str2 = itemInfo.strSavePath;
        businessItemInfo.mSavePath = str2;
        businessItemInfo.mSaveInDir = itemInfo.bSaveInDir;
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "getBusinessItemInfo doesn't set savePath , bid = " + j3 + " , scid = " + str);
            return null;
        }
        return businessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "NativeUpdateBusiness";
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    public boolean isFileExist(@NonNull BusinessUpdateParams businessUpdateParams, BusinessItemInfo businessItemInfo) {
        long j3 = businessUpdateParams.mBid;
        String str = businessUpdateParams.mScid;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isFileExists bid = " + j3 + " scid = " + str);
        }
        BaseUpdateCallback callback = UpdateCallbackSelector.getCallback(j3);
        if (callback != null && callback.isFileExists(j3, str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        super.onLoadFail(updateListenerParams);
        onCompleted(updateListenerParams);
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
        super.onLoadSuccess(updateListenerParams);
        onCompleted(updateListenerParams);
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onProgress(@NonNull UpdateListenerParams updateListenerParams) {
        super.onProgress(updateListenerParams);
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        if (businessUpdateParams == null) {
            return;
        }
        long j3 = businessUpdateParams.mBid;
        String str = businessUpdateParams.mScid;
        long j16 = updateListenerParams.mProgress;
        long j17 = updateListenerParams.mProgressMax;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onProgress bid = " + j3 + " scid = " + str + " dwProgress = " + j16 + " dwProgressMax = " + j17);
        }
        BaseUpdateCallback callback = UpdateCallbackSelector.getCallback(j3);
        if (callback != null) {
            callback.onProgress(j3, str, "", j16, j17);
        }
    }
}
