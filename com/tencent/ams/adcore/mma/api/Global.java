package com.tencent.ams.adcore.mma.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Global {
    static IPatchRedirector $redirector_ = null;
    public static final int FAILED_MESSAGE_DEFAULT_PEROID = 3600000;
    public static final int LOCATIOON_UPDATE_INTERVAL = 3600000;
    public static final int NORMAL_MESSAGE_DEFAULT_PEROID = 3600000;
    public static int OFFLINECACHE_LENGTH = 0;
    public static int OFFLINECACHE_QUEUEEXPIRATIONSECS = 0;
    public static int OFFLINECACHE_TIMEOUT = 0;
    public static final String TRACKING_ANDROIDID = "ANDROIDID";
    public static final String TRACKING_IMEI = "IMEI";
    public static final String TRACKING_KEY = "AKEY";
    public static final String TRACKING_LOCATION = "LBS";
    public static final String TRACKING_MAC = "MAC";
    public static final String TRACKING_MUDS = "MUDS";
    public static final String TRACKING_MUID = "MUID";
    public static final String TRACKING_NAME = "ANAME";
    public static final String TRACKING_ODIN = "ODIN";
    public static final String TRACKING_OS = "OS";
    public static final String TRACKING_OS_VERION = "OSVS";
    public static final String TRACKING_SCWH = "SCWH";
    public static final String TRACKING_SDKVS = "SDKVS";
    public static final String TRACKING_SDKVS_VALUE = "1.2";
    public static final String TRACKING_TERM = "TERM";
    public static final String TRACKING_TIMESTAMP = "TS";
    public static final String TRACKING_URL = "URL";
    public static final String TRACKING_WIFI = "WIFI";
    public static String location;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        OFFLINECACHE_LENGTH = 10;
        OFFLINECACHE_QUEUEEXPIRATIONSECS = 20;
        OFFLINECACHE_TIMEOUT = 10;
        location = "";
    }

    public Global() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
