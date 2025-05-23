package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.mobileqq.qcoroutine.api.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class QTaskPool$execute$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ g $runnable;
    final /* synthetic */ QTaskPool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QTaskPool$execute$1(QTaskPool qTaskPool, g gVar) {
        super(0);
        this.this$0 = qTaskPool;
        this.$runnable = gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qTaskPool, (Object) gVar);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        e.e("execute,type: " + this.$runnable.e().c() + " ,name: " + this.$runnable.d(), null, 2, null);
        this.this$0.h().put(this.$runnable, new b(System.currentTimeMillis()));
        com.tencent.mobileqq.qcoroutine.api.a a16 = this.$runnable.a();
        if (a16 != null) {
            a16.a();
        }
        if (this.$runnable.j() == null || this.this$0.l().a() <= 1) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.this$0.i(), null, null, new QTaskPool$execute$1$lJob$1(this, null), 3, null);
            b bVar = this.this$0.h().get(this.$runnable);
            if (bVar != null) {
                bVar.l(launch$default);
                return;
            }
            return;
        }
        SerialExecutor j3 = this.this$0.j();
        if (j3 != null) {
            j3.d(this.$runnable);
        }
    }
}
