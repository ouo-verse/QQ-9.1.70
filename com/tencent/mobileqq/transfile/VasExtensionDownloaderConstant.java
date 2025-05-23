package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VasExtensionDownloaderConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String BUSINESS_CAMERA_EMO_PANEL_DYNAMIC = "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC";
    public static final String BUSINESS_CAMERA_EMO_PANEL_THUMB = "BUSINESS_CAMERA_EMO_PANEL_THUMB";
    public static final String BUSINESS_COMMERCIAL_DRAINAGE = "COMMERCIAL_DRAINAGE";
    public static final String BUSINESS_EMOTICON_DIY = "EMOTICON_DIY";
    public static final String BUSINESS_EMOTICON_TAB = "EMOTICON_TAB";
    public static final String BUSINESS_FAVORITE_PANEL_DYNAMIC = "FAVOROTE_PANEL_DYNAMIC";
    public static final String BUSINESS_FAVORITE_PANEL_THUMB = "FAVORITE_PANEL_THUMB";
    public static final String BUSINESS_FAVORITE_PANEL_THUMB_NEW = "FAVORITE_PANEL_THUMB_NEW";
    public static final String BUSINESS_FONT_BUBBLE = "FONT_BUBBLE";
    public static final String BUSINESS_REDPACKET_SEND_PIC = "REDPACKET_SEND_PIC";
    public static final String BUSINESS_RESOURCE_IMG = "RESOURCE_IMG";
    public static final String COMIC_IPSITE_GAME_IMAGE = "COMIC_IPSITE_GAME_IMAGE";
    public static final String COMIC_IP_SITE_ROUND_IMAGE = "COMIC_IP_SITE_ROUND_IMAGE";
    public static final String IP_SITE_IMAGE = "IP_SITE_IMAGE";
    public static final String PROTOCOL_VAS_EXTENSION = "protocol_vas_extension_image";

    public VasExtensionDownloaderConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
