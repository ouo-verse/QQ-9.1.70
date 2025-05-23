package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RoomServiceConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String PARAMS_COVER_URL = "cover_url";
    public static final String PARAMS_FLV_URL = "flv_url";
    public static final String PARAMS_GAME_ID = "game_id";
    public static final String PARAMS_GAME_TAG_ID = "game_tag_id";
    public static final String PARAMS_NO_CLEAR_TOP = "noclearTop";
    public static final String PARAMS_PIP = "pip";
    public static final String PARAMS_QQ_LIVE_PRODUCT_TYPE = "qq_live_product_type";
    public static final String PARAMS_ROOM_ID = "roomid";
    public static final String PARAMS_ROOM_TYPE = "room_type";
    public static final String PARAMS_RTMP = "rtmp";
    public static final String PARAMS_SOURCE = "source";
    public static final String PARAMS_USE_FLV = "is_use_flv";
    public static final String PARAMS_VIDEO_SOURCE = "video_source";
    public static final String PARAM_FROM = "from";
    public static final String SCHEME_ILIVE_WATCH = "mqqapi://vaslive/watch?roomid={roomid}";

    public RoomServiceConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
