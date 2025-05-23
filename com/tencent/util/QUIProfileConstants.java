package com.tencent.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes27.dex */
public class QUIProfileConstants {
    static IPatchRedirector $redirector_ = null;
    public static final ae0.a DEFAULT_COLOR_PALETTE;
    public static final ae0.a DEFAULT_NIGHT_COLOR_PALETTE;
    public static final String PROFILE_DEBUG = "debug";
    public static final String PROFILE_ID_AI_AVATAR_HOME = "ai_avatar_home";
    public static final String PROFILE_ID_GUILD = "guild";
    public static final String PROFILE_ID_LOGIN = "login";
    public static final String PROFILE_ID_QQSTRANGER = "qq_stranger";
    public static final String PROFILE_ID_QQ_GALLERY = "qq_gallery";
    public static final String PROFILE_ID_QZONE = "qzone";
    public static final String PROFILE_ID_ROBOT_AIO = "robot_aio";
    public static final String PROFILE_ID_ROBOT_PROFILE = "robot_profile";
    public static final String PROFILE_ID_WINK = "wink";
    public static final String PROFILE_ID_ZPLAN = "zplan";
    private static final String TAG = "QUIProfileConstants";

    /* loaded from: classes27.dex */
    class a implements ae0.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // ae0.a
        public int[] getColor(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return QUIProfileConstants.getDefaultColorsByToken(str, false);
            }
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    /* loaded from: classes27.dex */
    class b implements ae0.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // ae0.a
        public int[] getColor(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return QUIProfileConstants.getDefaultColorsByToken(str, true);
            }
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEFAULT_COLOR_PALETTE = new a();
            DEFAULT_NIGHT_COLOR_PALETTE = new b();
        }
    }

    public QUIProfileConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] getDefaultColorsByToken(String str, boolean z16) {
        String[] j3;
        if (str != null && (j3 = ie0.a.f().j(BaseApplication.getContext(), removeSuffix(str), z16)) != null && j3.length != 0) {
            try {
                int[] iArr = new int[j3.length];
                for (int i3 = 0; i3 < j3.length; i3++) {
                    iArr[i3] = Color.parseColor(j3[i3]);
                }
                return iArr;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getDefaultColorsByToken exception", e16);
            }
        }
        return null;
    }

    private static String removeSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0 && lastIndexOf < str.length()) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }
}
