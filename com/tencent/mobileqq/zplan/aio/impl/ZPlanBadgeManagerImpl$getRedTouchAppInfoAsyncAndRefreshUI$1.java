package com.tencent.mobileqq.zplan.aio.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanBadgeManagerImpl$getRedTouchAppInfoAsyncAndRefreshUI$1 extends Lambda implements Function1<BusinessInfoCheckUpdate.AppInfo, Unit> {
    final /* synthetic */ boolean $needGuide;
    final /* synthetic */ ZPlanBadgeManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBadgeManagerImpl$getRedTouchAppInfoAsyncAndRefreshUI$1(ZPlanBadgeManagerImpl zPlanBadgeManagerImpl, boolean z16) {
        super(1);
        this.this$0 = zPlanBadgeManagerImpl;
        this.$needGuide = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanBadgeManagerImpl this$0, BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleRefreshRedTouch(appInfo, z16);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BusinessInfoCheckUpdate.AppInfo appInfo) {
        invoke2(appInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZPlanBadgeManagerImpl zPlanBadgeManagerImpl = this.this$0;
            final boolean z16 = this.$needGuide;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.r
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBadgeManagerImpl$getRedTouchAppInfoAsyncAndRefreshUI$1.b(ZPlanBadgeManagerImpl.this, appInfo, z16);
                }
            });
        }
    }
}
