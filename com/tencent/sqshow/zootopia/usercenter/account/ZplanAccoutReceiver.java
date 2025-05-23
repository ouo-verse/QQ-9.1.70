package com.tencent.sqshow.zootopia.usercenter.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\f\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/account/ZplanAccoutReceiver;", "Landroid/content/BroadcastReceiver;", "", "", "a", "()[Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanAccoutReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final ZplanAccoutReceiver f373102a = new ZplanAccoutReceiver();

    ZplanAccoutReceiver() {
    }

    private final String[] a() {
        return new String[]{NewIntent.ACTION_ACCOUNT_KICKED, NewIntent.ACTION_ACCOUNT_CHANGED, NewIntent.ACTION_ACCOUNT_EXPIRED, NewIntent.ACTION_LOGOUT, NewIntent.ACTION_FORCE_LOGOUT, NewIntent.ACTION_LOGIN};
    }

    public final void b() {
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        for (String str : a()) {
            intentFilter.addAction(str);
        }
        baseApplication.registerReceiver(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        QLog.i("ZplanAccoutReceiver", 1, "onReceive action = " + (intent != null ? intent.getAction() : null));
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        switch (action.hashCode()) {
            case -1177559092:
                if (!action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED)) {
                    return;
                }
                break;
            case -573186114:
                if (!action.equals(NewIntent.ACTION_ACCOUNT_KICKED)) {
                    return;
                }
                break;
            case 667652209:
                if (!action.equals(NewIntent.ACTION_LOGOUT)) {
                    return;
                }
                break;
            case 870619995:
                if (!action.equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                    return;
                }
                break;
            case 1782925093:
                if (!action.equals(NewIntent.ACTION_FORCE_LOGOUT)) {
                    return;
                }
                break;
            case 1822652290:
                if (action.equals(NewIntent.ACTION_LOGIN)) {
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    String action2 = intent.getAction();
                    Intrinsics.checkNotNull(action2);
                    simpleEventBus.dispatchEvent(new ZplanEventLogin(action2));
                    return;
                }
                return;
            default:
                return;
        }
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        String action3 = intent.getAction();
        Intrinsics.checkNotNull(action3);
        simpleEventBus2.dispatchEvent(new ZplanEventLogout(action3));
    }
}
