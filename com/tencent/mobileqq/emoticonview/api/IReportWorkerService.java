package com.tencent.mobileqq.emoticonview.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IReportWorkerService extends QRouteApi {
    Runnable createReportWorker(String str, boolean z16, IEmoticonMainPanel iEmoticonMainPanel, BaseQQAppInterface baseQQAppInterface, int i3);
}
