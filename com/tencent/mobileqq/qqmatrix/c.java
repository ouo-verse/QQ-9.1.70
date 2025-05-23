package com.tencent.mobileqq.qqmatrix;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Object, Boolean> f274132a;

    static {
        HashMap<Object, Boolean> hashMap = new HashMap<>();
        f274132a = hashMap;
        try {
            hashMap.put(new zi2.a(), Boolean.FALSE);
        } catch (Throwable th5) {
            QLog.e("QQThreadMonitorManager", 1, "[Error]:" + th5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar) {
        throw null;
    }
}
