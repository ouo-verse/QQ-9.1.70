package com.tencent.mobileqq.profilecard.constant;

import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes35.dex */
public class QCircleProfileConstant {
    public static final int STATE_CLOSE = -1;
    public static final int STATE_FULL_SCREEN = 15;
    public static final int STATE_NONE = 0;
    public static final int ZONE_FULL_SCREEN = 14;
    public static final int ZONE_NORMAL = 13;
    public static final int ZONE_RELEASE_TO_NORMAL = 12;
    public static final int ZONE_RELEASE_TO_TOP_DOWN = 11;
    public static final int ZONE_RELEASE_TO_TOP_UP = 10;
    public static final int CEILING_HEIGHT = (ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) + ImmersiveUtils.dpToPx(50.0f)) + ImmersiveUtils.dpToPx(10.0f);
    public static final int ATTACH_TOP_HEIGHT_UP = ViewUtils.dip2px(255.0f);
    public static final int ATTACH_TOP_HEIGHT_DOWN = Math.round(ScreenUtil.getRealHeight(BaseApplication.getContext()) * 0.18f);
    public static final int INIT_HEIGHT = ViewUtils.dip2px(350.0f);
    public static final int FULL_SCREEN_HEIGHT = Math.round(ScreenUtil.getRealHeight(BaseApplication.getContext()) * 0.48f);
}
