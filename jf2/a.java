package jf2;

import com.tencent.biz.qqcircle.events.QCircleEcommerceEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.ecommerce.base.event.api.IECEventDispatcherDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Ljf2/a;", "Lcom/tencent/ecommerce/base/event/api/IECEventDispatcherDelegate;", "", "action", "Lorg/json/JSONObject;", "param", "", "sendEvent", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECEventDispatcherDelegate {
    @Override // com.tencent.ecommerce.base.event.api.IECEventDispatcherDelegate
    public void sendEvent(int action, JSONObject param) {
        Intrinsics.checkNotNullParameter(param, "param");
        SimpleEventBus.getInstance().dispatchEvent(new QCircleEcommerceEvent(Integer.valueOf(action), param));
    }
}
