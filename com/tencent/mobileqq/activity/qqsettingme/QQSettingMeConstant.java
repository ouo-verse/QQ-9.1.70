package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQSettingMeConstant {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f184664a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class OpenPageType {
        private static final /* synthetic */ OpenPageType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final OpenPageType H5_TYPE;
        public static final OpenPageType HIPPY_TYPE;
        public static final OpenPageType UNKNOWN_TYPE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35459);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            OpenPageType openPageType = new OpenPageType("UNKNOWN_TYPE", 0);
            UNKNOWN_TYPE = openPageType;
            OpenPageType openPageType2 = new OpenPageType("H5_TYPE", 1);
            H5_TYPE = openPageType2;
            OpenPageType openPageType3 = new OpenPageType("HIPPY_TYPE", 2);
            HIPPY_TYPE = openPageType3;
            $VALUES = new OpenPageType[]{openPageType, openPageType2, openPageType3};
        }

        OpenPageType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static OpenPageType valueOf(String str) {
            return (OpenPageType) Enum.valueOf(OpenPageType.class, str);
        }

        public static OpenPageType[] values() {
            return (OpenPageType[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35467);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f184664a = new HashMap<String, String>() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeConstant.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    } else {
                        put("d_vip_identity", HippyQQConstants.ModuleName.QQ_VIP);
                        put("d_decoration", HippyQQConstants.ModuleName.QQ_PERSONALITY);
                    }
                }
            };
        }
    }

    public static boolean a(String str) {
        if (!"d_smallworld".equals(str) && !"d_vip_identity".equals(str) && !"d_qqwallet".equals(str) && !"d_favorite".equals(str) && !"d_document".equals(str) && !"d_album".equals(str) && !"d_decoration".equals(str) && !"d_video".equals(str) && !"d_vip_card".equals(str) && !"d_zplan".equals(str) && !"d_intimate_space".equals(str) && !"d_financial".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        return "d_my_game".equals(str);
    }
}
