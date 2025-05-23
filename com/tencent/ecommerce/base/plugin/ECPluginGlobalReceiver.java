package com.tencent.ecommerce.base.plugin;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.ui.ECSkin;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/ECPluginGlobalReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/app/Application;", "appContext", "", "a", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECPluginGlobalReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final ECPluginGlobalReceiver f100880a = new ECPluginGlobalReceiver();

    ECPluginGlobalReceiver() {
    }

    public final void a(Application appContext) {
        appContext.registerReceiver(this, new IntentFilter("ACTION_ACCOUNT_CHANGED"));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        cg0.a.b("ECPluginGlobalReceiver", "onReceive action=" + action);
        if (action != null && action.hashCode() == 782101081 && action.equals("ACTION_ACCOUNT_CHANGED")) {
            ECSkin.INSTANCE.init(wg0.a.a());
        }
    }
}
