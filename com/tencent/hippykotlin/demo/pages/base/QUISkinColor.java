package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUISkinColor extends NightRes {
    public static final QUISkinColor INSTANCE = new QUISkinColor();
    public static final h blueLabelText = new h(4278229503L);
    public static final h blueLabelBackground = new h(419469823);
    public static final h blueLabelBackgroundNight = new h(1073781247);
    public static final h picMark = new h(2566914048L);

    public final h bgNavAIO() {
        return wrapColor("bg_nav_aio");
    }

    public final h blueLabelBackground() {
        if (isNightMode()) {
            return blueLabelBackgroundNight;
        }
        return blueLabelBackground;
    }

    public final h textNavSecondary() {
        return wrapColor("text_nav_secondary");
    }

    public final h textPrimary() {
        return wrapColor("text_primary");
    }

    public final h wrapColor(String str) {
        return QUIToken.color$default(str);
    }
}
