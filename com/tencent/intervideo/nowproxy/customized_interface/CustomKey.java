package com.tencent.intervideo.nowproxy.customized_interface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CustomKey {
    static IPatchRedirector $redirector_ = null;
    public static final String CORE_ACTION_CALLBACK = "core_action_callback";
    public static final String CUSTOM_BEACON_REPORT = "custom_beacon_report";
    public static final String CUSTOM_CGIREQ = "custom_cgireq";
    public static final String CUSTOM_COVER_IMG = "custom_cover_img";
    public static final String CUSTOM_DNS = "custom_dns";
    public static final String CUSTOM_DOWNLOAD = "custom_download";
    public static final String CUSTOM_LOG = "custom_log";
    public static final String CUSTOM_PAY = "custom_pay";
    public static final String CUSTOM_REPORT = "custom_report";
    public static final String CUSTOM_SHARE = "custom_share";
    public static final String CUSTOM_SHARE_MENU_FLAG = "custom_share_menu_flag";
    public static final String CUSTOM_SUSCRIB = "custom_suscrib";
    public static final String CUSTOM_TOAST = "custom_toast";
    public static final String CUSTOM_WEBVIEW = "custom_webview";
    public static final String FREE_FLOW = "free_flow";
    public static final String SHARE_IMAGE_URL = "imageurl";
    public static final String SHARE_SUMMARY = "summary";
    public static final String SHARE_TITLE = "title";
    public static final String SHARE_TYPE = "sharetype";
    public static final String SHARE_URL = "targeturl";
    public static final String WELFARE_TASK_CALLBACK = "welfare_task_callback";

    public CustomKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
