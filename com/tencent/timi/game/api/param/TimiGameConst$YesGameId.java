package com.tencent.timi.game.api.param;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiGameConst$YesGameId {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Integer> f376307a;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface YesGameIdEnum {
    }

    static {
        ArrayList arrayList = new ArrayList();
        f376307a = arrayList;
        arrayList.add(101);
        arrayList.add(102);
        arrayList.add(103);
        arrayList.add(104);
        arrayList.add(105);
    }

    public static boolean a(int i3) {
        return f376307a.contains(Integer.valueOf(i3));
    }
}
