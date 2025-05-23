package com.qzone.reborn.feedx.util;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Object> f55765a = new HashMap<>();

    public static Object a(String str) {
        Object remove = f55765a.remove(str);
        QLog.d("QZoneFeedXDataTransferUtil", 1, "getAndRemoveData   | key = " + str + " | object = " + remove);
        return remove;
    }

    public static void b(String str, Object obj) {
        QLog.d("QZoneFeedXDataTransferUtil", 1, "saveData  transfer key  | key = " + str + " | data = " + obj);
        f55765a.put(str, obj);
    }
}
