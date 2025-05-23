package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import com.tencent.hippy.qq.utils.HippyFontUtils;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/g;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "method", "call", "<init>", "()V", "d", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g extends i01.e {
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "registerFont")) {
            a(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        if (params == null || params.length() == 0) {
            if (callback != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QzoneIPCModule.RESULT_CODE, -1), TuplesKt.to("downloadCode", -1));
                callback.invoke(mapOf);
                return;
            }
            return;
        }
        String optString = new JSONObject(params).optString("fontSrc");
        HippyArray hippyArray = new HippyArray();
        hippyArray.pushString(optString);
        HippyFontUtils.startAsyncDownloadFont(hippyArray, new b(callback));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/g$b", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "result", "", "resolve", "p0", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Promise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262996a;

        b(Function1<Object, Unit> function1) {
            this.f262996a = function1;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public String getCallId() {
            return "";
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object result) {
            Map mapOf;
            Function1<Object, Unit> function1 = this.f262996a;
            if (function1 != null) {
                Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.tencent.mtt.hippy.common.HippyMap");
                HippyMap hippyMap = (HippyMap) result;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QzoneIPCModule.RESULT_CODE, Integer.valueOf(hippyMap.getInt(QzoneIPCModule.RESULT_CODE))), TuplesKt.to("downloadCode", Integer.valueOf(hippyMap.getInt("downloadCode"))));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }
}
