package com.tencent.robot.adelie.homepage.create;

import androidx.lifecycle.Observer;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernel/nativeinterface/MyBotInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AdelieCreationFragment$botInfoObserver$2 extends Lambda implements Function0<Observer<MyBotInfo>> {
    final /* synthetic */ AdelieCreationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieCreationFragment$botInfoObserver$2(AdelieCreationFragment adelieCreationFragment) {
        super(0);
        this.this$0 = adelieCreationFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieCreationFragment this$0, MyBotInfo botInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(botInfo, "botInfo");
        this$0.Xi(botInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Observer<MyBotInfo> invoke() {
        final AdelieCreationFragment adelieCreationFragment = this.this$0;
        return new Observer() { // from class: com.tencent.robot.adelie.homepage.create.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdelieCreationFragment$botInfoObserver$2.b(AdelieCreationFragment.this, (MyBotInfo) obj);
            }
        };
    }
}
