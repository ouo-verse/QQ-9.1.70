package com.tencent.mobileqq.zootopia.download.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.z1.download.data.ZootopiaSummaryData;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0018j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0\u0018j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/notification/ZPlanModDownloadNotification;", "", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;", "summaryData", "", "modId", "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "progress", "", h.F, "d", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "f", "e", "b", "I", "notifyId", "Lcom/tencent/mobileqq/zootopia/download/notification/d;", "c", "Lcom/tencent/mobileqq/zootopia/download/notification/d;", "zplanNotificationProxy", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "modNotificationIdMap", "", "modNotificationClearedMap", "modSummaryDataMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanModDownloadNotification {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanModDownloadNotification f328166a = new ZPlanModDownloadNotification();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int notifyId = 99601;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final d zplanNotificationProxy = new d();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Integer> modNotificationIdMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Boolean> modNotificationClearedMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Object> modSummaryDataMap = new HashMap<>();

    ZPlanModDownloadNotification() {
    }

    private final int d(String modId) {
        HashMap<String, Integer> hashMap = modNotificationIdMap;
        if (hashMap.containsKey(modId)) {
            Integer num = hashMap.get(modId);
            Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
            return num.intValue();
        }
        int i3 = notifyId;
        notifyId = i3 + 1;
        hashMap.put(modId, Integer.valueOf(i3));
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(x task, int i3, float f16) {
        Intrinsics.checkNotNullParameter(task, "$task");
        String id5 = task.getId();
        if (i3 == 2 && Intrinsics.areEqual(modNotificationClearedMap.get(id5), Boolean.TRUE)) {
            QLog.i("ZPlanNotification_ModDownload", 1, "notifySilentDownloadProgress but cleared before - " + id5);
            return;
        }
        Object obj = modSummaryDataMap.get(id5);
        if (obj != null && (obj instanceof ZootopiaSummaryData)) {
            f328166a.h((ZootopiaSummaryData) obj, id5, i3, f16);
        } else {
            ZootopiaDownloadManager.f327992a.Y(id5, new ZPlanModDownloadNotification$notifySilentDownloadProgress$1$1(id5, i3, f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(ZootopiaSummaryData summaryData, String modId, int downloadStatus, float progress) {
        int d16 = d(modId);
        BaseApplication context = BaseApplication.getContext();
        d dVar = zplanNotificationProxy;
        c a16 = dVar.a(d16);
        QLog.i("ZPlanNotification_ModDownload", 1, "realNotifySilentDownloadProgress - " + modId + " - " + summaryData.getTitle() + ", status= " + downloadStatus + ", " + progress + ", curNotifyId= " + d16 + ", builder= " + a16);
        String title = summaryData.getTitle();
        int i3 = 4;
        String str = "";
        int i16 = 8;
        if (downloadStatus == 2) {
            a16.setProgress(100, (int) (progress * 100), false);
        } else if (downloadStatus == 4) {
            a16.setProgress(0, 0, false);
            str = context.getResources().getString(R.string.xuw);
            Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr\u2026nt_download_notify_pause)");
            i3 = 3;
        } else if (downloadStatus == 5) {
            a16.setProgress(0, 0, false);
            str = context.getResources().getString(R.string.xuv);
            Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr\u2026t_download_notify_finish)");
            i16 = 24;
            i3 = 2;
        } else {
            if (downloadStatus == 6) {
                dVar.b(d16);
                return;
            }
            i3 = 0;
        }
        a16.setTicker(title);
        a16.setContentTitle(title);
        a16.setContentText(str);
        a16.setWhen(System.currentTimeMillis());
        a16.setPriority(-1);
        BaseApplication baseApplication = BaseApplication.context;
        Intent intent = new Intent();
        intent.putExtra("zootopia_id", modId);
        intent.putExtra("zootopia_op_type", i3);
        intent.setAction("zootopia_download_receiver");
        Unit unit = Unit.INSTANCE;
        a16.setContentIntent(PendingIntent.getBroadcast(baseApplication, 0, intent, 201326592));
        BaseApplication baseApplication2 = BaseApplication.context;
        Intent intent2 = new Intent();
        intent2.putExtra("zootopia_id", modId);
        intent2.putExtra("zootopia_op_type", 5);
        intent2.setAction("zootopia_download_receiver");
        a16.setDeleteIntent(PendingIntent.getBroadcast(baseApplication2, 1, intent2, 201326592));
        Notification build = a16.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        build.flags = i16;
        dVar.c(d16, build);
    }

    public final void e(String modId) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        QLog.i("ZPlanNotification_ModDownload", 1, "notificationCleared - " + modId);
        modNotificationClearedMap.put(modId, Boolean.TRUE);
    }

    public final void f(final x task, final int downloadStatus, final float progress) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.notification.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanModDownloadNotification.g(x.this, downloadStatus, progress);
            }
        });
    }
}
