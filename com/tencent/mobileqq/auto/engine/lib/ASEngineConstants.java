package com.tencent.mobileqq.auto.engine.lib;

import com.tencent.biz.qcircleshadow.lib.QCirclePluginConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASEngineConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String AS_KEY_LOCAL_ACTIVITY_BUSINESS = "AS_KEY_BUSINESS";
    public static final String AS_KEY_LOCAL_ACTIVITY_SCHEME = "AS_KEY_LOCAL_ACTIVITY_SCHEME";
    public static final String MAIN_KEY_FLASH_SHOW = "qqflash";
    public static final String SECONDARY_KEY_AUTO_SHADOW_GRAY_ENABLE = "qqflash_auto_shadow_gray_switch";
    public static final int SWITCH_CLOSE = 0;
    public static final int SWITCH_OPEN = 1;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class AppName {
        static IPatchRedirector $redirector_;
        public static Map<String, String> sAPP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40466);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            HashMap hashMap = new HashMap();
            sAPP = hashMap;
            hashMap.put(BusinessKey.BUSINESS_FLASH_SHOW, "com.tencent.mobileqq.flashshow.application.FSApplication");
            sAPP.put(BusinessKey.BUSINESS_QCIRCLE, "com.tencent.qcircle.application.QCircleApplication");
            sAPP.put(BusinessKey.BUSINESS_ECOMMERCE, "com.tencent.ecommerce.base.plugin.ECPluginApplication");
        }

        public AppName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class BusinessKey {
        static IPatchRedirector $redirector_ = null;
        public static final String BUSINESS_ECOMMERCE = "qqecommerce-app";
        public static final String BUSINESS_FLASH_SHOW = "flash-show-app";
        public static final String BUSINESS_QCIRCLE = "qcircle-app";

        public BusinessKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class BusinessKeyToUUID {
        static IPatchRedirector $redirector_;
        public static final Map<String, String> sUUID;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40470);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                sUUID = new HashMap();
            }
        }

        public BusinessKeyToUUID() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class LoadAction {
        static IPatchRedirector $redirector_ = null;
        public static final int PLUGIN_PRELOAD_INSTALL = 1000;
        public static final int PLUGIN_START_ACTIVITY = 1001;
        public static final int PLUGIN_START_SERVICE = 1003;
        public static final int PLUGIN_START_WITH_INSTALL = 1002;
        public static final Map<Integer, Integer> sAction;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40471);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            HashMap hashMap = new HashMap();
            sAction = hashMap;
            hashMap.put(1000, 1000);
            hashMap.put(1001, 1001);
            hashMap.put(1002, 1002);
            hashMap.put(1003, 1003);
        }

        public LoadAction() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class NUM {
        static IPatchRedirector $redirector_;
        public static final int NUM_0 = 0;

        public NUM() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class PPS {
        static IPatchRedirector $redirector_;
        public static final Map<String, String> sPPS;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40476);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            HashMap hashMap = new HashMap();
            sPPS = hashMap;
            hashMap.put(BusinessKey.BUSINESS_QCIRCLE, "com.tencent.biz.qcircleshadow.local.QCirclePluginShadowService");
            hashMap.put(BusinessKey.BUSINESS_FLASH_SHOW, "com.tencent.mobileqq.auto.engine.enter.pps.FlashShowShadowService");
            hashMap.put(BusinessKey.BUSINESS_ECOMMERCE, "com.tencent.biz.qcircleshadow.local.QCirclePluginShadowService");
        }

        public PPS() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class ShadowEngineKey {
        static IPatchRedirector $redirector_ = null;
        public static final String KEY_AS_ENTER_BEAN = "KEY_AS_ENTER_BEAN";
        public static final String KEY_EXTRAS = "KEY_EXTRAS";
        public static final String KEY_PLUGIN_EXTRAS_HASH_MAP = "KEY_EXTRA_HASH_MAP";
        public static final String KEY_PLUGIN_PART_KEY = "KEY_PLUGIN_PART_KEY";
        public static final String KEY_PLUGIN_ZIP_PATH = "pluginZipPath";

        public ShadowEngineKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class Splash {
        static IPatchRedirector $redirector_;
        public static final Map<String, String> sSplashActivity;
        public static final Map<String, String> sSplashService;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40480);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            HashMap hashMap = new HashMap();
            sSplashActivity = hashMap;
            HashMap hashMap2 = new HashMap();
            sSplashService = hashMap2;
            hashMap.put(BusinessKey.BUSINESS_FLASH_SHOW, "com.tencent.mobileqq.flashshow.activity.FSSplashActivity");
            hashMap2.put(BusinessKey.BUSINESS_FLASH_SHOW, "com.tencent.mobileqq.flashshow.activity.FSSplashService");
            hashMap.put(BusinessKey.BUSINESS_QCIRCLE, QCirclePluginConstant.Business.PLUGIN_SPLASH_NAME);
            hashMap2.put(BusinessKey.BUSINESS_QCIRCLE, QCirclePluginConstant.Business.PLUGIN_SERVICE_NAME);
            hashMap2.put(BusinessKey.BUSINESS_ECOMMERCE, "com.tencent.ecommerce.base.plugin.ECPluginService");
        }

        public Splash() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ASEngineConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
