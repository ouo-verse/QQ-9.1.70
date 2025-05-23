package com.tencent.mobileqq.emosm.web;

import java.util.HashMap;

/* loaded from: classes6.dex */
public interface IPCConstants {
    public static final HashMap<String, Integer> M3 = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.emosm.web.IPCConstants.1
        {
            put("queryFontInfo", 2);
            put("setupChatFont", 1);
            put("font_startDownLoad", 3);
            put("font_StopDownLoad", 4);
            put("setupMagicFont", 4001);
            put("setupFontEffect", 4003);
            put("isSupportFounderColorFont", 4002);
            put("queryBubbleInfo", 6);
            put("bubble_startDownLoad", 5);
            put("setFontSwtich", 8);
            put("colorScreen_queryLocal", 16);
            put("colorScreen_setup", 17);
            put("download_FuncDev_webview", 18);
            put("face_setup", 19);
            put("sendEmojiToAIO", 20);
            put("getCollectEmojiStatus", 21);
            put("collectEmoji", 22);
            put("fontBubblePaySuccess", 23);
        }
    };
}
