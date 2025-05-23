package com.tencent.mobileqq.zplan.statussquare.api.impl;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.zplan.statussquare.ZPlanStatusSquareListFragment;
import com.tencent.mobileqq.zplan.statussquare.api.IZPlanStatusSquareApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/statussquare/api/impl/ZPlanStatusSquareApiImpl;", "Lcom/tencent/mobileqq/zplan/statussquare/api/IZPlanStatusSquareApi;", "()V", "createStatusSquareListFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "isZPlanStatusSquareEnable", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanStatusSquareApiImpl implements IZPlanStatusSquareApi {
    @Override // com.tencent.mobileqq.zplan.statussquare.api.IZPlanStatusSquareApi
    public QPublicBaseFragment createStatusSquareListFragment() {
        if (isZPlanStatusSquareEnable()) {
            return new ZPlanStatusSquareListFragment();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.statussquare.api.IZPlanStatusSquareApi
    public boolean isZPlanStatusSquareEnable() {
        return true;
    }
}
