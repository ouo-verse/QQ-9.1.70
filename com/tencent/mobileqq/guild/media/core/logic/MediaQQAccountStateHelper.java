package com.tencent.mobileqq.guild.media.core.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0003B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaQQAccountStateHelper;", "Landroid/content/BroadcastReceiver;", "", "a", "c", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/media/core/f;", "Ljava/lang/ref/WeakReference;", "core", "<init>", "(Ljava/lang/ref/WeakReference;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaQQAccountStateHelper extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<com.tencent.mobileqq.guild.media.core.f> core;

    public MediaQQAccountStateHelper(@NotNull WeakReference<com.tencent.mobileqq.guild.media.core.f> core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        a();
    }

    private final void a() {
        Context appContext;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplication.getContext().getPackageName());
        intentFilter.addAction(AppConstants.QQ_KICKED_LOGIN_OTHER_DEVICE);
        com.tencent.mobileqq.guild.media.core.f fVar = this.core.get();
        if (fVar != null && (appContext = fVar.getAppContext()) != null) {
            appContext.registerReceiver(this, intentFilter);
        }
    }

    private final void c() {
        Context appContext;
        try {
            com.tencent.mobileqq.guild.media.core.f fVar = this.core.get();
            if (fVar != null && (appContext = fVar.getAppContext()) != null) {
                appContext.unregisterReceiver(this);
            }
        } catch (Exception unused) {
        }
    }

    public final void b() {
        c();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        QLog.e("QGMC.Core.MediaQQAccountStateHelper", 1, "qqAccountReceiver onReceive=" + action);
        c();
        com.tencent.mobileqq.guild.media.core.f fVar = this.core.get();
        if (fVar != null) {
            fVar.I();
        }
    }
}
