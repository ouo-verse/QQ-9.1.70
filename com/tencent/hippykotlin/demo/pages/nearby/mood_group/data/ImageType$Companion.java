package com.tencent.hippykotlin.demo.pages.nearby.mood_group.data;

import com.tencent.qq.effect.engine.QEffectType;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ImageType$Companion {
    public final int parseFromString$enumunboxing$(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1096937569) {
            if (hashCode != 110742) {
                if (hashCode == 3000872 && str.equals("apng")) {
                    return 2;
                }
            } else if (str.equals("pag")) {
                return 4;
            }
        } else if (str.equals(QEffectType.LOTTIE_TAG)) {
            return 3;
        }
        return 1;
    }
}
