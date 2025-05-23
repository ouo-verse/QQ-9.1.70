package com.tencent.qqnt.notification.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J4\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\f\u0010\u000b\u001a\u00020\u0005*\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u0011\u001a\u00020\u00052\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006J,\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/notification/util/i;", "", "Landroid/content/Context;", "context", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", Constants.Configs.CONFIGS, "", "d", "", "p", "", "interruptionFilter", "g", DomainData.DOMAIN_NAME, DownloadInfo.spKey_Config, "o", "e", "a", "Landroid/app/NotificationChannel;", WadlProxyConsts.CHANNEL, "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "c", "l", "i", tl.h.F, "f", "j", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f359912a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f359912a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(Context context, HashMap<String, String> configs) {
        boolean areNotificationsPaused;
        boolean areBubblesEnabled;
        int importance;
        int bubblePreference;
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 31) {
                bubblePreference = notificationManager.getBubblePreference();
                configs.put("bubblePreference", String.valueOf(bubblePreference));
            }
            if (i3 >= 24) {
                importance = notificationManager.getImportance();
                configs.put("importance", String.valueOf(importance));
            }
            if (i3 >= 31) {
                areBubblesEnabled = notificationManager.areBubblesEnabled();
                configs.put("areBubblesEnabled", p(areBubblesEnabled));
            }
            if (i3 >= 29) {
                areNotificationsPaused = notificationManager.areNotificationsPaused();
                configs.put("areNotificationsPaused", p(areNotificationsPaused));
            }
        } catch (Exception e16) {
            QLog.w("NotificationSettingUtil", 1, "[getNotificationConfig], exc=" + e16);
        }
    }

    private final String g(int interruptionFilter) {
        if (interruptionFilter != 0) {
            if (interruptionFilter != 1) {
                if (interruptionFilter != 2) {
                    if (interruptionFilter != 3) {
                        if (interruptionFilter != 4) {
                            return "undefined(" + interruptionFilter + ")";
                        }
                        return "alarms";
                    }
                    return "none";
                }
                return "priority";
            }
            return "all";
        }
        return "unknown";
    }

    private final boolean n(Context context) {
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isPowerSaveMode();
    }

    private final String p(boolean z16) {
        if (z16) {
            return "1";
        }
        return "0";
    }

    @NotNull
    public final String a(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            StringBuffer stringBuffer = new StringBuffer();
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            Intrinsics.checkNotNullExpressionValue(from, "from(context)");
            List<NotificationChannel> notificationChannels = from.getNotificationChannels();
            Intrinsics.checkNotNullExpressionValue(notificationChannels, "notificationManager.notificationChannels");
            for (NotificationChannel channel : notificationChannels) {
                i iVar = f359912a;
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                stringBuffer.append("{" + iVar.b(channel) + "}\n");
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "{\n            val sb = S\u2026  sb.toString()\n        }");
            return stringBuffer2;
        } catch (Throwable th5) {
            return "(" + th5 + ")";
        }
    }

    @NotNull
    public final String b(@NotNull NotificationChannel channel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean canShowBadge;
        boolean canBypassDnd;
        boolean isImportantConversation;
        boolean isConversation;
        Uri sound;
        int lockscreenVisibility;
        String group;
        int importance;
        boolean canBubble;
        String description;
        String id5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) channel);
        }
        Intrinsics.checkNotNullParameter(channel, "channel");
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            id5 = channel.getId();
            str = "id:" + id5 + ",";
        } else {
            str = "id:n/a,";
        }
        stringBuffer.append(str);
        if (i3 >= 26) {
            description = channel.getDescription();
            str2 = "description:" + description + ",";
        } else {
            str2 = "description:n/a,";
        }
        stringBuffer.append(str2);
        if (i3 >= 29) {
            canBubble = channel.canBubble();
            str3 = "canBubble:" + canBubble + ",";
        } else {
            str3 = "canBubble:n/a,";
        }
        stringBuffer.append(str3);
        if (i3 >= 26) {
            importance = channel.getImportance();
            str4 = "importance:" + importance + ",";
        } else {
            str4 = "importance:n/a,";
        }
        stringBuffer.append(str4);
        if (i3 >= 26) {
            group = channel.getGroup();
            str5 = "group:" + group + ",";
        } else {
            str5 = "group:n/a,";
        }
        stringBuffer.append(str5);
        if (i3 >= 26) {
            lockscreenVisibility = channel.getLockscreenVisibility();
            str6 = "lockscreenVisibility:" + lockscreenVisibility + ",";
        } else {
            str6 = "lockscreenVisibility:n/a,";
        }
        stringBuffer.append(str6);
        if (i3 >= 26) {
            sound = channel.getSound();
            str7 = "sound:" + sound + ",";
        } else {
            str7 = "sound:n/a,";
        }
        stringBuffer.append(str7);
        if (i3 >= 31) {
            isConversation = channel.isConversation();
            str8 = "isConversation:" + isConversation + ",";
        } else {
            str8 = "isConversation:n/a,";
        }
        stringBuffer.append(str8);
        if (i3 >= 30) {
            isImportantConversation = channel.isImportantConversation();
            str9 = "isImportantConversation:" + isImportantConversation + ",";
        } else {
            str9 = "isImportantConversation:n/a,";
        }
        stringBuffer.append(str9);
        if (i3 >= 26) {
            canBypassDnd = channel.canBypassDnd();
            str10 = "canBypassDnd:" + canBypassDnd + ",";
        } else {
            str10 = "canBypassDnd:n/a,";
        }
        stringBuffer.append(str10);
        if (i3 >= 26) {
            canShowBadge = channel.canShowBadge();
            str11 = "canShowBadge:" + canShowBadge;
        } else {
            str11 = "canShowBadge:n/a";
        }
        stringBuffer.append(str11);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer().apply {\n \u2026   )\n        }.toString()");
        return stringBuffer2;
    }

    @RequiresApi(23)
    public final int c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return ((NotificationManager) systemService).getCurrentInterruptionFilter();
    }

    @RequiresApi(23)
    @NotNull
    public final HashMap<String, String> e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            i iVar = f359912a;
            hashMap.put("isNotificationEnabled", iVar.p(iVar.m(context)));
            hashMap.put("isDoNotDisturbOn", iVar.p(iVar.k(context)));
            hashMap.put(com.tencent.mobileqq.msf.core.c0.j.L0, iVar.p(iVar.n(context)));
            hashMap.put("interruptionFilter", iVar.g(iVar.c(context)));
            hashMap.put("isIgnoringBatteryOptimizations", iVar.p(iVar.l(context)));
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                hashMap.put("isDataSaverOn", iVar.p(iVar.i(context)));
            }
            if (i3 >= 30) {
                hashMap.put("isBackgroundRestricted", iVar.p(iVar.h(context)));
            }
            hashMap.put("hasNotificationPolicyAccess", iVar.p(iVar.f(context)));
            hashMap.put("isDeviceInDozeMode", iVar.p(iVar.j(context)));
            iVar.d(context, hashMap);
            return hashMap;
        } catch (Throwable th5) {
            QLog.w("NotificationSettingUtil", 1, "[getSystemConfig] exc=" + th5);
            return new HashMap<>();
        }
    }

    @RequiresApi(23)
    public final boolean f(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return ((NotificationManager) systemService).isNotificationPolicyAccessGranted();
    }

    @RequiresApi(30)
    public final boolean h(@NotNull Context context) {
        int appStandbyBucket;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        Object systemService = context.getSystemService("usagestats");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.usage.UsageStatsManager");
        appStandbyBucket = ((UsageStatsManager) systemService).getAppStandbyBucket();
        if (appStandbyBucket != 45) {
            return false;
        }
        return true;
    }

    @RequiresApi(24)
    public final boolean i(@NotNull Context context) {
        int restrictBackgroundStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            restrictBackgroundStatus = ((ConnectivityManager) systemService).getRestrictBackgroundStatus();
            if (restrictBackgroundStatus != 3) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            Log.i("NotificationSettingUtil", "[isDataSaverOn] exc=" + e16);
            return false;
        }
    }

    @RequiresApi(23)
    public final boolean j(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isDeviceIdleMode();
    }

    @RequiresApi(23)
    public final boolean k(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        if (((NotificationManager) systemService).getCurrentInterruptionFilter() != 1) {
            return true;
        }
        return false;
    }

    @RequiresApi(23)
    public final boolean l(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public final boolean m(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        return from.areNotificationsEnabled();
    }

    @NotNull
    public final String o(@NotNull HashMap<String, String> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : config.entrySet()) {
            stringBuffer.append(((Object) entry.getKey()) + ":" + ((Object) entry.getValue()) + ";");
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer().apply {\n \u2026   }\n        }.toString()");
        return stringBuffer2;
    }
}
