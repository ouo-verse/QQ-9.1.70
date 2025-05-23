package com.tencent.mobileqq.guild.mainframe.util;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, Long> f227726a = new ConcurrentHashMap<>(new HashMap(8));

    public static void a(String str) {
        b(str, "");
    }

    public static void b(String str, String str2) {
        QLog.isDebugVersion();
    }

    public static void c(String str) {
        QLog.isDebugVersion();
    }

    public static void d(String str, String str2) {
        QLog.isDebugVersion();
    }
}
