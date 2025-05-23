package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonReportUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_DISCUSSION = 2;
    public static final int TYPE_FRIEND = 0;
    public static final int TYPE_OTHER = 999;
    public static final int TYPE_PUBLIC = 4;
    public static final int TYPE_TEMP = 1;
    public static final int TYPE_TROOP = 3;

    public EmoticonReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getAioMoreFlag(int i3) {
        int i16;
        if (i3 != 0) {
            i16 = 1;
            if (i3 != 1) {
                if (i3 != 1000 && i3 != 1001) {
                    if (i3 != 1008) {
                        if (i3 != 1009 && i3 != 1020) {
                            if (i3 != 3000) {
                                if (i3 != 10002 && i3 != 10004 && i3 != 10008 && i3 != 10010) {
                                    switch (i3) {
                                        case 1003:
                                        case 1004:
                                        case 1005:
                                            break;
                                        default:
                                            switch (i3) {
                                                case 1023:
                                                case 1024:
                                                case 1025:
                                                    break;
                                                default:
                                                    i16 = 999;
                                                    break;
                                            }
                                    }
                                }
                            } else {
                                i16 = 2;
                            }
                        }
                    } else {
                        i16 = 4;
                    }
                }
            } else {
                i16 = 3;
            }
        } else {
            i16 = 0;
        }
        return String.valueOf(i16);
    }
}
