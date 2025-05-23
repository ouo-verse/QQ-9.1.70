package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NetContants {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface SharePref {
        public static final String EXTRA_ENABLE_IPV6 = "sso_list_enable_ipv6";
        public static final String EXTRA_ENABLE_IPV6_APPID = "_sso_list_appid";
        public static final String EXTRA_ENABLE_IPV6_VERSION = "_sso_list_version";
        public static final String KEY_ENABLE_IPV6 = "sso_list";
        public static final String KEY_SET_TEST_ENV = "sso_set_test_env";
        public static final String SP_MSF_COMMON = "sp_msf_common";
    }

    public NetContants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
