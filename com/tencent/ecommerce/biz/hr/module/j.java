package com.tencent.ecommerce.biz.hr.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/j;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tencent/ecommerce/biz/hr/module/HRNotifyModuleCrossProcessEvent;", "a", "Lcom/tencent/ecommerce/biz/hr/module/HRNotifyModuleCrossProcessEvent;", "callback", "<init>", "(Lcom/tencent/ecommerce/biz/hr/module/HRNotifyModuleCrossProcessEvent;)V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class j extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HRNotifyModuleCrossProcessEvent callback;

    public j(HRNotifyModuleCrossProcessEvent hRNotifyModuleCrossProcessEvent) {
        this.callback = hRNotifyModuleCrossProcessEvent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !Intrinsics.areEqual(intent.getAction(), "com.tencent.mobileqq.ecommerce.broadcast.hr.notify")) {
            return;
        }
        HRNotifyModuleCrossProcessEvent hRNotifyModuleCrossProcessEvent = this.callback;
        String stringExtra = intent.getStringExtra(AdMetricTag.EVENT_NAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = intent.getStringExtra("data");
        if (stringExtra2 == null) {
            stringExtra2 = "{}";
        }
        hRNotifyModuleCrossProcessEvent.onReceiveCrossProcessEvent(stringExtra, stringExtra2);
    }
}
