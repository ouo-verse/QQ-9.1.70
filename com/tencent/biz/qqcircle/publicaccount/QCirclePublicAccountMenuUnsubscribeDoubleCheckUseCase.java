package com.tencent.biz.qqcircle.publicaccount;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/publicaccount/QCirclePublicAccountMenuUnsubscribeDoubleCheckUseCase;", "Lcom/tencent/biz/pubaccount/recentcontact/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QCirclePublicAccountMenuUnsubscribeDoubleCheckUseCase implements com.tencent.biz.pubaccount.recentcontact.b {
    @Override // com.tencent.biz.pubaccount.recentcontact.b
    public void a(@NotNull RecentContactInfo item) {
        boolean z16;
        final BaseQQAppInterface baseQQAppInterface;
        Intrinsics.checkNotNullParameter(item, "item");
        int i3 = item.chatType;
        long j3 = item.peerUin;
        if (i3 == 103 && j3 == AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN_LONGVALUE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        ((IQCirclePublicAccountMessageService) baseQQAppInterface.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountMenuUnsubscribeDoubleCheckUseCase$onMenuUnfollowClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportUnFollowInConversationActionSheet(BaseQQAppInterface.this, qCirclePublicAccountMessageInfo);
            }
        });
    }
}
