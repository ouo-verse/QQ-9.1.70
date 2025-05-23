package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForRichState;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.hz;
import com.xiaomi.push.id;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.ah;
import common.config.service.QzoneConfig;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class w {
    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j3 = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a16 = ah.d(context).a(gk.SyncInfoFrequency.a(), 1209600);
        if (j3 == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j3) > a16) {
            d(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void c(Context context, he heVar) {
        jz4.c.m("need to update local info with: " + heVar.m391a());
        String str = heVar.m391a().get("accept_time");
        if (str != null) {
            MiPushClient.N(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                MiPushClient.e(context, split[0], split[1]);
                if (QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT.equals(split[0]) && QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT.equals(split[1])) {
                    s.c(context).j(true);
                } else {
                    s.c(context).j(false);
                }
            }
        }
        String str2 = heVar.m391a().get("aliases");
        if (str2 != null) {
            MiPushClient.R(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(",")) {
                    MiPushClient.g(context, str3);
                }
            }
        }
        String str4 = heVar.m391a().get(MessageForRichState.SIGN_MSG_TOPICS);
        if (str4 != null) {
            MiPushClient.S(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(",")) {
                    MiPushClient.j(context, str5);
                }
            }
        }
        String str6 = heVar.m391a().get("user_accounts");
        if (str6 != null) {
            MiPushClient.Q(context);
            if (!"".equals(str6)) {
                for (String str7 : str6.split(",")) {
                    MiPushClient.f(context, str7);
                }
            }
        }
    }

    public static void d(final Context context, final boolean z16) {
        com.xiaomi.push.ae.b(context).g(new Runnable() { // from class: com.xiaomi.mipush.sdk.w.1
            @Override // java.lang.Runnable
            public void run() {
                jz4.c.m("do sync info");
                he heVar = new he(com.xiaomi.push.service.m.a(), false);
                s c16 = s.c(context);
                heVar.c(gp.SyncInfo.f24750a);
                heVar.b(c16.d());
                heVar.d(context.getPackageName());
                HashMap hashMap = new HashMap();
                heVar.f24813a = hashMap;
                Context context2 = context;
                id.c(hashMap, "app_version", com.xiaomi.push.g.h(context2, context2.getPackageName()));
                Map<String, String> map = heVar.f24813a;
                Context context3 = context;
                id.c(map, "app_version_code", Integer.toString(com.xiaomi.push.g.b(context3, context3.getPackageName())));
                id.c(heVar.f24813a, "push_sdk_vn", "5_9_9-C");
                id.c(heVar.f24813a, "push_sdk_vc", Integer.toString(50909));
                id.c(heVar.f24813a, "token", c16.m());
                if (!hz.t()) {
                    String b16 = com.xiaomi.push.ag.b(ge.t(context));
                    String x16 = ge.x(context);
                    if (!TextUtils.isEmpty(x16)) {
                        b16 = b16 + "," + x16;
                    }
                    if (!TextUtils.isEmpty(b16)) {
                        id.c(heVar.f24813a, "imei_md5", b16);
                    }
                }
                com.xiaomi.push.q.a(context).d(heVar.f24813a);
                id.c(heVar.f24813a, "reg_id", c16.q());
                id.c(heVar.f24813a, "reg_secret", c16.t());
                id.c(heVar.f24813a, "accept_time", MiPushClient.v(context).replace(",", "-"));
                if (z16) {
                    id.c(heVar.f24813a, "aliases_md5", w.f(MiPushClient.w(context)));
                    id.c(heVar.f24813a, "topics_md5", w.f(MiPushClient.x(context)));
                    id.c(heVar.f24813a, "accounts_md5", w.f(MiPushClient.y(context)));
                } else {
                    id.c(heVar.f24813a, "aliases", w.g(MiPushClient.w(context)));
                    id.c(heVar.f24813a, MessageForRichState.SIGN_MSG_TOPICS, w.g(MiPushClient.x(context)));
                    id.c(heVar.f24813a, "user_accounts", w.g(MiPushClient.y(context)));
                }
                ag.h(context).y(heVar, gf.Notification, false, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(List<String> list) {
        String b16 = com.xiaomi.push.ag.b(g(list));
        if (!TextUtils.isEmpty(b16) && b16.length() > 4) {
            return b16.substring(0, 4).toLowerCase();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(List<String> list) {
        String str = "";
        if (iq.a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }
}
