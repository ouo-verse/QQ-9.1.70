package com.qzone.proxy.feedcomponent.text.font;

import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FontManager {
    public static final int FONT_TYPE_FULLTYPE = 1;
    public static final int FONT_TYPE_FULLTYPE_COLOR = 3;
    public static final int FONT_TYPE_FULLTYPE_XUANDONG = 4;
    public static final int FONT_TYPE_TRUETYPE = 2;
    private static Boolean barrageEnable;
    private static Boolean fontEnable;
    private static Boolean isSuperFontEnable;

    public static boolean enableTrueTypeFontViewCache() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_TRUE_TYPE_VIEW_CACHE, 1) != 0;
    }

    public static boolean isBarrageEffectEnable() {
        if (barrageEnable == null) {
            barrageEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_BARRAGE_EFFECT_ENABLED, true));
        }
        return barrageEnable.booleanValue();
    }

    public static boolean isFontEnable() {
        if (fontEnable == null) {
            fontEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FONT_ENABLED, true));
        }
        return fontEnable.booleanValue();
    }

    public static boolean isSuperFontEnable() {
        if (isSuperFontEnable == null) {
            isSuperFontEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_SUPER_FONT_ENABLED, true));
        }
        return isSuperFontEnable.booleanValue();
    }

    public static void notifyCacheBarrageEnableExpired() {
        barrageEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_BARRAGE_EFFECT_ENABLED, true));
    }

    public static void notifyCacheFontEnableExpired() {
        fontEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FONT_ENABLED, true));
    }

    public static void notifyCacheSuperFontEnableExpired() {
        isSuperFontEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_SUPER_FONT_ENABLED, true));
    }

    public static void preInitData() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.font.FontManager.1
            @Override // java.lang.Runnable
            public void run() {
                FontManager.fontEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FONT_ENABLED, true));
                FontManager.isSuperFontEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_SUPER_FONT_ENABLED, true));
                FontManager.barrageEnable = Boolean.valueOf(LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_BARRAGE_EFFECT_ENABLED, true));
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if ((r0 & 4) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        if ((r0 & 2) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        if ((r0 & 1) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if ((r0 & 8) == 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isFontEnable(int i3) {
        boolean z16 = false;
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_CUSTOM_FONT_SHOW, 0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return true;
                    }
                }
            }
        }
        return z16;
    }
}
