package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/g;", "Lkotlin/coroutines/Continuation;", "", "continuation", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.mobileqq.qcoroutine.framework.QTaskPoolKt", f = "QTaskPool.kt", i = {0, 1, 2}, l = {183, 189, 191}, m = TencentLocation.RUN_MODE, n = {"$this$run", "$this$run", "$this$run"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes16.dex */
public final class QTaskPoolKt$run$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QTaskPoolKt$run$1(Continuation continuation) {
        super(continuation);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return QTaskPoolKt.b(null, this);
    }
}
