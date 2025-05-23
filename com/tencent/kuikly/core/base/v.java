package com.tencent.kuikly.core.base;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/base/v;", "", "", "key", "value", "", "setProp", "", "width", "height", "Lcom/tencent/kuikly/core/base/w;", "calculateRenderViewSize", "removeFromParentComponent", "methodName", "params", "callMethod", "pagerId", "Ljava/lang/String;", "", "viewRef", "I", "viewName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class v {
    private final String pagerId;
    private final int viewRef;

    public v(String pagerId, int i3, String viewName) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.pagerId = pagerId;
        this.viewRef = i3;
        BridgeManager.f117344a.s(pagerId, i3, viewName);
    }

    public w calculateRenderViewSize(float width, float height) {
        List split$default;
        String i3 = BridgeManager.f117344a.i(this.pagerId, this.viewRef, width, height);
        if (!(i3.length() == 0)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) i3, new String[]{"|"}, false, 0, 6, (Object) null);
            return new w(Float.parseFloat((String) split$default.get(0)), Float.parseFloat((String) split$default.get(1)));
        }
        KLog.INSTANCE.e("Shadow", "calculateRenderViewSize sizeStr is empty");
        return new w(0.0f, 0.0f);
    }

    public final String callMethod(String methodName, String params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        Object n3 = BridgeManager.f117344a.n(this.pagerId, this.viewRef, methodName, params);
        if (n3 instanceof String) {
            return (String) n3;
        }
        return String.valueOf(n3);
    }

    public void removeFromParentComponent() {
        BridgeManager.f117344a.G(this.pagerId, this.viewRef);
    }

    public void setProp(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        BridgeManager.f117344a.M(this.pagerId, this.viewRef, key, value);
    }
}
