package com.tencent.kuikly.core.module;

import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J]\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00012-\b\u0002\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0006H&JE\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\u001cJR\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\r\u00a2\u0006\u0004\b\u001e\u0010!JZ\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\r\u00a2\u0006\u0004\b\u001e\u0010\"JE\u0010#\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b2+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\u001cJP\u0010#\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\r\u00a2\u0006\u0004\b#\u0010$J\u0092\u0001\u0010*\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010%2-\b\u0002\u0010(\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`'2-\b\u0002\u0010)\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`'2\b\b\u0002\u0010\u000f\u001a\u00020\u0004J[\u0010+\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00012-\b\u0002\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\u001c2\b\b\u0002\u0010\u000f\u001a\u00020\u0004J\u0012\u0010.\u001a\u00020\f2\n\u0010-\u001a\u00060\u0006j\u0002`,R\"\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/kuikly/core/module/Module;", "", "data", "parseTDFResult", "", "keepCallbackAlive", "", "methodName", "param", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lcom/tencent/kuikly/core/module/AnyCallbackFn;", "callback", "syncCall", "Lcom/tencent/kuikly/core/module/Module$b;", "innerToNative", "", "convertSyncCall", "pagerId", "Lcom/tencent/kuikly/core/pager/g;", ISchemeApi.KEY_PAGE_DATA, "injectVar$core_release", "(Ljava/lang/String;Lcom/tencent/kuikly/core/pager/g;)V", "injectVar", "moduleName", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "Lcom/tencent/kuikly/core/module/CallbackFn;", "callbackFn", "syncToNativeMethod", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(ZLjava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "asyncToNativeMethod", "(Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "", "params", "Lcom/tencent/kuikly/core/module/TDFModuleCallbackFn;", "successCallback", "errorCallback", "toTDFNative", "toNative", "Lcom/tencent/kuikly/core/module/CallbackRef;", "callbackRef", "removeCallback", "Ljava/lang/String;", "getPagerId", "()Ljava/lang/String;", "setPagerId", "(Ljava/lang/String;)V", "Lcom/tencent/kuikly/core/pager/g;", "getPageData", "()Lcom/tencent/kuikly/core/pager/g;", "setPageData", "(Lcom/tencent/kuikly/core/pager/g;)V", "<init>", "()V", "Companion", "a", "b", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class Module {
    private static final int CALLBACK_KEEP_ALIVE_MASK = 2;
    private static final String TDF_METHOD_RESULT_KEY = "result";
    private com.tencent.kuikly.core.pager.g pageData;
    private String pagerId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001f\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/module/Module$b;", "", "", "toString", "Lcom/tencent/kuikly/core/module/CallbackRef;", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "callbackRef", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "returnValue", "errorCallbackRef", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String callbackRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Object returnValue;

        public b(String str, Object obj, String str2) {
            this.callbackRef = str;
            this.returnValue = obj;
        }

        /* renamed from: a, reason: from getter */
        public final String getCallbackRef() {
            return this.callbackRef;
        }

        /* renamed from: b, reason: from getter */
        public final Object getReturnValue() {
            return this.returnValue;
        }

        public String toString() {
            Object obj = this.returnValue;
            if (obj instanceof String) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                return (String) obj;
            }
            if (obj != null) {
                return obj.toString();
            }
            return "";
        }

        public /* synthetic */ b(String str, Object obj, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : obj, (i3 & 4) != 0 ? null : str2);
        }
    }

    private final int convertSyncCall(boolean syncCall, boolean keepCallbackAlive) {
        com.tencent.kuikly.core.pager.g gVar = this.pageData;
        if (Intrinsics.areEqual(gVar != null ? gVar.getPlatform() : null, "ohos")) {
            return com.tencent.kuikly.core.base.d.b(syncCall) + (keepCallbackAlive ? 2 : 0);
        }
        return com.tencent.kuikly.core.base.d.b(syncCall);
    }

    public final void asyncToNativeMethod(String methodName, com.tencent.kuikly.core.nvi.serialization.json.e data, Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> callbackFn) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        toNative(false, methodName, data != null ? data.toString() : null, callbackFn, false);
    }

    public final com.tencent.kuikly.core.pager.g getPageData() {
        return this.pageData;
    }

    public final String getPagerId() {
        return this.pagerId;
    }

    public final void injectVar$core_release(String pagerId, com.tencent.kuikly.core.pager.g pageData) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        this.pagerId = pagerId;
        this.pageData = pageData;
    }

    public abstract String moduleName();

    public final void removeCallback(String callbackRef) {
        Intrinsics.checkNotNullParameter(callbackRef, "callbackRef");
        GlobalFunctions.f117252a.c(this.pagerId, callbackRef);
    }

    public final void setPageData(com.tencent.kuikly.core.pager.g gVar) {
        this.pageData = gVar;
    }

    public final void setPagerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pagerId = str;
    }

    public final String syncToNativeMethod(String methodName, com.tencent.kuikly.core.nvi.serialization.json.e data, Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> callbackFn) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return toNative(false, methodName, data != null ? data.toString() : null, callbackFn, true).toString();
    }

    public final b toNative(boolean keepCallbackAlive, String methodName, Object param, final Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> callback, boolean syncCall) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return innerToNative(keepCallbackAlive, methodName, param, callback != null ? new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.module.Module$toNative$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                com.tencent.kuikly.core.nvi.serialization.json.e eVar;
                if (obj != null && (obj instanceof String)) {
                    eVar = new com.tencent.kuikly.core.nvi.serialization.json.e((String) obj);
                } else {
                    eVar = (obj == null || !(obj instanceof com.tencent.kuikly.core.nvi.serialization.json.e)) ? null : (com.tencent.kuikly.core.nvi.serialization.json.e) obj;
                }
                callback.invoke(eVar);
            }
        } : null, syncCall);
    }

    public final b toTDFNative(final boolean keepCallbackAlive, String methodName, List<? extends Object> params, final Function1<Object, Unit> successCallback, final Function1<Object, Unit> errorCallback, boolean syncCall) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        String bVar = params != null ? b01.c.a(params).toString() : null;
        String a16 = successCallback != null ? GlobalFunctions.f117252a.a(this.pagerId, new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.module.Module$toTDFNative$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                Object parseTDFResult;
                Function1<Object, Unit> function1 = successCallback;
                parseTDFResult = this.parseTDFResult(obj != null ? n.a(obj) : null);
                function1.invoke(parseTDFResult);
                return Boolean.valueOf(keepCallbackAlive);
            }
        }) : null;
        String a17 = errorCallback != null ? GlobalFunctions.f117252a.a(this.pagerId, new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.module.Module$toTDFNative$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                Object parseTDFResult;
                Function1<Object, Unit> function1 = errorCallback;
                parseTDFResult = this.parseTDFResult(obj != null ? n.a(obj) : null);
                function1.invoke(parseTDFResult);
                return Boolean.valueOf(keepCallbackAlive);
            }
        }) : null;
        return new b(a16, parseTDFResult(BridgeManager.f117344a.p(this.pagerId, moduleName(), methodName, bVar, a16, a17, convertSyncCall(syncCall, keepCallbackAlive))), a17);
    }

    private final b innerToNative(final boolean keepCallbackAlive, String methodName, Object param, final Function1<Object, Unit> callback, boolean syncCall) {
        String a16 = callback != null ? GlobalFunctions.f117252a.a(this.pagerId, new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.module.Module$innerToNative$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                callback.invoke(obj != null ? n.a(obj) : null);
                return Boolean.valueOf(keepCallbackAlive);
            }
        }) : null;
        return new b(a16, BridgeManager.f117344a.k(this.pagerId, moduleName(), methodName, param, a16, convertSyncCall(syncCall, keepCallbackAlive)), null, 4, null);
    }

    public final void asyncToNativeMethod(String methodName, Object[] args, Function1<Object, Unit> callbackFn) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        ArrayList arrayList = new ArrayList();
        for (Object obj : args) {
            if ((obj instanceof String) || (obj instanceof byte[]) || (obj instanceof Number)) {
                arrayList.add(n.b(obj));
            } else {
                PagerNotFoundExceptionKt.a("asyncToNativeMethod args\u53c2\u6570\u7c7b\u578b\u4ec5\u652f\u6301String, Number, ByteArray\u7c7b\u578b, ele:" + obj);
            }
        }
        innerToNative(false, methodName, n.b(arrayList), callbackFn, false);
    }

    public final Object syncToNativeMethod(String methodName, Object[] args, Function1<Object, Unit> callbackFn) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        return syncToNativeMethod(false, methodName, args, callbackFn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object parseTDFResult(Object data) {
        if (data == null) {
            return null;
        }
        if (!(data instanceof com.tencent.kuikly.core.nvi.serialization.json.e)) {
            data = data instanceof String ? new com.tencent.kuikly.core.nvi.serialization.json.e((String) data) : null;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = (com.tencent.kuikly.core.nvi.serialization.json.e) data;
        if (eVar == null) {
            return null;
        }
        Object e16 = eVar.e("result");
        if (e16 instanceof com.tencent.kuikly.core.nvi.serialization.json.b) {
            return ((com.tencent.kuikly.core.nvi.serialization.json.b) e16).w();
        }
        return e16 instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? ((com.tencent.kuikly.core.nvi.serialization.json.e) e16).x() : e16;
    }

    public final Object syncToNativeMethod(boolean keepCallbackAlive, String methodName, Object[] args, Function1<Object, Unit> callbackFn) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        ArrayList arrayList = new ArrayList();
        for (Object obj : args) {
            if ((obj instanceof String) || (obj instanceof byte[]) || (obj instanceof Number)) {
                arrayList.add(n.b(obj));
            } else {
                PagerNotFoundExceptionKt.a("syncToNativeMethod args\u53c2\u6570\u7c7b\u578b\u4ec5\u652f\u6301String\uff0cNumber, ByteArray\u7c7b\u578b, ele:" + obj);
            }
        }
        Object returnValue = innerToNative(keepCallbackAlive, methodName, n.b(arrayList), callbackFn, true).getReturnValue();
        if (returnValue != null) {
            return n.a(returnValue);
        }
        return null;
    }

    static /* synthetic */ b innerToNative$default(Module module, boolean z16, String str, Object obj, Function1 function1, boolean z17, int i3, Object obj2) {
        if (obj2 == null) {
            boolean z18 = (i3 & 1) != 0 ? false : z16;
            if ((i3 & 8) != 0) {
                function1 = null;
            }
            return module.innerToNative(z18, str, obj, function1, (i3 & 16) != 0 ? false : z17);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: innerToNative");
    }

    public static /* synthetic */ b toNative$default(Module module, boolean z16, String str, Object obj, Function1 function1, boolean z17, int i3, Object obj2) {
        if (obj2 == null) {
            boolean z18 = (i3 & 1) != 0 ? false : z16;
            if ((i3 & 8) != 0) {
                function1 = null;
            }
            return module.toNative(z18, str, obj, function1, (i3 & 16) != 0 ? false : z17);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toNative");
    }

    public static /* synthetic */ b toTDFNative$default(Module module, boolean z16, String str, List list, Function1 function1, Function1 function12, boolean z17, int i3, Object obj) {
        if (obj == null) {
            return module.toTDFNative((i3 & 1) != 0 ? false : z16, str, list, (i3 & 8) != 0 ? null : function1, (i3 & 16) != 0 ? null : function12, (i3 & 32) != 0 ? false : z17);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toTDFNative");
    }
}
