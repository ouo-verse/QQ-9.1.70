package com.tencent.mobileqq.wink.editor.performance;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001J\u0006\u0010\u000e\u001a\u00020\u0004R$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000fj\b\u0012\u0004\u0012\u00020\u0001`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/performance/RenderTimeProxy;", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "cb", "b", "d", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "renderTimeCallbacks", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class RenderTimeProxy implements IRenderTimeListener {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<RenderTimeProxy> f321436c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<IRenderTimeListener> renderTimeCallbacks = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/performance/RenderTimeProxy$a;", "", "Lcom/tencent/mobileqq/wink/editor/performance/RenderTimeProxy;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/editor/performance/RenderTimeProxy;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.performance.RenderTimeProxy$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RenderTimeProxy a() {
            return (RenderTimeProxy) RenderTimeProxy.f321436c.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<RenderTimeProxy> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<RenderTimeProxy>() { // from class: com.tencent.mobileqq.wink.editor.performance.RenderTimeProxy$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RenderTimeProxy invoke() {
                return new RenderTimeProxy();
            }
        });
        f321436c = lazy;
    }

    public final void b(@NotNull IRenderTimeListener cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.renderTimeCallbacks.add(cb5);
    }

    public final void c() {
        this.renderTimeCallbacks.clear();
    }

    public final void d(@NotNull IRenderTimeListener cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.renderTimeCallbacks.remove(cb5);
    }

    @Override // com.tencent.tavcut.core.session.IRenderTimeListener
    public void onFirstFrameTimeFinish(long finishTimeInMs) {
        Iterator<T> it = this.renderTimeCallbacks.iterator();
        while (it.hasNext()) {
            ((IRenderTimeListener) it.next()).onFirstFrameTimeFinish(finishTimeInMs);
        }
    }

    @Override // com.tencent.tavcut.core.session.IRenderTimeListener
    public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        Iterator<T> it = this.renderTimeCallbacks.iterator();
        while (it.hasNext()) {
            ((IRenderTimeListener) it.next()).onRenderTimeCost(frameTimeCostInMs, renderNodeCostInMs, currentRenderTimeInUs);
        }
    }

    @Override // com.tencent.tavcut.core.session.IRenderTimeListener
    public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        Iterator<T> it = this.renderTimeCallbacks.iterator();
        while (it.hasNext()) {
            ((IRenderTimeListener) it.next()).onSingleFrameTimeCost(frameTimeCostInMs, renderNodeCostInMs, currentRenderTimeInUs);
        }
    }
}
