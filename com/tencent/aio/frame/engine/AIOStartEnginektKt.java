package com.tencent.aio.frame.engine;

import com.tencent.aio.frame.api.DrawerFrameScrollMsgIntent;
import com.tencent.aio.frame.drawer.AIOFrameDrawerProvider;
import com.tencent.aio.main.engine.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/main/engine/b;", "Lcom/tencent/aio/frame/engine/a;", "param", "Lcom/tencent/aio/api/perf/a;", "startUpTimeCallback", "Lus/a;", "a", "core-frame-ktx_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AIOStartEnginektKt {
    /* JADX WARN: Type inference failed for: r8v1, types: [T, us.a] */
    @NotNull
    public static final us.a a(@NotNull b startAIOFragmentWithFrame, @NotNull a param, @Nullable com.tencent.aio.api.perf.a aVar) {
        Intrinsics.checkNotNullParameter(startAIOFragmentWithFrame, "$this$startAIOFragmentWithFrame");
        Intrinsics.checkNotNullParameter(param, "param");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        ?? g16 = startAIOFragmentWithFrame.g(param.a(), param.d(), param.b(), aVar, new AIOFrameDrawerProvider(param.c(), new Function2<Integer, Integer, Unit>() { // from class: com.tencent.aio.frame.engine.AIOStartEnginektKt$startAIOFragmentWithFrame$drawerFrameProvider$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) Ref.ObjectRef.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                us.a aVar2 = (us.a) Ref.ObjectRef.this.element;
                if (aVar2 != null) {
                    aVar2.a(new DrawerFrameScrollMsgIntent(i3, i16));
                }
            }
        }));
        objectRef.element = g16;
        return (us.a) g16;
    }

    public static /* synthetic */ us.a b(b bVar, a aVar, com.tencent.aio.api.perf.a aVar2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar2 = null;
        }
        return a(bVar, aVar, aVar2);
    }
}
