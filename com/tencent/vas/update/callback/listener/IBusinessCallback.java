package com.tencent.vas.update.callback.listener;

import androidx.annotation.NonNull;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.request.TaskBatchUrlRsp;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IBusinessCallback extends IUpdateListener {
    void deleteFile(@NonNull BusinessUpdateParams businessUpdateParams, BusinessItemInfo businessItemInfo);

    long getBid();

    BusinessItemInfo getBusinessItemInfo(long j3, String str);

    String getFrom();

    boolean isFileExist(@NonNull BusinessUpdateParams businessUpdateParams, BusinessItemInfo businessItemInfo);

    void preHandleGetUrlRsp(TaskBatchUrlRsp taskBatchUrlRsp);
}
