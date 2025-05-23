package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private static int f230580d = 0 + 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f230581e = 0;

    private void b(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != f230581e) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1) {
                str = (String) objArr[0];
                a(z16, str);
            }
        }
        str = "";
        a(z16, str);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        b(i3, z16, obj);
    }

    protected void a(boolean z16, String str) {
    }
}
