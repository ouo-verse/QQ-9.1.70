package kotlinx.coroutines;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u000fB0\u0012'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR7\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00078\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
final class InvokeOnCancelling extends JobCancellingNode {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _invoked$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");

    @NotNull
    private volatile /* synthetic */ int _invoked = 0;

    @NotNull
    private final Function1<Throwable, Unit> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancelling(@NotNull Function1<? super Throwable, Unit> function1) {
        this.handler = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
        invoke2(th5);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@Nullable Throwable cause) {
        if (_invoked$FU.compareAndSet(this, 0, 1)) {
            this.handler.invoke(cause);
        }
    }
}
