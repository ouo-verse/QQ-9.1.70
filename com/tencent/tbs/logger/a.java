package com.tencent.tbs.logger;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private int f374480a;

    public a() {
        this(2048);
    }

    static int b(String str, int i3, int i16) {
        if (i16 == str.length()) {
            return i16;
        }
        if (str.charAt(i16) == '\n') {
            return i16;
        }
        for (int i17 = i16 - 1; i3 < i17; i17--) {
            if (str.charAt(i17) == '\n') {
                return i17 + 1;
            }
        }
        return i16;
    }

    @Override // com.tencent.tbs.logger.d
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (cVar.f374485d.length() <= this.f374480a) {
            Log.println(cVar.f374483b.getValue(), cVar.f374484c, cVar.f374485d);
            return;
        }
        int length = cVar.f374485d.length();
        int i3 = 0;
        while (i3 < length) {
            int b16 = b(cVar.f374485d, i3, Math.min(this.f374480a + i3, length));
            Log.println(cVar.f374483b.getValue(), cVar.f374484c, cVar.f374485d.substring(i3, b16));
            i3 = b16;
        }
    }

    public a(int i3) {
        this.f374480a = i3;
    }
}
