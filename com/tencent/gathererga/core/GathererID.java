package com.tencent.gathererga.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GathererID {
    static IPatchRedirector $redirector_ = null;
    public static final int AIDTICKET = 1;
    public static final int ANDROID_ID = 115;
    public static final int APPID = 503;
    public static final int APP_VERSION = 502;
    public static final int BOARD = 131;
    public static final int BOOT_ID = 130;
    public static final int BOOT_TIME = 407;
    public static final int BRAND = 118;
    public static final int BSSID = 307;
    public static final int BUILD_ID = 410;
    public static final int CARRIER = 305;
    public static final int COUNTRY = 303;
    public static final int CURRENT_VOLUME = 319;
    public static final int DEVICE = 123;
    public static final int DEVICE_ID = 110;
    public static final int DEVICE_ID0 = 111;
    public static final int DEVICE_ID1 = 112;
    public static final int DPI = 122;
    public static final int HARMONY_OS_VERSION = 124;
    public static final int HARMONY_PURE_MODE = 125;
    public static final int HEIGHT_AND_WIDTH = 119;
    public static final int IMEI = 101;
    public static final int IMEI0 = 102;
    public static final int IMEI1 = 103;
    public static final int IMSI = 104;
    public static final int IMSI0 = 105;
    public static final int IMSI1 = 106;
    public static final int INSTALLED_PACKAGES = 601;
    public static final int IP = 315;
    public static final int IS_HARMONY_OS = 126;
    public static final int IS_ROOT = 316;
    public static final int JAVA_VM_VERSION = 413;
    public static final int KERNEL_VERSION = 405;
    public static final int LANGUAGE = 304;
    public static final int LATITUDE = 309;
    public static final int LINUX_FILE_NODE = 129;
    public static final int LOCAL_COUNTRY = 323;
    public static final int LONGITUDE = 310;
    public static final int MANUFACTURER = 116;
    public static final int MANUFACTURER_OS_VERSION = 414;
    public static final int MAX_VOLUME = 320;
    public static final int MEID = 107;
    public static final int MEID0 = 108;
    public static final int MEID1 = 109;
    public static final int MIN_VOLUME = 321;
    public static final int MOBILE_NETWORK_TYPE = 313;
    public static final int MODEL = 117;
    public static final int NETWORK_TYPE = 312;
    public static final int OPEN_HARMONY_VERSION = 127;
    public static final int OS_VERSION = 403;
    public static final int PACKAGE_NAME = 501;
    public static final int PROC_VERSION = 404;
    public static final int QIMEI36 = 701;
    public static final int RAM_SIZE = 121;
    public static final int ROM_SIZE = 120;
    public static final int SCREEN_ORIENTATION = 317;
    public static final int SCREEN_WIDTH_BUCKET = 128;
    public static final int SDCARD_FREE_SPACE = 406;
    public static final int SYSTEM_CHROME_VERSION = 408;
    public static final int SYSTEM_UA = 308;
    public static final int TAIDTICKET = 2;
    public static final int TIME = 132;
    public static final int TIME_ZONE = 306;
    public static final int TIME_ZONE_ID = 322;
    public static final int UUID = 402;
    public static final int VERSION_CODENAME = 409;
    public static final int VERSION_INCREMENTAL = 412;
    public static final int VERSION_RELEASE_OR_CODENAME = 411;
    public static final int WEBVIEW_UA = 318;

    public GathererID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
