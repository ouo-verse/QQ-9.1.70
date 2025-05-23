package com.tencent.biz.pubaccount.api;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppService;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountH5Manager extends QRouteApi {
    public static final String C2B_FIRE_PTT_DIR = "c2bPTT/";

    void cancleAllTask();

    void downloadPtt(Bundle bundle);

    void init(AppService appService, AppInterface appInterface);

    void startDownloadPic(Bundle bundle);

    void startUploadPic(Bundle bundle);

    void uploadPtt(Bundle bundle);
}
