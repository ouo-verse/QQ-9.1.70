package com.tencent.mobileqq.zplan.statussquare.api;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/statussquare/api/IZPlanStatusSquareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createStatusSquareListFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "isZPlanStatusSquareEnable", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanStatusSquareApi extends QRouteApi {
    @Nullable
    QPublicBaseFragment createStatusSquareListFragment();

    boolean isZPlanStatusSquareEnable();
}
