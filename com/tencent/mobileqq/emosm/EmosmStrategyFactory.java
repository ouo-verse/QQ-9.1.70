package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class EmosmStrategyFactory {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface EmosmPage {
        public static final int PAGE_CAMERA_ROAMING = 1;
        public static final int PAGE_FAV_ROAMING = 0;
    }

    public static BaseEmosmStrategy a(BaseQQAppInterface baseQQAppInterface, k kVar, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return new FavRoamingStrategy(baseQQAppInterface, kVar);
            }
            return new CameraRoamingStrategy(baseQQAppInterface, kVar);
        }
        return new FavRoamingStrategy(baseQQAppInterface, kVar);
    }
}
