package com.tencent.qqnt.notification.logic;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\n\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0003J(\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0003J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0003J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/notification/logic/NotificationHandler;", "", "", "d", "", "id", "", "name", "", "importance", "", "isBadgeShow", "e", "Landroid/app/NotificationChannel;", "groupChannel", "messageChannel", "b", "channelId", "Landroidx/core/app/NotificationCompat$Builder;", "g", "c", "Landroid/app/Notification;", "notification", h.F, "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Z", "enableGroupChannel", "Landroid/app/NotificationManager;", "Lkotlin/Lazy;", "f", "()Landroid/app/NotificationManager;", "manager", "<init>", "(Landroid/content/Context;Z)V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NotificationHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean enableGroupChannel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy manager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/notification/logic/NotificationHandler$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.logic.NotificationHandler$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotificationHandler(@NotNull Context context, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        this.enableGroupChannel = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NotificationManager>() { // from class: com.tencent.qqnt.notification.logic.NotificationHandler$manager$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NotificationHandler.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NotificationManager invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (NotificationManager) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = NotificationHandler.this.context;
                Object systemService = context2.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                return (NotificationManager) systemService;
            }
        });
        this.manager = lazy;
        if (Build.VERSION.SDK_INT >= 26) {
            d();
        }
    }

    @TargetApi(26)
    private final void b(NotificationChannel groupChannel, NotificationChannel messageChannel) {
        int importance;
        boolean canShowBadge;
        Uri sound;
        AudioAttributes audioAttributes;
        boolean shouldVibrate;
        long[] vibrationPattern;
        int lightColor;
        boolean shouldShowLights;
        int lockscreenVisibility;
        boolean canBypassDnd;
        if (groupChannel != null && messageChannel != null) {
            importance = messageChannel.getImportance();
            groupChannel.setImportance(importance);
            canShowBadge = messageChannel.canShowBadge();
            groupChannel.setShowBadge(canShowBadge);
            sound = messageChannel.getSound();
            audioAttributes = messageChannel.getAudioAttributes();
            groupChannel.setSound(sound, audioAttributes);
            shouldVibrate = messageChannel.shouldVibrate();
            groupChannel.enableVibration(shouldVibrate);
            vibrationPattern = messageChannel.getVibrationPattern();
            groupChannel.setVibrationPattern(vibrationPattern);
            lightColor = messageChannel.getLightColor();
            groupChannel.setLightColor(lightColor);
            shouldShowLights = messageChannel.shouldShowLights();
            groupChannel.enableLights(shouldShowLights);
            lockscreenVisibility = messageChannel.getLockscreenVisibility();
            groupChannel.setLockscreenVisibility(lockscreenVisibility);
            canBypassDnd = messageChannel.canBypassDnd();
            groupChannel.setBypassDnd(canBypassDnd);
        }
    }

    @TargetApi(26)
    private final void d() {
        e(QQNotificationManager.CHANNEL_ID_SHOW_BADGE, "\u666e\u901a\u6d88\u606f", 4, true);
        e(QQNotificationManager.CHANNEL_ID_OTHER, "\u5176\u5b83\u901a\u77e5", 4, false);
        e(QQNotificationManager.CHANNEL_ID_HIDE_BADGE, "\u901a\u77e5\u680f\u663e\u793aQQ\u56fe\u6807", 2, false);
        if (this.enableGroupChannel) {
            e(QQNotificationManager.CHANNEL_ID_GROUP_MSG, "\u7fa4\u6d88\u606f", 4, true);
        }
        e("CHANNEL_ID_HEALTH_MSG", "\u8fd0\u52a8\u72b6\u6001", 4, false);
    }

    @TargetApi(26)
    private final void e(final String id5, CharSequence name, int importance, boolean isBadgeShow) {
        List notificationChannelGroups;
        Object obj;
        NotificationChannel notificationChannel;
        NotificationChannel notificationChannel2;
        String id6;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationChannelGroups = f().getNotificationChannelGroups();
            Intrinsics.checkNotNullExpressionValue(notificationChannelGroups, "manager.notificationChannelGroups");
            Iterator it = notificationChannelGroups.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    id6 = ((NotificationChannelGroup) obj).getId();
                    if (Intrinsics.areEqual(id6, "GROUP_ID_TOP")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj == null) {
                f().createNotificationChannelGroup(new NotificationChannelGroup("GROUP_ID_TOP", "\u6d88\u606f\u901a\u77e5"));
            }
            notificationChannel = f().getNotificationChannel(id5);
            if (notificationChannel != null) {
                com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Handler", new Function0<String>(id5) { // from class: com.tencent.qqnt.notification.logic.NotificationHandler$createNotificationChannel$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String $id;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$id = id5;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) id5);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "NotificationChannel " + this.$id + " has been create";
                    }
                });
                return;
            }
            final NotificationChannel notificationChannel3 = new NotificationChannel(id5, name, importance);
            notificationChannel3.setShowBadge(isBadgeShow);
            notificationChannel3.setGroup("GROUP_ID_TOP");
            if (importance > 3) {
                notificationChannel3.enableLights(true);
                notificationChannel3.setLightColor(-16711936);
                notificationChannel3.setLockscreenVisibility(0);
                notificationChannel3.setBypassDnd(true);
                if (Intrinsics.areEqual("CHANNEL_ID_HEALTH_MSG", id5)) {
                    notificationChannel3.enableVibration(false);
                } else if (!Intrinsics.areEqual(QQNotificationManager.CHANNEL_ID_SHOW_BADGE, id5) || Build.VERSION.SDK_INT > 28) {
                    notificationChannel3.enableVibration(true);
                    notificationChannel3.setVibrationPattern(new long[]{100, 200, 200, 100});
                } else {
                    notificationChannel3.enableVibration(false);
                }
            }
            notificationChannel3.setSound(null, null);
            com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Handler", new Function0<String>(id5, notificationChannel3) { // from class: com.tencent.qqnt.notification.logic.NotificationHandler$createNotificationChannel$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $id;
                final /* synthetic */ NotificationChannel $notificationChannel;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$id = id5;
                    this.$notificationChannel = notificationChannel3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) id5, (Object) notificationChannel3);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    boolean canShowBadge;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    String str = this.$id;
                    canShowBadge = this.$notificationChannel.canShowBadge();
                    return "NotificationChannel:" + str + " canShowBadge:" + canShowBadge;
                }
            });
            if (Intrinsics.areEqual(QQNotificationManager.CHANNEL_ID_GROUP_MSG, id5) && this.enableGroupChannel) {
                try {
                    notificationChannel2 = f().getNotificationChannel(QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
                    b(notificationChannel3, notificationChannel2);
                } catch (Throwable th5) {
                    com.tencent.qqnt.notification.util.a.f359909a.c("Notification.Handler", new Function0<String>(th5) { // from class: com.tencent.qqnt.notification.logic.NotificationHandler$createNotificationChannel$4
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Throwable $t;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$t = th5;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) th5);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                            return "initChannels: failed. " + this.$t;
                        }
                    });
                }
            }
            f().createNotificationChannel(notificationChannel3);
        }
    }

    private final NotificationManager f() {
        return (NotificationManager) this.manager.getValue();
    }

    public final void c(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, id5);
        } else {
            f().cancel(id5);
        }
    }

    @NotNull
    public final NotificationCompat.Builder g(@NotNull String channelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NotificationCompat.Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId);
        }
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (Build.VERSION.SDK_INT >= 26) {
            return new NotificationCompat.Builder(this.context.getApplicationContext(), channelId);
        }
        return new NotificationCompat.Builder(this.context.getApplicationContext());
    }

    public final void h(int id5, @Nullable Notification notification) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, id5, (Object) notification);
            return;
        }
        try {
            f().notify(id5, notification);
        } catch (RuntimeException e16) {
            com.tencent.qqnt.notification.util.a.f359909a.c("Notification.Handler", new Function0<String>(e16) { // from class: com.tencent.qqnt.notification.logic.NotificationHandler$notify$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RuntimeException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "notify occur exception, " + this.$e;
                }
            });
        }
    }
}
