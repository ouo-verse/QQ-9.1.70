package com.tencent.qqnt.aio.adapter.clickresponder;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/clickresponder/k;", "Lcom/tencent/qqnt/aio/adapter/clickresponder/b;", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/mobileqq/aio/msg/ah;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k extends b {
    @Override // com.tencent.qqnt.aio.adapter.clickresponder.b, com.tencent.qqnt.aio.adapter.clickresponder.e
    public void a(Context context, boolean isScaleChat, ah item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("SuperQQShowResponder", 1, "click tofu: " + item);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null) {
            QLog.e("SuperQQShowResponder", 1, "onSuperQQShowClick app is null");
            return;
        }
        ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Beancurd, ZootopiaSource.SUB_SOURCE_BEANCURD, null, 4, null);
        MasterInfo masterInfo = new MasterInfo();
        masterInfo.setUin(String.valueOf(item.getMsgRecord().peerUin));
        VisitorInfo visitorInfo = new VisitorInfo();
        visitorInfo.setUin(qQAppInterface.getCurrentAccountUin());
        ((IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class)).openSmallHomeTransitPage(context, new TransitPageInfo(masterInfo, visitorInfo, new TransitPageConfig(), new ExtInfo()), d16);
    }
}
