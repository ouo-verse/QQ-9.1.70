package com.tencent.kuikly.core.base;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.manager.BridgeManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u000e\u0012\u0006\u0010)\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u00104J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J&\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\"\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0005JI\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022-\b\u0002\u0010\u001c\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\u0004\u0018\u0001`\u001bJ\u0016\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u0014\u0010'\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010#R'\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-R$\u00102\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b \u00100\u001a\u0004\b(\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/kuikly/core/base/RenderView;", "", "", "key", "value", "", "k", "", HippyTKDListViewAdapter.X, "y", "width", "height", "j", AdMetricTag.EVENT_NAME, "", "sync", "", "forceSet", tl.h.F, "l", "methodName", "params", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "Lkotlin/ParameterName;", "name", "data", "Lcom/tencent/kuikly/core/module/CallbackFn;", "callback", "a", "subViewRef", "index", "e", "f", "g", "Ljava/lang/String;", "pagerId", "b", "I", "viewRef", "c", "viewName", "", "d", "Lkotlin/Lazy;", "()Ljava/util/Map;", "eventMap", "<set-?>", "Z", "()Z", "didLayout", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RenderView {

    /* renamed from: a, reason: from kotlin metadata */
    private final String pagerId;

    /* renamed from: b, reason: from kotlin metadata */
    private final int viewRef;

    /* renamed from: c, reason: from kotlin metadata */
    private final String viewName;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy eventMap;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean didLayout;

    public RenderView(String pagerId, int i3, String viewName) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.pagerId = pagerId;
        this.viewRef = i3;
        this.viewName = viewName;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Map<String, Integer>>() { // from class: com.tencent.kuikly.core.base.RenderView$eventMap$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, Integer> invoke() {
                return new LinkedHashMap();
            }
        });
        this.eventMap = lazy;
        BridgeManager.f117344a.r(pagerId, i3, viewName);
    }

    private final Map<String, Integer> d() {
        return (Map) this.eventMap.getValue();
    }

    public final void a(String methodName, String params, final Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> callback) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        BridgeManager.f117344a.q(this.pagerId, this.viewRef, methodName, params, callback != null ? GlobalFunctions.f117252a.a(this.pagerId, new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.base.RenderView$callMethod$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                callback.invoke((obj == null || !(obj instanceof String)) ? null : new com.tencent.kuikly.core.nvi.serialization.json.e((String) obj));
                return Boolean.FALSE;
            }
        }) : null);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getDidLayout() {
        return this.didLayout;
    }

    public final void e(int subViewRef, int index) {
        BridgeManager.f117344a.y(this.pagerId, this.viewRef, subViewRef, index);
    }

    public final void f() {
        BridgeManager.f117344a.y(this.pagerId, -1, this.viewRef, 0);
    }

    public final void g() {
        BridgeManager.f117344a.F(this.pagerId, this.viewRef);
    }

    public final void h(String eventName, int i3, boolean z16) {
        Integer num;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (z16 || !d().containsKey(eventName) || (num = d().get(eventName)) == null || num.intValue() != i3) {
            if (!z16) {
                d().put(eventName, Integer.valueOf(i3));
            }
            BridgeManager.f117344a.O(this.pagerId, this.viewRef, eventName, 1, 1, i3);
        }
    }

    public final void j(float r85, float y16, float width, float height) {
        BridgeManager.f117344a.K(this.pagerId, this.viewRef, r85, y16, width, height);
        this.didLayout = true;
    }

    public final void k(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        BridgeManager.P(BridgeManager.f117344a, this.pagerId, this.viewRef, key, value, 0, 0, 32, null);
    }

    public final void l() {
        BridgeManager.f117344a.L(this.pagerId, this.viewRef);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(RenderView renderView, String str, String str2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        renderView.a(str, str2, function1);
    }

    public static /* synthetic */ void i(RenderView renderView, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        renderView.h(str, i3, z16);
    }
}
