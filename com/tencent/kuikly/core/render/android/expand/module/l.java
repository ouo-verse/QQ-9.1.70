package com.tencent.kuikly.core.render.android.expand.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u001a\n\u0010\f\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\r\u001a\u00020\u0006*\u00020\u000b\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Landroid/content/Context;", "Landroid/content/BroadcastReceiver;", "receiver", "", "c", "f", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "e", "Landroid/content/Intent;", "b", "a", "d", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class l {
    @NotNull
    public static final String a(@NotNull Intent getKuiklyEventName) {
        Intrinsics.checkNotNullParameter(getKuiklyEventName, "$this$getKuiklyEventName");
        String stringExtra = getKuiklyEventName.getStringExtra(AdMetricTag.EVENT_NAME);
        if (stringExtra == null) {
            return "";
        }
        return stringExtra;
    }

    @NotNull
    public static final JSONObject b(@NotNull Intent getKuiklyEventParams) {
        Intrinsics.checkNotNullParameter(getKuiklyEventParams, "$this$getKuiklyEventParams");
        String stringExtra = getKuiklyEventParams.getStringExtra("data");
        if (stringExtra == null) {
            stringExtra = "{}";
        }
        return new JSONObject(stringExtra);
    }

    public static final void c(@NotNull Context registerKuiklyBroadcastReceiver, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(registerKuiklyBroadcastReceiver, "$this$registerKuiklyBroadcastReceiver");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
        Unit unit = Unit.INSTANCE;
        registerKuiklyBroadcastReceiver.registerReceiver(receiver, intentFilter);
    }

    private static final void d(Context context, String str, String str2) {
        Intent intent = new Intent("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
        intent.putExtra(AdMetricTag.EVENT_NAME, str);
        intent.putExtra("data", str2);
        context.sendBroadcast(intent);
    }

    public static final void e(@NotNull Context sendKuiklyEvent, @NotNull String eventName, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(sendKuiklyEvent, "$this$sendKuiklyEvent");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        String jSONObject = data.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "`data`.toString()");
        d(sendKuiklyEvent, eventName, jSONObject);
    }

    public static final void f(@NotNull Context unregisterKuiklyBroadcastReceiver, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(unregisterKuiklyBroadcastReceiver, "$this$unregisterKuiklyBroadcastReceiver");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        unregisterKuiklyBroadcastReceiver.unregisterReceiver(receiver);
    }
}
