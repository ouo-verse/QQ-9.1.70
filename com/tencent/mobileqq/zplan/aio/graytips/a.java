package com.tencent.mobileqq.zplan.aio.graytips;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.zplan.api.IZPlanAIOGrayTipApi;
import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/graytips/a;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$a;", "a", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$a;", "()Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$a;", PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, "<init>", "(Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$a;)V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IZPlanAIOGrayTipApi.GrayTipInfo actionData;

    public a(IZPlanAIOGrayTipApi.GrayTipInfo actionData) {
        Intrinsics.checkNotNullParameter(actionData, "actionData");
        this.actionData = actionData;
    }

    /* renamed from: a, reason: from getter */
    public final IZPlanAIOGrayTipApi.GrayTipInfo getActionData() {
        return this.actionData;
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        return 88;
    }
}
