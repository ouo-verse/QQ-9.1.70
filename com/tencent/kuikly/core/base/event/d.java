package com.tencent.kuikly.core.base.event;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J9\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004j\u0002`\tH&J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\b2\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H&J\u0018\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/base/event/d;", "", "", AdMetricTag.EVENT_NAME, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "parma", "", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "eventHandlerFn", "register", "data", "", "onFireEvent", "onViewDidRemove", "onRenderViewDidCreated", "onRenderViewDidRemoved", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "onRelativeCoordinatesDidChanged", "onViewLayoutFrameDidChanged", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface d {
    boolean onFireEvent(String eventName, Object data);

    void onRelativeCoordinatesDidChanged(DeclarativeBaseView<?, ?> view);

    void onRenderViewDidCreated();

    void onRenderViewDidRemoved();

    void onViewDidRemove();

    void onViewLayoutFrameDidChanged(DeclarativeBaseView<?, ?> view);

    void register(String eventName, Function1<Object, Unit> eventHandlerFn);
}
