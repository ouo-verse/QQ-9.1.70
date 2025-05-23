package com.tencent.kuikly.core.base;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.EventName;
import com.tencent.kuikly.core.views.internal.GroupEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J7\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\nJ\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016Rr\u0010\u0016\u001a`\u0012\u0004\u0012\u00020\u0002\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n0\u0014j/\u0012\u0004\u0012\u00020\u0002\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/base/l;", "Lcom/tencent/kuikly/core/views/internal/GroupEvent;", "", AdMetricTag.EVENT_NAME, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "handlerFn", "registerEvent", "data", "", "onFireEvent", "Lcom/tencent/kuikly/core/base/event/c;", "handler", "click", "onViewDidRemove", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "composeEventMap", "Ljava/util/HashMap;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class l extends GroupEvent {
    private final HashMap<String, Function1<Object, Unit>> composeEventMap = new HashMap<>();

    @Override // com.tencent.kuikly.core.base.event.Event
    public void click(Function1<? super ClickParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        EventName eventName = EventName.CLICK;
        Function1<Object, Unit> handlerWithEventName = handlerWithEventName(eventName.getValue());
        if (handlerWithEventName != null) {
            this.composeEventMap.put(eventName.getValue(), handlerWithEventName);
        }
        super.click(handler);
    }

    @Override // com.tencent.kuikly.core.base.event.Event, com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public boolean onFireEvent(String eventName, Object data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (this.composeEventMap.get(eventName) != null) {
            Function1<Object, Unit> function1 = this.composeEventMap.get(eventName);
            if (function1 == null) {
                return true;
            }
            function1.invoke(data);
            return true;
        }
        super.onFireEvent(eventName, data);
        return true;
    }

    @Override // com.tencent.kuikly.core.base.event.Event, com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public void onViewDidRemove() {
        super.onViewDidRemove();
        this.composeEventMap.clear();
    }

    public final void registerEvent(String eventName, Function1<Object, Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        this.composeEventMap.put(eventName, handlerFn);
    }
}
