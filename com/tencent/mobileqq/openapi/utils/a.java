package com.tencent.mobileqq.openapi.utils;

import com.tencent.mobileqq.activity.aio.item.n;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static final int a(int i3) {
        if (i3 != -2020) {
            if (i3 != -2007) {
                if (i3 != -2005) {
                    if (i3 != -2002) {
                        if (i3 != -2000) {
                            if (i3 != -1000) {
                                switch (i3) {
                                    case MessageRecord.MSG_TYPE_LONG_TEXT /* -1037 */:
                                        return 1;
                                    case MessageRecord.MSG_TYPE_LONG_MIX /* -1036 */:
                                    case MessageRecord.MSG_TYPE_MIX /* -1035 */:
                                        return 4;
                                    default:
                                        return 1073741824;
                                }
                            }
                            return 1;
                        }
                        return 8;
                    }
                    return 2;
                }
                return 64;
            }
            return 16;
        }
        return 32;
    }

    public static final int b(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                return 0;
            }
            return 2;
        }
        return 4;
    }

    public static final int c(int i3) {
        if (i3 != 2) {
            if (i3 != 4) {
                return 0;
            }
            return 1;
        }
        return 3000;
    }

    public static final int d(QQAppInterface qQAppInterface, int i3, boolean z16) {
        if (z16) {
            switch (i3) {
                case 1003:
                    return 1007;
                case 1004:
                case 1005:
                    return 1006;
                default:
                    return 1005;
            }
        }
        if (i3 != -1) {
            switch (i3) {
                case 2003:
                    return 1003;
                case 2004:
                case 2005:
                    return 1002;
                default:
                    return 1001;
            }
        }
        return 1000;
    }

    public static final int e(QQAppInterface qQAppInterface, MessageForPtt messageForPtt) {
        return d(qQAppInterface, n.f(qQAppInterface, messageForPtt), messageForPtt.isSendFromLocal());
    }
}
