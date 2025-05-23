package cooperation.vip.ad.processors;

import cooperation.vip.ad.GrowHalfLayerHelper;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class QQPushNotifyProcessor$runnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ QQPushNotifyProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQPushNotifyProcessor$runnable$2(QQPushNotifyProcessor qQPushNotifyProcessor) {
        super(0);
        this.this$0 = qQPushNotifyProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQPushNotifyProcessor this$0) {
        TianShuAccess.AdItem adItem;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        adItem = this$0.adItem;
        if (adItem != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("current_sence", "msgtab_stay");
            GrowHalfLayerHelper growHalfLayerHelper = GrowHalfLayerHelper.f391021a;
            str = this$0.traceId;
            this$0.A(growHalfLayerHelper.t(adItem, str, 1401, hashMap, true));
        }
        this$0.isAddRunnable = false;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        final QQPushNotifyProcessor qQPushNotifyProcessor = this.this$0;
        return new Runnable() { // from class: cooperation.vip.ad.processors.e
            @Override // java.lang.Runnable
            public final void run() {
                QQPushNotifyProcessor$runnable$2.b(QQPushNotifyProcessor.this);
            }
        };
    }
}
