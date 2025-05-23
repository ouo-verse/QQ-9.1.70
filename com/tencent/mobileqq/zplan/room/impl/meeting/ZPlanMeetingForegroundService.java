package com.tencent.mobileqq.zplan.room.impl.meeting;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/ZPlanMeetingForegroundService;", "Landroid/app/Service;", "Landroid/app/Notification;", "a", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "", WadlProxyConsts.FLAGS, "startId", "onStartCommand", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "I", "CONST_FOREGROUND_SERVICE_NOTIFICATION_ID", "", "e", "Z", "showing", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMeetingForegroundService extends Service {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int CONST_FOREGROUND_SERVICE_NOTIFICATION_ID = 888;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean showing;

    private final Notification a() {
        QQNotificationManager.getInstance();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, QQNotificationManager.CHANNEL_ID_OTHER);
        builder.setOngoing(true);
        builder.setSmallIcon(R.drawable.ie9);
        builder.setContentTitle("\u5c0f\u7a9d\u4f1a\u8bae");
        builder.setContentText("\u5f53\u524d\u6b63\u5728\u4f1a\u8bae\u4e2d\uff0c\u70b9\u51fb\u56de\u5230\u5c0f\u7a9d");
        builder.setContentIntent(PendingIntent.getActivity(this, 1, new Intent("mqqapi://zplan/enterAvatarScene?referer=3004&sceneType=7&pageData=%7B%22mapId%22%3A200001%2C%22openDetailNotReady%22%3Atrue%7D&sceneData=%7B%22testParam1%22%3A%22xxx%22%2C%22testParam2%22%3A%22yyy%22%7D&src_type=app&version=1.0"), 201326592));
        Notification build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!this.showing) {
            startForeground(this.CONST_FOREGROUND_SERVICE_NOTIFICATION_ID, a());
            this.showing = true;
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
