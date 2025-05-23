package com.tencent.kuikly.core.base.event;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.p;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J9\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0012\u0010\u001a\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(Rx\u0010+\u001a`\u0012\u0004\u0012\u00020\u0004\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u00100)j/\u0012\u0004\u0012\u00020\u0004\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u0010`*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00061"}, d2 = {"Lcom/tencent/kuikly/core/base/event/b;", "Lcom/tencent/kuikly/core/base/BaseObject;", "Lcom/tencent/kuikly/core/base/event/d;", "Lcom/tencent/kuikly/core/base/p;", "", "pagerId", "", "viewId", "", "init", AdMetricTag.EVENT_NAME, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "eventHandlerFn", "register", "unRegister", "data", "", "onFireEvent", "isEmpty", "onViewDidRemove", "Lcom/tencent/kuikly/core/base/AbstractBaseView;", "getView", "Lcom/tencent/kuikly/core/base/RenderView;", "getRenderView", "Lcom/tencent/kuikly/core/pager/b;", "getPager", "Ljava/lang/String;", "getPagerId", "()Ljava/lang/String;", "setPagerId", "(Ljava/lang/String;)V", "I", "getViewId", "()I", "setViewId", "(I)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "eventMap", "Ljava/util/LinkedHashMap;", "getEventMap", "()Ljava/util/LinkedHashMap;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class b extends BaseObject implements d, p {
    private int viewId;
    private String pagerId = "";
    private final LinkedHashMap<String, Function1<Object, Unit>> eventMap = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedHashMap<String, Function1<Object, Unit>> getEventMap() {
        return this.eventMap;
    }

    public final com.tencent.kuikly.core.pager.b getPager() {
        return com.tencent.kuikly.core.manager.c.f117352a.k(getPagerId());
    }

    @Override // com.tencent.kuikly.core.base.p
    public String getPagerId() {
        return this.pagerId;
    }

    public RenderView getRenderView() {
        AbstractBaseView<?, ?> view = getView();
        if (view != null) {
            return view.getRenderView();
        }
        return null;
    }

    public AbstractBaseView<?, ?> getView() {
        return getPager().getViewWithNativeRef(this.viewId);
    }

    public final int getViewId() {
        return this.viewId;
    }

    public void init(String pagerId, int viewId) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        setPagerId(pagerId);
        this.viewId = viewId;
    }

    public boolean isEmpty() {
        return this.eventMap.isEmpty();
    }

    public boolean onFireEvent(String eventName, Object data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Function1<Object, Unit> function1 = this.eventMap.get(eventName);
        if (function1 != null) {
            function1.invoke(data);
        } else {
            function1 = null;
        }
        return function1 != null;
    }

    public void onViewDidRemove() {
        this.eventMap.clear();
    }

    public void register(String eventName, Function1<Object, Unit> eventHandlerFn) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventHandlerFn, "eventHandlerFn");
        this.eventMap.put(eventName, eventHandlerFn);
    }

    public void setPagerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pagerId = str;
    }

    public final void setViewId(int i3) {
        this.viewId = i3;
    }

    public void unRegister(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventMap.remove(eventName);
    }
}
