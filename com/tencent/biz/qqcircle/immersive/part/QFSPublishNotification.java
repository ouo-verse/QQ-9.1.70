package com.tencent.biz.qqcircle.immersive.part;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0006J*\u0010\u001c\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ*\u0010\u001d\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ*\u0010\u001e\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ2\u0010\u001f\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u001b\u0010&\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010)\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010#\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSPublishNotification;", "", "Landroidx/core/app/NotificationCompat$Builder;", "a", "Lcom/tencent/biz/qqcircle/immersive/part/QFSPublishNotification$a;", "limitInfo", "", "progress", "", tl.h.F, "f", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "traceId", "missionId", "status", "Landroid/app/PendingIntent;", "b", "bucket", "", "i", "info", "j", "g", "c", "Landroid/graphics/Bitmap;", "largeIcon", DomainData.DOMAIN_NAME, "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "showLimitMap", "Lkotlin/Lazy;", "d", "()Ljava/lang/String;", "channelId", "e", "()I", "notifyId", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublishNotification {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublishNotification f87509a = new QFSPublishNotification();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, ShowLimitInfo> showLimitMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy notifyId;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPublishNotification$channelId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return ((IQCircleNotificationApi) QRoute.api(IQCircleNotificationApi.class)).getHideBadgeChannel();
            }
        });
        channelId = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPublishNotification$notifyId$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(((IQCircleNotificationApi) QRoute.api(IQCircleNotificationApi.class)).getQCircleCommonNotifyId());
            }
        });
        notifyId = lazy2;
    }

    QFSPublishNotification() {
    }

    private final NotificationCompat.Builder a() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(BaseApplication.context);
        builder.setSmallIcon(R.drawable.b8g);
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setPriority(-2);
        builder.setSound(null);
        builder.setVibrate(null);
        return builder;
    }

    private final PendingIntent b(long taskId, String traceId, String missionId, int status) {
        Intent intent = new Intent();
        intent.putExtra("type", 2);
        intent.putExtra("qcircle_publish_status", String.valueOf(status));
        intent.putExtra("qcircle_publish_traceid", traceId);
        intent.putExtra("qcircle_publish_missionid", missionId);
        intent.putExtra("qcircle_publish_taskid", String.valueOf(taskId));
        Intent intent2 = new Intent(BaseApplication.context, (Class<?>) JumpActivity.class);
        intent2.setData(Uri.parse("mqqapi://qzone/qzone_push"));
        intent2.putExtra("realIntent", intent);
        intent2.putExtra("pushschema", "mqqapi://qcircle/openfolder");
        intent2.putExtra(QQNotificationManager.PARAM_NOTIFYID, f87509a.e());
        intent2.addFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.context, e(), intent2, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(\n           \u2026tent.FLAG_UPDATE_CURRENT)");
        return activity;
    }

    private final String d() {
        return (String) channelId.getValue();
    }

    private final int e() {
        return ((Number) notifyId.getValue()).intValue();
    }

    private final boolean f() {
        if (Build.VERSION.SDK_INT < 26) {
            QRouteApi api = QRoute.api(IQCircleNotificationApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQCircleNotificationApi::class.java)");
            return IQCircleNotificationApi.a.a((IQCircleNotificationApi) api, false, 1, null);
        }
        QRouteApi api2 = QRoute.api(IQCircleNotificationApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IQCircleNotificationApi::class.java)");
        return IQCircleNotificationApi.a.b((IQCircleNotificationApi) api2, d(), false, 2, null);
    }

    private final boolean g(int bucket) {
        if (bucket == 1 || bucket == 2) {
            return true;
        }
        return false;
    }

    private final boolean h(ShowLimitInfo limitInfo, int progress) {
        if (progress < 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSPublishNotification", 2, "[isProgressValid] invalid progress, new: " + progress);
            }
            return false;
        }
        if (limitInfo.getLastShowProgress() >= progress) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSPublishNotification", 2, "[isProgressValid] not increase progress, new: " + progress + ", last: " + limitInfo.getLastShowProgress());
            }
            return false;
        }
        if (System.currentTimeMillis() - limitInfo.getLastProgressShowTime() < 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSPublishNotification", 2, "[isProgressValid] show too quick");
            }
            return false;
        }
        return true;
    }

    private final void i(long taskId, String traceId, String missionId, int status, int bucket) {
        WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
        builder.eventId(QCirclePublishQualityReporter.E_NOTIFICATION_SHOW);
        builder.traceId(traceId);
        builder.ext1(String.valueOf(status));
        builder.ext2(String.valueOf(bucket));
        builder.ext3(missionId);
        builder.ext4(String.valueOf(taskId));
        WinkPublishReportQueue.INSTANCE.report(builder.getReportData(), "QCIRCLE");
    }

    private final void j(ShowLimitInfo info) {
        if (info != null && !info.getHasReportTAB()) {
            QLog.i("QFSPublishNotification", 1, "[reportTAB] report to tab");
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_publish_notificationbar");
            info.e(true);
        }
    }

    public final int c() {
        int i3;
        if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_publish_notificationbar")) {
            i3 = 1;
        } else if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isContrast("exp_xsj_publish_notificationbar")) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        QLog.d("QFSPublishNotification", 1, "[expBucket] bucket=" + i3);
        return i3;
    }

    public final void k(long taskId, @NotNull String traceId, @NotNull String missionId, @Nullable Bitmap largeIcon) {
        int i3;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        ShowLimitInfo remove = showLimitMap.remove(Long.valueOf(taskId));
        if (remove != null) {
            i3 = remove.getTabBucket();
        } else {
            i3 = 3;
        }
        int i16 = i3;
        if (!g(i16)) {
            QLog.w("QFSPublishNotification", 1, "[showFailed] invalid tab bucket, " + i16);
            return;
        }
        if (!f()) {
            QLog.w("QFSPublishNotification", 1, "[showFailed] channel is disable");
            return;
        }
        if (i16 == 2) {
            i(taskId, traceId, missionId, 3, i16);
            j(remove);
            return;
        }
        NotificationCompat.Builder a16 = a();
        a16.setLargeIcon(largeIcon);
        a16.setContentTitle("\u53d1\u5e03\u5931\u8d25");
        a16.setTicker("\u53d1\u5e03\u5931\u8d25");
        a16.setContentText("\u89c6\u9891\u53d1\u5e03\u5931\u8d25\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5");
        a16.setContentIntent(f87509a.b(taskId, traceId, missionId, 3));
        Notification build = a16.build();
        Intrinsics.checkNotNullExpressionValue(build, "createBaseBuilder().appl\u2026_FAIL))\n        }.build()");
        ((IQCircleNotificationApi) QRoute.api(IQCircleNotificationApi.class)).showNotification("QFSPublishNotification", e(), build, d());
        i(taskId, traceId, missionId, 3, i16);
        j(remove);
    }

    public final void l(long taskId, @NotNull String traceId, @NotNull String missionId, @Nullable Bitmap largeIcon) {
        int i3;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        ConcurrentHashMap<Long, ShowLimitInfo> concurrentHashMap = showLimitMap;
        ShowLimitInfo showLimitInfo = concurrentHashMap.get(Long.valueOf(taskId));
        if (showLimitInfo != null) {
            i3 = showLimitInfo.getTabBucket();
        } else {
            i3 = 3;
        }
        int i16 = i3;
        if (!g(i16)) {
            QLog.w("QFSPublishNotification", 1, "[showNetworkWaiting] invalid tab bucket, " + i16);
            return;
        }
        if (!f()) {
            QLog.w("QFSPublishNotification", 1, "[showNetworkWaiting] channel is disable");
            return;
        }
        if (i16 == 2) {
            i(taskId, traceId, missionId, 4, i16);
            j(concurrentHashMap.get(Long.valueOf(taskId)));
            return;
        }
        NotificationCompat.Builder a16 = a();
        a16.setLargeIcon(largeIcon);
        a16.setContentTitle("\u53d1\u5e03\u6682\u505c");
        a16.setTicker("\u53d1\u5e03\u6682\u505c");
        a16.setContentText("\u65e0\u7f51\u7edc\u8fde\u63a5");
        a16.setContentIntent(f87509a.b(taskId, traceId, missionId, 4));
        Notification build = a16.build();
        Intrinsics.checkNotNullExpressionValue(build, "createBaseBuilder().appl\u2026_WAIT))\n        }.build()");
        ((IQCircleNotificationApi) QRoute.api(IQCircleNotificationApi.class)).showNotification("QFSPublishNotification", e(), build, d());
        i(taskId, traceId, missionId, 4, i16);
        j(concurrentHashMap.get(Long.valueOf(taskId)));
    }

    public final void m(long taskId, @NotNull String traceId, @NotNull String missionId, int progress, @Nullable Bitmap largeIcon) {
        ShowLimitInfo showLimitInfo;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        ShowLimitInfo showLimitInfo2 = new ShowLimitInfo(0L, 0, 0, false, 12, null);
        ShowLimitInfo putIfAbsent = showLimitMap.putIfAbsent(Long.valueOf(taskId), showLimitInfo2);
        if (putIfAbsent == null) {
            showLimitInfo = showLimitInfo2;
        } else {
            showLimitInfo = putIfAbsent;
        }
        if (!h(showLimitInfo, progress)) {
            return;
        }
        showLimitInfo.g(progress);
        if (showLimitInfo.getTabBucket() < 0) {
            showLimitInfo.h(c());
        }
        int tabBucket = showLimitInfo.getTabBucket();
        if (!g(tabBucket)) {
            if (QLog.isDebugVersion()) {
                QLog.i("QFSPublishNotification", 4, "[showProgress] invalid tab bucket, " + tabBucket);
                return;
            }
            return;
        }
        if (!f()) {
            QLog.w("QFSPublishNotification", 1, "[showProgress] channel is disable");
            return;
        }
        if (tabBucket == 2) {
            if (showLimitInfo.getLastProgressShowTime() == 0) {
                i(taskId, traceId, missionId, 1, tabBucket);
                j(showLimitInfo);
            }
            showLimitInfo.f(System.currentTimeMillis());
            return;
        }
        NotificationCompat.Builder a16 = a();
        a16.setLargeIcon(largeIcon);
        String str = "\u6b63\u5728\u53d1\u5e03\u4e2d\uff08" + progress + "%\uff09";
        a16.setTicker(str);
        a16.setContentTitle(str);
        a16.setProgress(100, progress, false);
        a16.setContentIntent(f87509a.b(taskId, traceId, missionId, 1));
        Notification build = a16.build();
        Intrinsics.checkNotNullExpressionValue(build, "createBaseBuilder().appl\u2026GRESS))\n        }.build()");
        ((IQCircleNotificationApi) QRoute.api(IQCircleNotificationApi.class)).showNotification("QFSPublishNotification", e(), build, d());
        if (showLimitInfo.getLastProgressShowTime() == 0) {
            i(taskId, traceId, missionId, 1, tabBucket);
            j(showLimitInfo);
        }
        showLimitInfo.f(System.currentTimeMillis());
    }

    public final void n(long taskId, @NotNull String traceId, @NotNull String missionId, @Nullable Bitmap largeIcon) {
        int i3;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        ShowLimitInfo remove = showLimitMap.remove(Long.valueOf(taskId));
        if (remove != null) {
            i3 = remove.getTabBucket();
        } else {
            i3 = 3;
        }
        int i16 = i3;
        if (!g(i16)) {
            QLog.w("QFSPublishNotification", 1, "[showSuccess] invalid tab bucket, " + i16);
            return;
        }
        if (!f()) {
            QLog.w("QFSPublishNotification", 1, "[showSuccess] channel is disable");
            return;
        }
        if (i16 == 2) {
            i(taskId, traceId, missionId, 2, i16);
            j(remove);
            return;
        }
        NotificationCompat.Builder a16 = a();
        a16.setLargeIcon(largeIcon);
        a16.setContentTitle("\u53d1\u5e03\u6210\u529f");
        a16.setTicker("\u53d1\u5e03\u6210\u529f");
        a16.setContentText("\u89c6\u9891\u53d1\u5e03\u6210\u529f\uff0c\u70b9\u51fb\u67e5\u770b\u8be6\u60c5");
        a16.setContentIntent(f87509a.b(taskId, traceId, missionId, 2));
        Notification build = a16.build();
        Intrinsics.checkNotNullExpressionValue(build, "createBaseBuilder().appl\u2026CCESS))\n        }.build()");
        ((IQCircleNotificationApi) QRoute.api(IQCircleNotificationApi.class)).showNotification("QFSPublishNotification", e(), build, d());
        i(taskId, traceId, missionId, 2, i16);
        j(remove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSPublishNotification$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "f", "(J)V", "lastProgressShowTime", "I", "c", "()I", "g", "(I)V", "lastShowProgress", "d", tl.h.F, "tabBucket", "Z", "()Z", "e", "(Z)V", "hasReportTAB", "<init>", "(JIIZ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSPublishNotification$a, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class ShowLimitInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long lastProgressShowTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int lastShowProgress;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int tabBucket;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasReportTAB;

        public ShowLimitInfo(long j3, int i3, int i16, boolean z16) {
            this.lastProgressShowTime = j3;
            this.lastShowProgress = i3;
            this.tabBucket = i16;
            this.hasReportTAB = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasReportTAB() {
            return this.hasReportTAB;
        }

        /* renamed from: b, reason: from getter */
        public final long getLastProgressShowTime() {
            return this.lastProgressShowTime;
        }

        /* renamed from: c, reason: from getter */
        public final int getLastShowProgress() {
            return this.lastShowProgress;
        }

        /* renamed from: d, reason: from getter */
        public final int getTabBucket() {
            return this.tabBucket;
        }

        public final void e(boolean z16) {
            this.hasReportTAB = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowLimitInfo)) {
                return false;
            }
            ShowLimitInfo showLimitInfo = (ShowLimitInfo) other;
            if (this.lastProgressShowTime == showLimitInfo.lastProgressShowTime && this.lastShowProgress == showLimitInfo.lastShowProgress && this.tabBucket == showLimitInfo.tabBucket && this.hasReportTAB == showLimitInfo.hasReportTAB) {
                return true;
            }
            return false;
        }

        public final void f(long j3) {
            this.lastProgressShowTime = j3;
        }

        public final void g(int i3) {
            this.lastShowProgress = i3;
        }

        public final void h(int i3) {
            this.tabBucket = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((androidx.fragment.app.a.a(this.lastProgressShowTime) * 31) + this.lastShowProgress) * 31) + this.tabBucket) * 31;
            boolean z16 = this.hasReportTAB;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "ShowLimitInfo(lastProgressShowTime=" + this.lastProgressShowTime + ", lastShowProgress=" + this.lastShowProgress + ", tabBucket=" + this.tabBucket + ", hasReportTAB=" + this.hasReportTAB + ")";
        }

        public /* synthetic */ ShowLimitInfo(long j3, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, i3, (i17 & 4) != 0 ? -1 : i16, (i17 & 8) != 0 ? false : z16);
        }
    }
}
