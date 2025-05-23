package com.tencent.ecommerce.base.eventbus;

import bi0.ECHREvent;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.plugin.ECPluginServiceEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u001a\u0010\f\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0007R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/eventbus/a;", "", "", "e", "Ljava/util/HashMap;", "", "param", "d", "eventType", "callback", "callbackTag", "c", "g", "f", "", "", "a", "Ljava/util/Map;", "eventToCallbackMap", "Lcom/tencent/ecommerce/base/eventbus/a$a;", "b", "callbackWrapperMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f100697c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<String>> eventToCallbackMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, CallbackWrapper> callbackWrapperMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lbi0/a;", "it", "", "a", "(Lbi0/a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b<T> implements EventObserver<ECHREvent> {

        /* renamed from: d, reason: collision with root package name */
        public static final b f100701d = new b();

        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECHREvent eCHREvent) {
            HashMap hashMapOf;
            String str;
            List<String> list = (List) a.b(a.f100697c).get(eCHREvent.getEventName());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("receiver event, it=");
            sb5.append(eCHREvent);
            sb5.append(", callbackList=");
            sb5.append(list);
            sb5.append(", size=");
            sb5.append(list != null ? Integer.valueOf(list.size()) : null);
            cg0.a.b("ECSDKEventManager", sb5.toString());
            if (list != null) {
                hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("KEY_JSON", eCHREvent.getData().toString()));
                for (String str2 : list) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(TraeConstants.KEY_OPERATION, "LOGIC");
                    CallbackWrapper callbackWrapper = (CallbackWrapper) a.a(a.f100697c).get(str2);
                    if (callbackWrapper == null || (str = callbackWrapper.callback) == null) {
                        return;
                    }
                    hashMap.put("KEY_CALLBACK", str);
                    hashMap.put("KEY_KEEP_CALLBACK", String.valueOf(true));
                    QQEcommerceSdk.INSTANCE.onEvent(new ECPluginServiceEvent(hashMap, hashMapOf));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/d;", "it", "", "a", "(Lcom/tencent/ecommerce/base/plugin/d;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class c<T> implements EventObserver<ECPluginServiceEvent> {

        /* renamed from: d, reason: collision with root package name */
        public static final c f100702d = new c();

        c() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECPluginServiceEvent eCPluginServiceEvent) {
            QQEcommerceSdk.INSTANCE.onEvent(new ECPluginServiceEvent(eCPluginServiceEvent.a(), eCPluginServiceEvent.getResult()));
        }
    }

    a() {
    }

    public static final /* synthetic */ Map a(a aVar) {
        return callbackWrapperMap;
    }

    public static final /* synthetic */ Map b(a aVar) {
        return eventToCallbackMap;
    }

    public final void c(String eventType, String callback, String callbackTag) {
        Map<String, List<String>> map = eventToCallbackMap;
        List<String> list = map.get(eventType);
        if (list == null) {
            list = new ArrayList<>();
            map.put(eventType, list);
        }
        if (!list.contains(callbackTag)) {
            list.add(callbackTag);
        }
        Map<String, CallbackWrapper> map2 = callbackWrapperMap;
        CallbackWrapper callbackWrapper = map2.get(callbackTag);
        if (callbackWrapper == null) {
            callbackWrapper = new CallbackWrapper(callback, callbackTag, new ArrayList());
            map2.put(callbackTag, callbackWrapper);
        }
        if (callbackWrapper.a().contains(eventType)) {
            return;
        }
        callbackWrapper.a().add(eventType);
    }

    public final void d(HashMap<String, String> param) {
        String str = param.get("KEY_EVENT_TYPE");
        String str2 = param.get("KEY_CALLBACK");
        String str3 = param.get("KEY_CALLBACK_TAG");
        cg0.a.b("ECSDKEventManager", "addEventCallback, eventType=" + str + ", callback=" + str2 + ", callbackTag=" + str3);
        if (str != null) {
            if (!(str.length() > 0) || str2 == null) {
                return;
            }
            if (!(str2.length() > 0) || str3 == null) {
                return;
            }
            if (str3.length() > 0) {
                c(str, str2, str3);
            }
        }
    }

    public final void e() {
        LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
        lifecycleEventBus.d(ThreadMode.ORIGIN, ECHREvent.class, b.f100701d);
        lifecycleEventBus.d(ThreadMode.MAIN, ECPluginServiceEvent.class, c.f100702d);
    }

    public final void f(String callbackTag) {
        CallbackWrapper callbackWrapper = callbackWrapperMap.get(callbackTag);
        if (callbackWrapper != null) {
            for (String str : callbackWrapper.a()) {
                Map<String, List<String>> map = eventToCallbackMap;
                List<String> list = map.get(str);
                if (list != null) {
                    list.remove(callbackTag);
                    if (list.isEmpty()) {
                        map.remove(str);
                    }
                }
            }
            callbackWrapperMap.remove(callbackTag);
            QQEcommerceSdk.INSTANCE.releaseLogicCallback(callbackWrapper.callback);
        }
    }

    public final void g(HashMap<String, String> param) {
        String str = param.get("KEY_CALLBACK_TAG");
        cg0.a.b("ECSDKEventManager", "removeEventCallback, callbackTag=" + str);
        if (str != null) {
            if (str.length() > 0) {
                f(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/eventbus/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "callback", "b", "callbackTag", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "eventList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.eventbus.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class CallbackWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String callback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String callbackTag;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<String> eventList;

        public CallbackWrapper(String str, String str2, List<String> list) {
            this.callback = str;
            this.callbackTag = str2;
            this.eventList = list;
        }

        public final List<String> a() {
            return this.eventList;
        }

        public int hashCode() {
            String str = this.callback;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.callbackTag;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<String> list = this.eventList;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "CallbackWrapper(callback=" + this.callback + ", callbackTag=" + this.callbackTag + ", eventList=" + this.eventList + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallbackWrapper)) {
                return false;
            }
            CallbackWrapper callbackWrapper = (CallbackWrapper) other;
            return Intrinsics.areEqual(this.callback, callbackWrapper.callback) && Intrinsics.areEqual(this.callbackTag, callbackWrapper.callbackTag) && Intrinsics.areEqual(this.eventList, callbackWrapper.eventList);
        }
    }
}
