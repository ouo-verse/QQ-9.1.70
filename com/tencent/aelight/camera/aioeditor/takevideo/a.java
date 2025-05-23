package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static List<Integer> f67928a = new ArrayList(Arrays.asList(-14079703, -1, -1027508, -1131223, -6038445, -12147713, -7768577, -496479));

    /* renamed from: b, reason: collision with root package name */
    public static List<Integer> f67929b = Arrays.asList(Integer.valueOf(Color.parseColor("#F95251")), Integer.valueOf(Color.parseColor("#FFC300")), Integer.valueOf(Color.parseColor("#07C060")), Integer.valueOf(Color.parseColor("#0FAFFF")), Integer.valueOf(Color.parseColor("#6468F0")), -1, -16777216);

    public static int a(boolean z16) {
        List<Integer> list;
        int i3;
        if (z16) {
            list = f67928a;
            i3 = 2;
        } else {
            list = f67928a;
            i3 = 1;
        }
        return list.get(i3).intValue();
    }
}
