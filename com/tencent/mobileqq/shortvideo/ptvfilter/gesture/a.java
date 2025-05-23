package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f288213a = {"Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X"};

    public static boolean a() {
        boolean b16 = com.tencent.mobileqq.shortvideo.gesture.a.c().b();
        if (!b16) {
            com.tencent.mobileqq.shortvideo.gesture.a.c().f();
        }
        QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils check gestureResource ready " + b16);
        return b16;
    }
}
