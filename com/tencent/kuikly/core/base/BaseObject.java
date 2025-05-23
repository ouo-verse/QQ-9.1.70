package com.tencent.kuikly.core.base;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@ScopeMarker
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J9\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016R7\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/base/BaseObject;", "", "()V", "extProps", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExtProps", "()Ljava/util/HashMap;", "extProps$delegate", "Lkotlin/Lazy;", "bindValueChange", "", "valueBlock", "Lkotlin/Function0;", "valueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "unbindAllValueChange", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class BaseObject {

    /* renamed from: extProps$delegate, reason: from kotlin metadata */
    private final Lazy extProps = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<HashMap<String, Object>>() { // from class: com.tencent.kuikly.core.base.BaseObject$extProps$2
        @Override // kotlin.jvm.functions.Function0
        public final HashMap<String, Object> invoke() {
            return new HashMap<>();
        }
    });

    public void bindValueChange(Function0<? extends Object> valueBlock, Function1<Object, Unit> valueChange) {
        Intrinsics.checkNotNullParameter(valueBlock, "valueBlock");
        Intrinsics.checkNotNullParameter(valueChange, "valueChange");
        com.tencent.kuikly.core.manager.c.f117352a.i().k(valueBlock, this, valueChange);
    }

    public final HashMap<String, Object> getExtProps() {
        return (HashMap) this.extProps.getValue();
    }

    public void unbindAllValueChange() {
        com.tencent.kuikly.core.manager.c.f117352a.i().y(this);
    }
}
