package com.tencent.mobileqq.qqecommerce.biz.eventbus.impl;

import com.tencent.mobileqq.qqecommerce.biz.eventbus.IQQEcommerceEventBus;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.QQECommerceSdkImpl;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J4\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n`\u000bH\u0016R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/impl/QQEcommerceEventBusImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/IQQEcommerceEventBus;", "", "event", "Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/IQQEcommerceEventBus$a;", "observer", "", "observeEvent", "releaseObserver", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "data", "sendEvent", "", "", "Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/impl/QQEcommerceEventBusImpl$a;", "observerWrapperList", "Ljava/util/Map;", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQEcommerceEventBusImpl implements IQQEcommerceEventBus {
    private final Map<Integer, ObserverWrapper> observerWrapperList = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/impl/QQEcommerceEventBusImpl$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getObserverTag", "()I", "observerTag", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "eventList", "<init>", "(ILjava/util/List;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.eventbus.impl.QQEcommerceEventBusImpl$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class ObserverWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int observerTag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<String> eventList;

        public ObserverWrapper(int i3, List<String> eventList) {
            Intrinsics.checkNotNullParameter(eventList, "eventList");
            this.observerTag = i3;
            this.eventList = eventList;
        }

        public final List<String> a() {
            return this.eventList;
        }

        public int hashCode() {
            return (this.observerTag * 31) + this.eventList.hashCode();
        }

        public String toString() {
            return "ObserverWrapper(observerTag=" + this.observerTag + ", eventList=" + this.eventList + ")";
        }

        public /* synthetic */ ObserverWrapper(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? new ArrayList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ObserverWrapper)) {
                return false;
            }
            ObserverWrapper observerWrapper = (ObserverWrapper) other;
            return this.observerTag == observerWrapper.observerTag && Intrinsics.areEqual(this.eventList, observerWrapper.eventList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002=\u0012/\u0012-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ-\u0010\u000b\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/eventbus/impl/QQEcommerceEventBusImpl$b", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Function1<HashMap<String, Object>, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQEcommerceEventBus.a f262529d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f262530e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQEcommerceEventBusImpl f262531f;

        b(IQQEcommerceEventBus.a aVar, String str, QQEcommerceEventBusImpl qQEcommerceEventBusImpl) {
            this.f262529d = aVar;
            this.f262530e = str;
            this.f262531f = qQEcommerceEventBusImpl;
        }

        public void a(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f262529d.a(this.f262530e, result);
            if (QQECommerceSdkImpl.INSTANCE.b()) {
                return;
            }
            this.f262531f.releaseObserver(this.f262530e, this.f262529d);
            this.f262531f.observeEvent(this.f262530e, this.f262529d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
            a(hashMap);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.eventbus.IQQEcommerceEventBus
    public void observeEvent(String event, IQQEcommerceEventBus.a observer) {
        List<String> a16;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(observer, "observer");
        ObserverWrapper observerWrapper = this.observerWrapperList.get(Integer.valueOf(observer.hashCode()));
        if (observerWrapper == null) {
            observerWrapper = new ObserverWrapper(observer.hashCode(), null, 2, 0 == true ? 1 : 0);
            this.observerWrapperList.put(Integer.valueOf(observer.hashCode()), observerWrapper);
        }
        if (observerWrapper.a().contains(event)) {
            return;
        }
        ObserverWrapper observerWrapper2 = this.observerWrapperList.get(Integer.valueOf(observer.hashCode()));
        if (observerWrapper2 != null && (a16 = observerWrapper2.a()) != null) {
            a16.add(event);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("KEY_EVENT_TYPE", event);
        hashMap.put("KEY_CALLBACK_TAG", event + observer.hashCode());
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(99, hashMap, new b(observer, event, this));
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.eventbus.IQQEcommerceEventBus
    public void releaseObserver(String event, IQQEcommerceEventBus.a observer) {
        List<String> a16;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(observer, "observer");
        ObserverWrapper observerWrapper = this.observerWrapperList.get(Integer.valueOf(observer.hashCode()));
        if (observerWrapper != null && (a16 = observerWrapper.a()) != null) {
            a16.remove(event);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("KEY_CALLBACK_TAG", event + observer.hashCode());
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(98, hashMap, null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.eventbus.IQQEcommerceEventBus
    public void sendEvent(String event, HashMap<String, Object> data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.eventbus.IQQEcommerceEventBus
    public void releaseObserver(IQQEcommerceEventBus.a observer) {
        List<String> a16;
        Intrinsics.checkNotNullParameter(observer, "observer");
        ObserverWrapper remove = this.observerWrapperList.remove(Integer.valueOf(observer.hashCode()));
        if (remove == null || (a16 = remove.a()) == null) {
            return;
        }
        Iterator<String> it = a16.iterator();
        while (it.hasNext()) {
            releaseObserver(it.next(), observer);
        }
    }
}
