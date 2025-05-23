package com.qq.e.comm.plugin.tangramsplash.selector;

import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.model.r;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {
    public static boolean a(r rVar) {
        if (rVar == null) {
            return false;
        }
        String h16 = rVar.h();
        if (!TextUtils.isEmpty(h16) && h16.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
            return false;
        }
        if (rVar.bJ() == null) {
            return true;
        }
        String bP = rVar.bP();
        if (!TextUtils.equals(bP, "ShakeInteractive") && !TextUtils.equals(bP, "ShakePlusInteractive") && !TextUtils.equals(bP, "SlideInteractive") && !TextUtils.equals(bP, "SlideFlipInteractive") && !TextUtils.equals(bP, "SlideVerticalCarouselCard") && !TextUtils.equals(bP, "TwistVerticalCarouselCard") && !TextUtils.equals(bP, "IconFlipInteractive") && !TextUtils.equals(bP, "LeanForwardInteractive") && !TextUtils.equals(bP, "AuraIconFlipInteractive") && !TextUtils.equals(bP, "AuraIconTwistInteractive")) {
            return false;
        }
        if (rVar.bJ().f() == null || !rVar.bJ().f().a()) {
            return true;
        }
        return TextUtils.equals(bP, "SlideFlipInteractive");
    }
}
