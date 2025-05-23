package com.tencent.kuikly.core.module;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016JE\u0010\u0010\u001a\u00060\u0002j\u0002`\u000f2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\rJ\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u000fJ \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/module/k;", "Lcom/tencent/kuikly/core/module/Module;", "", "moduleName", AdMetricTag.EVENT_NAME, "", "crossProcess", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/kuikly/core/module/CallbackFn;", "cb", "Lcom/tencent/kuikly/core/module/CallbackRef;", "a", "callbackRef", "e", "eventData", "c", "", "Ljava/util/Map;", "cbIdMap", "", "b", "I", "cbIdProducer", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends Module {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> cbIdMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int cbIdProducer;

    public final String a(String eventName, boolean crossProcess, Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> cb5) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        int i3 = this.cbIdProducer + 1;
        this.cbIdProducer = i3;
        String valueOf = String.valueOf(i3);
        String callbackRef = Module.toNative$default(this, true, "addNotify", new com.tencent.kuikly.core.nvi.serialization.json.e().v("id", valueOf).v(AdMetricTag.EVENT_NAME, eventName).w("crossProcess", crossProcess).toString(), cb5, false, 16, null).getCallbackRef();
        Intrinsics.checkNotNull(callbackRef);
        this.cbIdMap.put(callbackRef, valueOf);
        return callbackRef;
    }

    public final void c(String eventName, com.tencent.kuikly.core.nvi.serialization.json.e eventData, boolean crossProcess) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        Module.toNative$default(this, true, "postNotify", new com.tencent.kuikly.core.nvi.serialization.json.e().v(AdMetricTag.EVENT_NAME, eventName).v("data", eventData).w("crossProcess", crossProcess).toString(), null, false, 24, null);
    }

    public final void e(String eventName, String callbackRef) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackRef, "callbackRef");
        String remove = this.cbIdMap.remove(callbackRef);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        if (remove == null) {
            remove = "";
        }
        Module.toNative$default(this, false, "removeNotify", eVar.v("id", remove).v(AdMetricTag.EVENT_NAME, eventName).toString(), null, false, 24, null);
        removeCallback(callbackRef);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRNotifyModule";
    }

    public static /* synthetic */ String b(k kVar, String str, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return kVar.a(str, z16, function1);
    }

    public static /* synthetic */ void d(k kVar, String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        kVar.c(str, eVar, z16);
    }
}
