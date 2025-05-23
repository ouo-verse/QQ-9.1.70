package com.tencent.qqnt.emotion.constant;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static String a(Emoticon emoticon) {
        if (emoticon == null) {
            return null;
        }
        return emoticon.epId + "_" + emoticon.eId;
    }

    public static String b(String str, String str2) {
        return str + "_" + str2;
    }
}
