package com.tencent.mobileqq.zplan.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H&J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0003j\b\u0012\u0004\u0012\u00020\f`\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanNTPushApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onGetPushIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onHandlePushMsg", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", BaseConstants.EXTRA_PUSHID, "msgBuf", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanNTPushApi extends QRouteApi {
    @NotNull
    ArrayList<Long> onGetPushIdList();

    void onHandlePushMsg(@NotNull BaseQQAppInterface app, long pushId, @NotNull ArrayList<Byte> msgBuf);
}
