package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.gs;
import com.xiaomi.push.hz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f389708a = Log.isLoggable("NCHelper", 3);

    private static int a(NotificationChannel notificationChannel) {
        int i3 = 0;
        try {
            i3 = ((Integer) com.xiaomi.push.y.n(notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (f389708a) {
                j("isUserLockedChannel:" + i3 + " " + notificationChannel);
            }
        } catch (Exception e16) {
            jz4.c.n("NCHelper", "is user locked error" + e16);
        }
        return i3;
    }

    @TargetApi(26)
    private static NotificationChannel b(String str, NotificationChannel notificationChannel) {
        CharSequence name;
        int importance;
        String description;
        boolean shouldVibrate;
        boolean shouldShowLights;
        Uri sound;
        AudioAttributes audioAttributes;
        int lockscreenVisibility;
        name = notificationChannel.getName();
        importance = notificationChannel.getImportance();
        NotificationChannel notificationChannel2 = new NotificationChannel(str, name, importance);
        description = notificationChannel.getDescription();
        notificationChannel2.setDescription(description);
        shouldVibrate = notificationChannel.shouldVibrate();
        notificationChannel2.enableVibration(shouldVibrate);
        shouldShowLights = notificationChannel.shouldShowLights();
        notificationChannel2.enableLights(shouldShowLights);
        sound = notificationChannel.getSound();
        audioAttributes = notificationChannel.getAudioAttributes();
        notificationChannel2.setSound(sound, audioAttributes);
        lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        notificationChannel2.setLockscreenVisibility(lockscreenVisibility);
        return notificationChannel2;
    }

    private static SharedPreferences c(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String d(j jVar, String str, CharSequence charSequence, String str2, int i3, int i16, String str3, String str4) {
        boolean z16;
        String i17 = jVar.i(str);
        boolean z17 = f389708a;
        if (z17) {
            j("createChannel: appChannelId:" + i17 + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i3 + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i16 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(i17, charSequence, i16);
        notificationChannel.setDescription(str2);
        boolean z18 = false;
        if ((i3 & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        notificationChannel.enableVibration(z16);
        if ((i3 & 4) != 0) {
            z18 = true;
        }
        notificationChannel.enableLights(z18);
        if ((i3 & 1) == 0) {
            notificationChannel.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + jVar.h())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (z17) {
            j("create channel:" + notificationChannel);
        }
        i(jVar, notificationChannel, str4);
        return i17;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    static void e(Context context, j jVar, NotificationChannel notificationChannel, int i3, String str) {
        int i16;
        String id5;
        String id6;
        int lockscreenVisibility;
        int importance;
        boolean shouldShowLights;
        boolean shouldVibrate;
        Uri sound;
        if (i3 > 0) {
            if (com.xiaomi.push.g.a(context) >= 2) {
                i16 = f.c(context.getPackageName(), str);
            } else {
                i16 = 0;
            }
            id5 = notificationChannel.getId();
            NotificationChannel b16 = b(id5, notificationChannel);
            if ((i3 & 32) != 0) {
                sound = notificationChannel.getSound();
                if (sound != null) {
                    b16.setSound(null, null);
                } else {
                    b16.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i3 & 16) != 0) {
                shouldVibrate = notificationChannel.shouldVibrate();
                if (shouldVibrate) {
                    b16.enableVibration(false);
                } else {
                    b16.enableVibration(true);
                }
            }
            if ((i3 & 8) != 0) {
                shouldShowLights = notificationChannel.shouldShowLights();
                if (shouldShowLights) {
                    b16.enableLights(false);
                } else {
                    b16.enableLights(true);
                }
            }
            if ((i3 & 4) != 0) {
                importance = notificationChannel.getImportance();
                int i17 = importance - 1;
                if (i17 <= 0) {
                    i17 = 2;
                }
                b16.setImportance(i17);
            }
            if ((i3 & 2) != 0) {
                lockscreenVisibility = notificationChannel.getLockscreenVisibility();
                b16.setLockscreenVisibility(lockscreenVisibility - 1);
            }
            jVar.o(b16);
            jVar.p(notificationChannel, true);
            String h16 = jVar.h();
            id6 = notificationChannel.getId();
            f.m(h16, id6, i16, 0);
            return;
        }
        jVar.o(notificationChannel);
    }

    public static void f(Context context, String str) {
        if (hz.j(context) && !TextUtils.isEmpty(str)) {
            n(context, str);
            f.g(context, str);
        }
    }

    private static void g(Context context, List<String> list) {
        if (f389708a) {
            j("deleteCopiedChannelRecord:" + list);
        }
        if (!list.isEmpty()) {
            SharedPreferences.Editor edit = c(context).edit();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                edit.remove(it.next());
            }
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(gs gsVar) {
        Map<String, String> map;
        if (gsVar != null && (map = gsVar.f24766a) != null && map.containsKey("REMOVE_CHANNEL_MARK")) {
            gsVar.f389177a = 0;
            gsVar.f24766a.remove("channel_id");
            gsVar.f24766a.remove("channel_importance");
            gsVar.f24766a.remove("channel_name");
            gsVar.f24766a.remove("channel_description");
            gsVar.f24766a.remove("channel_perm");
            jz4.c.m("delete channel info by:" + gsVar.f24766a.get("REMOVE_CHANNEL_MARK"));
            gsVar.f24766a.remove("REMOVE_CHANNEL_MARK");
        }
    }

    @TargetApi(26)
    private static void i(j jVar, NotificationChannel notificationChannel, String str) {
        String id5;
        int i3;
        char c16;
        boolean z16;
        int importance;
        NotificationChannel notificationChannel2;
        int i16;
        boolean z17;
        String id6;
        boolean z18;
        Context d16 = jVar.d();
        id5 = notificationChannel.getId();
        String j3 = j.j(id5, jVar.h());
        boolean z19 = f389708a;
        if (z19) {
            j("appChannelId:" + id5 + " oldChannelId:" + j3);
        }
        if (hz.j(d16) && !TextUtils.equals(id5, j3)) {
            NotificationManager notificationManager = (NotificationManager) d16.getSystemService("notification");
            notificationChannel2 = notificationManager.getNotificationChannel(j3);
            NotificationChannel b16 = jVar.b(id5);
            if (z19) {
                j("xmsfChannel:" + notificationChannel2);
                j("appChannel:" + b16);
            }
            if (notificationChannel2 != null) {
                NotificationChannel b17 = b(id5, notificationChannel2);
                if (z19) {
                    j("copyXmsf copyXmsfChannel:" + b17);
                }
                if (b16 != null) {
                    i16 = a(b16);
                    if (i16 == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    jVar.p(b17, z18);
                    c16 = 3;
                } else {
                    i16 = a(notificationChannel2);
                    id6 = notificationChannel2.getId();
                    e(d16, jVar, b17, i16, id6);
                    c16 = 4;
                }
                m(d16, id5);
                notificationManager.deleteNotificationChannel(j3);
            } else if (b16 != null) {
                if (!l(d16, id5) && k(notificationChannel, b16)) {
                    if (z19) {
                        j("appHack updateNotificationChannel:" + notificationChannel);
                    }
                    i16 = a(b16);
                    if (i16 == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    jVar.p(notificationChannel, z17);
                    c16 = 2;
                } else {
                    i16 = 0;
                    c16 = 0;
                }
            } else {
                if (z19) {
                    j("appHack createNotificationChannel:" + notificationChannel);
                }
                jVar.o(notificationChannel);
                c16 = 1;
                i16 = 0;
            }
            i3 = i16;
        } else {
            NotificationChannel b18 = jVar.b(id5);
            if (z19) {
                j("elseLogic getNotificationChannel:" + b18);
            }
            if (b18 == null) {
                jVar.o(notificationChannel);
            }
            i3 = 0;
            c16 = 0;
        }
        if (c16 != 1 && c16 != 4 && c16 != 3) {
            z16 = false;
        } else {
            z16 = true;
        }
        Context d17 = jVar.d();
        String h16 = jVar.h();
        importance = notificationChannel.getImportance();
        f.h(d17, h16, id5, importance, str, z16, i3);
    }

    private static void j(String str) {
        jz4.c.n("NCHelper", str);
    }

    @TargetApi(26)
    private static boolean k(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        CharSequence name;
        CharSequence name2;
        boolean z16;
        String description;
        String description2;
        int importance;
        int importance2;
        boolean shouldVibrate;
        boolean shouldVibrate2;
        boolean shouldShowLights;
        boolean shouldShowLights2;
        Uri sound;
        boolean z17;
        Uri sound2;
        int importance3;
        int importance4;
        int importance5;
        int importance6;
        boolean z18 = false;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        name = notificationChannel.getName();
        name2 = notificationChannel2.getName();
        boolean equals = TextUtils.equals(name, name2);
        boolean z19 = true;
        if (!equals) {
            if (f389708a) {
                j("appHack channelConfigLowerCompare:getName");
            }
            z16 = true;
        } else {
            z16 = false;
        }
        description = notificationChannel.getDescription();
        description2 = notificationChannel2.getDescription();
        if (!TextUtils.equals(description, description2)) {
            if (f389708a) {
                j("appHack channelConfigLowerCompare:getDescription");
            }
            z16 = true;
        }
        importance = notificationChannel.getImportance();
        importance2 = notificationChannel2.getImportance();
        if (importance != importance2) {
            importance3 = notificationChannel.getImportance();
            importance4 = notificationChannel2.getImportance();
            notificationChannel.setImportance(Math.min(importance3, importance4));
            if (f389708a) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("appHack channelConfigLowerCompare:getImportance  ");
                importance5 = notificationChannel.getImportance();
                sb5.append(importance5);
                sb5.append(" ");
                importance6 = notificationChannel2.getImportance();
                sb5.append(importance6);
                j(sb5.toString());
            }
            z16 = true;
        }
        shouldVibrate = notificationChannel.shouldVibrate();
        shouldVibrate2 = notificationChannel2.shouldVibrate();
        if (shouldVibrate != shouldVibrate2) {
            notificationChannel.enableVibration(false);
            if (f389708a) {
                j("appHack channelConfigLowerCompare:enableVibration");
            }
            z16 = true;
        }
        shouldShowLights = notificationChannel.shouldShowLights();
        shouldShowLights2 = notificationChannel2.shouldShowLights();
        if (shouldShowLights != shouldShowLights2) {
            notificationChannel.enableLights(false);
            if (f389708a) {
                j("appHack channelConfigLowerCompare:enableLights");
            }
            z16 = true;
        }
        sound = notificationChannel.getSound();
        if (sound == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        sound2 = notificationChannel2.getSound();
        if (sound2 != null) {
            z18 = true;
        }
        if (z17 != z18) {
            notificationChannel.setSound(null, null);
            if (f389708a) {
                j("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z19 = z16;
        }
        if (f389708a) {
            j("appHack channelConfigLowerCompare:isDifferent:" + z19);
        }
        return z19;
    }

    private static boolean l(Context context, String str) {
        if (f389708a) {
            j("checkCopeidChannel:newFullChannelId:" + str + "  " + c(context).getBoolean(str, false));
        }
        return c(context).getBoolean(str, false);
    }

    private static void m(Context context, String str) {
        if (f389708a) {
            j("recordCopiedChannel:" + str);
        }
        c(context).edit().putBoolean(str, true).apply();
    }

    private static void n(Context context, String str) {
        try {
            j e16 = j.e(context, str);
            Set<String> keySet = c(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (e16.u(str2)) {
                    arrayList.add(str2);
                    if (f389708a) {
                        j("delete channel copy record:" + str2);
                    }
                }
            }
            g(context, arrayList);
        } catch (Exception unused) {
        }
    }
}
