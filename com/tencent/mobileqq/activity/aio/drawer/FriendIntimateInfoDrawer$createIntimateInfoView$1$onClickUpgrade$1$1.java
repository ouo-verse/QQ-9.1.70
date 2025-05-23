package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
final class FriendIntimateInfoDrawer$createIntimateInfoView$1$onClickUpgrade$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ FriendIntimateInfoDrawer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendIntimateInfoDrawer$createIntimateInfoView$1$onClickUpgrade$1$1(FriendIntimateInfoDrawer friendIntimateInfoDrawer, Context context) {
        super(0);
        this.this$0 = friendIntimateInfoDrawer;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, FriendIntimateInfoDrawer this$0) {
        View t16;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZPlanShowGuideApi iZPlanShowGuideApi = (IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class);
        t16 = this$0.t();
        iZPlanShowGuideApi.onShowBubbleTip(context, t16);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.s(true);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Context context = this.$context;
        final FriendIntimateInfoDrawer friendIntimateInfoDrawer = this.this$0;
        uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.drawer.c
            @Override // java.lang.Runnable
            public final void run() {
                FriendIntimateInfoDrawer$createIntimateInfoView$1$onClickUpgrade$1$1.b(context, friendIntimateInfoDrawer);
            }
        }, 500L);
    }
}
