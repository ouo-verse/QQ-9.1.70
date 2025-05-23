package com.tencent.mobileqq.setting.main.processor;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/setting/config/b;", "invoke", "()Lcom/tencent/mobileqq/setting/config/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class GXHItemProcessor$gxhConfig$2 extends Lambda implements Function0<com.tencent.mobileqq.setting.config.b> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXHItemProcessor$gxhConfig$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.m(com.tencent.mobileqq.setting.utils.o.f286768a, it, "em_bas_personal_dress_up_with_privilege_explicit", null, false, 8, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final com.tencent.mobileqq.setting.config.b invoke() {
        final Context context = this.$context;
        com.tencent.mobileqq.setting.config.b bVar = new com.tencent.mobileqq.setting.config.b("\u4e2a\u6027\u88c5\u626e\u4e0e\u7279\u6743\u5916\u663e", R.drawable.qui_skin_setting, "140129", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.setting.main.processor.GXHItemProcessor$gxhConfig$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ((IVasFragment) QRoute.api(IVasFragment.class)).startGHXSetting(context);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        });
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GXHItemProcessor$gxhConfig$2.b(view);
            }
        });
        return bVar;
    }
}
