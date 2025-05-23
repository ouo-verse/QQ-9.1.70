package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import android.content.Context;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.IDomOperate;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.Dimensions;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.DimensionsUtil;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0003,=>B8\u0012'\u0010\u000f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\tj\u0002`\u000e\u0012\u0006\u0010:\u001a\u00020\u0014\u00a2\u0006\u0004\b;\u0010<J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002JG\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0004\u0018\u0001`\u000eH\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010%\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u001c\u0010)\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010(2\b\u0010#\u001a\u0004\u0018\u00010\u001cH\u0016JM\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00042+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0004\u0018\u0001`\u000eJ\u0016\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014R\u0018\u00101\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00100R7\u00103\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\tj\u0002`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00102R\u0016\u00105\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00104R2\u00109\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c06j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c`78\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/RenderBridge;", "Lcom/tencent/mtt/hippy/IDomOperate;", "", "method", "Lorg/json/JSONObject;", "params", "", "c", "b", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "Lcom/tencent/mtt/hippy/HippyEngine;", EnginePathProvider.ENGINE_DIR, "f", "", "rootID", "Lcom/tencent/mtt/hippy/common/HippyArray;", "hippyArray", "createNode", "updateNode", "deleteNode", "flushBatch", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "callUIFunction", "id", "measureInWindow", "p0", "Lcom/tencent/mtt/hippy/runtime/builtins/e;", "p1", "p2", "getBoundingClientRect", "startBatch", "endBatch", "Lcom/tencent/mtt/hippy/common/HippyMap;", "getNodeForLocation", "module", "paramJson", "a", "width", "height", "e", "Lcom/tencent/mtt/hippy/HippyEngine;", "mHippyEngine", "Lkotlin/jvm/functions/Function1;", "mCallback", "I", "mKuiklyViewId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mPromises", "kuiklyViewId", "<init>", "(Lkotlin/jvm/functions/Function1;I)V", "Method", "Module", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RenderBridge implements IDomOperate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HippyEngine mHippyEngine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> mCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mKuiklyViewId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Promise> mPromises;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/RenderBridge$Method;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "RECEIVE_NATIVE_GESTURE", "CALLBACK", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum Method {
        RECEIVE_NATIVE_GESTURE("receiveNativeGesture"),
        CALLBACK("callback");

        private final String value;

        Method(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/RenderBridge$Module;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "EVENT_DISPATCHER", "EXEC_FUNCTION", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum Module {
        EVENT_DISPATCHER("EventDispatcher"),
        EXEC_FUNCTION("ExecFunction");

        private final String value;

        Module(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public RenderBridge(Function1<Object, Unit> callback, int i3) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
        this.mKuiklyViewId = i3;
        this.mPromises = new HashMap<>();
    }

    private final void b(JSONObject params) {
        QLog.d("VueModule", 2, "[doCallback] param: " + params);
        HippyMap hippyMap = null;
        String optString = params != null ? params.optString("callbackId") : null;
        try {
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushJSONObject(new JSONObject(params != null ? params.optString("result") : null));
            hippyMap = hippyMap2;
        } catch (Exception e16) {
            QLog.e("RenderBridge", 2, "[doCallback] " + e16);
        }
        QLog.d("RenderBridge", 2, "[doCallback] id: " + optString + ", result: " + hippyMap);
        Promise promise = this.mPromises.get(optString);
        if (promise != null) {
            promise.resolve(hippyMap);
        }
        TypeIntrinsics.asMutableMap(this.mPromises).remove(optString);
    }

    private final void c(String method, JSONObject params) {
        if (Intrinsics.areEqual(method, Method.CALLBACK.getValue())) {
            b(params);
        }
    }

    public final void a(String module, String method, JSONObject paramJson, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(method, "method");
        if (module.length() == 0) {
            if (callback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ret", "-1");
                jSONObject.put("msg", "module is null");
                callback.invoke(jSONObject);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(module, Module.EVENT_DISPATCHER.getValue())) {
            d(method, paramJson, callback);
        } else if (Intrinsics.areEqual(module, Module.EXEC_FUNCTION.getValue())) {
            c(method, paramJson);
        }
    }

    public final void e(int width, int height) {
        int i3;
        int i16;
        HippyEngineContext engineContext;
        HippyGlobalConfigs globalConfigs;
        HippyEngineContext engineContext2;
        HippyGlobalConfigs globalConfigs2;
        HippyEngineContext engineContext3;
        HippyEngineContext engineContext4;
        HippyModuleManager moduleManager;
        Dimensions dimensions;
        HippyEngineContext engineContext5;
        HippyGlobalConfigs globalConfigs3;
        HippyEngine hippyEngine = this.mHippyEngine;
        Context context = null;
        HippyMap dimensions2 = DimensionsUtil.getDimensions(width, height, (hippyEngine == null || (engineContext5 = hippyEngine.getEngineContext()) == null || (globalConfigs3 = engineContext5.getGlobalConfigs()) == null) ? null : globalConfigs3.getContext(), false);
        if (dimensions2 != null) {
            HippyMap map = dimensions2.getMap("windowPhysicalPixels");
            i16 = map.getInt("width");
            i3 = map.getInt("height");
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (height < 0 || i16 == i3) {
            HippyEngine hippyEngine2 = this.mHippyEngine;
            if (((hippyEngine2 == null || (engineContext3 = hippyEngine2.getEngineContext()) == null) ? null : engineContext3.getGlobalConfigs()) != null) {
                HippyEngine hippyEngine3 = this.mHippyEngine;
                HippyDeviceAdapter deviceAdapter = (hippyEngine3 == null || (engineContext2 = hippyEngine3.getEngineContext()) == null || (globalConfigs2 = engineContext2.getGlobalConfigs()) == null) ? null : globalConfigs2.getDeviceAdapter();
                if (deviceAdapter != null) {
                    HippyEngine hippyEngine4 = this.mHippyEngine;
                    if (hippyEngine4 != null && (engineContext = hippyEngine4.getEngineContext()) != null && (globalConfigs = engineContext.getGlobalConfigs()) != null) {
                        context = globalConfigs.getContext();
                    }
                    deviceAdapter.reviseDimensionIfNeed(context, dimensions2, false, false);
                }
            }
        }
        QLog.d("RenderBridge", 2, "[setDimensions] dimensionMap: " + dimensions2);
        HippyEngine hippyEngine5 = this.mHippyEngine;
        if (hippyEngine5 == null || (engineContext4 = hippyEngine5.getEngineContext()) == null || (moduleManager = engineContext4.getModuleManager()) == null || (dimensions = (Dimensions) moduleManager.getJavaScriptModule(Dimensions.class)) == null) {
            return;
        }
        dimensions.set(dimensions2);
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void endBatch() {
        QLog.d("RenderBridge", 2, "endBatch");
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "endBatch");
        function1.invoke(jSONObject);
    }

    public final void f(HippyEngine engine) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.mHippyEngine = engine;
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void measureInWindow(int id5, Promise promise) {
        QLog.d("RenderBridge", 2, "[measureInWindow] viewId: " + this.mKuiklyViewId + ", data:" + id5);
        if (promise != null) {
            HashMap<String, Promise> hashMap = this.mPromises;
            String callId = promise.getCallId();
            Intrinsics.checkNotNullExpressionValue(callId, "it.callId");
            hashMap.put(callId, promise);
        }
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "measureInWindow");
        jSONObject.put("viewId", this.mKuiklyViewId);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", id5);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("data", jSONObject2);
        jSONObject.put("callbackId", promise != null ? promise.getCallId() : null);
        function1.invoke(jSONObject);
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void startBatch() {
        QLog.d("RenderBridge", 2, "startBatch");
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "startBatch");
        function1.invoke(jSONObject);
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void getBoundingClientRect(int p06, com.tencent.mtt.hippy.runtime.builtins.e p16, Promise p26) {
        QLog.d("RenderBridge", 2, "[getBoundingClientRect] Not Implemented");
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void getNodeForLocation(HippyMap p06, Promise p16) {
        QLog.d("RenderBridge", 2, "[getNodeForLocation] Not Implemented");
    }

    private final void d(String method, JSONObject params, Function1<Object, Unit> callback) {
        HippyEngine hippyEngine;
        HippyEngineContext engineContext;
        HippyModuleManager moduleManager;
        EventDispatcher eventDispatcher;
        if (method != null) {
            if (!(method.length() == 0)) {
                if (params != null) {
                    params.optInt("viewId");
                }
                if (!Intrinsics.areEqual(method, Method.RECEIVE_NATIVE_GESTURE.getValue()) || (hippyEngine = this.mHippyEngine) == null || (engineContext = hippyEngine.getEngineContext()) == null || (moduleManager = engineContext.getModuleManager()) == null || (eventDispatcher = (EventDispatcher) moduleManager.getJavaScriptModule(EventDispatcher.class)) == null) {
                    return;
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushJSONObject(params);
                eventDispatcher.receiveNativeGesture(hippyMap);
                return;
            }
        }
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", "-1");
            jSONObject.put("msg", "module is null");
            callback.invoke(jSONObject);
        }
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void createNode(int rootID, HippyArray hippyArray) {
        JSONArray jSONArray = hippyArray != null ? hippyArray.toJSONArray() : null;
        QLog.d("RenderBridge", 2, 2, "[createNode] viewId: " + this.mKuiklyViewId + ", data:" + jSONArray);
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "createDomNode");
        jSONObject.put("rootId", rootID);
        jSONObject.put("viewId", this.mKuiklyViewId);
        jSONObject.put("data", jSONArray);
        function1.invoke(jSONObject);
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void deleteNode(int rootID, HippyArray hippyArray) {
        JSONArray jSONArray = hippyArray != null ? hippyArray.toJSONArray() : null;
        QLog.d("RenderBridge", 2, "[deleteNode] viewId: " + this.mKuiklyViewId + ", data:" + jSONArray);
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "deleteDomNode");
        jSONObject.put("rootId", rootID);
        jSONObject.put("viewId", this.mKuiklyViewId);
        jSONObject.put("data", jSONArray);
        function1.invoke(jSONObject);
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void flushBatch(int rootID, HippyArray hippyArray) {
        JSONArray jSONArray = hippyArray != null ? hippyArray.toJSONArray() : null;
        QLog.d("RenderBridge", 2, "[endBatch] viewId: " + this.mKuiklyViewId + ", data:" + jSONArray);
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "flushBatch");
        jSONObject.put("rootId", rootID);
        jSONObject.put("viewId", this.mKuiklyViewId);
        jSONObject.put("data", jSONArray);
        function1.invoke(jSONObject);
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void updateNode(int rootID, HippyArray hippyArray) {
        JSONArray jSONArray = hippyArray != null ? hippyArray.toJSONArray() : null;
        QLog.d("RenderBridge", 2, "[updateNode] viewId: " + this.mKuiklyViewId + ", data:" + jSONArray);
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "updateDomNode");
        jSONObject.put("rootId", rootID);
        jSONObject.put("viewId", this.mKuiklyViewId);
        jSONObject.put("data", jSONArray);
        function1.invoke(jSONObject);
    }

    @Override // com.tencent.mtt.hippy.IDomOperate
    public void callUIFunction(HippyArray hippyArray, Promise promise) {
        JSONArray jSONArray = hippyArray != null ? hippyArray.toJSONArray() : null;
        QLog.d("RenderBridge", 2, "[callUIFunction] viewId: " + this.mKuiklyViewId + ", data:" + jSONArray);
        if (promise != null) {
            HashMap<String, Promise> hashMap = this.mPromises;
            String callId = promise.getCallId();
            Intrinsics.checkNotNullExpressionValue(callId, "it.callId");
            hashMap.put(callId, promise);
        }
        Function1<Object, Unit> function1 = this.mCallback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "callUIFunction");
        jSONObject.put("viewId", this.mKuiklyViewId);
        jSONObject.put("data", jSONArray);
        jSONObject.put("callbackId", promise != null ? promise.getCallId() : null);
        function1.invoke(jSONObject);
    }
}
