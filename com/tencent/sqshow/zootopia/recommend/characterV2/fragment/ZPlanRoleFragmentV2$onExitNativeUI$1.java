package com.tencent.sqshow.zootopia.recommend.characterV2.fragment;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView;
import com.tencent.sqshow.zootopia.recommend.main.tab.a;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import n74.ck;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class ZPlanRoleFragmentV2$onExitNativeUI$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ZPlanRoleFragmentV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRoleFragmentV2$onExitNativeUI$1(ZPlanRoleFragmentV2 zPlanRoleFragmentV2) {
        super(0);
        this.this$0 = zPlanRoleFragmentV2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ck ckVar;
        AvatarRoleTitleView avatarRoleTitleView;
        ckVar = this.this$0.rootViewBinding;
        if (ckVar != null && (avatarRoleTitleView = ckVar.f419031g) != null) {
            avatarRoleTitleView.show();
        }
        Context context = this.this$0.getContext();
        final com.tencent.sqshow.zootopia.recommend.main.tab.a aVar = context != null ? (com.tencent.sqshow.zootopia.recommend.main.tab.a) CommonExKt.p(context, ZplanCacheComponentType.MAIN_TAB) : null;
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRoleFragmentV2$onExitNativeUI$1.b(com.tencent.sqshow.zootopia.recommend.main.tab.a.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.sqshow.zootopia.recommend.main.tab.a aVar) {
        if (aVar != null) {
            a.C9836a.b(aVar, true, null, 2, null);
        }
    }
}
