package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUISkinImage extends NightRes {
    public static final QUISkinImage INSTANCE = new QUISkinImage();

    public final String muteIcon() {
        return wrapImage("voice_mute", "4294967295");
    }

    public final String unmuteIcon() {
        return wrapImage("voice_high", "4294967295");
    }

    public final String viewMoreArrow() {
        return wrapImage("chevron_right", "icon_secondary");
    }

    public final String wrapImage(String str, String str2) {
        String m3 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", str, "?color=", str2);
        if (isNightMode()) {
            StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
            m16.append(SkinColor.colorUniqueID);
            return m16.toString();
        }
        StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
        m17.append(SkinColor.colorUniqueID);
        return m17.toString();
    }
}
