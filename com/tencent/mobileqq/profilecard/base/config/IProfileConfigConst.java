package com.tencent.mobileqq.profilecard.base.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* loaded from: classes16.dex */
public interface IProfileConfigConst {
    public static final IPatchRedirector $redirector_ = null;
    public static final int SWITCH_ANONYMOUS_ANSWER = 13;
    public static final int SWITCH_APOLLO = 1;
    public static final int SWITCH_BASE_INFO_AB_TEST = 12;
    public static final int SWITCH_COUNT = 21;
    public static final int[] SWITCH_DEFAULT_VALUES;
    public static final int SWITCH_DRESSUP = 16;
    public static final int SWITCH_GAME_INFO = 14;
    public static final int SWITCH_IN_STEP = 15;
    public static final int SWITCH_LIFE_ACHIEVEMENT = 10;
    public static final int SWITCH_META_FARM = 20;
    public static final int SWITCH_MINIAPP = 7;
    public static final int SWITCH_MUSIC = 4;
    public static final int SWITCH_MUSIC_DATA = 19;
    public static final int SWITCH_NOW = 0;
    public static final int SWITCH_PHOTO = 2;
    public static final int SWITCH_PRESENT = 6;
    public static final int SWITCH_QQCARD = 17;
    public static final int SWITCH_QQ_CIRCLE = 9;
    public static final int SWITCH_Q_CUB = 18;
    public static final int SWITCH_STICKY_NOTE = 8;
    public static final int SWITCH_TAG = 3;
    public static final int SWITCH_TRIBE = 5;
    public static final int SWITCH_WEISHI = 11;
    public static final int SWITCH_WZ_GAME_CARD = 14;
    public static final int SWITCH_WZ_SKIN_CARD = 15;
    public static final int SWITCH_YUAN_MENG_CARD = 16;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33473), (Class<?>) IProfileConfigConst.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            SWITCH_DEFAULT_VALUES = new int[]{0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0};
        }
    }
}
