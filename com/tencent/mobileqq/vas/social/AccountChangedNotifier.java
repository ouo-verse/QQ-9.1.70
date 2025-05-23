package com.tencent.mobileqq.vas.social;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/social/AccountChangedNotifier;", "", "", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "Landroid/content/BroadcastReceiver;", "c", "Landroid/content/BroadcastReceiver;", "getReceiver", "()Landroid/content/BroadcastReceiver;", "receiver", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AccountChangedNotifier {

    /* renamed from: a, reason: collision with root package name */
    public static final AccountChangedNotifier f310648a = new AccountChangedNotifier();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vas.social.AccountChangedNotifier$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Bundle extras = intent.getExtras();
            if (extras != null) {
                QLog.d("AccountChangedNotifier", 1, "AccountChangedNotifier on receive account change: " + extras.getString("account", "") + "!");
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    };

    AccountChangedNotifier() {
    }

    @JvmStatic
    public static final void a() {
        if (isInitialized.compareAndSet(false, true)) {
            BaseApplication context = BaseApplication.getContext();
            if (context != null && context.getContentResolver() != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NewIntent.ACTION_LOGIN);
                intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
                MobileQQ.sMobileQQ.registerReceiver(receiver, intentFilter);
                QLog.d("AccountChangedNotifier", 1, "AccountChangedNotifier init!");
                return;
            }
            QLog.w("AccountChangedNotifier", 1, "AccountChangedNotifier init Fail!");
        }
    }
}
