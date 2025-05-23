package i81;

import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a9\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T", "Lcom/tencent/mvi/api/runtime/b;", "context", "Lkotlin/Function0;", "onNewInteraction", "onDefaultInteraction", "a", "(Lcom/tencent/mvi/api/runtime/b;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    public static final <T> T a(@Nullable b bVar, @NotNull Function0<? extends T> onNewInteraction, @NotNull Function0<? extends T> onDefaultInteraction) {
        k kVar;
        j e16;
        Intrinsics.checkNotNullParameter(onNewInteraction, "onNewInteraction");
        Intrinsics.checkNotNullParameter(onDefaultInteraction, "onDefaultInteraction");
        if (bVar != null && (e16 = bVar.e()) != null) {
            kVar = e16.k(RobotMsgIntent.GetSupportNewInteraction.f188690d);
        } else {
            kVar = null;
        }
        Intrinsics.checkNotNull(kVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.event.RobotMsgResult.SupportNewInteractionResult");
        if (((e.f) kVar).a()) {
            return onNewInteraction.invoke();
        }
        return onDefaultInteraction.invoke();
    }
}
