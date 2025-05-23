package com.tencent.kuikly.core.render.android.expand.module;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J?\u0010\u000f\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002JI\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u001aH\u0014J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u001aH\u0014R&\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00100\u001a\u00020'8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010)\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/k;", "Li01/e;", "", AdMetricTag.EVENT_NAME, "data", "", "c", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "g", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Intent;", "it", "d", "(Landroid/content/Intent;)V", "Lorg/json/JSONObject;", "l", "event", "i", "", "", "Lcom/tencent/kuikly/core/render/android/expand/module/a;", "Ljava/util/Map;", "toHRMap", "Lcom/tencent/kuikly/core/render/android/expand/module/HRNotifyModuleReceiver;", "e", "Lcom/tencent/kuikly/core/render/android/expand/module/HRNotifyModuleReceiver;", "notifyBroadcastReceiver", "", "f", "Z", "hadRegisterNotifyBroadcastReceiver", tl.h.F, "getHadDestroy", "()Z", "setHadDestroy", "(Z)V", "hadDestroy", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class k extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, List<HRCallbackWrapper>> toHRMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HRNotifyModuleReceiver notifyBroadcastReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hadRegisterNotifyBroadcastReceiver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hadDestroy;

    private final void a(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        String optString;
        String optString2;
        if (!this.hadDestroy && callback != null && params != null && (optString = (jSONObject = new JSONObject(params)).optString(AdMetricTag.EVENT_NAME)) != null && (optString2 = jSONObject.optString("id")) != null) {
            List<HRCallbackWrapper> list = this.toHRMap.get(optString);
            if (list == null) {
                list = new ArrayList<>();
                this.toHRMap.put(optString, list);
            }
            list.add(new HRCallbackWrapper(optString2, callback));
            i(optString, jSONObject);
        }
    }

    private final void c(String eventName, String data) {
        List<HRCallbackWrapper> list = this.toHRMap.get(eventName);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((HRCallbackWrapper) it.next()).a().invoke(data);
            }
        }
    }

    private final void g(String params) {
        JSONObject jSONObject;
        String optString;
        if (params != null && (optString = (jSONObject = new JSONObject(params)).optString(AdMetricTag.EVENT_NAME)) != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            l(optString, optJSONObject);
        }
    }

    private final void j(String params) {
        JSONObject jSONObject;
        String optString;
        String optString2;
        List<HRCallbackWrapper> list;
        if (params != null && (optString = (jSONObject = new JSONObject(params)).optString(AdMetricTag.EVENT_NAME)) != null && (optString2 = jSONObject.optString("id")) != null && (list = this.toHRMap.get(optString)) != null) {
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (Intrinsics.areEqual(list.get(i3).getCallbackId(), optString2)) {
                    list.remove(i3);
                    break;
                }
                i3++;
            }
            if (list.isEmpty()) {
                this.toHRMap.remove(optString);
            }
        }
    }

    private final void m() {
        Context applicationContext;
        if (this.notifyBroadcastReceiver != null && this.hadRegisterNotifyBroadcastReceiver) {
            try {
                Context context = getContext();
                if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                    applicationContext.unregisterReceiver(this.notifyBroadcastReceiver);
                }
            } catch (Throwable th5) {
                w.f392617a.b("KRNotifyModule", "unregisterNotifyModuleReceiver: " + th5);
            }
            this.notifyBroadcastReceiver = null;
            this.hadRegisterNotifyBroadcastReceiver = false;
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1001125651) {
            if (hashCode != -146849974) {
                if (hashCode == 1471423497 && method.equals("postNotify")) {
                    g(params);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("addNotify")) {
                a(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("removeNotify")) {
            j(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    public final void d(@NotNull Intent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String stringExtra = it.getStringExtra(AdMetricTag.EVENT_NAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "it.getStringExtra(KEY_EVENT_NAME) ?: \"\"");
        String stringExtra2 = it.getStringExtra("data");
        if (stringExtra2 == null) {
            stringExtra2 = "{}";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra2, "it.getStringExtra(KEY_DATA) ?: \"{}\"");
        c(stringExtra, stringExtra2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(@NotNull String event, @NotNull JSONObject params) {
        Context context;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.notifyBroadcastReceiver == null) {
            this.notifyBroadcastReceiver = new HRNotifyModuleReceiver(this);
            Context context2 = getContext();
            if (context2 != null) {
                context = context2.getApplicationContext();
            } else {
                context = null;
            }
            if (context != null) {
                HRNotifyModuleReceiver hRNotifyModuleReceiver = this.notifyBroadcastReceiver;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
                Unit unit = Unit.INSTANCE;
                context.registerReceiver(hRNotifyModuleReceiver, intentFilter);
                this.hadRegisterNotifyBroadcastReceiver = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@NotNull String eventName, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        Context context = getContext();
        if (context != null) {
            l.e(context, eventName, data);
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        m();
        this.hadDestroy = true;
    }
}
