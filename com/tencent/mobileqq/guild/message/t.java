package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class t implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private static int f230814d = 0 + 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f230815e = 0;

    private void b(int i3, boolean z16, Object obj) {
        if (i3 != f230815e) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        int i16 = 0;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                hashMap = (HashMap) objArr[0];
                i16 = ((Integer) objArr[1]).intValue();
            }
        }
        a(z16, hashMap, i16);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        b(i3, z16, obj);
    }

    protected void a(boolean z16, HashMap<String, Object> hashMap, int i3) {
    }
}
