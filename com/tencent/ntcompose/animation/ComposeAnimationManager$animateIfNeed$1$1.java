package com.tencent.ntcompose.animation;

import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.manager.BridgeManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/kuikly/core/base/event/a;", "it", "", "invoke", "(Lcom/tencent/kuikly/core/base/event/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ComposeAnimationManager$animateIfNeed$1$1 extends Lambda implements Function1<AnimationCompletionParams, Unit> {
    public static final ComposeAnimationManager$animateIfNeed$1$1 INSTANCE = new ComposeAnimationManager$animateIfNeed$1$1();

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimationCompletionParams animationCompletionParams) {
        invoke2(animationCompletionParams);
        return Unit.INSTANCE;
    }

    public ComposeAnimationManager$animateIfNeed$1$1() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AnimationCompletionParams it) {
        Map i3;
        Function0 function0;
        Intrinsics.checkNotNullParameter(it, "it");
        String u16 = BridgeManager.f117344a.u();
        i3 = ComposeAnimationManager.f339152a.i();
        Map map = (Map) i3.get(u16);
        if (map == null || (function0 = (Function0) map.get(it.getAnimationKey())) == null) {
            return;
        }
        function0.invoke();
    }
}
