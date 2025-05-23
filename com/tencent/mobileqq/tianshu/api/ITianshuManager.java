package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITianshuManager extends QRouteApi {
    public static final int BIZ_TYPE_SPLASH = 1;

    boolean isBizExecuted(int i3);

    void report(TianShuReportData tianShuReportData);

    void requestAdv(List<TianShuAdPosItemData> list, TianShuGetAdvCallback tianShuGetAdvCallback);
}
