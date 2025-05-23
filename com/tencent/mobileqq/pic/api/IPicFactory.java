package com.tencent.mobileqq.pic.api;

import com.tencent.common.app.AppInterface;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicFactory extends QRouteApi {
    BaseCache getCache(AppInterface appInterface, DBDelayManager dBDelayManager);

    ProtocolDownloader getChatImageDownloader(BaseApplication baseApplication, String str);

    BaseTransProcessor getProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest);
}
