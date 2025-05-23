package com.tencent.timi.game.tgpa;

import android.content.Context;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f379966b;

    /* renamed from: a, reason: collision with root package name */
    private String f379967a = "";

    b() {
        l.i("TimiTgpaXid", "CyminiTgpaXid");
    }

    public static b a() {
        if (f379966b == null) {
            synchronized (b.class) {
                if (f379966b == null) {
                    f379966b = new b();
                }
            }
        }
        return f379966b;
    }

    public void b(Context context) {
    }
}
