package com.tencent.ecommerce.biz.taskcenter.hippy.module;

import cg0.a;
import com.tencent.ecommerce.base.fragment.d;
import com.tencent.ecommerce.biz.hippy.module.ECHippyBaseModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@HippyNativeModule(name = ECOpenTelemetryModule.TAG)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/taskcenter/hippy/module/ECOpenTelemetryModule;", "Lcom/tencent/ecommerce/biz/hippy/module/ECHippyBaseModule;", "Lcom/tencent/mtt/hippy/common/HippyMap;", "data", "", "addEvent", "", "defaultSpanName", "Ljava/lang/String;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;Ljava/lang/String;)V", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOpenTelemetryModule extends ECHippyBaseModule {
    private static final String ARG_ATTRIBUTES = "attributes";
    private static final String ARG_EVENT_NAME = "eventName";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ECOpenTelemetryModule";
    private final String defaultSpanName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/taskcenter/hippy/module/ECOpenTelemetryModule$a;", "", "Lcom/tencent/mtt/hippy/common/HippyMap;", "", "", "b", "ARG_ATTRIBUTES", "Ljava/lang/String;", "ARG_EVENT_NAME", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.taskcenter.hippy.module.ECOpenTelemetryModule$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, String> b(HippyMap hippyMap) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                Object value = entry.getValue();
                if (!(value instanceof String)) {
                    value = null;
                }
                String str = (String) value;
                if (str != null) {
                    linkedHashMap.put(entry.getKey(), str);
                }
            }
            return linkedHashMap;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECOpenTelemetryModule(HippyEngineContext hippyEngineContext, String str) {
        super(hippyEngineContext);
        this.defaultSpanName = str;
    }

    @HippyMethod(name = "addEvent")
    public final void addEvent(HippyMap data) {
        a.b(TAG, "#addEvent data=" + data);
        String string = data.getString("eventName");
        if (string != null) {
            HippyMap map = data.getMap("attributes");
            if (map == null) {
                map = new HippyMap();
            }
            d.f100713c.a(this.defaultSpanName, string, INSTANCE.b(map));
        }
    }
}
