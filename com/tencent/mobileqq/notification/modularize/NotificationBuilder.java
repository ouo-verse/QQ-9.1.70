package com.tencent.mobileqq.notification.modularize;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/NotificationBuilder;", "", "Landroidx/core/app/NotificationCompat$Builder;", "build", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "jumpScheme", "", "a", "Landroid/app/PendingIntent;", "contentIntent", "e", "c", "d", "f", "Landroid/app/Notification;", "b", "", "Lkotlin/Lazy;", "g", "()Z", "sIsAddApplicationIcon", tl.h.F, "sIsNotUseLeftAvatarInMi", "i", "isNotUseLeftAvatar", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class NotificationBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NotificationBuilder f254239a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sIsAddApplicationIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sIsNotUseLeftAvatarInMi;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59207);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f254239a = new NotificationBuilder();
        lazy = LazyKt__LazyJVMKt.lazy(NotificationBuilder$sIsAddApplicationIcon$2.INSTANCE);
        sIsAddApplicationIcon = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(NotificationBuilder$sIsNotUseLeftAvatarInMi$2.INSTANCE);
        sIsNotUseLeftAvatarInMi = lazy2;
    }

    NotificationBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(NotificationCompat.Builder build, f pushComponent, BaseJumpScheme jumpScheme) {
        boolean z16;
        if (pushComponent.buttons.isEmpty()) {
            return;
        }
        for (a aVar : pushComponent.buttons) {
            if (aVar.desc.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                NotificationCompat.Action build2 = new NotificationCompat.Action.Builder(0, aVar.desc, jumpScheme.e(pushComponent, aVar)).build();
                Intrinsics.checkNotNullExpressionValue(build2, "Builder(\n               \u2026on)\n            ).build()");
                build.addAction(build2);
            }
        }
    }

    private final NotificationCompat.Builder c(PendingIntent contentIntent, f pushComponent) {
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        NotificationCompat.Builder style = f(contentIntent, pushComponent).setStyle(bigPictureStyle);
        Intrinsics.checkNotNullExpressionValue(style, "getNotifyBuilder(content\u2026setStyle(bigPictureStyle)");
        if (!TextUtils.isEmpty(pushComponent.title)) {
            style.setContentTitle(pushComponent.title);
        }
        Bitmap c16 = i.f254311a.c(pushComponent.iconUrl);
        if (c16 != null) {
            bigPictureStyle.bigPicture(c16);
            style.setLargeIcon(c16);
            return style;
        }
        return d(contentIntent, pushComponent);
    }

    private final NotificationCompat.Builder d(PendingIntent contentIntent, f pushComponent) {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(pushComponent.contentText);
        NotificationCompat.Builder style = f(contentIntent, pushComponent).setStyle(bigTextStyle);
        Intrinsics.checkNotNullExpressionValue(style, "getNotifyBuilder(content\u2026  .setStyle(bigTextStyle)");
        if (!TextUtils.isEmpty(pushComponent.title)) {
            style.setContentTitle(pushComponent.title);
        }
        Bitmap c16 = i.f254311a.c(pushComponent.iconUrl);
        if (c16 != null) {
            style.setLargeIcon(c16);
        }
        return style;
    }

    private final NotificationCompat.Builder e(PendingIntent contentIntent, f pushComponent) {
        RemoteViews remoteViews = new RemoteViews(RFWApplication.getApplication().getPackageName(), R.layout.hxj);
        RemoteViews remoteViews2 = new RemoteViews(RFWApplication.getApplication().getPackageName(), R.layout.hxj);
        remoteViews.setTextViewText(R.id.content, pushComponent.contentText);
        remoteViews2.setTextViewText(R.id.u8e, pushComponent.contentText);
        remoteViews2.setViewVisibility(R.id.u8e, 0);
        remoteViews2.setViewVisibility(R.id.content, 8);
        if (!g()) {
            remoteViews.setViewVisibility(R.id.d_k, 8);
        }
        NotificationCompat.Builder style = f(contentIntent, pushComponent).setCustomContentView(remoteViews).setCustomBigContentView(remoteViews2).setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        Intrinsics.checkNotNullExpressionValue(style, "getNotifyBuilder(content\u2026coratedCustomViewStyle())");
        if (!TextUtils.isEmpty(pushComponent.title)) {
            style.setContentTitle(pushComponent.title);
            remoteViews.setTextViewText(R.id.title, pushComponent.title);
            remoteViews2.setTextViewText(R.id.title, pushComponent.title);
        }
        Bitmap c16 = i.f254311a.c(pushComponent.senderIcon);
        if (c16 != null) {
            Bitmap roundedCornerBitmap = BaseImageUtil.getRoundedCornerBitmap(c16, c16.getWidth(), c16.getWidth(), c16.getHeight());
            if (roundedCornerBitmap != null) {
                c16 = roundedCornerBitmap;
            }
            remoteViews.setBitmap(R.id.l_k, "setImageBitmap", c16);
            remoteViews2.setBitmap(R.id.l_k, "setImageBitmap", c16);
            return style;
        }
        QLog.d("NotificationBuilder", 1, "PushUtil.getBitmapFromUrl fail, use buildBigTextPush, url:" + pushComponent.senderIcon);
        return d(contentIntent, pushComponent);
    }

    private final NotificationCompat.Builder f(PendingIntent contentIntent, f pushComponent) {
        NotificationCompat.Builder priority = new NotificationCompat.Builder(BaseApplication.context, QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8g).setAutoCancel(true).setContentText(pushComponent.contentText).setWhen(System.currentTimeMillis()).setTicker(pushComponent.contentText).setContentIntent(contentIntent).setPriority(2);
        Intrinsics.checkNotNullExpressionValue(priority, "Builder(BaseApplication.\u2026ationCompat.PRIORITY_MAX)");
        return priority;
    }

    private final boolean g() {
        return ((Boolean) sIsAddApplicationIcon.getValue()).booleanValue();
    }

    private final boolean h() {
        return ((Boolean) sIsNotUseLeftAvatarInMi.getValue()).booleanValue();
    }

    private final boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_is_not_use_left_avatar", false);
    }

    @NotNull
    public final Notification b(@Nullable PendingIntent contentIntent, @NotNull f pushComponent, @NotNull BaseJumpScheme jumpScheme) {
        boolean z16;
        NotificationCompat.Builder d16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Notification) iPatchRedirector.redirect((short) 2, this, contentIntent, pushComponent, jumpScheme);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        Intrinsics.checkNotNullParameter(jumpScheme, "jumpScheme");
        boolean z18 = false;
        if (pushComponent.senderIcon.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (pushComponent.iconUrl.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && ((com.tencent.common.config.pad.j.g() && h()) || i())) {
                pushComponent.iconUrl = pushComponent.senderIcon;
                pushComponent.senderIcon = "";
                QLog.d("NotificationBuilder", 1, "not used left avatar");
            }
        }
        try {
            if (pushComponent.senderIcon.length() > 0) {
                z18 = true;
            }
            if (z18) {
                d16 = e(contentIntent, pushComponent);
            } else {
                int i3 = pushComponent.style;
                if (i3 != 2 && i3 != 3) {
                    d16 = d(contentIntent, pushComponent);
                }
                d16 = c(contentIntent, pushComponent);
            }
        } catch (Exception e16) {
            QLog.e("NotificationBuilder", 1, "buildLeftAvatarPush fail ", e16);
            d16 = d(contentIntent, pushComponent);
        }
        a(d16, pushComponent, jumpScheme);
        Notification build = d16.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
