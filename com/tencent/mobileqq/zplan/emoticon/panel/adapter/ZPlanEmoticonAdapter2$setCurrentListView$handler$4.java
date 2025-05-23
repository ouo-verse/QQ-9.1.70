package com.tencent.mobileqq.zplan.emoticon.panel.adapter;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class ZPlanEmoticonAdapter2$setCurrentListView$handler$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonAdapter2$setCurrentListView$handler$4(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).setEmoticonNextOpenPage("\u52a8\u4f5c");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        i.Companion companion = i.INSTANCE;
        Context context = this.$context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.b(context, "em_zplan_portal_entrance_aio_actionsheet");
        C11736d.b(100, new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonAdapter2$setCurrentListView$handler$4.c();
            }
        });
    }
}
