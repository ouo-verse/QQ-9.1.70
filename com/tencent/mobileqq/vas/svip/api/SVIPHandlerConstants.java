package com.tencent.mobileqq.vas.svip.api;

/* loaded from: classes20.dex */
public class SVIPHandlerConstants {
    public static final int HIBOOM_AUTH_TYPE_FORWARD = 1;
    public static final int HIBOOM_AUTH_TYPE_SEND = 2;
    public static final int NOTIFY_TYPE_AUTH_HIBOOM = 102;
    public static final int NOTIFY_TYPE_BUBBLE_CHANGE = 101;
    public static final int NOTIFY_TYPE_DEFAULT_CARD = 106;
    public static final int NOTIFY_TYPE_FRIEND_CLONE = 104;
    public static final int NOTIFY_TYPE_GET_BIG_TROOP_EXPIRED_INFO = 113;
    public static final int NOTIFY_TYPE_GET_BUBBLE_RECOMMEND = 108;
    public static final int NOTIFY_TYPE_GET_COLOR_NICK_DATA = 105;
    public static final int NOTIFY_TYPE_GET_FONT_RECOMMEND = 107;
    public static final int NOTIFY_TYPE_GET_ROAM_TOAST = 111;
    public static final int NOTIFY_TYPE_GET_ROAM_TYPE = 114;
    public static final int NOTIFY_TYPE_NAMEPLATE_SWITCH_CHANGE = 115;
    public static final int NOTIFY_TYPE_PAY_FONT_BUBBLE = 110;
    public static final int NOTIFY_TYPE_SET_FACE = 112;
    public static final int NOTIFY_TYPE_SET_FONT_BUBBLE = 109;
    public static final int NOTIFY_TYPE_SET_HIBOOM = 103;
    public static final int NOTIFY_TYPE_VIP_CHANGE = 100;
    public static final int NOTIFY_TYPE_YELLOW_VIP_CHANGE = 116;
    public static final int VIP_TYPE_NONE = 0;
    public static final int VIP_TYPE_QQVIP = 1;
    public static final int VIP_TYPE_SUPERQQ = 2;
    public static final int VIP_TYPE_SUPERVIP = 3;

    public static long mixedBubbleAndTextId(int i3, int i16) {
        return i3 | (i16 << 32);
    }

    public static int resolveBubbleId(long j3) {
        return (int) (j3 & (-1));
    }

    public static int resolveDiyBubbleTextId(long j3) {
        return (int) (j3 >> 32);
    }
}
