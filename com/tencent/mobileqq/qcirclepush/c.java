package com.tencent.mobileqq.qcirclepush;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.notification.modularize.i;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.push.MsgNotification;
import cooperation.qzone.remote.ServiceConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qcirclepush/c;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "b", "Lcom/tencent/mobileqq/qcirclepush/a;", "notificationInfo", "", "pushSession", "Landroid/app/Notification;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (((com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager.class)).isSwitchOn("qcircle_push_use_new_jump_action", true) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Intent b(Context context) {
        boolean z16;
        if (Build.VERSION.SDK_INT >= 31) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("mqqapi://qzone/qzone_push"));
            intent.setFlags(335544320);
            intent.setPackage(RFWApplication.getApplication().getPackageName());
            return intent;
        }
        Intent clickIntent = MsgNotification.getClickIntent(context);
        Intrinsics.checkNotNullExpressionValue(clickIntent, "getClickIntent(context)");
        return clickIntent;
    }

    @WorkerThread
    @NotNull
    public final Notification a(@NotNull Context context, @NotNull NotificationInfo notificationInfo, @NotNull String pushSession) {
        String jumpUrl;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        Intrinsics.checkNotNullParameter(pushSession, "pushSession");
        Intent intent = new Intent();
        intent.putExtra("type", 2);
        intent.putExtra("push_id", notificationInfo.getPushId());
        intent.putExtra(ServiceConst.PARA_SESSION_ID, pushSession);
        intent.putExtra(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, notificationInfo.getExtInfo());
        intent.putExtra("KEY_PUSH_IS_FROM", "1");
        try {
            jumpUrl = Uri.parse(notificationInfo.getJumpUrl()).buildUpon().appendQueryParameter(QCircleSchemeAttr.BaseKey.XSJ_SHORT_SESSION_ID, pushSession).build().toString();
        } catch (Exception e16) {
            QLog.e("QCirclePush.NotificationBuilder", 1, "append param failed, url = " + notificationInfo.getJumpUrl(), e16);
            jumpUrl = notificationInfo.getJumpUrl();
        }
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "try {\n            Uri.pa\u2026ionInfo.jumpUrl\n        }");
        QLog.i("QCirclePush.NotificationBuilder", 1, "targetUrl = " + jumpUrl);
        Intent b16 = b(context);
        b16.putExtra("realIntent", intent);
        b16.putExtra("pushschema", jumpUrl);
        b16.putExtra(QQNotificationManager.PARAM_NOTIFYID, notificationInfo.getNotifyId());
        PendingIntent pendingIntent = MsgNotification.getPendingIntent(context, notificationInfo.getNotifyId(), b16);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.b8g).setAutoCancel(true);
        String title = notificationInfo.getTitle();
        if (title.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            title = context.getString(R.string.wn7);
            Intrinsics.checkNotNullExpressionValue(title, "context.getString(R.string.tab_qqcircle)");
        }
        NotificationCompat.Builder priority = autoCancel.setContentTitle(title).setContentText(notificationInfo.getDescription()).setWhen(System.currentTimeMillis()).setTicker(notificationInfo.getDescription()).setContentIntent(pendingIntent).setPriority(2);
        Intrinsics.checkNotNullExpressionValue(priority, "Builder(context)\n       \u2026ationCompat.PRIORITY_MAX)");
        if (SdkInfoUtil.isOreo() && SdkInfoUtil.isTargetSDKOreo()) {
            priority.setChannelId(QQNotificationManager.CHANNEL_ID_OTHER);
        }
        Bitmap c16 = i.f254311a.c(notificationInfo.getIconUrl());
        if (c16 == null) {
            QLog.e("QCirclePush.NotificationBuilder", 1, "build, getBitmapFromUrl failed, url = " + notificationInfo.getIconUrl());
            c16 = j.g(context.getResources(), R.drawable.f162072os2);
        }
        priority.setLargeIcon(c16);
        Notification build = priority.build();
        Intrinsics.checkNotNullExpressionValue(build, "notifyBuilder.build()");
        return build;
    }
}
