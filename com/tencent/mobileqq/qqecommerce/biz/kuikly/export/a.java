package com.tencent.mobileqq.qqecommerce.biz.kuikly.export;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.expand.module.k;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e*\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0014J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/a;", "Lcom/tencent/kuikly/core/render/android/expand/module/k;", "", "event", "Lorg/json/JSONObject;", "data", "", "t", "u", "Landroid/content/Context;", AdMetricTag.EVENT_NAME, "r", "Lorg/json/JSONArray;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "params", "o", "originEventName", "w", "i", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Intent;", "intent", "p", "(Landroid/content/Intent;)V", "Landroid/content/BroadcastReceiver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/BroadcastReceiver;", "webViewEventReceiver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends k {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver webViewEventReceiver;

    private final String o(JSONObject params) {
        String jSONObject = params.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "params.toString()");
        if (jSONObject.length() < 460800) {
            return jSONObject;
        }
        QLog.e("KRNotifyModule", 1, "convertToBroadcastData, data reach max size");
        String jSONObject2 = new JSONObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            QLog.e(\n  \u2026ct().toString()\n        }");
        return jSONObject2;
    }

    private final void q() {
        Context applicationContext;
        if (this.webViewEventReceiver == null) {
            this.webViewEventReceiver = new b(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            Context context = getContext();
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                return;
            }
            applicationContext.registerReceiver(this.webViewEventReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        }
    }

    private final void r(Context context, String str, JSONObject jSONObject) {
        Intent intent = new Intent(str);
        intent.putExtras(nf2.a.b(nf2.a.e(jSONObject)));
        context.sendBroadcast(intent);
    }

    private final void t(String event, JSONObject data) {
        JSONArray optJSONArray;
        if ((event.length() == 0) || (optJSONArray = data.optJSONArray("domains")) == null || optJSONArray.length() == 0) {
            return;
        }
        Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("broadcast", true);
        intent.putExtra("event", w(event));
        intent.putStringArrayListExtra("domains", v(optJSONArray));
        intent.putExtra("data", o(data));
        Context context = getContext();
        if (context != null) {
            context.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        }
    }

    private final void u(JSONObject data) {
        QQKuiklyRenderView c16 = g.c(this);
        if (c16 != null) {
            c16.setActivityResult(data);
        }
    }

    private final ArrayList<String> v(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(jSONArray.getString(i3));
        }
        return arrayList;
    }

    private final String w(String originEventName) {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(originEventName, "custom_event_type_webview_", "", false, 4, (Object) null);
        return replace$default;
    }

    private final void x() {
        Context applicationContext;
        BroadcastReceiver broadcastReceiver = this.webViewEventReceiver;
        if (broadcastReceiver != null) {
            Context context = getContext();
            if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                applicationContext.unregisterReceiver(broadcastReceiver);
            }
            this.webViewEventReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.kuikly.core.render.android.expand.module.k
    public void i(String event, JSONObject params) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(event, "custom_event_type_webview_", false, 2, null);
        if (startsWith$default) {
            q();
        }
        super.i(event, params);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.kuikly.core.render.android.expand.module.k
    public void l(String eventName, JSONObject data) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        if (!data.optBoolean("__send_native_broadcast__")) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(eventName, "custom_event_type_webview_", false, 2, null);
            if (startsWith$default) {
                t(eventName, data);
                return;
            } else if (Intrinsics.areEqual(eventName, "KTOnActivityResultNotify")) {
                u(data);
                super.l(eventName, data);
                return;
            } else {
                super.l(eventName, data);
                return;
            }
        }
        Context context = getContext();
        if (context != null) {
            r(context, eventName, data);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.module.k, i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        x();
    }

    public final void p(Intent intent) {
        String stringExtra;
        Context context;
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra2 = intent.getStringExtra("event");
        if (stringExtra2 == null || (stringExtra = intent.getStringExtra("data")) == null || (context = getContext()) == null) {
            return;
        }
        l.e(context, "custom_event_type_webview_" + stringExtra2, new JSONObject(stringExtra));
    }
}
