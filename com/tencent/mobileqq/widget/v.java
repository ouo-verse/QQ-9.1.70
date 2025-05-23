package com.tencent.mobileqq.widget;

import android.graphics.Path;
import android.view.View;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class v extends HeartAnimator {
    public v(HeartLayout heartLayout) {
        super(heartLayout);
    }

    @Override // com.tencent.mobileqq.hotchat.anim.HeartAnimator
    public Path b(int i3, int i16, AtomicInteger atomicInteger, View view) {
        int i17;
        int i18;
        Random random = this.f236862a;
        Path path = new Path();
        HeartAnimator.a aVar = this.f236863b;
        int i19 = 1;
        if (!aVar.f236886l) {
            if (i3 >= 0 && i3 <= view.getWidth()) {
                HeartAnimator.a aVar2 = this.f236863b;
                aVar2.f236876b = i3 - ((int) ((aVar2.f236875a * 20.0f) / 3.0f));
            } else {
                this.f236863b.f236876b = (view.getWidth() - ((int) (this.f236863b.f236875a * 20.0f))) / 2;
            }
            if (i16 >= 0 && i16 <= view.getHeight()) {
                this.f236863b.f236877c = (view.getHeight() - i16) + ((int) ((this.f236863b.f236875a * 20.0f) / 3.0f));
            } else {
                HeartAnimator.a aVar3 = this.f236863b;
                aVar3.f236877c = (int) (aVar3.f236875a * 20.0f);
            }
            if (!this.f236862a.nextBoolean()) {
                i19 = -1;
            }
            int nextInt = random.nextInt(this.f236863b.f236878d);
            HeartAnimator.a aVar4 = this.f236863b;
            int i26 = (nextInt + aVar4.f236879e) * i19;
            int nextInt2 = (random.nextInt(aVar4.f236878d) + this.f236863b.f236879e) * i19;
            int height = view.getHeight() - this.f236863b.f236877c;
            float intValue = atomicInteger.intValue() * 4;
            HeartAnimator.a aVar5 = this.f236863b;
            int nextInt3 = ((int) (intValue * aVar5.f236875a)) + aVar5.f236882h + random.nextInt(aVar5.f236881g);
            int i27 = nextInt3 / this.f236863b.f236880f;
            int i28 = height - nextInt3;
            if (i28 < 0) {
                i18 = 0;
            } else {
                i18 = i28;
            }
            int i29 = height - (nextInt3 / 2);
            if (i29 < 0) {
                i29 = 0;
            }
            path.moveTo(r0.f236876b, height);
            float f16 = i29;
            path.cubicTo(this.f236863b.f236876b, height - i27, r0 + i26, i29 + i27, r0 + i26, f16);
            path.moveTo(this.f236863b.f236876b + i26, f16);
            int i36 = i29 - i27;
            if (i36 >= 0) {
                int i37 = this.f236863b.f236876b;
                path.cubicTo(i26 + i37, i36, i37 + nextInt2, i27 + i18, i37 + nextInt2, i18);
            }
        } else {
            int i38 = aVar.f236888n;
            int i39 = aVar.f236887m - (aVar.f236883i / 2);
            if (!this.f236862a.nextBoolean()) {
                i19 = -1;
            }
            int nextInt4 = random.nextInt(this.f236863b.f236878d);
            HeartAnimator.a aVar6 = this.f236863b;
            int i46 = nextInt4 + aVar6.f236879e;
            int nextInt5 = random.nextInt(aVar6.f236878d) + this.f236863b.f236879e;
            int abs = Math.abs(i38 - i16) / (this.f236862a.nextInt(3) + 2);
            if (i38 > i16) {
                i17 = i38 - abs;
            } else {
                i17 = abs + i38;
            }
            HeartAnimator.a aVar7 = this.f236863b;
            path.moveTo(i3 - (aVar7.f236883i / 2), i16 - (aVar7.f236884j / 2));
            float f17 = i17;
            path.cubicTo((i46 * i19) + i3, f17, i3 - (i19 * nextInt5), f17, i39, i38);
        }
        return path;
    }
}
