package com.tencent.mobileqq.icgame.sso;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    public static volatile l f237790c = new l();

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f237791a = false;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f237792b = new ConcurrentHashMap<>();

    public void c() {
        Set<Map.Entry<String, Integer>> entrySet = this.f237792b.entrySet();
        QLog.d("ICGameSSORequestRecordHelper", 4, "start---------------------------------------");
        for (Map.Entry<String, Integer> entry : entrySet) {
            QLog.d("ICGameSSORequestRecordHelper", 4, entry.getKey() + " " + entry.getValue());
        }
        QLog.d("ICGameSSORequestRecordHelper", 4, "end---------------------------------------");
    }
}
