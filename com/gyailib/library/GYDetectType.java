package com.gyailib.library;

import com.tencent.mobileqq.zootopia.ue.PayPluginScene;
import com.tencent.ttpic.openapi.filter.LightConstants;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYDetectType {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum GenderType {
        FEMALE(LightConstants.FEMALE),
        MALE(LightConstants.MALE);

        private final String value;

        GenderType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum GestureType {
        HEART("HEART"),
        PAPER("PAPER"),
        SCISSOR("SCISSOR"),
        FIST("FIST"),
        ONE("ONE"),
        LOVE("LOVE"),
        LIKE("LIKE"),
        OK("OK"),
        ROCK("ROCK"),
        SIX("SIX"),
        EIGHT("EIGHT"),
        LIFT("LIFT"),
        OTHERS(PayPluginScene.OTHERS),
        THREE("THREE"),
        FOUR("FOUR"),
        UNKNOWN("UNKNOWN");

        private final String value;

        GestureType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }
}
