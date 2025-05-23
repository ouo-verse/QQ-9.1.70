package com.tencent.mobileqq.minigame.api.impl;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.jsplugin.QQWidgetJsPlugin;
import com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmAppWidgetProvider;
import com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002JD\u0010\u000f\u001a\u00020\u000b2:\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016RF\u0010\u0003\u001a:\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004j\u0004\u0018\u0001`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl;", "Lcom/tencent/mobileqq/minigame/api/IMetaFarmWidgetApi;", "()V", "addWidgetCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errCode", "", "errMsg", "", "Lcom/tencent/mobileqq/minigame/api/AddWidgetCallback;", "checkWidgetRunnable", "Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl$CheckWidgetRunnable;", QQWidgetJsPlugin.EVENT_ADD_WIDGET, "callback", "clearImgCache", "handleAddWidgetCallback", "hasWidget", "", "reportWidgetAdd", "reportWidgetRemove", "requestPinAppWidget", "context", "Landroid/content/Context;", "updateWidgetData", "source", "CheckWidgetRunnable", "Companion", "PendingBroadcastReceiver", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmWidgetApiImpl implements IMetaFarmWidgetApi {
    private static final String ACTION_ADD_WIDGET_RECEIVER = "com.tencent.mobileqq.ACTION_MINI_ADD_WIDGET_CALLBACK";
    private static final String TAG = "MetaFarmWidgetApiImpl";
    private Function2<? super Integer, ? super String, Unit> addWidgetCallback;
    private CheckWidgetRunnable checkWidgetRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl$CheckWidgetRunnable;", "Ljava/lang/Runnable;", "widgetApiRef", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl;", "context", "Landroid/content/Context;", "receiver", "Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl$PendingBroadcastReceiver;", "(Lmqq/util/WeakReference;Lmqq/util/WeakReference;Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl$PendingBroadcastReceiver;)V", TencentLocation.RUN_MODE, "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class CheckWidgetRunnable implements Runnable {
        private final WeakReference<Context> context;
        private final PendingBroadcastReceiver receiver;
        private final WeakReference<MetaFarmWidgetApiImpl> widgetApiRef;

        public CheckWidgetRunnable(WeakReference<MetaFarmWidgetApiImpl> widgetApiRef, WeakReference<Context> context, PendingBroadcastReceiver receiver) {
            Intrinsics.checkNotNullParameter(widgetApiRef, "widgetApiRef");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            this.widgetApiRef = widgetApiRef;
            this.context = context;
            this.receiver = receiver;
        }

        @Override // java.lang.Runnable
        public void run() {
            MetaFarmWidgetApiImpl metaFarmWidgetApiImpl = this.widgetApiRef.get();
            if (metaFarmWidgetApiImpl == null) {
                return;
            }
            if (!metaFarmWidgetApiImpl.hasWidget()) {
                metaFarmWidgetApiImpl.handleAddWidgetCallback(-5, "user timeout");
            } else {
                metaFarmWidgetApiImpl.handleAddWidgetCallback(0, "");
            }
            try {
                Context context = this.context.get();
                if (context != null) {
                    context.unregisterReceiver(this.receiver);
                }
            } catch (Exception e16) {
                QLog.e(MetaFarmWidgetApiImpl.TAG, 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl$PendingBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "widgetApiRef", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmWidgetApiImpl;", "(Lmqq/util/WeakReference;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class PendingBroadcastReceiver extends BroadcastReceiver {
        private final WeakReference<MetaFarmWidgetApiImpl> widgetApiRef;

        public PendingBroadcastReceiver(WeakReference<MetaFarmWidgetApiImpl> widgetApiRef) {
            Intrinsics.checkNotNullParameter(widgetApiRef, "widgetApiRef");
            this.widgetApiRef = widgetApiRef;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MetaFarmWidgetApiImpl metaFarmWidgetApiImpl = this.widgetApiRef.get();
            if (metaFarmWidgetApiImpl == null) {
                return;
            }
            if (Intrinsics.areEqual(MetaFarmWidgetApiImpl.ACTION_ADD_WIDGET_RECEIVER, intent != null ? intent.getAction() : null)) {
                int intExtra = intent.getIntExtra("appWidgetId", -1);
                QLog.d(MetaFarmWidgetApiImpl.TAG, 1, "PendingBroadcastReceiver addWidget success, appWidgetId:" + intExtra);
                if (intExtra != -1) {
                    metaFarmWidgetApiImpl.handleAddWidgetCallback(0, "");
                }
                if (context != null) {
                    try {
                        context.unregisterReceiver(this);
                    } catch (Exception e16) {
                        QLog.e(MetaFarmWidgetApiImpl.TAG, 1, "PendingBroadcastReceiver e:" + e16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAddWidgetCallback(int errCode, String errMsg) {
        QLog.i(TAG, 1, "handleAddWidgetCallback errCode:" + errCode + ", errMsg:" + errMsg);
        if (errCode == 0) {
            CheckWidgetRunnable checkWidgetRunnable = this.checkWidgetRunnable;
            if (checkWidgetRunnable != null) {
                ThreadManagerV2.removeJob(checkWidgetRunnable, 64);
            }
            this.checkWidgetRunnable = null;
        }
        Function2<? super Integer, ? super String, Unit> function2 = this.addWidgetCallback;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(errCode), errMsg);
        }
        this.addWidgetCallback = null;
        updateWidgetData(5);
    }

    private final void requestPinAppWidget(Context context) {
        PendingIntent broadcast;
        ComponentName componentName = new ComponentName(context, (Class<?>) MetaFarmAppWidgetProvider.class);
        PendingBroadcastReceiver pendingBroadcastReceiver = new PendingBroadcastReceiver(new WeakReference(this));
        Intent intent = new Intent(ACTION_ADD_WIDGET_RECEIVER);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_ADD_WIDGET_RECEIVER);
        Unit unit = Unit.INSTANCE;
        context.registerReceiver(pendingBroadcastReceiver, intentFilter);
        if (Build.VERSION.SDK_INT >= 31) {
            broadcast = PendingIntent.getBroadcast(context, 0, intent, 167772160);
        } else {
            broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        }
        QLog.d(TAG, 1, "addWidget start");
        AppWidgetManager.getInstance(context).requestPinAppWidget(componentName, null, broadcast);
        CheckWidgetRunnable checkWidgetRunnable = new CheckWidgetRunnable(new WeakReference(this), new WeakReference(context), pendingBroadcastReceiver);
        this.checkWidgetRunnable = checkWidgetRunnable;
        ThreadManagerV2.executeDelay(checkWidgetRunnable, 64, null, false, 5000L);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi
    public void addWidget(Function2<? super Integer, ? super String, Unit> callback) {
        boolean isRequestPinAppWidgetSupported;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Context context = BaseApplication.getContext().getApplicationContext();
        if (hasWidget()) {
            QLog.d(TAG, 1, "addWidget failed: has widget");
            callback.invoke(-2, "has widget");
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            isRequestPinAppWidgetSupported = AppWidgetManager.getInstance(context).isRequestPinAppWidgetSupported();
            if (!isRequestPinAppWidgetSupported) {
                QLog.d(TAG, 1, "addWidget failed: not support");
                callback.invoke(-4, "not support");
                return;
            } else {
                this.addWidgetCallback = callback;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                requestPinAppWidget(context);
                return;
            }
        }
        QLog.d(TAG, 1, "addWidget failed: sdk too low: " + i3);
        callback.invoke(-3, "sdk too low");
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi
    public void clearImgCache() {
        MetaFarmWidgetUpdateManager.INSTANCE.clearImgCache();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi
    public boolean hasWidget() {
        int[] iArr;
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        try {
            iArr = AppWidgetManager.getInstance(applicationContext).getAppWidgetIds(new ComponentName(applicationContext, (Class<?>) MetaFarmAppWidgetProvider.class));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "hasWidget exception:" + e16);
            iArr = null;
        }
        if (iArr != null) {
            if (!(iArr.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi
    public void reportWidgetAdd() {
        MiniAppUtils.reportMiniGameCenterDC00087("4", "9534", "9402", "940202", "989712", "20", "", null);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi
    public void reportWidgetRemove() {
        MiniAppUtils.reportMiniGameCenterDC00087("4", "9534", "9402", "940202", "989713", "20", "", null);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi
    public void updateWidgetData(int source) {
        QLog.d(TAG, 1, "updateWidgetData source:" + source);
        MetaFarmWidgetUpdateManager.INSTANCE.requestUpdateWidget(source);
    }
}
