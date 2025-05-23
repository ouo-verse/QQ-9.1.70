package com.tencent.mobileqq.guild.jump.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes13.dex */
public class QQGuildJumpSource {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, Pair<String, String>> f226420a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet<Integer> f226421b = new HashSet<Integer>() { // from class: com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource.1
        {
            add(0);
            add(1000);
            add(1006);
            add(1001);
            add(1003);
            add(1008);
            add(1009);
            add(1010);
            add(1011);
            add(1012);
            add(1020);
            add(1021);
            add(1022);
            add(1023);
            add(1024);
            add(1025);
            add(1036);
            add(Integer.valueOf(AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION));
            add(10003);
            add(10010);
            add(10011);
            add(10004);
            add(10002);
            add(10007);
        }
    };

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes13.dex */
    @interface EntranceId {
    }

    static {
        d();
    }

    public static int a(int i3, long j3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            int i16 = 5;
            if (i3 != 5) {
                i16 = 4;
                if (i3 != 6) {
                    if (i3 == 7) {
                        return 6;
                    }
                    if (i3 != 8) {
                        return 4;
                    }
                    return 9;
                }
                if (j3 == 1000050) {
                    return 7;
                }
            }
            return i16;
        }
        return 3;
    }

    @NonNull
    public static Pair<String, String> b(int i3, String str) {
        int i16 = (i3 & 65535) + 196608;
        Pair<String, String> pair = f226420a.get(Integer.valueOf(i16));
        if (pair == null) {
            QLog.e("Guild.jump.QQGuildJumpSource", 1, str, " globalSetJoinSource error, from:", Integer.valueOf(i16), " code is not found");
            return new Pair<>("share", "others");
        }
        return pair;
    }

    public static Pair<String, String> c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "Guild.jump.QQGuildJumpSource";
        }
        if (!TextUtils.isEmpty(str) && az.b(str) && Integer.parseInt(str) >= 1) {
            return b(246624, str2);
        }
        return b(246615, str2);
    }

    private static void d() {
        HashMap<Integer, Pair<String, String>> hashMap = f226420a;
        hashMap.put(246621, new Pair<>("discover", "recommend_channel"));
        hashMap.put(246619, new Pair<>(UinConfigManager.KEY_ADS, "notice_pgrp"));
        hashMap.put(246615, new Pair<>(VasWebConstants.REPORT_ORIGIN, "sdk"));
        hashMap.put(246624, new Pair<>("channel_connect", "game_vendor"));
        hashMap.put(246620, new Pair<>("background", IProfileProtocolConst.KEY_COLLEGE));
        hashMap.put(246614, new Pair<>("search", "qq_search"));
        hashMap.put(246610, new Pair<>("share", "others"));
        hashMap.put(246611, new Pair<>(QCircleDaTongConstant.ElementParamValue.QRCODE, QCircleDaTongConstant.ElementParamValue.QRCODE));
        hashMap.put(246622, new Pair<>("open_platform", "mini_program"));
        hashMap.put(246623, new Pair<>("qq_group_recommend", "recommend"));
    }
}
