package com.qzone.component;

import android.graphics.Point;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.component.c;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Random f46702a = new Random();

    public static StickerBubbleAnimationView.a a(Point point, String str, int i3) {
        int i16;
        int nextInt;
        boolean z16 = i3 % 30 == 0;
        Random random = f46702a;
        if (z16) {
            i16 = (-random.nextInt(1500)) + 750;
        } else {
            i16 = (-random.nextInt(6000)) + 3000;
        }
        double d16 = i16;
        Random random2 = f46702a;
        if (z16) {
            nextInt = (-1000) - random2.nextInt(500);
        } else {
            nextInt = (-2000) - random2.nextInt(1000);
        }
        return new StickerBubbleAnimationView.a(point, str, z16, new c.b(d16, nextInt), new c.a(0.0d, 200.0d), 81);
    }
}
