package com.tencent.mobileqq.guild.feed.util;

import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes13.dex */
public class w {
    public static Integer a(String str, String str2, Integer num) {
        return Integer.valueOf(QzoneConfig.getInstance().getConfig(str, str2, num.intValue()));
    }

    public static Long b(String str, String str2, Long l3) {
        return Long.valueOf(QzoneConfig.getInstance().getConfig(str, str2, l3.longValue()));
    }

    public static String c(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }
}
