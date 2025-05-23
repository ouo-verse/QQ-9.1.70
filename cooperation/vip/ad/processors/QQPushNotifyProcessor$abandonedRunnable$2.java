package cooperation.vip.ad.processors;

import cooperation.vip.tianshu.TianShuManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class QQPushNotifyProcessor$abandonedRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ QQPushNotifyProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQPushNotifyProcessor$abandonedRunnable$2(QQPushNotifyProcessor qQPushNotifyProcessor) {
        super(0);
        this.this$0 = qQPushNotifyProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQPushNotifyProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adItem = null;
        TianShuManager.getInstance().clearAdShowStatus(1401);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        final QQPushNotifyProcessor qQPushNotifyProcessor = this.this$0;
        return new Runnable() { // from class: cooperation.vip.ad.processors.d
            @Override // java.lang.Runnable
            public final void run() {
                QQPushNotifyProcessor$abandonedRunnable$2.b(QQPushNotifyProcessor.this);
            }
        };
    }
}
