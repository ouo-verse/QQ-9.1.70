package com.tencent.mobileqq.vas.panel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B!\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u001c\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/panel/FontBubblePayEventReceiver;", "Landroid/content/BroadcastReceiver;", "", "a", "b", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "Lkotlin/Function2;", "", "Lorg/json/JSONObject;", "Lkotlin/jvm/functions/Function2;", "sendKuiklyPayEvent", "", "Z", "isRegistered", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FontBubblePayEventReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function2<String, JSONObject, Unit> sendKuiklyPayEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isRegistered;

    /* JADX WARN: Multi-variable type inference failed */
    public FontBubblePayEventReceiver(Function2<? super String, ? super JSONObject, Unit> sendKuiklyPayEvent) {
        Intrinsics.checkNotNullParameter(sendKuiklyPayEvent, "sendKuiklyPayEvent");
        this.sendKuiklyPayEvent = sendKuiklyPayEvent;
    }

    public final void a() {
        if (this.isRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        BaseApplicationImpl.getApplication().registerReceiver(this, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        this.isRegistered = true;
    }

    public final void b() {
        if (this.isRegistered) {
            try {
                BaseApplicationImpl.getApplication().unregisterReceiver(this);
            } catch (Throwable th5) {
                QLog.e("FontBubblePayEventReceiver", 1, "unRegisterReceiver error: " + th5.getMessage());
            }
            this.isRegistered = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("broadcast", true);
            String stringExtra = intent.getStringExtra("event");
            String stringExtra2 = intent.getStringExtra("data");
            if (booleanExtra && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                Intrinsics.checkNotNull(stringExtra2);
                JSONObject jSONObject = new JSONObject(stringExtra2);
                Function2<String, JSONObject, Unit> function2 = this.sendKuiklyPayEvent;
                Intrinsics.checkNotNull(stringExtra);
                function2.invoke(stringExtra, jSONObject);
                return;
            }
            QLog.e("FontBubblePayEventReceiver", 1, "onReceive error: receive event info illegal.");
            return;
        }
        QLog.e("FontBubblePayEventReceiver", 1, "onReceive error: context or intent is null.");
    }
}
