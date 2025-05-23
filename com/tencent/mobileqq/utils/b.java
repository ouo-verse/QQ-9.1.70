package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f307467b = new b();

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, HashSet<Long>> f307468a;

    b() {
    }

    public static b a() {
        return f307467b;
    }

    public boolean b(MessageRecord messageRecord, String str) {
        boolean z16;
        HashSet<Long> hashSet;
        HashMap<String, HashSet<Long>> hashMap = this.f307468a;
        if (hashMap != null && (hashSet = hashMap.get(str)) != null) {
            z16 = hashSet.contains(Long.valueOf(messageRecord.uniseq));
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOSingleReporter", 2, "hasReported(): mr.uniseq=" + messageRecord.uniseq + " result = " + z16);
        }
        return z16;
    }

    public void c(MessageRecord messageRecord, String str) {
        if (messageRecord == null) {
            return;
        }
        if (this.f307468a == null) {
            this.f307468a = new HashMap<>();
        }
        HashSet<Long> hashSet = this.f307468a.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f307468a.put(str, hashSet);
        }
        hashSet.add(Long.valueOf(messageRecord.uniseq));
    }
}
