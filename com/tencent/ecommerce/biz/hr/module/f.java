package com.tencent.ecommerce.biz.hr.module;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bi0.ECHREvent;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u000fB\u0007\u00a2\u0006\u0004\b%\u0010&J?\u0010\u000f\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016JI\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016R&\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/f;", "Li01/e;", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lbi0/a;", "Lcom/tencent/ecommerce/biz/hr/module/HRNotifyModuleCrossProcessEvent;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "i", "d", "g", "j", "event", "c", AdMetricTag.EVENT_NAME, "data", "onReceiveCrossProcessEvent", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", "Lcom/tencent/ecommerce/biz/hr/module/i;", "Ljava/util/Map;", "toHRMap", "Lcom/tencent/ecommerce/biz/hr/module/j;", "e", "Lcom/tencent/ecommerce/biz/hr/module/j;", "notifyBroadcastReceiver", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f extends i01.e implements EventObserver<ECHREvent>, HRNotifyModuleCrossProcessEvent {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, List<HRCallbackWrapper>> toHRMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private j notifyBroadcastReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/f$a;", "", "", "KEY_CROSS_PROCESS", "Ljava/lang/String;", "KEY_DATA", "KEY_EVENT_NAME", "KEY_ID", "MODULE_NAME", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.hr.module.f$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f() {
        LifecycleEventBus.f100688b.d(ThreadMode.MAIN, ECHREvent.class, this);
    }

    private final void g() {
        if (this.notifyBroadcastReceiver == null) {
            this.notifyBroadcastReceiver = new j(this);
            Context context = getContext();
            if (context != null) {
                j jVar = this.notifyBroadcastReceiver;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
                Unit unit = Unit.INSTANCE;
                context.registerReceiver(jVar, intentFilter);
            }
        }
    }

    private final void j() {
        Context context;
        if (this.notifyBroadcastReceiver == null || (context = getContext()) == null) {
            return;
        }
        context.unregisterReceiver(this.notifyBroadcastReceiver);
    }

    @Override // com.tencent.ecommerce.base.eventbus.EventObserver
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onEvent(ECHREvent event) {
        List<HRCallbackWrapper> list = this.toHRMap.get(event.getEventName());
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((HRCallbackWrapper) it.next()).callback.invoke(event.getData().toString());
            }
        }
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        int hashCode = method.hashCode();
        if (hashCode != -1001125651) {
            if (hashCode != -146849974) {
                if (hashCode == 1471423497 && method.equals("postNotify")) {
                    d(params);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("addNotify")) {
                a(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("removeNotify")) {
            i(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        LifecycleEventBus.f100688b.e(this);
        j();
    }

    @Override // com.tencent.ecommerce.biz.hr.module.HRNotifyModuleCrossProcessEvent
    public void onReceiveCrossProcessEvent(String eventName, String data) {
        List<HRCallbackWrapper> list = this.toHRMap.get(eventName);
        if (list != null) {
            for (HRCallbackWrapper hRCallbackWrapper : list) {
                if (hRCallbackWrapper.crossProcess) {
                    hRCallbackWrapper.callback.invoke(data);
                }
            }
        }
    }

    private final void d(String params) {
        JSONObject jSONObject;
        String optString;
        if (params == null || (optString = (jSONObject = new JSONObject(params)).optString(AdMetricTag.EVENT_NAME)) == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        LifecycleEventBus.f100688b.f(new ECHREvent(optString, optJSONObject));
        if (jSONObject.optBoolean("crossProcess", false)) {
            Intent intent = new Intent("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
            intent.putExtra(AdMetricTag.EVENT_NAME, optString);
            intent.putExtra("data", optJSONObject.toString());
            Context context = getContext();
            if (context != null) {
                context.sendBroadcast(intent);
            }
        }
    }

    private final void i(String params) {
        JSONObject jSONObject;
        String optString;
        String optString2;
        List<HRCallbackWrapper> list;
        if (params == null || (optString = (jSONObject = new JSONObject(params)).optString(AdMetricTag.EVENT_NAME)) == null || (optString2 = jSONObject.optString("id")) == null || (list = this.toHRMap.get(optString)) == null) {
            return;
        }
        int size = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (Intrinsics.areEqual(list.get(i3).callbackId, optString2)) {
                list.remove(i3);
                break;
            }
            i3++;
        }
        if (list.isEmpty()) {
            this.toHRMap.remove(optString);
        }
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        String optString;
        String optString2;
        if (callback == null || params == null || (optString = (jSONObject = new JSONObject(params)).optString(AdMetricTag.EVENT_NAME)) == null || (optString2 = jSONObject.optString("id")) == null) {
            return;
        }
        List<HRCallbackWrapper> list = this.toHRMap.get(optString);
        if (list == null) {
            list = new ArrayList<>();
            this.toHRMap.put(optString, list);
        }
        boolean optBoolean = jSONObject.optBoolean("crossProcess", false);
        list.add(new HRCallbackWrapper(optString2, callback, optBoolean));
        if (optBoolean) {
            g();
        }
    }
}
