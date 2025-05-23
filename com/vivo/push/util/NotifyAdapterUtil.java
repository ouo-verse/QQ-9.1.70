package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NotifyAdapterUtil {
    private static final String EXTRA_VPUSH_TYPE = "extra_vpush_type";
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "\u63a8\u9001\u901a\u77e5";
    private static final String TAG = "NotifyManager";
    private static final String USER_ID = "sysUserId";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    private static boolean cancelNotify(Context context, int i3) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i3);
        return true;
    }

    private static synchronized void initAdapter(Context context) {
        NotificationManager notificationManager;
        NotificationChannel notificationChannel;
        String str;
        CharSequence name;
        synchronized (NotifyAdapterUtil.class) {
            if (sNotificationManager == null) {
                sNotificationManager = (NotificationManager) context.getSystemService("notification");
            }
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
                notificationChannel = notificationManager.getNotificationChannel("default");
                if (notificationChannel != null) {
                    name = notificationChannel.getName();
                    if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                        sNotificationManager.deleteNotificationChannel("default");
                    }
                }
                if (isZh(context)) {
                    str = PUSH_ZH;
                } else {
                    str = PUSH_EN;
                }
                NotificationChannel notificationChannel2 = new NotificationChannel(PRIMARY_CHANNEL, str, 4);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(true);
                notificationChannel2.setLockscreenVisibility(1);
                sNotificationManager.createNotificationChannel(notificationChannel2);
            }
        }
    }

    private static boolean isPullService() {
        if (n.f387912a) {
            if (Build.VERSION.SDK_INT < 31) {
                return true;
            }
            return false;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return true;
        }
        return false;
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith(OcrConfig.CHINESE);
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j3, int i3, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        u.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j3, i3, notifyArriveCallbackByUser, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j3, notifyArriveCallbackByUser, aVar);
        }
    }

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j3, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        Notification build;
        Bitmap bitmap;
        Bitmap bitmap2;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i3 = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong("pushId", j3);
        if (com.vivo.push.restructure.a.a().e().l().isOpenMultiUser()) {
            bundle.putInt(USER_ID, w.a());
        }
        bundle.putInt(EXTRA_VPUSH_TYPE, 1);
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builder.setExtras(bundle);
            build = builder.build();
        } else {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setExtras(bundle);
            build = builder2.build();
        }
        Notification notification = build;
        notification.priority = 2;
        notification.flags = 16;
        notification.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i3;
        }
        notification.icon = defaultSmallIconId;
        RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.CHINA).format(new Date()));
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, 0);
        if (list != null && !list.isEmpty() && (bitmap2 = list.get(0)) != null) {
            remoteViews.setImageViewBitmap(suitIconId, bitmap2);
        } else {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i3;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        }
        if (list != null && list.size() > 1) {
            bitmap = list.get(1);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap);
            } else {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap);
            }
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        }
        notification.contentView = remoteViews;
        if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            notification.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        u.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        notification.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification.defaults |= 2;
                        notification.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification.defaults = 2;
                notification.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification.defaults = 1;
        }
        i iVar = new i();
        Intent a16 = iVar.a(context, packageName, j3, insideNotificationItem, notifyArriveCallbackByUser);
        if (a16 != null) {
            if (isPullService()) {
                notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), b.a(context, packageName, j3, a16, insideNotificationItem), 201326592);
            } else {
                new com.vivo.push.b.p(packageName, j3, insideNotificationItem).b(a16);
                notification.contentIntent = iVar.a(context, a16);
            }
            if (sNotificationManager != null) {
                int j16 = com.vivo.push.m.a().j();
                try {
                    if (j16 == 0) {
                        sNotificationManager.notify(sNotifyId, notification);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    if (j16 == 1) {
                        sNotificationManager.notify((int) j3, notification);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    u.a(TAG, "unknow notify style ".concat(String.valueOf(j16)));
                    return;
                } catch (Exception e16) {
                    u.a(TAG, e16);
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        u.a(TAG, "make notify intent error  ");
    }

    private static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j3, int i3, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        Bitmap bitmap;
        Notification.Builder builder;
        long j16;
        int i16;
        int i17;
        Bitmap bitmap2;
        Bitmap decodeResource;
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        String content = insideNotificationItem.getContent();
        int i18 = context.getApplicationInfo().icon;
        boolean isShowTime = insideNotificationItem.isShowTime();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        if (list != null && !list.isEmpty()) {
            bitmap = list.get(0);
            if (bitmap != null && defaultNotifyIcon > 0 && (decodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) != null) {
                int width = decodeResource.getWidth();
                int height = decodeResource.getHeight();
                decodeResource.recycle();
                bitmap = d.a(bitmap, width, height);
            }
        } else {
            bitmap = null;
        }
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
        } else {
            builder = new Notification.Builder(context);
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
        }
        if (com.vivo.push.restructure.a.a().e().l().isOpenMultiUser()) {
            bundle.putInt(USER_ID, w.a());
        }
        bundle.putInt(EXTRA_VPUSH_TYPE, 1);
        bundle.putLong("pushId", j3);
        builder.setExtras(bundle);
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId > 0) {
            i18 = defaultSmallIconId;
        }
        builder.setSmallIcon(i18);
        if (insideNotificationItem.getCompatibleType() != 1) {
            builder.setContentTitle(title);
        }
        builder.setPriority(2);
        builder.setContentText(content);
        if (isShowTime) {
            j16 = System.currentTimeMillis();
        } else {
            j16 = 0;
        }
        builder.setWhen(j16);
        builder.setShowWhen(isShowTime);
        builder.setTicker(title);
        int ringerMode = audioManager.getRingerMode();
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        builder.setDefaults(3);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else if (ringerMode == 1) {
                        builder.setDefaults(2);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else {
                        i16 = 1;
                    }
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(2);
                builder.setVibrate(new long[]{0, 100, 200, 300});
            }
            i16 = 1;
        } else {
            if (ringerMode == 2) {
                i16 = 1;
                builder.setDefaults(1);
            }
            i16 = 1;
        }
        if (list != null && list.size() > i16) {
            bitmap2 = list.get(i16);
            i17 = i3;
        } else {
            i17 = i3;
            bitmap2 = null;
        }
        if (i17 != i16) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(title);
            bigTextStyle.bigText(content);
            builder.setStyle(bigTextStyle);
        }
        if (bitmap2 != null) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(title);
            bigPictureStyle.setSummaryText(content);
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        builder.setAutoCancel(true);
        i iVar = new i();
        Intent a16 = iVar.a(context, packageName, j3, insideNotificationItem, notifyArriveCallbackByUser);
        if (a16 != null) {
            if (isPullService()) {
                builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), b.a(context, packageName, j3, a16, insideNotificationItem), 201326592));
            } else {
                new com.vivo.push.b.p(packageName, j3, insideNotificationItem).b(a16);
                builder.setContentIntent(iVar.a(context, a16));
            }
            Notification build = builder.build();
            int j17 = com.vivo.push.m.a().j();
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                try {
                    if (j17 == 0) {
                        notificationManager.notify(sNotifyId, build);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    if (j17 == 1) {
                        notificationManager.notify((int) j3, build);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    u.a(TAG, "unknow notify style ".concat(String.valueOf(j17)));
                    return;
                } catch (Exception e16) {
                    u.a(TAG, e16);
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        u.a(TAG, "make notify intent error  ");
    }

    public static boolean repealNotifyById(Context context, long j3) {
        int j16 = com.vivo.push.m.a().j();
        if (j16 == 0) {
            long b16 = ad.b().b("com.vivo.push.notify_key", -1L);
            if (b16 == j3) {
                u.d(TAG, "undo showed message ".concat(String.valueOf(j3)));
                u.a(context, "\u56de\u6536\u5df2\u5c55\u793a\u7684\u901a\u77e5\uff1a ".concat(String.valueOf(j3)));
                return cancelNotify(context, sNotifyId);
            }
            u.d(TAG, "current showing message id " + b16 + " not match " + j3);
            u.a(context, "\u4e0e\u5df2\u5c55\u793a\u7684\u901a\u77e5" + b16 + "\u4e0e\u5f85\u56de\u6536\u7684\u901a\u77e5" + j3 + "\u4e0d\u5339\u914d");
            return false;
        }
        if (j16 == 1) {
            return cancelNotify(context, (int) j3);
        }
        u.a(TAG, "unknow cancle notify style ".concat(String.valueOf(j16)));
        return false;
    }

    public static void setNotifyId(int i3) {
        sNotifyId = i3;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }
}
