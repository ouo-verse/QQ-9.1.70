package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuideCustomizeGrayTipsApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/GuideCustomizeGrayTipsApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IGuideCustomizeGrayTipsApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "isNeedAddGuideCustomizeGrayTips", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GuideCustomizeGrayTipsApiImpl implements IGuideCustomizeGrayTipsApi {
    public static final String TAG = "IGuideCustomizeGrayTipsApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IGuideCustomizeGrayTipsApi
    public void isNeedAddGuideCustomizeGrayTips(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.graytip.CustomizeGrayTipsManager");
        com.tencent.mobileqq.graytip.a aVar = (com.tencent.mobileqq.graytip.a) manager;
        if (!aVar.d()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "do not need to insert guide customize gray tips to aioList");
                return;
            }
            return;
        }
        aVar.c();
        String highStr = HardCodeUtil.qqStr(R.string.f170810zq1);
        String wording = HardCodeUtil.qqStr(R.string.f170809zq0);
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(b16, com.tencent.guild.aio.util.a.e(g17), 2000L, 0, true, false, null, 72, null);
        Intrinsics.checkNotNullExpressionValue(highStr, "highStr");
        LocalGrayTip.LocalGrayTipBuilder j3 = LocalGrayTip.LocalGrayTipBuilder.j(localGrayTipBuilder, highStr, new com.tencent.qqnt.msg.graytip.c(), 0, 4, null);
        Intrinsics.checkNotNullExpressionValue(wording, "wording");
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(peekAppRuntime, LocalGrayTip.LocalGrayTipBuilder.i(j3, wording, 0, 2, null).m(), null);
    }
}
