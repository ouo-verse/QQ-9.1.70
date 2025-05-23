package com.tencent.mobileqq.guild.media.core.data;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f228060a = false;

    public static String a(int i3, int i16, String str, String str2) {
        if (i3 == 2) {
            if (i16 == 46001) {
                return "\u8be5\u5b50\u9891\u9053\u5df2\u6ee1\u5458\uff0c\u53bb\u522b\u7684\u5b50\u9891\u9053\u901b\u901b\u5427\u3002";
            }
            if ((i16 == 46100 || i16 == 46200 || i16 == 23002) && !TextUtils.isEmpty(str)) {
                GuildChannelSwitchManager.h(str2, null, "enterVoiceChannelFailed");
                return str;
            }
            return "\u52a0\u5165\u97f3\u89c6\u9891\u5b50\u9891\u9053\u5931\u8d25";
        }
        if (i3 == 3) {
            if (i16 != -3301) {
                if (i16 == -1) {
                    return str;
                }
            } else {
                return "\u6570\u636e\u5f02\u5e38\uff0c\u81ea\u52a8\u9000\u51fa\u97f3\u89c6\u9891\u5b50\u9891\u9053\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
            }
        }
        return "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u52a0\u5165\u97f3\u89c6\u9891\u5b50\u9891\u9053";
    }

    public static String b() {
        String i06 = bw.f235485a.i0(bw.b2("normal_exit_room"), "");
        if (i06.startsWith("entered")) {
            return i06.substring(7);
        }
        return null;
    }

    public static void c(String str, int i3, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("audio_exit_reason", str);
        hashMap.put("audio_err_code", Integer.valueOf(i3));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent("ev_audio_channel_exit", hashMap);
        if (e()) {
            com.tencent.mobileqq.guild.performance.report.e.f(str, i3, str2);
        }
    }

    public static void d() {
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.AudioRoomError", 2, "handleUnexpectedExitReport start");
        }
        if (e() && !f228060a) {
            String b16 = b();
            if (b16 == null) {
                b16 = String.valueOf(2);
            }
            QLog.d("QGMC.AudioRoomError", 1, "handleUnexpectedExitReport: ", "program_err", b16);
            c("program_err", -1, b16);
            g();
        }
    }

    public static boolean e() {
        String i06 = bw.f235485a.i0(bw.b2("normal_exit_room"), "");
        if (i06 != null && i06.startsWith("entered")) {
            return true;
        }
        return false;
    }

    public static void f(String str) {
        bw.f235485a.D0(bw.b2("normal_exit_room"), "entered" + str);
        f228060a = true;
    }

    public static void g() {
        bw.f235485a.D0(bw.b2("normal_exit_room"), "exited");
        f228060a = false;
    }
}
