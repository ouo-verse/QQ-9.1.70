package com.tencent.mobileqq.timiqqid.helper;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/timiqqid/helper/CommonUtils;", "", "", "title", "content", WadlProxyConsts.KEY_JUMP_URL, "", "a", "<init>", "()V", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class CommonUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CommonUtils f293196a = new CommonUtils();

    CommonUtils() {
    }

    @JvmStatic
    public static final void a(@NotNull String title, @NotNull String content, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (!qQNotificationManager.areNotificationsEnabled(MobileQQ.sMobileQQ)) {
            YoloLog.e(com.tencent.av.video.effect.utils.CommonUtils.TAG, new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.helper.CommonUtils$showNotification$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "QQNotificationManager not enable";
                }
            });
            return;
        }
        Intent intent = new Intent(Foreground.getTopActivity(), (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(String.valueOf(jumpUrl)));
        qQNotificationManager.notify(com.tencent.av.video.effect.utils.CommonUtils.TAG, NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, new NotificationCompat.Builder(MobileQQ.sMobileQQ).setSmallIcon(R.drawable.icon).setWhen(System.currentTimeMillis()).setContentTitle(title).setContentText(content).setAutoCancel(true).setPriority(2).setChannelId(QQNotificationManager.CHANNEL_ID_OTHER).setContentIntent(PendingIntent.getActivity(MobileQQ.sMobileQQ, NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, intent, 201326592)).build());
    }
}
