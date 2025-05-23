package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes11.dex */
public class FunnyPicHelperConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String FUNNYPIC_BUSINESSFLAG = "";
    public static final String FUNNYPIC_COUNT_SP_KEY = "funnypic_count_sp_key";
    public static final int FUNNYPIC_GIF = 2;
    public static final int FUNNYPIC_LOOPCOUNT = 3;
    public static final String FUNNYPIC_NAME_SP_KEY = "funnypic_name_sp_key";
    public static final int FUNNYPIC_PNG = 1;
    public static final String FUNNYPIC_TYPE = "funnypic_type";
    public static final String FUNNYPIC_TYPE_SP_KEY = "funnypic_type_sp_key";
    public static final String FUNNY_URL_SUFFIX = "/client_100.png";
    public static final String FUNYPIC_PREFIX = "qto_";
    public static final String FUNYPIC_PREFIX_REPLACE = "qto@";
    public static final String PROTOCO_FUNNYPIC = "funny_pic";
    public static final String SP_FUNNY_PIC_INFO = "funny_pic_info";
    public static Set<String> sloadingFunnyPics;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39468);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sloadingFunnyPics = new HashSet();
        }
    }

    public FunnyPicHelperConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getFunnyPicName(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(FUNYPIC_PREFIX)) >= 0) {
            return str.substring(lastIndexOf, str.length());
        }
        return "";
    }
}
