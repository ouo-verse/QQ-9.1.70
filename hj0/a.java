package hj0;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.biz.taskcenter.hippy.ECHippyEventReceiver;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lhj0/a;", "", "Lcom/tencent/ecommerce/biz/taskcenter/hippy/ECHippyEventReceiver;", "receiver", "", "b", "c", "", AdMetricTag.EVENT_NAME, "Lcom/tencent/mtt/hippy/common/HippyMap;", "params", "a", "", "Ljava/util/Set;", "receivers", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f405184b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Set<ECHippyEventReceiver> receivers = new LinkedHashSet();

    a() {
    }

    public final void a(String eventName, HippyMap params) {
        if (eventName.length() == 0) {
            return;
        }
        Iterator<T> it = receivers.iterator();
        while (it.hasNext()) {
            ((ECHippyEventReceiver) it.next()).onReceiverEvent(eventName, params);
        }
    }

    public final void b(ECHippyEventReceiver receiver) {
        receivers.add(receiver);
    }

    public final void c(ECHippyEventReceiver receiver) {
        receivers.remove(receiver);
    }
}
