package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lc03/a;", "it", "", "invoke", "(Lc03/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPttContentComponent$updateSkinBubbleInfo$3$2$1 extends Lambda implements Function1<c03.a, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ c03.a $bubbleAnimDrawable;
    final /* synthetic */ AIOPttContentComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOPttContentComponent$updateSkinBubbleInfo$3$2$1(AIOPttContentComponent aIOPttContentComponent, c03.a aVar) {
        super(1);
        this.this$0 = aIOPttContentComponent;
        this.$bubbleAnimDrawable = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOPttContentComponent, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(c03.a bubbleAnimDrawable) {
        Intrinsics.checkNotNullParameter(bubbleAnimDrawable, "$bubbleAnimDrawable");
        bubbleAnimDrawable.stop();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c03.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull c03.a it) {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        handler = this.this$0.handler;
        final c03.a aVar = this.$bubbleAnimDrawable;
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.s
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttContentComponent$updateSkinBubbleInfo$3$2$1.b(c03.a.this);
            }
        });
    }
}
